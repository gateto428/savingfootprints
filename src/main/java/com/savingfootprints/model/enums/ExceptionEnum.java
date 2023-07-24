package com.savingfootprints.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {
    SAVE_USERS("0001", "Error in save users"),
    GET_USERS("0002", "Error in get users");
    private final String code;
    private final String message;
}
