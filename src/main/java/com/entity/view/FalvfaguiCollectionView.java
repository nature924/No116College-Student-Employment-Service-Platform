package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FalvfaguiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 法律法规收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("falvfagui_collection")
public class FalvfaguiCollectionView extends FalvfaguiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String falvfaguiCollectionValue;

	//级联表 法律法规
		/**
		* 法律法规名称
		*/

		@ColumnInfo(comment="法律法规名称",type="varchar(200)")
		private String falvfaguiName;
		/**
		* 法律法规编号
		*/

		@ColumnInfo(comment="法律法规编号",type="varchar(200)")
		private String falvfaguiUuidNumber;
		/**
		* 法律法规照片
		*/

		@ColumnInfo(comment="法律法规照片",type="varchar(200)")
		private String falvfaguiPhoto;
		/**
		* 新闻视频
		*/

		@ColumnInfo(comment="新闻视频",type="varchar(200)")
		private String falvfaguiVideo;
		/**
		* 法律法规类型
		*/
		@ColumnInfo(comment="法律法规类型",type="int(11)")
		private Integer falvfaguiTypes;
			/**
			* 法律法规类型的值
			*/
			@ColumnInfo(comment="法律法规类型的字典表值",type="varchar(200)")
			private String falvfaguiValue;
		/**
		* 法律法规介绍
		*/

		@ColumnInfo(comment="法律法规介绍",type="longtext")
		private String falvfaguiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer falvfaguiDelete;
	//级联表 学生
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 学生邮箱
		*/

		@ColumnInfo(comment="学生邮箱",type="varchar(200)")
		private String yonghuEmail;



	public FalvfaguiCollectionView() {

	}

	public FalvfaguiCollectionView(FalvfaguiCollectionEntity falvfaguiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, falvfaguiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getFalvfaguiCollectionValue() {
		return falvfaguiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setFalvfaguiCollectionValue(String falvfaguiCollectionValue) {
		this.falvfaguiCollectionValue = falvfaguiCollectionValue;
	}


	//级联表的get和set 法律法规

		/**
		* 获取： 法律法规名称
		*/
		public String getFalvfaguiName() {
			return falvfaguiName;
		}
		/**
		* 设置： 法律法规名称
		*/
		public void setFalvfaguiName(String falvfaguiName) {
			this.falvfaguiName = falvfaguiName;
		}

		/**
		* 获取： 法律法规编号
		*/
		public String getFalvfaguiUuidNumber() {
			return falvfaguiUuidNumber;
		}
		/**
		* 设置： 法律法规编号
		*/
		public void setFalvfaguiUuidNumber(String falvfaguiUuidNumber) {
			this.falvfaguiUuidNumber = falvfaguiUuidNumber;
		}

		/**
		* 获取： 法律法规照片
		*/
		public String getFalvfaguiPhoto() {
			return falvfaguiPhoto;
		}
		/**
		* 设置： 法律法规照片
		*/
		public void setFalvfaguiPhoto(String falvfaguiPhoto) {
			this.falvfaguiPhoto = falvfaguiPhoto;
		}

		/**
		* 获取： 新闻视频
		*/
		public String getFalvfaguiVideo() {
			return falvfaguiVideo;
		}
		/**
		* 设置： 新闻视频
		*/
		public void setFalvfaguiVideo(String falvfaguiVideo) {
			this.falvfaguiVideo = falvfaguiVideo;
		}
		/**
		* 获取： 法律法规类型
		*/
		public Integer getFalvfaguiTypes() {
			return falvfaguiTypes;
		}
		/**
		* 设置： 法律法规类型
		*/
		public void setFalvfaguiTypes(Integer falvfaguiTypes) {
			this.falvfaguiTypes = falvfaguiTypes;
		}


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

		/**
		* 获取： 法律法规介绍
		*/
		public String getFalvfaguiContent() {
			return falvfaguiContent;
		}
		/**
		* 设置： 法律法规介绍
		*/
		public void setFalvfaguiContent(String falvfaguiContent) {
			this.falvfaguiContent = falvfaguiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFalvfaguiDelete() {
			return falvfaguiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFalvfaguiDelete(Integer falvfaguiDelete) {
			this.falvfaguiDelete = falvfaguiDelete;
		}
	//级联表的get和set 学生

		/**
		* 获取： 学生姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 学生头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 学生邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 学生邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "FalvfaguiCollectionView{" +
			", falvfaguiCollectionValue=" + falvfaguiCollectionValue +
			", falvfaguiName=" + falvfaguiName +
			", falvfaguiUuidNumber=" + falvfaguiUuidNumber +
			", falvfaguiPhoto=" + falvfaguiPhoto +
			", falvfaguiVideo=" + falvfaguiVideo +
			", falvfaguiContent=" + falvfaguiContent +
			", falvfaguiDelete=" + falvfaguiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
