package com.example.demo;
import java.sql.*;
import java.time.LocalDate;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteConnection
{
    public static void main(String[] args)
    {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:samples.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

//            statement.executeUpdate("drop table if exists person");
//            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into samples values('s', 'leo','s', 'leo','s', 'leo',11)");
//            statement.executeUpdate("insert into person values(2, 'yui')");
//            ResultSet rs = statement.executeQuery("select * from person");
//            while(rs.next())
//            {
//                // read the result set
//                System.out.println("name = " + rs.getString("name"));
//                System.out.println("id = " + rs.getInt("id"));
//            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}

//public class SqliteConnection {
//
//    public Connection  connect() {
//        Connection conn = null;
//        try {
//            // db parameters
//            String url = "jdbc:sqlite:samples.db";
//            // create a connection to the database
//            conn = DriverManager.getConnection(url);
//
//            System.out.println("Connection to SQLite has been established.");
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
////        } finally {
////            try {
////                if (conn != null) {
////                    conn.close();
////                }
////            } catch (SQLException ex) {
////                System.out.println(ex.getMessage());
////            }
////        }
//        return conn;
//    }
//
//    public void insert(String name,String age) {
//        String sql = "INSERT INTO samples(name,age) VALUES(?,?)";
//
////        String objectId,String containerType, String addedDate,String media,String handler,String subcultureHistory,String contaminationDate
////        "INSERT INTO samples(objectId,typeOfContainer,date,media,handler,subcultureHistory,contaminationDate) VALUES(?,?,?,?,?,?,?)
//
//        try (Connection conn = this.connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, name);
//            pstmt.setString(2, age);
////            pstmt.setString(3, addedDate);
////            pstmt.setString(4, media);
////            pstmt.setString(5, handler);
////            pstmt.setString(6, subcultureHistory);
////            pstmt.setString(7, contaminationDate);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void select(){
//
//    }
//
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
////        connect();
//        SqliteConnection sqliteConnection = new SqliteConnection();
//        sqliteConnection.insert("s","s");
//
//    }
//}
