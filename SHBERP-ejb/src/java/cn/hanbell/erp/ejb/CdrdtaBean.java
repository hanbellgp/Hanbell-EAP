/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrdta;
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
public class CdrdtaBean extends SuperEJBForERP<Cdrdta> {

    public CdrdtaBean() {
        super(Cdrdta.class);
    }

    public List<Cdrdta> findByShpno(String shpno) {
        Query query = getEntityManager().createNamedQuery("Cdrdta.findByShpno");
        query.setParameter("shpno", shpno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
