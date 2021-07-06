package com.yataygecisle.preference.colleges.services.impl;

import com.yataygecisle.preference.colleges.domain.Course;
import com.yataygecisle.preference.colleges.repository.CourseRepository;
import com.yataygecisle.preference.colleges.services.CourseService;
import com.yataygecisle.preference.colleges.web.mappers.CourseMapper;
import com.yataygecisle.preference.colleges.web.models.CourseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @PreAuthorize("hasAuthority('READ_COURSE')")
    @Override
    public CourseDto getCourseById(UUID courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> {
                   log.warn("Cannot find course by given course id [courseId: {}]", courseId);
                   throw new RuntimeException("Invalid course id"); // TODO
                });

        return courseMapper.courseToCourseDto(course);
    }
}
