package com.ms.edu.comment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.edu.comment.mapper.CourseCommentFavoriteRecordMapper;
import com.ms.edu.comment.mapper.CourseCommentMapper;
import com.ms.edu.dto.CourseCommentDTO;
import com.ms.edu.entity.CourseComment;
import com.ms.edu.entity.CourseCommentFavoriteRecord;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: CommentController
 * Package: com.ms.edu.comment.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/17 15:54
 * @Version 1.0
 */
@RequestMapping("/comment")
@RestController
public class CommentController {

    @Resource
    private CourseCommentMapper courseCommentMapper;


    @Resource
    private CourseCommentFavoriteRecordMapper courseCommentFavoriteRecordMapper;

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 查询评论
     *
     * @param courseId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getCourseComment/{courseId}")
    public String getCourseComment(@PathVariable("courseId") Long courseId, Integer pageNum, Integer pageSize) throws JsonProcessingException {
        PageHelper.startPage(pageNum, pageSize);
        List<CourseCommentDTO> courseComment = courseCommentMapper.getCourseComment(courseId, (pageNum - 1) * pageSize, pageSize);
        PageInfo<CourseCommentDTO> pageInfo = new PageInfo<>(courseComment);
        HashMap map = new HashMap();
        map.put("list", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        String value = new ObjectMapper().writeValueAsString(map);
        return value;
    }

    /**
     * 发布评论
     *
     * @param courseId
     * @param comment
     * @param userName
     * @param userId
     */
    @GetMapping("saveCourseComment")
    public void saveCourseComment(Integer courseId, String comment, String userName, Integer userId) throws JsonProcessingException {
        CourseComment courseComment = new CourseComment();
        courseComment.setComment(comment);
        courseComment.setUserId(userId);
        courseComment.setUserName(userName);
        courseComment.setCourseId(courseId);
        courseCommentMapper.insert(courseComment);

        // 发送消息到rabbitmq
//        rabbitTemplate.convertAndSend("commentList", new ObjectMapper().writeValueAsString(courseCommentMapper.getCourseComment(Long.valueOf(courseId), 0, 10)));
    }

    /**
     * 点赞
     */
    @GetMapping("saveFavorite")
    @Transactional
    public void saveFavorite(Integer commentId, Integer userId) {
        // 修改赞的数量
        CourseComment courseComment = courseCommentMapper.selectById(commentId);
        courseComment.setLikeCount(courseComment.getLikeCount() + 1);
        courseCommentMapper.updateById(courseComment);
        CourseCommentFavoriteRecord courseCommentFavoriteRecord = courseCommentFavoriteRecordMapper.selectIsDel(commentId, userId);

        if (courseCommentFavoriteRecord == null) {
            // 之前未点赞 未点赞过
            // 添加点赞记录
            CourseCommentFavoriteRecord courseCommentFavoriteRecord1 = new CourseCommentFavoriteRecord();
            courseCommentFavoriteRecord1.setCommentId(commentId);
            courseCommentFavoriteRecord1.setUserId(userId);
            courseCommentFavoriteRecord1.setIsDel(0);
            courseCommentFavoriteRecordMapper.insert(courseCommentFavoriteRecord1);
        } else if (courseCommentFavoriteRecord.getIsDel() == 1) {
            // 之前是取消点赞，记录已经存在 直接更新记录
            // 修改点赞记录
            courseCommentFavoriteRecord.setIsDel(0);
            courseCommentFavoriteRecordMapper.updateById(courseCommentFavoriteRecord);
        }
    }

    /**
     * 取消点赞
     */
    @GetMapping("cancelFavorite")
    @Transactional
    public void deleteFavorite(Integer commentId, Integer userId) {

        // 修改赞的数量
        CourseComment courseComment = courseCommentMapper.selectById(commentId);
        courseComment.setLikeCount(courseComment.getLikeCount() - 1);
        courseCommentMapper.updateById(courseComment);

        // 根据userId、commentId逻辑删除点赞记录  注意是逻辑删除 不是物理删除
        // 查询点赞记录
        CourseCommentFavoriteRecord courseCommentFavoriteRecord = courseCommentFavoriteRecordMapper.selectIsDel(commentId, userId);

        courseCommentFavoriteRecord.setIsDel(1);
        courseCommentFavoriteRecordMapper.updateById(courseCommentFavoriteRecord);
    }


    @DeleteMapping("/deleteCourseComment")
    public void deleteComment(Integer commentId) {
        courseCommentMapper.deleteById(commentId);
    }
}
