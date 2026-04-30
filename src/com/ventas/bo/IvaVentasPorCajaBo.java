package com.ventas.bo;

import com.ventas.dao.IvaVentasPorCajaDao;
import com.ventas.entities.Cliente;
import com.ventas.entities.Configuracion;
import com.ventas.entities.IvaVentasPorCaja;
import com.ventas.entities.RenglonFacturaPorCaja;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

public class IvaVentasPorCajaBo {

    private final IvaVentasPorCajaDao dao = new IvaVentasPorCajaDao();

    private static final Logger logger = Logger.getLogger("IvaVentasBo");

    public List<IvaVentasPorCaja> getFacturasPendientesDeEnviarArca() throws Exception {
        List<IvaVentasPorCaja> listIvaVentas = null;
        try {
            listIvaVentas = dao.getFacturasPendientesDeEnviarArca();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;
    }

    public IvaVentasPorCaja saveIvaVentas(IvaVentasPorCaja ivaVentas) throws Exception {
        try {
            ivaVentas = (IvaVentasPorCaja) dao.save(ivaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentasPorCaja updateIvaVentas(IvaVentasPorCaja ivaVentas) throws Exception {
        try {
            ivaVentas = (IvaVentasPorCaja) dao.update(ivaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentasPorCaja saveIvaVentasCompleto(IvaVentasPorCaja ivaVentas, List<RenglonFacturaPorCaja> renglones) throws Exception {
        try {
            ivaVentas = (IvaVentasPorCaja) dao.save(ivaVentas);
            for (RenglonFacturaPorCaja rf : renglones) {
                rf.setIvaVentasPorCaja(ivaVentas);
                new RenglonFacturaPorCajaBo().saveRenglon(rf);
            }
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentasPorCaja> getAllIvaVentas() throws Exception {

        List<IvaVentasPorCaja> listIvaVentas = null;

        try {
            listIvaVentas = dao.getAll(IvaVentasPorCaja.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;

    }

    public List<IvaVentasPorCaja> getAllIvaVentasByCodigoYFecha() throws Exception {
        List<IvaVentasPorCaja> listIvaVentas = null;

        try {
            listIvaVentas = dao.getAll(IvaVentasPorCaja.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;
    }

    public List<IvaVentasPorCaja> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        try {
            fact = (List<IvaVentasPorCaja>) dao.getFacturasEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasBEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        try {
            fact = (List<IvaVentasPorCaja>) dao.getFacturasEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasEntreFechasOrdenCliente(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        try {
            fact = (List<IvaVentasPorCaja>) dao.getFacturasEntreFechasOrdenCliente(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasEntreFechasOrdenNroFc(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        try {
            fact = (List<IvaVentasPorCaja>) dao.getFacturasEntreFechasOrdenNroFc(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public Double getFacturasByPeriodo(Integer mes, Integer anio) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        Double totalVent = 0.0;
        try {
            fact = (List<IvaVentasPorCaja>) dao.getFacturasByPeriodo(mes, anio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if (fact != null && !fact.isEmpty()) {
            for (IvaVentasPorCaja ivve : fact) {
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

    public IvaVentasPorCaja getUltimaFactura(Integer td) throws Exception {
        IvaVentasPorCaja fe = null;
        try {
            fe = (IvaVentasPorCaja) dao.getUltimaFactura(td);
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

    public List<IvaVentasPorCaja> getFacturasPanificadosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        try {
            fact = (List<IvaVentasPorCaja>) dao.getFacturasPanificadosEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    //
    public List<IvaVentasPorCaja> getFacturasCigarrillosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        try {
            fact = (List<IvaVentasPorCaja>) dao.getFacturasCigarrillosEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasByCodigoAndFechas(Cliente cliente, Date fd, Date fa) throws Exception {
        List<IvaVentasPorCaja> fact = null;
        try {
            fact = (List<IvaVentasPorCaja>) dao.getFacturasByCodigoAndFechas(cliente, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }

    //
    public void saveListaFacturas(List<IvaVentasPorCaja> facturas) throws Exception {
        if (facturas != null && !facturas.isEmpty()) {
            for (IvaVentasPorCaja iv : facturas) {
                try {
                    dao.save(iv);
                } catch (HibernateException ex) {
                    throw new Exception("Ha ocurrido un problema intentando guardar Factura.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }

    public IvaVentasPorCaja getFacturaByNumero(String letra, Integer sucursal, Integer numero) throws Exception {
        IvaVentasPorCaja ivaVentas = null;
        try {
            ivaVentas = (IvaVentasPorCaja) dao.getByLetraNumero2(letra, sucursal, numero);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }
}
