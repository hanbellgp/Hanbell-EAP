/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1587
 */
@XmlRootElement
public class SHBERPINV325Model implements Serializable {

    private Date createdate;
    private String resno;
    private String towareh;
    private String prono;
    private String bz;
    private String dtowareh;
    private String dtowarehsum;
    private String itnbr;
    private String itdsc;
    private String trtype;
    private String dfromwareh;
    private String fromwareh;
    private String facno;
    private String applyUser;
    private String coorUser;
    private String applyDept;
    private String coorDept;
    private String relformid;
    private String fromwarehName;//来源仓说明
    private String towarehName;//目的仓说明
    private String resna;//原因说明
    private String dfromwarehName;//明细里的来源仓说明
    private String dtowarehName;//明细里的目的仓说明

    public SHBERPINV325Model() {
        this.prono = "1";
        this.resno = "0JQ01";
        this.resna = "移仓调拨";
        this.towareh = "ZP01";
        this.fromwarehName = "装配一倒扣仓";
        this.trtype = "IAC";
        this.fromwareh = "ASRS01";
        this.fromwarehName = "自动原物料仓";
        this.facno = "C";
        this.applyUser = "C1587";
        this.applyDept = "13000";
    }

    public String getResno() {
        return resno;
    }

    public void setResno(String resno) {
        this.resno = resno;
    }

    public String getTowareh() {
        return towareh;
    }

    public void setTowareh(String towareh) {
        this.towareh = towareh;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getDtowareh() {
        return dtowareh;
    }

    public void setDtowareh(String dtowareh) {
        this.dtowareh = dtowareh;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getDfromwareh() {
        return dfromwareh;
    }

    public void setDfromwareh(String dfromwareh) {
        this.dfromwareh = dfromwareh;
    }

    public String getFromwareh() {
        return fromwareh;
    }

    public void setFromwareh(String fromwareh) {
        this.fromwareh = fromwareh;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getFacno() {
        return facno;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getCoorUser() {
        return coorUser;
    }

    public void setCoorUser(String coorUser) {
        this.coorUser = coorUser;
    }

    public String getCoorDept() {
        return coorDept;
    }

    public void setCoorDept(String coorDept) {
        this.coorDept = coorDept;
    }

    public String getFromwarehName() {
        return fromwarehName;
    }

    public void setFromwarehName(String fromwarehName) {
        this.fromwarehName = fromwarehName;
    }

    public String getTowarehName() {
        return towarehName;
    }

    public void setTowarehName(String towarehName) {
        this.towarehName = towarehName;
    }

    public String getResna() {
        return resna;
    }

    public void setResna(String resna) {
        this.resna = resna;
    }

    public String getDfromwarehName() {
        return dfromwarehName;
    }

    public void setDfromwarehName(String dfromwarehName) {
        this.dfromwarehName = dfromwarehName;
    }

    public String getDtowarehName() {
        return dtowarehName;
    }

    public void setDtowarehName(String dtowarehName) {
        this.dtowarehName = dtowarehName;
    }

    /**
     * @param facno the facno to set
     */
    public void setFacno(String facno) {
        this.facno = facno;
    }

    /**
     * @return the createdate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate the createdate to set
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return the relformid
     */
    public String getRelformid() {
        return relformid;
    }

    /**
     * @param relformid the relformid to set
     */
    public void setRelformid(String relformid) {
        this.relformid = relformid;
    }

    /**
     * @return the dtowarehsum
     */
    public String getDtowarehsum() {
        return dtowarehsum;
    }

    /**
     * @param dtowarehsum the dtowarehsum to set
     */
    public void setDtowarehsum(String dtowarehsum) {
        this.dtowarehsum = dtowarehsum;
    }

}
