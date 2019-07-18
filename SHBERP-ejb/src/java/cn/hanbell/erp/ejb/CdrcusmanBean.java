/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrcusman;
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
public class CdrcusmanBean extends SuperEJBForERP<Cdrcusman> {

    public CdrcusmanBean() {
        super(Cdrcusman.class);
    }

    public List<Cdrcusman> findByMan(String man) {
        Query query = this.getEntityManager().createNamedQuery("Cdrcusman.findByMan");
        query.setParameter("man", man);
        return query.getResultList();
    }

    public Cdrcusman findByPK(String facno, String cusno) {
        Query query = getEntityManager().createNamedQuery("Cdrcusman.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("cusno", cusno);
        try {
            Object o = query.getSingleResult();
            if (o != null) {
                return (Cdrcusman) o;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

}
