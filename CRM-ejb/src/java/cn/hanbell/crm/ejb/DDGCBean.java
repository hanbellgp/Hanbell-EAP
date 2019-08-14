/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DDGC;
import cn.hanbell.crm.entity.DDGD;
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
public class DDGCBean extends SuperEJBForCRM<DDGC> {

    @EJB
    private DDGDBean ddgdBean;
    private List<DDGD> ddgdList;

    public DDGCBean() {
        super(DDGC.class);
    }

    public DDGC findByREPPB(String gc001, String gc002, String gc003) {
        Query query = this.getEntityManager().createNamedQuery("DDGC.findByREPPB");
        query.setParameter("gc001", gc001);
        query.setParameter("gc002", gc002);
        query.setParameter("gc003", gc003);
        try {
            return (DDGC) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<DDGD> getDetailList(String gd001) {
        ddgdList = ddgdBean.findByDDGC(gd001);
        return ddgdList;
    }

}
