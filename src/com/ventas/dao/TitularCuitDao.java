package com.ventas.dao;

import com.ventas.dao.GenericDao;
import com.ventas.entities.TitularCuit;
import com.ventas.util.HibernateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class TitularCuitDao extends GenericDao {

    public List<TitularCuit> getTitularCuitActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(TitularCuit.class);
        criteria.add(Restrictions.eq("activo", true));
        List<TitularCuit> titulares = (List<TitularCuit>) criteria.list();
        return titulares;
    }
    
    public TitularCuit getTitularCuitByCuit(String cuit) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(TitularCuit.class);
//        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("cuit", cuit));
        TitularCuit titular = (TitularCuit) criteria.uniqueResult();
        return titular;
    }

    public TitularCuit getUltimoTitularCuit() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(TitularCuit.class);
        criteria.addOrder(Order.desc("id"));
        List<TitularCuit> tcs = (List<TitularCuit>) criteria.list();
        if (tcs.isEmpty()) {
            return null;
        } else {
            TitularCuit cc = tcs.get(0);
            return cc;
        }
    }

//    public List<CCCliente> getAllMovimientosByCliente(Cliente cliente) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(CCCliente.class);
//        criteria.add(Restrictions.eq("cliente", cliente));
//        criteria.addOrder(Order.asc("id"));
//        List<CCCliente> movim = (List<CCCliente>) criteria.list();
//        return movim;
//    }
//
//    

//
//    public <T> List getAllOrdenado(Class<T> clase) throws HibernateException {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(clase);
//        criteria.addOrder(Order.asc("codigo"));
//        return criteria.list();
//    }
//
//    public <T> List getAllRubrosActivos() throws HibernateException {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Producto.class);
//        criteria.add(Restrictions.eq("activo", true));
//        criteria.addOrder(Order.asc("codigo"));
//        return criteria.list();
//    }
//
//    public List<Producto> getAllProductosByCodigos(Integer co1, Integer co2) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Producto.class);
//        criteria.add(Restrictions.or(Restrictions.eq("codigo", co1),
//                Restrictions.eq("codigo", co2),
//                Restrictions.and(Restrictions.lt("codigo", co2),
//                        Restrictions.gt("codigo", co1))));
//        criteria.addOrder(Order.asc("codigo"));
//        List<Producto> productos = (List<Producto>) criteria.list();
//        return productos;
//    }
}
