package org.softuni.mobilele.models.dtos;

import jakarta.validation.constraints.*;
import org.softuni.mobilele.models.enums.EngineTypeEnum;
import org.softuni.mobilele.models.enums.TransmissionTypeEnum;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDate;

public record CreateOfferDTO(

        @NotEmpty
        @Size(min = 5, max = 512)
        String description,

        @Positive
        @NotNull
        Long modelId,

        @NotNull
        EngineTypeEnum engineType,

        @NotNull
        TransmissionTypeEnum transmissionType,

        @NotEmpty
        String imageUrl,

        @Positive
        @NotNull
        Integer mileage,

        @Positive
        @NotNull
        Integer price,

        @NotNull
        @Min(1930)
        Integer year
) {
        public static CreateOfferDTO empty() {
              return new CreateOfferDTO(null, null, null,
                      null, null, null, null, null);
        }
}