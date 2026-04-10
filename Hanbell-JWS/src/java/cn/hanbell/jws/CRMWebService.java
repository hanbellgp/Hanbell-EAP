package cn.hanbell.jws;

import cn.hanbell.oa.ejb.HKFW004DetailBean;
import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.HZJS034DetailBean;
import cn.hanbell.oa.ejb.VHFW001DetailBean;
import cn.hanbell.oa.ejb.VHFW002Bean;
import cn.hanbell.oa.ejb.VHFW004Bean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;
import vn.hanbell.erp.ejb.CdrlnhadBean;
import vn.hanbell.erp.ejb.InvhadBean;

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
    private VHFW001DetailBean vhfw001DetailBean;
    @EJB
    private VHFW002Bean vhfw002Bean;
    @EJB
    private VHFW004Bean vhfw004Bean;
    @EJB
    private HZJS034DetailBean hzjs034DetailBean;
    @EJB
    private HKFW006Bean hkfw006Bean;

    @EJB
    private InvhadBean VHBinvhadBean;
    @EJB
    private CdrlnhadBean VHBcdrlnhadBean;

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

    //越南强制结案单
    @WebMethod(operationName = "updateCRMREPTDByOAVHFW001Detail")
    public String updateCRMREPTDByOAVHFW001Detail(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = vhfw001DetailBean.updateReptdByOAVHFW001(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPTDByOAHKFW004Detail", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackCRMREPTDByOAVHFW001")
    public String rollbackCRMREPTDByOAVHFW001(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = vhfw001DetailBean.rollbackReptdByOAVHFW001(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackCRMREPTDByOAHKFW004", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    //越南客诉单
    @WebMethod(operationName = "updateCRMSERBQFromOAVHFW002")
    public String updateCRMSERBQFromOAVHFW002(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = vhfw002Bean.updateSERBQ(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMSERBQFromOASERI12", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    //越南录入库存交易单  
    @WebMethod(operationName = "updateCRMWARTBByOAVHFW004")
    public String updateCRMWARTBByOAVHFW004(@WebParam(name = "psn") String psn, @WebParam(name = "step") String step) {
        Boolean ret = false;
        try {
            ret = vhfw004Bean.updateWARTB(psn, step);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMWARTBByOAWARMI05", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackCRMWARTAByOAVHFW004")
    public String rollbackCRMWARTAByOAVHFW004(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = vhfw004Bean.rollbackWARTA(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackCRMWARTBByOAWARMI05", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAProcessInstanceByOAVHFW004")
    public String updateOAProcessInstanceByOAVHFW004(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = vhfw004Bean.updateSubject(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAProcessInstanceByOAWARMI05", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createINV310ByOAVHFW004")
    public String createINV310ByOAVHFW004(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = VHBinvhadBean.initByOAVHFW004(psn);
        } catch (Exception ex) {
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createCDRN20ByOAVHFW004")
    public String createCDRN20ByOAVHFW004(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = VHBcdrlnhadBean.initByOAVHFW004(psn);
        } catch (Exception ex) {
            throw ex;
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
