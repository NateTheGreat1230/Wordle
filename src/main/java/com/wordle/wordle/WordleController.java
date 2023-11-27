package com.wordle.wordle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class WordleController {
    GameLogic logic = new GameLogic();
    //null = logic.setWord();
    String word = logic.getWord();

    @FXML
    private Label answer;
    @FXML
    private Label right;
    @FXML
    private TextField guess1;

    @FXML
    protected void onHelloButtonClick() {
        answer.setText(logic.getGuess());
    }
    @FXML
    protected void onSubmit() {
        boolean[] check = logic.checkWord(guess1.getText());
        boolean[] isTrue = new boolean[5];
        for (int i = 0; i < 5; i++) {
            isTrue[i] = true;
        }
        if (Arrays.equals(check, isTrue)) {
            right.setText("Correct!");
        } else {
            right.setText("Incorrect.");
        }
    }
}