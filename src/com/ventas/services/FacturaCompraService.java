/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.services;

import com.ventas.bo.FacturaCompraBo;
import com.ventas.entities.FacturaCompra;
import com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class FacturaCompraService {

    public void saveFacturaCompra(FacturaCompra fc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FacturaCompraBo fBo = new FacturaCompraBo();
        try {
            fBo.saveFacturaCompra(fc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void updateFacturaCompra(FacturaCompra fc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FacturaCompraBo fBo = new FacturaCompraBo();
        try {
            fBo.updateFacturaCompra(fc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public FacturaCompra getFacturaCompraById(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FacturaCompraBo fBo = new FacturaCompraBo();
        FacturaCompra fc;
        try {
            fc = fBo.getFacturaCompraById(id);
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
    public List<FacturaCompra> getAllFacturas() throws Exception {
        List<FacturaCompra> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FacturaCompraBo fBo = new FacturaCompraBo();
        try {
            facturas = fBo.getAllFacturas();
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<FacturaCompra> getFacturasCompraPendientes() throws Exception {
        List<FacturaCompra> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FacturaCompraBo fBo = new FacturaCompraBo();
        try {
            facturas = fBo.getFacturasCompraPendientes();
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
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
