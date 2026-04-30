package com.ventas.bo;

import com.ventas.dao.RenglonFacturaPorCajaDao;
import com.ventas.entities.IvaVentasPorCaja;
import com.ventas.entities.RenglonFacturaPorCaja;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

public class RenglonFacturaPorCajaBo {

    private final RenglonFacturaPorCajaDao dao = new RenglonFacturaPorCajaDao();

    private static final Logger logger = Logger.getLogger("RenglonFacturaPorCajaBo");

    public RenglonFacturaPorCaja saveRenglon(RenglonFacturaPorCaja renglonFactura) throws Exception {
        try {
            dao.save(renglonFactura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglonFactura;
    }

    public List<RenglonFacturaPorCaja> getRenglonesActivosEntreFechas(Date d1, Date d2) throws Exception {
        List<RenglonFacturaPorCaja> renglones = null;
        try {
            renglones = dao.getRenglonesActivosEntreFechas(d1, d2);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonFacturaPorCaja> getAllRenglonFacturaFromIvaVentas(IvaVentasPorCaja idIvaVentas) throws Exception {
        List<RenglonFacturaPorCaja> listRenglonFactura = null;
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
