/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ventas.services;

import com.ventas.bo.SubRubroBo;
import com.ventas.entities.SubRubro;
import com.ventas.util.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrador
 */
public class SubRubroService {

    public List<SubRubro> getAllSubRubros() throws Exception {
      List<SubRubro> listaSubRubro = new ArrayList();
      Session session = HibernateUtils.getSessionFactory().getCurrentSession();
      Transaction tx = session.beginTransaction();
      try{
          SubRubroBo bo = new SubRubroBo();
          listaSubRubro = bo.getAllRubros();
          tx.commit();
      }
      catch(Exception ex){
          tx.rollback();
         throw new Exception(ex);
      }
      
      
      return listaSubRubro;   
    }
    public void saveSubRubro(SubRubro subRubro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new SubRubroBo().saveSubRubro(subRubro);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void updateSubRubro(SubRubro subRubro) throws Exception {
       Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            new SubRubroBo().updateSubrubro(subRubro);
            tx.commit();
        }
        catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }

    public void deleteSubRubro(SubRubro subRubroABorrar) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            new SubRubroBo().deleteSelectedSubRubro(subRubroABorrar);
            tx.commit();
        }
        catch (Exception ex){
            tx.rollback();
            throw new Exception (ex); 
        }
    }
    
    public SubRubro getSubRubroByCodigo(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        SubRubro subRubro = null;
        try {
            subRubro = new SubRubroBo().getSubRubroByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            subRubro = null;
            throw new Exception(ex);
        }
        return subRubro;
    }
}
