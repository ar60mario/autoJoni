package com.ventas.services;

import com.ventas.bo.IvaVentasPorCajaBo;
import com.ventas.entities.Cliente;
import com.ventas.entities.Configuracion;
import com.ventas.entities.IvaVentasPorCaja;
import com.ventas.entities.RenglonFacturaPorCaja;
import com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class IvaVentasPorCajaService {

    public final IvaVentasPorCajaBo bo = new IvaVentasPorCajaBo();
    
    
    public List<IvaVentasPorCaja> getFacturasPendientesDeEnviarArca() throws Exception {
        List<IvaVentasPorCaja> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = bo.getFacturasPendientesDeEnviarArca();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public IvaVentasPorCaja saveIvaVentas(IvaVentasPorCaja ivaVentas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasPorCajaBo().saveIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
//    public void saveIvaVentasCompletoMp(IvaVentasPorCaja ivaVentas, 
//            FacturaCompraReferenciaMercadoPago fcrmp, CompraClienteMercadoPago ccmp,
//            List<RenglonFactura> renglones, Configuracion cfg) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new IvaVentasBo().saveIvaVentasCompletoMp(ivaVentas, fcrmp, ccmp, renglones, cfg);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
    
    public IvaVentasPorCaja updateIvaVentas(IvaVentasPorCaja ivaVentas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasPorCajaBo().updateIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentasPorCaja saveIvaVentasCompleto(IvaVentasPorCaja ivaVentas, List<RenglonFacturaPorCaja> renglones) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasPorCajaBo().saveIvaVentasCompleto(ivaVentas, renglones);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentasPorCaja> getAllIvaVentas() throws Exception {
        List<IvaVentasPorCaja> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasPorCajaBo().getAllIvaVentas();
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
            fe = new IvaVentasPorCajaBo().getUltimaFechaFactura(cuitTitular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }
    
    public IvaVentasPorCaja getUltimaFactura(Integer td) throws Exception {
        IvaVentasPorCaja fe = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fe = new IvaVentasPorCajaBo().getUltimaFactura(td);
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
            fe = new IvaVentasPorCajaBo().getUltimaNombreEnFactura();
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
            fe = new IvaVentasPorCajaBo().getUltimoCuitEnFactura();
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
            fe = new IvaVentasPorCajaBo().getUltimoImporteFactura(cuitTitular);
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
            fe = new IvaVentasPorCajaBo().getUltimoNumeroFactura(cuitTitular);
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
            fe = new IvaVentasPorCajaBo().getUltimoNumeroFacturaA(cuitTitular);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fe;
    }
    
    public List<IvaVentasPorCaja> getAllIvaVentasByCodigoYFecha(Cliente cliente, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentasPorCaja> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasPorCajaBo().getFacturasByCodigoAndFechas(cliente, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentasPorCaja> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasPorCajaBo().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasBEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasPorCajaBo().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentasPorCaja> getFacturasEntreFechasOrdenCliente(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasPorCajaBo().getFacturasEntreFechasOrdenCliente(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasEntreFechasOrdenNroFc(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasPorCajaBo().getFacturasEntreFechasOrdenNroFc(fd, fa);
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
            fact = new IvaVentasPorCajaBo().getFacturasByPeriodo(mes, anio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentasPorCaja> getFacturasCigarrillosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasPorCajaBo().getFacturasCigarrillosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    //
    public List<IvaVentasPorCaja> getFacturasPanificadosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasPorCajaBo().getFacturasPanificadosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }

    public void saveListaFacturas(List<IvaVentasPorCaja> facturas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new IvaVentasPorCajaBo().saveListaFacturas(facturas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public IvaVentasPorCaja getFacturaByNumero(String letra, Integer sucursal, Integer numero) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentasPorCaja ivaVentas = null;
        try {
            ivaVentas = new IvaVentasPorCajaBo().getFacturaByNumero(letra, sucursal, numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
}
