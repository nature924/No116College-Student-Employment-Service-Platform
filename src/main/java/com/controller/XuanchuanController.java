
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
 * 宣传
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuanchuan")
public class XuanchuanController {
    private static final Logger logger = LoggerFactory.getLogger(XuanchuanController.class);

    private static final String TABLE_NAME = "xuanchuan";

    @Autowired
    private XuanchuanService xuanchuanService;


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
    private XinxiService xinxiService;//学生信息
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
        params.put("xuanchuanDeleteStart",1);params.put("xuanchuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xuanchuanService.queryPage(params);

        //字典表数据转换
        List<XuanchuanView> list =(List<XuanchuanView>)page.getList();
        for(XuanchuanView c:list){
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
        XuanchuanEntity xuanchuan = xuanchuanService.selectById(id);
        if(xuanchuan !=null){
            //entity转view
            XuanchuanView view = new XuanchuanView();
            BeanUtils.copyProperties( xuanchuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody XuanchuanEntity xuanchuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanchuan:{}",this.getClass().getName(),xuanchuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XuanchuanEntity> queryWrapper = new EntityWrapper<XuanchuanEntity>()
            .eq("xuanchuan_name", xuanchuan.getXuanchuanName())
            .eq("xuanchuan_video", xuanchuan.getXuanchuanVideo())
            .eq("xuanchuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanchuanEntity xuanchuanEntity = xuanchuanService.selectOne(queryWrapper);
        if(xuanchuanEntity==null){
            xuanchuan.setXuanchuanDelete(1);
            xuanchuan.setInsertTime(new Date());
            xuanchuan.setCreateTime(new Date());
            xuanchuanService.insert(xuanchuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuanchuanEntity xuanchuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuanchuan:{}",this.getClass().getName(),xuanchuan.toString());
        XuanchuanEntity oldXuanchuanEntity = xuanchuanService.selectById(xuanchuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xuanchuan.getXuanchuanPhoto()) || "null".equals(xuanchuan.getXuanchuanPhoto())){
                xuanchuan.setXuanchuanPhoto(null);
        }
        if("".equals(xuanchuan.getXuanchuanVideo()) || "null".equals(xuanchuan.getXuanchuanVideo())){
                xuanchuan.setXuanchuanVideo(null);
        }

            xuanchuanService.updateById(xuanchuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuanchuanEntity> oldXuanchuanList =xuanchuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XuanchuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XuanchuanEntity xuanchuanEntity = new XuanchuanEntity();
            xuanchuanEntity.setId(id);
            xuanchuanEntity.setXuanchuanDelete(2);
            list.add(xuanchuanEntity);
        }
        if(list != null && list.size() >0){
            xuanchuanService.updateBatchById(list);
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
            List<XuanchuanEntity> xuanchuanList = new ArrayList<>();//上传的东西
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
                            XuanchuanEntity xuanchuanEntity = new XuanchuanEntity();
//                            xuanchuanEntity.setXuanchuanName(data.get(0));                    //宣传名称 要改的
//                            xuanchuanEntity.setXuanchuanUuidNumber(data.get(0));                    //宣传编号 要改的
//                            xuanchuanEntity.setXuanchuanPhoto("");//详情和图片
//                            xuanchuanEntity.setXuanchuanVideo(data.get(0));                    //宣传视频 要改的
//                            xuanchuanEntity.setXuanchuanContent("");//详情和图片
//                            xuanchuanEntity.setXuanchuanDelete(1);//逻辑删除字段
//                            xuanchuanEntity.setInsertTime(date);//时间
//                            xuanchuanEntity.setCreateTime(date);//时间
                            xuanchuanList.add(xuanchuanEntity);


                            //把要查询是否重复的字段放入map中
                                //宣传编号
                                if(seachFields.containsKey("xuanchuanUuidNumber")){
                                    List<String> xuanchuanUuidNumber = seachFields.get("xuanchuanUuidNumber");
                                    xuanchuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuanchuanUuidNumber = new ArrayList<>();
                                    xuanchuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xuanchuanUuidNumber",xuanchuanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //宣传编号
                        List<XuanchuanEntity> xuanchuanEntities_xuanchuanUuidNumber = xuanchuanService.selectList(new EntityWrapper<XuanchuanEntity>().in("xuanchuan_uuid_number", seachFields.get("xuanchuanUuidNumber")).eq("xuanchuan_delete", 1));
                        if(xuanchuanEntities_xuanchuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuanchuanEntity s:xuanchuanEntities_xuanchuanUuidNumber){
                                repeatFields.add(s.getXuanchuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [宣传编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuanchuanService.insertBatch(xuanchuanList);
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
        PageUtils page = xuanchuanService.queryPage(params);

        //字典表数据转换
        List<XuanchuanView> list =(List<XuanchuanView>)page.getList();
        for(XuanchuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuanchuanEntity xuanchuan = xuanchuanService.selectById(id);
            if(xuanchuan !=null){


                //entity转view
                XuanchuanView view = new XuanchuanView();
                BeanUtils.copyProperties( xuanchuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody XuanchuanEntity xuanchuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuanchuan:{}",this.getClass().getName(),xuanchuan.toString());
        Wrapper<XuanchuanEntity> queryWrapper = new EntityWrapper<XuanchuanEntity>()
            .eq("xuanchuan_name", xuanchuan.getXuanchuanName())
            .eq("xuanchuan_uuid_number", xuanchuan.getXuanchuanUuidNumber())
            .eq("xuanchuan_video", xuanchuan.getXuanchuanVideo())
            .eq("xuanchuan_delete", xuanchuan.getXuanchuanDelete())
//            .notIn("xuanchuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanchuanEntity xuanchuanEntity = xuanchuanService.selectOne(queryWrapper);
        if(xuanchuanEntity==null){
            xuanchuan.setXuanchuanDelete(1);
            xuanchuan.setInsertTime(new Date());
            xuanchuan.setCreateTime(new Date());
        xuanchuanService.insert(xuanchuan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

