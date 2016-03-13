/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cede.guis;

import com.cede.lib.ProductModel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import com.cede.guis.Facturas;

/**
 *
 * @author MHERNANDEZ
 */
public class AgregarProducto extends javax.swing.JFrame {
    private ImageIcon icon;
    ProductModel pm;
    DefaultTableModel tbm;
    private float total = 0;
    
    public AgregarProducto(DefaultTableModel tbm) {
        initComponents();
        this.tbm = tbm;
        this.setLocationRelativeTo(null);
        //Setting up the window logo
        icon = new ImageIcon(getClass().getResource("/com/cede/img/header-logo.png"));        
        //logoLabel.setIcon(icon);
         setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/com/cede/img/icono.png")));
        
        pm = new ProductModel();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        findProductTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        CantidadField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cancelarbtn = new javax.swing.JButton();
        agregarbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        findProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(findProductTable);

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        searchbtn.setText("Buscar");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad");

        cancelarbtn.setText("Cancelar");
        cancelarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarbtnActionPerformed(evt);
            }
        });

        agregarbtn.setText("Agregar");
        agregarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(searchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(cancelarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CantidadField)
                            .addComponent(agregarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarbtn)
                    .addComponent(agregarbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        /* Here is the code to perform when the "Enter" key is pressed */
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pm.ProductsSearch((DefaultTableModel)findProductTable.getModel(), searchField.getText());
         }
    }//GEN-LAST:event_searchFieldKeyPressed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        /* Here is the code to perform when the Buscar button is clicked */
        pm.ProductsSearch((DefaultTableModel)findProductTable.getModel(), searchField.getText());
    }//GEN-LAST:event_searchbtnActionPerformed

    private void cancelarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarbtnActionPerformed
        /* Here is the code to perform when the Cancelar  button is clicked */
        this.dispose();
    }//GEN-LAST:event_cancelarbtnActionPerformed

    private void agregarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarbtnActionPerformed
        /* Here is the code to perform when the Agragar button is clicked */
        tbm.addRow(new Object[]{findProductTable.getValueAt(findProductTable.getSelectedRow(), 0),
                            findProductTable.getValueAt(findProductTable.getSelectedRow(), 1),
                            findProductTable.getValueAt(findProductTable.getSelectedRow(), 2),
                            /*findProductTable.getValueAt(findProductTable.getSelectedRow(), 3)*/
                            Integer.parseInt(CantidadField.getText()),
                            findProductTable.getValueAt(findProductTable.getSelectedRow(), 4),
                            (Integer.parseInt(CantidadField.getText()) * 
                            Float.parseFloat(findProductTable.getValueAt(findProductTable.getSelectedRow(), 4).toString()))
        });
        
        int filas = tbm.getRowCount();
        for(int i = 0; i < filas; i++ ){
            total += Float.parseFloat(tbm.getValueAt(i,5).toString());
        }
        Facturas.totalFacturaField.setText(""+total);
        this.dispose();
    }//GEN-LAST:event_agregarbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CantidadField;
    private javax.swing.JButton agregarbtn;
    private javax.swing.JButton cancelarbtn;
    private javax.swing.JTable findProductTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchbtn;
    // End of variables declaration//GEN-END:variables
}
