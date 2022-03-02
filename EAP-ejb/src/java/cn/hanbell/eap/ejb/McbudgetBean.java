/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Mcbudget;
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
public class McbudgetBean extends SuperEJBForEAP<Mcbudget> {

    public McbudgetBean() {
        super(Mcbudget.class);
    }

    public List<Mcbudget> findBySrcno(String srcno) {
        Query query = getEntityManager().createNamedQuery("Mcbudget.findBySrcno");
        query.setParameter("srcno", srcno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
