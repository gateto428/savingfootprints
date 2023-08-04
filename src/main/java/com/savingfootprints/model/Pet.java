package com.savingfootprints.model;

import com.savingfootprints.model.enums.SizePet;
import com.savingfootprints.model.enums.TypePet;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Pet {
    private String id;
    private TypePet typePet;
    private SizePet sizePet;
    private String descriptionPet;
    private String location;
    private Boolean state;
    private String owner;
    private String creator;
}
