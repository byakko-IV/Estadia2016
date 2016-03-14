package com.cede.models;

public class Requisition {
    private int id;
    private String fecha;
    private String zonaEscolar;
    private int region;
    private float total;
    
    public Requisition(int id, String fecha, String zonaEscolar, int region, float total){
        this.id = id;
        this.fecha = fecha;
        this.zonaEscolar = zonaEscolar;
        this.region = region;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZonaEscolar() {
        return zonaEscolar;
    }

    public void setZonaEscolar(String zonaEscolar) {
        this.zonaEscolar = zonaEscolar;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
