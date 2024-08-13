/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.comm;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 */
public class MailNotify {

    protected String SMTP_HOST = "172.16.10.106";
    protected int SMTP_PORT = 2525;
    protected HtmlEmail email;

    protected MailNotification notification;

    protected Properties propsConfiguration = new Properties();
    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    public MailNotify() {
        try {
            propsConfiguration.load(this.getClass().getClassLoader().getResourceAsStream("META-INF/eap-ejb.properties"));
            String host = propsConfiguration.getProperty("smtp.host");
            if (host != null && !"".equals(host)) {
                this.SMTP_HOST = host;
            }
            String port = propsConfiguration.getProperty("smtp.port");
            if (port != null && !"".equals(port)) {
                this.SMTP_PORT = Integer.parseInt(port);
            }
        } catch (IOException ex) {
            log4j.error(ex);
        }
    }

    protected void init() {
        if (email == null) {
            System.setProperty("mail.mime.splitlongparameters", "false");
            email = new HtmlEmail();
            email.setHostName(SMTP_HOST);
            email.setSmtpPort(SMTP_PORT);
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
