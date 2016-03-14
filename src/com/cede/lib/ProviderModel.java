package com.cede.lib;

import com.cede.models.Provider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class ProviderModel extends MyConnection{
    
    //Retrieving all products from the data base
    public Vector<Provider> ProvidersList(){
        connect();
        Vector<Provider> pl = new Vector<Provider>();
        Provider provider;
        ResultSet result;
        String sql = "SELECT id_proveedor as id, rfc, nombre, domicilio, telefono FROM proveedores";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            result = ps.executeQuery();
            while(result.next()){
                provider = new Provider(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5)
                );
                pl.add(provider);
            }
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return pl;
    }
    
    //Storing a new provider into the data base
    public int storeProvider(Provider provider){
        int rowsAffected = 0;
        connect();
        String sql = "INSERT INTO proveedores VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps =  connect.prepareStatement(sql);
            ps.setInt(1, provider.getIdProvider());
            ps.setString(2, provider.getRfc());
            ps.setString(3, provider.getNombre());
            ps.setString(4, provider.getDomicilio());
            ps.setString(5, provider.getTelefono());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
     //Updating a existing product
    public int updatePorvider(Provider provider){
        int rowsAffected = 0;
        connect();
        String sql = "UPDATE proveedores SET rfc = ?, nombre = ?, domicilio = ?, telefono = ?" + 
                    "WHERE id_proveedor = ? ";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, provider.getRfc());
            ps.setString(2, provider.getNombre());
            ps.setString(3, provider.getDomicilio());
            ps.setString(4, provider.getTelefono());
            ps.setInt(5, provider.getIdProvider());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Deleting a existing product from data base
    public int providerDelete(Provider  provider){
        connect();
        int rowsAffected = 0;
        String sql = "DELETE FROM proveedores WHERE id_proveedor = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, provider.getIdProvider());
            rowsAffected = ps.executeUpdate();
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return rowsAffected;
    }
    
     //Retriving the max value from id_proveedor on productos table 
    public int getProviderId(){
        connect();
        int id = 0;
        String sql = "SELECT MAX(id_proveedor) FROM proveedores";
        ResultSet result = null;
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            result = ps.executeQuery();
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
    
    //Retrieving all products from the data base
    public void ProveedoresTotal(DefaultTableModel tableModel){
        connect();
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_proveedor as Id, rfc, nombre, domicilio, telefono FROM proveedores ORDER BY nombre";
        
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
    
    //Searching for a specific provider
    public void SearchProvider(DefaultTableModel tableModel, String parameter, String value){
        connect();
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_proveedor as Id, rfc, nombre, domicilio, telefono FROM proveedores WHERE "+ 
                parameter +" LIKE ? ORDER BY nombre";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%" +value+ "%");
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
    
    //Retrive a single record from the proveedores table
    public Provider providerDetail(int id){
        Provider p = new Provider();
        connect();
        ResultSet result = null;
        String sql = "SELECT * FROM proveedores WHERE id_proveedor = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeQuery();
            if(result != null){
                p.setIdProvider(result.getInt("id_proveedor"));
                p.setRfc(result.getString("rfc"));
                p.setNombre(result.getString("nombre"));
                p.setDomicilio(result.getString("domicilio"));
                p.setTelefono(result.getString("telefono"));
            }
            connect.close();
            return p;
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
        return p;
    }
}
