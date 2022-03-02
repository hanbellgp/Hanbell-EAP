/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import cn.hanbell.oa.ejb.WorkFlowBean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author C2082
 */
@Entity
@Table(name = "HK_CW007")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW007.findAll", query = "SELECT h FROM HKCW007 h"),
    @NamedQuery(name = "HKCW007.findByApplyType", query = "SELECT h FROM HKCW007 h WHERE h.applyType = :applyType"),
    @NamedQuery(name = "HKCW007.findByCapital", query = "SELECT h FROM HKCW007 h WHERE h.capital = :capital"),
    @NamedQuery(name = "HKCW007.findByFacno", query = "SELECT h FROM HKCW007 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW007.findByPSN", query = "SELECT h FROM HKCW007 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW007.findByWithdrawalTotal", query = "SELECT h FROM HKCW007 h WHERE h.withdrawalTotal = :withdrawalTotal"),
    @NamedQuery(name = "HKCW007.findByApplyUser", query = "SELECT h FROM HKCW007 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKCW007.findByApplyDept", query = "SELECT h FROM HKCW007 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKCW007.findByLoanPurpose", query = "SELECT h FROM HKCW007 h WHERE h.loanPurpose = :loanPurpose"),
    @NamedQuery(name = "HKCW007.findByFlowloan", query = "SELECT h FROM HKCW007 h WHERE h.flowloan = :flowloan"),
    @NamedQuery(name = "HKCW007.findByCreditBalance10", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance10 = :creditBalance10"),
    @NamedQuery(name = "HKCW007.findByCreditBalance2", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance2 = :creditBalance2"),
    @NamedQuery(name = "HKCW007.findByCreditBalance1", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance1 = :creditBalance1"),
    @NamedQuery(name = "HKCW007.findByWithdrawal10", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal10 = :withdrawal10"),
    @NamedQuery(name = "HKCW007.findByOID", query = "SELECT h FROM HKCW007 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW007.findByCreditBalance6", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance6 = :creditBalance6"),
    @NamedQuery(name = "HKCW007.findByCreditBalance5", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance5 = :creditBalance5"),
    @NamedQuery(name = "HKCW007.findByCreditBalance4", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance4 = :creditBalance4"),
    @NamedQuery(name = "HKCW007.findByCreditBalance3", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance3 = :creditBalance3"),
    @NamedQuery(name = "HKCW007.findByApplycompany", query = "SELECT h FROM HKCW007 h WHERE h.applycompany = :applycompany"),
    @NamedQuery(name = "HKCW007.findByCreditBalance9", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance9 = :creditBalance9"),
    @NamedQuery(name = "HKCW007.findByCreditBalance8", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance8 = :creditBalance8"),
    @NamedQuery(name = "HKCW007.findByCreditBalance7", query = "SELECT h FROM HKCW007 h WHERE h.creditBalance7 = :creditBalance7"),
    @NamedQuery(name = "HKCW007.findByDescription6", query = "SELECT h FROM HKCW007 h WHERE h.description6 = :description6"),
    @NamedQuery(name = "HKCW007.findByProject2", query = "SELECT h FROM HKCW007 h WHERE h.project2 = :project2"),
    @NamedQuery(name = "HKCW007.findByDescription7", query = "SELECT h FROM HKCW007 h WHERE h.description7 = :description7"),
    @NamedQuery(name = "HKCW007.findByDescription4", query = "SELECT h FROM HKCW007 h WHERE h.description4 = :description4"),
    @NamedQuery(name = "HKCW007.findByDescription5", query = "SELECT h FROM HKCW007 h WHERE h.description5 = :description5"),
    @NamedQuery(name = "HKCW007.findByDescription8", query = "SELECT h FROM HKCW007 h WHERE h.description8 = :description8"),
    @NamedQuery(name = "HKCW007.findByProjectname1", query = "SELECT h FROM HKCW007 h WHERE h.projectname1 = :projectname1"),
    @NamedQuery(name = "HKCW007.findByDescription9", query = "SELECT h FROM HKCW007 h WHERE h.description9 = :description9"),
    @NamedQuery(name = "HKCW007.findByProjectTotal", query = "SELECT h FROM HKCW007 h WHERE h.projectTotal = :projectTotal"),
    @NamedQuery(name = "HKCW007.findByBankName", query = "SELECT h FROM HKCW007 h WHERE h.bankName = :bankName"),
    @NamedQuery(name = "HKCW007.findByDescription2", query = "SELECT h FROM HKCW007 h WHERE h.description2 = :description2"),
    @NamedQuery(name = "HKCW007.findByDescription3", query = "SELECT h FROM HKCW007 h WHERE h.description3 = :description3"),
    @NamedQuery(name = "HKCW007.findByDescription1", query = "SELECT h FROM HKCW007 h WHERE h.description1 = :description1"),
    @NamedQuery(name = "HKCW007.findByWithdrawal6", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal6 = :withdrawal6"),
    @NamedQuery(name = "HKCW007.findByWithdrawal5", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal5 = :withdrawal5"),
    @NamedQuery(name = "HKCW007.findByTotal", query = "SELECT h FROM HKCW007 h WHERE h.total = :total"),
    @NamedQuery(name = "HKCW007.findByWithdrawal8", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal8 = :withdrawal8"),
    @NamedQuery(name = "HKCW007.findByWithdrawal7", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal7 = :withdrawal7"),
    @NamedQuery(name = "HKCW007.findByWithdrawal9", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal9 = :withdrawal9"),
    @NamedQuery(name = "HKCW007.findByFSN", query = "SELECT h FROM HKCW007 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW007.findByCurrency", query = "SELECT h FROM HKCW007 h WHERE h.currency = :currency"),
    @NamedQuery(name = "HKCW007.findByOther1", query = "SELECT h FROM HKCW007 h WHERE h.other1 = :other1"),
    @NamedQuery(name = "HKCW007.findByHdnmanager", query = "SELECT h FROM HKCW007 h WHERE h.hdnmanager = :hdnmanager"),
    @NamedQuery(name = "HKCW007.findByInterestRate", query = "SELECT h FROM HKCW007 h WHERE h.interestRate = :interestRate"),
    @NamedQuery(name = "HKCW007.findByTotalCredit", query = "SELECT h FROM HKCW007 h WHERE h.totalCredit = :totalCredit"),
    @NamedQuery(name = "HKCW007.findByDate2", query = "SELECT h FROM HKCW007 h WHERE h.date2 = :date2"),
    @NamedQuery(name = "HKCW007.findByDate1", query = "SELECT h FROM HKCW007 h WHERE h.date1 = :date1"),
    @NamedQuery(name = "HKCW007.findByWithdrawal2", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal2 = :withdrawal2"),
    @NamedQuery(name = "HKCW007.findByWithdrawal1", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal1 = :withdrawal1"),
    @NamedQuery(name = "HKCW007.findByWithdrawal4", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal4 = :withdrawal4"),
    @NamedQuery(name = "HKCW007.findByWithdrawal3", query = "SELECT h FROM HKCW007 h WHERE h.withdrawal3 = :withdrawal3"),
    @NamedQuery(name = "HKCW007.findByApplyDate", query = "SELECT h FROM HKCW007 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HKCW007.findByDescription10", query = "SELECT h FROM HKCW007 h WHERE h.description10 = :description10"),
    @NamedQuery(name = "HKCW007.findBySerialNumber", query = "SELECT h FROM HKCW007 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW007.findByCompanyno", query = "SELECT h FROM HKCW007 h WHERE h.companyno = :companyno")})
public class HKCW007 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "applyType")
    private String applyType;
    @Size(max = 255)
    @Column(name = "capital")
    private String capital;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "withdrawalTotal")
    private Double withdrawalTotal;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "loanPurpose")
    private String loanPurpose;
    @Size(max = 255)
    @Column(name = "flowloan")
    private String flowloan;
    @Column(name = "creditBalance10")
    private Double creditBalance10;
    @Column(name = "creditBalance2")
    private Double creditBalance2;
    @Column(name = "creditBalance1")
    private Double creditBalance1;
    @Column(name = "withdrawal10")
    private Double withdrawal10;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "creditBalance6")
    private Double creditBalance6;
    @Column(name = "creditBalance5")
    private Double creditBalance5;
    @Column(name = "creditBalance4")
    private Double creditBalance4;
    @Column(name = "creditBalance3")
    private Double creditBalance3;
    @Size(max = 255)
    @Column(name = "applycompany")
    private String applycompany;
    @Column(name = "creditBalance9")
    private Double creditBalance9;
    @Column(name = "creditBalance8")
    private Double creditBalance8;
    @Column(name = "creditBalance7")
    private Double creditBalance7;
    @Size(max = 255)
    @Column(name = "description6")
    private String description6;
    @Size(max = 255)
    @Column(name = "project2")
    private String project2;
    @Size(max = 255)
    @Column(name = "description7")
    private String description7;
    @Size(max = 255)
    @Column(name = "description4")
    private String description4;
    @Size(max = 255)
    @Column(name = "description5")
    private String description5;
    @Size(max = 255)
    @Column(name = "description8")
    private String description8;
    @Size(max = 255)
    @Column(name = "projectname1")
    private String projectname1;
    @Size(max = 255)
    @Column(name = "description9")
    private String description9;
    @Column(name = "projectTotal")
    private Double projectTotal;
    @Size(max = 255)
    @Column(name = "bankName")
    private String bankName;
    @Size(max = 255)
    @Column(name = "description2")
    private String description2;
    @Size(max = 255)
    @Column(name = "description3")
    private String description3;
    @Size(max = 255)
    @Column(name = "description1")
    private String description1;
    @Column(name = "withdrawal6")
    private Double withdrawal6;
    @Column(name = "withdrawal5")
    private Double withdrawal5;
    @Column(name = "total")
    private Double total;
    @Column(name = "withdrawal8")
    private Double withdrawal8;
    @Column(name = "withdrawal7")
    private Double withdrawal7;
    @Column(name = "withdrawal9")
    private Double withdrawal9;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "currency")
    private String currency;
    @Size(max = 255)
    @Column(name = "other1")
    private String other1;
    @Size(max = 255)
    @Column(name = "hdnmanager")
    private String hdnmanager;
    @Column(name = "interestRate")
    private Double interestRate;
    @Column(name = "totalCredit")
    private Double totalCredit;
    @Column(name = "date2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date2;
    @Column(name = "date1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date1;
    @Column(name = "withdrawal2")
    private Double withdrawal2;
    @Column(name = "withdrawal1")
    private Double withdrawal1;
    @Column(name = "withdrawal4")
    private Double withdrawal4;
    @Column(name = "withdrawal3")
    private Double withdrawal3;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "description10")
    private String description10;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "companyno")
    private String companyno;

   //申请人
    @JoinColumn(name = "applyUser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users user;

    //申请部门
    @JoinColumn(name = "applyDept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit dept;
    public HKCW007() {
    }

    public HKCW007(String oid) {
        this.oid = oid;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Double getWithdrawalTotal() {
        return withdrawalTotal;
    }

    public void setWithdrawalTotal(Double withdrawalTotal) {
        this.withdrawalTotal = withdrawalTotal;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public String getFlowloan() {
        return flowloan;
    }

    public void setFlowloan(String flowloan) {
        this.flowloan = flowloan;
    }

    public Double getCreditBalance10() {
        return creditBalance10;
    }

    public void setCreditBalance10(Double creditBalance10) {
        this.creditBalance10 = creditBalance10;
    }

    public Double getCreditBalance2() {
        return creditBalance2;
    }

    public void setCreditBalance2(Double creditBalance2) {
        this.creditBalance2 = creditBalance2;
    }

    public Double getCreditBalance1() {
        return creditBalance1;
    }

    public void setCreditBalance1(Double creditBalance1) {
        this.creditBalance1 = creditBalance1;
    }

    public Double getWithdrawal10() {
        return withdrawal10;
    }

    public void setWithdrawal10(Double withdrawal10) {
        this.withdrawal10 = withdrawal10;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getCreditBalance6() {
        return creditBalance6;
    }

    public void setCreditBalance6(Double creditBalance6) {
        this.creditBalance6 = creditBalance6;
    }

    public Double getCreditBalance5() {
        return creditBalance5;
    }

    public void setCreditBalance5(Double creditBalance5) {
        this.creditBalance5 = creditBalance5;
    }

    public Double getCreditBalance4() {
        return creditBalance4;
    }

    public void setCreditBalance4(Double creditBalance4) {
        this.creditBalance4 = creditBalance4;
    }

    public Double getCreditBalance3() {
        return creditBalance3;
    }

    public void setCreditBalance3(Double creditBalance3) {
        this.creditBalance3 = creditBalance3;
    }

    public String getApplycompany() {
        return applycompany;
    }

    public void setApplycompany(String applycompany) {
        this.applycompany = applycompany;
    }

    public Double getCreditBalance9() {
        return creditBalance9;
    }

    public void setCreditBalance9(Double creditBalance9) {
        this.creditBalance9 = creditBalance9;
    }

    public Double getCreditBalance8() {
        return creditBalance8;
    }

    public void setCreditBalance8(Double creditBalance8) {
        this.creditBalance8 = creditBalance8;
    }

    public Double getCreditBalance7() {
        return creditBalance7;
    }

    public void setCreditBalance7(Double creditBalance7) {
        this.creditBalance7 = creditBalance7;
    }

    public String getDescription6() {
        return description6;
    }

    public void setDescription6(String description6) {
        this.description6 = description6;
    }

    public String getProject2() {
        return project2;
    }

    public void setProject2(String project2) {
        this.project2 = project2;
    }

    public String getDescription7() {
        return description7;
    }

    public void setDescription7(String description7) {
        this.description7 = description7;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getDescription5() {
        return description5;
    }

    public void setDescription5(String description5) {
        this.description5 = description5;
    }

    public String getDescription8() {
        return description8;
    }

    public void setDescription8(String description8) {
        this.description8 = description8;
    }

    public String getProjectname1() {
        return projectname1;
    }

    public void setProjectname1(String projectname1) {
        this.projectname1 = projectname1;
    }

    public String getDescription9() {
        return description9;
    }

    public void setDescription9(String description9) {
        this.description9 = description9;
    }

    public Double getProjectTotal() {
        return projectTotal;
    }

    public void setProjectTotal(Double projectTotal) {
        this.projectTotal = projectTotal;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public Double getWithdrawal6() {
        return withdrawal6;
    }

    public void setWithdrawal6(Double withdrawal6) {
        this.withdrawal6 = withdrawal6;
    }

    public Double getWithdrawal5() {
        return withdrawal5;
    }

    public void setWithdrawal5(Double withdrawal5) {
        this.withdrawal5 = withdrawal5;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getWithdrawal8() {
        return withdrawal8;
    }

    public void setWithdrawal8(Double withdrawal8) {
        this.withdrawal8 = withdrawal8;
    }

    public Double getWithdrawal7() {
        return withdrawal7;
    }

    public void setWithdrawal7(Double withdrawal7) {
        this.withdrawal7 = withdrawal7;
    }

    public Double getWithdrawal9() {
        return withdrawal9;
    }

    public void setWithdrawal9(Double withdrawal9) {
        this.withdrawal9 = withdrawal9;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getHdnmanager() {
        return hdnmanager;
    }

    public void setHdnmanager(String hdnmanager) {
        this.hdnmanager = hdnmanager;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Double totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Double getWithdrawal2() {
        return withdrawal2;
    }

    public void setWithdrawal2(Double withdrawal2) {
        this.withdrawal2 = withdrawal2;
    }

    public Double getWithdrawal1() {
        return withdrawal1;
    }

    public void setWithdrawal1(Double withdrawal1) {
        this.withdrawal1 = withdrawal1;
    }

    public Double getWithdrawal4() {
        return withdrawal4;
    }

    public void setWithdrawal4(Double withdrawal4) {
        this.withdrawal4 = withdrawal4;
    }

    public Double getWithdrawal3() {
        return withdrawal3;
    }

    public void setWithdrawal3(Double withdrawal3) {
        this.withdrawal3 = withdrawal3;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getDescription10() {
        return description10;
    }

    public void setDescription10(String description10) {
        this.description10 = description10;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCompanyno() {
        return companyno;
    }

    public void setCompanyno(String companyno) {
        this.companyno = companyno;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public OrganizationUnit getDept() {
        return dept;
    }

    public void setDept(OrganizationUnit dept) {
        this.dept = dept;
    }

        
    public String getCompanyName() {
        WorkFlowBean WorkFlowBean = new WorkFlowBean();
        return WorkFlowBean.getCompanyName(this.facno);
    }
    
      public String getBibName() {
        switch (this.currency) {
            case "1":
                return "人民币";
            case "2":
                return "美元";
            case "3":
                return "日元";
            case "4":
                return "欧元";
            case "5":
                return "英镑";
            case "6":
                return "卢币";
            case "7":
                return "越南盾";
            case "8":
                return "台币";
            case "9":
                return "港币";
            case "10":
                return "其他";
        }
        return "";
    }
        
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW007)) {
            return false;
        }
        HKCW007 other = (HKCW007) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW007[ oid=" + oid + " ]";
    }
    
}
