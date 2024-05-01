/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.services;

import com.ventas.bo.RenglonRemitoBo;
import com.ventas.entities.Remito;
import com.ventas.entities.RenglonRemito;
import com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RenglonRemitoService {
    
    
    public void saveRenglon(RenglonRemito renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            RenglonRemitoBo bo = new RenglonRemitoBo();
            bo.saveRenglon(renglon);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }
    
    public List<RenglonRemito> getAllRenglonFacturaFromIvaVentas(Remito idIvaVentas) throws Exception {
        List<RenglonRemito> renglonFactura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonFactura = new RenglonRemitoBo().getAllRenglonFacturaFromIvaVentas(idIvaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonFactura;
    }
}
