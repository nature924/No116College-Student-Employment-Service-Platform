package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XinwenLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 新闻资讯留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xinwen_liuyan")
public class XinwenLiuyanView extends XinwenLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 新闻资讯
		/**
		* 新闻资讯名称
		*/

		@ColumnInfo(comment="新闻资讯名称",type="varchar(200)")
		private String xinwenName;
		/**
		* 新闻资讯编号
		*/

		@ColumnInfo(comment="新闻资讯编号",type="varchar(200)")
		private String xinwenUuidNumber;
		/**
		* 新闻资讯照片
		*/

		@ColumnInfo(comment="新闻资讯照片",type="varchar(200)")
		private String xinwenPhoto;
		/**
		* 新闻视频
		*/

		@ColumnInfo(comment="新闻视频",type="varchar(200)")
		private String xinwenVideo;
		/**
		* 新闻资讯类型
		*/
		@ColumnInfo(comment="新闻资讯类型",type="int(11)")
		private Integer xinwenTypes;
			/**
			* 新闻资讯类型的值
			*/
			@ColumnInfo(comment="新闻资讯类型的字典表值",type="varchar(200)")
			private String xinwenValue;
		/**
		* 新闻资讯介绍
		*/

		@ColumnInfo(comment="新闻资讯介绍",type="longtext")
		private String xinwenContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer xinwenDelete;
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



	public XinwenLiuyanView() {

	}

	public XinwenLiuyanView(XinwenLiuyanEntity xinwenLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, xinwenLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 新闻资讯

		/**
		* 获取： 新闻资讯名称
		*/
		public String getXinwenName() {
			return xinwenName;
		}
		/**
		* 设置： 新闻资讯名称
		*/
		public void setXinwenName(String xinwenName) {
			this.xinwenName = xinwenName;
		}

		/**
		* 获取： 新闻资讯编号
		*/
		public String getXinwenUuidNumber() {
			return xinwenUuidNumber;
		}
		/**
		* 设置： 新闻资讯编号
		*/
		public void setXinwenUuidNumber(String xinwenUuidNumber) {
			this.xinwenUuidNumber = xinwenUuidNumber;
		}

		/**
		* 获取： 新闻资讯照片
		*/
		public String getXinwenPhoto() {
			return xinwenPhoto;
		}
		/**
		* 设置： 新闻资讯照片
		*/
		public void setXinwenPhoto(String xinwenPhoto) {
			this.xinwenPhoto = xinwenPhoto;
		}

		/**
		* 获取： 新闻视频
		*/
		public String getXinwenVideo() {
			return xinwenVideo;
		}
		/**
		* 设置： 新闻视频
		*/
		public void setXinwenVideo(String xinwenVideo) {
			this.xinwenVideo = xinwenVideo;
		}
		/**
		* 获取： 新闻资讯类型
		*/
		public Integer getXinwenTypes() {
			return xinwenTypes;
		}
		/**
		* 设置： 新闻资讯类型
		*/
		public void setXinwenTypes(Integer xinwenTypes) {
			this.xinwenTypes = xinwenTypes;
		}


			/**
			* 获取： 新闻资讯类型的值
			*/
			public String getXinwenValue() {
				return xinwenValue;
			}
			/**
			* 设置： 新闻资讯类型的值
			*/
			public void setXinwenValue(String xinwenValue) {
				this.xinwenValue = xinwenValue;
			}

		/**
		* 获取： 新闻资讯介绍
		*/
		public String getXinwenContent() {
			return xinwenContent;
		}
		/**
		* 设置： 新闻资讯介绍
		*/
		public void setXinwenContent(String xinwenContent) {
			this.xinwenContent = xinwenContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getXinwenDelete() {
			return xinwenDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setXinwenDelete(Integer xinwenDelete) {
			this.xinwenDelete = xinwenDelete;
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
		return "XinwenLiuyanView{" +
			", xinwenName=" + xinwenName +
			", xinwenUuidNumber=" + xinwenUuidNumber +
			", xinwenPhoto=" + xinwenPhoto +
			", xinwenVideo=" + xinwenVideo +
			", xinwenContent=" + xinwenContent +
			", xinwenDelete=" + xinwenDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
