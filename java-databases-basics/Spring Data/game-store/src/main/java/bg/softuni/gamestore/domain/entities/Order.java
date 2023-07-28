package bg.softuni.gamestore.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToMany(targetEntity = Game.class, fetch = FetchType.EAGER)
    private Set<Game> games;
}
