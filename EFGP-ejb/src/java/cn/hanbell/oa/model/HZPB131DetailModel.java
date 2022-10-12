package cn.hanbell.oa.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HZPB131DetailModel implements Serializable {
    private String seq;
    private String itemno;
    private String itdsc;
    private String inventory;
    private String safetyStock;
    private String purNotEntered;
    private String batch;
    private String multiple;
    private String leadTime;
    private String first3MonthsAverage;
    private String annualAverage;
    private String purDraftRequirements;
    private String sysRequirementDate_txt;
    private String actualRequisitions;
    private String actDemandDate_txt;
    private String manNo;
    private String hdnManStatus;
    private String transferred;
    public HZPB131DetailModel() {
    }

    public String getSeq() {
        return this.seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getItemno() {
        return this.itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getItdsc() {
        return this.itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getInventory() {
        return this.inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getSafetyStock() {
        return this.safetyStock;
    }

    public void setSafetyStock(String safetyStock) {
        this.safetyStock = safetyStock;
    }

    public String getPurNotEntered() {
        return this.purNotEntered;
    }

    public void setPurNotEntered(String purNotEntered) {
        this.purNotEntered = purNotEntered;
    }

    public String getBatch() {
        return this.batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getMultiple() {
        return this.multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public String getLeadTime() {
        return this.leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }

    public String getFirst3MonthsAverage() {
        return this.first3MonthsAverage;
    }

    public void setFirst3MonthsAverage(String first3MonthsAverage) {
        this.first3MonthsAverage = first3MonthsAverage;
    }

    public String getAnnualAverage() {
        return this.annualAverage;
    }

    public void setAnnualAverage(String annualAverage) {
        this.annualAverage = annualAverage;
    }

    public String getPurDraftRequirements() {
        return this.purDraftRequirements;
    }

    public void setPurDraftRequirements(String purDraftRequirements) {
        this.purDraftRequirements = purDraftRequirements;
    }

    public String getSysRequirementDate_txt() {
        return this.sysRequirementDate_txt;
    }

    public void setSysRequirementDate_txt(String sysRequirementDate_txt) {
        this.sysRequirementDate_txt = sysRequirementDate_txt;
    }

    public String getActualRequisitions() {
        return this.actualRequisitions;
    }

    public void setActualRequisitions(String actualRequisitions) {
        this.actualRequisitions = actualRequisitions;
    }

    public String getActDemandDate_txt() {
        return this.actDemandDate_txt;
    }

    public void setActDemandDate_txt(String actDemandDate_txt) {
        this.actDemandDate_txt = actDemandDate_txt;
    }

    public String getHdnManStatus() {
        return this.hdnManStatus;
    }

    public void setHdnManStatus(String hdnManStatus) {
        this.hdnManStatus = hdnManStatus;
    }

    public String getManNo() {
        return this.manNo;
    }

    public void setManNo(String manNo) {
        this.manNo = manNo;
    }

    public String getTransferred() {
        return transferred;
    }

    public void setTransferred(String transferred) {
        this.transferred = transferred;
    }

    public int hashCode() {
        int hash = 0;
        return hash;
    }

    public boolean equals(Object object) {
        return object instanceof HZPB131DetailModel;
    }

    public String toString() {
        return "HZPB131DetailModel{seq=" + this.seq + ", itemno=" + this.itemno + ", itdsc=" + this.itdsc + ", inventory=" + this.inventory + ", safetyStock=" + this.safetyStock + ", purNotEntered=" + this.purNotEntered + ", batch=" + this.batch + ", multiple=" + this.multiple + ", leadTime=" + this.leadTime + ", first3MonthsAverage=" + this.first3MonthsAverage + ", annualAverage=" + this.annualAverage + ", purDraftRequirements=" + this.purDraftRequirements + ", sysRequirementDate_txt=" + this.sysRequirementDate_txt + ", actualRequisitions=" + this.actualRequisitions + ", actDemandDate_txt=" + this.actDemandDate_txt + '}';
    }
}
