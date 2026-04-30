package com.ventas.entities;

import java.util.Date;

public class IvaVentasPorCaja {

    private Long id;
    private Date fecha;
    private String letra;
    private Integer numeroSucursal;
    private Integer numeroFactura;
    private Cliente cliente;
    private Double gravado;
    private Double impuesto;
    private Double iva;
    private Double total;
    private Boolean activa;

    public IvaVentasPorCaja() {
    }

    public IvaVentasPorCaja(Long id, Date fecha, String letra, Integer numeroSucursal, Integer numeroFactura, Cliente cliente, Double gravado, Double impuesto, Double iva, Double total, Boolean activa) {
        this.id = id;
        this.fecha = fecha;
        this.letra = letra;
        this.numeroSucursal = numeroSucursal;
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.gravado = gravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.activa = activa;
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

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getNumeroSucursal() {
        return numeroSucursal;
    }

    public void setNumeroSucursal(Integer numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

}
