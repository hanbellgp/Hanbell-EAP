/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@XmlRootElement
public class PricingGroup implements Serializable {

    @Id
    private String groupid;
    private String name;
    private String pricingtype;
    private boolean price09;
    private boolean price08;
    private boolean price07;
    private boolean price06;
    private boolean price05;
    private boolean price04;
    private boolean price03;
    private boolean price02;
    private boolean price01;

    public PricingGroup() {
    }

    public PricingGroup(String groupid, String name, boolean price09, boolean price08, boolean price07, boolean price06, boolean price05, boolean price04, boolean price03, boolean price02, boolean price01, String pricingtype) {
        this.groupid = groupid;
        this.name = name;
        this.price09 = price09;
        this.price08 = price08;
        this.price07 = price07;
        this.price06 = price06;
        this.price05 = price05;
        this.price04 = price04;
        this.price03 = price03;
        this.price02 = price02;
        this.price01 = price01;
        this.pricingtype = pricingtype;
    }

    /**
     * @return the groupid
     */
    public String getGroupid() {
        return groupid;
    }

    /**
     * @param groupid the groupid to set
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price09
     */
    public boolean isPrice09() {
        return price09;
    }

    /**
     * @param price09 the price09 to set
     */
    public void setPrice09(boolean price09) {
        this.price09 = price09;
    }

    /**
     * @return the price08
     */
    public boolean isPrice08() {
        return price08;
    }

    /**
     * @param price08 the price08 to set
     */
    public void setPrice08(boolean price08) {
        this.price08 = price08;
    }

    /**
     * @return the price07
     */
    public boolean isPrice07() {
        return price07;
    }

    /**
     * @param price07 the price07 to set
     */
    public void setPrice07(boolean price07) {
        this.price07 = price07;
    }

    /**
     * @return the price06
     */
    public boolean isPrice06() {
        return price06;
    }

    /**
     * @param price06 the price06 to set
     */
    public void setPrice06(boolean price06) {
        this.price06 = price06;
    }

    /**
     * @return the price05
     */
    public boolean isPrice05() {
        return price05;
    }

    /**
     * @param price05 the price05 to set
     */
    public void setPrice05(boolean price05) {
        this.price05 = price05;
    }

    /**
     * @return the price04
     */
    public boolean isPrice04() {
        return price04;
    }

    /**
     * @param price04 the price04 to set
     */
    public void setPrice04(boolean price04) {
        this.price04 = price04;
    }

    /**
     * @return the price03
     */
    public boolean isPrice03() {
        return price03;
    }

    /**
     * @param price03 the price03 to set
     */
    public void setPrice03(boolean price03) {
        this.price03 = price03;
    }

    /**
     * @return the price02
     */
    public boolean isPrice02() {
        return price02;
    }

    /**
     * @param price02 the price02 to set
     */
    public void setPrice02(boolean price02) {
        this.price02 = price02;
    }

    /**
     * @return the price01
     */
    public boolean isPrice01() {
        return price01;
    }

    /**
     * @param price01 the price01 to set
     */
    public void setPrice01(boolean price01) {
        this.price01 = price01;
    }

    /**
     * @return the pricingtype
     */
    public String getPricingtype() {
        return pricingtype;
    }

    /**
     * @param pricingtype the pricingtype to set
     */
    public void setPricingtype(String pricingtype) {
        this.pricingtype = pricingtype;
    }


}
