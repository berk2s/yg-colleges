package com.yataygecisle.preference.colleges.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yataygecisle.preference.colleges.domain.Course;
import com.yataygecisle.preference.colleges.web.models.CreateCourseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

public class CourseControllerTest extends IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    UUID courseId;

    String accessToken;

    @Nested
    class TestEndpoint {

        @BeforeEach
        void setUp() throws JsonProcessingException {
            courseId = UUID.randomUUID();

            accessToken = createAccessToken();
        }

        @DisplayName("Get Course Successfully")
        @Test
        void getCourseSuccessfully() throws Exception {

            Course course = getCourse();

            mockMvc.perform(get(CourseController.ENDPOINT + "/" + course.getId().toString())
                    .header("Authorization", "Bearer " + accessToken))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.courseId", is(course.getId().toString())))
                    .andExpect(jsonPath("$.courseCode", is(course.getCourseCode().intValue())))
                    .andExpect(jsonPath("$.collegeName", is(course.getCollege().getCollegeName())))
                    .andExpect(jsonPath("$.facultyName", is(course.getFaculty().getFacultyName())))
                    .andExpect(jsonPath("$.courseType", is(course.getCourseType().name())))
                    .andExpect(jsonPath("$.courseName", is(course.getCourseName())))
                    .andExpect(jsonPath("$.country", is(course.getCountry().getCountryName())))
                    .andExpect(jsonPath("$.province", is(course.getProvince().getProvinceName())))
                    .andExpect(jsonPath("$.district", is(course.getDistrict().getDistrictName())))
                    .andExpect(jsonPath("$.nominalDuration", is(course.getNominalDuration())))
                    .andExpect(jsonPath("$.funder", is(course.getFunderType().name())))
                    .andExpect(jsonPath("$.educationType", is(course.getEducationType().name())))
                    .andExpect(jsonPath("$.courseFeature", is(course.getCourseFeature().name())))
                    .andExpect(jsonPath("$.determinedPointType", is(course.getPointType().name())))
                    .andExpect(jsonPath("$.minimumPoint", is(course.getMinimumPoint())))
                    .andExpect(jsonPath("$.minimumOrder", is(course.getMinimumOrder())))
                    .andExpect(jsonPath("$.nominalQuota", is(course.getNominalQuota())))
                    .andExpect(jsonPath("$.registeredStudents", is(course.getRegisteredStudents())))
                    .andExpect(jsonPath("$.specialConditions").isEmpty())
                    .andExpect(jsonPath("$.minimumRequiredOrder", is(course.getMinimumRequiredOrder())))
                    .andExpect(jsonPath("$.price").isEmpty());

        }

        @DisplayName("Create Course Successfully")
        @Test
        void createCourseSuccessfully() throws Exception {

            CreateCourseDto createCourseDto = new CreateCourseDto();

            mockMvc.perform(post(CourseController.ENDPOINT)
                    .header("Authorization", "Bearer " + accessToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(createCourseDto)))
                    .andExpect(status().isCreated());

        }

    }

}
