package com.ventas.frame;

import com.ventas.entities.Producto;
import com.ventas.entities.ProductoIntercambio;
import com.ventas.entities.ProductoTop;
import com.ventas.main.MainFrame;
import java.util.List;
import javax.swing.JOptionPane;
import com.ventas.services.ProductoService;
import com.ventas.services.ProductoTopService;
import com.ventas.util.LectorDeExcel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import jxl.read.biff.BiffException;

public class ImportarProductoParaActualizarStockFrame extends javax.swing.JFrame {

    private File archivoImportado = null;
    private ProductoIntercambio listaProductos = null;
    private List<Producto> produs;
    private List<ProductoTop> produTos;

    public ImportarProductoParaActualizarStockFrame(File archivo) {
        initComponents();
        this.archivoImportado = archivo;
        limpiarCampos();
        try {
            this.llenarTablaProductoImportado();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error importando los datos.\nSi esto persiste, asegurese que el archivo sea correcto.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductoImportado = new javax.swing.JTable();
        aceptarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EIMPORTAR EXCEL PARA ACTUALIZAR STOCKS");

        tablaProductoImportado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "DESCRIPCION", "STOCK", "INGRESO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductoImportado);
        if (tablaProductoImportado.getColumnModel().getColumnCount() > 0) {
            tablaProductoImportado.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaProductoImportado.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        aceptarBtn.setText("Actualizar");
        aceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aceptarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed
        guardarProductos();
    }//GEN-LAST:event_aceptarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ImportarProductoParaActualizarStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportarProductoParaActualizarStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportarProductoParaActualizarStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportarProductoParaActualizarStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ImportarProductoParaActualizarStockFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductoImportado;
    // End of variables declaration//GEN-END:variables

    private void llenarTablaProductoImportado() throws IOException, BiffException, Exception {
        listaProductos = LectorDeExcel.leerExcelParaActualizStocks(archivoImportado);
//        JOptionPane.showMessageDialog(this, "EEE");
        DefaultTableModel modelo = (DefaultTableModel) tablaProductoImportado.getModel();
        if (listaProductos != null) {
            produs = listaProductos.getProductos();
            produTos = listaProductos.getProductosTop();;
            for (Producto produ : produs) {
                Object[] fila = new Object[7];
                fila[0] = produ.getDetalle();
                fila[2] = produ.getStock();
                modelo.addRow(fila);
            }
            tablaProductoImportado.setModel(modelo);
        } else {
            Object[] mensaje = new Object[2];
            mensaje[0] = " ";
            mensaje[1] = "No se recuperó ningún PRODUCTO del archivo";
            modelo.addRow(mensaje);
            aceptarBtn.setEnabled(false);
        }
    }

    private void guardarProductos() {
        for (Producto p : produs) {
            try {
                new ProductoService().updateProducto(p);
            } catch (Exception ex) {
                Logger.getLogger(ImportarProductoParaActualizarStockFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERR1");
                return;
            }
        }
        for (ProductoTop pt : produTos) {
            try {
                new ProductoTopService().updateProductoTop(pt);
            } catch (Exception ex) {
                Logger.getLogger(ImportarProductoParaActualizarStockFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERR1");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Precios actualizados correctamente.");
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();

    }

    private void limpiarCampos() {
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
    }

}
