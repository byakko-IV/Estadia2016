/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cede.lib;

import com.cede.models.Content;
import com.cede.models.Requisition;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MHERNANDEZ
 */
public class ContentModel extends MyConnection{
 
    //Retriving the max value from id_contenido on contenido table 
    public int getContentId(){
        connect();
        int id = 0;
        String sql = "SELECT MAX(id_contenido) FROM contenido";
        ResultSet result = null;
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            result = ps.executeQuery();
            //result = getQuery(sql);
            if(result != null){
                while(result.next()){
                    id = result.getInt(1);
                }
            }
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return id;  
    }
    
    //Storing a new product into the data base
    public int storeContent(Content content){
        int rowsAffected = 0;
        connect();
        String sql = "INSERT INTO contenido VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps =  connect.prepareStatement(sql);
            ps.setInt(1, content.getIdContent());
            ps.setInt(2, content.getRequisition());
            ps.setInt(3, content.getProduct());
            ps.setInt(4, content.getCantidad());
            ps.setFloat(5, content.getImporte());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
            return rowsAffected;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Decrease the amount of product selected
    public int updateStock(Content content){
        int rowsAffected = 0;
        connect();
        String sql = "UPDATE productos SET cantidad = cantidad - ?, subtotal = (cantidad - ?) * precio WHERE id_producto = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, content.getCantidad());
            ps.setInt(2, content.getCantidad());
            ps.setInt(3, content.getProduct());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
        }catch(SQLException  ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Deleting a existing bill's content from data base
    public int contentDelete(Requisition requisition){
        int rowsAffected = 0;
        connect();
        String sql = "DELETE FROM contenido WHERE requisicion = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
             ps.setInt(1, requisition.getId());
             rowsAffected = ps.executeUpdate();
             connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
}
