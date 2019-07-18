/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CMSMV;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CMSMVBean extends SuperEJBForCRM<CMSMV> {

    public CMSMVBean() {
        super(CMSMV.class);
    }

    @Override
    public CMSMV findById(Object value) {
        Query query = getEntityManager().createNamedQuery("CMSMV.findByMv001");
        query.setParameter("mv001", value);
        try {
            Object o = query.getSingleResult();
            return (CMSMV) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
