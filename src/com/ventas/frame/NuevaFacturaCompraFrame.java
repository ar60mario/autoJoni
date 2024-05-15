/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.frame;

import com.ventas.entities.Configuracion;
import com.ventas.entities.FacturaCompra;
import com.ventas.entities.Producto;
import com.ventas.entities.Rubro;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.FacturaCompraService;
import com.ventas.services.ProductoService;
import com.ventas.services.RubroService;
import com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author argia
 */
public class NuevaFacturaCompraFrame extends javax.swing.JFrame {

    private List<Producto> productos;
    private Producto producto;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Float porceIva = 0F;

    /**
     * Creates new form NuevaFacturaCompraFrame
     */
    public NuevaFacturaCompraFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        grabarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        netoGravadoTxt = new javax.swing.JTextField();
        ivaTxt = new javax.swing.JTextField();
        iibbTxt = new javax.swing.JTextField();
        impuesto_1Txt = new javax.swing.JTextField();
        impuesto_2Txt = new javax.swing.JTextField();
        impuesto_3Txt = new javax.swing.JTextField();
        proveedorTxt = new javax.swing.JTextField();
        fechaTxt = new javax.swing.JTextField();
        gananciaTxt = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        gravadoVentaTxt = new javax.swing.JTextField();
        ivaVentaTxt = new javax.swing.JTextField();
        totalVentaTxt = new javax.swing.JTextField();
        impuestoVentaTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("NUEVA FACTURA COMPRA X IMPORTE");

        jLabel1.setText("FECHA:");

        jLabel2.setText("GANANCIA:");

        jLabel3.setText("NETO GRAVADO:");

        jLabel4.setText("IVA:");

        jLabel5.setText("IIBB:");

        jLabel6.setText("IMPUESTO 1:");

        jLabel7.setText("IMPUESTO 2:");

        jLabel8.setText("IMPUESTO 3:");

        jLabel9.setText("PROVEEDOR:");

        jLabel10.setText("PRODUCTO:");

        grabarBtn.setText("GRABAR");
        grabarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarBtnActionPerformed(evt);
            }
        });
        grabarBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                grabarBtnKeyPressed(evt);
            }
        });

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        netoGravadoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netoGravadoTxt.setText("N.GRAVADO");
        netoGravadoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                netoGravadoTxtKeyPressed(evt);
            }
        });

        ivaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ivaTxt.setText("IVA");
        ivaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ivaTxtKeyPressed(evt);
            }
        });

        iibbTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        iibbTxt.setText("ING.BRUTOS");
        iibbTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iibbTxtKeyPressed(evt);
            }
        });

        impuesto_1Txt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        impuesto_1Txt.setText("IMPUESTO 1");
        impuesto_1Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                impuesto_1TxtKeyPressed(evt);
            }
        });

        impuesto_2Txt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        impuesto_2Txt.setText("IMPUESTO 2");
        impuesto_2Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                impuesto_2TxtKeyPressed(evt);
            }
        });

        impuesto_3Txt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        impuesto_3Txt.setText("IMPUESTO 3");
        impuesto_3Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                impuesto_3TxtKeyPressed(evt);
            }
        });

        proveedorTxt.setText("PROVEEDOR");
        proveedorTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                proveedorTxtKeyPressed(evt);
            }
        });

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        gananciaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gananciaTxt.setText("GANANCIA");
        gananciaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gananciaTxtKeyPressed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboKeyPressed(evt);
            }
        });

        jLabel11.setText("TOTAL FACTURA:");

        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        jLabel12.setText("CALCULADO");

        gravadoVentaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gravadoVentaTxt.setText("N.GRAV. VTA.");

        ivaVentaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ivaVentaTxt.setText("IVA VTA.");

        totalVentaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalVentaTxt.setText("TOTAL VTA.");

        impuestoVentaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        impuestoVentaTxt.setText("IMPUESTO VTA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(grabarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(gananciaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(netoGravadoTxt)
                                                .addComponent(ivaTxt)
                                                .addComponent(iibbTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                                .addComponent(impuesto_1Txt)
                                                .addComponent(impuesto_2Txt)
                                                .addComponent(impuesto_3Txt)
                                                .addComponent(proveedorTxt)
                                                .addComponent(fechaTxt)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(87, 87, 87)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(gravadoVentaTxt)
                                                    .addComponent(ivaVentaTxt)
                                                    .addComponent(impuestoVentaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(totalVentaTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel12)
                                                        .addGap(19, 19, 19))))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(gananciaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(netoGravadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gravadoVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ivaVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(iibbTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(impuesto_1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(impuestoVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(impuesto_2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(impuesto_3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(proveedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grabarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                gananciaTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaTxtKeyPressed

    private void gananciaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (gananciaTxt.getText().isEmpty()) {
                gananciaTxt.setText("5");
            }
            netoGravadoTxt.requestFocus();
        }
    }//GEN-LAST:event_gananciaTxtKeyPressed

    private void netoGravadoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_netoGravadoTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!netoGravadoTxt.getText().isEmpty()) {
                Double netoGravado = Double.valueOf(netoGravadoTxt.getText().replace(",", "."));
                ivaTxt.setText(df.format(netoGravado * .21));
                ivaTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_netoGravadoTxtKeyPressed

    private void ivaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!ivaTxt.getText().isEmpty()) {
                iibbTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_ivaTxtKeyPressed

    private void iibbTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iibbTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (iibbTxt.getText().isEmpty()) {
                iibbTxt.setText("0.00");
            }
            impuesto_1Txt.requestFocus();
        }

    }//GEN-LAST:event_iibbTxtKeyPressed

    private void impuesto_1TxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_impuesto_1TxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (impuesto_1Txt.getText().isEmpty()) {
                impuesto_1Txt.setText("0.00");
            }
            impuesto_2Txt.requestFocus();
        }
    }//GEN-LAST:event_impuesto_1TxtKeyPressed

    private void impuesto_2TxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_impuesto_2TxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (impuesto_2Txt.getText().isEmpty()) {
                impuesto_2Txt.setText("0.00");
            }
            impuesto_3Txt.requestFocus();
        }
    }//GEN-LAST:event_impuesto_2TxtKeyPressed

    private void impuesto_3TxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_impuesto_3TxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (impuesto_3Txt.getText().isEmpty()) {
                impuesto_3Txt.setText("0.00");
            }
            proveedorTxt.requestFocus();
        }
    }//GEN-LAST:event_impuesto_3TxtKeyPressed

    private void proveedorTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proveedorTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!proveedorTxt.getText().isEmpty()) {
                combo.addFocusListener(null);
                combo.showPopup();
                combo.requestFocus();
            }
        }
    }//GEN-LAST:event_proveedorTxtKeyPressed

    private void grabarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarBtnActionPerformed
        grabar();
    }//GEN-LAST:event_grabarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if (evt.getModifiers() == 16) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                producto = productos.get(row - 1);
                calcularTotal();
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        if (evt.getKeyCode() == 10) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                producto = productos.get(row - 1);
                calcularTotal();
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void grabarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grabarBtnKeyPressed
        if (evt.getKeyCode() == 10) {
            grabar();
        }
    }//GEN-LAST:event_grabarBtnKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaFacturaCompraFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField gananciaTxt;
    private javax.swing.JButton grabarBtn;
    private javax.swing.JTextField gravadoVentaTxt;
    private javax.swing.JTextField iibbTxt;
    private javax.swing.JTextField impuestoVentaTxt;
    private javax.swing.JTextField impuesto_1Txt;
    private javax.swing.JTextField impuesto_2Txt;
    private javax.swing.JTextField impuesto_3Txt;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JTextField ivaVentaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField netoGravadoTxt;
    private javax.swing.JTextField proveedorTxt;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JTextField totalVentaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        fechaTxt.setText("");
        gananciaTxt.setText("");
        netoGravadoTxt.setText("");
        impuesto_1Txt.setText("");
        impuesto_2Txt.setText("");
        impuesto_3Txt.setText("");
        iibbTxt.setText("");
        ivaTxt.setText("");
        totalTxt.setText("");
        proveedorTxt.setText("");
        gravadoVentaTxt.setText("");
        ivaVentaTxt.setText("");
        impuestoVentaTxt.setText("");
        totalVentaTxt.setText("");
        combo.removeAllItems();
        combo.addItem("");
        productos = null;
        Rubro rubro = null;
        try {
            rubro = new RubroService().getRubroByCodigo(100);
        } catch (Exception ex) {
            Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(rubro.getCodigo());
//        System.exit(0);
        if (rubro != null) {
            try {
                productos = new ProductoService().getAllProductosByRubro(rubro);
            } catch (Exception ex) {
                Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (productos != null && !productos.isEmpty()) {
                for (Producto producto : productos) {
                    combo.addItem(producto.getDetalle());
                }
            }
        }
        Long cf = 1L;
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(cf);
        } catch (Exception ex) {
//            Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR LEYENDO CONFIGURACION");
            return;
        }
        porceIva = cfg.getIva();
    }

    private void grabar() {
        if (validar()) {
            FacturaCompra facturaCompra = new FacturaCompra();
            Date fecha = new Date();
            try {
                fecha = sdf.parse(fechaTxt.getText());
            } catch (ParseException ex) {
                Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            Float ganancia = Float.valueOf(gananciaTxt.getText().replace(",", "."));
            Double gravado = Double.valueOf(netoGravadoTxt.getText().replace(",", "."));
            Double iva = Double.valueOf(ivaTxt.getText().replace(",", "."));
            Double iibb = Double.valueOf(iibbTxt.getText().replace(",", "."));
            Double impuesto_1 = Double.valueOf(impuesto_1Txt.getText().replace(",", "."));
            Double impuesto_2 = Double.valueOf(impuesto_2Txt.getText().replace(",", "."));
            Double impuesto_3 = Double.valueOf(impuesto_3Txt.getText().replace(",", "."));
            Double totalFc = Double.valueOf(totalTxt.getText().replace(",", "."));
            Double gravadoVenta = Double.valueOf(gravadoVentaTxt.getText().replace(",", "."));
            Double ivaVenta = Double.valueOf(ivaVentaTxt.getText().replace(",", "."));
            Double impuestoVenta = Double.valueOf(impuestoVentaTxt.getText().replace(",", "."));
            Double totalVenta = Double.valueOf(totalVentaTxt.getText().replace(",", "."));
            String proveedor = proveedorTxt.getText();
            int row = combo.getSelectedIndex();
            Producto producto = productos.get(row - 1);
            facturaCompra.setFecha(fecha);
            facturaCompra.setGanancia(ganancia);
            facturaCompra.setGravado(gravado);
            facturaCompra.setGravadoUtilizado(0.0);
            facturaCompra.setIibb(iibb);
            facturaCompra.setImpuesto1(impuesto_1);
            facturaCompra.setImpuesto2(impuesto_2);
            facturaCompra.setImpuesto3(impuesto_3);
            facturaCompra.setImpuestoUtilizado(0.0);
            facturaCompra.setIva(iva);
            facturaCompra.setIvaUtilizado(0.0);
            facturaCompra.setProcesado(false);
            facturaCompra.setProducto(producto);
            facturaCompra.setProveedor(proveedor);
            facturaCompra.setGravadoVenta(gravadoVenta);
            facturaCompra.setGravadoTemp(0.0);
            facturaCompra.setIvaVenta(ivaVenta);
            facturaCompra.setIvaTemp(0.0);
            facturaCompra.setImpuestoVenta(impuestoVenta);
            facturaCompra.setImpuestoTemp(0.0);
            facturaCompra.setTotalVenta(totalVenta);
            facturaCompra.setTotalUtilizado(0.0);
            facturaCompra.setTotal(totalFc);
            facturaCompra.setTotalTemp(0.0);
            try {
                new FacturaCompraService().saveFacturaCompra(facturaCompra);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERROR GRABANDO FACTURA COMPRA");
                return;
//                Logger.getLogger(NuevaFacturaCompraFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "FACTURA COMPRA GRABADA");
            volver();
        }
    }

    private boolean validar() {

        if (netoGravadoTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NETO GRAVADO NO PUEDE ESTAR EN CERO");
            netoGravadoTxt.requestFocus();
            return false;
        }
        if (ivaTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "IVA NO PUEDE ESTAR EN CERO");
            ivaTxt.requestFocus();
            return false;
        }

        return true;
    }

    private void volver() {
        AbmFacturasComprasFrame afcf = new AbmFacturasComprasFrame();
        afcf.setVisible(true);
        this.dispose();
    }

    private Double devolver(String text) {
        Double importe;
        if (text.isEmpty()) {
            importe = 0.0;
        } else {
            importe = Double.valueOf(text.replace(",", "."));
        }
        return importe;
    }

    private void calcularTotal() {

        if (netoGravadoTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NETO GRAVADO NO PUEDE ESTAR EN CERO");
            netoGravadoTxt.requestFocus();
            return;
        }
        Double netoGravado = Double.valueOf(netoGravadoTxt.getText().replace(",", "."));
        if (ivaTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "IVA NO PUEDE ESTAR EN CERO");
            ivaTxt.requestFocus();
            return;
        }
        if (gananciaTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "GANANCIA NO PUEDE ESTAR EN CERO");
            gananciaTxt.requestFocus();
            return;
        }
        Double total = 0.0;
        Double totalVenta = 0.0;
        Double impuestoVenta = 0.0;
        Double gravadoVenta;
        Double ivaVenta;
        Float ganancia = Float.valueOf(gananciaTxt.getText().replace(",", "."));
        gravadoVenta = netoGravado * (1 + ganancia / 100);
        ivaVenta = gravadoVenta * porceIva / 100;
        if (!impuesto_1Txt.getText().isEmpty()) {
            impuestoVenta += devolver(impuesto_1Txt.getText().replace(",", "."));
        }
        if (!impuesto_2Txt.getText().isEmpty()) {
            impuestoVenta += devolver(impuesto_2Txt.getText().replace(",", "."));
        }
        if (!impuesto_3Txt.getText().isEmpty()) {
            impuestoVenta += devolver(impuesto_3Txt.getText().replace(",", "."));
        }
        total += devolver(netoGravadoTxt.getText().replace(",", "."));
        total += devolver(ivaTxt.getText().replace(",", "."));
        total += devolver(iibbTxt.getText().replace(",", "."));
        total += devolver(impuesto_1Txt.getText().replace(",", "."));
        total += devolver(impuesto_2Txt.getText().replace(",", "."));
        total += devolver(impuesto_3Txt.getText().replace(",", "."));
        totalTxt.setText(df.format(total));
        ivaVentaTxt.setText(df.format(ivaVenta));
        impuestoVentaTxt.setText(df.format(impuestoVenta));
        totalVenta = gravadoVenta + ivaVenta + impuestoVenta;
        totalVentaTxt.setText(df.format(totalVenta));
        gravadoVentaTxt.setText(df.format(gravadoVenta));
    }
}
