package cn.hanbell.jws;

import cn.hanbell.oa.ejb.HKFW004DetailBean;
import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.HZJS034DetailBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
@WebService(serviceName = "CRM")
@Stateless()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class CRMWebService {

    @EJB
    private HKFW004DetailBean hzfw004DetailBean;
    @EJB
    private HZJS034DetailBean hzjs034DetailBean;
    @EJB
    private HKFW006Bean hkfw006Bean;

    private final org.apache.logging.log4j.Logger log4j = LogManager.getLogger();

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "updateCRMREPTDByOAHKFW004Detail")
    public String updateCRMREPTDByOAHKFW004Detail(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hzfw004DetailBean.updateReptdByOAHKFW004(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPTDByOAHKFW004Detail", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackCRMREPTDByOAHKFW004")
    public String rollbackCRMREPTDByOAHKFW004(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hzfw004DetailBean.rollbackReptdByOAHKFW004(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackCRMREPTDByOAHKFW004", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateREPTDByOAHKFW006")
    public String updateREPTDByOAHKFW006(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkfw006Bean.updateReptdByOAHKFW006(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateREPTDByOAHKFW006", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMREPTDByOAHKFW006")
    public String updateCRMREPTDByOAHKFW006(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkfw006Bean.updateReptdByOAHKFW006(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPTDByOAHKFW006", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

}
