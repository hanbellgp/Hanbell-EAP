/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrpaydsc;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrpaydscBean extends SuperEJBForERP<Cdrpaydsc> {

    public CdrpaydscBean() {
        super(Cdrpaydsc.class);
    }

    public Cdrpaydsc findByPK(Character difcode, String allcode) {
        Query query = this.getEntityManager().createNamedQuery("Cdrpaydsc.findByPK");
        query.setParameter("difcode", difcode);
        query.setParameter("allcode", allcode);
        try {
            return (Cdrpaydsc) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

}
