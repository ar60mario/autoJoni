/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bo;

import com.ventas.dao.RenglonRemitoDao;
import com.ventas.entities.Remito;
import com.ventas.entities.RenglonRemito;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RenglonRemitoBo {

    private final RenglonRemitoDao dao = new RenglonRemitoDao();

    private static final Logger logger = Logger.getLogger("RenglonFacturaBo");

    public RenglonRemito saveRenglon(RenglonRemito renglonFactura) throws Exception {
        try {
            dao.save(renglonFactura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglonFactura;
    }

    public List<RenglonRemito> getAllRenglonFacturaFromIvaVentas(Remito idIvaVentas) throws Exception {
        List<RenglonRemito> listRenglonFactura = null;
        try {
            listRenglonFactura = dao.getRenglonFacturaFromIvaVentas(idIvaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonFactura;
    }
    /*
     public void saveFacturaYRenglones(IvaVentas iv, List<RenglonFactura> rf) throws Exception {
     dao.save(iv)
     if(listaClientes != null && !listaClientes.isEmpty()){
     for(Cliente cliente : listaClientes){
     Domicilio domicilio = cliente.getDomicilio();
     try{
     domicilio = db.saveDomicilio(domicilio);
     cliente.setDomicilio(domicilio);
     dao.save(cliente);
     }catch(HibernateException ex){
     throw new Exception("Ha ocurrido un problema intentando guardar el Cliente.\nPor favor intente nuevamente mas tarde.");
     }
     }
     }
     }
     */
}
