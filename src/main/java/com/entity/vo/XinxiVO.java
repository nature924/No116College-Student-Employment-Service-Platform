package com.entity.vo;

import com.entity.XinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学生信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinxi")
public class XinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 学生专业
     */

    @TableField(value = "xinxi_types")
    private Integer xinxiTypes;


    /**
     * 学生班级
     */

    @TableField(value = "xinxi_banji_types")
    private Integer xinxiBanjiTypes;


    /**
     * 学院
     */

    @TableField(value = "xinxi_xueyuan")
    private String xinxiXueyuan;


    /**
     * 学生信息介绍
     */

    @TableField(value = "xinxi_content")
    private String xinxiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "xinxi_delete")
    private Integer xinxiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：学生专业
	 */
    public Integer getXinxiTypes() {
        return xinxiTypes;
    }


    /**
	 * 获取：学生专业
	 */

    public void setXinxiTypes(Integer xinxiTypes) {
        this.xinxiTypes = xinxiTypes;
    }
    /**
	 * 设置：学生班级
	 */
    public Integer getXinxiBanjiTypes() {
        return xinxiBanjiTypes;
    }


    /**
	 * 获取：学生班级
	 */

    public void setXinxiBanjiTypes(Integer xinxiBanjiTypes) {
        this.xinxiBanjiTypes = xinxiBanjiTypes;
    }
    /**
	 * 设置：学院
	 */
    public String getXinxiXueyuan() {
        return xinxiXueyuan;
    }


    /**
	 * 获取：学院
	 */

    public void setXinxiXueyuan(String xinxiXueyuan) {
        this.xinxiXueyuan = xinxiXueyuan;
    }
    /**
	 * 设置：学生信息介绍
	 */
    public String getXinxiContent() {
        return xinxiContent;
    }


    /**
	 * 获取：学生信息介绍
	 */

    public void setXinxiContent(String xinxiContent) {
        this.xinxiContent = xinxiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXinxiDelete() {
        return xinxiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXinxiDelete(Integer xinxiDelete) {
        this.xinxiDelete = xinxiDelete;
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
