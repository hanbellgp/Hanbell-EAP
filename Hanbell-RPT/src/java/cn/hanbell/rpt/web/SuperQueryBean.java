/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.web;

import cn.hanbell.eap.ejb.SystemProgramBean;
import cn.hanbell.eap.entity.SystemProgram;
import com.lightshell.comm.SuperEJB;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;

/**
 *
 * @author KevinDong
 * @param <T>
 */
public abstract class SuperQueryBean<T> {

    @EJB
    protected SystemProgramBean sysprgBean;

    protected FacesContext fc;
    protected ExternalContext ec;

    protected Class<T> entityClass;
    protected SuperEJB superEJB;
    protected SuperLazyModel model;
    protected List<T> entityList;
    protected T currentEntity;
    protected T newEntity;

    protected String appDataPath;
    protected String appResPath;
    protected SystemProgram currentPrg;
    protected String fileName;
    protected String fileFullName;
    protected String reportPath;
    protected String reportOutputPath;
    protected String reportViewContext;
    protected String reportViewPath;

    protected Map<String, String[]> params;//页面传参

    protected Date queryDateBegin;
    protected Date queryDateEnd;
    protected String queryState;

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    /**
     * @param entityClass
     */
    public SuperQueryBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PostConstruct
    public void construct() {
        //不需要进行操作权限设置
        fc = FacesContext.getCurrentInstance();
        ec = fc.getExternalContext();
        appDataPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.appdatapath");
        appResPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.apprespath");
        reportPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.reportpath");
        reportOutputPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.reportoutputpath");
        reportViewContext = ec.getInitParameter("cn.hanbell.web.reportviewcontext");
        int beginIndex = fc.getViewRoot().getViewId().lastIndexOf("/") + 1;
        int endIndex = fc.getViewRoot().getViewId().lastIndexOf(".");
        String rpt = fc.getViewRoot().getViewId().substring(beginIndex, endIndex);
        currentPrg = sysprgBean.findBySystemAndAPI("EFGP", rpt);
        create();
        init();
    }

    @PreDestroy
    public void destroy() {
        if (entityList != null) {
            entityList.clear();
            entityList = null;
        }
        setCurrentEntity(null);
        setNewEntity(null);
        setModel(null);
        if (getSuperEJB() != null) {
            superEJB = null;
        }
    }

    public void create() {
        if (newEntity == null) {
            try {
                T entity = entityClass.newInstance();
                setNewEntity(entity);
            } catch (InstantiationException | IllegalAccessException ex) {
                log4j.error(ex);
            }
        }
    }

    public void init() {
        if (this.getModel().getDataList() != null && !this.model.getDataList().isEmpty()) {
            setCurrentEntity((T) this.getModel().getDataList().get(0));
        } else {
            setCurrentEntity(getNewEntity());
        }
    }

    public void preview() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().redirect(reportViewPath);
    }

    public void print() {

    }

    public void query() {

    }

    public void reset() {
        if (model != null) {
            model.filterFields.clear();
        }
    }

    //关窗
      public void closeDialog() {
        if (this.currentEntity != null) {
            this.closeDialog(this.currentEntity);
        } else {
             this.showWarnMsg("Warn", "没有选择数据!");
        }

    }

    public void closeDialog(Object entity) {
        if (entity != null) {
            PrimeFaces.current().dialog().closeDynamic(entity);
        } else {
            this.showWarnMsg("Warn", "没有选择数据!");
        }
    }
    
    //开窗
public void openDialog(String view) {
        this.openDialog(view, (Map) null);
    }

    protected void openDialog(String view, Map<String, List<String>> params) {
        Map<String, Object> options = new HashMap();
        options.put("modal", true);
        this.openDialog(view, options, null);
    }

    protected void openDialog(String view, Map<String, Object> options, Map<String, List<String>> params) {
        try {
            PrimeFaces.current().dialog().openDynamic(view, options, params);
        } catch (Exception var5) {
           var5.printStackTrace();
        }
    }
    //JSF警告
     protected void showWarnMsg(String summary, String detail) {
        this.showMsg(FacesMessage.SEVERITY_WARN, summary, detail);
    }
       protected void showMsg(Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(severity, summary, detail));
    }
    /**
     * @return the superEJB
     */
    public SuperEJB getSuperEJB() {
        return superEJB;
    }

    /**
     * @param superEJB the superEJB to set
     */
    public void setSuperEJB(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    /**
     * @return the model
     */
    public SuperLazyModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(SuperLazyModel model) {
        this.model = model;
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
     * @return the newEntity
     */
    public T getNewEntity() {
        return newEntity;
    }

    /**
     * @param newEntity the newEntity to set
     */
    public void setNewEntity(T newEntity) {
        this.newEntity = newEntity;
    }

    public String getAppDataPath() {
        return this.appDataPath;
    }

    public String getAppImgPath() {
        return this.appResPath;
    }

    public String getAppResPath() {
        return this.appResPath;
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

    /**
     * @return the queryState
     */
    public String getQueryState() {
        return queryState;
    }

    /**
     * @param queryState the queryState to set
     */
    public void setQueryState(String queryState) {
        this.queryState = queryState;
    }

}
