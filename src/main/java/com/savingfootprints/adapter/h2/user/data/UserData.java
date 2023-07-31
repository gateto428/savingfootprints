package com.savingfootprints.adapter.h2.user.data;

import com.savingfootprints.model.enums.DocumentType;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Builder(toBuilder = true)
@Table("users")
@Data
public class UserData implements Persistable<String> {
    @Id
    private String id;
    private String name;
    private String lastName;
    private DocumentType documentType;
    private String document;
    private String phone;
    private String email;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
