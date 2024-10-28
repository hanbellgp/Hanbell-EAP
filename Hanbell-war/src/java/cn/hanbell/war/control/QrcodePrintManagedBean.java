/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.eap.ejb.CompanyBean;
import cn.hanbell.eap.ejb.QrcodeBean;
import cn.hanbell.eap.ejb.QrcodeDetailBean;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.Company;
import cn.hanbell.eap.entity.Qrcode;
import cn.hanbell.eap.entity.QrcodeDetail;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.war.lazy.QrcodeModel;
import cn.hanbell.war.rpt.QrcodePrintReport;
import cn.hanbell.war.rpt.SGD00933QrcodePrint;
import cn.hanbell.war.rpt.SSH00849QrcodePrint;
import cn.hanbell.war.web.FormMultiBean;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.lightshell.comm.BaseLib;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "qrcodePrintManagedBean")
@SessionScoped
public class QrcodePrintManagedBean extends FormMultiBean<Qrcode, QrcodeDetail> {

    @EJB
    private CompanyBean companyBean;
    @EJB
    private SystemUserBean systemUserBean;
    @EJB
    private QrcodeBean qrcodeBean;
    @EJB
    private QrcodeDetailBean qrcodeDetailBean;
    private String queryType;
    private String queryCompany;
    private UploadedFile file;

    private String type;
    private List<Type> typeList;
    private List<Company> companyList;

    public QrcodePrintManagedBean() {
        super(Qrcode.class, QrcodeDetail.class);
    }

    @Override
    public void construct() {
        typeList = new ArrayList<Type>();
         typeList.add(new Type("", "全部"));
        typeList.add(new Type("SGD00933QrCode", "广东汉德出货二维码"));
         typeList.add(new Type("SSH00849QrCode", "上海萨震出货二维码"));
        companyList = companyBean.findAll();
        super.construct();
    }

    @Override
    public void init() {
        superEJB = qrcodeBean;
        detailEJB = qrcodeDetailBean;
        model = new QrcodeModel(qrcodeBean);
        this.queryState="N";
        model.getFilterFields().put("status", "N");
        super.init();
    }

    @Override
    public void print() throws Exception {
        if (currentPrgGrant == null || currentEntity == null) {
            return;
        }
        String reportName = "", outputName, reportFormat;
        // 设置报表名称
        // 设置导出文件名称
        fileName = this.currentEntity.getType() + BaseLib.formatDate("yyyyMMddHHmmss", getDate()) + ".pdf";
        outputName = reportOutputPath + fileName;
        reportClassLoader = Class.forName("cn.hanbell.war.rpt.SGD00933QrcodePrint").getClassLoader();
        reportName = reportPath + this.currentEntity.getType()+".rptdesign";
        OutputStream os = new FileOutputStream(outputName);
        PdfCopyFields pdfCopy = new PdfCopyFields(os);
        HashMap<String, Object> reportParams = new HashMap<>();
        ByteArrayOutputStream baos;
        QrcodePrintReport report = null;
        if (this.currentEntity.getType().equals("SGD00933QrCode")) {//机体广州汉德二维码
            report = new SGD00933QrcodePrint();
        }else if(this.currentEntity.getType().equals("SSH00849QrCode")){
              report = new SSH00849QrcodePrint();
        }
        report.setEJB(qrcodeBean);
        report.initQrcode(this.currentEntity.getFormid(), this.getAppResPath());
        reportParams.put("JNDIName", this.qrcodeBean);
        // 设置报表参数
        baos = new ByteArrayOutputStream();
        reportParams.put("id", this.currentEntity.getId());
        try {
            // 初始配置
            this.reportInitAndConfig();
            // 生成报表
            this.reportRunAndOutput(reportName, reportParams, null, "pdf", baos);
        } catch (Exception ex) {
            throw ex;
        } finally {
            currentEntity.setStatus("V");
            update();
            reportParams.clear();
        }

        pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
        pdfCopy.close();
        this.reportViewPath = reportViewContext + fileName;
        this.preview();
    }

    public void generateQRCode(String content, int width, int height, String filePath, String fileName) {
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            Path path = FileSystems.getDefault().getPath(filePath, fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
        } catch (WriterException | IOException ex) {
            Logger.getLogger(ShipmentPrintManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryCompany != null && !"".equals(queryCompany)) {
                this.model.getFilterFields().put("company", queryCompany);
            }
            if (queryFormId != null && !"".equals(queryFormId)) {
                this.model.getFilterFields().put("formid", queryFormId);
            }
            if (queryType != null && !"".equals(queryType)) {
                this.model.getFilterFields().put("type", queryType);
            }
            if (queryState != null && !"ALL".equals(queryState)) {
                this.model.getFilterFields().put("status", queryState);
            }

        }
    }

    /**
     * 上传回调事件
     *
     * @param event
     */
    @Override
    public void handleFileUploadWhenNew(FileUploadEvent event) {
        this.file = event.getFile();
        this.showInfoMsg("Info", "上传成功,请保存！");
    }

    public void upload() {
        if (file != null) {
            try {
                InputStream is = file.getInputstream();
                Workbook excel = WorkbookFactory.create(is);
                Sheet sheet = excel.getSheetAt(0);
                Qrcode head = new Qrcode();
                SystemUser user = systemUserBean.findByUserId(this.userManagedBean.getUserid());
                head.setFormdate(new Date());
                head.setCompany(this.userManagedBean.getCompany());
                head.setUserno(user.getUserid());
                head.setUsername(user.getUsername());
                head.setDeptno(user.getDeptno());
                head.setDeptname(user.getDept().getDept());
                head.setType(this.type);
                Type t = typeList.stream().filter(item -> item.getTypeId().equals(this.type)).findFirst().get();
                head.setTypename(t.typeName);
                head.setStatus("N");
                head.setCreator(user.getUserid());
                head.setCredateToNow();
            
                Cell cell;
                int column=0,row=0;
                while(true){//获取行数
                   
                    if(row==26){
                         System.out.print(row);
                    }
                    if( sheet.getRow(row)==null || getValue(sheet.getRow(row).getCell(0))==null ||  "".equals(getValue(sheet.getRow(row).getCell(0)))){
                        break;
                    }
                    row++;
                }
                while(true){//获取列数
                    cell = sheet.getRow(0).getCell(column);
                    if( getValue(cell)==null ||  "".equals(getValue(cell))){
                        break;
                    }
                    column++;
                }
                List<QrcodeDetail> addDetail = new ArrayList<>();
                for (int i = 1; i <= row; i++) {
                    QrcodeDetail detail = new QrcodeDetail();
                    detail.setSeq(i);
                    if (sheet.getRow(i)==null || getValue(sheet.getRow(i).getCell(0)) == null || "".equals(getValue(sheet.getRow(i).getCell(0)))) {
                        break;
                    }
                     detail.setContent(1, getValue(cell));
                    for (int j = 0; j < column; j++) {
                        cell = sheet.getRow(i).getCell(j);
                        
                        detail.setContent(j + 1, getValue(cell));
                    }
                    addDetail.add(detail);
                }
                if (!addDetail.isEmpty()) {
                    try {
                        String formid = qrcodeBean.initData(head, addDetail);
                        if (formid != null) {
                            showInfoMsg("Info", "数据上传成功，共" + addDetail.size() + "条数据。");
                        } else {
                            showErrorMsg("Error", "数据写入失败");
                        }
                    } catch (Exception ex) {
                        showErrorMsg("Error", "上传失败："+ex.getMessage());
                    }
                } else {
                    showErrorMsg("Error", "文档为空，请检查！！");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                showErrorMsg("Error", "导入失败" + ex.toString());

            }
        }

    }

    public static String getValue(Cell cell) throws Exception {
     
        String value = "";
        if (null == cell) {
            return value;
        }
        int cellType = cell.getCellType();
        switch (cellType) {
            //数值型
            case 0:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    //如果是date类型则 ，获取该cell的date值
                    Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    value = format.format(date);
                    ;
                } else {// 纯数字
                    BigDecimal big = new BigDecimal(cell.getNumericCellValue());
                    value = big.toString();
                    //解决1234.0  去掉后面的.0
                    if (null != value && !"".equals(value.trim())) {
                        String[] item = value.split("[.]");
                        if (1 < item.length && "0".equals(item[1])) {
                            value = item[0];
                        }
                    }
                }
                break;
            //字符串类型
            case 1:
                value = cell.getStringCellValue();
                break;
            // 公式类型
            case 2:
                //读公式计算值
            throw new Exception("存在公式！");
            // 布尔类型
            case 4:
                value = " " + cell.getBooleanCellValue();
                break;
            default:
                value = cell.getStringCellValue();
        }
        if ("null".endsWith(value.trim())) {
            value = "";
        }
        return value;
      
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getQueryCompany() {
        return queryCompany;
    }

    public void setQueryCompany(String queryCompany) {
        this.queryCompany = queryCompany;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public class Type implements Serializable {

        private String typeId;
        private String typeName;

        public Type(String typeId, String typeName) {
            this.typeId = typeId;
            this.typeName = typeName;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

    }
}
