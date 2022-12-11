package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        double height=  Screen.getPrimary().getBounds().getHeight();
        double width=   Screen.getPrimary().getBounds().getWidth();

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("Tissue culture laboratory inventory");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}