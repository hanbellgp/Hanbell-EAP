/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.comm;

import java.io.File;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 */
public class MailNotify {

    protected String smtpHost = "172.16.10.18";
    protected int smptPort = 25;
    protected HtmlEmail email;

    protected MailNotification notification;

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    public MailNotify() {

    }

    protected void init() {
        if (email == null) {
            System.setProperty("mail.mime.splitlongparameters", "false");
            email = new HtmlEmail();
            email.setHostName(smtpHost);
            email.setSmtpPort(smptPort);
        }
    }

    protected void send() {
        try {
            init();
            email.setFrom(notification.mailFrom, "sys", "utf8");
            email.setSubject(notification.getMailSubject());
            email.setHtmlMsg(notification.getMailContent());
            email.setCharset("utf8");
            if (notification.getTo() != null && !notification.to.isEmpty()) {
                for (String t : notification.getTo()) {
                    email.addTo(t);
                }
            }
            if (notification.getCc() != null && !notification.cc.isEmpty()) {
                for (String c : notification.getCc()) {
                    email.addCc(c);
                }
            }
            if (notification.getBcc() != null && !notification.bcc.isEmpty()) {
                for (String b : notification.getBcc()) {
                    email.addBcc(b);
                }
            }
            if (notification.getAttachments() != null) {
                for (File f : notification.getAttachments()) {
                    email.attach(f);
                }
            }
            email.send();
        } catch (EmailException ex) {
            log4j.error(ex);
        }
    }

    public void sendMail(MailNotification notification) {
        this.notification = notification;
        send();
    }

}
