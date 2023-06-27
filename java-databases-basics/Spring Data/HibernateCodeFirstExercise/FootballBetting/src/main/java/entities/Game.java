package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game extends BaseEntity {

    @OneToOne
    @JoinColumn
    private Team homeTeam;

    @OneToOne
    @JoinColumn
    private Team awayTeam;

    @Column(name = "home_goals")
    private Short homeGoals;

    @Column(name = "away_goals")
    private Short awayGoals;

    @Column
    private Date date;

    @Column
    private Double homeTeamWinBetRate;

    @Column
    private Double awayTeamWinBetRate;

    @Column
    private Double drawGameBetRate;

    @ManyToOne
    @JoinColumn
    private Round round;

    @ManyToOne
    @JoinColumn
    private Competition competition;

}
