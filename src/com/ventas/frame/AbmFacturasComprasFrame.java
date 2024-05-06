/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.frame;

import com.ventas.main.MainFrame;
import com.ventas.util.UtilFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author argia
 */
public class AbmFacturasComprasFrame extends javax.swing.JFrame {

    /**
     * Creates new form AbmFacturasComprasFrame
     */
    public AbmFacturasComprasFrame() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        nuevaBtn = new javax.swing.JButton();
        filtrarProveedorBtn = new javax.swing.JButton();
        importarExcelBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        alTxt = new javax.swing.JTextField();
        soloPendientesBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "PROVEEDOR", "TOTAL", "PROCESADA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(400);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("FECHA:");

        deTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deTxt.setText("FECHA");
        deTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deTxtKeyPressed(evt);
            }
        });

        nuevaBtn.setText("NUEVA");
        nuevaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaBtnActionPerformed(evt);
            }
        });

        filtrarProveedorBtn.setText("FILTRAR PROVEEDOR");
        filtrarProveedorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarProveedorBtnActionPerformed(evt);
            }
        });

        importarExcelBtn.setText("IMPORTAR EXCEL");
        importarExcelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarExcelBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("HASTA:");

        alTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alTxt.setText("HASTA");
        alTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alTxtKeyPressed(evt);
            }
        });

        soloPendientesBtn.setText("SOLO PENDIENTES");
        soloPendientesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soloPendientesBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(filtrarProveedorBtn)
                        .addGap(18, 18, 18)
                        .addComponent(importarExcelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(soloPendientesBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevaBtn)
                    .addComponent(filtrarProveedorBtn)
                    .addComponent(importarExcelBtn)
                    .addComponent(soloPendientesBtn)
                    .addComponent(volverBtn))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importarExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarExcelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importarExcelBtnActionPerformed

    private void filtrarProveedorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarProveedorBtnActionPerformed
        int row = tabla.getSelectedRow();
        if(row < 0){
            
        }
        
    }//GEN-LAST:event_filtrarProveedorBtnActionPerformed

    private void nuevaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaBtnActionPerformed
        nuevaFacturaCompra();
    }//GEN-LAST:event_nuevaBtnActionPerformed

    private void deTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deTxtKeyPressed
        if(evt.getKeyCode()==10){
            String fe = deTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                alTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            deTxt.setText(fe);
        }
    }//GEN-LAST:event_deTxtKeyPressed

    private void alTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alTxtKeyPressed
        if(evt.getKeyCode()==10){
            String fe = alTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                buscar();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            alTxt.setText(fe);
        }
    }//GEN-LAST:event_alTxtKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void soloPendientesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soloPendientesBtnActionPerformed
        soloPendientes();
    }//GEN-LAST:event_soloPendientesBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AbmFacturasComprasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmFacturasComprasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmFacturasComprasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmFacturasComprasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmFacturasComprasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JTextField deTxt;
    private javax.swing.JButton filtrarProveedorBtn;
    private javax.swing.JButton importarExcelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevaBtn;
    private javax.swing.JButton soloPendientesBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void nuevaFacturaCompra() {
        NuevaFacturaCompraFrame nfcf = new NuevaFacturaCompraFrame();
        nfcf.setVisible(true);
        this.dispose();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void soloPendientes() {
        
    }

    private void limpiarCampos() {
        deTxt.setText("");
        alTxt.setText("");
    }

    private void buscar() {
        
    }
}
