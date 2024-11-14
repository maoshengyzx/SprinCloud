package com.ms.edu.comment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.edu.comment.mapper.CourseCommentMapper;
import com.ms.edu.comment.service.CourseCommentService;
import com.ms.edu.entity.CourseComment;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【course_comment(课程留言表)】的数据库操作Service实现
* @createDate 2024-06-17 15:51:50
*/
@Service
public class CourseCommentServiceImpl extends ServiceImpl<CourseCommentMapper, CourseComment>
    implements CourseCommentService {

}




