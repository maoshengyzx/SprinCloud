package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户课程订单表
 * @TableName user_course_order_1
 */
@TableName(value ="user_course_order_1")
public class UserCourseOrder1 implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 课程id，根据订单中的课程类型来选择
     */
    private Integer courseId;

    /**
     * 活动课程id
     */
    private Integer activityCourseId;

    /**
     * 订单来源类型: 1 用户下单购买 2 后台添加专栏
     */
    private Integer sourceType;

    /**
     * 当前状态: 0已创建 10未支付 20已支付 30已取消 40已过期 
     */
    private Integer status;

    /**
     * 创建时间
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
     * 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
     * 课程id，根据订单中的课程类型来选择
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 课程id，根据订单中的课程类型来选择
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 活动课程id
     */
    public Integer getActivityCourseId() {
        return activityCourseId;
    }

    /**
     * 活动课程id
     */
    public void setActivityCourseId(Integer activityCourseId) {
        this.activityCourseId = activityCourseId;
    }

    /**
     * 订单来源类型: 1 用户下单购买 2 后台添加专栏
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     * 订单来源类型: 1 用户下单购买 2 后台添加专栏
     */
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 当前状态: 0已创建 10未支付 20已支付 30已取消 40已过期 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 当前状态: 0已创建 10未支付 20已支付 30已取消 40已过期 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
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
        UserCourseOrder1 other = (UserCourseOrder1) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getActivityCourseId() == null ? other.getActivityCourseId() == null : this.getActivityCourseId().equals(other.getActivityCourseId()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getActivityCourseId() == null) ? 0 : getActivityCourseId().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", orderNo=").append(orderNo);
        sb.append(", userId=").append(userId);
        sb.append(", courseId=").append(courseId);
        sb.append(", activityCourseId=").append(activityCourseId);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}