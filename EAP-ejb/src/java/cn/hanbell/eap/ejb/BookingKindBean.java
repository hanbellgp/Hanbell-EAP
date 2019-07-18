/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.BookingKind;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class BookingKindBean extends SuperEJBForEAP<BookingKind> {

    public BookingKindBean() {
        super(BookingKind.class);
    }

    public BookingKind findByKind(String kind) {
        Query query = this.getEntityManager().createNamedQuery("BookingKind.findByKind");
        query.setParameter("kind", kind);
        try {
            Object o = query.getSingleResult();
            return (BookingKind) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
