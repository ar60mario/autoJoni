package com.ventas.bo;

import com.ventas.dao.FacturaCompraReferenciaMercadoPagoDao;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author argia
 */
public class FacturaCompraReferenciaMercadoPagoBo {

    private final FacturaCompraReferenciaMercadoPagoDao dao = new FacturaCompraReferenciaMercadoPagoDao();

    public FacturaCompraReferenciaMercadoPago
            saveFacturaCompraReferenciaMercadoPago(FacturaCompraReferenciaMercadoPago fcrmp)
            throws Exception {
        FacturaCompraReferenciaMercadoPago fact = null;
        try {
            fact = (FacturaCompraReferenciaMercadoPago) dao.save(fcrmp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago>
            getFacturasMercadoPagoEntreFechas(Date de, Date al)
            throws Exception {
        List<FacturaCompraReferenciaMercadoPago> fact = null;
        try {
            fact = (List<FacturaCompraReferenciaMercadoPago>) dao.getFacturasMercadoPagoEntreFechas(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public FacturaCompraReferenciaMercadoPago getFacturaById(Long id)
            throws Exception {
        FacturaCompraReferenciaMercadoPago fact = null;
        try {
            fact = (FacturaCompraReferenciaMercadoPago) dao.getFacturaById(id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public FacturaCompraReferenciaMercadoPago getFacturaByIvaVentas(IvaVentas iv)
            throws Exception {
        FacturaCompraReferenciaMercadoPago fact = null;
        try {
            fact = (FacturaCompraReferenciaMercadoPago) dao.getFacturaByIvaVentas(iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechas(Date de, Date al)
            throws Exception {
        List<FacturaCompraReferenciaMercadoPago> fact;
        try {
            fact = (List<FacturaCompraReferenciaMercadoPago>) dao
                    .getFacturasIvaVentasEntreFechas(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechasAndOperacion(Date de,
            Date al, String operacion) throws Exception {
        List<FacturaCompraReferenciaMercadoPago> fact;
        try {
            fact = (List<FacturaCompraReferenciaMercadoPago>) dao
                    .getFacturasIvaVentasEntreFechasAndOperacion(de, al, operacion);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago> getFacturasIvaVentasEntreFechasAndNombre(Date de,
            Date al, String nombre) throws Exception {
        List<FacturaCompraReferenciaMercadoPago> fact;
        try {
            fact = (List<FacturaCompraReferenciaMercadoPago>) dao
                    .getFacturasIvaVentasEntreFechasAndNombre(de, al, nombre);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<FacturaCompraReferenciaMercadoPago>
            getFacturasIvaVentasEntreFechasAndCuit(Date de, Date al, String cuit)
            throws Exception {
        List<FacturaCompraReferenciaMercadoPago> fact;
        try {
            fact = (List<FacturaCompraReferenciaMercadoPago>) dao
                    .getFacturasIvaVentasEntreFechasAndCuit(de, al, cuit);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

}
