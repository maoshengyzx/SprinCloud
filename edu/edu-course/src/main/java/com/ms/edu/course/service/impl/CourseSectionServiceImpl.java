package com.ms.edu.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ms.edu.entity.CourseSection;
import com.ms.edu.course.service.CourseSectionService;
import com.ms.edu.course.mapper.CourseSectionMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【course_section(课程章节表)】的数据库操作Service实现
* @createDate 2024-06-11 15:47:26
*/
@Service
public class CourseSectionServiceImpl extends ServiceImpl<CourseSectionMapper, CourseSection>
    implements CourseSectionService{

}




