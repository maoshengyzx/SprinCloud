package com.ms.edu.dto;

import com.ms.edu.entity.CourseLesson;
import com.ms.edu.entity.CourseMedia;

/**
 * ClassName: CourseLessonDTO
 * Package: com.ms.edu.dto
 * Description:
 *
 * @Author ms
 * @Create 2024/6/17 14:15
 * @Version 1.0
 */
public class CourseLessonDTO extends CourseLesson {
    private CourseMedia courseMedia;


    public CourseMedia getCourseMedia() {
        return courseMedia;
    }

    public void setCourseMedia(CourseMedia courseMedia) {
        this.courseMedia = courseMedia;
    }
}
