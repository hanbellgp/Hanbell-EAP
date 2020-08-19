/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrdmas;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrdmasBean extends SuperEJBForERP<Cdrdmas> {

    public CdrdmasBean() {
        super(Cdrdmas.class);
    }
    
    public Cdrdmas findByFacnoAndCdrnoAndItnbrAndTrseq(String facno,String cdrno,String itnbr,int trseq){
        Query query = getEntityManager().createNamedQuery("Cdrdmas.findByFacnoAndCdrnoAndItnbrAndTrseq");
        query.setParameter("facno", facno);
        query.setParameter("cdrno", cdrno);
        query.setParameter("itnbr", itnbr);
        query.setParameter("trseq", trseq);
        try {
            Object o = query.getSingleResult();
            return (Cdrdmas) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
