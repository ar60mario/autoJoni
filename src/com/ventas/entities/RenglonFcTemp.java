package com.ventas.entities;

public class RenglonFcTemp {

    private Long id;
    private Integer itemNro;
    private Producto producto;
    private Integer codigoProducto;
    private Double gravado;
    private Float cantidad;
    private Double impuesto;
    private Double iva;
    private Double total;
    private FcTemp factura;

    public RenglonFcTemp() {
    }

    public RenglonFcTemp(Long id, Integer itemNro, Producto producto, Integer codigoProducto, Double gravado,
            Float cantidad, Double impuesto, Double iva, Double total, FcTemp factura) {
        this.id = id;
        this.itemNro = itemNro;
        this.producto = producto;
        this.codigoProducto = codigoProducto;
        this.gravado = gravado;
        this.cantidad = cantidad;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.factura = factura;
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

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
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

    public FcTemp getFactura() {
        return factura;
    }

    public void setFactura(FcTemp factura) {
        this.factura = factura;
    }

}
