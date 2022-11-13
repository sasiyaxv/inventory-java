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

        delete.setOnAction(e->{
            System.out.println("DElete");
//            HelloController helloController = new HelloController();
//            helloController.returnList().remove(objectId);

            SqliteConnection sqliteConnection = new SqliteConnection();
            sqliteConnection.deleteRecord(objectId);


        });
    }

    public Record(String containerType, String addedDate, String media, String handlerPerson, String subcultureHistory, String contaminationDate, String objectId, Button delete) {
        this.containerType = containerType;
        this.addedDate = addedDate;
        this.media = media;
        this.handlerPerson = handlerPerson;
        this.subcultureHistory = subcultureHistory;
        this.contaminationDate = contaminationDate;
        this.objectId = objectId;
        this.delete = delete;
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
