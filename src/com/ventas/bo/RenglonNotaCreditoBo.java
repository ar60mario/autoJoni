/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bo;

import com.ventas.dao.RenglonFacturaDao;
import com.ventas.dao.RenglonNotaCreditoDao;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.RenglonFactura;
import com.ventas.entities.RenglonNotaCredito;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RenglonNotaCreditoBo {

    private final RenglonNotaCreditoDao dao = new RenglonNotaCreditoDao();

    private static final Logger logger = Logger.getLogger("RenglonFacturaBo");

    public RenglonNotaCredito saveRenglon(RenglonNotaCredito renglonFactura) throws Exception {
        try {
            dao.save(renglonFactura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglonFactura;
    }

    public List<RenglonNotaCredito> getAllRenglonNotaCreditoFromIvaVentas(IvaVentas idIvaVentas) throws Exception {
        List<RenglonNotaCredito> listRenglonFactura = null;
        try {
            listRenglonFactura = dao.getRenglonNotaCreditoFromIvaVentas(idIvaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonFactura;
    }

}
