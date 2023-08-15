package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage rootStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        rootStage = primaryStage;
        Parent home = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("Book Rent");
        primaryStage.setScene(new Scene(home, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}