package com.ms.edu.service;

import com.github.pagehelper.PageInfo;
import com.ms.edu.dto.CourseCommentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: CommentFegin
 * Package: com.ms.edu.service
 * Description:
 *
 * @Author ms
 * @Create 2024/6/17 15:38
 * @Version 1.0
 */
@FeignClient("edu-comment")
public interface CommentFegin {

    @GetMapping("/comment/getCourseComment/{courseId}")
    String getComment(@PathVariable("courseId") Long courseId, @RequestParam Integer pageNum, @RequestParam Integer pageSize);

    @GetMapping("/comment/saveCourseComment")
    void saveCourseComment(@RequestParam Integer courseId, @RequestParam String comment, @RequestParam String userName, @RequestParam Integer userId);

    @GetMapping("/comment/saveFavorite")
    void saveCourseCommentLike(@RequestParam Integer commentId, @RequestParam Integer userId);

    @GetMapping("/comment/cancelFavorite")
    void cancelCourseCommentLike(@RequestParam Integer commentId, @RequestParam Integer userId);

    @DeleteMapping("/comment/deleteComment")
    void deleteComment(@RequestParam Integer commentId);
}
