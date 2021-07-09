package com.yataygecisle.preference.colleges.web.models;

import com.yataygecisle.commons.annotations.UUID;
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

    @NotNull(message = "Course Code must not be empty")
    private Long courseCode;

    @NotNull(message = "Course Name must not be empty")
    private String courseName;

    @NotNull(message = "Course Type must not be empty")
    private CourseType courseType;

    @NotNull(message = "Funder Type must not be empty")
    private FunderType funderType;

    @NotNull(message = "Education Type must not be empty")
    private EducationType educationType;

    @NotNull(message = "Course Feature must not be empty")
    private CourseFeature courseFeature;

    @NotNull(message = "Point Type must not be empty")
    private PointType pointType;

    @NotNull(message = "Minimum Point must not be empty")
    private Double minimumPoint;

    @NotNull(message = "Minimum Order must not be empty")
    private Double minimumOrder;

    @NotNull(message = "Minimum Required Order must not be empty")
    private Double minimumRequiredOrder;

    @NotNull(message = "Nominal Duration must not be empty")
    private Integer nominalDuration;

    @NotNull(message = "Nominal Quota must not be empty")
    private Integer nominalQuota;

    @NotNull(message = "Registered Students must not be empty")
    private Integer registeredStudents;

    private Double price;

    @UUID(message = "Faculty ID must be UUID")
    @NotNull(message = "Course ID must not be empty")
    private String collegeId;

    @UUID(message = "Faculty ID must be UUID")
    @NotNull(message = "Faculty ID must not be empty")
    private String facultyId;

    @UUID(message = "Country ID must be UUID")
    @NotNull(message = "Country ID must not be empty")
    private String countryId;

    @UUID(message = "Province ID must be UUID")
    @NotNull(message = "Province ID must not be empty")
    private String provinceId;

    @UUID(message = "District ID must be UUID")
    @NotNull(message = "District ID must not be empty")
    private String districtId;

    private List<String> specialConditions = new ArrayList<>();

}
