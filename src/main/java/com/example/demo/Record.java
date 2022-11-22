package com.example.demo;
import javafx.scene.control.Button;


public class Record {
    private String containerType;
    private String addedDate;
    private String media;
    private String handlerPerson;
    private String subcultureHistory;
    private String contaminationDate;

    private String objectId;
    private Button delete;

    private Button edit;

    private  HelloController helloController;


    public Record(String containerType, String addedDate, String media, String handlerPerson, String subcultureHistory, String contaminationDate) {
        this.containerType = containerType;
        this.addedDate = addedDate;
        this.media = media;
        this.handlerPerson = handlerPerson;
        this.subcultureHistory = subcultureHistory;
        this.contaminationDate = contaminationDate;
    }

    public Record(String containerType, String addedDate, String media, String handlerPerson, String subcultureHistory, String contaminationDate, Button delete) {
        this.containerType = containerType;
        this.addedDate = addedDate;
        this.media = media;
        this.handlerPerson = handlerPerson;
        this.subcultureHistory = subcultureHistory;
        this.contaminationDate = contaminationDate;
        this.delete = delete;
    }

    public Record(String containerType, String addedDate, String media, String handlerPerson, String subcultureHistory, String contaminationDate, String objectId, Button delete, HelloController helloController,Button edit ) {
        this.containerType = containerType;
        this.addedDate = addedDate;
        this.media = media;
        this.handlerPerson = handlerPerson;
        this.subcultureHistory = subcultureHistory;
        this.contaminationDate = contaminationDate;
        this.objectId = objectId;
        this.delete = delete;
        this.helloController = helloController;
        this.edit = edit;

        delete.setOnAction(e->{

            this.helloController.adminMenuClicked();

            System.out.println("DELETE11111" + this.objectId );
            deleteRecord(this.objectId);
            this.helloController.fetchDatabse();

        });



        edit.setOnAction(e->{
            this.helloController.adminMenuClicked();


            System.out.println("Edit");



            this.helloController.fetchDatabse();
        });
    }

    SqliteConnection sqliteConnection = new SqliteConnection();

    public Record(String containerType, String addedDate, String media, String handlerPerson, String subcultureHistory, String objectId, Button delete, Button edit, HelloController helloController) {
        this.containerType = containerType;
        this.addedDate = addedDate;
        this.media = media;
        this.handlerPerson = handlerPerson;
        this.subcultureHistory = subcultureHistory;
        this.objectId = objectId;
        this.delete = delete;
        this.edit = edit;
        this.helloController = helloController;

    }

    public void deleteRecord(String objectId){

     sqliteConnection.deleteRecord(objectId);



    }

    public Button getEdit() {
        return edit;
    }

    public Button getDelete() {
        return delete;
    }

    public String getContainerType() {
        return containerType;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public String getMedia() {
        return media;
    }

    public String getHandlerPerson() {
        return handlerPerson;
    }

    public String getSubcultureHistory() {
        return subcultureHistory;
    }

    public String getContaminationDate() {
        return contaminationDate;
    }

    public String getObjectId() {
        return objectId;
    }
}
