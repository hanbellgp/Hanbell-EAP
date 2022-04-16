/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import cn.hanbell.eap.ejb.CompanyBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class RequestBody extends HmacSha1Signature {

    private CompanyBean companyBean = lookupCompanyBeanBean();

    private String facno;
    private String deptId;
    private String deptName;
    private String centerId;
    private int page_index;
    private int page_size;
    private String flag;
    private String userId;
    private String budgetAcc;
    private String accName;

    public RequestBody() {

    }

    public boolean checkRequestParams() {
        try {
            if (facno == null) {
                return false;
            }
            if (null == companyBean.findByCompany(facno)) {
                return false;
            }
            if (page_size < 1 || page_index < 1) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public int getPage_index() {
        return page_index;
    }

    public void setPage_index(int page_index) {
        this.page_index = page_index;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private CompanyBean lookupCompanyBeanBean() {
        try {
            Context c = new InitialContext();
            return (CompanyBean) c.lookup("java:global/Hanbell-EAP/EAP-ejb/CompanyBean!cn.hanbell.eap.ejb.CompanyBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public CompanyBean getCompanyBean() {
        return companyBean;
    }

    public void setCompanyBean(CompanyBean companyBean) {
        this.companyBean = companyBean;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBudgetAcc() {
        return budgetAcc;
    }

    public void setBudgetAcc(String budgetAcc) {
        this.budgetAcc = budgetAcc;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

}
