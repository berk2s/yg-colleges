package com.yataygecisle.preference.colleges.domain.enums;

public enum PointType {
    SAY("Sayısal"),
    EA("Eşit Ağırlık"),
    SOZ("Sözel"),
    DIL("Dil");

    private final String pointType;

    PointType(String pointType) {
        this.pointType = pointType;
    }
}
