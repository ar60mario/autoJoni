/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author argia
 */
public class FacturaCompraReferenciaMercadoPagoDao extends GenericDao {
    
    public FacturaCompraReferenciaMercadoPago getFacturaById(Long id) {
        FacturaCompraReferenciaMercadoPago fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (FacturaCompraReferenciaMercadoPago) session.createCriteria(FacturaCompraReferenciaMercadoPago.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return fact;
    }
    
    public FacturaCompraReferenciaMercadoPago getFacturaByIvaVentas(IvaVentas iv) {
        FacturaCompraReferenciaMercadoPago fact;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (FacturaCompraReferenciaMercadoPago) session.createCriteria(FacturaCompraReferenciaMercadoPago.class)
                .add(Restrictions.eq("ivaVentas", iv))
                .uniqueResult();
        return fact;
    }
}
