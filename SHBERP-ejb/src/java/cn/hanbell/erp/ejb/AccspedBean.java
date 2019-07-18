/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Accsped;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class AccspedBean extends SuperEJBForERP<Accsped> {

    public AccspedBean() {
        super(Accsped.class);
    }

    public List<Accsped> findByConfig(short config) {
        Query query = getEntityManager().createNamedQuery("Accsped.findByConfig");
        query.setParameter("config", config);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
