/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.web;

import cn.hanbell.war.control.UserManagedBean;
import cn.hanbell.eap.entity.SystemGrantPrg;
import cn.hanbell.erp.comm.SuperEJBForERP;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author KevinDong
 * @param <T>
 */
public abstract class SuperQueryBeanForERP<T> implements Serializable {

    protected FacesContext fc;
    protected ExternalContext ec;

    protected Class<T> entityClass;
    protected SuperEJBForERP superEJB;

    protected T currentEntity;
    protected List<T> entityList;
    protected BaseLazyModelForERP model;

    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean userManagedBean;

    protected String appDataPath;
    protected String appResPath;
    protected SystemGrantPrg currentPrgGrant;

    protected Map<String, String[]> requestParams;//页面传参

    protected String queryFormId;
    protected String queryName;
    protected Date queryDateBegin;
    protected Date queryDateEnd;

    /**
     * @param entityClass
     */
    public SuperQueryBeanForERP(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PostConstruct
    public void construct() {
        //不需要进行操作权限设置
        fc = FacesContext.getCurrentInstance();
        ec = fc.getExternalContext();
        appDataPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.appdatapath");
        appResPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.apprespath");
        int beginIndex = fc.getViewRoot().getViewId().lastIndexOf("/") + 1;
        int endIndex = fc.getViewRoot().getViewId().lastIndexOf(".");
        if (getUserManagedBean().getSystemGrantPrgList() != null && !userManagedBean.getSystemGrantPrgList().isEmpty()) {
            getUserManagedBean().getSystemGrantPrgList().stream().filter((p) -> (p.getSysprg().getApi().equals(fc.getViewRoot().getViewId().substring(beginIndex, endIndex)))).forEachOrdered((p) -> {
                currentPrgGrant = p;
            });
        }
        init();
    }

    @PreDestroy
    public void destory() {
        if (getEntityList() != null) {
            getEntityList().clear();
        }
        setCurrentEntity(null);
        setModel(null);
        superEJB = null;
    }

    public void closeDialog() {
        if (currentEntity != null) {
            closeDialog(currentEntity);
        } else {
            showMsg(FacesMessage.SEVERITY_WARN, "Warn", "没有选择数据");
        }
    }

    public void closeDialog(T entity) {
        if (entity != null) {
            RequestContext.getCurrentInstance().closeDialog(entity);
        } else {
            showMsg(FacesMessage.SEVERITY_WARN, "Warn", "没有选择数据");
        }
    }

    public void handleRowSelect(SelectEvent event) {
        setCurrentEntity((T) event.getObject());
    }

    public void handleRowUnselect(UnselectEvent event) {
        setCurrentEntity(null);
    }

    public void init() {
        if (this.model != null && this.model.getDataList() != null && !this.model.getDataList().isEmpty()) {
            currentEntity = (T) this.model.getDataList().get(0);
        } else {
            try {
                currentEntity = entityClass.newInstance();
            } catch (Exception ex) {

            }

        }
    }

    public void query() {

    }

    public void reset() {
        if (this.getModel() != null) {
            this.getModel().getFilterFields().clear();
        }
    }

    protected void showMsg(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public String getAppDataPath() {
        return this.appDataPath;
    }

    public String getAppResPath() {
        return this.appResPath;
    }

    /**
     * @return the userManagedBean
     */
    public UserManagedBean getUserManagedBean() {
        return userManagedBean;
    }

    /**
     * @param userManagedBean the userManagedBean to set
     */
    public void setUserManagedBean(UserManagedBean userManagedBean) {
        this.userManagedBean = userManagedBean;
    }

    /**
     * @return the currentEntity
     */
    public T getCurrentEntity() {
        return currentEntity;
    }

    /**
     * @param currentEntity the currentEntity to set
     */
    public void setCurrentEntity(T currentEntity) {
        this.currentEntity = currentEntity;
    }

    /**
     * @return the entityList
     */
    public List<T> getEntityList() {
        return entityList;
    }

    /**
     * @param entityList the entityList to set
     */
    public void setEntityList(List<T> entityList) {
        this.entityList = entityList;
    }

    /**
     * @return the model
     */
    public BaseLazyModelForERP getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(BaseLazyModelForERP model) {
        this.model = model;
    }

    /**
     * @return the superEJB
     */
    public SuperEJBForERP getSuperEJB() {
        return superEJB;
    }

    /**
     * @return the queryFormId
     */
    public String getQueryFormId() {
        return queryFormId;
    }

    /**
     * @param queryFormId the queryFormId to set
     */
    public void setQueryFormId(String queryFormId) {
        this.queryFormId = queryFormId;
    }

    /**
     * @return the queryName
     */
    public String getQueryName() {
        return queryName;
    }

    /**
     * @param queryName the queryName to set
     */
    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    /**
     * @return the queryDateBegin
     */
    public Date getQueryDateBegin() {
        return queryDateBegin;
    }

    /**
     * @param queryDateBegin the queryDateBegin to set
     */
    public void setQueryDateBegin(Date queryDateBegin) {
        this.queryDateBegin = queryDateBegin;
    }

    /**
     * @return the queryDateEnd
     */
    public Date getQueryDateEnd() {
        return queryDateEnd;
    }

    /**
     * @param queryDateEnd the queryDateEnd to set
     */
    public void setQueryDateEnd(Date queryDateEnd) {
        this.queryDateEnd = queryDateEnd;
    }

}
