package com.ms.edu.order.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ms.edu.entity.UserCourseOrder0;
import com.ms.edu.order.mapper.UserCourseOrder0Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: OrderController
 * Package: com.ms.edu.order.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/19 18:58
 * @Version 1.0
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    private UserCourseOrder0Mapper userCourseOrder0Mapper;


    @GetMapping("/insertOrder")
    public void insertOrder(UserCourseOrder0 order0) {
        LambdaQueryWrapper<UserCourseOrder0> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCourseOrder0::getUserId, order0.getUserId());
        queryWrapper.eq(UserCourseOrder0::getCourseId, order0.getCourseId());
        UserCourseOrder0 list = userCourseOrder0Mapper.selectOne(queryWrapper);
        if (list == null) {
//            userCourseOrder0Mapper.insertOrder(order0);
            userCourseOrder0Mapper.insert(order0);
        }
    }

    @GetMapping("/getOKOrderCourseIds")
    public List<Integer> getOKOrderCourseIds(Integer userId) {
        return userCourseOrder0Mapper.getOKOrderCourseIds(userId);
    }


}
