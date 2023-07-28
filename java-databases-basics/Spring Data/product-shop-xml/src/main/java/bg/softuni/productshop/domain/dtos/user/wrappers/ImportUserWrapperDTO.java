package bg.softuni.productshop.domain.dtos.user.wrappers;

import bg.softuni.productshop.domain.dtos.user.ImportUserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportUserWrapperDTO {

    @XmlElement(name = "user")
    private List<ImportUserDTO> users;
}
