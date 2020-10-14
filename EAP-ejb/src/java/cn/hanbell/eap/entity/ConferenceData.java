/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "conferencedata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConferenceData.findAll", query = "SELECT c FROM ConferenceData c"),
    @NamedQuery(name = "ConferenceData.findByConfCode", query = "SELECT c FROM ConferenceData c WHERE c.confCode = :confCode"),
    @NamedQuery(name = "ConferenceData.findByConfName", query = "SELECT c FROM ConferenceData c WHERE c.confName = :confName"),
    @NamedQuery(name = "ConferenceData.findByConfCodeOrName", query = "SELECT c FROM ConferenceData c WHERE  c.confCode = :confCode OR "
            + "c.confName = :confName ORDER BY c.confName ")})
public class ConferenceData implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "confCode")
    private String confCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "confName")
    private String confName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "palce")
    private String palce;

    public ConferenceData() {
    }

    public ConferenceData(String confCode, String confName, String palce) {
        this.confCode = confCode;
        this.confName = confName;
        this.palce = palce;
    }

    public String getConfCode() {
        return confCode;
    }

    public void setConfCode(String confCode) {
        this.confCode = confCode;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getPalce() {
        return palce;
    }

    public void setPalce(String palce) {
        this.palce = palce;
    }
    
}
