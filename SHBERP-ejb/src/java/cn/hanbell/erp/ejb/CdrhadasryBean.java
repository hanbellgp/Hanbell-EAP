/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrhadasry;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class CdrhadasryBean extends SuperEJBForERP<Cdrhadasry>{
    
    public CdrhadasryBean() {
        super(Cdrhadasry.class);
    }
    
    /**
     *
     * @param value
     * @return
     */
    @Override
    public Cdrhadasry findById(Object value) {
        Query query = getEntityManager().createNamedQuery("Cdrhadasry.findByTrno");
        query.setParameter("trno", value);
        try {
            Object o = query.getSingleResult();
            return (Cdrhadasry) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
