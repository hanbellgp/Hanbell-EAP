/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Secgsys;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class SecgsysBean extends SuperEJBForERP<Secgsys> {

    public SecgsysBean() {
        super(Secgsys.class);
    }

    public Secgsys findByPK(String sysno, String groupno, String gtype) {
        Query query = getEntityManager().createNamedQuery("Secgsys.findByPK");
        query.setParameter("sysno", sysno);
        query.setParameter("groupno", groupno);
        query.setParameter("gtype", gtype);
        try {
            Object o = query.getSingleResult();
            return (Secgsys) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Secgsys> findByGroupnoAndGtype(String groupno, String gtype) {
        Query query = getEntityManager().createNamedQuery("Secgsys.findByGroupnoAndGtype");
        query.setParameter("groupno", groupno);
        query.setParameter("gtype", gtype);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<Secgsys> findByGroupno(String groupno) {
        Query query = getEntityManager().createNamedQuery("Secgsys.findByGroupno");
        query.setParameter("groupno", groupno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
}
