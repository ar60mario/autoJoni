package com.ventas.frame;

import com.ventas.entities.Configuracion;
import com.ventas.entities.Producto;
import com.ventas.entities.ProductoTop;
import com.ventas.entities.Rubro;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.ProductoService;
import com.ventas.services.ProductoTopService;
import com.ventas.services.RubroService;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModificarProductoTopFrame extends javax.swing.JFrame {

    private final ProductoTop producto;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private List<Rubro> rubros;

    /**
     * @param p
     */
    public ModificarProductoTopFrame(ProductoTop p) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        this.producto = p;
        llenarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        guardarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        activoChk = new javax.swing.JCheckBox();
        codigoTxt = new javax.swing.JTextField();
        detalleTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cantidadMaximaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        precioTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cantidadMinimaTxt = new javax.swing.JTextField();
        ventaSinStockChk = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        porcentualMaximaVentaTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fraccionTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        netoTxt = new javax.swing.JTextField();
        impuestoTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fraccionMpTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MODIFICAR PRODUCTOS UTILIZADOS");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("Descripción:");

        activoChk.setText("Activo");

        codigoTxt.setText("CODIGO");

        detalleTxt.setText("DETALLE");

        jLabel3.setText("Cantidad Máxima Venta:");

        cantidadMaximaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadMaximaTxt.setText("CAN");

        jLabel4.setText("Final c/Iva:");

        precioTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioTxt.setText("PRECIO");

        jLabel6.setText("Cantidad Mínma Venta:");

        cantidadMinimaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadMinimaTxt.setText("CAN");

        ventaSinStockChk.setText("Venta sin Stock");

        jLabel7.setText("Porcentual Cantidad Máxima Venta Automática:");

        porcentualMaximaVentaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        porcentualMaximaVentaTxt.setText("POR");

        jLabel5.setText("Fracción Mínima de Venta:");

        fraccionTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fraccionTxt.setText("FRACC");

        jLabel8.setText("Neto:");

        jLabel9.setText("Impuesto:");

        netoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netoTxt.setText("NETO");

        impuestoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        impuestoTxt.setText("IMP.INT");

        jLabel10.setText("Fracción Mercado Pago:");

        fraccionMpTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fraccionMpTxt.setText("FRACC2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detalleTxt)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(activoChk)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(26, 26, 26))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(32, 32, 32)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cantidadMaximaTxt)
                                            .addComponent(cantidadMinimaTxt)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fraccionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                            .addComponent(fraccionMpTxt))))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(porcentualMaximaVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ventaSinStockChk)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(precioTxt)
                                .addComponent(netoTxt)
                                .addComponent(impuestoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activoChk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(detalleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cantidadMinimaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(netoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidadMaximaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(impuestoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fraccionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fraccionMpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ventaSinStockChk)
                    .addComponent(jLabel7)
                    .addComponent(porcentualMaximaVentaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(guardarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        guardar();
        volver();
    }//GEN-LAST:event_guardarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarProductoTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarProductoTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarProductoTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarProductoTopFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarProductoTopFrame(null).setVisible(true);
            }
        });
    }

    private void llenarCampos() {
//        rubros = null;
//        try {
//            rubros = new RubroService().getAllRubros();
//        } catch (Exception ex) {
//            Logger.getLogger(ModificarProductoTopFrame.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "ERROR EN RUBROS - NRO.231");
//            return;
//        }

        int cod = producto.getCodigo();
        codigoTxt.setText(String.valueOf(cod));
        Producto pr = null;
        Configuracion co = null;
        try {
            pr = new ProductoService().getProductoByCodigo(cod);
            co = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(ModificarProductoTopFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Float iva = 0.0F;
        if (co != null) {
            iva = co.getIva() / 100;
        }
        if (pr != null) {
            Long ru = pr.getRubro().getId();
//            System.out.println(ru.getNombre());
//            System.exit(0);
//            int p = 1;
//            int y = 0;
//            if (rubros != null && !rubros.isEmpty()) {
//                for (Rubro r : rubros) {
//                    if (r.getId().equals(ru)) {
//                        y = p;
//                    }
//                    p += 1;
//                }
//            }

            detalleTxt.setText(pr.getDetalle());
            Double precio = pr.getPrecio() + pr.getImpuesto() + (pr.getPrecio() * iva);
            Double neto = pr.getPrecio();
            Float impuesto = pr.getImpuesto();
            precioTxt.setText(df.format(precio));
            impuestoTxt.setText(df.format(impuesto));
            netoTxt.setText(df.format(neto));
            Integer fraccion = producto.getFraccion();
            fraccionTxt.setText(fraccion.toString());
            if (producto.getFraccionMp() != null) {
                fraccionMpTxt.setText(producto.getFraccionMp().toString());
            } else {
                fraccionMpTxt.setText("0");
            }
            detalleTxt.setEditable(false);
            precioTxt.setEditable(false);
            if (producto.getActivo()) {
                activoChk.setSelected(true);
            } else {
                activoChk.setSelected(false);
            }
            if (producto.getCantidadMaximaVenta() != null) {
                cantidadMaximaTxt.setText(producto.getCantidadMaximaVenta().toString());
            } else {
                cantidadMaximaTxt.setText("");
            }
            if (producto.getCantidadMinimaVenta() != null) {
                cantidadMinimaTxt.setText(producto.getCantidadMinimaVenta().toString());
            } else {
                cantidadMinimaTxt.setText("");
            }
            if (producto.getPorcentualMaximoVentaAutomatica() != null) {
                porcentualMaximaVentaTxt.setText(producto.getPorcentualMaximoVentaAutomatica().toString());
            } else {
                porcentualMaximaVentaTxt.setText("");
            }
            if(producto.getVentaSinStock()){
                ventaSinStockChk.setSelected(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activoChk;
    private javax.swing.JTextField cantidadMaximaTxt;
    private javax.swing.JTextField cantidadMinimaTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JTextField detalleTxt;
    private javax.swing.JTextField fraccionMpTxt;
    private javax.swing.JTextField fraccionTxt;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JTextField impuestoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField netoTxt;
    private javax.swing.JTextField porcentualMaximaVentaTxt;
    private javax.swing.JTextField precioTxt;
    private javax.swing.JCheckBox ventaSinStockChk;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        AbmProductosTopFrame aptf = new AbmProductosTopFrame();
        aptf.setVisible(true);
        this.dispose();
    }

    private void guardar() {

        if (activoChk.isSelected()) {
            producto.setActivo(true);
        } else {
            producto.setActivo(false);
            producto.setOrden(-1);
        }
        Integer c = 0;
        if (!cantidadMaximaTxt.getText().isEmpty()) {
            c = Integer.valueOf(cantidadMaximaTxt.getText());
        }
        producto.setCantidadMaximaVenta(c);
        if (!cantidadMinimaTxt.getText().isEmpty()) {
            c = Integer.valueOf(cantidadMinimaTxt.getText());
        }
        producto.setCantidadMinimaVenta(c);
        if (ventaSinStockChk.isSelected()) {
            producto.setVentaSinStock(true);
        } else {
            producto.setVentaSinStock(false);
        }
        Float porce = Float.valueOf(porcentualMaximaVentaTxt.getText().replace(",", "."));
        producto.setPorcentualMaximoVentaAutomatica(porce);
        Integer fraccion = Integer.valueOf(fraccionTxt.getText().replace(",", "."));
        Integer fraccionMp = Integer.valueOf(fraccionMpTxt.getText().replace(",", "."));
        producto.setFraccion(fraccion);
        producto.setFraccionMp(fraccionMp);
        try {
            new ProductoTopService().updateProductoTop(producto);
            JOptionPane.showMessageDialog(this, "Guardado correctamente");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se actualizo Producto");
        }

    }
}
