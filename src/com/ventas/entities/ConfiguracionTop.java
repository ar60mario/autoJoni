package com.ventas.entities;

/**
 *
 * @author Mario
 */
public class ConfiguracionTop {

    private Integer id;
    private Integer orderMaximo;
    private Double importeMaximo;
    private Double importeMaximoPanificados;
    private Double importeMinimoMercadoPago;//logistica
    private Double minimoMp;
    private Double maximoLogistica;
    private Float porcentajeImpuesto;

    public ConfiguracionTop() {
    }

    public ConfiguracionTop(Integer id, Integer orderMaximo, Double importeMaximo,
            Double importeMaximoPanificados, Double importeMinimoMercadoPago,
            Double minimoMp, Double maximoLogistica, Float porcentajeImpuesto) {
        this.id = id;
        this.orderMaximo = orderMaximo;
        this.importeMaximo = importeMaximo;
        this.importeMaximoPanificados = importeMaximoPanificados;
        this.importeMinimoMercadoPago = importeMinimoMercadoPago;
        this.minimoMp = minimoMp;
        this.maximoLogistica = maximoLogistica;
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderMaximo() {
        return orderMaximo;
    }

    public void setOrderMaximo(Integer orderMaximo) {
        this.orderMaximo = orderMaximo;
    }

    public Double getImporteMaximo() {
        return importeMaximo;
    }

    public void setImporteMaximo(Double importeMaximo) {
        this.importeMaximo = importeMaximo;
    }

    public Double getImporteMaximoPanificados() {
        return importeMaximoPanificados;
    }

    public void setImporteMaximoPanificados(Double importeMaximoPanificados) {
        this.importeMaximoPanificados = importeMaximoPanificados;
    }

    public Double getImporteMinimoMercadoPago() {
        return importeMinimoMercadoPago;
    }

    public void setImporteMinimoMercadoPago(Double importeMinimoMercadoPago) {
        this.importeMinimoMercadoPago = importeMinimoMercadoPago;
    }

    public Double getMinimoMp() {
        return minimoMp;
    }

    public void setMinimoMp(Double minimoMp) {
        this.minimoMp = minimoMp;
    }

    public Double getMaximoLogistica() {
        return maximoLogistica;
    }

    public void setMaximoLogistica(Double maximoLogistica) {
        this.maximoLogistica = maximoLogistica;
    }

    public Float getPorcentajeImpuesto() {
        return porcentajeImpuesto;
    }

    public void setPorcentajeImpuesto(Float porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

}
