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
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.text.Collator;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.json.JSONException;
import org.json.JSONObject;
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

    private Date queryCreateDateBegin;

    private Date queryCreateDateEnd;

    private String queryFormSerialNumber;
    private String queryCustomer;

    private final String TMSURL = "http://172.16.10.95:9090/api/TMS_Freight/";

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
        queryCreateDateEnd=BaseLib.getDate();
        Calendar c=Calendar.getInstance();
        c.setTime(queryCreateDateEnd);
        c.add(Calendar.MONTH, -2);
        queryCreateDateBegin=c.getTime();
        super.init();
        this.queryState = "1";
    }

    @Override
    public void print() {
        entityList = hkfw005Bean.findByHKCW005QueryPage(queryCreateDateBegin, queryCreateDateEnd, queryFormSerialNumber, queryCustomer, queryDateBegin, queryDateEnd, queryState, queryWorkItemName);
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
            row.createCell(11).setCellValue(e.getMark() != null ? e.getMark() : "");
            row.createCell(12).setCellValue(e.getYfjs() != null ? e.getYfjsValue() : "");
            row.createCell(13).setCellValue(e.getShaddress() != null ? e.getShaddress() : "");
            row.createCell(14).setCellValue(e.getShpno() != null ? e.getShpno() : "");
            row.createCell(15).setCellValue(e.getLendno() != null ? e.getLendno() : "");
            row.createCell(16).setCellValue(e.getReturnno() != null ? e.getReturnno() : "");
            row.createCell(17).setCellValue(e.getShpdate() != null ? BaseLib.formatDate("yyyy/MM/dd", e.getShpdate()) : "");
            row.createCell(18).setCellValue(e.getWlcompanyValue() != null ? e.getWlcompanyValue() : "");
            row.createCell(19).setCellValue(e.getHyno() != null ? e.getHyno() : "");
            row.createCell(20).setCellValue(e.getTotal() != null ? String.valueOf(e.getTotal()) : "");
            i++;
        }
        for (int c = 0; c < 21; c++) {
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
       entityList=hkfw005Bean.findByHKCW005QueryPage(queryCreateDateBegin, queryCreateDateEnd, queryFormSerialNumber, queryCustomer, queryDateBegin, queryDateEnd, queryState, queryWorkItemName);
       System.out.println(entityList.size());
    }

    public void update() {
        try {
            entityList = hkfw005Bean.findByHKCW005QueryPage(queryCreateDateBegin, queryCreateDateEnd, queryFormSerialNumber, queryCustomer, queryDateBegin, queryDateEnd, queryState, queryWorkItemName);
            if (entityList == null || entityList.isEmpty()) {
                return;
            }
            for (HKFW005 e : entityList) {
                //https请求获取TMS的数据
                String scrno = "";
                if (e.getReturnno() != null && !"".equals(e.getReturnno())) {
                    if (e.getReturnno().contains(";")) {
                        scrno = e.getReturnno().split(";")[0];
                    } else {
                        scrno = e.getReturnno();
                    }
                } else if (e.getLendno() != null && !"".equals(e.getLendno())) {
                    if (e.getLendno().contains(";")) {
                        scrno = e.getLendno().split(";")[0];
                    } else {
                        scrno = e.getLendno();
                    }
                } else if (e.getShpno() != null && !"".equals(e.getShpno())) {
                    if (e.getShpno().contains(";")) {
                        scrno = e.getShpno().split(";")[0];
                    } else {
                        scrno = e.getShpno();
                    }
                }
                e.setIsHighYellow(false);
                Map<String, String> result = this.findByTms(scrno);
                if (result == null) {
                    continue;
                }
                StringBuilder s = new StringBuilder();
                //归还单号
                if (e.getReturnno() != null && !"".equals(e.getReturnno())) {
                    s.append(e.getReturnno());
                    if (!e.getReturnno().endsWith(";")) {
                        s.append(";");
                    }
                }
                //借出单号
                if (e.getLendno() != null && !"".equals(e.getLendno())) {
                    s.append(e.getLendno());
                    if (!e.getLendno().endsWith(";")) {
                        s.append(";");
                    }
                }
                //出货单号
                if (e.getShpno() != null && !"".equals(e.getShpno())) {
                    s.append(e.getShpno());
                    if (!e.getShpno().endsWith(";")) {
                        s.append(";");
                    }
                }
                Comparator comparator = Collator.getInstance(java.util.Locale.CHINA);
                String[] srnos = s.toString().split(";");
                Arrays.sort(srnos, comparator);
                String srno = String.join(";", srnos);
                e.setTotal(Double.valueOf(result.get("totalCost")));
                e.setHyno(result.get("freightno"));
                hkfw005Bean.update(e);
                //要求货运单和OA单据必须一一对应。
                if (!srno.equals(result.get("srnoList"))) {
                    e.setIsHighYellow(true);
                }
            }
            fileName = "HKFW005" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
            fileFullName = reportOutputPath + fileName;
            HSSFWorkbook wb = new HSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());

            CellStyle yellowSytle = wb.createCellStyle();
            yellowSytle.setBorderRight(CellStyle.BORDER_THIN);
            yellowSytle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            yellowSytle.setBorderLeft(CellStyle.BORDER_THIN);
            yellowSytle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            yellowSytle.setBorderTop(CellStyle.BORDER_THIN);
            yellowSytle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            yellowSytle.setBorderBottom(CellStyle.BORDER_THIN);
            yellowSytle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            yellowSytle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            yellowSytle.setFillPattern((short) 1);
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
            row.createCell(21).setCellValue("运输方式");
            int i = 1;
            for (HKFW005 e : entityList) {
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(e.getProcessSerialNumber());
                Short i1;
                i1 = cellStyle.getFillBackgroundColor();
                i1 = cellStyle.getFillForegroundColor();
                i1 = yellowSytle.getFillBackgroundColor();
                i1 = yellowSytle.getFillForegroundColor();
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(1);
                cell.setCellValue(BaseLib.formatDate("yyyy/MM/dd", e.getCreatedate()));
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }
                //cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
                cell = row.createCell(2);
                cell.setCellValue(e.getCusno() != null ? e.getCusno() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(3);
                cell.setCellValue(e.getCusna() != null ? e.getCusna() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(4);
                cell.setCellValue(e.getProcessInstance().getSubject());
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(5);
                cell.setCellValue(e.getRequireUser() != null ? e.getRequireUser().getUserName() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(6);
                cell.setCellValue(e.getRequireDept() != null ? e.getRequireDept().getOrganizationUnitName() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(7);
                cell.setCellValue(e.getApplyUser() != null ? e.getApplyUser().getUserName() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(8);
                cell.setCellValue(e.getApplyDept() != null ? e.getApplyDept().getOrganizationUnitName() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(9);
                cell.setCellValue(e.getSupportUser() != null ? e.getSupportUser().getUserName() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(10);
                cell.setCellValue(e.getSupportDept() != null ? e.getSupportDept().getOrganizationUnitName() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(11);
                cell.setCellValue(e.getMark() != null ? e.getMark() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(12);
                cell.setCellValue(e.getYfjs() != null ? e.getYfjsValue() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(13);
                cell.setCellValue(e.getShaddress() != null ? e.getShaddress() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(14);
                cell.setCellValue(e.getShpno() != null ? e.getShpno() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(15);
                cell.setCellValue(e.getLendno() != null ? e.getLendno() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(16);
                cell.setCellValue(e.getReturnno() != null ? e.getReturnno() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(17);
                cell.setCellValue(e.getShpdate() != null ? BaseLib.formatDate("yyyy/MM/dd", e.getShpdate()) : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(18);
                cell.setCellValue(e.getWlcompanyValue() != null ? e.getWlcompanyValue() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(19);
                cell.setCellValue(e.getHyno() != null ? e.getHyno() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }

                cell = row.createCell(20);
                cell.setCellValue(e.getTotal() != null ? String.valueOf(e.getTotal()) : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }
                cell = row.createCell(21);
                cell.setCellValue(e.getYsstyle() != null ? e.getYStyleValue() : "");
                if (e.getIsHighYellow()) {
                    cell.setCellStyle(yellowSytle);
                } else {
                    cell.setCellStyle(cellStyle);
                }
                i++;
            }
            for (int c = 0; c < 21; c++) {
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
        } catch (Exception e) {
            e.printStackTrace();
            log4j.error(e.getMessage());
        }
    }

    @Override
    public void reset() {
        super.reset();
        this.model.getFilterFields().put("type <>", "4");
    }

    public void handleFileUploadWhenNew(FileUploadEvent event) {
        UploadedFile file1 = event.getFile();
        Integer a = 0;
        InputStream inputStream = null;
        if (file1 != null) {
            try {
                inputStream = file1.getInputstream();
                upload(event);
                Workbook excel = WorkbookFactory.create(inputStream);
                Sheet sheet = excel.getSheetAt(0);
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    String processsNumber = row.getCell(0).getStringCellValue();
                    double total = Double.valueOf(cellToVlaue(row.getCell(20)));
                    HKFW005 hkfw005 = hkfw005Bean.findByPSN(processsNumber);
                    hkfw005.setTotal(total);
                    hkfw005Bean.update(hkfw005);
                }
                FacesContext.getCurrentInstance().addMessage((String) null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "修改成功"));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage((String) null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "上传失败"));
                ex.printStackTrace();
            } finally {
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
        InputStream input = null;
        UploadedFile file1 = event.getFile();
        try {
            input = file1.getInputstream();
            String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            int index = finalFilePath.indexOf("WEB-INF");
            String filePath = new String(finalFilePath.substring(1, index));
            StringBuffer pathString = new StringBuffer(filePath.concat("rpt/"));
            pathString.append(String.valueOf(new Date().getTime()));
            pathString.append(".xls");
            String path = pathString.substring(0, pathString.indexOf("Hanbell-EAP")).concat("FileUploadServer/resources").concat(String.valueOf(new Date().getTime()));
            StringBuffer url = new StringBuffer(pathString.substring(0, pathString.indexOf("Hanbell-EAP")));
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
        } finally {
            input.close();
            output.close();
        }
        return true;
    }

    public Map<String, String> findByTms(String srcno) throws Exception {
        CloseableHttpResponse response = null;
        try {
            String urlString = TMSURL + "/GetFreightInfoBySrno?srno=" + srcno;
            response = get(urlString, null, null);
            if (response != null) {
                HttpEntity httpEntity = response.getEntity();
                JSONObject jor;
                jor = new JSONObject(EntityUtils.toString(httpEntity, "UTF-8"));
                String message = jor.getString("Message");

                Map<String, String> result = new HashMap<String, String>();
                if ("查询成功".equals(message)) {
                    JSONObject data = jor.getJSONObject("Data");
                    result.put("freightno", data.getString("freightno"));
                    result.put("srnoList", data.getString("srnoList"));
                    result.put("totalCost", data.getString("totalCost"));
                    return result;
                } else {
                    return null;
                }
            }
            return null;
        } catch (ParseException | JSONException | IOException ex) {
            throw new Exception(ex);
        } finally {
            try {
                response.close();
            } catch (IOException ex) {
            }
        }
    }

    public CloseableHttpResponse get(String url, Map<String, String> params, RequestConfig config) {
        try {
            SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(new TrustSelfSignedStrategy()).build();
            HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
            SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(connectionFactory).build();
            URIBuilder builder = new URIBuilder(url);
            if (params != null) {
                Iterator var5 = params.keySet().iterator();
                while (var5.hasNext()) {
                    String k = (String) var5.next();
                    builder.addParameter(k, (String) params.get(k));
                }
            }
            URI uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);
            if (config != null) {
                httpGet.setConfig(config);
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                return response;
            }
        } catch (Exception var9) {
            return null;
        }
        return null;
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

    public Date getQueryCreateDateBegin() {
        return queryCreateDateBegin;
    }

    public void setQueryCreateDateBegin(Date queryCreateDateBegin) {
        this.queryCreateDateBegin = queryCreateDateBegin;
    }

    public Date getQueryCreateDateEnd() {
        return queryCreateDateEnd;
    }

    public void setQueryCreateDateEnd(Date queryCreateDateEnd) {
        this.queryCreateDateEnd = queryCreateDateEnd;
    }

    public String getQueryFormSerialNumber() {
        return queryFormSerialNumber;
    }

    public void setQueryFormSerialNumber(String queryFormSerialNumber) {
        this.queryFormSerialNumber = queryFormSerialNumber;
    }

    public String getQueryCustomer() {
        return queryCustomer;
    }

    public void setQueryCustomer(String queryCustomer) {
        this.queryCustomer = queryCustomer;
    }

}
