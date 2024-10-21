package com.entity.model;

import com.entity.FenxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 就业分析
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FenxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 就业分析名称
     */
    private String fenxiName;


    /**
     * 就业分析编号
     */
    private String fenxiUuidNumber;


    /**
     * 就业分析照片
     */
    private String fenxiPhoto;


    /**
     * 就业分析类型
     */
    private Integer fenxiTypes;


    /**
     * 就业去向
     */
    private String fenxiQuxiang;


    /**
     * 薪资
     */
    private Integer fenxiXinzi;


    /**
     * 就业率
     */
    private Integer fenxiJiuyel;


    /**
     * 就业分析介绍
     */
    private String fenxiContent;


    /**
     * 逻辑删除
     */
    private Integer fenxiDelete;


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

    }
