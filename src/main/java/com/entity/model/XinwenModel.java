package com.entity.model;

import com.entity.XinwenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 新闻资讯
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinwenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 新闻资讯名称
     */
    private String xinwenName;


    /**
     * 新闻资讯编号
     */
    private String xinwenUuidNumber;


    /**
     * 新闻资讯照片
     */
    private String xinwenPhoto;


    /**
     * 新闻视频
     */
    private String xinwenVideo;


    /**
     * 新闻资讯类型
     */
    private Integer xinwenTypes;


    /**
     * 新闻资讯介绍
     */
    private String xinwenContent;


    /**
     * 逻辑删除
     */
    private Integer xinwenDelete;


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
