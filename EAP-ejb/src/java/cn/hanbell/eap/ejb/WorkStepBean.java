/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.WorkStep;
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
public class WorkStepBean extends SuperEJBForEAP<WorkStep> {

    public WorkStepBean() {
        super(WorkStep.class);
    }

    public WorkStep findByUID(String uid) {
        Query query = getEntityManager().createNamedQuery("WorkStep.findByUID");
        query.setParameter("uid", uid);
        try {
            Object o = query.getSingleResult();
            return (WorkStep) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<WorkStep> findByContextUID(String contextUID) {
        Query query = getEntityManager().createNamedQuery("WorkStep.findByContextUID");
        query.setParameter("contextUID", contextUID);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public WorkStep findByContextUIDAndSeq(String contextUID, Integer seq) {
        Query query = getEntityManager().createNamedQuery("WorkStep.findByContextUIDAndSeq");
        query.setParameter("contextUID", contextUID);
        query.setParameter("seq", seq);
        try {
            Object o = query.getSingleResult();
            return (WorkStep) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
