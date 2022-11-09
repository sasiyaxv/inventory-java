package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Record> sampleTable;

    @FXML
    private TableColumn<Record, String> contaminationDateCol;

    @FXML
    private TableColumn<Record, String> handlerCol;

    @FXML
    private TableColumn<Record, String> historyCol;

    @FXML
    private TableColumn<Record, String> mediaCol;

    @FXML
    private TableColumn<Record, String> addedDateCol;

    @FXML
    private TableColumn<Record, String> containerCol;


    @FXML
    private ComboBox<String> containerType;

    @FXML
    private void initialize(){
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4");
        containerType.setItems(list);
    }

    @FXML
    private DatePicker addedDate;

    @FXML
    private TextField media;

    @FXML
    private TextField handlerPerson;

    @FXML
    private TextField subHistory;

    @FXML
    private DatePicker contaminationDate;

    @FXML
    private Button addRecordBtn;

    @FXML
    private Button clearBtn;



    @FXML
    private void addRecordBtnClicked() {
        LocalDate addedDateVal = addedDate.getValue();
        LocalDate contaminationDateVal = contaminationDate.getValue();
        String containerTypeVal = containerType.getValue();
        String mediaVal = media.getText();
        String handlerPersonVal = handlerPerson.getText();
        String subHistoryVal = subHistory.getText();

        if (containerTypeVal==null || addedDateVal==null || mediaVal ==null || handlerPersonVal==null){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setTitle("Incomplete");
            a.setContentText("Please complete relevant fields.");
            a.show();
        }

    }


    @FXML
    private void clearButtonClicked() {
        subHistory.clear();
        handlerPerson.clear();
        media.clear();
    }

//    LocalDate today = LocalDate.now();


    ObservableList<Record> newList = FXCollections.observableArrayList(
            new Record("d","today","s","s","s","today")
    );





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        containerCol.setCellValueFactory(new PropertyValueFactory<Record,String>("Container Type"));
        addedDateCol.setCellValueFactory(new PropertyValueFactory<Record,String>("Added Date"));
        mediaCol.setCellValueFactory(new PropertyValueFactory<Record,String>("Media"));
        handlerCol.setCellValueFactory(new PropertyValueFactory<Record,String>("Handler"));
        historyCol.setCellValueFactory(new PropertyValueFactory<Record,String>("Subculture History"));
        contaminationDateCol.setCellValueFactory(new PropertyValueFactory<Record,String>("Contamination Date"));

//        sampleTable.setItems(newList);


    }
}



//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }