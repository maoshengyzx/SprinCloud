package com.ms.edu.course;

import com.ms.edu.course.mapper.CourseMediaMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EduCourseApplicationTests {

    @Resource
    private CourseMediaMapper courseMediaMapper;

    @Test
    void contextLoads() {
        System.out.println(courseMediaMapper.selectList(null));
    }

}
