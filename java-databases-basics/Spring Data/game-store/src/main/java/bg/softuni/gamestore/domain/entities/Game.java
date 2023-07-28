package bg.softuni.gamestore.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
public class Game extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column
    private String trailer;

    @Column(name = "image_thumbnail")
    private String imageThumbnail;

    @Column
    private float size;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private String description;

    @Column
    private LocalDate releaseDate;

}
