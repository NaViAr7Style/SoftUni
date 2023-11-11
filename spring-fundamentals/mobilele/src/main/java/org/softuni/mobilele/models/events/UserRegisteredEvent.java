package org.softuni.mobilele.models.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserRegisteredEvent extends ApplicationEvent {

    private final String userEmail;

    public UserRegisteredEvent(Object source, String userEmail) {
        super(source);
        this.userEmail = userEmail;
    }

}
