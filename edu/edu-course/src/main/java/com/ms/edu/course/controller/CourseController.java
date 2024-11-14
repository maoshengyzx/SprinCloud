package com.ms.edu.course.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.edu.course.mapper.CourseMapper;
import com.ms.edu.dto.CourseDTO;
import com.ms.edu.dto.CourseSectionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: CourseController
 * Package: com.ms.edu.course.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/11 15:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseMapper courseMapper;

    /**
     * 获取所有课程
     *
     * @return
     */
    @GetMapping("/list")
    public List<CourseDTO> list() {
        List<CourseDTO> courses = courseMapper.selectCourse();
        return courses;
    }

    /**
     * 获取课程下的所有章节
     *
     * @param courseId
     * @return
     */
    @GetMapping("/getCourseSection/{courseId}")
    public List<CourseSectionDTO> getCourseSection(@PathVariable("courseId") int courseId) {
        return courseMapper.selectCourseSectionByCourseId(courseId);
    }


    /**
     * 查询课程视频信息
     *
     * @param courseId
     * @param lessonId
     * @return
     */
    @GetMapping("/getCourseMedia")
    public List<CourseSectionDTO> getCourseMedia(Integer courseId, Integer lessonId) {
        return courseMapper.selectCourseMediaByCourseIdAndLessonId(courseId, lessonId);
    }

    /**
     * 查询个人已购课程信息
     *
     * @param courseIds
     * @param pageNum
     * @param pageSize
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/getMyCoursesById")
    public String getMyCoursesById(String courseIds, Integer pageNum, Integer pageSize) throws JsonProcessingException {
        List<Integer> courseValues = extractCourseValues(courseIds);
        PageHelper.startPage(pageNum, pageSize);
        List<CourseDTO> list = courseMapper.getMyCoursesByIds(courseValues);
        PageInfo<CourseDTO> pageInfo = new PageInfo<>(list);
        HashMap map = new HashMap();
        map.put("list", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    /**
     * 更新课程购买数量
     * @param courseId
     */
    @GetMapping("updateCourseBuyNum")
    public void updateCourseBuyNum(Integer courseId) {
        courseMapper.updateCourseBuyNum(courseId);
    }

    public List<Integer> extractCourseValues(String courseIds) {
        List<Integer> courseValues = new ArrayList<>();

        if (courseIds != null && !courseIds.isEmpty()) {
            Pattern pattern = Pattern.compile("=(\\d+)");
            Matcher matcher = pattern.matcher(courseIds);

            while (matcher.find()) {
                try {
                    int value = Integer.parseInt(matcher.group(1));
                    courseValues.add(value);
                } catch (NumberFormatException e) {
                    System.out.println("无法将字符串转换为整数：" + e.getMessage());
                }
            }
        }

        return courseValues;
    }
}
