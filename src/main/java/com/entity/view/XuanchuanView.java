package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XuanchuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 宣传
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuanchuan")
public class XuanchuanView extends XuanchuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表




	public XuanchuanView() {

	}

	public XuanchuanView(XuanchuanEntity xuanchuanEntity) {
		try {
			BeanUtils.copyProperties(this, xuanchuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







	@Override
	public String toString() {
		return "XuanchuanView{" +
			"} " + super.toString();
	}
}
