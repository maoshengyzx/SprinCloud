package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName course_play_history
 */
@TableName(value ="course_play_history")
public class CoursePlayHistory implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 章节id
     */
    private Integer sectionId;

    /**
     * 课时id
     */
    private Integer lessonId;

    /**
     * 历史播放节点(s)
     */
    private Integer historyNode;

    /**
     * 最高历史播放节点
     */
    private Integer historyHighestNode;

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
     * 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 课时id
     */
    public Integer getLessonId() {
        return lessonId;
    }

    /**
     * 课时id
     */
    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    /**
     * 历史播放节点(s)
     */
    public Integer getHistoryNode() {
        return historyNode;
    }

    /**
     * 历史播放节点(s)
     */
    public void setHistoryNode(Integer historyNode) {
        this.historyNode = historyNode;
    }

    /**
     * 最高历史播放节点
     */
    public Integer getHistoryHighestNode() {
        return historyHighestNode;
    }

    /**
     * 最高历史播放节点
     */
    public void setHistoryHighestNode(Integer historyHighestNode) {
        this.historyHighestNode = historyHighestNode;
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
        CoursePlayHistory other = (CoursePlayHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getSectionId() == null ? other.getSectionId() == null : this.getSectionId().equals(other.getSectionId()))
            && (this.getLessonId() == null ? other.getLessonId() == null : this.getLessonId().equals(other.getLessonId()))
            && (this.getHistoryNode() == null ? other.getHistoryNode() == null : this.getHistoryNode().equals(other.getHistoryNode()))
            && (this.getHistoryHighestNode() == null ? other.getHistoryHighestNode() == null : this.getHistoryHighestNode().equals(other.getHistoryHighestNode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getSectionId() == null) ? 0 : getSectionId().hashCode());
        result = prime * result + ((getLessonId() == null) ? 0 : getLessonId().hashCode());
        result = prime * result + ((getHistoryNode() == null) ? 0 : getHistoryNode().hashCode());
        result = prime * result + ((getHistoryHighestNode() == null) ? 0 : getHistoryHighestNode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", courseId=").append(courseId);
        sb.append(", sectionId=").append(sectionId);
        sb.append(", lessonId=").append(lessonId);
        sb.append(", historyNode=").append(historyNode);
        sb.append(", historyHighestNode=").append(historyHighestNode);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}