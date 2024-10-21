package com.entity.model;

import com.entity.XuanchuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宣传
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuanchuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 宣传名称
     */
    private String xuanchuanName;


    /**
     * 宣传编号
     */
    private String xuanchuanUuidNumber;


    /**
     * 宣传照片
     */
    private String xuanchuanPhoto;


    /**
     * 宣传视频
     */
    private String xuanchuanVideo;


    /**
     * 宣传介绍
     */
    private String xuanchuanContent;


    /**
     * 逻辑删除
     */
    private Integer xuanchuanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
