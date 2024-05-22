/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bo;

import com.ventas.dao.FacturaCompraReferenciaMercadoPagoDao;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import org.hibernate.HibernateException;

/**
 *
 * @author argia
 */
public class FacturaCompraReferenciaMercadoPagoBo {

    private final FacturaCompraReferenciaMercadoPagoDao dao = new FacturaCompraReferenciaMercadoPagoDao();

    public FacturaCompraReferenciaMercadoPago saveFacturaCompraReferenciaMercadoPago(FacturaCompraReferenciaMercadoPago fcrmp) 
    throws Exception {
        FacturaCompraReferenciaMercadoPago fact = null;
        try {
            fact = (FacturaCompraReferenciaMercadoPago) dao.save(fcrmp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public FacturaCompraReferenciaMercadoPago getFacturaById(Long id) 
    throws Exception {
        FacturaCompraReferenciaMercadoPago fact = null;
        try {
            fact = (FacturaCompraReferenciaMercadoPago) 
                    dao.getFacturaById(id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public FacturaCompraReferenciaMercadoPago getFacturaByIvaVentas(IvaVentas iv) 
    throws Exception {
        FacturaCompraReferenciaMercadoPago fact = null;
        try {
            fact = (FacturaCompraReferenciaMercadoPago) 
                    dao.getFacturaByIvaVentas(iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
}
