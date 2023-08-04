package com.savingfootprints.model;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Picture {
    private String id;
    private String path;
    private String pet;
}
