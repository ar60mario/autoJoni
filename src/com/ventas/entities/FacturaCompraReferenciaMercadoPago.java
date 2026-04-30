package com.ventas.entities;

public class FacturaCompraReferenciaMercadoPago {
    private Long id;
    private CompraClienteMercadoPago compraClienteMercadoPago;
    private IvaVentas ivaVentas;

    public FacturaCompraReferenciaMercadoPago() {
    }

    public FacturaCompraReferenciaMercadoPago(Long id, CompraClienteMercadoPago compraClienteMercadoPago, IvaVentas ivaVentas) {
        this.id = id;
        this.compraClienteMercadoPago = compraClienteMercadoPago;
        this.ivaVentas = ivaVentas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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