package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    ObservableList<Record> sampleList = FXCollections.observableArrayList();
    FilteredList<Record> filteredList = new FilteredList<>(sampleList, p -> true);

//    Test commit

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
    private ComboBox filterBy;

    @FXML
    private TextField filterField;

    @FXML
    private Button searchBtn;



    @FXML
    private void addRecordBtnClicked() {
        LocalDate addedDateVal = addedDate.getValue();
        LocalDate contaminationDateVal = contaminationDate.getValue();
        String containerTypeVal = containerType.getValue();
        String mediaVal = media.getText();
        String handlerPersonVal = handlerPerson.getText();
        String subHistoryVal = subHistory.getText();

        if (containerTypeVal==null || addedDateVal==null || mediaVal ==null || handlerPersonVal==null){
            AlertGenerate alertGenerate = new AlertGenerate();
            alertGenerate.alertShow("ERROR","Incomplete Form","Please complete relevant fields.");
        } else {
            Record newRecord = new Record(containerType.getValue(), addedDate.getValue().toString(), media.getText(), handlerPerson.getText(), subHistory.getText(), contaminationDate.getValue().toString());

            sampleList.add(newRecord);
            sampleTable.setItems(sampleList);
            clearButtonClicked();

        }


    }

    @FXML
    private void filterTyped(){
        System.out.println("typed");

        if (filterBy.getValue() != null) {

            String searchBy = filterBy.getValue().toString();

            filterField.textProperty().addListener((obs, oldValue, newValue) -> {

                switch (searchBy)//Switch on choiceBox value
                {
                    case "Media" -> {
                        filteredList.setPredicate(p -> p.getMedia().toLowerCase().contains(newValue.toLowerCase().trim()));
                        sampleTable.setItems(filteredList);
                    }
                    case "Handler Person" -> {
                        filteredList.setPredicate(p -> p.getHandlerPerson().toLowerCase().contains(newValue.toLowerCase().trim()));
                        sampleTable.setItems(filteredList);
                    }
                    case "Container Type" -> {
                        filteredList.setPredicate(p -> p.getContainerType().toLowerCase().contains(newValue.toLowerCase().trim()));
                        sampleTable.setItems(filteredList);
                    }
                    case "Added Date" -> {
                        filteredList.setPredicate(p -> p.getAddedDate().toLowerCase().contains(newValue.toLowerCase().trim()));
                        sampleTable.setItems(filteredList);
                    }
                    case "Contamination Date" -> {
                        filteredList.setPredicate(p -> p.getContaminationDate().toLowerCase().contains(newValue.toLowerCase().trim()));
                        sampleTable.setItems(filteredList);
                    }
                    case "Subculture History" -> {
                        filteredList.setPredicate(p -> p.getSubcultureHistory().toLowerCase().contains(newValue.toLowerCase().trim()));
                        sampleTable.setItems(filteredList);
                    }
                }
            });
        }




    }





    @FXML
    private void clearButtonClicked() {
        subHistory.clear();
        handlerPerson.clear();
        media.clear();
        contaminationDate.setValue(null);
        addedDate.setValue(null);
        containerType.valueProperty().set(null);
    }









    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> containerType = FXCollections.observableArrayList("1","2","3","4");
        this.containerType.setItems(containerType);

        ObservableList<String> filterByArray = FXCollections.observableArrayList("Container Type","Added Date","Media","Handler Person","Subculture History","Contamination Date");
        this.filterBy.setItems(filterByArray);

        containerCol.setCellValueFactory(new PropertyValueFactory<Record,String>("containerType"));
        addedDateCol.setCellValueFactory(new PropertyValueFactory<Record,String>("addedDate"));
        mediaCol.setCellValueFactory(new PropertyValueFactory<Record,String>("media"));
        handlerCol.setCellValueFactory(new PropertyValueFactory<Record,String>("handlerPerson"));
        historyCol.setCellValueFactory(new PropertyValueFactory<Record,String>("subcultureHistory"));
        contaminationDateCol.setCellValueFactory(new PropertyValueFactory<Record,String>("contaminationDate"));



    }
}



//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }