package com.ms.edu.course.mapper;

import com.ms.edu.dto.CourseDTO;
import com.ms.edu.dto.CourseSectionDTO;
import com.ms.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ms.edu.entity.CourseMedia;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【course(课程)】的数据库操作Mapper
* @createDate 2024-06-11 15:47:26
* @Entity com.ms.edu.entity.Course
*/
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 查询全部课程
     * @return
     */
    List<CourseDTO> selectCourse();

    /**
     * 查询课程对于的章节信息
     * @param courseId
     * @return
     */
    List<CourseSectionDTO> selectCourseSectionByCourseId(int courseId);

    List<CourseSectionDTO> selectCourseMediaByCourseIdAndLessonId(@Param("courseId") Integer courseId,@Param("lessonId") Integer lessonId);

    List<CourseDTO> getMyCoursesByIds(@Param("courseValues") List<Integer> courseValues);

    void updateCourseBuyNum(Integer courseId);
}




