package com.entity.vo;

import com.entity.FalvfaguiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 法律法规
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("falvfagui")
public class FalvfaguiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 法律法规名称
     */

    @TableField(value = "falvfagui_name")
    private String falvfaguiName;


    /**
     * 法律法规编号
     */

    @TableField(value = "falvfagui_uuid_number")
    private String falvfaguiUuidNumber;


    /**
     * 法律法规照片
     */

    @TableField(value = "falvfagui_photo")
    private String falvfaguiPhoto;


    /**
     * 新闻视频
     */

    @TableField(value = "falvfagui_video")
    private String falvfaguiVideo;


    /**
     * 法律法规类型
     */

    @TableField(value = "falvfagui_types")
    private Integer falvfaguiTypes;


    /**
     * 法律法规介绍
     */

    @TableField(value = "falvfagui_content")
    private String falvfaguiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "falvfagui_delete")
    private Integer falvfaguiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：法律法规名称
	 */
    public String getFalvfaguiName() {
        return falvfaguiName;
    }


    /**
	 * 获取：法律法规名称
	 */

    public void setFalvfaguiName(String falvfaguiName) {
        this.falvfaguiName = falvfaguiName;
    }
    /**
	 * 设置：法律法规编号
	 */
    public String getFalvfaguiUuidNumber() {
        return falvfaguiUuidNumber;
    }


    /**
	 * 获取：法律法规编号
	 */

    public void setFalvfaguiUuidNumber(String falvfaguiUuidNumber) {
        this.falvfaguiUuidNumber = falvfaguiUuidNumber;
    }
    /**
	 * 设置：法律法规照片
	 */
    public String getFalvfaguiPhoto() {
        return falvfaguiPhoto;
    }


    /**
	 * 获取：法律法规照片
	 */

    public void setFalvfaguiPhoto(String falvfaguiPhoto) {
        this.falvfaguiPhoto = falvfaguiPhoto;
    }
    /**
	 * 设置：新闻视频
	 */
    public String getFalvfaguiVideo() {
        return falvfaguiVideo;
    }


    /**
	 * 获取：新闻视频
	 */

    public void setFalvfaguiVideo(String falvfaguiVideo) {
        this.falvfaguiVideo = falvfaguiVideo;
    }
    /**
	 * 设置：法律法规类型
	 */
    public Integer getFalvfaguiTypes() {
        return falvfaguiTypes;
    }


    /**
	 * 获取：法律法规类型
	 */

    public void setFalvfaguiTypes(Integer falvfaguiTypes) {
        this.falvfaguiTypes = falvfaguiTypes;
    }
    /**
	 * 设置：法律法规介绍
	 */
    public String getFalvfaguiContent() {
        return falvfaguiContent;
    }


    /**
	 * 获取：法律法规介绍
	 */

    public void setFalvfaguiContent(String falvfaguiContent) {
        this.falvfaguiContent = falvfaguiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFalvfaguiDelete() {
        return falvfaguiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFalvfaguiDelete(Integer falvfaguiDelete) {
        this.falvfaguiDelete = falvfaguiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
