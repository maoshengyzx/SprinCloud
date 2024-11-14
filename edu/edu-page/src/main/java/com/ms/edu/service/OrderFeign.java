package com.ms.edu.service;

import com.ms.edu.dto.CourseDTO;
import com.ms.edu.entity.UserCourseOrder0;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ClassName: OrderFgien
 * Package: com.ms.edu.service
 * Description:
 *
 * @Author ms
 * @Create 2024/6/19 19:38
 * @Version 1.0
 */
@FeignClient("edu-order")
public interface OrderFeign {

    @GetMapping("/order/insertOrder")
    public void insertOrder(@SpringQueryMap UserCourseOrder0 userCourseOrder0);

    @GetMapping("/order/getOKOrderCourseIds")
    List<Integer> getOKOrderCourseIds(@RequestParam Integer userId);



}
