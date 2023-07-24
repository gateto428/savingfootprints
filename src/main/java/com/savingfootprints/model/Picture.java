package com.savingfootprints.model;

import lombok.Builder;

@Builder
public class Picture {
    private String id;
    private String path;
    private Pet pet;
}
