/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Misrate;
import cn.hanbell.erp.entity.Nkpipurpcm;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class NkpipurpcmBean extends SuperEJBForERP<Nkpipurpcm> {

    public NkpipurpcmBean() {
        super(Nkpipurpcm.class);
    }

    public List<Nkpipurpcm> findByUsernaAndVdrna(String userna, String vdrna) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from N_KpiPurPcm where 1=1");
        if (userna != null && !"".equals(userna)) {
            sql.append(" and userna='").append(userna).append("'");
        }
        if (vdrna != null && !"".equals(vdrna)) {
            sql.append(" and vdrna='").append(vdrna).append("'");
        }
        try {
            Query query = this.getEntityManager().createNativeQuery(sql.toString());
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Nkpipurpcm findByVdrno(String vdrno) {
        Query q = this.getEntityManager().createNamedQuery("Nkpipurpcm.findByVdrno");
        q.setParameter("vdrno", vdrno);
        try {
            Nkpipurpcm result = (Nkpipurpcm) q.getSingleResult();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

}
