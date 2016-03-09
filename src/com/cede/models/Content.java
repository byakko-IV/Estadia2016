package com.cede.models;

public class Content {
    private int idContent;
    private int requisition;
    private int product;
    private int cantidad;
    private float importe;
    
    public Content(int idContent, int requisition, int product, int cantidad, int importe){
        this.idContent = idContent;
        this.requisition = requisition;
        this.product = product;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getIdContent() {
        return idContent;
    }

    public void setIdContent(int idContent) {
        this.idContent = idContent;
    }

    public int getRequisition() {
        return requisition;
    }

    public void setRequisition(int requisition) {
        this.requisition = requisition;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
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
