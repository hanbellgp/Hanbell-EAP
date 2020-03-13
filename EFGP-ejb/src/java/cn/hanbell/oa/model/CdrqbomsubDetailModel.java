/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class CdrqbomsubDetailModel {

    private String trseq;
    private String itdesc;
    private String itnbr; 
    private String itscode;
    private String itsdesc;
    private String itnbrs;
    private String itdsc;

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
    }

    public String getItdesc() {
        return itdesc;
    }

    public void setItdesc(String itdesc) {
        this.itdesc = itdesc;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItscode() {
        return itscode;
    }

    public void setItscode(String itscode) {
        this.itscode = itscode;
    }

    public String getItsdesc() {
        return itsdesc;
    }

    public void setItsdesc(String itsdesc) {
        this.itsdesc = itsdesc;
    }

    public String getItnbrs() {
        return itnbrs;
    }

    public void setItnbrs(String itnbrs) {
        this.itnbrs = itnbrs;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }
    
}
