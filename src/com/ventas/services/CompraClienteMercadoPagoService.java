package com.ventas.services;

import com.ventas.bo.CompraClienteMercadoPagoBo;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompraClienteMercadoPagoService {
    
//    public void deleteCompra(Compra cliente) throws Exception{
//       Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//       Transaction tx = session.beginTransaction();
//       try{
//          new CompraBo().deleteCliente(cliente);
//          tx.commit();
//       }
//       catch(Exception ex){
//           tx.rollback();
//           throw new Exception (ex);
//       }
//    }
//
//    public void saveCompra(Compra compra) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new CompraBo().saveCompra(compra);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
    public CompraClienteMercadoPago getComprobanteCompraClientesMercadoPago(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        CompraClienteMercadoPago ccmp;
        try {
            ccmp = new CompraClienteMercadoPagoBo().getComprobanteCompraClientesMercadoPago(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            ccmp = null;
            throw new Exception(ex);
        }
        return ccmp;
    }
    
    
    public void saveCompraClientesImportados(List<CompraClienteMercadoPago> compra) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CompraClienteMercadoPagoBo().saveCompraClientesImportados(compra);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<CompraClienteMercadoPago> getComprasParaProcesar(Double limiteCompras) throws Exception {
        List<CompraClienteMercadoPago> compras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            compras = new CompraClienteMercadoPagoBo().getComprasParaProcesar(limiteCompras);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return compras;
    }

    public List<CompraClienteMercadoPago> getAllFacturasPendientesDeProcesar() throws Exception {
        List<CompraClienteMercadoPago> compras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            compras = new CompraClienteMercadoPagoBo().getAllFacturasPendientesDeProcesar();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return compras;
    }
    
    public List<CompraClienteMercadoPago> getAllFacturasProcesadas() throws Exception {
        List<CompraClienteMercadoPago> compras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            compras = new CompraClienteMercadoPagoBo().getAllFacturasProcesadas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return compras;
    }
//    public void updateCompra(Compra compra) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new CompraBo().updateCompra(compra);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//    
//    public List<Compra> getCompraOrdenado() throws Exception{
//        List<Compra> compras = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            compras = new CompraBo().getComprasOrdenado();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return compras;
//    }
//    
//    public List<Compra> getCompraPorComprobante(String nro) throws Exception{
//        List<Compra> compras = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            compras = new CompraBo().getCompraPorComprobante(nro);
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return compras;
//    }
//    
//    public List<Compra> getComprasEntreFechas(Date de, Date al) throws Exception {
//        List<Compra> compras = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            compras = new CompraBo().getComprasEntreFechas(de, al);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return compras;
//    }
}
