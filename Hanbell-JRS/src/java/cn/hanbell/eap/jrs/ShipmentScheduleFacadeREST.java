/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ShipmentScheduleBean;
import cn.hanbell.eap.entity.ShipmentSchedule;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/shipmentschedule")
@javax.enterprise.context.RequestScoped
public class ShipmentScheduleFacadeREST extends SuperRESTForEAP<ShipmentSchedule> {

    @EJB
    private ShipmentScheduleBean shipmentScheduleBean;

    public ShipmentScheduleFacadeREST() {
        super(ShipmentSchedule.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return shipmentScheduleBean;
    }

}
