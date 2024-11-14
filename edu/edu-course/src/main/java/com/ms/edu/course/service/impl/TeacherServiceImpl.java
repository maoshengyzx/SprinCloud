package com.ms.edu.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.edu.entity.Teacher;
import com.ms.edu.course.service.TeacherService;
import com.ms.edu.course.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【teacher(讲师表)】的数据库操作Service实现
* @createDate 2024-06-11 15:47:26
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

}




