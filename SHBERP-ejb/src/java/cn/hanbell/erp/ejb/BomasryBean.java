/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Bomasry;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class BomasryBean extends SuperEJBForERP<Bomasry> {

    public BomasryBean() {
        super(Bomasry.class);
    }

    public List<Bomasry> findByItnbrfAndCmccode(String itnbrf, String cmccode) {
        Query query = this.getEntityManager().createNamedQuery("Bomasry.findByItnbrfAndCmccode");
        query.setParameter("itnbrf", itnbrf);
        query.setParameter("cmccode", cmccode);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

}
