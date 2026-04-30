package com.ventas.entities;

public class FcTemp {

    private Long id;
    private Double gravado;
    private Double impuesto;
    private Double iva;
    private Double total;
    private String cuitCliente;
    private Boolean anulada;

    public FcTemp() {
    }

    public FcTemp(Long id, Double gravado, Double impuesto, Double iva, Double total,
            String cuitCliente, Boolean anulada) {
        this.id = id;
        this.gravado = gravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.cuitCliente = cuitCliente;
        this.anulada = anulada;
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

    public String getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(String cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

}
