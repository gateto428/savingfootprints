package com.savingfootprints.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DocumentType {
    CC(0, "C.C."),
    CE(1, "C.E."),
    TI(2, "T.I.");

    private final Integer id;
    private final String type;
}
