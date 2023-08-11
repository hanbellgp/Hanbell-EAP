/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.HK001Bean;
import cn.hanbell.oa.ejb.ProcessInstanceBean;
import cn.hanbell.oa.entity.HK001;
import cn.hanbell.oa.entity.HKFW005;
import cn.hanbell.oa.entity.HKFW005Detail;
import cn.hanbell.rpt.lazy.HK001Model;
import cn.hanbell.rpt.lazy.HKFW005DetailModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author C2082
 */
@ManagedBean(name = "hk001ManagedBean")
@javax.faces.bean.ViewScoped
public class HK001ManagedBean extends SuperQueryBean<HK001> {

    private String queryUserid;
    private String queryUserName;
    private String queryDeptNo;
    private String queryDeptName;
    private String queryType1;
    private String queryType2;
    private String queryType3;
    @EJB
    private HK001Bean hk001Bean;
    @EJB
    private ProcessInstanceBean processInstanceBean;

    public HK001ManagedBean() {
        super(HK001.class);
    }

    @Override
    public void init() {
        setSuperEJB(hk001Bean);
        this.model = new HK001Model(hk001Bean);
        super.init();
        Calendar c = Calendar.getInstance();
        c.setTime(BaseLib.getDate());
        c.add(Calendar.MONTH, -1);
        this.setQueryDateBegin(c.getTime());
        this.setQueryDateEnd(BaseLib.getDate());
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryUserid != null && !"".equals(queryUserid)) {
                this.model.getFilterFields().put("applyUser.id", queryUserid);
            }
            if (queryUserName != null && !"".equals(queryUserName)) {
                this.model.getFilterFields().put("applyUser.userName", queryUserName);
            }
            if (queryDeptNo != null && !"".equals(queryDeptNo)) {
                this.model.getFilterFields().put("applyDept.id", queryDeptNo);
            }
            if (queryDeptName != null && !"".equals(queryDeptName)) {
                this.model.getFilterFields().put("applyDept.organizationUnitName", queryDeptName);
            }
            if (queryType1 != null && !"All".equals(queryType1)) {
                this.model.getFilterFields().put("type1", queryType1);
            }
            if (queryType2 != null && !"All".equals(queryType2)) {
                this.model.getFilterFields().put("type2", queryType2);
            }
            if (queryType3 != null && !"All".equals(queryType3)) {
                this.model.getFilterFields().put("type3", queryType3);
            }
            if (queryDateBegin != null && !"".equals(queryDateBegin)) {
                this.model.getFilterFields().put("applyDateBegin", queryDateBegin);
            }
            if (queryDateEnd != null && !"".equals(queryDateEnd)) {
                this.model.getFilterFields().put("applyDateEnd", queryDateEnd);
            }
        }
    }

    @Override
    public void reset() {
        queryUserid = "";
        queryUserName = "";
        queryDeptNo = "";
        queryDeptName = "";
        queryType1 = "All";
        queryType2 = "All";
        queryType3 = "All";
        Calendar c = Calendar.getInstance();
        c.setTime(BaseLib.getDate());
        c.add(Calendar.MONTH, -1);
        this.setQueryDateBegin(c.getTime());
        this.setQueryDateEnd(BaseLib.getDate());
    }

    @Override
    public void print() {
        entityList = hk001Bean.findByFilters(this.model.getFilterFields(), this.model.getSortFields());
        if (entityList == null || entityList.isEmpty()) {
            return;
        }
        fileName = "HK001" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
        fileFullName = reportOutputPath + fileName;
        HSSFWorkbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        short border = 1;
        cellStyle.setBorderBottom(border);
        cellStyle.setBorderLeft(border);
        cellStyle.setBorderRight(border);
        cellStyle.setBorderTop(border);
        //创建内容
        Sheet sheet = wb.createSheet("HK00驻厂需求明细");
        Cell cell;
        Row row;
        row = sheet.createRow(0);

        cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("流程序号");
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("流程状态");
        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("公司别");
        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("申请人");
        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("申请部门");
        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("申请日期");
        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("职等");
        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("岗位");
        cell = row.createCell(8);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("户籍所在地");
        cell = row.createCell(9);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("申请理由说明");
        cell = row.createCell(10);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("驻厂");
        cell = row.createCell(11);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("驻点");
        cell = row.createCell(12);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("租房");
        cell = row.createCell(13);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("驻外日期");
        cell = row.createCell(14);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("驻厂/驻点地址");
        cell = row.createCell(15);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("客户服务名称");
        cell = row.createCell(16);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("客户服务地址");
        cell = row.createCell(17);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("机器保内时间");
        cell = row.createCell(18);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("租房日期");
        cell = row.createCell(19);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("租房付款方式");
        cell = row.createCell(20);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("居住人数");
        cell = row.createCell(21);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("同住人姓名");
        cell = row.createCell(22);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("年租房价格");
        cell = row.createCell(23);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("合约签订主体");
        cell = row.createCell(24);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("月租房价格");
        cell = row.createCell(25);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("合约签订日期");
//  cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
        int i = 1;
        for (HK001 e : entityList) {
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getProcessSerialNumber().getSerialNumber());
            cell = row.createCell(1);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(this.processInstanceBean.getCurrentStateValue(e.getProcessSerialNumber().getCurrentState()));
            cell = row.createCell(2);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getFacno());
            cell = row.createCell(3);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(String.format("%s %s", e.getApplyUser().getId(), e.getApplyUser().getUserName()));
            cell = row.createCell(4);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(String.format("%s %s", e.getApplyDept().getId(), e.getApplyDept().getOrganizationUnitName()));
            cell = row.createCell(5);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(BaseLib.formatDate("yyyy/MM/dd", e.getApplyDate()));
            cell = row.createCell(6);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getUserTitle());
            cell = row.createCell(7);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getUserPost());
            cell = row.createCell(8);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getDomicile());
            cell = row.createCell(9);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getApplyReason());
            cell = row.createCell(10);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getType1Value());
            cell = row.createCell(11);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getType2Value());
            cell = row.createCell(12);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getType3Value());
            cell = row.createCell(13);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(String.format("%s~%s", BaseLib.formatDate("yyyy/MM/dd", e.getStartDate1()), BaseLib.formatDate("yyyy/MM/dd", e.getEndDate1())));
            cell = row.createCell(14);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getAddress1());
            cell = row.createCell(15);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getCustomerName());
            cell = row.createCell(16);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getCustomerAddress());
            cell = row.createCell(17);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(String.format("%s~%s", BaseLib.formatDate("yyyy/MM/dd", e.getStartDate2()), BaseLib.formatDate("yyyy/MM/dd", e.getEndDate2())));
            cell = row.createCell(18);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(String.format("%s~%s", BaseLib.formatDate("yyyy/MM/dd", e.getStartDate3()), BaseLib.formatDate("yyyy/MM/dd", e.getEndDate3())));
            cell = row.createCell(19);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getPayWayValue());
            cell = row.createCell(20);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getResidents());
            cell = row.createCell(21);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getOtherPerson());
            cell = row.createCell(22);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(String.format("%s元/年，押金%s元", e.getYearPay(), e.getYearDeposit()));
  //cell.setCellValue( e.getYearPay()!=null && !"".equals( e.getYearPay()) && e.getYearDeposit()!=null && !"".equals( e.getYearDeposit()) ? String.format("%s元/年，押金%s元", e.getYearPay(), e.getYearDeposit()) :"");
            cell = row.createCell(23);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(e.getContracStigningValue());
            cell = row.createCell(24);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(String.format("%s元/年，押金%s元", e.getMonthPay(), e.getMonthDeposit()));
            cell = row.createCell(25);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(BaseLib.formatDate("yyyy/MM/dd", e.getContractDate()));
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

    public ProcessInstanceBean getProcessInstanceBean() {
        return processInstanceBean;
    }

    public void setProcessInstanceBean(ProcessInstanceBean processInstanceBean) {
        this.processInstanceBean = processInstanceBean;
    }

    
    public String getQueryUserid() {
        return queryUserid;
    }

    public void setQueryUserid(String queryUserid) {
        this.queryUserid = queryUserid;
    }

    public String getQueryUserName() {
        return queryUserName;
    }

    public void setQueryUserName(String queryUserName) {
        this.queryUserName = queryUserName;
    }

    public String getQueryDeptNo() {
        return queryDeptNo;
    }

    public void setQueryDeptNo(String queryDeptNo) {
        this.queryDeptNo = queryDeptNo;
    }

    public String getQueryDeptName() {
        return queryDeptName;
    }

    public void setQueryDeptName(String queryDeptName) {
        this.queryDeptName = queryDeptName;
    }

    public String getQueryType1() {
        return queryType1;
    }

    public void setQueryType1(String queryType1) {
        this.queryType1 = queryType1;
    }

    public String getQueryType2() {
        return queryType2;
    }

    public void setQueryType2(String queryType2) {
        this.queryType2 = queryType2;
    }

    public String getQueryType3() {
        return queryType3;
    }

    public void setQueryType3(String queryType3) {
        this.queryType3 = queryType3;
    }

}
