package com.ms.edu.comment.mapper;

import com.ms.edu.dto.CourseCommentDTO;
import com.ms.edu.entity.CourseComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
* @author Administrator
* @description 针对表【course_comment(课程留言表)】的数据库操作Mapper
* @createDate 2024-06-17 15:51:50
* @Entity com.ms.edu.entity.CourseComment
*/
public interface CourseCommentMapper extends BaseMapper<CourseComment> {

    List<CourseCommentDTO> getCourseComment(@Param("courseId") Long courseId,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
}




