package com.dao;

import com.entity.FenxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FenxiView;

/**
 * 就业分析 Dao 接口
 *
 * @author 
 */
public interface FenxiDao extends BaseMapper<FenxiEntity> {

   List<FenxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
