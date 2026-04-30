package com.ventas.services;

import com.ventas.bo.FacturaCompraBo;
import com.ventas.bo.FacturaCompraReferenciaMercadoPagoBo;
import com.ventas.entities.FacturaCompra;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FacturaCompraReferenciaMercadoPagoService {

    public FacturaCompraReferenciaMercadoPagoBo fBo = new FacturaCompraReferenciaMercadoPagoBo();

    public FacturaCompraReferenciaMercadoPago getFacturaByIvaVentas(IvaVentas iv) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
//        FacturaCompraReferenciaMercadoPagoBo fBo = new FacturaCompraReferenciaMercadoPagoBo();
        FacturaCompraReferenciaMercadoPago fc;
        try {
            fc = fBo.getFacturaByIvaVentas(iv);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            fc = null;
            throw new Exception(ex);
        }
        return fc;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasMercadoPagoEntreFechas(Date de, Date al)
            throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
//        FacturaCompraReferenciaMercadoPagoBo fBo = new FacturaCompraReferenciaMercadoPagoBo();
        List<FacturaCompraReferenciaMercadoPago> fc;
        try {
            fc = fBo.getFacturasMercadoPagoEntreFechas(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            fc = null;
            throw new Exception(ex);
        }
        return fc;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechas(Date de, Date al)
            throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
//        FacturaCompraReferenciaMercadoPagoBo fBo = new FacturaCompraReferenciaMercadoPagoBo();
        List<FacturaCompraReferenciaMercadoPago> fc;
        try {
            fc = fBo.getFacturasIvaVentasEntreFechas(de, al);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            fc = null;
            throw new Exception(ex);
        }
        return fc;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechasAndOperacion(Date de,
            Date al, String operacion)
            throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<FacturaCompraReferenciaMercadoPago> fc;
        try {
            fc = fBo.getFacturasIvaVentasEntreFechasAndOperacion(de, al, operacion);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            fc = null;
            throw new Exception(ex);
        }
        return fc;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechasAndNombre(Date de,
            Date al, String nombre)
            throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<FacturaCompraReferenciaMercadoPago> fc;
        try {
            fc = fBo.getFacturasIvaVentasEntreFechasAndNombre(de, al, nombre);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            fc = null;
            throw new Exception(ex);
        }
        return fc;
    }
    
    public List<FacturaCompraReferenciaMercadoPago>
            getFacturasIvaVentasEntreFechasAndCuit(Date de, Date al, String cuit)
            throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
//        FacturaCompraReferenciaMercadoPagoBo fBo = new FacturaCompraReferenciaMercadoPagoBo();
        List<FacturaCompraReferenciaMercadoPago> fc;
        try {
            fc = fBo.getFacturasIvaVentasEntreFechasAndCuit(de, al, cuit);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            fc = null;
            throw new Exception(ex);
        }
        return fc;
    }

    public void saveFacturaCompraRmp(FacturaCompraReferenciaMercadoPago fc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
//        FacturaCompraReferenciaMercadoPagoBo fBo = new FacturaCompraReferenciaMercadoPagoBo();
        try {
            fBo.saveFacturaCompraReferenciaMercadoPago(fc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

//    public void updateFacturaCompra(FacturaCompra fc) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        FacturaCompraBo fBo = new FacturaCompraBo();
//        try {
//            fBo.updateFacturaCompra(fc);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
    public FacturaCompraReferenciaMercadoPago getFacturaById(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
//        FacturaCompraReferenciaMercadoPagoBo fBo = new FacturaCompraReferenciaMercadoPagoBo();
        FacturaCompraReferenciaMercadoPago fc;
        try {
            fc = fBo.getFacturaById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            fc = null;
            throw new Exception(ex);
        }
        return fc;
    }

//    public void deleteFactura(Factura fc) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        FcBo fBo = new FcBo();
//        try {
//            fBo.deleteFactura(fc);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void updateFactura(Factura fc) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        FcBo fBo = new FcBo();
//        try {
//            fBo.updateFactura(fc);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//    
//    public List<FacturaCompra> getAllFacturas() throws Exception {
//        List<FacturaCompra> facturas = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        FacturaCompraBo fBo = new FacturaCompraBo();
//        try {
//            facturas = fBo.getAllFacturas();
//            tx.commit();
//        } catch (HibernateException ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return facturas;
//    }
//    
//    public List<FacturaCompra> getFacturasCompraPendientes() throws Exception {
//        List<FacturaCompra> facturas = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        FacturaCompraBo fBo = new FacturaCompraBo();
//        try {
//            facturas = fBo.getFacturasCompraPendientes();
//            tx.commit();
//        } catch (HibernateException ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return facturas;
//    }
//    
//    public List<Factura> getAllFacturasActivas() throws Exception {
//        List<Factura> facturas = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        FcBo fBo = new FcBo();
//        try {
//            facturas = fBo.getAllFacturasActivas();
//            tx.commit();
//        } catch (HibernateException ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return facturas;
//    }
//    /*   
//    public void saveNotaCredito(IvaVentas iv, List<RenglonNotaCredito> rf) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        IvaVentasBO ivaBO = new IvaVentasBO();
//        IvaVentas ivaVentas = ivaBO.saveIvaVentas(iv);
//        Boolean bolean = true;
//        for (RenglonNotaCredito renglon : rf) {
//            renglon.setIvaVentas(ivaVentas);
//            try {
//                RenglonNotaCreditoBO bo = new RenglonNotaCreditoBO();
//                bo.saveRenglon(renglon);
//            } catch (Exception ex) {
//                bolean = false;
//                tx.rollback();
//                throw new Exception(ex);
//            }
//        }
//        if (bolean) {
//            tx.commit();
//        }
//    }
//    
//     */
}
