package com.cede.models;

public class Acquisition {
    private int idAcquisition;
    private int factura;
    private int producto;
    private int cantidad;
    private float importe;
    
    public Acquisition(int idAcquisition, int factura, int producto, int cantidad, float importe){
        this.idAcquisition = idAcquisition;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getIdAcquisition() {
        return idAcquisition;
    }

    public void setIdAcquisition(int idAcquisition) {
        this.idAcquisition = idAcquisition;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    
}
