package com.example.demo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HelloController implements Initializable, Serializable {

    SqliteConnection sqliteConnection = new SqliteConnection();

    public ObservableList<Record> getSampleList() {
        return sampleList;
    }

    public void setSampleList(ObservableList<Record> sampleList) {
        this.sampleList = sampleList;
    }

    public ObservableList<Record> sampleList = FXCollections.observableArrayList();
    public FilteredList<Record> filteredList = new FilteredList<>(sampleList, p -> true);

    ArrayList<Record> backupList = new ArrayList<>();

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
    private TableColumn<Record,Button> deleteCol;

    @FXML
    private TableColumn<Record,Button> editCol;

    @FXML
    private TableColumn<Record,String> objectIdCol;


    @FXML
    private ComboBox<String> containerType;

    @FXML
    private DatePicker addedDate;

    @FXML
    private TextField media;

    @FXML
    private TextField handlerPerson;

    @FXML
    private TextField subHistory;

//    @FXML
//    private DatePicker contaminationDate;

    @FXML
    private Button delete;

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

//    Menu
    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem adminMenu;

    @FXML
    private MenuItem backupMenu;

    @FXML
    private MenuItem exitMenu;


    public void getAdminAccess(String userName,String passWord){
        System.out.println("Hello controller"+userName);
    }


    @FXML
    private void exitButtonClicked(){
        System.exit(0);
    }

    public void backupMenuClicked(){
        System.out.println("backup");
        System.out.println("SAVED"+sampleList);

        try {
            FileWriter writer = new FileWriter("records.txt");
            for (Record record : sampleList) {
                writer.write(record.getObjectId() + "," + record.getContainerType() +","+record.getAddedDate() + "," + record.getMedia() +","+record.getHandlerPerson() + "," + record.getSubcultureHistory() +","+record.getContaminationDate()+ "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void adminMenuClicked(){

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.show();


    }

    public ObservableList<Record> returnList(){
        return sampleList;
    }

    public void fetchDatabse() {
        sampleList.clear();
        System.out.println("11111111111");
        System.out.println(sampleList);
        sampleList.addAll(sqliteConnection.readFromDatabase(this));
        sampleTable.setItems(sampleList);
        System.out.println("222222222");
        System.out.println(sampleList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sampleList.addAll(sqliteConnection.readFromDatabase(this));
        sampleTable.setItems(sampleList);


        ObservableList<String> containerType = FXCollections.observableArrayList("Tube","Jam jar Small","Jam jar Medium","Jam jar Large","Other");
        this.containerType.setItems(containerType);

        ObservableList<String> filterByArray = FXCollections.observableArrayList("Container Type","Added Date","Media","Handler Person","Subculture History","Contamination Date","Object Id");
        this.filterBy.setItems(filterByArray);


        objectIdCol.setCellValueFactory(new PropertyValueFactory<Record,String>("objectId"));
        containerCol.setCellValueFactory(new PropertyValueFactory<Record,String>("containerType"));
        addedDateCol.setCellValueFactory(new PropertyValueFactory<Record,String>("addedDate"));
        mediaCol.setCellValueFactory(new PropertyValueFactory<Record,String>("media"));
        handlerCol.setCellValueFactory(new PropertyValueFactory<Record,String>("handlerPerson"));
        historyCol.setCellValueFactory(new PropertyValueFactory<Record,String>("subcultureHistory"));
        contaminationDateCol.setCellValueFactory(new PropertyValueFactory<Record,String>("contaminationDate"));
        deleteCol.setCellValueFactory(new PropertyValueFactory<Record,Button>("delete"));
        editCol.setCellValueFactory(new PropertyValueFactory<Record,Button>("edit"));






    }

    @FXML
    private void addRecordBtnClicked() {
        LocalDate addedDateVal = addedDate.getValue();
//        LocalDate contaminationDateVal = contaminationDate.getValue();
        String containerTypeVal = containerType.getValue();
        String mediaVal = media.getText();
        String handlerPersonVal = handlerPerson.getText();
        String subHistoryVal = subHistory.getText();

        if (containerTypeVal==null || addedDateVal==null || mediaVal ==null || handlerPersonVal==null){
            AlertGenerate alertGenerate = new AlertGenerate();
            alertGenerate.alertShow("ERROR","Incomplete Form","Please complete relevant fields.");
        } else {
            String uniqueID = String.valueOf(new Random(System. currentTimeMillis()). nextInt(99999999));

            Record newRecord = new Record(containerType.getValue(), addedDate.getValue().toString(), media.getText(), handlerPerson.getText(), subHistory.getText(),uniqueID,new Button("Delete"),new Button("Edit") ,this);
            sampleList.add(newRecord);

            sqliteConnection.writeToDatabase(containerType.getValue(), addedDate.getValue().toString(), media.getText(), handlerPerson.getText(), subHistory.getText(),uniqueID);

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
                    case "Object Id" -> {
                        filteredList.setPredicate(p -> p.getObjectId().toLowerCase().contains(newValue.toLowerCase().trim()));
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
        addedDate.setValue(null);
        containerType.setValue(null);
        containerType.setPromptText("SSS");
    }












}



//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }