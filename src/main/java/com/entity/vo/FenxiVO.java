package com.entity.vo;

import com.entity.FenxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 就业分析
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fenxi")
public class FenxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 就业分析名称
     */

    @TableField(value = "fenxi_name")
    private String fenxiName;


    /**
     * 就业分析编号
     */

    @TableField(value = "fenxi_uuid_number")
    private String fenxiUuidNumber;


    /**
     * 就业分析照片
     */

    @TableField(value = "fenxi_photo")
    private String fenxiPhoto;


    /**
     * 就业分析类型
     */

    @TableField(value = "fenxi_types")
    private Integer fenxiTypes;


    /**
     * 就业去向
     */

    @TableField(value = "fenxi_quxiang")
    private String fenxiQuxiang;


    /**
     * 薪资
     */

    @TableField(value = "fenxi_xinzi")
    private Integer fenxiXinzi;


    /**
     * 就业率
     */

    @TableField(value = "fenxi_jiuyel")
    private Integer fenxiJiuyel;


    /**
     * 就业分析介绍
     */

    @TableField(value = "fenxi_content")
    private String fenxiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "fenxi_delete")
    private Integer fenxiDelete;


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
	 * 设置：就业分析名称
	 */
    public String getFenxiName() {
        return fenxiName;
    }


    /**
	 * 获取：就业分析名称
	 */

    public void setFenxiName(String fenxiName) {
        this.fenxiName = fenxiName;
    }
    /**
	 * 设置：就业分析编号
	 */
    public String getFenxiUuidNumber() {
        return fenxiUuidNumber;
    }


    /**
	 * 获取：就业分析编号
	 */

    public void setFenxiUuidNumber(String fenxiUuidNumber) {
        this.fenxiUuidNumber = fenxiUuidNumber;
    }
    /**
	 * 设置：就业分析照片
	 */
    public String getFenxiPhoto() {
        return fenxiPhoto;
    }


    /**
	 * 获取：就业分析照片
	 */

    public void setFenxiPhoto(String fenxiPhoto) {
        this.fenxiPhoto = fenxiPhoto;
    }
    /**
	 * 设置：就业分析类型
	 */
    public Integer getFenxiTypes() {
        return fenxiTypes;
    }


    /**
	 * 获取：就业分析类型
	 */

    public void setFenxiTypes(Integer fenxiTypes) {
        this.fenxiTypes = fenxiTypes;
    }
    /**
	 * 设置：就业去向
	 */
    public String getFenxiQuxiang() {
        return fenxiQuxiang;
    }


    /**
	 * 获取：就业去向
	 */

    public void setFenxiQuxiang(String fenxiQuxiang) {
        this.fenxiQuxiang = fenxiQuxiang;
    }
    /**
	 * 设置：薪资
	 */
    public Integer getFenxiXinzi() {
        return fenxiXinzi;
    }


    /**
	 * 获取：薪资
	 */

    public void setFenxiXinzi(Integer fenxiXinzi) {
        this.fenxiXinzi = fenxiXinzi;
    }
    /**
	 * 设置：就业率
	 */
    public Integer getFenxiJiuyel() {
        return fenxiJiuyel;
    }


    /**
	 * 获取：就业率
	 */

    public void setFenxiJiuyel(Integer fenxiJiuyel) {
        this.fenxiJiuyel = fenxiJiuyel;
    }
    /**
	 * 设置：就业分析介绍
	 */
    public String getFenxiContent() {
        return fenxiContent;
    }


    /**
	 * 获取：就业分析介绍
	 */

    public void setFenxiContent(String fenxiContent) {
        this.fenxiContent = fenxiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFenxiDelete() {
        return fenxiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFenxiDelete(Integer fenxiDelete) {
        this.fenxiDelete = fenxiDelete;
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
