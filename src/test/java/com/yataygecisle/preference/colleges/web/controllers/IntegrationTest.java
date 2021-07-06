package com.yataygecisle.preference.colleges.web.controllers;

import com.yataygecisle.preference.colleges.domain.College;
import com.yataygecisle.preference.colleges.domain.Course;
import com.yataygecisle.preference.colleges.domain.Faculty;
import com.yataygecisle.preference.colleges.repository.CollegeRepository;
import com.yataygecisle.preference.colleges.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    CourseRepository courseRepository;

    Course getCourse() {
        return courseRepository.findByCourseCode(1L).get();
    }

}
