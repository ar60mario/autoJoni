package com.ventas.util;

import com.ventas.services.ProductoService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UtilProducto {
    public static Integer getUltimoCodigoProducto(){
        Integer codigo = 0;
        try {
            codigo = new ProductoService().getUltimoCodigo();
        } catch (Exception ex) {
            Logger.getLogger(UtilProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 12 - PRODUCTO");
            return null;
        }
        return codigo;
    }
}
