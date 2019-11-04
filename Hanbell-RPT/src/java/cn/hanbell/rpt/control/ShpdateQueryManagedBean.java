/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.erp.ejb.CdrhadBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author C1879
 */
@ManagedBean(name = "shpdateQueryManagedBean")
@ViewScoped
public class ShpdateQueryManagedBean implements Serializable {

    @EJB
    private CdrhadBean cdrhadBean;

    private String itnbr;
    private String facno;
    private List<String[]> list;

    public ShpdateQueryManagedBean() {

    }

    @PostConstruct
    public void construct() {
        reset();
    }

    public void query() {
        list.clear();
        String[] itnbrs = getItnbr().split(",");
        if ("".equals(getItnbr().trim())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "查询条件不能为空！"));
        } else {
            try {
                list = cdrhadBean.queryShpdateList(facno, itnbrs);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.toString()));
            }
        }

    }

    public void reset() {
        facno = "C";
        setItnbr("");
        list = new ArrayList<>();
    }

    /**
     * @return the facno
     */
    public String getFacno() {
        return facno;
    }

    /**
     * @param facno the facno to set
     */
    public void setFacno(String facno) {
        this.facno = facno;
    }

    /**
     * @return the list
     */
    public List<String[]> getList() {
        return list;
    }

    /**
     * @return the itnbr
     */
    public String getItnbr() {
        return itnbr;
    }

    /**
     * @param itnbr the itnbr to set
     */
    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

}
