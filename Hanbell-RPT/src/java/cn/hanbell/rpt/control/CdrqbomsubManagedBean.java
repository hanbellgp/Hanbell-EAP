/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.erp.ejb.CdrqbomsubBean;
import cn.hanbell.oa.model.CdrqbomsubDetailModel;
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
@ManagedBean(name = "cdrqbomsubManagedBean")
@javax.faces.bean.ViewScoped
public class CdrqbomsubManagedBean implements Serializable {

    @EJB
    private CdrqbomsubBean cdrqbomsubBean;
    private String facno;
    private String cdrno;
    private short trseq;
    private List<CdrqbomsubDetailModel> list;

    public CdrqbomsubManagedBean() {

    }

    @PostConstruct
    public void construct() {
        reset();
    }
    
     public void init() {
         cdrqbomsubBean.setCompany(facno);
         list = cdrqbomsubBean.querybomsubModelList(facno, cdrno, trseq);
     }

    public void query() {        
        try {
            cdrqbomsubBean.setCompany(facno);
            list = cdrqbomsubBean.querybomsubModelList(facno, cdrno, trseq);
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

    public String getCdrno() {
        return cdrno;
    }

    public void setCdrno(String cdrno) {
        this.cdrno = cdrno;
    }

    public short getTrseq() {
        return trseq;
    }

    public void setTrseq(short trseq) {
        this.trseq = trseq;
    }

    public List<CdrqbomsubDetailModel> getList() {
        return list;
    }

    public void setList(List<CdrqbomsubDetailModel> list) {
        this.list = list;
    }
}
