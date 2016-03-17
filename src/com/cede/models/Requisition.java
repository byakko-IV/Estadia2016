package com.cede.models;

public class Requisition {
    private int id;
    private String beneficiado;
    private String concepto;
    private String fecha;
    private String zonaEscolar;
    private int region;
    private double subtotal;
    private double iva;
    private double total;
    
    public Requisition(){
        
    }
    
    public Requisition(int id, String beneficiado, String concepto, String fecha, String zonaEscolar, int region, 
            double subtotal, double iva, double total){
        this.id = id;
        this.fecha = fecha;
        this.zonaEscolar = zonaEscolar;
        this.region = region;
        this.total = total;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getBeneficiado() {
        return beneficiado;
    }

    public void setBeneficiado(String beneficiado) {
        this.beneficiado = beneficiado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
