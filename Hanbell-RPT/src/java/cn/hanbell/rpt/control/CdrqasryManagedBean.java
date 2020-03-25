/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.erp.ejb.CdrqhadBean;
import cn.hanbell.oa.model.CdrqasryModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "cdrqasryManagedBean")
@javax.faces.bean.ViewScoped
public class CdrqasryManagedBean implements Serializable {

    @EJB
    private CdrqhadBean cdrqhadBean;
    private String facno;
    private String quono;
    private short trseq;
    private List<CdrqasryModel> list;

    public CdrqasryManagedBean() {

    }

    @PostConstruct
    public void construct() {
        reset();
    }

     public void init() {
         cdrqhadBean.setCompany(facno);
         list = cdrqhadBean.queryCdrqasryModelList(facno, quono, trseq);
     }

    public void query() {
        try {
            cdrqhadBean.setCompany(facno);
            list = cdrqhadBean.queryCdrqasryModelList(facno, quono, trseq);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.toString()));
        }

    }

    public void reset() {
        list = new ArrayList<>();
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public short getTrseq() {
        return trseq;
    }

    public void setTrseq(short trseq) {
        this.trseq = trseq;
    }

    public String getQuono() {
        return quono;
    }

    public void setQuono(String quono) {
        this.quono = quono;
    }

    public List<CdrqasryModel> getList() {
        return list;
    }

    public void setList(List<CdrqasryModel> list) {
        this.list = list;
    }

}
