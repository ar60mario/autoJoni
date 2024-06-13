/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ventas.dao;

import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.NuevaFactura;
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
public class NuevaFacturaDao extends GenericDao{

    public NuevaFactura getNuevaFacturaByCompraMP(CompraClienteMercadoPago ccmp) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(NuevaFactura.class);
        criteria.add(Restrictions.eq("compraMercadoPago", ccmp));
        NuevaFactura nFc = (NuevaFactura) criteria.uniqueResult();
        return nFc;
    }

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
