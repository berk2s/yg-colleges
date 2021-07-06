package com.yataygecisle.preference.colleges.domain;

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
public class Faculty extends BaseEntity {

    @Column(name = "faculty_name")
    private String facultyName;

    @ManyToOne
    private College college;

    @OneToMany(mappedBy = "faculty",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        course.setFaculty(this);
        courses.add(course);
    }

}
