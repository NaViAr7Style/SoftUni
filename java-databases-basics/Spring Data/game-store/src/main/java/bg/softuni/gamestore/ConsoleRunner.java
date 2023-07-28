package bg.softuni.gamestore;

import bg.softuni.gamestore.domain.services.game.GameService;
import bg.softuni.gamestore.domain.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static bg.softuni.gamestore.constants.Commands.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final Scanner SCANNER = new Scanner(System.in);
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public ConsoleRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) {
        String input;

        while (!(input = SCANNER.nextLine()).equals(CLOSE)) {

            final String[] arguments = input.split("\\|");
            final String command = arguments[0];

            final String output = switch (command) {
                case REGISTER_USER -> userService.registerUser(arguments);
                case LOG_USER_IN -> userService.loginUser(arguments);
                case LOGOUT_USER -> userService.logoutUser();
                case ADD_GAME -> gameService.addGame(arguments);
                case EDIT_GAME -> gameService.editGame(arguments);
                case DELETE_GAME -> gameService.deleteGame(arguments);
                case PRINT_ALL_GAMES -> gameService.printAllGames(arguments);
                case DETAIL_GAME -> gameService.printGameDetails(arguments);
//                case OWNED_GAMES -> gameService.printOwnedGames(arguments);
                default -> "No command found";
            };

            System.out.println(output);
        }
    }

}
