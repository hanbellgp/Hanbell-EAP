/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.eap.ejb.ArmbillBean;
import cn.hanbell.eap.ejb.ArmbillDetailBean;
import cn.hanbell.eap.entity.Armbill;
import cn.hanbell.eap.entity.ArmbillDetail;
import cn.hanbell.war.lazy.ArmbillModel;
import cn.hanbell.war.web.FormMultiBean;
import com.lightshell.comm.BaseLib;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "billPrintManagedBean")
@SessionScoped
public class BillPrintManagedBean extends FormMultiBean<Armbill, ArmbillDetail> {

    @EJB
    protected ArmbillDetailBean armbillDetailBean;
    @EJB
    protected ArmbillBean armbillBean;

    private String queryCreator;
    private String queryDeptno;

    /**
     * Creates a new instance of BillPrintManagedBean
     */
    public BillPrintManagedBean() {
        super(Armbill.class, ArmbillDetail.class);
    }

    @Override
    public void delete() {
        if (entityList != null && !entityList.isEmpty()) {
            entityList.stream().forEach((e) -> {
                delete(e);
            });
        }
    }

    @Override
    public void init() {
        queryCreator = userManagedBean.getCurrentUser().getUsername();
        superEJB = armbillBean;
        detailEJB = armbillDetailBean;
        model = new ArmbillModel(armbillBean, userManagedBean.getCompany());
        model.getFilterFields().put("status", "N");
        model.getFilterFields().put("creator", getQueryCreator());
        model.getSortFields().put("status", "ASC");
        model.getSortFields().put("formid", "DESC");
        super.init();
    }

    public void print(String rptdesign) throws Exception {
        if (currentPrgGrant == null || entityList == null || entityList.isEmpty()) {
            return;
        }
        String reportName, outputName, reportFormat;
        //设置报表名称
        reportName = reportPath + currentPrgGrant.getSysprg().getRptdesign();
        //设置导出文件名称
        fileName = "BillPrint" + BaseLib.formatDate("yyyyMMddHHmmss", getDate()) + ".pdf";
        outputName = reportOutputPath + fileName;
        OutputStream os = new FileOutputStream(outputName);
        if (this.currentPrgGrant != null && this.currentPrgGrant.getSysprg().getRptclazz() != null) {
            reportClassLoader = Class.forName(this.currentPrgGrant.getSysprg().getRptclazz()).getClassLoader();
        }
        PdfCopyFields pdfCopy = new PdfCopyFields(os);
        HashMap<String, Object> reportParams = new HashMap<>();
        ByteArrayOutputStream baos;
        for (Armbill c : entityList) {
            //设置报表参数
            baos = new ByteArrayOutputStream();
            reportParams.put("company", userManagedBean.getCurrentCompany().getName());
            reportParams.put("companyFullName", userManagedBean.getCurrentCompany().getFullname());
            reportParams.put("tel", userManagedBean.getCurrentCompany().getTel());
            reportParams.put("fax", userManagedBean.getCurrentCompany().getFax());
            reportParams.put("id", c.getId());
            reportParams.put("formid", c.getFormid());
            reportParams.put("JNDIName", currentPrgGrant.getSysprg().getRptjndi());
            try {
                //初始配置
                this.reportInitAndConfig();
                //生成报表
                this.reportRunAndOutput(reportName, reportParams, null, "pdf", baos);
            } catch (Exception ex) {
                throw ex;
            } finally {
                reportParams.clear();
                c.setStatus("P");
                currentEntity = c;
                update();
            }
            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
        }
        pdfCopy.close();
        this.reportViewPath = reportViewContext + fileName;
        this.preview();
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryFormId != null && !"".equals(queryFormId)) {
                this.model.getFilterFields().put("formid", queryFormId);
            }
            if (queryDateBegin != null) {
                this.model.getFilterFields().put("formdateBegin", queryDateBegin);
            }
            if (queryDateEnd != null) {
                this.model.getFilterFields().put("formdateEnd", queryDateEnd);
            }
            if (queryCreator != null && !"".equals(queryCreator)) {
                this.model.getFilterFields().put("creator", queryCreator);
            }
            if (queryDeptno != null && !"".equals(queryDeptno)) {
                this.model.getFilterFields().put("deptno", queryDeptno);
            }
            if (queryState != null && !"ALL".equals(queryState)) {
                this.model.getFilterFields().put("status", queryState);
            }
        }
    }

    @Override
    public void reset() {
        super.reset();
        queryCreator = userManagedBean.getCurrentUser().getUsername();
        model.getFilterFields().put("status", "N");
        model.getFilterFields().put("creator", getQueryCreator());
    }

    @Override
    public void setEntityList(List<Armbill> entityList) {
        super.setEntityList(entityList);
        if (entityList != null && !entityList.isEmpty()) {
            setCurrentEntity(entityList.get(0));
        }
    }

    /**
     * @return the queryCreator
     */
    public String getQueryCreator() {
        return queryCreator;
    }

    /**
     * @param queryCreator the queryCreator to set
     */
    public void setQueryCreator(String queryCreator) {
        this.queryCreator = queryCreator;
    }

    /**
     * @return the queryDeptno
     */
    public String getQueryDeptno() {
        return queryDeptno;
    }

    /**
     * @param queryDeptno the queryDeptno to set
     */
    public void setQueryDeptno(String queryDeptno) {
        this.queryDeptno = queryDeptno;
    }

}
