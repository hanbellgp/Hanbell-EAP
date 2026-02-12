/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Purvdrrel;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class PurvdrrelBean extends SuperEJBForERP<Purvdrrel> {

    public PurvdrrelBean() {
        super(Purvdrrel.class);
    }

    public List<Purvdrrel> findByVdrno(String vdrno) {
        Query query = getEntityManager().createNamedQuery("Purvdrrel.findByVdrno");
        query.setParameter("vdrno", vdrno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
}
