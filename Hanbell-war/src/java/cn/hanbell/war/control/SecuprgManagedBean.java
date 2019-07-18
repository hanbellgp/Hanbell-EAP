/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.erp.ejb.SecgprgBean;
import cn.hanbell.erp.ejb.SecuprgBean;
import cn.hanbell.erp.ejb.SecuserBean;
import cn.hanbell.erp.entity.Secgprg;
import cn.hanbell.erp.entity.Secuprg;
import cn.hanbell.erp.entity.Secuser;
import cn.hanbell.war.lazy.SecuserModel;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "secuprgManagedBean")
@SessionScoped
public class SecuprgManagedBean implements Serializable {

    @EJB
    private SecgprgBean secgprgBean;

    @EJB
    private SecuprgBean secuprgBean;

    @EJB
    private SecuserBean secuserBean;

    private SecuserModel model;
    private Secuser currentEntity;

    private List<Secuprg> detailList;
    private List<Secgprg> detailList2;

    private Secuprg currentDetail;
    private Secgprg currentDetail2;

    private String queryFacno;
    private String queryUserno;
    private String queryUsername;

    public SecuprgManagedBean() {
    }

    @PostConstruct
    public void construct() {
        init();
    }

    public void init() {
        this.model = new SecuserModel(secuserBean);
    }

    public void query() {
        if (model == null) {
            return;
        }
        this.secuserBean.setCompany(queryFacno);
        if (queryUserno != null && !"".equals(queryUserno)) {
            model.getFilterFields().put("userno", queryUserno);
        }
        if (this.queryUsername != null && !"".equals(this.queryUsername)) {
            model.getFilterFields().put("username", queryUsername);
        }
    }

    public void reset() {
        this.model.getFilterFields().clear();
    }

    public String view(String path) {
        if (currentEntity == null) {
            return "";
        } else {
            secuprgBean.setCompany(queryFacno);
            detailList = secuprgBean.findByUserno(currentEntity.getUserno());
            secgprgBean.setCompany(queryFacno);
            detailList2 = secgprgBean.findByGroupnoAndGtype(currentEntity.getUserno(), "U");
            return path;
        }
    }

    /**
     * @return the model
     */
    public SecuserModel getModel() {
        return model;
    }

    /**
     * @return the queryFacno
     */
    public String getQueryFacno() {
        return queryFacno;
    }

    /**
     * @param queryFacno the queryFacno to set
     */
    public void setQueryFacno(String queryFacno) {
        this.queryFacno = queryFacno;
    }

    /**
     * @return the queryUserno
     */
    public String getQueryUserno() {
        return queryUserno;
    }

    /**
     * @param queryUserno the queryUserno to set
     */
    public void setQueryUserno(String queryUserno) {
        this.queryUserno = queryUserno;
    }

    /**
     * @return the queryUsername
     */
    public String getQueryUsername() {
        return queryUsername;
    }

    /**
     * @param queryUsername the queryUsername to set
     */
    public void setQueryUsername(String queryUsername) {
        this.queryUsername = queryUsername;
    }

    /**
     * @return the currentEntity
     */
    public Secuser getCurrentEntity() {
        return currentEntity;
    }

    /**
     * @param currentEntity the currentEntity to set
     */
    public void setCurrentEntity(Secuser currentEntity) {
        this.currentEntity = currentEntity;
    }

    /**
     * @return the detailList
     */
    public List<Secuprg> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<Secuprg> detailList) {
        this.detailList = detailList;
    }

    /**
     * @return the detailList2
     */
    public List<Secgprg> getDetailList2() {
        return detailList2;
    }

    /**
     * @param detailList2 the detailList2 to set
     */
    public void setDetailList2(List<Secgprg> detailList2) {
        this.detailList2 = detailList2;
    }

    /**
     * @return the currentDetail
     */
    public Secuprg getCurrentDetail() {
        return currentDetail;
    }

    /**
     * @param currentDetail the currentDetail to set
     */
    public void setCurrentDetail(Secuprg currentDetail) {
        this.currentDetail = currentDetail;
    }

    /**
     * @return the currentDetail2
     */
    public Secgprg getCurrentDetail2() {
        return currentDetail2;
    }

    /**
     * @param currentDetail2 the currentDetail2 to set
     */
    public void setCurrentDetail2(Secgprg currentDetail2) {
        this.currentDetail2 = currentDetail2;
    }

}
