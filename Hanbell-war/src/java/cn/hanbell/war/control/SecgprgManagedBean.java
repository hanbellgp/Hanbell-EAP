/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.erp.ejb.SecgprgBean;
import cn.hanbell.erp.ejb.SecgroupBean;
import cn.hanbell.erp.entity.Secgprg;
import cn.hanbell.erp.entity.Secgroup;
import cn.hanbell.war.lazy.SecgroupModel;
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
@ManagedBean(name = "secgprgManagedBean")
@SessionScoped
public class SecgprgManagedBean implements Serializable {

    @EJB
    private SecgprgBean secgprgBean;

    @EJB
    private SecgroupBean secgroupBean;

    private SecgroupModel model;
    private Secgroup currentEntity;

    private List<Secgprg> detailList;

    private Secgprg currentDetail;

    private String queryFacno;
    private String queryGroupno;
    private String queryGroupname;
    private String querySysno;

    public SecgprgManagedBean() {
    }

    @PostConstruct
    public void construct() {
        init();
    }

    public void init() {
        this.model = new SecgroupModel(secgroupBean);
    }

    public void query() {
        if (model != null) {
            model.getFilterFields().clear();
            this.secgroupBean.setCompany(queryFacno);
            if (queryGroupno != null && !"".equals(queryGroupno)) {
                model.getFilterFields().put("secgroupPK.groupno", queryGroupno);
            }
            if (this.queryGroupname != null && !"".equals(this.queryGroupname)) {
                model.getFilterFields().put("groupname", queryGroupname);
            }
        }
    }

    public void reset() {
        this.model.getFilterFields().clear();
    }

    public String view(String path) {
        if (currentEntity == null) {
            return "";
        } else {
            secgprgBean.setCompany(queryFacno);
            if (querySysno == null || "".equals(querySysno)) {
                detailList = secgprgBean.findByGroupnoAndGtype(currentEntity.getSecgroupPK().getGroupno(), "G");
            } else {
                detailList = secgprgBean.findByGroupnoGtypeAndSysno(currentEntity.getSecgroupPK().getGroupno(), "G", querySysno);
            }
            return path;
        }
    }

    /**
     * @return the model
     */
    public SecgroupModel getModel() {
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
     * @return the queryGroupno
     */
    public String getQueryGroupno() {
        return queryGroupno;
    }

    /**
     * @param queryGroupno the queryGroupno to set
     */
    public void setQueryGroupno(String queryGroupno) {
        this.queryGroupno = queryGroupno;
    }

    /**
     * @return the queryGroupname
     */
    public String getQueryGroupname() {
        return queryGroupname;
    }

    /**
     * @param queryGroupname the queryGroupname to set
     */
    public void setQueryGroupname(String queryGroupname) {
        this.queryGroupname = queryGroupname;
    }

    /**
     * @return the querySysno
     */
    public String getQuerySysno() {
        return querySysno;
    }

    /**
     * @param querySysno the querySysno to set
     */
    public void setQuerySysno(String querySysno) {
        this.querySysno = querySysno;
    }

    /**
     * @return the currentEntity
     */
    public Secgroup getCurrentEntity() {
        return currentEntity;
    }

    /**
     * @param currentEntity the currentEntity to set
     */
    public void setCurrentEntity(Secgroup currentEntity) {
        this.currentEntity = currentEntity;
    }

    /**
     * @return the detailList
     */
    public List<Secgprg> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<Secgprg> detailList) {
        this.detailList = detailList;
    }

    /**
     * @return the currentDetail
     */
    public Secgprg getCurrentDetail() {
        return currentDetail;
    }

    /**
     * @param currentDetail the currentDetail to set
     */
    public void setCurrentDetail(Secgprg currentDetail) {
        this.currentDetail = currentDetail;
    }

}
