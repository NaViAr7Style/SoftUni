package bg.softuni.springdataintro;

import bg.softuni.springdataintro.models.User;
import bg.softuni.springdataintro.services.AccountService;
import bg.softuni.springdataintro.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AccountService accountService;

    private final UserService userService;

    public ConsoleRunner(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {

        User someUser = new User("Some Other User", 20);
        userService.register(someUser);

        accountService.withdrawMoney(BigDecimal.valueOf(10), 1L);

    }

}
