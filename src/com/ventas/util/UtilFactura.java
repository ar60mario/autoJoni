/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.util;

import com.ventas.entities.CalculoFactura;
import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.Configuracion;
import com.ventas.entities.Domicilio;
import com.ventas.entities.FacturaCompra;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.services.ClienteService;
import com.ventas.services.CompraClienteMercadoPagoService;
import com.ventas.services.ComprobanteVentaMercadoPagoService;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.FacturaCompraService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author argia
 */
public class UtilFactura {

    public static CalculoFactura calcularTotales(FacturaCompra fc, CompraClienteMercadoPago ccmp) {
        Long id_config = 1L;
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();
            DecimalFormat df = new DecimalFormat("#0.00");
            CalculoFactura cf = new CalculoFactura();
            Double totalVenta = fc.getTotalVenta();
//            Double saldoFacturaParaMercadoPago = fc.getTotal() - fc.getTotalUtilizado() - fc.getTotalTemp();
//            String saldoFacturaParaMercadoPagoString = df.format(saldoFacturaParaMercadoPago);
//            Double saldoFacturaParaMercadoPagoRedondeado = Double.valueOf(saldoFacturaParaMercadoPagoString.replace(",", "."));
            Double impuestoVenta = fc.getImpuestoVenta();
            Double totalMercadoPago = ccmp.getImporte();
//            if (saldoFacturaParaMercadoPagoRedondeado >= totalMercadoPago) {
            Double porcentajeCalculo = impuestoVenta / totalVenta;
            Double impuestoCalculado = totalMercadoPago * porcentajeCalculo;
            String impuestoVentaString = df.format(impuestoCalculado);
            Double impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));

            Double brutoCalculado = totalMercadoPago - impuestoRedondeado;
            String brutoCalculadoString = df.format(brutoCalculado);
            Double brutoCalculadoRedondeado = Double.valueOf(brutoCalculadoString.replace(",", "."));

            Double gravadoCalculado = brutoCalculadoRedondeado / (1 + porcIva / 100);
            String gravadoCalculadoString = df.format(gravadoCalculado);
            Double gravadoCalculadoRedondeado = Double.valueOf(gravadoCalculadoString.replace(",", "."));

            Double ivaCalculado = gravadoCalculadoRedondeado * (porcIva / 100);
//                System.out.println(ivaCalculado);
            String ivaCalculadoString = df.format(ivaCalculado);
//                System.out.println(ivaCalculadoString);
            Double ivaCalculadoRedondeado = Double.valueOf(ivaCalculadoString.replace(",", "."));
//                System.out.println(ivaCalculadoRedondeado);

            cf.setGravado(gravadoCalculadoRedondeado);
            cf.setImpuesto(impuestoRedondeado);
            cf.setIva(ivaCalculadoRedondeado);
            cf.setTotal(totalMercadoPago);

            Double t1 = totalMercadoPago;
            Double t2 = gravadoCalculadoRedondeado
                    + impuestoRedondeado
                    + ivaCalculadoRedondeado;
            String t2String = df.format(t2);
            Double t2Redondeado = Double.valueOf(t2String.replace(",", "."));
//                System.out.println(t1);
//                System.out.println(t2Redondeado);
//
//                JOptionPane.showMessageDialog(null, "VER");

            if (!df.format(t1).equals(df.format(t2Redondeado))) {
                if (t1 > t2Redondeado) {
                    impuestoCalculado = impuestoRedondeado + .01;
                } else {
                    impuestoCalculado = impuestoRedondeado - .01;
                }
                impuestoVentaString = df.format(impuestoCalculado);
                impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
                cf.setImpuesto(impuestoRedondeado);
                t2 = gravadoCalculadoRedondeado
                        + impuestoRedondeado
                        + ivaCalculadoRedondeado;
                t2String = df.format(t2);
                t2Redondeado = Double.valueOf(t2String.replace(",", "."));
            }
            cf.setTotalMp(t2Redondeado);
//            }
            return cf;
        }
        return null;
    }

    public static CalculoFactura calcularTotales2(FacturaCompra fc, CompraClienteMercadoPago ccmp) {
        Long id_config = 1L;
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();

            DecimalFormat df = new DecimalFormat("#0.00");
            CalculoFactura cf = new CalculoFactura();

            Double gravadoCalculado = fc.getGravadoVenta() - fc.getGravadoUtilizado();
            String gravadoCalculadoString = df.format(gravadoCalculado);
            Double gravadoCalculadoRedondeado = Double.valueOf(gravadoCalculadoString.replace(",", "."));
            cf.setGravado(gravadoCalculadoRedondeado);

            Double impuestoCalculado = fc.getImpuestoVenta() - fc.getImpuestoUtilizado();
            String impuestoVentaString = df.format(impuestoCalculado);
            Double impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
            cf.setImpuesto(impuestoRedondeado);

            Double ivaCalculado = gravadoCalculadoRedondeado * (porcIva / 100);
            String ivaCalculadoString = df.format(ivaCalculado);
            Double ivaCalculadoRedondeado = Double.valueOf(ivaCalculadoString.replace(",", "."));
            cf.setIva(ivaCalculadoRedondeado);

            Double t1 = fc.getTotalVenta() - fc.getTotalUtilizado();
            String t1String = df.format(t1);
            Double t1Redondeado = Double.valueOf(t1String.replace(",", "."));

            Double t2 = gravadoCalculadoRedondeado
                    + impuestoRedondeado
                    + ivaCalculadoRedondeado;
            String t2String = df.format(t2);
            Double t2Redondeado = Double.valueOf(t2String.replace(",", "."));

            if (!df.format(t1).equals(df.format(t2Redondeado))) {
                if (t1Redondeado > t2Redondeado) {
                    impuestoCalculado = impuestoRedondeado + .01;
                } else {
                    impuestoCalculado = impuestoRedondeado - .01;
                }
                impuestoVentaString = df.format(impuestoCalculado);
                impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
                cf.setImpuesto(impuestoRedondeado);
                t2 = gravadoCalculadoRedondeado
                        + impuestoRedondeado
                        + ivaCalculadoRedondeado;
                t2String = df.format(t2);
                t2Redondeado = Double.valueOf(t2String.replace(",", "."));
            }

            cf.setTotalMp(t2Redondeado);
            cf.setTotal(t1Redondeado);

            return cf;
        }
        return null;
    }

    public static CalculoFactura calcularTotales3(FacturaCompra fc, CompraClienteMercadoPago ccmp) {
//        IMPORTES IGUALES
        Long id_config = 1L;
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();
            DecimalFormat df = new DecimalFormat("#0.00");
            CalculoFactura cf = new CalculoFactura();

            Double gravadoCalculado = fc.getGravadoVenta() - fc.getGravadoUtilizado();
            String gravadoCalculadoString = df.format(gravadoCalculado);
            Double gravadoCalculadoRedondeado = Double.valueOf(gravadoCalculadoString.replace(",", "."));
            cf.setGravado(gravadoCalculadoRedondeado);

            Double impuestoCalculado = fc.getImpuestoVenta() - fc.getImpuestoUtilizado();
            String impuestoCalculadoString = df.format(impuestoCalculado);
            Double impuestoCalculadoRedondeado = Double.valueOf(impuestoCalculadoString.replace(",", "."));
            cf.setImpuesto(impuestoCalculadoRedondeado);

            Double ivaCalculado = gravadoCalculadoRedondeado * (porcIva / 100);
            String ivaCalculadoString = df.format(ivaCalculado);
            Double ivaCalculadoRedondeado = Double.valueOf(ivaCalculadoString.replace(",", "."));
            cf.setIva(ivaCalculadoRedondeado);

            Double totalFacturaParaMercadoPago = fc.getTotalVenta() - fc.getTotalUtilizado();
            String totalFacturaParaMercadoPagoString = df.format(totalFacturaParaMercadoPago);
            Double totalFacturaParaMercadoPagoRedondeado = Double.valueOf(totalFacturaParaMercadoPagoString
                    .replace(",", "."));
//            cf.setTotal(totalFacturaParaMercadoPagoRedondeado);
//            cf.setTotalMp(totalFacturaParaMercadoPagoRedondeado);

            Double t1 = totalFacturaParaMercadoPagoRedondeado;
            String t1String = df.format(t1);
            Double t1Redondeado = Double.valueOf(t1String.replace(",", "."));
            Double t2 = gravadoCalculadoRedondeado
                    + impuestoCalculadoRedondeado
                    + ivaCalculadoRedondeado;
            String t2String = df.format(t2);
            Double t2Redondeado = Double.valueOf(t2String.replace(",", "."));

            if (!df.format(t1Redondeado).equals(df.format(t2Redondeado))) {
                if (t1Redondeado > t2Redondeado) {
                    impuestoCalculado = impuestoCalculadoRedondeado + .01;
                } else {
                    impuestoCalculado = impuestoCalculadoRedondeado - .01;
                }
                String impuestoVentaString = df.format(impuestoCalculado);
                Double impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
                cf.setImpuesto(impuestoRedondeado);
                t2 = gravadoCalculadoRedondeado
                        + impuestoRedondeado
                        + ivaCalculadoRedondeado;
                t2String = df.format(t2);
                t2Redondeado = Double.valueOf(t2String.replace(",", "."));
            }
            cf.setTotal(t1Redondeado);
            cf.setTotalMp(t2Redondeado);

            return cf;
        }
        return null;
    }

    public static void grabarComprobanteCompleto(CalculoFactura cf,
            CompraClienteMercadoPago compraMercadoPago, FacturaCompra facturaCompra,
            FacturaIvaIntercambio fii, FacturaCompraReferenciaMercadoPago fcrmp) {
        Cliente cliente = null; // = new Cliente();;
        Domicilio dm; // = new Domicilio();
        Boolean nuevo = true;
        try {
            cliente = new ClienteService().getClienteByCodigo(compraMercadoPago.getCuit());
            if (cliente != null) {
                nuevo = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR GRABANDO CLIENTE NUEVO");
            return;
        }
        if (nuevo) {
            cliente = new Cliente();
            dm = new Domicilio();
            cliente.setCuit(compraMercadoPago.getCuit());
            cliente.setCodigo(compraMercadoPago.getCuit());
            cliente.setCategoriaDeIva(5);
            cliente.setFormaDePago(1);
            cliente.setTieneDescuento(false);
            cliente.setDescuento(0F);
            cliente.setActivo(true);
            cliente.setSaldo(0.0);
            cliente.setTipo("86");
            cliente.setRazonSocial(compraMercadoPago.getNombre());
            dm.setCalle("COSQUIN");
            dm.setNumero("2626");
            dm.setLocalidad("LA NORIA");
            dm.setProvincia("BUENOS AIRES");
            dm.setCodigoPostal("1814");
            cliente.setDomicilio(dm);
        }

        try {
            new ComprobanteVentaMercadoPagoService().saveComprobanteCompleto(cliente, nuevo,
                    cf, compraMercadoPago, facturaCompra, fii, fcrmp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR GRABANDO COMPROBANTE NUEVO");
        }
    }
}
