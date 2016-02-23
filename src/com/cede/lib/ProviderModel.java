package com.cede.lib;

import com.cede.models.Provider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


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
    
    
    
}
