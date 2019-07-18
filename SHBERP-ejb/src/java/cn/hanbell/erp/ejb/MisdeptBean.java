/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Misdept;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class MisdeptBean extends SuperEJBForERP<Misdept> {

    public MisdeptBean() {
        super(Misdept.class);
    }

    @Override
    public Misdept findById(Object value) {
        return findByDepno(value.toString());
    }

    public Misdept findByDepno(String depno) {
        Query query = this.getEntityManager().createNamedQuery("Misdept.findByDepno");
        query.setParameter("depno", depno);
        try {
            Object o = query.getSingleResult();
            return (Misdept) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
