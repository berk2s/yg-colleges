package com.yataygecisle.preference.colleges.services.impl;

import com.yataygecisle.preference.colleges.domain.*;
import com.yataygecisle.preference.colleges.repository.*;
import com.yataygecisle.preference.colleges.services.CourseService;
import com.yataygecisle.preference.colleges.web.exceptions.ConditionNotFoundException;
import com.yataygecisle.preference.colleges.web.exceptions.CourseNotFoundException;
import com.yataygecisle.preference.colleges.web.exceptions.DistrictNotFoundException;
import com.yataygecisle.preference.colleges.web.exceptions.FacultyNotFoundException;
import com.yataygecisle.preference.colleges.web.mappers.CourseMapper;
import com.yataygecisle.preference.colleges.web.models.CourseDto;
import com.yataygecisle.preference.colleges.web.models.CreateCourseDto;
import com.yataygecisle.preference.colleges.web.models.ErrorDesc;
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
    private final FacultyRepository facultyRepository;
    private final DistrictRepository districtRepository;
    private final ConditionRepository conditionRepository;
    private final CourseMapper courseMapper;

    @PreAuthorize("hasAuthority('READ_COURSE')")
    @Override
    public CourseDto getCourseById(UUID courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> {
                   log.warn("Cannot find course by given course id [courseId: {}]", courseId);
                   throw new CourseNotFoundException(ErrorDesc.COURSE_NOT_FOUND.getErrorDesc());
                });

        return courseMapper.courseToCourseDto(course);
    }

    @PreAuthorize("hasAuthority('WRITE_COURSE')")
    @Override
    public CourseDto createCourse(CreateCourseDto createCourseDto) {
        Course course = courseMapper.createCourseDtoToCourseDto(createCourseDto);

        UUID facultyId = UUID.fromString(createCourseDto.getFacultyId());
        UUID districtId = UUID.fromString(createCourseDto.getDistrictId());

        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> {
                   log.warn("Cannot find faculty by given faculty id [facultyId: {}]", facultyId.toString());
                   throw new FacultyNotFoundException(ErrorDesc.FACULTY_NOT_FOUND.getErrorDesc());
                });

        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> {
                    log.warn("Cannot find district by given district id [districtId: {}]", districtId.toString());
                    throw new DistrictNotFoundException(ErrorDesc.DISTRICT_NOT_FOUND.getErrorDesc());
                });

        for (String _conditionId : createCourseDto.getSpecialConditions()) {
            UUID conditionId = UUID.fromString(_conditionId);

            Condition condition = conditionRepository.findById(conditionId)
                    .orElseThrow(() -> {
                        log.warn("Cannot find condition by given condition id [conditionId: {}]", _conditionId);
                        throw new ConditionNotFoundException(ErrorDesc.CONDITION_NOT_FOUND.getErrorDesc());
                    });

            course.addCondition(condition);
        }


        course.addCollege(faculty.getCollege());
        course.addFaculty(faculty);
        course.addCountry(district.getProvince().getCountry());
        course.addProvince(district.getProvince());
        course.addDistrict(district);

        courseRepository.save(course);

        return courseMapper.courseToCourseDto(course);
    }
}
