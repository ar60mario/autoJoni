package com.ventas.dao;

import com.ventas.entities.Fabricante;
import com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class FabricanteDao extends GenericDao{

//    public Fabricante getByCuit(String cuit) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Fabricante.class);
//        criteria.add(Restrictions.eq("cuit", cuit));
//        Fabricante cliente = (Fabricante) criteria.uniqueResult();
//        return cliente;
//    }

    public Fabricante getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Fabricante.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        
        Fabricante cliente = (Fabricante) criteria.uniqueResult();
        return cliente;
    }
    
    public Fabricante getUltimoFabricante() {
        List<Fabricante> cs = null; 
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Fabricante.class);
        criteria.addOrder(Order.desc("codigo"));
        Fabricante fabricante = null;
        cs = (List<Fabricante>) criteria.list();
        fabricante = cs.get(0);
        return fabricante;
    }
    
    public List<Fabricante> getAllFabricantesOrdenado() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Fabricante.class);
        criteria.addOrder(Order.asc("nombre"));
        return (List<Fabricante>) criteria.list();
    }
    
    public List<Fabricante> getAllFabricantesOrdenadoActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Fabricante.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("nombre"));
        return (List<Fabricante>) criteria.list();
    }
    
    public List<Fabricante> getFabricantesByFiltro(String filtro) {
        List<Fabricante> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
        StringBuffer sb = new StringBuffer();
        sb.append("from Fabricante clie ");
        sb.append("where clie.nombre like :filtro ");
        sb.append("order by clie.nombre asc");
        
        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%"+filtro+"%");
        
        clientes = (List<Fabricante>) query.list();
                
        return clientes;
    }
}
