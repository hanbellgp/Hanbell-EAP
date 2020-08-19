/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrbdta;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrbdtaBean extends SuperEJBForERP<Cdrbdta> {

    public CdrbdtaBean() {
        super(Cdrbdta.class);
    }

    public Cdrbdta findByFacnoAndBaknoAndItnbrAndTrseq(String facno,String bakno, String itnbr,int trseq) {
        Query query = getEntityManager().createNamedQuery("Cdrbdta.findByFacnoAndBaknoAndItnbrAndTrseq");
        query.setParameter("facno", facno);
        query.setParameter("bakno", bakno);
        query.setParameter("itnbr", itnbr);
        query.setParameter("trseq", trseq);
        try {
            Object o = query.getSingleResult();
            return (Cdrbdta) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
