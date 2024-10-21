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
 * 学生档案
 *
 * @author 
 * @email
 */
@TableName("dangan")
public class DanganEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DanganEntity() {

	}

	public DanganEntity(T t) {
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
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 学生档案名称
     */
    @ColumnInfo(comment="学生档案名称",type="varchar(200)")
    @TableField(value = "dangan_name")

    private String danganName;


    /**
     * 学生档案编号
     */
    @ColumnInfo(comment="学生档案编号",type="varchar(200)")
    @TableField(value = "dangan_uuid_number")

    private String danganUuidNumber;


    /**
     * 学生档案照片
     */
    @ColumnInfo(comment="学生档案照片",type="varchar(200)")
    @TableField(value = "dangan_photo")

    private String danganPhoto;


    /**
     * 学生档案类型
     */
    @ColumnInfo(comment="学生档案类型",type="int(11)")
    @TableField(value = "dangan_types")

    private Integer danganTypes;


    /**
     * 就业去向
     */
    @ColumnInfo(comment="就业去向",type="varchar(200)")
    @TableField(value = "dangan_quxiang")

    private String danganQuxiang;


    /**
     * 学生档案介绍
     */
    @ColumnInfo(comment="学生档案介绍",type="longtext")
    @TableField(value = "dangan_content")

    private String danganContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "dangan_delete")

    private Integer danganDelete;


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
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：学生档案名称
	 */
    public String getDanganName() {
        return danganName;
    }
    /**
	 * 设置：学生档案名称
	 */

    public void setDanganName(String danganName) {
        this.danganName = danganName;
    }
    /**
	 * 获取：学生档案编号
	 */
    public String getDanganUuidNumber() {
        return danganUuidNumber;
    }
    /**
	 * 设置：学生档案编号
	 */

    public void setDanganUuidNumber(String danganUuidNumber) {
        this.danganUuidNumber = danganUuidNumber;
    }
    /**
	 * 获取：学生档案照片
	 */
    public String getDanganPhoto() {
        return danganPhoto;
    }
    /**
	 * 设置：学生档案照片
	 */

    public void setDanganPhoto(String danganPhoto) {
        this.danganPhoto = danganPhoto;
    }
    /**
	 * 获取：学生档案类型
	 */
    public Integer getDanganTypes() {
        return danganTypes;
    }
    /**
	 * 设置：学生档案类型
	 */

    public void setDanganTypes(Integer danganTypes) {
        this.danganTypes = danganTypes;
    }
    /**
	 * 获取：就业去向
	 */
    public String getDanganQuxiang() {
        return danganQuxiang;
    }
    /**
	 * 设置：就业去向
	 */

    public void setDanganQuxiang(String danganQuxiang) {
        this.danganQuxiang = danganQuxiang;
    }
    /**
	 * 获取：学生档案介绍
	 */
    public String getDanganContent() {
        return danganContent;
    }
    /**
	 * 设置：学生档案介绍
	 */

    public void setDanganContent(String danganContent) {
        this.danganContent = danganContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDanganDelete() {
        return danganDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDanganDelete(Integer danganDelete) {
        this.danganDelete = danganDelete;
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
        return "Dangan{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", danganName=" + danganName +
            ", danganUuidNumber=" + danganUuidNumber +
            ", danganPhoto=" + danganPhoto +
            ", danganTypes=" + danganTypes +
            ", danganQuxiang=" + danganQuxiang +
            ", danganContent=" + danganContent +
            ", danganDelete=" + danganDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
