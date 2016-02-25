package com.cede.lib;


import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager extends MyConnection{
    
    public DBManager(){
        //Class constructor 
    }
    
    //This allow to insert into the data base
    public boolean insert(String sql){
        
        boolean valor = true;
        connect();
        try{
            query.executeUpdate(sql);
        }catch(SQLException ex){
            valor = false;
            ex.printStackTrace();
        }finally{
            try{
                query.close();
                conn.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return valor;
        
    }
    
    public boolean delete(String sql){
        boolean valor = true;
        connect();
        try{
            query.executeUpdate(sql);
        }catch(SQLException ex){
            valor = false;
            ex.printStackTrace();
        }finally{
            try{
                query.close();
                conn.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return valor;
    }
        
    //Handling the data base information
    public ResultSet getQuery(String sql){
        
        connect();
        ResultSet result = null;
        
        try{
            result = query.executeQuery(sql);
        }catch(SQLException ex){
            System.out.println("Message: " + ex.getMessage());
            System.out.println("State: " + ex.getSQLState());
            System.out.println("Error Code: " + ex.getErrorCode());
            
        }
        
        return result;
    }
}
