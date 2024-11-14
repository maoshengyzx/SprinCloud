package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 广告表
 * @TableName promotion_ad
 */
@TableName(value ="promotion_ad")
public class PromotionAd implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 广告名
     */
    private String name;

    /**
     * 广告位id
     */
    private Integer spaceId;

    /**
     * 精确搜索关键词
     */
    private String keyword;

    /**
     * 静态广告的内容
     */
    private String htmlContent;

    /**
     * 文字一
     */
    private String text;

    /**
     * 链接一
     */
    private String link;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer status;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 
     */
    private String img;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 广告名
     */
    public String getName() {
        return name;
    }

    /**
     * 广告名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 广告位id
     */
    public Integer getSpaceId() {
        return spaceId;
    }

    /**
     * 广告位id
     */
    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    /**
     * 精确搜索关键词
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 精确搜索关键词
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 静态广告的内容
     */
    public String getHtmlContent() {
        return htmlContent;
    }

    /**
     * 静态广告的内容
     */
    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    /**
     * 文字一
     */
    public String getText() {
        return text;
    }

    /**
     * 文字一
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 链接一
     */
    public String getLink() {
        return link;
    }

    /**
     * 链接一
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 
     */
    public String getImg() {
        return img;
    }

    /**
     * 
     */
    public void setImg(String img) {
        this.img = img;
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
        PromotionAd other = (PromotionAd) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSpaceId() == null ? other.getSpaceId() == null : this.getSpaceId().equals(other.getSpaceId()))
            && (this.getKeyword() == null ? other.getKeyword() == null : this.getKeyword().equals(other.getKeyword()))
            && (this.getHtmlContent() == null ? other.getHtmlContent() == null : this.getHtmlContent().equals(other.getHtmlContent()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSpaceId() == null) ? 0 : getSpaceId().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getHtmlContent() == null) ? 0 : getHtmlContent().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", spaceId=").append(spaceId);
        sb.append(", keyword=").append(keyword);
        sb.append(", htmlContent=").append(htmlContent);
        sb.append(", text=").append(text);
        sb.append(", link=").append(link);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", priority=").append(priority);
        sb.append(", img=").append(img);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}