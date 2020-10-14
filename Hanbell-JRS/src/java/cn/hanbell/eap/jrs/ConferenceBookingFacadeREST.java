/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ConferenceBookingBean;
import cn.hanbell.eap.entity.ConferenceBooking;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C1491
 */
@Path("eap/conference")
@javax.enterprise.context.RequestScoped
public class ConferenceBookingFacadeREST extends SuperRESTForEAP<ConferenceBooking> {

    @EJB
    private ConferenceBookingBean cfBookingBean;

    public ConferenceBookingFacadeREST() {
        super(ConferenceBooking.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return cfBookingBean;
    }

}
