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
public class ItemMaster implements Serializable {

    @Id
    private String itnbr;
    private String itdsc;

    public ItemMaster() {

    }

    public ItemMaster(String model,String itemno) {
        this.itnbr = model;
        this.itdsc = itemno;
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

}
