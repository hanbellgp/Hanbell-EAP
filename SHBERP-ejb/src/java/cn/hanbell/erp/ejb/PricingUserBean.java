/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.PricingUser;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class PricingUserBean extends SuperEJBForERP<PricingUser> {

    public PricingUserBean() {
        super(PricingUser.class);
    }

    public PricingUser findByGroupidAndUserid(String groupid, String userid) {
        Query query = getEntityManager().createNamedQuery("PricingUser.findByGroupidAndUserid");
        query.setParameter("groupid", groupid);
        query.setParameter("userid", userid);
        try {
            return (PricingUser) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
