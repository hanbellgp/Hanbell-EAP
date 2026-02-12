/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;

import cn.hanbell.util.BaseLib;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Accrno;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class AccrnoBean extends SuperEJBForERP<Accrno> {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public AccrnoBean() {
        super(Accrno.class);
    }

    public Accrno findMaxByPK(String facno, Date date) {
        Query query = getEntityManager().createNamedQuery("Accrno.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("finvdate", date);
        try {
            return (Accrno) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public String getFormId(String facno, Date date, Boolean flag) throws Exception {
        String newid;
        int maxid;
        Accrno accrno = findMaxByPK(facno, date);
        if (accrno != null) {
            maxid = accrno.getFinvno() + 1;
            accrno.setFinvno((short) maxid);
            newid = facno + BaseLib.formatDate("yyyyMMdd", date).substring(3) + String.format("%05d", maxid);
            if (flag) {
                this.update(accrno);
                this.getEntityManager().flush();
            }
        } else {
            newid = facno + BaseLib.formatDate("yyyyMMdd", date).substring(3) + String.format("%05d", 1);
            if (flag) {
                Accrno e = new Accrno(facno, date);
                e.setFinvno((short) 1);
                this.persist(e);
                this.getEntityManager().flush();
            }
        }
        return newid;
    }

}
