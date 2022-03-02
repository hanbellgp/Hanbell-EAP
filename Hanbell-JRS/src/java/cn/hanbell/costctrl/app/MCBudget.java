/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class MCBudget extends HmacSha1Signature {

    private String type;
    private String srcno;
    private String crmno;
    private String crmtype;
    private String loanNo;

    private List<MCBudgetDetail> budgetList;

    public List<MCBudgetDetail> getBudgetList() {
        return budgetList;
    }

    public void setBudgetList(List<MCBudgetDetail> budgetList) {
        this.budgetList = budgetList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public String getCrmno() {
        return crmno;
    }

    public void setCrmno(String crmno) {
        this.crmno = crmno;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getCrmtype() {
        return crmtype;
    }

    public void setCrmtype(String crmtype) {
        this.crmtype = crmtype;
    }

}
