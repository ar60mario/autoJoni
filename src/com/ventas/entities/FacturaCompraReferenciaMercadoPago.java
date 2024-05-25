package com.ventas.entities;

/**
 *
 * @author argia
 */
public class FacturaCompraReferenciaMercadoPago {
    private Long id;
    private ArticuloCompra articuloCompra;
    private CompraClienteMercadoPago compraClienteMercadoPago;
    private IvaVentas ivaVentas;

    public FacturaCompraReferenciaMercadoPago() {
    }

    public FacturaCompraReferenciaMercadoPago(Long id, ArticuloCompra articuloCompra, CompraClienteMercadoPago compraClienteMercadoPago, IvaVentas ivaVentas) {
        this.id = id;
        this.articuloCompra = articuloCompra;
        this.compraClienteMercadoPago = compraClienteMercadoPago;
        this.ivaVentas = ivaVentas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArticuloCompra getArticuloCompra() {
        return articuloCompra;
    }

    public void setArticuloCompra(ArticuloCompra articuloCompra) {
        this.articuloCompra = articuloCompra;
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