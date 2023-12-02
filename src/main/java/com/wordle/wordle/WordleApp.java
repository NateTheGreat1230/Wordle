package com.wordle.wordle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WordleApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WordleApp.class.getResource("Wordle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Wordle.css")).toExternalForm());
        stage.getIcons().add(new Image(Objects.requireNonNull(WordleApp.class.getResourceAsStream("favicon.png"))));
        stage.setTitle("Wordle Game");
        stage.setScene(scene);
        stage.show();
        WordleController controller = fxmlLoader.getController();
        controller.addEventListeners();
    }
    public static void main(String[] args) {launch();}
}