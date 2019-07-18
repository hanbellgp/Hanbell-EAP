/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Booking;
import com.lightshell.comm.BaseLib;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class BookingBean extends SuperEJBForEAP<Booking> {

    public BookingBean() {
        super(Booking.class);
    }

    public List<Booking> findNeedMsgNotify(int days, int hours, int minutes) {
        try {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, days);
            c.add(Calendar.HOUR, hours);
            c.add(Calendar.MINUTE, minutes);
            Date d = BaseLib.getDate("yyyy-MM-dd", BaseLib.formatDate("yyyy-MM-dd", c.getTime()));
            Date t = BaseLib.getDate("HH:mm", BaseLib.formatDate("HH:mm", c.getTime()));
            Query query = getEntityManager().createNamedQuery("Booking.findNeedMsgNotify");
            query.setParameter("startdate", d);
            query.setParameter("starttime", t);
            return query.getResultList();
        } catch (ParseException ex) {
            Logger.getLogger(BookingBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
