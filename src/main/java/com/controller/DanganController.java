
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
 * 学生档案
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dangan")
public class DanganController {
    private static final Logger logger = LoggerFactory.getLogger(DanganController.class);

    private static final String TABLE_NAME = "dangan";

    @Autowired
    private DanganService danganService;


    @Autowired
    private TokenService tokenService;

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
        params.put("danganDeleteStart",1);params.put("danganDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = danganService.queryPage(params);

        //字典表数据转换
        List<DanganView> list =(List<DanganView>)page.getList();
        for(DanganView c:list){
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
        DanganEntity dangan = danganService.selectById(id);
        if(dangan !=null){
            //entity转view
            DanganView view = new DanganView();
            BeanUtils.copyProperties( dangan , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(dangan.getYonghuId());
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
    public R save(@RequestBody DanganEntity dangan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dangan:{}",this.getClass().getName(),dangan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            dangan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DanganEntity> queryWrapper = new EntityWrapper<DanganEntity>()
            .eq("yonghu_id", dangan.getYonghuId())
            .eq("dangan_name", dangan.getDanganName())
            .eq("dangan_types", dangan.getDanganTypes())
            .eq("dangan_quxiang", dangan.getDanganQuxiang())
            .eq("dangan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanganEntity danganEntity = danganService.selectOne(queryWrapper);
        if(danganEntity==null){
            dangan.setDanganDelete(1);
            dangan.setInsertTime(new Date());
            dangan.setCreateTime(new Date());
            danganService.insert(dangan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DanganEntity dangan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dangan:{}",this.getClass().getName(),dangan.toString());
        DanganEntity oldDanganEntity = danganService.selectById(dangan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            dangan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(dangan.getDanganPhoto()) || "null".equals(dangan.getDanganPhoto())){
                dangan.setDanganPhoto(null);
        }

            danganService.updateById(dangan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DanganEntity> oldDanganList =danganService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DanganEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DanganEntity danganEntity = new DanganEntity();
            danganEntity.setId(id);
            danganEntity.setDanganDelete(2);
            list.add(danganEntity);
        }
        if(list != null && list.size() >0){
            danganService.updateBatchById(list);
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
            List<DanganEntity> danganList = new ArrayList<>();//上传的东西
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
                            DanganEntity danganEntity = new DanganEntity();
//                            danganEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            danganEntity.setDanganName(data.get(0));                    //学生档案名称 要改的
//                            danganEntity.setDanganUuidNumber(data.get(0));                    //学生档案编号 要改的
//                            danganEntity.setDanganPhoto("");//详情和图片
//                            danganEntity.setDanganTypes(Integer.valueOf(data.get(0)));   //学生档案类型 要改的
//                            danganEntity.setDanganQuxiang(data.get(0));                    //就业去向 要改的
//                            danganEntity.setDanganContent("");//详情和图片
//                            danganEntity.setDanganDelete(1);//逻辑删除字段
//                            danganEntity.setInsertTime(date);//时间
//                            danganEntity.setCreateTime(date);//时间
                            danganList.add(danganEntity);


                            //把要查询是否重复的字段放入map中
                                //学生档案编号
                                if(seachFields.containsKey("danganUuidNumber")){
                                    List<String> danganUuidNumber = seachFields.get("danganUuidNumber");
                                    danganUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> danganUuidNumber = new ArrayList<>();
                                    danganUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("danganUuidNumber",danganUuidNumber);
                                }
                        }

                        //查询是否重复
                         //学生档案编号
                        List<DanganEntity> danganEntities_danganUuidNumber = danganService.selectList(new EntityWrapper<DanganEntity>().in("dangan_uuid_number", seachFields.get("danganUuidNumber")).eq("dangan_delete", 1));
                        if(danganEntities_danganUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DanganEntity s:danganEntities_danganUuidNumber){
                                repeatFields.add(s.getDanganUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学生档案编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        danganService.insertBatch(danganList);
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
        PageUtils page = danganService.queryPage(params);

        //字典表数据转换
        List<DanganView> list =(List<DanganView>)page.getList();
        for(DanganView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DanganEntity dangan = danganService.selectById(id);
            if(dangan !=null){


                //entity转view
                DanganView view = new DanganView();
                BeanUtils.copyProperties( dangan , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(dangan.getYonghuId());
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
    public R add(@RequestBody DanganEntity dangan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dangan:{}",this.getClass().getName(),dangan.toString());
        Wrapper<DanganEntity> queryWrapper = new EntityWrapper<DanganEntity>()
            .eq("yonghu_id", dangan.getYonghuId())
            .eq("dangan_name", dangan.getDanganName())
            .eq("dangan_uuid_number", dangan.getDanganUuidNumber())
            .eq("dangan_types", dangan.getDanganTypes())
            .eq("dangan_quxiang", dangan.getDanganQuxiang())
            .eq("dangan_delete", dangan.getDanganDelete())
//            .notIn("dangan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanganEntity danganEntity = danganService.selectOne(queryWrapper);
        if(danganEntity==null){
            dangan.setDanganDelete(1);
            dangan.setInsertTime(new Date());
            dangan.setCreateTime(new Date());
        danganService.insert(dangan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

