package com.cede.models;

public class Product {
    private String id_producto;
    private String descripcion;
    private String cantidad;
    private String precio;
    private String proveedor;
    
    public Product(String id_producto, String descripcion, String cantidad, String precio, String proveedor){
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
    }
    
    public String getProductId(){
        return this.id_producto;
    }
    
    public void setProductId(String id_producto){
        this.id_producto = id_producto;
    }
    
    public String getProductDescription(){
        return this.descripcion;
    }
    
    public void setProductDescription(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getProductCuantity(){
        return this.cantidad;
    }
    
    public void setProductCuantity(String cantidad){
        this.cantidad = cantidad;
    }
    
    public String getProductPrice(){
        return this.precio;
    }
    
    public void setProductPrice(String precio){
        this.precio = precio;
    }
    
    public String getProductProvider(){
        return this.proveedor;
    }
    
    public void setProductProvider(String proveedor){
        this.proveedor = proveedor;
    }
}
