/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW033reDetail;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class HZCW033reDetailBean extends SuperEJBForEFGP<HZCW033reDetail> {

    public HZCW033reDetailBean() {
        super(HZCW033reDetail.class);
    }

    public List<HZCW033reDetail> findByLoanNo(String loanNo) {
        Query query = getEntityManager().createNamedQuery("HZCW033reDetail.findByLoanNo");
        query.setParameter("loanNo", loanNo);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
}
