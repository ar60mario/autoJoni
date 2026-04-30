package com.ventas.dao;

import com.ventas.entities.FcTemp;
import com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

public class FcTempDao extends GenericDao {

    public List<FcTemp> getFacturasPendientesDeEnviarArca() {
        List<FcTemp> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FcTemp.class);
        criteria.add(Restrictions.eq("anulada", false));
        facturas = criteria.list();
        return facturas;
    }
    
//    public NuevaFactura getNuevaFacturaByCompraMP(CompraClienteMercadoPago ccmp) {
//        
//        
//        criteria.add(Restrictions.eq("compraMercadoPago", ccmp));
//        NuevaFactura nFc = (NuevaFactura) criteria.uniqueResult();
//        return nFc;
//    }

//    public Cliente getByCodigo(String codigo) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("codigo", codigo));
//        
//        Cliente cliente = (Cliente) criteria.uniqueResult();
//        return cliente;
//    }
//    
//    public Cliente getUltimoCliente() {
//        List<Cliente> cs = null; 
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.addOrder(Order.desc("codigo"));
//        Cliente cliente = null;
//        cs = (List<Cliente>) criteria.list();
//        cliente = cs.get(0);
//        return cliente;
//    }
//    
//    public List<Cliente> getAllClientesOrdenado() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.addOrder(Order.asc("razonSocial"));
//        return (List<Cliente>) criteria.list();
//    }
//    
//    public List<Cliente> getClientesByFiltro(String filtro) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.razonSocial like :filtro ");
//        sb.append("order by clie.razonSocial asc");
//        
//        Query query = session.createQuery(sb.toString());
//        query.setParameter("filtro", "%"+filtro+"%");
//        
//        clientes = (List<Cliente>) query.list();
//                
//        return clientes;
//    }
}
