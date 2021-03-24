/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.PricingPolicyBean;
import cn.hanbell.erp.entity.PricingPolicy;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.util.SuperEJB;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("shberp/pricingpolicy")
@javax.enterprise.context.RequestScoped
public class PricingPolicyFacadeREST extends SuperRESTForERP<PricingPolicy> {

    @Inject
    private PricingPolicyBean pricingPolicyBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return pricingPolicyBean;
    }

    public PricingPolicyFacadeREST() {
        super(PricingPolicy.class);
    }

}
