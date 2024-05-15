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

    public CalculoFactura() {
    }

    public CalculoFactura(Long id, Double gravado, Double impuesto, Double iva, Double total, Double totalMp) {
        this.id = id;
        this.gravado = gravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.totalMp = totalMp;
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

}