package com.ventas.frame;

import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import com.ventas.main.MainFrame;
import com.ventas.services.FacturaCompraReferenciaMercadoPagoService;
import com.ventas.util.UtilFrame;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class FacturasDeMercadoPagoFrame extends javax.swing.JFrame {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
    private final DecimalFormat df = new DecimalFormat("#0.00");
    private List<IvaVentas> ivaVentas;
    private Date a;
    private Date d;
    private Integer r;

    /**
     * @param facturas
     * @param d
     * @param a
     * @param r
     */
    public FacturasDeMercadoPagoFrame(List<IvaVentas> facturas, Date d, Date a, Integer r) {
        initComponents();

        this.d = d;
        this.a = a;
        this.r = r;
        this.ivaVentas = facturas;
        limpiarCampos();
        if (r != null) {
            this.d = d;
            this.a = a;
            this.r = r;
            deTxt.setText(sdf.format(d));
            alTxt.setText(sdf.format(a));
            buscar();
            Rectangle rect = tabla.getCellRect(r - 1, 0, true);
            tabla.scrollRectToVisible(rect);
            tabla.clearSelection();
            tabla.setRowSelectionInterval(r - 1, r - 1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        verFacturaBtn = new javax.swing.JButton();
        excelBtn = new javax.swing.JButton();
        filtroTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        operacionTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FACTURAS DE VENTA CORRESPONDIENTES A TRANSFERENCIAS DE MERCADO PAGO");

        jLabel1.setText("DESDE:");

        jLabel2.setText("HASTA:");

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

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FECHA", "CUIT", "NOMBRE", "IMPORTE", "ORIGEN", "OPERACION", "_", "FECHA FC", "NRO.FC", "GRAVADO", "IVA", "IMPUESTO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("<<< FECHAS DE FACTURAS");

        verFacturaBtn.setText("VER FACTURA");
        verFacturaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFacturaBtnActionPerformed(evt);
            }
        });

        excelBtn.setText("EXCEL");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        filtroTxt.setText("FILTRO");
        filtroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtroTxtKeyPressed(evt);
            }
        });

        jLabel4.setText("Operación:");

        operacionTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        operacionTxt.setText("OPERACION");
        operacionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                operacionTxtKeyPressed(evt);
            }
        });

        jLabel5.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(verFacturaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(excelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(operacionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(verFacturaBtn)
                    .addComponent(excelBtn)
                    .addComponent(jLabel4)
                    .addComponent(operacionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volverBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

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
                buscar();
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

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        excel();
    }//GEN-LAST:event_excelBtnActionPerformed

    private void verFacturaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFacturaBtnActionPerformed
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UNA FACTURA PARA VER DETALLE");
            return;
        }
        IvaVentas iv = ivaVentas.get(row);
        Date de = new Date();
        Date al = new Date();
        try {
            de = sdf.parse(deTxt.getText());
            al = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 258 - FECHA");
            return;
        }
        VerComprobanteFrame vcf = new VerComprobanteFrame(ivaVentas, iv, de, al, row, 2);
        vcf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_verFacturaBtnActionPerformed

    private void operacionTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_operacionTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            buscarPorOperacion();
        }
    }//GEN-LAST:event_operacionTxtKeyPressed

    private void filtroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            buscarPorFiltro();
        }
    }//GEN-LAST:event_filtroTxtKeyPressed

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
            java.util.logging.Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturasDeMercadoPagoFrame(null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JTextField deTxt;
    private javax.swing.JButton excelBtn;
    private javax.swing.JTextField filtroTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField operacionTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JButton verFacturaBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        //this.setExtendedState(6);
        this.setExtendedState(6); // this.MAXIMIZED_BOTH
        deTxt.setText("");
        alTxt.setText("");
        filtroTxt.setText("");
        operacionTxt.setText("");
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void buscar() {
        UtilFrame.limpiarTabla(tabla);
        if (!deTxt.getText().isEmpty()) {
            if (!alTxt.getText().isEmpty()) {
                Date de, al = new Date();
                try {
                    de = sdf.parse(deTxt.getText());
                    al = sdf.parse(alTxt.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
                    return;
                }
                List<FacturaCompraReferenciaMercadoPago> facturas;
                try {
                    facturas = new FacturaCompraReferenciaMercadoPagoService().getFacturasIvaVentasEntreFechas(de, al);
                } catch (Exception ex) {
                    Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                ivaVentas = new ArrayList<>();
                llenarTabla(facturas);
            }
        }
    }

    private void excel() {
        String fech = sdf2.format(new Date());
        String rutaArchivo = "d:/ventasJo/data/excel/facturas_MP_" + fech + ".xls";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "ERROR Nro. 417");
            return;
        }
        WritableWorkbook libro = null;
        try {
            libro = Workbook.createWorkbook(archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "ERROR Nro. 427");
            return;
        }
        WritableSheet hoja1 = libro.createSheet("FACTURAS MP", 0);
        try {
            hoja1.addCell(new jxl.write.Label(0, 0, "BELSITO JONATHAN MAXIMILIANO"));
            hoja1.addCell(new jxl.write.Label(0, 1, "FECHA MP"));
            hoja1.addCell(new jxl.write.Label(1, 1, "RAZON SOCIAL"));
            hoja1.addCell(new jxl.write.Label(2, 1, "CUIT"));
            hoja1.addCell(new jxl.write.Label(3, 1, "IMPORTE MP"));
            hoja1.addCell(new jxl.write.Label(4, 1, "FECHA FC"));
            hoja1.addCell(new jxl.write.Label(5, 1, "NUMERO FC"));
            hoja1.addCell(new jxl.write.Label(6, 1, "NETO GRAVADO"));
            hoja1.addCell(new jxl.write.Label(7, 1, "IVA"));
            hoja1.addCell(new jxl.write.Label(8, 1, "IMPUESTO"));
            hoja1.addCell(new jxl.write.Label(9, 1, "TOTAL"));
            hoja1.addCell(new jxl.write.Label(10, 1, "ORIGEN"));
            int y = 2;
            Double tgG = 0.0;
            Double tgIv = 0.0;
            Double tgIm = 0.0;
            Double tgTt = 0.0;
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (IvaVentas i : ivaVentas) {
                String nroFc = i.getLetra() + " " + i.getNumeroSucursal() + "-" + i.getNumeroFactura();
                tgG += i.getGravado();
                tgIm += i.getImpuesto();
                tgIv += i.getIva();
                tgTt += i.getTotal();
                if (!tbl.getValueAt(y - 2, 0).toString().isEmpty()) {
                    String fechaMp = tbl.getValueAt(y - 2, 0).toString();

                    Double importeMp = Double.valueOf(tbl.getValueAt(y - 2, 0).toString());
                    hoja1.addCell(new jxl.write.Label(0, y, fechaMp));
                    hoja1.addCell(new jxl.write.Label(1, y, i.getCliente().getRazonSocial()));
                    hoja1.addCell(new jxl.write.Label(2, y, i.getCliente().getCuit()));
                    hoja1.addCell(new jxl.write.Number(3, y, importeMp));
                    if (!tbl.getValueAt(y - 2, 10).toString().isEmpty()) {
                        String origen = tbl.getValueAt(y - 2, 10).toString();
                        hoja1.addCell(new jxl.write.Label(10, y, origen));
                    }
                }
                hoja1.addCell(new jxl.write.Label(4, y, sdf.format(i.getFecha())));
                hoja1.addCell(new jxl.write.Label(5, y, nroFc));
                hoja1.addCell(new jxl.write.Number(6, y, i.getGravado()));
                hoja1.addCell(new jxl.write.Number(7, y, i.getIva()));
                hoja1.addCell(new jxl.write.Number(8, y, i.getImpuesto()));
                hoja1.addCell(new jxl.write.Number(9, y, i.getTotal()));
            }
            hoja1.addCell(new jxl.write.Label(1, y + 1, "TOTALES"));
            hoja1.addCell(new jxl.write.Number(6, y + 1, tgG));
            hoja1.addCell(new jxl.write.Number(7, y + 1, tgIv));
            hoja1.addCell(new jxl.write.Number(8, y + 1, tgIm));
            hoja1.addCell(new jxl.write.Number(9, y + 1, tgTt));

        } catch (WriteException ex) {
            JOptionPane.showMessageDialog(this, "Error configurando Excel");
        }
        try {
            libro.write();
            libro.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: 483");
            return;
        } catch (WriteException ex) {
            JOptionPane.showMessageDialog(this, "Error: 484");
            return;
        }
        JOptionPane.showMessageDialog(this, "Excel creado correctamente");
        JOptionPane.showMessageDialog(this, "LO ENCUENTRA EN d:/ventasJo/data/excel/facturas_MP");
    }

    private void buscarPorOperacion() {
        if (!operacionTxt.getText().isEmpty()) {
            String operacion = operacionTxt.getText();
            UtilFrame.limpiarTabla(tabla);
            if (!deTxt.getText().isEmpty()) {
                if (!alTxt.getText().isEmpty()) {
                    Date de, al;
                    try {
                        de = sdf.parse(deTxt.getText());
                        al = sdf.parse(alTxt.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
                        return;
                    }
                    List<FacturaCompraReferenciaMercadoPago> facturas;
                    try {
                        facturas = new FacturaCompraReferenciaMercadoPagoService().getFacturasIvaVentasEntreFechasAndOperacion(de, al, operacion);
                    } catch (Exception ex) {
                        Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
                        return;
                    }
                    
                    llenarTabla(facturas);
                }
            }
        }
    }

    private void buscarPorFiltro() {
        if (!filtroTxt.getText().isEmpty()) {
            String filtro = filtroTxt.getText();
            UtilFrame.limpiarTabla(tabla);
            if (!deTxt.getText().isEmpty()) {
                if (!alTxt.getText().isEmpty()) {
                    Date de, al;
                    try {
                        de = sdf.parse(deTxt.getText());
                        al = sdf.parse(alTxt.getText());
                    } catch (ParseException ex) {
                        Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
                        return;
                    }
                    List<FacturaCompraReferenciaMercadoPago> facturas;
                    try {
                        facturas = new FacturaCompraReferenciaMercadoPagoService()
                                .getFacturasIvaVentasEntreFechasAndNombre(de, al, filtro);
                    } catch (Exception ex) {
                        Logger.getLogger(FacturasDeMercadoPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
                        return;
                    }
                    llenarTabla(facturas);
                }
            }
        }
    }

    private void llenarTabla(List<FacturaCompraReferenciaMercadoPago> facturas) {
        UtilFrame.limpiarTabla(tabla);
        ivaVentas = new ArrayList<>();
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        for (FacturaCompraReferenciaMercadoPago fcrmp : facturas) {
            IvaVentas iv = fcrmp.getIvaVentas();
            ivaVentas.add(iv);
            String fechaMP = fcrmp.getCompraClienteMercadoPago().getFecha();
            Date fechaFcVenta = iv.getFecha();
            String nroFc = iv.getLetra() + " " + iv.getNumeroSucursal() + "-" + iv.getNumeroFactura();
            Double gravado = iv.getGravado();
            Double impuesto = iv.getImpuesto();
            Double iva21 = iv.getIva();
            Double totalFc = iv.getTotal();
            String origen = fcrmp.getCompraClienteMercadoPago().getOrigen();
            String operacion = fcrmp.getCompraClienteMercadoPago().getOperacion();
            Object o[] = new Object[13];
            o[0] = fechaMP;
            o[1] = iv.getCuitCliente();
            o[2] = iv.getRazonSocialCliente();
            o[3] = df.format(fcrmp.getCompraClienteMercadoPago().getImporte());
            o[4] = origen;
            o[5] = operacion;
            o[6] = " ";
            o[7] = sdf.format(fechaFcVenta);
            o[8] = nroFc;
            o[9] = df.format(gravado);
            o[10] = df.format(impuesto);
            o[11] = df.format(iva21);
            o[12] = df.format(totalFc);
            tbl.addRow(o);
        }
        tabla.setModel(tbl);
    }
}
