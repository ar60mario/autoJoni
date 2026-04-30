package com.ventas.frame;

import com.ventas.entities.Producto;
import com.ventas.entities.ProductoTop;
import com.ventas.entities.Rubro;
import com.ventas.entities.SubRubro;
import com.ventas.main.MainFrame;
import com.ventas.services.ProductoService;
import com.ventas.services.ProductoTopService;
import com.ventas.services.RubroService;
import com.ventas.util.Constantes;
import com.ventas.util.LectorDeExcel;
import com.ventas.util.UtilFactura;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class AbmProductoFrame extends javax.swing.JFrame {

    private List<Producto> listadoProducto = null;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private DefaultTableModel tbl = null;
    private String filtro = "";
    private DecimalFormat df = new DecimalFormat("#0.0");
    private DecimalFormat dfp = new DecimalFormat("#0.00");
    private List<Rubro> rubros;

    /**
     * @param filtro
     */
    public AbmProductoFrame(String filtro) {
        initComponents();
        this.filtro = filtro;
        limpiarCampos();
    }

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
        excelBtn = new javax.swing.JButton();
        actualizarStockBtn = new javax.swing.JButton();
        habilitarPrecioPorcentajeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                "Detalle", "Neto", "Imp. Int.", "Final c/iva", "Stock", "Util"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(200);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(75);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(75);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(75);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(45);
            tablaProductos.getColumnModel().getColumn(5).setPreferredWidth(20);
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

        borrarBtn.setText("Borrar x Tabacalera");
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

        importarBtn.setText("Importar Nuevos");
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

        excelBtn.setText("Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        actualizarStockBtn.setText("ActualizarStocks");
        actualizarStockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarStockBtnActionPerformed(evt);
            }
        });

        habilitarPrecioPorcentajeBtn.setText("Habilitar Precio Porcentaje");
        habilitarPrecioPorcentajeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarPrecioPorcentajeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nuevoBtn)
                                .addGap(18, 18, 18)
                                .addComponent(modificarBtn)
                                .addGap(18, 18, 18)
                                .addComponent(borrarBtn)
                                .addGap(18, 18, 18)
                                .addComponent(importarBtn)
                                .addGap(153, 153, 153)
                                .addComponent(actualizarStockBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(excelBtn)
                                .addGap(18, 18, 18)
                                .addComponent(habilitarPrecioPorcentajeBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(volverBtn))))
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(modificarBtn)
                    .addComponent(nuevoBtn)
                    .addComponent(borrarBtn)
                    .addComponent(importarBtn)
                    .addComponent(excelBtn)
                    .addComponent(actualizarStockBtn)
                    .addComponent(habilitarPrecioPorcentajeBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
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
        int row = combo.getSelectedIndex();
        if (row > 0) {
            borrarTabla();
            Rubro ru = rubros.get(row - 1);
            buscarPorRubro(ru);
            llenarTablaFinal();
        }
    }//GEN-LAST:event_comboActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        excel();
    }//GEN-LAST:event_excelBtnActionPerformed

    private void actualizarStockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarStockBtnActionPerformed
        actualizarStocks();
    }//GEN-LAST:event_actualizarStockBtnActionPerformed

    private void habilitarPrecioPorcentajeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarPrecioPorcentajeBtnActionPerformed
        habilitarByPorcentaje();
    }//GEN-LAST:event_habilitarPrecioPorcentajeBtnActionPerformed

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
    private javax.swing.JButton actualizarStockBtn;
    private javax.swing.JButton borrarBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton excelBtn;
    private javax.swing.JButton habilitarPrecioPorcentajeBtn;
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
        llenarTablaFinal();
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
        int row = combo.getSelectedIndex();
        Rubro rubro = rubros.get(row - 1);
        List<Producto> productosViejos;
        try {
            productosViejos = new ProductoService().getAllProductosByRubro(rubro);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 396 - PRODUCTOS");
            return;
        }
        if (productosViejos != null && !productosViejos.isEmpty()) {
            for (Producto p : productosViejos) {
                p.setInactivo(true);
                try {
                    new ProductoService().updateProducto(p);
                } catch (Exception ex) {
                    Logger.getLogger(AbmProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR 396 - PRODUCTOS");
                    return;
                }
            }
        }
        List<ProductoTop> productosTopViejos;
        try {
            productosTopViejos = new ProductoTopService().getAllProductoTabacoTopActivos2(rubro);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 396 - PRODUCTOS UTILIZADOS");
            return;
        }
        if (productosTopViejos != null && !productosTopViejos.isEmpty()) {
            for (ProductoTop pt : productosTopViejos) {
                pt.setActivo(false);
                try {
                    new ProductoTopService().updateProductoTop(pt);
                } catch (Exception ex) {
                    Logger.getLogger(AbmProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR 396 - PRODUCTOS URILIZADOS");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
        volver();
    }

    private void limpiarCampos() {
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
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
        panificadosChk.setSelected(false);
        panificadosChk.setEnabled(false);
        panificadosChk.setVisible(false);
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

    private void llenarTablaByRubro(Integer row) {
//        int row = combo.getSelectedIndex();
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
        llenarTablaFinal();
//        if (listadoProducto != null && !listadoProducto.isEmpty()) {
//            for (Producto producto : listadoProducto) { // Recorro la lista de productos y lleno la tabla.
//                Object[] fila = new Object[10];
//                fila[0] = producto.getCodigo();
//                fila[1] = producto.getCodigoBarras();
//                fila[2] = producto.getDetalle();
//                fila[3] = dfp.format(producto.getPrecio());
//                fila[4] = dfp.format(producto.getImpuesto());
//                fila[5] = producto.getRubro().getCodigo();
//                fila[6] = producto.getSubRubro().getCodigo();
//                fila[7] = dfp.format(producto.getSugerido());
//                if (producto.getStock() != null) {
//                    fila[9] = df.format(producto.getStock());
//                } else {
//                    fila[9] = df.format(0);
//                }
//                if (producto.getInactivo()) {
//                    fila[8] = "Inactivo";
//                } else {
//                    fila[8] = "Activo";
//                }
//                tbl.addRow(fila); // Agrego la fila a la tabla
//            }
//        }
//        tablaProductos.setModel(tbl); // Pongo la tabla visible.
    }

    private void llenarTablaFinal() {
        tbl = (DefaultTableModel) tablaProductos.getModel();
        if (listadoProducto != null && !listadoProducto.isEmpty()) {
            for (Producto producto : listadoProducto) { // Recorro la lista de productos y lleno la tabla.
                Object[] fila = new Object[6];
                fila[0] = producto.getDetalle();
                fila[1] = dfp.format(producto.getPrecio());
                fila[2] = dfp.format(producto.getImpuesto());
                Double precioFinal;
                Float porIva = producto.getAlicuotaIva().getAlicuota();
                precioFinal = producto.getPrecio() * (1 + porIva / 100);
                precioFinal += producto.getImpuesto();
                fila[3] = dfp.format(precioFinal);
                if (producto.getStock() != null) {
                    fila[4] = df.format(producto.getStock());
                } else {
                    fila[4] = df.format(0);
                }
                tbl.addRow(fila);
            }
        }
        tablaProductos.setModel(tbl);
    }

    private void buscarPorRubro(Rubro rubro) {
        listadoProducto = null;
        try {
            listadoProducto = new ProductoService().getAllProductosByRubro(rubro);
        } catch (Exception ex) {
            Logger.getLogger(AbmProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volver() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        this.dispose();
    }

    private void actualizarPrecios() {
        JFileChooser archivoExcelLeido = new JFileChooser();
        archivoExcelLeido.showOpenDialog(this);
        File archivo = archivoExcelLeido.getSelectedFile();
        if (archivo != null) {
            if (LectorDeExcel.validarExtension(archivo)) {
                ImportarProductoParaActualizarPreciosFrame ippapf = new ImportarProductoParaActualizarPreciosFrame(archivo);
                ippapf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El formato elegido no está soportado.",
                        "Atencion",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void actualizarStocks() {
        JFileChooser archivoExcelLeido = new JFileChooser();
        archivoExcelLeido.showOpenDialog(this);
        File archivo = archivoExcelLeido.getSelectedFile();
        if (archivo != null) {
            if (LectorDeExcel.validarExtension(archivo)) {
                ImportarProductoParaActualizarStockFrame ippapf = new ImportarProductoParaActualizarStockFrame(archivo);
                ippapf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El formato elegido no está soportado.",
                        "Atencion",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void excel() {
        int row = combo.getSelectedIndex();
        Rubro rubro = rubros.get(row - 1);
        String nombreRubro = rubro.getNombre();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        String fech = sdf2.format(new Date());
        String rutaArchivo = Constantes.rutaExcel + "Productos_" + nombreRubro + "_" + fech + ".xls";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(InformeVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 665 - CREANDO ARCHIVO, VERIFIQUE SI ESTA ABIERTO");
            return;
        }
        WritableWorkbook libro = null;
        try {
            libro = Workbook.createWorkbook(archivo);
        } catch (IOException ex) {
            Logger.getLogger(InformeVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 674 - CREANDO ARCHIVO, VERIFIQUE SI ESTA ABIERTO");
            return;
        }
        WritableSheet hoja1 = libro.createSheet("Productos", 0);
        try {
            hoja1.addCell(new jxl.write.Label(0, 0, "PRODUCTO"));
            hoja1.addCell(new jxl.write.Label(1, 0, "PRECIO NETO"));
            hoja1.addCell(new jxl.write.Label(2, 0, "IMPUESTO"));
            hoja1.addCell(new jxl.write.Label(3, 0, "FINAL"));
            hoja1.addCell(new jxl.write.Label(4, 0, "RUBRO"));
            hoja1.addCell(new jxl.write.Label(5, 0, "SUB_RUBRO"));
            hoja1.addCell(new jxl.write.Label(6, 0, "PROD_PORC"));
            hoja1.addCell(new jxl.write.Label(7, 0, "CANT_FRACC"));
            hoja1.addCell(new jxl.write.Label(8, 0, "PORC_FRACC"));
            int y = 1;
            for (Producto pr : listadoProducto) {
                Double precioFinal = (pr.getPrecio() * 1.21) + pr.getImpuesto();
                ProductoTop pt1 = null;
                try {
                    pt1 = new ProductoTopService().getProductoTopByCodigo(pr.getCodigo());
//                System.out.println(pr.getPrecio());
//                System.out.println(pr.getImpuesto());
//                System.out.println(pr.getDetalle());
//                System.out.println(precioFinal);
                } catch (Exception ex) {
                    Logger.getLogger(AbmProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                precioFinal = UtilFactura.calcularRedondeo(precioFinal);
//                System.out.println(precioFinal);
//                System.exit(0);
                hoja1.addCell(new jxl.write.Label(0, y, pr.getDetalle()));
                hoja1.addCell(new jxl.write.Number(1, y, pr.getPrecio()));
                hoja1.addCell(new jxl.write.Number(2, y, pr.getImpuesto()));
                hoja1.addCell(new jxl.write.Number(3, y, precioFinal));
                hoja1.addCell(new jxl.write.Number(4, y, pr.getRubro().getCodigo()));
                hoja1.addCell(new jxl.write.Number(5, y, pr.getSubRubro().getCodigo()));
                hoja1.addCell(new jxl.write.Number(6, y, 0));
                hoja1.addCell(new jxl.write.Number(7, y, 0));
                hoja1.addCell(new jxl.write.Number(8, y, 0));
                if (pr.getPrecioPorPorcentaje() != null) {
                    if (pr.getPrecioPorPorcentaje()) {
                        hoja1.addCell(new jxl.write.Number(6, y, 1));
                        hoja1.addCell(new jxl.write.Number(8, y, pr.getPorcentajePrecio()));
                    }
                }
                if (pt1 != null) {
                    if (pt1.getFraccionMp() != null) {
                        hoja1.addCell(new jxl.write.Number(7, y, pt1.getFraccionMp()));
                    }
                }
                y += 1;
            }
        } catch (WriteException ex) {
            Logger.getLogger(InformeVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error configurando Excel");
            return;
        }
        try {
            libro.write();
            libro.close();
        } catch (IOException ex) {
            Logger.getLogger(InformeVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 702");
            return;
        } catch (WriteException ex) {
            Logger.getLogger(InformeVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 703");
            return;
        }
        JOptionPane.showMessageDialog(this, "Excel creado correctamente");
        /*
        
        
        
        
        
        
        
            
            hoja1.addCell(new jxl.write.Label(3, 1, "PTO.VENTA"));
            hoja1.addCell(new jxl.write.Label(4, 1, "NUMERO"));
            hoja1.addCell(new jxl.write.Label(5, 1, "CUIT"));
            hoja1.addCell(new jxl.write.Label(6, 1, "RAZON SOCIAL"));
            hoja1.addCell(new jxl.write.Label(7, 1, "CONDICION"));
//            hoja1.addCell(new jxl.write.Label(8, 1, "GRAVADO 0%"));
//            hoja1.addCell(new jxl.write.Label(9, 1, "GRAVADO 10.5%"));
            hoja1.addCell(new jxl.write.Label(8, 1, "GRAVADO 21%"));
//            hoja1.addCell(new jxl.write.Label(11, 1, "GRAVADO 27%"));
//            hoja1.addCell(new jxl.write.Label(12, 1, "IVA 0%"));
//            hoja1.addCell(new jxl.write.Label(13, 1, "IVA 10.5%"));
            hoja1.addCell(new jxl.write.Label(9, 1, "IVA 21%"));
//            hoja1.addCell(new jxl.write.Label(15, 1, "IVA 27%"));
            hoja1.addCell(new jxl.write.Label(10, 1, "IMPUESTO"));
            hoja1.addCell(new jxl.write.Label(11, 1, "TOTAL"));
            hoja1.addCell(new jxl.write.Label(12, 1, "VTO.CAE"));
            hoja1.addCell(new jxl.write.Label(13, 1, "CAE"));
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            int y = 2;
            Double tg0 = 0.0;
            Double tg10 = 0.0;
            Double tg21 = 0.0;
            Double tg27 = 0.0;
            Double ti = 0.0;
            Double tv0 = 0.0;
            Double tv10 = 0.0;
            Double tv21 = 0.0;
            Double tv27 = 0.0;
            Double tt = 0.0;
            //int rows = tabla.getRowCount();
            for (IvaVentas i : facturas) {
                // String td = i.getTipoDoc().toString();
                String td = "";
                Double t = 1.0;
                if (i.getTipoDoc().equals(1)) {
                    td = "1 FC";
                }
                if (i.getTipoDoc().equals(6)) {
                    td = "6 FC";
                }
                if (i.getTipoDoc().equals(3)) {
                    td = "3 NC";
                    t = -1.0;
                }
                if (i.getTipoDoc().equals(8)) {
                    td = "8 NC";
                    t = -1.0;
                }
                tg21 += i.getGravado() * t;
                if (i.getGravado0() != null) {
                    tg0 += i.getGravado0() * t;
                }
                if (i.getGravado10_5() != null) {
                    tg10 += i.getGravado10_5() * t;
                }
                if (i.getGravado27() != null) {
                    tg27 += i.getGravado27() * t;
                }
                ti += i.getImpuesto() * t;
                tv21 += i.getIva() * t;
                if (i.getIva0() != null) {
                    tv0 += i.getIva0() * t;
                }
                if (i.getIva10_5() != null) {
                    tv10 += i.getIva10_5() * t;
                }
                if (i.getIva27() != null) {
                    tv27 += i.getIva27() * t;
                }
                tt += i.getTotal() * t;
                hoja1.addCell(new jxl.write.Label(0, y, sdf.format(i.getFecha())));

                hoja1.addCell(new jxl.write.Label(1, y, td));
                hoja1.addCell(new jxl.write.Label(2, y, i.getLetra()));
                hoja1.addCell(new jxl.write.Label(3, y, df2.format(i.getNumeroSucursal())));
                hoja1.addCell(new jxl.write.Label(4, y, df1.format(i.getNumeroFactura())));
                hoja1.addCell(new jxl.write.Label(5, y, i.getCliente().getCuit()));
                hoja1.addCell(new jxl.write.Label(6, y, i.getCliente().getRazonSocial()));
                String condicion = "";
                switch (i.getCliente().getCategoriaDeIva()) {
                    case 1:
                        condicion = "INSCRIPTO";
                        break;
                    case 2:
                        condicion = "MONOTRIBUTO";
                        break;
                    case 3:
                        condicion = "EXENTO";
                        break;
                    case 4:
                        condicion = "CONS.FINAL";
                        break;
                }
                hoja1.addCell(new jxl.write.Label(7, y, condicion));
//                if (i.getGravado0() != null) {
//                    hoja1.addCell(new jxl.write.Number(8, y, i.getGravado0() * t));
//                } else {
//                    hoja1.addCell(new jxl.write.Number(8, y, 0.00));
//                }
//                if (i.getGravado10_5() != null) {
//                    hoja1.addCell(new jxl.write.Number(9, y, i.getGravado10_5() * t));
//                } else {
//                    hoja1.addCell(new jxl.write.Number(9, y, 0.00));
//                }
                if (i.getGravado() != null) {
                    hoja1.addCell(new jxl.write.Number(8, y, i.getGravado() * t));
                } else {
                    hoja1.addCell(new jxl.write.Number(8, y, 0.00));
                }
//                if (i.getGravado27() != null) {
//                    hoja1.addCell(new jxl.write.Number(11, y, i.getGravado27() * t));
//                } else {
//                    hoja1.addCell(new jxl.write.Number(11, y, 0.00));
//                }
//                if (i.getIva0() != null) {
//                    hoja1.addCell(new jxl.write.Number(12, y, i.getIva0() * t));
//                } else {
//                    hoja1.addCell(new jxl.write.Number(12, y, 0.00));
//                }
//                if (i.getIva10_5() != null) {
//                    hoja1.addCell(new jxl.write.Number(13, y, i.getIva10_5() * t));
//                } else {
//                    hoja1.addCell(new jxl.write.Number(13, y, 0.00));
//                }
                if (i.getIva() != null) {
                    hoja1.addCell(new jxl.write.Number(9, y, i.getIva() * t));
                } else {
                    hoja1.addCell(new jxl.write.Number(9, y, 0.0));
                }
//                if (i.getIva0() != null) {
//                    hoja1.addCell(new jxl.write.Number(15, y, i.getIva27() * t));
//                } else {
//                    hoja1.addCell(new jxl.write.Number(15, y, 0.00));
//                }
                hoja1.addCell(new jxl.write.Number(10, y, i.getImpuesto() * t));
                hoja1.addCell(new jxl.write.Number(11, y, i.getTotal() * t));
                hoja1.addCell(new jxl.write.Label(12, y, sdf.format(i.getFechaCae())));
                hoja1.addCell(new jxl.write.Label(13, y, i.getCae().toString()));
                y += 1;
            }
            hoja1.addCell(new jxl.write.Label(1, y + 1, "TOTALES"));
//            hoja1.addCell(new jxl.write.Number(8, y + 1, tg0));
//            hoja1.addCell(new jxl.write.Number(9, y + 1, tg10));
            hoja1.addCell(new jxl.write.Number(8, y + 1, tg21));
//            hoja1.addCell(new jxl.write.Number(11, y + 1, tg27));
//            hoja1.addCell(new jxl.write.Number(12, y + 1, tv0));
//            hoja1.addCell(new jxl.write.Number(13, y + 1, tv10));
            hoja1.addCell(new jxl.write.Number(9, y + 1, tv21));
//            hoja1.addCell(new jxl.write.Number(15, y + 1, tv27));
            hoja1.addCell(new jxl.write.Number(10, y + 1, ti));
            hoja1.addCell(new jxl.write.Number(11, y + 1, tt));
        
            
        JOptionPane.showMessageDialog(this, "LO ENCUENTRA EN d:/ventasJo/data/excel/IVA_VENTAS");
         */
    }

    private void habilitarByPorcentaje() {
        int row = tablaProductos.getSelectedRow();
        if (row >= 0) {
            Producto p = listadoProducto.get(row);
            p.setPrecioPorPorcentaje(true);
            p.setPorcentajePrecio(0F);
            try {
                new ProductoService().updateProducto(p);
                JOptionPane.showMessageDialog(this, "Recuerde asignarle porcentaje - X PORCENT HABILITADO");
            } catch (Exception ex) {
                Logger.getLogger(AbmProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
