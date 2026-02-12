/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Cdrqdta;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class CdrqdtaBean extends SuperEJBForERP<Cdrqdta> {

    public CdrqdtaBean() {
        super(Cdrqdta.class);
    }

    public List<Cdrqdta> findNeedThrowDetail(String facno, String quono) {
        Query query = this.getEntityManager().createNamedQuery("Cdrqdta.findByNeedThrowDetail");
        query.setParameter("facno", facno);
        query.setParameter("quono", quono);
        return query.getResultList();
    }

}
