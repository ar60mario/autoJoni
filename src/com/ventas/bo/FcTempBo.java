package com.ventas.bo;

import com.ventas.dao.FcTempDao;
import com.ventas.entities.FcTemp;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

public class FcTempBo {

    private final FcTempDao dao = new FcTempDao();

    public FcTemp save(FcTemp ft) throws Exception {
        try {
            ft = (FcTemp) dao.save(ft);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ft;
    }

    public List<FcTemp> getFacturasPendientesDeEnviarArca() throws Exception {
        List<FcTemp> facturas=null;
        try {
            facturas = dao.getFacturasPendientesDeEnviarArca();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return facturas;
    }
//    public void delete(NuevaFactura nf) throws Exception {
//
//        
//            dao.delete(nf);
//        
//            
//        }
//
//    }
//
//    public NuevaFactura getNuevaFacturaByCompraMP(CompraClienteMercadoPago ccmp) throws Exception {
//        NuevaFactura nf;
//        try {
//            nf = (NuevaFactura) dao.getNuevaFacturaByCompraMP(ccmp);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return nf;
//    }
//
//    public List<NuevaFactura> getAll() throws Exception {
//        List<NuevaFactura> nuevas = null;
//
//        try {
//            nuevas = dao.getAll(NuevaFactura.class);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return nuevas;
//    }

//    public void updateCliente(Cliente cliente) throws Exception {
//
//        // Primero guardo la dirección del administrador.
//        DomicilioBo domicilioBo = new DomicilioBo();
//        Domicilio domicilioCliente = cliente.getDomicilio();
//        domicilioCliente = domicilioBo.updateDomicilio(domicilioCliente);
//        cliente.setDomicilio(domicilioCliente);
//
//        try {
//            cliente = (Cliente) dao.update(cliente);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//
//    }
//
//    public List<Cliente> getClienteByPagina(int paginaActual) throws Exception {
//
//        List<Cliente> listadoClientes = null;
//        int start = 0;
//        if (paginaActual > 1) {
//            start = ((paginaActual - 1) * Constantes.MAX_RESULTS) + 1;
//        }
//
//        try {
//            listadoClientes = dao.getAll(Cliente.class, start);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//
//        return listadoClientes;
//
//    }
//
//    public int getClientesCount() throws Exception {
//
//        int cantidad = 0;
//
//        try {
//            cantidad = dao.getCount(Cliente.class);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//
//        return cantidad;
//
//    }
//
//    public void deleteCliente(Cliente cliente) throws Exception {
//
//        try {
//            dao.delete(cliente);
//
//        } catch (HibernateException ex) {
//
//            throw new Exception(ex);
//        }
//    }
//
//    public Cliente getClienteByCuit(String cuit) throws Exception {
//        Cliente cliente = null;
//        try {
//            cliente = dao.getByCuit(cuit);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return cliente;
//    }
////
//
//    public Cliente getUltimoCliente() throws Exception {
//        Cliente cliente = null;
//        try {
//            cliente = dao.getUltimoCliente();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return cliente;
//    }
//
//    public Cliente getClienteByCodigo(String codigo) throws Exception {
//        Cliente cliente = null;
//        try {
//            cliente = dao.getByCodigo(codigo);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return cliente;
//    }
//
//    public List<Cliente> getClientesOrdenado() throws Exception {
//
//        List<Cliente> listadoClientes = null;
//        try {
//            listadoClientes = dao.getAllClientesOrdenado();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listadoClientes;
//
//    }
//
//    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
//        List<Cliente> clientes = null;
//        try {
//            clientes = dao.getClientesByFiltro(filtro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//
//    public void saveListaClientes(List<Cliente> listaClientes) throws Exception {
//        DomicilioBo db = new DomicilioBo();
//
//        if (listaClientes != null && !listaClientes.isEmpty()) {
//            for (Cliente cliente : listaClientes) {
//                Domicilio domicilio = cliente.getDomicilio();
//                try {
//                    domicilio = db.saveDomicilio(domicilio);
//                    cliente.setDomicilio(domicilio);
//                    dao.save(cliente);
//                } catch (HibernateException ex) {
//                    throw new Exception("Ha ocurrido un problema intentando guardar el Cliente.\nPor favor intente nuevamente mas tarde.");
//                }
//            }
//        }
//    }
}
