package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Objects;

public class AdminController {

    SqliteConnection sqliteConnection = new SqliteConnection();
    HelloController helloController = new HelloController();

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passWordField;

    @FXML
    private Button confirmBtn;


    @FXML
    public void confirmBtnClicked(){
        String userName = userNameField.getText();
        String passWord = passWordField.getText();

        if (Objects.equals(userName, "admin") && Objects.equals(passWord, "admin")){


            helloController.getAdminAccess(userName,passWord);

//            sqliteConnection.deleteRecord(objectId);

            System.out.println("Record deleted.");
        }

        System.out.println("Record deleted.");


        System.out.println(userName  + passWord);
    }





}
