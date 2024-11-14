package com.ms.edu.controller;

import com.ms.edu.entity.UserCourseOrder0;
import com.ms.edu.service.CourseFegin;
import com.ms.edu.service.OrderFeign;
import com.ms.edu.service.PayFegin;
import com.ms.edu.utils.ApiResponse;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: OrderController
 * Package: com.ms.edu.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/19 19:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/page")
public class OrderController {

    @Resource
    private OrderFeign orderFeign;

    @Resource
    private PayFegin payFegin;

    @Resource
    private CourseFegin courseFeign;

    @GetMapping("/order/updateOrder")
//    @GlobalTransactional(rollbackFor = Exception.class)
    public ApiResponse updateOrder(UserCourseOrder0 userCourseOrder0) {
        // 插入订单数据
        orderFeign.insertOrder(userCourseOrder0);
        userCourseOrder0.setStatus(2);
        // 更新订单状态
        payFegin.updateOrderStatus(userCourseOrder0);


        // 更新课程已购数量
        courseFeign.updateCourseBuyNum(userCourseOrder0.getCourseId());

        return ApiResponse.success();
    }

    @GetMapping("/order/getOKOrderCourseIds")
    public ApiResponse getOKOrderCourseIds(Integer userId) {
        return ApiResponse.success(orderFeign.getOKOrderCourseIds(userId));
    }


}
