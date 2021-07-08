package com.yataygecisle.preference.colleges.web.models;

import lombok.Getter;

@Getter
public enum ErrorDesc {
    COURSE_NOT_FOUND("Course not found"),
    FACULTY_NOT_FOUND("Faculty not found"),
    DISTRICT_NOT_FOUND("District not found"),
    CONDITION_NOT_FOUND("Condition not found");

    private final String errorDesc;

    private ErrorDesc(String e) {
        this.errorDesc = e;
    }

    @Override
    public String toString() {
        return errorDesc;
    }
}
