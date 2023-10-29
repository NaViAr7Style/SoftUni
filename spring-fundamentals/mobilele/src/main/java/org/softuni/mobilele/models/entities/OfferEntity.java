package org.softuni.mobilele.models.entities;

import jakarta.persistence.*;
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

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private ModelEntity model;

    @Column(name = "engine")
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    @Column(name = "transmission")
    @Enumerated(EnumType.STRING)
    private TransmissionTypeEnum transmission;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private long mileage;

    @Column
    private BigDecimal price;

    @Column
    private int year;

}
