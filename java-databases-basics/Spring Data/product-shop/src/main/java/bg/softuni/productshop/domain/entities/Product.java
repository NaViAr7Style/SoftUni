package bg.softuni.productshop.domain.entities;

import bg.softuni.productshop.domain.dtos.ProductDTO;
import bg.softuni.productshop.domain.dtos.ProductsSoldWithCountDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    private User buyer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User seller;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

}
