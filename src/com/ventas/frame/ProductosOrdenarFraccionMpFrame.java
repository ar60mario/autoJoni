package com.ventas.frame;

import com.ventas.entities.ProductoTop;
import com.ventas.entities.ProductoTop2;
import com.ventas.entities.Rubro;
import com.ventas.estructuras.Constante;
import com.ventas.main.MainFrame;
import com.ventas.services.ProductoTopService;
import com.ventas.services.RubroService;
import com.ventas.util.UtilFactura;
import com.ventas.util.UtilFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ProductosOrdenarFraccionMpFrame extends javax.swing.JFrame {

    private JPanel contentPanel;
    private List<ProductoTop> productosTop;
    private List<Rubro> rubros;
    private DecimalFormat df = new DecimalFormat("$ #,##0.00");
    private List<ProductoTop2> productosTop2;

    public ProductosOrdenarFraccionMpFrame() {
        initComponents();
        limpiarCampos();
        cargarRubros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        aplicarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nuevaFraccionTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRODUCTOS FRACCION MP");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Producto", "Precio", "Fraccion MP", "Total Fraccion", "Neto", "Impuesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Rubro:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        aplicarBtn.setText("Aplicar");
        aplicarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Nueva Fracción:");

        nuevaFraccionTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nuevaFraccionTxt.setText("NF");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nuevaFraccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aplicarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(aplicarBtn)
                    .addComponent(jLabel2)
                    .addComponent(nuevaFraccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            cargarProductosTop(row);
        }
    }//GEN-LAST:event_comboActionPerformed

    private void aplicarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarBtnActionPerformed
        aplicarNuevaFraccion();
    }//GEN-LAST:event_aplicarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ProductosOrdenarFraccionMpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosOrdenarFraccionMpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosOrdenarFraccionMpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosOrdenarFraccionMpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductosOrdenarFraccionMpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicarBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nuevaFraccionTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constante.getR(), Constante.getG(), Constante.getB()));
        JFrame jFrame = ProductosOrdenarFraccionMpFrame.this;
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        String str0 = "ORDENAR PRODUCTOS MERCADO PAGO - FACTURACIÓN AUTOMÁTICA";
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
        UtilFrame.limpiarTabla(tabla);
        nuevaFraccionTxt.setText("");
    }

    private void cargarProductosTop(int row) {
        Rubro rubro = rubros.get(row - 1);
        productosTop = null;
        try {
            productosTop = new ProductoTopService().getAllProductoTabacoTopActivos2(rubro);
        } catch (Exception ex) {
            Logger.getLogger(ProductosOrdenarFraccionMpFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(productosTop);
        llenarTabla();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void cargarRubros() {
        rubros = null;
        try {
            rubros = new RubroService().getAllRubros();
        } catch (Exception ex) {
            Logger.getLogger(ProductosOrdenarFraccionMpFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarCombo();
    }

    private void llenarCombo() {
        combo.removeAllItems();
        combo.addItem("");
        if (rubros != null && !rubros.isEmpty()) {
            for (Rubro r : rubros) {
                combo.addItem(r.getNombre());
            }
        }
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        if (productosTop != null && !productosTop.isEmpty()) {
            productosTop2 = cargarProd2(productosTop);
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (ProductoTop2 pt : productosTop2) {
                Double precio = pt.getPrecio();
                precio = precio * 1.21;
//                precio = UtilFactura.calcularRedondeo(precio);
                precio += pt.getImpuesto();
                precio = UtilFactura.calcularRedondeo(precio);
                Double totalFr = precio * pt.getFraccion();
                Object o[] = new Object[6];
                o[0] = pt.getDetalle();
                o[1] = precio;
                o[2] = pt.getFraccion();
                o[3] = df.format(totalFr);
                o[4] = pt.getPrecio();
                o[5] = pt.getImpuesto();
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        } else {
            JOptionPane.showMessageDialog(this, "VACIA");
        }
    }

    private List<ProductoTop2> cargarProd2(List<ProductoTop> produ) {

        List<ProductoTop2> productos2 = new ArrayList<>();
        if (produ != null && !produ.isEmpty()) {
            for (ProductoTop pt : produ) {
//                System.out.println(pt.getStock());
//                System.exit(0);
               // if (pt.getStock() > 0) {
                    Double total = ((pt.getPrecio() * 1.21) + pt.getImpuesto()) * pt.getFraccionMp();
                    if (total > 0.00) {
                        ProductoTop2 pt2 = new ProductoTop2();
                        pt2.setActivo(true);
                        pt2.setCantidad(pt.getCantidadMaximaVenta());
                        pt2.setCodigo(pt.getCodigo());
                        pt2.setDetalle(pt.getDetalle());
                        pt2.setFraccion(pt.getFraccionMp());
                        pt2.setImpuesto(pt.getImpuesto());
                        pt2.setOrden(0);
                        pt2.setPrecio(pt.getPrecio());
                        pt2.setRubro(pt.getRubro());
                        pt2.setStock(pt.getStock());
                        pt2.setSubRubro(pt.getSubRubro());
                        pt2.setTotal(total);
                        pt2.setUsado(false);
                        productos2.add(pt2);
                    }
               // }
            }
            Collections.sort(productos2);
        }

        return productos2;
    }

    private void aplicarNuevaFraccion() {
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UNO");
            return;
        }
        if (!nuevaFraccionTxt.getText().isEmpty()) {
            Integer nuevaFraccion = Integer.valueOf(nuevaFraccionTxt.getText());
            ProductoTop2 pt2 = productosTop2.get(row);
            String detalle = pt2.getDetalle();
            ProductoTop pt = null;
            try {
                pt = new ProductoTopService().getProductoTopByDetalle(detalle);
            } catch (Exception ex) {
                Logger.getLogger(ProductosOrdenarFraccionMpFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 357");
                return;
            }
            pt.setFraccionMp(nuevaFraccion);
            try {
                new ProductoTopService().updateProductoTop(pt);
            } catch (Exception ex) {
                Logger.getLogger(ProductosOrdenarFraccionMpFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 365");
                return;
            }
            row = combo.getSelectedIndex();
            cargarProductosTop(row);
        }
    }
}
