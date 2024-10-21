package com.entity.model;

import com.entity.FalvfaguiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 法律法规
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FalvfaguiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 法律法规名称
     */
    private String falvfaguiName;


    /**
     * 法律法规编号
     */
    private String falvfaguiUuidNumber;


    /**
     * 法律法规照片
     */
    private String falvfaguiPhoto;


    /**
     * 新闻视频
     */
    private String falvfaguiVideo;


    /**
     * 法律法规类型
     */
    private Integer falvfaguiTypes;


    /**
     * 法律法规介绍
     */
    private String falvfaguiContent;


    /**
     * 逻辑删除
     */
    private Integer falvfaguiDelete;


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
