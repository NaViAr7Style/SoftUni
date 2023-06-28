package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {

    @Column(name = "first_name",nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(nullable = false, unique = true ,length = 50)
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column
    private String picture;

    @Column(name = "has_medical_insurance")
    private Boolean hasMedicalInsurance;

    @OneToMany(targetEntity = Visitation.class,mappedBy = "patient")
    private Set<Visitation> visitations;

}
