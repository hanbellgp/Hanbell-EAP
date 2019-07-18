/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPPA;
import cn.hanbell.crm.entity.REPPB;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class REPPABean extends SuperEJBForCRM<REPPA> {

    @EJB
    private REPPBBean reppbBean;

    private List<REPPB> reppbList;

    public REPPABean() {
        super(REPPA.class);
    }

    public List<REPPA> findNeedThrow() {
        Query query = this.getEntityManager().createNamedQuery("REPPA.findNeedThrow").setFirstResult(0).setMaxResults(1);
        return query.getResultList();
    }

    public List<REPPB> getDetailList(String pa001, String pa002) {
        reppbList = reppbBean.findByREPPAPK(pa001, pa002);
        return reppbList;
    }

    public REPPA findByPK(String pa001, String pa002) {
        Query query = getEntityManager().createNamedQuery("REPPA.findByPK");
        query.setParameter("pa001", pa001);
        query.setParameter("pa002", pa002);
        try {
            Object o = query.getSingleResult();
            return (REPPA) o;
        } catch (Exception ex) {
            return null;
        }
    }

    //根据报价单号查询
    public REPPA findByPA519(String pa519) {
        Query query = getEntityManager().createNamedQuery("REPPA.findByPA519");
        query.setParameter("pa519", pa519);
        try {
            Object o = query.getSingleResult();
            return (REPPA) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
