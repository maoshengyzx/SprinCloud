package com.ms.edu.controller;

import com.ms.edu.entity.User;
import com.ms.edu.service.UploadClient;
import com.ms.edu.service.UserFegin;
import com.ms.edu.utils.ApiResponse;
import com.ms.edu.utils.RedisUtil;
import com.ms.edu.vo.UserVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: UserController
 * Package: com.ms.edu.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/12 9:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/page")
public class UserController {

    @Resource
    private UserFegin userFegin;

    @Resource
    private UploadClient uploadClient;

    @Resource
    private RedisUtil redisUtil;


    @RequestMapping("/userLogin")
    public ApiResponse user(User user) {
        return ApiResponse.success(userFegin.userLogin(user));
    }


    /**
     * 个人头像修改
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public ApiResponse upload(@RequestPart("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        return ApiResponse.success(uploadClient.fileUpload(file, userId));
    }

    /**
     * 更新用户信息
     * @param userVO
     * @return
     */
    @GetMapping("/updateUser")
    public ApiResponse updateUser(UserVO userVO) {
        return ApiResponse.success(userFegin.updata(userVO));
    }

    /**
     * 修改密码
     * @param userVO
     * @return
     */
    @GetMapping("/updatePwd")
    public ApiResponse updatePwd(UserVO userVO) {
        return ApiResponse.success(userFegin.updateUserPassword(userVO));
    }

    /**
     * 微信扫码登录
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/wxLogin")
    public void wxLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        String string = userFegin.wxLogin(code);
        response.sendRedirect(string);
    }

    /**
     * 检查微信登录状态
     * @return
     */
    @GetMapping("/checkWxStatus")
    public ApiResponse checkWxStatus() {
        return ApiResponse.success(userFegin.checkWxStatus());
    }

}
