package com.savingfootprints.model;

import lombok.Builder;

@Builder
public class Initiative {
    private String id;
    private String name;
    private String description;
    private Double goal;
    private Boolean state;
    private Pet pet;
}
