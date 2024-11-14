package com.ms.edu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ms.edu.entity.User;
import com.ms.edu.mapper.UserMapper;
import com.ms.edu.oss.AliOSSUtils;
import com.ms.edu.utils.AppJwtUtil;
import com.ms.edu.utils.RedisUtil;
import com.ms.edu.utils.SaltMD5Util;
import com.ms.edu.vo.UserVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: UserController
 * Package: com.ms.edu.user.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/12 9:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisUtil redisUtil;


    @GetMapping("/login")
    public Map userLogin(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone, user.getPhone());
        User one = userMapper.selectOne(queryWrapper);
        HashMap map = new HashMap();
        if (one == null) {
            user.setPassword(SaltMD5Util.generateSaltPassword(user.getPassword()));
            userMapper.insert(user);
            String token = AppJwtUtil.getToken(user.getId().longValue());
            redisUtil.set("token", token);
            map.put("token", token);
            map.put("user", userMapper.selectOne(queryWrapper));
            return map;
        } else {
            if (SaltMD5Util.verifySaltPassword(user.getPassword(), one.getPassword())) {
                User user1 = userMapper.selectOne(queryWrapper);
                if (user1 != null) {
                    String token = AppJwtUtil.getToken(user1.getId().longValue());
                    redisUtil.set("token", token);
                    map.put("token", token);
                    map.put("user", user1);
                    return map;
                }
            }
        }
        return null;
    }


    /**
     * 用户 图片上传 并存到阿里云校
     *
     * @return 新增结果
     */
    @PostMapping("/uploadFile")
    public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam int userId) throws IOException {
        System.out.println(userId);
        if (!file.isEmpty()) {
            InputStream inputStream = file.getInputStream();
            String avatar = AliOSSUtils.UploadOSS("WindImage/" + file.getOriginalFilename(), inputStream);
            User user = new User();
            user.setId(userId);
            user.setPortrait(avatar);
            userMapper.updateById(user);
            return avatar;
        }
        return null;
    }

    /**
     * 更新用户信息
     * @param vo
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/updateUser")
    public User updateUser(UserVO vo) throws InterruptedException {
        Thread.sleep(1000);
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        if (!StringUtils.isBlank(vo.getNewName())) {
            updateWrapper.eq(User::getId, vo.getUserId()).set(User::getName, vo.getNewName());
            userMapper.update(vo, updateWrapper);
        }
        return userMapper.selectById(vo.getUserId());
    }


    /**
     * 修改密码操作
     * @param userVO
     * @return
     */
    @GetMapping("/updateUserPassword")
    public User updateUserPassword(UserVO userVO) {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        userVO.setPassword(SaltMD5Util.generateSaltPassword(userVO.getPassword()));
        updateWrapper.eq(User::getId, userVO.getUserId()).set(User::getPassword, userVO.getPassword());
        userMapper.update(userVO, updateWrapper);
        return userMapper.selectById(userVO.getUserId());
    }

    @GetMapping("/getUserInfo")
    public User getUserInfo(Integer userId) {
        return userMapper.selectById(userId);
    }
}
