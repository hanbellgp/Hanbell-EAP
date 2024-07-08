///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.war.rpt;
//
////import cn.hanbell.crm.ejb.CRMGGBean;
////import cn.hanbell.crm.ejb.REPMIBean;
////import cn.hanbell.crm.ejb.WARMBBean;
//import cn.hanbell.crm.entity.CRMGG;
//import cn.hanbell.crm.entity.REPMI;
//import cn.hanbell.crm.entity.REPMIPK;
//import cn.hanbell.eap.entity.InvmasImport;
//import cn.hanbell.war.control.UserManagedBean;
//import cn.hanbell.war.web.SuperSingleBean;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.ViewScoped;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.primefaces.event.FileUploadEvent;
//
///**
// *
// * @author C1879
// */
//@ManagedBean(name = "repmiImportManagedBean")
//@ViewScoped
//public class REPMIImportManagedBean extends SuperSingleBean<InvmasImport> {
//
//    protected String MI001;
//    protected String MI002;
//    protected Date dateBegin;
//    protected Date dateEnd;
//    protected List<REPMI> repmiList;
//
//    LinkedHashMap<String, String> map;
//
////    @EJB
////    protected REPMIBean rEPMIBean;
////    @EJB
////    protected WARMBBean wARMBBean;
////    @EJB
////    protected CRMGGBean cRMGGBean;
//
//    @ManagedProperty(value = "#{userManagedBean}")
//    protected UserManagedBean userBean;
//
//    public REPMIImportManagedBean() {
//        super(InvmasImport.class);
//        repmiList = new ArrayList<>();
//    }
//
//    @Override
//    public void init() {
//        repmiList.clear();
//        MI001 = "";
//        MI002 = "";
//        dateBegin = null;
//        dateEnd = null;
//    }
//
//    @Override
//    public void reset() {
//        init();
//    }
//
//    @Override
//    public void query() {
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//        map = new LinkedHashMap<>();
//        map.put("MI001", MI001);
//        map.put("MI002", MI002);
//        map.put("dateBegin", dateBegin != null ? df.format(dateBegin) : "");
//        map.put("dateEnd", dateEnd != null ? df.format(dateEnd) : "");
//        repmiList = rEPMIBean.queryRepmi(map);
//    }
//
//    @Override
//    public void handleFileUploadWhenNew(FileUploadEvent event) {
//        List<REPMI> addlist = new ArrayList<>();
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
//
//        super.handleFileUploadWhenNew(event);
//        if (this.fileName != null) {
//            if (addlist != null) {
//                addlist.clear();
//            }
//            int linage = 0;
//            try {
//                InputStream is = new FileInputStream(getAppResPath() + "/" + fileName);
//                Workbook excel = WorkbookFactory.create(is);
//                Sheet sheet = excel.getSheetAt(0);
//                int lastRowNum = sheet.getLastRowNum();
//                REPMI repmi;
//                CRMGG crmgg;
//                boolean inspect = false;
//                for (int i = 1; i <= lastRowNum; i++) {
//                    linage = i + 1;
//                    repmi = new REPMI();
//                    Row row = sheet.getRow(i);
//                    repmi.setREPMIPK(new REPMIPK(row.getCell(0).getStringCellValue().trim(), row.getCell(1).getStringCellValue().trim())); //(品号,序号)
//                    if (wARMBBean.findByMB001(row.getCell(0).getStringCellValue().trim()) == null) {
//                        showErrorMsg("Error", "导入资料第" + linage + "行产品序号资料不存在");
//                        inspect = true;
//                    }
//                    if (row.getCell(2).getDateCellValue() != null) {
//                        repmi.setMi006(df.format(row.getCell(2).getDateCellValue())); //保修期间起
//                    }
//                    if (row.getCell(3).getDateCellValue() != null) {
//                        repmi.setMi007(df.format(row.getCell(3).getDateCellValue())); //保修期间止
//                    }
//                    repmi.setMi506(row.getCell(4).getStringCellValue().trim()); //终端客户代号
//                    crmgg = cRMGGBean.findByERPCusno(row.getCell(4).getStringCellValue().trim());
//                    if (crmgg == null) {
//                        showErrorMsg("Error", "导入资料第" + linage + "行终端客户资料不存在");
//                        inspect = true;
//                    }
//                    if (crmgg != null) {
//                        repmi.setMi507(crmgg.getGg003()); //终端客户简称
//                    }
//                    addlist.add(repmi);
//                    linage = 0;
//                }
//                if (inspect) {
//                    showErrorMsg("Error", "资料导入CRM失败");
//                } else if (addlist != null || !addlist.isEmpty()) {
//                    if (rEPMIBean.addRepmi(addlist, this.userBean.getCurrentUser().getUserid())) {
//                        showInfoMsg("Info", "数据成功导入CRM资料库中");
////                        //将导入文件重命名
////                        File file = new File(getAppResPath() + "/" + fileName);
////                        file.renameTo(new File(getAppResPath() + "/" + (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + this.userBean.getCurrentUser().getUserid() + this.userBean.getCurrentUser().getUsername() + fileName)));
//                    } else {
//                        showInfoMsg("Info", "资料异常导入CRM失败");
//                    }
//                } else {
//                    showInfoMsg("Info", "资料异常导入CRM失败");
//                }
//            } catch (Exception ex) {
//                if (linage != 0) {
//                    showErrorMsg("Error", "导入资料第" + linage + "行格式错误");
//                }
//                showErrorMsg("Error", "导入CRM失败,找不到文件或格式错误----" + ex.toString());
//            }
//        }
//    }
//
//    /**
//     * @return the MI001
//     */
//    public String getMI001() {
//        return MI001;
//    }
//
//    /**
//     * @param MI001 the MI001 to set
//     */
//    public void setMI001(String MI001) {
//        this.MI001 = MI001;
//    }
//
//    /**
//     * @return the MI002
//     */
//    public String getMI002() {
//        return MI002;
//    }
//
//    /**
//     * @param MI002 the MI002 to set
//     */
//    public void setMI002(String MI002) {
//        this.MI002 = MI002;
//    }
//
//    /**
//     * @return the repmiList
//     */
//    public List<REPMI> getRepmiList() {
//        return repmiList;
//    }
//
//    /**
//     * @param repmiList the repmiList to set
//     */
//    public void setRepmiList(List<REPMI> repmiList) {
//        this.repmiList = repmiList;
//    }
//
//    /**
//     * @return the userBean
//     */
//    public UserManagedBean getUserBean() {
//        return userBean;
//    }
//
//    /**
//     * @param userBean the userBean to set
//     */
//    public void setUserBean(UserManagedBean userBean) {
//        this.userBean = userBean;
//    }
//
//    /**
//     * @return the dateBegin
//     */
//    public Date getDateBegin() {
//        return dateBegin;
//    }
//
//    /**
//     * @param dateBegin the dateBegin to set
//     */
//    public void setDateBegin(Date dateBegin) {
//        this.dateBegin = dateBegin;
//    }
//
//    /**
//     * @return the dateEnd
//     */
//    public Date getDateEnd() {
//        return dateEnd;
//    }
//
//    /**
//     * @param dateEnd the dateEnd to set
//     */
//    public void setDateEnd(Date dateEnd) {
//        this.dateEnd = dateEnd;
//    }
//
//}
