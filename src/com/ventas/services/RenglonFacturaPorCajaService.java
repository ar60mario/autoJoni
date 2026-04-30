package com.ventas.services;

import com.ventas.bo.RenglonFacturaPorCajaBo;
import com.ventas.entities.IvaVentasPorCaja;
import com.ventas.entities.RenglonFacturaPorCaja;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RenglonFacturaPorCajaService {

    public void saveRenglon(RenglonFacturaPorCaja renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            RenglonFacturaPorCajaBo bo = new RenglonFacturaPorCajaBo();
            bo.saveRenglon(renglon);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<RenglonFacturaPorCaja> getRenglonesActivosEntreFechas(Date d1, Date d2) throws Exception {
        List<RenglonFacturaPorCaja> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonFacturaPorCajaBo().getRenglonesActivosEntreFechas(d1, d2);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }

    public List<RenglonFacturaPorCaja> getAllRenglonFacturaFromIvaVentas(IvaVentasPorCaja idIvaVentas) throws Exception {
        List<RenglonFacturaPorCaja> renglonFactura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonFactura = new RenglonFacturaPorCajaBo().getAllRenglonFacturaFromIvaVentas(idIvaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonFactura;
    }
}
