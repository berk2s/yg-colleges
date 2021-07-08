package com.yataygecisle.preference.colleges.web.controllers;

import com.yataygecisle.preference.colleges.services.CourseService;
import com.yataygecisle.preference.colleges.web.models.CourseDto;
import com.yataygecisle.preference.colleges.web.models.CreateCourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping(CourseController.ENDPOINT)
@RestController
public class CourseController {

    public static final String ENDPOINT = "/courses";

    private final CourseService courseService;

    @GetMapping(value = "{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseDto> getCourseById(@PathVariable UUID courseId) {
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CreateCourseDto createCourseDto) {
        return new ResponseEntity<>(courseService.createCourse(createCourseDto), HttpStatus.CREATED);
    }

}
