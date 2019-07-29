/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Purdta;
import cn.hanbell.erp.entity.Purhad;
import java.util.Date;
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
public class PurhadBean extends SuperEJBForERP<Purhad> {

    @EJB
    private PurdtaBean purdtaBean;

    List<Purdta> detailList;

    public PurhadBean() {
        super(Purhad.class);
    }

    public List<Purhad> findNeedThrowByVdrno(String vdrno, Date podate) {
        Query query = getEntityManager().createNamedQuery("Purhad.findNeedThrowByVdrno").setFirstResult(0).setMaxResults(1);
        query.setParameter("vdrno", vdrno);
        query.setParameter("podate", podate);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void setCompany(String company) {
        super.setCompany(company);
        purdtaBean.setCompany(company);
    }

    @Override
    public void setDetail(Object value) {
        detailList = purdtaBean.findByPono(value.toString());
    }

    /**
     * @return the detailList
     */
    public List<Purdta> getDetailList() {
        return detailList;
    }

    public List<Purdta> getDetailList(Object value) {
        return purdtaBean.findByPono(value.toString());
    }

}
