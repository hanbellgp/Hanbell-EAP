/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Puracd;
import cn.hanbell.erp.entity.Purach;
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
public class PurachBean extends SuperEJBForERP<Purach> {

    @EJB
    private PuracdBean puracdBean;

    private List<Puracd> detailList;

    public PurachBean() {
        super(Purach.class);
    }

    public Purach findByAcceptno(String value) {
        Query query = getEntityManager().createNamedQuery("Purach.findByAcceptno");
        query.setParameter("acceptno", value);
        try {
            Object o = query.getSingleResult();
            return (Purach) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Puracd> findByAcceptnoAndItnbr(String acceptno, String itnbr) {
        return puracdBean.findByAcceptnoAndItnbr(acceptno, itnbr);
    }

    public String[] findByPrno(String prno) {
        String[] acceptno = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT acceptno FROM purdtamap,puracd WHERE purdtamap.facno=puracd.facno AND purdtamap.prono=puracd.prono AND purdtamap.pono=puracd.pono AND purdtamap.trseq =puracd.ponotrseq ");
        sb.append(" AND purdtamap.srcno=?1 ORDER BY acceptno");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        query.setParameter(1, prno);
        List result = query.getResultList();
        if (result != null && !result.isEmpty()) {
            acceptno = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                acceptno[i] = result.get(i).toString();
            }
        }
        return acceptno;
    }

    public String[] findByPrnoAndItnbr(String prno, String itnbr) {
        String[] acceptno = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT acceptno FROM purdtamap,puracd WHERE purdtamap.facno=puracd.facno AND purdtamap.prono=puracd.prono AND purdtamap.pono=puracd.pono AND purdtamap.trseq =puracd.ponotrseq ");
        sb.append(" AND puracd.accsta='Y' AND purdtamap.srcno=?1 AND puracd.itnbr=?2  ORDER BY acceptno");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        query.setParameter(1, prno);
        query.setParameter(2, itnbr);
        List result = query.getResultList();
        if (result != null && !result.isEmpty()) {
            acceptno = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                acceptno[i] = result.get(i).toString();
            }
        }
        return acceptno;
    }

    public Boolean isRelationAcceptance(String prno, String pono, int potrseq) {
        Query query = getEntityManager().createNativeQuery("SELECT * FROM purdtamap WHERE srcno=?1 AND pono=?2 AND trseq=?3 ");
        query.setParameter(1, prno);
        query.setParameter(2, pono);
        query.setParameter(3, potrseq);
        List result = query.getResultList();
        if (result == null || result.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void setCompany(String company) {
        super.setCompany(company);
        puracdBean.setCompany(company);
    }

    @Override
    public void setDetail(Object value) {
        detailList = puracdBean.findByAcceptno(value.toString());
    }

    /**
     * @return the detailList
     */
    public List<Puracd> getDetailList() {
        return detailList;
    }

}
