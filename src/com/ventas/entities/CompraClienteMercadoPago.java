package com.ventas.entities;

import java.util.Date;

/**
 *
 * @author argia
 */
public class CompraClienteMercadoPago {
    private Long id;
    private String fecha;
    private String nombre;
    private String cuit;
    private Double importe;
    private Double importeUtilizado;
    private Boolean procesado;
    private String origen;
    private String operacion;

    public CompraClienteMercadoPago() {
    }

    public CompraClienteMercadoPago(Long id, String fecha, String nombre, String cuit, Double importe, Double importeUtilizado, Boolean procesado, String origen, String operacion) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.cuit = cuit;
        this.importe = importe;
        this.importeUtilizado = importeUtilizado;
        this.procesado = procesado;
        this.origen = origen;
        this.operacion = operacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public Double getImporteUtilizado() {
        return importeUtilizado;
    }

    public void setImporteUtilizado(Double importeUtilizado) {
        this.importeUtilizado = importeUtilizado;
    }

    public Boolean getProcesado() {
        return procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
}