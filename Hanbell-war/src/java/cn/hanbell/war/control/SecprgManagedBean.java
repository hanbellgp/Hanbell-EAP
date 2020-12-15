/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.erp.ejb.SecprgBean;
import cn.hanbell.erp.ejb.SecuprgBean;
import cn.hanbell.erp.entity.Secuprg;
import cn.hanbell.erp.entity.Secprg;
import cn.hanbell.war.lazy.SecprgModel;
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
@ManagedBean(name = "secprgManagedBean")
@SessionScoped
public class SecprgManagedBean implements Serializable {

    @EJB
    private SecprgBean secprgBean;

    @EJB
    private SecuprgBean secuprgBean;

    private SecprgModel model;
    private Secprg currentEntity;

    private List<Secuprg> detailList;
    private Secuprg currentDetail;

    private String queryFacno;
    private String queryPrgno;
    private String queryPrgname;
    private String querySysno;

    public SecprgManagedBean() {
    }

    @PostConstruct
    public void construct() {
        init();
    }

    public void init() {
        this.model = new SecprgModel(secprgBean);
    }

    public void query() {
        if (model != null) {
            model.getFilterFields().clear();
            this.secuprgBean.setCompany(queryFacno);
            if (queryPrgno != null && !"".equals(queryPrgno)) {
                model.getFilterFields().put("prgno", queryPrgno);
            }
            if (this.queryPrgname != null && !"".equals(this.queryPrgname)) {
                model.getFilterFields().put("prgname", queryPrgname);
            }
            if (this.querySysno != null && !"".equals(this.querySysno)) {
                model.getFilterFields().put("sysno", querySysno);
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
            secuprgBean.setCompany(queryFacno);
            detailList = secuprgBean.findByPrgno(currentEntity.getPrgno());
            return path;
        }
    }

    /**
     * @return the model
     */
    public SecprgModel getModel() {
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
     * @return the queryPrgno
     */
    public String getQueryPrgno() {
        return queryPrgno;
    }

    /**
     * @param queryPrgno the queryPrgno to set
     */
    public void setQueryPrgno(String queryPrgno) {
        this.queryPrgno = queryPrgno;
    }

    /**
     * @return the queryPrgname
     */
    public String getQueryPrgname() {
        return queryPrgname;
    }

    /**
     * @param queryPrgname the queryPrgname to set
     */
    public void setQueryPrgname(String queryPrgname) {
        this.queryPrgname = queryPrgname;
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
    public Secprg getCurrentEntity() {
        return currentEntity;
    }

    /**
     * @param currentEntity the currentEntity to set
     */
    public void setCurrentEntity(Secprg currentEntity) {
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

}
