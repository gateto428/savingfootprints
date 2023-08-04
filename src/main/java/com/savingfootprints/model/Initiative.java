package com.savingfootprints.model;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Initiative {
    private String id;
    private String name;
    private String description;
    private Double goal;
    private Boolean state;
    private String pet;
}
