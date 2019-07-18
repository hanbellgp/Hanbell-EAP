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
 * @author C1587
 */
@XmlRootElement
public class SHBERPINV325DetailModel implements Serializable {

    private String seq;
    private String itnbr;
    private String itdsc;
    private String countnum;
    private String sumnum;
    private String dfromwareh;
    private String dfromwarehName;
    private String dtowareh;
    private String dtowarehName;
    private String dtowarehsum;
    private String bz;

    public SHBERPINV325DetailModel() {
        this.seq = "";
        this.itnbr = "";
        this.itdsc = "";
        this.countnum = "";
        this.sumnum = "";
        this.dfromwareh = "";
        this.dfromwarehName = "";
        this.dtowareh = "";
        this.dtowarehName = "";
        this.dtowarehsum = "";
        this.bz = "";
    }

    /**
     * @return the seq
     */
    public String getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * @return the itnbr
     */
    public String getItnbr() {
        return itnbr;
    }

    /**
     * @param itnbr the itnbr to set
     */
    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    /**
     * @return the itdsc
     */
    public String getItdsc() {
        return itdsc;
    }

    /**
     * @param itdsc the itdsc to set
     */
    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    /**
     * @return the countnum
     */
    public String getCountnum() {
        return countnum;
    }

    /**
     * @param countnum the countnum to set
     */
    public void setCountnum(String countnum) {
        this.countnum = countnum;
    }

    /**
     * @return the sumnum
     */
    public String getSumnum() {
        return sumnum;
    }

    /**
     * @param sumnum the sumnum to set
     */
    public void setSumnum(String sumnum) {
        this.sumnum = sumnum;
    }

    /**
     * @return the dfromwareh
     */
    public String getDfromwareh() {
        return dfromwareh;
    }

    /**
     * @param dfromwareh the dfromwareh to set
     */
    public void setDfromwareh(String dfromwareh) {
        this.dfromwareh = dfromwareh;
    }

    /**
     * @return the dtowareh
     */
    public String getDtowareh() {
        return dtowareh;
    }

    /**
     * @param dtowareh the dtowareh to set
     */
    public void setDtowareh(String dtowareh) {
        this.dtowareh = dtowareh;
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

    /**
     * @return the bz
     */
    public String getBz() {
        return bz;
    }

    /**
     * @param bz the bz to set
     */
    public void setBz(String bz) {
        this.bz = bz;
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

}
