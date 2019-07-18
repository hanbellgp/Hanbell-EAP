/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invunit;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class InvunitBean extends SuperEJBForERP<Invunit> {

    public InvunitBean() {
        super(Invunit.class);
    }

    public Invunit findByUnitcodsc(String unitcodsc) {
        Query query = getEntityManager().createNamedQuery("Invunit.findByUnitcodsc");
        query.setParameter("unitcodsc", unitcodsc);
        try {
            return (Invunit) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
