package com.ms.edu.order.mapper;

import com.ms.edu.dto.CourseDTO;
import com.ms.edu.entity.UserCourseOrder0;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user_course_order_0(用户课程订单表)】的数据库操作Mapper
* @createDate 2024-06-19 18:56:35
* @Entity com.ms.edu.entity.UserCourseOrder0
*/
public interface UserCourseOrder0Mapper extends BaseMapper<UserCourseOrder0> {

    void insertOrder(UserCourseOrder0 order0);

    List<Integer> getOKOrderCourseIds(Integer userId);


//    List<CourseDTO> getMyCoursesById(String courseIds);
}




