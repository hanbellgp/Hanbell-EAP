/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.WARTB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class WARTBBean extends SuperEJBForCRM<WARTB>{

    public WARTBBean(){
        super(WARTB.class);
    }
    public WARTB findByPK(String tb001,String tb002,String tb003){
        Query query = this.getEntityManager().createNamedQuery("WARTB.findByPK");
        query.setParameter("tb001", tb001);
        query.setParameter("tb002", tb002);
        query.setParameter("tb003", tb003);
        try {
            Object o = query.getSingleResult();
            return (WARTB) o;
        } catch (Exception ex) {
            return null;
        }
    }
}
