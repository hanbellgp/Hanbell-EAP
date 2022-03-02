/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Manpih;
import java.math.BigDecimal;
import javax.persistence.Query;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class ManpihBean extends SuperEJBForERP<Manpih> {

    public ManpihBean() {
        super(Manpih.class);
    }

    public BigDecimal findAvgDraw(String facno, String itnbr, String month) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select a.trnqy from(");
        sql.append(" select d.altitnbr as itnbr,i.itcls,convert(char(6),h.issdate,112) as yearmon,i.itdsc,i.pocode,sum(risqty1) as trnqy");
        sql.append(" from manpih h,manpid d,invmas i");
        sql.append(" where h.facno='").append("facno").append("' and h.prono='1' and d.facno='").append("facno").append("' and d.prono='1' and h.facno=d.facno and h.prono=d.prono and h.pisno=d.pisno and d.altitnbr=i.itnbr");
        sql.append(" and h.issstatus<>'D'  and h.iocode='2' ");
        sql.append(" and d.altitnbr='").append(itnbr).append("'");
        sql.append(" group by d.altitnbr,i.itcls,convert(char(6),h.issdate,112),i.itdsc,i.spdsc,i.pocode");
        sql.append(" union");
        sql.append(" select d.altitnbr as itnbr,i.itcls,convert(char(6),h.issdate,112) as yearmon,i.itdsc,i.pocode,sum(risqty1) as trnqy");
        sql.append(" from manpihh h,manpidh d,invmas i");
        sql.append(" where  h.facno='").append("facno").append("' and h.prono='1' and d.facno='").append("facno").append("' and d.prono='1' and h.facno=d.facno and h.prono=d.prono and h.pisno=d.pisno and d.altitnbr=i.itnbr");
        sql.append(" and h.issstatus<>'D'  and h.iocode='2' ");
        sql.append(" and d.altitnbr='").append(itnbr).append("'");
        sql.append(" group by d.altitnbr,i.itcls,convert(char(6),h.issdate,112),i.itdsc,i.pocode");
        sql.append(" )a where a.yearmon='").append(month).append("'");
        try {
            Query q = getEntityManager().createNativeQuery(sql.toString());
            return (BigDecimal) q.getSingleResult();
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }
}
