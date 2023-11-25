package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.events.UserRegisteredEvent;
import org.softuni.mobilele.services.EmailService;
import org.softuni.mobilele.services.UserActivationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    private final EmailService emailService;

    public UserActivationServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {
        // TODO: Add Activation links
        emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserFullName());
    }

    @Override
    public void cleanUpObsoleteActivationLinks() {
        //TODO: Implement
        System.out.println("Not yet implemented.");
    }
}
