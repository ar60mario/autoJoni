/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ventas.services;

import com.ventas.bo.TipoDocBo;
import com.ventas.entities.TipoDoc;
import com.ventas.util.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Administrador
 */
public class TipoDocService {

    public List<TipoDoc> getAllTipoDocs() throws Exception {
      List<TipoDoc> listaTipoDoc = new ArrayList();
      Session session = HibernateUtils.getSessionFactory().getCurrentSession();
      Transaction tx = session.beginTransaction();
      try{
          TipoDocBo bo = new TipoDocBo();
          listaTipoDoc = bo.getAllDocs();
          tx.commit();
      }
      catch(Exception ex){
          tx.rollback();
         throw new Exception(ex);
      }
      
      
      return listaTipoDoc;   
    }
    public void saveTipoDoc(TipoDoc tipoDoc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new TipoDocBo().saveTipoDoc(tipoDoc);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void updateTipoDoc(TipoDoc tipoDoc) throws Exception {
       Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            new TipoDocBo().updateTipoDoc(tipoDoc);
            tx.commit();
        }
        catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }

    public void deleteTipoDoc(TipoDoc tipoDocABorrar) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            new TipoDocBo().deleteSelectedTipoDoc(tipoDocABorrar);
            tx.commit();
        }
        catch (Exception ex){
            tx.rollback();
            throw new Exception (ex); 
        }
    }
    
    public TipoDoc getTipoDocByCodigo(String codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        TipoDoc tipoDoc = null;
        try {
            tipoDoc = new TipoDocBo().getTipoDocByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tipoDoc = null;
            throw new Exception(ex);
        }
        return tipoDoc;
    }
}
