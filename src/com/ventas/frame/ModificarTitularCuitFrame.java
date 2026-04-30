package com.ventas.frame;

import com.ventas.entities.TitularCuit;
import com.ventas.estructuras.Constante;
import com.ventas.main.MainFrame;
import com.ventas.services.TitularCuitService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ModificarTitularCuitFrame extends javax.swing.JFrame {

    private JPanel contentPanel;
    private TitularCuit titular;

    public ModificarTitularCuitFrame(TitularCuit titular) {
        initComponents();
        this.titular = titular;
        limpiarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rutaCrtTxt = new javax.swing.JTextField();
        rutaKeyTxt = new javax.swing.JTextField();
        grabarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        leerRutaCrtBtn = new javax.swing.JButton();
        leerRutaKeyBtn = new javax.swing.JButton();
        razonSocialTxt = new javax.swing.JTextField();
        comboC = new javax.swing.JComboBox<>();
        comboT = new javax.swing.JComboBox<>();
        cuitTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        iibbTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        calleTxt = new javax.swing.JTextField();
        localidadTxt = new javax.swing.JTextField();
        puntoVentaTxt = new javax.swing.JTextField();
        activoChk = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NUEVO TITULAR CUIT");

        jLabel1.setText("Razón Social:");

        jLabel3.setText("Categoría Arca:");

        jLabel4.setText("CUIT:");

        jLabel2.setText("Tipo Doc:");

        jLabel5.setText("IIBB:");

        jLabel6.setText("Calle Número Piso Dpto.:");

        jLabel7.setText("CP. Localidad Provincia:");

        jLabel8.setText("Punto de Venta:");

        jLabel9.setText("Ruta crt:");

        jLabel10.setText("Ruta key:");

        rutaCrtTxt.setText("RUTA CRT");

        rutaKeyTxt.setText("RUTA KEY");

        grabarBtn.setText("Grabar");
        grabarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        leerRutaCrtBtn.setText("Leer Ruta CRT");
        leerRutaCrtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerRutaCrtBtnActionPerformed(evt);
            }
        });

        leerRutaKeyBtn.setText("Leer Ruta KEY");
        leerRutaKeyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerRutaKeyBtnActionPerformed(evt);
            }
        });

        razonSocialTxt.setText("RAZON SOCIAL");

        comboC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cuitTxt.setText("CUIT");

        jLabel11.setText("11 dígitos sin guiones");

        iibbTxt.setText("IIBB");

        jLabel12.setText("completo con guiones");

        calleTxt.setText("CALLE NÚMERO");

        localidadTxt.setText("CP LOCALIDAD PROVINCIA");

        puntoVentaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        puntoVentaTxt.setText("PV");

        activoChk.setText("Activo");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rutaCrtTxt)
                    .addComponent(rutaKeyTxt)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(grabarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(leerRutaCrtBtn)
                        .addGap(18, 18, 18)
                        .addComponent(leerRutaKeyBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 451, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(iibbTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cuitTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboT, javax.swing.GroupLayout.Alignment.LEADING, 0, 180, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(comboC, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(activoChk))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(localidadTxt)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(puntoVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activoChk))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(iibbTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(localidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(puntoVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rutaCrtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rutaKeyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grabarBtn)
                    .addComponent(volverBtn)
                    .addComponent(leerRutaCrtBtn)
                    .addComponent(leerRutaKeyBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void grabarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarBtnActionPerformed
        grabar();
    }//GEN-LAST:event_grabarBtnActionPerformed

    private void leerRutaCrtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerRutaCrtBtnActionPerformed
        leerRutaCrt();
    }//GEN-LAST:event_leerRutaCrtBtnActionPerformed

    private void leerRutaKeyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerRutaKeyBtnActionPerformed
        leerRutaKey();
    }//GEN-LAST:event_leerRutaKeyBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarTitularCuitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarTitularCuitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarTitularCuitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarTitularCuitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarTitularCuitFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activoChk;
    private javax.swing.JTextField calleTxt;
    private javax.swing.JComboBox<String> comboC;
    private javax.swing.JComboBox<String> comboT;
    private javax.swing.JTextField cuitTxt;
    private javax.swing.JButton grabarBtn;
    private javax.swing.JTextField iibbTxt;
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
    private javax.swing.JButton leerRutaCrtBtn;
    private javax.swing.JButton leerRutaKeyBtn;
    private javax.swing.JTextField localidadTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField puntoVentaTxt;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JTextField rutaCrtTxt;
    private javax.swing.JTextField rutaKeyTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constante.getR(), Constante.getG(), Constante.getB()));
        JFrame jFrame = ModificarTitularCuitFrame.this;
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        String str0 = "NUEVO TITULAR CUIT - FACTURACIÓN AUTOMÁTICA";
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        setContentPane(contentPanel);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volver();
            }
        });
        llenarFrame();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void grabar() {
        int codigo = titular.getCodigo();
        if (validar()) {
//            try {
//                codigo = new TitularCuitService().getUltimoCodigoTitularCuit();
//            } catch (Exception ex) {
//                Logger.getLogger(ModificarTitularCuitFrame.class.getName()).log(Level.SEVERE, null, ex);
//                codigo = 1;
//            }
            int categ = comboC.getSelectedIndex();
            Integer ptoVta = Integer.valueOf(puntoVentaTxt.getText());
            String tipoDoc = "";
            Integer td = comboT.getSelectedIndex();
            if (td.equals(1)) {
                tipoDoc = "80";
            }
//            TitularCuit tc = new TitularCuit();
            if (activoChk.isSelected()) {
                titular.setActivo(true);
            } else {
                titular.setActivo(false);
            }
            titular.setCalleNroPisoDto(calleTxt.getText());
            titular.setCategoria(categ);
//            titular.setCodigo(codigo);
            titular.setCpLocalidadProvincia(localidadTxt.getText());
            titular.setCuit(cuitTxt.getText());
            titular.setIibb(iibbTxt.getText());
            titular.setPuntoVenta(ptoVta);
            titular.setRazonSocial(razonSocialTxt.getText());
            titular.setRutaCrt(rutaCrtTxt.getText());
            titular.setRutaKey(rutaKeyTxt.getText());
            titular.setTipoDoc(tipoDoc);
            try {
                new TitularCuitService().updateTitularCuit(titular);
            } catch (Exception ex) {
                Logger.getLogger(ModificarTitularCuitFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR");
                return;
            }
            JOptionPane.showMessageDialog(this, "OK");
            volver();
        }
    }

    private void leerRutaCrt() {
        String ruta1 = obtenerRuta();
        rutaCrtTxt.setText(ruta1);

    }

    private void leerRutaKey() {
        String ruta1 = obtenerRuta();
        rutaKeyTxt.setText(ruta1);
    }

    private boolean validar() {
        return true;
    }

    private String obtenerRuta() {
        JFileChooser seleccion = new JFileChooser();
        seleccion.showOpenDialog(this);
        File archivo = seleccion.getSelectedFile();
//        String filePath = archivo.getAbsolutePath();
        String ruta1 = archivo.getAbsolutePath();
        return ruta1;
    }

    private void llenarFrame() {
        String tipoDoc = titular.getTipoDoc();
        razonSocialTxt.setText(titular.getRazonSocial());
        comboC.removeAllItems();
        comboC.addItem("");
        comboC.addItem("INSCRIPTO");
        comboC.setSelectedIndex(titular.getCategoria());
        comboT.removeAllItems();
        comboT.addItem("");
        comboT.addItem("80 - CUIT");
        if (tipoDoc.equals("80")) {
            comboT.setSelectedIndex(1);
        }
        cuitTxt.setText(titular.getCuit());
        iibbTxt.setText(titular.getIibb());
        calleTxt.setText(titular.getCalleNroPisoDto());
        localidadTxt.setText(titular.getCpLocalidadProvincia());
        puntoVentaTxt.setText(titular.getPuntoVenta().toString());
        String rutaCrt = titular.getRutaCrt();
        String rutaKey = titular.getRutaKey();
        rutaCrtTxt.setText(rutaCrt);
        rutaKeyTxt.setText(rutaKey);
        if (titular.getActivo()) {
            activoChk.setSelected(true);
        } else {
            activoChk.setSelected(false);
        }
    }
}
