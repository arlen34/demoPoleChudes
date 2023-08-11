package kg.polechudes.demo.service;

import kg.polechudes.demo.entity.Game;
import kg.polechudes.demo.entity.Word;
import kg.polechudes.demo.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {

    private final WordRepository wordRepository;

//    public GameService(WordRepository wordRepository) {
//        this.wordRepository = wordRepository;
//    }

//    private String[] words = {"apple", "banana", "cherry", "grape", "orange"};

    //    public Game startGame() {
//        Game game = new Game();
//        game.setWordToGuess(words[new Random().nextInt(words.length)]);
//        game.setGuessedWord("_".repeat(game.getWordToGuess().length()));
//        game.setRemainingAttempts(6);
//        game.setGameOver(false);
//        return game;
//    }
    public Game startGame(Word word) {
        Game game = new Game();
//        Word randomWord = getRandomWord();
        game.setWordToGuess(word);
        game.setGuessedWord("_".repeat(word.getValue().length()));
        game.setRemainingAttempts(6);
        game.setGameOver(false);
        return game;
    }

    public Game guessLetter(Game game, char letter) {
        if (!game.isGameOver()) {
            Word wordToGuess = game.getWordToGuess();
            String wordValue = wordToGuess.getValue();
            String guessedWord = game.getGuessedWord();

            StringBuilder newGuessedWord = new StringBuilder(guessedWord);
            boolean found = false;

            for (int i = 0; i < wordValue.length(); i++) {
                if (wordValue.charAt(i) == letter) {
                    newGuessedWord.setCharAt(i, letter);
                    found = true;
                }
            }

            if (!found) {
                game.setRemainingAttempts(game.getRemainingAttempts() - 1);
            }

            game.setGuessedWord(newGuessedWord.toString());

            if (newGuessedWord.toString().equals(wordValue) || game.getRemainingAttempts() == 0) {
                game.setGameOver(true);
            }
        }

        return game;
    }
}
