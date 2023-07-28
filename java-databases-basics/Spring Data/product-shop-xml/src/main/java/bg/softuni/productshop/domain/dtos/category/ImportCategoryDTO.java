package bg.softuni.productshop.domain.dtos.category;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCategoryDTO implements Serializable {

    @Expose
    @XmlElement
    private String name;

    public ImportCategoryDTO(String name) {
        this.name = name;
        validate();
    }

    private void validate() {

        if (name.length() < 3 || 15 < name.length()) {
            throw new IllegalArgumentException("Please insert a category name between 3 and 15 characters");
        }
    }


}
