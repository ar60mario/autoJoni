
package com.ventas.frame;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import com.ventas.entities.Cliente;
import com.ventas.entities.Configuracion;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.Producto;
import com.ventas.entities.RenglonFactura;
import com.ventas.entities.TicketTime;
import com.ventas.estructuras.Constante;
import com.ventas.main.MainFrame;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.IvaVentasService;
import com.ventas.services.ProductoService;
import com.ventas.services.RenglonFacturaService;
import com.ventas.services.TicketTimeService;
import com.ventas.util.UtilFrame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.rint;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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


public class NotaCreditoPorGrupoFrame extends javax.swing.JFrame {

    private JPanel contentPanel;
    private List<IvaVentas> facturas;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("$#,##0.00");
    private DecimalFormat df_afip = new DecimalFormat("#0.00");
    private final Integer puntoVta = 10;
    private Integer comprobanteNumero = 0;
    private String userdir = "d:/ventasJo/crt";
    private String token;
    private String sign;
    private Date fecha = new Date();
    private int hora = 0;
    private int minutos = 0;
    private int segundos = 0;
    private String tipoComprob;
    private ActiveXComponent wsaa = new ActiveXComponent("WSAA");
    private String wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
    private TicketTime tkt;
    private int tst = 0; //  1 esta en test
    
    public NotaCreditoPorGrupoFrame() {
        initComponents();
        limpiarCampos();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        notaCreditoBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fechaNotaCreditoTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("NOTA DE CREDITO FACTURAS SELECCIONADAS");

        jLabel1.setText("Desde:");

        deTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deTxt.setText("DE");
        deTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deTxtKeyPressed(evt);
            }
        });

        alTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alTxt.setText("AL");
        alTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alTxtKeyPressed(evt);
            }
        });

        jLabel2.setText("Hasta:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Cliente", "CUIT", "Nro.", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
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
            tabla.getColumnModel().getColumn(0).setPreferredWidth(15);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        notaCreditoBtn.setText("Nota Crédito Seleccionadas");
        notaCreditoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaCreditoBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha Nota Crédito:");

        fechaNotaCreditoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaNotaCreditoTxt.setText("FNC");
        fechaNotaCreditoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaNotaCreditoTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(notaCreditoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaNotaCreditoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(fechaNotaCreditoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notaCreditoBtn)
                    .addComponent(volverBtn))
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
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = deTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                alTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            deTxt.setText(fe);
        }
    }//GEN-LAST:event_deTxtKeyPressed

    private void alTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = alTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                buscarFacturas();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            alTxt.setText(fe);
        }
    }//GEN-LAST:event_alTxtKeyPressed

    private void notaCreditoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaCreditoBtnActionPerformed
        int rows = tabla.getSelectedRowCount();
        if(rows > 0){
            int lineas[] = tabla.getSelectedRows();
            for(int i = 0;i<rows;i++){
                notaCreditoByFc(facturas.get(lineas[i]));
            }
            JOptionPane.showMessageDialog(this, "PROCESO COMPLETADO");
            volver();
        }
    }//GEN-LAST:event_notaCreditoBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void fechaNotaCreditoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaNotaCreditoTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaNotaCreditoTxt.getText();
            int largo = fe.length();
            if (largo != 10) {
//                buscarFacturas();
//            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaNotaCreditoTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaNotaCreditoTxtKeyPressed

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
            java.util.logging.Logger.getLogger(NotaCreditoPorGrupoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoPorGrupoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoPorGrupoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoPorGrupoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotaCreditoPorGrupoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JTextField deTxt;
    private javax.swing.JTextField fechaNotaCreditoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton notaCreditoBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void limpiarCampos() {
        deTxt.setText("");
        alTxt.setText("");
        fechaNotaCreditoTxt.setText("");
        UtilFrame.limpiarTabla(tabla);
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constante.getR(), Constante.getG(), Constante.getB()));
        JFrame jFrame = NotaCreditoPorGrupoFrame.this;
        jFrame.setLocationRelativeTo(null);
        String str0 = "- Joni -"; // + " " + str1;
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        jFrame.setDefaultCloseOperation(0);
        setContentPane(contentPanel);
    }

    private void buscarFacturas() {
        Date de, al;
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(NotaCreditoPorGrupoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 296 - FECHAS");
            return;
        }
        facturas = null;
        try {
            facturas = new IvaVentasService().getFacturasBEntreFechas(de, al);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoPorGrupoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 305 - FACTURAS");
            return;
        }
        llenarTabla();
    }

    private void llenarTabla() {
        if(facturas != null && !facturas.isEmpty()){
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for(IvaVentas fc:facturas){
                Object o[] = new Object[5];
                o[0]=sdf.format(fc.getFecha());
                o[1]=fc.getCliente().getRazonSocial();
                o[2]=fc.getCliente().getCuit();
                o[3]="Fc 10-"+fc.getNumeroFactura().toString();
                o[4]=df.format(fc.getTotal());
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void notaCreditoByFc(IvaVentas iv) {
        Configuracion config = null;
        try {
            config = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR nro.339 - CONFIGURACION");
            return;
        }
        int numf;
        if (config.getNumeroNotaCreditoB() != null) {
            numf = config.getNumeroNotaCreditoB();
        } else {
            numf = 0;
        }
        Cliente cli = iv.getCliente();
        Long caeLong = 0L;
        Date caeVencim = new Date();
        List<RenglonFactura> renglo2 = null;
        String letra = "B";
        try {
            renglo2 = new RenglonFacturaService().getAllRenglonFacturaFromIvaVentas(iv);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR nro.360 - RENGLONES DE FACTURA");
//            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        int tim = 0;
        Date fws = new Date();
        try {
            fws = sdf.parse(fechaNotaCreditoTxt.getText());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "ERROR nro.383 - FECHA PARA NOTAS DE CREDITO");
//            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        Date ultimaFechaNc = fws;
        if (tst == 0) {
            // asignar cae AFIP
            try {
                LibraryLoader.loadJacobLibrary();
                wsaa = new ActiveXComponent("WSAA");
//                System.out.println(Dispatch.get(wsaa, "InstallDir").toString()
//                        + " "
//                        + Dispatch.get(wsaa, "Version").toString()
//                );
                Calendar cal = Calendar.getInstance();
                fecha = cal.getTime();
                hora = cal.get(Calendar.HOUR_OF_DAY);
                minutos = cal.get(Calendar.MINUTE);
                segundos = cal.get(Calendar.SECOND);
                tkt = new TicketTimeService().getTicketById(1L);
                if (fecha != tkt.getFecha()) {
                    solicitarNuevoTicket();
                } else if (hora != tkt.getHora()) {
                    if (hora == tkt.getHora() + 1) {
                        if (minutos > tkt.getMinuto()) {
                            solicitarNuevoTicket();
                        } else {
                            int xMinuto = 60 - tkt.getMinuto();
                            if ((xMinuto + minutos) > 30) {
                                solicitarNuevoTicket();
                            }
                        }
                    } else {
                        solicitarNuevoTicket();
                    }
                } else if (minutos - tkt.getMinuto() > 30) {
                    solicitarNuevoTicket();
                }
                ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
                Dispatch.put(wsfev1, "Cuit", new Variant("20300377425"));
                Dispatch.put(wsfev1, "Token", new Variant(token));
                Dispatch.put(wsfev1, "Sign", new Variant(sign));
                String cache = "";
                wsdl = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL";
                Dispatch.call(wsfev1, "Conectar",
                        new Variant(cache),
                        new Variant(wsdl)
                );
                String tipo_cbte = "8";
                tipoComprob = tipo_cbte;
                String pto_vta = String.valueOf(puntoVta); // Sucursal declarada WS
                String sucursalFacturaPapel = "000" + pto_vta;
                Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                        new Variant(tipo_cbte),
                        new Variant(pto_vta));
                String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//                        System.out.println(wsfev1);
//                        //JOptionPane.showMessageDialog(this, "Ult.Comprb." + ult.toString());
//                        System.out.println("Ult.Comprb." + ult.toString());
                numf = Integer.valueOf(ult.toString());
                comprobanteNumero = Integer.parseInt(ult.toString());
                if (numf != comprobanteNumero) {
                    JOptionPane.showMessageDialog(this, "No coinciden los numeros");
                    return;
                }
//                        System.out.println(numf);
//                        System.exit(0);
                String fechaWs = new SimpleDateFormat("yyyyMMdd").format(fws);
                String concepto = "1";// producto 
                String cui = cli.getCuit();
                String cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
                String tipoD = String.valueOf(cli.getTipo());
                String tipo_doc = tipoD, nro_doc = cuit1; //tipo y numero
                int cbte_nro = Integer.parseInt(ult.toString()) + 1,
                        cbt_desde = cbte_nro,
                        cbt_hasta = cbte_nro;
                String numeroFacturaPapel = String.valueOf(cbte_nro);
                numf = cbte_nro;
                comprobanteNumero = cbte_nro;
                int largo = ("00000000" + numeroFacturaPapel).length();
                numeroFacturaPapel = ("00000000" + numeroFacturaPapel).substring(largo - 8, largo);
                Double importeAbono = iv.getTotal(); //100.50
                String imp_total = df_afip.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
                String imp_tot_conc = "0.00";
                String imp_neto = df_afip.format(iv.getGravado()).replaceAll("\\,", "\\.");
                String imp_iva = df_afip.format(iv.getIva()).replaceAll("\\,", "\\.");
                int internos = (int) rint(iv.getImpuesto() * 100);
                String imp_trib = "", imp_op_ex = "0";
                if (internos > 0) {
                    imp_trib = df_afip.format(iv.getImpuesto()).replaceAll("\\,", "\\.");
                } else {
                    imp_trib = "0.00";
                }
                System.out.println("");
                System.out.println(pto_vta);
                System.out.println(imp_trib);
                System.out.println(imp_iva);
                System.out.println(imp_neto);
                System.out.println(imp_tot_conc);
                System.out.println(imp_total);
                System.out.println(imp_op_ex);
//                System.exit(0);
                String fecha_cbte = fechaWs, fecha_venc_pago = "";
                String fecha_serv_desde = "", fecha_serv_hasta = "";
                String moneda_id = "PES", moneda_ctz = "1.000";

                int xxx = 1;
                if (xxx != 0) {
                    Variant ok = Dispatch.call(wsfev1, "CrearFactura",
                            new Variant(concepto), new Variant(tipo_doc),
                            new Variant(nro_doc), new Variant(tipo_cbte),
                            new Variant(pto_vta),
                            new Variant(cbt_desde), new Variant(cbt_hasta),
                            new Variant(imp_total), new Variant(imp_tot_conc),
                            new Variant(imp_neto), new Variant(imp_iva),
                            new Variant(imp_trib), new Variant(imp_op_ex),
                            new Variant(fecha_cbte), new Variant(fecha_venc_pago),
                            new Variant(fecha_serv_desde), new Variant(fecha_serv_hasta),
                            new Variant(moneda_id), new Variant(moneda_ctz));

                    Variant cbte_asoc_tipo = new Variant(iv.getTipoDoc()),
                            cbte_asoc_pto_vta = new Variant(puntoVta),
                            cbte_asoc_nro = new Variant(iv.getNumeroFactura().toString());
                    Dispatch.call(wsfev1, "AgregarCmpAsoc",
                            cbte_asoc_tipo, cbte_asoc_pto_vta, cbte_asoc_nro);
//                }

                    if (internos > 0) {
                        // 99 es otros impuestos "Otros Impuestos"
                        // 04 impuestos internos "Impuestos Internos"
                        Variant tributo_id = new Variant(04),
                                tributo_desc = new Variant("Impuestos Internos"),
                                tributo_base_imp = new Variant("0.00"),
                                tributo_alic = new Variant("0.00"),
                                tributo_importe = new Variant(imp_trib);
                        Dispatch.call(wsfev1, "AgregarTributo",
                                tributo_id, tributo_desc, tributo_base_imp,
                                tributo_alic, tributo_importe);
                    }
                    Variant iva_id = new Variant(5),
                            iva_base_imp = new Variant(imp_neto),
                            iva_importe = new Variant(imp_iva);
                    Dispatch.call(wsfev1, "AgregarIva",
                            iva_id, iva_base_imp, iva_importe);
                    Dispatch.put(wsfev1, "Reprocesar", new Variant(false));
                    Variant cae = Dispatch.call(wsfev1, "CAESolicitar");
                    String requ = Dispatch.get(wsfev1, "XmlRequest").toString();
                    String resp = Dispatch.get(wsfev1, "XmlResponse").toString();
                    excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
                    String errmsg = Dispatch.get(wsfev1, "ErrMsg").toString();
                    String obs = Dispatch.get(wsfev1, "Obs").toString();
                    String vto = Dispatch.get(wsfev1, "Vencimiento").toString();
                    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
                    //caeVencim = sd.parse(vto);
                    String resultado = Dispatch.get(wsfev1, "Resultado").toString();
                    if (!resultado.equals("A")) {
                        JOptionPane.showMessageDialog(this, "Obs: " + obs + "\nError: " + errmsg);
                        return;
                    }
                    if (vto != "" && vto != null) {
                        caeVencim = sd.parse(vto);
                        String vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                    }
                    caeLong = Long.valueOf(cae.toString());
                    String ruta1 = "d:/ventasJo/cmprbt/" + tipoComprob //cmprbt
                            + "B" + sucursalFacturaPapel
                            + numeroFacturaPapel + ".xm1";
                    String ruta2 = "d:/ventasJo/cmprbt/" + tipoComprob
                            + "B" + sucursalFacturaPapel
                            + numeroFacturaPapel + ".xm2";
                    File archivo1 = new File(ruta1);
                    File archivo2 = new File(ruta2);
                    BufferedWriter bw1, bw2;
                    bw1 = new BufferedWriter(new FileWriter(archivo1));
                    bw2 = new BufferedWriter(new FileWriter(archivo2));
                    bw1.write(requ);
                    bw2.write(resp);
                    bw1.close();
                    bw2.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
//                        e.printStackTrace();
                return;
            }
        }
        // FIN ASIGNAR CAE AFIP
        IvaVentas iv2 = new IvaVentas();
        iv2.setCae(caeLong);
        iv2.setCliente(iv.getCliente());
        iv2.setDescuentoGlobal(0.0);
        iv2.setExento(0.0);
        iv2.setFecha(fws);
        iv2.setFechaCae(caeVencim);
        iv2.setGravado(iv.getGravado());
        iv2.setGravado0(0.0);
        iv2.setGravado10_5(0.0);
        iv2.setGravado27(0.0);
        iv2.setImpuesto(iv.getImpuesto());
        iv2.setIva(iv.getIva());
        iv2.setIva0(0.0);
        iv2.setIva10_5(0.0);
        iv2.setIva27(0.0);
        iv2.setLetra(letra);
        iv2.setLetraReferencia("B");
        iv2.setNoGravado(0.0);
        //numf += 1;
        iv2.setNumeroFactura(numf);
        iv2.setTipoDoc(8);
        iv2.setNumeroFacturaReferencia(iv.getNumeroFactura());
        iv2.setNumeroSucursal(10);
        iv2.setNumeroSucursalReferencia(10);
        iv2.setTotal(iv.getTotal());
        try {
            iv2 = new IvaVentasService().saveIvaVentas(iv2);
        } catch (Exception ex) {
//            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        config.setNumeroNotaCreditoB(numf);
        config.setUltimaFecha(ultimaFechaNc);
        try {
            new ConfiguracionService().updateConfiguracion(config);
        } catch (Exception ex) {
//            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        int nu = 0;
        for (RenglonFactura r : renglo2) {
            nu += 1;
            RenglonFactura rf = new RenglonFactura();
            rf.setCantidad(r.getCantidad());
            rf.setDescripcion(r.getProducto().getDetalle());
            rf.setDescuento(0.0);
            rf.setExento(0.0);
            rf.setGravado(r.getGravado());
            rf.setGravado0(0.0);
            rf.setGravado10_5(0.0);
            rf.setGravado27(0.0);
            rf.setImpuesto(r.getImpuesto());
            rf.setItemNro(nu);
            rf.setIva(r.getIva());
            rf.setIva0(0.0);
            rf.setIva27(0.0);
            rf.setIva10_5(0.0);
            rf.setIvaVentas(iv2);
            rf.setNoGravado(0.0);
            rf.setProducto(r.getProducto());
            rf.setSugerido(r.getSugerido());
            rf.setTotal(r.getTotal());
            if (r.getCostoG() != null) {
                rf.setCostoG(r.getCostoG());
            } else {
                rf.setCostoG(0.0);
            }
            if (r.getCostoI() != null) {
                rf.setCostoI(r.getCostoI());
            } else {
                rf.setCostoI(0.0);
            }
            try {
                new RenglonFacturaService().saveRenglon(rf);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
                    config.setNumeroNotaCreditoB(numf);
                    config.setUltimaFecha(fws);
                    try {
                        new ConfiguracionService().updateConfiguracion(config);
                    } catch (Exception ex) {
                        Logger.getLogger(FacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
//            Producto pro1 = r.getProducto();
//            Float fl = pro1.getStock();
//            fl += r.getCantidad();
//            pro1.setStock(fl);
//            try {
//                new ProductoService().updateProducto(pro1);
//            } catch (Exception ex) {
//                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
//        JOptionPane.showMessageDialog(this, "NOTA DE CREDITO GENERADA CORRECTAMENTE");
//        limpiarCampos();
    }

    private void solicitarNuevoTicket() {
        wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
        System.out.println("autenticar");
        Dispatch.call(wsaa, "Autenticar",
                new Variant("wsfe"),
                new Variant(userdir + "/JONI_2024_22d9a5cec0ec4972.crt"),
                new Variant(userdir + "/clave_privada_20300377425_202404201217.key"),
                //                new Variant("c:/ventasF/crt/fernando2023_3c09a0deb45cc8fa.crt"),
                //                new Variant("c:/ventasF/crt/clave_privada_20250844922_202304144101.key"),
                new Variant(wsdl));
        System.out.println("autenticado");
        String excepcion = Dispatch.get(wsaa, "Excepcion").toString();
        token = Dispatch.get(wsaa, "Token").toString();
        sign = Dispatch.get(wsaa, "Sign").toString();
        System.out.println(token);
        System.out.println(sign);
        tkt.setFecha(fecha);
        tkt.setHora(hora);
        tkt.setMinuto(minutos);
        tkt.setSegundo(segundos);
        try {
            new TicketTimeService().updateTicket(tkt);
        } catch (Exception ex) {
            Logger.getLogger(FacturarFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo guardar nuevo Ticket");
        }
    }
}
