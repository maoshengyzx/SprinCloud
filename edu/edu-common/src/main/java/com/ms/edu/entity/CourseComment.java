package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程留言表
 * @TableName course_comment
 */
@TableName(value ="course_comment")
public class CourseComment implements Serializable {
    /**
     * 主键
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
     * 课时id
     */
    private Integer lessonId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 运营设置用户昵称
     */
    private String userName;

    /**
     * 父级评论id
     */
    private Integer parentId;

    /**
     * 是否置顶：0不置顶，1置顶
     */
    private Integer isTop;

    /**
     * 评论
     */
    private String comment;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 是否回复留言：0普通留言，1回复留言
     */
    private Integer isReply;

    /**
     * 留言类型：0用户留言，1讲师留言，2运营马甲 3讲师回复 4小编回复 5官方客服回复
     */
    private Integer type;

    /**
     * 留言状态：0待审核，1审核通过，2审核不通过，3已删除
     */
    private Integer status;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 记录更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 最后操作者id
     */
    private Integer lastOperator;

    /**
     * 是否发送了通知,1表示未发出，0表示已发出
     */
    private Integer isNotify;

    /**
     * 标记归属
     */
    private Integer markBelong;

    /**
     * 回复状态 0 未回复 1 已回复
     */
    private Integer replied;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
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
     * 运营设置用户昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 运营设置用户昵称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 父级评论id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级评论id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 是否置顶：0不置顶，1置顶
     */
    public Integer getIsTop() {
        return isTop;
    }

    /**
     * 是否置顶：0不置顶，1置顶
     */
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    /**
     * 评论
     */
    public String getComment() {
        return comment;
    }

    /**
     * 评论
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 点赞数
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * 点赞数
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * 是否回复留言：0普通留言，1回复留言
     */
    public Integer getIsReply() {
        return isReply;
    }

    /**
     * 是否回复留言：0普通留言，1回复留言
     */
    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }

    /**
     * 留言类型：0用户留言，1讲师留言，2运营马甲 3讲师回复 4小编回复 5官方客服回复
     */
    public Integer getType() {
        return type;
    }

    /**
     * 留言类型：0用户留言，1讲师留言，2运营马甲 3讲师回复 4小编回复 5官方客服回复
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 留言状态：0待审核，1审核通过，2审核不通过，3已删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 留言状态：0待审核，1审核通过，2审核不通过，3已删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 注册时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 记录更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 记录更新时间
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
     * 最后操作者id
     */
    public Integer getLastOperator() {
        return lastOperator;
    }

    /**
     * 最后操作者id
     */
    public void setLastOperator(Integer lastOperator) {
        this.lastOperator = lastOperator;
    }

    /**
     * 是否发送了通知,1表示未发出，0表示已发出
     */
    public Integer getIsNotify() {
        return isNotify;
    }

    /**
     * 是否发送了通知,1表示未发出，0表示已发出
     */
    public void setIsNotify(Integer isNotify) {
        this.isNotify = isNotify;
    }

    /**
     * 标记归属
     */
    public Integer getMarkBelong() {
        return markBelong;
    }

    /**
     * 标记归属
     */
    public void setMarkBelong(Integer markBelong) {
        this.markBelong = markBelong;
    }

    /**
     * 回复状态 0 未回复 1 已回复
     */
    public Integer getReplied() {
        return replied;
    }

    /**
     * 回复状态 0 未回复 1 已回复
     */
    public void setReplied(Integer replied) {
        this.replied = replied;
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
        CourseComment other = (CourseComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getSectionId() == null ? other.getSectionId() == null : this.getSectionId().equals(other.getSectionId()))
            && (this.getLessonId() == null ? other.getLessonId() == null : this.getLessonId().equals(other.getLessonId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getIsTop() == null ? other.getIsTop() == null : this.getIsTop().equals(other.getIsTop()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getLikeCount() == null ? other.getLikeCount() == null : this.getLikeCount().equals(other.getLikeCount()))
            && (this.getIsReply() == null ? other.getIsReply() == null : this.getIsReply().equals(other.getIsReply()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getLastOperator() == null ? other.getLastOperator() == null : this.getLastOperator().equals(other.getLastOperator()))
            && (this.getIsNotify() == null ? other.getIsNotify() == null : this.getIsNotify().equals(other.getIsNotify()))
            && (this.getMarkBelong() == null ? other.getMarkBelong() == null : this.getMarkBelong().equals(other.getMarkBelong()))
            && (this.getReplied() == null ? other.getReplied() == null : this.getReplied().equals(other.getReplied()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getSectionId() == null) ? 0 : getSectionId().hashCode());
        result = prime * result + ((getLessonId() == null) ? 0 : getLessonId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getIsTop() == null) ? 0 : getIsTop().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getLikeCount() == null) ? 0 : getLikeCount().hashCode());
        result = prime * result + ((getIsReply() == null) ? 0 : getIsReply().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getLastOperator() == null) ? 0 : getLastOperator().hashCode());
        result = prime * result + ((getIsNotify() == null) ? 0 : getIsNotify().hashCode());
        result = prime * result + ((getMarkBelong() == null) ? 0 : getMarkBelong().hashCode());
        result = prime * result + ((getReplied() == null) ? 0 : getReplied().hashCode());
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
        sb.append(", lessonId=").append(lessonId);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", parentId=").append(parentId);
        sb.append(", isTop=").append(isTop);
        sb.append(", comment=").append(comment);
        sb.append(", likeCount=").append(likeCount);
        sb.append(", isReply=").append(isReply);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", lastOperator=").append(lastOperator);
        sb.append(", isNotify=").append(isNotify);
        sb.append(", markBelong=").append(markBelong);
        sb.append(", replied=").append(replied);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}