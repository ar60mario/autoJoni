package com.ventas.bo;

import com.ventas.dao.FacturaCompraDao;
import com.ventas.entities.ArticuloCompra;
import com.ventas.entities.FacturaCompra;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class FacturaCompraBo {

    private final FacturaCompraDao dao = new FacturaCompraDao();
//    private static final Logger logger = Logger.getLogger("FcBo");

    public FacturaCompra saveFacturaCompra(FacturaCompra factura) throws Exception {
        FacturaCompra fact = null;
        try {
            fact = (FacturaCompra) dao.save(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public FacturaCompra saveFacturaCompraAndArticulo(FacturaCompra factura, ArticuloCompra articulo) throws Exception {
        FacturaCompra fact = null;
        try {
            factura.setArticuloCompra(articulo);
            fact = (FacturaCompra) dao.save(factura);
            new ArticuloCompraBo().updateArticuloCompra(articulo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public FacturaCompra updateFacturaCompra(FacturaCompra factura) throws Exception {
        FacturaCompra fact = null;
        try {
            fact = (FacturaCompra) dao.update(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public FacturaCompra getFacturaCompraById(Long id) throws Exception {
        FacturaCompra fact = null;
        try {
            fact = (FacturaCompra) dao.getFacturaCompraById(id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<FacturaCompra> getFacturasCompraPendientes() throws Exception {
        List<FacturaCompra> fact = null;
        try {
            fact = (List<FacturaCompra>) dao.getFacturasCompraPendientes();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<FacturaCompra> getFacturasEntreFechas(Date de, Date al) throws Exception {
        List<FacturaCompra> fact = null;
        try {
            fact = (List<FacturaCompra>) dao.getFacturasEntreFechas(de, al);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

//    public void deleteFactura(Factura factura) throws Exception {
//        try {
//            dao.delete(factura);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public void updateFactura(Factura factura) throws Exception {
//        try {
//            dao.update(factura);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public void saveFacturaCompleta(Factura f, List<RenglonFc> renglones) throws Exception {
//        FacturaCompraBo fBo = new FacturaCompraBo();
//        Factura fa = fBo.saveFactura(f);
//        for (RenglonFc r : renglones) {
//            r.setFactura(fa);
//            RenglonFcBo rBo = new RenglonFcBo();
//            rBo.saveRenglon(r);
//        }
//    }
//
    public List<FacturaCompra> getAllFacturas() throws Exception {
        List<FacturaCompra> fact = null;
        try {
            fact = (List<FacturaCompra>) dao.getAll(FacturaCompra.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
//
//    public List<Factura> getAllFacturasActivas() throws Exception {
//        List<Factura> fact = null;
//        try {
//            fact = dao.getAllFacturasActivas();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return fact;
//    }
}
