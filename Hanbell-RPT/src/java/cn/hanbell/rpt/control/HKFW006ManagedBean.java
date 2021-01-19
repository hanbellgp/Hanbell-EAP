/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.entity.HKFW006;
import cn.hanbell.oa.model.HKFW006StatisticModel;
import cn.hanbell.rpt.lazy.HKFW006Model;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author C2082
 */
@ManagedBean(name = "hkfw006ManagedQueryBean")
@javax.faces.bean.ViewScoped
public class HKFW006ManagedBean extends SuperQueryBean<HKFW006> {

    @EJB
    private HKFW006Bean hkfw006Bean;
    private String queryCompany;
    private String selectView;
    private String queryCustomer;
    private String queryService;
    private String queryUser;
    private String queryDept;
    private String queryProduct;
    private String quertType;
    private String queryStatus;
    private String queryNumber;
    private Date queryDateBegin;
    private Date queryDateEnd;
    private boolean statisticView;
    private boolean detailView;
    private String queryYear;
    private List<HKFW006StatisticModel> hkfw006Model;

    public HKFW006ManagedBean() {
        super(HKFW006.class);
    }

    @Override
    public void init() {
        detailView=true;
        statisticView=false;
        setSuperEJB(hkfw006Bean);
        this.model = new HKFW006Model(hkfw006Bean);
        this.selectView = "明细表";
        this.queryStatus="All";
        super.init();
        this.hkfw006Model=new ArrayList();
         Calendar cal = Calendar.getInstance();
         queryYear=String.valueOf(cal.get(Calendar.YEAR));
         this.model.getFilterFields().put("rettype", "2");
        initHkfw006Model();
    }

    @Override
    public void print() {
        entityList = hkfw006Bean.findByFilters(model.getFilterFields(), model.getSortFields());
        InputStream is = null;
        try {
            try {
                String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                String pathString = new String(filePath.concat("rpt/"));
                File file = new File(pathString, "退货通知单模板.xlsx");
                is = new FileInputStream(file);
                this.fileName = "HKFW006" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xlsx";
                this.fileFullName = this.reportOutputPath + this.fileName;
                Workbook wb = WorkbookFactory.create(is);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(0);
                wb.setSheetName(0, sdf.format(new Date()) + "退货通知单明细表");
                Row row = null;
                int i = 1;
                for (Iterator var12 = this.entityList.iterator(); var12.hasNext(); ++i) {
                    HKFW006 e = (HKFW006) var12.next();
                    row = sheet.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(i);
                    row.createCell(1).setCellValue(e.getFacno() != null ? e.getCompanyValue(e.getFacno()) : "");
                    row.createCell(2).setCellValue(e.getCptype() != null ? e.getCpTypeValue(e.getCptype()) : "");
                    row.createCell(3).setCellValue(e.getSupportUser() != null ? e.getSupportUser().getId() : "");
                    row.createCell(4).setCellValue(e.getSupportUser() != null ? e.getSupportUser().getUserName() : "");
                    row.createCell(5).setCellValue(e.getSupportDept() != null ? e.getSupportDept().getId() : "");
                    row.createCell(6).setCellValue(e.getSupportDept() != null ? e.getSupportDept().getOrganizationUnitName() : "");
                    row.createCell(7).setCellValue(e.getCusno() != null ? e.getCusno() : "");
                    row.createCell(8).setCellValue(e.getCusna() != null ? e.getCusna() : "");
                    row.createCell(9).setCellValue(e.getReturndate() != null ? BaseLib.formatDate("yyyy/MM/dd", e.getReturndate()) : "");
                     row.createCell(10).setCellValue(e.getCreatedate()!= null ? BaseLib.formatDate("yyyy/MM/dd", e.getCreatedate()) : "");
                    row.createCell(11).setCellValue(e.getReturntype() != null ? e.getReturnTypeVlaue(e.getReturntype()) : "");
                    row.createCell(12).setCellValue(e.getKfno() != null ? e.getKfno() : "");
                    row.createCell(13).setCellValue(e.getFwno() != null ? e.getFwno() : "");
                    row.createCell(14).setCellValue(e.getTitnbr() != null ? e.getTitnbr() : "");
                    row.createCell(15).setCellValue(e.getTitdsc() != null ? e.getTitdsc() : "");
                    row.createCell(16).setCellValue(e.getTcreateno() != null ? e.getTcreateno() : "");
                    row.createCell(17).setCellValue(e.getGzreason() != null ? e.getGzreasonValue(e.getGzreason()) : "");
                    row.createCell(18).setCellValue(e.getZbpzno() != null && e.getFgspzno() != null ? e.inWrehValue(e.getZbpzno(), e.getFgspzno()) : "");
                    row.createCell(19).setCellValue(e.getYf() != null ? String.valueOf(e.getYf()) : "");
                    row.createCell(20).setCellValue(e.getProcessInstance() != null ? e.getOAStatus(e.getProcessInstance().getCurrentState()) : "");
                }
                 Sheet sheet1 = wb.getSheetAt(1);
                   wb.setSheetName(1, sdf.format(new Date()) + "退货通知单统计表");
//                 List<HKFW006StatisticModel> hkfw006Model;
                    i=1;
                for(HKFW006StatisticModel m:hkfw006Model){
                    row = sheet1.getRow(i);
                    row.getCell(2).setCellValue(m.getMonth1());
                    row.getCell(3).setCellValue(m.getMonth2());
                    row.getCell(4).setCellValue(m.getMonth3());
                    row.getCell(5).setCellValue(m.getMonth4());
                    row.getCell(6).setCellValue(m.getMonth5());
                    row.getCell(7).setCellValue(m.getMonth6());
                    row.getCell(8).setCellValue(m.getMonth7());
                    row.getCell(9).setCellValue(m.getMonth8());
                    row.getCell(10).setCellValue(m.getMonth9());
                    row.getCell(11).setCellValue(m.getMonth10());
                    row.getCell(12).setCellValue(m.getMonth11());
                    row.getCell(13).setCellValue(m.getMonth12());
                    row.getCell(14).setCellValue(m.getSum()); 
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
            } catch (IOException var41) {
                this.log4j.error(var41.getMessage());
            } catch (Exception var42) {
                var42.printStackTrace();
                this.log4j.error(var42.getMessage());
            }
        } finally {

        }
    }

    @Override
    public void query() {
        initHkfw006Model();
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            this.model.getFilterFields().put("rettype", "2");
            if (queryCompany != null && !"".equals(queryCompany)) {
                this.model.getFilterFields().put("facno", queryCompany);
            }
            if (queryCustomer != null && !"".equals(queryCustomer)) {
                this.model.getFilterFields().put("kfno", queryCustomer);
            }
            if (queryService != null && !"".equals(queryService)) {
                this.model.getFilterFields().put("fwno", queryService);
            }
            if (queryUser != null && !"".equals(queryUser)) {
                this.model.getFilterFields().put("supportUser.userName", queryUser);
            }
            if (queryDept != null && !"".equals(queryDept)) {
                this.model.getFilterFields().put("supportDept.organizationUnitName", queryDept);
            }
            if (queryProduct != null && !"".equals(queryProduct)) {
                this.model.getFilterFields().put("cptype", queryProduct);
            }
            if (quertType != null && !"".equals(quertType)) {
                this.model.getFilterFields().put("returntype", quertType);
            }
            if (queryStatus != null && !"All".equals(queryStatus)) {
                if ("Y".equals(queryStatus)) {
                    this.model.getFilterFields().put("processInstance.currentState =", 3);
                } else if ("X".equals(queryStatus)) {
                    this.model.getFilterFields().put("processInstance.currentState <=", 2);
                }
            }
            if (queryDateBegin != null && !"".equals(queryDateBegin)) {
                this.model.getFilterFields().put("returndateBegin", queryDateBegin);
            }
            if (queryDateEnd != null && !"".equals(queryDateEnd)) {
                this.model.getFilterFields().put("returndateEnd", queryDateEnd);
            }
        }
    }

    public void reset() {
         this.queryCompany="";
         this.queryCustomer="";
         this.queryService="";
         this.queryUser="";
         this.queryDept="";
         this.queryProduct="";
         this.quertType="";
         this.queryStatus="All";
         queryDateBegin=null;
          Calendar cal = Calendar.getInstance();
         queryYear=String.valueOf(cal.get(Calendar.YEAR));
         queryDateEnd=null;
    }

    public String getQueryCompany() {
        return queryCompany;
    }

    public void setQueryCompany(String queryCompany) {
        this.queryCompany = queryCompany;
    }

    public String getSelectView() {
        return selectView;
    }

    public void setSelectView(String selectView) {
        this.selectView = selectView;
        if("统计表".equals(this.selectView)){
            this.detailView=false;
            this.statisticView=true;
        }else if("明细表".equals(this.selectView)){
            this.detailView=true;
            this.statisticView=false;
        }
    }

    public String getQueryCustomer() {
        return queryCustomer;
    }

    public void setQueryCustomer(String queryCustomer) {
        this.queryCustomer = queryCustomer;
    }

    public String getQueryService() {
        return queryService;
    }

    public void setQueryService(String queryService) {
        this.queryService = queryService;
    }

    public String getQueryUser() {
        return queryUser;
    }

    public void setQueryUser(String queryUser) {
        this.queryUser = queryUser;
    }

    public String getQueryDept() {
        return queryDept;
    }

    public void setQueryDept(String queryDept) {
        this.queryDept = queryDept;
    }

    public String getQueryProduct() {
        return queryProduct;
    }

    public void setQueryProduct(String queryProduct) {
        this.queryProduct = queryProduct;
    }

    public String getQuertType() {
        return quertType;
    }

    public void setQuertType(String quertType) {
        this.quertType = quertType;
    }

    public String getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(String queryStatus) {
        this.queryStatus = queryStatus;
    }

    public String getQueryNumber() {
        return queryNumber;
    }

    public void setQueryNumber(String queryNumber) {
        this.queryNumber = queryNumber;
    }

    public Date getQueryDateBegin() {
        return queryDateBegin;
    }

    public void setQueryDateBegin(Date queryDateBegin) {
        this.queryDateBegin = queryDateBegin;
    }

    public Date getQueryDateEnd() {
        return queryDateEnd;
    }

    public void setQueryDateEnd(Date queryDateEnd) {
        this.queryDateEnd = queryDateEnd;
    }

    public List<HKFW006StatisticModel> getHkfw006Model() {
        return hkfw006Model;
    }

    public void setHkfw006Model(List<HKFW006StatisticModel> hkfw006Model) {
        this.hkfw006Model = hkfw006Model;
    }

    public void updateSelectView(ValueChangeEvent evt){
    }

    public boolean isStatisticView() {
        return statisticView;
    }

    public void setStatisticView(boolean statisticView) {
        this.statisticView = statisticView;
    }

    public boolean isDetailView() {
        return detailView;
    }

    public void setDetailView(boolean detailView) {
        this.detailView = detailView;
    }

    public String getQueryYear() {
        return queryYear;
    }

    public void setQueryYear(String queryYear) {
        this.queryYear = queryYear;
    }
    
    
   
    public void initHkfw006Model() { 
         hkfw006Model.clear();
        HKFW006StatisticModel h1=hkfw006Bean.BPMStatisticReport("%1B%", "华东本部", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h2=hkfw006Bean.BPMStatisticReport("%1B%", "华东本部", "2", "汉钟财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h1);
        hkfw006Model.add(h2);
        hkfw006Model.add(new HKFW006StatisticModel("华东本部","合计",h1.getMonth1()+h2.getMonth1(),h1.getMonth2()+h2.getMonth2(),h1.getMonth3()+h2.getMonth3(),h1.getMonth4()+h2.getMonth4(),
        h1.getMonth5()+h2.getMonth5(),h1.getMonth6()+h2.getMonth6(),h1.getMonth7()+h2.getMonth7(),h1.getMonth8()+h2.getMonth8(),h1.getMonth9()+h2.getMonth9(),h1.getMonth10()+h2.getMonth10(),
        h1.getMonth11()+h2.getMonth11(),h1.getMonth12()+h2.getMonth12(),h1.getSum()+h2.getSum()));
        
        HKFW006StatisticModel h3=hkfw006Bean.BPMStatisticReport("%1C%", "济南分公司", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h4=hkfw006Bean.BPMStatisticReport("%1C%", "济南分公司", "2", "汉钟财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h3);
        hkfw006Model.add(h4);
        hkfw006Model.add(new HKFW006StatisticModel("济南分公司","合计",h3.getMonth1()+h4.getMonth1(),h3.getMonth2()+h4.getMonth2(),h3.getMonth3()+h4.getMonth3(),h3.getMonth4()+h4.getMonth4(),
        h3.getMonth5()+h4.getMonth5(),h3.getMonth6()+h4.getMonth6(),h3.getMonth7()+h4.getMonth7(),h3.getMonth8()+h4.getMonth8(),h3.getMonth9()+h4.getMonth9(),h3.getMonth10()+h4.getMonth10(),
        h3.getMonth11()+h3.getMonth11(),h3.getMonth12()+h3.getMonth12(),h3.getSum()+h4.getSum()));
        
        
        HKFW006StatisticModel h5=hkfw006Bean.BPMStatisticReport("%1D%", "广州分公司", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h6=hkfw006Bean.BPMStatisticReport("%1D%", "广州分公司", "2", "汉钟财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h5);
        hkfw006Model.add(h6);
        hkfw006Model.add(new HKFW006StatisticModel("广州分公司","合计",h5.getMonth1()+h6.getMonth1(),h5.getMonth2()+h6.getMonth2(),h5.getMonth3()+h6.getMonth3(),h5.getMonth4()+h6.getMonth4(),
        h5.getMonth5()+h6.getMonth5(),h5.getMonth6()+h6.getMonth6(),h5.getMonth7()+h6.getMonth7(),h5.getMonth8()+h6.getMonth8(),h5.getMonth9()+h6.getMonth9(),h5.getMonth10()+h6.getMonth10(),
        h5.getMonth11()+h6.getMonth11(),h5.getMonth12()+h6.getMonth12(),h5.getSum()+h6.getSum()));
       
        HKFW006StatisticModel h7=hkfw006Bean.BPMStatisticReport("%1E%", "南京分公司", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h8=hkfw006Bean.BPMStatisticReport("%1E%", "南京分公司", "2", "汉钟财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h7);
        hkfw006Model.add(h8);
        hkfw006Model.add(new HKFW006StatisticModel("南京分公司","合计",h7.getMonth1()+h8.getMonth1(),h7.getMonth2()+h8.getMonth2(),h7.getMonth3()+h8.getMonth3(),h7.getMonth4()+h8.getMonth4(),
        h7.getMonth5()+h8.getMonth5(),h7.getMonth6()+h8.getMonth6(),h7.getMonth7()+h8.getMonth7(),h7.getMonth8()+h8.getMonth8(),h7.getMonth9()+h8.getMonth9(),h7.getMonth10()+h8.getMonth10(),
        h7.getMonth11()+h8.getMonth11(),h7.getMonth12()+h8.getMonth12(),h7.getSum()+h8.getSum()));
        
        HKFW006StatisticModel h9=hkfw006Bean.BPMStatisticReport("%1V%", "重庆分公司", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h10=hkfw006Bean.BPMStatisticReport("%1V%", "重庆分公司", "2", "汉钟财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h9);
        hkfw006Model.add(h10);
        hkfw006Model.add(new HKFW006StatisticModel("重庆分公司","合计",h9.getMonth1()+h10.getMonth1(),h9.getMonth2()+h10.getMonth2(),h9.getMonth3()+h10.getMonth3(),h9.getMonth4()+h10.getMonth4(),
        h9.getMonth5()+h10.getMonth5(),h9.getMonth6()+h10.getMonth6(),h9.getMonth7()+h10.getMonth7(),h9.getMonth8()+h10.getMonth8(),h9.getMonth9()+h10.getMonth9(),h9.getMonth10()+h10.getMonth10(),
        h9.getMonth11()+h10.getMonth11(),h9.getMonth12()+h10.getMonth12(),h9.getSum()+h10.getSum()));
        
        
        int hkh1=h1.getMonth1()+h3.getMonth1()+h5.getMonth1()+h7.getMonth1()+h9.getMonth1();
        int hkh2=h1.getMonth2()+h3.getMonth2()+h5.getMonth2()+h7.getMonth2()+h9.getMonth2();
        int hkh3=h1.getMonth3()+h3.getMonth3()+h5.getMonth3()+h7.getMonth3()+h9.getMonth3();
        int hkh4=h1.getMonth4()+h3.getMonth4()+h5.getMonth4()+h7.getMonth4()+h9.getMonth4();;
        int hkh5=h1.getMonth5()+h3.getMonth5()+h5.getMonth5()+h7.getMonth5()+h9.getMonth5();
        int hkh6=h1.getMonth6()+h3.getMonth6()+h5.getMonth6()+h7.getMonth6()+h9.getMonth6();
        int hkh7=h1.getMonth7()+h3.getMonth7()+h5.getMonth7()+h7.getMonth7()+h9.getMonth7();
        int hkh8=h1.getMonth8()+h3.getMonth8()+h5.getMonth8()+h7.getMonth8()+h9.getMonth8();
        int hkh9=h1.getMonth9()+h3.getMonth9()+h5.getMonth9()+h7.getMonth9()+h9.getMonth9();
        int hkh10=h1.getMonth10()+h3.getMonth10()+h5.getMonth10()+h7.getMonth10()+h9.getMonth10();
        int hkh11=h1.getMonth11()+h3.getMonth11()+h5.getMonth11()+h7.getMonth11()+h9.getMonth11();
        int hkh12=h1.getMonth12()+h3.getMonth12()+h5.getMonth12()+h7.getMonth12()+h9.getMonth12();
        int hkhsum=h1.getSum()+h3.getSum()+h5.getSum()+h7.getSum()+h9.getSum();
        hkfw006Model.add(new HKFW006StatisticModel("R冷媒退机合计","客户财产",hkh1,hkh2,hkh3,hkh4,hkh5,hkh6,hkh7,hkh8,hkh9,hkh10,hkh11,hkh12,hkhsum));
        int hhz1=h2.getMonth1()+h4.getMonth1()+h6.getMonth1()+h8.getMonth1()+h10.getMonth1();
        int hhz2=h2.getMonth2()+h4.getMonth2()+h6.getMonth2()+h8.getMonth2()+h10.getMonth2();
        int hhz3=h2.getMonth3()+h4.getMonth3()+h6.getMonth3()+h8.getMonth3()+h10.getMonth3();
        int hhz4=h2.getMonth4()+h4.getMonth4()+h6.getMonth4()+h8.getMonth4()+h10.getMonth4();;
        int hhz5=h2.getMonth5()+h4.getMonth5()+h6.getMonth5()+h8.getMonth5()+h10.getMonth5();
        int hhz6=h2.getMonth6()+h4.getMonth6()+h6.getMonth6()+h8.getMonth6()+h10.getMonth6();
        int hhz7=h2.getMonth7()+h4.getMonth7()+h6.getMonth7()+h8.getMonth7()+h10.getMonth7();
        int hhz8=h2.getMonth8()+h4.getMonth8()+h6.getMonth8()+h8.getMonth8()+h10.getMonth8();
        int hhz9=h2.getMonth9()+h4.getMonth9()+h6.getMonth9()+h8.getMonth9()+h10.getMonth9();
        int hhz10=h2.getMonth10()+h4.getMonth10()+h6.getMonth10()+h8.getMonth10()+h10.getMonth10();
        int hhz11=h2.getMonth11()+h4.getMonth11()+h6.getMonth11()+h8.getMonth11()+h10.getMonth11();
        int hhz12=h2.getMonth12()+h4.getMonth12()+h6.getMonth12()+h8.getMonth12()+h10.getMonth12();
        int hhzsum=h2.getSum()+h4.getSum()+h6.getSum()+h8.getSum()+h10.getSum();
        hkfw006Model.add(new HKFW006StatisticModel("R冷媒退机合计","汉钟财产",hhz1,hhz2,hhz3,hhz4,hhz5,hhz6,hhz7,hhz8,hhz9,hhz10,hhz11,hhz12,hhzsum));
        hkfw006Model.add(new HKFW006StatisticModel("R冷媒退机合计","合计",hhz1+hkh1,hhz2+hkh2,hhz3+hkh3,hhz4+hkh4,hhz5+hkh5,hhz6+hkh6,hhz7+hkh7,hhz8+hkh8,hhz9+hkh9,hhz10+hkh10,hhz11+hkh11,hhz12+hkh12,hhzsum+hkhsum));
        
        HKFW006StatisticModel h11=hkfw006Bean.BPMStatisticReport("%1G%", "空压机体产品部", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h12=hkfw006Bean.BPMStatisticReport("%1G%", "空压机体产品部", "2", "汉钟财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h11);
        hkfw006Model.add(h12);
        hkfw006Model.add(new HKFW006StatisticModel("空压机体产品部","合计",h11.getMonth1()+h12.getMonth1(),h11.getMonth2()+h12.getMonth2(),h11.getMonth3()+h12.getMonth3(),h11.getMonth4()+h12.getMonth4(),
        h11.getMonth5()+h12.getMonth5(),h11.getMonth6()+h12.getMonth6(),h11.getMonth7()+h12.getMonth7(),h11.getMonth8()+h12.getMonth8(),h11.getMonth9()+h12.getMonth9(),h11.getMonth10()+h12.getMonth10(),
        h11.getMonth11()+h12.getMonth11(),h11.getMonth12()+h12.getMonth12(),h11.getSum()+h12.getSum()));
        
         HKFW006StatisticModel h13=hkfw006Bean.BPMStatisticReport("%1Q%", "空压机组产品部", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h14=hkfw006Bean.BPMStatisticReport("%1Q%", "空压机组产品部", "2", "汉钟财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h13);
        hkfw006Model.add(h14);
        hkfw006Model.add(new HKFW006StatisticModel("空压机组产品部","合计",h13.getMonth1()+h14.getMonth1(),h13.getMonth2()+h14.getMonth2(),h13.getMonth3()+h14.getMonth3(),h13.getMonth4()+h14.getMonth4(),
        h13.getMonth5()+h14.getMonth5(),h13.getMonth6()+h14.getMonth6(),h13.getMonth7()+h14.getMonth7(),h13.getMonth8()+h14.getMonth8(),h13.getMonth9()+h14.getMonth9(),h13.getMonth10()+h14.getMonth10(),
        h13.getMonth11()+h14.getMonth11(),h13.getMonth12()+h14.getMonth12(),h13.getSum()+h14.getSum()));
        
        
        HKFW006StatisticModel h15=hkfw006Bean.BPMStatisticReport("%1H%", "真空产品部", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h16=hkfw006Bean.BPMStatisticReport("%1H%", "真空产品部", "2", "汉钟财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h15);
        hkfw006Model.add(h16);
        hkfw006Model.add(new HKFW006StatisticModel("真空产品部","合计",h15.getMonth1()+h16.getMonth1(),h15.getMonth2()+h16.getMonth2(),h15.getMonth3()+h16.getMonth3(),h15.getMonth4()+h16.getMonth4(),
        h15.getMonth5()+h16.getMonth5(),h15.getMonth6()+h16.getMonth6(),h15.getMonth7()+h16.getMonth7(),h15.getMonth8()+h16.getMonth8(),h15.getMonth9()+h16.getMonth9(),h15.getMonth10()+h16.getMonth10(),
        h15.getMonth11()+h16.getMonth11(),h15.getMonth12()+h16.getMonth12(),h15.getSum()+h16.getSum()));
               
        HKFW006StatisticModel h17=hkfw006Bean.BPMStatisticReport("%8A%", "再生能源产品部", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h18=hkfw006Bean.BPMStatisticReport("%8A%", "再生能源产品部", "3", "柯茂财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h17);
        hkfw006Model.add(h18);
        hkfw006Model.add(new HKFW006StatisticModel("再生能源产品部","合计",h17.getMonth1()+h18.getMonth1(),h17.getMonth2()+h18.getMonth2(),h17.getMonth3()+h18.getMonth3(),h17.getMonth4()+h18.getMonth4(),
        h17.getMonth5()+h18.getMonth5(),h17.getMonth6()+h18.getMonth6(),h17.getMonth7()+h18.getMonth7(),h17.getMonth8()+h18.getMonth8(),h17.getMonth9()+h18.getMonth9(),h17.getMonth10()+h18.getMonth10(),
        h17.getMonth11()+h18.getMonth11(),h17.getMonth12()+h18.getMonth12(),h17.getSum()+h18.getSum()));
        
        
         HKFW006StatisticModel h19=hkfw006Bean.BPMStatisticReport("%5C%", "涡轮产品部", "1", "客户财产", Integer.valueOf(queryYear));
        HKFW006StatisticModel h20=hkfw006Bean.BPMStatisticReport("%5C%", "涡轮产品部", "3", "柯茂财产", Integer.valueOf(queryYear));
        hkfw006Model.add(h19);
        hkfw006Model.add(h20);
        hkfw006Model.add(new HKFW006StatisticModel("涡轮产品部","合计",h19.getMonth1()+h20.getMonth1(),h19.getMonth2()+h20.getMonth2(),h19.getMonth3()+h20.getMonth3(),h19.getMonth4()+h20.getMonth4(),
        h19.getMonth5()+h20.getMonth5(),h19.getMonth6()+h20.getMonth6(),h19.getMonth7()+h20.getMonth7(),h19.getMonth8()+h20.getMonth8(),h19.getMonth9()+h20.getMonth9(),h19.getMonth10()+h20.getMonth10(),
        h19.getMonth11()+h20.getMonth11(),h19.getMonth12()+h20.getMonth12(),h19.getSum()+h20.getSum()));
        
    }

}
