/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ventas.entities.Factura;
import com.ventas.entities.RenglonFc;
import com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class RenglonFcDao extends GenericDao{
    
    public List<RenglonFc> getRenglonesByFactura(Factura f) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<RenglonFc> renglones = null;
        StringBuffer sb = new StringBuffer();
        sb.append("from RenglonFc rf ");
        sb.append("where rf.factura = :f ");
        sb.append("and rf.anulado != true ");
        Query query = session.createQuery(sb.toString());
        query.setParameter("f",  f);
        renglones = (List<RenglonFc>) query.list();
        return renglones;
    }
    
    public List<RenglonFc> getAllRenglonesActivos() {
        List<RenglonFc> rfc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        // Criteria criteria = session.createCriteria(RenglonFc.class);
        rfc = (List<RenglonFc>) 
                session.createCriteria(RenglonFc.class)
                        .add(Restrictions.eq("anulado", false))
                        .list();
//        criteria.add(Restrictions.eq("anulado", false));
        //rfc = criteria.list();
        return rfc;
    }
}
