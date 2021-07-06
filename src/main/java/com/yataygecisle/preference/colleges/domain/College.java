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
public class College extends BaseEntity {

    @Column(name = "college_name")
    private String collegeName;

    @OneToMany(mappedBy = "college",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Faculty> faculties = new ArrayList<>();

    @OneToMany(mappedBy = "college", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses = new ArrayList<>();

    public void addFaculty(Faculty faculty) {
        faculty.setCollege(this);
        faculties.add(faculty);
    }

    public void addCourse(Course course) {
        course.setCollege(this);
        courses.add(course);
    }

}
