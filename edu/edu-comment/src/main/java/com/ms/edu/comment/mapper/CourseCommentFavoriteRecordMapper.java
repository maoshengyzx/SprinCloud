package com.ms.edu.comment.mapper;

import com.ms.edu.entity.CourseCommentFavoriteRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【course_comment_favorite_record(课程留言点赞表)】的数据库操作Mapper
* @createDate 2024-06-17 15:51:50
* @Entity com.ms.edu.entity.CourseCommentFavoriteRecord
*/
public interface CourseCommentFavoriteRecordMapper extends BaseMapper<CourseCommentFavoriteRecord> {


    CourseCommentFavoriteRecord selectIsDel(Integer commentId, Integer userId);
}




