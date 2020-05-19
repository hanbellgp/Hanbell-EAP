/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrqasry;
import cn.hanbell.oa.model.CdrqasryModel;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrqasryBean extends SuperEJBForERP<Cdrqasry> {

    @EJB
    private InvmasBean invmasBean;

    public CdrqasryBean() {
        super(Cdrqasry.class);
    }

    public List<Cdrqasry> findByQuonoAndTrseq(String facno, String quono, short trseq) {
        Query query = this.getEntityManager().createNamedQuery("Cdrqasry.findByQuonoAndTrseq");
        query.setParameter("facno", facno);
        query.setParameter("quono", quono);
        query.setParameter("trseq", trseq);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
