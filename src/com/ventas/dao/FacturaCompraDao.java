/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ventas.entities.Factura;
import com.ventas.entities.FacturaCompra;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class FacturaCompraDao extends GenericDao {

//    public List<Factura> getFacturasEntreFechas(Date fd, Date fa) {
//        List<Factura> fact = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        fact = (List<Factura>) session.createCriteria(Factura.class)
//                .add(Restrictions.between("fecha", fd, fa))
//                .addOrder(Order.asc("fecha"))
//                .addOrder(Order.asc("letra"))
//                .addOrder(Order.asc("numeroFactura"))
//                .list();
//        return fact;
//    }

    public List<FacturaCompra> getFacturasCompraPendientes() {
        List<FacturaCompra> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<FacturaCompra>) session.createCriteria(FacturaCompra.class)
                .add(Restrictions.eq("procesado", false))
                .list();
        return fact;
    }

    public FacturaCompra getFacturaCompraById(Long id) {
        FacturaCompra fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (FacturaCompra) session.createCriteria(FacturaCompra.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return fact;
    }
    /*
    public IvaVentas getFacturaByLetraNumero(String letra, Integer numero){
        IvaVentas factura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        factura = (IvaVentas)
                session.createCriteria(IvaVentas.class)
                .add(Restrictions.and(Restrictions.eq("letra", letra)
                        ,Restrictions.eq("numeroFactura", numero)))
                .uniqueResult();
        return factura;
    }*/
}
