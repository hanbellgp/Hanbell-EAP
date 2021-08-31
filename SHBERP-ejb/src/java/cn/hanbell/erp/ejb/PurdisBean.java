/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Purdis;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class PurdisBean extends SuperEJBForERP<Purdis> {

    public PurdisBean() {
        super(Purdis.class);
    }

    public List<Purdis> findByItnbrAndMainyn(String itnbr, String mainyn) {
        try {
            Query query = getEntityManager().createNamedQuery("Purdis.findByItnbrAndMainyn");
            query.setParameter("itnbr", itnbr);
            query.setParameter("mainyn", 'Y');
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
