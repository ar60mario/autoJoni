/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.entities;

import java.util.Date;

/**
 *
 * @author argia
 */
public class FacturaCompra {
    private Long id;
    private Date fecha;
    private Float ganancia;
    private Double gravado;
    private Double iva;
    private Double iibb;
    private Double impuesto1;
    private Double impuesto2;
    private Double impuesto3;
    private String proveedor;
    private Double gravadoUtilizado;
    private Double ivaUtilizado;
    private Double impuestoUtilizado;
    private Boolean procesado;
    private Producto producto;

    public FacturaCompra() {
    }

    public FacturaCompra(Long id, Date fecha, Float ganancia, Double gravado, Double iva, Double iibb, Double impuesto1, Double impuesto2, Double impuesto3, String proveedor, Double gravadoUtilizado, Double ivaUtilizado, Double impuestoUtilizado, Boolean procesado, Producto producto) {
        this.id = id;
        this.fecha = fecha;
        this.ganancia = ganancia;
        this.gravado = gravado;
        this.iva = iva;
        this.iibb = iibb;
        this.impuesto1 = impuesto1;
        this.impuesto2 = impuesto2;
        this.impuesto3 = impuesto3;
        this.proveedor = proveedor;
        this.gravadoUtilizado = gravadoUtilizado;
        this.ivaUtilizado = ivaUtilizado;
        this.impuestoUtilizado = impuestoUtilizado;
        this.procesado = procesado;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getGanancia() {
        return ganancia;
    }

    public void setGanancia(Float ganancia) {
        this.ganancia = ganancia;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getIibb() {
        return iibb;
    }

    public void setIibb(Double iibb) {
        this.iibb = iibb;
    }

    public Double getImpuesto1() {
        return impuesto1;
    }

    public void setImpuesto1(Double impuesto1) {
        this.impuesto1 = impuesto1;
    }

    public Double getImpuesto2() {
        return impuesto2;
    }

    public void setImpuesto2(Double impuesto2) {
        this.impuesto2 = impuesto2;
    }

    public Double getImpuesto3() {
        return impuesto3;
    }

    public void setImpuesto3(Double impuesto3) {
        this.impuesto3 = impuesto3;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Double getGravadoUtilizado() {
        return gravadoUtilizado;
    }

    public void setGravadoUtilizado(Double gravadoUtilizado) {
        this.gravadoUtilizado = gravadoUtilizado;
    }

    public Double getIvaUtilizado() {
        return ivaUtilizado;
    }

    public void setIvaUtilizado(Double ivaUtilizado) {
        this.ivaUtilizado = ivaUtilizado;
    }

    public Double getImpuestoUtilizado() {
        return impuestoUtilizado;
    }

    public void setImpuestoUtilizado(Double impuestoUtilizado) {
        this.impuestoUtilizado = impuestoUtilizado;
    }

    public Boolean getProcesado() {
        return procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}