/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW017;
import cn.hanbell.oa.entity.HZCW033reDetail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class HZCW017Bean extends SuperEJBForEFGP<HZCW017> {

    @EJB
    private HZCW033reDetailBean hzcw033reDetailBean;

    public HZCW017Bean() {
        super(HZCW017.class);
    }

    @Override
    public HZCW017 findById(Object value) {
        return super.findByPSN(value);
    }

    //检查是否还有借款未还
    public Boolean checkArrears(String userno) {
        double loantotal;
        double sum = 0.00;
        String loanNo;
        List<HZCW017> hzcw017List;
        List<HZCW033reDetail> hzcw033reDetails;
        try {
            Query q = this.getEntityManager().createQuery("SELECT a from HZCW017 a WHERE a.processInstance.currentState = 3 and a.arrears > 0 and a.loanUser = :loanUser ");
            q.setParameter("loanUser", userno);
            hzcw017List = q.getResultList();
            if (hzcw017List.size() > 0) {
                loanNo = hzcw017List.get(0).getProcessSerialNumber();
                loantotal = hzcw017List.get(0).getLoanTotal();
            } else {
                return true;
            }
            hzcw033reDetails = hzcw033reDetailBean.findByLoanNo(loanNo);
            if (hzcw033reDetails.size() > 0) {
                double sum1 = 0.00;
                double sum2 = 0.00;
                for (HZCW033reDetail hz033reD : hzcw033reDetails) {
                    sum1 += hz033reD.getRefund();
                    sum2 += hz033reD.getTaxInclusive();
                }
                sum = sum1 + sum2;
            }
            if (loantotal > sum) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
