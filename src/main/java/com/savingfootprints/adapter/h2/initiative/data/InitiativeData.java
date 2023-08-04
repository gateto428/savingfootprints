package com.savingfootprints.adapter.h2.initiative.data;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Builder(toBuilder = true)
@Table("Initiative")
@Data
public class InitiativeData implements Persistable<String> {
    @Id
    private String id;
    private String name;
    private String description;
    private Double goal;
    private Boolean state;
    private String pet;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
