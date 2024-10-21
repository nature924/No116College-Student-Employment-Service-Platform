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
 * 就业分析
 *
 * @author 
 * @email
 */
@TableName("fenxi")
public class FenxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FenxiEntity() {

	}

	public FenxiEntity(T t) {
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
     * 就业分析名称
     */
    @ColumnInfo(comment="就业分析名称",type="varchar(200)")
    @TableField(value = "fenxi_name")

    private String fenxiName;


    /**
     * 就业分析编号
     */
    @ColumnInfo(comment="就业分析编号",type="varchar(200)")
    @TableField(value = "fenxi_uuid_number")

    private String fenxiUuidNumber;


    /**
     * 就业分析照片
     */
    @ColumnInfo(comment="就业分析照片",type="varchar(200)")
    @TableField(value = "fenxi_photo")

    private String fenxiPhoto;


    /**
     * 就业分析类型
     */
    @ColumnInfo(comment="就业分析类型",type="int(11)")
    @TableField(value = "fenxi_types")

    private Integer fenxiTypes;


    /**
     * 就业去向
     */
    @ColumnInfo(comment="就业去向",type="varchar(200)")
    @TableField(value = "fenxi_quxiang")

    private String fenxiQuxiang;


    /**
     * 薪资
     */
    @ColumnInfo(comment="薪资",type="int(11)")
    @TableField(value = "fenxi_xinzi")

    private Integer fenxiXinzi;


    /**
     * 就业率
     */
    @ColumnInfo(comment="就业率",type="int(11)")
    @TableField(value = "fenxi_jiuyel")

    private Integer fenxiJiuyel;


    /**
     * 就业分析介绍
     */
    @ColumnInfo(comment="就业分析介绍",type="longtext")
    @TableField(value = "fenxi_content")

    private String fenxiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fenxi_delete")

    private Integer fenxiDelete;


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
	 * 获取：就业分析名称
	 */
    public String getFenxiName() {
        return fenxiName;
    }
    /**
	 * 设置：就业分析名称
	 */

    public void setFenxiName(String fenxiName) {
        this.fenxiName = fenxiName;
    }
    /**
	 * 获取：就业分析编号
	 */
    public String getFenxiUuidNumber() {
        return fenxiUuidNumber;
    }
    /**
	 * 设置：就业分析编号
	 */

    public void setFenxiUuidNumber(String fenxiUuidNumber) {
        this.fenxiUuidNumber = fenxiUuidNumber;
    }
    /**
	 * 获取：就业分析照片
	 */
    public String getFenxiPhoto() {
        return fenxiPhoto;
    }
    /**
	 * 设置：就业分析照片
	 */

    public void setFenxiPhoto(String fenxiPhoto) {
        this.fenxiPhoto = fenxiPhoto;
    }
    /**
	 * 获取：就业分析类型
	 */
    public Integer getFenxiTypes() {
        return fenxiTypes;
    }
    /**
	 * 设置：就业分析类型
	 */

    public void setFenxiTypes(Integer fenxiTypes) {
        this.fenxiTypes = fenxiTypes;
    }
    /**
	 * 获取：就业去向
	 */
    public String getFenxiQuxiang() {
        return fenxiQuxiang;
    }
    /**
	 * 设置：就业去向
	 */

    public void setFenxiQuxiang(String fenxiQuxiang) {
        this.fenxiQuxiang = fenxiQuxiang;
    }
    /**
	 * 获取：薪资
	 */
    public Integer getFenxiXinzi() {
        return fenxiXinzi;
    }
    /**
	 * 设置：薪资
	 */

    public void setFenxiXinzi(Integer fenxiXinzi) {
        this.fenxiXinzi = fenxiXinzi;
    }
    /**
	 * 获取：就业率
	 */
    public Integer getFenxiJiuyel() {
        return fenxiJiuyel;
    }
    /**
	 * 设置：就业率
	 */

    public void setFenxiJiuyel(Integer fenxiJiuyel) {
        this.fenxiJiuyel = fenxiJiuyel;
    }
    /**
	 * 获取：就业分析介绍
	 */
    public String getFenxiContent() {
        return fenxiContent;
    }
    /**
	 * 设置：就业分析介绍
	 */

    public void setFenxiContent(String fenxiContent) {
        this.fenxiContent = fenxiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFenxiDelete() {
        return fenxiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFenxiDelete(Integer fenxiDelete) {
        this.fenxiDelete = fenxiDelete;
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
        return "Fenxi{" +
            ", id=" + id +
            ", fenxiName=" + fenxiName +
            ", fenxiUuidNumber=" + fenxiUuidNumber +
            ", fenxiPhoto=" + fenxiPhoto +
            ", fenxiTypes=" + fenxiTypes +
            ", fenxiQuxiang=" + fenxiQuxiang +
            ", fenxiXinzi=" + fenxiXinzi +
            ", fenxiJiuyel=" + fenxiJiuyel +
            ", fenxiContent=" + fenxiContent +
            ", fenxiDelete=" + fenxiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
