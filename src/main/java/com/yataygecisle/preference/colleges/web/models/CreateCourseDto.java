package com.yataygecisle.preference.colleges.web.models;

import com.yataygecisle.preference.colleges.annotations.UUID;
import com.yataygecisle.preference.colleges.domain.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCourseDto {

    @NotNull
    private Long courseCode;

    @NotNull
    private String courseName;

    @NotNull
    private CourseType courseType;

    @NotNull
    private FunderType funderType;

    @NotNull
    private EducationType educationType;

    @NotNull
    private CourseFeature courseFeature;

    @NotNull
    private PointType pointType;

    @NotNull
    private Double minimumPoint;

    @NotNull
    private Double minimumOrder;

    @NotNull
    private Double minimumRequiredOrder;

    @NotNull
    private Integer nominalDuration;

    @NotNull
    private Integer nominalQuota;

    @NotNull
    private Integer registeredStudents;

    private Double price;

    @UUID
    @NotNull
    private String collegeId;

    @UUID
    @NotNull
    private String facultyId;

    @UUID
    @NotNull
    private String countryId;

    @UUID
    @NotNull
    private String provinceId;

    @UUID
    @NotNull
    private String districtId;

    private List<String> specialConditions = new ArrayList<>();

}
