package com.ventas.bo;

import com.ventas.dao.TitularCuitDao;
import com.ventas.entities.TitularCuit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

public class TitularCuitBo {

    TitularCuitDao dao = new TitularCuitDao();

    public List<TitularCuit> getTitularCuitActivos() throws Exception {
        List<TitularCuit> titulares = null;
        try {
            titulares = dao.getTitularCuitActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return titulares;
    }

    public TitularCuit getTitularCuitByCuit(String cuit) throws Exception {
        TitularCuit tc = null;
        try {
            tc = dao.getTitularCuitByCuit(cuit);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return tc;
    }
    
    public void saveTitularCuit(TitularCuit tc) throws Exception {
        try {
            dao.save(tc);
        } catch (HibernateException ex) {
            throw new Exception();
        }
    }
    
    public void updateTitularCuit(TitularCuit tc) throws Exception {
        try {
            dao.update(tc);
        } catch (HibernateException ex) {
            throw new Exception();
        }
    }

    public Integer getUltimoCodigoTitularCuit() throws Exception {
        TitularCuit tc = null;
        try {
            tc = dao.getUltimoTitularCuit();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return tc.getCodigo();
    }

//    public void ajustarCtaCteCliente(List<CCCliente> ctaCompleta, CCCliente ccc) throws Exception {
//        try {
////            int i = 0;
////            Double saldo = 0.0;
//            for (CCCliente cc : ctaCompleta) {
//                if (!cc.getId().equals(ccc.getId())) {
////                if (i == 0) {
////                    saldo = cc.getDebe() - cc.getHaber();
////                    i = 1;
////                } else {
////                    saldo += cc.getDebe() - cc.getHaber();
////                }
////                cc.setSaldo(saldo);
//                    new TitularCuitBo().update(cc);
//                } else {
//                    new TitularCuitBo().deleteCCCliente(ccc);
//                }
//            }
//        } catch (HibernateException ex) {
//            throw new Exception();
//        }
//    }
//
//    public void cruceCtaCteClienteToCliente(CruceCuentaCorriente cruceCuentaCorriente, CCCliente ccc, CCCliente ccc2,
//            Recibo rc, Recibo rc2, Saldo saldo, Saldo saldo2, Configuracion cfg, ConfiguracionCruceCuentas confCruCue) throws Exception {
//        Cliente clienteDestino = ccc2.getCliente();
//        try {
//            rc = (Recibo) new ReciboDAO().save(rc);
//            rc2 = (Recibo) new ReciboDAO().save(rc2);
//            ccc.setRecibo(rc);
//            ccc2.setRecibo(rc2);
//            System.out.println(ccc.getDebe());
//            System.out.println(ccc.getHaber());
////            System.exit(0);
//            ccc=(CCCliente)dao.save(ccc);
//            ccc2=(CCCliente)dao.save(ccc2);
//            new ConfiguracionBO().updateConfiguracion(cfg);
//            new SaldoDAO().update(saldo);
//            new SaldoDAO().update(saldo2);
//            cruceCuentaCorriente.setCuentaCorrienteCliente(ccc2);
//            cruceCuentaCorriente.setCuentaCorrienteClienteOrigen(ccc);
//            cruceCuentaCorriente.setClienteDestino(clienteDestino);
//            new CruceCuentaCorrienteBo().saveCruceCuentaCorrienteCompletaClienteCliente(cruceCuentaCorriente);
//            new ConfiguracionCruceCuentasBo().updateConfiguracionCruceCuentas(confCruCue);
//        } catch (HibernateException ex) {
//            throw new Exception();
//        }
//    }
//
//    public void cruceCtaCteClienteToProveedor(CCCliente ccc, ProveedorCuentaCorriente ccc2,
//            Recibo rc, Pago rc2, Saldo saldo, SaldoProveedor saldo2, Configuracion cfg) throws Exception {
//        try {
//            rc = new ReciboBO().saveRecibo(rc);
//            rc2 = new PagoBo().savePago(rc2);
//            ccc.setRecibo(rc);
//            ccc2.setPago(rc2);
//            dao.save(ccc);
//            new ProveedorCuentaCorrienteDao().save(ccc2);
//            new ConfiguracionBO().updateConfiguracion(cfg);
//            new SaldoDAO().update(saldo);
//            new SaldoProveedorDao().update(saldo2);
//        } catch (HibernateException ex) {
//            throw new Exception();
//        }
//    }
//
//    public List<CCCliente> getAllMovimientosByCliente(Cliente cliente) throws Exception {
//        List<CCCliente> movim = null;
//        try {
//            movim = dao.getAllMovimientosByCliente(cliente);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return movim;
//    }
//
//    public void update(CCCliente ccc) throws Exception {
//        try {
//            dao.update(ccc);
//        } catch (HibernateException ex) {
//            throw new Exception();
//        }
//    }
//
//    public void saveCtaCompleta(List<CCCliente> ccc) throws Exception {
//        try {
//            for (CCCliente c : ccc) {
//                dao.update(c);
//            }
//        } catch (HibernateException ex) {
//            throw new Exception();
//        }
//    }
//
//    public void deleteCCCliente(CCCliente ccc) throws Exception {
//        try {
//            dao.delete(ccc);
//        } catch (HibernateException ex) {
//            throw new Exception();
//        }
//    }
//
//    public void grabarPagoEnCuentaCorrienteClienteCompleto(Cliente cliente, Recibo recibo, CCCliente cta) throws Exception {
//        try {
//            new ClienteBo().updateCliente(cliente);
//            recibo = new ReciboBO().saveRecibo(recibo);
//            cta.setRecibo(recibo);
//            new TitularCuitBo().saveCCCliente(cta);
//        } catch (HibernateException ex) {
//            throw new Exception();
//        }
//    }
//
//    public void updateCuentaCorrienteCliente(Saldo saldo, Recibo recibo, CCCliente cta) throws Exception {
//        try {
//            new SaldoBO().updateSaldo(saldo);
//            new TitularCuitBo().deleteCCCliente(cta);
//            new ReciboBO().deleteRecibo(recibo);
//        } catch (HibernateException ex) {
//            throw new Exception();
//        }
//    }
//
//    public Producto saveRubro(Producto rubro) throws Exception{
//        
//        try{
//            rubro = (Producto) dao.save(rubro);
//        }catch (HibernateException ex){
//            throw new Exception(ex);
//        }
//        return rubro;
//    }
//
//    public void updateRubro(Producto rubro) throws HibernateException{
//        try{
//            dao.update(rubro);
//        } catch(HibernateException ex){
//            throw new HibernateException (ex);
//        }
//    }
//
//    public void deleteRubro(Producto rubroABorrar) throws Exception{
//        try{ 
//            dao.delete(rubroABorrar);
//        } catch(HibernateException ex){
//            throw new HibernateException (ex);    
//        }
//    }
//    
//    public Producto getRubroByCodigo(Integer codigo) throws Exception {
//        Producto rubro = null;
//        try{
//            rubro = dao.getByCodigo(codigo);
//        }catch(HibernateException ex){
//            throw new Exception(ex);
//        }
//        return rubro;
//    }
//    
//    public List<Producto> getProductosByFiltro(String filtro) throws Exception {
//        List<Producto> listaRubro = new ArrayList();
//        try{
//            listaRubro = (List<Producto>) dao.getProductosByFiltro(filtro);
//        }
//        catch(HibernateException ex){
//            throw new Exception(ex);
//        }
//        return listaRubro;
//    }
//    
//    public List<Producto> getAllRubrosActivos() throws Exception {
//        List<Producto> listaRubro = new ArrayList();
//        try{
//            listaRubro = (List<Producto>) dao.getAllRubrosActivos();
//        }
//        catch(HibernateException ex){
//            throw new Exception(ex);
//        }
//        return listaRubro;
//    }
//    
//    public List<Producto> getAllProductosByCodigos(Integer co1, Integer co2) throws Exception {
//        List<Producto> lista = null;
//        try{
//            lista = (List<Producto>) dao.getAllProductosByCodigos(co1, co2);
//        }
//        catch(HibernateException ex){
//            throw new Exception(ex);
//        }
//        return lista;
//    }
}
