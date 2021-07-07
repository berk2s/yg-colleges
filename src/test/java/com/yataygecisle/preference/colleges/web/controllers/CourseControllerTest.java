package com.yataygecisle.preference.colleges.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yataygecisle.preference.colleges.domain.Course;
import com.yataygecisle.preference.colleges.domain.enums.*;
import com.yataygecisle.preference.colleges.web.models.CreateCourseDto;
import com.yataygecisle.preference.colleges.web.models.ErrorDesc;
import com.yataygecisle.preference.colleges.web.models.ErrorType;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

public class CourseControllerTest extends IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    UUID courseId;

    String accessToken;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        courseId = UUID.randomUUID();

        accessToken = createAccessToken();
    }

    @Nested
    class TestEndpoint {


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

            Course course = getCourse();

            CreateCourseDto createCourseDto = new CreateCourseDto();
            createCourseDto.setCourseCode(1L);
            createCourseDto.setCourseName("New Course");
            createCourseDto.setCourseType(CourseType.FAK);
            createCourseDto.setFunderType(FunderType.PRIVATE);
            createCourseDto.setEducationType(EducationType.FORMAL);
            createCourseDto.setCourseFeature(CourseFeature.ENGLISH);
            createCourseDto.setPointType(PointType.SAY);
            createCourseDto.setMinimumPoint(451.123);
            createCourseDto.setMinimumOrder(12.912);
            createCourseDto.setMinimumRequiredOrder(300000.0);
            createCourseDto.setNominalDuration(4);
            createCourseDto.setNominalQuota(80);
            createCourseDto.setRegisteredStudents(82);
            createCourseDto.setCollegeId(course.getCollege().getId().toString());
            createCourseDto.setFacultyId(course.getFaculty().getId().toString());
            createCourseDto.setCountryId(course.getCountry().getId().toString());
            createCourseDto.setProvinceId(course.getProvince().getId().toString());
            createCourseDto.setDistrictId(course.getDistrict().getId().toString());

            mockMvc.perform(post(CourseController.ENDPOINT)
                    .header("Authorization", "Bearer " + accessToken)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(createCourseDto)))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.courseId").isNotEmpty())
                    .andExpect(jsonPath("$.courseCode", is(createCourseDto.getCourseCode().intValue())))
                    .andExpect(jsonPath("$.collegeName", is(course.getCollege().getCollegeName())))
                    .andExpect(jsonPath("$.facultyName", is(course.getFaculty().getFacultyName())))
                    .andExpect(jsonPath("$.courseType", is(createCourseDto.getCourseType().name())))
                    .andExpect(jsonPath("$.courseName", is(createCourseDto.getCourseName())))
                    .andExpect(jsonPath("$.country", is(course.getCountry().getCountryName())))
                    .andExpect(jsonPath("$.province", is(course.getProvince().getProvinceName())))
                    .andExpect(jsonPath("$.district", is(course.getDistrict().getDistrictName())))
                    .andExpect(jsonPath("$.nominalDuration", is(createCourseDto.getNominalDuration())))
                    .andExpect(jsonPath("$.funder", is(createCourseDto.getFunderType().name())))
                    .andExpect(jsonPath("$.educationType", is(createCourseDto.getEducationType().name())))
                    .andExpect(jsonPath("$.courseFeature", is(createCourseDto.getCourseFeature().name())))
                    .andExpect(jsonPath("$.determinedPointType", is(createCourseDto.getPointType().name())))
                    .andExpect(jsonPath("$.minimumPoint", is(createCourseDto.getMinimumPoint())))
                    .andExpect(jsonPath("$.minimumOrder", is(createCourseDto.getMinimumOrder())))
                    .andExpect(jsonPath("$.nominalQuota", is(createCourseDto.getNominalQuota())))
                    .andExpect(jsonPath("$.registeredStudents", is(createCourseDto.getRegisteredStudents())))
                    .andExpect(jsonPath("$.specialConditions").isEmpty())
                    .andExpect(jsonPath("$.minimumRequiredOrder", is(createCourseDto.getMinimumRequiredOrder())))
                    .andExpect(jsonPath("$.price").isEmpty());

        }

    }

    @Nested
    class TestExceptions {


        @DisplayName("Test Unauthorized Request")
        @Test
        void testUnauthorizedRequest() throws Exception {

            mockMvc.perform(get(CourseController.ENDPOINT + "/" + UUID.randomUUID().toString()))
                    .andExpect(status().isUnauthorized());

        }

        @DisplayName("Test Course Not Found")
        @Test
        void testCourseNotFoundException() throws Exception {

            mockMvc.perform(get(CourseController.ENDPOINT + "/" + UUID.randomUUID().toString())
                    .header("Authorization", "Bearer " + accessToken))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.error", is(ErrorType.NOT_FOUND.getError())))
                    .andExpect(jsonPath("$.error_description", is(ErrorDesc.COURSE_NOT_FOUND.name())));

        }

    }

}
