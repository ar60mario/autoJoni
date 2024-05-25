package com.ventas.entities;

import java.util.Date;

/**
 *
 * @author argia
 */
public class FacturaCompra {

    private Long id;
    private Date fecha;
    private Float ganancia;
    private Double gravado;
    private Double gravadoVenta;
    private Double iva;
    private Double ivaVenta;
    private Double iibb;
    private Double impuesto1;
    private Double impuesto2;
    private Double impuesto3;
    private Double impuestoVenta;
    private String proveedor;
    private Double total;
    private Double totalVenta;
    private ArticuloCompra articuloCompra;

    public FacturaCompra() {
    }

    public FacturaCompra(Long id, Date fecha, Float ganancia, Double gravado, Double gravadoVenta, Double iva, Double ivaVenta, Double iibb, Double impuesto1, Double impuesto2, Double impuesto3, Double impuestoVenta, String proveedor, Double total, Double totalVenta, ArticuloCompra articuloCompra) {
        this.id = id;
        this.fecha = fecha;
        this.ganancia = ganancia;
        this.gravado = gravado;
        this.gravadoVenta = gravadoVenta;
        this.iva = iva;
        this.ivaVenta = ivaVenta;
        this.iibb = iibb;
        this.impuesto1 = impuesto1;
        this.impuesto2 = impuesto2;
        this.impuesto3 = impuesto3;
        this.impuestoVenta = impuestoVenta;
        this.proveedor = proveedor;
        this.total = total;
        this.totalVenta = totalVenta;
        this.articuloCompra = articuloCompra;
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

    public Float getGanancia() {
        return ganancia;
    }

    public void setGanancia(Float ganancia) {
        this.ganancia = ganancia;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getGravadoVenta() {
        return gravadoVenta;
    }

    public void setGravadoVenta(Double gravadoVenta) {
        this.gravadoVenta = gravadoVenta;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(Double ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public Double getIibb() {
        return iibb;
    }

    public void setIibb(Double iibb) {
        this.iibb = iibb;
    }

    public Double getImpuesto1() {
        return impuesto1;
    }

    public void setImpuesto1(Double impuesto1) {
        this.impuesto1 = impuesto1;
    }

    public Double getImpuesto2() {
        return impuesto2;
    }

    public void setImpuesto2(Double impuesto2) {
        this.impuesto2 = impuesto2;
    }

    public Double getImpuesto3() {
        return impuesto3;
    }

    public void setImpuesto3(Double impuesto3) {
        this.impuesto3 = impuesto3;
    }

    public Double getImpuestoVenta() {
        return impuestoVenta;
    }

    public void setImpuestoVenta(Double impuestoVenta) {
        this.impuestoVenta = impuestoVenta;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public ArticuloCompra getArticuloCompra() {
        return articuloCompra;
    }

    public void setArticuloCompra(ArticuloCompra articuloCompra) {
        this.articuloCompra = articuloCompra;
    }
    
}