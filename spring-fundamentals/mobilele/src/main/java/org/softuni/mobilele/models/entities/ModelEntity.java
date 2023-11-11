package org.softuni.mobilele.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.softuni.mobilele.models.enums.VehicleCategoryEnum;

@Entity
@Table(name = "models")
@Getter
@Setter
public class ModelEntity extends BaseEntity {

    @Column
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private VehicleCategoryEnum category;

    @ManyToOne(optional = false)
    private BrandEntity brand;

}
