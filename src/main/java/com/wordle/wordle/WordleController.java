package com.wordle.wordle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
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
//    @FXML
//    private Label right1;
//    @FXML
//    private Label right2;
//    @FXML
//    private Label right3;
//    @FXML
//    private Label right4;
//    @FXML
//    private Label right5;
//    @FXML
//    private Label right6;
    @FXML
    private Label score;
    @FXML
    TextField Guess1L1;
    @FXML
    private TextField Guess1L2;
    @FXML
    private TextField Guess1L3;
    @FXML
    private TextField Guess1L4;
    @FXML
    private TextField Guess1L5;
    @FXML
    private TextField Guess2L1;
    @FXML
    private TextField Guess2L2;
    @FXML
    private TextField Guess2L3;
    @FXML
    private TextField Guess2L4;
    @FXML
    private TextField Guess2L5;
    @FXML
    private TextField Guess3L1;
    @FXML
    private TextField Guess3L2;
    @FXML
    private TextField Guess3L3;
    @FXML
    private TextField Guess3L4;
    @FXML
    private TextField Guess3L5;
    @FXML
    private TextField Guess4L1;
    @FXML
    private TextField Guess4L2;
    @FXML
    private TextField Guess4L3;
    @FXML
    private TextField Guess4L4;
    @FXML
    private TextField Guess4L5;
    @FXML
    private TextField Guess5L1;
    @FXML
    private TextField Guess5L2;
    @FXML
    private TextField Guess5L3;
    @FXML
    private TextField Guess5L4;
    @FXML
    private TextField Guess5L5;
    @FXML
    private TextField Guess6L1;
    @FXML
    private TextField Guess6L2;
    @FXML
    private TextField Guess6L3;
    @FXML
    private TextField Guess6L4;
    @FXML
    private TextField Guess6L5;


    //Guess1L1.addEventFilter()
    @FXML
    protected void onStartClick() {
        addEventListeners();
    }
    protected void addEventListeners() {

        logic.addListenerAndLimiter(Guess1L1);
        logic.addListenerAndLimiter(Guess1L2);
        logic.addListenerAndLimiter(Guess1L3);
        logic.addListenerAndLimiter(Guess1L4);
        logic.addListenerAndLimiter(Guess1L5);
        logic.addListenerAndLimiter(Guess2L1);
        logic.addListenerAndLimiter(Guess2L2);
        logic.addListenerAndLimiter(Guess2L3);
        logic.addListenerAndLimiter(Guess2L4);
        logic.addListenerAndLimiter(Guess2L5);
        logic.addListenerAndLimiter(Guess3L1);
        logic.addListenerAndLimiter(Guess3L2);
        logic.addListenerAndLimiter(Guess3L3);
        logic.addListenerAndLimiter(Guess3L4);
        logic.addListenerAndLimiter(Guess3L5);
        logic.addListenerAndLimiter(Guess4L1);
        logic.addListenerAndLimiter(Guess4L2);
        logic.addListenerAndLimiter(Guess4L3);
        logic.addListenerAndLimiter(Guess4L4);
        logic.addListenerAndLimiter(Guess4L5);
        logic.addListenerAndLimiter(Guess5L1);
        logic.addListenerAndLimiter(Guess5L2);
        logic.addListenerAndLimiter(Guess5L3);
        logic.addListenerAndLimiter(Guess5L4);
        logic.addListenerAndLimiter(Guess5L5);
        logic.addListenerAndLimiter(Guess6L1);
        logic.addListenerAndLimiter(Guess6L2);
        logic.addListenerAndLimiter(Guess6L3);
        logic.addListenerAndLimiter(Guess6L4);
        logic.addListenerAndLimiter(Guess6L5);
    }
    @FXML
    protected void onGetGuessClick() {
        answer.setText(logic.getGuess());
    }
//    @FXML
//    protected void onSubmit() {
//        boolean[] check1 = logic.checkWord(Guess1L1.getText());
//        boolean[] check2 = logic.checkWord(guess2.getText());
//        boolean[] check3 = logic.checkWord(guess3.getText());
//        boolean[] check4 = logic.checkWord(guess4.getText());
//        boolean[] check5 = logic.checkWord(guess5.getText());
//        boolean[] check6 = logic.checkWord(guess6.getText());
//        if (Arrays.equals(check1, logic.isTrue)) {
//            score.setText("You got it in " + 1 + " guess.");
//        } else if (Arrays.equals(check2, logic.isTrue)) {
//            score.setText("You got it in " + 2 + " guesses.");
//        } else if (Arrays.equals(check3, logic.isTrue)) {
//            score.setText("You got it in " + 3 + " guesses.");
//        } else if (Arrays.equals(check4, logic.isTrue)) {
//            score.setText("You got it in " + 4 + " guesses.");
//        } else if (Arrays.equals(check5, logic.isTrue)) {
//            score.setText("You got it in " + 5 + " guesses.");
//        } else if (Arrays.equals(check6, logic.isTrue)) {
//            score.setText("You got it in " + 6 + " guesses.");
//        } else {
//            score.setText("Not the correct word.");
//            right1.setText(Arrays.toString(check1));
//            right2.setText(Arrays.toString(check2));
//            right3.setText(Arrays.toString(check3));
//            right4.setText(Arrays.toString(check4));
//            right5.setText(Arrays.toString(check5));
//            right6.setText(Arrays.toString(check6));
//        }
//    }
}