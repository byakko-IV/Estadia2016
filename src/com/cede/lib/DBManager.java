package com.cede.lib;

import com.cede.models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

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
    
    //Storing a new product into the data base
    public void storeProduct(Product product){
        insert("INSERT INTO productos VALUES("+
                product.getProductId() + ", '" +
                product.getProductDescription() + "', " +
                product.getProductCuantity() + ", " +
                product.getProductPrice() + ", " +
                product.getProductProvider() + ")");
    }
    
    //Retrieving all products from the data base
    public void ProductsTotal(DefaultTableModel tableModel){
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT * FROM productos";
        
        try{
            result = getQuery(sql);
            if(result != null){
                int columnNumber = result.getMetaData().getColumnCount();
                System.out.println(columnNumber);
                for(int i = 1; i < columnNumber; i++){
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
