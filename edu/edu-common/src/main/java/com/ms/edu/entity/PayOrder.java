package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付订单信息表
 * @TableName pay_order
 */
@TableName(value ="pay_order")
public class PayOrder implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单号(唯一)
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 商品唯一标识(ID)
     */
    private Integer productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 金额,单位元
     */
    private BigDecimal amount;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 货币类型，cny-人民币 gbeans-勾豆
     */
    private String currency;

    /**
     * 支付渠道：weChat-微信支付，aliPay-支付宝支付,applePay-苹果支付
     */
    private String channel;

    /**
     * 订单状态：1-未支付 2-支付成功 3-支付失败 -1-订单失效
     */
    private Integer status;

    /**
     * 渠道中的状态码值
     */
    private Integer channelStatus;

    /**
     * 类型 1-购买课程 2-充值
     */
    private Integer orderType;

    /**
     * 支付来源 1-app 2-h5 3-pc
     */
    private Integer source;

    /**
     * 用户支付IP
     */
    private String clientIp;

    /**
     * 购买账号id
     */
    private String buyId;

    /**
     * 外部支付渠道交易号
     */
    private String outTradeNo;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 附加字段，KV json，例如:{"mobile":13020202,"success_url":123}
     */
    private String extra;

    /**
     * 商品订单编号
     */
    private String goodsOrderNo;

    /**
     * 支付所使用的平台：1 拉勾 2 拉勾教育
     */
    private Integer platform;

    /**
     * 微信类型, 参考自lg-wechat-boot项目中的wxinfo
     */
    private Integer wxType;

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
     * 订单号(唯一)
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号(唯一)
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 商品唯一标识(ID)
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 商品唯一标识(ID)
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 金额,单位元
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 金额,单位元
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 商品数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 商品数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 货币类型，cny-人民币 gbeans-勾豆
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 货币类型，cny-人民币 gbeans-勾豆
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 支付渠道：weChat-微信支付，aliPay-支付宝支付,applePay-苹果支付
     */
    public String getChannel() {
        return channel;
    }

    /**
     * 支付渠道：weChat-微信支付，aliPay-支付宝支付,applePay-苹果支付
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 订单状态：1-未支付 2-支付成功 3-支付失败 -1-订单失效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 订单状态：1-未支付 2-支付成功 3-支付失败 -1-订单失效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 渠道中的状态码值
     */
    public Integer getChannelStatus() {
        return channelStatus;
    }

    /**
     * 渠道中的状态码值
     */
    public void setChannelStatus(Integer channelStatus) {
        this.channelStatus = channelStatus;
    }

    /**
     * 类型 1-购买课程 2-充值
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 类型 1-购买课程 2-充值
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 支付来源 1-app 2-h5 3-pc
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 支付来源 1-app 2-h5 3-pc
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 用户支付IP
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * 用户支付IP
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * 购买账号id
     */
    public String getBuyId() {
        return buyId;
    }

    /**
     * 购买账号id
     */
    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    /**
     * 外部支付渠道交易号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 外部支付渠道交易号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 支付时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 支付时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 附加字段，KV json，例如:{"mobile":13020202,"success_url":123}
     */
    public String getExtra() {
        return extra;
    }

    /**
     * 附加字段，KV json，例如:{"mobile":13020202,"success_url":123}
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }

    /**
     * 商品订单编号
     */
    public String getGoodsOrderNo() {
        return goodsOrderNo;
    }

    /**
     * 商品订单编号
     */
    public void setGoodsOrderNo(String goodsOrderNo) {
        this.goodsOrderNo = goodsOrderNo;
    }

    /**
     * 支付所使用的平台：1 拉勾 2 拉勾教育
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 支付所使用的平台：1 拉勾 2 拉勾教育
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /**
     * 微信类型, 参考自lg-wechat-boot项目中的wxinfo
     */
    public Integer getWxType() {
        return wxType;
    }

    /**
     * 微信类型, 参考自lg-wechat-boot项目中的wxinfo
     */
    public void setWxType(Integer wxType) {
        this.wxType = wxType;
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
        PayOrder other = (PayOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getChannelStatus() == null ? other.getChannelStatus() == null : this.getChannelStatus().equals(other.getChannelStatus()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getClientIp() == null ? other.getClientIp() == null : this.getClientIp().equals(other.getClientIp()))
            && (this.getBuyId() == null ? other.getBuyId() == null : this.getBuyId().equals(other.getBuyId()))
            && (this.getOutTradeNo() == null ? other.getOutTradeNo() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getExtra() == null ? other.getExtra() == null : this.getExtra().equals(other.getExtra()))
            && (this.getGoodsOrderNo() == null ? other.getGoodsOrderNo() == null : this.getGoodsOrderNo().equals(other.getGoodsOrderNo()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getWxType() == null ? other.getWxType() == null : this.getWxType().equals(other.getWxType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getChannelStatus() == null) ? 0 : getChannelStatus().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getClientIp() == null) ? 0 : getClientIp().hashCode());
        result = prime * result + ((getBuyId() == null) ? 0 : getBuyId().hashCode());
        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getExtra() == null) ? 0 : getExtra().hashCode());
        result = prime * result + ((getGoodsOrderNo() == null) ? 0 : getGoodsOrderNo().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getWxType() == null) ? 0 : getWxType().hashCode());
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
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", amount=").append(amount);
        sb.append(", count=").append(count);
        sb.append(", currency=").append(currency);
        sb.append(", channel=").append(channel);
        sb.append(", status=").append(status);
        sb.append(", channelStatus=").append(channelStatus);
        sb.append(", orderType=").append(orderType);
        sb.append(", source=").append(source);
        sb.append(", clientIp=").append(clientIp);
        sb.append(", buyId=").append(buyId);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", extra=").append(extra);
        sb.append(", goodsOrderNo=").append(goodsOrderNo);
        sb.append(", platform=").append(platform);
        sb.append(", wxType=").append(wxType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}