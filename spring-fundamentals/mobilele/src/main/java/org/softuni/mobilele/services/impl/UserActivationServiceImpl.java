package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.entities.UserActivationCodeEntity;
import org.softuni.mobilele.models.entities.UserEntity;
import org.softuni.mobilele.models.events.UserRegisteredEvent;
import org.softuni.mobilele.repositories.UserActivationCodeRepository;
import org.softuni.mobilele.repositories.UserRepository;
import org.softuni.mobilele.services.interfaces.EmailService;
import org.softuni.mobilele.services.interfaces.UserActivationService;
import org.softuni.mobilele.services.exceptions.ObjectNotFoundException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private static final String ACTIVATION_CODE_SYMBOLS =   "abcdefghijklmnopqrstuvwxyz" +
                                                            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                                                            "0123456789";

    private static final int ACTIVATION_CODE_LENGTH = 20;

    private final EmailService emailService;
    private final UserRepository userRepository;
    private final UserActivationCodeRepository userActivationCodeRepository;

    public UserActivationServiceImpl(EmailService emailService,
                                     UserRepository userRepository,
                                     UserActivationCodeRepository userActivationCodeRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userActivationCodeRepository = userActivationCodeRepository;
    }

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {
        String activationCode = createActivationCode(event.getUserEmail());

        emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserFullName(), activationCode);
    }

    @Override
    public void cleanUpObsoleteActivationLinks() {
        //TODO: Implement
    }

    @Override
    public String createActivationCode(String userEmail) {
        UserActivationCodeEntity userActivationCodeEntity = new UserActivationCodeEntity();
        UserEntity user = userRepository
                .findByEmail(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException("User not found!"));

        userActivationCodeEntity.setActivationCode(generateActivationCode());
        userActivationCodeEntity.setCreated(Instant.now());
        userActivationCodeEntity.setUser(user);

        userActivationCodeRepository.save(userActivationCodeEntity);

        return userActivationCodeEntity.getActivationCode();
    }

    private static String generateActivationCode() {

        StringBuilder activationCode = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int randInt = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(randInt));
        }

        return activationCode.toString();
    }

}
