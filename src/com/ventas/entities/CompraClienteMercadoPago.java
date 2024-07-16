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
    private Double importeUtilizado;
    private Boolean procesado;
    private String origen;
    private String letraFactura;

    public CompraClienteMercadoPago() {
    }

    public CompraClienteMercadoPago(Long id, Date fecha, String nombre, String cuit, Double importe, 
            Double importeUtilizado, Boolean procesado, String origen, String letraFactura) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.cuit = cuit;
        this.importe = importe;
        this.importeUtilizado = importeUtilizado;
        this.procesado = procesado;
        this.origen = origen;
        this.letraFactura = letraFactura;
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

    public String getLetraFactura() {
        return letraFactura;
    }

    public void setLetraFactura(String letraFactura) {
        this.letraFactura = letraFactura;
    }
    
}