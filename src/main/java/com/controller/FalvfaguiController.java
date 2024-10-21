
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
 * 法律法规
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/falvfagui")
public class FalvfaguiController {
    private static final Logger logger = LoggerFactory.getLogger(FalvfaguiController.class);

    private static final String TABLE_NAME = "falvfagui";

    @Autowired
    private FalvfaguiService falvfaguiService;


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
        params.put("falvfaguiDeleteStart",1);params.put("falvfaguiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = falvfaguiService.queryPage(params);

        //字典表数据转换
        List<FalvfaguiView> list =(List<FalvfaguiView>)page.getList();
        for(FalvfaguiView c:list){
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
        FalvfaguiEntity falvfagui = falvfaguiService.selectById(id);
        if(falvfagui !=null){
            //entity转view
            FalvfaguiView view = new FalvfaguiView();
            BeanUtils.copyProperties( falvfagui , view );//把实体数据重构到view中
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
    public R save(@RequestBody FalvfaguiEntity falvfagui, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,falvfagui:{}",this.getClass().getName(),falvfagui.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FalvfaguiEntity> queryWrapper = new EntityWrapper<FalvfaguiEntity>()
            .eq("falvfagui_name", falvfagui.getFalvfaguiName())
            .eq("falvfagui_video", falvfagui.getFalvfaguiVideo())
            .eq("falvfagui_types", falvfagui.getFalvfaguiTypes())
            .eq("falvfagui_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FalvfaguiEntity falvfaguiEntity = falvfaguiService.selectOne(queryWrapper);
        if(falvfaguiEntity==null){
            falvfagui.setFalvfaguiDelete(1);
            falvfagui.setInsertTime(new Date());
            falvfagui.setCreateTime(new Date());
            falvfaguiService.insert(falvfagui);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FalvfaguiEntity falvfagui, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,falvfagui:{}",this.getClass().getName(),falvfagui.toString());
        FalvfaguiEntity oldFalvfaguiEntity = falvfaguiService.selectById(falvfagui.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(falvfagui.getFalvfaguiPhoto()) || "null".equals(falvfagui.getFalvfaguiPhoto())){
                falvfagui.setFalvfaguiPhoto(null);
        }
        if("".equals(falvfagui.getFalvfaguiVideo()) || "null".equals(falvfagui.getFalvfaguiVideo())){
                falvfagui.setFalvfaguiVideo(null);
        }

            falvfaguiService.updateById(falvfagui);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FalvfaguiEntity> oldFalvfaguiList =falvfaguiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<FalvfaguiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FalvfaguiEntity falvfaguiEntity = new FalvfaguiEntity();
            falvfaguiEntity.setId(id);
            falvfaguiEntity.setFalvfaguiDelete(2);
            list.add(falvfaguiEntity);
        }
        if(list != null && list.size() >0){
            falvfaguiService.updateBatchById(list);
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
            List<FalvfaguiEntity> falvfaguiList = new ArrayList<>();//上传的东西
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
                            FalvfaguiEntity falvfaguiEntity = new FalvfaguiEntity();
//                            falvfaguiEntity.setFalvfaguiName(data.get(0));                    //法律法规名称 要改的
//                            falvfaguiEntity.setFalvfaguiUuidNumber(data.get(0));                    //法律法规编号 要改的
//                            falvfaguiEntity.setFalvfaguiPhoto("");//详情和图片
//                            falvfaguiEntity.setFalvfaguiVideo(data.get(0));                    //新闻视频 要改的
//                            falvfaguiEntity.setFalvfaguiTypes(Integer.valueOf(data.get(0)));   //法律法规类型 要改的
//                            falvfaguiEntity.setFalvfaguiContent("");//详情和图片
//                            falvfaguiEntity.setFalvfaguiDelete(1);//逻辑删除字段
//                            falvfaguiEntity.setInsertTime(date);//时间
//                            falvfaguiEntity.setCreateTime(date);//时间
                            falvfaguiList.add(falvfaguiEntity);


                            //把要查询是否重复的字段放入map中
                                //法律法规编号
                                if(seachFields.containsKey("falvfaguiUuidNumber")){
                                    List<String> falvfaguiUuidNumber = seachFields.get("falvfaguiUuidNumber");
                                    falvfaguiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> falvfaguiUuidNumber = new ArrayList<>();
                                    falvfaguiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("falvfaguiUuidNumber",falvfaguiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //法律法规编号
                        List<FalvfaguiEntity> falvfaguiEntities_falvfaguiUuidNumber = falvfaguiService.selectList(new EntityWrapper<FalvfaguiEntity>().in("falvfagui_uuid_number", seachFields.get("falvfaguiUuidNumber")).eq("falvfagui_delete", 1));
                        if(falvfaguiEntities_falvfaguiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FalvfaguiEntity s:falvfaguiEntities_falvfaguiUuidNumber){
                                repeatFields.add(s.getFalvfaguiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [法律法规编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        falvfaguiService.insertBatch(falvfaguiList);
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
        List<FalvfaguiView> returnFalvfaguiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = falvfaguiCollectionService.queryPage(params1);
        List<FalvfaguiCollectionView> collectionViewsList =(List<FalvfaguiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(FalvfaguiCollectionView collectionView:collectionViewsList){
            Integer falvfaguiTypes = collectionView.getFalvfaguiTypes();
            if(typeMap.containsKey(falvfaguiTypes)){
                typeMap.put(falvfaguiTypes,typeMap.get(falvfaguiTypes)+1);
            }else{
                typeMap.put(falvfaguiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("falvfaguiTypes",type);
            PageUtils pageUtils1 = falvfaguiService.queryPage(params2);
            List<FalvfaguiView> falvfaguiViewList =(List<FalvfaguiView>)pageUtils1.getList();
            returnFalvfaguiViewList.addAll(falvfaguiViewList);
            if(returnFalvfaguiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = falvfaguiService.queryPage(params);
        if(returnFalvfaguiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnFalvfaguiViewList.size();//要添加的数量
            List<FalvfaguiView> falvfaguiViewList =(List<FalvfaguiView>)page.getList();
            for(FalvfaguiView falvfaguiView:falvfaguiViewList){
                Boolean addFlag = true;
                for(FalvfaguiView returnFalvfaguiView:returnFalvfaguiViewList){
                    if(returnFalvfaguiView.getId().intValue() ==falvfaguiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnFalvfaguiViewList.add(falvfaguiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnFalvfaguiViewList = returnFalvfaguiViewList.subList(0, limit);
        }

        for(FalvfaguiView c:returnFalvfaguiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnFalvfaguiViewList);
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
        PageUtils page = falvfaguiService.queryPage(params);

        //字典表数据转换
        List<FalvfaguiView> list =(List<FalvfaguiView>)page.getList();
        for(FalvfaguiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FalvfaguiEntity falvfagui = falvfaguiService.selectById(id);
            if(falvfagui !=null){


                //entity转view
                FalvfaguiView view = new FalvfaguiView();
                BeanUtils.copyProperties( falvfagui , view );//把实体数据重构到view中

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
    public R add(@RequestBody FalvfaguiEntity falvfagui, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,falvfagui:{}",this.getClass().getName(),falvfagui.toString());
        Wrapper<FalvfaguiEntity> queryWrapper = new EntityWrapper<FalvfaguiEntity>()
            .eq("falvfagui_name", falvfagui.getFalvfaguiName())
            .eq("falvfagui_uuid_number", falvfagui.getFalvfaguiUuidNumber())
            .eq("falvfagui_video", falvfagui.getFalvfaguiVideo())
            .eq("falvfagui_types", falvfagui.getFalvfaguiTypes())
            .eq("falvfagui_delete", falvfagui.getFalvfaguiDelete())
//            .notIn("falvfagui_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FalvfaguiEntity falvfaguiEntity = falvfaguiService.selectOne(queryWrapper);
        if(falvfaguiEntity==null){
            falvfagui.setFalvfaguiDelete(1);
            falvfagui.setInsertTime(new Date());
            falvfagui.setCreateTime(new Date());
        falvfaguiService.insert(falvfagui);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

