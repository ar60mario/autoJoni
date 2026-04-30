package com.ventas.dao;

import com.ventas.entities.Cliente;
import com.ventas.entities.IvaVentasPorCaja;
import com.ventas.util.HibernateUtils;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class IvaVentasPorCajaDao extends GenericDao {

    private DecimalFormat df_mes = new DecimalFormat("00");
    private DecimalFormat df_anio = new DecimalFormat("0000");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public List<IvaVentasPorCaja> getFacturasPendientesDeEnviarArca() {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.eq("activa", true))
                .list();
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasEntreFechas(Date fd, Date fa) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.between("fecha", fd, fa))
                //  .add(Restrictions.eq("panificado", false))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasBEntreFechas(Date fd, Date fa) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.between("fecha", fd, fa))
                //  .add(Restrictions.eq("panificado", false))
                .add(Restrictions.eq("tipoDoc", 6))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasEntreFechasOrdenCliente(Date fd, Date fa) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(IvaVentasPorCaja.class);
        Criteria criteria2 = criteria.createCriteria("cliente");
        criteria.add(Restrictions.between("fecha", fd, fa));

        criteria2.addOrder(Order.asc("razonSocial"));
        criteria.addOrder(Order.asc("letra"));
        criteria.addOrder(Order.asc("numeroFactura"));
        fact = (List<IvaVentasPorCaja>) criteria.list();
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasEntreFechasOrdenNroFc(Date fd, Date fa) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(IvaVentasPorCaja.class);
//        Criteria criteria2 = criteria.createCriteria("cliente");
        criteria.add(Restrictions.between("fecha", fd, fa));
        criteria.addOrder(Order.asc("fecha"));
        criteria.addOrder(Order.asc("letra"));
        criteria.addOrder(Order.asc("numeroFactura"));
        fact = (List<IvaVentasPorCaja>) criteria.list();
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasByPeriodo(Integer mes, Integer anio) {
        List<IvaVentasPorCaja> fact;
        Date fd;
        try {
            fd = sdf.parse("01/" + df_mes.format(mes) + "/" + df_anio.format(anio));
        } catch (ParseException ex) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fd);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date fa = cal.getTime();
        System.out.println(fd);
        System.out.println(fa);
//        System.exit(0);
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(IvaVentasPorCaja.class);
//        Criteria criteria2 = criteria.createCriteria("cliente");
        criteria.add(Restrictions.between("fecha", fd, fa));
        criteria.addOrder(Order.asc("fecha"));
        criteria.addOrder(Order.asc("letra"));
        criteria.addOrder(Order.asc("numeroFactura"));
        fact = (List<IvaVentasPorCaja>) criteria.list();
        return fact;
    }

    public String getUltimaFechaFactura(String cuitTitular) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.eq("cuitTitular", cuitTitular))
                //  .add(Restrictions.eq("panificado", false))
                .setMaxResults(3)
                .addOrder(Order.desc("fecha"))
                //                        .addOrder(Order.asc("letra"))
                .addOrder(Order.desc("numeroFactura"))
                .list();
        Date fecha = fact.get(0).getFecha();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fecha);
    }

    public IvaVentasPorCaja getUltimaFactura(Integer td) {
        List<IvaVentasPorCaja> fact;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.eq("tipoDoc", td))
                .addOrder(Order.desc("fecha"))
                .addOrder(Order.desc("numeroFactura"))
                .setMaxResults(3)
                .list();
        IvaVentasPorCaja iv = fact.get(0);
        return iv;
    }

    public String getUltimaNombreEnFactura() {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                //                        .add(Restrictions.between("fecha", fd, fa))
                //  .add(Restrictions.eq("panificado", false))
                .setMaxResults(3)
                .addOrder(Order.desc("fecha"))
                //                        .addOrder(Order.asc("letra"))
                .addOrder(Order.desc("numeroFactura"))
                .list();
        String nombre = fact.get(0).getCliente().getRazonSocial();

        return nombre;
    }

    public String getUltimoCuitEnFactura() {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                //                        .add(Restrictions.between("fecha", fd, fa))
                //  .add(Restrictions.eq("panificado", false))
                .setMaxResults(3)
                .addOrder(Order.desc("fecha"))
                //                        .addOrder(Order.asc("letra"))
                .addOrder(Order.desc("numeroFactura"))
                .list();
        String nombre = fact.get(0).getCliente().getCuit();

        return nombre;
    }

    public String getUltimoImporteFactura(String cuitTitular) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.eq("cuitTitular", cuitTitular))
                //  .add(Restrictions.eq("panificado", false))
                .setMaxResults(3)
                .addOrder(Order.desc("fecha"))
                //                        .addOrder(Order.asc("letra"))
                .addOrder(Order.desc("numeroFactura"))
                .list();
        Double importe = fact.get(0).getTotal();
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(importe);
    }

    public Integer getUltimoNumeroFactura(String cuitTitular) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.eq("cuitTitular", cuitTitular))
                .add(Restrictions.eq("tipoDoc", 6))
                .setMaxResults(3)
                .addOrder(Order.desc("numeroFactura"))
                //                        .addOrder(Order.asc("letra"))
                //                        .addOrder(Order.desc("numeroFactura"))
                .list();
        Integer numero = fact.get(0).getNumeroFactura();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return numero;
    }

    public Integer getUltimoNumeroFacturaA(String cuitTitular) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.eq("cuitTitular", cuitTitular))
                .add(Restrictions.eq("tipoDoc", 1))
                .setMaxResults(3)
                .addOrder(Order.desc("numeroFactura"))
                //                        .addOrder(Order.asc("letra"))
                //                        .addOrder(Order.desc("numeroFactura"))
                .list();
        Integer numero = fact.get(0).getNumeroFactura();

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return numero;
    }

    public List<IvaVentasPorCaja> getFacturasPanificadosEntreFechas(Date fd, Date fa) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("numeroSucursal", 7))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasCigarrillosEntreFechas(Date fd, Date fa) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("numeroSucursal", 6))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentasPorCaja> getFacturasByCodigoAndFechas(Cliente cliente, Date fd, Date fa) {
        List<IvaVentasPorCaja> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentasPorCaja>) session.createCriteria(IvaVentasPorCaja.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("cliente", cliente))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public IvaVentasPorCaja getByLetraNumero(String letra, Integer sucursal, Integer numero) {
        IvaVentasPorCaja factura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from IvaVentas iv ");
        sb.append("where iv.letra = '" + letra + "' and iv.numeroSucursal = '"
                + sucursal + "' and iv.numeroFactura = '" + numero + "' ");
        Query query = session.createQuery(sb.toString());
        factura = (IvaVentasPorCaja) query.uniqueResult();
        return factura;
    }

    public IvaVentasPorCaja getByLetraNumero2(String letra, Integer sucursal, Integer numero) {
        IvaVentasPorCaja factura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        factura = (IvaVentasPorCaja) session.createCriteria(IvaVentasPorCaja.class)
                //                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("letra", letra))
                .add(Restrictions.eq("numeroSucursal", sucursal))
                .add(Restrictions.eq("numeroFactura", numero))
                .add(Restrictions.eq("tipoDoc", 6))
                //                .addOrder(Order.asc("fecha"))
                //                .addOrder(Order.asc("letra"))
                //                .addOrder(Order.asc("numeroFactura"))
                .uniqueResult();
        return factura;
    }
}
