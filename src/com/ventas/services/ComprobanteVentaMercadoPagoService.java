package com.ventas.services;

import com.ventas.bo.CompraBo;
import com.ventas.bo.ComprobanteVentaMercadoPagoBo;
import com.ventas.entities.Cliente;
import com.ventas.entities.Compra;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.FacturaCompra;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComprobanteVentaMercadoPagoService {

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
    public void saveComprobanteCompleto(Cliente cliente, Boolean nuevo, Double gravado, Double iva,
            Double impuesto, Double total, CompraClienteMercadoPago ccmp, FacturaCompra facturaCompra, FacturaIvaIntercambio fii) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            if (nuevo) {
                new ComprobanteVentaMercadoPagoBo().saveComprobanteCompleto1(cliente, gravado, iva,
                        impuesto, total, ccmp, facturaCompra, fii);
            } else {
//                new ComprobanteVentaMercadoPagoBo().saveComprobanteCompleto2(cliente, gravado, iva,
//                        impuesto, total, compraMercadoPago, facturaCompra);
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

//    public List<Compra> getAllCompras() throws Exception {
//        List<Compra> compras = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            compras = new CompraBo().getAllCompra();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return compras;
//    }
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
