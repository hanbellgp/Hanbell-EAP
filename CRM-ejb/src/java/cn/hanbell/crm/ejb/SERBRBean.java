/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.SERBR;
import cn.hanbell.crm.entity.SERBRPK;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class SERBRBean extends SuperEJBForCRM<SERBR> {

    public SERBRBean() {
        super(SERBR.class);
    }

    public SERBR findByPK(String Br001, String Br002) {
        SERBRPK pk = new SERBRPK();
        pk.setBr001(Br001);
        pk.setBr002(Br002);
        Query query = getEntityManager().createNamedQuery("SERBR.findByPK");
        query.setParameter("br001", Br001);
        query.setParameter("br002", Br002);
        try {
            Object o = query.getSingleResult();
            return (SERBR) o;
        } catch (Exception ex) {
            return null;
        }
    }
}
