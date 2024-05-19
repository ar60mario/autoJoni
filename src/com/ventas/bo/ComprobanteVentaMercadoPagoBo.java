/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bo;

import com.ventas.entities.CalculoFactura;
import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.FacturaCompra;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.RenglonFactura;

/**
 *
 * @author argia
 */
public class ComprobanteVentaMercadoPagoBo {

    public void saveComprobanteCompleto1(Cliente cliente, CalculoFactura cf, 
            CompraClienteMercadoPago compraMercadoPago,
            FacturaCompra facturaCompra, FacturaIvaIntercambio fii) throws Exception {
        Cliente cl = new ClienteBo().saveCliente(cliente);
        IvaVentas iv = new IvaVentas();
        RenglonFactura rf = new RenglonFactura();
        iv.setExento(0.0);
        iv.setNoGravado(0.0);
        iv.setDescuentoGlobal(0.0);
        iv.setLetraReferencia("");
        iv.setNumeroSucursalReferencia(0);
        iv.setNumeroFacturaReferencia(0);
        iv.setGravado(cf.getGravado());
        iv.setGravado0(0.0);
        iv.setGravado10_5(0.0);
        iv.setGravado27(0.0);
        iv.setFecha(fii.getFecha());
        iv.setLetra(fii.getLetra());
        iv.setNumeroFactura(fii.getNumero());
        iv.setNumeroSucursal(fii.getSucursal());
        iv.setTipoDoc(6);
        iv.setImpuesto(cf.getImpuesto());
        iv.setIva(cf.getIva());
        iv.setIva0(0.0);
        iv.setIva10_5(0.0);
        iv.setIva27(0.0);
        iv.setTotal(cf.getTotal());
        iv.setCliente(cl);
        iv.setCae(fii.getCae());
        iv.setFechaCae(fii.getFechaVencimientoCae());
        rf.setCantidad(1F);
        rf.setCostoG(0.0);
        rf.setCostoI(0.0);
        rf.setDescripcion(facturaCompra.getProducto().getDetalle());
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
        rf.setIvaVentas(iv);
        rf.setNoGravado(0.0);
        rf.setProducto(facturaCompra.getProducto());
        rf.setSugerido(0.0);
        rf.setTotal(cf.getTotal());
        iv = new IvaVentasBo().saveIvaVentas(iv);
        rf.setIvaVentas(iv);
        new RenglonFacturaBo().saveRenglon(rf);
        new CompraClienteMercadoPagoBo().updateCompraClientesImportados(compraMercadoPago);
        new FacturaCompraBo().updateFacturaCompra(facturaCompra);

        //renglon iva ventas
    }
    
    public void saveComprobanteCompleto2(Cliente cliente, CalculoFactura cf, 
            CompraClienteMercadoPago compraMercadoPago,
            FacturaCompra facturaCompra, FacturaIvaIntercambio fii,
            FacturaCompraReferenciaMercadoPago fcrmp) throws Exception {
        IvaVentas iv = new IvaVentas();
        RenglonFactura rf = new RenglonFactura();
        iv.setExento(0.0);
        iv.setNoGravado(0.0);
        iv.setDescuentoGlobal(0.0);
        iv.setLetraReferencia("");
        iv.setNumeroSucursalReferencia(0);
        iv.setNumeroFacturaReferencia(0);
        iv.setGravado(cf.getGravado());
        iv.setGravado0(0.0);
        iv.setGravado10_5(0.0);
        iv.setGravado27(0.0);
        iv.setFecha(fii.getFecha());
        iv.setLetra(fii.getLetra());
        iv.setNumeroFactura(fii.getNumero());
        iv.setNumeroSucursal(fii.getSucursal());
        iv.setTipoDoc(6);
        iv.setImpuesto(cf.getImpuesto());
        iv.setIva(cf.getIva());
        iv.setIva0(0.0);
        iv.setIva10_5(0.0);
        iv.setIva27(0.0);
        iv.setTotal(cf.getTotal());
        iv.setCliente(cliente);
        iv.setCae(fii.getCae());
        iv.setFechaCae(fii.getFechaVencimientoCae());
        rf.setCantidad(1F);
        rf.setCostoG(0.0);
        rf.setCostoI(0.0);
        rf.setDescripcion(facturaCompra.getProducto().getDetalle());
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
        rf.setIvaVentas(iv);
        rf.setNoGravado(0.0);
        rf.setProducto(facturaCompra.getProducto());
        rf.setSugerido(0.0);
        rf.setTotal(cf.getTotal());
        iv = new IvaVentasBo().saveIvaVentas(iv);
        rf.setIvaVentas(iv);
        fcrmp.setIvaVentas(iv);
        new RenglonFacturaBo().saveRenglon(rf);
        new CompraClienteMercadoPagoBo().updateCompraClientesImportados(compraMercadoPago);
        new FacturaCompraBo().updateFacturaCompra(facturaCompra);
        new FacturaCompraReferenciaMercadoPagoBo().saveFacturaCompraReferenciaMercadoPago(fcrmp);
                
        //renglon iva ventas
    }
}
