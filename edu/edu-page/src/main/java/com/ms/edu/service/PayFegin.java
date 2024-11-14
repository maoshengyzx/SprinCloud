package com.ms.edu.service;

import com.ms.edu.entity.UserCourseOrder0;
import com.ms.edu.vo.PayVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * ClassName: OrderFegin
 * Package: com.ms.edu.service
 * Description:
 *
 * @Author ms
 * @Create 2024/6/19 15:05
 * @Version 1.0
 */
@FeignClient(value = "edu-pay")
public interface PayFegin {

    @GetMapping("/pay/createCode")
    Map getCode(@RequestParam Integer courseId, @RequestParam String courseName, @RequestParam String price,@RequestParam Integer userId);

    @RequestMapping("/pay/wxCallBack")
    String wxCallBack();

    @RequestMapping("/pay/saveOrder")
    void saveOrder(@SpringQueryMap PayVO orderVO);

    @RequestMapping("/pay/checkOrderStatus")
    Map<String, String> checkOrderStatus(@RequestParam String orderId);

    @RequestMapping("/pay/updateOrder")
    void updateOrderStatus(@SpringQueryMap UserCourseOrder0 vo);

    @RequestMapping("/pay/deleteOrder")
    void deleteOrder(@RequestParam String orderNo);
}
