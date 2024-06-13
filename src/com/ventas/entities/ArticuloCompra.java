package com.ventas.entities;

/**
 *
 * @author argia
 */
public class ArticuloCompra {

    private Long id;
    private Double gravado;
    private Double impuesto;
    private Double iva;
    private Double total;
    private Boolean activo;
    private Producto producto;
    private Float porcentual;

    public ArticuloCompra() {
    }

    public ArticuloCompra(Long id, Double gravado, Double impuesto, Double iva, Double total, Boolean activo, Producto producto, Float porcentual) {
        this.id = id;
        this.gravado = gravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.activo = activo;
        this.producto = producto;
        this.porcentual = porcentual;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Float getPorcentual() {
        return porcentual;
    }

    public void setPorcentual(Float porcentual) {
        this.porcentual = porcentual;
    }

}