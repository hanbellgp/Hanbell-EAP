/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrcusrel;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrcusrelBean extends SuperEJBForERP<Cdrcusrel> {

    public CdrcusrelBean() {
        super(Cdrcusrel.class);
    }

    public List<Cdrcusrel> findByCusno(String cusno) {
        Query query = this.getEntityManager().createNamedQuery("Cdrcusrel.findByCusno");
        query.setParameter("cusno", cusno);
        return query.getResultList();
    }

}
