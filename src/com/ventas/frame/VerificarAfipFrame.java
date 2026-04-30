package com.ventas.frame;

import com.ventas.main.MainFrame;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import com.ventas.entities.TitularCuit;
import com.ventas.services.TitularCuitService;
import com.ventas.util.Constantes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VerificarAfipFrame extends javax.swing.JFrame {

    private List<TitularCuit> titulares;

    public VerificarAfipFrame() {
        initComponents();
        limpiarCampos();
        cargarTitulares();
        llenarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verificarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        facturaBTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        notaCreditoBTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboT = new javax.swing.JComboBox<>();
        versionWsaaTxt = new javax.swing.JTextField();
        razonSocialTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        facturaATxt = new javax.swing.JTextField();
        notaCreditoATxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VERIFICAR ACCESO AFIP");

        verificarBtn.setText("Verificar");
        verificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Ultimo Comprobante Factura B utilizado:");

        facturaBTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        facturaBTxt.setText("FC B");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("VARIOS");

        jLabel2.setText("Ultimo Comprobante Nota de Crédito B utilizado:");

        notaCreditoBTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        notaCreditoBTxt.setText("NC B");

        jLabel3.setText("Titular Cuit:");

        comboT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTActionPerformed(evt);
            }
        });

        versionWsaaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        versionWsaaTxt.setText("VER");

        razonSocialTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        razonSocialTxt.setText("CUIT");

        jLabel4.setText("Ultimo Comprobante Factura A utilizado:");

        jLabel6.setText("Ultimo Comprobante Nota de Crédito A utilizado:");

        facturaATxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        facturaATxt.setText("FC A");

        notaCreditoATxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        notaCreditoATxt.setText("NC A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(versionWsaaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(facturaBTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(notaCreditoBTxt)
                                    .addComponent(facturaATxt)
                                    .addComponent(notaCreditoATxt))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(facturaBTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(notaCreditoBTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(facturaATxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(notaCreditoATxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(versionWsaaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verificarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void verificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarBtnActionPerformed
        verificar();
    }//GEN-LAST:event_verificarBtnActionPerformed

    private void comboTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTActionPerformed
        int row = comboT.getSelectedIndex();
        if (row > 0) {
            verificar();
        }
    }//GEN-LAST:event_comboTActionPerformed

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
            java.util.logging.Logger.getLogger(VerificarAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerificarAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerificarAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerificarAfipFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerificarAfipFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboT;
    private javax.swing.JTextField facturaATxt;
    private javax.swing.JTextField facturaBTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField notaCreditoATxt;
    private javax.swing.JTextField notaCreditoBTxt;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JButton verificarBtn;
    private javax.swing.JTextField versionWsaaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void verificar() {
        int row = comboT.getSelectedIndex();
        if (row < 1) {
            JOptionPane.showMessageDialog(this, "ERROR TITULAR");
            return;
        }
        TitularCuit tc = titulares.get(row - 1);
        try {
            LibraryLoader.loadJacobLibrary();
            ActiveXComponent wsaa = new ActiveXComponent("WSAA");
            String ver_wsaa = Dispatch.get(wsaa, "InstallDir").toString();
            versionWsaaTxt.setText(ver_wsaa
            + " "
            + Dispatch.get(wsaa, "Version").toString());
            System.out.println(ver_wsaa
                    + " "
                    + Dispatch.get(wsaa, "Version").toString()
            );
            razonSocialTxt.setText(tc.getCuit());
            String wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
            String userdir = Constantes.userdir;
            Dispatch.call(wsaa, "Autenticar",
                    new Variant("wsfe"),
                    //                    new Variant(userdir + "/dario2023_290f8f532bf779a9.crt"),
                    //                    new Variant(userdir + "/clave_privada_20249273253_202305142338.key"),
                    new Variant(tc.getRutaCrt()),
                    new Variant(tc.getRutaKey()),
                    new Variant(wsdl));
            String excepcion = Dispatch.get(wsaa, "Excepcion").toString();
            System.out.println(excepcion);
//            JOptionPane.showMessageDialog(this, excepcion);
            String token = Dispatch.get(wsaa, "Token").toString();
            String sign = Dispatch.get(wsaa, "Sign").toString();
            ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
            Dispatch.put(wsfev1, "Cuit", new Variant(tc.getCuit()));
            Dispatch.put(wsfev1, "Token", new Variant(token));
            Dispatch.put(wsfev1, "Sign", new Variant(sign));
            String cache = "";
            //https://wsaahomo.afip.gov.ar/ws/services/LoginCms?wsdl  HOMOLOGACION
            //wsdl = "https://wsaahomo.afip.gov.ar/ws/services/LoginCms?wsdl";
            wsdl = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL"; // produccion
            Dispatch.call(wsfev1, "Conectar",
                    new Variant(cache),
                    new Variant(wsdl)
            );
            String tipo_cbte = "6"; //Factura B
            String pto_vta = tc.getPuntoVenta().toString(); // Sucursal declarada WS
            Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                    new Variant(tipo_cbte),
                    new Variant(pto_vta));
            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//            JOptionPane.showMessageDialog(this, excepcion);
            facturaBTxt.setText(ult.toString());
            tipo_cbte = "1"; //Factura B
            ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                    new Variant(tipo_cbte),
                    new Variant(pto_vta));
            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
            facturaATxt.setText(ult.toString());
            tipo_cbte = "3"; //Nc A
            ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                    new Variant(tipo_cbte),
                    new Variant(pto_vta));
            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
            notaCreditoATxt.setText(ult.toString());
            tipo_cbte = "8"; //Nc B
            ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                    new Variant(tipo_cbte),
                    new Variant(pto_vta));
            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
            notaCreditoBTxt.setText(ult.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            e.printStackTrace();
            return;
        }
        // verificar Punto Venta 7
        // PANIFICADOS
//        
//        try {
//            LibraryLoader.loadJacobLibrary();
//            ActiveXComponent wsaa = new ActiveXComponent("WSAA");
//            String wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
//            String userdir = "c:/certadriel";
//            Dispatch.call(wsaa, "Autenticar",
//                    new Variant("wsfe"),
//                    new Variant(userdir + "/Adriel2020_6bd4a7cc99b8087c.crt"),
//                    new Variant(userdir + "/clave_privada_23329560449_202001190135.key"),
////                    new Variant(userdir + "/adriel7_4eadf1766beca905.crt"),
////                    new Variant(userdir + "/clave_privada_23329560449_202006011046.key"),
//                    //
//                    //
//                    new Variant(wsdl));
//            String excepcion = Dispatch.get(wsaa, "Excepcion").toString();
//            System.out.println(excepcion);
////            JOptionPane.showMessageDialog(this, excepcion);
//            String token = Dispatch.get(wsaa, "Token").toString();
//            String sign = Dispatch.get(wsaa, "Sign").toString();
//            ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
//            Dispatch.put(wsfev1, "Cuit", new Variant("23329560449"));
//            Dispatch.put(wsfev1, "Token", new Variant(token));
//            Dispatch.put(wsfev1, "Sign", new Variant(sign));
//            String cache = "";
//            //https://wsaahomo.afip.gov.ar/ws/services/LoginCms?wsdl  HOMOLOGACION
//            //wsdl = "https://wsaahomo.afip.gov.ar/ws/services/LoginCms?wsdl";
//            wsdl = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL"; // produccion
//            Dispatch.call(wsfev1, "Conectar",
//                    new Variant(cache),
//                    new Variant(wsdl)
//            );
//            String tipo_cbte = "1";
//            tipo_cbte = "1"; //Factura A
//            String pto_vta = "7"; // Sucursal declarada WS
//            Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
//                    new Variant(tipo_cbte),
//                    new Variant(pto_vta));
//            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
////            JOptionPane.showMessageDialog(this, excepcion);
//            facturasPanificadosATxt.setText(ult.toString());
//            tipo_cbte = "6"; //Factura B
//            ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
//                    new Variant(tipo_cbte),
//                    new Variant(pto_vta));
//            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//            facturasPanificadosBTxt.setText(ult.toString());
//            tipo_cbte = "3"; //Nc A
//            ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
//                    new Variant(tipo_cbte),
//                    new Variant(pto_vta));
//            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//            notaCreditoPanificadosATxt.setText(ult.toString());
//            tipo_cbte = "8"; //Nc B
//            ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
//                    new Variant(tipo_cbte),
//                    new Variant(pto_vta));
//            excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//            notaCreditoPanificadosBTxt.setText(ult.toString());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e);
//            e.printStackTrace();
//            return;
//        }
    }

    private void limpiarCampos() {
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        facturaBTxt.setText("");
        notaCreditoBTxt.setText("");
        facturaATxt.setText("");
        notaCreditoATxt.setText("");
//        facturaBTxt.setText("");
//        notaCreditoATxt.setText("");
//        notaCreditoBTxt.setText("");

//        facturasPanificadosATxt.setText("");
//        facturasPanificadosBTxt.setText("");
//        notaCreditoPanificadosATxt.setText("");
//        notaCreditoPanificadosBTxt.setText("");
//        facturasPanificadosATxt.setVisible(false);
//        facturasPanificadosBTxt.setVisible(false);
//        notaCreditoPanificadosATxt.setVisible(false);
//        notaCreditoPanificadosBTxt.setVisible(false);
//        jLabel6.setVisible(false);
    }

    private void cargarTitulares() {
        try {
            titulares = new TitularCuitService().getTitularCuitActivos();
        } catch (Exception ex) {
            Logger.getLogger(VerificarAfipFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR");
        }
    }

    private void llenarCombo() {
        comboT.removeAllItems();
        comboT.addItem("");
        if (titulares != null && !titulares.isEmpty()) {
            for (TitularCuit tc : titulares) {
                comboT.addItem(tc.getRazonSocial());
            }
        }
    }
}
