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
public class ItemFault implements Serializable {

    @Id
    private String fault;
    private String name;

    public ItemFault() {

    }

    public ItemFault(String fault,String name) {
        this.fault = fault;
        this.name = name;
    }

    /**
     * @return the fault
     */
    public String getFault() {
        return fault;
    }

    /**
     * @param fault the fault to set
     */
    public void setFault(String fault) {
        this.fault = fault;
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

}
