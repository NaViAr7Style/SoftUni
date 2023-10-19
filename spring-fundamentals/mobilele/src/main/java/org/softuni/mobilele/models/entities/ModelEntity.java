package org.softuni.mobilele.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.softuni.mobilele.models.enums.VehicleCategoryEnum;

@Entity
@Table(name = "models")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModelEntity extends BaseEntity {

    @Column
    private String name;

    @Column(name = "vehicle_category")
    @Enumerated(EnumType.STRING)
    private VehicleCategoryEnum vehicleCategory;

    @ManyToOne
    private BrandEntity brand;

}
