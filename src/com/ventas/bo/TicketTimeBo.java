/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas.bo;

import com.ventas.dao.TicketTimeDao;
import com.ventas.entities.TicketTime;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class TicketTimeBo {

    TicketTimeDao dao = new TicketTimeDao();

    public TicketTime updateTicket(TicketTime ticket) throws Exception {
        try {
            ticket = (TicketTime) dao.update(ticket);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ticket;
    }

    public void saveTicket(TicketTime ticket) throws Exception {
        try {
            ticket = (TicketTime) dao.save(ticket);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public TicketTime getTicketById(Long id) throws Exception {
        TicketTime ticket = null;
        try {
            ticket = (TicketTime) dao.getById(TicketTime.class, id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ticket;
    }
}
