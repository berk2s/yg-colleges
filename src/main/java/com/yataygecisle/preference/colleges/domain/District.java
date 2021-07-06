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
public class District extends BaseEntity {

    @Column(name = "district_id")
    private UUID districtId;

    @Column(name = "district_name")
    private String districtName;

    @ManyToOne
    private Province province;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        course.setDistrict(this);
        courses.add(course);
    }

}
