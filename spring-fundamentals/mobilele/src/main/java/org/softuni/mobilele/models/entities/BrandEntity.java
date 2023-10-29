package org.softuni.mobilele.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
@NamedEntityGraph(
    name = "brandWithModels",
    attributeNodes = @NamedAttributeNode("models")
)
public class BrandEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand",
            targetEntity = ModelEntity.class,
            fetch = FetchType.LAZY)
    private List<ModelEntity> models;

}
