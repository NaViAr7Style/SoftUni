package bg.softuni.gamestore.domain.services.game;

public interface GameService {

    String addGame(String[] args);

    String deleteGame(String[] args);

    String editGame(String[] args);

    String printAllGames(String[] args);

    String printGameDetails(String[] args);
}
