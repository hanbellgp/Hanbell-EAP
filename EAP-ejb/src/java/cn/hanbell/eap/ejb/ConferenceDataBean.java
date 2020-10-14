/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.ConferenceData;
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
public class ConferenceDataBean extends SuperEJBForEAP<ConferenceData> {

    public ConferenceDataBean() {
        super(ConferenceData.class);
    }

    public List<ConferenceData> findByConferenceCodeOrName(String q) {
        Query query = getEntityManager().createNamedQuery("ConferenceData.findByConferenceCodeOrName");
        query.setParameter("conferenceCode", q);
        query.setParameter("conferenceName", q);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
