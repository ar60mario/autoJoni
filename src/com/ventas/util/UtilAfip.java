/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.entities.TicketTime;
import com.ventas.services.TicketTimeService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.rint;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author argia
 */
public class UtilAfip {

    private static ActiveXComponent wsaa;
    private static String token;
    private static String sign;
    private static String wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
    private static TicketTime tkt = null;
    private static DecimalFormat df = new DecimalFormat("#0.00");
    private static DecimalFormat dfs = new DecimalFormat("0000");
    private static DecimalFormat dfn = new DecimalFormat("00000000");
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static FacturaIvaIntercambio presentarAfip(String cuitTitular, String tipoDocTit,
            String cuitCliente, String tipoDocCli, Double gravado, Double impuesto,
            Double iva, Double total, Date fechaFactura, String pto_vta) {
        FacturaIvaIntercambio fii = new FacturaIvaIntercambio();
        if (validar(cuitTitular, tipoDocTit, cuitCliente, tipoDocCli, gravado, impuesto,
                iva, total, fechaFactura)) {

            if (verificarToken()) {
//                System.out.println("aqui");
//                System.exit(0);
                try {
                    ActiveXComponent wsfev1 = new ActiveXComponent("WSFEv1");
                    Dispatch.put(wsfev1, "Cuit", new Variant(cuitTitular));//20249273253
                    Dispatch.put(wsfev1, "Token", new Variant(token));
                    Dispatch.put(wsfev1, "Sign", new Variant(sign));
                    String cache = "";
                    wsdl = "https://servicios1.afip.gov.ar/wsfev1/service.asmx?WSDL";
                    Dispatch.call(wsfev1, "Conectar",
                            new Variant(cache),
                            new Variant(wsdl)
                    );
                    String tipo_cbte = "6";
                    String letra = "B";
//                    tipoComprob = tipo_cbte;

                    String puntoVenta = "000" + pto_vta;
                    Integer punto_venta = Integer.valueOf(puntoVenta);
                    Variant ult = Dispatch.call(wsfev1, "CompUltimoAutorizado",
                            new Variant(tipo_cbte),
                            new Variant(puntoVenta));
                    String excepcion = Dispatch.get(wsfev1, "Excepcion").toString();
//                        System.out.println(wsfev1);
//                        //JOptionPane.showMessageDialog(this, "Ult.Comprb." + ult.toString());
//                        System.out.println("Ult.Comprb." + ult.toString());
//                    Integer numf = Integer.valueOf(ult.toString());
//                    Integer comprobanteNumero = Integer.parseInt(ult.toString());
//                    if (numf != comprobanteNumero) {
//                        JOptionPane.showMessageDialog(null, "No coinciden los numeros");
//                        return;
//                    }
//                        System.out.println(numf);
//                        System.exit(0);
                    String fechaWs = new SimpleDateFormat("yyyyMMdd").format(fechaFactura);
                    String concepto = "1";// producto 
//                    String cui = cli.getCuit();
                    String cuit1 = cuitCliente; //cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
                    String tipoD = String.valueOf(tipoDocCli); //cli.getTipo()
                    String tipo_doc = tipoD, nro_doc = cuit1; //tipo y numero
                    int cbte_nro = Integer.parseInt(ult.toString()) + 1,
                            cbt_desde = cbte_nro,
                            cbt_hasta = cbte_nro;
//                    numeroFacturaPapel = String.valueOf(cbte_nro);
//                    numf = cbte_nro;
//                    comprobanteNumero = cbte_nro;
//                    int largo = ("00000000" + numeroFacturaPapel).length();
//                    numeroFacturaPapel = ("00000000" + numeroFacturaPapel).substring(largo - 8, largo);
                    Double importeAbono = total; //100.50 f.getTotal()
                    String imp_total = df.format(importeAbono).replaceAll("\\,", "\\.");//"124.00";
                    String imp_tot_conc = "0.00";
                    String imp_neto = df.format(gravado).toString().replaceAll("\\,", "\\.");
                    String imp_iva = df.format(iva).toString().replaceAll("\\,", "\\.");
//                    int internos = (int) rint(f.getImpuesto() * 100);
                    String imp_trib = "", imp_op_ex = "0";
//                    if (internos > 0) {
                    imp_trib = df.format(impuesto).replaceAll("\\,", "\\.");
//                    } else {
//                        imp_trib = "0.00";
//                    }
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
                        if (impuesto > 0) {
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
                            JOptionPane.showMessageDialog(null, "Obs: " + obs + "\nError: " + errmsg);
                            return null;
                        }
                        Date vencimCae;
                        String vencCae = "";
                        if (vto != "" && vto != null) {
//                            Date caeVencim = sd.parse(vto);
                            vencCae = vto.substring(6, 8) + "/" + vto.substring(4, 6) + "/" + vto.substring(0, 4);
                        }
                        System.out.println(vencCae);
                        vencimCae = sdf.parse(vencCae);
                        System.out.println(vencimCae);
                        Long caeLong = Long.valueOf(cae.toString());
                        String ruta1 = Constantes.ruta
                                + tipo_cbte
                                + letra
                                + "-0010-"
                                + dfn.format(cbte_nro) + ".xm1";
                        String ruta2 = Constantes.ruta
                                + tipo_cbte
                                + letra
                                + "-0010-"
                                + dfn.format(cbte_nro) + ".xm2";
                        System.out.println(ruta1);
                        System.out.println(ruta2);
                        File archivo1 = new File(ruta1);
                        File archivo2 = new File(ruta2);
                        BufferedWriter bw1, bw2;
                        bw1 = new BufferedWriter(new FileWriter(archivo1));
                        bw2 = new BufferedWriter(new FileWriter(archivo2));
                        bw1.write(requ);
                        bw2.write(resp);
                        bw1.close();
                        bw2.close();
                        fii.setCae(caeLong);
                        fii.setEstado(resultado);
                        fii.setFecha(fechaFactura);
                        fii.setFechaVencimientoCae(vencimCae);
                        fii.setLetra(letra);
                        fii.setNumero(cbte_nro);
                        fii.setSucursal(punto_venta);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
//                        e.printStackTrace();
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
        return fii;
    }

    private static boolean validar(String cuitTitular, String tipoDocTit, String cuitCliente,
            String tipoDocCli, Double gravado, Double impuesto, Double iva, Double total,
            Date fechaFactura) {
        if (cuitTitular.isEmpty()) {
            return false;
        }
        if (tipoDocTit.isEmpty()) {
            return false;
        }
        if (cuitCliente.isEmpty()) {
            return false;
        }
        if (tipoDocCli.isEmpty()) {
            return false;
        }
        if (gravado < 0.01) {
            return false;
        }
        if (impuesto < 0.01) {
            return false;
        }
        if (iva < 0.01) {
            return false;
        }
        if (total < 0.01) {
            return false;
        }
        Date hoy = new Date();
        if (hoy.before(fechaFactura)) {
            return false;
        }
        return true;
    }

    private static boolean verificarToken() {
        Date fecha;
        try {
            LibraryLoader.loadJacobLibrary();
            wsaa = new ActiveXComponent("WSAA");
            System.out.println(Dispatch.get(wsaa, "InstallDir").toString()
                    + " "
                    + Dispatch.get(wsaa, "Version").toString()
            );
            Calendar cal = Calendar.getInstance();
//            String cuitTitular = Constantes.cuitTitular;
            fecha = cal.getTime();
            int hora = cal.get(Calendar.HOUR_OF_DAY);
            int minutos = cal.get(Calendar.MINUTE);
            int segundos = cal.get(Calendar.SECOND);
            tkt = new TicketTimeService().getTicketById(1L);
            if (fecha != tkt.getFecha()) {
                solicitarNuevoTicket(fecha, hora, minutos, segundos);
            } else if (hora != tkt.getHora()) {
                if (hora == tkt.getHora() + 1) {
                    if (minutos > tkt.getMinuto()) {
                        solicitarNuevoTicket(fecha, hora, minutos, segundos);
                    } else {
                        int xMinuto = 60 - tkt.getMinuto();
                        if ((xMinuto + minutos) > 30) {
                            solicitarNuevoTicket(fecha, hora, minutos, segundos);
                        }
                    }
                } else {
                    solicitarNuevoTicket(fecha, hora, minutos, segundos);
                }
            } else if (minutos - tkt.getMinuto() > 30) {
                solicitarNuevoTicket(fecha, hora, minutos, segundos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
//                        e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void solicitarNuevoTicket(Date fecha, Integer hora, Integer minutos,
            Integer segundos) {
        String certif = Constantes.certif;
        String llave = Constantes.llave;
        wsdl = "https://wsaa.afip.gov.ar/ws/services/LoginCms";
        Dispatch.call(wsaa, "Autenticar",
                new Variant("wsfe"),
                new Variant(Constantes.userdir + certif),
                new Variant(Constantes.userdir + llave),
                new Variant(wsdl));
        String excepcion = Dispatch.get(wsaa, "Excepcion").toString();
        token = Dispatch.get(wsaa, "Token").toString();
        sign = Dispatch.get(wsaa, "Sign").toString();
        tkt.setFecha(fecha);
        tkt.setHora(hora);
        tkt.setMinuto(minutos);
        tkt.setSegundo(segundos);
        tkt.setSign(sign);
        tkt.setToken(token);
        try {
            new TicketTimeService().updateTicket(tkt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar nuevo Ticket");
        }
//        System.out.println(token);
//        System.out.println(sign);
//        System.exit(0);
    }
}
