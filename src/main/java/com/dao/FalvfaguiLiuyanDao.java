package com.dao;

import com.entity.FalvfaguiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FalvfaguiLiuyanView;

/**
 * 法律法规留言 Dao 接口
 *
 * @author 
 */
public interface FalvfaguiLiuyanDao extends BaseMapper<FalvfaguiLiuyanEntity> {

   List<FalvfaguiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
