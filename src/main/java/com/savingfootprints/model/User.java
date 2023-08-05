package com.savingfootprints.model;

import com.savingfootprints.model.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private String lastName;
    private DocumentType documentType;
    private String document;
    private String phone;
    private String email;
}
