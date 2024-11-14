package com.ms.edu.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.edu.entity.Course;
import com.ms.edu.course.service.CourseService;
import com.ms.edu.course.mapper.CourseMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【course(课程)】的数据库操作Service实现
* @createDate 2024-06-11 15:47:26
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

}




