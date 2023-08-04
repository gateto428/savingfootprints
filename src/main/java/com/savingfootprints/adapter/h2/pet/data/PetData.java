package com.savingfootprints.adapter.h2.pet.data;

import com.savingfootprints.model.enums.SizePet;
import com.savingfootprints.model.enums.TypePet;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Builder(toBuilder = true)
@Table("Pet")
@Data
public class PetData implements Persistable<String> {
    @Id
    private String id;
    private TypePet typePet;
    private SizePet sizePet;
    private String descriptionPet;
    private String location;
    private Boolean state;
    private String owner;
    private String creator;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
