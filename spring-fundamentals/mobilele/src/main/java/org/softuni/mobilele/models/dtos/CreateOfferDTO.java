package org.softuni.mobilele.models.dtos;

import jakarta.validation.constraints.*;
import org.softuni.mobilele.models.enums.EngineTypeEnum;
import org.softuni.mobilele.models.enums.TransmissionTypeEnum;
import org.softuni.mobilele.models.validation.YearNotInTheFuture;

public record CreateOfferDTO(

        @NotEmpty
        @Size(min = 5, max = 512)
        String description,

        @Positive
        @NotNull
        Long modelId,

        @NotNull
        EngineTypeEnum engine,

        @NotNull
        TransmissionTypeEnum transmission,

        @NotEmpty
        String imageUrl,

        @Positive
        @NotNull
        Integer mileage,

        @Positive
        @NotNull
        Integer price,

        @NotNull(message = "Manufacturing year is required.")
        @YearNotInTheFuture(message = "The year should not be in the future.")
        @Min(value = 1930, message = "Please select a year equal to or after 1930.")
        Integer year) {

        public static CreateOfferDTO empty() {
              return new CreateOfferDTO(null, null, null,
                      null, null, null, null, null);
        }
}