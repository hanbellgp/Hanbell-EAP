/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.ParticipantActivityInstance;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ParticipantActivityInstanceBean extends SuperEJBForEFGP<ParticipantActivityInstance> {

    public ParticipantActivityInstanceBean() {
        super(ParticipantActivityInstance.class);
    }

    public ParticipantActivityInstance findByContextOIDAndDefinitionId(String contextOID, String definitionId) {
        Query query = getEntityManager().createNamedQuery("ParticipantActivityInstance.findByContextOIDAndDefinitionId");
        query.setParameter("contextOID", contextOID);
        query.setParameter("definitionId", definitionId);
        try {
            Object o = query.getSingleResult();
            return (ParticipantActivityInstance) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
