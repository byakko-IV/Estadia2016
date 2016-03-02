package com.cede.lib;

import com.cede.models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ProductModel extends MyConnection{
    
    //Storing a new product into the data base
    public int storeProduct(Product product){
        int rowsAffected = 0;
        connect();
        String sql = "INSERT INTO productos VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps =  connect.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(product.getProductId()));
            ps.setString(2, product.getProductDescription());
            ps.setString(3, product.getProductPresentation());
            ps.setInt(4, product.getProductCuantity());
            ps.setFloat(5, product.getProductPrice());
            ps.setFloat(6, (product.getProductCuantity() * product.getProductPrice()));
            ps.setInt(7, product.getProductProvider());
            
            rowsAffected = ps.executeUpdate();
            connect.close();
            return rowsAffected;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Updating a existing producs
    public int updateProduct(Product product){
        int rowsAffected = 0;
        connect();
        String sql = "UPDATE productos SET descripcion = ?, presentacion = ?, cantidad = ?, "
                + "precio = ?, subtotal = ? WHERE id_producto = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, product.getProductDescription());
            ps.setString(2, product.getProductPresentation());
            ps.setInt(3, product.getProductCuantity());
            ps.setFloat(4, product.getProductPrice());
            ps.setFloat(5, (product.getProductCuantity() * product.getProductPrice())); 
            ps.setInt(6, Integer.parseInt(product.getProductId()));
            
            rowsAffected = ps.executeUpdate();
            connect.close();
        }catch(SQLException  ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
    
    //Deleting a existing product from data base
    public int productDelete(Product product){
        int rowsAffected = 0;
        connect();
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
             ps.setInt(1, Integer.parseInt(product.getProductId()));
             rowsAffected = ps.executeUpdate();
             connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsAffected;
    }
        
     //Retrieving all products from the data base
    public void ProductsTotal(DefaultTableModel tableModel){
        connect();
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_producto as Id, descripcion, presentacion, cantidad, precio, subtotal, proveedor "
                + "FROM productos ORDER BY descripcion";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            result = ps.executeQuery();
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
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    //Retriving the max value from producto_id on productos table 
    public int getProductId(){
        connect();
        int id = 0;
        String sql = "SELECT MAX(id_producto) FROM productos";
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
    
    //Retriving the total amount of money of all products availables
    public float getProductTotalMoney(){
        connect();
        float total = 0;
        String sql = "SELECT SUM(subtotal) FROM productos";
        ResultSet result = null;
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            result = ps.executeQuery();
            //result = getQuery(sql);
            if(result != null){
                while(result.next()){
                    total = result.getFloat(1);
                }
            }
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return total;  
    }
    
    //Searching products from the data base
    public void ProductsSearch(DefaultTableModel tableModel, String parameter){
        connect();
        ResultSet result = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "SELECT id_producto as Id, descripcion, presentacion, cantidad, precio, subtotal, proveedor FROM "+
                "productos WHERE descripcion LIKE ? ORDER BY descripcion";
        
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%" + parameter + "%");
            result = ps.executeQuery();
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
            connect.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
    }
}
