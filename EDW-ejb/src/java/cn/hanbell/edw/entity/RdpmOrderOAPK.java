/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Embeddable
public class RdpmOrderOAPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FormId")
    private String formId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FormTrseq")
    private int formTrseq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RequestItnbr")
    private String requestItnbr;

    public RdpmOrderOAPK() {
    }

    public RdpmOrderOAPK(String formId, int formTrseq, String requestItnbr) {
        this.formId = formId;
        this.formTrseq = formTrseq;
        this.requestItnbr = requestItnbr;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public int getFormTrseq() {
        return formTrseq;
    }

    public void setFormTrseq(int formTrseq) {
        this.formTrseq = formTrseq;
    }

    public String getRequestItnbr() {
        return requestItnbr;
    }

    public void setRequestItnbr(String requestItnbr) {
        this.requestItnbr = requestItnbr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (formId != null ? formId.hashCode() : 0);
        hash += (int) formTrseq;
        hash += (requestItnbr != null ? requestItnbr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RdpmOrderOAPK)) {
            return false;
        }
        RdpmOrderOAPK other = (RdpmOrderOAPK) object;
        if ((this.formId == null && other.formId != null) || (this.formId != null && !this.formId.equals(other.formId))) {
            return false;
        }
        if (this.formTrseq != other.formTrseq) {
            return false;
        }
        if ((this.requestItnbr == null && other.requestItnbr != null) || (this.requestItnbr != null && !this.requestItnbr.equals(other.requestItnbr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.RdpmOrderOAPK[ formId=" + formId + ", formTrseq=" + formTrseq + ", requestItnbr=" + requestItnbr + " ]";
    }
    
}
