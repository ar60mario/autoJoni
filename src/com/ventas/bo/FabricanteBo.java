package com.ventas.bo;

import com.ventas.dao.FabricanteDao;
import com.ventas.entities.Fabricante;
import com.ventas.util.Constantes;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class FabricanteBo {

    private final FabricanteDao dao = new FabricanteDao();

    public List<Fabricante> getAllFabricantes() throws Exception {
        List<Fabricante> listFabricantes = null;

        try {
            listFabricantes = dao.getAll(Fabricante.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listFabricantes;
    }

    public Fabricante saveFabricante(Fabricante fabricante) throws Exception {
        try {
            dao.save(fabricante);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fabricante;
    }

    public void updateFabricante(Fabricante fabricante) throws Exception {
        try {
            fabricante = (Fabricante) dao.update(fabricante);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

//    public List<Fabricante> getClienteByPagina(int paginaActual) throws Exception {
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

//    public Cliente getClienteByCuit(String cuit) throws Exception {
//        Cliente cliente = null;
//        try {
//            cliente = dao.getByCuit(cuit);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return cliente;
//    }
//

    public Fabricante getUltimoFabricante() throws Exception {
        Fabricante fabricante = null;
        try {
            fabricante = dao.getUltimoFabricante();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fabricante;
    }

    public Fabricante getFabricanteByCodigo(Integer codigo) throws Exception {
        Fabricante cliente = null;
        try {
            cliente = dao.getByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cliente;
    }

    public List<Fabricante> getFabricantesOrdenado() throws Exception {

        List<Fabricante> listadoFabricantes = null;
        try {
            listadoFabricantes = dao.getAllFabricantesOrdenado();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoFabricantes;

    }

    public List<Fabricante> getAllFabricantesOrdenadoActivos() throws Exception {

        List<Fabricante> listadoFabricantes = null;
        try {
            listadoFabricantes = dao.getAllFabricantesOrdenadoActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoFabricantes;

    }
    
    public List<Fabricante> getFabricantesByFiltro(String filtro) throws Exception {
        List<Fabricante> fabricantes = null;
        try {
            fabricantes = dao.getFabricantesByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fabricantes;
    }

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
