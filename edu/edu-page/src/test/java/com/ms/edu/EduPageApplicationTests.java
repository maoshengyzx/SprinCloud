package com.ms.edu;

import com.ms.edu.dto.CourseDTO;
import com.ms.edu.es.CourseDTORepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
public class EduPageApplicationTests {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;


    @Resource
    private CourseDTORepository courseDTORepository;

    @Test
    public void contextLoads() {
        elasticsearchTemplate.createIndex(CourseDTO.class);
        elasticsearchTemplate.putMapping(CourseDTO.class);
    }

    @Test
    public void testFind() {
        Iterable<CourseDTO> all = courseDTORepository.findAll();
        for (CourseDTO item : all) {
            System.out.println("item=" + item);
        }
    }

    @Test
    public void query() {
        // 查询全部，并按照价格降序排序
        Iterable<CourseDTO> items = this.courseDTORepository.findAll(Sort.by("price").descending());
        for (CourseDTO item : items) {
            log.info("item = {}", item);
        }
    }

    @Test
    public void search() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("courseName", "入门"));
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("courseName").preTags("<em>").postTags("</em>");
//        queryBuilder.withHighlightBuilder(highlightBuilder);
        // 搜索，获取结果
        Page<CourseDTO> items = this.courseDTORepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        System.out.println("total = " + total);
        for (CourseDTO item : items) {
            log.info("item = {}", item);
        }
    }

    @Test
    public void searchWithHighlight() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("course_name", "入门"));
        // 更加价格区间查询
        queryBuilder.withFilter(QueryBuilders.rangeQuery("price").gte(0).lte(200));
        // 设置高亮显示
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("courseName").preTags("<font color='red'>")
                .postTags("</font>");

        HighlightBuilder.Field field = new HighlightBuilder.Field("courseName");
        field.preTags("<font color='red'>").postTags("</font>");
        queryBuilder.withHighlightFields(field);

        // 搜索，获取结果
        Page<CourseDTO> items = courseDTORepository.search(queryBuilder.build());
        List<CourseDTO> content = items.getContent();

        for (CourseDTO item : content) {
            log.info("item = {}", item);
        }
    }


}
