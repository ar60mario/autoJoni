/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.dao;

import com.ventas.entities.Cliente;
import com.ventas.entities.IvaVentas;
import com.ventas.util.HibernateUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 *
 * @author Marcela
 */
public class IvaVentasDao extends GenericDao {

    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.between("fecha", fd, fa))
                //  .add(Restrictions.eq("panificado", false))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getFacturasEntreFechasOrdenCliente(Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(IvaVentas.class);
        Criteria criteria2 = criteria.createCriteria("cliente");
        criteria.add(Restrictions.between("fecha", fd, fa));
        criteria2.addOrder(Order.asc("razonSocial"));
        criteria.addOrder(Order.asc("letra"));
        criteria.addOrder(Order.asc("numeroFactura"));
        fact = (List<IvaVentas>) criteria.list();
        return fact;
    }

    public String getUltimaFechaFactura() {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                //                        .add(Restrictions.between("fecha", fd, fa))
                //  .add(Restrictions.eq("panificado", false))
                .setMaxResults(3)
                .addOrder(Order.desc("fecha"))
                //                        .addOrder(Order.asc("letra"))
                .addOrder(Order.desc("numeroFactura"))
                .list();
        Date fecha = fact.get(0).getFecha();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    public Integer getUltimoNumeroFactura() {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.eq("numeroSucursal", 10))
                .add(Restrictions.eq("tipoDoc", 6))
                .setMaxResults(3)
                .addOrder(Order.desc("numeroFactura"))
                //                        .addOrder(Order.asc("letra"))
                //                        .addOrder(Order.desc("numeroFactura"))
                .list();
        Integer numero = fact.get(0).getNumeroFactura();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return numero;
    }

    public List<IvaVentas> getFacturasPanificadosEntreFechas(Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("numeroSucursal", 7))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getFacturasCigarrillosEntreFechas(Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("numeroSucursal", 6))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getFacturasByCodigoAndFechas(Cliente cliente, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("cliente", cliente))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public IvaVentas getByLetraNumero(String letra, Integer sucursal, Integer numero) {
        IvaVentas factura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from IvaVentas iv ");
        sb.append("where iv.letra = '" + letra + "' and iv.numeroSucursal = '"
                + sucursal + "' and iv.numeroFactura = '" + numero + "' ");
        Query query = session.createQuery(sb.toString());
        factura = (IvaVentas) query.uniqueResult();
        return factura;
    }
}
