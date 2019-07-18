/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DDGA;
import cn.hanbell.crm.entity.DDGB;
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
public class DDGABean extends SuperEJBForCRM<DDGA> {

    @EJB
    private DDGBBean ddgbBean;
    private List<DDGB> ddgbList;

    public DDGABean() {
        super(DDGA.class);
    }

    public DDGA findByREPPB(String ga001, String ga002, String ga003) {
        Query query = this.getEntityManager().createNamedQuery("DDGA.findByREPPB");
        query.setParameter("ga001", ga001);
        query.setParameter("ga002", ga002);
        query.setParameter("ga003", ga003);
        try {
            return (DDGA) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<DDGB> getDetailList(String ga001) {
        ddgbList = ddgbBean.findByDDGA(ga001);
        return ddgbList;
    }

}
