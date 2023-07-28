package bg.softuni.productshop.domain.services.user;

import bg.softuni.productshop.domain.dtos.UserWithSoldProductsDTO;
import bg.softuni.productshop.domain.dtos.UsersWithSoldProductsWrapperModel;
import bg.softuni.productshop.domain.entities.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {


    boolean isDataSeeded();

    void seedUsers(List<User> users);

    Optional<User> getRandomEntity();

    List<UserWithSoldProductsDTO> getSuccUsers() throws IOException;

    UsersWithSoldProductsWrapperModel getSuccUsers2() throws IOException;
}
