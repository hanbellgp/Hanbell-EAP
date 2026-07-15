/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrqhdsc;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrqhdscBean extends SuperEJBForERP<Cdrqhdsc> {

    public CdrqhdscBean() {
        super(Cdrqhdsc.class);
    }

    public Cdrqhdsc findByQuono(String quono) {
        Query query = this.getEntityManager().createNamedQuery("Cdrqhdsc.findByQuono");
        query.setParameter("quono", quono);
        try {
            return (Cdrqhdsc) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
}
