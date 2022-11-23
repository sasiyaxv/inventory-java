package com.example.demo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EditController {

    @FXML
    private DatePicker editContaminationDate;
    @FXML
    private TextField editSubcultureHistory;


    AdminUserSingleton adminUserSingleton = AdminUserSingleton.getInstance();
    SqliteConnection sqliteConnection = new SqliteConnection();


    public void confirmBtnClicked(ActionEvent event){
       String contaminationDate = editContaminationDate.getValue().toString();
       String subcultureHistory = editSubcultureHistory.getText();

       adminUserSingleton.setContaminationDate(contaminationDate);
       adminUserSingleton.setSubcultureHistory(subcultureHistory);

       sqliteConnection.editRecord(adminUserSingleton.getObjectId(), contaminationDate,subcultureHistory);

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();

        System.out.println(contaminationDate+ subcultureHistory);
    }



}
