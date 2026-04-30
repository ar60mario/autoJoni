package com.ventas.util;

import com.ventas.entities.ArticuloCompra;
import com.ventas.entities.CalculoFactura;
import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.Configuracion;
import com.ventas.entities.Domicilio;
import com.ventas.entities.FacturaCompra;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.entities.Producto;
import com.ventas.entities.ProductoTop;
import com.ventas.entities.RenglonFc;
import com.ventas.entities.Rubro;
import com.ventas.services.ClienteService;
import com.ventas.services.ComprobanteVentaMercadoPagoService;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.ProductoService;
import com.ventas.services.ProductoTopService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author argia
 */
public class UtilFactura {

    private static DecimalFormat df0 = new DecimalFormat("000");
    private static DecimalFormat df = new DecimalFormat("#0.00");

    public static CalculoFactura calcularTotales(FacturaCompra fc, CompraClienteMercadoPago ccmp) {
        Long id_config = 1L;
        Configuracion cfg;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            //
            return null;
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();

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

    public static Float calcularPorcentualImpuesto(Double impuesto, Double total) {
        if (impuesto > 0.00) {
            if (total > 0.00) {
                Float porcentual;
                DecimalFormat dfp = new DecimalFormat("#0.000");
                Double porcentajeCalculo = impuesto / total;
                String porcentajeCalculoString = dfp.format(porcentajeCalculo);
                porcentual = Float.valueOf(porcentajeCalculoString.replace(",", "."));
                return porcentual;
            } else {
                return 0F;
            }
        } else {
            return 0F;
        }
    }

    public static CalculoFactura calcularTotales2(FacturaCompra fc, CompraClienteMercadoPago ccmp) {
        Long id_config = 1L;
        Configuracion cfg;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            return null;
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();

            DecimalFormat df = new DecimalFormat("#0.00");
            CalculoFactura cf = new CalculoFactura();

//            Double gravadoCalculado = fc.getGravadoVenta() - fc.getGravadoUtilizado();
//            String gravadoCalculadoString = df.format(gravadoCalculado);
//            Double gravadoCalculadoRedondeado = Double.valueOf(gravadoCalculadoString.replace(",", "."));
//            cf.setGravado(gravadoCalculadoRedondeado);
//            Double impuestoCalculado = fc.getImpuestoVenta() - fc.getImpuestoUtilizado();
//            String impuestoVentaString = df.format(impuestoCalculado);
//            Double impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
//            cf.setImpuesto(impuestoRedondeado);
//            Double ivaCalculado = gravadoCalculadoRedondeado * (porcIva / 100);
//            String ivaCalculadoString = df.format(ivaCalculado);
//            Double ivaCalculadoRedondeado = Double.valueOf(ivaCalculadoString.replace(",", "."));
//            cf.setIva(ivaCalculadoRedondeado);
//            Double t1 = fc.getTotalVenta() - fc.getTotalUtilizado();
//            String t1String = df.format(t1);
//            Double t1Redondeado = Double.valueOf(t1String.replace(",", "."));
//            Double t2 = gravadoCalculadoRedondeado
//                    + impuestoRedondeado
//                    + ivaCalculadoRedondeado;
//            String t2String = df.format(t2);
//            Double t2Redondeado = Double.valueOf(t2String.replace(",", "."));
//            if (!df.format(t1).equals(df.format(t2Redondeado))) {
//                if (t1Redondeado > t2Redondeado) {
//                    impuestoCalculado = impuestoRedondeado + .01;
//                } else {
//                    impuestoCalculado = impuestoRedondeado - .01;
//                }
//                impuestoVentaString = df.format(impuestoCalculado);
//                impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
//                cf.setImpuesto(impuestoRedondeado);
//                t2 = gravadoCalculadoRedondeado
//                        + impuestoRedondeado
//                        + ivaCalculadoRedondeado;
//                t2String = df.format(t2);
//                t2Redondeado = Double.valueOf(t2String.replace(",", "."));
//            }
//            cf.setTotalMp(t2Redondeado);
//            cf.setTotal(t1Redondeado);
            return cf;
        }
        return null;
    }

    public static CalculoFactura calcularTotales3(Double fc) {
        Long id_config = 1L;
        Configuracion cfg;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            return null;
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();

            DecimalFormat df = new DecimalFormat("#0.00");
            CalculoFactura cf = new CalculoFactura();

//            Double gravadoCalculado = fc.getGravadoVenta() - fc.getGravadoUtilizado();
//            String gravadoCalculadoString = df.format(gravadoCalculado);
//            Double gravadoCalculadoRedondeado = Double.valueOf(gravadoCalculadoString.replace(",", "."));
//            cf.setGravado(gravadoCalculadoRedondeado);
//            Double impuestoCalculado = fc.getImpuestoVenta() - fc.getImpuestoUtilizado();
//            String impuestoVentaString = df.format(impuestoCalculado);
//            Double impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
//            cf.setImpuesto(impuestoRedondeado);
//            Double ivaCalculado = gravadoCalculadoRedondeado * (porcIva / 100);
//            String ivaCalculadoString = df.format(ivaCalculado);
//            Double ivaCalculadoRedondeado = Double.valueOf(ivaCalculadoString.replace(",", "."));
//            cf.setIva(ivaCalculadoRedondeado);
//            Double t1 = fc.getTotalVenta() - fc.getTotalUtilizado();
//            String t1String = df.format(t1);
//            Double t1Redondeado = Double.valueOf(t1String.replace(",", "."));
//            Double t2 = gravadoCalculadoRedondeado
//                    + impuestoRedondeado
//                    + ivaCalculadoRedondeado;
//            String t2String = df.format(t2);
//            Double t2Redondeado = Double.valueOf(t2String.replace(",", "."));
//            if (!df.format(t1).equals(df.format(t2Redondeado))) {
//                if (t1Redondeado > t2Redondeado) {
//                    impuestoCalculado = impuestoRedondeado + .01;
//                } else {
//                    impuestoCalculado = impuestoRedondeado - .01;
//                }
//                impuestoVentaString = df.format(impuestoCalculado);
//                impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
//                cf.setImpuesto(impuestoRedondeado);
//                t2 = gravadoCalculadoRedondeado
//                        + impuestoRedondeado
//                        + ivaCalculadoRedondeado;
//                t2String = df.format(t2);
//                t2Redondeado = Double.valueOf(t2String.replace(",", "."));
//            }
//            cf.setTotalMp(t2Redondeado);
//            cf.setTotal(t1Redondeado);
            return cf;
        }
        return null;
    }

    public static CalculoFactura calcularTotalesAutomatico(Double totalGenerado, ArticuloCompra compra) {
        if (totalGenerado.equals(0.0)) {
            return null;
        }
        if (compra == null) {
            return null;
        }
        Long id_config = 1L;
        Configuracion cfg;
        Double impuestoVenta = compra.getImpuesto();
        Double totalVenta = compra.getTotal();
        Double porcentajeCalculo = impuestoVenta / totalVenta;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            return null;
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();

            CalculoFactura cf = new CalculoFactura();

            Double impuestoRedondeado = calcularRedondeo(totalGenerado * porcentajeCalculo);

            Double brutoRedondeado = calcularRedondeo(totalGenerado - impuestoRedondeado);

            Double netoRedondeado = calcularRedondeo(brutoRedondeado / (1 + porcIva / 100));

            Double ivaRedondeado = calcularRedondeo(netoRedondeado * porcIva / 100);

            Double totalRedondeado = calcularRedondeo(netoRedondeado
                    + impuestoRedondeado
                    + ivaRedondeado);

            cf.setGravado(netoRedondeado);
            cf.setImpuesto(impuestoRedondeado);
            cf.setIva(ivaRedondeado);
            cf.setTotal(totalRedondeado);
            cf.setProducto(compra.getProducto());
            cf.setArticulo(compra);

            return cf;
        }
        return null;
    }

    public static CalculoFactura calcularTotalesAutomatico2(Double totalGenerado, ArticuloCompra compra) {
        if (totalGenerado.equals(0.0)) {
            return null;
        }
        if (compra == null) {
            return null;
        }
        Float porcentual = compra.getPorcentual();
        if (porcentual == 0F) {
            return null;
        }
        Long id_config = 1L;
        Configuracion cfg;
//        Double impuestoVenta = compra.getImpuesto();
//        Double totalVenta = compra.getTotal();
        Double porcentajeCalculo = porcentual.doubleValue();
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            return null;
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();

            CalculoFactura cf = new CalculoFactura();

            Double impuestoRedondeado = calcularRedondeo(totalGenerado * porcentajeCalculo);

            Double brutoRedondeado = calcularRedondeo(totalGenerado - impuestoRedondeado);

            Double netoRedondeado = calcularRedondeo(brutoRedondeado / (1 + porcIva / 100));

            Double ivaRedondeado = calcularRedondeo(netoRedondeado * porcIva / 100);

            Double totalRedondeado = calcularRedondeo(netoRedondeado
                    + impuestoRedondeado
                    + ivaRedondeado);

            cf.setGravado(netoRedondeado);
            cf.setImpuesto(impuestoRedondeado);
            cf.setIva(ivaRedondeado);
            cf.setTotal(totalRedondeado);
            cf.setProducto(compra.getProducto());
            cf.setArticulo(compra);
            return cf;
        }
        return null;
    }

    public static List<RenglonFc> calcularTotalesAutomatico3(Double totalGenerado, Rubro rubro) {
        if (totalGenerado.equals(0.0)) {
            return null;
        }
//        System.out.println(totalGenerado);
//        System.exit(0);
        int contador1 = 0;
        int contador2 = 0;
        int contador3 = 0;
        Double cnd;
        List<RenglonFc> renglonex = new ArrayList<>();
        List<ProductoTop> pt;
        try {
            pt = new ProductoTopService().getAllProductoTabacoTopActivos9(rubro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR 341 - PRODUCTOS");
            return null;
        }
        Integer ordenMx = pt.get(0).getOrden();
        Long id_config = 1L;
        Configuracion cfg;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR 349 - CONFIGURACION");
            return null;
        }
        if (cfg != null) {
            Random can = new Random();
            cnd = can.nextDouble() * 10.0;
            Double cantidad = cnd.doubleValue();
            Float porcIva = cfg.getIva();
            RenglonFc cf = new RenglonFc();
            Random rnd = new Random();
            Float orden_pro_nuevo = (rnd.nextFloat() * ordenMx) + 1;
            String o_pro_nue = df0.format(orden_pro_nuevo);
            Integer pro_elegido = Integer.valueOf(o_pro_nue);
            ProductoTop pt1;
            System.out.println(pro_elegido);
            System.out.println(orden_pro_nuevo);
            System.out.println(ordenMx);
            System.out.println(contador1);
            contador1 += 1;

//            System.exit(0);
            try {
                pt1 = new ProductoTopService().getProductoTopByOrder2(pro_elegido);
                System.out.println(pt1);
            } catch (Exception ex) {
                System.out.println(pro_elegido);

                System.out.println(orden_pro_nuevo);
                System.out.println(ordenMx);
                System.out.println(contador1);
                Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR NRO. 366");
                return null;
            }

            Double impuesto0 = pt1.getImpuesto() * cantidad;
            Double netoGrv0 = pt1.getPrecio() * cantidad;
            Double iva0 = netoGrv0 * (1 + porcIva / 100);
            Double total0 = impuesto0 + iva0 + netoGrv0;
            Integer codigo = pt1.getCodigo();
            Producto pro;
            try {
                pro = new ProductoService().getProductoByCodigo(codigo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR Nro. 378 - PRODUCTO");
                return null;
            }
            cf.setAnulado(false);
            cf.setCantidad(cantidad.floatValue());
            cf.setGravado(netoGrv0);
            cf.setImpuesto(impuesto0);
            cf.setItemNro(1);
            cf.setIva(iva0);
            cf.setTotal(total0);
            cf.setProducto(pro);
            renglonex.add(cf);

            RenglonFc cf1 = new RenglonFc();
//            Random can1 = new Random();
//            cnd = can1.nextFloat() * 10F;
            Double cantidad1 = 10.0;//cnd.doubleValue();
            Random rnd1 = new Random();
            Float orden_pro_nuevo1 = (rnd1.nextFloat() * ordenMx) + 1;
            String o_pro_nue1 = df0.format(orden_pro_nuevo1);
            Integer pro_elegido1 = Integer.valueOf(o_pro_nue1);
            ProductoTop pt2;
            System.out.println(pro_elegido1);
            System.out.println(orden_pro_nuevo1);
            System.out.println(ordenMx);
            System.out.println(contador2);
//            System.exit(0);
            try {
                pt2 = new ProductoTopService().getProductoTopByOrder(pro_elegido1);
                contador2 += 1;
            } catch (Exception ex) {
                System.out.println(pro_elegido1);
                System.out.println(orden_pro_nuevo1);
                System.out.println(ordenMx);
                System.out.println(contador2);
                Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
//            System.exit(0);
                JOptionPane.showMessageDialog(null, "ERROR NRO. 401");
                return null;
            }
            Double impuesto1 = pt2.getImpuesto() * cantidad1;
            Double netoGrv1 = pt2.getPrecio() * cantidad1;
            Double iva1 = netoGrv1 * (1 + porcIva / 100);
            Double total1 = impuesto1 + iva1 + netoGrv1;
            Integer codigo1 = pt2.getCodigo();
            Producto pro1;
            try {
                pro1 = new ProductoService().getProductoByCodigo(codigo1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR Nro. 413 - PRODUCTO");
                return null;
            }
            cf1.setAnulado(false);
            cf1.setCantidad(cantidad1.floatValue());
            cf1.setGravado(netoGrv1);
            cf1.setImpuesto(impuesto1);
            cf1.setItemNro(2);
            cf1.setIva(iva1);
            cf1.setTotal(total1);
            cf1.setProducto(pro1);
            renglonex.add(cf1);

            RenglonFc cf3 = new RenglonFc();
//            Random can3 = new Random();
//            cnd = can3.nextFloat() * 10F;
            Double cantidad3 = 10.0;//cnd.doubleValue();
            Random rnd3 = new Random();
            Float orden_pro_nuevo3 = (rnd3.nextFloat() * ordenMx) + 1;
            String o_pro_nue3 = df0.format(orden_pro_nuevo3);
            Integer pro_elegido3 = Integer.valueOf(o_pro_nue3);
            ProductoTop pt3;
            System.out.println(orden_pro_nuevo3);
            System.out.println(pro_elegido3);
            System.out.println(ordenMx);
            System.out.println(contador3);
            try {
                pt3 = new ProductoTopService().getProductoTopByOrder(pro_elegido3);
                contador3 += 1;
            } catch (Exception ex) {
                System.out.println(orden_pro_nuevo3);
                System.out.println(pro_elegido3);
                System.out.println(ordenMx);
                System.out.println(contador3);
                Logger.getLogger(UtilFactura.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR NRO. 442");
                return null;
            }
            Double impuesto3 = pt3.getImpuesto() * cantidad3;
            Double netoGrv3 = pt3.getPrecio() * cantidad3;
            Double iva3 = netoGrv3 * (1 + porcIva / 100);
            Double total3 = impuesto3 + iva3 + netoGrv3;
            Integer codigo3 = pt3.getCodigo();
            Producto pro3;
            try {
                pro3 = new ProductoService().getProductoByCodigo(codigo3);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR Nro. 413 - PRODUCTO");
                return null;
            }
            cf3.setAnulado(false);
            cf3.setCantidad(cantidad3.floatValue());
            cf3.setGravado(netoGrv3);
            cf3.setImpuesto(impuesto3.doubleValue());
            cf3.setItemNro(3);
            cf3.setIva(iva3);
            cf3.setTotal(total3);
            cf3.setProducto(pro3);
            renglonex.add(cf3);
            return renglonex;
        }
        JOptionPane.showMessageDialog(null, "ERROR Nro. 355 - CONFIGURACION");
        return null;
    }

    public static List<RenglonFc> calcularTotalesAutomatico4(Double totalGenerado, Rubro rubro, Double minimo, Double maximo) {
        if (totalGenerado.equals(0.0)) {
            return null;
        }
        if (totalGenerado < minimo) {
            return null;
        }
        Configuracion cfg;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR 531 - COFIGURACION");
            return null;
        }
        Float porIva = cfg.getIva();
        Integer ordenMx;
        Double totalNecesario = totalGenerado;
        List<ProductoTop> p;
        try {
            p = new ProductoTopService().getAllProductoTabacoTopActivos9(rubro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR Nro. 530 - NO HAY PRODUCTOS HABILITADOS");
            return null;
        }
        ordenMx = p.get(0).getOrden();
        List<RenglonFc> renglones = new ArrayList<>();
        // aqui se generan los renglones de factura
        Boolean listo = false;
        Boolean origen = true;
        Integer itemNro = 1;
        Double sumaRenglones = 0.0;
        do {
            Random rnd = new Random();
            Float ord = rnd.nextFloat() * ordenMx + .5F;
            Integer orden = ord.intValue();
            System.out.println(orden);
            System.out.println("");
//            for (int i = 0; i < 50; i++) {
//                System.out.println(p.get(i));
//                System.out.println(p.get(i).getDetalle());
//                System.out.println(p.get(i).getImpuesto());
//                System.out.println(p.get(i).getOrden());
//            }
//            System.exit(0);
            ProductoTop pt1 = p.get(orden);
            if (!pt1.getUsado()) {
                Double precio = pt1.getPrecio();
                Double iva = precio * porIva / 100;
                Float impuesto = pt1.getImpuesto();
                Double ventaUnitario = precio + iva + impuesto;
                Double ventaFraccion = ventaUnitario * pt1.getFraccion();
                Double cant = (totalNecesario / ventaFraccion) / 5;
                if (cant < 1) {
                    if (origen) {
                        cant = 1.0;
                        origen = false;
                    } else {
                        origen = true;
                        cant = 2.0;
                    }
                }
                Integer cantidad = cant.intValue() * pt1.getFraccion();
                Double totalNeto = precio * cantidad;
                Float totalImpuesto = impuesto * cantidad;
                pt1.setStock(pt1.getStock() - cantidad);
                Double totalIva = totalNeto * porIva / 100;
                totalNeto = calcularRedondeo(totalNeto);
                totalImpuesto = calcularRedondeoF(totalImpuesto);
                totalIva = calcularRedondeo(totalIva);
                Double totalRenglon = totalNeto + totalImpuesto + totalIva;
                totalRenglon = calcularRedondeo(totalRenglon);
                if (totalRenglon > 0.0) {

                    Integer codigo = pt1.getCodigo();

                    RenglonFc rfc = new RenglonFc();
                    rfc.setAnulado(false);
                    rfc.setCodigoProducto(codigo);
                    rfc.setCantidad(cantidad.floatValue());
                    rfc.setCostoG(0.0);
                    rfc.setCostoI(0.0);
                    rfc.setDescuento(0.0);
                    rfc.setExento(0.0);
                    rfc.setFabricacion(false);
                    rfc.setGravado(totalNeto);
                    rfc.setGravado0(0.0);
                    rfc.setGravado10_5(0.0);
                    rfc.setGravado27(0.0);
                    rfc.setImpuesto(totalImpuesto.doubleValue());
                    rfc.setItemNro(itemNro);
                    rfc.setIva(totalIva);
                    rfc.setIva0(0.0);
                    rfc.setIva10_5(0.0);
                    rfc.setIva27(0.0);
                    rfc.setNoGravado(0.0);
////                    rfc.setProducto(producto);
                    rfc.setSugerido(0.0);
                    rfc.setTotal(totalRenglon);
                    renglones.add(rfc);
                    pt1.setUsado(true);
                    p.set(orden, pt1);
                    sumaRenglones += totalRenglon;
                    System.out.println("614 " + totalRenglon);
                    System.out.println("615 " + sumaRenglones);
                    if (sumaRenglones > minimo) {
                        listo = true;
                    } else {
                        if (hayMas2(p)) {
                            listo = false;
                        } else {
                            listo = true;
                        }
                    }

                } else {
                    System.out.println("calculado = o menor a 0");
                }
                System.out.println("629 " + totalRenglon);
            } else {
                System.out.println("USADO");
            }

            System.out.println("634 " + sumaRenglones);
//            JOptionPane.showMessageDialog(null, "VER");
        } while (!listo);
        // fin de aqui se generan los renglones de factura
        return renglones;
    }

    public static CalculoFactura calcularTotales3(FacturaCompra fc, CompraClienteMercadoPago ccmp) {
//        IMPORTES IGUALES
        Long id_config = 1L;
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(id_config);
        } catch (Exception ex) {
            return null;
        }
        if (cfg != null) {
            Float porcIva = cfg.getIva();
            DecimalFormat df = new DecimalFormat("#0.00");
            CalculoFactura cf = new CalculoFactura();

//            Double gravadoCalculado = fc.getGravadoVenta() - fc.getGravadoUtilizado();
//            String gravadoCalculadoString = df.format(gravadoCalculado);
//            Double gravadoCalculadoRedondeado = Double.valueOf(gravadoCalculadoString.replace(",", "."));
//            cf.setGravado(gravadoCalculadoRedondeado);
//            Double impuestoCalculado = fc.getImpuestoVenta() - fc.getImpuestoUtilizado();
//            String impuestoCalculadoString = df.format(impuestoCalculado);
//            Double impuestoCalculadoRedondeado = Double.valueOf(impuestoCalculadoString.replace(",", "."));
//            cf.setImpuesto(impuestoCalculadoRedondeado);
//            Double ivaCalculado = gravadoCalculadoRedondeado * (porcIva / 100);
//            String ivaCalculadoString = df.format(ivaCalculado);
//            Double ivaCalculadoRedondeado = Double.valueOf(ivaCalculadoString.replace(",", "."));
//            cf.setIva(ivaCalculadoRedondeado);
//            Double totalFacturaParaMercadoPago = fc.getTotalVenta() - fc.getTotalUtilizado();
//            String totalFacturaParaMercadoPagoString = df.format(totalFacturaParaMercadoPago);
//            Double totalFacturaParaMercadoPagoRedondeado = Double.valueOf(totalFacturaParaMercadoPagoString
//                    .replace(",", "."));
//            cf.setTotal(totalFacturaParaMercadoPagoRedondeado);
//            cf.setTotalMp(totalFacturaParaMercadoPagoRedondeado);
//            Double t1 = totalFacturaParaMercadoPagoRedondeado;
//            String t1String = df.format(t1);
//            Double t1Redondeado = Double.valueOf(t1String.replace(",", "."));
//            Double t2 = gravadoCalculadoRedondeado
//                    + impuestoCalculadoRedondeado
//                    + ivaCalculadoRedondeado;
//            String t2String = df.format(t2);
//            Double t2Redondeado = Double.valueOf(t2String.replace(",", "."));
//
//            if (!df.format(t1Redondeado).equals(df.format(t2Redondeado))) {
//                if (t1Redondeado > t2Redondeado) {
//                    impuestoCalculado = impuestoCalculadoRedondeado + .01;
//                } else {
//                    impuestoCalculado = impuestoCalculadoRedondeado - .01;
//                }
//                String impuestoVentaString = df.format(impuestoCalculado);
//                Double impuestoRedondeado = Double.valueOf(impuestoVentaString.replace(",", "."));
//                cf.setImpuesto(impuestoRedondeado);
//                t2 = gravadoCalculadoRedondeado
//                        + impuestoRedondeado
//                        + ivaCalculadoRedondeado;
//                t2String = df.format(t2);
//                t2Redondeado = Double.valueOf(t2String.replace(",", "."));
//            }
//            cf.setTotal(t1Redondeado);
//            cf.setTotalMp(t2Redondeado);
            return cf;
        }
        return null;
    }

    public static void grabarComprobanteCompleto(CalculoFactura cf,
            CompraClienteMercadoPago compraMercadoPago, FacturaCompra facturaCompra,
            FacturaIvaIntercambio fii, FacturaCompraReferenciaMercadoPago fcrmp) {
        Cliente cliente; // = new Cliente();;
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

    public static Double calcularRedondeo(Double importe) {
        DecimalFormat df_a = new DecimalFormat("#0.00");
        if (importe > 0.0) {
            String importeStr = df_a.format(importe);
            Double redondeado = Double.valueOf(importeStr.replace(",", "."));
            return redondeado;
        } else {
            return 0.00;
        }
    }

    public static Float calcularRedondeoF(Float importe) {
        DecimalFormat df = new DecimalFormat("#0.00");
        if (importe > 0.0) {
            String importeStr = df.format(importe);
            Float redondeado = Float.valueOf(importeStr.replace(",", "."));
            return redondeado;
        } else {
            return 0F;
        }

    }

    private static boolean hayMas2(List<ProductoTop> p) {
        Boolean hay = false;
        for (ProductoTop pt2 : p) {
            if (!pt2.getUsado() && pt2.getStock() > 0) {
                hay = true;
                break;
            }
        }
        return hay;
    }
}
