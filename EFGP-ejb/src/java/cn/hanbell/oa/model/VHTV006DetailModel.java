/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class VHTV006DetailModel implements Serializable {

    private String seq;
    private String trseq;
    private String itnbr;
    private String itnbrcus;
    private String itdsc;
    private String quaqy1;
    private String unpris;
    private String lastunpri;
    private String tramts;
    private String cdrdate;
    private String peratio;
    private String refmodel;
    private String refratio;
    private String diffitting;
    private String spdsc;

    public VHTV006DetailModel() {

        this.trseq = "";
        this.itnbr = "";
        this.itnbrcus = "";
        this.itdsc = "";
        this.quaqy1 = "";
        this.unpris = "";
        this.lastunpri = "";
        this.tramts = "";
        this.cdrdate = "";
        this.peratio = "";
        this.refmodel = "";
        this.refratio = "";
        this.diffitting = "";

    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VHTV006DetailModel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPAPM811DetailModel";
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItnbrcus() {
        return itnbrcus;
    }

    public void setItnbrcus(String itnbrcus) {
        this.itnbrcus = itnbrcus;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getQuaqy1() {
        return quaqy1;
    }

    public void setQuaqy1(String quaqy1) {
        this.quaqy1 = quaqy1;
    }

    public String getUnpris() {
        return unpris;
    }

    public void setUnpris(String unpris) {
        this.unpris = unpris;
    }

    public String getLastunpri() {
        return lastunpri;
    }

    public void setLastunpri(String lastunpri) {
        this.lastunpri = lastunpri;
    }

    public String getTramts() {
        return tramts;
    }

    public void setTramts(String tramts) {
        this.tramts = tramts;
    }

    public String getCdrdate() {
        return cdrdate;
    }

    public void setCdrdate(String cdrdate) {
        this.cdrdate = cdrdate;
    }

    public String getPeratio() {
        return peratio;
    }

    public void setPeratio(String peratio) {
        this.peratio = peratio;
    }

    public String getRefmodel() {
        return refmodel;
    }

    public void setRefmodel(String refmodel) {
        this.refmodel = refmodel;
    }

    public String getRefratio() {
        return refratio;
    }

    public void setRefratio(String refratio) {
        this.refratio = refratio;
    }

    public String getDiffitting() {
        return diffitting;
    }

    public void setDiffitting(String diffitting) {
        this.diffitting = diffitting;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

}
