package com.savingfootprints.controllers.service.user;

import com.savingfootprints.controllers.service.DTO;
import com.savingfootprints.model.User;
import com.savingfootprints.model.enums.DocumentType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO extends DTO<User> {
    private String id;
    @NotNull(message = "This no null")
    private String name;
    @NotNull(message = "This no null")
    private String lastName;
    @NotNull(message = "This no null")
    private DocumentType documentType;
    @NotNull(message = "This no null")
    private String document;
    private String phone;
    @NotNull(message = "This no null")
    private String email;

    @Override
    public Mono<User> toModel() {
        return Mono.just(User.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .documentType(this.documentType)
                .document(this.document)
                .phone(this.phone)
                .email(this.email)
                .build());
    }
}
