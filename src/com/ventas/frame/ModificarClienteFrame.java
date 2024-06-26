/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.frame;

import com.ventas.entities.Cliente;
import com.ventas.entities.Domicilio;
import com.ventas.entities.TipoDoc;
import com.ventas.services.ClienteService;
import com.ventas.services.TipoDocService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcela
 */
public class ModificarClienteFrame extends javax.swing.JFrame {

    private final Logger logger = Logger.getLogger("EditarClienteFrame");
    private List<TipoDoc> tipos = null;
    //private List<Cliente> lista = new ArrayList<Cliente>();
    private Cliente cliente;

    // private Domicilio domicilio;
    /**
     *
     */
    public ModificarClienteFrame(Cliente clie) {
        initComponents();
        //limpiarCampos();
        this.cliente = clie;
        llenarCampos(cliente);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardarClienteBtn = new javax.swing.JButton();
        volverNuevoClienteBtn = new javax.swing.JButton();
        codigoTxt = new javax.swing.JTextField();
        razonSocialTxt = new javax.swing.JTextField();
        cuitTxt = new javax.swing.JTextField();
        calleTxt = new javax.swing.JTextField();
        telTxt = new javax.swing.JTextField();
        celTxt = new javax.swing.JTextField();
        mailTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        obsTxt = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        numeroTxt = new javax.swing.JTextField();
        pisoTxt = new javax.swing.JTextField();
        departamentoTxt = new javax.swing.JTextField();
        localidadTxT = new javax.swing.JTextField();
        provinciaTxt = new javax.swing.JTextField();
        descuentoTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        codigoPostalTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        llevaDtoChk = new javax.swing.JCheckBox();
        comboCategoria = new javax.swing.JComboBox();
        comboFormasPago = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        activoChk = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        comboT = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MODIFICAR CLIENTE");

        guardarClienteBtn.setText("Guardar");
        guardarClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarClienteBtnActionPerformed(evt);
            }
        });

        volverNuevoClienteBtn.setText("Volver");
        volverNuevoClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverNuevoClienteBtnActionPerformed(evt);
            }
        });

        codigoTxt.setText("Id");
        codigoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTxtActionPerformed(evt);
            }
        });

        razonSocialTxt.setText("Razón Social");

        cuitTxt.setText("Cuit");
        cuitTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuitTxtActionPerformed(evt);
            }
        });

        calleTxt.setText("Domicilio");
        calleTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calleTxtActionPerformed(evt);
            }
        });

        telTxt.setText("Teléfono");

        celTxt.setText("Celular");

        mailTxt.setText("Maiil");

        jLabel1.setText("Codigo:");

        jLabel2.setText("Razón Social");

        jLabel3.setText("Cuit");

        jLabel4.setText("Calle");

        jLabel5.setText("Categoria");

        jLabel6.setText("Telefono");

        jLabel7.setText("Celular");

        jLabel8.setText("Mail");

        jLabel9.setText("Observaciones");

        obsTxt.setColumns(20);
        obsTxt.setRows(5);
        jScrollPane2.setViewportView(obsTxt);

        jLabel10.setText("Numero");

        jLabel11.setText("Piso");

        jLabel12.setText("Dto");

        jLabel13.setText("Localidad");

        jLabel14.setText("Provincia");

        numeroTxt.setText("Numero");

        pisoTxt.setText("Piso");

        departamentoTxt.setText("Departam");

        localidadTxT.setText("Localidad");

        provinciaTxt.setText("Provincia");

        descuentoTxt.setText("Descuento");

        jLabel16.setText("Codigo Postal");

        codigoPostalTxt.setText("CODIGO POSTAL");

        jLabel17.setText("Forma de Pago");

        llevaDtoChk.setText("Lleva descuento");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboFormasPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setText("*");

        jLabel19.setText("*");

        jLabel20.setText("*");

        jLabel21.setText("*");

        jLabel22.setText("*");

        jLabel23.setText("*");

        activoChk.setText("Activo");

        jLabel15.setText("Tipo:");

        comboT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel24.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(codigoTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cuitTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(localidadTxT, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                            .addComponent(provinciaTxt)
                                            .addComponent(departamentoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                            .addComponent(pisoTxt))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(descuentoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(77, 77, 77))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboT, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(comboFormasPago, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel22)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel23))
                                        .addComponent(codigoPostalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(razonSocialTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                                .addComponent(calleTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(telTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(celTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(mailTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel21)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(activoChk)
                                                        .addComponent(llevaDtoChk))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel20)
                                                .addComponent(jLabel19)))))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(guardarClienteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverNuevoClienteBtn)
                        .addGap(97, 97, 97))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel15)
                    .addComponent(comboT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(llevaDtoChk)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pisoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activoChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(departamentoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(localidadTxT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFormasPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(codigoPostalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(provinciaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(celTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volverNuevoClienteBtn)
                    .addComponent(guardarClienteBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarClienteBtnActionPerformed
        guardarCliente();
    }//GEN-LAST:event_guardarClienteBtnActionPerformed

    private void volverNuevoClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverNuevoClienteBtnActionPerformed
        AbmClienteFrame abmClienteFrame = new AbmClienteFrame();
        this.dispose();
        abmClienteFrame.setVisible(true);
    }//GEN-LAST:event_volverNuevoClienteBtnActionPerformed

    private void codigoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTxtActionPerformed

    private void cuitTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuitTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuitTxtActionPerformed

    private void calleTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calleTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calleTxtActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarClienteFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activoChk;
    private javax.swing.JTextField calleTxt;
    private javax.swing.JTextField celTxt;
    private javax.swing.JTextField codigoPostalTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JComboBox comboFormasPago;
    private javax.swing.JComboBox<String> comboT;
    private javax.swing.JTextField cuitTxt;
    private javax.swing.JTextField departamentoTxt;
    private javax.swing.JTextField descuentoTxt;
    private javax.swing.JButton guardarClienteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox llevaDtoChk;
    private javax.swing.JTextField localidadTxT;
    private javax.swing.JTextField mailTxt;
    private javax.swing.JTextField numeroTxt;
    private javax.swing.JTextArea obsTxt;
    private javax.swing.JTextField pisoTxt;
    private javax.swing.JTextField provinciaTxt;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JTextField telTxt;
    private javax.swing.JButton volverNuevoClienteBtn;
    // End of variables declaration//GEN-END:variables

    private void guardarCliente() {
        if (validarCampos()) {

            cliente.setCodigo(codigoTxt.getText());
            cliente.setRazonSocial(razonSocialTxt.getText());
            cliente.setCuit(cuitTxt.getText());
            cliente.setCategoriaDeIva(comboCategoria.getSelectedIndex());
            cliente.setTelefono(telTxt.getText());
            cliente.setCelular(celTxt.getText());
            cliente.setMail(mailTxt.getText());
            cliente.setObservaciones(obsTxt.getText());
            cliente.setSaldo(0.0);
            cliente.setFormaDePago(comboFormasPago.getSelectedIndex());
            cliente.setDescuento(Float.valueOf(descuentoTxt.getText()));
            if (activoChk.isSelected()) {
                cliente.setActivo(true);
            } else {
                cliente.setActivo(false);
            }
            if (llevaDtoChk.isSelected()) {
                cliente.setTieneDescuento(true);
            } else {
                cliente.setTieneDescuento(false);
            }
            // Armar la direccion
            Domicilio domicilio = cliente.getDomicilio();
            domicilio.setCalle(calleTxt.getText());
            domicilio.setNumero(numeroTxt.getText());
            domicilio.setPiso(pisoTxt.getText());
            domicilio.setDepartamento(departamentoTxt.getText());
            domicilio.setLocalidad(localidadTxT.getText());
            domicilio.setProvincia(provinciaTxt.getText());
            domicilio.setCodigoPostal(codigoPostalTxt.getText());

            cliente.setDomicilio(domicilio);
            int row = comboT.getSelectedIndex();
            String tip = tipos.get(row).getCodigo();
            cliente.setTipo(tip);
            try {
                new ClienteService().updateCliente(cliente);
                JOptionPane.showMessageDialog(this, "CLIENTE guardado correctamente.");
            } catch (Exception ex) {
                Logger.getLogger(ModificarClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "CLIENTE no guardado.");
            }
            AbmClienteFrame acf = new AbmClienteFrame();
            acf.setVisible(true);
            this.dispose();

        }
    }

    private void llenarCampos(Cliente cliente) {
        Domicilio domicilio = cliente.getDomicilio();
        descuentoTxt.setVisible(false);
        llevaDtoChk.setVisible(false);
        codigoTxt.setText(cliente.getCodigo());
        celTxt.setText(cliente.getCelular());
        cuitTxt.setText(cliente.getCuit());
        razonSocialTxt.setText(cliente.getRazonSocial());
        telTxt.setText(cliente.getTelefono());
        mailTxt.setText(cliente.getMail());
        obsTxt.setText(cliente.getObservaciones());
        descuentoTxt.setText(String.valueOf(cliente.getDescuento()));
        comboT.removeAllItems();
        String tp = cliente.getTipo();

        try {
            tipos = new TipoDocService().getAllTipoDocs();
        } catch (Exception ex) {
            Logger.getLogger(ModificarClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tipos != null && !tipos.isEmpty()) {
            for (TipoDoc t : tipos) {
                comboT.addItem(t.getCodigo() + " " + t.getDescripcion());
            }
            int largo = tipos.size();
            int i = 0;
            for (int x = 0; x < largo; x++) {
                if (tipos.get(x).getCodigo().equals(cliente.getTipo())) {
                    i = x;
                }
            }
            comboT.setSelectedIndex(i);
        }

        //formaDePagoTxt.setText(String.valueOf(cliente.getFormaDePago()));
        if (cliente.getTieneDescuento()) {
            llevaDtoChk.setSelected(true);
        } else {
            llevaDtoChk.setSelected(false);
        }
        if (cliente.getActivo()) {
            activoChk.setSelected(true);
        } else {
            activoChk.setSelected(false);
        }
        // aqui se desarma domicilio en sus componentes:
        // calle numero piso dto, etc
        calleTxt.setText(domicilio.getCalle());
        numeroTxt.setText(domicilio.getNumero());
        pisoTxt.setText(domicilio.getPiso());
        departamentoTxt.setText(domicilio.getDepartamento());
        codigoPostalTxt.setText(domicilio.getCodigoPostal());
        localidadTxT.setText(domicilio.getLocalidad());
        provinciaTxt.setText(domicilio.getProvincia());

        //lenar combo categoria y combo Formas pago
        comboCategoria.removeAllItems();
        comboFormasPago.removeAllItems();
        comboCategoria.addItem("");
        comboFormasPago.addItem("");
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboCategoria.getModel();

        model.addElement("1- Inscripto");
        model.addElement("2- Monotributo");
        model.addElement("3- Exento");
        model.addElement("4- Consumidor Final");

        DefaultComboBoxModel model2 = (DefaultComboBoxModel) comboFormasPago.getModel();

        model2.addElement("1- Contado");
        model2.addElement("2- 7 dias fecha factura");
        model2.addElement("3- 14-dias fecha factura");
        model2.addElement("4- otro");

        comboCategoria.setModel(model);
        comboFormasPago.setModel(model2);
        if (cliente.getCategoriaDeIva() != null) {
            comboCategoria.setSelectedIndex(cliente.getCategoriaDeIva());
        }
        if (cliente.getFormaDePago() != null) {
            comboFormasPago.setSelectedIndex(cliente.getFormaDePago());
        }
    }

    private boolean validarCampos() {
        if (codigoTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CLIENTE - Verifique el Codigo.");
            return false;
        }
//        if (tipoTxt.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "CLIENTE - Ingrese Tipo Documento.");
//            tipoTxt.requestFocus();
//            return false;
//        }
        if (numeroTxt.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "CLIENTE - Verifique el Número.");
            return false;
        }
        if (razonSocialTxt.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Cliente - Verifique la Razon Social.");
            return false;
        }
        if (comboCategoria.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Cliente - Seleccione la Categoria del Cliente");
            return false;
        }
        if (comboFormasPago.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Cliente - Seleccione la Forma de Pago del cliente");
        }
        if (calleTxt.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Cliente - Complete la Calle");
            return false;
        }

        return true;
    }

}
