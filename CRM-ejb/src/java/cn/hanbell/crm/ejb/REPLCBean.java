/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPLC;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class REPLCBean extends SuperEJBForCRM<REPLC> {

    public REPLCBean() {
        super(REPLC.class);
    }

    public List<REPLC> findByLC001ANDLC002(String lc001, String lc002) {
        Query query = getEntityManager().createNamedQuery("REPLC.findByLC001ANDLC002");
        query.setParameter("lc001", lc001);
        query.setParameter("lc002", lc002);
        try {
            List<REPLC> replcs = query.getResultList();
            return replcs;
        } catch (Exception ex) {
            return null;
        }
    }

}
