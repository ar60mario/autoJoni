package com.ventas.dao;

import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
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

    public List<FacturaCompraReferenciaMercadoPago> getFacturasMercadoPagoEntreFechas(Date de, Date al) {
        List<FacturaCompraReferenciaMercadoPago> facts;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaCompraReferenciaMercadoPago.class);
        Criteria criteria2 = criteria.createCriteria("ivaVentas");
        criteria2.add(Restrictions.between("fecha", de, al));
        facts = (List<FacturaCompraReferenciaMercadoPago>) criteria.list();
        return facts;
    }

    public FacturaCompraReferenciaMercadoPago getFacturaByIvaVentas(IvaVentas iv) {
        FacturaCompraReferenciaMercadoPago fact;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (FacturaCompraReferenciaMercadoPago) session
                .createCriteria(FacturaCompraReferenciaMercadoPago.class)
                .add(Restrictions.eq("ivaVentas", iv))
                .uniqueResult();
        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechas(Date de, Date al) {
        List<FacturaCompraReferenciaMercadoPago> fact;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaCompraReferenciaMercadoPago.class);
        Criteria criteria1 = criteria.createCriteria("ivaVentas");
        criteria1.add(Restrictions.between("fecha", de, al));
        criteria1.addOrder(Order.asc("fecha"));
        fact = (List<FacturaCompraReferenciaMercadoPago>) criteria.list();

        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechasAndOperacion(Date de,
            Date al, String operacion) {
        List<FacturaCompraReferenciaMercadoPago> fact;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaCompraReferenciaMercadoPago.class);
        Criteria criteria2 = criteria.createCriteria("compraClienteMercadoPago");
        Criteria criteria1 = criteria.createCriteria("ivaVentas");
        criteria1.add(Restrictions.between("fecha", de, al));
        criteria2.add(Restrictions.like("operacion", operacion + "%"));
        criteria1.addOrder(Order.asc("fecha"));
        fact = (List<FacturaCompraReferenciaMercadoPago>) criteria.list();

        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechasAndNombre(Date de,
            Date al, String nombre) {
        List<FacturaCompraReferenciaMercadoPago> fact;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaCompraReferenciaMercadoPago.class);
        Criteria criteria1 = criteria.createCriteria("ivaVentas");
        criteria1.add(Restrictions.between("fecha", de, al));
        criteria1.add(Restrictions.like("razonSocialCliente", "%" + nombre + "%"));
        criteria1.addOrder(Order.asc("fecha"));
        fact = (List<FacturaCompraReferenciaMercadoPago>) criteria.list();

        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago>
            getFacturasIvaVentasEntreFechasAndCuit(Date de, Date al, String cuit) {
        List<FacturaCompraReferenciaMercadoPago> fact;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(FacturaCompraReferenciaMercadoPago.class);
        Criteria criteria1 = criteria.createCriteria("ivaVentas");
        Criteria criteria2 = criteria1.createCriteria("cliente");
        criteria1.add(Restrictions.between("fecha", de, al));
        criteria2.add(Restrictions.eq("cuit", cuit));
        criteria1.addOrder(Order.asc("fecha"));
        fact = (List<FacturaCompraReferenciaMercadoPago>) criteria.list();

        return fact;
    }
}
