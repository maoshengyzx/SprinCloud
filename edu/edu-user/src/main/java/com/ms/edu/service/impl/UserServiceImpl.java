package com.ms.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.edu.entity.User;
import com.ms.edu.service.UserService;
import com.ms.edu.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-06-12 09:29:46
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




