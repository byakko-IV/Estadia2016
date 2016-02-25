package com.cede.lib;

import com.cede.models.Provider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class ProviderModel extends DBManager{
    
    //Retrieving all products from the data base
    public Vector<Provider> ProvidersList(){
        
        Vector<Provider> pl = new Vector<Provider>();
        Provider provider;
        ResultSet result;
        String sql = "SELECT id_proveedor as id, rfc, nombre, domicilio, telefono FROM proveedores";
        
        try{
            result = getQuery(sql);
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
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                query.close();
                conn.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return pl;
    }
    
    //Storing a new provider into the data base
    public void storeProvider(Provider provider){
        String sql = "INSERT INTO proveedores VALUES("+
                    provider.getIdProvider() + ", '" +
                    provider.getRfc() + "', '" +
                    provider.getNombre() +"', '" +
                    provider.getDomicilio() + "', '" +
                    provider.getTelefono() + "')";
        //System.out.println(sql);
        insert(sql);
        
    }
    
     //Updating a existing product
    public void updatePorvider(Provider provider){
        String sql = "UPDATE proveedores SET "+
                    "rfc = '" + provider.getRfc() + "'," + 
                    "nombre = '" + provider.getNombre() +"', " +
                    "domicilio = '" + provider.getDomicilio() + "', " +
                    "telefono = '" + provider.getTelefono() + "' " +
                    "WHERE id_proveedor = " + provider.getIdProvider();
        System.out.println(sql);
        insert(sql);
        
    }
    
    //Deleting a existing product from data base
        public void providerDelete(Provider  provider){
        String sql = "DELETE FROM proveedores WHERE id_proveedor = " + provider.getIdProvider();
        delete(sql);
    }
    
     //Retriving the max value from id_proveedor on productos table 
    public int getProviderId(){
        
        int id = 0;
        String sql = "SELECT MAX(id_proveedor) FROM proveedores";
        ResultSet result = null;
        
        try{
            result = getQuery(sql);
            if(result != null){
                while(result.next()){
                    id = result.getInt(1);
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                query.close();
                conn.close();
                if(result != null){
                    result.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
        return id;  
    }
    
    //Retrieving all products from the data base
    public void ProveedoresTotal(DefaultTableModel tableModel){
        
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_proveedor as Id, rfc, nombre, domicilio, telefono FROM proveedores ORDER BY nombre";
        
        try{
            result = getQuery(sql);
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
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                query.close();
                conn.close();
                if(result != null){
                    result.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }
    
}
