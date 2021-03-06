/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.ejb.InvclsBean;
import cn.hanbell.erp.ejb.InvhadBean;
import cn.hanbell.erp.ejb.InvhdscBean;
import cn.hanbell.erp.ejb.InvsysBean;
import cn.hanbell.erp.ejb.InvtrnBean;
import cn.hanbell.erp.ejb.InvtrnhBean;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.ejb.MisdeptBean;
import cn.hanbell.erp.ejb.PurvdrBean;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Invhad;
import cn.hanbell.erp.entity.Invhdsc;
import cn.hanbell.erp.entity.Invsys;
import cn.hanbell.erp.entity.Invtrnh;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.erp.entity.Misdept;
import cn.hanbell.erp.entity.Purvdr;
import cn.hanbell.rpt.lazy.InvtrnhModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author C2082
 */
@ManagedBean(name = "invtrnhManagedBean")
@javax.faces.bean.ViewScoped
public class InvtrnhManagedBean extends SuperQueryBean<Invtrnh> {

    @EJB
    private InvtrnhBean invtrnhBean;
    @EJB
    private MisdeptBean misdeptBean;
    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private InvhdscBean invhdscBean;
    @EJB
    private CdrcusBean cdrcusBean;
    @EJB
    private PurvdrBean purvdrBean;
    @EJB
    private InvsysBean invsysBean;
    @EJB
    private InvtrnBean invtrnBean;
    @EJB
    private InvclsBean invclsBean;
    @EJB
    private InvhadBean invhadBean;
    private String queryfacno;
    private String queryno;
    private String querytype;
    private String querywareh;
    private String querydept;
    private String queryuser;
    private String facnoView;
    private List<Object[]> list;

    public InvtrnhManagedBean() {
        super(Invtrnh.class);
    }

    @Override
    public void init() {
        this.queryfacno = "C";
        this.setSuperEJB(this.invtrnhBean);
        this.model = new InvtrnhModel(invtrnhBean);
        this.queryDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(queryDateEnd);
        cal.add(Calendar.MONTH, -1);
        this.queryDateBegin = cal.getTime();
        this.facnoView = invtrnhBean.getCompanyName(this.queryfacno);
        super.init();
    }

    @Override
    public void reset() {
        this.queryfacno = "C";
        this.queryDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(queryDateEnd);
        cal.add(Calendar.MONTH, -1);
        this.queryDateBegin = cal.getTime();
        this.queryno = "";
        this.querytype = "";
        this.querywareh = "";
        this.querydept = "";
        this.queryuser = "";
        this.facnoView = invtrnhBean.getCompanyName(this.queryfacno);
        invtrnhBean.setCompany("C");
        misdeptBean.setCompany("C");
        miscodeBean.setCompany("C");
        invhdscBean.setCompany("C");
        cdrcusBean.setCompany("C");
        invsysBean.setCompany("C");
        invtrnBean.setCompany("C");
        invclsBean.setCompany("C");
        invhadBean.setCompany("C");
        purvdrBean.setCompany("C");
    }

    @Override
    public void query() {
        try {
            this.facnoView = invtrnhBean.getCompanyName(this.queryfacno);
            invtrnhBean.setCompany(queryfacno);
            misdeptBean.setCompany(queryfacno);
            miscodeBean.setCompany(queryfacno);
            invhdscBean.setCompany(queryfacno);
            cdrcusBean.setCompany(queryfacno);
            invsysBean.setCompany(queryfacno);
            invtrnBean.setCompany(queryfacno);
            invclsBean.setCompany(queryfacno);
            invhadBean.setCompany(queryfacno);
            purvdrBean.setCompany(queryfacno);
            Invsys invsys = invsysBean.findByFacno(queryfacno);
            Date monDate = BaseLib.getDate("yyyyMM", invsys.getLmonth());
            Calendar c = Calendar.getInstance();
            c.setTime(monDate);
            c.add(Calendar.MONTH, 1);
            //查询结束的时间大于月结的一个月时间并且数据两个开始年月和结束年月不同。则分开查询合并。
            if (c.getTime().getTime() <= queryDateEnd.getTime() && queryDateBegin.getTime() < c.getTime().getTime()) {
                c.add(Calendar.DAY_OF_MONTH, -1);
                list = invtrnhBean.getInvtrnhByINV555(queryfacno, queryDateBegin, c.getTime(), changeVlaue(queryno), changeVlaue(querytype), changeVlaue(querywareh), changeVlaue(querydept), changeVlaue(queryuser));
                c.add(Calendar.DAY_OF_MONTH, 1);
                List<Object[]> o = invtrnBean.getInvtrnhByINV555(queryfacno, c.getTime(), queryDateEnd, changeVlaue(queryno), changeVlaue(querytype), changeVlaue(querywareh), changeVlaue(querydept), changeVlaue(queryuser));
                list.addAll(o);
            } else if (c.getTime().getTime() <= queryDateBegin.getTime() && c.getTime().getTime() <= queryDateEnd.getTime()) {
                list = invtrnBean.getInvtrnhByINV555(queryfacno, queryDateBegin, queryDateEnd, changeVlaue(queryno), changeVlaue(querytype), changeVlaue(querywareh), changeVlaue(querydept), changeVlaue(queryuser));
            } else {
                list = invtrnhBean.getInvtrnhByINV555(queryfacno, queryDateBegin, queryDateEnd, changeVlaue(queryno), changeVlaue(querytype), changeVlaue(querywareh), changeVlaue(querydept), changeVlaue(queryuser));
            }
        } catch (ParseException ex) {
            Logger.getLogger(InvtrnhManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void print() {
        InputStream is = null;
        try {
            try {
                String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                String pathString = new String(filePath.concat("rpt/"));
                File file = new File(pathString, "库存异动单模板.xlsx");
                is = new FileInputStream(file);
                this.fileName = this.facnoView + "INVTRNH" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xlsx";
                this.fileFullName = this.reportOutputPath + this.fileName;
                Workbook wb = WorkbookFactory.create(is);
                CellStyle cellStyle = wb.createCellStyle();
                short border = 1;
                cellStyle.setBorderBottom(border);
                cellStyle.setBorderLeft(border);
                cellStyle.setBorderRight(border);
                cellStyle.setBorderTop(border);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(0);
                wb.setSheetName(0, this.facnoView + sdf.format(new Date()) + "库存异动单");
                Row row = null;
                int i = 1;
                //打印单头档
                for (Object[] h : list) {
                    row = sheet.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(i);
                    Cell cell1 = row.createCell(1);
                    Cell cell2 = row.createCell(2);
                    Cell cell3 = row.createCell(3);
                    Cell cell4 = row.createCell(4);
                    Cell cell5 = row.createCell(5);
                    Cell cell6 = row.createCell(6);
                    Cell cell7 = row.createCell(7);
                    Cell cell8 = row.createCell(8);
                    Cell cell9 = row.createCell(9);
                    Cell cell10 = row.createCell(10);
                    Cell cell11 = row.createCell(11);
                    Cell cell12 = row.createCell(12);
                    Cell cell13 = row.createCell(13);
                    Cell cell14 = row.createCell(14);
                    Cell cell15 = row.createCell(15);
                    Cell cell16 = row.createCell(16);
                    Cell cell17 = row.createCell(17);
                    Cell cell18 = row.createCell(18);
                    Cell cell19 = row.createCell(19);
                    Cell cell20 = row.createCell(20);
                    Cell cell21 = row.createCell(21);
                    Cell cell22 = row.createCell(22);
                    Cell cell23 = row.createCell(23);
                    Cell cell24 = row.createCell(24);
                    Cell cell25 = row.createCell(25);
                    Cell cell26 = row.createCell(26);
                    cell.setCellStyle(cellStyle);
                    cell1.setCellStyle(cellStyle);
                    cell2.setCellStyle(cellStyle);
                    cell3.setCellStyle(cellStyle);
                    cell4.setCellStyle(cellStyle);
                    cell5.setCellStyle(cellStyle);
                    cell6.setCellStyle(cellStyle);
                    cell7.setCellStyle(cellStyle);
                    cell8.setCellStyle(cellStyle);
                    cell9.setCellStyle(cellStyle);
                    cell10.setCellStyle(cellStyle);
                    cell11.setCellStyle(cellStyle);
                    cell12.setCellStyle(cellStyle);
                    cell13.setCellStyle(cellStyle);
                    cell14.setCellStyle(cellStyle);
                    cell15.setCellStyle(cellStyle);
                    cell16.setCellStyle(cellStyle);
                    cell17.setCellStyle(cellStyle);
                    cell18.setCellStyle(cellStyle);
                    cell19.setCellStyle(cellStyle);
                    cell20.setCellStyle(cellStyle);
                    cell21.setCellStyle(cellStyle);
                    cell22.setCellStyle(cellStyle);
                    cell23.setCellStyle(cellStyle);
                    cell24.setCellStyle(cellStyle);
                    cell25.setCellStyle(cellStyle);
                    cell26.setCellStyle(cellStyle);
                    cell1.setCellValue(h[6] != null ? BaseLib.formatDate("yyyy/MM/dd", (Date) h[6]) : "");
                    cell2.setCellValue(h[0] != null ? (String) h[0] : "");
                    cell3.setCellValue(h[1] != null ? (String) h[1] : "");
                    cell4.setCellValue(h[2] != null ? (String) h[2] : "");
                    cell5.setCellValue(h[3] != null ? (String) h[3] : "");
                    cell6.setCellValue(h[4] != null ? (String) h[4] : "");
                    //部门代号
                    if ("GE".equals((String) h[24])) {
                        Misdept m = misdeptBean.findByDepno((String) h[4]);

                        cell7.setCellValue(m != null ? m.getDepname() : "");

                    } else if ("PJ".equals((String) h[24])) {
                        //厂商代号
                        Purvdr purvdr = purvdrBean.findByVdrno((String) h[4]);

                        cell7.setCellValue(purvdr != null ? purvdr.getVdrna() : "");

                    } else if ("CA".equals((String) h[24])) {
                        //客户代号
                        Cdrcus cdrcus = cdrcusBean.findByCusno((String) h[4]);
                        cell7.setCellValue(cdrcus != null ? cdrcus.getCusna() : "");

                    }
                    cell8.setCellValue(h[5] != null ? (String) h[5] : "");
                    cell9.setCellValue(String.valueOf((int) h[7]));
                    cell10.setCellValue(h[8] != null ? (String) h[8] : "");
                    cell11.setCellValue(h[9] != null ? (String) h[9] : "");
                    cell12.setCellValue(h[10] != null ? (String) h[10] : "");
                    cell13.setCellValue(h[11] != null ? (String) h[11] : "");
                    cell14.setCellValue(h[12] != null ? invclsBean.getItclscode((String) h[12]) : "");
                    cell15.setCellValue(h[13] != null ? (String) h[13] : "");
                    cell16.setCellValue(h[14] != null ? (String) h[14] : "");
                    cell17.setCellValue(h[15] != null ? String.valueOf((java.math.BigDecimal) h[15]) : "");
                    cell18.setCellValue(h[16] != null ? (String) h[16] : "");
                    cell19.setCellValue(h[17] != null ? String.valueOf((java.math.BigDecimal) h[17]) : "");
                    cell20.setCellValue(h[18] != null ? (String) h[18] : "");
                    cell21.setCellValue(h[19] != null ? getIocodeValue((String) h[19]) : "");
                    Invhdsc invdsc = invhdscBean.findByFacnoAndPronoAndTrno((String) h[2], (String) h[3], (String) h[5]);
                    StringBuffer invdscBuffer = new StringBuffer(";;");
                    if (h[22] != null && "研发专案".equals((String) (h[22]))) {
                        List<Invhad> entity = invhadBean.getInvtrnhByFacnoAndPronoAndTrnoAndTrtype((String) h[2], (String) h[3], (String) h[5], (String) h[0]);
                        if (entity != null && !entity.isEmpty()) {
                            invdscBuffer.append(entity.get(0).getHmark1()).append(";;");
                        }
                    }

                    if (invdsc != null) {
                        if (invdsc.getMark1() != null && !"".equals(invdsc.getMark1())) {
                            invdscBuffer.append(invdsc.getMark1()).append(";");
                        }
                        if (invdsc.getMark2() != null && !"".equals(invdsc.getMark2())) {
                            invdscBuffer.append(invdsc.getMark2()).append(";");
                        }
                        if (invdsc.getMark3() != null && !"".equals(invdsc.getMark3())) {
                            invdscBuffer.append(invdsc.getMark3()).append(";");
                        }
                        if (invdsc.getMark4() != null && !"".equals(invdsc.getMark4())) {
                            invdscBuffer.append(invdsc.getMark4()).append(";");
                        }
                        invdscBuffer.append(";;");
                        cell22.setCellValue(invdscBuffer.toString());
                    }
                    Miscode miscode = miscodeBean.findByPK((String) h[20], (String) h[21]);
                    cell23.setCellValue(h[20] != null ? (String) (h[20]) : "");
                    cell24.setCellValue(miscode != null ? miscode.getCusds() : "");
                    //项目
                    if ("IAA".equals(String.valueOf(h[0])) || "IAB".equals(String.valueOf(h[0]))) {
                        Miscode project = miscodeBean.findByPK("91", h[23] != null ? String.valueOf(h[23]) : "");
                        if (project != null) {
                            cell25.setCellValue(h[23] != null ? String.valueOf(h[23]) : "");
                            cell26.setCellValue(project != null && h[23] != null ? project.getCdesc() : "");
                        }
                    }
                    i++;
                }
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream(this.fileFullName);
                    wb.write(os);
                    this.reportViewPath = this.reportViewContext + this.fileName;
                    this.preview();
                } catch (Exception var38) {
                    this.log4j.error(var38);
                } finally {
                    try {
                        if (null != os) {
                            os.flush();
                            os.close();
                        }
                    } catch (IOException var37) {
                        this.log4j.error(var37.getMessage());
                    }
                }
            } catch (FileNotFoundException var40) {
                this.log4j.error(var40.getMessage());
                var40.printStackTrace();
            } catch (IOException var41) {
                this.log4j.error(var41.getMessage());
                var41.printStackTrace();
            } catch (Exception var42) {
                var42.printStackTrace();
                this.log4j.error(var42.getMessage());
            }
        } finally {

        }
    }

    public List<Object[]> getList() {
        return list;
    }

    public void setList(List<Object[]> list) {
        this.list = list;
    }

    public String getQueryfacno() {
        return queryfacno;
    }

    public void setQueryfacno(String queryfacno) {
        this.queryfacno = queryfacno;
    }

    public String getQueryno() {
        return queryno;
    }

    public void setQueryno(String queryno) {
        this.queryno = queryno;
    }

    public String getQuerytype() {
        return querytype;
    }

    public void setQuerytype(String querytype) {
        this.querytype = querytype;
    }

    public String getQuerywareh() {
        return querywareh;
    }

    public void setQuerywareh(String querywareh) {
        this.querywareh = querywareh;
    }

    public String getQuerydept() {
        return querydept;
    }

    public void setQuerydept(String querydept) {
        this.querydept = querydept;
    }

    public String getQueryuser() {
        return queryuser;
    }

    public void setQueryuser(String queryuser) {
        this.queryuser = queryuser;
    }

    public String getFacnoView() {
        return facnoView;
    }

    public void setFacnoView(String facnoView) {
        this.facnoView = facnoView;
    }

    public String changeVlaue(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        String[] nos = s.split(",");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nos.length; i++) {
            sb.append("'").append(nos[i]).append("',");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String getIocodeValue(String ioccode) {
        switch (ioccode) {
            case "0":
                return "期初";
            case "1":
                return "入库";
            case "2":
                return "出库";
            case "3":
                return "调拨";
            case "Z":
                return "期末";
        }
        return "";
    }

}
