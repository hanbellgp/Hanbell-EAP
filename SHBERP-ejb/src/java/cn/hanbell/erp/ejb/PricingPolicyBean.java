/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.PricingPolicy;
import cn.hanbell.erp.entity.PricingPolicy;
import java.util.ArrayList;
import java.util.List;
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
public class PricingPolicyBean extends SuperEJBForERP<PricingPolicy> {

    public PricingPolicyBean() {
        super(PricingPolicy.class);
    }

    @Override
    public PricingPolicy findById(Object value) {
        Query query = getEntityManager().createNamedQuery("PricingPolicy.findByPricingId");
        query.setParameter("pricingid", value);
        return (PricingPolicy) query.getSingleResult();
    }

}
