package bg.softuni.gamestore.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bg.softuni.gamestore.constants.ErrorMessages.*;
import static bg.softuni.gamestore.constants.Validations.GAME_TITLE_PATTERN;
import static bg.softuni.gamestore.constants.Validations.YOUTUBE_URL_PATTERN;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {

    private String title;
    private BigDecimal price;
    private float size;
    private String trailer;
    private String imageThumbnail;
    private String description;
    private LocalDate releaseDate;

    public GameDTO(String title, BigDecimal price, float size, String trailer,
                   String imageThumbnail, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
        validate();
    }

    private void validate() {

        if (!Pattern.matches(GAME_TITLE_PATTERN, this.title)) {
            throw new IllegalArgumentException(INVALID_TITLE);
        }

        if (BigDecimal.ZERO.compareTo(price) >= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }

        if (Float.compare(0, size) >= 0) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }

        if (!trailer.contains("youtube.com") && trailer.length() != 11) {
            throw new IllegalArgumentException(INVALID_TRAILER_URL);
        }

        if (trailer.length() != 11) {
            Pattern pattern = Pattern.compile(YOUTUBE_URL_PATTERN);
            Matcher matcher = pattern.matcher(trailer);

            if (matcher.find()) {
                trailer = matcher.group(1);
            }
        }

        if (!imageThumbnail.contains("http://") && !imageThumbnail.contains("https://")) {
            throw new IllegalArgumentException(INVALID_THUMBNAIL_URL);
        }

        if (description.length() < 20) {
            throw new IllegalArgumentException(SHORT_DESCRIPTION);
        }

    }

    public String successfullyAddedGame() {
        return "Added " + this.title;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return String.format("Title: %s\nPrice: %s\nDescription: %s\nRelease date: %s",
                this.title,
                this.price,
                this.description,
                this.releaseDate.format(formatter));
    }
}
