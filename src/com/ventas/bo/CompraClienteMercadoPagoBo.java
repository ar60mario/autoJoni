/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package com.ventas.bo;

import com.ventas.dao.CompraClienteMercadoPagoDao;
import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.Domicilio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CompraClienteMercadoPagoBo {

    private final CompraClienteMercadoPagoDao dao = new CompraClienteMercadoPagoDao();

//
//    public Compra saveCompra(Compra compra) throws Exception {
//        try {
//            dao.save(compra);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return compra;
//    }
    public CompraClienteMercadoPago getComprobanteCompraClientesMercadoPago(Long id) throws Exception {
        CompraClienteMercadoPago ccmp;
        try {
            ccmp = dao.getComprobanteCompraClientesMercadoPago(id);
        } catch (HibernateException ex) {
            ccmp = null;
            throw new Exception(ex);
        }
        return ccmp;
    }

    public void saveCompraClientesImportados(List<CompraClienteMercadoPago> compra) throws Exception {
        for (CompraClienteMercadoPago ccmp : compra) {
            try {
                String cuit = ccmp.getCuit();
                Cliente cliente;
                cliente = new ClienteBo().getClienteByCuit(cuit);
                if(cliente == null){
                    Cliente cli = new Cliente();
                    Domicilio domi = new Domicilio();
                    domi.setCalle("COSQUIN");
                    domi.setNumero("2626");
                    domi.setCodigoPostal("1814");
                    domi.setDepartamento("");
                    domi.setLocalidad("LA NORIA");
                    domi.setPiso("");
                    domi.setProvincia("BUENOS AIRES");
                    cli.setActivo(true);
                    cli.setCategoriaDeIva(5);
                    cli.setCelular("");
                    cli.setCodigo(cuit);
                    cli.setCuit(cuit);
                    cli.setDescuento(0F);
                    cli.setDomicilio(domi);
                    cli.setFormaDePago(1);
                    cli.setMail("");
                    cli.setObservaciones("");
                    cli.setRazonSocial(ccmp.getNombre());
                    cli.setSaldo(0.0);
                    cli.setTelefono("");
                    cli.setTieneDescuento(false);
                    cli.setTipo("86");
                    new ClienteBo().saveCliente(cli);
                }
//                String p = cuit.substring(0,2);
//                String m = cuit.substring(2, 8);
//                String f = cuit.substring(10,10);
//                System.out.println(cuit);
//                System.out.println(p);
//                System.out.println(m);
//                System.out.println(f);
//                System.exit(0);
                dao.save(ccmp);
            } catch (HibernateException ex) {
                throw new Exception(ex);
            }
        }
    }

    public void updateCompraClientesImportados(CompraClienteMercadoPago compra) throws Exception {
        try {
            dao.update(compra);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void deleteCompraClienteMP(CompraClienteMercadoPago compra) throws Exception {
        try {
            dao.delete(compra);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public List<CompraClienteMercadoPago> getAllFacturasPendientesDeProcesar() throws Exception {
        List<CompraClienteMercadoPago> listCompras = null;
        try {
            listCompras = dao.getAllFacturasPendientesDeProcesar();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listCompras;
    }
    
    public List<CompraClienteMercadoPago> getComprasParaProcesar(Double limiteCompras) throws Exception {
        List<CompraClienteMercadoPago> listCompras = null;
        List<CompraClienteMercadoPago> comprasParaFacturar = new ArrayList<>();
        try {
            listCompras = dao.getAllFacturasPendientesDeProcesar();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        Double totalCalculado = 0.0;
        if (listCompras != null && !listCompras.isEmpty()) {
            for (CompraClienteMercadoPago ccmp : listCompras) {
                totalCalculado += ccmp.getImporte();
                comprasParaFacturar.add(ccmp);
                if (totalCalculado >= limiteCompras) {
                    break;
                }
            }
        }
        return comprasParaFacturar;
    }
    
//    public List<CompraClienteMercadoPago> getAllFacturasPendientesDeProcesar() throws Exception {
//        List<CompraClienteMercadoPago> listCompras = null;
//        try {
//            listCompras = dao.getAllFacturasPendientesDeProcesar();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listCompras;
//    }

    public List<CompraClienteMercadoPago> getAllFacturasProcesadas() throws Exception {
        List<CompraClienteMercadoPago> listCompras = null;
        try {
            listCompras = dao.getAllFacturasProcesadas();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listCompras;
    }
    
//    public void updateCompra(Compra compra) throws Exception {
//        try {
//            compra = (Compra) dao.update(compra);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//
//    }
//
//    public void deleteCliente(Compra compra) throws Exception {
//        try {
//            dao.delete(compra);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//    }
//
//    public List<Compra> getComprasOrdenado() throws Exception {
//        List<Compra> listadoCompras = null;
//        try {
//            listadoCompras = dao.getAllCompraOrdenado();
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listadoCompras;
//    }
//
//    public List<Compra> getCompraPorComprobante(String nro) throws Exception {
//        List<Compra> listadoCompras = null;
//        try {
//            listadoCompras = dao.getCompraPorComprobante(nro);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listadoCompras;
//    }
//
//    public List<Compra> getComprasEntreFechas(Date de, Date al) throws Exception {
//        List<Compra> listCompras = null;
//        try {
//            listCompras = dao.getComprasEntreFechas(de, al);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listCompras;
//    }
}
