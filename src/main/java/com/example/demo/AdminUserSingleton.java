package com.example.demo;

public class AdminUserSingleton {

    private static final AdminUserSingleton instance = new AdminUserSingleton();
    private String objectId;

    private String contaminationDate;
    private String subcultureHistory;

    private AdminUserSingleton(){}

    public static AdminUserSingleton getInstance(){
        return instance;
    }



    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getContaminationDate() {
        return contaminationDate;
    }

    public void setContaminationDate(String contaminationDate) {
        this.contaminationDate = contaminationDate;
    }

    public String getSubcultureHistory() {
        return subcultureHistory;
    }

    public void setSubcultureHistory(String subcultureHistory) {
        this.subcultureHistory = subcultureHistory;
    }

}
