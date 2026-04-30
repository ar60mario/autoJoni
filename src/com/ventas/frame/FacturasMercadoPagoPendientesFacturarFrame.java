package com.ventas.frame;

import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.Factura;
import com.ventas.entities.NuevaFactura;
import com.ventas.entities.RenglonFc;
import com.ventas.main.MainFrame;
import com.ventas.services.CompraClienteMercadoPagoService;
import com.ventas.services.FacturaService;
import com.ventas.services.NuevaFacturaService;
import com.ventas.services.RenglonFcService;
import com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FacturasMercadoPagoPendientesFacturarFrame extends javax.swing.JFrame {

    private List<CompraClienteMercadoPago> facturasComprasMP;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#,##0.00");

    public FacturasMercadoPagoPendientesFacturarFrame() {
        initComponents();
        limpiarCampos();
        cargarFacturas();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        modificarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        porFechaRb = new javax.swing.JRadioButton();
        porClienteRb = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("COMPRAS MERCADO PAGO PENDIENTES DE FACTURAR");

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "CUIT", "CLIENTE", "IMPORTE", "ORIGEN", "LETR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        modificarBtn.setText("MODIFICAR");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        eliminarBtn.setText("ELIMINAR");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        porFechaRb.setText("Por fecha");
        porFechaRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porFechaRbActionPerformed(evt);
            }
        });

        porClienteRb.setText("Por Cliente");
        porClienteRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porClienteRbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(modificarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(porFechaRb)
                        .addGap(18, 18, 18)
                        .addComponent(porClienteRb)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(porFechaRb)
                    .addComponent(porClienteRb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(modificarBtn)
                    .addComponent(eliminarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN MOVIMIENTO PARA MODIFICAR");
            return;
        }
        CompraClienteMercadoPago ccmp = facturasComprasMP.get(row);
        modificar(ccmp);
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        int rows = tabla.getSelectedRowCount();
        int a[] = tabla.getSelectedRows();
        if (rows < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN MOVIMIENTO PARA ELIMINAR");
            return;
        }
        int ax = JOptionPane.showConfirmDialog(this, "CONFIRME ELIMINAR MOVIMIENTOS SELECCIONADOS", "Atención", JOptionPane.YES_NO_OPTION);
        if (ax == 0) {
            for (int n = rows - 1; n > -1; n--) {
                if (a[n] < facturasComprasMP.size()) {
                    CompraClienteMercadoPago ccmp = facturasComprasMP.get(a[n]);
                    facturasComprasMP.remove(a[n]);
                    eliminar(ccmp);
                }
            }
            JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
            cargarFacturas();
            llenarTabla();
        }
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void porFechaRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porFechaRbActionPerformed
        porFechaRb.setSelected(true);
        porClienteRb.setSelected(false);
        cargarFacturas();
    }//GEN-LAST:event_porFechaRbActionPerformed

    private void porClienteRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porClienteRbActionPerformed
        porFechaRb.setSelected(false);
        porClienteRb.setSelected(true);
        cargarFacturas();
    }//GEN-LAST:event_porClienteRbActionPerformed

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
            java.util.logging.Logger.getLogger(FacturasMercadoPagoPendientesFacturarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturasMercadoPagoPendientesFacturarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturasMercadoPagoPendientesFacturarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturasMercadoPagoPendientesFacturarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturasMercadoPagoPendientesFacturarFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JRadioButton porClienteRb;
    private javax.swing.JRadioButton porFechaRb;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void cargarFacturas() {
        facturasComprasMP = null;
        try {
            if (porFechaRb.isSelected()) {
                facturasComprasMP = new CompraClienteMercadoPagoService().getAllFacturasPendientesDeProcesarPorFecha();
            } else {
                facturasComprasMP = new CompraClienteMercadoPagoService().getAllFacturasPendientesDeProcesarPorFecha();
            }
        } catch (Exception ex) {
            Logger.getLogger(FacturasMercadoPagoPendientesFacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        if (facturasComprasMP != null && !facturasComprasMP.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (CompraClienteMercadoPago ccmp : facturasComprasMP) {
                Object o[] = new Object[6];
                o[0] = ccmp.getFecha();
                o[1] = ccmp.getCuit();
                o[2] = ccmp.getNombre();
                o[3] = df.format(ccmp.getImporte());
                o[4] = ccmp.getOperacion();
//                if (ccmp.getLetraFactura() != null) {
//                    o[5] = ccmp.getLetraFactura();
//                } else {
//                    o[5] = "B";
//                }
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void eliminar(CompraClienteMercadoPago ccmp) {
        ccmp.setProcesado(true);
        try {
            new CompraClienteMercadoPagoService().updateCompraClientesImportados(ccmp);
        } catch (Exception ex) {
            Logger.getLogger(FacturasMercadoPagoPendientesFacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

////        int a = JOptionPane.showConfirmDialog(this, "CONFIRME ELIMINAR MOVIMIENTO", "Atención", JOptionPane.YES_NO_OPTION);
////        if (a == 0) {
//            List<Factura> lnf = null;
//            try {
//                lnf = new FacturaService().getFacturaByCompraClienteMp(ccmp);
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(this, "ERROR nro. 247");
//                return;
//            }
//            if (lnf != null && !lnf.isEmpty()) {
//                for (Factura fa : lnf) {
//                    List<RenglonFc> renglns = null;
//                    try {
//                        renglns = new RenglonFcService().getRenglonesByFc(fa);
//                    } catch (Exception ex) {
//                        JOptionPane.showMessageDialog(this, "ERROR nro. 258");
//                        return;
//                    }
//                    if (renglns != null && !renglns.isEmpty()) {
//                        try {
//                            new RenglonFcService().deleteFacturaAndRenglones(fa, renglns);
//                        } catch (Exception ex) {
//                            JOptionPane.showMessageDialog(this, "ERROR nro. 265");
//                            return;
//                        }
//                    }
//                }
//            }
//            try {
//                new CompraClienteMercadoPagoService().deleteCompraClienteMP(ccmp);
//                
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(this, "ERROR 234 - NO ELIMINADO");
//            }
////        }
    }

    private void modificar(CompraClienteMercadoPago ccmp) {
        ModificarCompraMercadoPagoFrame mcmpf = new ModificarCompraMercadoPagoFrame(ccmp);
        mcmpf.setVisible(true);
        this.dispose();
    }

    private void limpiarCampos() {
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        setLocationRelativeTo(null);
        porFechaRb.setSelected(true);
    }
}
