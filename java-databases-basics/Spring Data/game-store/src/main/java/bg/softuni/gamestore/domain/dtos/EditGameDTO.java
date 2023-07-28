package bg.softuni.gamestore.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class EditGameDTO {

    private Long id;
    private String title;
    private BigDecimal price;
    private float size;
    private String trailer;
    private String imageThumbnail;
    private String description;
    private LocalDate releaseDate;

    public String successfullyEditedGame() {
        return "Edited " + this.title;
    }

    public void updateFields(Map<String, String> updatedValues) {

        for (String key : updatedValues.keySet()) {
            switch (key) {
                case "title" -> setTitle(updatedValues.get(key));
                case "price" -> setPrice(new BigDecimal(updatedValues.get(key)));
                case "size" -> setSize(Float.parseFloat(updatedValues.get(key)));
                case "trailer" -> setTrailer(updatedValues.get(key));
                case "thumbnailURL" -> setImageThumbnail(updatedValues.get(key));
                case "description" -> setDescription(updatedValues.get(key));
                case "releaseDate" -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate newDate = LocalDate.parse(updatedValues.get(key), formatter);

                    setReleaseDate(newDate);
                }
            }
        }
    }
}
