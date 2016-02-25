package com.cede.models;

public class Provider {
    private int idBill;
    private String rfc;
    private String nombre;
    private String domicilio;
    private String telefono;
    
    public Provider(int idBill, String rfc, String nombre, String domicilio, String telefono){
        this.idBill = idBill;
        this.rfc = rfc;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public int getIdProvider() {
        return idBill;
    }

    public void setIdProvider(int idBill) {
        this.idBill = idBill;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
