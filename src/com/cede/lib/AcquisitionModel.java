/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cede.lib;

import com.cede.models.Acquisition;
import com.cede.models.Bill;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MHERNANDEZ
 */
public class AcquisitionModel extends MyConnection{
    
    //Retriving the max value from adquisicion_id on productos table 
    public int getAcquisitionId(){
        connect();
        int id = 0;
        String sql = "SELECT MAX(id_adquisicion) FROM adquisicion";
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
    public int storeAcquisition(Acquisition a){
        int rowsAffected = 0;
        connect();
        String sql = "INSERT INTO adquisicion VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps =  connect.prepareStatement(sql);
            ps.setInt(1, a.getIdAcquisition());
            ps.setInt(2, a.getFactura());
            ps.setInt(3, a.getProducto());
            ps.setInt(4, a.getCantidad());
            ps.setFloat(5, a.getImporte());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
            return rowsAffected;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Inceracing the amount of product selected
    public int updateStock(Acquisition a){
        int rowsAffected = 0;
        connect();
        String sql = "UPDATE productos SET cantidad = cantidad + ?, subtotal = (cantidad + ?) * precio WHERE id_producto = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, a.getCantidad());
            ps.setInt(2, a.getCantidad());
            ps.setInt(3, a.getProducto());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
        }catch(SQLException  ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Deleting a existing bill's content from data base
    public int acquisitionDelete(Bill bill){
        int rowsAffected = 0;
        connect();
        String sql = "DELETE FROM adquisicion WHERE factura = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
             ps.setInt(1, bill.getFolio());
             rowsAffected = ps.executeUpdate();
             connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
}
