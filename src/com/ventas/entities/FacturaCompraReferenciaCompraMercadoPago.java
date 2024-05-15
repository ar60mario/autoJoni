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
public class FacturaCompraReferenciaCompraMercadoPago {
    private Long id;
    private FacturaCompra facturaCompra;
    private CompraClienteMercadoPago compraClienteMercadoPago;

    public FacturaCompraReferenciaCompraMercadoPago() {
    }

    public FacturaCompraReferenciaCompraMercadoPago(Long id, FacturaCompra facturaCompra, CompraClienteMercadoPago compraClienteMercadoPago) {
        this.id = id;
        this.facturaCompra = facturaCompra;
        this.compraClienteMercadoPago = compraClienteMercadoPago;
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
    
}
