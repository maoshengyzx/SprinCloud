package com.ms.edu.dto;

import com.ms.edu.entity.CourseLesson;
import com.ms.edu.entity.CourseSection;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * ClassName: CourseSectionDTO
 * Package: com.ms.edu.dto
 * Description:
 *
 * @Author ms
 * @Create 2024/6/11 16:43
 * @Version 1.0
 */
public class CourseSectionDTO extends CourseSection {

    private List<CourseLessonDTO> courseLessonList;

    public List<CourseLessonDTO> getCourseLessonList() {
        return courseLessonList;
    }

    public void setCourseLessonList(List<CourseLessonDTO> courseLessonList) {
        this.courseLessonList = courseLessonList;
    }
}
