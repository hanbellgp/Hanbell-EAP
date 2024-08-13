/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.eap.ejb.ProposalAttachBean;
import cn.hanbell.eap.ejb.ProposalBean;
import cn.hanbell.eap.entity.Department;
import cn.hanbell.eap.entity.Proposal;
import cn.hanbell.eap.entity.ProposalAttach;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.war.lazy.ProposalModel;
import cn.hanbell.war.web.SuperMultiBean;
import com.lightshell.comm.BaseLib;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "proposalManagedBean")
@SessionScoped
public class ProposalManagedBean extends SuperMultiBean<Proposal, ProposalAttach> {

    @EJB
    private ProposalBean proposalBean;
    @EJB
    private ProposalAttachBean proposalAttachBean;
    private String queryCreator;
    private String queryDept;

    public ProposalManagedBean() {
        super(Proposal.class, ProposalAttach.class);
    }

    // 自动获取案件编号
    @Override
    protected boolean doBeforePersist() throws Exception {
        if (super.doBeforePersist()) {
            String fomrid = proposalBean.getFormId(BaseLib.getDate());
            newEntity.setProposalid(fomrid);
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        queryFormId = null;
        queryName = null;
        queryCreator = null;
        queryDept = null;
        queryDateBegin = null;
        queryDateEnd = null;
        queryState = null;
        super.reset(); //
    }

    @Override
    public void handleDialogReturnWhenNew(SelectEvent event) {
        if (newEntity != null && event.getObject() != null) {
            SystemUser u = (SystemUser) event.getObject();
            newEntity.setProposaluserno(u.getUserid());
            newEntity.setProposaluserna(u.getUsername());
        }
    }

    public void handDialogReturnDeptWhenNew(SelectEvent event) {
        if (newEntity != null && event.getObject() != null) {
            Department dept = (Department) event.getObject();
            newEntity.setProposaldepno(dept.getDeptno());
            newEntity.setProposaldept(dept.getDept());
        }
    }

    public void handleDialogReturnUserWhenEdit(SelectEvent event) {
        if (currentEntity != null && event.getObject() != null) {
            SystemUser u = (SystemUser) event.getObject();
            currentEntity.setProposaluserno(u.getUserid());
            currentEntity.setProposaluserna(u.getUsername());
        }
    }

    public void handleDialogReturnDeptWhenEdit(SelectEvent event) {
        if (currentEntity != null && event.getObject() != null) {
            Department dept = (Department) event.getObject();
            currentEntity.setProposaldepno(dept.getDeptno());
            currentEntity.setProposaldept(dept.getDept());
        }
    }

    @Override
    public void init() {
        this.superEJB = proposalBean;
        this.detailEJB = proposalAttachBean;
        this.model = new ProposalModel(proposalBean);
        super.init();
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryFormId != null && !"".equals(queryFormId)) {
                this.model.getFilterFields().put("proposalid", queryFormId);
            }
            if (queryName != null && !"".equals(queryName)) {
                this.model.getFilterFields().put("proposalna", queryName);
            }
            if (queryCreator != null && !"".equals(queryCreator)) {
                this.model.getFilterFields().put("proposaluserna", queryCreator);
            }
            if (queryDept != null && !"".equals(queryDept)) {
                this.model.getFilterFields().put("proposaldepno", queryDept);
            }
            if (queryDateBegin != null) {
                this.model.getFilterFields().put("proposaldateBegin", queryDateBegin);
            }
            if (queryDateEnd != null) {
                this.model.getFilterFields().put("proposaldateEnd", queryDateEnd);
            }
            if (queryState != null && !"".equals(queryState)) {
                if (!"ALL".equals(queryState)) {
                    this.model.getFilterFields().put("conclusion", queryState);
                }
            }
        }
    }

    public String queryView() {
        return "proposalQuery";
    }

    public String getQueryCreator() {
        return queryCreator;
    }

    public void setQueryCreator(String queryCreator) {
        this.queryCreator = queryCreator;
    }

    public String getQueryDept() {
        return queryDept;
    }

    public void setQueryDept(String queryDept) {
        this.queryDept = queryDept;
    }

    public void handleFileUploadWhenDetailEdit(FileUploadEvent event) throws UnsupportedEncodingException {
        super.handleFileUploadWhenEdit(event);
        if (this.fileName != null) {
            String path = this.getClass().getClassLoader().getResource("/").getPath().substring(1);
            path = java.net.URLDecoder.decode(path, "utf-8");
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
                    .getResponse();
         // response.setCharacterEncoding("GBK");
            if (newDetail == null) {
                this.createDetail();
                this.currentDetail.setResource(fileName);
                this.currentDetail.setContent(path);
                this.doConfirmDetail();
            } else {
                this.currentDetail.setResource(fileName);
                this.doConfirmDetail();
            }
        }
    }

//    //设置唯一ID
//    static String oldProsalID = "";
//    //唯一ID的生成
//    public String getnewPorsaalID() {
//        String id = null;
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
//        String thisData = oldProsalID.substring(0, 6);
//        //这个判断就是判断你数据取出来的最后一个业务单号是不是当月的
//        if (!formatter.format(date).equals(thisData)) {
//          //过了一个月
//            thisData = formatter.format(date);
//            id = "HHTG" + thisData + "0001";
//        } else {
//           //当月
//            DecimalFormat df = new DecimalFormat("0000");
//           //不是新的一月就累加
//            id = "HHTG" + formatter.format(date)
//                    + df.format(1 + Integer.parseInt(oldProsalID.substring(6)));
//        }
//        oldProsalID=id;
//        return id;
//
//    }
}
