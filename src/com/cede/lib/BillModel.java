package com.cede.lib;

import com.cede.models.Bill;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class BillModel extends MyConnection{
    
    //Storing a new product into the data base
    public int storeBill(Bill bill){
        int rowsAffected = 0;
        connect();
        String sql = "INSERT INTO facturas VALUES(?,?,?,?)";
        try{
            PreparedStatement ps =  connect.prepareStatement(sql);
            ps.setInt(1, bill.getFolio());
            ps.setString(2, bill.getFecha());
            ps.setFloat(3, bill.getTotalVenta());
            ps.setInt(4, bill.getProviderId());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
            return rowsAffected;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Retrieving all products from the data base
    public void BillsTotal(DefaultTableModel tableModel){
        connect();
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT folio, fecha, total_venta as total, proveedor as id_proveedor"
                + " FROM facturas ORDER BY fecha";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            result = ps.executeQuery();
            if(result != null){
                int columnNumber = result.getMetaData().getColumnCount();
                for(int i = 1; i <= columnNumber; i++){
                    tableModel.addColumn(result.getMetaData().getColumnName(i));
                }
                while(result.next()){
                    Object []obj = new Object[columnNumber];
                    for(int i = 1; i <= columnNumber; i++){
                        obj[i-1] = result.getObject(i);
                    }
                    tableModel.addRow(obj);
                }
            }
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    //Deleting a existing bill from data base
    public int billDelete(Bill bill){
        int rowsAffected = 0;
        connect();
        String sql = "DELETE FROM facturas WHERE folio = ?";
        
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
    
    //Retrive a single record from the products table
    public Bill BillDetail(int id){
        Bill bill = new Bill();
        connect();
        ResultSet result = null;
        String sql = "SELECT * FROM facturas WHERE folio = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeQuery();
            if(result != null){
                bill.setFolio(result.getInt("folio"));
                bill.setFecha(result.getString("fecha"));
                bill.setTotalVenta(result.getFloat("total_venta"));
                bill.setProviderId(result.getInt("proveedor"));
            }
            connect.close();
            return bill;
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        return bill;
    }
}
