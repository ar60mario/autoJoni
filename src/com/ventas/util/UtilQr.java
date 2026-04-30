package com.ventas.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class UtilQr {

    public static String ver_qr = "1";
    public static DecimalFormat df_qr = new DecimalFormat("#0.00");
    public static SimpleDateFormat sdf_qr = new SimpleDateFormat("yyyy-MM-dd");
    private static int qrTamAncho = 150;
    private static int qrTamAlto = 150;
    private static String url_qr = "https://www.afip.gob.ar/fe/qr/?p=";
    private static String formato = "png";
    private static String ruta = Constantes.ruta_qr;
    private static String extension = ".png";

    public static String crearDataQr(Date fechaCmpbte, String cuitTitular, String ptoVta,
            Integer nroCpbte, String tipoCompr, Double totalFc, String tipoDocumReceptor,
            String nroDocumReceptor, String caeNro) {
        String fechaC = sdf_qr.format(fechaCmpbte);
        String cuit_qr = cuitTitular;
        String puntoVenta_qr = ptoVta;
        String tipoComprobante_qr = tipoCompr;
        String numeroComprobante_qr = nroCpbte.toString();
        String importe_qr = df_qr.format(totalFc).replace(",", ".");
        String moneda_qr = "PES";
        String cotiz_qr = "1";
        String tipoDoc_qr = tipoDocumReceptor;
        String numeroDoc_qr = nroDocumReceptor;
        String tipoCodigoAutoriz_qr = "E";
        String nroCae_qr = caeNro;
        String data = "{\"ver\":" + ver_qr
                + ",\"fecha\":\"" + fechaC + "\""
                + ",\"cuit\":" + cuit_qr
                + ",\"ptoVta\":" + puntoVenta_qr
                + ",\"tipoCmp\":" + tipoComprobante_qr
                + ",\"nroCmp\":" + numeroComprobante_qr
                + ",\"importe\":" + importe_qr
                + ",\"moneda\":\"" + moneda_qr + "\""
                + ",\"ctz\":" + cotiz_qr
                + ",\"tipoDocRec\":" + tipoDoc_qr
                + ",\"nroDocRec\":" + numeroDoc_qr
                + ",\"tipoCodAut\":\"" + tipoCodigoAutoriz_qr + "\""
                + ",\"codAut\":" + nroCae_qr + "}";
        return data;
    }

    public static void generarPngQr(String data, String numeroFactura) throws Exception {
        String cadenaCodificada = Base64.getEncoder().encodeToString(data.getBytes());
        BitMatrix matriz;
        Writer writer = new QRCodeWriter();
        try {
            matriz = writer.encode(url_qr + cadenaCodificada, BarcodeFormat.QR_CODE, qrTamAncho, qrTamAlto);
        } catch (WriterException e) {
            e.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "ERROR GENERANDO QR");
            return;
        }
        BufferedImage imagen = new BufferedImage(qrTamAncho,
                qrTamAlto, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < qrTamAlto; y++) {
            for (int x = 0; x < qrTamAncho; x++) {
                int valor = (matriz.get(x, y) ? 0 : 1) & 0xff;
                imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
            }
        }
        FileOutputStream qrCode;
        qrCode = new FileOutputStream(ruta + numeroFactura + extension);
        ImageIO.write(imagen, formato, qrCode);
        qrCode.close();
    }

}
