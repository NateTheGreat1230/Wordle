module com.wordle.wordle {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;

    opens com.wordle.wordle to javafx.fxml;
    exports com.wordle.wordle;
}