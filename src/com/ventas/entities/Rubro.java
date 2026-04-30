package com.ventas.entities;

public class Rubro {

    private Long id;
    private Integer codigo;
    private String nombre;
    private Integer tipoMarca;

    public Rubro() {
    }

    public Rubro(Long id, Integer codigo, String nombre, Integer tipoMarca) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoMarca = tipoMarca;
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

    public Integer getTipoMarca() {
        return tipoMarca;
    }

    public void setTipoMarca(Integer tipoMarca) {
        this.tipoMarca = tipoMarca;
    }

}
