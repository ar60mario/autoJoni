package com.ventas.util;

import com.ventas.estructuras.CategoriaArca;

public class UtilCliente {

    public static String getCategoria(Integer categoria) {
        String categ = "";
        switch (categoria) {
            case 0:
                categ = CategoriaArca.INSCRIPTO.getDetalle();
                break;
            case 1:
                categ = CategoriaArca.EXENTO.getDetalle();
                break;
            case 2:
                categ = CategoriaArca.CONS_FINAL.getDetalle();
                break;
            case 3:
                categ = CategoriaArca.MONOTRIBUTO.getDetalle();
                break;
            default:
                categ = "Cons. Final";
        }
        return categ;
    }
    
    
}
