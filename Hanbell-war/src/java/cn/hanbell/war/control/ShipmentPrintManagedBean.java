/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.eap.ejb.ShipmentBean;
import cn.hanbell.eap.ejb.ShipmentDetailBean;
import cn.hanbell.eap.entity.Shipment;
import cn.hanbell.eap.entity.ShipmentDetail;
import cn.hanbell.erp.ejb.CdrscusBean;
import cn.hanbell.war.lazy.ShipmentModel;
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
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code128.Code128Constants;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "shipmentPrintManagedBean")
@SessionScoped
public class ShipmentPrintManagedBean extends FormMultiBean<Shipment, ShipmentDetail> {

    @EJB
    protected ShipmentDetailBean shipmentDetailBean;
    @EJB
    protected ShipmentBean shipmentBean;

    private String queryCreator;
    private String queryDeptno;

    /**
     * Creates a new instance of BillPrintManagedBean
     */
    public ShipmentPrintManagedBean() {
        super(Shipment.class, ShipmentDetail.class);
    }

    public void clearState() {
        if (null != getCurrentEntity()) {
            try {
                currentEntity.setStatus("N");// 简化查询条件,此处不再提供修改状态(M)
                currentEntity.setOptuser(getUserManagedBean().getCurrentUser().getUsername());
                currentEntity.setOptdateToNow();
                currentEntity.setCfmuser(null);
                currentEntity.setCfmdate(null);
                superEJB.update(currentEntity);
                showInfoMsg("Info", "更新成功");
            } catch (Exception ex) {
                showErrorMsg("Error", ex.getMessage());
            }
        } else {
            showWarnMsg("Warn", "没有可更新数据");
        }
    }

    @Override
    public void delete() {
        if (entityList != null && !entityList.isEmpty()) {
            entityList.stream().forEach((e) -> {
                delete(e);
            });
        }
    }

    @Override
    protected boolean doBeforeUpdate() throws Exception {
        if (currentEntity != null && detailList != null) {
            String f;
            for (ShipmentDetail sd : detailList) {
                if (sd.getShpno() != null) {
                    // 汉钟出货单条码
                    f = this.getAppResPath() + sd.getShpno() + ".png";
                    this.generateCode128(sd.getShpno(), 1.5f, 8d, f);
                    this.generateQRCode(sd.getShpno(), 300, 300, this.getAppResPath(), "QR" + sd.getShpno() + ".png");
                }
                if (sd.getItemno() != null) {
                    // 汉钟品号条码
                    f = this.getAppResPath() + sd.getItemno() + ".png";
                    this.generateCode128(sd.getItemno(), 1.5f, 8d, f);
                    this.generateQRCode(sd.getItemno(), 300, 300, this.getAppResPath(), "QR" + sd.getItemno() + ".png");
                }
                if (sd.getCustomerItem() != null && !sd.getCustomerItem().equals("")) {
                    // 客户品号条码
                    f = this.getAppResPath() + currentEntity.getCustomerno() + sd.getCustomerItem() + ".png";
                    this.generateCode128(sd.getCustomerItem(), 1.5f, 8d, f);
                    this.generateQRCode(sd.getCustomerItem(), 300, 300, this.getAppResPath(), "QR" + currentEntity.getCustomerno() + sd.getCustomerItem() + ".png");
                    if (sd.getItemModel() != null && sd.getVarnr() != null) {
                        StringBuilder content = new StringBuilder();
                        switch (currentEntity.getCustomerno()) {
                            case "SCQ00011":
                                // 美的专属二维码，备注：如果需要修改日期格式，修改ShipmentDetail类中的getShpdateAndLotseq()方法
                                content.append("A0007001").append("|").append(BaseLib.formatDate("yyyyMMdd", sd.getShpdate())).append("-").append(sd.getLotseq()).append("|")
                                        .append(sd.getVarnr()).append("|").append(sd.getCustomerItem()).append("|").append(sd.getItemModel());
                                break;
                            case "SSD00103":
                                // 海达瑞专属二维码
                                content.append(sd.getCustomerItem()).append(".").append(sd.getVarnr()).append(".").append(sd.getItemModel()).append(".")
                                        .append(BaseLib.formatDate("yyyyMMdd", sd.getShpdate())).append(".").append(sd.getCustomerItemDesc());
                                break;
                             case "SSD00886":
                                // 海达诚专属二维码
                                content.append(sd.getCustomerItem()).append(".").append(sd.getVarnr()).append(".").append(sd.getItemModel()).append(".")
                                        .append(BaseLib.formatDate("yyyyMMdd", sd.getShpdate())).append(".").append(sd.getCustomerItemDesc());
                                break;
                                //冰山冷热专属二维码
                            case "SLN00028":
                                content.append(sd.getCustomerItem()).append(" ").append(sd.getItemDesc()).append("|").append(sd.getItemModel());
                                break;
                        }
                        if (content.length() > 0) {
                            this.generateQRCode(content.toString(), 300, 300, this.getAppResPath(), "QR" + currentEntity.getCustomerno() + sd.getVarnr() + ".png");
                        }
                    }
                }
                if (sd.getVarnr() != null) {
                    // 汉钟物料条码
                    f = this.getAppResPath() + sd.getVarnr() + ".png";
                    this.generateCode128(sd.getVarnr(), 1.5f, 8d, f);
                    this.generateQRCode(sd.getVarnr(), 300, 300, this.getAppResPath(), "QR" + sd.getVarnr() + ".png");
                }
            }
        }
        return super.doBeforeUpdate();
    }

    @Override
    public void init() {
        queryCreator = userManagedBean.getCurrentUser().getUsername();
        superEJB = shipmentBean;
        detailEJB = shipmentDetailBean;
        model = new ShipmentModel(shipmentBean, userManagedBean.getCompany());
        model.getFilterFields().put("status", "N");
        model.getFilterFields().put("creator", getQueryCreator());
        model.getSortFields().put("status", "ASC");
        model.getSortFields().put("formid", "DESC");
        super.init();
    }

    @Override
    public void print() throws Exception {
        if (currentPrgGrant == null || entityList == null || entityList.isEmpty()) {
            return;
        }
        String reportName, outputName, reportFormat;
        // 设置报表名称
        // reportName = reportPath + currentPrgGrant.getSysprg().getRptdesign();
        // 设置导出文件名称
        fileName = "ShipmentPrint" + BaseLib.formatDate("yyyyMMddHHmmss", getDate()) + ".pdf";
        outputName = reportOutputPath + fileName;
        OutputStream os = new FileOutputStream(outputName);
        if (this.currentPrgGrant != null && this.currentPrgGrant.getSysprg().getRptclazz() != null) {
            reportClassLoader = Class.forName(this.currentPrgGrant.getSysprg().getRptclazz()).getClassLoader();
        }
        PdfCopyFields pdfCopy = new PdfCopyFields(os);
        HashMap<String, Object> reportParams = new HashMap<>();
        ByteArrayOutputStream baos;
        for (Shipment c : entityList) {
            // 设置报表参数
            baos = new ByteArrayOutputStream();
            reportParams.put("company", userManagedBean.getCurrentCompany().getName());
            reportParams.put("companyFullName", userManagedBean.getCurrentCompany().getFullname());
            reportParams.put("tel", userManagedBean.getCurrentCompany().getTel());
            reportParams.put("fax", userManagedBean.getCurrentCompany().getFax());
            reportParams.put("id", c.getId());
            reportParams.put("formid", c.getFormid());
            reportParams.put("JNDIName", currentPrgGrant.getSysprg().getRptjndi());
            try {
                // 按每个客户打印不同格式
                reportName = reportPath + "shipmentBarcode.rptdesign";
                // 初始配置
                this.reportInitAndConfig();
                // 生成报表
                this.reportRunAndOutput(reportName, reportParams, null, "pdf", baos);
            } catch (Exception ex) {
                throw ex;
            } finally {
                reportParams.clear();
                c.setStatus("P");
                currentEntity = c;
                update();
            }
            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
        }
        pdfCopy.close();
        this.reportViewPath = reportViewContext + fileName;
        this.preview();
    }

    public void print(String rptdesign) throws Exception {
        if (currentPrgGrant == null || entityList == null || entityList.isEmpty()) {
            return;
        }
        String reportName, outputName, reportFormat;
        // 设置报表名称
        // reportName = reportPath + currentPrgGrant.getSysprg().getRptdesign();
        // 设置导出文件名称
        fileName = "ShipmentPrint" + BaseLib.formatDate("yyyyMMddHHmmss", getDate()) + ".pdf";
        outputName = reportOutputPath + fileName;
        OutputStream os = new FileOutputStream(outputName);
        if (this.currentPrgGrant != null && this.currentPrgGrant.getSysprg().getRptclazz() != null) {
            reportClassLoader = Class.forName(this.currentPrgGrant.getSysprg().getRptclazz()).getClassLoader();
        }
        PdfCopyFields pdfCopy = new PdfCopyFields(os);
        HashMap<String, Object> reportParams = new HashMap<>();
        ByteArrayOutputStream baos;
        for (Shipment c : entityList) {
            // 设置报表参数
            baos = new ByteArrayOutputStream();
            reportParams.put("company", userManagedBean.getCurrentCompany().getName());
            reportParams.put("companyFullName", userManagedBean.getCurrentCompany().getFullname());
            reportParams.put("tel", userManagedBean.getCurrentCompany().getTel());
            reportParams.put("fax", userManagedBean.getCurrentCompany().getFax());
            reportParams.put("id", c.getId());
            reportParams.put("formid", c.getFormid());
            reportParams.put("JNDIName", currentPrgGrant.getSysprg().getRptjndi());
            try {
                if (!rptdesign.equals("ShipmentLable")) {
                    // 按每个客户打印不同格式
                    reportName = reportPath + c.getCustomerno() + rptdesign + ".rptdesign";
                } else {
                    reportName = reportPath + rptdesign + ".rptdesign";
                }
                // 初始配置
                this.reportInitAndConfig();
                // 生成报表
                this.reportRunAndOutput(reportName, reportParams, null, "pdf", baos);
            } catch (Exception ex) {
                throw ex;
            } finally {
                reportParams.clear();
                c.setStatus("P");
                currentEntity = c;
                update();
            }
            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
        }
        pdfCopy.close();
        this.reportViewPath = reportViewContext + fileName;
        this.preview();
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryFormId != null && !"".equals(queryFormId)) {
                this.model.getFilterFields().put("formid", queryFormId);
            }
            if (queryDateBegin != null) {
                this.model.getFilterFields().put("formdateBegin", queryDateBegin);
            }
            if (queryDateEnd != null) {
                this.model.getFilterFields().put("formdateEnd", queryDateEnd);
            }
            if (queryCreator != null && !"".equals(queryCreator)) {
                this.model.getFilterFields().put("creator", queryCreator);
            }
            if (queryDeptno != null && !"".equals(queryDeptno)) {
                this.model.getFilterFields().put("deptno", queryDeptno);
            }
            if (queryState != null && !"ALL".equals(queryState)) {
                this.model.getFilterFields().put("status", queryState);
            }
        }
    }

    @Override
    public void reset() {
        super.reset();
        queryCreator = userManagedBean.getCurrentUser().getUsername();
        model.getFilterFields().put("status", "N");
        model.getFilterFields().put("creator", getQueryCreator());
    }

    @Override
    public void setEntityList(List<Shipment> entityList) {
        super.setEntityList(entityList);
        if (entityList != null && !entityList.isEmpty()) {
            setCurrentEntity(entityList.get(0));
        }
    }

    /**
     * @return the queryCreator
     */
    public String getQueryCreator() {
        return queryCreator;
    }

    /**
     * @param queryCreator the queryCreator to set
     */
    public void setQueryCreator(String queryCreator) {
        this.queryCreator = queryCreator;
    }

    /**
     * @return the queryDeptno
     */
    public String getQueryDeptno() {
        return queryDeptno;
    }

    /**
     * @param queryDeptno the queryDeptno to set
     */
    public void setQueryDeptno(String queryDeptno) {
        this.queryDeptno = queryDeptno;
    }

    public void generateCode128(String content, float widthSize, double height, String fullFileName) {
        try {
            Code128Bean bean = new Code128Bean();
            // 设置解析度
            final int dpi = 150;
            // Configure the barcode generator
            bean.setModuleWidth(UnitConv.in2mm(widthSize / dpi)); // makes the narrow bar
            bean.setBarHeight(height);
            bean.setCodeset(Code128Constants.CODESET_A);
            bean.doQuietZone(false);
            // 产生Code128文件
            File outputFile = new File(fullFileName);
            OutputStream out = new FileOutputStream(outputFile);
            try {
                // Set up the canvas provider
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/png", dpi, BufferedImage.TYPE_BYTE_BINARY,
                        false, 0);
                // Generate the barcode
                bean.generateBarcode(canvas, content);
                // Signal end of generation
                canvas.finish();
            } finally {
                out.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(ShipmentPrintManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void generateZXingCode128(String content, int width, int height, String filePath, String fileName) {
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.CODE_128, width, height, hints);// 这里是大小
            Path path = FileSystems.getDefault().getPath(filePath, fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
        } catch (WriterException | IOException ex) {
            Logger.getLogger(ShipmentPrintManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
