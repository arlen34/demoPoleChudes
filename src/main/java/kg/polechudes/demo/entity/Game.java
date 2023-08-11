package kg.polechudes.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private Word wordToGuess;
    private String guessedWord;
    private int remainingAttempts;
    private boolean isGameOver;
}
