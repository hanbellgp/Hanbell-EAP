/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jws;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;
import vn.hanbell.erp.ejb.ApmpayBean;
import vn.hanbell.erp.ejb.BudgetDetailBean;
import vn.hanbell.erp.ejb.InvmasBean;
import vn.hanbell.erp.ejb.PurhaskBean;

/**
 *
 * @author C0160
 */
@WebService(serviceName = "VHBERP")
@Stateless()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class VHBERPWebService {

    @EJB
    private InvmasBean invmasBean;
    @EJB
    private BudgetDetailBean budgetDetailBean;
    @EJB
    private ApmpayBean apmpayBean;
    @EJB
    private PurhaskBean purhaskBean;

    private final org.apache.logging.log4j.Logger log4j = LogManager.getLogger();

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "createINV140ByOAVHTK001")
    public String createINV140ByOAVHTK001(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invmasBean.initByOAVHTK001(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createINV140ByOAVHTK001", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "addBudgetPlanByOAVHTV003")
    public String addBudgetPlanByOAVHTV003(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = budgetDetailBean.addByOAVHTV003(psn);
        } catch (Exception ex) {
            log4j.error("addBudgetPlanByOAVHTV003时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "addBudgetPlanByOAVHTV001")
    public String addBudgetPlanByOAVHTV001(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = budgetDetailBean.addByOAVHTV001(psn);
        } catch (Exception ex) {
            log4j.error("addBudgetPlanByOAVHTV001时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "addBudgetPlanByOAVHTV002")
    public String addBudgetPlanByOAVHTV002(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = budgetDetailBean.addByOAVHTV002(psn);
        } catch (Exception ex) {
            log4j.error("addBudgetPlanByOAVHTV002时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createAPM525ByOAVHTV003")
    public String createAPM525ByOAVHTV003(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmpayBean.initByOAVHTV003(psn);
        } catch (Exception ex) {
            log4j.error("createAPM525ByOAVHTV003时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createAPM525ByOAVHTV001")
    public String createAPM525ByOAVHTV001(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmpayBean.initByOAVHTV001(psn);
        } catch (Exception ex) {
            log4j.error("createAPM525ByOAVHTV001时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createAPM525ByOAVHTV002")
    public String createAPM525ByOAVHTV002(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmpayBean.initByOAVHTV002(psn);
        } catch (Exception ex) {
            log4j.error("createAPM525ByOAJZGHD时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "subtractBudgetPlanByOAVHTV003")
    public String subtractBudgetPlanByOAVHTV003(@WebParam(name = "psn") String psn,
            @WebParam(name = "isReject") String isReject) {
        Boolean ret = false;
        try {
            if ("1".equals(isReject)) {
                ret = apmpayBean.subtractBudgetPlanByOAVHTV003(psn);
            } else {
                return "200";
            }
        } catch (Exception ex) {
            log4j.error("subtractBudgetPlanByOAVHTV003时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }
    
    @WebMethod(operationName = "createPUR210ByOAVHTM001")
    public String createPUR210ByOAVHTM001(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = purhaskBean.initByOAVHTM001(psn);
        } catch (Exception ex) {
            log4j.error("createPUR210ByOAQGD时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "subtractBudgetPlanByOAVHTV001")
    public String subtractBudgetPlanByOAVHTV001(@WebParam(name = "psn") String psn,
            @WebParam(name = "isReject") String isReject) {
        Boolean ret = false;
        try {
            if ("1".equals(isReject)) {
                ret = apmpayBean.subtractBudgetPlanByOAVHTV001(psn);
            } else {
                return "200";
            }
        } catch (Exception ex) {
            log4j.error("subtractBudgetPlanByOAVHTV001时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "subtractBudgetPlanByOAVHTV002")
    public String subtractBudgetPlanByOAVHTV002(@WebParam(name = "psn") String psn,
            @WebParam(name = "isReject") String isReject) {
        Boolean ret = false;
        try {
            if ("1".equals(isReject)) {
                ret = apmpayBean.subtractBudgetPlanByOAVHTV002(psn);
            } else {
                return "200";
            }
        } catch (Exception ex) {
            log4j.error("subtractBudgetPlanByOAVHTV002时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

}
