/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.EmailRecipient;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1879
 */
@Stateless
@LocalBean
public class EmailRecipientBean extends SuperEJBForEAP<EmailRecipient> {

    public EmailRecipientBean() {
        super(EmailRecipient.class);
    }

    public List<EmailRecipient> findEmailnameByCodeAndEmailtype(String code, String emailtype) {
        Query query = getEntityManager().createNamedQuery("EmailRecipient.findEmailnameByCodeAndEmailtype");
        query.setParameter("code", code);
        query.setParameter("emailtype", emailtype);
        try {
            return query.getResultList();
        } catch (Exception ex) {
        }
        return null;
    }

}
