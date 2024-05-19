/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.util.HibernateUtils;
import java.util.Date;
//import org.hibernate.classic.Session;
import org.hibernate.Session;
import org.hibernate.Criteria;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CompraClienteMercadoPagoDao extends GenericDao {

    public CompraClienteMercadoPago getComprobanteCompraClientesMercadoPago(Long id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CompraClienteMercadoPago.class);
        criteria.add(Restrictions.eq("id", id));
        return (CompraClienteMercadoPago) criteria.uniqueResult();
    }
//    
//    public List<CompraClienteMercadoPago> getComprasParaProcesar() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(CompraClienteMercadoPago.class);
//        criteria.add(Restrictions.eq("procesado", false));
//        criteria.addOrder(Order.asc("fecha"));
//        return (List<CompraClienteMercadoPago>) criteria.list();
//    }
    
    public List<CompraClienteMercadoPago> getAllFacturasPendientesDeProcesar() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CompraClienteMercadoPago.class);
        criteria.add(Restrictions.eq("procesado", false));
        criteria.addOrder(Order.asc("fecha"));
        return (List<CompraClienteMercadoPago>) criteria.list();
    }
//
//    public List<Compra> getComprasEntreFechas(Date de, Date al) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Compra.class);
//        criteria.add(Restrictions.between("fecha", de, al));
//        return (List<Compra>) criteria.list();
//    }
}
