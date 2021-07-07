package com.yataygecisle.preference.colleges.web.models;

import lombok.Getter;

@Getter
public enum ErrorType {
    NOT_FOUND("not_found"),
    INVALID_REQUEST("invalid_request"),
    INVALID_GRANT("invalid_grant"),
    INVALID_SCOPE("invalid_scope"),
    SERVER_ERROR("server_error"),
    INVALID_TOKEN("invalid_token");

    private final String error;

    private ErrorType(String e) {
        this.error = e;
    }

    @Override
    public String toString() {
        return error;
    }
}
