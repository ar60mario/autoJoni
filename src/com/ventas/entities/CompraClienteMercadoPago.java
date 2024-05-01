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
public class CompraClienteMercadoPago {
    private Long id;
    private String nombre;
    private String cuit;
    private Double importe;
    private Boolean procesado;

    public CompraClienteMercadoPago() {
    }

    public CompraClienteMercadoPago(Long id, String nombre, String cuit, Double importe, Boolean procesado) {
        this.id = id;
        this.nombre = nombre;
        this.cuit = cuit;
        this.importe = importe;
        this.procesado = procesado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getProcesado() {
        return procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }
    
}
