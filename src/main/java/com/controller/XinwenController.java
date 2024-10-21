
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
 * 新闻资讯
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinwen")
public class XinwenController {
    private static final Logger logger = LoggerFactory.getLogger(XinwenController.class);

    private static final String TABLE_NAME = "xinwen";

    @Autowired
    private XinwenService xinwenService;


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
        params.put("xinwenDeleteStart",1);params.put("xinwenDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xinwenService.queryPage(params);

        //字典表数据转换
        List<XinwenView> list =(List<XinwenView>)page.getList();
        for(XinwenView c:list){
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
        XinwenEntity xinwen = xinwenService.selectById(id);
        if(xinwen !=null){
            //entity转view
            XinwenView view = new XinwenView();
            BeanUtils.copyProperties( xinwen , view );//把实体数据重构到view中
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
    public R save(@RequestBody XinwenEntity xinwen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinwen:{}",this.getClass().getName(),xinwen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XinwenEntity> queryWrapper = new EntityWrapper<XinwenEntity>()
            .eq("xinwen_name", xinwen.getXinwenName())
            .eq("xinwen_video", xinwen.getXinwenVideo())
            .eq("xinwen_types", xinwen.getXinwenTypes())
            .eq("xinwen_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinwenEntity xinwenEntity = xinwenService.selectOne(queryWrapper);
        if(xinwenEntity==null){
            xinwen.setXinwenDelete(1);
            xinwen.setInsertTime(new Date());
            xinwen.setCreateTime(new Date());
            xinwenService.insert(xinwen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinwenEntity xinwen, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinwen:{}",this.getClass().getName(),xinwen.toString());
        XinwenEntity oldXinwenEntity = xinwenService.selectById(xinwen.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xinwen.getXinwenPhoto()) || "null".equals(xinwen.getXinwenPhoto())){
                xinwen.setXinwenPhoto(null);
        }
        if("".equals(xinwen.getXinwenVideo()) || "null".equals(xinwen.getXinwenVideo())){
                xinwen.setXinwenVideo(null);
        }

            xinwenService.updateById(xinwen);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinwenEntity> oldXinwenList =xinwenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XinwenEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XinwenEntity xinwenEntity = new XinwenEntity();
            xinwenEntity.setId(id);
            xinwenEntity.setXinwenDelete(2);
            list.add(xinwenEntity);
        }
        if(list != null && list.size() >0){
            xinwenService.updateBatchById(list);
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
            List<XinwenEntity> xinwenList = new ArrayList<>();//上传的东西
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
                            XinwenEntity xinwenEntity = new XinwenEntity();
//                            xinwenEntity.setXinwenName(data.get(0));                    //新闻资讯名称 要改的
//                            xinwenEntity.setXinwenUuidNumber(data.get(0));                    //新闻资讯编号 要改的
//                            xinwenEntity.setXinwenPhoto("");//详情和图片
//                            xinwenEntity.setXinwenVideo(data.get(0));                    //新闻视频 要改的
//                            xinwenEntity.setXinwenTypes(Integer.valueOf(data.get(0)));   //新闻资讯类型 要改的
//                            xinwenEntity.setXinwenContent("");//详情和图片
//                            xinwenEntity.setXinwenDelete(1);//逻辑删除字段
//                            xinwenEntity.setInsertTime(date);//时间
//                            xinwenEntity.setCreateTime(date);//时间
                            xinwenList.add(xinwenEntity);


                            //把要查询是否重复的字段放入map中
                                //新闻资讯编号
                                if(seachFields.containsKey("xinwenUuidNumber")){
                                    List<String> xinwenUuidNumber = seachFields.get("xinwenUuidNumber");
                                    xinwenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xinwenUuidNumber = new ArrayList<>();
                                    xinwenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xinwenUuidNumber",xinwenUuidNumber);
                                }
                        }

                        //查询是否重复
                         //新闻资讯编号
                        List<XinwenEntity> xinwenEntities_xinwenUuidNumber = xinwenService.selectList(new EntityWrapper<XinwenEntity>().in("xinwen_uuid_number", seachFields.get("xinwenUuidNumber")).eq("xinwen_delete", 1));
                        if(xinwenEntities_xinwenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinwenEntity s:xinwenEntities_xinwenUuidNumber){
                                repeatFields.add(s.getXinwenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [新闻资讯编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xinwenService.insertBatch(xinwenList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<XinwenView> returnXinwenViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = xinwenCollectionService.queryPage(params1);
        List<XinwenCollectionView> collectionViewsList =(List<XinwenCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(XinwenCollectionView collectionView:collectionViewsList){
            Integer xinwenTypes = collectionView.getXinwenTypes();
            if(typeMap.containsKey(xinwenTypes)){
                typeMap.put(xinwenTypes,typeMap.get(xinwenTypes)+1);
            }else{
                typeMap.put(xinwenTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("xinwenTypes",type);
            PageUtils pageUtils1 = xinwenService.queryPage(params2);
            List<XinwenView> xinwenViewList =(List<XinwenView>)pageUtils1.getList();
            returnXinwenViewList.addAll(xinwenViewList);
            if(returnXinwenViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = xinwenService.queryPage(params);
        if(returnXinwenViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnXinwenViewList.size();//要添加的数量
            List<XinwenView> xinwenViewList =(List<XinwenView>)page.getList();
            for(XinwenView xinwenView:xinwenViewList){
                Boolean addFlag = true;
                for(XinwenView returnXinwenView:returnXinwenViewList){
                    if(returnXinwenView.getId().intValue() ==xinwenView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnXinwenViewList.add(xinwenView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnXinwenViewList = returnXinwenViewList.subList(0, limit);
        }

        for(XinwenView c:returnXinwenViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnXinwenViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinwenService.queryPage(params);

        //字典表数据转换
        List<XinwenView> list =(List<XinwenView>)page.getList();
        for(XinwenView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinwenEntity xinwen = xinwenService.selectById(id);
            if(xinwen !=null){


                //entity转view
                XinwenView view = new XinwenView();
                BeanUtils.copyProperties( xinwen , view );//把实体数据重构到view中

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
    public R add(@RequestBody XinwenEntity xinwen, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinwen:{}",this.getClass().getName(),xinwen.toString());
        Wrapper<XinwenEntity> queryWrapper = new EntityWrapper<XinwenEntity>()
            .eq("xinwen_name", xinwen.getXinwenName())
            .eq("xinwen_uuid_number", xinwen.getXinwenUuidNumber())
            .eq("xinwen_video", xinwen.getXinwenVideo())
            .eq("xinwen_types", xinwen.getXinwenTypes())
            .eq("xinwen_delete", xinwen.getXinwenDelete())
//            .notIn("xinwen_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinwenEntity xinwenEntity = xinwenService.selectOne(queryWrapper);
        if(xinwenEntity==null){
            xinwen.setXinwenDelete(1);
            xinwen.setInsertTime(new Date());
            xinwen.setCreateTime(new Date());
        xinwenService.insert(xinwen);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

