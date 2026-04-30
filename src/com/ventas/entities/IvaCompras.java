package com.ventas.entities;

import java.util.Date;

/**
 *
 * @author argia
 */
public class IvaCompras {
    private Long id;
    private Date fecha;
    private Integer tipoComprobante;
    private Double gravado;
    private Double impuesto;
    private Double iva;
    private Double otros;
    private Double total;
    private Integer sucursal;
    private Integer numero;
    private String razonSocial;
    private String cuit;

    public IvaCompras() {
    }

    public IvaCompras(Long id, Date fecha, Integer tipoComprobante, Double gravado, Double impuesto, Double iva, Double otros, Double total, Integer sucursal, Integer numero, String razonSocial, String cuit) {
        this.id = id;
        this.fecha = fecha;
        this.tipoComprobante = tipoComprobante;
        this.gravado = gravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.otros = otros;
        this.total = total;
        this.sucursal = sucursal;
        this.numero = numero;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
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

    public Integer getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(Integer tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
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

    public Double getOtros() {
        return otros;
    }

    public void setOtros(Double otros) {
        this.otros = otros;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    
    
}
