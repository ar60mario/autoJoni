package com.ventas.estructuras;

public enum CategoriaArca {
    INSCRIPTO(1,"IVA Responsable Inscripto"),
    EXENTO(4,"IVA Sujeto Exento"),
    CONS_FINAL(5,"Consumidor Final"),
    MONOTRIBUTO(6,"Responsable Monotributo");

    private final Integer codigo;
    private final String detalle;

    CategoriaArca(Integer codigo, String detalle) {
        this.codigo = codigo;
        this.detalle = detalle;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDetalle() {
        return detalle;
    }
}
