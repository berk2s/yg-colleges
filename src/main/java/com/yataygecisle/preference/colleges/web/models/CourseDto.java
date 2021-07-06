package com.yataygecisle.preference.colleges.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CourseDto {

    private String courseId;

    private Long courseCode;

    private String collegeName;

    private String facultyName;

    private String courseType;

    private String courseName;

    private String country;

    private String province;

    private String district;

    private Integer nominalDuration;

    private String funder;

    private String educationType;

    private String courseFeature;

    private String determinedPointType;

    private Double minimumPoint;

    private Double minimumOrder;

    private Integer nominalQuota;

    private Integer registeredStudents;

    private List<String> specialConditions;

    private Double minimumRequiredOrder;

    private Double price;

}
