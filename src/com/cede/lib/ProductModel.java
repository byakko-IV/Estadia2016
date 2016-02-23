/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cede.lib;

import com.cede.models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MHERNANDEZ
 */
public class ProductModel extends DBManager{
    
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
    
    //Updating a existing product
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
    
    //Deleting a existing product from data base
        public void productDelete(Product  producto){
        String sql = "DELETE FROM productos WHERE id_producto = " + producto.getProductId();
        delete(sql);
    }
        
     //Retrieving all products from the data base
    public void ProductsTotal(DefaultTableModel tableModel){
        
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_producto as Id, descripcion, presentacion, cantidad, precio, subtotal, proveedor FROM productos "+
                "ORDER BY descripcion";
        
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
    
    //Searching products from the data base
    public void ProductsSearch(DefaultTableModel tableModel, String parameter){
        
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_producto as Id, descripcion, presentacion, cantidad, precio, subtotal, proveedor FROM "+
                "productos WHERE descripcion LIKE '%" + parameter + "%' ORDER BY descripcion";
        
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
    
}
