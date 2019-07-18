/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGC003Detail;
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
public class HKGC003DetailBean extends SuperEJBForEFGP<HKGC003Detail> {

    public HKGC003DetailBean() {
        super(HKGC003Detail.class);
    }

    public List<HKGC003Detail> findBySrcOID(String srcOID) {
        Query query = getEntityManager().createNamedQuery("HKGC003Detail.findBySrcOID");
        query.setParameter("srcOID", srcOID);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
