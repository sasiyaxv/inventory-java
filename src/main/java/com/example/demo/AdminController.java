package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class AdminController {


    @FXML
    private TextField userNameField;

    @FXML
    private TextField passWordField;


    public void switchToEditMode(ActionEvent event) throws IOException {

        String userName = userNameField.getText();
        String passWord = passWordField.getText();

//        Add username and password here
        if (Objects.equals(userName, "admin") && Objects.equals(passWord, "admin")){

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("edit-view.fxml")));
            Scene scene1 = new Scene(root);
            Stage stage1;

            stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage1.setScene(scene1);
            stage1.show();

        }
        else {
            AlertGenerate alertGenerate = new AlertGenerate();
            alertGenerate.alertShow("ERROR","Wrong credentials","Please enter correct details.");
        }
    }
}
