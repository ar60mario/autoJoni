package com.ventas.dao;

import com.ventas.entities.IvaVentasPorCaja;
import com.ventas.entities.RenglonFacturaPorCaja;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RenglonFacturaPorCajaDao extends GenericDao {

    public List<RenglonFacturaPorCaja> getRenglonFacturaFromIvaVentas(IvaVentasPorCaja idIva) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFacturaPorCaja.class);
        List<RenglonFacturaPorCaja> renglones = null;
        criteria.add(Restrictions.eq("ivaVentasPorCaja", idIva));
        renglones = (List<RenglonFacturaPorCaja>) criteria.list();
        return renglones;
    }

    public List<RenglonFacturaPorCaja> getRenglonesActivosEntreFechas(Date d1, Date d2) {
        List<RenglonFacturaPorCaja> rfc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFacturaPorCaja.class);
        Criteria criteria1 = criteria.createCriteria("ivaVentas");
        criteria1.add(Restrictions.between("fecha", d1, d2));
//        criteria.add(Restrictions.eq("anulado", false));
        rfc = criteria.list();
        return rfc;
    }
}
