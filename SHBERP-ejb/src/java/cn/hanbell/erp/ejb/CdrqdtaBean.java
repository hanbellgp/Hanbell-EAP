/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrqdta;
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
public class CdrqdtaBean extends SuperEJBForERP<Cdrqdta>{

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
