package com.savingfootprints.controllers.service.donation;

import com.savingfootprints.controllers.service.DTO;
import com.savingfootprints.model.Donation;
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
public class DonationDTO extends DTO<Donation> {
    @NotNull(message = "This no null")
    private String idInitiative;
    @NotNull(message = "This no null")
    private String idUsers;
    @NotNull(message = "This no null")
    private Double donationPay;
    private String transferCode;

    @Override
    public Mono<Donation> toModel() {
        return Mono.just(Donation
                .builder()
                .idInitiative(this.idInitiative)
                .idUsers(this.idUsers)
                .donationPay(this.donationPay)
                .transferCode(this.transferCode)
                .build());
    }
}
