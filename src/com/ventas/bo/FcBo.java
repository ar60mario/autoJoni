package com.ventas.bo;

import com.ventas.dao.FcDao;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.Factura;
import com.ventas.entities.Producto;
import com.ventas.entities.RenglonFc;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class FcBo {

    private final FcDao dao = new FcDao();

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
        FcBo fBo = new FcBo();
        RenglonFcBo rBo = new RenglonFcBo();
        Factura fa = fBo.saveFactura(f);
        for (RenglonFc r : renglones) {
            r.setFactura(fa);
            rBo.saveRenglon(r);
        }
    }
    
//    public void saveFacturaCompletaAndStock(Factura f, List<RenglonFc> renglones) throws Exception {
//        FcBo fBo = new FcBo();
//        RenglonFcBo rBo = new RenglonFcBo();
//        
//        Factura fa = fBo.saveFactura(f);
//        for (RenglonFc r : renglones) {
//            r.setFactura(fa);
//            rBo.saveRenglon(r);
//        }
//    }

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

    public List<Factura> getFacturaByCompraClienteMp(CompraClienteMercadoPago ccmp) throws Exception {
        List<Factura> fact = null;
        try {
            fact = dao.getFacturaByCompraClienteMp(ccmp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
}
