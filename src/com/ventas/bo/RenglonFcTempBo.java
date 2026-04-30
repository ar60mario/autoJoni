package com.ventas.bo;

import com.ventas.dao.RenglonFcTempDao;
import com.ventas.entities.RenglonFcTemp;
import org.hibernate.HibernateException;

public class RenglonFcTempBo {

    private final RenglonFcTempDao dao = new RenglonFcTempDao();

//    private static final Logger logger = Logger.getLogger("RenglonFacturaBo");

    public RenglonFcTemp saveRenglon(RenglonFcTemp renglon) throws Exception {
        try {
            dao.save(renglon);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglon;
    }

//    public List<RenglonFactura> getRenglonesActivosEntreFechas(Date d1, Date d2) throws Exception {
//        List<RenglonFactura> renglones = null;
//        try {
//            renglones = dao.getRenglonesActivosEntreFechas(d1, d2);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return renglones;
//    }
//
//    public List<RenglonFactura> getAllRenglonFacturaFromIvaVentas(IvaVentas idIvaVentas) throws Exception {
//        List<RenglonFactura> listRenglonFactura = null;
//        try {
//            listRenglonFactura = dao.getRenglonFacturaFromIvaVentas(idIvaVentas);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return listRenglonFactura;
//    }
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
