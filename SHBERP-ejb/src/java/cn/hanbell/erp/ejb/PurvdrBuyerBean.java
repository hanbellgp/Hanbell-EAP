/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.PurvdrBuyer;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1368
 */
@Stateless
@LocalBean
public class PurvdrBuyerBean extends SuperEJBForERP<PurvdrBuyer> {

    public PurvdrBuyerBean() {
        super(PurvdrBuyer.class);
    }

    public List<PurvdrBuyer> findByVdrno(String vdrno) {
        Query query = getEntityManager().createNamedQuery("PurvdrBuyer.findByVdrno");
        query.setParameter("vdrno", vdrno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
