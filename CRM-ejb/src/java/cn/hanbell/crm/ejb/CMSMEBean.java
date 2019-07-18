/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CMSME;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CMSMEBean extends SuperEJBForCRM<CMSME> {

    public CMSMEBean() {
        super(CMSME.class);
    }

    @Override
    public CMSME findById(Object value) {
        Query query = getEntityManager().createNamedQuery("CMSME.findByMe001");
        query.setParameter("me001", value);
        try {
            Object o = query.getSingleResult();
            return (CMSME) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
