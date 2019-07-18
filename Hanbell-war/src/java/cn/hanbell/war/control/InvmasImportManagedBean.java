/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.eap.ejb.InvmasImportBean;
import cn.hanbell.eap.entity.InvmasImport;
import cn.hanbell.erp.ejb.InvclsBean;
import cn.hanbell.erp.entity.Invcls;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.model.HZJS034DetailModel;
import cn.hanbell.oa.model.HZJS034Model;
import cn.hanbell.war.lazy.InvmasImportModel;
import cn.hanbell.war.web.SuperSingleBean;
import com.lightshell.comm.BaseLib;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "invmasImportManagedBean")
@SessionScoped
public class InvmasImportManagedBean extends SuperSingleBean<InvmasImport> {

    @EJB
    private WorkFlowBean workFlowBean;

    @EJB
    private InvclsBean invclsBean;

    @EJB
    private InvmasImportBean invmasImportBean;

    private List<InvmasImport> addedList;

    public InvmasImportManagedBean() {
        super(InvmasImport.class);
    }

    @Override
    public void delete() {
        if (entityList != null && !entityList.isEmpty()) {
            superEJB.delete(entityList);
            entityList.clear();
            showInfoMsg("Info", "删除成功");
        }
    }

    @Override
    protected boolean doAfterPersist() throws Exception {
        fileName = null;
        doAdd = false;
        return super.doAfterPersist();
    }

    @Override
    protected boolean doBeforePersist() throws Exception {
        if (addedList == null || addedList.isEmpty()) {
            showErrorMsg("Error", "没有可导入资料");
            return false;
        }
        if (addedList.size() > 1) {
            addedList.sort((InvmasImport o1, InvmasImport o2) -> {
                if (o1.getItnbr().compareTo(o2.getItnbr()) < 1) {
                    return -1;
                } else {
                    return 1;
                }
            });
        }
        return true;
    }

    @Override
    protected boolean doBeforeVerify() throws Exception {
        if (entityList == null || entityList.isEmpty()) {
            showErrorMsg("Error", "没有可导入资料");
            return false;
        }
        return true;
    }

    @Override
    public void handleFileUploadWhenNew(FileUploadEvent event) {
        super.handleFileUploadWhenNew(event);
        if (this.fileName != null) {
            InvmasImport e;
            if (addedList != null) {
                addedList.clear();
            }
            try {
                InputStream is = new FileInputStream(getAppResPath() + "/" + fileName);
                Workbook wb = WorkbookFactory.create(is);
                Sheet sheet = wb.getSheetAt(wb.getActiveSheetIndex());
                Cell c;
                for (Row r : sheet) {
                    if (r.getRowNum() == 0) {
                        continue;
                    }
                    e = new InvmasImport();
                    c = r.getCell(0);
                    e.setItcls(BaseLib.convertExcelCell(String.class, c).trim());
                    c = r.getCell(1);
                    e.setItnbr(BaseLib.convertExcelCell(String.class, c).trim());
                    c = r.getCell(2);
                    e.setItdsc(BaseLib.convertExcelCell(String.class, c).trim());
                    c = r.getCell(3);
                    e.setSpdsc(BaseLib.convertExcelCell(String.class, c).trim());
                    c = r.getCell(4);
                    e.setEitdsc(BaseLib.convertExcelCell(String.class, c).trim());
                    c = r.getCell(5);
                    e.setEspdsc(BaseLib.convertExcelCell(String.class, c).trim());
                    c = r.getCell(6);
                    e.setKind(BaseLib.convertExcelCell(String.class, c).trim());
                    c = r.getCell(7);
                    e.setUnmsr1(BaseLib.convertExcelCell(String.class, c).trim());
                    c = r.getCell(8);
                    e.setUsed(BaseLib.convertExcelCell(String.class, c).trim());
                    e.setStatus("N");
                    e.setCreator(userManagedBean.getCurrentUser().getUsername());
                    e.setCredateToNow();
                    addedList.add(e);
                }
                doAdd = true;
                showInfoMsg("Info", "导入成功");
            } catch (IOException | InvalidFormatException ex) {
                showErrorMsg("Info", "导入失败,找不到文件或格式错误");
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void init() {
        doAdd = false;
        addedList = new ArrayList<>();
        superEJB = invmasImportBean;
        model = new InvmasImportModel(invmasImportBean);
        model.getFilterFields().put("status", "N");
        super.init();
    }

    @Override
    public void persist() {
        try {
            if (doBeforePersist()) {
                addedList.stream().forEach((e) -> {
                    superEJB.persist(e);
                });
                doAfterPersist();
                showInfoMsg("Info", "新增保存成功");
            } else {
                showErrorMsg("Error", "新增前检核失败");
            }
        } catch (Exception ex) {
            showErrorMsg("Error", ex.getMessage());
        }
    }

    @Override
    public void reset() {
        if (addedList != null) {
            addedList.clear();
        }
        fileName = null;
        doAdd = false;
    }

    @Override
    protected void setToolBar() {
        if (currentPrgGrant != null) {
            this.doEdit = currentPrgGrant.getDoedit();
            this.doDel = currentPrgGrant.getDodel();
            this.doCfm = currentPrgGrant.getDocfm();
            this.doUnCfm = currentPrgGrant.getDouncfm();
        }
    }

    @Override
    public void verify() {
        try {
            if (!doBeforeVerify()) {
                showErrorMsg("Error", "抛转前检核失败");
                return;
            }
            String formid;
            HZJS034Model m;
            HZJS034DetailModel d;
            List<HZJS034DetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("Detail", detailList);
            invclsBean.setCompany(userManagedBean.getCompany());
            int i = 0;
            for (InvmasImport e : entityList) {
                i++;
                d = new HZJS034DetailModel();
                d.setSeq(String.valueOf(i));
                if (e.getItcls() != null && !"".equals(e.getItcls())) {
                    Invcls invcls = invclsBean.findByItcls(e.getItcls());
                    if (invcls == null) {
                        showErrorMsg("Error", e.getItcls() + "大类不存在");
                        return;
                    }
                    d.setItcls(e.getItcls());
                    d.setClsdsc(invcls.getClsdsc());
                    d.setItclscode(invcls.getItclscode().toString());
                    d.setJityn(invcls.getJityn().toString());
                    d.setPurtrtype(invclsBean.findPurtrtypeByItclscode(d.getItclscode()));
                } else {
                    d.setItcls("");
                    d.setClsdsc("");
                }
                d.setItnbr(e.getItnbr());
                d.setItdsc(e.getItdsc());
                d.setSpdsc(e.getSpdsc());
                d.setEitdsc(e.getEitdsc());
                d.setEspdsc(e.getEspdsc());
                d.setKind(e.getKind());
                d.setMorpcode("P");
                d.setUnmsr1(e.getUnmsr1());
                d.setUnmsr1e("PC");
                d.setUnmsr2("");
                d.setIsDUnit("N");
                d.setYt(e.getUsed());
                d.setRemark("");
                detailList.add(d);
            }
            formid = BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate());
            workFlowBean.initUserInfo(userManagedBean.getUserid());
            m = new HZJS034Model();
            m.setFacno(userManagedBean.getCompany());
            m.setEmpl(workFlowBean.getCurrentUser().getId());
            m.setDept(workFlowBean.getUserFunction().getOrganizationUnit().getId());
            m.setIndate(BaseLib.getDate());
            m.setPLMNO(formid);
            String formInstance = workFlowBean.buildXmlForEFGP("HZ_JS034", m, details);
            String subject = "批量导入_" + formid;
            String msg = workFlowBean.invokeProcess(workFlowBean.hostAdd, workFlowBean.hostPort, "HZ_JS034", formInstance, subject);
            String[] rm = msg.split("\\$");
            if (rm != null) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, rm);
            }
            if (rm.length == 2 && rm[0].equals("200")) {
                //更新导入内容状态
                formid = rm[1];
                for (InvmasImport ii : entityList) {
                    ii.setStatus("V");
                    ii.setRemark(formid);
                }
                superEJB.update(entityList);
                showInfoMsg("Info", "流程序号" + formid);
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the addedList
     */
    public List<InvmasImport> getAddedList() {
        return addedList;
    }

    /**
     * @param addedList the addedList to set
     */
    public void setAddedList(List<InvmasImport> addedList) {
        this.addedList = addedList;
    }

}
