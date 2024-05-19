/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.entities;

/**
 *
 * @author argia
 */
public class FacturaCompraReferenciaMercadoPago {
    private Long id;
    private FacturaCompra facturaCompra;
    private CompraClienteMercadoPago compraClienteMercadoPago;
    private IvaVentas ivaVentas;

    public FacturaCompraReferenciaMercadoPago() {
    }

    public FacturaCompraReferenciaMercadoPago(Long id, FacturaCompra facturaCompra, CompraClienteMercadoPago compraClienteMercadoPago, IvaVentas ivaVentas) {
        this.id = id;
        this.facturaCompra = facturaCompra;
        this.compraClienteMercadoPago = compraClienteMercadoPago;
        this.ivaVentas = ivaVentas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FacturaCompra getFacturaCompra() {
        return facturaCompra;
    }

    public void setFacturaCompra(FacturaCompra facturaCompra) {
        this.facturaCompra = facturaCompra;
    }

    public CompraClienteMercadoPago getCompraClienteMercadoPago() {
        return compraClienteMercadoPago;
    }

    public void setCompraClienteMercadoPago(CompraClienteMercadoPago compraClienteMercadoPago) {
        this.compraClienteMercadoPago = compraClienteMercadoPago;
    }

    public IvaVentas getIvaVentas() {
        return ivaVentas;
    }

    public void setIvaVentas(IvaVentas ivaVentas) {
        this.ivaVentas = ivaVentas;
    }
    
}