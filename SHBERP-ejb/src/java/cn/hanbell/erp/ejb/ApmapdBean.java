/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmapd;
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
public class ApmapdBean extends SuperEJBForERP<Apmapd> {

    public ApmapdBean() {
        super(Apmapd.class);
    }

    public List<Apmapd> findNeedThrowDetail(String facno, String apno, String aptyp) {
        Query query = this.getEntityManager().createNamedQuery("Apmapd.findByNeedThrowDetail");
        query.setParameter("facno", facno);
        query.setParameter("apno", apno);
        query.setParameter("aptyp", aptyp);
        return query.getResultList();
    }

    public Apmapd findByPK(String facno, String apno, String aptyp, String trseq) {
        Query query = this.getEntityManager().createNamedQuery("Apmapd.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("apno", apno);
        query.setParameter("aptyp", aptyp);
        query.setParameter("trseq", trseq);
        try {
            return (Apmapd) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Apmapd> findByFacnoAndApno(String facno, String apno) {
        Query query = this.getEntityManager().createNamedQuery("Apmapd.findByFacnoAndApno");
        query.setParameter("facno", facno);
        query.setParameter("apno", apno);
        return query.getResultList();
    }

    //单身发票号对应多验收类别 ogdkid='ZZZZ'
    public String getTrtypeByBilno(String facno, String apno, String aptyp, String bilno) {
        String ls_trtype = "";
        StringBuilder sb = new StringBuilder();
        sb.append("Select count(distinct ogdkid)  From apmapd ");
        sb.append("Where facno = '").append(facno).append("' and apno = '").append(apno).append("' and aptyp = '").append(aptyp).append("' ");
        sb.append(" and  bilno = '").append(bilno).append("'");
        Query query = this.getEntityManager().createNativeQuery(sb.toString());
        Object rs = query.getSingleResult();
        if (null != rs) {
            int ll_count = Integer.parseInt(rs.toString());
            if (ll_count > 1) {
                ls_trtype = "ZZZZ";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Select  Max(ogdkid)  From apmapd ");
                sb2.append("Where facno = '").append(facno).append("' and apno = '").append(apno).append("' and aptyp = '").append(aptyp).append("' ");
                sb2.append(" and  bilno = '").append(bilno).append("'");
                Query query2 = this.getEntityManager().createNativeQuery(sb2.toString());
                Object rs2 = query2.getSingleResult();
                if (null != rs2) {
                    ls_trtype = rs2.toString();
                }
            }
        }
        return ls_trtype;
    }

}
