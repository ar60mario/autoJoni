/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.services;

import com.ventas.bo.ArticuloCompraBo;
import com.ventas.bo.CompraClienteMercadoPagoBo;
import com.ventas.bo.FacturaCompraReferenciaMercadoPagoBo;
import com.ventas.bo.IvaVentasBo;
import com.ventas.bo.RenglonFacturaBo;
import com.ventas.bo.RenglonNotaCreditoBo;
import com.ventas.entities.ArticuloCompra;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.RenglonFactura;
import com.ventas.entities.RenglonNotaCredito;
import com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class FacturaService {

    public void saveFactura(IvaVentas iv, List<RenglonFactura> rf) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentasBo ivaBO = new IvaVentasBo();
        IvaVentas ivaVentas = ivaBO.saveIvaVentas(iv);
//        Boolean bolean = true;
        for (RenglonFactura renglon : rf) {
            renglon.setIvaVentas(ivaVentas);
            try {
                RenglonFacturaBo bo = new RenglonFacturaBo();
                bo.saveRenglon(renglon);
//                ArticuloCompraBo bo2 = new ArticuloCompraBo();
//                bo2.updateArticuloCompra(artCmpr);
                tx.commit();
            } catch (Exception ex) {
//                bolean = false;
                tx.rollback();
                throw new Exception(ex);
            }
        }
//        if (bolean) {
//            
//        }
    }

    public void saveFacturaCompleta(IvaVentas iv, List<RenglonFactura> rf,
            ArticuloCompra artCmpr, CompraClienteMercadoPago compra,
            FacturaCompraReferenciaMercadoPago fcrmp) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentasBo ivaBO = new IvaVentasBo();
        IvaVentas ivaVentas = ivaBO.saveIvaVentas(iv);
//        Boolean bolean = true;
        for (RenglonFactura renglon : rf) {
            renglon.setIvaVentas(ivaVentas);
            try {
                RenglonFacturaBo bo = new RenglonFacturaBo();
                bo.saveRenglon(renglon);
                ArticuloCompraBo bo2 = new ArticuloCompraBo();
                bo2.updateArticuloCompra(artCmpr);
                if (compra != null) {
                    new CompraClienteMercadoPagoBo().updateCompraClientesImportados(compra);
                }
                if (fcrmp != null) {
                    fcrmp.setArticuloCompra(artCmpr);
                    fcrmp.setCompraClienteMercadoPago(compra);
                    fcrmp.setIvaVentas(ivaVentas);
                    new FacturaCompraReferenciaMercadoPagoBo().saveFacturaCompraReferenciaMercadoPago(fcrmp);
                }
                tx.commit();
            } catch (Exception ex) {
//                bolean = false;
                tx.rollback();
                throw new Exception(ex);
            }
        }
//        if (bolean) {
//            
//        }
    }

    public void saveNotaCredito(IvaVentas iv, List<RenglonNotaCredito> rf) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentasBo ivaBO = new IvaVentasBo();
        IvaVentas ivaVentas = ivaBO.saveIvaVentas(iv);
        Boolean bolean = true;
        for (RenglonNotaCredito renglon : rf) {
            renglon.setIvaVentas(ivaVentas);
            try {
                RenglonNotaCreditoBo bo = new RenglonNotaCreditoBo();
                bo.saveRenglon(renglon);
            } catch (Exception ex) {
                bolean = false;
                tx.rollback();
                throw new Exception(ex);
            }
        }
        if (bolean) {
            tx.commit();
        }
    }

}
