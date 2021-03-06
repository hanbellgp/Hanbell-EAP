/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Secguser;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SecguserBean extends SuperEJBForERP<Secguser> {

    public SecguserBean() {
        super(Secguser.class);
    }

    public List<Secguser> findByGroupno(String groupno) {
        Query query = getEntityManager().createNamedQuery("Secguser.findByGroupno");
        query.setParameter("groupno", groupno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Secguser findByPK(String groupno, String gtype, String userno) {
        Query query = getEntityManager().createNamedQuery("Secguser.findByPK");
        query.setParameter("groupno", groupno);
        query.setParameter("gtype", gtype);
        query.setParameter("userno", userno);
        try {
            Object o = query.getSingleResult();
            return (Secguser) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
