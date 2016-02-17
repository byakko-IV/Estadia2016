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
    
    public void productDelete(Product  producto){
        String sql = "DELETE FROM productos WHERE id_producto = " + producto.getProductId();
        delete(sql);
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
    
    public void updateProduct(Product product){
        String sql = "UPDATE productos SET "+
                    "descripcion = '" + product.getProductDescription() + "'," + 
                    "presentacion = '" + product.getProductPresentation() +"', " +
                    "cantidad = " + product.getProductCuantity() + ", " +
                    "precio = " + product.getProductPrice() + ", " +
                    "subtotal = " + (product.getProductCuantity() * product.getProductPrice()) + 
                    " WHERE id_producto = " + product.getProductId();
        //System.out.println(sql);
        insert(sql);
        
    }
    
    //Storing a new product into the data base
    public void storeProduct(Product product){
        String sql = "INSERT INTO productos VALUES("+
                    product.getProductId() + ", '" +
                    product.getProductDescription() + "', '" +
                    product.getProductPresentation() +"', " +
                    product.getProductCuantity() + ", " +
                    product.getProductPrice() + ", " +
                    (product.getProductCuantity() * product.getProductPrice()) + ", " +
                    product.getProductProvider() + ")";
        //System.out.println(sql);
        insert(sql);
        
    }
    
    //Retrieving all products from the data base
    public void ProductsTotal(DefaultTableModel tableModel){
        
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_producto as Id, descripcion, presentacion, cantidad, precio, subtotal, proveedor FROM productos";
        
        try{
            result = getQuery(sql);
            if(result != null){
                int columnNumber = result.getMetaData().getColumnCount();
                for(int i = 1; i < columnNumber; i++){
                    tableModel.addColumn(result.getMetaData().getColumnName(i));
                }
                while(result.next()){
                    Object []obj = new Object[columnNumber];
                    for(int i = 1; i < columnNumber; i++){
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
    
    //Retriving the max value from producto_id on productos table 
    public int getProductId(){
        
        int id = 0;
        String sql = "SELECT MAX(id_producto) FROM productos";
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
    
    //Retriving the total amount of money of all products availables
    public float getProductTotalMoney(){
        
        float total = 0;
        String sql = "SELECT SUM(subtotal) FROM productos";
        ResultSet result = null;
        
        try{
            result = getQuery(sql);
            if(result != null){
                while(result.next()){
                    total = result.getFloat(1);
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
        
        return total;  
    }
}
