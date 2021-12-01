/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.SALFI;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SALFIBean extends SuperEJBForCRM<SALFI> {

    public SALFIBean() {
        super(SALFI.class);
    }

    public SALFI findByPK(String fi001) {
        Query query = getEntityManager().createNamedQuery("SALFI.findByFi001");
        query.setParameter("fi001", fi001);
        try {
            return (SALFI) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
