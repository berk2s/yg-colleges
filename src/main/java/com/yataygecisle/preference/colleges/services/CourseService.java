package com.yataygecisle.preference.colleges.services;

import com.yataygecisle.preference.colleges.web.models.CourseDto;
import com.yataygecisle.preference.colleges.web.models.CreateCourseDto;

import java.util.UUID;

public interface CourseService {

    CourseDto getCourseById(UUID courseId);

    CourseDto createCourse(CreateCourseDto createCourseDto);

}
