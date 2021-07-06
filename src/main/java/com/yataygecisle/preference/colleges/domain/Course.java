package com.yataygecisle.preference.colleges.domain;

import com.yataygecisle.preference.colleges.domain.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course extends BaseEntity {

    @Column(name = "course_code")
    private Long courseCode;

    @Column(name = "course_name")
    private String courseName;

    @Enumerated(EnumType.ORDINAL)
    private CourseType courseType;

    @Enumerated(EnumType.ORDINAL)
    private FunderType funderType;

    @Enumerated(EnumType.ORDINAL)
    private EducationType educationType;

    @Enumerated(EnumType.ORDINAL)
    private CourseFeature courseFeature;

    @Enumerated(EnumType.ORDINAL)
    private PointType pointType;

    @Column(name = "minimum_point")
    private Double minimumPoint;

    @Column(name = "maximum_point")
    private Double minimumOrder;

    @Column(name = "minimum_required_order")
    private Double minimumRequiredOrder;

    @Column(name = "nominal_duration")
    private Integer nominalDuration;

    @Column(name = "nominal_quota")
    private Integer nominalQuota;

    @Column(name = "registered_students")
    private Integer registeredStudents;

    @Column
    private Double price;

    @ManyToOne
    private College college;

    @ManyToOne
    private Faculty faculty;

    @ManyToOne
    private Country country;

    @ManyToOne
    private Province province;

    @ManyToOne
    private District district;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH
    })
    @JoinTable(name = "course_conditions",
            joinColumns = {
                @JoinColumn(name = "course_id", referencedColumnName = "id")
            }, inverseJoinColumns = {
                @JoinColumn(name = "condition_id", referencedColumnName = "condition_id")
    })
    private List<Condition> conditions = new ArrayList<>();

    public void addCondition(Condition condition) {
        condition.getCourses().add(this);
        conditions.add(condition);
    }

    public void removeCondition(Condition condition) {
        condition.getCourses().remove(condition);
        conditions.remove(condition);
    }

    public void addCountry(Country country) {
        this.country = country;
        country.getCourses().add(this);
    }

    public void addProvince(Province province) {
        this.province = province;
        province.getCourses().add(this);
    }

    public void addDistrict(District district) {
        this.district = district;
        district.getCourses().add(this);
    }

}
