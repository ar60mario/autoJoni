/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package com.ventas.bo;

import com.ventas.dao.CompraClienteMercadoPagoDao;
import com.ventas.entities.CompraClienteMercadoPago;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CompraClienteMercadoPagoBo {

    private final CompraClienteMercadoPagoDao dao = new CompraClienteMercadoPagoDao();

//    public List<Compra> getAllCompra() throws Exception {
//        List<Compra> listCompras = null;
//
//        try {
//            listCompras = dao.getAll(Compra.class);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listCompras;
//    }
//
//    public Compra saveCompra(Compra compra) throws Exception {
//        try {
//            dao.save(compra);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return compra;
//    }

    public void saveCompraClientesImportados(List<CompraClienteMercadoPago> compra) throws Exception {
        for (CompraClienteMercadoPago ccmp : compra) {
            try {
                dao.save(ccmp);
            } catch (HibernateException ex) {
                throw new Exception(ex);
            }
        }
    }

//    public void updateCompra(Compra compra) throws Exception {
//        try {
//            compra = (Compra) dao.update(compra);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//
//    }
//
//    public void deleteCliente(Compra compra) throws Exception {
//        try {
//            dao.delete(compra);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Compra> getComprasOrdenado() throws Exception {
//        List<Compra> listadoCompras = null;
//        try {
//            listadoCompras = dao.getAllCompraOrdenado();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listadoCompras;
//    }
//
//    public List<Compra> getCompraPorComprobante(String nro) throws Exception {
//        List<Compra> listadoCompras = null;
//        try {
//            listadoCompras = dao.getCompraPorComprobante(nro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listadoCompras;
//    }
//
//    public List<Compra> getComprasEntreFechas(Date de, Date al) throws Exception {
//        List<Compra> listCompras = null;
//        try {
//            listCompras = dao.getComprasEntreFechas(de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listCompras;
//    }
}
