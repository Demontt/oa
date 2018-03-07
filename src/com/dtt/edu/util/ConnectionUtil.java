package com.dtt.edu.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
    static String user= "demo";
    static String pwd="root";
    static String url="jdbc:mysql://localhost:3306/gzhb?characterEncoding=utf-8";
    static String driver = "com.mysql.jdbc.Driver";//驱动程序名
    static Connection con=null;

    public static void main(String[] args) {
        ConnectionUtil.getCurrentConnection();
    }

    public static Connection getCurrentConnection(){
        Connection con=null;
        try {
            Class.forName(driver);
//            System.out.println("驱动器加载成功");
            try {
                con=DriverManager.getConnection(url,user,pwd);
//                System.out.println("数据库连接成功");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;

    }
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void close(Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

