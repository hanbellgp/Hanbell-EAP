/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrlot;
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
public class CdrlotBean extends SuperEJBForERP<Cdrlot> {

    public CdrlotBean() {
        super(Cdrlot.class);
    }

    public List<Cdrlot> findByFacnoAndShpno(String facno, String shpno) {
        Query query = this.getEntityManager().createNamedQuery("Cdrlot.findByFacnoAndShpno");
        query.setParameter("facno", facno);
        query.setParameter("shpno", shpno);
        return query.getResultList();
    }

}
