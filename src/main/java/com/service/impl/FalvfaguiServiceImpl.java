package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.FalvfaguiDao;
import com.entity.FalvfaguiEntity;
import com.service.FalvfaguiService;
import com.entity.view.FalvfaguiView;

/**
 * 法律法规 服务实现类
 */
@Service("falvfaguiService")
@Transactional
public class FalvfaguiServiceImpl extends ServiceImpl<FalvfaguiDao, FalvfaguiEntity> implements FalvfaguiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<FalvfaguiView> page =new Query<FalvfaguiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
