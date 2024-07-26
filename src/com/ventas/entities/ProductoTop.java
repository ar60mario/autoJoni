package com.ventas.entities;

/**
 *
 * @author Mario
 */
public class ProductoTop {
    private Long id;
    private Integer codigo;
    private Boolean activo;
    private Boolean usado;
    private Integer orden;
    private Integer cantidad;
    private Boolean panificado;
    private Float stock;
    private String detalle;
    private Double precio;
    private Float impuesto;
    private Rubro rubro;
    private SubRubro subRubro;
    private Float porcentualMaximoVentaAutomatica;
    private Integer cantidadMinimaVenta;
    private Integer cantidadMaximaVenta;
    private Integer fraccion;
    private Boolean ventaSinStock;

    public ProductoTop() {
    }

    public ProductoTop(Long id, Integer codigo, Boolean activo, Boolean usado, Integer orden, Integer cantidad, Boolean panificado, Float stock, String detalle, Double precio, Float impuesto, Rubro rubro, SubRubro subRubro, Float porcentualMaximoVentaAutomatica, Integer cantidadMinimaVenta, Integer cantidadMaximaVenta, Integer fraccion, Boolean ventaSinStock) {
        this.id = id;
        this.codigo = codigo;
        this.activo = activo;
        this.usado = usado;
        this.orden = orden;
        this.cantidad = cantidad;
        this.panificado = panificado;
        this.stock = stock;
        this.detalle = detalle;
        this.precio = precio;
        this.impuesto = impuesto;
        this.rubro = rubro;
        this.subRubro = subRubro;
        this.porcentualMaximoVentaAutomatica = porcentualMaximoVentaAutomatica;
        this.cantidadMinimaVenta = cantidadMinimaVenta;
        this.cantidadMaximaVenta = cantidadMaximaVenta;
        this.fraccion = fraccion;
        this.ventaSinStock = ventaSinStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getUsado() {
        return usado;
    }

    public void setUsado(Boolean usado) {
        this.usado = usado;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getPanificado() {
        return panificado;
    }

    public void setPanificado(Boolean panificado) {
        this.panificado = panificado;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public SubRubro getSubRubro() {
        return subRubro;
    }

    public void setSubRubro(SubRubro subRubro) {
        this.subRubro = subRubro;
    }

    public Float getPorcentualMaximoVentaAutomatica() {
        return porcentualMaximoVentaAutomatica;
    }

    public void setPorcentualMaximoVentaAutomatica(Float porcentualMaximoVentaAutomatica) {
        this.porcentualMaximoVentaAutomatica = porcentualMaximoVentaAutomatica;
    }

    public Integer getCantidadMinimaVenta() {
        return cantidadMinimaVenta;
    }

    public void setCantidadMinimaVenta(Integer cantidadMinimaVenta) {
        this.cantidadMinimaVenta = cantidadMinimaVenta;
    }

    public Integer getCantidadMaximaVenta() {
        return cantidadMaximaVenta;
    }

    public void setCantidadMaximaVenta(Integer cantidadMaximaVenta) {
        this.cantidadMaximaVenta = cantidadMaximaVenta;
    }

    public Integer getFraccion() {
        return fraccion;
    }

    public void setFraccion(Integer fraccion) {
        this.fraccion = fraccion;
    }

    public Boolean getVentaSinStock() {
        return ventaSinStock;
    }

    public void setVentaSinStock(Boolean ventaSinStock) {
        this.ventaSinStock = ventaSinStock;
    }
    
}