package org.softuni.mobilele.services.schedulers;

import org.softuni.mobilele.services.UserActivationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ActivationLinkCleanUpScheduler {

    private final UserActivationService userActivationService;

    public ActivationLinkCleanUpScheduler(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void cleanUp() {
        userActivationService.cleanUpObsoleteActivationLinks();
    }
}
