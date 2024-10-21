package com.entity.vo;

import com.entity.XuanchuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宣传
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuanchuan")
public class XuanchuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 宣传名称
     */

    @TableField(value = "xuanchuan_name")
    private String xuanchuanName;


    /**
     * 宣传编号
     */

    @TableField(value = "xuanchuan_uuid_number")
    private String xuanchuanUuidNumber;


    /**
     * 宣传照片
     */

    @TableField(value = "xuanchuan_photo")
    private String xuanchuanPhoto;


    /**
     * 宣传视频
     */

    @TableField(value = "xuanchuan_video")
    private String xuanchuanVideo;


    /**
     * 宣传介绍
     */

    @TableField(value = "xuanchuan_content")
    private String xuanchuanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "xuanchuan_delete")
    private Integer xuanchuanDelete;


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
	 * 设置：宣传名称
	 */
    public String getXuanchuanName() {
        return xuanchuanName;
    }


    /**
	 * 获取：宣传名称
	 */

    public void setXuanchuanName(String xuanchuanName) {
        this.xuanchuanName = xuanchuanName;
    }
    /**
	 * 设置：宣传编号
	 */
    public String getXuanchuanUuidNumber() {
        return xuanchuanUuidNumber;
    }


    /**
	 * 获取：宣传编号
	 */

    public void setXuanchuanUuidNumber(String xuanchuanUuidNumber) {
        this.xuanchuanUuidNumber = xuanchuanUuidNumber;
    }
    /**
	 * 设置：宣传照片
	 */
    public String getXuanchuanPhoto() {
        return xuanchuanPhoto;
    }


    /**
	 * 获取：宣传照片
	 */

    public void setXuanchuanPhoto(String xuanchuanPhoto) {
        this.xuanchuanPhoto = xuanchuanPhoto;
    }
    /**
	 * 设置：宣传视频
	 */
    public String getXuanchuanVideo() {
        return xuanchuanVideo;
    }


    /**
	 * 获取：宣传视频
	 */

    public void setXuanchuanVideo(String xuanchuanVideo) {
        this.xuanchuanVideo = xuanchuanVideo;
    }
    /**
	 * 设置：宣传介绍
	 */
    public String getXuanchuanContent() {
        return xuanchuanContent;
    }


    /**
	 * 获取：宣传介绍
	 */

    public void setXuanchuanContent(String xuanchuanContent) {
        this.xuanchuanContent = xuanchuanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXuanchuanDelete() {
        return xuanchuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXuanchuanDelete(Integer xuanchuanDelete) {
        this.xuanchuanDelete = xuanchuanDelete;
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
