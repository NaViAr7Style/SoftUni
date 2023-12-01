package org.softuni.mobilele.testUtils;

import org.softuni.mobilele.models.entities.UserRoleEntity;
import org.softuni.mobilele.models.enums.UserRoleEnum;
import org.softuni.mobilele.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(UserRoleEnum.USER);

            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(UserRoleEnum.ADMIN);

            userRoleRepository.saveAll(List.of(userRole, adminRole));
        }
    }
}
