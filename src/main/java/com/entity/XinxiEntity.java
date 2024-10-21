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
 * 学生信息
 *
 * @author 
 * @email
 */
@TableName("xinxi")
public class XinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinxiEntity() {

	}

	public XinxiEntity(T t) {
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
     * 学生专业
     */
    @ColumnInfo(comment="学生专业",type="int(11)")
    @TableField(value = "xinxi_types")

    private Integer xinxiTypes;


    /**
     * 学生班级
     */
    @ColumnInfo(comment="学生班级",type="int(11)")
    @TableField(value = "xinxi_banji_types")

    private Integer xinxiBanjiTypes;


    /**
     * 学院
     */
    @ColumnInfo(comment="学院",type="varchar(200)")
    @TableField(value = "xinxi_xueyuan")

    private String xinxiXueyuan;


    /**
     * 学生信息介绍
     */
    @ColumnInfo(comment="学生信息介绍",type="longtext")
    @TableField(value = "xinxi_content")

    private String xinxiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xinxi_delete")

    private Integer xinxiDelete;


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
	 * 获取：学生专业
	 */
    public Integer getXinxiTypes() {
        return xinxiTypes;
    }
    /**
	 * 设置：学生专业
	 */

    public void setXinxiTypes(Integer xinxiTypes) {
        this.xinxiTypes = xinxiTypes;
    }
    /**
	 * 获取：学生班级
	 */
    public Integer getXinxiBanjiTypes() {
        return xinxiBanjiTypes;
    }
    /**
	 * 设置：学生班级
	 */

    public void setXinxiBanjiTypes(Integer xinxiBanjiTypes) {
        this.xinxiBanjiTypes = xinxiBanjiTypes;
    }
    /**
	 * 获取：学院
	 */
    public String getXinxiXueyuan() {
        return xinxiXueyuan;
    }
    /**
	 * 设置：学院
	 */

    public void setXinxiXueyuan(String xinxiXueyuan) {
        this.xinxiXueyuan = xinxiXueyuan;
    }
    /**
	 * 获取：学生信息介绍
	 */
    public String getXinxiContent() {
        return xinxiContent;
    }
    /**
	 * 设置：学生信息介绍
	 */

    public void setXinxiContent(String xinxiContent) {
        this.xinxiContent = xinxiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXinxiDelete() {
        return xinxiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXinxiDelete(Integer xinxiDelete) {
        this.xinxiDelete = xinxiDelete;
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
        return "Xinxi{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", xinxiTypes=" + xinxiTypes +
            ", xinxiBanjiTypes=" + xinxiBanjiTypes +
            ", xinxiXueyuan=" + xinxiXueyuan +
            ", xinxiContent=" + xinxiContent +
            ", xinxiDelete=" + xinxiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
