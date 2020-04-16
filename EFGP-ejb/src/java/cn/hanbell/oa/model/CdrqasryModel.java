/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class CdrqasryModel {

    private String facno;
    private String quono;
    private short trseq;
    private short seq;
    private String itnbr;
    private String itdsc;
    private BigDecimal stdqty;
    private BigDecimal quoprice;

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public BigDecimal getStdqty() {
        return stdqty;
    }

    public void setStdqty(BigDecimal stdqty) {
        this.stdqty = stdqty;
    }

    public BigDecimal getQuoprice() {
        return quoprice;
    }

    public void setQuoprice(BigDecimal quoprice) {
        this.quoprice = quoprice;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getQuono() {
        return quono;
    }

    public void setQuono(String quono) {
        this.quono = quono;
    }

    public short getTrseq() {
        return trseq;
    }

    public void setTrseq(short trseq) {
        this.trseq = trseq;
    }

    public short getSeq() {
        return seq;
    }

    public void setSeq(short seq) {
        this.seq = seq;
    }

}
