/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.util;

/**
 *
 * @author Marcela
 */
public class Constantes {

    public static final int MAX_RESULTS = 20;

    // Constantes de archivos
    public static final String EXTENSION_EXCEL_1 = "xls";
//    public static final String EXTENSION_EXCEL_2 = "xlsx";
//    public static final String EXTENSION_EXCEL_3 = "xlsm";
//    public static final String EXTENSION_EXCEL_4 = "xlsb";
//    public static final String EXTENSION_EXCEL_5 = "xlm";
//    public static final String EXTENSION_EXCEL_6 = "xlsm";

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static final String cuitTitular = "20300377425";
    public static final String puntoVenta = "10";
    public static final String certif = "/JONI_2024_22d9a5cec0ec4972.crt";
    public static final String llave = "/clave_privada_20300377425_202404201217.key";
    public static final String userdir = "d:/ventasJo/crt";
    public static final String ruta = "d:/ventasJo/cmprbt/";
    public static final String ruta_qr = "d://ventasJo//qr//codigoQR";
    public static final String ruta_pdf = "d://ventasJo//data//facturas_pdf//";
    public static final String ruta_logo_afip = "d://ventasJo//qr//afip.png";
    public static final String ruta_fonts = "d:/ventasJo/ttf/PF_I2OF5_TXT.ttf";
    public static final String razon_social_titular = "BELSITO JONATHAN MAXIMILIANO";
    public static final String nombre_fantasia_titular = "BELSITO JONATHAN MAXIMILIANO";
}
