package com.ms.edu.es;

import com.ms.edu.dto.CourseDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CourseDTORepository extends ElasticsearchRepository<CourseDTO, Long> {

    /**
     * 根据价格区间查询
     * @param begin
     * @param end
     * @return
     */
    List<CourseDTO> findByPriceBetween(Double begin, Double end);
}