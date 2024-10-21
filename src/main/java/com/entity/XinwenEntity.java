package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 新闻资讯
 *
 * @author 
 * @email
 */
@TableName("xinwen")
public class XinwenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinwenEntity() {

	}

	public XinwenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 新闻资讯名称
     */
    @ColumnInfo(comment="新闻资讯名称",type="varchar(200)")
    @TableField(value = "xinwen_name")

    private String xinwenName;


    /**
     * 新闻资讯编号
     */
    @ColumnInfo(comment="新闻资讯编号",type="varchar(200)")
    @TableField(value = "xinwen_uuid_number")

    private String xinwenUuidNumber;


    /**
     * 新闻资讯照片
     */
    @ColumnInfo(comment="新闻资讯照片",type="varchar(200)")
    @TableField(value = "xinwen_photo")

    private String xinwenPhoto;


    /**
     * 新闻视频
     */
    @ColumnInfo(comment="新闻视频",type="varchar(200)")
    @TableField(value = "xinwen_video")

    private String xinwenVideo;


    /**
     * 新闻资讯类型
     */
    @ColumnInfo(comment="新闻资讯类型",type="int(11)")
    @TableField(value = "xinwen_types")

    private Integer xinwenTypes;


    /**
     * 新闻资讯介绍
     */
    @ColumnInfo(comment="新闻资讯介绍",type="longtext")
    @TableField(value = "xinwen_content")

    private String xinwenContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xinwen_delete")

    private Integer xinwenDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：新闻资讯名称
	 */
    public String getXinwenName() {
        return xinwenName;
    }
    /**
	 * 设置：新闻资讯名称
	 */

    public void setXinwenName(String xinwenName) {
        this.xinwenName = xinwenName;
    }
    /**
	 * 获取：新闻资讯编号
	 */
    public String getXinwenUuidNumber() {
        return xinwenUuidNumber;
    }
    /**
	 * 设置：新闻资讯编号
	 */

    public void setXinwenUuidNumber(String xinwenUuidNumber) {
        this.xinwenUuidNumber = xinwenUuidNumber;
    }
    /**
	 * 获取：新闻资讯照片
	 */
    public String getXinwenPhoto() {
        return xinwenPhoto;
    }
    /**
	 * 设置：新闻资讯照片
	 */

    public void setXinwenPhoto(String xinwenPhoto) {
        this.xinwenPhoto = xinwenPhoto;
    }
    /**
	 * 获取：新闻视频
	 */
    public String getXinwenVideo() {
        return xinwenVideo;
    }
    /**
	 * 设置：新闻视频
	 */

    public void setXinwenVideo(String xinwenVideo) {
        this.xinwenVideo = xinwenVideo;
    }
    /**
	 * 获取：新闻资讯类型
	 */
    public Integer getXinwenTypes() {
        return xinwenTypes;
    }
    /**
	 * 设置：新闻资讯类型
	 */

    public void setXinwenTypes(Integer xinwenTypes) {
        this.xinwenTypes = xinwenTypes;
    }
    /**
	 * 获取：新闻资讯介绍
	 */
    public String getXinwenContent() {
        return xinwenContent;
    }
    /**
	 * 设置：新闻资讯介绍
	 */

    public void setXinwenContent(String xinwenContent) {
        this.xinwenContent = xinwenContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXinwenDelete() {
        return xinwenDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXinwenDelete(Integer xinwenDelete) {
        this.xinwenDelete = xinwenDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xinwen{" +
            ", id=" + id +
            ", xinwenName=" + xinwenName +
            ", xinwenUuidNumber=" + xinwenUuidNumber +
            ", xinwenPhoto=" + xinwenPhoto +
            ", xinwenVideo=" + xinwenVideo +
            ", xinwenTypes=" + xinwenTypes +
            ", xinwenContent=" + xinwenContent +
            ", xinwenDelete=" + xinwenDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
