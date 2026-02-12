/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;

import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;
import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.BudgetDetail;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class BudgetDetailBean extends SuperEJBForERP<BudgetDetail> {

    public BudgetDetailBean() {
        super(BudgetDetail.class);
    }

    public BudgetDetail findBudgetDetail(BudgetDetail entity) {
        return findBudgetDetail(entity.getBudgetDetailPK().getFacno(), entity.getBudgetDetailPK().getPeriod(), entity.getBudgetDetailPK().getCenterid(), entity.getBudgetDetailPK().getBudgetacc());
    }

    public BudgetDetail findBudgetDetail(String facno, String period, String centerid, String budgetacc) {
        Query query = getEntityManager().createNamedQuery("BudgetDetail.findBudgetDetail");
        query.setParameter("facno", facno);
        query.setParameter("period", period);
        query.setParameter("centerid", centerid);
        query.setParameter("budgetacc", budgetacc);
        try {
            return (BudgetDetail) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void add(BudgetDetail entity) throws RuntimeException {
        try {
            BudgetDetail e = findBudgetDetail(entity);
            if (e != null) {
                e.setAddamts(e.getAddamts().add(entity.getAddamts()));
                e.setDecramts(e.getDecramts().add(entity.getDecramts()));
                e.setPreamts(e.getPreamts().add(entity.getPreamts()));
                update(e);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void add(List<BudgetDetail> entities) throws RuntimeException {
        for (BudgetDetail e : entities) {
            add(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void subtract(BudgetDetail entity) throws RuntimeException {
        try {
            BudgetDetail e = findBudgetDetail(entity);
            if (e != null) {
                e.setAddamts(e.getAddamts().subtract(entity.getAddamts()));
                e.setDecramts(e.getDecramts().subtract(entity.getDecramts()));
                e.setPreamts(e.getPreamts().subtract(entity.getPreamts()));
                update(e);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void subtract(List<BudgetDetail> entities) throws RuntimeException {
        for (BudgetDetail e : entities) {
            subtract(e);
        }
    }

    public Double getBudgetBalanceForDeptPeriod(String facno, String period1, String period2, String centerid) {
        BigDecimal deptPeriod = BigDecimal.ZERO;
        double deptBalance;
        List<BudgetDetail> budgetDetails;
        Query q = this.getEntityManager().createQuery("SELECT b FROM BudgetDetail b WHERE b.budgetDetailPK.facno = :facno AND b.budgetDetailPK.period >= :period1  AND b.budgetDetailPK.period <= :period2 AND b.budgetDetailPK.centerid = :centerid ");
        q.setParameter("facno", facno);
        q.setParameter("period1", period1);
        q.setParameter("period2", period2);
        q.setParameter("centerid", centerid);
        try {
            budgetDetails = q.getResultList();
            for (BudgetDetail b : budgetDetails) {
                deptPeriod = deptPeriod.add(b.getAmts().add(b.getAddamts()).subtract(b.getDecramts()).subtract(b.getPreamts()));

            }
            deptBalance = deptPeriod.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception ex) {
            deptBalance = 0.00;
        }

        return deptBalance;
    }

    public Double getBudgetBalanceForDeptPeriod(String facno, Date date, String centerid) {
        String period1 = "";
        String period2 = "";
        String datestring = BaseLib.formatDate("yyyy/MM/dd", date);
        String[] sp = datestring.split("/");
        if (Integer.parseInt(sp[1], 10) < 4) {
            period1 = sp[0] + "01";
            period2 = sp[0] + sp[1];
        }
        if (3 < Integer.parseInt(sp[1], 10) && Integer.parseInt(sp[1], 10) < 7) {
            period1 = sp[0] + "04";
            period2 = sp[0] + sp[1];
        }
        if (6 < Integer.parseInt(sp[1], 10) && Integer.parseInt(sp[1], 10) < 10) {
            period1 = sp[0] + "07";
            period2 = sp[0] + sp[1];
        }
        if (9 < Integer.parseInt(sp[1], 10) && Integer.parseInt(sp[1], 10) < 13) {
            period1 = sp[0] + "10";
            period2 = sp[0] + sp[1];
        }

        return this.getBudgetBalanceForDeptPeriod(facno, period1, period2, centerid);

    }

    public Double getBudgetBalanceForDeptYear(String facno, Date date, String centerid) {
        String period1 = "";
        String period2 = "";
        String datestring = BaseLib.formatDate("yyyy/MM/dd", date);
        String[] sp = datestring.split("/");
        period1 = sp[0] + "01";
        period2 = sp[0] + "12";
        return this.getBudgetBalanceForDeptPeriod(facno, period1, period2, centerid);
    }
}
