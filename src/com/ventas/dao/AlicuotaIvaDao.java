/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ventas.dao;

import com.ventas.entities.AlicuotaIva;
import com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrador
 */
public class AlicuotaIvaDao extends GenericDao{

    public AlicuotaIva getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(AlicuotaIva.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        AlicuotaIva alicuotaIva = (AlicuotaIva) criteria.uniqueResult();
        return alicuotaIva;
    }
    
    public <T> List getAllOrdenado(Class<T> clase) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(clase);
        criteria.addOrder(Order.asc("codigo"));
        return criteria.list();
    }
}
