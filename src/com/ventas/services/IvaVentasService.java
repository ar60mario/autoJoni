package com.ventas.services;

import com.ventas.bo.IvaVentasBo;
import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.Configuracion;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.RenglonFactura;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class IvaVentasService {

    public final IvaVentasBo bo = new IvaVentasBo();
    
    public IvaVentas saveIvaVentas(IvaVentas ivaVentas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBo().saveIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public void saveIvaVentasCompletoMp(IvaVentas ivaVentas, 
            FacturaCompraReferenciaMercadoPago fcrmp, CompraClienteMercadoPago ccmp,
            List<RenglonFactura> renglones, Configuracion cfg) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new IvaVentasBo().saveIvaVentasCompletoMp(ivaVentas, fcrmp, ccmp, renglones, cfg);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public IvaVentas updateIvaVentas(IvaVentas ivaVentas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBo().updateIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentas saveIvaVentasCompleto(IvaVentas ivaVentas, List<RenglonFactura> renglones) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBo().saveIvaVentasCompleto(ivaVentas, renglones);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentas> getAllIvaVentas() throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBo().getAllIvaVentas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public String getUltimaFechaFactura(String cuitTitular) throws Exception {
        String fe = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fe = new IvaVentasBo().getUltimaFechaFactura(cuitTitular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }
    
    public IvaVentas getUltimaFactura(Integer td) throws Exception {
        IvaVentas fe = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fe = new IvaVentasBo().getUltimaFactura(td);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }

    public String getUltimaNombreEnFactura() throws Exception {
        String fe = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fe = new IvaVentasBo().getUltimaNombreEnFactura();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }

    public String getUltimoCuitEnFactura() throws Exception {
        String fe = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fe = new IvaVentasBo().getUltimoCuitEnFactura();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }

    public String getUltimoImporteFactura(String cuitTitular) throws Exception {
        String fe = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fe = new IvaVentasBo().getUltimoImporteFactura(cuitTitular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }

    public Integer getUltimoNumeroFactura(String cuitTitular) throws Exception {
        Integer fe = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fe = new IvaVentasBo().getUltimoNumeroFactura(cuitTitular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }

    public Integer getUltimoNumeroFacturaA(String cuitTitular) throws Exception {
        Integer fe = 0;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fe = new IvaVentasBo().getUltimoNumeroFacturaA(cuitTitular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }
    
    public List<IvaVentas> getAllIvaVentasByCodigoYFecha(Cliente cliente, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBo().getFacturasByCodigoAndFechas(cliente, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBo().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentas> getFacturasBEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBo().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFacturasEntreFechasOrdenCliente(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBo().getFacturasEntreFechasOrdenCliente(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentas> getFacturasEntreFechasOrdenNroFc(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBo().getFacturasEntreFechasOrdenNroFc(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    public Double getFacturasByPeriodo(Integer mes, Integer anio) throws Exception {
        Double fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBo().getFacturasByPeriodo(mes, anio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFacturasCigarrillosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBo().getFacturasCigarrillosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    //
    public List<IvaVentas> getFacturasPanificadosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBo().getFacturasPanificadosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    public void saveListaFacturas(List<IvaVentas> facturas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new IvaVentasBo().saveListaFacturas(facturas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public IvaVentas getFacturaByNumero(String letra, Integer sucursal, Integer numero) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = new IvaVentasBo().getFacturaByNumero(letra, sucursal, numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
}
