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
    //int scoreNum;

    @FXML
    private Label answer;
    @FXML
    private Label right1;
    @FXML
    private Label right2;
    @FXML
    private Label right3;
    @FXML
    private Label right4;
    @FXML
    private Label right5;
    @FXML
    private Label right6;
    @FXML
    private Label score;
    @FXML
    private TextField guess1;
    @FXML
    private TextField guess2;
    @FXML
    private TextField guess3;
    @FXML
    private TextField guess4;
    @FXML
    private TextField guess5;
    @FXML
    private TextField guess6;


    @FXML
    protected void onHelloButtonClick() {
        answer.setText(logic.getGuess());
    }
    @FXML
    protected void onSubmit() {
        boolean[] check1 = logic.checkWord(guess1.getText());
        boolean[] check2 = logic.checkWord(guess2.getText());
        boolean[] check3 = logic.checkWord(guess3.getText());
        boolean[] check4 = logic.checkWord(guess4.getText());
        boolean[] check5 = logic.checkWord(guess5.getText());
        boolean[] check6 = logic.checkWord(guess6.getText());
        if (Arrays.equals(check1, logic.isTrue)) {
            score.setText("You got it in " + 1 + " guess.");
        } else if (Arrays.equals(check2, logic.isTrue)) {
            score.setText("You got it in " + 2 + " guesses.");
        } else if (Arrays.equals(check3, logic.isTrue)) {
            score.setText("You got it in " + 3 + " guesses.");
        } else if (Arrays.equals(check4, logic.isTrue)) {
            score.setText("You got it in " + 4 + " guesses.");
        } else if (Arrays.equals(check5, logic.isTrue)) {
            score.setText("You got it in " + 5 + " guesses.");
        } else if (Arrays.equals(check6, logic.isTrue)) {
            score.setText("You got it in " + 6 + " guesses.");
        } else {
            score.setText("Not the correct word.");
            right1.setText(Arrays.toString(check1));
            right2.setText(Arrays.toString(check2));
            right3.setText(Arrays.toString(check3));
            right4.setText(Arrays.toString(check4));
            right5.setText(Arrays.toString(check5));
            right6.setText(Arrays.toString(check6));
        }
    }
}