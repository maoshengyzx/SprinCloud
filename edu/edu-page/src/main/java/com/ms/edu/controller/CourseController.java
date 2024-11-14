package com.ms.edu.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.edu.dto.CourseDTO;
import com.ms.edu.es.CourseDTORepository;
import com.ms.edu.service.CourseFegin;
import com.ms.edu.service.UserFegin;
import com.ms.edu.utils.ApiResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: CourseController
 * Package: com.ms.edu.controller
 * Description:
 *
 * @Author ms
 * @Create 2024/6/11 15:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/page")
public class CourseController {

    @Resource
    private CourseFegin courseFegin;

    @Resource
    private CourseDTORepository courseDTORepository;

    @Resource
    private ElasticsearchTemplate client;



    @GetMapping("/course")
    public ApiResponse course() {
        List<CourseDTO> list = courseFegin.list();
        return ApiResponse.success(list);
    }

    @GetMapping("/searchCourse")
    public ApiResponse searchCourse(String keyWords, Long startPrice, Long endPrice, int pageNum, int pageSize) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        // 构建查询条件
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        // 添加基本分词查询
        if (keyWords != null && !keyWords.isEmpty()) {
            queryBuilder.must(QueryBuilders.multiMatchQuery(keyWords, "courseName", "brief", "teacherName"));
        }

        // 添加价格范围查询
        if (startPrice != null || endPrice != null) {
            RangeQueryBuilder priceRangeQuery = QueryBuilders.rangeQuery("price");
            if (startPrice != null) {
                priceRangeQuery.gte(startPrice);
            }
            if (endPrice != null) {
                priceRangeQuery.lte(endPrice);
            }
            queryBuilder.must(priceRangeQuery);
        }

        // 设置高亮显示
//        HighlightBuilder highlightBuilder = new HighlightBuilder().field("courseName").preTags("<font color='red'>").postTags("</font>");
//        queryBuilder.withHighlightBuilder(highlightBuilder);

        // 设置分页信息
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        builder.withPageable(pageable);
        builder.withQuery(queryBuilder);

        builder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC));

        // 执行查询
        Page<CourseDTO> items = courseDTORepository.search(builder.build());

        // 获取结果
        List<CourseDTO> content = items.getContent();


        if (!StringUtils.isBlank(keyWords)) {
            highlightKeywords(content, keyWords);
        }

        return ApiResponse.success(items);
    }


    /**
     * 查询课程章节信息
     *
     * @param courseId
     * @return
     */
    @GetMapping("/course/{courseId}")
    public ApiResponse getCourseSection(@PathVariable("courseId") int courseId) {
        return ApiResponse.success(courseFegin.getCourseSection(courseId));
    }

    @GetMapping("course/media")
    public ApiResponse getCourseMedia(Integer courseId,Integer lessonId) {
        return ApiResponse.success(courseFegin.getCourseMedia(courseId, lessonId));
    }


    /**
     * 查询已购课程信息
     * @param courseIds
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/course/getMyCoursesById")
    public ApiResponse getMyCoursesById(String courseIds,Integer pageNum,Integer pageSize) throws IOException {
        String json = courseFegin.getMyCoursesById(courseIds, pageNum, pageSize);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mixedMap = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        return ApiResponse.success(mixedMap);
    }

    public void highlightKeywords(Iterable<CourseDTO> courses, String key) {
// 使用正则表达式进行不区分大小写的匹配
        String highlightedKey = "<span style='color:red;'>" + key + "</span>";
        String regex = "(?i)" + Pattern.quote(key); // (?i) 表示不区分大小写
        Pattern pattern = Pattern.compile(regex);
        for (CourseDTO course : courses) {
            Matcher matcherCourseName = pattern.matcher(course.getCourseName());
            Matcher matcherBrief = pattern.matcher(course.getBrief());
            Matcher matcherTeacherName = pattern.matcher(course.getTeacherName());
            course.setCourseName(matcherCourseName.replaceAll(highlightedKey));
            course.setBrief(matcherBrief.replaceAll(highlightedKey));
            course.setTeacherName(matcherTeacherName.replaceAll(highlightedKey));
        }
    }



}
