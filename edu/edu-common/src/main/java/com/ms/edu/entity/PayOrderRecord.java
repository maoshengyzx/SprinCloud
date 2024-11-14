package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 支付订单状态日志表
 * @TableName pay_order_record
 */
@TableName(value ="pay_order_record")
public class PayOrderRecord implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 操作类型：CREATE|PAY|REFUND...
     */
    private String type;

    /**
     * 原订单状态
     */
    private String fromStatus;

    /**
     * 新订单状态
     */
    private String toStatus;

    /**
     * 实付金额，单位为分
     */
    private Integer paidAmount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作人
     */
    private String createdBy;

    /**
     * 操作时间
     */
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
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
     * 操作类型：CREATE|PAY|REFUND...
     */
    public String getType() {
        return type;
    }

    /**
     * 操作类型：CREATE|PAY|REFUND...
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 原订单状态
     */
    public String getFromStatus() {
        return fromStatus;
    }

    /**
     * 原订单状态
     */
    public void setFromStatus(String fromStatus) {
        this.fromStatus = fromStatus;
    }

    /**
     * 新订单状态
     */
    public String getToStatus() {
        return toStatus;
    }

    /**
     * 新订单状态
     */
    public void setToStatus(String toStatus) {
        this.toStatus = toStatus;
    }

    /**
     * 实付金额，单位为分
     */
    public Integer getPaidAmount() {
        return paidAmount;
    }

    /**
     * 实付金额，单位为分
     */
    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 操作人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 操作人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 操作时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 操作时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        PayOrderRecord other = (PayOrderRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFromStatus() == null ? other.getFromStatus() == null : this.getFromStatus().equals(other.getFromStatus()))
            && (this.getToStatus() == null ? other.getToStatus() == null : this.getToStatus().equals(other.getToStatus()))
            && (this.getPaidAmount() == null ? other.getPaidAmount() == null : this.getPaidAmount().equals(other.getPaidAmount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFromStatus() == null) ? 0 : getFromStatus().hashCode());
        result = prime * result + ((getToStatus() == null) ? 0 : getToStatus().hashCode());
        result = prime * result + ((getPaidAmount() == null) ? 0 : getPaidAmount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", fromStatus=").append(fromStatus);
        sb.append(", toStatus=").append(toStatus);
        sb.append(", paidAmount=").append(paidAmount);
        sb.append(", remark=").append(remark);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}