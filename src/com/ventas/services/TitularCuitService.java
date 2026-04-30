package com.ventas.services;

import com.ventas.bo.TitularCuitBo;
import com.ventas.entities.TitularCuit;
import com.ventas.util.HibernateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TitularCuitService {

    private TitularCuitBo bo = new TitularCuitBo();

    public List<TitularCuit> getTitularCuitActivos() throws Exception {
        List<TitularCuit> titulares = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            titulares = bo.getTitularCuitActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return titulares;
    }

    public TitularCuit getTitularCuitByCuit(String cuit) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        TitularCuit tc=null;
        try {
            tc = bo.getTitularCuitByCuit(cuit);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return tc;
    }

    public void saveTitularCuit(TitularCuit tc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            bo.saveTitularCuit(tc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void updateTitularCuit(TitularCuit tc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            bo.updateTitularCuit(tc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public Integer getUltimoCodigoTitularCuit() throws Exception {
        Integer codigo = 0;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            codigo = bo.getUltimoCodigoTitularCuit();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return codigo;
    }

//    public List<CCCliente> getAllMovimientosByCliente(Cliente cliente) throws Exception {
//        List<CCCliente> movim = new ArrayList();
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            CCClienteBO bo = new CCClienteBO();
//            movim = bo.getAllMovimientosByCliente(cliente);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return movim;
//    }
//
//    public void grabarPagoEnCuentaCorrienteClienteCompleto(Cliente cliente, Recibo recibo, CCCliente cta) throws Exception {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new CCClienteBO().grabarPagoEnCuentaCorrienteClienteCompleto(cliente, recibo, cta);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void updateCuentaCorrienteCliente(Saldo saldo, Recibo recibo, CCCliente cta) throws Exception {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new CCClienteBO().updateCuentaCorrienteCliente(saldo, recibo, cta);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void ajustarCtaCteCliente(List<CCCliente> ctaCompleta, CCCliente ccc) throws Exception {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new CCClienteBO().ajustarCtaCteCliente(ctaCompleta, ccc);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//
//    public void cruceCtaCteClienteToCliente(CruceCuentaCorriente cruceCuentaCorriente, CCCliente ccc, CCCliente ccc2, Recibo rc, Recibo rc2,
//            Saldo saldo, Saldo saldo2, Configuracion cfg, ConfiguracionCruceCuentas confCruCue) throws Exception {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            System.out.println(ccc.getDebe());
//            System.out.println(ccc.getHaber());
////            System.exit(0);
//            new CCClienteBO().cruceCtaCteClienteToCliente(cruceCuentaCorriente, ccc, ccc2, 
//                    rc, rc2, saldo, saldo2, cfg, confCruCue);
//            tx.commit();
//        } catch (HibernateException ex) {
//            tx.rollback();
//            throw new HibernateException(ex);
//        }
//    }
//    
//    public void cruceCtaCteClienteToProveedor(CCCliente ccc, ProveedorCuentaCorriente pcc, Recibo rc, Pago rc2,
//            Saldo saldo, SaldoProveedor saldoP, Configuracion cfg) throws Exception {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new CCClienteBO().cruceCtaCteClienteToProveedor(ccc, pcc, rc, rc2, saldo, saldoP, cfg);
//            tx.commit();
//        } catch (HibernateException ex) {
//            tx.rollback();
//            throw new HibernateException(ex);
//        }
//    }
//    public void deleteRubro(Producto rubroABorrar) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            new ProductoBO().deleteRubro(rubroABorrar);
//            tx.commit();
//        }
//        catch (Exception ex){
//            tx.rollback();
//            throw new Exception (ex);
//        }
//    }
//    
//    public Producto getRubroByCodigo(Integer codigo) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        Producto rubro = null;
//        try {
//            rubro = new ProductoBO().getRubroByCodigo(codigo);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return rubro;
//    }
//    
//    public List<Producto> getAllRubrosActivos() throws Exception {
//        List<Producto> listaRubro = new ArrayList();
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            ProductoBO bo = new ProductoBO();
//            listaRubro = bo.getAllRubrosActivos();
//            tx.commit();
//        }
//        catch(Exception ex){
//           tx.rollback();
//            throw new Exception(ex);   
//        }
//        return listaRubro;
//    }
//    
//    public List<Producto> getAllProductosByCodigos(Integer co1, Integer co2) throws Exception {
//        List<Producto> lista = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            ProductoBO bo = new ProductoBO();
//            lista = bo.getAllProductosByCodigos(co1, co2);
//            tx.commit();
//        }
//        catch(Exception ex){
//           tx.rollback();
//            throw new Exception(ex);   
//        }
//        return lista;
//    }
//    
//    public List<Producto> getProductosByFiltro(String filtro) throws Exception {
//        List<Producto> listaRubro = new ArrayList();
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            ProductoBO bo = new ProductoBO();
//            listaRubro = bo.getProductosByFiltro(filtro);
//            tx.commit();
//        }
//        catch(Exception ex){
//           tx.rollback();
//            throw new Exception(ex);   
//        }
//        return listaRubro;
//    }
}
