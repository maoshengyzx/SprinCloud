package com.ms.edu.dto;

import com.ms.edu.entity.Course;
import com.ms.edu.entity.Teacher;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * ClassName: CourseDTO
 * Package: com.ms.edu.dto
 * Description:
 *
 * @Author ms
 * @Create 2024/6/11 16:40
 * @Version 1.0
 */
@Document(indexName = "course", type = "course", shards = 1, replicas = 0)
public class CourseDTO extends Course {

    @Field(type = FieldType.Integer)
    private Integer teacherId;


    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String teacherName;


    @Field(type = FieldType.Text)
    private String position;

    @Field(type = FieldType.Text)
    private String description;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
