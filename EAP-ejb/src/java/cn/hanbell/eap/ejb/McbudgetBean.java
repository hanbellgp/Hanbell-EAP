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
        try {
            List resultList = query.getResultList();
            if (null == resultList || resultList.isEmpty()) {
                return null;
            }
            return (Mcbudget) resultList.get(0);
              //存在多笔中间表明细科目+金额一样情况，在总金额再核对
//            Mcbudget m = (Mcbudget) query.getSingleResult();
//            if (null == m) {
//                return null;
//            }
//            if (m.getPreamts().compareTo(preamts) == 0) {
//                return (Mcbudget) query.getSingleResult();
//            } else {
//                return null;
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
