package com.example.demo;

import java.time.LocalDate;

public class Record {
    private String containerType;
    private String addedDate;
    private String media;
    private String handlerPerson;
    private String subcultureHistory;
    private String contaminationDate;

    public Record(String containerType, String addedDate, String media, String handlerPerson, String subcultureHistory, String contaminationDate) {
        this.containerType = containerType;
        this.addedDate = addedDate;
        this.media = media;
        this.handlerPerson = handlerPerson;
        this.subcultureHistory = subcultureHistory;
        this.contaminationDate = contaminationDate;
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
}
