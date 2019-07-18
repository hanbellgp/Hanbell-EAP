/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJH001serial;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class HKJH001serialBean extends SuperEJBForEFGP<HKJH001serial>{
    public HKJH001serialBean(){
        super(HKJH001serial.class);
    }

    public HKJH001serial findByKind(String kind3) {
        Query query = this.getEntityManager().createNamedQuery("HKJH001serial.findByKind");
        query.setParameter("kind", kind3);
        try {
            Object o = query.getSingleResult();
            return (HKJH001serial) o;
        } catch (Exception ex) {
            return null;
        }
    }
    
}
