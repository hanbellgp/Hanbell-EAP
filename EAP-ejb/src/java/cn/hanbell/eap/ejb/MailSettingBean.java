/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */

package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.MailRecipient;
import cn.hanbell.eap.entity.MailSetting;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class MailSettingBean extends SuperEJBForEAP<MailSetting> {

    @EJB
    private MailRecipientBean mailRecipientBean;

    public MailSettingBean() {
        super(MailSetting.class);
    }

    public MailSetting findByMailClazz(String mailClazz) {
        Query query = getEntityManager().createNamedQuery("MailSetting.findByMailClazz");
        query.setParameter("mailClazz", mailClazz);
        try {
            Object o = query.getSingleResult();
            return (MailSetting)o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<String> findRecipientByMailClazzAndKind(String mailClazz, String kind) {
        MailSetting ms = findByMailClazz(mailClazz);
        if (ms != null) {
            switch (kind) {
                case "to":
                    return findRecipientTo(ms.getId());
                case "cc":
                    return findRecipientCc(ms.getId());
                case "bcc":
                    return findRecipientBcc(ms.getId());
            }
        }
        return null;
    }

    public List<String> findRecipientTo(String mailClazz) {
        MailSetting ms = findByMailClazz(mailClazz);
        if (ms != null) {
            return findRecipientTo(ms.getId());
        }
        return null;
    }

    public List<String> findRecipientTo(int pid) {
        List<String> to = new ArrayList<>();
        List<MailRecipient> detail = mailRecipientBean.findByPIdAndKind(pid, "to");
        if (detail != null && !detail.isEmpty()) {
            detail.forEach((r) -> {
                to.add(r.getMailadd());
            });
        }
        return to;
    }

    public List<String> findRecipientCc(String mailClazz) {
        MailSetting ms = findByMailClazz(mailClazz);
        if (ms != null) {
            return findRecipientCc(ms.getId());
        }
        return null;
    }

    public List<String> findRecipientCc(int pid) {
        List<String> cc = new ArrayList<>();
        List<MailRecipient> detail = mailRecipientBean.findByPIdAndKind(pid, "cc");
        if (detail != null && !detail.isEmpty()) {
            detail.forEach((r) -> {
                cc.add(r.getMailadd());
            });
        }
        return cc;
    }

    public List<String> findRecipientBcc(String mailClazz) {
        MailSetting ms = findByMailClazz(mailClazz);
        if (ms != null) {
            return findRecipientBcc(ms.getId());
        }
        return null;
    }

    public List<String> findRecipientBcc(int pid) {
        List<String> bcc = new ArrayList<>();
        List<MailRecipient> detail = mailRecipientBean.findByPIdAndKind(pid, "bcc");
        if (detail != null && !detail.isEmpty()) {
            detail.forEach((r) -> {
                bcc.add(r.getMailadd());
            });
        }
        return bcc;
    }

}
