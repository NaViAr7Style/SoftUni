package bg.softuni.productshop.domain.dtos.user.wrappers;

import bg.softuni.productshop.domain.dtos.user.UserWithSoldProductsDTO2;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersWithSoldProductsWrapperModel {

    @Expose
    private Integer usersCount;

    @Expose
    private List<UserWithSoldProductsDTO2> users;

    public UsersWithSoldProductsWrapperModel(List<UserWithSoldProductsDTO2> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
