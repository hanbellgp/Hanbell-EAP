/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Secgroup;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class SecgroupBean extends SuperEJBForERP<Secgroup> {

    public SecgroupBean() {
        super(Secgroup.class);
    }

    @Override
    public Secgroup findById(Object value) {
        return findByGroupno(value.toString());
    }

    public Secgroup findByGroupno(String groupno) {
        Query query = getEntityManager().createNamedQuery("Secgroup.findByGroupno");
        query.setParameter("groupno", groupno);
        try {
            Object o = query.getSingleResult();
            return (Secgroup) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
