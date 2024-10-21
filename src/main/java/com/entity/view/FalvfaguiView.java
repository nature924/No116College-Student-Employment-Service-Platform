package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FalvfaguiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 法律法规
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("falvfagui")
public class FalvfaguiView extends FalvfaguiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 法律法规类型的值
	*/
	@ColumnInfo(comment="法律法规类型的字典表值",type="varchar(200)")
	private String falvfaguiValue;




	public FalvfaguiView() {

	}

	public FalvfaguiView(FalvfaguiEntity falvfaguiEntity) {
		try {
			BeanUtils.copyProperties(this, falvfaguiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 法律法规类型的值
	*/
	public String getFalvfaguiValue() {
		return falvfaguiValue;
	}
	/**
	* 设置： 法律法规类型的值
	*/
	public void setFalvfaguiValue(String falvfaguiValue) {
		this.falvfaguiValue = falvfaguiValue;
	}




	@Override
	public String toString() {
		return "FalvfaguiView{" +
			", falvfaguiValue=" + falvfaguiValue +
			"} " + super.toString();
	}
}
