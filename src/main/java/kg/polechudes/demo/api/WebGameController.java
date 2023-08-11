package kg.polechudes.demo.api;

import kg.polechudes.demo.entity.Game;
import kg.polechudes.demo.service.GameService;
import kg.polechudes.demo.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/game")
public class WebGameController {
    private final GameService gameService;
    private final WordService wordService;

    public WebGameController(GameService gameService, WordService wordService) {
        this.gameService = gameService;
        this.wordService = wordService;
    }

    private Game currentGame;

    @GetMapping
    public String showGame(Model model) {
        if (currentGame == null || currentGame.isGameOver()) {
            currentGame = gameService.startGame(wordService.getRandomWordWithQuestion());
        }
        model.addAttribute("currentGame", currentGame);
        return "game";
    }

    @PostMapping("/guess")
    public String guessLetter(@RequestParam char letter, Model model) {
        currentGame = gameService.guessLetter(currentGame, letter);
        model.addAttribute("currentGame", currentGame);
        return "game";
    }

    @PostMapping("/guessWord")
    public String guessWord(@RequestParam String word, Model model) {
        if (!currentGame.isGameOver()) {
            if (currentGame.getWordToGuess().getValue().equalsIgnoreCase(word)) {
                currentGame.setGuessedWord(currentGame.getWordToGuess().getValue());
            }
            currentGame.setGameOver(true);
        }
        model.addAttribute("currentGame", currentGame);
        return "game";
    }

}

