package org.softuni.mobilele.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.softuni.mobilele.models.enums.EngineTypeEnum;
import org.softuni.mobilele.models.enums.TransmissionTypeEnum;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "offers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OfferEntity extends BaseEntity {

    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private ModelEntity model;

    @Column(name = "engine_type")
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engineType;

    @Column(name = "transmission_type")
    private TransmissionTypeEnum transmissionType;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private long mileage;

    @Column
    private BigDecimal price;

    @Column
    private int year;

}
