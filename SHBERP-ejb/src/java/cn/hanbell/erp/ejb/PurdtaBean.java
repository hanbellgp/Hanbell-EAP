/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Purdta;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class PurdtaBean extends SuperEJBForERP<Purdta> {

    public PurdtaBean() {
        super(Purdta.class);
    }

    public List<Purdta> findByPono(String pono) {
        Query query = getEntityManager().createNamedQuery("Purdta.findByPono");
        query.setParameter("pono", pono);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
