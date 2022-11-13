package com.example.demo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.*;

public class SqliteConnection {

    public Connection connectDatabase() {

        Connection dbConnect = null;

        try {
            Class.forName("org.sqlite.JDBC");
            dbConnect = DriverManager.getConnection("jdbc:sqlite:samples.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return dbConnect;

    }

    public void writeToDatabase(String containerType, String addedDate, String media, String handler, String subcultureHistory, String contaminationDate, String objectId
    ) {
        String sql = "INSERT INTO samples(containerType,addedDate,media,handler,subcultureHistory,contaminationDate,objectId) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = this.connectDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, containerType);
            pstmt.setString(2, addedDate);
            pstmt.setString(3, media);
            pstmt.setString(4, handler);
            pstmt.setString(5, subcultureHistory);
            pstmt.setString(6, contaminationDate);
            pstmt.setString(7, objectId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ObservableList<Record> readFromDatabase() {

        ObservableList<Record> readList = FXCollections.observableArrayList();

        String sql = "SELECT containerType,addedDate,media,handler,subcultureHistory,contaminationDate,objectId FROM samples";
        try (Connection conn = this.connectDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
               String containerType =  rs.getString("containerType");
                String addedDate =  rs.getString("addedDate");
                String media =  rs.getString("media");
                String handler =  rs.getString("handler");
                String subcultureHistory =  rs.getString("subcultureHistory");
                String contaminationDate =  rs.getString("contaminationDate");
                String objectId =  rs.getString("objectId");


                Record record = new Record(containerType,addedDate,media,handler,subcultureHistory,contaminationDate,objectId,new Button("Delete"));
                readList.add(record);



            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(readList);
        return readList;
    }

    public void deleteRecord(String objectId) {
        String sql = "DELETE FROM samples WHERE objectId= ?";
        try (Connection conn = this.connectDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, objectId);
            pstmt.executeUpdate();
            System.out.println("Deleted frm db");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
//        SqliteConnection sqliteConnection = new SqliteConnection();
//        sqliteConnection.deleteRecord("70b496f8-8e81-4b87-800a-8b7f5332edf8");
//        sqliteConnection.deleteRecord(1);
//        sqliteConnection.readFromDatabase();

    }
}
