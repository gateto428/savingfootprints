package com.savingfootprints.model;

import com.savingfootprints.model.enums.DocumentType;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class User {
    private String id;
    private String name;
    private String lastName;
    private DocumentType documentType;
    private String document;
    private String phone;
    private String email;
}
