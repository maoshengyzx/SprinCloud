package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程章节表
 *
 * @TableName course_section
 */
@TableName(value = "course_section")
public class CourseSection implements Serializable {
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
     * 章节名
     */
    private String sectionName;

    /**
     * 章节描述
     */
    private String description;

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
    private Integer isDe;

    /**
     * 排序字段
     */
    private Integer orderNum;

    /**
     * 状态，0:隐藏；1：待更新；2：已发布
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
     * 章节名
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * 章节名
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * 章节描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 章节描述
     */
    public void setDescription(String description) {
        this.description = description;
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
    public Integer getIsDe() {
        return isDe;
    }

    /**
     * 是否删除
     */
    public void setIsDe(Integer isDe) {
        this.isDe = isDe;
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
     * 状态，0:隐藏；1：待更新；2：已发布
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态，0:隐藏；1：待更新；2：已发布
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
        CourseSection other = (CourseSection) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
                && (this.getSectionName() == null ? other.getSectionName() == null : this.getSectionName().equals(other.getSectionName()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getIsDe() == null ? other.getIsDe() == null : this.getIsDe().equals(other.getIsDe()))
                && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getSectionName() == null) ? 0 : getSectionName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDe() == null) ? 0 : getIsDe().hashCode());
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
        sb.append(", sectionName=").append(sectionName);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDe=").append(isDe);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}