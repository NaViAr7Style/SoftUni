package org.softuni.mobilele.services.interfaces;

import org.softuni.mobilele.models.events.UserRegisteredEvent;

public interface UserActivationService {

    void userRegistered(UserRegisteredEvent userRegisteredEvent);

    void cleanUpObsoleteActivationLinks();

    String createActivationCode(String userEmail);
}
