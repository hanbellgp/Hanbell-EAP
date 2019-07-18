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
public class ItemModel implements Serializable {

    @Id
    private String model;
    private String itemno;

    public ItemModel() {

    }

    public ItemModel(String model,String itemno) {
        this.model = model;
        this.itemno = itemno;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the itemno
     */
    public String getItemno() {
        return itemno;
    }

    /**
     * @param itemno the itemno to set
     */
    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

}
