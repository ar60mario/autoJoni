/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bo;

import com.ventas.dao.IvaVentasDao;
import com.ventas.entities.Cliente;
import com.ventas.entities.IvaVentas;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcela
 */
public class IvaVentasBo {

    private final IvaVentasDao dao = new IvaVentasDao();

    private static final Logger logger = Logger.getLogger("IvaVentasBo");

    public IvaVentas saveIvaVentas(IvaVentas ivaVentas) throws Exception {
        try {
            ivaVentas = (IvaVentas) dao.save(ivaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentas> getAllIvaVentas() throws Exception {

        List<IvaVentas> listIvaVentas = null;

        try {
            listIvaVentas = dao.getAll(IvaVentas.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;

    }

    public List<IvaVentas> getAllIvaVentasByCodigoYFecha() throws Exception {
        List<IvaVentas> listIvaVentas = null;

        try {
            listIvaVentas = dao.getAll(IvaVentas.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;
    }

    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    //getFacturasPanificadosEntreFechas
    public List<IvaVentas> getFacturasPanificadosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasPanificadosEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    //
    public List<IvaVentas> getFacturasCigarrillosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasCigarrillosEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFacturasByCodigoAndFechas(Cliente cliente, Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasByCodigoAndFechas(cliente, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    //
    public void saveListaFacturas(List<IvaVentas> facturas) throws Exception {
        if(facturas != null && !facturas.isEmpty()){
            for(IvaVentas iv: facturas){
                try{
                    dao.save(iv);
                }catch(HibernateException ex){
                    throw new Exception("Ha ocurrido un problema intentando guardar Factura.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }
    
    public IvaVentas getFacturaByNumero(String letra, Integer sucursal, Integer numero) throws Exception {
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = (IvaVentas) dao.getByLetraNumero(letra,sucursal,numero);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }
}
