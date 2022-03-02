/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invsafqy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class InvsafqyBean extends SuperEJBForERP<Invsafqy> {

    public InvsafqyBean() {
        super(Invsafqy.class);
    }

    public Invsafqy findByItnbr(String itnbr) {
        try {
            Query query = getEntityManager().createNamedQuery("Invsafqy.findByItnbr");
            query.setParameter("itnbr", itnbr);
            return (Invsafqy) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
