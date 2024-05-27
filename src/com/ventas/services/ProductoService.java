/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.services;

import com.ventas.bo.ProductoBo;
import com.ventas.entities.Producto;
import com.ventas.entities.Rubro;
import com.ventas.util.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class ProductoService {

    public List<Producto> getAllProductos() throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getAllProductos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }

        return productoLista;
    }

    public List<Producto> getAllProductosByRubro(Rubro rubro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getAllProductosByRubro(rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }

        return productoLista;
    }
    
    public void guardarProducto(Producto producto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            bo.guardarProducto(producto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public Producto getProductoByCodigo(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBo().getProductoByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    
    public Producto getProductoPanificadoByCodigo(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBo().getProductoPanificadoByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    
    public Producto getProductoByCodigoC(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBo().getProductoByCodigoC(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    
    public Producto getProductoByCodigoV(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBo().getProductoByCodigoV(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
//
    public Producto getByCodigoPanificadoV(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBo().getByCodigoPanificadoV(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    public Producto updateProducto(Producto producto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            producto = new ProductoBo().updateProducto(producto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }

    public void deleteProducto(Producto producto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ProductoBo().deleteProducto(producto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void saveListaProductos(List<Producto> listaProductos) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ProductoBo().saveListaProductos(listaProductos);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<Producto> getProductosByFiltro(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBo().getProductosByFiltro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroAndRubro(String filtro, Rubro rubro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBo().getProductosByFiltroAndRubro(filtro, rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroAndRubroEliminados(String filtro, Rubro rubro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBo().getProductosByFiltroAndRubroEliminados(filtro, rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosPanificadosByFiltro(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBo().getProductosPanificadosByFiltro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getAllProductosOrdenadoByCodigo(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getAllProductosOrdByCodigo(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getProductosDeTabacaleras(Integer desde) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getProductosDeTabacaleras(desde);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosOrdenadoByNombre(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getAllProductosOrdByNombre(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getAllProductosOrdenadoByRubro(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getAllProductosOrdByRubro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getAllProductosOrdenadoByNombreInactivo() throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getProductosInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getAllProductosSinCodigoBarras(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getProductoSinCodigoBarras(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getAllProductosEnCero(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productoLista = bo.getAllProductosEnCero(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public Producto getProductoByCodigoBarras(Long codigoBarras) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBo().getProductoByCodigoBarras(codigoBarras);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    
    public Producto getProductoPanificadoByCodigoBarras(Long codigoBarras) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBo().getProductoPanificadoByCodigoBarras(codigoBarras);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    
    public Integer getUltimoCodigo() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Integer c = null;
        try {
            c = new ProductoBo().getUltimoCodigo();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return c;
    }
    
    public List<Producto> getProductosEntreCodigos(Integer de, Integer a) throws Exception {
        List<Producto> productos = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBo bo = new ProductoBo();
            productos = bo.getProductosEntreCodigos(de, a);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
}
