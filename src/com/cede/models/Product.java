package com.cede.models;

public class Product {
    private String id_producto;
    private String presentacion;
    private String descripcion;
    private int cantidad;
    private float precio;
    private String proveedor;
    
    public Product(String id_producto, String descripcion, String presentacion, int cantidad, float precio, String proveedor){
        this.id_producto = id_producto;
        this.presentacion = presentacion;
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
    
    public String getProductPresentation(){
        return this.presentacion;
    }
    
    public void setProductPresentation(String presentacion){
        this.presentacion = presentacion;
    }
    public int getProductCuantity(){
        return this.cantidad;
    }
    
    public void setProductCuantity(int cantidad){
        this.cantidad = cantidad;
    }
    
    public float getProductPrice(){
        return this.precio;
    }
    
    public void setProductPrice(float precio){
        this.precio = precio;
    }
    
    public String getProductProvider(){
        return this.proveedor;
    }
    
    public void setProductProvider(String proveedor){
        this.proveedor = proveedor;
    }
}
