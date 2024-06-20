/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.jrs;

import cn.hanbell.costctrl.app.Edw640Qrcode;
import cn.hanbell.costctrl.app.Edw640QrcodeDetail;
import cn.hanbell.edw.ejb.EhsHiddenDangerBean;
import cn.hanbell.edw.entity.EhsHiddenDanger;
import cn.hanbell.edw.rpt.Edw640QrcodePrint;
import cn.hanbell.jrs.ResponseInfo;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.ResponseObject;
import cn.hanbell.jrs.SuperRESTForEDW;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.lightshell.comm.BaseLib;
import com.lightshell.comm.SuperEJB;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.DocxRenderOption;
import org.eclipse.birt.report.engine.api.EXCELRenderOption;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;

/**
 *
 * @author C2082
 */
@Stateless
@Path("shbedw/qrcode")
public class QrcodeFacadeREST extends SuperRESTForEDW<EhsHiddenDanger> {


    @EJB
    private EhsHiddenDangerBean ehsHiddenDangerBean;

    public QrcodeFacadeREST() {
        super(EhsHiddenDanger.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return ehsHiddenDangerBean;
    }
    
    @POST
    @Path("edw640qrcode")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage edw640QrCode(Edw640Qrcode qrcode) throws FileNotFoundException, Exception {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

        String url = path.substring(1, path.indexOf("WEB-INF"));
        //ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String appResPath = url + "resources/app/res/";
        String reportPath = url + "rpt//";
        String reportOutputPath = url + "rpt//output//";
        String reportName = "", outputName, reportFormat;
        String fileName = "EDW640" + BaseLib.formatDate("yyyyMMddHHmmss", new Date()) + ".pdf";
        outputName = reportOutputPath + fileName;
        reportName = reportPath + "Edw640QrCode.rptdesign";
        OutputStream os = new FileOutputStream(outputName);
        PdfCopyFields pdfCopy = new PdfCopyFields(os);
        HashMap<String, Object> reportParams = new HashMap<>();
        ByteArrayOutputStream baos;
        Edw640QrcodePrint report = new Edw640QrcodePrint();
        report.initQrcode(qrcode.getQrcodes(), 200, 220, appResPath, "EDW640");
        // 设置报表参数
        baos = new ByteArrayOutputStream();
        reportParams.put("data", qrcode.getQrcodes());
        try {
            // 初始配置
            //this.reportInitAndConfig();
            // 生成报表
            this.reportRunAndOutput(reportName, reportParams, null, "pdf", baos);
        } catch (Exception ex) {
            throw ex;
        } finally {
            reportParams.clear();
        }

        pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
        pdfCopy.close();
        File file = new File(outputName);
        try (FileInputStream fis = new FileInputStream(file);
                ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = bos.toByteArray();
            String base64 = Base64.getEncoder().encodeToString(imageBytes);
           
            ResponseInfo msg=new ResponseInfo("200","success");
            msg.setData(base64);
            return msg;
    }
    }
    public void generateQRCode(String content, int width, int height, String filePath, String fileName) {
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            java.nio.file.Path path = FileSystems.getDefault().getPath(filePath, fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
        } catch (WriterException | IOException ex) {
        }
    }

    public void reportRunAndOutput(String reportName, HashMap params, String outputName, String outputFormat, OutputStream os) throws Exception {

        EngineConfig reportEngineConfig = new EngineConfig();
        // EngineConfig reportEngineConfig
//        if (this.reportClassLoader != null) {
//            this.reportEngineConfig.getAppContext().put("PARENT_CLASSLOADER", this.reportClassLoader);
//        }

        if ((outputName != null || os != null) && outputFormat != null) {
            try {
                Platform.startup(reportEngineConfig);
                IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject("org.eclipse.birt.report.engine.ReportEngineFactory");
                IReportEngine reportEngine = factory.createReportEngine(reportEngineConfig);
                IReportRunnable design = reportEngine.openReportDesign(reportName);
                IRunAndRenderTask task = reportEngine.createRunAndRenderTask(design);
                Object options;
                switch (outputFormat) {
                    case "pdf":
                        options = new PDFRenderOption();
                        break;
                    case "html":
                        options = new HTMLRenderOption();
                        break;
                    case "word":
                        options = new DocxRenderOption();
                        break;
                    case "xls":
                        options = new EXCELRenderOption();
                        break;
                    default:
                        options = new PDFRenderOption();
                        outputFormat = "pdf";
                }

                ((RenderOption) options).setOutputFormat(outputFormat);
                if (os != null) {
                    ((RenderOption) options).setOutputStream(os);
                } else {
                    ((RenderOption) options).setOutputFileName(outputName);
                }

                task.setRenderOption((IRenderOption) options);
                task.setParameterValues(params);
                task.validateParameters();
                task.run();
                task.close();
            } catch (BirtException var15) {
                throw var15;
            } finally {
                Platform.shutdown();
            }

        }
    }

}
