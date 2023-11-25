package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.dtos.UserRegistrationDTO;
import org.softuni.mobilele.models.entities.UserEntity;
import org.softuni.mobilele.models.events.UserRegisteredEvent;
import org.softuni.mobilele.repositories.UserRepository;
import org.softuni.mobilele.services.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher appEventPublisher;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ApplicationEventPublisher appEventPublisher) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.appEventPublisher = appEventPublisher;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map((userRegistrationDTO)));

        appEventPublisher.publishEvent(new UserRegisteredEvent(
                "UserService",
                userRegistrationDTO.email(),
                userRegistrationDTO.fullName()
        ));
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        UserEntity user = new UserEntity();

        user.setActive(false);
        user.setFirstName(userRegistrationDTO.firstName());
        user.setLastName(userRegistrationDTO.lastName());
        user.setEmail(userRegistrationDTO.email());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

        return user;
    }

}
