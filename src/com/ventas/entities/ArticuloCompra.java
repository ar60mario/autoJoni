package com.ventas.entities;

/**
 *
 * @author argia
 */
public class ArticuloCompra {

    private Long id;
    private Integer codigo;
    private String nombre;
    private Double gravado;
    private Double impuesto;
    private Double iva;
    private Double total;
    private Double gravadoUsado;
    private Double impuestoUsado;
    private Double ivaUsado;
    private Double totalUsado;
    private Boolean activo;
    private Producto producto;

    public ArticuloCompra() {
    }

    public ArticuloCompra(Long id, Integer codigo, String nombre, Double gravado, Double impuesto, 
            Double iva, Double total, Double gravadoUsado, Double impuestoUsado, Double ivaUsado, 
            Double totalUsado, Boolean activo, Producto producto) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.gravado = gravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.total = total;
        this.gravadoUsado = gravadoUsado;
        this.impuestoUsado = impuestoUsado;
        this.ivaUsado = ivaUsado;
        this.totalUsado = totalUsado;
        this.activo = activo;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Double getGravadoUsado() {
        return gravadoUsado;
    }

    public void setGravadoUsado(Double gravadoUsado) {
        this.gravadoUsado = gravadoUsado;
    }

    public Double getImpuestoUsado() {
        return impuestoUsado;
    }

    public void setImpuestoUsado(Double impuestoUsado) {
        this.impuestoUsado = impuestoUsado;
    }

    public Double getIvaUsado() {
        return ivaUsado;
    }

    public void setIvaUsado(Double ivaUsado) {
        this.ivaUsado = ivaUsado;
    }

    public Double getTotalUsado() {
        return totalUsado;
    }

    public void setTotalUsado(Double totalUsado) {
        this.totalUsado = totalUsado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
