package com.cede.lib;

import com.cede.models.Requisition;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class RequisitionModel extends MyConnection {
    
    //Retriving the max value from id_requisicion on requisiciones table 
    public int getRequisitionId(){
        connect();
        int id = 0;
        String sql = "SELECT MAX(id_requisicion) FROM requisiciones";
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
    
    //Storing a new requisition into the data base
    public int storeRequisition(Requisition req){
        int rowsAffected = 0;
        connect();
        String sql = "INSERT INTO requisiciones VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps =  connect.prepareStatement(sql);
            ps.setInt(1, req.getId());
            ps.setString(2, req.getZonaEscolar());
            ps.setInt(3, req.getRegion());
            ps.setString(4, req.getFecha());
            ps.setFloat(5, req.getTotal());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
            return rowsAffected;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Retrieving all products from the data base
    public void RequisitionTotal(DefaultTableModel tableModel){
        connect();
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_requisicion as Id, zona_escolar, region, fecha, total"
                + " FROM requisiciones ORDER BY fecha";
        
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
    public int requisitionDelete(Requisition requisition){
        int rowsAffected = 0;
        connect();
        String sql = "DELETE FROM requisiciones WHERE id_requisicion = ?";
        
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
