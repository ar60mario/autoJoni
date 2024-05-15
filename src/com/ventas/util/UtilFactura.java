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
            Double saldoFacturaParaMercadoPago = fc.getTotal() - fc.getTotalUtilizado() - fc.getTotalTemp();
            String saldoFacturaParaMercadoPagoString = df.format(saldoFacturaParaMercadoPago);
            Double saldoFacturaParaMercadoPagoRedondeado = Double.valueOf(saldoFacturaParaMercadoPagoString.replace(",", "."));
            Double impuestoVenta = fc.getImpuestoVenta();
            Double totalMercadoPago = ccmp.getImporte();
            if (saldoFacturaParaMercadoPagoRedondeado >= totalMercadoPago) {
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
            }
            return cf;
        }
        return null;
    }

    public static void grabarComprobanteCompleto(String cuit, String nombre, Double gravado, Double iva,
            Double impuesto, Double total, Long compraMercadoPago, Long facturaCompra, FacturaIvaIntercambio fii) {
        Cliente cliente;
        Boolean nuevo = true;
        try {
            cliente = new ClienteService().getClienteByCodigo(cuit);
            if (cliente != null) {
                nuevo = false;
            }
        } catch (Exception ex) {
//            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
            cliente = new Cliente();
        }
        if(nuevo){
            cliente = new Cliente();
            cliente.setCuit(cuit);
            cliente.setCodigo(cuit);
            cliente.setCategoriaDeIva(5);
            cliente.setFormaDePago(1);
            cliente.setTieneDescuento(false);
            cliente.setDescuento(0F);
            cliente.setActivo(true);
            cliente.setSaldo(0.0);
            cliente.setTipo("80");
            cliente.setRazonSocial(nombre);
            Domicilio dm = new Domicilio();
            dm.setCalle("Cosquin");
            dm.setNumero("2626");
            dm.setLocalidad("LA NORIA");
            dm.setProvincia("BUENOS AIRES");
            dm.setCodigoPostal("1814");
            cliente.setDomicilio(dm);
        }
//        System.out.println(nuevo);
//        System.out.println(cliente);
//        System.exit(0);
        CompraClienteMercadoPago ccmp = null;
        try {
            ccmp = new CompraClienteMercadoPagoService().getComprobanteCompraClientesMercadoPago(compraMercadoPago);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        ccmp.setProcesado(true);
        FacturaCompra fc = null;
        try {
            fc = new FacturaCompraService().getFacturaCompraById(facturaCompra);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        fc.setGravadoUtilizado(fc.getGravadoUtilizado() + gravado);
        fc.setIvaUtilizado(fc.getIvaUtilizado() + iva);
        fc.setImpuestoUtilizado(fc.getImpuestoUtilizado() + impuesto);
        fc.setTotalUtilizado(fc.getTotalUtilizado() + total);
        try {
            new ComprobanteVentaMercadoPagoService().saveComprobanteCompleto(cliente, nuevo,
                    gravado, iva, impuesto, total, ccmp, fc, fii);
        } catch (Exception ex) {
            Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
