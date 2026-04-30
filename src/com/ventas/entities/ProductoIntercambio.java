package com.ventas.entities;

import java.util.List;

public class ProductoIntercambio {
    private Long id;
    private List<Producto> productos;
    private List<ProductoTop> productosTop;

    public ProductoIntercambio() {
    }

    public ProductoIntercambio(Long id, List<Producto> productos, List<ProductoTop> productosTop) {
        this.id = id;
        this.productos = productos;
        this.productosTop = productosTop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<ProductoTop> getProductosTop() {
        return productosTop;
    }

    public void setProductosTop(List<ProductoTop> productosTop) {
        this.productosTop = productosTop;
    }
    
    
}
