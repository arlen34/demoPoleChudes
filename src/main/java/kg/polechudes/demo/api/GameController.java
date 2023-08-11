package kg.polechudes.demo.api;

import kg.polechudes.demo.entity.Game;
import kg.polechudes.demo.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    private Game currentGame;

//    @GetMapping("/start")
//    public Game startGame() {
//        currentGame = gameService.startGame();
//        return currentGame;
//    }

    @PostMapping("/guess")
    public Game guessLetter(@RequestParam char letter) {
        currentGame = gameService.guessLetter(currentGame, letter);
        return currentGame;
    }
}

