package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程
 * @TableName course
 */
@TableName(value ="course")
public class Course implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @Field(type = FieldType.Integer)
    private Integer id;

    /**
     * 课程名
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String courseName;

    /**
     * 课程一句话简介
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String brief;

    /**
     * 原价
     */
    @Field(type = FieldType.Double)
    private Double price;

    /**
     * 原价标签
     */
    @Field(type = FieldType.Text)
    private String priceTag;

    /**
     * 优惠价
     */
    @Field(type = FieldType.Double)
    private Double discounts;

    /**
     * 优惠标签
     */
    private String discountsTag;

    /**
     * 描述markdown
     */
    private String courseDescriptionMarkDown;

    /**
     * 课程描述
     */
    @Field(type = FieldType.Text)
    private String courseDescription;

    /**
     * 课程展示图
     */
    @Field(type = FieldType.Text)
    private String courseImgUrl;

    /**
     * 是否新品
     */
    private Integer isNew;

    /**
     * 广告语
     */
    private String isNewDes;

    /**
     * 最后操作者
     */
    private Integer lastOperatorId;

    /**
     * 自动上架时间
     */
    private Date autoOnlineTime;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 总时长(分钟)
     */
    private Integer totalDuration;

    /**
     * 课程缩略图
     */
    private String courseListImg;

    /**
     * 课程状态，0-草稿，1-上架
     */
    private Integer status;

    /**
     * 课程排序，用于后台保存草稿时用到
     */
    private Integer sortNum;

    /**
     * 课程预览第一个字段
     */
    private String previewFirstField;

    /**
     * 课程预览第二个字段
     */
    private String previewSecondField;

    /**
     * 销量
     */
    @Field(type = FieldType.Integer)
    private Integer sales;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 课程名
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 课程名
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 课程一句话简介
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 课程一句话简介
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * 原价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 原价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 原价标签
     */
    public String getPriceTag() {
        return priceTag;
    }

    /**
     * 原价标签
     */
    public void setPriceTag(String priceTag) {
        this.priceTag = priceTag;
    }

    /**
     * 优惠价
     */
    public Double getDiscounts() {
        return discounts;
    }

    /**
     * 优惠价
     */
    public void setDiscounts(Double discounts) {
        this.discounts = discounts;
    }

    /**
     * 优惠标签
     */
    public String getDiscountsTag() {
        return discountsTag;
    }

    /**
     * 优惠标签
     */
    public void setDiscountsTag(String discountsTag) {
        this.discountsTag = discountsTag;
    }

    /**
     * 描述markdown
     */
    public String getCourseDescriptionMarkDown() {
        return courseDescriptionMarkDown;
    }

    /**
     * 描述markdown
     */
    public void setCourseDescriptionMarkDown(String courseDescriptionMarkDown) {
        this.courseDescriptionMarkDown = courseDescriptionMarkDown;
    }

    /**
     * 课程描述
     */
    public String getCourseDescription() {
        return courseDescription;
    }

    /**
     * 课程描述
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    /**
     * 课程展示图
     */
    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    /**
     * 课程展示图
     */
    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    /**
     * 是否新品
     */
    public Integer getIsNew() {
        return isNew;
    }

    /**
     * 是否新品
     */
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    /**
     * 广告语
     */
    public String getIsNewDes() {
        return isNewDes;
    }

    /**
     * 广告语
     */
    public void setIsNewDes(String isNewDes) {
        this.isNewDes = isNewDes;
    }

    /**
     * 最后操作者
     */
    public Integer getLastOperatorId() {
        return lastOperatorId;
    }

    /**
     * 最后操作者
     */
    public void setLastOperatorId(Integer lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    /**
     * 自动上架时间
     */
    public Date getAutoOnlineTime() {
        return autoOnlineTime;
    }

    /**
     * 自动上架时间
     */
    public void setAutoOnlineTime(Date autoOnlineTime) {
        this.autoOnlineTime = autoOnlineTime;
    }

    /**
     * 记录创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 记录创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 是否删除
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 总时长(分钟)
     */
    public Integer getTotalDuration() {
        return totalDuration;
    }

    /**
     * 总时长(分钟)
     */
    public void setTotalDuration(Integer totalDuration) {
        this.totalDuration = totalDuration;
    }

    /**
     * 课程缩略图
     */
    public String getCourseListImg() {
        return courseListImg;
    }

    /**
     * 课程缩略图
     */
    public void setCourseListImg(String courseListImg) {
        this.courseListImg = courseListImg;
    }

    /**
     * 课程状态，0-草稿，1-上架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 课程状态，0-草稿，1-上架
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 课程排序，用于后台保存草稿时用到
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * 课程排序，用于后台保存草稿时用到
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    /**
     * 课程预览第一个字段
     */
    public String getPreviewFirstField() {
        return previewFirstField;
    }

    /**
     * 课程预览第一个字段
     */
    public void setPreviewFirstField(String previewFirstField) {
        this.previewFirstField = previewFirstField;
    }

    /**
     * 课程预览第二个字段
     */
    public String getPreviewSecondField() {
        return previewSecondField;
    }

    /**
     * 课程预览第二个字段
     */
    public void setPreviewSecondField(String previewSecondField) {
        this.previewSecondField = previewSecondField;
    }

    /**
     * 销量
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 销量
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCourseName() == null ? other.getCourseName() == null : this.getCourseName().equals(other.getCourseName()))
            && (this.getBrief() == null ? other.getBrief() == null : this.getBrief().equals(other.getBrief()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPriceTag() == null ? other.getPriceTag() == null : this.getPriceTag().equals(other.getPriceTag()))
            && (this.getDiscounts() == null ? other.getDiscounts() == null : this.getDiscounts().equals(other.getDiscounts()))
            && (this.getDiscountsTag() == null ? other.getDiscountsTag() == null : this.getDiscountsTag().equals(other.getDiscountsTag()))
            && (this.getCourseDescriptionMarkDown() == null ? other.getCourseDescriptionMarkDown() == null : this.getCourseDescriptionMarkDown().equals(other.getCourseDescriptionMarkDown()))
            && (this.getCourseDescription() == null ? other.getCourseDescription() == null : this.getCourseDescription().equals(other.getCourseDescription()))
            && (this.getCourseImgUrl() == null ? other.getCourseImgUrl() == null : this.getCourseImgUrl().equals(other.getCourseImgUrl()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getIsNewDes() == null ? other.getIsNewDes() == null : this.getIsNewDes().equals(other.getIsNewDes()))
            && (this.getLastOperatorId() == null ? other.getLastOperatorId() == null : this.getLastOperatorId().equals(other.getLastOperatorId()))
            && (this.getAutoOnlineTime() == null ? other.getAutoOnlineTime() == null : this.getAutoOnlineTime().equals(other.getAutoOnlineTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getTotalDuration() == null ? other.getTotalDuration() == null : this.getTotalDuration().equals(other.getTotalDuration()))
            && (this.getCourseListImg() == null ? other.getCourseListImg() == null : this.getCourseListImg().equals(other.getCourseListImg()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSortNum() == null ? other.getSortNum() == null : this.getSortNum().equals(other.getSortNum()))
            && (this.getPreviewFirstField() == null ? other.getPreviewFirstField() == null : this.getPreviewFirstField().equals(other.getPreviewFirstField()))
            && (this.getPreviewSecondField() == null ? other.getPreviewSecondField() == null : this.getPreviewSecondField().equals(other.getPreviewSecondField()))
            && (this.getSales() == null ? other.getSales() == null : this.getSales().equals(other.getSales()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseName() == null) ? 0 : getCourseName().hashCode());
        result = prime * result + ((getBrief() == null) ? 0 : getBrief().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPriceTag() == null) ? 0 : getPriceTag().hashCode());
        result = prime * result + ((getDiscounts() == null) ? 0 : getDiscounts().hashCode());
        result = prime * result + ((getDiscountsTag() == null) ? 0 : getDiscountsTag().hashCode());
        result = prime * result + ((getCourseDescriptionMarkDown() == null) ? 0 : getCourseDescriptionMarkDown().hashCode());
        result = prime * result + ((getCourseDescription() == null) ? 0 : getCourseDescription().hashCode());
        result = prime * result + ((getCourseImgUrl() == null) ? 0 : getCourseImgUrl().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getIsNewDes() == null) ? 0 : getIsNewDes().hashCode());
        result = prime * result + ((getLastOperatorId() == null) ? 0 : getLastOperatorId().hashCode());
        result = prime * result + ((getAutoOnlineTime() == null) ? 0 : getAutoOnlineTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getTotalDuration() == null) ? 0 : getTotalDuration().hashCode());
        result = prime * result + ((getCourseListImg() == null) ? 0 : getCourseListImg().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSortNum() == null) ? 0 : getSortNum().hashCode());
        result = prime * result + ((getPreviewFirstField() == null) ? 0 : getPreviewFirstField().hashCode());
        result = prime * result + ((getPreviewSecondField() == null) ? 0 : getPreviewSecondField().hashCode());
        result = prime * result + ((getSales() == null) ? 0 : getSales().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseName=").append(courseName);
        sb.append(", brief=").append(brief);
        sb.append(", price=").append(price);
        sb.append(", priceTag=").append(priceTag);
        sb.append(", discounts=").append(discounts);
        sb.append(", discountsTag=").append(discountsTag);
        sb.append(", courseDescriptionMarkDown=").append(courseDescriptionMarkDown);
        sb.append(", courseDescription=").append(courseDescription);
        sb.append(", courseImgUrl=").append(courseImgUrl);
        sb.append(", isNew=").append(isNew);
        sb.append(", isNewDes=").append(isNewDes);
        sb.append(", lastOperatorId=").append(lastOperatorId);
        sb.append(", autoOnlineTime=").append(autoOnlineTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", totalDuration=").append(totalDuration);
        sb.append(", courseListImg=").append(courseListImg);
        sb.append(", status=").append(status);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", previewFirstField=").append(previewFirstField);
        sb.append(", previewSecondField=").append(previewSecondField);
        sb.append(", sales=").append(sales);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}