
package com.ventas.dao;

import com.ventas.entities.Rubro;
import com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class RubroDao extends GenericDao {

    public Rubro getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Rubro.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        Rubro rubro = (Rubro) criteria.uniqueResult();
        return rubro;
    }

    public <T> List getAllOrdenado(Class<T> clase) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(clase);
        criteria.addOrder(Order.asc("codigo"));
        return criteria.list();
    }
    
    public List<Rubro> getRubrosByNroMarca(int nroMarca) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Rubro.class);
        criteria.add(Restrictions.eq("tipoMarca", nroMarca));
        criteria.addOrder(Order.asc("codigo"));
        return criteria.list();
    }
}
