package com.ventas.entities;

import java.util.Date;

/**
 *
 * @author argia
 */
public class CompraClienteMercadoPago {
    private Long id;
    private Date fecha;
    private String nombre;
    private String cuit;
    private Double importe;
    private Boolean procesado;

    public CompraClienteMercadoPago() {
    }

    public CompraClienteMercadoPago(Long id, Date fecha, String nombre, String cuit, Double importe, Boolean procesado) {
        this.id = id;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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