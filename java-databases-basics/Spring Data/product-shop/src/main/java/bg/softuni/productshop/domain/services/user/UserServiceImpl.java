package bg.softuni.productshop.domain.services.user;

import bg.softuni.productshop.constants.Utils;
import bg.softuni.productshop.domain.dtos.UserDTO;
import bg.softuni.productshop.domain.dtos.UserWithSoldProductsDTO;
import bg.softuni.productshop.domain.dtos.UserWithSoldProductsDTO2;
import bg.softuni.productshop.domain.dtos.UsersWithSoldProductsWrapperModel;
import bg.softuni.productshop.domain.entities.User;
import bg.softuni.productshop.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static bg.softuni.productshop.constants.Paths.SUCCESSFULLY_SOLD_PRODUCTS_PATH;
import static bg.softuni.productshop.constants.Paths.USERS_AND_PRODUCTS_PATH;
import static bg.softuni.productshop.constants.Utils.MAPPER;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return userRepository.count() > 0;
    }

    @Override
    public void seedUsers(List<User> users) {
        userRepository.saveAllAndFlush(users);
    }

    @Override
    public Optional<User> getRandomEntity() {
        return userRepository.getRandomEntity();
    }

    @Override
    public List<UserWithSoldProductsDTO> getSuccUsers() throws IOException {
        final List<UserWithSoldProductsDTO> users =
                userRepository
                        .findAllBySoldProductsBuyerIsNotNullOrderBySoldProductsBuyerLastNameAscSoldProductsBuyerFirstNameAsc()
                        .stream()
                        .map(u -> MAPPER.map(u, UserWithSoldProductsDTO.class))
                        .toList();

        Utils.writeIntoJSONFile(users, SUCCESSFULLY_SOLD_PRODUCTS_PATH);

        return users;
    }

    @Override
    public UsersWithSoldProductsWrapperModel getSuccUsers2() throws IOException {
        List<UserWithSoldProductsDTO2> usersWithSoldProducts = userRepository
                .findAllBySoldProductsBuyerIsNotNullOrderBySoldProductsBuyerLastNameAscSoldProductsBuyerFirstNameAsc()
                .stream()
                .map(u -> MAPPER.map(u, UserDTO.class))
                .map(UserDTO::toUserWithSoldProductsDTO2)
                .toList();

        UsersWithSoldProductsWrapperModel usersWithSoldProductsWrapperModel =
                new UsersWithSoldProductsWrapperModel(usersWithSoldProducts);

        Utils.writeIntoJSONFile(usersWithSoldProductsWrapperModel, USERS_AND_PRODUCTS_PATH);

        return usersWithSoldProductsWrapperModel;
    }


}
