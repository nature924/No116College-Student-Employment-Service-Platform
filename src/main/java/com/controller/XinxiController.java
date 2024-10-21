
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 学生信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinxi")
public class XinxiController {
    private static final Logger logger = LoggerFactory.getLogger(XinxiController.class);

    private static final String TABLE_NAME = "xinxi";

    @Autowired
    private XinxiService xinxiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DanganService danganService;//学生档案
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ExampaperService exampaperService;//试卷
    @Autowired
    private ExampapertopicService exampapertopicService;//试卷选题
    @Autowired
    private ExamquestionService examquestionService;//试题表
    @Autowired
    private ExamrecordService examrecordService;//考试记录表
    @Autowired
    private ExamredetailsService examredetailsService;//答题详情表
    @Autowired
    private ExamrewrongquestionService examrewrongquestionService;//错题表
    @Autowired
    private FalvfaguiService falvfaguiService;//法律法规
    @Autowired
    private FalvfaguiCollectionService falvfaguiCollectionService;//法律法规收藏
    @Autowired
    private FalvfaguiLiuyanService falvfaguiLiuyanService;//法律法规留言
    @Autowired
    private FenxiService fenxiService;//就业分析
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GongsiService gongsiService;//企业
    @Autowired
    private JianliService jianliService;//简历
    @Autowired
    private LaoshiService laoshiService;//老师
    @Autowired
    private ToudiService toudiService;//简历投递
    @Autowired
    private XinwenService xinwenService;//新闻资讯
    @Autowired
    private XinwenCollectionService xinwenCollectionService;//新闻资讯收藏
    @Autowired
    private XinwenLiuyanService xinwenLiuyanService;//新闻资讯留言
    @Autowired
    private XuanchuanService xuanchuanService;//宣传
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private ZhaopinService zhaopinService;//职位招聘
    @Autowired
    private ZhaopinCollectionService zhaopinCollectionService;//职位收藏
    @Autowired
    private ZhaopinLiuyanService zhaopinLiuyanService;//招聘咨询
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("企业".equals(role))
            params.put("gongsiId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        params.put("xinxiDeleteStart",1);params.put("xinxiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xinxiService.queryPage(params);

        //字典表数据转换
        List<XinxiView> list =(List<XinxiView>)page.getList();
        for(XinxiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinxiEntity xinxi = xinxiService.selectById(id);
        if(xinxi !=null){
            //entity转view
            XinxiView view = new XinxiView();
            BeanUtils.copyProperties( xinxi , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xinxi.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XinxiEntity xinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinxi:{}",this.getClass().getName(),xinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xinxi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XinxiEntity> queryWrapper = new EntityWrapper<XinxiEntity>()
            .eq("yonghu_id", xinxi.getYonghuId())
            .eq("xinxi_types", xinxi.getXinxiTypes())
            .eq("xinxi_banji_types", xinxi.getXinxiBanjiTypes())
            .eq("xinxi_xueyuan", xinxi.getXinxiXueyuan())
            .eq("xinxi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinxiEntity xinxiEntity = xinxiService.selectOne(queryWrapper);
        if(xinxiEntity==null){
            xinxi.setXinxiDelete(1);
            xinxi.setInsertTime(new Date());
            xinxi.setCreateTime(new Date());
            xinxiService.insert(xinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinxiEntity xinxi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinxi:{}",this.getClass().getName(),xinxi.toString());
        XinxiEntity oldXinxiEntity = xinxiService.selectById(xinxi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xinxi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            xinxiService.updateById(xinxi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinxiEntity> oldXinxiList =xinxiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XinxiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XinxiEntity xinxiEntity = new XinxiEntity();
            xinxiEntity.setId(id);
            xinxiEntity.setXinxiDelete(2);
            list.add(xinxiEntity);
        }
        if(list != null && list.size() >0){
            xinxiService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<XinxiEntity> xinxiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XinxiEntity xinxiEntity = new XinxiEntity();
//                            xinxiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xinxiEntity.setXinxiTypes(Integer.valueOf(data.get(0)));   //学生专业 要改的
//                            xinxiEntity.setXinxiBanjiTypes(Integer.valueOf(data.get(0)));   //学生班级 要改的
//                            xinxiEntity.setXinxiXueyuan(data.get(0));                    //学院 要改的
//                            xinxiEntity.setXinxiContent("");//详情和图片
//                            xinxiEntity.setXinxiDelete(1);//逻辑删除字段
//                            xinxiEntity.setInsertTime(date);//时间
//                            xinxiEntity.setCreateTime(date);//时间
                            xinxiList.add(xinxiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xinxiService.insertBatch(xinxiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinxiService.queryPage(params);

        //字典表数据转换
        List<XinxiView> list =(List<XinxiView>)page.getList();
        for(XinxiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinxiEntity xinxi = xinxiService.selectById(id);
            if(xinxi !=null){


                //entity转view
                XinxiView view = new XinxiView();
                BeanUtils.copyProperties( xinxi , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xinxi.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XinxiEntity xinxi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinxi:{}",this.getClass().getName(),xinxi.toString());
        Wrapper<XinxiEntity> queryWrapper = new EntityWrapper<XinxiEntity>()
            .eq("yonghu_id", xinxi.getYonghuId())
            .eq("xinxi_types", xinxi.getXinxiTypes())
            .eq("xinxi_banji_types", xinxi.getXinxiBanjiTypes())
            .eq("xinxi_xueyuan", xinxi.getXinxiXueyuan())
            .eq("xinxi_delete", xinxi.getXinxiDelete())
//            .notIn("xinxi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinxiEntity xinxiEntity = xinxiService.selectOne(queryWrapper);
        if(xinxiEntity==null){
            xinxi.setXinxiDelete(1);
            xinxi.setInsertTime(new Date());
            xinxi.setCreateTime(new Date());
        xinxiService.insert(xinxi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

