package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HZPB131Model implements Serializable {
    private String facno;
    private Date applyDate;
    private String applyUser;
    private String applyDept;
    private String sourceNumber;
    private String productionPlace;

    public HZPB131Model() {
    }

    public String getFacno() {
        return this.facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Date getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyUser() {
        return this.applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return this.applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getSourceNumber() {
        return this.sourceNumber;
    }

    public void setSourceNumber(String sourceNumber) {
        this.sourceNumber = sourceNumber;
    }

    public String getProductionPlace() {
        return this.productionPlace;
    }

    public void setProductionPlace(String productionPlace) {
        this.productionPlace = productionPlace;
    }

    public boolean equals(Object object) {
        return object instanceof HZPB131Model;
    }

    public int hashCode() {
        int hash = 0;
        return hash;
    }

    public String toString() {
        return "HZPB131Model{facno=" + this.facno + ", applyDate=" + this.applyDate + ", applyUser=" + this.applyUser + ", applyDept=" + this.applyDept + ", sourceNumber=" + this.sourceNumber + '}';
    }
}
