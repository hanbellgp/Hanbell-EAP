/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.app;

import java.io.Serializable;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class REPTAApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String repairKindname;
    private String repairno;
    private List<REPPWApplication> detailList;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof REPTAApplication)) {
            return false;
        }
        REPTAApplication other = (REPTAApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.app.REPTAApplication[ id=" + id + " ]";
    }

    public String getRepairKindname() {
        return repairKindname;
    }

    public void setRepairKindname(String repairKindname) {
        this.repairKindname = repairKindname;
    }

    public String getRepairno() {
        return repairno;
    }

    public void setRepairno(String repairno) {
        this.repairno = repairno;
    }

    public List<REPPWApplication> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<REPPWApplication> detailList) {
        this.detailList = detailList;
    }
    
}
