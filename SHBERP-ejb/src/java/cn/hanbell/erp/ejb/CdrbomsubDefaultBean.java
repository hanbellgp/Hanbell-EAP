/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.CdrbomsubDefault;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrbomsubDefaultBean extends SuperEJBForERP<CdrbomsubDefault> {

    public CdrbomsubDefaultBean() {
        super(CdrbomsubDefault.class);
    }

    public CdrbomsubDefault findByPK(String facno, String itnbrf, String itemtyp) {
        Query query = this.getEntityManager().createNamedQuery("CdrbomsubDefault.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("itnbrf", itnbrf);
        query.setParameter("itemtyp", itemtyp);
        try {
            return (CdrbomsubDefault) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

}
