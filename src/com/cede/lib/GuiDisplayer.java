/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cede.lib;

import com.cede.guis.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MHERNANDEZ
 */
public class GuiDisplayer {
    Main m;
    Proveedores p;
    Facturas f;
    Requisiciones r;
    AgregarProducto ap;
    ProductosDetalle pd;
    
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
    
}
