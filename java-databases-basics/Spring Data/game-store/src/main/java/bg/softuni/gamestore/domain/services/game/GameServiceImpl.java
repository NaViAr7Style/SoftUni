package bg.softuni.gamestore.domain.services.game;

import bg.softuni.gamestore.domain.dtos.EditGameDTO;
import bg.softuni.gamestore.domain.dtos.GameDTO;
import bg.softuni.gamestore.domain.dtos.PrintGameDTO;
import bg.softuni.gamestore.domain.entities.Game;
import bg.softuni.gamestore.domain.repositories.GameRepository;
import bg.softuni.gamestore.domain.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static bg.softuni.gamestore.constants.ErrorMessages.*;

@Service
public class GameServiceImpl implements GameService {

    private final ModelMapper modelMapper;
    private final GameRepository gameRepository;
    private final UserService userService;

    public GameServiceImpl(GameRepository gameRepository, UserService userService) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public String addGame(String[] args) {
        if (this.userService.userIsNotAdmin()) {
            return NOT_ADMIN;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int argsLength = args.length;

        final String title = argsLength > 1 ? args[1] : "";
        final BigDecimal price = argsLength > 2 ? new BigDecimal(args[2]) : BigDecimal.ZERO;
        final float size = argsLength > 3 ? Float.parseFloat(args[3]) : 0;
        final String trailer = argsLength > 4 ? args[4] : "";
        final String thumbnailURL = argsLength > 5 ? args[5] : null;
        final String description = argsLength > 6 ? args[6] : "";
        final LocalDate releaseDate = argsLength > 7 ? LocalDate.parse(args[7], formatter) : LocalDate.now();

        GameDTO gameDTO;

        try {
            gameDTO = new GameDTO(title, price, size, trailer, thumbnailURL, description, releaseDate);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        Game gameToBeSaved = modelMapper.map(gameDTO, Game.class);

        gameRepository.saveAndFlush(gameToBeSaved);

        return gameDTO.successfullyAddedGame();
    }

    @Override
    public String deleteGame(String[] args) {
        String notValid = validateOperation(args);
        if (notValid != null) {
            return notValid;
        }

        final Long id = Long.parseLong(args[1]);
        final Optional<Game> byId = gameRepository.findById(id);

        if (byId.isEmpty()) {
            return NO_SUCH_GAME;
        }

        gameRepository.delete(byId.get());

        return "Deleted " + byId.get().getTitle();
    }

    @Override
    public String editGame(String[] args) {
        String notValid = validateOperation(args);
        if (notValid != null) {
            return notValid;
        }

        final Long id = Long.parseLong(args[1]);
        final Optional<Game> byId = gameRepository.findById(id);

        Map<String, String> updatingArguments = new HashMap<>();

        for (int i = 2; i < args.length; i++) {
            String[] argumentsForUpdate = args[i].split("=");

            updatingArguments.put(argumentsForUpdate[0], argumentsForUpdate[1]);
        }

        final EditGameDTO editGameDTO = modelMapper.map(byId, EditGameDTO.class);
        editGameDTO.updateFields(updatingArguments);

        Game updatedGame = modelMapper.map(editGameDTO, Game.class);

        gameRepository.saveAndFlush(updatedGame);

        return editGameDTO.successfullyEditedGame();
    }

    @Override
    public String printAllGames(String[] args) {

        List<Game> allGames = gameRepository.findAll();

        PrintGameDTO[] printGameDTOS = modelMapper.map(allGames, PrintGameDTO[].class);

        StringBuilder sb = new StringBuilder();

        Arrays.stream(printGameDTOS)
                .forEach(g -> sb.append(String.format("%s %s\n", g.getTitle(), g.getPrice())));

        return sb.toString().trim();
    }

    @Override
    public String printGameDetails(String[] args) {
        int argsLength = args.length;

        if (argsLength <= 1) {
            return NOT_ENOUGH_ARGS;
        }

        final String title = args[1];
        Optional<Game> byTitle = gameRepository.findByTitle(title);

        if (byTitle.isEmpty()) {
            return NO_SUCH_GAME;
        }

        GameDTO gameToPrint = modelMapper.map(byTitle.get(), GameDTO.class);

        return gameToPrint.toString();
    }

    private String validateOperation(String[] args) {
        if (this.userService.userIsNotAdmin()) {
            return NOT_ADMIN;
        }

        int argsLength = args.length;

        if (argsLength <= 1) {
            return NOT_ENOUGH_ARGS;
        }

        final Long id = Long.parseLong(args[1]);
        final Optional<Game> byId = gameRepository.findById(id);

        if (byId.isEmpty()) {
            return NO_SUCH_GAME;
        }

        return null;
    }

}
