package org.softuni.mobilele.models.dtos;

import org.softuni.mobilele.models.enums.EngineTypeEnum;
import org.softuni.mobilele.models.enums.TransmissionTypeEnum;

import java.math.BigDecimal;

public record OfferDetailDTO(
        String id,
        String brand,
        String model,
        int year,
        int mileage,
        BigDecimal price,
        EngineTypeEnum engine,
        TransmissionTypeEnum transmission,
        String imageUrl,
        String seller,
        boolean viewerIsOwner
) {
    public String summary() {
        return brand + " " + model + ", " + year;
    }
}
