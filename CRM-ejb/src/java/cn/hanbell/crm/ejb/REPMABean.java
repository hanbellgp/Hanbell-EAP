/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPMA;
import cn.hanbell.crm.entity.REPTA;
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
public class REPMABean extends SuperEJBForCRM<REPMA> {

    public REPMABean() {
        super(REPMA.class);
    }

    public List<REPMA> findByMB003(String ma003) {
        Query query = getEntityManager().createNamedQuery("REPMA.findByMa003");
        query.setParameter("ma003", ma003);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
}
