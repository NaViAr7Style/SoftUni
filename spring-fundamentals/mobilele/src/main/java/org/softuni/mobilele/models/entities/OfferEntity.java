package org.softuni.mobilele.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.softuni.mobilele.models.enums.EngineTypeEnum;
import org.softuni.mobilele.models.enums.TransmissionTypeEnum;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "offers")
@Getter
@Setter
public class OfferEntity extends BaseEntity {

    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne(optional = false)
    private ModelEntity model;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionTypeEnum transmission;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column
    @Positive
    private int mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    @Min(1930)
    private int year;

}
