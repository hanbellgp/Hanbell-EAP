/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crmsys.ejb;

import cn.hanbell.crmsys.comm.SuperEJBForCRMSYS;
import cn.hanbell.crmsys.entity.DSCMA;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class DSCMABean extends SuperEJBForCRMSYS<DSCMA> {

    public DSCMABean() {
        super(DSCMA.class);
    }

    @Override
    public DSCMA findById(Object value) {
        Query query = getEntityManager().createNamedQuery("DSCMA.findByMa001");
        query.setParameter("ma001", value);
        try {
            Object o = query.getSingleResult();
            return (DSCMA) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
