/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "PLM_ITNBR_MASTER_TEMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PLMItnbrMasterTemp.findAll", query = "SELECT p FROM PLMItnbrMasterTemp p"),
    @NamedQuery(name = "PLMItnbrMasterTemp.findByItemNumber", query = "SELECT p FROM PLMItnbrMasterTemp p WHERE p.itemNumber = :itemNumber"),
    @NamedQuery(name = "PLMItnbrMasterTemp.findById", query = "SELECT p FROM PLMItnbrMasterTemp p WHERE p.id = :id"),
    @NamedQuery(name = "PLMItnbrMasterTemp.findByProno", query = "SELECT p FROM PLMItnbrMasterTemp p WHERE p.prono = :prono"),
    @NamedQuery(name = "PLMItnbrMasterTemp.findNeedThrow", query = "SELECT p FROM PLMItnbrMasterTemp p WHERE p.prono<>'A' AND p.prono<>'B' AND (p.cTriggerYn <> 'Y' OR p.cTriggerYn is null)")})
public class PLMItnbrMasterTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 128)
    @Column(name = "item_number")
    private String itemNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "id")
    private String id;
    @Size(max = 20)
    @Column(name = "prono")
    private String prono;
    @Size(max = 30)
    @Column(name = "applicant")
    private String applicant;
    @Size(max = 20)
    @Column(name = "apply_dep")
    private String applyDep;
    @Column(name = "apply_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 1)
    @Column(name = "to_erp")
    private String toErp;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "type")
    private Character type;
    @Column(name = "trigger_yn")
    private Character triggerYn;
    @Size(max = 30)
    @Column(name = "apply_type")
    private String applyType;
    @Column(name = "c_trigger_yn")
    private Character cTriggerYn;

    public PLMItnbrMasterTemp() {
    }

    public PLMItnbrMasterTemp(String id) {
        this.id = id;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplyDep() {
        return applyDep;
    }

    public void setApplyDep(String applyDep) {
        this.applyDep = applyDep;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getToErp() {
        return toErp;
    }

    public void setToErp(String toErp) {
        this.toErp = toErp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public Character getTriggerYn() {
        return triggerYn;
    }

    public void setTriggerYn(Character triggerYn) {
        this.triggerYn = triggerYn;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public Character getCTriggerYn() {
        return cTriggerYn;
    }

    public void setCTriggerYn(Character cTriggerYn) {
        this.cTriggerYn = cTriggerYn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PLMItnbrMasterTemp)) {
            return false;
        }
        PLMItnbrMasterTemp other = (PLMItnbrMasterTemp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.plm.entity.PLMItnbrMasterTemp[ id=" + id + " ]";
    }

}
