package com.savingfootprints.adapter.h2.picture.data;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Builder(toBuilder = true)
@Table("Picture")
@Data
public class PictureData implements Persistable<String> {
    @Id
    private String id;
    private String path;
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
