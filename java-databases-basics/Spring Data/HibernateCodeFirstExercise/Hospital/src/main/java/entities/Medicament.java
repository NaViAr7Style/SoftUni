package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToMany(targetEntity = Visitation.class, mappedBy = "medicaments")
    private Set<Visitation> visitations;
}
