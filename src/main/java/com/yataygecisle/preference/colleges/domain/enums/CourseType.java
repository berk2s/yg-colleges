package com.yataygecisle.preference.colleges.domain.enums;

public enum CourseType {
    FAK("Fakülte"),
    MYO("Meslek Yüksek Okulu");

    private final String collegeType;

    CourseType(String collegeType) {
        this.collegeType = collegeType;
    }
}
