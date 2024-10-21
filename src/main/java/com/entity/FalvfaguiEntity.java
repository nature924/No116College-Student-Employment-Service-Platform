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
 * 法律法规
 *
 * @author 
 * @email
 */
@TableName("falvfagui")
public class FalvfaguiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FalvfaguiEntity() {

	}

	public FalvfaguiEntity(T t) {
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
     * 法律法规名称
     */
    @ColumnInfo(comment="法律法规名称",type="varchar(200)")
    @TableField(value = "falvfagui_name")

    private String falvfaguiName;


    /**
     * 法律法规编号
     */
    @ColumnInfo(comment="法律法规编号",type="varchar(200)")
    @TableField(value = "falvfagui_uuid_number")

    private String falvfaguiUuidNumber;


    /**
     * 法律法规照片
     */
    @ColumnInfo(comment="法律法规照片",type="varchar(200)")
    @TableField(value = "falvfagui_photo")

    private String falvfaguiPhoto;


    /**
     * 新闻视频
     */
    @ColumnInfo(comment="新闻视频",type="varchar(200)")
    @TableField(value = "falvfagui_video")

    private String falvfaguiVideo;


    /**
     * 法律法规类型
     */
    @ColumnInfo(comment="法律法规类型",type="int(11)")
    @TableField(value = "falvfagui_types")

    private Integer falvfaguiTypes;


    /**
     * 法律法规介绍
     */
    @ColumnInfo(comment="法律法规介绍",type="longtext")
    @TableField(value = "falvfagui_content")

    private String falvfaguiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "falvfagui_delete")

    private Integer falvfaguiDelete;


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
	 * 获取：法律法规名称
	 */
    public String getFalvfaguiName() {
        return falvfaguiName;
    }
    /**
	 * 设置：法律法规名称
	 */

    public void setFalvfaguiName(String falvfaguiName) {
        this.falvfaguiName = falvfaguiName;
    }
    /**
	 * 获取：法律法规编号
	 */
    public String getFalvfaguiUuidNumber() {
        return falvfaguiUuidNumber;
    }
    /**
	 * 设置：法律法规编号
	 */

    public void setFalvfaguiUuidNumber(String falvfaguiUuidNumber) {
        this.falvfaguiUuidNumber = falvfaguiUuidNumber;
    }
    /**
	 * 获取：法律法规照片
	 */
    public String getFalvfaguiPhoto() {
        return falvfaguiPhoto;
    }
    /**
	 * 设置：法律法规照片
	 */

    public void setFalvfaguiPhoto(String falvfaguiPhoto) {
        this.falvfaguiPhoto = falvfaguiPhoto;
    }
    /**
	 * 获取：新闻视频
	 */
    public String getFalvfaguiVideo() {
        return falvfaguiVideo;
    }
    /**
	 * 设置：新闻视频
	 */

    public void setFalvfaguiVideo(String falvfaguiVideo) {
        this.falvfaguiVideo = falvfaguiVideo;
    }
    /**
	 * 获取：法律法规类型
	 */
    public Integer getFalvfaguiTypes() {
        return falvfaguiTypes;
    }
    /**
	 * 设置：法律法规类型
	 */

    public void setFalvfaguiTypes(Integer falvfaguiTypes) {
        this.falvfaguiTypes = falvfaguiTypes;
    }
    /**
	 * 获取：法律法规介绍
	 */
    public String getFalvfaguiContent() {
        return falvfaguiContent;
    }
    /**
	 * 设置：法律法规介绍
	 */

    public void setFalvfaguiContent(String falvfaguiContent) {
        this.falvfaguiContent = falvfaguiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFalvfaguiDelete() {
        return falvfaguiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFalvfaguiDelete(Integer falvfaguiDelete) {
        this.falvfaguiDelete = falvfaguiDelete;
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
        return "Falvfagui{" +
            ", id=" + id +
            ", falvfaguiName=" + falvfaguiName +
            ", falvfaguiUuidNumber=" + falvfaguiUuidNumber +
            ", falvfaguiPhoto=" + falvfaguiPhoto +
            ", falvfaguiVideo=" + falvfaguiVideo +
            ", falvfaguiTypes=" + falvfaguiTypes +
            ", falvfaguiContent=" + falvfaguiContent +
            ", falvfaguiDelete=" + falvfaguiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
