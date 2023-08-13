/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Purcontract;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class PurcontractBean extends SuperEJBForERP<Purcontract> {

    public PurcontractBean() {
        super(Purcontract.class);
    }

    public Purcontract findByItnbrAndVdr(String facno, String prono, String itnbr, String vdrno, Date requestDate) {
        Query query = getEntityManager().createNamedQuery("Purcontract.findByItnbrAndVdr");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("vdrno", vdrno);
        query.setParameter("itnbr", itnbr);
        query.setParameter("fromdate", requestDate);
        query.setParameter("enddate", requestDate);
        try {
            List<Purcontract> list = query.getResultList();
            if (null == list || list.size() > 1) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public BigDecimal getUnprisByItnbrAndVdr(String facno, String prono, String itnbr, String vdrno, Date requestDate, BigDecimal apmqty) {
        BigDecimal unpris;
        BigDecimal disqy5, disqy4, disqy3, disqy2, disqy1;
        BigDecimal dispri5, dispri4, dispri3, dispri2, dispri1, dispri0;
        setCompany(facno);
        Purcontract pc = this.findByItnbrAndVdr(facno, prono, itnbr, vdrno, requestDate);
        if (null == pc) {
            return BigDecimal.ZERO;
        }
        if (pc.getSelpricode().equals('1')) {
            unpris = pc.getUnpri();
        } else {
            disqy5 = pc.getDisqy5();
            dispri5 = pc.getDispri5();
            disqy4 = pc.getDisqy4();
            dispri4 = pc.getDispri4();
            disqy3 = pc.getDisqy3();
            dispri3 = pc.getDispri3();
            disqy2 = pc.getDisqy2();
            dispri2 = pc.getDispri2();
            disqy1 = pc.getDisqy1();
            dispri1 = pc.getDispri1();
            dispri0 = pc.getDispri0();
            unpris = (disqy5.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy5) >= 0) ? dispri5 : disqy4.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy4) >= 0
                    ? dispri4 : disqy3.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy3) >= 0 ? dispri3 : disqy2.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy2) >= 0
                    ? dispri2 : disqy1.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy1) >= 0 ? dispri1 : dispri0;

        }
        return unpris;
    }

}
