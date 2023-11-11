package org.softuni.mobilele.services.impl;

import org.softuni.mobilele.models.events.UserRegisteredEvent;
import org.softuni.mobilele.services.UserActivationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserActivationServiceImpl implements UserActivationService {

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {
        // TODO: Add Activation links
        System.out.println("User with email " + event.getUserEmail() + " registered successfully!");
    }
}
