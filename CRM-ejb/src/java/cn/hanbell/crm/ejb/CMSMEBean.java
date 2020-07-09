/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CMSME;
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
public class CMSMEBean extends SuperEJBForCRM<CMSME> {

    public CMSMEBean() {
        super(CMSME.class);
    }

    @Override
    public CMSME findById(Object value) {
        Query query = getEntityManager().createNamedQuery("CMSME.findByMe001");
        query.setParameter("me001", value);
        try {
            Object o = query.getSingleResult();
            return (CMSME) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Object[]> findByLikeId(String M2001) {
        StringBuffer s2 = new StringBuffer("SELECT  TOP 50 * FROM ( Select ME001,ME002 from CMSME CMSME where ME001 like '%000%' ");
        try {

            if (M2001 != null && !"".equals(M2001)) {
                s2.append("and  ME002 like '%").append(M2001).append("%'");
            }
            s2.append(") AS tData  order by ME001");
            Query query = getEntityManager().createNativeQuery(s2.toString());
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }
}
