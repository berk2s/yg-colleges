package com.yataygecisle.preference.colleges.web.mappers;

import com.yataygecisle.preference.colleges.domain.Course;
import com.yataygecisle.preference.colleges.web.models.CourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(imports = {UUID.class, Collectors.class})
public interface CourseMapper {

    @Mappings({
            @Mapping(target = "courseId", expression = "java( course.getId().toString() )"),
            @Mapping(target = "collegeName", expression = "java( course.getCollege().getCollegeName() )"),
            @Mapping(target = "facultyName", expression = "java( course.getFaculty().getFacultyName() )"),
            @Mapping(target = "courseType", expression = "java( course.getCourseType().name() )"),
            @Mapping(target = "country", expression = "java( course.getCountry().getCountryName() )"),
            @Mapping(target = "province", expression = "java( course.getProvince().getProvinceName() )"),
            @Mapping(target = "district", expression = "java( course.getDistrict().getDistrictName() )"),
            @Mapping(target = "funder", expression = "java( course.getFunderType().name() )"),
            @Mapping(target = "educationType", expression = "java( course.getEducationType().name() )"),
            @Mapping(target = "courseFeature", expression = "java( course.getCourseFeature().name() )"),
            @Mapping(target = "determinedPointType", expression = "java( course.getPointType().name() )"),
            @Mapping(source = "nominalQuota", target = "nominalQuota")
            //     @Mapping(target = "specialConditions", expression = "java( course.getConditions().stream().map(c -> c.getReferenceNumber().toString()).collect(Collectors.toList()) )")
            //@Mapping(target = "specialConditions", source = "conditions")
    })
    CourseDto courseToCourseDto(Course course);

}
