package com.ventas.entities;

public class ProductoTop2 implements Comparable<ProductoTop2> {

    private Long id;
    private Integer codigo;
    private Boolean activo;
    private Boolean usado;
    private Integer orden;
    private Integer cantidad;
    private Float stock;
    private String detalle;
    private Double precio;
    private Float impuesto;
    private Rubro rubro;
    private SubRubro subRubro;
    private Double total;
    private Integer fraccion;

    public ProductoTop2() {
    }

    public ProductoTop2(Long id, Integer codigo, Boolean activo, Boolean usado, Integer orden, Integer cantidad, Float stock, String detalle, Double precio, Float impuesto, Rubro rubro, SubRubro subRubro, Double total, Integer fraccion) {
        this.id = id;
        this.codigo = codigo;
        this.activo = activo;
        this.usado = usado;
        this.orden = orden;
        this.cantidad = cantidad;
        this.stock = stock;
        this.detalle = detalle;
        this.precio = precio;
        this.impuesto = impuesto;
        this.rubro = rubro;
        this.subRubro = subRubro;
        this.total = total;
        this.fraccion = fraccion;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getUsado() {
        return usado;
    }

    public void setUsado(Boolean usado) {
        this.usado = usado;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public SubRubro getSubRubro() {
        return subRubro;
    }

    public void setSubRubro(SubRubro subRubro) {
        this.subRubro = subRubro;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getFraccion() {
        return fraccion;
    }

    public void setFraccion(Integer fraccion) {
        this.fraccion = fraccion;
    }

    @Override
    public int compareTo(ProductoTop2 o) {
        Double a = this.getTotal();
        Double b = o.getTotal();
        return b.compareTo(a);
    }

}
