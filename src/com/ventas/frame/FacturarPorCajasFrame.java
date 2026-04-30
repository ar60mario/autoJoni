package com.ventas.frame;

import com.ventas.entities.Cliente;
import com.ventas.entities.Configuracion;
import com.ventas.entities.FcTemp;
import com.ventas.entities.IvaVentasPorCaja;
import com.ventas.entities.Producto;
import com.ventas.entities.ProductoTop;
import com.ventas.entities.RenglonFacturaPorCaja;
import com.ventas.entities.RenglonFcTemp;
import com.ventas.entities.Rubro;
import com.ventas.estructuras.Constante;
import com.ventas.main.MainFrame;
import com.ventas.services.ClienteService;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.FcTempService;
import com.ventas.services.IvaVentasPorCajaService;
import com.ventas.services.IvaVentasService;
import com.ventas.services.ProductoService;
import com.ventas.services.ProductoTopService;
import com.ventas.services.RubroService;
import com.ventas.util.Constantes;
import com.ventas.util.UtilArca;
import com.ventas.util.UtilFactura;
import com.ventas.util.UtilFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FacturarPorCajasFrame extends javax.swing.JFrame {

    private JPanel contentPanel;
    private List<Rubro> rubros;
    private Integer maximoOrdenProducto;
    private Float porcentualIva;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final DecimalFormat df = new DecimalFormat("#,##0.00");

    public FacturarPorCajasFrame() {
        initComponents();
        limpiarCampos();
        cargarFrame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        volverBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ultimaFechaTxt = new javax.swing.JTextField();
        calcularBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ivaFacturadoTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        presentarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha Facturas:");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        jLabel2.setText("Tabacalera:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboKeyPressed(evt);
            }
        });

        jLabel3.setText("Última Fecha Sistema:");

        ultimaFechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ultimaFechaTxt.setText("ULT.FECHA");

        calcularBtn.setText("Calcular Facturas");
        calcularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Iva A Facturar:");

        ivaFacturadoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ivaFacturadoTxt.setText("IVA A FACTURAR");
        ivaFacturadoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ivaFacturadoTxtKeyPressed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Gravado", "Impuesto", "Iva", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(25);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        presentarBtn.setText("Presentar");
        presentarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(presentarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ultimaFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 155, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ivaFacturadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(calcularBtn)))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ultimaFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ivaFacturadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcularBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(presentarBtn))
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
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularBtnActionPerformed
        UtilFrame.limpiarTabla(tabla);
        int row = combo.getSelectedIndex();
        if (row > 0) {
            if (!ivaFacturadoTxt.getText().isEmpty()) {
                int a = JOptionPane.showConfirmDialog(this, "VERIFICÓ LA FECHA DE FACTURAS???", "Atenci n", JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    calcular();
                }
            }
        }
    }//GEN-LAST:event_calcularBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void presentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentarBtnActionPerformed
        presentar();
    }//GEN-LAST:event_presentarBtnActionPerformed

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            combo.addFocusListener(null);
            combo.showPopup();
            combo.requestFocus();
        }
    }//GEN-LAST:event_fechaTxtKeyPressed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if(evt.getModifiers()==16){
            int row = combo.getSelectedIndex();
            if(row > 0){
                ivaFacturadoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        if(evt.getKeyCode()==10){
            int row = combo.getSelectedIndex();
            if(row > 0){
                ivaFacturadoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void ivaFacturadoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaFacturadoTxtKeyPressed
        if(evt.getKeyCode()==10){
            if(!ivaFacturadoTxt.getText().isEmpty()){
                calcularBtn.requestFocus();
            }
        }
    }//GEN-LAST:event_ivaFacturadoTxtKeyPressed

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
            java.util.logging.Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturarPorCajasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField ivaFacturadoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton presentarBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField ultimaFechaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void calcular() {
        Double miniIva = Double.valueOf(ivaFacturadoTxt.getText().replace(",", "."));
        Double acumuladoIva = 0.0;
        Float cantidad;
        Integer cant;
        Float nroItemF;
        Integer nroItem;
        int row = combo.getSelectedIndex();
        if (row > 0) {
            Boolean salir = false;
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            do {
                int n = 0;

                do {
                    Rubro rubro = rubros.get(row - 1);
                    List<ProductoTop> productosT;
                    List<ProductoTop> productosTordenado;
                    try {
                        productosT = new ProductoTopService().getAllProductoTabacoTopActivos2ConStock(rubro);
                    } catch (Exception ex) {
                        Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR");
                        return;
                    }
                    if (productosT.size() < 1) {
                        JOptionPane.showMessageDialog(this, "NO HAY STOCK");
                        return;
                    }
                    if (productosT != null && !productosT.isEmpty()) {
                        productosTordenado = cargarOrdenProductosTop(productosT);
                        int rows = productosTordenado.size() - 1;
                        Random rnd = new Random(); // es la cantidad de productos de la factura
                        Random rnd2 = new Random(); // es el número de orden del producto a facturar
                        Random rnd3 = new Random(); // es la cantidad de unidades de dicho producto
                        cantidad = rnd.nextFloat() * rows + 1F;
                        cant = cantidad.intValue();
                        Double totalFc = 0.0;
                        Double totalFcImpuesto = 0.0;
                        Double totalGravado;
                        Double totalIva;
                        Float totalImpuesto = 0F;
                        int i = 0;
                        int nroItm = 0;
                        FcTemp facturaCreada = new FcTemp();
                        List<RenglonFcTemp> renglones = new ArrayList<>();
                        do {
                            nroItemF = rnd2.nextFloat() * maximoOrdenProducto + .5F;
                            nroItem = nroItemF.intValue();
                            System.out.println(nroItem);
                            System.out.println(maximoOrdenProducto);
//                        System.exit(0);
                            ProductoTop pt = productosTordenado.get(nroItem);
                            if (!pt.getUsado()) {
                                Float unidad;
                                unidad = rnd3.nextFloat() * 2 + 1F;
                                Integer unid = unidad.intValue();
                                Float stock = pt.getStock();
                                if (stock > 0) {
                                    if (unid > 0) {
                                        if (unid > stock) {
                                            unid = stock.intValue();
                                        }
                                        RenglonFcTemp renglonFacturaCreada = new RenglonFcTemp();
                                        stock -= unid;
                                        Double gravado = pt.getPrecio();
                                        Double bruto = gravado * (1 + porcentualIva / 100);
                                        Double iva = gravado * porcentualIva / 100;
                                        Float impuesto = pt.getImpuesto();
                                        Double precioFinal = bruto + impuesto;
                                        precioFinal = UtilFactura.calcularRedondeo(precioFinal);
                                        Double totalLinea = precioFinal * unid;
                                        totalLinea = UtilFactura.calcularRedondeo(totalLinea);
                                        totalImpuesto = impuesto * unid;
                                        totalImpuesto = UtilFactura.calcularRedondeoF(totalImpuesto);
                                        Double totalBruto = totalLinea - totalImpuesto;
                                        totalBruto = UtilFactura.calcularRedondeo(totalBruto);
                                        totalGravado = totalBruto / (1 + porcentualIva / 100);
                                        totalGravado = UtilFactura.calcularRedondeo(totalGravado);
                                        totalIva = iva * unid;
                                        System.out.println(totalLinea);
                                        System.out.println("-----------");
                                        pt.setUsado(true);
                                        pt.setStock(stock);
                                        totalFc += totalLinea;
                                        totalFcImpuesto += totalImpuesto;
                                        totalFc = UtilFactura.calcularRedondeo(totalFc);
                                        i += 1;
                                        try {
                                            new ProductoTopService().updateProductoTop(pt);
                                        } catch (Exception ex) {
                                            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                                            JOptionPane.showMessageDialog(this, "ERROR 284");
                                            return;
                                        }
                                        Producto prod = null;
                                        try {
                                            prod = new ProductoService().getProductoByCodigo(pt.getCodigo());
                                        } catch (Exception ex) {
                                            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                                            JOptionPane.showMessageDialog(this, "ERROR 290");
                                            return;
                                        }
                                        nroItm += 1;
                                        Float stk = prod.getStock();
                                        stk = stock;
                                        prod.setStock(stk);
                                        try {
                                            new ProductoService().updateProducto(prod);
                                        } catch (Exception ex) {
                                            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                                            JOptionPane.showMessageDialog(this, "ERROR 299");
                                            return;
                                        }
                                        renglonFacturaCreada.setCantidad(unid.floatValue());
                                        renglonFacturaCreada.setCodigoProducto(pt.getCodigo());
                                        renglonFacturaCreada.setGravado(totalGravado);
                                        renglonFacturaCreada.setImpuesto(totalImpuesto.doubleValue());
                                        renglonFacturaCreada.setIva(totalIva);
                                        renglonFacturaCreada.setItemNro(nroItm);
                                        renglonFacturaCreada.setProducto(prod);
                                        renglonFacturaCreada.setTotal(totalLinea);
                                        renglones.add(renglonFacturaCreada);
                                    }
                                }
                            }
                        } while (i < cant);
                        Double totalFcBruto = totalFc - totalFcImpuesto;
                        totalFcBruto = UtilFactura.calcularRedondeo(totalFcBruto);
                        Double totalFcGravado = totalFcBruto / (1 + porcentualIva / 100);
                        totalFcGravado = UtilFactura.calcularRedondeo(totalFcGravado);
                        Double totalFcIva = totalFcBruto - totalFcGravado;
                        totalFcIva = UtilFactura.calcularRedondeo(totalFcIva);
                        facturaCreada.setAnulada(false);
                        facturaCreada.setCuitCliente("00-00000000-0");
                        facturaCreada.setGravado(totalFcGravado);
                        facturaCreada.setImpuesto(totalFcImpuesto);
                        facturaCreada.setIva(totalFcIva);
                        facturaCreada.setTotal(totalFc);
                        try {
                            new FcTempService().save(facturaCreada, renglones);
                        } catch (Exception ex) {
                            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "ERROR 297");
                            return;
                        }
                        n += 1;
                        System.out.println(totalFc);
                        String fechaFactura = fechaTxt.getText();
                        Date fechaF;
                        Cliente cliente = null;
                        try {
                            cliente = new ClienteService().getClienteByCodigo("1");
                        } catch (Exception ex) {
                            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "ERROR 349");
                            return;
                        }
                        try {
                            fechaF = sdf.parse(fechaFactura);
                        } catch (ParseException ex) {
                            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "ERROR 356");
                            return;
                        }

                        IvaVentasPorCaja iv = new IvaVentasPorCaja();
                        iv.setCliente(cliente);
                        iv.setFecha(fechaF);
                        iv.setGravado(totalFcGravado);
                        iv.setActiva(true);
                        iv.setImpuesto(totalFcImpuesto);
                        iv.setIva(totalFcIva);
                        iv.setLetra("B");
                        iv.setTotal(totalFc);
                        acumuladoIva += totalFcIva;
                        List<RenglonFacturaPorCaja> renglonesFc = new ArrayList<>();
                        for (RenglonFcTemp rft : renglones) {
                            RenglonFacturaPorCaja rf = new RenglonFacturaPorCaja();
                            rf.setCantidad(rft.getCantidad());
                            rf.setDescripcion(rft.getProducto().getDetalle());
                            rf.setGravado(rft.getGravado());
                            rf.setImpuesto(rft.getImpuesto());
                            rf.setItemNro(rft.getItemNro());
                            rf.setIva(rft.getIva());
                            rf.setProducto(rft.getProducto());
                            rf.setTotal(rft.getTotal());
                            renglonesFc.add(rf);
                        }
                        try {
                            new IvaVentasPorCajaService().saveIvaVentasCompleto(iv, renglonesFc);
                        } catch (Exception ex) {
                            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "ERROR FC");
                            return;
                        }
                        Object o[] = new Object[5];
                        o[0] = sdf.format(fechaF);
                        o[1] = df.format(totalFcGravado);
                        o[2] = df.format(totalFcImpuesto);
                        o[3] = df.format(totalFcIva);
                        o[4] = df.format(totalFc);
                        tbl.addRow(o);
                    }
                    int ord = 0;
                    for (ProductoTop pt : productosT) {
                        if (pt.getStock().intValue() > 0) {
                            pt.setUsado(false);
                            ord += 1;
                            pt.setOrden(ord);
                            try {
                                new ProductoTopService().updateProductoTop(pt);
                            } catch (Exception ex) {
                                Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(this, "ERROR 317");
                                return;
                            }
                            maximoOrdenProducto = ord;
                        }
                    }
                } while (n < 1);
                if (acumuladoIva > miniIva) {
                    salir = true;
                    System.out.println(acumuladoIva);
                }
            } while (!salir);
            Object o[] = new Object[5];
            o[3] = df.format(acumuladoIva);
            tbl.addRow(o);
            tabla.setModel(tbl);
        }

    }

    private void limpiarCampos() {
        UtilFrame.limpiarTabla(tabla);
        fechaTxt.setText(sdf.format(new Date()));
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constante.getR(), Constante.getG(), Constante.getB()));
        JFrame jFrame = FacturarPorCajasFrame.this;
        jFrame.setLocationRelativeTo(null);
        String str0 = "FACTURA POR CAJA 2DAS MARCAS"; // + " " + str1;
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setTitle("SISTEMA VENTAS");
        setContentPane(contentPanel);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volver();
            }
        });

    }

    private void cargarFrame() {
        ivaFacturadoTxt.setText("");
        rubros = null;
        combo.removeAllItems();
        combo.addItem("");
        int nuro = 2;
        try {
            rubros = new RubroService().getRubrosByNroMarca(nuro);
        } catch (Exception ex) {
            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR");
            return;
        }
        if (rubros != null && !rubros.isEmpty()) {
            for (Rubro r : rubros) {
                combo.addItem(r.getNombre());
            }
        }
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        porcentualIva = cfg.getIva();
        try {
            String ufe = new IvaVentasService().getUltimaFechaFactura(Constantes.cuitTitular);
            ultimaFechaTxt.setText(ufe);
        } catch (Exception ex) {
            Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 504");
        }
    }

    private List<ProductoTop> cargarOrdenProductosTop(List<ProductoTop> productosT) {
        int ord = 0;
        List<ProductoTop> listaProductos = new ArrayList<>();
        for (ProductoTop pt : productosT) {
            if (pt.getStock().intValue() > 0) {
                try {
                    pt.setOrden(ord);
                    pt.setUsado(false);
                    ProductoTop pt2 = new ProductoTopService().updateProductoTop(pt);
                    listaProductos.add(pt2);
                    ord += 1;
                } catch (Exception ex) {
                    Logger.getLogger(FacturarPorCajasFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR");
                    return null;
                }
            }
        }
        maximoOrdenProducto = ord - 1;
        return listaProductos;
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void presentar() {
        UtilArca.presentarFacturaPorCajaEnArcaPendientes();
        JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
        volver();
    }
}
