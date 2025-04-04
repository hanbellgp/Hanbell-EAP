/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.eap.ejb.SystemProgramBean;
import cn.hanbell.eap.entity.SystemProgram;
import cn.hanbell.oa.ejb.HKCW005Bean;
import cn.hanbell.oa.ejb.HZCW028Bean;
import cn.hanbell.oa.ejb.HZCW030Bean;
import cn.hanbell.oa.ejb.HZCW033Bean;
import cn.hanbell.oa.ejb.ProcessInstanceBean;
import cn.hanbell.oa.ejb.ZQ001Bean;
import cn.hanbell.oa.entity.HKCW005;
import cn.hanbell.oa.entity.ProcessInstance;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperReportManagedBean;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.DocxRenderOption;
import org.eclipse.birt.report.engine.api.EXCELRenderOption;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "reportManagedBean")
@ViewScoped
public class ReportManagedBean extends SuperReportManagedBean {

    @EJB
    private SystemProgramBean systemProgramBean;
    @EJB
    private ProcessInstanceBean processInstanceBean;
    @EJB
    private HZCW028Bean hzcw028Bean;
    @EJB
    private HZCW033Bean hzcw033Bean;
    @EJB
    private HZCW030Bean hzcw030Bean;
    @EJB
    private HKCW005Bean hkcw005Bean;
    
        @EJB
    private ZQ001Bean zq001Bean;
    private String msg;
    private Map<String, String[]> paramMap;

    protected SystemProgram systemProgram;

    public ReportManagedBean() {
    }

    @Override
    public void construct() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.reportPath = fc.getExternalContext().getRealPath("/")
                + fc.getExternalContext().getInitParameter("cn.hanbell.web.reportpath");
        this.reportOutputPath = fc.getExternalContext().getRealPath("/")
                + fc.getExternalContext().getInitParameter("cn.hanbell.web.reportoutputpath");
        this.reportViewContext = fc.getExternalContext().getInitParameter("cn.hanbell.web.reportviewcontext");
        msg = reportPath;
        super.construct();
    }

    @Override
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        paramMap = fc.getExternalContext().getRequestParameterValuesMap();
        try {
            if (paramMap == null || paramMap.isEmpty() || !paramMap.containsKey("system") || !paramMap.containsKey("api")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("params.xhtml");
            }
            print();
        } catch (Exception ex) {
            Logger.getLogger(ReportManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void print() throws Exception {
        String system = paramMap.get("system")[0];
        String api = paramMap.get("api")[0];
        systemProgram = systemProgramBean.findBySystemAndAPI(system, api);
        if (systemProgram == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("deny.xhtml");
        }
        HashMap<String, Object> reportParams = new HashMap<>();
        reportParams.put("JNDIName", systemProgram.getRptjndi());
        if (paramMap.containsKey("formid")) {
            if ("EFGP".equals(system)) {
                ProcessInstance pi = processInstanceBean.findByOID(paramMap.get("formid")[0]);
                reportParams.put("formid", pi.getSerialNumber());
            } else {
                reportParams.put("formid", paramMap.get("formid")[0]);
            }
        }
        // 加入列印者参数user
        if (paramMap.containsKey("user")) {
            reportParams.put("user", paramMap.get("user")[0]);
        }
        if (paramMap.containsKey("filterFields")) {
            reportParams.put("filterFields", paramMap.get("filterFields")[0]);
        }
        if (paramMap.containsKey("sortFields")) {
            reportParams.put("sortFields", paramMap.get("sortFields")[0]);
        }
        reportOutputFormat = systemProgram.getRptformat();
         SecureRandom secureRandom = new SecureRandom();

        // 生成一个 1000 位的随机数
        BigInteger randomNumber = new BigInteger(20, secureRandom);
        String fileName = systemProgram.getApi() +randomNumber+ "."
                + reportOutputFormat;
        String reportName = reportPath + systemProgram.getRptdesign();
        String outputName = reportOutputPath + fileName;
        reportViewPath = reportViewContext + fileName;
        try {
            if ("EFGP".equals(system)) {
                OutputStream os = new FileOutputStream(outputName);
                PdfCopyFields pdfCopy = new PdfCopyFields(os);
                ByteArrayOutputStream baos;
                // 生成表单内容
                this.setReportClass(Class.forName(systemProgram.getRptclazz()).getClassLoader());
                // 初始配置
                this.reportInitAndConfig();
                // 生成报表
                baos = new ByteArrayOutputStream();
                this.reportRunAndOutput(reportName, reportParams, null, "pdf", baos);
                pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                // 报销单有差旅明细单独列印
                if ("HZ_CW028".equals(api)) {
                    String formSerialNumber = hzcw028Bean.findByPSN(reportParams.get("formid")).getFormSerialNumber();
                    if (hzcw028Bean.getTrafficDetail(formSerialNumber).size() > 0) {
                        baos = new ByteArrayOutputStream();
                        this.reportRunAndOutput(reportPath + "hzcw02802.rptdesign", reportParams, null, "pdf", baos);
                        pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                    }
                }
                //借支归还单有差旅明细单独列印
                if ("HZ_CW033".equals(api)) {
                    String formSerialNumber = hzcw033Bean.findByPSN(reportParams.get("formid")).getFormSerialNumber();
                    if (hzcw033Bean.getTrafficDetail(formSerialNumber).size() > 0) {
                        baos = new ByteArrayOutputStream();
                        this.reportRunAndOutput(reportPath + "hzcw03301.rptdesign", reportParams, null, "pdf", baos);
                        pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                    }
                }
                if ("HZ_CW030".equals(api)) {
                    String formSerialNumber = hzcw030Bean.findByPSN(reportParams.get("formid")).getFormSerialNumber();
                    String projecttype = hzcw030Bean.findByPSN(reportParams.get("formid")).getProject();
                    //费用预算追加
                    if ("1".equals(projecttype)) {
                        if (hzcw030Bean.getDetailList1(formSerialNumber).size() > 0) {
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hzcw03001.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                        }
                        if (hzcw030Bean.getDetailList2(formSerialNumber).size() > 0) {
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hzcw03002.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                        }
                        //费用预算调拨
                    } else if ("2".equals(projecttype)) {
                        if (hzcw030Bean.getDetailList3(formSerialNumber).size() > 0) {
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hzcw03003.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                        }
                        if (hzcw030Bean.getDetailList4(formSerialNumber).size() > 0) {
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hzcw03004.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                        }
                    }
                }
                if ("HK_CW005".equals(api)) {
                    ProcessInstance pi = processInstanceBean.findByOID(paramMap.get("formid")[0]);
                    HKCW005 hkcw005 = hkcw005Bean.findByPSN(pi.getSerialNumber());
                    switch (hkcw005.getFkxz()) {
                        case "2"://理财
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hkcw00501.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                            break;
                        case "3"://金融衍生性产品
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hkcw00502.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                            break;
                        case "4"://证券投资补充表
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hkcw00503.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                            break;
                        case "5"://对外投资款补充表
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hkcw00504.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                            break;
                        case "14"://定存
                            baos = new ByteArrayOutputStream();
                            this.reportRunAndOutput(reportPath + "hkcw00505.rptdesign", reportParams, null, "pdf", baos);
                            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                            break;
                    }
                }
                
                // 生成签核流程
                this.setReportClass(Class.forName("cn.hanbell.efgp.rpt.ProcessCheckReport").getClassLoader());// 设置成流程报表
                reportParams.remove("JNDIName");
                reportParams.put("JNDIName",
                        "java:global/Hanbell-EAP/EFGP-ejb/ProcessCheckBean!cn.hanbell.oa.ejb.ProcessCheckBean");// 设置成流程报表Bean
                 
                // 初始配置
                this.reportInitAndConfig();
                
                // 生成报表
                baos = new ByteArrayOutputStream();
                //服务工作支援单打印签核意见
                if ("HK_FW005".equals(api)) {
                    this.reportRunAndOutput(reportPath + "processcheck_fw.rptdesign", reportParams, null, "pdf", baos);
                } else {
                    this.reportRunAndOutput(reportPath + "processcheck.rptdesign", reportParams, null, "pdf", baos);
                }
                pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
                // 生成合并文件
                pdfCopy.close();
            } else {
                this.setReportClass(Class.forName(systemProgram.getRptclazz()).getClassLoader());
                // 初始配置
                this.reportInitAndConfig();
                // 生成报表
                this.reportRunAndOutput(reportName, reportParams, outputName, reportOutputFormat, null);
            }
            // 预览报表
            this.preview();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @Override
    protected void reportRunAndOutput(String reportName, HashMap params, String outputName, String outputFormat, OutputStream os) throws Exception {
        if ((outputName != null || os != null) && outputFormat != null) {
            try {
                Platform.startup(this.reportEngineConfig);
                IReportEngineFactory factory = (IReportEngineFactory)Platform.createFactoryObject("org.eclipse.birt.report.engine.ReportEngineFactory");
                this.reportEngine = factory.createReportEngine(this.reportEngineConfig);
                IReportRunnable design = this.reportEngine.openReportDesign(reportName);
                IRunAndRenderTask task = this.reportEngine.createRunAndRenderTask(design);
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

                ((RenderOption)options).setOutputFormat(outputFormat);
                if (os != null) {
                    ((RenderOption)options).setOutputStream(os);
                } else {
                    ((RenderOption)options).setOutputFileName(outputName);
                }

                task.setRenderOption((IRenderOption)options);
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

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
