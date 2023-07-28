package bg.softuni.productshop.domain.dtos.product.wrappers;

import bg.softuni.productshop.domain.dtos.product.ProductBasicInfoDTO2;
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
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportProductWrapperDTO {

    @XmlElement(name = "product")
    private List<ProductBasicInfoDTO2> products;
}
