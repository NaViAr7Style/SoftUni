package org.softuni.mobilele.models.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserRegisteredEvent extends ApplicationEvent {

    private final String userEmail;
    private final String userFullName;

    public UserRegisteredEvent(Object source,
                               String userEmail,
                               String userFullName) {
        super(source);
        this.userEmail = userEmail;
        this.userFullName = userFullName;
    }

}
