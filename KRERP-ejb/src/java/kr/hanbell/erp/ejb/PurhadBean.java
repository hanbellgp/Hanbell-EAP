/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Purdta;
import kr.hanbell.erp.entity.Purhad;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class PurhadBean extends SuperEJBForERP<Purhad>{
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
