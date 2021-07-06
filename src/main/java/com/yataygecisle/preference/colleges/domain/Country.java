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
public class Country extends BaseEntity {

    @Column(name = "country_id")
    private UUID countryId;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Province> provinces = new ArrayList<>();

    public void addCourse(Course course) {
        course.setCountry(this);
        courses.add(course);
    }

    public void addProvince(Province province) {
        province.setCountry(this);
        provinces.add(province);
    }

}
