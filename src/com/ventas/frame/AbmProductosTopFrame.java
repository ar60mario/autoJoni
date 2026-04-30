package com.ventas.frame;

import com.ventas.entities.Configuracion;
import com.ventas.entities.ConfiguracionTop;
import com.ventas.entities.Producto;
import com.ventas.entities.ProductoTop;
import com.ventas.entities.Rubro;
import com.ventas.main.MainFrame;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.ConfiguracionTopService;
import com.ventas.services.ProductoService;
import com.ventas.services.ProductoTopService;
import com.ventas.services.RubroService;
import com.ventas.util.UtilFrame;
import com.ventas.util.UtilTabla;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AbmProductosTopFrame extends javax.swing.JFrame {

    private List<ProductoTop> productos = null;
    private List<Rubro> rubros;
    private DecimalFormat df = new DecimalFormat("#0.00");

    public AbmProductosTopFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        panificadosChk.setSelected(false);
        panificadosChk.setVisible(false);
        llenarCombo();
//        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        nuevoBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        panificadosChk = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ABM - PRODUCTOS UTILIZADOS");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Detalle", "Neto", "Imp. Int.", "Final c/Iva", "Final Calc.Min", "Final Calc.Frx", "Mínimo Vta.", "Máximo Vta.", "Fraccionado", "Fracc.MP", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(270);
        }

        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        panificadosChk.setText("Panificados");
        panificadosChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panificadosChkActionPerformed(evt);
            }
        });

        jLabel1.setText("Tabacalera:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(modificarBtn)
                        .addGap(52, 52, 52)
                        .addComponent(panificadosChk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoBtn)
                    .addComponent(modificarBtn)
                    .addComponent(volverBtn)
                    .addComponent(panificadosChk))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        nuevo();
    }//GEN-LAST:event_nuevoBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        modificar();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void panificadosChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panificadosChkActionPerformed
        UtilFrame.limpiarTabla(tablaProductos);
        int row = combo.getSelectedIndex();
        if (row > 0) {
            if (panificadosChk.isSelected()) {
                llenarTablaPan();
            } else {
                llenarTabla(row);
            }
        }
    }//GEN-LAST:event_panificadosChkActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            llenarTabla(row);
        }
    }//GEN-LAST:event_comboActionPerformed

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
            java.util.logging.Logger.getLogger(AbmProductosTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmProductosTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmProductosTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmProductosTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmProductosTopFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JButton nuevoBtn;
    private javax.swing.JCheckBox panificadosChk;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarCombo() {
        combo.removeAllItems();
        combo.addItem("");
        rubros = null;
        try {
            rubros = new RubroService().getAllRubros();
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 246 - RUBROS");
            return;
        }
        for (Rubro r : rubros) {
            combo.addItem(r.getNombre());
        }
    }

    private void llenarTabla(Integer row) {
        productos = null;
        Rubro rubro = rubros.get(row - 1);
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Float pIva = 0F;
        if (cfg != null) {
            pIva = cfg.getIva();
        }
        try {
            productos = new ProductoTopService().getAllProductoTabacoTopActivos2(rubro);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        UtilFrame.limpiarTabla(tablaProductos);
        if (productos != null && !productos.isEmpty()) {
            UtilTabla ut = new UtilTabla();

            tablaProductos.setDefaultRenderer(Object.class, ut);
            DefaultTableModel tbl = (DefaultTableModel) tablaProductos.getModel();
            for (ProductoTop p : productos) {
                Object ob[] = new Object[11];
//                ob[0] = p.getOrden();
//                ob[1] = p.getCodigo();
                Producto prd = null;

                try {
                    prd = new ProductoService().getProductoByCodigo(p.getCodigo());
                } catch (Exception ex) {
                    Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (prd != null) {
                    ob[0] = prd.getDetalle();
//                    if (prd.getInactivo()) {
//                        ob[3] = "Inactivo";
//                    } else {
//                        ob[3] = "Activo";
//                    }
                    Double prec = (prd.getPrecio() * (1 + pIva / 100)) + prd.getImpuesto();
                    Double neto = prd.getPrecio();
                    Float impInt = prd.getImpuesto();
                    ob[1] = df.format(neto);
                    ob[2] = df.format(impInt);
                    ob[3] = df.format(prec);
                    ob[4] = df.format(prec * p.getCantidadMinimaVenta());
                    ob[5] = df.format(prec * p.getFraccionMp());
                    ob[10] = prd.getStock();
                }
                ob[6] = p.getCantidadMinimaVenta();
                ob[7] = p.getCantidadMaximaVenta();
                ob[8] = p.getFraccion();
                if (p.getFraccionMp() != null) {
                    ob[9] = p.getFraccionMp().toString();
                } else {
                    ob[9] = "0";
                }

                tbl.addRow(ob);
            }
            tablaProductos.setModel(tbl);
        }
    }

    private void nuevo() {
        if (panificadosChk.isSelected()) {
            NuevoProductoPanificadoTopFrame mf = new NuevoProductoPanificadoTopFrame();
            mf.setVisible(true);
            this.dispose();
        } else {
            NuevoProductoTopFrame mf = new NuevoProductoTopFrame();
            mf.setVisible(true);
            this.dispose();
        }
    }

    private void modificar() {
        int row = tablaProductos.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar que producto modificar");
            return;
        }
        ProductoTop p = productos.get(row);
        ModificarProductoTopFrame mptf = new ModificarProductoTopFrame(p);
        mptf.setVisible(true);
        this.dispose();
    }

    private void volver() {
        int row = combo.getSelectedIndex();
        if (row > 0) {
            int o = 0;
            for (ProductoTop p : productos) {
                p.setOrden(o);
                o += 1;
                try {
                    new ProductoTopService().updateProductoTop(p);
                } catch (Exception ex) {
                    Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ConfiguracionTop cf = null;
            try {
                cf = new ConfiguracionTopService().getConfigTopById(1);
            } catch (Exception ex) {
                Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            cf.setOrderMaximo(o);
            try {
                new ConfiguracionTopService().updateConfigTop(cf);
            } catch (Exception ex) {
                Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            int mx = 0;
        }
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void llenarTablaPan() {
        productos = null;
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Float pIva = 0F;
        if (cfg != null) {
            pIva = cfg.getIva();
        }
        try {
            productos = new ProductoTopService().getAllProductoTopActivos();
        } catch (Exception ex) {
            Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (productos != null && !productos.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaProductos.getModel();
            for (ProductoTop p : productos) {
                Object ob[] = new Object[6];
                ob[0] = p.getOrden();
                ob[1] = p.getCodigo();
                Producto prd = null;
                try {
                    prd = new ProductoService().getProductoPanificadoByCodigo(p.getCodigo());
                } catch (Exception ex) {
                    Logger.getLogger(AbmProductosTopFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (prd != null) {
                    ob[2] = prd.getDetalle();
                    if (prd.getInactivo()) {
                        ob[3] = "Inactivo";
                    } else {
                        ob[3] = "Activo";
                    }
                    ob[4] = df.format((prd.getPrecio() * (1 + pIva / 100)) + prd.getImpuesto());
                }
                ob[5] = p.getCantidad();
                tbl.addRow(ob);
            }
            tablaProductos.setModel(tbl);
        }
    }

}
