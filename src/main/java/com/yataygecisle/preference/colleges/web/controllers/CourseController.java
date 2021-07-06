package com.yataygecisle.preference.colleges.web.controllers;

import com.yataygecisle.preference.colleges.services.CourseService;
import com.yataygecisle.preference.colleges.web.models.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
