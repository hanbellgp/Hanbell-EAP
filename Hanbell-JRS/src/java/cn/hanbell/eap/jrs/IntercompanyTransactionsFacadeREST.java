/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.IntercompanyTransactionsBean;
import cn.hanbell.eap.entity.IntercompanyTransactions;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/intercompanytransactions")
@javax.enterprise.context.RequestScoped
public class IntercompanyTransactionsFacadeREST extends SuperRESTForEAP<IntercompanyTransactions> {

    @EJB
    private IntercompanyTransactionsBean intercompanyTransactionsBean;

    public IntercompanyTransactionsFacadeREST() {
        super(IntercompanyTransactions.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return intercompanyTransactionsBean;
    }

}
