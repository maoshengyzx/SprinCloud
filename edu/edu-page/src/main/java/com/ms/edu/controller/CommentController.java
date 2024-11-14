package com.ms.edu.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.edu.dto.CourseCommentDTO;
import com.ms.edu.entity.User;
import com.ms.edu.service.CommentFegin;
import com.ms.edu.service.UserFegin;
import com.ms.edu.utils.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: CommentController
 * Package: com.ms.edu.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/17 15:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/page")
public class CommentController {

    @Resource
    private CommentFegin commentFegin;

    @Resource
    private UserFegin userFegin;


    /**
     * 查询帖子评论
     *
     * @param courseId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/courseComment/{courseId}")
    public ApiResponse getComment(@PathVariable("courseId") Long courseId, Integer pageNum, Integer pageSize) throws IOException {
        String jsonResponse = commentFegin.getComment(courseId, pageNum, pageSize);
        // 使用 Jackson ObjectMapper 解析 JSON 响应
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseMap = objectMapper.readValue(jsonResponse, new TypeReference<Map<String, Object>>() {});

       // 获取评论列表和总数
        List<Map<String, Object>> commentListMap = (List<Map<String, Object>>) responseMap.get("list");
        Integer total = (int) responseMap.get("total");

        // 将 Map 转换为 CourseCommentDTO 对象列表
        List<CourseCommentDTO> commentList = new ArrayList<>();
        for (Map<String, Object> commentMap : commentListMap) {
            CourseCommentDTO comment = objectMapper.convertValue(commentMap, CourseCommentDTO.class);
            commentList.add(comment);
        }
        // 设置评论总数
        commentList.stream().forEach(item -> {
            User userInfo = userFegin.getUserInfo(item.getUserId());
            item.setUserPortrait(userInfo.getPortrait());
        });
        HashMap map = new HashMap();
        map.put("total", total);
        map.put("list", commentList);
        return ApiResponse.success(map);
    }

    /**
     * 新增课程回复
     */
    @GetMapping("/comment/saveCourseComment")
    public ApiResponse saveCourseComment(Integer courseId, String comment, String userName, Integer userId) {
        commentFegin.saveCourseComment(courseId, comment, userName, userId);
        return ApiResponse.success();
    }


    /**
     * 回复点赞
     */
    @GetMapping("/comment/saveCourseCommentLike")
    public ApiResponse saveCourseCommentLike(Integer commentId, Integer userId) {
        commentFegin.saveCourseCommentLike(commentId, userId);
        return ApiResponse.success();
    }


    /**
     * 取消点赞
     */
    @GetMapping("/comment/cancelCourseCommentLike")
    public ApiResponse cancelCourseCommentLike(Integer commentId, Integer userId) {
        commentFegin.cancelCourseCommentLike(commentId, userId);
        return ApiResponse.success();
    }


    @DeleteMapping("/comment/deleteCourseComment")
    public ApiResponse deleteCourseComment(Integer commentId) {
        commentFegin.deleteComment(commentId);
        return ApiResponse.success();
    }
}
