/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public ProductoTop() {
    }

    public ProductoTop(Long id, Integer codigo, Boolean activo, Boolean usado, Integer orden, Integer cantidad, Boolean panificado, Float stock, String detalle, Double precio, Float impuesto, Rubro rubro, SubRubro subRubro) {
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

}