package com.example.demo;
import java.sql.*;
import java.time.LocalDate;

public class SqliteConnection {

    public Connection  connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:test.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
        return conn;
    }

    public void insert(String name,String age) {
        String sql = "INSERT INTO SAMPLES(name,age) VALUES(?,?)";

//        String objectId,String containerType, String addedDate,String media,String handler,String subcultureHistory,String contaminationDate
//        "INSERT INTO samples(objectId,typeOfContainer,date,media,handler,subcultureHistory,contaminationDate) VALUES(?,?,?,?,?,?,?)

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, age);
//            pstmt.setString(3, addedDate);
//            pstmt.setString(4, media);
//            pstmt.setString(5, handler);
//            pstmt.setString(6, subcultureHistory);
//            pstmt.setString(7, contaminationDate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void select(){

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        connect();
        SqliteConnection sqliteConnection = new SqliteConnection();
        sqliteConnection.insert("s","s");

    }
}
