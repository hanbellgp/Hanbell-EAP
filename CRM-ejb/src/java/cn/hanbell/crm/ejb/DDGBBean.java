/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DDGB;
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
public class DDGBBean extends SuperEJBForCRM<DDGB> {

    public DDGBBean() {
        super(DDGB.class);
    }

    public List<DDGB> findByDDGA(String gb001) {
        Query query = getEntityManager().createNamedQuery("DDGB.findByGb001");
        query.setParameter("gb001", gb001);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
