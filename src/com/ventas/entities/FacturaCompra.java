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
    private Double gravadoVenta;
    private Double gravadoTemp;
    private Double iva;
    private Double ivaVenta;
    private Double ivaTemp;
    private Double iibb;
    private Double impuesto1;
    private Double impuesto2;
    private Double impuesto3;
    private Double impuestoVenta;
    private Double impuestoTemp;
    private String proveedor;
    private Double total;
    private Double totalVenta;
    private Double totalTemp;
    private Double gravadoUtilizado;
    private Double ivaUtilizado;
    private Double impuestoUtilizado;
    private Double totalUtilizado;
    private Boolean procesado;
    private Producto producto;

    public FacturaCompra() {
    }

    public FacturaCompra(Long id, Date fecha, Float ganancia, Double gravado, Double gravadoVenta, Double gravadoTemp, Double iva, Double ivaVenta, Double ivaTemp, Double iibb, Double impuesto1, Double impuesto2, Double impuesto3, Double impuestoVenta, Double impuestoTemp, String proveedor, Double total, Double totalVenta, Double totalTemp, Double gravadoUtilizado, Double ivaUtilizado, Double impuestoUtilizado, Double totalUtilizado, Boolean procesado, Producto producto) {
        this.id = id;
        this.fecha = fecha;
        this.ganancia = ganancia;
        this.gravado = gravado;
        this.gravadoVenta = gravadoVenta;
        this.gravadoTemp = gravadoTemp;
        this.iva = iva;
        this.ivaVenta = ivaVenta;
        this.ivaTemp = ivaTemp;
        this.iibb = iibb;
        this.impuesto1 = impuesto1;
        this.impuesto2 = impuesto2;
        this.impuesto3 = impuesto3;
        this.impuestoVenta = impuestoVenta;
        this.impuestoTemp = impuestoTemp;
        this.proveedor = proveedor;
        this.total = total;
        this.totalVenta = totalVenta;
        this.totalTemp = totalTemp;
        this.gravadoUtilizado = gravadoUtilizado;
        this.ivaUtilizado = ivaUtilizado;
        this.impuestoUtilizado = impuestoUtilizado;
        this.totalUtilizado = totalUtilizado;
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

    public Double getGravadoVenta() {
        return gravadoVenta;
    }

    public void setGravadoVenta(Double gravadoVenta) {
        this.gravadoVenta = gravadoVenta;
    }

    public Double getGravadoTemp() {
        return gravadoTemp;
    }

    public void setGravadoTemp(Double gravadoTemp) {
        this.gravadoTemp = gravadoTemp;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(Double ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public Double getIvaTemp() {
        return ivaTemp;
    }

    public void setIvaTemp(Double ivaTemp) {
        this.ivaTemp = ivaTemp;
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

    public Double getImpuestoVenta() {
        return impuestoVenta;
    }

    public void setImpuestoVenta(Double impuestoVenta) {
        this.impuestoVenta = impuestoVenta;
    }

    public Double getImpuestoTemp() {
        return impuestoTemp;
    }

    public void setImpuestoTemp(Double impuestoTemp) {
        this.impuestoTemp = impuestoTemp;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Double getTotalTemp() {
        return totalTemp;
    }

    public void setTotalTemp(Double totalTemp) {
        this.totalTemp = totalTemp;
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

    public Double getTotalUtilizado() {
        return totalUtilizado;
    }

    public void setTotalUtilizado(Double totalUtilizado) {
        this.totalUtilizado = totalUtilizado;
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