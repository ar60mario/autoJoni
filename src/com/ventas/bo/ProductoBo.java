package com.ventas.bo;

import com.ventas.dao.ProductoDao;
import com.ventas.entities.Producto;
import com.ventas.entities.ProductoIntercambio;
import com.ventas.entities.ProductoTop;
import com.ventas.entities.Rubro;
import com.ventas.entities.SubRubro;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

public class ProductoBo {

    private final ProductoDao dao = new ProductoDao();

    public List<Producto> getAllProductos() throws Exception {
//        ProductoDao dao = new ProductoDao();
        List<Producto> losProductos = new ArrayList<>();
        try {
            losProductos = dao.getAllCigarrillos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getAllProductosByRubro(Rubro rubro) throws Exception {
//        ProductoDao dao = new ProductoDao();
        List<Producto> losProductos = new ArrayList<>();
        try {
            losProductos = dao.getAllProductosByRubro(rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getProductosConPrecioPorPorcentaje(String filtro, Rubro rubro) throws Exception {
        List<Producto> losProductos = new ArrayList<>();
        try {
            losProductos = dao.getProductosConPrecioPorPorcentaje(filtro, rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public Producto guardarProducto(Producto producto) throws Exception {
        try {
            dao.save(producto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoByCodigo(Integer codigo) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getActivoByCodigoSubRubroAndRubro(Rubro ru, SubRubro su) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getActivoByCodigoSubRubroAndRubro(ru, su);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }
    
    public Producto getByRubroAndPrecioPorPorcentaje(Rubro rubro) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getByRubroAndPrecioPorPorcentaje(rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoByDetalle(String detalle) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getProductoByDetalle(detalle);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoLogistica() throws Exception {
        Producto producto = null;
        try {
            producto = dao.getProductoLogistica();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoPanificadoByCodigo(Integer codigo) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getPanificadoByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoByCodigoC(Integer codigo) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getByCodigoC(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoByCodigoV(Integer codigo) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getByCodigoV(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }
//

    public Producto getByCodigoPanificadoV(Integer codigo) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getByCodigoPanificadoV(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto updateProducto(Producto producto) throws Exception {
        try {
            producto = (Producto) dao.update(producto);
        } catch (HibernateException ex) {
            throw new Exception(ex);

        }
        return producto;
    }

    public void deleteProducto(Producto producto) throws Exception {
        try {
            dao.delete(producto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void saveListaProductos(List<Producto> listaProductos) throws Exception {
        if (listaProductos != null && !listaProductos.isEmpty()) {
            for (Producto prod : listaProductos) {
                if (prod.getRubro() == null) {
                    throw new Exception("El RUBRO asociado al Producto " + prod.getRubro().getCodigo() + " no es válido.");
                }
                if (prod.getSubRubro() == null) {
                    throw new Exception("El SUB-RUBRO asociado al Producto " + prod.getSubRubro().getCodigo() + " no es válido.");
                }
                try {
                    dao.save(prod);
                } catch (HibernateException ex) {
                    throw new Exception("Ha ocurrido un problema intentando guardar los PRODUCTOS.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }

    public void saveListaProductosAndProductoTop(ProductoIntercambio listaProductos) throws Exception {
        if (listaProductos != null) {
            List<Producto> productos = listaProductos.getProductos();
            List<ProductoTop> prodTops = listaProductos.getProductosTop();
            int i = 0;
            for (Producto prod : productos) {
                try {
                    dao.save(prod);
                    new ProductoTopBo().saveProductoTop(prodTops.get(i));
                    i += 1;
                } catch (HibernateException ex) {
                    throw new Exception("Ha ocurrido un problema intentando guardar los PRODUCTOS.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }

    public List<Producto> getProductosByFiltro2(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltro2(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getProductosByFiltro(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getProductosByFiltroAndRubro(String filtro, Rubro rubro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltroAndRubro(filtro, rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getProductosByFiltroAndRubroEliminados(String filtro, Rubro rubro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltroAndRubroEliminados(filtro, rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getProductosPanificadosByFiltro(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosPanificadosByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getProductoSinCodigoBarras(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosSinCodigoBarras(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getAllProductosOrdByCodigo(String filtro) throws Exception {
        ProductoDao dao = new ProductoDao();
        List<Producto> losProductos = new ArrayList<>();

        try {
            losProductos = dao.getAllOrdByCodigo(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getProductosDeTabacaleras(Integer desde) throws Exception {
        ProductoDao dao = new ProductoDao();
        List<Producto> losProductos = new ArrayList<>();

        try {
            losProductos = dao.getProductosDeTabacaleras(desde);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getAllProductosOrdByNombre(String filtro) throws Exception {
        ProductoDao dao = new ProductoDao();
        List<Producto> losProductos = new ArrayList<>();
        try {
            losProductos = dao.getAllProductosOrdenado(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getAllProductosOrdByRubro(String filtro) throws Exception {
        ProductoDao dao = new ProductoDao();
        List<Producto> losProductos = new ArrayList<>();

        try {
            losProductos = dao.getAllOrdByRubro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getAllProductosEnCero(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosEnCero(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getProductosInactivos() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public Producto getProductoByCodigoBarras(Long codigoBarras) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getByCodigoBarras(codigoBarras);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoPanificadoByCodigoBarras(Long codigoBarras) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getPanificadoByCodigoBarras(codigoBarras);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Integer getUltimoCodigo() throws Exception {
        Integer c = null;
        try {
            c = dao.getUltimoCodigo();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return c;
    }

    public List<Producto> getProductosEntreCodigos(Integer de, Integer a) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosEntreCodigos(de, a);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

}
