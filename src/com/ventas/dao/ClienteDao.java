package com.ventas.dao;

import com.ventas.entities.Cliente;
import com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

public class ClienteDao extends GenericDao {

    public Cliente getByCuit(String cuit) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("cuit", cuit));
        Cliente cliente = (Cliente) criteria.uniqueResult();
        return cliente;
    }

    public Cliente getByCodigo(String codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("codigo", codigo));

        Cliente cliente = (Cliente) criteria.uniqueResult();
        return cliente;
    }

    public Cliente getUltimoCliente() {
        List<Cliente> cs = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.addOrder(Order.desc("codigo"));
        Cliente cliente = null;
        cs = (List<Cliente>) criteria.list();
        cliente = cs.get(0);
        return cliente;
    }

    public List<Cliente> getAllClientesOrdenado() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Cliente>) criteria.list();
    }

    public List<Cliente> getClientesByFiltro(String filtro) {
        List<Cliente> clientes;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Cliente clie ");
        sb.append("where clie.razonSocial like :filtro ");
        sb.append("order by clie.razonSocial asc");

        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");

        clientes = (List<Cliente>) query.list();

        return clientes;
    }

    public List<Cliente> getClientesByFiltroFacturaA(String filtro) {
        List<Cliente> clientes;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("razonSocial", "%" + filtro + "%"));
        criteria.add(Restrictions.lt("categoriaDeIva", 4));
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Cliente>) criteria.list();
    }
}
