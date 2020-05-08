/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.DemandsBean;
import cn.hanbell.eap.entity.Demands;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/demands")
@javax.enterprise.context.RequestScoped
public class DemandsFacadeREST extends SuperRESTForEAP<Demands> {

    @EJB
    private DemandsBean demandsBean;

    public DemandsFacadeREST() {
        super(Demands.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return demandsBean;
    }

}
