package com.ventas.entities;

public class TitularCuit {

    private Long id;
    private Integer codigo;
    private String razonSocial;
    private Integer categoria;
    private String cuit;
    private String tipoDoc;
    private String iibb;
    private String calleNroPisoDto;
    private String cpLocalidadProvincia;
    private Integer puntoVenta;
    private Boolean activo;
    private String rutaCrt;
    private String rutaKey;
    private Integer ultimoNroFactura;

    public TitularCuit() {
    }

    public TitularCuit(Long id, Integer codigo, String razonSocial, Integer categoria, String cuit,
            String tipoDoc, String iibb, String calleNroPisoDto, String cpLocalidadProvincia,
            Integer puntoVenta, Boolean activo, String rutaCrt, String rutaKey, Integer ultimoNroFactura) {
        this.id = id;
        this.codigo = codigo;
        this.razonSocial = razonSocial;
        this.categoria = categoria;
        this.cuit = cuit;
        this.tipoDoc = tipoDoc;
        this.iibb = iibb;
        this.calleNroPisoDto = calleNroPisoDto;
        this.cpLocalidadProvincia = cpLocalidadProvincia;
        this.puntoVenta = puntoVenta;
        this.activo = activo;
        this.rutaCrt = rutaCrt;
        this.rutaKey = rutaKey;
        this.ultimoNroFactura = ultimoNroFactura;
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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getIibb() {
        return iibb;
    }

    public void setIibb(String iibb) {
        this.iibb = iibb;
    }

    public String getCalleNroPisoDto() {
        return calleNroPisoDto;
    }

    public void setCalleNroPisoDto(String calleNroPisoDto) {
        this.calleNroPisoDto = calleNroPisoDto;
    }

    public String getCpLocalidadProvincia() {
        return cpLocalidadProvincia;
    }

    public void setCpLocalidadProvincia(String cpLocalidadProvincia) {
        this.cpLocalidadProvincia = cpLocalidadProvincia;
    }

    public Integer getPuntoVenta() {
        return puntoVenta;
    }

    public void setPuntoVenta(Integer puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getRutaCrt() {
        return rutaCrt;
    }

    public void setRutaCrt(String rutaCrt) {
        this.rutaCrt = rutaCrt;
    }

    public String getRutaKey() {
        return rutaKey;
    }

    public void setRutaKey(String rutaKey) {
        this.rutaKey = rutaKey;
    }

    public Integer getUltimoNroFactura() {
        return ultimoNroFactura;
    }

    public void setUltimoNroFactura(Integer ultimoNroFactura) {
        this.ultimoNroFactura = ultimoNroFactura;
    }

}
