/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.crm.ejb.DUPLDBean;
import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.ejb.REPTEBean;
import cn.hanbell.crm.entity.CMSMV;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.DUPLD;
import cn.hanbell.crm.entity.REPTC;
import cn.hanbell.crm.entity.REPTE;
import cn.hanbell.crm.model.REPTEModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import cn.hanbell.util.BaseLib;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author C2082
 */
@ManagedBean(name = "repteManagedBean")
@javax.faces.bean.ViewScoped
public class REPTEManagedBean extends SuperQueryBean<REPTEModel> {

    @EJB
    private REPTEBean repteBean;
    @EJB
    private REPTCBean reptcBean;
    @EJB
    private DUPLDBean dupldBean;
    private List<REPTEModel> reptemodels;
    private String maintainType;
    private String maintainNumber;
    private String passesName;
    private String customerAbbreviation;
    private String serviceStaff;
    private Date startDate;
    private Date endDate;
    private REPTEModel selectRepteModel;
    private StreamedContent file;
    private InputStream rarInputStream;

    public REPTEManagedBean() {
        super(REPTEModel.class);
    }

    public void handleDialogReturnCRMGG(SelectEvent event) {
        System.out.println("---+" + selectRepteModel);
        CRMGG u = (CRMGG) event.getObject();
        customerAbbreviation = u.getGg001() + "-" + u.getGg003();
    }

    public void handleDialogReturnCMSMV(SelectEvent event) {
        System.out.println("---+" + selectRepteModel);
        CMSMV u = (CMSMV) event.getObject();
        serviceStaff = u.getMv001() + "-" + u.getMv002();
    }

    @Override
    public void init() {
        try {
            this.reportPath = fc.getExternalContext().getRealPath("/")
                    + fc.getExternalContext().getInitParameter("cn.hanbell.web.reportpath") + "压缩模板.rar";
            startDate = new Date();
            endDate = new Date();
            reptemodels = new ArrayList<REPTEModel>();
            List<REPTE> reptes = repteBean.findAll();
            setReptemodelList(reptes);
        } catch (ParseException ex) {
            Logger.getLogger(REPTEManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void print() {
        query();
        InputStream is = null;
        try {
            try {
                String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                String pathString = new String(filePath.concat("rpt/"));
                File file = new File(pathString, "服务打卡明细模板.xlsx");
                is = new FileInputStream(file);
                this.fileName = "REPTE" + com.lightshell.comm.BaseLib.formatDate("yyyyMMddHHmmss", com.lightshell.comm.BaseLib.getDate()) + ".xlsx";
                this.fileFullName = this.reportOutputPath + this.fileName;
                Workbook wb = WorkbookFactory.create(is);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(0);
                wb.setSheetName(0, sdf.format(new Date()) + "服务打卡明细");
                Row row = null;
                int i = 1;
                for (Iterator var12 = reptemodels.iterator(); var12.hasNext(); ++i) {
                    REPTEModel e = (REPTEModel) var12.next();
                    row = sheet.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(i);
                    row.createCell(1).setCellValue(e.getTe001() + e.getTe002() + "-" + e.getTe004());
                    row.createCell(2).setCellValue(e.getCustomerAbbreviation() != null ? e.getCustomerAbbreviation() : "");
                    row.createCell(3).setCellValue(e.getServiceStaff() != null ? e.getServiceStaff() : "");
                    row.createCell(4).setCellValue(e.getRoadStartDate() != null ? e.getRoadStartDate() : "");
                    row.createCell(5).setCellValue(e.getTe506() != null ? e.getTe506() : "");
                    row.createCell(6).setCellValue(e.getArrivalDate() != null ? e.getArrivalDate() : "");
                    row.createCell(7).setCellValue(e.getTe507() != null ? e.getTe507() : "");
                    row.createCell(8).setCellValue(e.getLeaveDate() != null ? e.getLeaveDate() : "");
                    row.createCell(9).setCellValue(e.getTe508() != null ? e.getTe508() : "");
                    row.createCell(10).setCellValue(e.getRoadEndDate() != null ? e.getRoadEndDate() : "");
                    row.createCell(11).setCellValue(e.getTe509() != null ? e.getTe509() : "");
                    row.createCell(12).setCellValue(e.getTe010() != null ? e.getTe010().toString() : "");
                    row.createCell(13).setCellValue(e.getRoadTime() != null ? e.getRoadTime().toString() : "");
                    row.createCell(14).setCellValue(e.getTe009() != null ? e.getTe009() : "");
                }
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream(this.fileFullName);
                    wb.write(os);

                    this.reportViewPath = this.reportViewContext + this.fileName;
                    this.preview();
                } catch (Exception var38) {
                    var38.printStackTrace();
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
                this.log4j.error(var42.getMessage());
            }

        } finally {

        }
    }

    public void query() {
        StringBuffer sql = new StringBuffer();
        if (customerAbbreviation != null && !"".equals(customerAbbreviation)) {
            sql.append("SELECT te.* FROM REPTE  te left join REPTC tc on te.TE001=tc.TC001 and te.TE002=tc.TC002 WHERE TC007='").append(customerAbbreviation.split("-")[0]).append("'");
        } else {
            sql.append("SELECT * FROM REPTE where 1=1");
        }
        if (!"ALL".equals(maintainType)) {
            sql.append(" and TE001 like '%").append(maintainType).append("%'");
        }
        if (maintainNumber != null && !"".equals(maintainNumber)) {
            sql.append(" and TE002 like '%").append(maintainNumber).append("%'");
        }
        if (serviceStaff != null && !"".equals(serviceStaff)) {
            sql.append(" and TE008 like '%").append(serviceStaff.split("-")[0]).append("%'");
        }
        List<REPTE> list = repteBean.getREPTEBySql(sql.toString());
        List<REPTE> reptes = new ArrayList<REPTE>();
        try {
            for (REPTE r : list) {
                if (r.getTe502() != null && !"".equals(r.getTe502())
                        && r.getTe504() != null && !"".equals(r.getTe504())) {
                    Date date = BaseLib.getDate("yyyyMMddHHmm", new StringBuffer(r.getTe502()).append(r.getTe504()).toString());
                    if (date.getTime() >= startDate.getTime() && date.getTime() <= endDate.getTime()+1000*60*60*24) {
                        reptes.add(r);
                    }
                }
            }
            setReptemodelList(reptes);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void reset() {
        maintainType = "ALL";
        maintainNumber = "";
        passesName = "";
        customerAbbreviation = "";
        serviceStaff = "";
    }

    public REPTEModel getSelectRepteModel() {
        return selectRepteModel;
    }

    public void setSelectRepteModel(REPTEModel selectRepteModel) {
        this.selectRepteModel = selectRepteModel;
    }

    public REPTEBean getRepteBean() {
        return repteBean;
    }

    public void setRepteBean(REPTEBean repteBean) {
        this.repteBean = repteBean;
    }

    public REPTCBean getReptcBean() {
        return reptcBean;
    }

    public void setReptcBean(REPTCBean reptcBean) {
        this.reptcBean = reptcBean;
    }

    public List<REPTEModel> getReptemodels() {
        return reptemodels;
    }

    public void setReptemodels(List<REPTEModel> reptemodels) {
        this.reptemodels = reptemodels;
    }

    public String getMaintainType() {
        return maintainType;
    }

    public void setMaintainType(String maintainType) {
        this.maintainType = maintainType;
    }

    public String getMaintainNumber() {
        return maintainNumber;
    }

    public void setMaintainNumber(String maintainNumber) {
        this.maintainNumber = maintainNumber;
    }

    public String getPassesName() {
        return passesName;
    }

    public void setPassesName(String passesName) {
        this.passesName = passesName;
    }

    public String getCustomerAbbreviation() {
        return customerAbbreviation;
    }

    public void setCustomerAbbreviation(String customerAbbreviation) {
        this.customerAbbreviation = customerAbbreviation;
    }

    public String getServiceStaff() {
        return serviceStaff;
    }

    public void setServiceStaff(String serviceStaff) {
        this.serviceStaff = serviceStaff;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setReptemodelList(List<REPTE> reptes) throws ParseException {
        reptemodels.clear();
        for (REPTE r : reptes) {
            REPTEModel model = new REPTEModel();
            model.setTe001(r.getREPTEPK().getTe001());
            model.setTe002(r.getREPTEPK().getTe002());
            model.setTe004(r.getREPTEPK().getTe004());
            REPTC reptc = reptcBean.findByPK(r.getREPTEPK().getTe001(), r.getREPTEPK().getTe002());
            if (reptc.getCrmgg() != null) {
                model.setCustomerAbbreviation(reptc.getCrmgg().getGg003());
            }
            if (r.getCmsmv() != null) {
                model.setServiceStaff(r.getCmsmv().getMv002());
            }
            model.setTe009(r.getTe009());
            model.setTe010(r.getTe010());
            if (r.getTe502() != null && !"".equals(r.getTe502())
                    && r.getTe504() != null && !"".equals(r.getTe504())) {
                model.setRoadStartDate(repteBean.proccessDate("yyyyMMdd HHmm", new StringBuffer(r.getTe502()).append(" ").append(r.getTe504()).toString(), "yyyy/MM/dd HH:mm"));
                model.setTe506(r.getTe506());
            }
            if (r.getTe007() != null && !"".equals(r.getTe007())
                    && r.getTe017() != null && !"".equals(r.getTe017())) {
                model.setArrivalDate(repteBean.proccessDate("yyyyMMdd HHmm", new StringBuffer(r.getTe007()).append(" ").append(r.getTe017()).toString(), "yyyy/MM/dd HH:mm"));
                model.setTe507(r.getTe507());
            }
            if (r.getTe018() != null && !"".equals(r.getTe018())
                    && r.getTe019() != null && !"".equals(r.getTe019())) {
                model.setLeaveDate(repteBean.proccessDate("yyyyMMdd HHmm", new StringBuffer(r.getTe018()).append(" ").append(r.getTe019()).toString(), "yyyy/MM/dd HH:mm"));
                model.setTe508(r.getTe508());
            }
            if (r.getTe503() != null && !"".equals(r.getTe503())
                    && r.getTe505() != null && !"".equals(r.getTe505())) {
                model.setRoadEndDate(repteBean.proccessDate("yyyyMMdd HHmm", new StringBuffer(r.getTe503()).append(" ").append(r.getTe505()).toString(), "yyyy/MM/dd HH:mm"));
                model.setTe509(r.getTe509());
            }
            if (model.getRoadStartDate() != null && !"".equals(model.getRoadStartDate())
                    && model.getArrivalDate() != null && !"".equals(model.getArrivalDate())
                    && model.getLeaveDate() != null && !"".equals(model.getLeaveDate())
                    && model.getRoadEndDate() != null && !"".equals(model.getRoadEndDate())) {
                Date roadStartDate = BaseLib.getDate("yyyy/MM/dd HH:mm", model.getRoadStartDate());
                Date arriveDate = BaseLib.getDate("yyyy/MM/dd HH:mm", model.getArrivalDate());
                Date leaveDate = BaseLib.getDate("yyyy/MM/dd HH:mm", model.getLeaveDate());
                Date roadEndDate = BaseLib.getDate("yyyy/MM/dd HH:mm", model.getRoadEndDate());
                if (roadStartDate.getTime() <= arriveDate.getTime() && leaveDate.getTime() <= roadEndDate.getTime()) {
                    long time = (arriveDate.getTime() - roadStartDate.getTime()) + (roadEndDate.getTime() - leaveDate.getTime());
                    BigDecimal decimal = new BigDecimal((double) time / 1000 / 60 / 60);
                    BigDecimal bdmt = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                    model.setRoadTime(bdmt);
                }
            }

            StringBuffer str = new StringBuffer(model.getTe001());
            str.append("_").append(model.getTe002()).append("_").append(model.getTe004());
            model.setId(str.toString());
            reptemodels.add(model);
        }
    }

    public void downloadPhoto() {
        file=null;
        InputStream imgis = null;
        File img = null;
        img = new File(this.reportPath);
        try {
            boolean b=photoIntoRar();
            //没有数据
            if(!b){
              FacesContext.getCurrentInstance().addMessage((String)null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "该维修单没有上传图片"));
                return;
            }
            imgis = new FileInputStream(img);
            //由于压缩直接给file类型，不能直接关流，会导致rar模板更新失败，使用字节数组组成流，放入file中
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int ch;
            while ((ch = imgis.read(buffer)) != -1) {
                bytestream.write(buffer, 0, ch);
            }
                byte data[] = bytestream.toByteArray();
                bytestream.close();
            if (imgis != null) {
                file = new DefaultStreamedContent(new ByteArrayInputStream(data), "application/x-rar-compressed", "downloaded_boromir.rar");
            } else {
                System.out.println("文件不存在");
            }
        } catch (IOException ex) {   
            Logger.getLogger(REPTEManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
               img.delete();
               img.createNewFile();
//               imgis.close();
            } catch (Exception e) {
                System.out.println("关流失败");
            }
        }
    }

    public boolean photoIntoRar() {
        List<DUPLD> duplds = dupldBean.findByLD002AndLd003(this.selectRepteModel.getTe001(), this.selectRepteModel.getTe002());
        if (duplds == null || duplds.isEmpty()) {
            return false;
        }
        InputStream imgis = null;
        BufferedInputStream bInStream = null;
        ZipOutputStream zip = null;
        OutputStream rar = null;
        File rarFile = new File(this.reportPath);
        try {
            rar = new FileOutputStream(rarFile);
            zip = new ZipOutputStream(rar);
            for (DUPLD d : duplds) {
                HttpURLConnection connection = null;
                URL connecUrl = new URL(d.getDs007());
                connection = (HttpURLConnection) connecUrl.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(15000);
                // 设置读取远程返回的数据时间：60000毫秒
                connection.setReadTimeout(60000);
                connection.connect();
                if (connection.getResponseCode() == 200) {
                    imgis = connection.getInputStream();
                }
                if (imgis != null) {
                    bInStream = new BufferedInputStream(imgis);
                    ZipEntry entry = new ZipEntry(d.getDs008());
                    zip.putNextEntry(entry);
                    int len = 0;
                    byte[] buffer = new byte[10 * 1024];
                    while ((len = imgis.read(buffer)) > 0) {
                        zip.write(buffer, 0, len);
                    }
                } else {
                    System.out.println("文件不存在");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(REPTEManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                zip.flush();
                bInStream.close();
                imgis.close();  
                zip.close();
                rar.close();
            } catch (Exception ex) {
                Logger.getLogger(REPTEManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", "123");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", "124");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public InputStream getRarInputStream() {
        return rarInputStream;
    }

    public void setRarInputStream(InputStream rarInputStream) {
        this.rarInputStream = rarInputStream;
    }

}
