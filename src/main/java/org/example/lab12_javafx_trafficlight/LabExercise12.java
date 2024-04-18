// Student name: Koichi Nakata (ID: knakata595)

package org.example.lab12_javafx_trafficlight;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class LabExercise12 extends Application {
    protected BorderPane getPane() {
        VBox paneForLights = new VBox(10); // Gap between nodes

        Circle topCircle = new Circle();
        topCircle.setRadius(50);
        topCircle.setStroke(Color.BLACK);
        topCircle.setFill(Color.WHITE);

        Circle midCircle = new Circle();
        midCircle.setRadius(50);
        midCircle.setStroke(Color.BLACK);
        midCircle.setFill(Color.WHITE);

        Circle btmCircle = new Circle();
        btmCircle.setRadius(50);
        btmCircle.setStroke(Color.BLACK);
        btmCircle.setFill(Color.WHITE);

        paneForLights.getChildren().addAll(topCircle, midCircle, btmCircle);
        paneForLights.setAlignment(Pos.CENTER); // Aligns in the middle

        Rectangle rectangle = new Rectangle(120, 340);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        StackPane trafficPane = new StackPane();
        trafficPane.getChildren().addAll(rectangle, paneForLights); // Stacks nodes in the center


        HBox paneForButtons = new HBox(10);
        RadioButton btRed = new RadioButton("Red");
        RadioButton btYellow = new RadioButton("Yellow");
        RadioButton btGreen = new RadioButton("Green");
        paneForButtons.getChildren().addAll(btRed, btYellow, btGreen);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: blue");

        BorderPane pane = new BorderPane();
        pane.setCenter(trafficPane);
        pane.setBottom(paneForButtons);

        ToggleGroup group = new ToggleGroup();
        btRed.setToggleGroup(group);
        btYellow.setToggleGroup(group);
        btGreen.setToggleGroup(group);

        EventHandler<ActionEvent> handler = e -> {
            if (btRed.isSelected()) {
                topCircle.setFill(Color.RED);
                midCircle.setFill(Color.WHITE);
                btmCircle.setFill(Color.WHITE);
            } else if (btYellow.isSelected()) {
                topCircle.setFill(Color.WHITE);
                midCircle.setFill(Color.YELLOW);
                btmCircle.setFill(Color.WHITE);
            } else {
                topCircle.setFill(Color.WHITE);
                midCircle.setFill(Color.WHITE);
                btmCircle.setFill(Color.GREEN);
            }
        };

        btRed.setOnAction(handler);
        btYellow.setOnAction(handler);
        btGreen.setOnAction(handler);

        return pane;
    }

    @Override
    public void start(Stage stage) throws IOException {
        // getPane() method enables to inherit this window to another version
        Scene scene = new Scene(getPane(), 400, 450);
        stage.setTitle("Lab Exercise 12");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}