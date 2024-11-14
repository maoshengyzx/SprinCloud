package com.ms.edu.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.edu.entity.CourseLesson;
import com.ms.edu.course.service.CourseLessonService;
import com.ms.edu.course.mapper.CourseLessonMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【course_lesson(课程节内容)】的数据库操作Service实现
* @createDate 2024-06-11 15:47:26
*/
@Service
public class CourseLessonServiceImpl extends ServiceImpl<CourseLessonMapper, CourseLesson>
    implements CourseLessonService{

}




