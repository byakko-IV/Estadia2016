package com.cede.models;

public class Bill {
    private int folio;
    private String fecha;
    private float totalVenta;
    private int providerId;
    
    public Bill(int folio, String fecha, float totalVenta, int providerId){
        this.folio = folio;
        this.fecha = fecha;
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

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
    
    
}
