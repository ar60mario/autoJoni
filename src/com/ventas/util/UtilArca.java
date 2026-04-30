package com.ventas.util;

import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.IvaVentasPorCaja;
import com.ventas.entities.RenglonFactura;
import com.ventas.entities.RenglonFacturaPorCaja;
import com.ventas.services.IvaVentasPorCajaService;
import com.ventas.services.IvaVentasService;
import com.ventas.services.RenglonFacturaPorCajaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UtilArca {

    public static Integer presentarFacturaPorCajaEnArcaPendientes() {
        List<IvaVentasPorCaja> ivxc;
        Integer estado = 0;
        try {
            ivxc = new IvaVentasPorCajaService().getFacturasPendientesDeEnviarArca();
        } catch (Exception ex) {
            Logger.getLogger(UtilArca.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR Nro. 20");
            return 9;
        }
        if (ivxc != null && !ivxc.isEmpty()) {
            for (IvaVentasPorCaja iv2 : ivxc) {
                List<RenglonFacturaPorCaja> reng = null;
                try {
                    reng = new RenglonFacturaPorCajaService().getAllRenglonFacturaFromIvaVentas(iv2);
                } catch (Exception ex) {
                    Logger.getLogger(UtilArca.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "ERROR Nro. 34");
                    return 8;
                }
                String cuitTitular = Constantes.cuitTitular;
                String tipoDocTit = Constantes.tipoDocTit;
                String iibb = Constantes.iibbTitular;
                String inicioA = Constantes.inicioActividades;
                String razonSocial = Constantes.razon_social_titular;
                String calleT = Constantes.calleNroTitular;
                String cpT = Constantes.cpLocalidadProvinciaTitular;
                String cuitCliente = "00000000000";
                String tipoDocCli = "99";
                String puntoVenta = Constantes.puntoVenta;
                Double totalFcGravado = iv2.getGravado();
                Double totalFcImpuesto = iv2.getImpuesto();
                Double totalFcIva = iv2.getIva();
                Double totalFc = iv2.getTotal();
                Date fechaF = iv2.getFecha();

                FacturaIvaIntercambio fii = UtilAfip.presentarAfip(cuitTitular, tipoDocTit, cuitCliente,
                        tipoDocCli, totalFcGravado, totalFcImpuesto, totalFcIva,
                        totalFc, fechaF, puntoVenta);

                if (fii != null) {
                    IvaVentas iv1 = new IvaVentas();
                    List<RenglonFactura> renglones = new ArrayList<>();
                    iv1.setFecha(fechaF);
                    iv1.setCae(fii.getCae());
                    iv1.setFechaCae(fii.getFechaVencimientoCae());
                    iv1.setNumeroFactura(fii.getNumero());
                    iv1.setNumeroSucursal(fii.getSucursal());
                    iv1.setCliente(iv2.getCliente());
                    iv1.setCuitCliente(cuitCliente);
                    iv1.setRazonSocialCliente("CONS.FINAL");
                    iv1.setCalleNroCliente(calleT);
                    iv1.setCpLocalidadProvinciaCliente(cpT);
                    iv1.setCuitTitular(cuitTitular);
                    iv1.setRazonSocialTitular(razonSocial);
                    iv1.setCalleNroTitular(calleT);
                    iv1.setCpLocalidadProvinciaTitular(cpT);
                    iv1.setIibbTitular(iibb);
                    iv1.setInicioActividades(inicioA);
                    iv1.setDescripcion("SEG.MARCAS");
                    iv1.setDescuentoGlobal(0.0);
                    iv1.setExento(0.0);
                    iv1.setIva0(0.0);
                    iv1.setIva10_5(0.0);
                    iv1.setIva27(0.0);
                    iv1.setNoGravado(0.00);
                    iv1.setGravado0(0.0);
                    iv1.setGravado10_5(0.0);
                    iv1.setGravado27(0.0);
                    iv1.setGravado(iv2.getGravado());
                    iv1.setImpuesto(iv2.getImpuesto());
                    iv1.setIva(iv2.getIva());
                    iv1.setTotal(iv2.getTotal());
                    iv1.setLetra("B");
                    iv1.setLetraReferencia("X");
                    iv1.setNumeroFacturaReferencia(0);
                    iv1.setNumeroSucursalReferencia(0);
                    iv1.setOperacion("AUTOM");
                    iv1.setTipoDoc(6);
                    for(RenglonFacturaPorCaja rfxc:reng){
                        RenglonFactura rf = new RenglonFactura();
                        rf.setCantidad(rfxc.getCantidad());
                        rf.setCostoG(0.0);
                        rf.setCostoI(0.0);
                        rf.setDescripcion(rfxc.getDescripcion());
                        rf.setDescuento(0.0);
                        rf.setExento(0.0);
                        rf.setFabricacion(false);
                        rf.setGravado(rfxc.getGravado());
                        rf.setGravado0(0.0);
                        rf.setGravado10_5(0.0);
                        rf.setGravado27(0.0);
                        rf.setImpuesto(rfxc.getImpuesto());
                        rf.setItemNro(rfxc.getItemNro());
                        rf.setIva(rfxc.getIva());
                        rf.setIva0(0.0);
                        rf.setIva10_5(0.0);
                        rf.setIva27(0.0);
                        rf.setIvaVentas(iv1);
                        rf.setNoGravado(0.0);
                        rf.setProducto(rfxc.getProducto());
                        rf.setSugerido(0.0);
                        rf.setTotal(rfxc.getTotal());
                        renglones.add(rf);
                        iv2.setActiva(false);
                    }
                    try {
                        new IvaVentasService().saveIvaVentasCompleto(iv1, renglones);
                        new IvaVentasPorCajaService().updateIvaVentas(iv2);
                    } catch (Exception ex) {
                        Logger.getLogger(UtilArca.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "ERROR Nro. 126");
                        return 7;
                    }
                }
            }
        }
        return estado;
    }
}
