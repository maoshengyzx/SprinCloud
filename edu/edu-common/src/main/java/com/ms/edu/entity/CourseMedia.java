package com.ms.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

/**
 * 课节视频表
 * @TableName course_media
 */
@TableName(value ="course_media")
public class CourseMedia implements Serializable {
    /**
     * 课程媒体主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer mediaId;

    /**
     * 课程Id
     */
    private Integer courseId;

    /**
     * 章ID
     */
    private Integer sectionId;

    /**
     * 课时ID
     */
    private Integer lessonId;

    /**
     * 封面图URL
     */
    private String coverImageUrl;

    /**
     * 时长（06:02）
     */
    private Time mediaDuration;

    /**
     * 媒体资源文件对应的EDK
     */
    private String fileEdk;

    /**
     * 文件大小MB
     */
    private Double fileSize;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 媒体资源文件对应的DK
     */
    private String fileDk;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除，0未删除，1删除
     */
    private Integer isDel;

    /**
     * 时长，秒数（主要用于音频在H5控件中使用）
     */
    private Integer durationNum;

    /**
     * 媒体资源文件ID
     */

    private String fileId;

    public CourseMedia() {
    }


    public Time getMediaDuration() {
        return mediaDuration;
    }

    public void setMediaDuration(Time mediaDuration) {
        this.mediaDuration = mediaDuration;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 课程Id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 课程Id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 章ID
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * 章ID
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * 课时ID
     */
    public Integer getLessonId() {
        return lessonId;
    }

    /**
     * 课时ID
     */
    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    /**
     * 封面图URL
     */
    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    /**
     * 封面图URL
     */
    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }



    /**
     * 媒体资源文件对应的EDK
     */
    public String getFileEdk() {
        return fileEdk;
    }

    /**
     * 媒体资源文件对应的EDK
     */
    public void setFileEdk(String fileEdk) {
        this.fileEdk = fileEdk;
    }

    /**
     * 文件大小MB
     */
    public Double getFileSize() {
        return fileSize;
    }

    /**
     * 文件大小MB
     */
    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 媒体资源文件对应的DK
     */
    public String getFileDk() {
        return fileDk;
    }

    /**
     * 媒体资源文件对应的DK
     */
    public void setFileDk(String fileDk) {
        this.fileDk = fileDk;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否删除，0未删除，1删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 是否删除，0未删除，1删除
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 时长，秒数（主要用于音频在H5控件中使用）
     */
    public Integer getDurationNum() {
        return durationNum;
    }

    /**
     * 时长，秒数（主要用于音频在H5控件中使用）
     */
    public void setDurationNum(Integer durationNum) {
        this.durationNum = durationNum;
    }

    /**
     * 媒体资源文件ID
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * 媒体资源文件ID
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

}