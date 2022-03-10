/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Mcbudget;
import java.math.BigDecimal;
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
public class McbudgetBean extends SuperEJBForEAP<Mcbudget> {

    public McbudgetBean() {
        super(Mcbudget.class);
    }

    public List<Mcbudget> findBySrcno(String srcno) {
        Query query = getEntityManager().createNamedQuery("Mcbudget.findBySrcno");
        query.setParameter("srcno", srcno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Mcbudget findByProperties(String type, String srcno, String facno, String period, String centerid, String budgetacc, BigDecimal preamts) {
        Query query = getEntityManager().createNamedQuery("Mcbudget.findByProperties");
        query.setParameter("type", type);
        query.setParameter("srcno", srcno);
        query.setParameter("facno", facno);
        query.setParameter("period", period);
        query.setParameter("centerid", centerid);
        query.setParameter("budgetacc", budgetacc);
        query.setParameter("preamts", preamts);
        try {
            return (Mcbudget) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 检查报销单明细与费控中间表预扣是否一致
     */
    public boolean checkMcbudget(String type, String srcno, String facno, String period, String centerid, String budgetacc, BigDecimal preamts) {
        //List<Mcbudget> bcList = mcbudgetBean.findBySrcno(srcno);
        Mcbudget m = findByProperties(type, srcno, facno, period, centerid, budgetacc, preamts);
        if (null == m) {
            return false;
        }
        return true;
    }

}
