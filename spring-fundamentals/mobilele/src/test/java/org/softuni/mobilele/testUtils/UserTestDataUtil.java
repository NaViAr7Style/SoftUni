package org.softuni.mobilele.testUtils;

import org.softuni.mobilele.models.entities.UserEntity;
import org.softuni.mobilele.models.entities.UserRoleEntity;
import org.softuni.mobilele.models.enums.UserRoleEnum;
import org.softuni.mobilele.repositories.UserRepository;
import org.softuni.mobilele.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTestDataUtil {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserEntity createTestUser(String username) {
        return createUser(List.of(UserRoleEnum.USER), username);
    }

    public UserEntity createTestAdmin(String username) {
        return createUser(List.of(UserRoleEnum.ADMIN), username);
    }

    private UserEntity createUser(List<UserRoleEnum> roles, String username) {

        List<UserRoleEntity> roleEntities = userRoleRepository.findAllByRoleIn(roles);

        UserEntity newUser = new UserEntity();

        newUser.setActive(true);
        newUser.setEmail(username);
        newUser.setFirstName("firstName");
        newUser.setLastName("lastName");
        newUser.setRoles(roleEntities);

        return userRepository.save(newUser);
    }

    public void cleanUp() {
        userRepository.deleteAll();
    }
}
