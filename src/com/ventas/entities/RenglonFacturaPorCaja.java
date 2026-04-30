package com.ventas.entities;

public class RenglonFacturaPorCaja {

    private Long id;
    private Integer itemNro;
    private Producto producto;
    private String descripcion;
    private Double gravado;
    private Float cantidad;
    private Double impuesto;
    private Double iva;
    private Double total;
    private IvaVentasPorCaja ivaVentasPorCaja;

    public RenglonFacturaPorCaja() {
    }

    public RenglonFacturaPorCaja(Long id, Integer itemNro, Producto producto, String descripcion, Double gravado, Float cantidad, Double impuesto, Double iva, Double total, IvaVentasPorCaja ivaVentasPorCaja) {
        this.id = id;
        this.itemNro = itemNro;
        this.producto = producto;
        this.descripcion = descripcion;
        this.gravado = gravado;
        this.cantidad = cantidad;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.ivaVentasPorCaja = ivaVentasPorCaja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemNro() {
        return itemNro;
    }

    public void setItemNro(Integer itemNro) {
        this.itemNro = itemNro;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
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

    public IvaVentasPorCaja getIvaVentasPorCaja() {
        return ivaVentasPorCaja;
    }

    public void setIvaVentasPorCaja(IvaVentasPorCaja ivaVentasPorCaja) {
        this.ivaVentasPorCaja = ivaVentasPorCaja;
    }

}