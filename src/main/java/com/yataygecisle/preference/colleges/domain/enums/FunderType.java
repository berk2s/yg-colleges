package com.yataygecisle.preference.colleges.domain.enums;

public enum FunderType {
    PUBLIC("Devlet"),
    PRIVATE("Vakıf");

    private final String funderType;

    FunderType(String funderType) {
        this.funderType = funderType;
    }
}
