/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.BookingKindBean;
import cn.hanbell.eap.entity.BookingKind;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/bookingkind")
@javax.enterprise.context.RequestScoped
public class BookingKindFacadeREST extends SuperRESTForEAP<BookingKind> {

    @Inject
    private BookingKindBean bookingKindBean;

    public BookingKindFacadeREST() {
        super(BookingKind.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return bookingKindBean;
    }

}
