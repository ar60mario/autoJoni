/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.frame;

import com.ventas.entities.CalculoFactura;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.ConfiguracionTop;
import com.ventas.entities.FacturaCompra;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.main.MainFrame;
import com.ventas.services.CompraClienteMercadoPagoService;
import com.ventas.services.ConfiguracionTopService;
import com.ventas.services.FacturaCompraService;
import com.ventas.util.UtilFactura;
import com.ventas.util.UtilFrame;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author argia
 */
public class FacturasMercadoPagoFrame extends javax.swing.JFrame {

    private DecimalFormat df = new DecimalFormat("#0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<CompraClienteMercadoPago> compras = null;
    private CompraClienteMercadoPago compra;
    private List<FacturaCompra> facturas = null;
    private FacturaCompra factura;
    private Integer contadorFacturas = 0;
    private Integer contadorCompras = 0;

    /**
     * Creates new form FacturasMercadoPagoFrame
     */
    public FacturasMercadoPagoFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ultimaFechaTxt = new javax.swing.JTextField();
        fechaTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        procesarBtn = new javax.swing.JButton();
        presentarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        maximoFacturarTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FACTURACION MERCADO PAGO");

        jLabel1.setText("FECHA FACTURAS:");

        jLabel2.setText("ULTIMA FECHA SISTEMA:");

        ultimaFechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ultimaFechaTxt.setText("ULT.FECHA");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUIT", "NOMBRE", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(70);
        }

        procesarBtn.setText("CALCULAR");
        procesarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarBtnActionPerformed(evt);
            }
        });
        procesarBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                procesarBtnKeyPressed(evt);
            }
        });

        presentarBtn.setText("PRESENTAR");
        presentarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("MAXIMO A FACTURAR:");

        maximoFacturarTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        maximoFacturarTxt.setText("MAX.FACTURAR");
        maximoFacturarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                maximoFacturarTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ultimaFechaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(fechaTxt))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maximoFacturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(procesarBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(presentarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ultimaFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procesarBtn)
                    .addComponent(jLabel3)
                    .addComponent(maximoFacturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presentarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                try {
                    Date fecha = sdf.parse(fe);
                    if (verificarFecha(fecha)) {
                        maximoFacturarTxt.requestFocus();
                    }
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "ERROR EN FECHA");
                    fechaTxt.requestFocus();
                    return;
                }

            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaTxtKeyPressed

    private void procesarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarBtnActionPerformed
        calcular();
    }//GEN-LAST:event_procesarBtnActionPerformed

    private void maximoFacturarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maximoFacturarTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!maximoFacturarTxt.getText().isEmpty()) {
                procesarBtn.requestFocus();
            }
        }
    }//GEN-LAST:event_maximoFacturarTxtKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void presentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentarBtnActionPerformed
        presentar();
        JOptionPane.showMessageDialog(this, "REALIZADO");
        volver();
    }//GEN-LAST:event_presentarBtnActionPerformed

    private void procesarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_procesarBtnKeyPressed
        if (evt.getKeyCode() == 10) {
            calcular();
        }
    }//GEN-LAST:event_procesarBtnKeyPressed

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
            java.util.logging.Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturasMercadoPagoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maximoFacturarTxt;
    private javax.swing.JButton presentarBtn;
    private javax.swing.JButton procesarBtn;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField ultimaFechaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        String ultimaFecha = UtilFrame.ultimaFecha();
        if (ultimaFecha != null) {
            ultimaFechaTxt.setText(ultimaFecha);
        } else {
            ultimaFechaTxt.setText("01-01-2020");
        }
        fechaTxt.setText("");
        maximoFacturarTxt.setText("");
        fechaTxt.requestFocus();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

//    private void procesar() {
//
//        UtilFrame.limpiarTabla(tabla);
//        if (!maximoFacturarTxt.getText().isEmpty()) {
//            Double maximoFacturar = Double.valueOf(maximoFacturarTxt.getText().replace(",", "."));
//            Double sumaDeFacturas = 0.0;
//            try {
//                compras = new CompraClienteMercadoPagoService().getComprasParaProcesar(maximoFacturar);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
//                return;
//            }
//
//            try {
//                facturas = new FacturaCompraService().getAllFacturas();
//            } catch (Exception ex) {
//                Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (compras != null && !compras.isEmpty()) {
//                if (facturas != null && !facturas.isEmpty()) {
//                    int i = 0;
//                    DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
//                    for (CompraClienteMercadoPago ccmp : compras) {
//                        System.out.println(ccmp.getImporte());
//                        System.out.println(ccmp.getId());
////                        System.out.println("p1");
//                        FacturaCompra fc = facturas.get(i);
//                        Double t1 = fc.getTotal() - fc.getTotalTemp();
//                        Double t2 = ccmp.getImporte();
//                        if (t2 <= t1) {
//                            CalculoFactura cf = UtilFactura.calcularTotales(fc, ccmp);
//                            if (cf != null) {
//                                Object o[] = new Object[9];
//                                o[0] = ccmp.getCuit();
//                                o[1] = ccmp.getNombre();
//                                o[2] = cf.getGravado();
//                                o[3] = cf.getImpuesto();
//                                o[4] = cf.getIva();
//                                o[5] = cf.getTotal();
//                                o[6] = cf.getTotalMp();
//                                o[7] = ccmp.getId();
//                                o[8] = fc.getId();
//                                sumaDeFacturas += cf.getTotalMp();
//                                String sumaDeFacturasString = df.format(sumaDeFacturas);
//                                sumaDeFacturas = Double.valueOf(sumaDeFacturasString.replace(",", "."));
////                                System.out.println(cf.getTotal());
////                                System.out.println(sumaDeFacturas);
////                                JOptionPane.showMessageDialog(this, "VER");
//                                tbl.addRow(o);
//                                ccmp.setProcesado(true);
//                                fc.setGravadoTemp(fc.getGravadoTemp() + cf.getGravado());
//                                fc.setImpuestoTemp(fc.getImpuestoTemp() + cf.getImpuesto());
//                                fc.setIvaTemp(fc.getIvaTemp() + cf.getIva());
//                                fc.setTotalTemp(fc.getTotalTemp() + cf.getTotal());
////                                FacturaCompraReferenciaMercadoPago fcrmp
////                                        = new FacturaCompraReferenciaMercadoPago();
////                                fcrcmp.setCompraClienteMercadoPago(ccmp);
////                                fcrcmp.setFacturaCompra(fc);
//                            }
//                        } else {
//                            // tomar total y el saldo de otra factura de compra
//                            i += 1;
//                        }
////                        Double sumaFacturas = sumaDeFacturas.doubleValue();
//                        if (sumaDeFacturas > maximoFacturar) {
//                            break;
//                        }
////                        System.out.println(i);
////                        System.out.println(facturas.size());
////                        System.out.println("p2");
//                        if (i > facturas.size() - 1) {
//                            break;
//                        }
//                    }
//                    Object o[] = new Object[7];
//                    o[0] = "";
//                    o[1] = "";
//                    o[2] = "";
//                    o[3] = "";
//                    o[4] = "";
//                    o[5] = "";
//                    o[6] = sumaDeFacturas.doubleValue();
//                    tbl.addRow(o);
//                    tabla.setModel(tbl);
//                }
//            }
//        }
//    }
    private void calcular() {
        compras = null;
        UtilFrame.limpiarTabla(tabla);
        if (!maximoFacturarTxt.getText().isEmpty()) {
            Double maximoFacturar = Double.valueOf(maximoFacturarTxt.getText().replace(",", "."));
            try {
                compras = new CompraClienteMercadoPagoService().getComprasParaProcesar(maximoFacturar);
            } catch (Exception ex) {
                Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            llenarTabla();
        }
    }

    private void llenarTabla() {
        if (compras != null && !compras.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            Double sumaDeFacturas = 0.0;
            for (CompraClienteMercadoPago ccmp : compras) {
                Object o[] = new Object[3];
                o[0] = ccmp.getCuit();
                o[1] = ccmp.getNombre();
                o[2] = ccmp.getImporte();
                sumaDeFacturas += ccmp.getImporte();
                tbl.addRow(o);
            }
            Object o[] = new Object[3];
            o[0] = "";
            o[1] = "TOTAL A PROCESAR";
            o[2] = sumaDeFacturas;
            tbl.addRow(o);
            tabla.setModel(tbl);
        }
    }

    private void presentar() {
        try {
            facturas = new FacturaCompraService().getAllFacturas();
        } catch (Exception ex) {
            Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConfiguracionTop ct = null;
        try {
            ct = new ConfiguracionTopService().getConfigTopById(1);
        } catch (Exception ex) {
            Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Double importeMinimoMercadoPago = 0.0;
        if (ct != null) {
            importeMinimoMercadoPago = ct.getImporteMinimoMercadoPago();
        } else {
            return;
        }
        Date fecha = new Date();
        try {
            fecha = sdf.parse(fechaTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FacturasMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (compras != null && !compras.isEmpty()) {
            if (facturas != null && !facturas.isEmpty()) {
                Boolean salir1 = true;
//                Boolean salir2 = false;
                Integer cantidadFacturas = facturas.size();
                Integer cantidadCompras = compras.size();

                do {
                    salir1 = generarFactura(cantidadCompras,
                            cantidadFacturas, importeMinimoMercadoPago,
                            fecha);

                } while (salir1);
            } else {
                JOptionPane.showMessageDialog(this, "NO HAY FACTURAS COMPRA DISPONIBLES");
            }
        }

    }

    /*
    int rows = tabla.getRowCount();
//        if (rows < 1) {
//            JOptionPane.showMessageDialog(this, "DEBE TENER UNA FACTURA MINIMO PARA PRESENTAR");
//            return;
//        }
//        
     */
    private Boolean generarFactura(Integer cantidadCompras,
            Integer cantidadFacturas, Double importeMinimoMercadoPago,
            Date fecha) {

        compra = compras.get(contadorCompras);
        factura = facturas.get(contadorFacturas);
        Double totalCompraMP = compra.getImporte() - compra.getImporteUtilizado();
        Double totalFactura = factura.getTotalVenta() - factura.getTotalUtilizado();
        if (totalFactura < importeMinimoMercadoPago) {
            contadorFacturas += 1;
            if (contadorFacturas > cantidadFacturas - 1) {
                return false;
            }
            return true;
        }

        if (totalFactura > totalCompraMP) {
//            JOptionPane.showMessageDialog(this, "AQUI ES MAYOR");
//            System.out.println(totalFactura);
//            System.out.println(totalCompraMP);
//            JOptionPane.showMessageDialog(this, "VER");
            CalculoFactura cf = UtilFactura.calcularTotales(factura, compra);

            Integer ultimoNumero = UtilFrame.getUltimoNumeroFactura();
            // presentar afip
            FacturaIvaIntercambio fii = new FacturaIvaIntercambio();
            FacturaCompraReferenciaMercadoPago fcrmp = new FacturaCompraReferenciaMercadoPago();

            fii.setEstado("A");
            fii.setCae(1234567890123456789L);
            fii.setFechaVencimientoCae(new Date());
            fii.setFecha(fecha);
            fii.setLetra("B");
            fii.setNumero(ultimoNumero + 1);
            fii.setSucursal(10);

            compra.setProcesado(true);
            compra.setImporteUtilizado(compra.getImporte());

            factura.setGravadoUtilizado(factura.getGravadoUtilizado() + cf.getGravado());
            factura.setIvaUtilizado(factura.getIvaUtilizado() + cf.getIva());
            factura.setImpuestoUtilizado(factura.getImpuestoUtilizado() + cf.getImpuesto());
            factura.setTotalUtilizado(factura.getTotalUtilizado() + cf.getTotal());

            fcrmp.setCompraClienteMercadoPago(compra);
            fcrmp.setFacturaCompra(factura);

            if (fii.getEstado().equals("A")) {
                UtilFactura.grabarComprobanteCompleto(cf,
                        compra, factura, fii, fcrmp);
            }
            contadorCompras += 1;
            if (contadorCompras > cantidadCompras - 1) {
                return false;
            }

        } else {
            if (totalFactura < totalCompraMP) {
//                JOptionPane.showMessageDialog(this, "AQUI YA ES MENOR");
//                System.out.println(totalFactura);
//                System.out.println(totalCompraMP);
//                JOptionPane.showMessageDialog(this, "VER");

                CalculoFactura cf = UtilFactura.calcularTotales2(factura, compra);

                Integer ultimoNumero = UtilFrame.getUltimoNumeroFactura();
                // presentar afip
                FacturaIvaIntercambio fii = new FacturaIvaIntercambio();
                FacturaCompraReferenciaMercadoPago fcrmp = new FacturaCompraReferenciaMercadoPago();

                fii.setEstado("A");
                fii.setCae(1234567890123456789L);
                fii.setFechaVencimientoCae(new Date());
                fii.setFecha(fecha);
                fii.setLetra("B");
                fii.setNumero(ultimoNumero + 1);
                fii.setSucursal(10);

                compra.setProcesado(false);
                compra.setImporteUtilizado(compra.getImporteUtilizado() + cf.getTotal());

                factura.setGravadoUtilizado(factura.getGravadoVenta());
                factura.setIvaUtilizado(factura.getIvaVenta());
                factura.setImpuestoUtilizado(factura.getImpuestoVenta());
                factura.setTotalUtilizado(factura.getTotalVenta());
                factura.setProcesado(true);

                fcrmp.setFacturaCompra(factura);
                fcrmp.setCompraClienteMercadoPago(compra);

                if (fii.getEstado().equals("A")) {
                    UtilFactura.grabarComprobanteCompleto(cf, compra, factura, fii, fcrmp);
                }
                contadorFacturas += 1;
                if (contadorFacturas > cantidadFacturas - 1) {
                    return false;
                }

            } else {
//                JOptionPane.showMessageDialog(this, "AQUI ES IGUAL");
//                System.out.println(totalFactura);
//                System.out.println(totalCompraMP);
//                JOptionPane.showMessageDialog(this, "VER");

                CalculoFactura cf = UtilFactura.calcularTotales3(factura, compra);

                Integer ultimoNumero = UtilFrame.getUltimoNumeroFactura();
                // presentar afip
                FacturaIvaIntercambio fii = new FacturaIvaIntercambio();
                FacturaCompraReferenciaMercadoPago fcrmp = new FacturaCompraReferenciaMercadoPago();

                fii.setEstado("A");
                fii.setCae(1234567890123456789L);
                fii.setFechaVencimientoCae(new Date());
                fii.setFecha(fecha);
                fii.setLetra("B");
                fii.setNumero(ultimoNumero + 1);
                fii.setSucursal(10);

                compra.setProcesado(true);
                compra.setImporteUtilizado(compra.getImporte());

                factura.setGravadoUtilizado(factura.getGravadoVenta());
                factura.setIvaUtilizado(factura.getIvaVenta());
                factura.setImpuestoUtilizado(factura.getImpuestoVenta());
                factura.setTotalUtilizado(factura.getTotalVenta());
                factura.setProcesado(true);
//
                fcrmp.setCompraClienteMercadoPago(compra);
                fcrmp.setFacturaCompra(factura);

                if (fii.getEstado().equals("A")) {
                    UtilFactura.grabarComprobanteCompleto(cf, compra, factura, fii, fcrmp);
                }

                contadorFacturas += 1;
                if (contadorFacturas > cantidadFacturas - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private Boolean verificarFecha(Date fecha) {
        Date hoy = new Date();
        if (fecha.after(hoy)) {
            JOptionPane.showMessageDialog(this, "NO PUEDE FACTURAR CON FECHA POSTERIOR A HOY");
            fechaTxt.requestFocus();
            return false;
        }
        try {
            Date ultimaFecha = sdf.parse(ultimaFechaTxt.getText());
            if (fecha.before(ultimaFecha)) {
                JOptionPane.showMessageDialog(this, "NO PUEDE FACTURAR CON FECHA ANTERIOR A ULTIMA");
                fechaTxt.requestFocus();
                return false;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
            fechaTxt.requestFocus();
            return false;
        }
        return true;
    }
}
