package com.servlets;

import java.sql.*;

public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection(String db){

       try{
           if(con == null){
               Class.forName("org.gjt.mm.mysql.Driver");

               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,"root","");

           }
       }catch (Exception e){
           System.out.println("Here we are getting error!!!!");
           e.printStackTrace();
       }

        return  con;
    }
}
