package com.yataygecisle.preference.colleges.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Province extends BaseEntity {

    @Column(name = "province_id")
    private UUID provinceId;

    @Column(name = "province_name")
    private String provinceName;

    @OneToMany(mappedBy = "province", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.DETACH
    }, orphanRemoval = true)
    private List<District> districts = new ArrayList<>();

    @OneToMany(mappedBy = "province", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Course> courses = new ArrayList<>();

    @ManyToOne
    private Country country;

    public void addDistrict(District district) {
        district.setProvince(this);
        districts.add(district);
    }

    public void addCourse(Course course) {
        course.setProvince(this);
        courses.add(course);
    }

}
