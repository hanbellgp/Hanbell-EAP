/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.comm;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 */
public abstract class MailNotification {

    protected MailNotify mail;

    protected String mailFrom = "noreply@hanbell.com.cn";
    private String mailContent;
    private String mailSubject;

    protected String company;

    protected List<String> to;
    protected List<String> cc;
    protected List<String> bcc;
    protected List<File> attachments;

    protected String css = "<style type='text/css'>body{font-size:14px;}div.content{margin:auto;text-align:center;}div.tbl{margin-bottom:20px;}table{margin:auto;border-spacing:0px;border:1px solid #A2C0DA;}th,td{padding:5px;border-collapse:collapse;text-align:left;}th{background:#B0D0FC;border:1px solid #000000;text-align:center;font-weight:bold;}td{background:#D3E5FD;border:1px solid #000000;text-align:right;}.title{font-size:14px;font-weight:bold;}.foot{font-size:14px;color:Red;}.divFoot{text-align:right;height:20px;width:100%;}div.tableTitle{float:left;font-size:14px;font-weight:bold;text-align:left;}</style>";

    protected Calendar c;

    protected final Logger log4j = LogManager.getLogger();

    public MailNotification() {
        this.c = Calendar.getInstance();
        this.to = new ArrayList();
        this.cc = new ArrayList();
        this.bcc = new ArrayList();
        this.attachments = new ArrayList();
    }

    public void clearReceivers() {
        this.to.clear();
        this.cc.clear();
        this.bcc.clear();
    }

    public void init(String subject, String content) {
        this.setMailSubject(subject);
        this.setMailContent(content);
    }

    public void addAttachments(File f) {
        this.attachments.add(f);
    }

    public void addTo(String mailAddress) {
        this.to.add(mailAddress);
    }

    public void addCc(String mailAddress) {
        this.cc.add(mailAddress);
    }

    public void addBcc(String mailAddress) {
        this.bcc.add(mailAddress);
    }

    public void notify(MailNotify mail) {
        this.mail = mail;
        this.mail.sendMail(this);
    }

    /**
     * @return the to
     */
    public List<String> getTo() {
        return to;
    }

    /**
     * @return the cc
     */
    public List<String> getCc() {
        return cc;
    }

    /**
     * @return the bcc
     */
    public List<String> getBcc() {
        return bcc;
    }

    /**
     * @return the attachments
     */
    public List<File> getAttachments() {
        return attachments;
    }

    /**
     * @return the mailContent
     */
    public String getMailContent() {
        return mailContent;
    }

    /**
     * @param mailContent the mailContent to set
     */
    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    /**
     * @return the mailSubject
     */
    public String getMailSubject() {
        return mailSubject;
    }

    /**
     * @param mailSubject the mailSubject to set
     */
    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

}
