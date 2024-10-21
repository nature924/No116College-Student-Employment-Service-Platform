package com.entity.model;

import com.entity.XinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 学生专业
     */
    private Integer xinxiTypes;


    /**
     * 学生班级
     */
    private Integer xinxiBanjiTypes;


    /**
     * 学院
     */
    private String xinxiXueyuan;


    /**
     * 学生信息介绍
     */
    private String xinxiContent;


    /**
     * 逻辑删除
     */
    private Integer xinxiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
