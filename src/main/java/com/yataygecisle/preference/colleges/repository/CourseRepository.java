package com.yataygecisle.preference.colleges.repository;

import com.yataygecisle.preference.colleges.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    Optional<Course> findByCourseCode(Long courseCode);

}
