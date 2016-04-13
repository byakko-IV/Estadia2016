package com.cede.models;

public class Bill {
    private int folio;
    private String fecha;
    private double subtotal;
    private double iva;
    private double totalVenta;
    private int providerId;
    
    public Bill(){
        
    }
    
    public Bill(int folio, String fecha, double subtotal, double iva, double totalVenta, int providerId){
        this.folio = folio;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.totalVenta = totalVenta;
        this.providerId = providerId;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
    
    
}
