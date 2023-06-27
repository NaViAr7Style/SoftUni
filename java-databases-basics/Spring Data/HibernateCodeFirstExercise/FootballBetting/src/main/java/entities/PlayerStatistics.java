package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "player_statistics")
public class PlayerStatistics extends BaseEntity implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn
    private Player player;

    @Column
    private Short goalsScored;

    @Column
    private Short playerAssists;

    @Column
    private Short minutesPlayed;

}
