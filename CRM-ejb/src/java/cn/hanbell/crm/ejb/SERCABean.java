/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.SERCA;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SERCABean extends SuperEJBForCRM<SERCA>{

    public SERCABean() {
        super(SERCA.class);
    }

    public String findByCa009(String kfno) {
        Query query = getEntityManager().createNamedQuery("SERCA.findByC001ToCa009");
        query.setParameter("ca001", kfno);
        try {
            Object o = query.getSingleResult();
            if (o != null) {
                SERCA sr = (SERCA) o;
                return sr.getSERCAPK().getCa001();
            }
            return null;
        } catch (Exception ex) {
            return null;
        }

    }
}
