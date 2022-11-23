package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ConfirmDeleteController {
    @FXML
    private TextField userNameField;

    @FXML
    private TextField passWordField;

    AdminUserSingleton adminUserSingleton = AdminUserSingleton.getInstance();

SqliteConnection sqliteConnection = new SqliteConnection();



    public void deleteBtnClicked(ActionEvent event) throws IOException {
        String userName = userNameField.getText();
        String passWord =passWordField.getText();

        if (Objects.equals(userName, "admin") && Objects.equals(passWord, "admin")){
            sqliteConnection.deleteRecord(adminUserSingleton.getObjectId());
        }

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();


//        adminUserSingleton.setPassWord(passWord);



//        Stage stage = (Stage) userNameField.getScene().getWindow();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
//        stage.setScene(new Scene(root));
    }
}
