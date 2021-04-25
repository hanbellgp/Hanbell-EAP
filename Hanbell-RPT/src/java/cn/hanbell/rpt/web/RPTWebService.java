/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.web;

import cn.hanbell.eap.comm.MailNotify;
import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.eap.ejb.SystemProgramBean;
import cn.hanbell.eap.entity.SystemProgram;
import cn.hanbell.oa.ejb.HSYPB004Bean;
import cn.hanbell.oa.entity.HSYPB004;
import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.DocxRenderOption;
import org.eclipse.birt.report.engine.api.EXCELRenderOption;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;

/**
 *
 * @author C0160
 */
@WebService(serviceName = "RPT")
@Stateless()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class RPTWebService {

    private final Logger log4j = LogManager.getLogger("cn.hanbell.rpt");

    @EJB
    private MailNotificationBean eapMailBean;
    @EJB
    private SystemProgramBean systemProgramBean;

    @EJB
    private HSYPB004Bean hsypb004Bean;

    private SystemProgram systemProgram;

    private String reportPath;
    private String reportOutputPath;
    private ClassLoader reportClassLoader;
    private IReportEngine reportEngine;
    private EngineConfig reportEngineConfig;

    @PostConstruct
    public void construct() {
        FacesContext fc = FacesContext.getCurrentInstance();
        reportPath = fc.getExternalContext().getRealPath("/")
                + fc.getExternalContext().getInitParameter("cn.hanbell.web.reportpath");
        reportOutputPath = fc.getExternalContext().getRealPath("/")
                + fc.getExternalContext().getInitParameter("cn.hanbell.web.reportoutputpath");
    }

    protected void reportInitAndConfig() {
        reportEngineConfig = new EngineConfig();
        if (reportClassLoader != null) {
            reportEngineConfig.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, reportClassLoader);
        }
    }

    protected void reportRunAndOutput(String reportName, HashMap params, String outputName, String outputFormat, OutputStream os) throws Exception {

        if ((outputName == null && os == null) || outputFormat == null) {
            return;
        }
        try {
            Platform.startup(reportEngineConfig);

            IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);

            reportEngine = factory.createReportEngine(reportEngineConfig);
            IReportRunnable design = reportEngine.openReportDesign(reportName);
            IRunAndRenderTask task = reportEngine.createRunAndRenderTask(design);

            RenderOption options;
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
            options.setOutputFormat(outputFormat);
            if (os != null) {
                options.setOutputStream(os);
            } else {
                options.setOutputFileName(outputName);
            }

            task.setRenderOption(options);
            task.setParameterValues(params);
            task.validateParameters();

            task.run();
            task.close();

        } catch (BirtException ex) {
            throw ex;
        } finally {
            Platform.shutdown();
        }

    }

    protected void setReportClass(ClassLoader value) {
        this.reportClassLoader = value;
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * 发送邮件通知
     *
     * @param system 系统代号
     * @param api 应用API
     * @param formid 识别编号
     * @return 200成功,其他失败
     */
    @WebMethod(operationName = "sendMailNotification")
    public String sendMailNotification(@WebParam(name = "system") String system, @WebParam(name = "api") String api, @WebParam(name = "formid") String formid) {

        switch (api) {
            case "HSY_PB004":
                systemProgram = systemProgramBean.findBySystemAndAPI(system, api);
                if (systemProgram == null) {
                    return "500";
                }
                HSYPB004 entity = hsypb004Bean.findByPSN(formid);
                if (entity == null) {
                    return "500";
                }

                HashMap<String, Object> reportParams = new HashMap<>();
                reportParams.put("JNDIName", systemProgram.getRptjndi());
                reportParams.put("formid", formid);
                String outputFormat = systemProgram.getRptformat();
                String fileName = formid + "." + outputFormat;
                String reportName = reportPath + systemProgram.getRptdesign();
                String outputName = reportOutputPath + fileName;

                try {
                    this.setReportClass(Class.forName(systemProgram.getRptclazz()).getClassLoader());
                    // 初始配置
                    this.reportInitAndConfig();
                    // 生成报表
                    this.reportRunAndOutput(reportName, reportParams, outputName, outputFormat, null);
                    // 发送邮件
                    eapMailBean.clearReceivers();
                    eapMailBean.getAttachments().clear();
                    eapMailBean.setMailSubject("文件申请流程结案通知" + formid);
                    if (entity.getReceptionDept() != null && !"".equals(entity.getReceptionDept())) {
                        String[] depts = entity.getReceptionDept().split(";");
                        if (depts != null) {
                            for (String dept : depts) {
                                eapMailBean.addTo(dept.split("_")[0] + "@hanbell.com.cn");
                            }
                        }
                    }
                    eapMailBean.addCc(hsypb004Bean.getMailAddress(entity.getApplyUser()));
                    eapMailBean.setMailContent(hsypb004Bean.getMailContent(formid));
                    // 获取文件
                    File file = new File(outputName);
                    if (file.exists()) {
                        eapMailBean.addAttachments(file);
                    }
                    eapMailBean.notify(new MailNotify());

                } catch (Exception ex) {
                    log4j.error(ex);
                    return "404";
                }

                break;
            default:
        }

        return "200";
    }

}
