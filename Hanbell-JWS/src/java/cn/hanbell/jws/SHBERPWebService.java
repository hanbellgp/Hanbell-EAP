/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jws;

import cn.hanbell.Annotation.WebServiceDescriptAnnotation;
import cn.hanbell.Invocation.WebServiceInterceptor;
import cn.hanbell.erp.ejb.ApmpayBean;
import cn.hanbell.erp.ejb.BudgetDetailBean;
import cn.hanbell.erp.ejb.CdrbrhadBean;
import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.ejb.CdrlnhadBean;
import cn.hanbell.erp.ejb.InvbalBean;
import cn.hanbell.erp.ejb.InvbatBean;
import cn.hanbell.erp.ejb.InvclsBean;
import cn.hanbell.erp.ejb.InvhadBean;
import cn.hanbell.erp.ejb.InvmasBean;
import cn.hanbell.erp.ejb.ManmotBean;
import cn.hanbell.erp.ejb.PurhaskBean;
import cn.hanbell.erp.ejb.PurvdrBean;
import cn.hanbell.oa.ejb.HZCW028Bean;
import cn.hanbell.oa.ejb.HZCW033Bean;
import java.math.BigDecimal;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 */
@WebService(serviceName = "WebService")
@Stateless()
@SOAPBinding(style = SOAPBinding.Style.RPC)
@Interceptors(WebServiceInterceptor.class)
public class SHBERPWebService {

    // EJBForEFGP
    @EJB
    private HZCW028Bean hzcw028Bean;
    @EJB
    private HZCW033Bean hzcw033Bean;

    // EJBForERP
    @EJB
    private ApmpayBean apmpayBean;
    @EJB
    private BudgetDetailBean budgetDetailBean;
    @EJB
    private CdrcusBean cdrcusBean;
    @EJB
    private CdrlnhadBean cdrlnhadBean;
    @EJB
    private CdrbrhadBean cdrbrhadBean;
    @EJB
    private InvbalBean invbalBean;
    @EJB
    private InvbatBean invbatBean;
    @EJB
    private InvclsBean invclsBean;
    @EJB
    private InvhadBean invhadBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private PurhaskBean purhaskBean;
    @EJB
    private PurvdrBean purvdrBean;
    @EJB
    private ManmotBean manmotBean;

    private final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    @WebMethod(operationName = "hello")
    @WebServiceDescriptAnnotation(value = "你好,JAVA")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "hello2")
    @WebServiceDescriptAnnotation(value = "你好,JAVA2")
    public String hello2(@WebParam(name = "name") String txt) {
        Random random = new Random();
        boolean ret = random.nextBoolean();
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "hello3")
    public String hello3(@WebParam(name = "name") String txt) {
        boolean ret = false;
        try {
            Random random = new Random();
            boolean randomRet = random.nextBoolean();
            if (randomRet) {
                System.out.print(1 / 0);
            }
            ret = true;
        } catch (Exception e) {
            throw e;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "addBudgetPlanByOABXD")
    @WebServiceDescriptAnnotation(value = "报销单追加预算")
    public String addBudgetPlanByOABXD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = budgetDetailBean.addByOABXD(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "addBudgetPlanByOAJZD")
    @WebServiceDescriptAnnotation(value = "借支单追加预算")
    public String addBudgetPlanByOAJZD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = budgetDetailBean.addByOAJZD(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "addBudgetPlanByOAJZGHD")
    @WebServiceDescriptAnnotation(value = "借支单追加预算")
    public String addBudgetPlanByOAJZGHD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = budgetDetailBean.addByOAJZGHD(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createAPM525ByOABXD")
    @WebServiceDescriptAnnotation(value = "OA费用预算调整单调整ERP预算")
    public String createAPM525ByOABXD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmpayBean.initByOABXD(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createAPM525ByOAJZD")
    @WebServiceDescriptAnnotation(value = "借支单抛转APM525")
    public String createAPM525ByOAJZD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmpayBean.initByOAJZD(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createAPM525ByOAJZGHD")
    @WebServiceDescriptAnnotation(value = "归还单抛转APM525")
    public String createAPM525ByOAJZGHD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmpayBean.initByOAJZGHD(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createCDRN20ByOAHKJH007")
    @WebServiceDescriptAnnotation(value = "集团内借机申请单抛转CDRN20(借支单)")
    public String createCDRN20ByOAHKJH007(@WebParam(name = "psn") String psn) {
        String ret = null;
        try {
            ret = cdrlnhadBean.initByOAHKJH007(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret != null && !"".equals(ret)) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createCDRN20ByOAWARMI05")
    @WebServiceDescriptAnnotation(value = "库存交易单抛转CDRN20(借支单)")
    public String createCDRN20ByOAWARMI05(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = cdrlnhadBean.initByOAWARI05(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createCDRN30ByOAHKFW006CDRN30")
    @WebServiceDescriptAnnotation(value = "退货通知单(HK_FW006_CDRN30)抛转CDRN30单据抛转归还单")
    public String createCDRN30ByOAHKFW006CDRN30(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = cdrbrhadBean.initByOAHKFW006(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    // 客户拷贝
    @WebMethod(operationName = "createCustomerByOAHKJH003")
    @WebServiceDescriptAnnotation(value = "客户基本信息抛转申请表抛转ERP")
    public String createCustomerByOAHKJH003(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = cdrcusBean.cloneByOAHKJH003(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createCustomerByOAPSN")
    @WebServiceDescriptAnnotation(value = "客户资料抛转")
    public String createCustomerByOAPSN(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = cdrcusBean.initByOAPSN(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createINV140ByOAJHSQD")
    @WebServiceDescriptAnnotation(value = "件号申请单抛转")
    public String createINV140ByOAJHSQD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invmasBean.initByOAJHSQD(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createInvclsByOAHKJS007") // 品号大类申请单
    @WebServiceDescriptAnnotation(value = "品号大类申请单抛转")
    public String createInvclsByOAHKJS007(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invclsBean.createByOAHKJS007(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createINV140ByOAJHZYD")
    @WebServiceDescriptAnnotation(value = "件号转移单抛转")
    public String createINV140ByOAJHZYD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invmasBean.initByOASHBINV140(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createINV310ByOAHKFW006INV310")
    @WebServiceDescriptAnnotation(value = "HK_FW006_INV130抛转INV310")
    public String createINV310ByOAHKFW006INV310(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invhadBean.initByOAHKFW006(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createINV310ByOAWARMI05")
    @WebServiceDescriptAnnotation(value = "库存交易单抛转")
    public String createINV310ByOAWARMI05(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invhadBean.initByOAWARMI05(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createINV325ByOASHBERPINV325")
    @WebServiceDescriptAnnotation(value = "生产制程领退料抛转")
    public String createINV325ByOASHBERPINV325(@WebParam(name = "psn") String psn) {
        String ret = null;
        try {
            ret = invhadBean.initByOASHBERPINV325(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret != null && !"".equals(ret)) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createPUR120ByOAPSN")
    @WebServiceDescriptAnnotation(value = "新增厂商资料抛转")
    public String createPUR120ByOAPSN(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = purvdrBean.initByOAPSN(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createPUR210ByOAQGD")
    @WebServiceDescriptAnnotation(value = "请购单抛转")
    public String createPUR210ByOAQGD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = purhaskBean.initByOAQGD(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    // 厂商
    @WebMethod(operationName = "createPurvdrByOAHKJH004")
    @WebServiceDescriptAnnotation(value = "厂商基本信息抛转表(OA)抛转")
    public String createPurvdrByOAHKJH004(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = purvdrBean.cloneByOAHKJH004(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createINV310ByOAHKPB054")
    @WebServiceDescriptAnnotation(value = "质量扣款申请单抛转INV310")
    public String createINV310ByOAHKPB054(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invhadBean.initByOAHKPB054(psn);
        } catch (Exception ex) {
            log4j.error("createINV310ByOAHKPB054", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "isLessThenInvbal")
    @WebServiceDescriptAnnotation(value = "检查库存数量是否>领退料数量")
    public String isLessThenInvbal(@WebParam(name = "facno") String facno, @WebParam(name = "prono") String prono,
            @WebParam(name = "itnbr") String itnbr, @WebParam(name = "wareh") String wareh,
            @WebParam(name = "qty") String qty) {
        Boolean ret;
        try {
            invbalBean.setCompany(facno);
            ret = invbalBean.isGreatThenInvbal(facno, prono, itnbr, wareh, BigDecimal.valueOf(Double.valueOf(qty)));
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "404";
        } else {
            return "200";
        }
    }

    @WebMethod(operationName = "isLessThenInvbat")
    @WebServiceDescriptAnnotation(value = "检查库存数量是否>领退料数量")
    public String isLessThenInvbat(@WebParam(name = "facno") String facno, @WebParam(name = "prono") String prono,
            @WebParam(name = "itnbr") String itnbr, @WebParam(name = "wareh") String wareh,
            @WebParam(name = "fixnr") String fixnr, @WebParam(name = "varnr") String varnr,
            @WebParam(name = "qty") String qty) {
        Boolean ret;
        try {
            invbatBean.setCompany(facno);
            ret = invbatBean.isGreatThenInvbat(facno, prono, itnbr, wareh, fixnr, varnr,
                    BigDecimal.valueOf(Double.valueOf(qty)));
        } catch (Exception ex) {

            throw ex;
        }
        if (ret) {
            return "404";
        } else {
            return "200";
        }
    }

    @WebMethod(operationName = "subtractBudgetPlanByOABXD")
    @WebServiceDescriptAnnotation(value = "报销单扣除预算")
    public String subtractBudgetPlanByOABXD(@WebParam(name = "psn") String psn,
            @WebParam(name = "isReject") String isReject) {
        Boolean ret = false;
        try {
            if ("1".equals(isReject)) {
                ret = apmpayBean.subtractBudgetPlanByOABXD(psn);
            } else {
                return "200";
            }
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "subtractBudgetPlanByOAJZD")
    @WebServiceDescriptAnnotation(value = "借支单扣除预算")
    public String subtractBudgetPlanByOAJZD(@WebParam(name = "psn") String psn,
            @WebParam(name = "isReject") String isReject) {
        Boolean ret = false;
        try {
            if ("1".equals(isReject)) {
                ret = apmpayBean.subtractBudgetPlanByOAJZD(psn);
            } else {
                return "200";
            }
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "subtractBudgetPlanByOAJZGHD")
    @WebServiceDescriptAnnotation(value = "归还单扣除预算")
    public String subtractBudgetPlanByOAJZGHD(@WebParam(name = "psn") String psn,
            @WebParam(name = "isReject") String isReject) {
        Boolean ret = false;
        try {
            if ("1".equals(isReject)) {
                ret = apmpayBean.subtractBudgetPlanByOAJZGHD(psn);
            } else {
                return "200";
            }
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCustomerByOAPSN")
    @WebServiceDescriptAnnotation(value = "客户基本信息变更申请单抛转")
    public String updateCustomerByOAPSN(@WebParam(name = "psn") String psn) {

        Boolean ret = false;
        try {
            ret = cdrcusBean.updateByOAPSN(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateINV140ByOAHKJS001")
    @WebServiceDescriptAnnotation(value = "工程表更申请单抛转件号")
    public String updateINV140ByOAHKJS001(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invmasBean.updateByOAHKJS001(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateINV140ByOAJHXGD")
    @WebServiceDescriptAnnotation(value = "件号名称规格修改表抛转")
    public String updateINV140ByOAJHXGD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invmasBean.updateByOASHBINV146(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updatePUR120ByOAPSN")
    @WebServiceDescriptAnnotation(value = "厂商基本信息变更申请表抛转")
    public String updatePUR120ByOAPSN(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = purvdrBean.updateByOAPSN(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateMAN345ByOAPSN")
    @WebServiceDescriptAnnotation(value = "采购草稿申请抛转ERP")
    public String updateMAN345ByOAPSN(@WebParam(name = "psn") String psn, @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            ret = manmotBean.updateByOAPSN(psn, status);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }
}
