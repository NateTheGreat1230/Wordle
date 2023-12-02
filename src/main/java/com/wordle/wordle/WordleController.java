package com.wordle.wordle;

import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TextFieldSkin;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class WordleController {
    public VBox grid;
    GameLogic logic = new GameLogic();
    String word = logic.getWord();
    ArrayList<TextField> textBoxes = new ArrayList<>();
    @FXML
    private HBox guess1;
    @FXML
    private HBox guess2;
    @FXML
    private HBox guess3;
    @FXML
    private HBox guess4;
    @FXML
    private HBox guess5;
    @FXML
    private HBox guess6;
    @FXML
    private Label answer;
    @FXML
    private Label score;
    @FXML
    private Label errorSpot;
    @FXML
    private TextField Guess1L1;
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
    TextField current = Guess1L1;
    protected void addEventListeners() {
        makeListSwitch();
        setCurrent(Guess1L1);
        Guess1L2.setFocusTraversable(false);
        Guess1L1.requestFocus();
        addLimiterAndListener(Guess1L1);
        addLimiterAndListener(Guess1L2);
        addLimiterAndListener(Guess1L3);
        addLimiterAndListener(Guess1L4);
        addLimiterAndListenerLast(Guess1L5);
        addLimiterAndListener(Guess2L1);
        addLimiterAndListener(Guess2L2);
        addLimiterAndListener(Guess2L3);
        addLimiterAndListener(Guess2L4);
        addLimiterAndListenerLast(Guess2L5);
        addLimiterAndListener(Guess3L1);
        addLimiterAndListener(Guess3L2);
        addLimiterAndListener(Guess3L3);
        addLimiterAndListener(Guess3L4);
        addLimiterAndListenerLast(Guess3L5);
        addLimiterAndListener(Guess4L1);
        addLimiterAndListener(Guess4L2);
        addLimiterAndListener(Guess4L3);
        addLimiterAndListener(Guess4L4);
        addLimiterAndListenerLast(Guess4L5);
        addLimiterAndListener(Guess5L1);
        addLimiterAndListener(Guess5L2);
        addLimiterAndListener(Guess5L3);
        addLimiterAndListener(Guess5L4);
        addLimiterAndListenerLast(Guess5L5);
        addLimiterAndListener(Guess6L1);
        addLimiterAndListener(Guess6L2);
        addLimiterAndListener(Guess6L3);
        addLimiterAndListener(Guess6L4);
        addLimiterAndListenerLast(Guess6L5);
    }
    public String makeString() {
        switch(logic.guessNum) {
            case 0: {
                String L1 = Guess1L1.getText();
                String L2 = Guess1L2.getText();
                String L3 = Guess1L3.getText();
                String L4 = Guess1L4.getText();
                String L5 = Guess1L5.getText();
                String guess = (L1 + L2 + L3 + L4 + L5);
                return guess;
            } case 1: {
                String L1 = Guess2L1.getText();
                String L2 = Guess2L2.getText();
                String L3 = Guess2L3.getText();
                String L4 = Guess2L4.getText();
                String L5 = Guess2L5.getText();
                String guess = (L1+L2+L3+L4+L5);
                return guess;
            } case 2: {
                String L1 = Guess3L1.getText();
                String L2 = Guess3L2.getText();
                String L3 = Guess3L3.getText();
                String L4 = Guess3L4.getText();
                String L5 = Guess3L5.getText();
                String guess = (L1+L2+L3+L4+L5);
                return guess;
            } case 3: {
                String L1 = Guess4L1.getText();
                String L2 = Guess4L2.getText();
                String L3 = Guess4L3.getText();
                String L4 = Guess4L4.getText();
                String L5 = Guess4L5.getText();
                String guess = (L1+L2+L3+L4+L5);
                return guess;
            } case 4: {
                String L1 = Guess5L1.getText();
                String L2 = Guess5L2.getText();
                String L3 = Guess5L3.getText();
                String L4 = Guess5L4.getText();
                String L5 = Guess5L5.getText();
                String guess = (L1+L2+L3+L4+L5);
                return guess;
            } case 5: {
                String L1 = Guess6L1.getText();
                String L2 = Guess6L2.getText();
                String L3 = Guess6L3.getText();
                String L4 = Guess6L4.getText();
                String L5 = Guess6L5.getText();
                String guess = (L1+L2+L3+L4+L5);
                return guess;
            } case 6: {
                errorSpot.setText("Too many Guesses error");
            }
        }
        return null;
    }
    public void addLimiterAndListenerLast(final TextField tf) {
        KeyCombination enterPressed = new KeyCodeCombination(KeyCode.ENTER);
        KeyCombination backspacePressed = new KeyCodeCombination(KeyCode.BACK_SPACE);
        tf.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                current.requestFocus();
            }
        });
        tf.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if(backspacePressed.match(event)){
                    errorSpot.setText("");
                    Robot robot = new Robot();
                    robot.keyPress(KeyCode.SHIFT);
                    robot.keyPress(KeyCode.TAB);
                    robot.keyRelease(KeyCode.TAB);
                    robot.keyRelease(KeyCode.SHIFT);
                    robot.keyPress(KeyCode.BACK_SPACE);
                    robot.keyPress(KeyCode.BACK_SPACE);
                }
                if(enterPressed.match(event)){
                    errorSpot.setText("");
                    String guess = makeString();
                    try {
                        if (logic.inList(guess) == true) {
                            String[] checked = logic.checkWord(guess);
                            setColors(checked);
                            Robot robot = new Robot();
                            robot.keyPress(KeyCode.TAB);
                            robot.keyRelease(KeyCode.TAB);
                        } else {
                            errorSpot.setText("Not in word list.");
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        final int maxLength = 1;
        tf.textProperty().addListener((ov, oldValue, newValue) -> {
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            }
        });

    }
    public void addLimiterAndListener(final TextField tf) {
        KeyCombination enterPressed = new KeyCodeCombination(KeyCode.ENTER);
        KeyCombination tabPressed = new KeyCodeCombination(KeyCode.TAB);
        KeyCombination backspacePressed = new KeyCodeCombination(KeyCode.BACK_SPACE);
        tf.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                current.requestFocus();
            }
        });
        tf.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (backspacePressed.match(event)) {
                    traverseBackward();
//                    Robot robot = new Robot();
//                    robot.keyPress(KeyCode.BACK_SPACE);
//                    robot.keyPress(KeyCode.BACK_SPACE);
//                    robot.keyPress(KeyCode.SHIFT);
//                    robot.keyPress(KeyCode.TAB);
//                    robot.keyRelease(KeyCode.TAB);
//                    robot.keyRelease(KeyCode.SHIFT);
//                    robot.keyPress(KeyCode.BACK_SPACE);
//                    robot.keyPress(KeyCode.BACK_SPACE);
                }
                if(enterPressed.match(event)) {
                    errorSpot.setText("Not enough Letters");
                }
                if (tabPressed.match(event)) {
                    System.out.println("TAB~!!!!!");
                }

            }
        });
        final int maxLength = 1;
        tf.textProperty().addListener((ov, oldValue, newValue) -> {
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            } else {
                traverseForward();
            }
        });
    }
    @FXML
    protected void onGetGuessClick() {
        answer.setText(logic.getGuess());
    }
    public void setColors(String[] guess) {
        switch (logic.guessNum) {
            case 1: {
                TextField[] tf = new TextField[]{Guess1L1, Guess1L2, Guess1L3, Guess1L4, Guess1L5};
                makeMap(tf, guess);
                checkWin(guess);
                break;
            } case 2: {
                TextField[] tf = new TextField[]{Guess2L1, Guess2L2, Guess2L3, Guess2L4, Guess2L5};
                makeMap(tf, guess);
                checkWin(guess);
                break;
            } case 3: {
                TextField[] tf = new TextField[]{Guess3L1, Guess3L2, Guess3L3, Guess3L4, Guess3L5};
                makeMap(tf, guess);
                checkWin(guess);
                break;
            } case 4: {
                TextField[] tf = new TextField[]{Guess4L1, Guess4L2, Guess4L3, Guess4L4, Guess4L5};
                makeMap(tf, guess);
                checkWin(guess);
                break;
            } case 5: {
                TextField[] tf = new TextField[]{Guess5L1, Guess5L2, Guess5L3, Guess5L4, Guess5L5};
                makeMap(tf, guess);
                checkWin(guess);
                break;
            } case 6: {
                TextField[] tf = new TextField[]{Guess6L1, Guess6L2, Guess6L3, Guess6L4, Guess6L5};
                makeMap(tf, guess);
                checkWin(guess);
                break;
            }
        }
    }
    public void makeMap(TextField[] tf, String[] guess) {
        Map<TextField, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(tf[i], guess[i]);
        }
        for (Map.Entry<TextField, String> entry : map.entrySet()) {
            setColors(entry.getKey(), entry.getValue());
        }
    }
    public void setColors(TextField tf, String letter) {
        if (letter.equals("true")) {
            tf.setStyle("-fx-control-inner-background: #538d4eff");
        } else if (letter.equals("false")) {
            tf.setStyle("-fx-control-inner-background: #3a3a3cff");
        } else if (letter.equals("contains")) {
            tf.setStyle("-fx-control-inner-background: #b59f3bff");
        }
    }
    public void checkWin(String[] guess) {
        if (Arrays.equals(guess, new String[]{"true", "true", "true", "true", "true"})) {
            Label label = new Label("you win!");
            Popup popup = new Popup();

            // set background
            label.setStyle("-fx-background-color: white;");

            // add the label
            popup.getContent().add(label);

            // set size of label
            label.setMinWidth(80);
            label.setMinHeight(50);
            Window window = Guess1L4.getScene().getWindow();
            popup.show(window);
            //popup.show((Window) Stage.getWindows().stream().filter(Window::isShowing));
        }
    }
    public void setCurrent(TextField tf) {
        current = tf;
    }
    public void makeListSwitch() {
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0: {
                    TextField[] tf = new TextField[]{Guess1L1, Guess1L2, Guess1L3, Guess1L4, Guess1L5};
                    makeList(tf);
                    break;
                } case 1: {
                    TextField[] tf = new TextField[]{Guess2L1, Guess2L2, Guess2L3, Guess2L4, Guess2L5};
                    makeList(tf);
                    break;
                } case 2: {
                    TextField[] tf = new TextField[]{Guess3L1, Guess3L2, Guess3L3, Guess3L4, Guess3L5};
                    makeList(tf);
                    break;
                } case 3: {
                    TextField[] tf = new TextField[]{Guess4L1, Guess4L2, Guess4L3, Guess4L4, Guess4L5};
                    makeList(tf);
                    break;
                } case 4: {
                    TextField[] tf = new TextField[]{Guess5L1, Guess5L2, Guess5L3, Guess5L4, Guess5L5};
                    makeList(tf);
                    break;
                } case 5: {
                    TextField[] tf = new TextField[]{Guess6L1, Guess6L2, Guess6L3, Guess6L4, Guess6L5};
                    makeList(tf);
                    break;
                }
            }
        }
    }
    public void makeList(TextField[] textFields) {
        for (TextField textField : textFields) {
            textBoxes.add(textField);
        }
    }
    public TextField traverseForward() {
        int theCurrent = textBoxes.indexOf(current);
        if (!current.getText().equals("")) {
            TextField next = textBoxes.get(theCurrent+1);
            current = next;
            current.requestFocus();
            return next;
        }
        return current;
    }
    public TextField traverseBackward() {
        int theCurrent = textBoxes.indexOf(current);
        TextField prev = textBoxes.get(theCurrent-1);
        current = prev;
        current.requestFocus();
        Robot robot = new Robot();
        robot.keyPress(KeyCode.DELETE);
        robot.keyRelease(KeyCode.DELETE);
        return prev;
    }
}