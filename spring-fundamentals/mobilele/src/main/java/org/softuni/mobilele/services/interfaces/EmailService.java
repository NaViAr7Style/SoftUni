package org.softuni.mobilele.services.interfaces;

public interface EmailService {

    void sendRegistrationEmail(String userEmail, String userFullName, String activationCode);
}
