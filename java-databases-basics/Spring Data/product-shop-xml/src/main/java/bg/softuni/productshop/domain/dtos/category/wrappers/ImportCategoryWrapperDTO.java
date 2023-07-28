package bg.softuni.productshop.domain.dtos.category.wrappers;

import bg.softuni.productshop.domain.dtos.category.ImportCategoryDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCategoryWrapperDTO {

    @XmlElement(name = "category")
    private List<ImportCategoryDTO> categories;
}
