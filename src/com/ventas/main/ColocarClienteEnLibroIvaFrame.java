package com.ventas.main;

import com.ventas.entities.Cliente;
import com.ventas.entities.Domicilio;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import com.ventas.services.FacturaCompraReferenciaMercadoPagoService;
import com.ventas.services.IvaVentasService;
import com.ventas.util.Constantes;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ColocarClienteEnLibroIvaFrame extends javax.swing.JFrame {

    private JPanel contentPanel;

    public ColocarClienteEnLibroIvaFrame() {
        initComponents();
        limpiarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        actualizarBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actualizarBtn.setText("Actualizar");
        actualizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarBtnActionPerformed(evt);
            }
        });

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actualizarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(salirBtn)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarBtn)
                    .addComponent(salirBtn))
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
                .addGap(0, 34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        salir();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        actualizar();
    }//GEN-LAST:event_actualizarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ColocarClienteEnLibroIvaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColocarClienteEnLibroIvaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColocarClienteEnLibroIvaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColocarClienteEnLibroIvaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColocarClienteEnLibroIvaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(100, 100, 255));
        JFrame jFrame = ColocarClienteEnLibroIvaFrame.this;
        jFrame.setLocationRelativeTo(null);
        String str0 = "HERRAMIENTAS - LIBRO IVA";
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setTitle("ACTUALIZACION LIBRO IVA VENTAS");
        setContentPane(contentPanel);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });
    }

    private void salir() {
        System.exit(0);
    }

    private void actualizar() {
        List<IvaVentas> libroIva = null;
        try {
            libroIva = new IvaVentasService().getAllIvaVentas();
        } catch (Exception ex) {
            Logger.getLogger(ColocarClienteEnLibroIvaFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        for (IvaVentas iv : libroIva) {
            Cliente cliente = iv.getCliente();
            if (iv.getRazonSocialCliente() == null) {
                if (cliente.getId().equals(1L)) {
                    iv.setDescripcion("AUTOM");
                    iv.setOperacion("AUTOM");
                } else {
                    iv.setDescripcion("mp");
                    iv.setOperacion("_");
                }
                iv.setRazonSocialCliente(cliente.getRazonSocial());
                iv.setCuitCliente(cliente.getCuit());
                FacturaCompraReferenciaMercadoPago fcrmp = null;
                try {
                    fcrmp = new FacturaCompraReferenciaMercadoPagoService().getFacturaByIvaVentas(iv);
                } catch (Exception ex) {
                    Logger.getLogger(ColocarClienteEnLibroIvaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (fcrmp != null) {
                    iv.setRazonSocialCliente(fcrmp.getCompraClienteMercadoPago().getNombre());
                    iv.setCuitCliente(fcrmp.getCompraClienteMercadoPago().getCuit());
                    iv.setDescripcion(fcrmp.getCompraClienteMercadoPago().getOrigen());
                    if (fcrmp.getCompraClienteMercadoPago().getOperacion() != null) {
                        iv.setOperacion(fcrmp.getCompraClienteMercadoPago().getOperacion());
                    }
                }
                Domicilio dm = cliente.getDomicilio();
                iv.setCalleNroCliente(dm.getCalle() + " " + dm.getNumero());
                iv.setCpLocalidadProvinciaCliente(dm.getCodigoPostal()
                        + " " + dm.getLocalidad()
                        + " " + dm.getProvincia());
                iv.setCuitTitular(Constantes.cuitTitular);
                iv.setRazonSocialTitular(Constantes.razon_social_titular);
                iv.setCalleNroTitular(Constantes.calleNroTitular);
                iv.setCpLocalidadProvinciaTitular(Constantes.cpLocalidadProvinciaTitular);
                iv.setIibbTitular(Constantes.iibbTitular);
                iv.setInicioActividades(Constantes.inicioActividades);
                try {
                    new IvaVentasService().updateIvaVentas(iv);
                } catch (Exception ex) {
                    Logger.getLogger(ColocarClienteEnLibroIvaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
