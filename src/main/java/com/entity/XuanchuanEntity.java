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
 * 宣传
 *
 * @author 
 * @email
 */
@TableName("xuanchuan")
public class XuanchuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuanchuanEntity() {

	}

	public XuanchuanEntity(T t) {
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
     * 宣传名称
     */
    @ColumnInfo(comment="宣传名称",type="varchar(200)")
    @TableField(value = "xuanchuan_name")

    private String xuanchuanName;


    /**
     * 宣传编号
     */
    @ColumnInfo(comment="宣传编号",type="varchar(200)")
    @TableField(value = "xuanchuan_uuid_number")

    private String xuanchuanUuidNumber;


    /**
     * 宣传照片
     */
    @ColumnInfo(comment="宣传照片",type="varchar(200)")
    @TableField(value = "xuanchuan_photo")

    private String xuanchuanPhoto;


    /**
     * 宣传视频
     */
    @ColumnInfo(comment="宣传视频",type="varchar(200)")
    @TableField(value = "xuanchuan_video")

    private String xuanchuanVideo;


    /**
     * 宣传介绍
     */
    @ColumnInfo(comment="宣传介绍",type="longtext")
    @TableField(value = "xuanchuan_content")

    private String xuanchuanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xuanchuan_delete")

    private Integer xuanchuanDelete;


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
	 * 获取：宣传名称
	 */
    public String getXuanchuanName() {
        return xuanchuanName;
    }
    /**
	 * 设置：宣传名称
	 */

    public void setXuanchuanName(String xuanchuanName) {
        this.xuanchuanName = xuanchuanName;
    }
    /**
	 * 获取：宣传编号
	 */
    public String getXuanchuanUuidNumber() {
        return xuanchuanUuidNumber;
    }
    /**
	 * 设置：宣传编号
	 */

    public void setXuanchuanUuidNumber(String xuanchuanUuidNumber) {
        this.xuanchuanUuidNumber = xuanchuanUuidNumber;
    }
    /**
	 * 获取：宣传照片
	 */
    public String getXuanchuanPhoto() {
        return xuanchuanPhoto;
    }
    /**
	 * 设置：宣传照片
	 */

    public void setXuanchuanPhoto(String xuanchuanPhoto) {
        this.xuanchuanPhoto = xuanchuanPhoto;
    }
    /**
	 * 获取：宣传视频
	 */
    public String getXuanchuanVideo() {
        return xuanchuanVideo;
    }
    /**
	 * 设置：宣传视频
	 */

    public void setXuanchuanVideo(String xuanchuanVideo) {
        this.xuanchuanVideo = xuanchuanVideo;
    }
    /**
	 * 获取：宣传介绍
	 */
    public String getXuanchuanContent() {
        return xuanchuanContent;
    }
    /**
	 * 设置：宣传介绍
	 */

    public void setXuanchuanContent(String xuanchuanContent) {
        this.xuanchuanContent = xuanchuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXuanchuanDelete() {
        return xuanchuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXuanchuanDelete(Integer xuanchuanDelete) {
        this.xuanchuanDelete = xuanchuanDelete;
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
        return "Xuanchuan{" +
            ", id=" + id +
            ", xuanchuanName=" + xuanchuanName +
            ", xuanchuanUuidNumber=" + xuanchuanUuidNumber +
            ", xuanchuanPhoto=" + xuanchuanPhoto +
            ", xuanchuanVideo=" + xuanchuanVideo +
            ", xuanchuanContent=" + xuanchuanContent +
            ", xuanchuanDelete=" + xuanchuanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
