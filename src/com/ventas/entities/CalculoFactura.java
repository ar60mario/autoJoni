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
public class CalculoFactura {
    private Long id;
    private Double gravado;
    private Double impuesto;
    private Double iva;
    private Double total;
    private Double totalMp;
    private Producto producto;
    private ArticuloCompra articulo;
    private String cuitCliente;
    private CompraClienteMercadoPago compraMercadoPago;

    public CalculoFactura() {
    }

    public CalculoFactura(Long id, Double gravado, Double impuesto, Double iva, Double total, Double totalMp, Producto producto, ArticuloCompra articulo, String cuitCliente, CompraClienteMercadoPago compraMercadoPago) {
        this.id = id;
        this.gravado = gravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.totalMp = totalMp;
        this.producto = producto;
        this.articulo = articulo;
        this.cuitCliente = cuitCliente;
        this.compraMercadoPago = compraMercadoPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalMp() {
        return totalMp;
    }

    public void setTotalMp(Double totalMp) {
        this.totalMp = totalMp;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArticuloCompra getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloCompra articulo) {
        this.articulo = articulo;
    }

    public String getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(String cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public CompraClienteMercadoPago getCompraMercadoPago() {
        return compraMercadoPago;
    }

    public void setCompraMercadoPago(CompraClienteMercadoPago compraMercadoPago) {
        this.compraMercadoPago = compraMercadoPago;
    }
    
}