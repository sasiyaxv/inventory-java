package com.example.demo;

import javafx.scene.control.Alert;

public class AlertGenerate {

            public void alertShow(String alertType,String title,String message){
                Alert alert = new Alert(Alert.AlertType.valueOf(alertType));
                alert.setTitle(title);
                alert.setContentText(message);
                alert.show();
            }
}
