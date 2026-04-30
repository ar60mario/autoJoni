package com.ventas.frame;

import com.ventas.entities.ProductoTop;
import com.ventas.entities.ProductoTop2;
import com.ventas.entities.Rubro;
import com.ventas.main.MainFrame;
import com.ventas.services.ProductoTopService;
import com.ventas.services.RubroService;
import com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductosValorizadosMpFrame extends javax.swing.JFrame {

    private List<Rubro> rubros;
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    List<ProductoTop2> prd_2;

    public ProductosValorizadosMpFrame() {
        initComponents();
        prepararFrame();
        llenar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cambiarBtn = new javax.swing.JButton();
        fraccionTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("STOCK VALORIZADO MERCADO PAGO");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "DETALLE", "P.UNI", "Fracc.MP", "P.FRACC", "RUBRO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
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
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel1.setText("Rubro:");

        cambiarBtn.setText("Cambiar");
        cambiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarBtnActionPerformed(evt);
            }
        });

        fraccionTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fraccionTxt.setText("FRCC");

        jLabel2.setText("Fracción:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fraccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cambiarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(cambiarBtn)
                    .addComponent(fraccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        llenarTabla();
    }//GEN-LAST:event_comboActionPerformed

    private void cambiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarBtnActionPerformed
        cambiar();
        fraccionTxt.setText("");
    }//GEN-LAST:event_cambiarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ProductosValorizadosMpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosValorizadosMpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosValorizadosMpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosValorizadosMpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductosValorizadosMpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiarBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField fraccionTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenar() {
        UtilFrame.limpiarTabla(tabla);

        rubros = null;

        try {
            rubros = new RubroService().getAllRubros();
        } catch (Exception ex) {
            Logger.getLogger(ProductosValorizadosMpFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        combo.removeAllItems();
        combo.addItem("");
        for (Rubro r : rubros) {
            combo.addItem(r.getNombre());
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private List<ProductoTop2> cargarProd2(List<ProductoTop> produ) {
        List<ProductoTop2> productos2 = new ArrayList<>();
        if (produ != null && !produ.isEmpty()) {
            for (ProductoTop pt : produ) {
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
            }
        }
        Collections.sort(productos2);
        return productos2;
    }

    private void llenarTabla() {
        int row = combo.getSelectedIndex();
        UtilFrame.limpiarTabla(tabla);
        if (row > 0) {
            Rubro rubro = rubros.get(row - 1);
            List<ProductoTop> productos;
//            Double totalTop = 0.0;
            try {
                productos = new ProductoTopService().getAllProductoTabacoTopActivos2(rubro);
            } catch (Exception ex) {
                Logger.getLogger(ProductosValorizadosMpFrame.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            prd_2 = cargarProd2(productos);
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (ProductoTop2 pt : prd_2) {
                Double neto = pt.getPrecio();
                Double iva = neto * .21;
                Float stock = pt.getStock();
                Float impuesto = pt.getImpuesto();
                Double precioUnitario = neto + iva + impuesto;
                Integer fraccion = pt.getFraccion();
                Double precioFraccion = precioUnitario * fraccion;
//                Double precioStock = precioUnitario * stock;
                Object o[] = new Object[6];
                o[0] = pt.getCodigo();
                o[1] = pt.getDetalle();
                o[2] = df.format(precioUnitario);
                o[3] = fraccion.toString();
                o[4] = df.format(precioFraccion);
//                o[4] = df.format(precioStock);
                o[5] = pt.getRubro().getNombre();
//                totalTop += precioStock;

                tbl.addRow(o);
            }
//            Object o[] = new Object[5];
////            o[0]=pt.getCodigo();
////            o[1]=pt.getDetalle();
////            o[2]=df.format(precioUnitario);
//            o[4] = df.format(totalTop);
////            totalTop+=precioFraccion;
//            tbl.addRow(o);
            tabla.setModel(tbl);
        }
    }

    private void prepararFrame() {
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        fraccionTxt.setText("");
    }

    private void cambiar() {
        int row = tabla.getSelectedRow();
        if (row >= 0) {
            Integer frcc = Integer.valueOf(fraccionTxt.getText().replace(",", "."));
            ProductoTop2 pt2 = prd_2.get(row);

            ProductoTop pt;
            try {
                pt = new ProductoTopService().getProductoTopByCodigo(pt2.getCodigo());
            } catch (Exception ex) {
                Logger.getLogger(ProductosValorizadosMpFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 322");
                return;
            }
            pt.setFraccionMp(frcc);
            try {
                new ProductoTopService().updateProductoTop(pt);
            } catch (Exception ex) {
                Logger.getLogger(ProductosValorizadosMpFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro. 328");
                return;
            }
            System.out.println(pt2.getDetalle());
            System.out.println(pt2.getCodigo());
            System.out.println(pt2.getFraccion());
            System.out.println(pt.getFraccionMp());
            llenarTabla();
        }
    }
}
