package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "store_locations")
public class StoreLocation extends BaseEntity {

    @Column
    private String locationName;

    @OneToMany(targetEntity = Sale.class, mappedBy = "storeLocation")
    private Set<Sale> sales;

}
