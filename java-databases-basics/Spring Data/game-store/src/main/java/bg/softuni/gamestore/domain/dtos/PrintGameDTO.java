package bg.softuni.gamestore.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PrintGameDTO {

    private String title;
    private BigDecimal price;

    public PrintGameDTO(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

}
