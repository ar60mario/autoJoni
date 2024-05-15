/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bo;

import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.FacturaCompra;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.entities.IvaVentas;
import com.ventas.services.IvaVentasService;

/**
 *
 * @author argia
 */
public class ComprobanteVentaMercadoPagoBo {

    public void saveComprobanteCompleto1(Cliente cliente, Double gravado, Double iva,
            Double impuesto, Double total, CompraClienteMercadoPago compraMercadoPago,
            FacturaCompra facturaCompra, FacturaIvaIntercambio fii) throws Exception {
        Cliente cl = new ClienteBo().saveCliente(cliente);
        IvaVentas iv = new IvaVentas();
        iv.setExento(0.0);
        iv.setNoGravado(0.0);
        iv.setDescuentoGlobal(0.0);
        iv.setLetraReferencia("");
        iv.setNumeroSucursalReferencia(0);
        iv.setNumeroFacturaReferencia(0);
        iv.setGravado(gravado);
        iv.setGravado0(0.0);
        iv.setGravado10_5(0.0);
        iv.setGravado27(0.0);
        iv.setFecha(fii.getFecha());
        iv.setLetra(fii.getLetra());
        iv.setNumeroFactura(fii.getNumero());
        iv.setNumeroSucursal(fii.getSucursal());
        iv.setTipoDoc(6);
        iv.setImpuesto(impuesto);
        iv.setIva(iva);
        iv.setIva0(0.0);
        iv.setIva10_5(0.0);
        iv.setIva27(0.0);
        iv.setTotal(total);
        iv.setCliente(cl);
        iv.setCae(fii.getCae());
        iv.setFechaCae(fii.getFechaVencimientoCae());
        new IvaVentasBo().saveIvaVentas(iv);
        new CompraClienteMercadoPagoBo().updateCompraClientesImportados(compraMercadoPago);
        new FacturaCompraBo().updateFacturaCompra(facturaCompra);

        //renglon iva ventas
    }
}
