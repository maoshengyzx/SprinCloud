package com.ms.edu.service;

import com.ms.edu.dto.CourseDTO;
import com.ms.edu.dto.CourseSectionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * ClassName: CourseFegin
 * Package: com.ms.edu.service
 * Description:
 *
 * @Author ms
 * @Create 2024/6/11 15:55
 * @Version 1.0
 */
@FeignClient(value = "edu-course")
public interface CourseFegin {

    @GetMapping("/course/list")
    List<CourseDTO> list();


    @GetMapping("/course/getCourseSection/{courseId}")
    List<CourseSectionDTO> getCourseSection(@PathVariable("courseId") int courseId);

    @GetMapping("/course/getCourseMedia")
    List<CourseSectionDTO> getCourseMedia(@RequestParam Integer courseId ,@RequestParam Integer lessonId);


    @GetMapping("/course/getMyCoursesById")
    String getMyCoursesById(@RequestParam String courseIds, @RequestParam Integer pageNum, @RequestParam Integer pageSize);

    @GetMapping("/course/updateCourseBuyNum")
    void updateCourseBuyNum(@RequestParam Integer courseId);
}
