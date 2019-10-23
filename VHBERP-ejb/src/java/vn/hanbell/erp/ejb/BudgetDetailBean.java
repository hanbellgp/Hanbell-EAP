/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;



import cn.hanbell.oa.ejb.VHTV001Bean;
import cn.hanbell.oa.ejb.VHTV002Bean;
import cn.hanbell.oa.ejb.VHTV002reDetailBean;
import cn.hanbell.oa.ejb.VHTV003Bean;
import cn.hanbell.oa.ejb.VHTV003reDetailBean;
import cn.hanbell.oa.entity.VHTV001;
import cn.hanbell.oa.entity.VHTV002;
import cn.hanbell.oa.entity.VHTV002reDetail;
import cn.hanbell.oa.entity.VHTV003;
import cn.hanbell.oa.entity.VHTV003reDetail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.BudgetDetail;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class BudgetDetailBean extends SuperEJBForERP<BudgetDetail> {

    @EJB
    private VHTV003Bean vhtv003Bean;
    @EJB
    private VHTV003reDetailBean vhtv003reDetailBean;
    @EJB
    private VHTV002Bean vhtv002Bean;
    @EJB
    private VHTV002reDetailBean vhtv002reDetailBean;
    @EJB
    private VHTV001Bean vhtv001Bean;

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

    public Boolean addByOAVHTV003(String psn) {
        String period;
        Date date;
        VHTV003 v = vhtv003Bean.findByPSN(psn);
        String facno = v.getFacno();
        List<BudgetDetail> budgetDetails = new ArrayList<>();
        List<VHTV003reDetail> details = null;
        try {

            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", v.getAppDate())); //付款日期
            period = BaseLib.formatDate("yyyyMM", date);
            System.out.println(period);

            details = vhtv003reDetailBean.findByFSN(v.getFormSerialNumber());

            for (int i = 0; i < details.size(); i++) {

                VHTV003reDetail detail = details.get(i);
                //预算金额更新逻辑
                BudgetDetail u;
                u = new BudgetDetail(facno, "", period, detail.getCenterid(), detail.getBudgetAcc(), "R", i + 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(Double.valueOf(detail.getTaxInclusive())*(v.getRatio())));
                budgetDetails.add(u);

            }

            this.add(budgetDetails);
            this.getEntityManager().flush();

            return true;
        } catch (ParseException | RuntimeException ex) {
            Logger.getLogger(ApmpayBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (details != null && !details.isEmpty()) {
                details.clear();
            }
            if (budgetDetails != null && !budgetDetails.isEmpty()) {
                budgetDetails.clear();
            }
        }
    }

    public Boolean subtractByOAVHTV003(String psn) {
        String period;
        Date date;
        VHTV003 v = vhtv003Bean.findByPSN(psn);
        String facno = v.getFacno();
        List<BudgetDetail> budgetDetails = new ArrayList<>();
        List<VHTV003reDetail> details = null;
        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", v.getAppDate())); //付款日期
            period = BaseLib.formatDate("yyyyMM", date);

            details = vhtv003reDetailBean.findByFSN(v.getFormSerialNumber());

            for (int i = 0; i < details.size(); i++) {
                VHTV003reDetail detail = details.get(i);
                //预算金额更新逻辑
                BudgetDetail u;
                u = new BudgetDetail(facno, "", period, detail.getCenterid(), detail.getBudgetAcc(), "R", i + 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(Double.valueOf(detail.getTaxInclusive() )* (v.getRatio())));
                budgetDetails.add(u);
            }

            this.subtract(budgetDetails);
            this.getEntityManager().flush();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(ApmpayBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (details != null && !details.isEmpty()) {
                details.clear();
            }
            if (budgetDetails != null && !budgetDetails.isEmpty()) {
                budgetDetails.clear();
            }
        }
    }

    public Boolean addByOAVHTV001(String psn) {
        String period;
        Date date;
        VHTV001 j = vhtv001Bean.findByPSN(psn);
        List<BudgetDetail> budgetDetails = new ArrayList<>();

        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", j.getLoanDate())); //付款日期
            period = BaseLib.formatDate("yyyyMM", date);
            System.out.println(period);

            //预算金额更新逻辑
            BudgetDetail u;
            u = new BudgetDetail("V", "", period, j.getCenterid(), j.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(j.getTotalRMB()));
            budgetDetails.add(u);
            this.add(budgetDetails);
            this.getEntityManager().flush();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ApmpayBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Boolean subtractByOAVHTV001(String psn) {
        String period;
        Date date;
        VHTV001 j = vhtv001Bean.findByPSN(psn);
        List<BudgetDetail> budgetDetails = new ArrayList<>();
        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", j.getLoanDate())); //付款日期
            period = BaseLib.formatDate("yyyyMM", date);
            System.out.println(period);
            //预算金额更新逻辑
            BudgetDetail u;
            u = new BudgetDetail("V", "", period, j.getCenterid(), j.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(j.getTotalRMB()));
            budgetDetails.add(u);
            this.subtract(budgetDetails);
            this.getEntityManager().flush();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ApmpayBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Boolean addByOAVHTV002(String psn) {
        String period;
        Date date;
        VHTV002 j = vhtv002Bean.findByPSN(psn);
        String facno = j.getFacno();
        List<BudgetDetail> budgetDetails = new ArrayList<>();

        try {

            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", j.getAppDate())); //付款日期
            period = BaseLib.formatDate("yyyyMM", date);
            System.out.println(period);
            List<VHTV002reDetail> details = vhtv002reDetailBean.findByFSN(j.getFormSerialNumber());

            for (int i = 0; i < details.size(); i++) {

                VHTV002reDetail detail = details.get(i);

                //预算金额更新逻辑
                BudgetDetail u;
                u = new BudgetDetail(facno, "", period, detail.getCenterid(), detail.getBudgetAcc(), "R", i + 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(Double.valueOf(detail.getTaxInclusive()) * (j.getRatio())));
                budgetDetails.add(u);

            }
            //改变借支单科目预扣
            BudgetDetail u1;
            VHTV001 jz = vhtv001Bean.findByPSN(details.get(0).getLoanNo());
            Date date1 = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", jz.getLoanDate())); //借支单日期
            String period1 = BaseLib.formatDate("yyyyMM", date1);
            if (j.getTotaltaxInclusiveRMB() <= jz.getTotalRMB()) {
                u1 = new BudgetDetail("V", "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(BigDecimal.valueOf(j.getTotaltaxInclusiveRMB())));
            } else {
                u1 = new BudgetDetail("V", "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(BigDecimal.valueOf(jz.getTotalRMB())));
            }
            budgetDetails.add(u1);

            this.add(budgetDetails);
            this.getEntityManager().flush();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(BudgetDetailBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Boolean subtractByOAVHTV002(String psn) {
        String period;
        Date date;
        VHTV002 j = vhtv002Bean.findByPSN(psn);
        String facno = j.getFacno();
        List<BudgetDetail> budgetDetails = new ArrayList<>();

        try {

            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", j.getAppDate())); //付款日期
            period = BaseLib.formatDate("yyyyMM", date);
            System.out.println(period);
            List<VHTV002reDetail> details = vhtv002reDetailBean.findByFSN(j.getFormSerialNumber());

            for (int i = 0; i < details.size(); i++) {

                VHTV002reDetail detail = details.get(i);

                //预算金额更新逻辑
                BudgetDetail u;
                u = new BudgetDetail(facno, "", period, detail.getCenterid(), detail.getBudgetAcc(), "R", i + 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(Double.valueOf(detail.getTaxInclusive()) * (j.getRatio())));
                budgetDetails.add(u);

            }
            //改变借支单科目预扣
            BudgetDetail u1;
            VHTV001 jz = vhtv001Bean.findByPSN(details.get(0).getLoanNo());
            Date date1 = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", jz.getLoanDate())); //借支单日期
            String period1 = BaseLib.formatDate("yyyyMM", date1);
            u1 = new BudgetDetail("V", "", period1, jz.getCenterid(), jz.getPreAccno(), "R", 1, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO.subtract(BigDecimal.valueOf(j.getTotaltaxInclusiveRMB())));
            budgetDetails.add(u1);

            this.subtract(budgetDetails);
            this.getEntityManager().flush();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(ApmpayBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
