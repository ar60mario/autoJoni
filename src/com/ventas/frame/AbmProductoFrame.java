package com.ventas.frame;

import com.ventas.entities.Producto;
import com.ventas.entities.Rubro;
import com.ventas.main.MainFrame;
import com.ventas.services.ProductoService;
import com.ventas.services.RubroService;
import com.ventas.util.LectorDeExcel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Supervisor
 */
public class AbmProductoFrame extends javax.swing.JFrame {

    private List<Producto> listadoProducto = null;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private DefaultTableModel tbl = null;
    private String filtro = "";
    private DecimalFormat df = new DecimalFormat("#0.0");
    private DecimalFormat dfp = new DecimalFormat("#0.00");
    private List<Rubro> rubros;

    /**
     * Creates new form AbmProductoFrame
     *
     * @param filtro
     */
    public AbmProductoFrame(String filtro) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        this.filtro = filtro;
        panificadosChk.setSelected(false);
        panificadosChk.setEnabled(false);
        limpiarCampos();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        modificarBtn = new javax.swing.JButton();
        nuevoBtn = new javax.swing.JButton();
        borrarBtn = new javax.swing.JButton();
        productoTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        productoBtn = new javax.swing.JButton();
        importarBtn = new javax.swing.JButton();
        panificadosChk = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ABM PRODUCTOS - TODOS");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Codigo de barra", "Detalle", "Precio", "Impuesto", "Rubro", "Sub rubro", "Sugerido", "Activo", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(75);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(75);
            tablaProductos.getColumnModel().getColumn(5).setPreferredWidth(50);
            tablaProductos.getColumnModel().getColumn(6).setPreferredWidth(50);
            tablaProductos.getColumnModel().getColumn(7).setPreferredWidth(50);
            tablaProductos.getColumnModel().getColumn(8).setPreferredWidth(50);
            tablaProductos.getColumnModel().getColumn(9).setPreferredWidth(45);
        }

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        borrarBtn.setText("Borrar");
        borrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarBtnActionPerformed(evt);
            }
        });

        productoTxt.setText("PRODUCTO");
        productoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productoTxtKeyPressed(evt);
            }
        });

        jLabel1.setText("Producto:");

        productoBtn.setText("Buscar");
        productoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoBtnActionPerformed(evt);
            }
        });

        importarBtn.setText("Importar");
        importarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarBtnActionPerformed(evt);
            }
        });

        panificadosChk.setText("Panificados");
        panificadosChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panificadosChkActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtro Rubro:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(modificarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(importarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borrarBtn)
                        .addGap(90, 90, 90)
                        .addComponent(volverBtn)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productoBtn)
                .addGap(18, 18, 18)
                .addComponent(panificadosChk)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(productoBtn)
                    .addComponent(panificadosChk)
                    .addComponent(jLabel2)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(modificarBtn)
                    .addComponent(nuevoBtn)
                    .addComponent(borrarBtn)
                    .addComponent(importarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        Producto producto = this.productoSeleccionado();
        filtro = productoTxt.getText();
        if (producto != null) {
            ModificarProductoFrame mcf = new ModificarProductoFrame(producto, this.filtro);
            mcf.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un producto para cntinuar");
        }
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        NuevoProductoFrame nuevoProductoFrame = new NuevoProductoFrame(filtro);
        nuevoProductoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nuevoBtnActionPerformed

    private void borrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarBtnActionPerformed
        borrarProducto();
    }//GEN-LAST:event_borrarBtnActionPerformed

    private void productoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoBtnActionPerformed
        borrarTabla();
        this.llenarTabla();
    }//GEN-LAST:event_productoBtnActionPerformed

    private void productoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            borrarTabla();
            this.llenarTabla();
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_productoTxtKeyPressed

    private void importarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarBtnActionPerformed
        importar();
    }//GEN-LAST:event_importarBtnActionPerformed

    private void panificadosChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panificadosChkActionPerformed
        borrarTabla();
        this.llenarTabla();
    }//GEN-LAST:event_panificadosChkActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if (evt.getModifiers() == 16) {
            int row = combo.getSelectedIndex();
            borrarTabla();
            if (row > 0) {
                llenarTablaByRubro();
            }
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
            java.util.logging.Logger.getLogger(AbmProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AbmProductoFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton importarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JButton nuevoBtn;
    private javax.swing.JCheckBox panificadosChk;
    private javax.swing.JButton productoBtn;
    private javax.swing.JTextField productoTxt;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        int row = combo.getSelectedIndex();
        Rubro ru;
        if (row > 0) {
            ru = rubros.get(row - 1);
        } else {
            JOptionPane.showMessageDialog(this, "ERROR EN RUBROS");
            return;
        }

        this.filtro = productoTxt.getText();
        if (panificadosChk.isSelected()) {
            try {
                ProductoService productoService = new ProductoService();
                listadoProducto = productoService.getProductosPanificadosByFiltro(filtro);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "error con la base de datos");
            }
        } else {
            try {
                ProductoService productoService = new ProductoService();
                listadoProducto = productoService.getProductosByFiltroAndRubro(filtro, ru);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "error con la base de datos");
            }
        }
        tbl = (DefaultTableModel) tablaProductos.getModel();
        if (listadoProducto != null && !listadoProducto.isEmpty()) {
            for (Producto producto : listadoProducto) { // Recorro la lista de productos y lleno la tabla.
                Object[] fila = new Object[10];
                fila[0] = producto.getCodigo();
                fila[1] = producto.getCodigoBarras();
                fila[2] = producto.getDetalle();
                fila[3] = dfp.format(producto.getPrecio());
                fila[4] = dfp.format(producto.getImpuesto());
                fila[5] = producto.getRubro().getCodigo();
                fila[6] = producto.getSubRubro().getCodigo();
                fila[7] = dfp.format(producto.getSugerido());
                if (producto.getStock() != null) {
                    fila[9] = df.format(producto.getStock());
                } else {
                    fila[9] = df.format(0);
                }
                if (producto.getInactivo()) {
                    fila[8] = "Inactivo";
                } else {
                    fila[8] = "Activo";
                }
                tbl.addRow(fila); // Agrego la fila a la tabla
            }
        }
        tablaProductos.setModel(tbl); // Pongo la tabla visible.
    }

    private Producto productoSeleccionado() {
        Producto producto = null;
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1 && listadoProducto != null && !listadoProducto.isEmpty()) {
            producto = listadoProducto.get(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Producto de la lista");
        }
        return producto;
    }

    private void borrarProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Desea eliminar el Producto?",
                    "Borrar",
                    JOptionPane.OK_CANCEL_OPTION);
            if (confirm == JOptionPane.OK_OPTION) {
                Producto prodABorrar = getProductoSeleccionado();
                try {
                    new ProductoService().deleteProducto(prodABorrar);
                    listadoProducto.remove(filaSeleccionada);
                    borrarTabla();
                    llenarTabla();
                } catch (Exception ex) {
                    logger.log(Level.SEVERE, ex.getMessage());
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un error eliminando el Producto.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un Producto para eliminarlo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private Producto getProductoSeleccionado() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            Producto producto = listadoProducto.get(filaSeleccionada);
            return producto;
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Producto de la lista.");
        }
        return null;
    }

    private void limpiarCampos() {
        productoTxt.setText(this.filtro);
        rubros = null;
        try {
            rubros = new RubroService().getAllRubros();
        } catch (Exception ex) {
            Logger.getLogger(AbmProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR LEYENDO RUBROS");
            return;
        }
        combo.removeAllItems();
        combo.addItem("");
        if (rubros != null && !rubros.isEmpty()) {
            for (Rubro r : rubros) {
                combo.addItem(r.getNombre());
            }
        }
        combo.setSelectedIndex(2);
    }

    private void borrarTabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
            int filas = tablaProductos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    private void importar() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            if (LectorDeExcel.validarExtension(archivo)) {
                ImportarProductoFrame ipf = new ImportarProductoFrame(archivo);
                ipf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El formato elegido no está soportado.",
                        "Atencion",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void llenarTablaByRubro() {
        int row = combo.getSelectedIndex();
        Rubro r = rubros.get(row - 1);
        this.filtro = productoTxt.getText();
        if (panificadosChk.isSelected()) {
            try {
                ProductoService productoService = new ProductoService();
                listadoProducto = productoService.getProductosPanificadosByFiltro(filtro);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "error con la base de datos");
            }
        } else {
            try {
                ProductoService productoService = new ProductoService();
                listadoProducto = productoService.getProductosByFiltroAndRubro(filtro, r);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "error con la base de datos");
            }
        }
        tbl = (DefaultTableModel) tablaProductos.getModel();
        if (listadoProducto != null && !listadoProducto.isEmpty()) {
            for (Producto producto : listadoProducto) { // Recorro la lista de productos y lleno la tabla.
                Object[] fila = new Object[10];
                fila[0] = producto.getCodigo();
                fila[1] = producto.getCodigoBarras();
                fila[2] = producto.getDetalle();
                fila[3] = dfp.format(producto.getPrecio());
                fila[4] = dfp.format(producto.getImpuesto());
                fila[5] = producto.getRubro().getCodigo();
                fila[6] = producto.getSubRubro().getCodigo();
                fila[7] = dfp.format(producto.getSugerido());
                if (producto.getStock() != null) {
                    fila[9] = df.format(producto.getStock());
                } else {
                    fila[9] = df.format(0);
                }
                if (producto.getInactivo()) {
                    fila[8] = "Inactivo";
                } else {
                    fila[8] = "Activo";
                }
                tbl.addRow(fila); // Agrego la fila a la tabla
            }
        }
        tablaProductos.setModel(tbl); // Pongo la tabla visible.
    }
}
