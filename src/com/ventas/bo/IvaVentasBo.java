package com.ventas.bo;

import com.ventas.dao.IvaVentasDao;
import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.Configuracion;
import com.ventas.entities.FacturaCompraReferenciaMercadoPago;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.RenglonFactura;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

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

    public void saveIvaVentasCompletoMp(IvaVentas ivaVentas, 
            FacturaCompraReferenciaMercadoPago fcrmp, CompraClienteMercadoPago ccmp,
            List<RenglonFactura> renglones, Configuracion cfg) throws Exception {
        try {
            new ConfiguracionBo().updateConfiguracion(cfg);
            ivaVentas = (IvaVentas) dao.save(ivaVentas);
            for(RenglonFactura rf:renglones){
                rf.setIvaVentas(ivaVentas);
                new RenglonFacturaBo().saveRenglon(rf);
            }
            ccmp=new CompraClienteMercadoPagoBo().updateCompraClientesImportados(ccmp);
            fcrmp.setCompraClienteMercadoPago(ccmp);
            fcrmp.setIvaVentas(ivaVentas);
            new FacturaCompraReferenciaMercadoPagoBo().saveFacturaCompraReferenciaMercadoPago(fcrmp);
            
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public IvaVentas updateIvaVentas(IvaVentas ivaVentas) throws Exception {
        try {
            ivaVentas = (IvaVentas) dao.update(ivaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public IvaVentas saveIvaVentasCompleto(IvaVentas ivaVentas, List<RenglonFactura> renglones) throws Exception {
        try {
            ivaVentas = (IvaVentas) dao.save(ivaVentas);
            for (RenglonFactura rf : renglones) {
                rf.setIvaVentas(ivaVentas);
                new RenglonFacturaBo().saveRenglon(rf);
            }
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


    public List<IvaVentas> getFacturasBEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentas> getFacturasEntreFechasOrdenCliente(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasEntreFechasOrdenCliente(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentas> getFacturasEntreFechasOrdenNroFc(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasEntreFechasOrdenNroFc(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public Double getFacturasByPeriodo(Integer mes, Integer anio) throws Exception {
        List<IvaVentas> fact = null;
        Double totalVent = 0.0;
        try {
            fact = (List<IvaVentas>) dao.getFacturasByPeriodo(mes, anio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if (fact != null && !fact.isEmpty()) {
            for (IvaVentas ivve : fact) {
                totalVent += ivve.getTotal();
            }
        }
        return totalVent;
    }

    public String getUltimaFechaFactura(String cuitTitular) throws Exception {
        String fe = null;
        try {
            fe = (String) dao.getUltimaFechaFactura(cuitTitular);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fe;
    }
//
    public IvaVentas getUltimaFactura(Integer td) throws Exception {
        IvaVentas fe = null;
        try {
            fe = (IvaVentas) dao.getUltimaFactura(td);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fe;
    }
    
    public String getUltimaNombreEnFactura() throws Exception {
        String fe = null;
        try {
            fe = (String) dao.getUltimaNombreEnFactura();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fe;
    }

    public String getUltimoCuitEnFactura() throws Exception {
        String fe = null;
        try {
            fe = (String) dao.getUltimoCuitEnFactura();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fe;
    }

    public String getUltimoImporteFactura(String cuitTitular) throws Exception {
        String fe = null;
        try {
            fe = (String) dao.getUltimoImporteFactura(cuitTitular);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fe;
    }

    public Integer getUltimoNumeroFactura(String cuitTitular) throws Exception {
        Integer fe = null;
        try {
            fe = dao.getUltimoNumeroFactura(cuitTitular);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fe;
    }

    public Integer getUltimoNumeroFacturaA(String cuitTitular) throws Exception {
        Integer fe = 0;
        try {
            fe = dao.getUltimoNumeroFacturaA(cuitTitular);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
//        System.out.println(fe);
//        System.exit(0);
        return fe;
    }
    
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
        if (facturas != null && !facturas.isEmpty()) {
            for (IvaVentas iv : facturas) {
                try {
                    dao.save(iv);
                } catch (HibernateException ex) {
                    throw new Exception("Ha ocurrido un problema intentando guardar Factura.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }

    public IvaVentas getFacturaByNumero(String letra, Integer sucursal, Integer numero) throws Exception {
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = (IvaVentas) dao.getByLetraNumero2(letra, sucursal, numero);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }
}
