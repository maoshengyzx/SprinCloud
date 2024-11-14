package com.ms.edu.order;

import com.ms.edu.entity.UserCourseOrder0;
import com.ms.edu.order.mapper.UserCourseOrder0Mapper;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class EduOrderApplicationTests {

    @Resource
    private UserCourseOrder0Mapper userCourseOrder0Mapper;

    @Test
    void contextLoads() {
        List<UserCourseOrder0> okOrderCourseIds = userCourseOrder0Mapper.selectList(null);
        System.out.println(okOrderCourseIds);
    }

    @Test
    void InsertCourse() {
        UserCourseOrder0 userCourseOrder0 = new UserCourseOrder0();
        userCourseOrder0.setUserId(1);
        userCourseOrder0.setCourseId(1);
        userCourseOrder0.setOrderNo("123456789");
        userCourseOrder0.setStatus(1);
        userCourseOrder0Mapper.insert(userCourseOrder0);
    }

}
