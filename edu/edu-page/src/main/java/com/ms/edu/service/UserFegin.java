package com.ms.edu.service;

import com.ms.edu.dto.CourseDTO;
import com.ms.edu.entity.User;
import com.ms.edu.vo.UserVO;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * ClassName: UserFegin
 * Package: com.ms.edu.service
 * Description:
 *
 * @Author ms
 * @Create 2024/6/12 9:46
 * @Version 1.0
 */
@FeignClient(value = "edu-user", contextId = "userFegin")
@RefreshScope
public interface UserFegin {

    @GetMapping("/user/login")
    public Map userLogin(@SpringQueryMap User user);

    @GetMapping("/user/updateUser")
    public User updata(@SpringQueryMap UserVO userVO);

    @GetMapping("/user/updateUserPassword")
    public User updateUserPassword(@SpringQueryMap UserVO userVO);

    @GetMapping("/user/wxLogin")
    public String wxLogin(@RequestParam String code);

    @GetMapping("/user/checkWxStatus")
    public Map checkWxStatus();

    @GetMapping("/user/getUserInfo")
    User getUserInfo(@RequestParam Integer userId);


}
