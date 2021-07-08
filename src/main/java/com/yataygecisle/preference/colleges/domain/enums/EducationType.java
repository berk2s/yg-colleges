package com.yataygecisle.preference.colleges.domain.enums;

public enum EducationType {
    FORMAL("Örgün"),
    SECONDARY("İkinci Öğretim");

    private final String educationType;

    EducationType(String educationType) {
        this.educationType = educationType;
    }
}
