package com.cede.lib;

import com.cede.guis.*;
import javax.swing.table.DefaultTableModel;

public class GuiDisplayer {
    Main m;
    Proveedores p;
    Facturas f;
    Requisiciones r;
    AgregarProducto ap;
    ProductosDetalle pd;
    ProveedoresDetalle prd;
    FacturasDetalle fd;
    RequisicionesDetalle rd;
    
    public void ChargeMain(){
        m = new Main();
        m.setVisible(true);
    }
    
    public void ChargeProveedores(){
        p = new Proveedores();
        p.setVisible(true);
    }
    
    public void ChargeFacturas(){
        f = new Facturas();
        f.setVisible(true);
    }
    
    public void ChargeRequisiciones(){
        r = new Requisiciones();
        r.setVisible(true);
    }
    
    public void ChargeAddProduct(DefaultTableModel tbm, String controller){
        ap = new AgregarProducto(tbm, controller);
        ap.setVisible(true);
    }
    
    public void ChargeProducctDitail(int id){
        pd = new ProductosDetalle(id);
        pd.setVisible(true);
    }
    
    public void ChargeProviderDetail(int id){
        prd = new ProveedoresDetalle(id);
        prd.setVisible(true);
    }
    
    public void ChargeBillsDetails(int id){
        fd = new FacturasDetalle(id);
        fd.setVisible(true);
    }
    
    public void ChageRequisitionsDetails(int id){
        rd = new RequisicionesDetalle(id);
        rd.setVisible(true);
    }
}
