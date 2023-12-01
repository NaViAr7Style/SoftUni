package org.softuni.mobilele.services.schedulers;

import org.softuni.mobilele.services.interfaces.UserActivationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
