package com.ventas.services;

import com.ventas.bo.ConfiguracionTopBo;
import com.ventas.entities.ConfiguracionTop;
import com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConfiguracionTopService {
    
    public ConfiguracionTop getConfigTopById(Integer id) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ConfiguracionTop config = null;
        try {
            config = new ConfiguracionTopBo().getConfigTopById(id);
            tx.commit();
        }catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    return config;
    }
    
    public void saveConfigTop(ConfiguracionTop conf) throws Exception{
        
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ConfiguracionTopBo().saveConfigTop(conf);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    

    public void updateConfigTop(ConfiguracionTop config) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ConfiguracionTopBo().updateConfigTop(config);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
}
