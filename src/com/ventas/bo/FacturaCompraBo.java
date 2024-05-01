/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bo;

import com.ventas.dao.FcDao;
import com.ventas.entities.Factura;
import com.ventas.entities.RenglonFc;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class FacturaCompraBo {

    private final FcDao dao = new FcDao();
    private static final Logger logger = Logger.getLogger("FcBo");

    public Factura saveFactura(Factura factura) throws Exception {
        Factura fact = null;
        try {
            fact = (Factura) dao.save(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public void deleteFactura(Factura factura) throws Exception {
        try {
            dao.delete(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void updateFactura(Factura factura) throws Exception {
        try {
            dao.update(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void saveFacturaCompleta(Factura f, List<RenglonFc> renglones) throws Exception {
        FacturaCompraBo fBo = new FacturaCompraBo();
        Factura fa = fBo.saveFactura(f);
        for (RenglonFc r : renglones) {
            r.setFactura(fa);
            RenglonFcBo rBo = new RenglonFcBo();
            rBo.saveRenglon(r);
        }
    }

    public List<Factura> getAllFacturas() throws Exception {
        List<Factura> fact = null;
        try {
            fact = (List<Factura>) dao.getAll(Factura.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<Factura> getAllFacturasActivas() throws Exception {
        List<Factura> fact = null;
        try {
            fact = dao.getAllFacturasActivas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
}
