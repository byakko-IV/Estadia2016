package com.cede.models;

public class Bill {
    private String folio;
    private String fecha;
    private float totalVenta;
    private int providerId;
    
    public Bill(String folio, String fecha, float totalVenta, int providerId){
        this.folio = folio;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.providerId = providerId;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
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
