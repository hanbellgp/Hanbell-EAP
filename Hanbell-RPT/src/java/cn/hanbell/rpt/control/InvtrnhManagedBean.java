/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.ejb.InvhdscBean;
import cn.hanbell.erp.ejb.InvtrnhBean;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.ejb.MisdeptBean;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Invhdsc;
import cn.hanbell.erp.entity.Invtrnh;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.erp.entity.Misdept;
import cn.hanbell.rpt.lazy.InvtrnhModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    private String queryfacno;
    private String queryno;
    private String querytype;
    private String querywareh;
    private String querydept;
    private String queryuser;
    private String facnoView;
    private List<Invtrnh> list;

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
    }

    @Override
    public void query() {
        this.facnoView = invtrnhBean.getCompanyName(this.queryfacno);
        invtrnhBean.setCompany(queryfacno);
        misdeptBean.setCompany(queryfacno);
        miscodeBean.setCompany(queryfacno);
        invhdscBean.setCompany(queryfacno);
        cdrcusBean.setCompany(queryfacno);
        list = invtrnhBean.getInvtrnhByINV555(queryfacno, queryDateBegin, queryDateEnd, changeVlaue(queryno), changeVlaue(querytype), changeVlaue(querywareh), changeVlaue(querydept), changeVlaue(queryuser));
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
                for (Invtrnh h : list) {
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
                    cell1.setCellValue(h.getTrdate() != null ? BaseLib.formatDate("yyyy/MM/dd", h.getTrdate()) : "");
                    cell2.setCellValue(h.getInvdou() != null ? h.getInvdou().getTrtype() : "");
                    cell3.setCellValue(h.getInvdou() != null ? h.getInvdou().getTypedsc() : "");
                    cell4.setCellValue(h.getInvtrnhPK().getFacno() != null ? h.getInvtrnhPK().getFacno() : "");
                    cell5.setCellValue(h.getInvtrnhPK().getProno() != null ? h.getInvtrnhPK().getProno() : "");
                    cell6.setCellValue(h.getDepno() != null ? h.getDepno() : "");
                    Misdept m = misdeptBean.findByDepno(h.getDepno());
                    if (m == null) {
                        Cdrcus cdrcus = cdrcusBean.findByCusno(h.getDepno());
                        cell7.setCellValue(cdrcus != null ? cdrcus.getCusna() : "");
                    } else {
                        cell7.setCellValue(m != null ? m.getDepname() : "");
                    }
                    cell8.setCellValue(h.getInvtrnhPK().getTrno() != null ? h.getInvtrnhPK().getTrno() : "");
                    cell9.setCellValue(String.valueOf(h.getInvtrnhPK().getTrseq()));
                    cell10.setCellValue(h.getItnbr() != null ? h.getItnbr() : "");
                    cell11.setCellValue(h.getInvmas() != null ? h.getInvmas().getItdsc() : "");
                    cell12.setCellValue(h.getInvmas() != null && h.getInvmas().getInvcls() != null ? h.getInvmas().getInvcls().getItcls() : "");
                    cell13.setCellValue(h.getInvmas() != null && h.getInvmas().getInvcls() != null ? h.getInvmas().getInvcls().getClsdsc() : "");
                    cell14.setCellValue(h.getWareh() != null ? h.getWareh() : "");
                    cell15.setCellValue(h.getInvwh() != null ? h.getInvwh().getWhdsc() : "");
                    cell16.setCellValue(h.getTrnqy1() != null ? String.valueOf(h.getTrnqy1()) : "");
                    cell17.setCellValue(h.getUnmsr1() != null ? String.valueOf(h.getUnmsr1()) : "");
                    cell18.setCellValue(h.getTramt() != null ? String.valueOf(h.getTramt()) : "");
                    cell19.setCellValue(h.getUserno() != null ? h.getUserno() : "");
                    cell20.setCellValue(h.getIocode() != null ? h.getIocodeValue(h.getIocode()) : "");
                    Invhdsc invdsc = invhdscBean.findByFacnoAndPronoAndTrno(h.getInvtrnhPK().getFacno(), h.getInvtrnhPK().getProno(), h.getInvtrnhPK().getTrno());
                    StringBuffer invdscBuffer = new StringBuffer(";;");
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
                        cell21.setCellValue(invdscBuffer.toString());
                    }
                    Miscode miscode = miscodeBean.findByPK("IK", h.getRescode());
                    cell22.setCellValue(h.getRescode() != null ? "IK" : "");
                    cell23.setCellValue(miscode != null ? miscode.getCusds() : "");
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

    public List<Invtrnh> getList() {
        return list;
    }

    public void setList(List<Invtrnh> list) {
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

}
