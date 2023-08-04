package com.savingfootprints.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {
    SAVE_USERS("0001", "Error in save users"),
    GET_USERS("0002", "Error in get users"),
    USER_NOT_FOUND("0003", "User not found"),
    BODY_MISSING("0004", "Body missing error"),
    SAVE_PET("0005", "Error in save pets"),
    PET_NOT_FOUND("0006", "Pet not found"),
    GET_PETS("0007", "Error in get pets"),
    SAVE_PICTURE("0008", "Error in save pictures"),
    PICTURE_NOT_FOUND("0009", "Picture not found"),
    GET_PICTURES("0008", "Error in get pictures"),
    SAVE_INITIATIVE("0010", "Error in save initiative"),
    INITIATIVE_NOT_FOUND("0011", "Initiatives not found"),
    GET_INITIATIVES("0012", "Error in get initiatives"),
    SAVE_DONATION("0013", "Error in save donation"),
    DONATION_NOT_FOUND("0014", "Donations not found"),
    GET_DONATIONS("0015", "Error in get donations");
    private final String code;
    private final String message;
}
