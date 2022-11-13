package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminController {

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passWordField;

    @FXML
    private Button loginBtn;


    @FXML
    private void loginBtnClicked(){
        String userName = userNameField.getText();
        String passWord = passWordField.getText();
        System.out.println(userName  + passWord);
    }





}
