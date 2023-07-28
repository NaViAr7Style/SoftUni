package bg.softuni.gamestore.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin;

    @ManyToMany(targetEntity = Game.class, fetch = FetchType.EAGER)
    private Set<Game> games;

    @OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Order> orders;

}
