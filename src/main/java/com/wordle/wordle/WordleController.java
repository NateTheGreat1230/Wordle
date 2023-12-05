package com.wordle.wordle;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
    GameLogic logic = new GameLogic();
    String word = logic.getWord();
    ArrayList<TextField> textBoxes = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();
    HashMap<Button, String> alphaHashMap = new HashMap<>();
    @FXML
    private Label answer;
    @FXML
    private Label score;
    @FXML
    private Label errorSpot;
    @FXML private TextField
            Guess1L1, Guess1L2, Guess1L3, Guess1L4, Guess1L5,
            Guess2L1, Guess2L2, Guess2L3, Guess2L4, Guess2L5,
            Guess3L1, Guess3L2, Guess3L3, Guess3L4, Guess3L5,
            Guess4L1, Guess4L2, Guess4L3, Guess4L4, Guess4L5,
            Guess5L1, Guess5L2, Guess5L3, Guess5L4, Guess5L5,
            Guess6L1, Guess6L2, Guess6L3, Guess6L4, Guess6L5;
    @FXML private Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ,
            btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT,
            btnU, btnV, btnW, btnX, btnY, btnZ, btnENT, btnDEL;
    TextField current = Guess1L1;
    protected void addEventListeners() {
        makeListSwitch();
        makeAlphaList();
        setCurrent(Guess1L1);
        Guess1L1.requestFocus();
        addLimiterAndListenerFirst(Guess1L1);
        addLimiterAndListener(Guess1L2);
        addLimiterAndListener(Guess1L3);
        addLimiterAndListener(Guess1L4);
        addLimiterAndListenerLast(Guess1L5);
        addLimiterAndListenerFirst(Guess2L1);
        addLimiterAndListener(Guess2L2);
        addLimiterAndListener(Guess2L3);
        addLimiterAndListener(Guess2L4);
        addLimiterAndListenerLast(Guess2L5);
        addLimiterAndListenerFirst(Guess3L1);
        addLimiterAndListener(Guess3L2);
        addLimiterAndListener(Guess3L3);
        addLimiterAndListener(Guess3L4);
        addLimiterAndListenerLast(Guess3L5);
        addLimiterAndListenerFirst(Guess4L1);
        addLimiterAndListener(Guess4L2);
        addLimiterAndListener(Guess4L3);
        addLimiterAndListener(Guess4L4);
        addLimiterAndListenerLast(Guess4L5);
        addLimiterAndListenerFirst(Guess5L1);
        addLimiterAndListener(Guess5L2);
        addLimiterAndListener(Guess5L3);
        addLimiterAndListener(Guess5L4);
        addLimiterAndListenerLast(Guess5L5);
        addLimiterAndListenerFirst(Guess6L1);
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
        KeyCombination tabPressed = new KeyCodeCombination(KeyCode.TAB);
        KeyCombination backspacePressed = new KeyCodeCombination(KeyCode.BACK_SPACE);
        tf.setOnMouseClicked(mouseEvent -> current.requestFocus());
        tf.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (backspacePressed.match(event)) {
                event.consume();
                errorSpot.setText("");
                if (current.getText().equals("")) {
                    traverseBackward();
                    current.requestFocus();
                } else {
                    current.setText("");
                    current.requestFocus();
                }
            } else if (enterPressed.match(event)) {
                errorSpot.setText("");
                String guess = makeString();
                if (!current.getText().equals("")) {
                    try {
                        if (logic.inList(guess)) {
                            String[] checked = logic.checkWord(guess);
                            setColors(checked);
                            looseScreen(checked);
                            if (textBoxes.indexOf(current) + 1 != textBoxes.size()) {
                                traverseForward();
                            }
                        } else {
                            errorSpot.setText("Not in word list.");
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else if (tabPressed.match(event)) {
                    current.requestFocus();
                }
            } else {
                errorSpot.setText("Not enough letters.");
            }
        });
        final int maxLength = 1;
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z]*")) {
                tf.setText(oldValue);
                errorSpot.setText("Not a valid input");
            } else {
                tf.setText(newValue.toUpperCase());
                errorSpot.setText("");
            }
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
                    errorSpot.setText("");
                }
                if(enterPressed.match(event)) {
                    errorSpot.setText("Not enough Letters");
                }
                if (tabPressed.match(event)) {
                    current.requestFocus();
                    errorSpot.setText("");
                }
            }
        });
        final int maxLength = 1;
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z]*")) {
                tf.setText(oldValue);
                errorSpot.setText("Not a valid input");
            } else {
                errorSpot.setText("");
                tf.setText(newValue.toUpperCase());
                traverseForward();
            }
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            }
        });
    }
    public void addLimiterAndListenerFirst(final TextField tf) {
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
                    current.requestFocus();
                }
                if(enterPressed.match(event)) {
                    errorSpot.setText("Not enough Letters");
                }
                if (tabPressed.match(event)) {
                    current.requestFocus();
                }

            }
        });
        final int maxLength = 1;
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("[a-zA-Z]*")) {
                tf.setText(oldValue);
                errorSpot.setText("Not a valid input");
            } else {
                errorSpot.setText("");
                tf.setText(newValue.toUpperCase());
                traverseForward();
            }
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            }
        });
    }
    @FXML
    protected void onGetGuessClick() {
        answer.setText(logic.getGuess());
        current.requestFocus();
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
            setAlphaColors(entry.getKey().getText(), entry.getValue());
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
    public void setAlphaColors(String tfLetter, String letter) {
        Button button = new Button();
        for (Map.Entry<Button, String> entry : alphaHashMap.entrySet()) {
            if (entry.getValue().equals(tfLetter)) {
                button = entry.getKey();
            }
        }
        if (letter.equals("true")) {
            button.setStyle("-fx-background-color: #538d4eff");
        } else if (letter.equals("false")) {
            button.setStyle("-fx-background-color: #3a3a3cff");
        } else if (letter.equals("contains")) {
            button.setStyle("-fx-background-color: #b59f3bff");
        }
    }
    public void checkWin(String[] guess) {
        if (Arrays.equals(guess, new String[]{"true", "true", "true", "true", "true"})) {
            Label label = new Label("You win! You guessed it in " + logic.guessNum + " tries!");
            Popup popup = new Popup();
            VBox vbox = new VBox();
            Button button = new Button("Play Again");
            Button button1 = new Button("Close");
            button.getStyleClass().addAll("win-button");
            button1.getStyleClass().addAll("win-button");
            label.getStyleClass().addAll("win-label");
            vbox.getStyleClass().addAll("win-screen");
            vbox.getChildren().add(label);
            vbox.getChildren().add(button);
            vbox.getChildren().add(button1);
            popup.getContent().add(vbox);
            label.setMinWidth(80);
            label.setMinHeight(50);
            Window window = Guess1L4.getScene().getWindow();
            popup.show(window);
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    clearBoard();
                    logic.setWord();
                    logic.guessNum = 0;
                    popup.hide();
                }
            });
            button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    popup.hide();
                }
            });
        }
    }
    public void looseScreen(String[] guess) {
        if (logic.guessNum == 6 && !Arrays.equals(guess, new String[]{"true", "true", "true", "true", "true"})) {
            Label label = new Label("You loose. The word was " + logic.getWord());
            Popup popup = new Popup();
            VBox vbox = new VBox();
            Button button = new Button("Play Again");
            Button button1 = new Button("Close");
            button.getStyleClass().addAll("win-button");
            button1.getStyleClass().addAll("win-button");
            label.getStyleClass().addAll("win-label");
            vbox.getStyleClass().addAll("win-screen");
            vbox.getChildren().add(label);
            vbox.getChildren().add(button);
            vbox.getChildren().add(button1);
            popup.getContent().add(vbox);
            label.setMinWidth(80);
            label.setMinHeight(50);
            Window window = Guess1L4.getScene().getWindow();
            popup.show(window);
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    clearBoard();
                    logic.setWord();
                    logic.guessNum = 0;
                    popup.hide();
                }
            });
            button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    popup.hide();
                }
            });
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
    @FXML
    protected void restartGameBTN() {
        clearBoard();
        logic.setWord();
        logic.guessNum = 0;
    }
    public void makeList(TextField[] textFields) {
        for (TextField textField : textFields) {
            textBoxes.add(textField);
        }
    }
    public void makeAlphaList() {
        Button[] buttonList = {
                btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ,
                btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT,
                btnU, btnV, btnW, btnX, btnY, btnZ
        };
        char currentLetter = 'A';
        for (Button button : buttonList) {
            alphaHashMap.put(button, String.valueOf(currentLetter));
            currentLetter++;
        }
        for (Button theCurrentButton : buttonList) {
            buttons.add(theCurrentButton);
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
        if (current.getText().equals("")) {
            int theCurrent = textBoxes.indexOf(current);
            TextField prev = textBoxes.get(theCurrent-1);
            current = prev;
            current.requestFocus();
            Robot robot = new Robot();
            robot.keyPress(KeyCode.DELETE);
            robot.keyRelease(KeyCode.DELETE);
            return prev;
        } else {
            current.setText("");
            return current;
        }
    }
    public void clearBoard() {
        for (TextField boxes : textBoxes) {
            boxes.clear();
            boxes.setStyle("-fx-control-inner-background: #121213ff");
        }
        for (Button eachbutton : buttons) {
            eachbutton.setStyle("-fx-background-color: #121213ff;");
        }
        current = textBoxes.get(0);
        current.requestFocus();
        errorSpot.setText("");
    }
    @FXML
    protected void onAlphabetClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();
        current.setText(buttonText);
        current.requestFocus();
    }
    @FXML
    protected void onAlphabetClickDEL() {
        errorSpot.setText("");
        List<TextField> firstList = new ArrayList<>();
        firstList.add(Guess1L1);
        firstList.add(Guess2L1);
        firstList.add(Guess3L1);
        firstList.add(Guess4L1);
        firstList.add(Guess5L1);
        firstList.add(Guess6L1);
        if (firstList.get(logic.guessNum).equals(current)) {
            if (!current.getText().equals("")) {
                current.setText("");
                current.requestFocus();
            } else {
                current.requestFocus();
            }
        } else {
            if (current.getText().equals("")) {
                traverseBackward();
                current.requestFocus();
            } else {
                current.setText("");
                current.requestFocus();
            }
        }
    }
    @FXML
    protected void onAlphabetClickENT() {
        current.requestFocus();
        Robot robot = new Robot();
        robot.keyPress(KeyCode.ENTER);
        robot.keyRelease(KeyCode.ENTER);
    }
}