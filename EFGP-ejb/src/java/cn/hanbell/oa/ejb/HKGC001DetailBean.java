/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGC001Detail;
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
public class HKGC001DetailBean extends SuperEJBForEFGP<HKGC001Detail> {

    public HKGC001DetailBean() {
        super(HKGC001Detail.class);
    }

    public List<HKGC001Detail> findByFSNAndPurchase(String value, String flag) {
        Query query = getEntityManager().createNamedQuery("HKGC001Detail.findByFSNAndPurchase");
        query.setParameter("fsn", value);
        query.setParameter("purchase", flag);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
