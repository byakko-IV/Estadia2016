package com.cede.models;

public class Requisition {
    private int id;
    private int zonaEscolar;
    private int region;
    
    public Requisition(int id, int zonaEscolar, int region){
        this.id = id;
        this.zonaEscolar = zonaEscolar;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZonaEscolar() {
        return zonaEscolar;
    }

    public void setZonaEscolar(int zonaEscolar) {
        this.zonaEscolar = zonaEscolar;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }
    
    
}
