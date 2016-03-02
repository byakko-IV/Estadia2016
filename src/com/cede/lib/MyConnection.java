package com.cede.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyConnection {
    public String route;
    Connection connect;
    Statement query;
    
    
    public MyConnection(){
        route = "src/com/cede/db/estadia.db";
    }
        
    public void connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:"+route);
            query = connect.createStatement();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
