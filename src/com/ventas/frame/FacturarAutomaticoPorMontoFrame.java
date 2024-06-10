package com.ventas.frame;

import com.ventas.entities.ArticuloCompra;
import com.ventas.entities.CalculoFactura;
import com.ventas.entities.Cliente;
import com.ventas.entities.Configuracion;
import com.ventas.entities.ConfiguracionTop;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.RenglonFactura;
import com.ventas.main.MainFrame;
import com.ventas.services.ArticuloCompraService;
import com.ventas.services.ClienteService;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.ConfiguracionTopService;
import com.ventas.services.FacturaService;
import com.ventas.services.IvaVentasService;
import com.ventas.util.Constantes;
import com.ventas.util.UtilAfip;
import com.ventas.util.UtilFactura;
import com.ventas.util.UtilFrame;
import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author argia
 */
public class FacturarAutomaticoPorMontoFrame extends javax.swing.JFrame {

    private List<ArticuloCompra> articulos;
//    private List<FacturaCompra> compras;
    private List<CalculoFactura> nuevasFacturas;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Double minimo = 0.0;
    private Double maximo = 0.0;
    private Date fechaFacturas = new Date();
    private String cuitTitular = Constantes.cuitTitular;
    private String tipoDocTit = Constantes.tipoDocTit;
    private String puntoVenta = Constantes.puntoVenta;
    private Cliente cliente;
    private String cuitCliente;
    private String tipoDocCli;
    private final int tst = 0; // 1 esta en test

    /**
     * Creates new form FacturarAutomaticoPorMontoFrame
     */
    public FacturarAutomaticoPorMontoFrame() {
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

        volverBtn = new javax.swing.JButton();
        presentarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        calcularBtn = new javax.swing.JButton();
        importeMaximoTxt = new javax.swing.JTextField();
        importeMinimoTxt = new javax.swing.JTextField();
        fechaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ultimaFechaTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        totalFacturarTxt = new javax.swing.JTextField();
        segDeTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        segAlTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FACTURACION AUTOMATICA POR MONTO");

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        presentarBtn.setText("PRESENTAR");
        presentarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentarBtnActionPerformed(evt);
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
                "NRO", "GRAVADO", "IMPUESTO", "IVA", "TOTAL"
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        jLabel1.setText("FECHA:");

        jLabel2.setText("IMPORTE MINIMO:");

        jLabel3.setText("IMPORTE MAXIMO:");

        calcularBtn.setText("CALCULAR");
        calcularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularBtnActionPerformed(evt);
            }
        });

        importeMaximoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeMaximoTxt.setText("IMPORTE MAX");

        importeMinimoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeMinimoTxt.setText("IMPORTE MIN");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        jLabel4.setText("ULTIMA FECHA:");

        ultimaFechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ultimaFechaTxt.setText("ULTIMA FECHA");

        jLabel5.setText("TOTAL FACTURAR:");

        totalFacturarTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalFacturarTxt.setText("TOTAL FACTURAR");
        totalFacturarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                totalFacturarTxtKeyPressed(evt);
            }
        });

        segDeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        segDeTxt.setText("SEG");

        jLabel6.setText("SEGUNDOS ENTRE FC:");

        segAlTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        segAlTxt.setText("SEG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(presentarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(segDeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(segAlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(importeMinimoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(importeMaximoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calcularBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ultimaFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalFacturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ultimaFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(totalFacturarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(importeMinimoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(importeMaximoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcularBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(presentarBtn)
                    .addComponent(segDeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(segAlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void presentarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentarBtnActionPerformed
        presentar();
        JOptionPane.showMessageDialog(this, "PROCESO TRMINADO");
        volver();
    }//GEN-LAST:event_presentarBtnActionPerformed

    private void calcularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularBtnActionPerformed
        if (!importeMinimoTxt.getText().isEmpty()) {
            minimo = Double.valueOf(importeMinimoTxt.getText().replace(",", "."));
        }
        if (!importeMaximoTxt.getText().isEmpty()) {
            maximo = Double.valueOf(importeMaximoTxt.getText().replace(",", "."));
        }
        calcular();
    }//GEN-LAST:event_calcularBtnActionPerformed

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                try {
                    fechaFacturas = sdf.parse(fechaTxt.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "ERROR 252");
                    return;
                }
                totalFacturarTxt.requestFocus();
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

    private void totalFacturarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalFacturarTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!totalFacturarTxt.getText().isEmpty()) {
                mostrarImportes();
            }
        }
    }//GEN-LAST:event_totalFacturarTxtKeyPressed

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
            java.util.logging.Logger.getLogger(FacturarAutomaticoPorMontoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturarAutomaticoPorMontoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturarAutomaticoPorMontoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturarAutomaticoPorMontoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturarAutomaticoPorMontoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularBtn;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField importeMaximoTxt;
    private javax.swing.JTextField importeMinimoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton presentarBtn;
    private javax.swing.JTextField segAlTxt;
    private javax.swing.JTextField segDeTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField totalFacturarTxt;
    private javax.swing.JTextField ultimaFechaTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        fechaTxt.setText("");
        segDeTxt.setText("15");
        segAlTxt.setText("50");
        importeMinimoTxt.setText("");
        importeMaximoTxt.setText("");
        totalFacturarTxt.setText("");
        ultimaFechaTxt.setText("");
        ultimaFechaTxt.setEditable(false);
        try {
            ultimaFechaTxt.setText(new IvaVentasService().getUltimaFechaFactura());
        } catch (Exception ex) {
            ultimaFechaTxt.setText(sdf.format(new Date()));
        }
        UtilFrame.limpiarTabla(tabla);
        ConfiguracionTop cfgt;
        try {
            cfgt = new ConfiguracionTopService().getConfigTopById(1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR NRO.275");
            return;
        }
        minimo = cfgt.getImporteMinimoMercadoPago();
        maximo = cfgt.getImporteMaximo();
        Configuracion cfg;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR NRO.288");
        }
        try {
            cliente = new ClienteService().getClienteByCodigo("1");
            if (cliente != null) {
                String cuit_cliente = cliente.getCuit();
                String pri = cuit_cliente.substring(0, 2);
                String med = cuit_cliente.substring(3, 11);
                String fin = cuit_cliente.substring(12, 13);
                cuitCliente = pri + med + fin;
                tipoDocCli = cliente.getTipo();
            }
        } catch (Exception ex) {
            cliente = null;
        }

    }

    private void calcular() {
        Double limiteFacturar = Double.valueOf(totalFacturarTxt.getText());
        UtilFrame.limpiarTabla(tabla);
        articulos = null;
        try {
            articulos = new ArticuloCompraService().getAllArticulosActivos();
        } catch (Exception ex) {
//            Logger.getLogger(FacturarAutomaticoPorMontoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        if (articulos != null && !articulos.isEmpty()) {
            nuevasFacturas = calcularConFacturas(limiteFacturar, articulos);
        } else {
            nuevasFacturas = calcularSinFacturas(limiteFacturar);
        }
        llenarTabla(nuevasFacturas);
    }

    private void presentar() {
        int a = JOptionPane.showConfirmDialog(this, "VERIFICO LA FECHA DE LAS FACTURAS???", "Atención", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            Cliente cliente;
            String codigo = "1";
            try {
                cliente = new ClienteService().getClienteByCodigo(codigo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ERROR 391");
                return;
            }
            if (!segDeTxt.getText().isEmpty()) {
                if ((!segAlTxt.getText().isEmpty())) {
                    int tim = 0;
                    for (CalculoFactura cf : nuevasFacturas) {
                        FacturaIvaIntercambio fii;// = new FacturaIvaIntercambio();

                        int tim1 = Integer.valueOf(segDeTxt.getText());
                        int tim2 = Integer.valueOf(segAlTxt.getText());
                        do {
                            Random rnd = new Random();
                            Double segu = rnd.nextDouble() * (tim2 + 1);
                            tim = segu.intValue();
                        } while (tim < tim1 || tim > tim2);
                        try {
                            sleep(tim * 1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (tst == 0) {
                            fii = UtilAfip.presentarAfip(cuitTitular, tipoDocTit, cuitCliente,
                                    tipoDocCli, cf.getGravado(), cf.getImpuesto(), cf.getIva(),
                                    cf.getTotal(), fechaFacturas, puntoVenta);
                        } else {
                            fii.setCae(123456789012345L);
                            fii.setEstado("A");
                            fii.setFecha(fechaFacturas);
                            fii.setFechaVencimientoCae(fechaFacturas);
                            fii.setLetra("B");
                            Integer nroFc;
                            try {
                                nroFc = new IvaVentasService().getUltimoNumeroFactura();
                            } catch (Exception ex) {
                                nroFc = 0;
                            }
                            fii.setNumero(nroFc + 1);
                            fii.setSucursal(2);
                        }
                        if (fii != null) {
                            RenglonFactura rf = new RenglonFactura();
                            List<RenglonFactura> listaRf = new ArrayList<>();
                            rf.setCantidad(1F);
                            rf.setCostoG(0.0);
                            rf.setCostoI(0.0);
                            rf.setDescripcion(cf.getProducto().getDetalle());
                            rf.setDescuento(0.0);
                            rf.setExento(0.0);
                            rf.setFabricacion(false);
                            rf.setGravado(cf.getGravado());
                            rf.setGravado0(0.0);
                            rf.setGravado10_5(0.0);
                            rf.setGravado27(0.0);
                            rf.setImpuesto(cf.getImpuesto());
                            rf.setItemNro(1);
                            rf.setIva(cf.getIva());
                            rf.setIva0(0.0);
                            rf.setIva10_5(0.0);
                            rf.setIva27(0.0);
                            rf.setNoGravado(0.0);
                            rf.setProducto(cf.getProducto());
                            rf.setSugerido(0.0);
                            rf.setTotal(cf.getTotal());
                            IvaVentas iv = new IvaVentas();
                            iv.setCae(fii.getCae());
                            iv.setCliente(cliente);
                            iv.setDescuentoGlobal(0.0);
                            iv.setExento(0.0);
                            iv.setFecha(fechaFacturas);
                            iv.setFechaCae(fii.getFechaVencimientoCae());
                            iv.setGravado(cf.getGravado());
                            iv.setGravado0(0.0);
                            iv.setGravado10_5(0.0);
                            iv.setGravado27(0.0);
                            iv.setImpuesto(cf.getImpuesto());
                            iv.setIva(cf.getIva());
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
                            iv.setTotal(cf.getTotal());
                            rf.setIvaVentas(iv);
                            listaRf.add(rf);
                            ArticuloCompra artCmpr = cf.getArticulo();
                            artCmpr.setGravado(artCmpr.getGravado() - iv.getGravado());
                            artCmpr.setImpuesto(artCmpr.getImpuesto() - iv.getImpuesto());
                            artCmpr.setIva(artCmpr.getIva() - iv.getIva());
                            artCmpr.setTotal(artCmpr.getTotal() - iv.getTotal());
                            try {
                                new FacturaService().saveFacturaCompleta(iv, listaRf, artCmpr, null);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(this, "ERROR 466");
                                break;
                            }
                            
                        } else {
                            JOptionPane.showMessageDialog(this, "ERR AFIP");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "DEBE INGRESAR LOS SEGUNDOS ENTRE FACTURAS");
                }
            } else {
                JOptionPane.showMessageDialog(this, "DEBE INGRESAR LOS SEGUNDOS ENTRE FACTURAS");
            }
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void mostrarImportes() {
        importeMinimoTxt.setText(df.format(minimo));
        importeMaximoTxt.setText(df.format(maximo));
        calcularBtn.requestFocus();
    }

    private List<CalculoFactura> calcularConFacturas(Double limiteFacturar, List<ArticuloCompra> compras) {
        List<CalculoFactura> nuevas_facturas = new ArrayList<>();
        Double totalFacturas = 0.00;
        Boolean repetir = true;
        Integer contadorCompras = 0;
        Integer ultimoCompras = compras.size();
        ArticuloCompra compra = compras.get(contadorCompras);
        do {
            Random rnd = new Random();
            Double importeRnd = rnd.nextDouble() * (maximo + 1);
            importeRnd = importeRedondeado(importeRnd);
            if (importeRnd > minimo) {
                CalculoFactura cf = UtilFactura.calcularTotalesAutomatico(importeRnd, compra);
                if (cf != null) {
                    nuevas_facturas.add(cf);
                    totalFacturas += cf.getTotal();
                } else {
                    repetir = false;
                }
                compra.setGravado(compra.getGravado() - cf.getGravado());
                compra.setImpuesto(compra.getImpuesto() - cf.getImpuesto());
                compra.setIva(compra.getIva() - cf.getIva());
                compra.setTotal(compra.getTotal() - cf.getTotal());
                if (compra.getTotal() < 0.0) {
                    contadorCompras += 1;
                    if (contadorCompras > ultimoCompras - 1) {
                        repetir = false;
                    } else {
                        compra = compras.get(contadorCompras);
                    }
                }
            }
            if (totalFacturas > limiteFacturar) {
                repetir = false;
            }
        } while (repetir);
        return nuevas_facturas;
    }

    private List<CalculoFactura> calcularSinFacturas(Double limiteFacturar) {
        List<CalculoFactura> nuevas_facturas = new ArrayList<>();

        List<ArticuloCompra> compras = null;
        try {
            compras = new ArticuloCompraService().getAllArticulosActivos();
        } catch (Exception ex) {
            return null;
        }
        if (compras != null && !compras.isEmpty()) {
            Double totalFacturas = 0.00;
            Boolean repetir = true;
            Integer contadorCompras = 0;
            Integer ultimoCompras = compras.size();

            ArticuloCompra compra = compras.get(contadorCompras);
            do {
                Random rnd = new Random();
                Double importeRnd = rnd.nextDouble() * (maximo + 1);
                importeRnd = importeRedondeado(importeRnd);
                if (importeRnd > minimo) {
                    CalculoFactura cf = UtilFactura.calcularTotalesAutomatico(importeRnd, compra);
                    if (cf != null) {
                        nuevas_facturas.add(cf);
                        totalFacturas += cf.getTotal();
                    } else {
                        repetir = false;
                    }
                    compra.setGravado(compra.getGravado() - cf.getGravado());
                    compra.setImpuesto(compra.getImpuesto() - cf.getImpuesto());
                    compra.setIva(compra.getIva() - cf.getIva());
                    compra.setTotal(compra.getTotal() - cf.getTotal());
                    if (compra.getTotal() < 0.0) {
                        contadorCompras += 1;
                        if (contadorCompras > ultimoCompras - 1) {
                            contadorCompras = 0;
                        } else {
                            compra = compras.get(contadorCompras);
                        }
                    }
                }
                if (totalFacturas > limiteFacturar) {
                    repetir = false;
                }
            } while (repetir);
        } else {
            JOptionPane.showMessageDialog(this, "NO HAY COMPRAS DISPONIBLES");
            nuevas_facturas = null;
        }
        return nuevas_facturas;
    }

    private Boolean generarFactura(Date fecha) {

//        compra = compras.get(contadorCompras);
//        factura = facturas.get(contadorFacturas);
//        Double totalCompraMP = compra.getImporte() - compra.getImporteUtilizado();
//        Double totalFactura = factura.getTotalVenta() - factura.getTotalUtilizado();
//        if (totalFactura < importeMinimoMercadoPago) {
//            contadorFacturas += 1;
//            if (contadorFacturas > cantidadFacturas - 1) {
//                return false;
//            }
//            return true;
//        }
//        if (totalFactura > totalCompraMP) {
////            JOptionPane.showMessageDialog(this, "AQUI ES MAYOR");
////            System.out.println(totalFactura);
////            System.out.println(totalCompraMP);
////            JOptionPane.showMessageDialog(this, "VER");
//            CalculoFactura cf = UtilFactura.calcularTotales(factura, compra);
//
//            Integer ultimoNumero = UtilFrame.getUltimoNumeroFactura();
//            // presentar afip
//            FacturaIvaIntercambio fii = new FacturaIvaIntercambio();
//            FacturaCompraReferenciaMercadoPago fcrmp = new FacturaCompraReferenciaMercadoPago();
//
//            fii.setEstado("A");
//            fii.setCae(1234567890123456789L);
//            fii.setFechaVencimientoCae(new Date());
//            fii.setFecha(fecha);
//            fii.setLetra("B");
//            fii.setNumero(ultimoNumero + 1);
//            fii.setSucursal(10);
//
//            compra.setProcesado(true);
//            compra.setImporteUtilizado(compra.getImporte());
//
//            factura.setGravadoUtilizado(factura.getGravadoUtilizado() + cf.getGravado());
//            factura.setIvaUtilizado(factura.getIvaUtilizado() + cf.getIva());
//            factura.setImpuestoUtilizado(factura.getImpuestoUtilizado() + cf.getImpuesto());
//            factura.setTotalUtilizado(factura.getTotalUtilizado() + cf.getTotal());
//
//            fcrmp.setCompraClienteMercadoPago(compra);
//            fcrmp.setFacturaCompra(factura);
//
//            if (fii.getEstado().equals("A")) {
//                UtilFactura.grabarComprobanteCompleto(cf,
//                        compra, factura, fii, fcrmp);
//            }
//            contadorCompras += 1;
//            if (contadorCompras > cantidadCompras - 1) {
//                return false;
//            }
//
//        } else {
//            if (totalFactura < totalCompraMP) {
////                JOptionPane.showMessageDialog(this, "AQUI YA ES MENOR");
////                System.out.println(totalFactura);
////                System.out.println(totalCompraMP);
////                JOptionPane.showMessageDialog(this, "VER");
//
//                CalculoFactura cf = UtilFactura.calcularTotales2(factura, compra);
//
//                Integer ultimoNumero = UtilFrame.getUltimoNumeroFactura();
//                // presentar afip
//                FacturaIvaIntercambio fii = new FacturaIvaIntercambio();
//                FacturaCompraReferenciaMercadoPago fcrmp = new FacturaCompraReferenciaMercadoPago();
//
//                fii.setEstado("A");
//                fii.setCae(1234567890123456789L);
//                fii.setFechaVencimientoCae(new Date());
//                fii.setFecha(fecha);
//                fii.setLetra("B");
//                fii.setNumero(ultimoNumero + 1);
//                fii.setSucursal(10);
//
//                compra.setProcesado(false);
//                compra.setImporteUtilizado(compra.getImporteUtilizado() + cf.getTotal());
//
//                factura.setGravadoUtilizado(factura.getGravadoVenta());
//                factura.setIvaUtilizado(factura.getIvaVenta());
//                factura.setImpuestoUtilizado(factura.getImpuestoVenta());
//                factura.setTotalUtilizado(factura.getTotalVenta());
//                factura.setProcesado(true);
//
//                fcrmp.setFacturaCompra(factura);
//                fcrmp.setCompraClienteMercadoPago(compra);
//
//                if (fii.getEstado().equals("A")) {
//                    UtilFactura.grabarComprobanteCompleto(cf, compra, factura, fii, fcrmp);
//                }
//                contadorFacturas += 1;
//                if (contadorFacturas > cantidadFacturas - 1) {
//                    return false;
//                }
//
//            } else {
////                JOptionPane.showMessageDialog(this, "AQUI ES IGUAL");
////                System.out.println(totalFactura);
////                System.out.println(totalCompraMP);
////                JOptionPane.showMessageDialog(this, "VER");
//
//                CalculoFactura cf = UtilFactura.calcularTotales3(factura, compra);
//
//                Integer ultimoNumero = UtilFrame.getUltimoNumeroFactura();
//                // presentar afip
//                FacturaIvaIntercambio fii = new FacturaIvaIntercambio();
//                FacturaCompraReferenciaMercadoPago fcrmp = new FacturaCompraReferenciaMercadoPago();
//
//                fii.setEstado("A");
//                fii.setCae(1234567890123456789L);
//                fii.setFechaVencimientoCae(new Date());
//                fii.setFecha(fecha);
//                fii.setLetra("B");
//                fii.setNumero(ultimoNumero + 1);
//                fii.setSucursal(10);
//
//                compra.setProcesado(true);
//                compra.setImporteUtilizado(compra.getImporte());
//
//                factura.setGravadoUtilizado(factura.getGravadoVenta());
//                factura.setIvaUtilizado(factura.getIvaVenta());
//                factura.setImpuestoUtilizado(factura.getImpuestoVenta());
//                factura.setTotalUtilizado(factura.getTotalVenta());
//                factura.setProcesado(true);
////
//                fcrmp.setCompraClienteMercadoPago(compra);
//                fcrmp.setFacturaCompra(factura);
//
//                if (fii.getEstado().equals("A")) {
//                    UtilFactura.grabarComprobanteCompleto(cf, compra, factura, fii, fcrmp);
//                }
//
//                contadorFacturas += 1;
//                if (contadorFacturas > cantidadFacturas - 1) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    private Double importeRedondeado(Double importeRnd) {
        String importeStr = df.format(importeRnd);
        Double importeRedondeado = Double.valueOf(importeStr.replace(",", "."));
        return importeRedondeado;
    }

    private void llenarTabla(List<CalculoFactura> nuevas_facturas) {
        Integer nro = 0;
        if (nuevas_facturas != null && !nuevas_facturas.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (CalculoFactura cf : nuevas_facturas) {
                Object o[] = new Object[5];
                nro += 1;
                o[0] = nro;
                o[1] = df.format(cf.getGravado());
                o[2] = df.format(cf.getImpuesto());
                o[3] = df.format(cf.getIva());
                o[4] = df.format(cf.getTotal());
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }
}
