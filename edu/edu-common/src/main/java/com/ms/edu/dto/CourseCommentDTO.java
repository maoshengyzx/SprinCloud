package com.ms.edu.dto;

import com.ms.edu.entity.CourseComment;
import com.ms.edu.entity.CourseCommentFavoriteRecord;

import java.util.List;

/**
 * ClassName: CourseCommentDTO
 * Package: com.ms.edu.dto
 * Description:
 *
 * @Author ms
 * @Create 2024/6/17 15:57
 * @Version 1.0
 */
public class CourseCommentDTO extends CourseComment {


    private List<CourseCommentFavoriteRecord> favoriteRecord;

    private String userPortrait;

    public List<CourseCommentFavoriteRecord> getFavoriteRecord() {
        return favoriteRecord;
    }

    public void setFavoriteRecord(List<CourseCommentFavoriteRecord> favoriteRecord) {
        this.favoriteRecord = favoriteRecord;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }
}
