package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程节内容
 * @TableName course_lesson
 */
@TableName(value ="course_lesson")
public class CourseLesson implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 章节id
     */
    private Integer sectionId;

    /**
     * 课时主题
     */
    private String theme;

    /**
     * 课时时长(分钟)
     */
    private Integer duration;

    /**
     * 是否免费
     */
    private Integer isFree;

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
     * 排序字段
     */
    private Integer orderNum;

    /**
     * 课时状态,0-隐藏，1-未发布，2-已发布
     */
    private Integer status;

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
     * 课程id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 课程id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 章节id
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * 章节id
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * 课时主题
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 课时主题
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * 课时时长(分钟)
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 课时时长(分钟)
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 是否免费
     */
    public Integer getIsFree() {
        return isFree;
    }

    /**
     * 是否免费
     */
    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
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
     * 排序字段
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 排序字段
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 课时状态,0-隐藏，1-未发布，2-已发布
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 课时状态,0-隐藏，1-未发布，2-已发布
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        CourseLesson other = (CourseLesson) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getSectionId() == null ? other.getSectionId() == null : this.getSectionId().equals(other.getSectionId()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getIsFree() == null ? other.getIsFree() == null : this.getIsFree().equals(other.getIsFree()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getSectionId() == null) ? 0 : getSectionId().hashCode());
        result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getIsFree() == null) ? 0 : getIsFree().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseId=").append(courseId);
        sb.append(", sectionId=").append(sectionId);
        sb.append(", theme=").append(theme);
        sb.append(", duration=").append(duration);
        sb.append(", isFree=").append(isFree);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}