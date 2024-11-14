package com.ms.edu.vo;

import com.ms.edu.entity.PayOrder;

/**
 * ClassName: OrderVO
 * Package: com.ms.edu.vo
 * Description:
 *
 * @Author ms
 * @Create 2024/6/19 15:54
 * @Version 1.0
 */
public class PayVO extends PayOrder {

    private String orderNo;

    private Integer userId;

    private Integer courseId;

    private Integer activityCourseId;


    private Integer sourceType;


    private String price;


    @Override
    public String getOrderNo() {
        return orderNo;
    }

    @Override
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getActivityCourseId() {
        return activityCourseId;
    }

    public void setActivityCourseId(Integer activityCourseId) {
        this.activityCourseId = activityCourseId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
