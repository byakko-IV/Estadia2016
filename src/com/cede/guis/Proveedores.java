/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cede.guis;

import com.cede.lib.GuiDisplayer;
import com.cede.lib.ProviderModel;
import com.cede.models.Provider;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MHERNANDEZ
 */
public class Proveedores extends javax.swing.JFrame {
    private ImageIcon icon;
    private GuiDisplayer g;
    private ProviderModel pm;
    /**
     * Creates new form Main
     */
    public Proveedores() {
        initComponents();
        icon = new ImageIcon(getClass().getResource("/com/cede/img/header-logo.png"));        
        logoLabel.setIcon(icon);
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/com/cede/img/icono.png")));
        g = new GuiDisplayer();
        pm = new ProviderModel();
        pm.ProveedoresTotal((DefaultTableModel)tablaProviders.getModel());
        
        this.disableFields();
    }

    private void cleanFields(){
        rfcField.setText("");
        nombreField.setText("");
        domicilioField.setText("");
        telefonoField.setText("");
    }

    private void disableFields(){
        rfcField.disable();
        nombreField.disable();
        domicilioField.disable();
        telefonoField.disable();
        Cancelbtn.setEnabled(false);
        Guardarbtn.setEnabled(false);
        Nuevobtn.setEnabled(true);
    }

    private void enableFields(){
        rfcField.enable();
        rfcField.requestFocus();
        nombreField.enable();
        domicilioField.enable();
        telefonoField.enable();
        Cancelbtn.setEnabled(true);
        Guardarbtn.setEnabled(true);
        Nuevobtn.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rfcField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        domicilioField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        telefonoField = new javax.swing.JTextField();
        Nuevobtn = new javax.swing.JButton();
        Cancelbtn = new javax.swing.JButton();
        Guardarbtn = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProviders = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        Editarbtn = new javax.swing.JButton();
        Eliminarbtn = new javax.swing.JButton();
        ParametroCombo = new javax.swing.JComboBox();
        searchProviderField = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proveedores");
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(6);

        logoLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("RFC");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombre");

        jLabel3.setText("Domicilio");

        jLabel5.setText("Teléfono");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(domicilioField)
                            .addComponent(telefonoField)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfcField)
                            .addComponent(nombreField))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rfcField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(domicilioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefonoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        Nuevobtn.setText("Nuevo");
        Nuevobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevobtnActionPerformed(evt);
            }
        });

        Cancelbtn.setText("Cancelar");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });

        Guardarbtn.setText("Guardar");
        Guardarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Nuevobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(Guardarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nuevobtn)
                    .addComponent(Cancelbtn)
                    .addComponent(Guardarbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cede/img/productos-icon.png"))); // NOI18N
        jButton1.setText("Productos");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setIconTextGap(-10);
        jButton1.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cede/img/proveedores-icon.png"))); // NOI18N
        jButton2.setText("Proveedores");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setIconTextGap(-10);
        jButton2.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cede/img/facturas-icon.png"))); // NOI18N
        jButton3.setText("Facturas");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setIconTextGap(-10);
        jButton3.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cede/img/requisiciones-icon.png"))); // NOI18N
        jButton4.setText("Requisiciones");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setIconTextGap(-10);
        jButton4.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaProviders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaProviders);

        jButton8.setText("Detalle");

        Editarbtn.setText("Editar");
        Editarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarbtnActionPerformed(evt);
            }
        });

        Eliminarbtn.setText("Eliminar");
        Eliminarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarbtnActionPerformed(evt);
            }
        });

        ParametroCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nombre", "domicilio" }));

        searchProviderField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchProviderFieldKeyPressed(evt);
            }
        });

        jButton11.setText("Buscar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Editarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Eliminarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ParametroCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchProviderField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ParametroCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchProviderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(Editarbtn)
                    .addComponent(Eliminarbtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        MenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        MenuSalir.setText("Salir");
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(MenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*Here is the code to perform when the producto´s button is clicked*/
        g.ChargeMain();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*Here is de code to perform when de factura´s button is clicked*/
        g.ChargeFacturas();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*Here there is nothing to do*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        /*Here is the code to perform when the requisicione´s button is clicked*/
        g.ChargeRequisiciones();
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void GuardarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarbtnActionPerformed
        /*Here is the code to perform whe the guardar button is cliecked*/
        try{
            Provider p = new Provider( pm.getProviderId() + 1, rfcField.getText(), nombreField.getText(), domicilioField.getText(),
                                       telefonoField.getText());
            pm.storeProvider(p);
            this.cleanFields();
            this.disableFields();
            pm.ProveedoresTotal((DefaultTableModel)tablaProviders.getModel());
            //System.out.println(pm.getProviderId());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage()+"\nVerifique");
        }
    }//GEN-LAST:event_GuardarbtnActionPerformed

    private void NuevobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevobtnActionPerformed
        this.cleanFields();
        this.enableFields();
    }//GEN-LAST:event_NuevobtnActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        this.cleanFields();
        this.disableFields();
    }//GEN-LAST:event_CancelbtnActionPerformed

    private void EditarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarbtnActionPerformed
        /*Here is the code to perform whe the editar button is clicked*/
        try{
            Provider p = new Provider(
                    Integer.parseInt(tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 0).toString()),
                    tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 1).toString(),
                    tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 2).toString(),
                    tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 3).toString(),
                    tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 4).toString()
                    );
            pm.updatePorvider(p);
            pm.ProveedoresTotal((DefaultTableModel)tablaProviders.getModel());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage()+"\nVerifique");
        }
    }//GEN-LAST:event_EditarbtnActionPerformed

    private void EliminarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarbtnActionPerformed
        try{
            Provider p = new Provider(
                    Integer.parseInt(tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 0).toString()),
                    tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 1).toString(),
                    tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 2).toString(),
                    tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 3).toString(),
                    tablaProviders.getValueAt(tablaProviders.getSelectedRow(), 4).toString()
                    );
            pm.providerDelete(p);
            pm.ProveedoresTotal((DefaultTableModel)tablaProviders.getModel());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage()+"\nVerifique");
        }
    }//GEN-LAST:event_EliminarbtnActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        /*Here is the code to perform when the search butto is clicked*/
        pm.SearchProvider((DefaultTableModel)tablaProviders.getModel(), ParametroCombo.getSelectedItem().toString(), 
                searchProviderField.getText());
    }//GEN-LAST:event_jButton11ActionPerformed

    private void searchProviderFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchProviderFieldKeyPressed
        /*Here is the code to perform when the search butto is clicked*/
        System.out.print(ParametroCombo.getSelectedItem().toString());
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pm.SearchProvider((DefaultTableModel)tablaProviders.getModel(), ParametroCombo.getSelectedItem().toString(), 
                searchProviderField.getText());
        }
    }//GEN-LAST:event_searchProviderFieldKeyPressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JButton Editarbtn;
    private javax.swing.JButton Eliminarbtn;
    private javax.swing.JButton Guardarbtn;
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JButton Nuevobtn;
    private javax.swing.JComboBox ParametroCombo;
    private javax.swing.JTextField domicilioField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField rfcField;
    private javax.swing.JTextField searchProviderField;
    private javax.swing.JTable tablaProviders;
    private javax.swing.JTextField telefonoField;
    // End of variables declaration//GEN-END:variables
}
