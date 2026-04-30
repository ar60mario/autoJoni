package com.ventas.frame;

import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.Configuracion;
import com.ventas.entities.ConfiguracionTop;
import com.ventas.entities.Domicilio;
import com.ventas.entities.Factura;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.Producto;
import com.ventas.entities.ProductoTop;
import com.ventas.entities.ProductoTop2;
import com.ventas.entities.RenglonFactura;
import com.ventas.entities.RenglonFc;
import com.ventas.entities.Rubro;
import com.ventas.entities.SubRubro;
import com.ventas.entities.TitularCuit;
import com.ventas.main.MainFrame;
import com.ventas.services.ClienteService;
import com.ventas.services.CompraClienteMercadoPagoService;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.ConfiguracionTopService;
import com.ventas.services.FacturaCompraReferenciaMercadoPagoService;
import com.ventas.services.FacturaService;
import com.ventas.services.FcService;
import com.ventas.services.IvaVentasService;
import com.ventas.services.ProductoService;
import com.ventas.services.ProductoTopService;
import com.ventas.services.RenglonFacturaService;
import com.ventas.services.RenglonFcService;
import com.ventas.services.RubroService;
import com.ventas.services.SubRubroService;
import com.ventas.util.Constantes;
import com.ventas.util.UtilFrame;
import com.ventas.util.UtilAfip;
import com.ventas.util.UtilFactura;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;

public class FacturarMercadoPago2Frame extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("#0.00");
    private final DecimalFormat df_csm = new DecimalFormat("$#,##0.00");
    private final DecimalFormat df_int = new DecimalFormat("#0");
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<CompraClienteMercadoPago> comprasMp = null;
    private List<Rubro> rubros;
    private final String origen;
    private Double minimoMp;
    private List<Factura> facturas;
    private List<ProductoTop> productos;
    private Date fechaFacturas;
    private ConfiguracionTop cf;
    private Float porcentualIva;
    private final TitularCuit titular;
    private int maxNro;
    private Rubro rubro;

    /**
     * @param origen
     * @param titular
     */
    public FacturarMercadoPago2Frame(String origen, TitularCuit titular) {
        initComponents();
        this.origen = origen;
        this.titular = titular;
        limpiarCampos();
    }

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
        jLabel4 = new javax.swing.JLabel();
        segDeTxt = new javax.swing.JTextField();
        segAlTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        barral = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        ultimoNumeroTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ultimoImporteTxt = new javax.swing.JTextField();
        sacarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                "NRO", "CUIT", "NOMBRE", "TOTAL", "Imp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
        }

        procesarBtn.setText("CALCULAR FC");
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

        jLabel4.setText("SEGUNDOS ENTRE FC:");

        segDeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        segDeTxt.setText("SEG");

        segAlTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        segAlTxt.setText("SEG");

        jLabel3.setText("TABACALERA:");

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

        jLabel5.setText("Ult.Fc:");

        ultimoNumeroTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ultimoNumeroTxt.setText("U.NUM.FC");

        jLabel6.setText("Ult.IMPORTE:");

        ultimoImporteTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ultimoImporteTxt.setText("U.IMPORTE");

        sacarBtn.setText("SACAR");
        sacarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sacarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ultimaFechaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(fechaTxt))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ultimoNumeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ultimoImporteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(procesarBtn)
                                .addGap(93, 93, 93))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(presentarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(sacarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(segDeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(segAlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ultimaFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procesarBtn)
                    .addComponent(jLabel5)
                    .addComponent(ultimoNumeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ultimoImporteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presentarBtn)
                    .addComponent(sacarBtn)
                    .addComponent(jLabel4)
                    .addComponent(segDeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(segAlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    fechaFacturas = sdf.parse(fe);
                    if (verificarFecha(fechaFacturas)) {
                        combo.addFocusListener(null);
                        combo.showPopup();
                        combo.requestFocus();
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
        procesar2();
    }//GEN-LAST:event_procesarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver(origen);
    }//GEN-LAST:event_volverBtnActionPerformed

    private void presentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentarBtnActionPerformed
        int row = combo.getSelectedIndex();
        if (row > 0) {
            presentar();
        }
    }//GEN-LAST:event_presentarBtnActionPerformed

    private void procesarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_procesarBtnKeyPressed
        if (evt.getKeyCode() == 10) {
            procesar2();
        }
    }//GEN-LAST:event_procesarBtnKeyPressed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if (evt.getModifiers() == 16) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                procesarBtn.requestFocus();
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        if (evt.getKeyCode() == 10) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                procesarBtn.requestFocus();
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void sacarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sacarBtnActionPerformed
        int cantidadSeleccionada = tabla.getSelectedRowCount();
        int a[] = tabla.getSelectedRows();
        if (cantidadSeleccionada < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNA FACTURA PARA SACER");
            return;
        }
        for (int n = cantidadSeleccionada - 1; n > -1; n--) {
            if (a[n] < facturas.size()) {
                facturas.remove(a[n]);
            }
        }
        llenarTabla2();
    }//GEN-LAST:event_sacarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturarMercadoPago2Frame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barral;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton presentarBtn;
    private javax.swing.JButton procesarBtn;
    private javax.swing.JButton sacarBtn;
    private javax.swing.JTextField segAlTxt;
    private javax.swing.JTextField segDeTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField ultimaFechaTxt;
    private javax.swing.JTextField ultimoImporteTxt;
    private javax.swing.JTextField ultimoNumeroTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        this.setTitle(this.getTitle() + "  -x-  " + titular.getRazonSocial());
        sacarBtn.setVisible(false);
        presentarBtn.setEnabled(false);

        String ultimaFecha = UtilFrame.ultimaFecha(titular.getCuit());
        if (ultimaFecha != null) {
            ultimaFechaTxt.setText(ultimaFecha);
        } else {
            ultimaFechaTxt.setText("01-01-2020");
        }
        fechaTxt.setText("");
        fechaTxt.requestFocus();
        segDeTxt.setText("1");
        segAlTxt.setText("1");
        segDeTxt.setVisible(false);
        segAlTxt.setVisible(false);
        jLabel4.setVisible(false);
        combo.removeAllItems();
        combo.addItem("");
        rubros = null;
        try {
            rubros = new RubroService().getAllRubros();
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Rubro r : rubros) {
            combo.addItem(r.getNombre());
        }
        Integer ult_num = 0;
        String ult_impFc;
        try {
            ult_num = new IvaVentasService().getUltimoNumeroFactura("20300377425");
            ult_impFc = new IvaVentasService().getUltimoImporteFactura("20300377425");
        } catch (Exception ex) {
            return;
        }
        ultimoNumeroTxt.setText(ult_num.toString());
        ultimoImporteTxt.setText(ult_impFc);
        if (origen.equals("V")) {
            llenarCampos();
        }
        cf = null;
        try {
            cf = new ConfiguracionTopService().getConfigTopById(1);
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        porcentualIva = cfg.getIva();
    }

    private void volver(String o) {
        if (o.equals("M")) {
            MainFrame mf = new MainFrame();
            mf.setVisible(true);
        } else {
            Integer row = tabla.getSelectedRow();
            Factura f = facturas.get(row);
            VerFacturaFrame mf = new VerFacturaFrame(f);
            mf.setVisible(true);
        }
        this.dispose();
    }

    private void calcular() {
        UtilFrame.limpiarTabla(tabla);
        calcularFacturas();
        llenarTabla();
        presentarBtn.setEnabled(true);
    }

    private void llenarTabla2() {
        UtilFrame.limpiarTabla(tabla);
        if (facturas != null && !facturas.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            Double sumaDeFacturas = 0.0;
            int row = 1;
            for (Factura fa : facturas) {
                Object o[] = new Object[4];
                o[0] = row;
                row += 1;
                o[1] = fa.getCliente().getCuit();
                o[2] = fa.getCliente().getRazonSocial();
                o[3] = df.format(fa.getTotal());
                sumaDeFacturas += fa.getTotal();
                tbl.addRow(o);
            }
            Object o[] = new Object[4];
            o[0] = "";
            o[2] = "TOTAL A PROCESAR";
            o[3] = df.format(sumaDeFacturas);
            tbl.addRow(o);
            tabla.setModel(tbl);
        }
    }

    private void llenarTabla() {

        facturas = null;
        try {
            facturas = new FcService().getAllFacturasActivas();
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarTabla2();
    }

    private void presentar() {
        if (fechaTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ERROR EN FECHA");
            return;
        }
        facturas = null;
        try {
            facturas = new FacturaService().getAllFacturasActivas();
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 589 - FACTURAS");
            return;
        }
        try {
            fechaFacturas = sdf.parse(fechaTxt.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN FECHA");
            return;
        }
        int a = JOptionPane.showConfirmDialog(this, "VERIFICO LA FECHA DE LAS FACTURAS???", "Atención",
                JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            int row = combo.getSelectedIndex();
            if (row < 1) {
                JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR RUBRO");
                return;
            }
            if (facturas != null && !facturas.isEmpty()) {
//                try {
//                    Integer ultimoNro = new IvaVentasService().getUltimoNumeroFactura();
//                } catch (Exception ex) {
//                    Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                for (Factura fa : facturas) {
                int tim1 = Integer.valueOf(segDeTxt.getText().trim());
                int tim2 = Integer.valueOf(segAlTxt.getText().trim());
                try {
                    FileWriter fichero = new FileWriter("D:/ventasJo/temp/titular.txt");
                    PrintWriter pw = new PrintWriter(fichero);
                    pw.println(titular.getCuit());
                    pw.println(titular.getTipoDoc());
                    pw.println(titular.getPuntoVenta());
                    pw.close();
                } catch (Exception e) {
//                    e.printStackTrace();
                }

                try {
                    FileWriter fichero = new FileWriter("D:/ventasJo/temp/temp.txt");
                    PrintWriter pw = new PrintWriter(fichero);
                    pw.println(sdf.format(fechaFacturas));
                    pw.println(tim1);
                    pw.println(tim2);

                    pw.close();
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                presentarBtn.setEnabled(false);
                sacarBtn.setEnabled(false);
                procesarBtn.setEnabled(false);
                combo.setEnabled(false);
                fechaTxt.setEditable(false);
//                System.exit(0);
                barral();
//                }
            } else {
                JOptionPane.showMessageDialog(this, "NO HAY FACTURAS CARGADAS DISPONIBLES PARA CALCULAR LOS IMPUESTOS");
            }
        }
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
            Date f5d = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(f5d);
            calendar.add(Calendar.DATE, -6);
            f5d = calendar.getTime();
            if (fecha.before(f5d)) {
                JOptionPane.showMessageDialog(this, "NO DEBE SUPERAR 5 DIAS ATRAS");
                return false;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
            fechaTxt.requestFocus();
            return false;
        }
        return true;
    }

    private void barral() {
        Avanzando_a avanzando = new Avanzando_a();
//        presentarBtn.setEnabled(false);
//        procesarBtn.setEnabled(false);
//        sacarBtn.setEnabled(false);
        avanzando.setBar(barral);
        Thread hilo = new Thread(avanzando);
        hilo.start();
    }

    private void copiarStock() {
        productos = null;
        try {
            productos = new ProductoTopService().getAllProductoTabacoTopActivos2(rubro);
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR PT Nro 686");
            System.exit(0);
        }
        if (productos != null && !productos.isEmpty()) {
            int orden = 0;
            for (ProductoTop p : productos) {
                Integer cod_pro = p.getCodigo();
                Producto pro;
                try {
                    pro = new ProductoService().getProductoByCodigo(cod_pro);
                } catch (Exception ex) {
                    continue;
                }
                Float cant_pro = pro.getStock();
                p.setStock(cant_pro);
                p.setDetalle(pro.getDetalle());
                p.setPrecio(pro.getPrecio());
                p.setImpuesto(pro.getImpuesto());
                p.setUsado(false);
                p.setOrden(orden);
                orden += 1;
                try {
                    new ProductoTopService().updateProductoTop(p);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            "ERROR ACTUALIZANDO PRODUCTO SELECCIONADO" + p.getDetalle());
                    return;
                }
            }
        }
    }

    private void calcularFacturas() {
        comprasMp = null;
        try {
            comprasMp = new CompraClienteMercadoPagoService().getAllFacturasPendientesDeProcesar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR LEYENDO COMPRAS DE MERCADO PAGO PENDIENTES");
            return;
        }
        if (comprasMp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "NO HAY COMPRAS DE MP REGISTRADAS");
            return;
        }
        Producto prod_logistica;
        try {
            prod_logistica = new ProductoService().getProductoLogistica();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR LEYENDO PRODUCTO LOGISTICA");
            return;
        }
        Boolean hayProductos = false;
        for (ProductoTop pr0 : productos) {
            if (pr0.getStock() > 0) {
                hayProductos = true;
                break;
            }
        }
        if (!hayProductos) {
            JOptionPane.showMessageDialog(this, "NO HAY STOCK DE PRODUCTOS");
            return;
        }
        for (CompraClienteMercadoPago ccmp : comprasMp) {
            // aqui se agrega la modificacion
            Double limite = ccmp.getImporte();
            productos = null;
            try {
                productos = new ProductoTopService().getAllProductoTopActivosConLimite(limite);
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<ProductoTop> productos2 = null;
            try {
                productos2 = new ProductoTopService().getAllProductoTopActivos();
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            // aquí termina
            Double acumuladoFactura = 0.0;
            Float porcentualIvaFc = 21F;
//            Float cant;
            Integer nro = 0;
            Cliente cliente;
            String cuit = ccmp.getCuit();
            try {
                cliente = new ClienteService().getClienteByCuit(cuit);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERROR EN CUIT CLIENTE");
                return;
            }
            Double totalFactura = ccmp.getImporte();
            Double saldoFactura;
            Producto pro;
            Factura factura = new Factura();
            List<RenglonFc> renglones = new ArrayList<>();
            Double totalGravado = 0.0;
            Double totalImpuesto = 0.0;
            Double totalIva = 0.0;
            Boolean salga = false;
            Boolean usados = true;
            do {
                // generar producto y cantidad
                ProductoTop pt = generarProducto();
                if (pt == null) {
                    JOptionPane.showMessageDialog(this, "SIN PRODUCTOS");
                    salga = true;
                }
                if (pt.getCantidadMinimaVenta() == null) {
                    JOptionPane.showMessageDialog(this,
                            "PRODUCTO SIN MINIMO ESTABLECIDO " + pt.getDetalle());
                    return;
                }
                if (pt.getCantidadMaximaVenta() == null) {
                    JOptionPane.showMessageDialog(this,
                            "PRODUCTO SIN MAXIMO ESTABLECIDO " + pt.getDetalle());
                    return;
                }
                Integer min = pt.getCantidadMinimaVenta();
                Integer max = pt.getCantidadMaximaVenta();
                Integer frac = pt.getFraccion();
                Float cant = generarCantidad(min, max, frac).floatValue();

                if (cant > pt.getStock()) {
                    cant = pt.getStock();
                }

                Integer codigo = pt.getCodigo();
                try {
                    pro = new ProductoService().getProductoByCodigo(codigo);
                } catch (Exception ex) {
                    continue;
                }
                nro += 1;
                Float porcentualIva = pro.getAlicuotaIva().getAlicuota();
                Double neto = pt.getPrecio() * cant;
                Double precio = neto * (1 + porcentualIva / 100);
                Float impuesto = pt.getImpuesto() * cant;
                Double totalLinea = precio + impuesto;
                acumuladoFactura += totalLinea;
                saldoFactura = totalFactura - acumuladoFactura;
                System.out.println(nro);
//                System.out.println(cant);
//                System.out.println(neto);
//                System.out.println(porcentualIva);
//                System.out.println(precio);
//                System.out.println(impuesto);
//                System.out.println(totalLinea);
//                System.out.println(acumuladoFactura);
//                System.out.println(saldoFactura);
//                System.out.println(totalFactura);
//                JOptionPane.showMessageDialog(this, "VER");
                if (saldoFactura < 0) {
                    acumuladoFactura -= totalLinea;
                    saldoFactura = totalFactura - acumuladoFactura;
                    totalLinea = saldoFactura;
                    totalGravado -= neto;
                    totalImpuesto -= impuesto;
                    System.out.println(saldoFactura);
                    System.out.println(minimoMp);
//                    JOptionPane.showMessageDialog(this, "VER");
                    if (saldoFactura < minimoMp) {
                        cant = 1F;
                        impuesto = 0F;
                        neto = totalLinea / (1 + porcentualIva / 100);
                        precio = totalLinea;
                        pro = prod_logistica;
                        totalFactura = ccmp.getImporte();
                        totalGravado += neto;
                        totalImpuesto += impuesto;
                        acumuladoFactura += totalLinea;
//                        saldoFactura = totalFactura - acumuladoFactura;

                        //         totalImpuesto += impuesto;
                        salga = true;
                    } else {
                        nro -= 1;
                        continue;
                    }
                }
                RenglonFc rfc = new RenglonFc();
                rfc.setAnulado(false);
                rfc.setCantidad(cant);
                rfc.setCostoG(0.0);
                rfc.setCostoI(0.0);
                rfc.setDescuento(0.0);
                rfc.setExento(0.0);
                rfc.setFabricacion(false);
                rfc.setFactura(factura);
                rfc.setGravado(neto);
                totalGravado += neto;
                totalImpuesto += impuesto;
                rfc.setGravado0(0.0);
                rfc.setGravado10_5(0.0);
                rfc.setGravado27(0.0);
                rfc.setImpuesto(impuesto.doubleValue());
                rfc.setItemNro(nro);
                Double iva = precio - neto;
                rfc.setIva(iva);
                totalIva += iva;
                rfc.setIva0(0.0);
                rfc.setIva10_5(0.0);
                rfc.setIva27(0.0);
                rfc.setNoGravado(0.0);
                rfc.setProducto(pro);
                rfc.setSugerido(0.0);
                rfc.setTotal(totalLinea);

                renglones.add(rfc);
//                System.out.println(nro);
//                System.out.println(cant);
//                System.out.println(neto);
//                System.out.println(porcentualIva);
//                System.out.println(precio);
//                System.out.println(impuesto);
//                System.out.println(totalLinea);
//                System.out.println(acumuladoFactura);
//                System.out.println(saldoFactura);
//                System.out.println(totalFactura);
//                JOptionPane.showMessageDialog(this, "VER");

                if (!pro.getEsLogistica()) {
                    pt.setStock(pt.getStock() - cant);
                    pt.setUsado(true);
                    try {
                        new ProductoTopService().updateProductoTop(pt);
                    } catch (Exception ex) {
                        Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERR 795");
                    }
                }
                usados = true;
                for (ProductoTop p1 : productos) {
                    if (!p1.getUsado()) {
                        usados = false;
                        break;
                    }
                }
                if (usados) {
                    salga = true;
                }
            } while (!salga);
            if (usados) {
                System.out.println("TODOS USADOS");
            }
            System.out.println("SALGO");
            totalImpuesto = 0.0;
            for (RenglonFc rf : renglones) {
                totalImpuesto += rf.getImpuesto();
            }
            totalFactura = ccmp.getImporte();
            String totalImpuestoStr = df.format(totalImpuesto);
            totalImpuesto = Double.valueOf(totalImpuestoStr.replace(",", "."));
            Double bruto = totalFactura - totalImpuesto;
            String brutoStr = df.format(bruto);
            bruto = Double.valueOf(brutoStr.replace(",", "."));
            totalGravado = bruto / (1 + porcentualIvaFc / 100);
            String totalGrvStr = df.format(totalGravado);
            totalGravado = Double.valueOf(totalGrvStr.replace(",", "."));
            totalIva = totalGravado * porcentualIvaFc / 100;
            String ivaStr = df.format(totalIva);
            totalIva = Double.valueOf(ivaStr.replace(",", "."));
            if (totalFactura > ccmp.getImporte() - 1) {
                factura.setAnulado(false);
                factura.setCliente(cliente);
                factura.setExento(0.0);
                factura.setFabricacion(false);
                factura.setFecha(fechaFacturas);
                factura.setGravado(totalGravado);
                factura.setGravado0(0.0);
                factura.setGravado10(0.0);
                factura.setGravado27(0.0);
                factura.setImpuesto(totalImpuesto);
                factura.setIva(totalIva);
                factura.setIva0(0.0);
                factura.setIva10(0.0);
                factura.setIva27(0.0);
                factura.setNoGravado(0.0);
                factura.setTotal(totalFactura);
                factura.setCompraClienteMercadoPago(ccmp);
//            facturas.add(factura);
                try {
                    new FcService().saveFactura(factura, renglones);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "ERROR GUARDANDO FACTURAS GENERADAS");
                    return;
                }
            } else {
                break;
            }
            for (ProductoTop pr_t : productos) {
                pr_t.setUsado(false);
                try {
                    new ProductoTopService().updateProductoTop(pr_t);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "ERROR 811");
                    return;
                }
            }
//            System.exit(0);
        }
    }

    private void cargarProductosTop() {
        productos = null;
        int row = combo.getSelectedIndex();
        if (row < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN RUBRO");
            return;
        }
        try {
            productos = new ProductoTopService().getAllProductoTabacoTopActivos2(rubro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR NRO.851 - LEYENDO PRODUCTOS");
            return;
        }
        try {
            cf = new ConfiguracionTopService().getConfigTopById(1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR Nro.857 LEYENDO CONFIG TOP");
            return;
        }
        maxNro = cf.getOrderMaximo();
        minimoMp = cf.getImporteMinimoMercadoPago();
    }

    private ProductoTop generarProducto() {
        Boolean generado;
        ProductoTop productoT;
        do {
            generado = false;
            if (hayProductos()) {
                Random rnd = new Random();
                Double prod = rnd.nextDouble() * (maxNro + 1);
                int i = prod.intValue();
                int x = 0;
                if (!productos.isEmpty()) {
                    for (ProductoTop pptt : productos) {
                        if (pptt.getOrden().equals(i)) {
                            break;
                        }
                        x += 1;
                    }
                    try {
                        productoT = productos.get(x);
                        Float stock = productoT.getStock();
                        if (stock > 0) {
                            if (productoT.getUsado()) {
                                continue;
                            }
                            generado = true;
                        }
                    } catch (Exception ex) {
                        generado = false;
                        productoT = null;
                    }
                } else {
                    productoT = null;
                }
            } else {
                productoT = null;
            }
        } while (!generado);
        return productoT;
    }

    private Integer generarCantidad(Integer min, Integer max, Integer frac) {
        Boolean generado;
        int i;
        do {
            generado = false;
            Random rand = new Random();
            Double cnd = rand.nextDouble() * (max + 1);
            i = cnd.intValue();
            if (i % frac == 0) {
                if (i > min - 1) {
                    if (i < max + 1) {
                        generado = true;
                    }
                }
                if (i < 1) {
                    generado = false;
                }
            }
        } while (!generado);
        return i;
    }

    private void procesar() {
        copiarStock();
        List<Factura> facturasParaBorrar = null;
        try {
            facturasParaBorrar = new FcService().getAllFacturasActivas();
            for (Factura nf : facturasParaBorrar) {
                nf.setAnulado(true);
                new FcService().updateFactura(nf);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR ELIMINANDO FC ANTERIORES");
            return;
        }
        cargarProductosTop();
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "NO HAY PRODUCTOS PARA FACTURAR");
        }
    }

    private boolean hayProductos() {
        Boolean hay = false;
        if (productos != null && !productos.isEmpty()) {
            for (ProductoTop p : productos) {
                if (p.getStock() > 0) {
                    if (!p.getUsado()) {
                        hay = true;
                        break;
                    }
                }
            }
        }
        return hay;
    }

    private void llenarCampos() {
        presentarBtn.setEnabled(false);
        facturas = null;
        try {
            facturas = new FcService().getAllFacturasActivas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR nro. 1025");
            volver("V");
        }
        llenarTabla2();
    }

    private void procesar2() {
        int row = combo.getSelectedIndex() - 1;
        rubro = rubros.get(row);
        procesar();
        tabla.requestFocus();
        UtilFrame.limpiarTabla(tabla);
        int nro = 0;
//        minimoMp = cf.getMinimoMp();
        comprasMp = null;
        try {
            comprasMp = new CompraClienteMercadoPagoService().getAllFacturasPendientesDeProcesar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "NO HAY COMPRAS DE MERCADO PAGO PARA PROCESAR");
            return;
        }
//        List<ProductoTop> product;
//        try {
//            product = new ProductoTopService().getAllProductoTabacoTopActivos2(rubro);
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "ERROR 1122 - PRODUCTOS");
//            return;
//        }
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
//        System.out.println(comprasMp);
//        System.out.println(productos);
//        System.exit(0);
        for (CompraClienteMercadoPago ccmp : comprasMp) {
            List<ProductoTop2> productos2 = cargarProd2(productos);
            System.out.println(productos2);
//            JOptionPane.showMessageDialog(this, "w");
            Collections.sort(productos2);

//            System.out.println(productos2.size());
//            System.exit(0);
            if (ccmp.getImporte() > minimoMp) {
                Object o[] = new Object[5];
                Factura factura = crearFcMp(productos2, null, ccmp);
                if (factura != null) {
                    nro += 1;
                    o[0] = nro;
                    o[1] = factura.getCliente().getCuit();
                    o[2] = factura.getCompraClienteMercadoPago().getNombre();
                    o[3] = df_csm.format(factura.getTotal());
                    o[4] = df_csm.format(factura.getImpuesto());
                    tbl.addRow(o);
                }
            } else {
                Object o[] = new Object[5];
                Factura factura = crearFcMp2(productos2, null, ccmp);
                if (factura != null) {
                    nro += 1;
                    o[0] = nro;
                    o[1] = factura.getCliente().getCuit();
                    o[2] = factura.getCompraClienteMercadoPago().getNombre();
                    o[3] = df_csm.format(factura.getTotal());
                    o[4] = factura.getImpuesto();
                    tbl.addRow(o);
                }
            }
        }
        tabla.setModel(tbl);
        presentarBtn.setEnabled(true);
    }

    private List<ProductoTop2> cargarProd2(List<ProductoTop> produ) {
//        System.out.println(produ);
        List<ProductoTop2> productos2 = new ArrayList<>();
        if (produ != null && !produ.isEmpty()) {
            for (ProductoTop pt : produ) {
                //if (pt.getStock() > 0) {
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
                //}
            }
        }
//        System.out.println(productos2.size());
//        System.exit(0);
        return productos2;
    }

    private List<ProductoTop2> cargarProd4(List<ProductoTop> produ) {
        List<ProductoTop2> productos4 = new ArrayList<>();
        if (produ != null && !produ.isEmpty()) {
            for (ProductoTop pt : produ) {
                Double total = ((pt.getPrecio() * 1.21) + pt.getImpuesto()) * pt.getFraccion();
                if (total > 0.00) {
                    ProductoTop2 pt4 = new ProductoTop2();
                    pt4.setActivo(true);
                    pt4.setCantidad(pt.getCantidadMaximaVenta());
                    pt4.setCodigo(pt.getCodigo());
                    pt4.setDetalle(pt.getDetalle());
                    pt4.setFraccion(pt.getFraccion());
                    pt4.setImpuesto(pt.getImpuesto());
                    pt4.setOrden(0);
                    pt4.setPrecio(pt.getPrecio());
                    pt4.setRubro(pt.getRubro());
                    pt4.setStock(pt.getStock());
                    pt4.setSubRubro(pt.getSubRubro());
                    pt4.setTotal(total);
                    pt4.setUsado(false);
                    productos4.add(pt4);
                }
            }
        }
        return productos4;
    }

    private Factura crearFcMp(List<ProductoTop2> productos2, List<ProductoTop2> productos4,
            CompraClienteMercadoPago ccmp) {
        List<RenglonFc> renglones = new ArrayList<>();
        Factura factura = new Factura();
        Double importeCompraMp = ccmp.getImporte();
        if (importeCompraMp > minimoMp) {
            String cuit = ccmp.getCuit();
            System.out.println(cuit);
            if (cuit.equals("00-00000000-0")) {
                factura = generaFcB_MP(productos2, ccmp, renglones);
//                System.out.println("CONS FINAL");
            } else {
                if (cuit.equals("0")) {
                    factura = generaFcB_MP(productos2, ccmp, renglones);
                } else {
                    if (cuit.equals("00000000000")) {
                        factura = generaFcB_MP(productos2, ccmp, renglones);
                    } else {
//                System.out.println("INSCRIPTO");
//                factura = generaFcA_MP(productos2, ccmp, renglones);
                    }
                }
            }
//            JOptionPane.showMessageDialog(this, "VER");
        }
        return factura;
    }

    private Integer calcularCantidadFraccionesLinea(ProductoTop2 producto, Double importeLinea) {
        Integer cantidad = 0;
        Double precioGravado = producto.getPrecio();
        Double ivaCalculado = precioGravado * porcentualIva / 100;
        Float impuesto = producto.getImpuesto();
        Double precioUnitarioFinal = precioGravado
                + ivaCalculado
                + impuesto;
        Double precioFraccionado = precioUnitarioFinal * producto.getFraccion();
        System.out.println("precio unitario final");
        System.out.println(precioUnitarioFinal);
        System.out.println("importe linea");
        System.out.println(importeLinea);
        System.out.println("total fraccionado");
        System.out.println(precioFraccionado);
        if (precioFraccionado > importeLinea) {
            cantidad = 0;
        } else {
            System.out.println("importeLinea");
            System.out.println(importeLinea);
            System.out.println(importeLinea.intValue());
            System.out.println(df_int.format(importeLinea));
            System.out.println("precioFraccionado");
            System.out.println(precioFraccionado);
            System.out.println(df_int.format(importeLinea));
            System.out.println(df_int.format(precioFraccionado));
            Integer il = Integer.valueOf(df_int.format(importeLinea.intValue()));
            Integer pf = Integer.valueOf(df_int.format(precioFraccionado));
            cantidad = Integer.valueOf(df_int.format(il / pf));
        }
        System.out.println("cantidad");
        System.out.println(cantidad);
        return cantidad;
    }

    private Double calcularTotalLinea(ProductoTop2 producto, Integer cantidad) {
        Double precioGravado = producto.getPrecio();
        Double ivaCalculado = precioGravado * porcentualIva / 100;
        Float impuesto = producto.getImpuesto();
        Double precioUnitarioFinal = precioGravado
                + ivaCalculado
                + impuesto;
        Double precioTotal = precioUnitarioFinal * cantidad;
        return precioTotal;
    }

    private List<RenglonFc> generarFcMp3(List<ProductoTop2> productos2, CompraClienteMercadoPago ccmp) {
        List<RenglonFc> re = null;
        for (ProductoTop2 pt2 : productos2) {
            System.out.println(pt2.getDetalle());
            System.out.println(pt2.getCantidad());
            System.out.println(pt2.getFraccion());
            System.out.println(pt2.getTotal());
            System.out.println("---");
        }
        System.exit(0);
        return re;
    }

    private List<RenglonFc> generarFcMp(List<ProductoTop2> productos2, CompraClienteMercadoPago ccmp) {
        int cuantos = productos2.size();
        System.out.println(cuantos);
//        
        int orden = 0;
        List<RenglonFc> renglones = new ArrayList<>();
        Integer partes;
        Double importeMp = ccmp.getImporte();
        if (importeMp < 30000) {
            partes = 1;
        } else {
            if (importeMp < 600000) {
                partes = 2;
            } else {
                if (importeMp < 100000) {
                    partes = 3;
                } else {
                    if (importeMp < 300000) {
                        partes = 4;
                    } else {
                        if (importeMp < 500000) {
                            partes = 5;
                        } else {
                            partes = 6;
                        }
                    }
                }
            }
        }
        System.out.println(partes);
        if (cuantos < partes) {
            partes = cuantos - 1;
            if (partes < 1) {
                partes = 1;
            }
        }
        Integer ult = productos2.size();
        Double importeLineaFactura = importeMp / partes;
        System.out.println("importeLineaFactura");
        System.out.println(importeLineaFactura);
        System.out.println("total fc mp");
        System.out.println(importeMp);
        System.out.println("aqui se calcula");
        Double totalAcumulado = 0.0;
//        System.exit(0);
        for (int i = 0; i < ult; i++) {
            ProductoTop2 pt2 = productos2.get(i);
            Integer cantidadFracciones = calcularCantidadFraccionesLinea(pt2, importeLineaFactura);
            System.out.println(cantidadFracciones);
            if (cantidadFracciones > 0) {
                Integer cantidadProductos = cantidadFracciones * pt2.getFraccion();
                Double totalLinea = calcularTotalLinea(pt2, cantidadProductos);
                if (totalLinea > importeMp) {
                    cantidadFracciones = 0;
                    continue;
                }
                System.out.println(pt2.getDetalle());
                System.out.println(cantidadProductos);
                System.out.println("total linea");
                System.out.println(totalLinea);
                totalAcumulado += totalLinea;
                importeMp -= totalLinea;
                partes -= 1;
                Double totalNetoGravado = cantidadProductos * pt2.getPrecio();
                Float totalImpuesto = cantidadProductos * pt2.getImpuesto();
                Double totalIva = (pt2.getPrecio() * porcentualIva / 100) * cantidadProductos;
                orden += 1;
                RenglonFc rfc = new RenglonFc();
                rfc.setAnulado(false);
                rfc.setCantidad(cantidadProductos.floatValue());
                rfc.setCodigoProducto(pt2.getCodigo());
                rfc.setCostoG(0.0);
                rfc.setCostoI(0.0);
                rfc.setDescuento(0.0);
                rfc.setExento(0.0);
                rfc.setFabricacion(false);
                Double valorTotalNetoGravado = UtilFactura.calcularRedondeo(totalNetoGravado);
                rfc.setGravado(valorTotalNetoGravado);
                rfc.setGravado0(0.0);
                rfc.setGravado10_5(0.0);
                rfc.setGravado27(0.0);
                Double valorTotalImpuesto = UtilFactura.calcularRedondeo(totalImpuesto.doubleValue());
                rfc.setImpuesto(valorTotalImpuesto);
                rfc.setItemNro(orden);
                Double valorTotalIva = UtilFactura.calcularRedondeo(totalIva);
                rfc.setIva(valorTotalIva);
                rfc.setIva0(0.0);
                rfc.setIva10_5(0.0);
                rfc.setIva27(0.0);
                rfc.setNoGravado(0.0);
                Producto pt1;
                try {
                    pt1 = new ProductoService().getProductoByCodigo(pt2.getCodigo());
                } catch (Exception ex) {
                    Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR nro.1394 - PRODUCTO");
                    return null;
                }
                rfc.setProducto(pt1);
                rfc.setSugerido(0.0);
                Double valorTotalLinea = UtilFactura.calcularRedondeo(totalLinea);
                rfc.setTotal(valorTotalLinea);
                renglones.add(rfc);

                if (importeMp < cf.getMaximoLogistica()) {
//                    JOptionPane.showMessageDialog(this, "ver producto y sale");
                    break;
                }
                importeLineaFactura = importeMp / partes;
            }
//            JOptionPane.showMessageDialog(this, "ver producto");
        }

        System.out.println("total acumulado");
        System.out.println(totalAcumulado);
//        }
        System.out.println("x_____________________________x");

        System.out.println(ccmp.getImporte());
        System.out.println(totalAcumulado);
        if (totalAcumulado < ccmp.getImporte()) {
            //
            List<ProductoTop> prodTopParaUltimaLinea;
            Double totalLineaParaAjustar = ccmp.getImporte() - totalAcumulado;
            totalLineaParaAjustar = UtilFactura.calcularRedondeo(totalLineaParaAjustar);
            try {
                prodTopParaUltimaLinea = new ProductoTopService().getProductoTopActivosVtaSinStock();
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro.1503 - PROD-AJUSTE");
                return null;
            }
            Integer codigoProdAjuste = prodTopParaUltimaLinea.get(0).getCodigo();
            Integer fraccionMpAjuste = prodTopParaUltimaLinea.get(0).getFraccionMp();
            Producto productoParaRenglon;
            try {
                productoParaRenglon = new ProductoService().getProductoByCodigo(codigoProdAjuste);
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro.1512 - PROD-AJUSTE");
                return null;
            }
            Double netoAjuste = productoParaRenglon.getPrecio() * 1.21 + productoParaRenglon.getImpuesto();
            netoAjuste = UtilFactura.calcularRedondeo(netoAjuste);
            netoAjuste = netoAjuste * fraccionMpAjuste;

            Double cantidadProductoAjuste = totalLineaParaAjustar / netoAjuste;
            if (cantidadProductoAjuste.intValue() >= 1) {
                Integer cantGrupo = cantidadProductoAjuste.intValue();
                Integer cantidadParaRenglon = cantGrupo * fraccionMpAjuste;

                Double precioNetoAjuste = productoParaRenglon.getPrecio() * cantidadParaRenglon;
                precioNetoAjuste = UtilFactura.calcularRedondeo(precioNetoAjuste);
                Float impuestoAjuste = productoParaRenglon.getImpuesto() * cantidadParaRenglon;
                impuestoAjuste = UtilFactura.calcularRedondeoF(impuestoAjuste);
                Double ivaAjuste = precioNetoAjuste * .21;
                ivaAjuste = UtilFactura.calcularRedondeo(ivaAjuste);
                Double totalAjuste = precioNetoAjuste + impuestoAjuste + ivaAjuste;
                totalAjuste = UtilFactura.calcularRedondeo(totalAjuste);

                RenglonFc rfc2 = new RenglonFc();
                rfc2.setAnulado(false);
                rfc2.setCantidad(cantidadParaRenglon.floatValue());
                rfc2.setCodigoProducto(codigoProdAjuste);
                rfc2.setCostoG(0.0);
                rfc2.setCostoI(0.0);
                rfc2.setDescuento(0.0);
                rfc2.setExento(0.0);
                rfc2.setFabricacion(false);
                Double valorPrecioNetoAjuste = UtilFactura.calcularRedondeo(precioNetoAjuste);
                rfc2.setGravado(valorPrecioNetoAjuste);
                rfc2.setGravado0(0.0);
                rfc2.setGravado10_5(0.0);
                rfc2.setGravado27(0.0);
                Double valorImpuestoAjuste = UtilFactura.calcularRedondeo(impuestoAjuste.doubleValue());
                rfc2.setImpuesto(valorImpuestoAjuste);
                rfc2.setItemNro(orden);
                orden += 1;
                Double valorIvaAjuste = UtilFactura.calcularRedondeo(ivaAjuste);
                rfc2.setIva(valorIvaAjuste);
                rfc2.setIva0(0.0);
                rfc2.setIva10_5(0.0);
                rfc2.setIva27(0.0);
                rfc2.setNoGravado(0.0);
                rfc2.setProducto(productoParaRenglon);
                rfc2.setSugerido(0.0);
                Double valorTotalAjuste = UtilFactura.calcularRedondeo(totalAjuste);
                rfc2.setTotal(valorTotalAjuste);

                renglones.add(rfc2);
                Double valorTotalAcumulado = totalAcumulado + valorTotalAjuste;
                totalAcumulado = UtilFactura.calcularRedondeo(valorTotalAcumulado);
            }
            //
            Producto pro;
            Double totalLineaLogis = ccmp.getImporte() - totalAcumulado;
//            Double totalGravadoLogis = totalLineaLogis / (1 + porcentualIva / 100);
//            Double totalIvaLogis = totalLineaLogis - totalGravadoLogis;

            try {
                pro = new ProductoService().getByRubroAndPrecioPorPorcentaje(rubro);
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR nro. 1432 - CIG.VARIOS");
                return null;
            }
//            System.out.println(rubro.getNombre());
//            System.out.println(pro.getDetalle());
////            System.out.println(pro.getDetalle());
//            System.exit(0);
            RenglonFc rfc = new RenglonFc();
            Double valorTotalLineaLogis = UtilFactura.calcularRedondeo(totalLineaLogis);
            System.out.println(pro);
            System.out.println(pro.getDetalle());
            System.out.println(pro.getPorcentajePrecio());
//            System.out.println(totalLineaLogis);
//            System.out.println(UtilFactura.calcularRedondeo(totalLineaLogis));
//            System.out.println(valorTotalLineaLogis = UtilFactura.calcularRedondeo(totalLineaLogis));
            System.out.println(pro.getPorcentajePrecio());
            System.out.println(pro.getPorcentajePrecio() / 100);
            System.out.println(valorTotalLineaLogis * pro.getPorcentajePrecio() / 100);
            valorTotalLineaLogis = UtilFactura.calcularRedondeo(totalLineaLogis);
//            System.exit(0);
            Double impu2 = valorTotalLineaLogis * pro.getPorcentajePrecio() / 100;
            Double bruto2 = valorTotalLineaLogis - impu2;
            Double neto2 = bruto2 / 1.21;
            rfc.setAnulado(false);
            rfc.setCantidad(1F);
            rfc.setCodigoProducto(pro.getCodigo());
            rfc.setCostoG(0.0);
            rfc.setCostoI(0.0);
            rfc.setDescuento(0.0);
            rfc.setExento(0.0);
            rfc.setFabricacion(false);
            Double iva2 = valorTotalLineaLogis - neto2 - impu2;
            neto2 = UtilFactura.calcularRedondeo(neto2);
            rfc.setGravado(neto2);
            rfc.setGravado0(0.0);
            rfc.setGravado10_5(0.0);
            rfc.setGravado27(0.0);
            impu2 = UtilFactura.calcularRedondeo(impu2);
            rfc.setImpuesto(impu2);
            rfc.setItemNro(orden);
//            Double valorIvaLogis = UtilFactura.calcularRedondeo(totalIvaLogis);
            iva2 = UtilFactura.calcularRedondeo(iva2);
            rfc.setIva(iva2);
            rfc.setIva0(0.0);
            rfc.setIva10_5(0.0);
            rfc.setIva27(0.0);
            rfc.setNoGravado(0.0);
            rfc.setProducto(pro);
            rfc.setSugerido(0.0);

            rfc.setTotal(valorTotalLineaLogis);
            renglones.add(rfc);
        }

        return renglones;// Is ok
    }

    private Factura generaFcB_MP(List<ProductoTop2> productos2, CompraClienteMercadoPago ccmp,
            List<RenglonFc> renglones) {
        Factura factura = new Factura();
        RenglonFc rf = new RenglonFc();
        renglones = generarFcMp(productos2, ccmp);
        String cuit = ccmp.getCuit();
        if (renglones != null && !renglones.isEmpty()) {
            Cliente cliente;
            if (cuit.equals("00-00000000-0")) {
                try {
                    cliente = new ClienteService().getClienteByCodigo("1");
                } catch (Exception ex) {
                    Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR nro. 1596 - CLIENTE");
                    return null;
                }
            } else {
                if (cuit.equals("0")) {
                    try {
                        cliente = new ClienteService().getClienteByCodigo("1");
                    } catch (Exception ex) {
                        Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR nro. 1605 - CLIENTE");
                        return null;
                    }
                } else {
                    if (cuit.equals("00000000000")) {
                        try {
                            cliente = new ClienteService().getClienteByCodigo("1");
                        } catch (Exception ex) {
                            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "ERROR nro. 1605 - CLIENTE");
                            return null;
                        }
                    } else {
                        try {
                            cliente = new ClienteService().getClienteByCuit(cuit);
                        } catch (Exception ex) {
                            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "ERROR nro. 1232 - CLIENTE");
                            return null;
                        }
                    }
                }
            }
            Double gravado = 0.0;
            Double impuesto = 0.0;
            Double iva = 0.0;
            Double totalFactura = 0.0;
            for (RenglonFc renglon : renglones) {
                gravado += renglon.getGravado();
                gravado = UtilFactura.calcularRedondeo(gravado);
                impuesto += renglon.getImpuesto();
                impuesto = UtilFactura.calcularRedondeo(impuesto);
                iva += renglon.getIva();
                iva = UtilFactura.calcularRedondeo(iva);
                totalFactura += renglon.getTotal();
                totalFactura = UtilFactura.calcularRedondeo(totalFactura);
                System.out.println(gravado);
                System.out.println(iva);
                System.out.println(impuesto);
                System.out.println(totalFactura);
                System.out.println("_");
            }
            if (!df.format(totalFactura).equals(df.format(ccmp.getImporte()))) {
                System.out.println("DIFERENTE");
                if (totalFactura > ccmp.getImporte()) {
                    totalFactura -= .01;
                    impuesto -= .01;
                } else {
                    totalFactura += .01;
                    impuesto += .01;
                }
                System.out.println(gravado);
                System.out.println(iva);
                System.out.println(impuesto);
                System.out.println(totalFactura);
                System.out.println("_");
            }
            factura.setAnulado(false);
            factura.setCliente(cliente);
            factura.setCompraClienteMercadoPago(ccmp);
            factura.setExento(0.0);
            factura.setFabricacion(false);
            factura.setFecha(fechaFacturas);
            factura.setGravado(gravado);
            factura.setGravado0(0.0);
            factura.setGravado10(0.0);
            factura.setGravado27(0.0);
            factura.setImpuesto(impuesto);
            factura.setIva(iva);
            factura.setIva0(0.0);
            factura.setIva10(0.0);
            factura.setIva27(0.0);
            factura.setNoGravado(0.0);
            factura.setTotal(totalFactura);
            rf.setFactura(factura);
//                JOptionPane.showMessageDialog(this, "OTRA FACTURA");
//                System.exit(0);
            try {
                new FcService().saveFactura(factura, renglones);
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                factura = null;
            }
        }
        return factura;
    }

    private Factura generaFcA_MP(List<ProductoTop2> productos2, CompraClienteMercadoPago ccmp, List<RenglonFc> renglones) {
        Factura factura = new Factura();
//        RenglonFc rf = new RenglonFc();
        renglones = generarFcMp(productos2, ccmp);
        String cuit = ccmp.getCuit();
        if (renglones != null && !renglones.isEmpty()) {
            Cliente cliente = null;
            try {
                cliente = new ClienteService().getClienteByCuit(cuit);
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR nro. 1232 - CLIENTE");
                return null;
            }
            Double gravado = 0.0;
            Double impuesto = 0.0;
            Double iva = 0.0;
            Double totalFactura = 0.0;
            for (RenglonFc renglon : renglones) {
                gravado += renglon.getGravado();
                gravado = UtilFactura.calcularRedondeo(gravado);
                impuesto += renglon.getImpuesto();
                impuesto = UtilFactura.calcularRedondeo(impuesto);
                iva += renglon.getIva();
                iva = UtilFactura.calcularRedondeo(iva);
                totalFactura += renglon.getTotal();
                totalFactura = UtilFactura.calcularRedondeo(totalFactura);
                System.out.println(gravado);
                System.out.println(iva);
                System.out.println(impuesto);
                System.out.println(totalFactura);
                System.out.println("_");
            }
            if (!df.format(totalFactura).equals(df.format(ccmp.getImporte()))) {
                System.out.println("DIFERENTE");
                if (totalFactura > ccmp.getImporte()) {
                    totalFactura -= .01;
                    impuesto -= .01;
                } else {
                    totalFactura += .01;
                    impuesto += .01;
                }
                System.out.println(gravado);
                System.out.println(iva);
                System.out.println(impuesto);
                System.out.println(totalFactura);
                System.out.println("_");
            }
            factura.setAnulado(false);
            factura.setCliente(cliente);
            factura.setCompraClienteMercadoPago(ccmp);
            factura.setExento(0.0);
            factura.setFabricacion(false);
            factura.setFecha(fechaFacturas);
            factura.setGravado(gravado);
            factura.setGravado0(0.0);
            factura.setGravado10(0.0);
            factura.setGravado27(0.0);
            factura.setImpuesto(impuesto);
            factura.setIva(iva);
            factura.setIva0(0.0);
            factura.setIva10(0.0);
            factura.setIva27(0.0);
            factura.setNoGravado(0.0);
            factura.setTotal(totalFactura);
//            rf.setFactura(factura);
//                JOptionPane.showMessageDialog(this, "OTRA FACTURA");
//                System.exit(0);
            try {
                new FcService().saveFactura(factura, renglones);
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                factura = null;
            }
        }
        return factura;
    }

    private Factura crearFcMp2(List<ProductoTop2> productos2, Object object, CompraClienteMercadoPago ccmp) {
        List<RenglonFc> renglones = new ArrayList<>();
        Factura factura = new Factura();
        String cuit = ccmp.getCuit();
        System.out.println(cuit);
        if (cuit.equals("00-00000000-0")) {
            factura = generaFcB_MP2(productos2, ccmp, renglones);
//                System.out.println("CONS FINAL");
        } else {
//                System.out.println("INSCRIPTO");
//                factura = generaFcA_MP(productos2, ccmp, renglones);
        }
//            JOptionPane.showMessageDialog(this, "VER");

        return factura;
    }

    private Factura generaFcB_MP2(List<ProductoTop2> productos2, CompraClienteMercadoPago ccmp, List<RenglonFc> renglones) {
        Factura factura = new Factura();
        RenglonFc rf = new RenglonFc();
        renglones = generarFcMp2(productos2, ccmp);
        String cuit = ccmp.getCuit();
        if (renglones != null && !renglones.isEmpty()) {
            Cliente cliente = null;
            try {
                cliente = new ClienteService().getClienteByCuit(cuit);
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR nro. 1232 - CLIENTE");
                return null;
            }
            Double gravado = 0.0;
            Double impuesto = 0.0;
            Double iva = 0.0;
            Double totalFactura = 0.0;
            for (RenglonFc renglon : renglones) {
                gravado += renglon.getGravado();
                gravado = UtilFactura.calcularRedondeo(gravado);
                impuesto += renglon.getImpuesto();
                impuesto = UtilFactura.calcularRedondeo(impuesto);
                iva += renglon.getIva();
                iva = UtilFactura.calcularRedondeo(iva);
                totalFactura += renglon.getTotal();
                totalFactura = UtilFactura.calcularRedondeo(totalFactura);
                System.out.println(gravado);
                System.out.println(iva);
                System.out.println(impuesto);
                System.out.println(totalFactura);
                System.out.println("_");
            }
            if (!df.format(totalFactura).equals(df.format(ccmp.getImporte()))) {
                System.out.println("DIFERENTE");
                if (totalFactura > ccmp.getImporte()) {
                    totalFactura -= .01;
                    impuesto -= .01;
                } else {
                    totalFactura += .01;
                    impuesto += .01;
                }
                System.out.println(gravado);
                System.out.println(iva);
                System.out.println(impuesto);
                System.out.println(totalFactura);
                System.out.println("_");
            }
            factura.setAnulado(false);
            factura.setCliente(cliente);
            factura.setCompraClienteMercadoPago(ccmp);
            factura.setExento(0.0);
            factura.setFabricacion(false);
            factura.setFecha(fechaFacturas);
            factura.setGravado(gravado);
            factura.setGravado0(0.0);
            factura.setGravado10(0.0);
            factura.setGravado27(0.0);
            factura.setImpuesto(impuesto);
            factura.setIva(iva);
            factura.setIva0(0.0);
            factura.setIva10(0.0);
            factura.setIva27(0.0);
            factura.setNoGravado(0.0);
            factura.setTotal(totalFactura);
            rf.setFactura(factura);
//                JOptionPane.showMessageDialog(this, "OTRA FACTURA");
//                System.exit(0);
            try {
                new FcService().saveFactura(factura, renglones);
            } catch (Exception ex) {
                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
                factura = null;
            }
        }
        return factura;
    }

    private List<RenglonFc> generarFcMp2(List<ProductoTop2> productos2, CompraClienteMercadoPago ccmp) {
        int cuantos = productos2.size();
        System.out.println(cuantos);
        int orden = 0;
        List<RenglonFc> renglones = new ArrayList<>();

        Double importeMp = ccmp.getImporte();

        Integer ult = productos2.size();
        Double importeLineaFactura = importeMp;
        System.out.println("importeLineaFactura");
        System.out.println(importeLineaFactura);
        System.out.println("total fc mp");
        System.out.println(importeMp);
        System.out.println("aqui se calcula");
        Double totalAcumulado = 0.0;
//        for (int i = 0; i < ult; i++) {
//            ProductoTop2 pt2 = productos2.get(i);
//            Integer cantidadFracciones = calcularCantidadFraccionesLinea(pt2, importeLineaFactura);
//            System.out.println(cantidadFracciones);
//            if (cantidadFracciones > 0) {
//                Integer cantidadProductos = cantidadFracciones * pt2.getFraccion();
//                Double totalLinea = calcularTotalLinea(pt2, cantidadProductos);
//                if (totalLinea > importeMp) {
//                    cantidadFracciones = 0;
//                    continue;
//                }
//                System.out.println(pt2.getDetalle());
//                System.out.println(cantidadProductos);
//                System.out.println("total linea");
//                System.out.println(totalLinea);
//                totalAcumulado += totalLinea;
//                importeMp -= totalLinea;
//                Double totalNetoGravado = cantidadProductos * pt2.getPrecio();
//                Float totalImpuesto = cantidadProductos * pt2.getImpuesto();
//                Double totalIva = (pt2.getPrecio() * porcentualIva / 100) * cantidadProductos;
//                orden += 1;
//                RenglonFc rfc = new RenglonFc();
//                rfc.setAnulado(false);
//                rfc.setCantidad(cantidadProductos.floatValue());
//                rfc.setCodigoProducto(pt2.getCodigo());
//                rfc.setCostoG(0.0);
//                rfc.setCostoI(0.0);
//                rfc.setDescuento(0.0);
//                rfc.setExento(0.0);
//                rfc.setFabricacion(false);
//                Double valorTotalNetoGravado = UtilFactura.calcularRedondeo(totalNetoGravado);
//                rfc.setGravado(valorTotalNetoGravado);
//                rfc.setGravado0(0.0);
//                rfc.setGravado10_5(0.0);
//                rfc.setGravado27(0.0);
//                Double valorTotalImpuesto = UtilFactura.calcularRedondeo(totalImpuesto.doubleValue());
//                rfc.setImpuesto(valorTotalImpuesto);
//                rfc.setItemNro(orden);
//                Double valorTotalIva = UtilFactura.calcularRedondeo(totalIva);
//                rfc.setIva(valorTotalIva);
//                rfc.setIva0(0.0);
//                rfc.setIva10_5(0.0);
//                rfc.setIva27(0.0);
//                rfc.setNoGravado(0.0);
//                Producto pt1;
//                try {
//                    pt1 = new ProductoService().getProductoByCodigo(pt2.getCodigo());
//                } catch (Exception ex) {
//                    Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(this, "ERROR nro.1394 - PRODUCTO");
//                    return null;
//                }
//                rfc.setProducto(pt1);
//                rfc.setSugerido(0.0);
//                Double valorTotalLinea = UtilFactura.calcularRedondeo(totalLinea);
//                rfc.setTotal(valorTotalLinea);
//                renglones.add(rfc);
//
//                if (importeMp < cf.getMaximoLogistica()) {
////                    JOptionPane.showMessageDialog(this, "ver producto y sale");
//                    break;
//                }
////                importeLineaFactura = importeMp / partes;
//            }
////            JOptionPane.showMessageDialog(this, "ver producto");
//        }

        System.out.println("total acumulado");
        System.out.println(totalAcumulado);
//        }
        System.out.println("x_____________________________x");

        System.out.println(ccmp.getImporte());
        System.out.println(totalAcumulado);
//        if (totalAcumulado < ccmp.getImporte()) {
//            //
//            List<ProductoTop> prodTopParaUltimaLinea;
//            Double totalLineaParaAjustar = ccmp.getImporte() - totalAcumulado;
//            totalLineaParaAjustar = UtilFactura.calcularRedondeo(totalLineaParaAjustar);
//            try {
//                prodTopParaUltimaLinea = new ProductoTopService().getProductoTopActivosVtaSinStock();
//            } catch (Exception ex) {
//                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "ERROR Nro.1503 - PROD-AJUSTE");
//                return null;
//            }
//            Integer codigoProdAjuste = prodTopParaUltimaLinea.get(0).getCodigo();
//            Integer fraccionMpAjuste = prodTopParaUltimaLinea.get(0).getFraccionMp();
//            Producto productoParaRenglon;
//            try {
//                productoParaRenglon = new ProductoService().getProductoByCodigo(codigoProdAjuste);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "ERROR Nro.1512 - PROD-AJUSTE");
//                return null;
//            }
//            Double netoAjuste = productoParaRenglon.getPrecio() * 1.21 + productoParaRenglon.getImpuesto();
//            netoAjuste = UtilFactura.calcularRedondeo(netoAjuste);
//            netoAjuste = netoAjuste * fraccionMpAjuste;
//
//            Double cantidadProductoAjuste = totalLineaParaAjustar / netoAjuste;
//            if (cantidadProductoAjuste.intValue() >= 1) {
//                Integer cantGrupo = cantidadProductoAjuste.intValue();
//                Integer cantidadParaRenglon = cantGrupo * fraccionMpAjuste;
//
//                Double precioNetoAjuste = productoParaRenglon.getPrecio() * cantidadParaRenglon;
//                precioNetoAjuste = UtilFactura.calcularRedondeo(precioNetoAjuste);
//                Float impuestoAjuste = productoParaRenglon.getImpuesto() * cantidadParaRenglon;
//                impuestoAjuste = UtilFactura.calcularRedondeoF(impuestoAjuste);
//                Double ivaAjuste = precioNetoAjuste * .21;
//                ivaAjuste = UtilFactura.calcularRedondeo(ivaAjuste);
//                Double totalAjuste = precioNetoAjuste + impuestoAjuste + ivaAjuste;
//                totalAjuste = UtilFactura.calcularRedondeo(totalAjuste);
//
//                RenglonFc rfc2 = new RenglonFc();
//                rfc2.setAnulado(false);
//                rfc2.setCantidad(cantidadParaRenglon.floatValue());
//                rfc2.setCodigoProducto(codigoProdAjuste);
//                rfc2.setCostoG(0.0);
//                rfc2.setCostoI(0.0);
//                rfc2.setDescuento(0.0);
//                rfc2.setExento(0.0);
//                rfc2.setFabricacion(false);
//                Double valorPrecioNetoAjuste = UtilFactura.calcularRedondeo(precioNetoAjuste);
//                rfc2.setGravado(valorPrecioNetoAjuste);
//                rfc2.setGravado0(0.0);
//                rfc2.setGravado10_5(0.0);
//                rfc2.setGravado27(0.0);
//                Double valorImpuestoAjuste = UtilFactura.calcularRedondeo(impuestoAjuste.doubleValue());
//                rfc2.setImpuesto(valorImpuestoAjuste);
//                rfc2.setItemNro(orden);
//                orden += 1;
//                Double valorIvaAjuste = UtilFactura.calcularRedondeo(ivaAjuste);
//                rfc2.setIva(valorIvaAjuste);
//                rfc2.setIva0(0.0);
//                rfc2.setIva10_5(0.0);
//                rfc2.setIva27(0.0);
//                rfc2.setNoGravado(0.0);
//                rfc2.setProducto(productoParaRenglon);
//                rfc2.setSugerido(0.0);
//                Double valorTotalAjuste = UtilFactura.calcularRedondeo(totalAjuste);
//                rfc2.setTotal(valorTotalAjuste);
//
//                renglones.add(rfc2);
//                Double valorTotalAcumulado = totalAcumulado + valorTotalAjuste;
//                totalAcumulado = UtilFactura.calcularRedondeo(valorTotalAcumulado);
//            }
//            //
Rubro ru = null;
        try {
            ru = new RubroService().getRubroByCodigo(1);
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        SubRubro su = null;
        try {
            su = new SubRubroService().getSubRubroByCodigo(25);
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Producto pro;
        Double totalLineaLogis = ccmp.getImporte();
//            Double totalGravadoLogis = totalLineaLogis / (1 + porcentualIva / 100);
//            Double totalIvaLogis = totalLineaLogis - totalGravadoLogis;
        try {
            pro = new ProductoService().getActivoByCodigoSubRubroAndRubro(ru, su);
        } catch (Exception ex) {
            Logger.getLogger(FacturarMercadoPago2Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR nro. 1432 - CIG.VARIOS");
            return null;
        }
        RenglonFc rfc = new RenglonFc();
        Double valorTotalLineaLogis = UtilFactura.calcularRedondeo(totalLineaLogis);
        System.out.println(valorTotalLineaLogis);
        System.out.println(pro);
        System.out.println(pro.getPorcentajePrecio());
//        System.exit(0);
        Double impu2 = valorTotalLineaLogis * pro.getPorcentajePrecio() / 100;
        Double bruto2 = valorTotalLineaLogis - impu2;
        Double neto2 = bruto2 / 1.21;
        rfc.setAnulado(false);
        rfc.setCantidad(1F);
        rfc.setCodigoProducto(1124);
        rfc.setCostoG(0.0);
        rfc.setCostoI(0.0);
        rfc.setDescuento(0.0);
        rfc.setExento(0.0);
        rfc.setFabricacion(false);
        Double iva2 = valorTotalLineaLogis - neto2 - impu2;
        neto2 = UtilFactura.calcularRedondeo(neto2);
        rfc.setGravado(neto2);
        rfc.setGravado0(0.0);
        rfc.setGravado10_5(0.0);
        rfc.setGravado27(0.0);
        impu2 = UtilFactura.calcularRedondeo(impu2);
        rfc.setImpuesto(impu2);
        rfc.setItemNro(orden);
//            Double valorIvaLogis = UtilFactura.calcularRedondeo(totalIvaLogis);
        iva2 = UtilFactura.calcularRedondeo(iva2);
        rfc.setIva(iva2);
        rfc.setIva0(0.0);
        rfc.setIva10_5(0.0);
        rfc.setIva27(0.0);
        rfc.setNoGravado(0.0);
        rfc.setProducto(pro);
        rfc.setSugerido(0.0);

        rfc.setTotal(valorTotalLineaLogis);
        renglones.add(rfc);

        return renglones;// Is ok
    }

}

class Avanzando_a implements Runnable {

    private JProgressBar bar;
    private Float incremento;
    private Float maximo;
    private final int tst = 0; // 1 esta en test

    @Override

    public void run() {
        this.getBar().setValue(1);
//        System.exit(0);
        File archivoTitular = new File("D:/ventasJo/temp/titular.txt");
        FileReader frd;
        String cuitTitular; // = Constantes.cuitTitular;
        String tipoDocTit; // = Constantes.tipoDocTit;
        String puntoVenta; // = Constantes.puntoVenta;
        try {
            frd = new FileReader(archivoTitular);
            BufferedReader brd = new BufferedReader(frd);
            cuitTitular = brd.readLine();
            tipoDocTit = brd.readLine();
            puntoVenta = brd.readLine();
            brd.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 1664");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Float posF = 2F;
        Integer largo;
        // desde aqui
        Date fechaFacturas;
        Integer tim1;
        Integer tim2;
        String fechaString;
        String tim1String;
        String tim2String;
        File archivo = new File("D:/ventasJo/temp/temp.txt");
        FileReader fr;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            fechaString = br.readLine();
            tim1String = br.readLine();
            tim2String = br.readLine();
            br.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 1688");
            return;
        }

        try {
            fechaFacturas = sdf.parse(fechaString);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "ERROR 1703");
            return;
        }
        tim1 = Integer.valueOf(tim1String);
        tim2 = Integer.valueOf(tim2String);

        List<Factura> nuevasFacturas = null;
        try {
            nuevasFacturas = new FcService().getAllFacturasActivas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR 931");
            return;
        }
        largo = nuevasFacturas.size();
        maximo = largo.floatValue();
        incremento = 100 / maximo;
        System.out.println(nuevasFacturas);

        for (Factura nuevasFc : nuevasFacturas) {

            posF += incremento;
            Integer pos = posF.intValue();
            getBar().setValue(pos);

            CompraClienteMercadoPago compraCliMp = nuevasFc.getCompraClienteMercadoPago();
            String cuit_cliente = compraCliMp.getCuit();
            String pri0;// = cuit_cliente.substring(0, 2);
            String med0;// = cuit_cliente.substring(3, 11);
            String fin0;// = cuit_cliente.substring(12, 13);
            if (cuit_cliente.equals("")) {
                pri0 = "0";
                med0 = "";
                fin0 = "";
            } else {
                if (cuit_cliente.equals("0")) {
                    pri0 = "0";
                    med0 = "";
                    fin0 = "";
                } else {
                    if (cuit_cliente.equals("00-00000000-0")) {
                        pri0 = "0";
                        med0 = "";
                        fin0 = "";
                    } else {
                        if (cuit_cliente.equals("00000000000")) {
                            pri0 = "0";
                            med0 = "";
                            fin0 = "";
                        } else {
                            pri0 = cuit_cliente.substring(0, 2);
                            med0 = cuit_cliente.substring(3, 11);
                            fin0 = cuit_cliente.substring(12, 13);
                        }
                    }

                }
            }
            String tipoDocCli; // = cliente.getTipo();
            String cui; // = pri0 + "-" + med0 + "-" + fin0;
            if (pri0.equals("0")) {
                cui = pri0 + med0 + fin0;
            } else {
                cui = pri0 + "-" + med0 + "-" + fin0;
            }

            System.out.println(cui);

            Cliente cliente = null;
            String pri;// = cui.substring(0, 2);
            String med;// = cui.substring(3, 11);
            String fin;// = cui.substring(12, 13);
            System.out.println(cui);
//            System.exit(0);
            if (!cui.equals("00-00000000-0")) {
                if (!cui.equals("0")) {
                    if (!cui.equals("00000000000")) {
                        try {
                            cliente = new ClienteService().getClienteByCuit(cui);
                            if (cliente == null) {
                                JOptionPane.showMessageDialog(null, "ERROR nro. 947 - LEYENDO CLIENTE");
                                return;
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "ERROR nro. 947 - LEYENDO CLIENTE");
                            return;
                        }
                        pri = cui.substring(0, 2);
                        med = cui.substring(3, 11);
                        fin = cui.substring(12, 13);
                        tipoDocCli = "80";
                    } else {
                        try {
                            cliente = new ClienteService().getClienteByCodigo("1");
                            if (cliente == null) {
                                JOptionPane.showMessageDialog(null, "ERROR nro. 947 - LEYENDO CLIENTE");
                                return;
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "ERROR nro. 947 - LEYENDO CLIENTE");
                            return;
                        }
                        pri = "0";
                        med = "";
                        fin = "";
                        tipoDocCli = "99";
                    }
                } else {
                    try {
                        cliente = new ClienteService().getClienteByCodigo("1");
                        if (cliente == null) {
                            JOptionPane.showMessageDialog(null, "ERROR nro. 947 - LEYENDO CLIENTE");
                            return;
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "ERROR nro. 947 - LEYENDO CLIENTE");
                        return;
                    }
                    pri = "0";
                    med = "";
                    fin = "";
                    tipoDocCli = "99";
                }
            } else {
                try {
                    cliente = new ClienteService().getClienteByCodigo("1");
                    if (cliente == null) {
                        JOptionPane.showMessageDialog(null, "ERROR nro. 947 - LEYENDO CLIENTE");
                        return;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR nro. 947 - LEYENDO CLIENTE");
                    return;
                }
                pri = "0";
                med = "";
                fin = "";
                tipoDocCli = "99";
            }
            String cuitCliente = pri + med + fin;

            int tim = 0;
            FacturaIvaIntercambio fii = null;
            System.out.println(cliente);
            System.out.println(cui);
            System.out.println(cuitCliente);
//            System.exit(0);
            do {
                Random rnd = new Random();
                Double segu = rnd.nextDouble() * (tim2 + 1);
                tim = segu.intValue();
            } while (tim < tim1 || tim > tim2);
            try {
                sleep(tim * 1000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "ERR. con frecuencia de facturas");
                continue;
            }
            System.out.println(nuevasFc.getGravado());
            System.out.println(nuevasFc.getImpuesto());
            System.out.println(nuevasFc.getIva());
            System.out.println(nuevasFc.getTotal());
//            System.exit(0);
            if (tst == 0) {
                if (cuit_cliente.equals("00-00000000-0")) {
                    System.out.println("FC B");
                } else {
                    System.out.println("FC A");
                }
                System.out.println(cuitTitular);
                System.out.println(tipoDocTit);
                System.out.println(cuitCliente);
                System.out.println(tipoDocCli);
                System.out.println(fechaFacturas);
                System.out.println(puntoVenta);
                System.out.println("xxx");
//                JOptionPane.showMessageDialog(null, "ver");
                fii = UtilAfip.presentarAfip(cuitTitular, tipoDocTit, cuitCliente,
                        tipoDocCli, nuevasFc.getGravado(), nuevasFc.getImpuesto(), nuevasFc.getIva(),
                        nuevasFc.getTotal(), fechaFacturas, puntoVenta);
                compraCliMp.setProcesado(true);
            } else {
                fii = new FacturaIvaIntercambio();
                fii.setCae(123456789012345L);
                fii.setEstado("A");
                fii.setFecha(fechaFacturas);
                fii.setFechaVencimientoCae(fechaFacturas);
                fii.setLetra("B");
                Integer nroFc;
                try {
                    nroFc = new IvaVentasService().getUltimoNumeroFactura(cuitTitular);
                } catch (Exception ex) {
                    nroFc = 0;
                }
                fii.setNumero(nroFc + 1);
                fii.setSucursal(20);
            }
            List<RenglonFactura> listaRf = new ArrayList<>();
            List<RenglonFc> renglones;
            try {
                renglones = new RenglonFcService().getRenglonesByFc(nuevasFc);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "FC SIN RENGLONES");
                return;
            }
            if (fii != null) {
                Configuracion cfg;
                try {
                    cfg = new ConfiguracionService().getFacturas(1L);
                } catch (Exception ex) {
                    Logger.getLogger(Avanzando_a.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR 1641 - CONFIGURACION");
                    return;
                }
                cfg.setNumeroFacturaB(fii.getNumero());
                IvaVentas iv = new IvaVentas();
                iv.setCae(fii.getCae());
                iv.setCliente(cliente);
                if (cliente.getDomicilio() != null) {
                    Domicilio dm = cliente.getDomicilio();
                    iv.setCalleNroCliente(dm.getCalle()
                            + " " + dm.getNumero());
                    iv.setCpLocalidadProvinciaCliente(dm.getCodigoPostal()
                            + " " + dm.getLocalidad()
                            + " " + dm.getProvincia());
                } else {
                    iv.setCalleNroCliente("");
                    iv.setCpLocalidadProvinciaCliente("");
                }
                iv.setRazonSocialCliente(compraCliMp.getNombre());
                iv.setRazonSocialTitular(Constantes.razon_social_titular);
                iv.setCuitTitular(Constantes.cuitTitular);
                iv.setCuitCliente(cuitCliente);
                iv.setCalleNroTitular(Constantes.calleNroTitular);
                iv.setCpLocalidadProvinciaTitular(Constantes.cpLocalidadProvinciaTitular);
                iv.setIibbTitular(Constantes.iibbTitular);
                iv.setInicioActividades(Constantes.inicioActividades);
                iv.setDescripcion(compraCliMp.getOrigen());
                iv.setOperacion(compraCliMp.getOperacion());
                iv.setDescuentoGlobal(0.0);
                iv.setExento(0.0);
                iv.setFecha(fechaFacturas);
                iv.setFechaCae(fii.getFechaVencimientoCae());
                iv.setGravado(nuevasFc.getGravado());
                iv.setGravado0(0.0);
                iv.setGravado10_5(0.0);
                iv.setGravado27(0.0);
                iv.setImpuesto(nuevasFc.getImpuesto());
                iv.setIva(nuevasFc.getIva());
                iv.setIva0(0.0);
                iv.setIva10_5(0.0);
                iv.setIva27(0.0);
                iv.setLetra(fii.getLetra());
                iv.setLetraReferencia("x");
                iv.setNoGravado(0.0);
                iv.setNumeroFactura(fii.getNumero());
                iv.setNumeroFacturaReferencia(0);
                iv.setNumeroSucursal(fii.getSucursal());
                iv.setNumeroSucursalReferencia(0);
                iv.setTipoDoc(6);
                iv.setTotal(nuevasFc.getTotal());
                for (RenglonFc re : renglones) {
                    RenglonFactura rf = new RenglonFactura();
                    rf.setCantidad(re.getCantidad());
                    rf.setCostoG(0.0);
                    rf.setCostoI(0.0);
                    rf.setDescripcion(re.getProducto().getDetalle());
                    rf.setDescuento(0.0);
                    rf.setExento(0.0);
                    rf.setFabricacion(false);
                    rf.setGravado(re.getGravado());
                    rf.setGravado0(0.0);
                    rf.setGravado10_5(0.0);
                    rf.setGravado27(0.0);
                    rf.setImpuesto(re.getImpuesto());
                    rf.setItemNro(1);
                    rf.setIva(re.getIva());
                    rf.setIva0(0.0);
                    rf.setIva10_5(0.0);
                    rf.setIva27(0.0);
                    rf.setNoGravado(0.0);
                    rf.setProducto(re.getProducto());
                    rf.setSugerido(0.0);
                    rf.setTotal(re.getTotal());
                    rf.setIvaVentas(iv);
                    listaRf.add(rf);
                }
                FacturaCompraReferenciaMercadoPago fcrmp = new FacturaCompraReferenciaMercadoPago();
                try {
                    new IvaVentasService().saveIvaVentasCompletoMp(iv, fcrmp, compraCliMp, listaRf, cfg);
                } catch (Exception ex) {
                    Logger.getLogger(Avanzando_a.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERR nro 1975");
                    return;
                }
//                try {
//                    iv = new IvaVentasService().saveIvaVentas(iv);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "ERR nro 1076");
//                }
//                try {
//                    for (RenglonFactura rn : listaRf) {
//                        rn.setIvaVentas(iv);
//                        new RenglonFacturaService().saveRenglon(rn);
//                    }
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "ERR nro. 1082");
//                }
//                try {
//                    new CompraClienteMercadoPagoService().updateCompraClientesImportados(compraCliMp);
//                    fcrmp.setCompraClienteMercadoPago(compraCliMp);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "ERR nro. 1088");
//                }
//                fcrmp.setCompraClienteMercadoPago(compraCliMp);
//                fcrmp.setIvaVentas(iv);
//                try {
//                    new FacturaCompraReferenciaMercadoPagoService().saveFacturaCompraRmp(fcrmp);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "ERR nro. 1094");
//                }
//                try {
//                    new ConfiguracionService().updateConfiguracion(cfg);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "ERR nro. 1322");
//                }
            } else {
                System.out.println(cuit_cliente);
                System.out.println(fii);
                JOptionPane.showMessageDialog(null, "ERR AFIP NRO. 1239");
            }
        }

        JOptionPane.showMessageDialog(
                null, "         FINALIZADO         \n\nPUEDE SALIR DE ESTA PANTALLA");

    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }

    public JProgressBar getBar() {
        return bar;
    }

}
