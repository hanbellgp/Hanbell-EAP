/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.HKFW005Bean;
import cn.hanbell.oa.ejb.WorkItemBean;
import cn.hanbell.oa.entity.HKFW005;
import cn.hanbell.rpt.lazy.HKFW005Model;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "hkfw005ManagedQueryBean")
@javax.faces.bean.ViewScoped
public class HKFW005ManagedQueryBean extends SuperQueryBean<HKFW005> {

    @EJB
    private WorkItemBean workItemBean;

    @EJB
    private HKFW005Bean hkfw005Bean;

    private String queryWorkItemName;

    /**
     * Creates a new instance of HKFW005QueryBean
     */
    public HKFW005ManagedQueryBean() {
        super(HKFW005.class);
    }

    @Override
    public void init() {
        setSuperEJB(hkfw005Bean);
        this.model = new HKFW005Model(hkfw005Bean);
        this.model.getFilterFields().put("type <>", "4");
        super.init();
    }

    @Override
    public void print() {
        entityList = hkfw005Bean.findByFilters(model.getFilterFields(), model.getSortFields());
        if (entityList == null || entityList.isEmpty()) {
            return;
        }
        fileName = "HKFW005" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
        fileFullName = reportOutputPath + fileName;
        HSSFWorkbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        //创建内容
        Sheet sheet = wb.createSheet("HKFW005");
        Cell cell;
        Row row;
        row = sheet.createRow(0);
        row.createCell(0).setCellValue("流程序号");
        row.createCell(1).setCellValue("创建日期");
        row.createCell(2).setCellValue("客户编号");
        row.createCell(3).setCellValue("客户简称");
        row.createCell(4).setCellValue("主旨");
        row.createCell(5).setCellValue("需求人");
        row.createCell(6).setCellValue("需求部门");
        row.createCell(7).setCellValue("申请人");
        row.createCell(8).setCellValue("申请部门");
        row.createCell(9).setCellValue("配合人");
        row.createCell(10).setCellValue("配合部门");
        row.createCell(11).setCellValue("备注");
        row.createCell(12).setCellValue("运费结算");
        row.createCell(13).setCellValue("送货地址");
        row.createCell(14).setCellValue("出货单号");
        row.createCell(15).setCellValue("借出单号");
        row.createCell(16).setCellValue("归还单号");
        row.createCell(17).setCellValue("发货日期");
        row.createCell(18).setCellValue("物流公司");
        row.createCell(19).setCellValue("货运单号");
        row.createCell(20).setCellValue("运费");
        int i = 1;
        for (HKFW005 e : entityList) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(e.getProcessSerialNumber());
            cell = row.createCell(1);
            cell.setCellValue(e.getCreatedate());
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
            cell.setCellStyle(cellStyle);
            row.createCell(2).setCellValue(e.getCusno() != null ? e.getCusno() : "");
            row.createCell(3).setCellValue(e.getCusna() != null ? e.getCusna() : "");
            row.createCell(4).setCellValue(e.getProcessInstance().getSubject());
            row.createCell(5).setCellValue(e.getRequireUser() != null ? e.getRequireUser().getUserName() : "");
            row.createCell(6).setCellValue(e.getRequireDept() != null ? e.getRequireDept().getOrganizationUnitName() : "");
            row.createCell(7).setCellValue(e.getApplyUser() != null ? e.getApplyUser().getUserName() : "");
            row.createCell(8).setCellValue(e.getApplyDept() != null ? e.getApplyDept().getOrganizationUnitName() : "");
            row.createCell(9).setCellValue(e.getSupportUser() != null ? e.getSupportUser().getUserName() : "");
            row.createCell(10).setCellValue(e.getSupportDept() != null ? e.getSupportDept().getOrganizationUnitName() : "");
            row.createCell(11).setCellValue(e.getMark()!= null ? e.getMark() : "");
            row.createCell(12).setCellValue(e.getYfjs()!= null ? e.getYfjsValue() : "");
            row.createCell(13).setCellValue(e.getShaddress()!= null ? e.getShaddress() : "");
            row.createCell(14).setCellValue(e.getShpno()!= null ? e.getShpno() : "");
            row.createCell(15).setCellValue(e.getLendno()!= null ? e.getLendno() : "");
            row.createCell(16).setCellValue(e.getReturnno()!= null ? e.getReturnno() : "");
            row.createCell(17).setCellValue(e.getShpdate()!= null ? BaseLib.formatDate("yyyy/MM/dd", e.getShpdate()) : "");          
            row.createCell(18).setCellValue(e.getWlcompanyValue()!= null ? e.getWlcompanyValue() : "");
            row.createCell(19).setCellValue(e.getHyno()!= null ? e.getHyno() : "");
            row.createCell(20).setCellValue(e.getTotal()!= null ? String.valueOf(e.getTotal()) : "");
            i++;
        }
        for (int c = 0; c < 13; c++) {
            sheet.autoSizeColumn(c);
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(fileFullName);
            wb.write(os);
            this.reportViewPath = reportViewContext + fileName;
            this.preview();
        } catch (Exception ex) {
            log4j.error(ex);
        } finally {
            try {
                if (null != os) {
                    os.flush();
                    os.close();
                }
            } catch (IOException ex) {
                log4j.error(ex.getMessage());
            }
        }
    }

    @Override
    public void query() {
        List<String> psnList = null;
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryDateBegin != null && queryDateEnd != null) {
                if(!"ALL".equals(queryWorkItemName)){
                    psnList = workItemBean.findProcessSerialNumbersByWorkItem("PKG_HK_FW005", queryWorkItemName, queryDateBegin, queryDateEnd);
                }else{
                    psnList = workItemBean.findProcessSerialNumbersByProcessIdAndCompletedTime("PKG_HK_FW005", queryDateBegin, queryDateEnd);
                }
                if (psnList != null) {
                    this.model.getFilterFields().put("processInstance.serialNumber IN ", psnList);
                } else {
                    this.model.getFilterFields().put("processInstance.serialNumber = ", "");
                }
            }
            if (queryState != null && "Y".equals(queryState)) {
                this.model.getFilterFields().put("processInstance.currentState", 3);
            } else if (queryState != null && "N".equals(queryState)) {
                this.model.getFilterFields().put("processInstance.currentState <=", 2);
            }
        }
        this.model.getFilterFields().put("type <>", "4");
    }

    @Override
    public void reset() {
        super.reset();
        this.model.getFilterFields().put("type <>", "4");
    }

    public void handleFileUploadWhenNew(FileUploadEvent event) {
        UploadedFile file1 = event.getFile();
        Integer a = 0;
        InputStream inputStream =null;
        if (file1 != null) {
            try {
               inputStream=  file1.getInputstream();
                upload(event);
                Workbook excel = WorkbookFactory.create(inputStream);
                Sheet sheet = excel.getSheetAt(0);
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    String processsNumber = row.getCell(0).getStringCellValue();
                    double total =Double.valueOf(cellToVlaue(row.getCell(20)));
                    HKFW005 hkfw005 = hkfw005Bean.findByPSN(processsNumber);
                    hkfw005.setTotal(total);
                    hkfw005Bean.update(hkfw005);   
                }
                 FacesContext.getCurrentInstance().addMessage((String) null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "修改成功"));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage((String) null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "上传失败"));
                ex.printStackTrace();
            }finally{
                try {
                    inputStream.close();
                } catch (IOException ex) {
//                    Logger.getLogger(HKFW005ManagedQueryBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     public String cellToVlaue(Cell cell) {
        if (cell == null) {     
            return "";
        }
        int type = cell.getCellType();
        switch (type) {
            case 0:
                double d = cell.getNumericCellValue();
                //整数去掉小数点
                if (d == (int) d) {
                    return String.valueOf((int) d);
                }
                return String.valueOf(cell.getNumericCellValue());
            case 1:
                return cell.getStringCellValue();
            case 2:
                return cell.getCellFormula();
            case 3:
                return "0";
            case 4:
                return String.valueOf(cell.getBooleanCellValue());
            case 5:
                return String.valueOf(cell.getErrorCellValue());
        }
        return "";
    }

    public boolean upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        OutputStream output = null;
         InputStream input =null;
         UploadedFile file1 = event.getFile();
        try {
             input=  file1.getInputstream();
           String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                StringBuffer pathString = new StringBuffer(filePath.concat("rpt/"));
            pathString.append(String.valueOf(new Date().getTime()));
            pathString.append(".xls");
            String path=pathString.substring(0,pathString.indexOf("Hanbell-EAP")).concat("FileUploadServer/resources").concat(String.valueOf(new Date().getTime()));
            StringBuffer url=new StringBuffer(pathString.substring(0,pathString.indexOf("Hanbell-EAP"))); 
            url.append("FileUploadServer/resources/").append(String.valueOf(new Date().getTime())).append(".xls");
            File dest = new File(url.toString());
            byte[] buf = new byte[1024];
            int bytesRead;
            output = new FileOutputStream(dest);
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            input.close();
            output.close();         
        }
        return true;
    }

    /**
     * @return the workItemName
     */
    public String getQueryWorkItemName() {
        return queryWorkItemName;
    }

    /**
     * @param queryWorkItemName the workItemName to set
     */
    public void setQueryWorkItemName(String queryWorkItemName) {
        this.queryWorkItemName = queryWorkItemName;
    }

}
