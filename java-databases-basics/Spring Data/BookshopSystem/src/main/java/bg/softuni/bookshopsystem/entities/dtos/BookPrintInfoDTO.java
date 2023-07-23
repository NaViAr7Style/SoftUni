package bg.softuni.bookshopsystem.entities.dtos;

import bg.softuni.bookshopsystem.entities.enums.AgeRestriction;
import bg.softuni.bookshopsystem.entities.enums.EditionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BookPrintInfoDTO {

    private String title;
    private EditionType editionType;
    private AgeRestriction ageRestriction;
    private BigDecimal price;

    public BookPrintInfoDTO(String title, EditionType editionType, AgeRestriction ageRestriction, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", title, editionType, ageRestriction, price);
    }

}
