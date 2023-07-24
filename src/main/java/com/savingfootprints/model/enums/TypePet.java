package com.savingfootprints.model.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TypePet {
    CAT(0, "cat"),
    DOG(1, "DOG"),
    DONKEY(3, "DONKEY");

    private final Integer id;
    private final String name;
}
