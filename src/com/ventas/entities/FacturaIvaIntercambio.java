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
public class FacturaIvaIntercambio {
    private Long id;
    private Date fecha;
    private String letra;
    private Integer sucursal;
    private Integer numero;
    private Long cae;
    private Date fechaVencimientoCae;
    private String estado;

    public FacturaIvaIntercambio() {
    }

    public FacturaIvaIntercambio(Long id, Date fecha, String letra, Integer sucursal, Integer numero, Long cae, Date fechaVencimientoCae, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.letra = letra;
        this.sucursal = sucursal;
        this.numero = numero;
        this.cae = cae;
        this.fechaVencimientoCae = fechaVencimientoCae;
        this.estado = estado;
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

    public Long getCae() {
        return cae;
    }

    public void setCae(Long cae) {
        this.cae = cae;
    }

    public Date getFechaVencimientoCae() {
        return fechaVencimientoCae;
    }

    public void setFechaVencimientoCae(Date fechaVencimientoCae) {
        this.fechaVencimientoCae = fechaVencimientoCae;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}