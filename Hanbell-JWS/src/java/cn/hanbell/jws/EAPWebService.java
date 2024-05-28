/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package cn.hanbell.jws;

import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.ejb.DDGABean;
import cn.hanbell.crm.ejb.DDGCBean;
import cn.hanbell.crm.ejb.REPPABean;
import cn.hanbell.crm.ejb.REPTABean;
import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.ejb.SERBQBean;
import cn.hanbell.crm.ejb.SERCABean;
import cn.hanbell.crm.ejb.SyncCRMBean;
import cn.hanbell.crm.ejb.WARMBBean;
import cn.hanbell.crm.entity.CRMGD;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.DDGA;
import cn.hanbell.crm.entity.DDGB;
import cn.hanbell.crm.entity.DDGC;
import cn.hanbell.crm.entity.DDGD;
import cn.hanbell.crm.entity.REPPA;
import cn.hanbell.crm.entity.REPPB;
import cn.hanbell.crm.entity.REPTA;
import cn.hanbell.crm.entity.REPTAPK;
import cn.hanbell.crm.entity.REPTC;
import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.crm.entity.SERCA;
import cn.hanbell.crm.entity.SERCAPK;
import cn.hanbell.crm.entity.WARMB;
import cn.hanbell.eam.ejb.AssetAcceptanceBean;
import cn.hanbell.eam.ejb.AssetApplyBean;
import cn.hanbell.eam.ejb.AssetCardBean;
import cn.hanbell.eam.ejb.AssetCategoryBean;
import cn.hanbell.eam.ejb.AssetDisposeBean;
import cn.hanbell.eam.ejb.AssetItemBean;
import cn.hanbell.eam.ejb.AssetScrapBean;
import cn.hanbell.eam.ejb.StationeryDistributeBean;
import cn.hanbell.eam.ejb.WarehouseBean;
import cn.hanbell.eam.entity.AssetAcceptance;
import cn.hanbell.eam.entity.AssetAcceptanceDetail;
import cn.hanbell.eam.entity.AssetApply;
import cn.hanbell.eam.entity.AssetApplyDetail;
import cn.hanbell.eam.entity.AssetCard;
import cn.hanbell.eam.entity.AssetCategory;
import cn.hanbell.eam.entity.AssetDispose;
import cn.hanbell.eam.entity.AssetDisposeDetail;
import cn.hanbell.eam.entity.AssetDistribute;
import cn.hanbell.eam.entity.AssetDistributeDetail;
import cn.hanbell.eam.entity.AssetItem;
import cn.hanbell.eam.entity.AssetScrap;
import cn.hanbell.eam.entity.AssetScrapDetail;
import cn.hanbell.eap.comm.MailNotify;
import cn.hanbell.eap.ejb.CustomerComplaintBean;
import cn.hanbell.eap.ejb.CustomerComplaintExpenseBean;
import cn.hanbell.eap.ejb.CustomerComplaintMaterialBean;
import cn.hanbell.eap.ejb.DemandsBean;
import cn.hanbell.eap.ejb.DepartmentBean;
import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.eap.ejb.MailSettingBean;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.CustomerComplaint;
import cn.hanbell.eap.entity.CustomerComplaintExpense;
import cn.hanbell.eap.entity.CustomerComplaintMaterial;
import cn.hanbell.eap.entity.Demands;
import cn.hanbell.eap.entity.Department;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.ecpur.ejb.ECPurvdrBean;
import cn.hanbell.erp.ejb.Apmanp585hBean;
import cn.hanbell.erp.ejb.ApmaphBean;
import cn.hanbell.erp.ejb.ApmbilBean;
import cn.hanbell.erp.ejb.ApmchpBean;
import cn.hanbell.erp.ejb.ApmpayBean;
import cn.hanbell.erp.ejb.BomasryBean;
import cn.hanbell.erp.ejb.BomsubBean;
import cn.hanbell.erp.ejb.CdrbhadBean;
import cn.hanbell.erp.ejb.CdrbomsubDefaultBean;
import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.ejb.CdrcusmanBean;
import cn.hanbell.erp.ejb.CdrhadBean;
import cn.hanbell.erp.ejb.CdrhmasBean;
import cn.hanbell.erp.ejb.CdrhpopsfkBean;
import cn.hanbell.erp.ejb.CdrlndtaBean;
import cn.hanbell.erp.ejb.CdrlnhadBean;
import cn.hanbell.erp.ejb.CdrpaydscBean;
import cn.hanbell.erp.ejb.CdrqasryBean;
import cn.hanbell.erp.ejb.CdrqbomsubBean;
import cn.hanbell.erp.ejb.CdrqhadBean;
import cn.hanbell.erp.ejb.CdrqsysBean;
import cn.hanbell.erp.ejb.CdrsfkpartBean;
import cn.hanbell.erp.ejb.CdrsfksortsBean;
import cn.hanbell.erp.ejb.CdrsfkspecBean;
import cn.hanbell.erp.ejb.CdrsysBean;
import cn.hanbell.erp.ejb.CrmreppalogBean;
import cn.hanbell.erp.ejb.InvclswahBean;
import cn.hanbell.erp.ejb.InvhadBean;
import cn.hanbell.erp.ejb.InvmasBean;
import cn.hanbell.erp.ejb.InvwhBean;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.ejb.PricingGroupBean;
import cn.hanbell.erp.ejb.PurachBean;
import cn.hanbell.erp.ejb.PurhaskBean;
import cn.hanbell.erp.ejb.PurvdrBean;
import cn.hanbell.erp.ejb.SecgprgBean;
import cn.hanbell.erp.entity.Apmanp585h;
import cn.hanbell.erp.entity.Apmaph;
import cn.hanbell.erp.entity.Bomsub;
import cn.hanbell.erp.entity.CdrbomsubDefault;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Cdrcusman;
import cn.hanbell.erp.entity.Cdrdpopsfk;
import cn.hanbell.erp.entity.CdrdpopsfkPK;
import cn.hanbell.erp.entity.Cdrhpopsfk;
import cn.hanbell.erp.entity.CdrhpopsfkPK;
import cn.hanbell.erp.entity.Cdrpaydsc;
import cn.hanbell.erp.entity.Cdrqasry;
import cn.hanbell.erp.entity.CdrqasryPK;
import cn.hanbell.erp.entity.Cdrqbomsub;
import cn.hanbell.erp.entity.CdrqbomsubPK;
import cn.hanbell.erp.entity.Cdrqdta;
import cn.hanbell.erp.entity.CdrqdtaPK;
import cn.hanbell.erp.entity.Cdrqhad;
import cn.hanbell.erp.entity.CdrqhadPK;
import cn.hanbell.erp.entity.Cdrsfkpart;
import cn.hanbell.erp.entity.Cdrsfksorts;
import cn.hanbell.erp.entity.Cdrsfkspec;
import cn.hanbell.erp.entity.Crmreppalog;
import cn.hanbell.erp.entity.Invclswah;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.erp.entity.Puracd;
import cn.hanbell.erp.entity.Purach;
import cn.hanbell.erp.entity.Purhask;
import cn.hanbell.kpi.ejb.ScorecardAuditorBean;
import cn.hanbell.kpi.ejb.ScorecardBean;
import cn.hanbell.kpi.ejb.ScorecardDetailBean;
import cn.hanbell.kpi.entity.Scorecard;
import cn.hanbell.kpi.entity.ScorecardAuditor;
import cn.hanbell.kpi.entity.ScorecardDetail;
import cn.hanbell.oa.ejb.HKCG007Bean;
import cn.hanbell.oa.ejb.HKCG011Bean;
import cn.hanbell.oa.ejb.HKCG016Bean;
import cn.hanbell.oa.ejb.HKCW002Bean;
import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.HKGL038Bean;
import cn.hanbell.oa.ejb.HKJH001Bean;
import cn.hanbell.oa.ejb.HZCW028Bean;
import cn.hanbell.oa.ejb.HZCW033Bean;
import cn.hanbell.oa.ejb.HZCW034Bean;
import cn.hanbell.oa.ejb.HZJS034Bean;
import cn.hanbell.oa.ejb.SERI12Bean;
import cn.hanbell.oa.ejb.HKCW003Bean;
import cn.hanbell.oa.ejb.HKFW004DetailBean;
import cn.hanbell.oa.ejb.HKFW005Bean;
import cn.hanbell.oa.ejb.HKGC002Bean;
import cn.hanbell.oa.ejb.HKGC003Bean;
import cn.hanbell.oa.ejb.HKGL060Bean;
import cn.hanbell.oa.ejb.HKCG019Bean;
import cn.hanbell.oa.ejb.HKCG020Bean;
import cn.hanbell.oa.ejb.HKCW015Bean;
import cn.hanbell.oa.ejb.HKGL004Bean;
import cn.hanbell.oa.ejb.HKGL031Bean;
import cn.hanbell.oa.ejb.HKGL034Bean;
import cn.hanbell.oa.ejb.HKGL034DetailBean;
import cn.hanbell.oa.ejb.HKGL037Bean;
import cn.hanbell.oa.ejb.HKGl076Bean;
import cn.hanbell.oa.ejb.HKJH005Bean;
import cn.hanbell.oa.ejb.HKJH006Bean;
import cn.hanbell.oa.ejb.HKXQB001Bean;
import cn.hanbell.oa.ejb.HKYX011Bean;
import cn.hanbell.oa.ejb.HKYX014Bean;
import cn.hanbell.oa.ejb.HSPB015Bean;
import cn.hanbell.oa.ejb.HZGL004Bean;
import cn.hanbell.oa.ejb.HZGL004BizDetailBean;
import cn.hanbell.oa.ejb.ParticipantActivityInstanceBean;
import cn.hanbell.oa.ejb.ProcessInstanceBean;
import cn.hanbell.oa.ejb.SHBCRMREPI13Bean;
import cn.hanbell.oa.ejb.SHBCRMSERI12Bean;
import cn.hanbell.oa.ejb.SHBERPAPM828Bean;
import cn.hanbell.oa.ejb.SHBINV140Bean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.ejb.VHTV002Bean;
import cn.hanbell.oa.ejb.WARMI05Bean;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.ejb.WorkItemBean;
import cn.hanbell.oa.entity.Functions;
import cn.hanbell.oa.entity.HKCG011;
import cn.hanbell.oa.entity.HKCG016;
import cn.hanbell.oa.entity.HKCG019;
import cn.hanbell.oa.entity.HKCG020;
import cn.hanbell.oa.entity.HKCW002;
import cn.hanbell.oa.entity.HKCW002Detail;
import cn.hanbell.oa.entity.HKCW015;
import cn.hanbell.oa.entity.HKGL004;
import cn.hanbell.oa.entity.HKGL034;
import cn.hanbell.oa.entity.HKGL034Detail;
import cn.hanbell.oa.entity.HKGL060;
import cn.hanbell.oa.entity.HKGL060Detail;
import cn.hanbell.oa.entity.HKGL076;
import cn.hanbell.oa.entity.HKGL076DetailQ1;
import cn.hanbell.oa.entity.HKGL076DetailQ2;
import cn.hanbell.oa.entity.HKGL076DetailQ3;
import cn.hanbell.oa.entity.HKGL076DetailQ4;
import cn.hanbell.oa.entity.HKXQB001;
import cn.hanbell.oa.entity.HSPB015;
import cn.hanbell.oa.entity.HZCW034;
import cn.hanbell.oa.entity.HZCW034Detail;
import cn.hanbell.oa.entity.HZGL004;
import cn.hanbell.oa.entity.HZGL004BizDetail;
import cn.hanbell.oa.entity.HZJS034;
import cn.hanbell.oa.entity.HZJS034Detail;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.ParticipantActivityInstance;
import cn.hanbell.oa.entity.ProcessInstance;
import cn.hanbell.oa.entity.SERI12;
import cn.hanbell.oa.entity.SERI12grid2SERI12;
import cn.hanbell.oa.entity.SHBCRMREPI13;
import cn.hanbell.oa.entity.SHBCRMSERI12;
import cn.hanbell.oa.entity.SHBERPAPM828;
import cn.hanbell.oa.entity.SHBERPINV140;
import cn.hanbell.oa.entity.SHBERPINV140Detail;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.entity.WorkItem;
import cn.hanbell.util.BaseLib;
import cn.hanbell.wco.ejb.Agent1000002Bean;
import com.lightshell.comm.SuperEJB;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author C0160
 */
@WebService(serviceName = "EAP")
@Stateless()
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class EAPWebService {

    private final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    // EJBForCRM
    @EJB
    private REPPABean reppaBean;
    @EJB
    private DDGABean ddgaBean;
    @EJB
    private DDGCBean ddgcBean;
    @EJB
    private WARMBBean warmbBean;
    @EJB
    private SERBQBean serbqBean;
    @EJB
    private SERCABean sercaBean;
    @EJB
    private REPTABean reptaBean;
    @EJB
    private REPTCBean reptcBean;
    @EJB
    private CRMGGBean crmggBean;
    @EJB
    private SyncCRMBean syncCRMBean;

    // EJBForEAP
    @EJB
    private DepartmentBean departmentBean;
    @EJB
    private SystemUserBean systemUserBean;
    @EJB
    private MailNotificationBean mailBean;
    @EJB
    private MailSettingBean mailSettingBean;
    @EJB
    private CustomerComplaintBean customerComplaintBean;
    @EJB
    private CustomerComplaintExpenseBean complaintExpenseBean;
    @EJB
    private CustomerComplaintMaterialBean complaintMaterialBean;
    @EJB
    private DemandsBean demandsBean;

    // EJBForEAM
    @EJB
    private AssetAcceptanceBean assetAcceptanceBean;
    @EJB
    private AssetApplyBean assetApplyBean;
    @EJB
    private AssetCardBean assetCardBean;
    @EJB
    private AssetCategoryBean assetCategoryBean;
    @EJB
    private AssetDisposeBean assetDisposeBean;
    @EJB
    private AssetItemBean assetItemBean;
    @EJB
    private AssetScrapBean assetScrapBean;
    @EJB
    private StationeryDistributeBean stationeryDistributeBean;
    @EJB
    private WarehouseBean warehouseBean;

    // EJBForEFGP
    @EJB
    private HKCG007Bean hkcg007Bean;
    @EJB
    private HKCG011Bean hkcg011Bean;
    @EJB
    private HKCG016Bean hkcg016Bean;
    @EJB
    private HKCG019Bean hkcg019Bean;
    @EJB
    private HKCG020Bean hkcg020Bean;
    @EJB
    private HKCW002Bean hkcw002Bean;
    @EJB
    private HKCW003Bean hkcw003Bean;
    @EJB
    private HKFW004DetailBean hkfw004DetailBean;
    @EJB
    private HKFW005Bean hkfw005Bean;
    @EJB
    private HKFW006Bean hkfw006Bean;
    @EJB
    private HKGC002Bean hkgc002Bean;
    @EJB
    private HKGC003Bean hkgc003Bean;
    @EJB
    private HKGL038Bean hkgl038Bean;
    @EJB
    private HKGL060Bean hkgl060Bean;
    @EJB
    private HKJH001Bean hkjh001Bean;
    @EJB
    private HKJH006Bean hkjh006Bean;
    @EJB
    private HKXQB001Bean hkxqb001Bean;
    @EJB
    private HSPB015Bean hspb015Bean;
    @EJB
    private HZCW028Bean hzcw028Bean;
    @EJB
    private HZCW033Bean hzcw033Bean;
    @EJB
    private HZCW034Bean hzcw034Bean;
    @EJB
    private HZJS034Bean hzjs034Bean;
    @EJB
    private SERI12Bean seri12Bean;
    @EJB
    private SHBCRMSERI12Bean shbcrmseri12Bean;
    @EJB
    private SHBCRMREPI13Bean shbcrmrepi13Bean;
    @EJB
    private SHBERPAPM828Bean shberpapm828Bean;
    @EJB
    private SHBINV140Bean shbinv140Bean;
    @EJB
    private VHTV002Bean vhtv002Bean;
    @EJB
    private WARMI05Bean warmi05Bean;
    @EJB
    private UsersBean usersBean;
    @EJB
    private ProcessInstanceBean processInstanceBean;
    @EJB
    private ParticipantActivityInstanceBean participantActivityInstanceBean;
    @EJB
    private WorkFlowBean workFlowBean;
    @EJB
    private WorkItemBean workItemBean;
    @EJB
    private cn.hanbell.oa.ejb.PLMProjectBean efgpPLMProjectBean;
    @EJB
    private HKGL034Bean hkgl034Bean;
    @EJB
    private HKGL034DetailBean hkgl034DetailBean;
    @EJB
    private HKGL004Bean hkgl004Bean;
    @EJB
    private HZGL004Bean hzgl004Bean;
    @EJB
    private HZGL004BizDetailBean hzgl004BizBean;
    @EJB
    private HKYX011Bean hkyx011Bean;
    @EJB
    private HKGL031Bean hkgl031Bean;
    @EJB
    private HKJH005Bean hkjh005Bean;
    @EJB
    private HKYX014Bean hkyx014Bean;
    @EJB
    private HKGl076Bean hkgl076Bean;
    @EJB
    private HKCW015Bean hkcw015Bean;
    @EJB
    private HKGL037Bean hkgl037Bean;

    // EJBForERP
    @EJB
    private PricingGroupBean pricingGroupBean;
    @EJB
    private InvclswahBean invclswahBean;
    @EJB
    private InvhadBean invhadBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private InvwhBean invwhBean;
    @EJB
    private ApmbilBean apmbilBean;
    @EJB
    private ApmaphBean apmaphBean;
    @EJB
    private ApmpayBean apmpayBean;
    @EJB
    private Apmanp585hBean apmanp585hBean;
    @EJB
    private CdrqhadBean cdrqhadBean;
    @EJB
    private CdrlndtaBean cdrlndtaBean;
    @EJB
    private CdrlnhadBean cdrlnhadBean;
    @EJB
    private CdrhadBean cdrhadBean;
    @EJB
    private CdrhmasBean cdrhmasBean;
    @EJB
    private CdrbhadBean cdrbhadBean;
    @EJB
    private PurachBean purachBean;
    @EJB
    private PurhaskBean purhaskBean;
    @EJB
    private PurvdrBean purvdrBean;
    @EJB
    private SecgprgBean secgprgBean;
    @EJB
    private CdrcusBean cdrcusBean;
    @EJB
    private CdrcusmanBean cdrcusmanBean;
    @EJB
    private CdrpaydscBean cdrpaydscBean;
    @EJB
    private CdrqbomsubBean cdrqbomsubBean;
    @EJB
    private CdrqsysBean cdrqsysBean;
    @EJB
    private CdrsysBean cdrsysBean;
    @EJB
    private CdrhpopsfkBean cdrhpopsfkBean;
    @EJB
    private CdrsfkpartBean cdrsfkpartBean;
    @EJB
    private CdrsfksortsBean cdrsfksortsBean;
    @EJB
    private CdrsfkspecBean cdrsfkspecBean;
    @EJB
    private CdrqasryBean cdrqasryBean;
    @EJB
    private BomasryBean bomasryBean;
    @EJB
    private BomsubBean bomsubBean;
    @EJB
    private CdrbomsubDefaultBean cdrbomsubDefaultBean;
    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private CrmreppalogBean crmreppalogBean;
    @EJB
    private ECPurvdrBean ecpurvdrBean;
    @EJB
    private ApmchpBean apmchpBean;

//    //EJBForVHBERP
//    @EJB
//    private vn.hanbell.erp.ejb.ApmbilBean vhbapmbilBean;
//    @EJB
//    private vn.hanbell.erp.ejb.ApmaphBean vhbapmaphBean;
//
    // EJBForPLM
    @EJB
    private cn.hanbell.plm.ejb.PLMProjectBean plmPLMProjectBean;
    @EJB
    private cn.hanbell.plm.ejb.PLMTeamBean plmPLMTeamBean;

    // EJBForWCO
    @EJB
    private Agent1000002Bean agent1000002Bean;

    // EJBForKPI
    @EJB
    private ScorecardAuditorBean scorecardAuditorBean;
    @EJB
    private ScorecardDetailBean scorecardDetailBean;
    @EJB
    private ScorecardBean scorecarBean;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "createCRMREPMFByOAHKCW003")
    public String createCRMREPMFByOAHKCW003(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkcw003Bean.initByOAHKCW003(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createCRMREPMFByOAHKCW003", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            //加入邮件通知
            mailBean.clearReceivers();
            mailBean.getTo().add("C1491@hanbell.com.cn");
            mailBean.getTo().add("C1278@hanbell.com.cn");
            mailBean.getTo().add("C1900@hanbell.com.cn");
            mailBean.setMailSubject("OA新增标准成本更新CRM失败");
            mailBean.setMailContent("OA新增标准成本更新CRM失败，流程序号：" + psn);
            mailBean.notify(new MailNotify());
            return "404";
        }
    }

    @WebMethod(operationName = "createCRMSERBQByOASHBCRMSERI12")
    public String createCRMSERBQByOASHBCRMSERI12(@WebParam(name = "psn") String psn) {
        String ret = "200";
        Date date;
        try {
            SHBCRMSERI12 h = shbcrmseri12Bean.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException("未找到对应的OA实体");
            }
            SERBQ bq = new SERBQ();
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String bq001 = serbqBean.getBQ001ByDeptAndDate(h.getHdnappdept(), date);
            bq.setBq001(bq001);
            bq.setBq002(h.getBq002() == null ? "" : h.getBq002());
            bq.setBq003(h.getBq003() == null ? "" : h.getBq003());
            bq.setBq005(h.getBq005() == null ? "" : h.getBq005());
            bq.setBq006(h.getBq006() == null ? "" : h.getBq006());
            bq.setBq007(h.getBq007() == null ? "" : h.getBq007());
            String ti = BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", BaseLib.getDate());
            bq.setBq008(ti.substring(11));
            bq.setBq009(h.getBq009() == null ? "" : h.getBq009());
            bq.setBq014(h.getBq014() == null ? "" : h.getBq014());
            bq.setBq016(h.getBq016() == null ? "" : h.getBq016());
            bq.setBq017(h.getBq017() == null ? "" : h.getBq017());
            bq.setBq018(h.getHdnapplyuser());
            bq.setBq021(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
            bq.setBq022("");
            bq.setBq023(h.getBq023() == null ? "" : h.getBq023());
            bq.setBq024(h.getBq024() == null ? "" : h.getBq024());
            bq.setBq027("");
            bq.setBq027("");
            bq.setBq031("");
            bq.setBq034("");
            bq.setBq035(h.getBq035() == null ? "" : h.getBq035());
            bq.setBq036("");
            bq.setBq042(BigDecimal.ZERO);
            bq.setBq043(BigDecimal.ZERO);
            bq.setBq044("");
            bq.setBq047("2");
            bq.setBq049("");
            bq.setBq052("3");
            bq.setBq055(h.getBq055() == null ? "" : h.getBq055());
            bq.setBq056(h.getBq056() == null ? "" : h.getBq056());
            bq.setBq058("");
            bq.setBq059("");
            bq.setBq060(h.getBq060() == null ? "" : h.getBq060());
            bq.setBq061(h.getBq061() == null ? "" : h.getBq061());
            bq.setBq064("");
            bq.setBq065("");
            bq.setBq068(BigDecimal.ZERO);
            bq.setBq088("RMB");
            bq.setBq089(BigDecimal.ZERO);
            bq.setBq090("N");
            bq.setBq092(BigDecimal.ZERO);
            bq.setBq093("N");
            bq.setBq094("S02");
            bq.setBq095("");
            bq.setBq096("1");
            bq.setBq107("N");
            // bq.setBq110(h.getBq110() == null ? "" : h.getBq110());
            bq.setBq116("1");
            bq.setBq121("");
            bq.setBq122(BigDecimal.ZERO);
            bq.setBq123(BigDecimal.ZERO);
            bq.setBq124(BigDecimal.ZERO);
            bq.setBq125(BigDecimal.ZERO);
            bq.setBq126(BigDecimal.ZERO);
            bq.setBq127(BigDecimal.ZERO);
            bq.setBq128(BigDecimal.ZERO);
            bq.setBq197(h.getBq197() == null ? "" : h.getBq197());
            bq.setBq198(h.getBq198() == null ? "" : h.getBq198());
            bq.setBq199(h.getBq199() == null ? "" : h.getBq199());
            bq.setBq500(h.getBq500() == null ? "" : h.getBq500());
            if ("1".equals(bq.getBq500())) {
                bq.setBq110("Y");
            } else {
                bq.setBq110("N");
            }
            bq.setBq501("N");
            bq.setBq506(h.getBq506() == null ? "" : h.getBq506());
            bq.setCompany("SHAHANBELL");
            bq.setCreator(h.getHdnapplyuser());
            bq.setUsrGroup(h.getHdnappdept());
            bq.setFlag((short) 0);
            bq.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));

            SERCA ca = new SERCA();
            SERCAPK capk = new SERCAPK();
            capk.setCa001(bq001);
            capk.setCa002("0001"); // 手机端发单明细只有1笔资料
            ca.setSERCAPK(capk);
            ca.setCa003(h.getCa003());
            ca.setCa004(h.getCa004());
            ca.setCa005(h.getCa005());
            ca.setCa009(h.getCa009());
            ca.setCa010(h.getCa010()); // 叫修单单别
            String ca011 = reptaBean.getTA002ByTA001AndDate(h.getCa010(), BaseLib.getDate());
            ca.setCa011(ca011); // 叫修单单号（派工单号）
            ca.setCa012("");
            ca.setCa013(BigDecimal.ZERO);
            ca.setCa014("");
            ca.setCa015(h.getBq023c());
            ca.setCa019(h.getBq005());
            ca.setCa021(h.getBq023());
            ca.setCa500(h.getCa500());
            ca.setFlag((short) 0);
            // 产生叫修单
            REPTA ta = new REPTA();
            REPTAPK tapk = new REPTAPK();
            ta.setCompany("SHAHANBELL");
            ta.setCreateDate(bq.getCreateDate());
            ta.setCreator(bq.getCreator());
            ta.setUsrGroup(h.getHdnappdept());
            tapk.setTa001(ca.getCa010());
            tapk.setTa002(ca011);
            ta.setREPTAPK(tapk);
            ta.setTa003(bq.getCreateDate());
            ta.setTa004(h.getBq002()); // 客户代号
            ta.setTa005(h.getCa003()); // 产品品号
            ta.setTa006(h.getCa004()); // 产品品名
            ta.setTa007(h.getCa005()); // 产品规格
            // ta.setTa008(bq.getCreateDate()); //合约代号
            ta.setTa009(h.getBq016()); // 接单人员
            ta.setTa010(h.getBq023c()); // 问题描述
            ta.setTa071(h.getBq023()); // 问题代号
            ta.setTa062("RMB");
            ta.setTa063(BigDecimal.ONE);
            ta.setTa197(h.getBq197()); // 产品别
            ta.setTa198(h.getBq198()); // 区域别
            // 交货资料
            CRMGG gg = crmggBean.findByGG001(ta.getTa004());
            if (gg != null) {
                ta.setTa034(gg.getGg027()); // 传真
            }
            if (crmggBean.getDetaiList(ta.getTa004()) != null) {
                if (crmggBean.getDetaiList(ta.getTa004()).size() > 0) {
                    CRMGD gd = crmggBean.getDetaiList(ta.getTa004()).get(0);
                    ta.setTa020(gd.getGd005()); // 联络人
                    ta.setTa087(gd.getGd012()); // 移动电话
                    ta.setTa026(gd.getGd008()); // 地址
                    ta.setTa025(gd.getGd025() + gd.getGd007()); // 电话
                }

            }
            serbqBean.persist(bq);
            serbqBean.getEntityManager().flush();
            sercaBean.persist(ca);
            reptaBean.persist(ta);
            // 回写OA客诉单单号,派工单号
            h.setBq001(bq001);
            h.setCa011(ca011);
            shbcrmseri12Bean.update(h);

        } catch (Exception e) {
            return String.format("执行%s:参数%s时异常%s:", "createCRMSERBQByOASHBCRMSERI12", psn, "******" + e.toString());
        }
        return ret;
    }

    @WebMethod(operationName = "createCRMWARMBByOAJHSQD")
    public String createCRMWARMBByOAJHSQD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HZJS034 h = hzjs034Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        hzjs034Bean.setDetail(h.getFormSerialNumber());
        List<HZJS034Detail> details = hzjs034Bean.getDetailList();
        try {

            // 表身循环
            for (int i = 0; i < details.size(); i++) {
                HZJS034Detail detail = details.get(i);
                if (null == warmbBean.findByMB001(detail.getItnbr())) {
                    WARMB m = new WARMB();
                    m.setCompany(h.getFacno());
                    m.setCreator(h.getEmpl());
                    m.setMb001(detail.getItnbr()); // 设置件号
                    m.setMb008(detail.getItcls()); // 设置品号大类
                    m.setMb002(detail.getItdsc()); // 设置中文品名
                    m.setMb003(detail.getSpdsc()); // 设置中文规格
                    m.setMb004(detail.getUnmsr1()); // 设置单位一
                    m.setMb029(detail.getEitdsc());
                    m.setMb030(detail.getEspdsc());
                    if (null != detail.getMorpcode()) {
                        switch (detail.getMorpcode()) {
                            case "W":
                                m.setMb010("M");
                                break;
                            case "H":
                                m.setMb010("Y");
                                break;
                            case "A":
                                m.setMb010("S");
                                break;
                            default:
                                m.setMb010(detail.getMorpcode()); // 设置自制采购码
                                break;
                        }
                    }
                    m.setMb028("Y"); // 设置产品序号管理
                    m.setMb050("Y"); // 设置需核销
                    invclswahBean.setCompany(h.getFacno());
                    Invclswah invclswah = invclswahBean.findByInvclswahPK(h.getFacno(), "1", detail.getItcls());
                    if (invclswah != null) {
                        m.setMb011(invclswah.getDefwah());
                    }
                    m.setMb033(detail.getItnbr());
                    m.setMb057(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate())); // 设置生效日期日期
                    warmbBean.persist(m);
                }
            }
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createCRMWARMBByOAJHSQD", psn), ex);
            ret = false;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createCRMWARMBByOAJHZYD")
    public String createCRMWARMBByOAJHZYD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        SHBERPINV140 h = shbinv140Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        if ("C".equals(h.getFacno2()) || "K".equals(h.getFacno2())) {
            List<SHBERPINV140Detail> details = shbinv140Bean.getDetailList(h.getFormSerialNumber());
            try {
                // 表身循环
                for (int i = 0; i < details.size(); i++) {
                    SHBERPINV140Detail detail = details.get(i);
                    if (null == warmbBean.findByMB001(detail.getItnbr())) {
                        WARMB m = new WARMB();
                        m.setCompany(h.getFacno2());
                        m.setCreator(h.getApplyuser());
                        m.setMb001(detail.getItnbr()); // 设置件号
                        m.setMb008(detail.getItcls()); // 设置品号大类
                        m.setMb002(detail.getItdsc()); // 设置中文品名
                        m.setMb003(detail.getSpdsc()); // 设置中文规格
                        m.setMb004(detail.getUnmsr1()); // 设置单位一
                        m.setMb029(detail.getEitdsc());
                        m.setMb030(detail.getEspdsc());
                        if (null != detail.getMorpcode()) {
                            switch (detail.getMorpcode()) {
                                case "W":
                                    m.setMb010("M");
                                    break;
                                case "H":
                                    m.setMb010("Y");
                                    break;
                                case "A":
                                    m.setMb010("S");
                                    break;
                                default:
                                    m.setMb010(detail.getMorpcode()); // 设置自制采购码
                                    break;
                            }
                        }
                        m.setMb028("Y"); // 设置产品序号管理
                        m.setMb050("Y"); // 设置需核销
                        invclswahBean.setCompany(h.getFacno2());
                        Invclswah invclswah = invclswahBean.findByInvclswahPK(h.getFacno2(), "1", detail.getItcls());
                        if (invclswah != null) {
                            m.setMb011(invclswah.getDefwah());
                        }
                        m.setMb033(detail.getItnbr());
                        m.setMb057(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate())); // 设置生效日期日期
                        warmbBean.persist(m);
                    }
                }
                ret = true;
            } catch (Exception ex) {
                log4j.error(String.format("执行%s:参数%s时异常", "createCRMWARMBByOAJHZYD", psn), ex);
            }

        } else {
            ret = true;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createEAMAssetAcceptanceByOAHKCW002")
    public String createEAMAssetAcceptanceByOAHKCW002(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        // 将ERP资产验收同步到EAM资产入库
        List<HKCW002Detail> hkcw002Details;
        HKCW002 e = hkcw002Bean.findNotAcceptance(psn);
        if (e != null) {
            String[] acceptno;
            boolean flag;
            // 用于更新资产明细
            List<HKCW002Detail> editedHKCW002Detail = new ArrayList<>();
            HashMap<SuperEJB, List<?>> hkcw002DetailEdited = new HashMap<>();
            hkcw002DetailEdited.put(hkcw002Bean, editedHKCW002Detail);

            purhaskBean.setCompany(e.getFacno());
            purachBean.setCompany(e.getFacno());
            // HKCG007抛转PUR210时截取了流程序号,省略了PKG_
            Purhask prh = purhaskBean.findBySrcno(e.getHkcg007().substring(4));
            if (prh != null) {

                try {
                    flag = true;
                    int i;
                    BigDecimal qty;
                    // EAM相关对象
                    AssetItem ai;
                    List<AssetAcceptanceDetail> addedDetail = new ArrayList();
                    // ERP相关对象
                    Purach purach;
                    List<Puracd> puracdList;
                    // EFGP相关对象
                    hkcw002Bean.setDetail(e.getFormSerialNumber());
                    hkcw002Details = hkcw002Bean.getDetailList();

                    if (hkcw002Details != null && !hkcw002Details.isEmpty()) {
                        for (HKCW002Detail d : hkcw002Details) {
                            if (d.getPurqty() == null || "".equals(d.getPurqty())) {
                                continue;
                            }
                            if (d.getRelqty() != null && !"".equals(d.getRelqty())) {
                                qty = BigDecimal.valueOf(Double.parseDouble(d.getRelqty()));
                                if (qty.compareTo(BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                    continue;
                                }
                            }
                            // 得到验收单号数组
                            acceptno = purachBean.findByPrnoAndItnbr(prh.getPurhaskPK().getPrno(), d.getItemno());
                            if (acceptno != null) {
                                qty = BigDecimal.ZERO;
                                for (String n : acceptno) {
                                    purach = purachBean.findByAcceptno(n);
                                    puracdList = purachBean.findByAcceptnoAndItnbr(n, d.getItemno());
                                    // 删除与此笔申请明细无关的同品号验收明细，解决同品号不同采购单合并验收问题
                                    if (puracdList != null && !puracdList.isEmpty() && puracdList.size() > 1) {
                                        for (int x = 0; x < puracdList.size(); x++) {
                                            Puracd acd = puracdList.get(x);
                                            if (!purachBean.isRelationAcceptance(prh.getPurhaskPK().getPrno(),
                                                    acd.getPono(), acd.getPonotrseq())) {
                                                puracdList.remove(acd);
                                                x--;
                                            }
                                        }
                                    }
                                    if (puracdList != null && !puracdList.isEmpty()) {
                                        // ERP每一笔验收产生一笔EAM资产入库
                                        i = 0;
                                        addedDetail.clear();// 清空之前列表
                                        // 计算累计验收数量
                                        for (Puracd acd : puracdList) {
                                            if (acd.getOkqy1().compareTo(
                                                    BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                                // 多笔请购合并采购验收，验收数量大于申请数量，按申请数量入库
                                                qty = qty.add(BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
                                            } else {
                                                qty = qty.add(acd.getOkqy1());
                                            }
                                        }
                                        for (Puracd acd : puracdList) {
                                            // 判断验收记录，处理多次验收逻辑
                                            if (d.getRelno() == null) {
                                                d.setRelno("");
                                            }
                                            if (d.getRelno().compareTo(n) < 0) {
                                                // 新的验收记录，产生EAM入库
                                                i++;
                                                AssetAcceptanceDetail aad = new AssetAcceptanceDetail();
                                                // aad.setPid("");
                                                aad.setSeq(i);
                                                aad.setAcceptdate(acd.getAcceptdate());
                                                aad.setAcceptDeptno(acd.getDepno());
                                                aad.setAcceptUserno(acd.getUserno());
                                                ai = assetItemBean.findByItemno(acd.getItnbr());
                                                aad.setAssetItem(ai);
                                                // aad.setQty(acd.getAccqy1());
                                                if (acd.getAccqy1().compareTo(
                                                        BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                                    // 多笔请购合并采购验收，验收数量大于申请数量，按申请数量入库
                                                    aad.setQty(BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
                                                } else {
                                                    aad.setQty(acd.getAccqy1());
                                                }
                                                aad.setUnit(ai.getUnit());
                                                aad.setQcpass(false);
                                                // aad.setQcqty(acd.getOkqy1());
                                                if (acd.getOkqy1().compareTo(
                                                        BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                                    // 多笔请购合并采购验收，验收数量大于申请数量，按申请数量入库
                                                    aad.setQcqty(BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
                                                } else {
                                                    aad.setQcqty(acd.getOkqy1());
                                                }
                                                aad.setAddqty(BigDecimal.ZERO);
                                                aad.setWarehouse(ai.getCategory().getWarehouse());
                                                aad.setCurrency(acd.getCoin());
                                                aad.setExchange(acd.getRatio());
                                                aad.setTaxrate(acd.getTaxrate());
                                                aad.setPrice(acd.getUnpris());
                                                aad.setAmts(acd.getTramts());
                                                aad.setExtax(acd.getTotamts().subtract(acd.getTaxamts()));
                                                aad.setTaxes(acd.getTaxamts());
                                                aad.setSrcapi("ERP");
                                                aad.setSrcformid(n);
                                                aad.setSrcseq(Integer.valueOf(acd.getPuracdPK().getTrseq()));
                                                aad.setStatus("40");

                                                addedDetail.add(aad);

                                                // 更新资产申请明细关联单号
                                                d.setRelno(n);
                                                d.setRelseq(String.valueOf(acd.getPuracdPK().getTrseq()));
                                                d.setRelqty(String.valueOf(qty));

                                                editedHKCW002Detail.add(d);
                                            }
                                        }
                                        if (addedDetail.size() > 0) {
                                            AssetAcceptance aa = new AssetAcceptance();
                                            aa.setCompany(purach.getPurachPK().getFacno());
                                            aa.setFormid("");
                                            aa.setFormdate(purach.getAcceptdate());
                                            aa.setVendorno(purach.getVdrno());
                                            aa.setDeptno(purach.getDepno());
                                            aa.setRemark(
                                                    e.getProcessSerialNumber() + "_" + purach.getPurachPK().getAcceptno());
                                            aa.setStatus("N");
                                            // 产生EAM资产入库
                                            assetAcceptanceBean.initAssetAcceptance(aa, addedDetail);
                                        }
                                    }
                                }
                            }
                        }
                        if (editedHKCW002Detail.size() > 0) {
                            // 判断整张资产申请是否全部验收
                            for (HKCW002Detail d : hkcw002Details) {
                                if (d.getPurqty() == null || "".equals(d.getPurqty())) {
                                    continue;
                                }
                                if (d.getRelqty() != null && !"".equals(d.getRelqty())) {
                                    qty = BigDecimal.valueOf(Double.parseDouble(d.getRelqty()));
                                    if (qty.compareTo(BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) < 0) {
                                        flag = false;
                                    }
                                } else {
                                    flag = false;
                                }
                            }
                            if (flag) {
                                // 全部验收完成
                                acceptno = purachBean.findByPrno(prh.getPurhaskPK().getPrno());
                                e.setRelformid(Arrays.toString(acceptno));
                            }
                            hkcw002Bean.update(e, null, hkcw002DetailEdited, null);
                        }
                    }
                    ret = true;
                } catch (Exception ex) {
                    log4j.error(String.format("执行%s:参数%s时异常", "createEAMAssetAcceptanceByOAHKCW002", psn), ex);
                }

            }
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createEAMAssetApplyByOAHKCW002")
    public String createEAMAssetApplyByOAHKCW002(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            HKCW002 e;
            List<HKCW002Detail> detailList;
            e = hkcw002Bean.findByPSN(psn);
            if (e != null) {
                OrganizationUnit ou;
                Department dept;
                SystemUser user;
                AssetApply aa;
                AssetApplyDetail aad;
                List<AssetApplyDetail> aadList = new ArrayList<>();
                hkcw002Bean.setDetail(e.getFormSerialNumber());
                detailList = hkcw002Bean.getDetailList();

                if (detailList != null && !detailList.isEmpty()) {
                    // EAM资产申请主档
                    aa = new AssetApply();
                    aa.setCompany(e.getFacno());
                    aa.setFormdate(e.getFormdate());
                    aa.setApplyDeptno(e.getApplyDeptno());
                    dept = departmentBean.findByDeptno(e.getApplyDeptno());
                    if (dept != null) {
                        aa.setApplyDeptname(dept.getDept());
                    } else {
                        ou = workFlowBean.findOrgUnitByDeptno(e.getApplyDeptno());
                        if (ou != null) {
                            dept = new Department(ou.getId(), ou.getOrganizationUnitName());
                            dept.setStatusToNew();
                            departmentBean.persist(dept);
                            aa.setApplyDeptname(ou.getOrganizationUnitName());
                        }
                    }
                    aa.setApplyUserno(e.getApplyUserno());
                    user = systemUserBean.findByUserId(e.getApplyUserno());
                    if (user != null) {
                        aa.setApplyUsername(user.getUsername());
                    }
                    aa.setRequireDeptno(e.getRequireDeptno());
                    dept = departmentBean.findByDeptno(e.getRequireDeptno());
                    if (dept != null) {
                        aa.setRequireDeptname(dept.getDept());
                    } else {
                        ou = workFlowBean.findOrgUnitByDeptno(e.getRequireDeptno());
                        if (ou != null) {
                            dept = new Department(ou.getId(), ou.getOrganizationUnitName());
                            dept.setStatusToNew();
                            departmentBean.persist(dept);
                            aa.setRequireDeptname(ou.getOrganizationUnitName());
                        }
                    }
                    aa.setRequireUserno(e.getRequireUserno());
                    user = systemUserBean.findByUserId(e.getRequireUserno());
                    if (user != null) {
                        aa.setRequireUsername(user.getUsername());
                    }
                    aa.setRemark(e.getProcessSerialNumber());

                    aa.setStatusToNew();
                    aa.setCreator(e.getProcessSerialNumber());
                    aa.setCredateToNow();
                    // EAM资产申请明细
                    int i = 0;
                    for (HKCW002Detail d : detailList) {
                        i++;
                        aad = new AssetApplyDetail();
                        aad.setSeq(i);
                        aad.setRequireDeptno(aa.getRequireDeptno());
                        aad.setRequireDeptname(aa.getRequireDeptname());
                        aad.setRequireUserno(aa.getRequireUserno());
                        aad.setRequireUsername(aa.getRequireUsername());
                        aad.setAssetItem(assetApplyBean.findByItemno(d.getItemno()));
                        aad.setItemdesc(d.getItemdesc());
                        aad.setItemspec(d.getItemspec());
                        aad.setQty(BigDecimal.valueOf(Double.valueOf(d.getQty())));
                        aad.setDisqty(BigDecimal.valueOf(Double.valueOf(d.getDisqty())));
                        if (!"".equals(d.getPurqty())) {
                            aad.setPurqty(BigDecimal.valueOf(Double.valueOf(d.getPurqty())));
                        } else {
                            aad.setPurqty(BigDecimal.ZERO);
                        }
                        aad.setAccqty(BigDecimal.ZERO);
                        aad.setUnit(d.getUnit());
                        aad.setCurrency(e.getCurrency());
                        aad.setExchange(BigDecimal.valueOf(e.getRate()));
                        aad.setPrice(BigDecimal.valueOf(Double.valueOf(d.getPrice())));
                        aad.setAmts(BigDecimal.valueOf(Double.valueOf(d.getAmts())));
                        aad.setBudgetacc(d.getBudgetacc());
                        aad.setBudgetaccname(d.getBudgetaccname());
                        aad.setDmark1(d.getDmark1());
                        aad.setDmark1desc(d.getDmark1desc());
                        aad.setDmark2(d.getDmark2());
                        aad.setDmark2desc(d.getDmark2desc());
                        aad.setSrcapi("HK_CW002");
                        aad.setSrcformid(d.getFormSerialNumber());
                        aad.setSrcseq(Integer.valueOf(d.getSeq()));
                        aad.setDistributed(false);
                        aad.setPurchased(Boolean.valueOf(e.getPurchase()));
                        aad.setStatus("10");
                        // 添加到明细列表
                        aadList.add(aad);
                    }
                    // 新增到EAM
                    String formid = assetApplyBean.initAssetApply(aa, aadList);
                    if (formid != null && !"".equals(formid)) {
                        e.setSrcformid(formid);
                        hkcw002Bean.update(e);// 记录EAM单号
                    }
                }
                ret = true;
            } else {
                ret = false;
            }
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createEAMAssetApplyByOAHKCW002", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createEAMAssetDisposeByEAMAssetScrap")
    public String createEAMAssetDisposeByEAMAssetScrap(@WebParam(name = "formid") String formid) {
        Boolean ret = false;
        HZCW034 e;
        try {
            AssetScrap as;
            List<AssetScrapDetail> asdList;
            as = assetScrapBean.findByFormId(formid);
            if (as == null) {
                throw new NullPointerException(formid + "不存在");
            }
            assetScrapBean.setDetail(as.getFormid());
            asdList = assetScrapBean.getDetailList();
            if (asdList == null || asdList.isEmpty()) {
                return "200";
            }
            String assetno;
            AssetDispose ad;
            AssetDisposeDetail add;
            List<AssetDisposeDetail> addList = new ArrayList<>();
            int i = 0;
            for (AssetScrapDetail d : asdList) {
                i++;
                add = new AssetDisposeDetail();
                add.setSeq(i);
                if (d.getAssetItem().getCategory().getNoauto()) {
                    // 资产编号
                    add.setAssetCard(d.getAssetCard());
                    add.setAssetno(d.getAssetno());
                } else {
                    // 单据编号
                    assetno = d.getPid() + "-" + BaseLib.formatString("0000", String.valueOf(d.getSeq()));
                    AssetCard ac = assetCardBean.findByAssetno(assetno);
                    if (ac == null) {
                        throw new NullPointerException(assetno + "资产卡片不存在");
                    }
                    add.setAssetCard(ac);
                    add.setAssetno(ac.getFormid());
                }
                add.setAssetItem(d.getAssetItem());
                add.setQty(d.getQty());
                add.setUnit(d.getUnit());
                add.setBuyPrice(d.getPrice());
                add.setBuyAmts(d.getAmts());
                add.setBuyDate(d.getBuyDate());
                add.setSurplusValue(d.getSurplusValue());
                add.setAmts(BigDecimal.ZERO);
                add.setUserno(d.getUserno());
                add.setUsername(d.getUsername());
                add.setDeptno(d.getDeptno());
                add.setDeptname(d.getDeptname());
                add.setUsed(d.getUsed());
                add.setWarehouse(d.getWarehouse2());
                add.setSrcapi("assetscrap");
                add.setSrcformid(d.getPid());
                add.setSrcseq(d.getSeq());
                add.setRelapi(d.getSrcapi());
                add.setRelformid(d.getSrcformid());
                add.setRelseq(d.getSrcseq());
                addList.add(add);
            }
            ad = new AssetDispose();
            ad.setCompany(as.getCompany());
            ad.setFormdate(BaseLib.getDate());
            ad.setDeptno(as.getDeptno());
            ad.setDeptname(as.getDeptname());
            // 处置总额
            ad.setTotalAmts(BigDecimal.ZERO);
            // 残值总额
            ad.setSurplusValue(BigDecimal.ZERO);
            ad.setReason(as.getReason());
            ad.setRemark(as.getRemark());
            ad.setStatus("N");
            ad.setCreator(as.getCfmuser());
            ad.setCredateToNow();
            String id = assetDisposeBean.initAssetDispose(ad, addList);
            if (id != null && !"".equals(id)) {
                ad.setStatus("V");
                assetDisposeBean.verify(ad);// 抛转后直接确认
                ret = true;
            } else {
                ret = false;
            }
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createEAMAssetDisposeByEAMAssetScrap", formid), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }

    }

    @WebMethod(operationName = "createEAMAssetDisposeByOAHZCW034")
    public String createEAMAssetDisposeByOAHZCW034(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HZCW034 e;
        try {
            e = hzcw034Bean.findByPSN(psn);
            if (e == null) {
                throw new NullPointerException(psn + "不存在");
            } else if (e.getSourceno() == null || "".equals(e.getSourceno())) {
                return "200";
            }
            AssetScrap as;
            List<AssetScrapDetail> asdList;
            as = assetScrapBean.findByFormId(e.getSourceno());
            if (as == null) {
                throw new NullPointerException(e.getSourceno() + "不存在");
            }
            assetScrapBean.setDetail(as.getFormid());
            asdList = assetScrapBean.getDetailList();
            if (asdList == null || asdList.isEmpty()) {
                return "200";
            }
            String assetno;
            AssetDispose ad;
            AssetDisposeDetail add;
            List<AssetDisposeDetail> addList = new ArrayList<>();
            int i = 0;
            for (AssetScrapDetail d : asdList) {
                i++;
                add = new AssetDisposeDetail();
                add.setSeq(i);
                if (d.getAssetItem().getCategory().getNoauto()) {
                    // 资产编号
                    add.setAssetCard(d.getAssetCard());
                    add.setAssetno(d.getAssetno());
                } else {
                    // 单据编号
                    assetno = d.getPid() + "-" + BaseLib.formatString("0000", String.valueOf(d.getSeq()));
                    AssetCard ac = assetCardBean.findByAssetno(assetno);
                    if (ac == null) {
                        throw new NullPointerException(assetno + "资产卡片不存在");
                    }
                    add.setAssetCard(ac);
                    add.setAssetno(ac.getFormid());
                }
                add.setAssetItem(d.getAssetItem());
                add.setQty(d.getQty());
                add.setUnit(d.getUnit());
                add.setBuyPrice(d.getPrice());
                add.setBuyAmts(d.getAmts());
                add.setBuyDate(d.getBuyDate());
                add.setSurplusValue(d.getSurplusValue());
                add.setAmts(BigDecimal.ZERO);
                add.setUserno(d.getUserno());
                add.setUsername(d.getUsername());
                add.setDeptno(d.getDeptno());
                add.setDeptname(d.getDeptname());
                add.setUsed(d.getUsed());
                add.setWarehouse(d.getWarehouse2());
                add.setSrcapi("assetscrap");
                add.setSrcformid(d.getPid());
                add.setSrcseq(d.getSeq());
                add.setRelapi(d.getSrcapi());
                add.setRelformid(d.getSrcformid());
                add.setRelseq(d.getSrcseq());
                addList.add(add);
            }
            ad = new AssetDispose();
            ad.setCompany(e.getFacno());
            ad.setFormdate(BaseLib.getDate());
            ad.setDeptno(as.getDeptno());
            ad.setDeptname(as.getDeptname());
            // 处置总额
            ad.setTotalAmts(BigDecimal.ZERO);
            // 残值总额
            ad.setSurplusValue(BigDecimal.ZERO);
            ad.setReason(as.getReason());
            ad.setRemark(as.getRemark());
            ad.setStatus("N");
            ad.setCreator(e.getCreator());
            ad.setCredateToNow();
            String formid = assetDisposeBean.initAssetDispose(ad, addList);
            if (formid != null && !"".equals(formid)) {
                e.setDisposeno(formid);
                hzcw034Bean.update(e);// 记录EAM单号
                ad.setStatus("V");
                assetDisposeBean.verify(ad);// 抛转后直接确认
                ret = true;
            } else {
                ret = false;
            }
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createEAMAssetDisposeByOAHZCW034", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }

    }

    @WebMethod(operationName = "createEAMAssetItemByOAHZJS034")
    public String createEAMAssetItemByOAHZJS034(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            HZJS034 h = hzjs034Bean.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException();
            }
            if (!h.getGenre1().equals("ZC")) {
                return "200";
            }
            hzjs034Bean.setDetail(h.getFormSerialNumber());
            List<HZJS034Detail> details = hzjs034Bean.getDetailList();
            AssetItem ai;
            AssetCategory ac;
            for (HZJS034Detail detail : details) {
                if (detail.getItnbr().substring(0, 2).equals("B1")) {
                    continue;
                }
                ai = assetItemBean.findByItemno(detail.getItnbr());
                if (ai != null) {
                    continue;
                }
                ac = assetCategoryBean.findByCategory(detail.getItcls());
                if (ac == null) {
                    continue;
                }
                ai = new AssetItem();
                ai.setCategory(ac);
                ai.setItemno(detail.getItnbr());
                ai.setItemdesc(detail.getItdsc());
                ai.setItemspec(detail.getSpdsc());
                ai.setUnit(detail.getUnmsr1());
                ai.setStatus("V");
                ai.setCreator(h.getEmpl());
                ai.setCredateToNow();
                assetItemBean.persist(ai);
            }
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createEAMAssetItemByOAHZJS034", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createEAMAssetScrapByOAHZCW034")
    public String createEAMAssetScrapByOAHZCW034(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HZCW034 e;
        List<HZCW034Detail> detailList;
        try {
            e = hzcw034Bean.findByPSN(psn);
            if (e == null) {
                throw new NullPointerException(psn + "不存在");
            } else if (e.getSourceno() != null && !"".equals(e.getSourceno())) {
                return "200";
            }
            hzcw034Bean.setDetail(e.getFormSerialNumber());
            detailList = hzcw034Bean.getDetailList();
            if (detailList == null || detailList.isEmpty()) {
                throw new NullPointerException(psn + "没有明细资料");
            }
            Department dept;
            AssetCard ac;
            AssetItem ai;
            AssetScrap as;
            AssetScrapDetail asd;
            List<AssetScrapDetail> asdList = new ArrayList<>();
            int i = 0;
            for (HZCW034Detail d : detailList) {
                ac = assetCardBean.findByAssetno(d.getAssetno());
                ai = assetItemBean.findByItemno(d.getItnbr());
                if (ac == null) {
                    throw new RuntimeException(d.getAssetno() + "EAM中不存在");
                } else if (ac.getScrap()) {
                    throw new RuntimeException(d.getAssetno() + "EAM中已报废");
                }
                if (ai == null) {
                    throw new RuntimeException(d.getItnbr() + "EAM中不存在");
                }
                i++;
                asd = new AssetScrapDetail();
                asd.setSeq(i);
                asd.setAssetCard(ac);
                asd.setAssetno(d.getAssetno());
                asd.setAssetItem(ai);
                asd.setQty(com.lightshell.comm.BaseLib.convertObject(BigDecimal.class, d.getScrapqty()));
                asd.setUnit(ac.getUnit());
                asd.setPrice(com.lightshell.comm.BaseLib.convertObject(BigDecimal.class, d.getPrice()));
                asd.setAmts(com.lightshell.comm.BaseLib.convertObject(BigDecimal.class, d.getAmts()));
                asd.setSurplusValue(com.lightshell.comm.BaseLib.convertObject(BigDecimal.class, d.getSurplusValue()));
                asd.setUserno(d.getUserno());
                asd.setUsername(d.getUsername());
                asd.setDeptno(d.getDeptno());
                asd.setDeptname(d.getDeptname());
                asd.setBuyDate(BaseLib.getDate("yyyy/MM/dd", d.getBuyDatetxt()));
                asd.setUsed(Integer.parseInt(d.getUsetime()));
                asd.setWarehouse(warehouseBean.findByWarehouseno(d.getWarehouseno()));
                asd.setWarehouse2(warehouseBean.findByWarehouseno(d.getWarehouseno2()));
                asd.setSrcapi("EFGP");
                asd.setSrcformid(d.getFormSerialNumber());
                asd.setSrcseq(Integer.parseInt(d.getSeq()));
                asdList.add(asd);
            }
            as = new AssetScrap();
            as.setCompany(e.getFacno());
            as.setFormdate(e.getApplydate());
            as.setDeptno(e.getApplydept());
            dept = departmentBean.findByDeptno(e.getApplydept());
            if (dept != null) {
                as.setDeptname(dept.getDept());
            }
            if (e.getCountsum() != null) {
                as.setTotalAmts(BigDecimal.valueOf(e.getCountsum()));
            } else {
                as.setTotalAmts(BigDecimal.ZERO);
            }
            if (e.getRsum() != null) {
                as.setSurplusValue(BigDecimal.valueOf(e.getRsum()));
            } else {
                as.setSurplusValue(BigDecimal.ZERO);
            }
            as.setReason(e.getMark());
            as.setRemark(psn);
            as.setStatus("N");
            as.setCreator(e.getCreator());
            as.setCredateToNow();
            String formid = assetScrapBean.initAssetScrap(as, asdList);
            if (formid != null && !"".equals(formid)) {
                e.setSourceno(formid);
                hzcw034Bean.update(e);// 记录EAM单号
                as.setStatus("V");
                assetScrapBean.verify(as);// 抛转后直接确认
                ret = true;
            } else {
                ret = false;
            }
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createEAMAssetScrapByOAHZCW034", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    /**
     * Web 服务操作
     *
     * @param psn
     * @return
     */
    @WebMethod(operationName = "createEAMOS310ByOAHKGL060")
    public String createEAMOS310ByOAHKGL060(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HKGL060 e;
        List<HKGL060Detail> detailList;
        try {
            e = hkgl060Bean.findByPSN(psn);
            if (e == null) {
                throw new NullPointerException(psn + "不存在");
            } else if (e.getRelformid() != null && !"".equals(e.getRelformid())) {
                return "200";
            }
            detailList = hkgl060Bean.getDetailList(e.getFormSerialNumber());
            if (detailList == null || detailList.isEmpty()) {
                throw new NullPointerException(psn + "没有明细资料");
            }
            Department dept;
            AssetItem ai;
            AssetDistribute ad;
            AssetDistributeDetail add;
            List<AssetDistributeDetail> addList = new ArrayList<>();
            int i = 0;
            for (HKGL060Detail d : detailList) {
                ai = assetItemBean.findByItemno(d.getItemno());
                if (ai == null) {
                    throw new RuntimeException(d.getItemno() + "EAM中不存在");
                }
                i++;
                add = new AssetDistributeDetail();
                add.setSeq(i);
                add.setDeptno(d.getRequireDeptno());
                add.setDeptname(d.getRequireDeptName());
                add.setUserno(d.getRequireUserno());
                add.setUsername(d.getRequireUserName());
                add.setAssetItem(ai);
                add.setQty(BigDecimal.valueOf(Double.valueOf(d.getActualqty())));
                add.setPrice(BigDecimal.valueOf(Double.valueOf(d.getPrice())));
                add.setAmts(BigDecimal.valueOf(Double.valueOf(d.getAmts())));
                add.setUnit(ai.getUnit());
                add.setWarehouse(warehouseBean.findByWarehouseno(d.getWarehouse()));
                add.setSrcapi("EFGP");
                add.setSrcformid(d.getFormSerialNumber());
                add.setSrcseq(Integer.parseInt(d.getSeq()));
                addList.add(add);
            }
            ad = new AssetDistribute();
            ad.setCompany(e.getFacno());
            // ad.setFormdate(e.getApplyDate()); 改为流程结束 C0160 2021/6/22
            ad.setFormdate(BaseLib.getDate());
            ad.setDeptno(e.getApplyDept());
            dept = departmentBean.findByDeptno(e.getApplyDept());
            if (dept != null) {
                ad.setDeptname(dept.getDept());
            }
            ad.setRemark(psn);
            ad.setStatus("N");
            ad.setCreator(e.getApplyUser());
            ad.setCredateToNow();
            String formid = stationeryDistributeBean.initStationeryDistribute(ad, addList);
            if (formid != null && !"".equals(formid)) {
                e.setRelformid(formid);
                hkgl060Bean.update(e);// 记录EAM单号
                ret = true;
            } else {
                ret = false;
            }
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createEAMStationeryDistributeByOAHKGL060", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createEAPDemandsByOAHKXQB001")
    public String createEAPDemandsByOAHKXQB001(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HKXQB001 b = hkxqb001Bean.findByPSN(psn);
        if (b == null) {
            throw new NullPointerException();
        }
        try {
            String SerialNumber = b.getSerialNumber();// 表单单号
            String xqjs = b.getXqjs();// 需求简称
            Date date1 = b.getCreatedate();// 创建日期
            String ssxt = b.getSsxt();// 所属系统
            String ssmk = b.getSsmk();// 所属模块
            String cxmc = b.getCxmc();// 程序名称
            String appuser = b.getApplyuser();
            String user1 = b.getUser1().trim();// 需求人
            String user2 = b.getUser2().trim();// 负责人
            String dept1 = b.getDept1().trim();// 需求部门
            Date date2 = b.getTime1();// 需求日期
            String xqnr = b.getXqnr();// 需求内容
            String zsd = b.getZsd();// 重视度
            String jjd = b.getJjd();// 紧急度
            String sypl = b.getSypl();// 使用频率
            String xxpg = b.getXypg();// 效益评估
            // 抛转EAP的Demands
            Demands d = new Demands();
            SystemUser s;
            Department t;
            Date formDate;
            formDate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            // 单号
            String formid;
            formid = demandsBean.setFormIdNumber();
            d.setFormid(formid);
            d.setOid(SerialNumber);// OA表单单号
            d.setDemandResume(xqjs);
            d.setDemandContent(xqnr);
            d.setSystemName(ssxt);
            d.setModuleName(ssmk);
            d.setProcedureName(cxmc);
            d.setDemandDate(date2);
            d.setStatus("N");
            d.setEmergencyDegree(jjd == null ? "" : jjd);
            if (user1 != null && !"".equals(user1)) {
                s = systemUserBean.findByUserId(user1);
                if (s != null) {
                    d.setDemanderID(user1);// 需求人
                    d.setDemanderName(s.getUsername());
                }
            }
            if (appuser != null && !"".equals(appuser)) {
                s = systemUserBean.findByUserId(appuser);
                if (s != null) {
                    d.setWriterID(appuser);// 创建需求人
                    d.setWriterName(s.getUsername());
                }
            }
            d.setFormdate(formDate);// 表单日期为SQL的日期
            d.setWriteDate(date1);// 创建时间
            if (dept1 != null && !"".equals(dept1)) {
                t = departmentBean.findByDeptno(dept1);
                if (t != null) {
                    d.setDemanderDeptID(dept1);// 需求部门
                    d.setDemanderDeptName(t.getDept());
                }
            }
            if (user2 != null && !"".equals(user2)) {
                /*负责人*/
                s = systemUserBean.findByUserId(user2);
                if (s != null) {
                    d.setDirectorID(user2);
                    d.setDirectorName(s.getUsername());
                    String directorDeptId = s.getDeptno();
                    t = departmentBean.findByDeptno(directorDeptId);
                    /*责任部门*/
                    if (t != null) {
                        d.setDirectorDeptID(directorDeptId);
                        d.setDirectorDeptName(t.getDept());
                    }
                }
            } else {
                d.setDirectorID("");
                d.setDirectorName("");
                d.setDirectorDeptID("");
                d.setDirectorDeptName("");
            }
            demandsBean.persist(d);
            ret = true;
        } catch (ParseException ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKXQB001", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createERPAPM330ByOAAPM811")
    public String createERPAPM330ByOAAPM811(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmbilBean.initByOAAPM811(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createERPAPM330ByOAAPM811", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createERPAPM250ByOAAPM820")
    public String createERPAPM250ByOAAPM820(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmbilBean.initByOAAPM820(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createERPAPM250ByOAAPM820", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

//    @WebMethod(operationName = "createVHBERPAPM250ByOAVHBAPM820")
//    public String createVHBERPAPM250ByOAVHBAPM820(@WebParam(name = "psn") String psn) {
//        Boolean ret = false;
//        try {
//            ret = vhbapmbilBean.initByOAAPM820(psn);
//        } catch (Exception ex) {
//            log4j.error(String.format("执行%s:参数%s时异常", "createVHBERPAPM250ByOAVHBAPM820", psn), ex);
//            throw new RuntimeException(ex);
//        }
//        if (ret) {
//            return "200";
//        } else {
//            return "404";
//        }
//    }
    @WebMethod(operationName = "createERPAPM525ByOAAPM828")
    public String createERPAPM525ByOAAPM828(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmpayBean.initByOAAPM828(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createERPAPM525ByOAAPM828", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPAPM828ByOAAPM828")
    public String updateERPAPM828ByOAAPM828(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmaphBean.updateByOAAPM828(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateERPAPM828ByOAAPM828", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPAPM820ByOAHKCW013")
    public String updateERPAPM820ByOAHKCW013(@WebParam(name = "psn") String psn, @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            ret = apmaphBean.updateERPAPM820ByOAHKCW013(psn, status);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateERPAPM820ByOAHKCW013", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

//    @WebMethod(operationName = "updateVHBERPAPM820ByOAVHTV005")
//    public String updateVHBERPAPM820ByOAVHTV005(@WebParam(name = "psn") String psn, @WebParam(name = "status") String status) {
//        Boolean ret = false;
//        try {
//            ret = vhbapmaphBean.updateVHBERPAPM820ByOAVHTV005(psn, status);
//        } catch (Exception ex) {
//            log4j.error(String.format("执行%s:参数%s时异常", "updateERPAPM820ByOAHKCW013", psn), ex);
//            throw new RuntimeException(ex);
//        }
//        if (ret) {
//            return "200";
//        } else {
//            return "404";
//        }
//    }
    @WebMethod(operationName = "createERPCDR645ByOAHKFW005")
    public String createERPCDR645ByOAHKFW005(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = cdrhadBean.initByOAHKFW005(psn);
        } catch (Exception ex) {
            log4j.error("createCDR645ByOAHKFW005时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createERPQuoteByCRMREPPA")
    public String createERPQuoteByCRMREPPA(@WebParam(name = "pa001") String pa001,
            @WebParam(name = "pa002") String pa002) {
        String facno;
        String pricelevel;
        String ls_levelp;
        String ls_levelpo;
        Character wi_s_cdrbomsubyn;
        Character wi_s_acesoryyn;
        String wi_s_isquouse;
        Character ls_cdrbomsubyn;
        Character ls_cdrothsfk;
        String li_cdrbomsubitem;
        Object[] prpl;
        int li_ulevelp;
        BigDecimal ldc_stdprice;
        BigDecimal ldc_levelpri;
        BigDecimal ldc_salesprice = BigDecimal.ZERO;
        BigDecimal ldc_subdiffprice = BigDecimal.ZERO;
        String ls_itnbr;
        String ls_itemdesc;
        String pricingtype;
        Character decode;
        List<REPPB> reppbList = null;
        boolean lb_checpoa = false;

        REPPA ra = reppaBean.findByPK(pa001, pa002);
        Crmreppalog logreppa = new Crmreppalog();
        if (ra != null) {
            // 记录抛转次数，超过3次不轮询
            if (ra.getPa518() == null || "".equals(ra.getPa518())) {
                ra.setPa518("1");
            } else {
                int i = Integer.valueOf(ra.getPa518()) + 1;
                ra.setPa518(String.valueOf(i));
            }
            logreppa.setPzcnt(Integer.parseInt(ra.getPa518()));
            // syncCRMBean.syncUpdate(ra, null);

        }
        try {
            if (ra != null) {
                logreppa.setPa001(pa001);
                logreppa.setPa002(pa002);
                List<Cdrqdta> addedDetail = new ArrayList();
                List<Cdrhpopsfk> sfkhadd = new ArrayList();
                List<Cdrdpopsfk> sfkdadd = new ArrayList();
                List<Cdrqbomsub> cqbomsubadd = new ArrayList();
                facno = ra.getPa500();
                if (facno.equals("")) {
                    logreppa.setErrdescription("找不到对应的公司别资料!");
                    throw new NullPointerException("找不到对应的公司别资料！");
                }
                Date quodate = com.lightshell.comm.BaseLib.getDate("yyyy/MM/dd",
                        com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", com.lightshell.comm.BaseLib.getDate()));
                logreppa.setIndate(com.lightshell.comm.BaseLib.getDate());
                pricingtype = ra.getPa509(); // 报价类别
                if (ra.getPa508().equals("")) {
                    decode = '1';
                } else {
                    decode = ra.getPa508().charAt(0); // 国内外码
                }
                cdrsysBean.setCompany(facno);
                cdrqsysBean.setCompany(facno);
                cdrcusBean.setCompany(facno);
                miscodeBean.setCompany(facno);
                cdrpaydscBean.setCompany(facno);
                cdrcusmanBean.setCompany(facno);
                cdrqhadBean.setCompany(facno);
                reppbList = reppaBean.getDetailList(pa001, pa002);
                if (reppbList != null && !reppbList.isEmpty()) {
                    // 表头资料
                    Cdrqhad qh = new Cdrqhad();
                    CdrqhadPK qhpk = new CdrqhadPK();
                    qhpk.setFacno(facno);
                    String lsquono = cdrqsysBean.getSerialno(facno, quodate, decode, false, "CDR225");
                    wi_s_cdrbomsubyn = cdrsysBean.getByFacno(facno).getCdrbomsubyn();
                    wi_s_acesoryyn = cdrsysBean.getByFacno(facno).getAcesoryyn();
                    wi_s_isquouse = cdrsysBean.getByFacno(facno).getIsquouse();
                    qh.setCusno(ra.getPa510());
                    Cdrcus cs = cdrcusBean.findByCusno(qh.getCusno());
                    if (cs == null) {
                        logreppa.setErrdescription("找不到对应的客户资料!");
                        throw new NullPointerException("找不到对应的客户资料！");
                    }
                    qh.setDepno(ra.getPa507());
                    qh.setQuodate(quodate);
                    String pa029 = ra.getPa029().substring(0, 4) + "/" + ra.getPa029().substring(4, 6) + "/"
                            + ra.getPa029().substring(6);
                    String pa030 = ra.getPa030().substring(0, 4) + "/" + ra.getPa030().substring(4, 6) + "/"
                            + ra.getPa030().substring(6);
                    qh.setFromdate(com.lightshell.comm.BaseLib.getDate("yyyy/MM/dd", pa029));
                    qh.setEeffdate(com.lightshell.comm.BaseLib.getDate("yyyy/MM/dd", pa030));
                    long tt = qh.getEeffdate().getTime() - qh.getFromdate().getTime();
                    long tdays = (tt / 1000 / 60 / 60 / 24);
                    qh.setEffdays((short) tdays); // 有效天数
                    qh.setDecode(decode); // 国内国外
                    if (ra.getPa517() == null || "".equals(ra.getPa517())) {
                        qh.setShptrseq((short) 1);
                    } else {
                        qh.setShptrseq(Short.valueOf(ra.getPa517())); // 指配客户代号
                    }
                    qh.setIvotrseq(cs.getIvotrseq()); // 发票客户代号
                    qh.setIsspecial(ra.getPa515()); // 是否特殊报价
                    if (pa001.trim().equals("DD")) {
                        qh.setQuotype('1');
                        qh.setHquosta('Y');
                    } else {
                        qh.setQuotype('2'); // 单对单/合约报价
                        if ("Y".equals(qh.getIsspecial())) {
                            qh.setHquosta('R');
                        } else {
                            qh.setHquosta('Y');
                        }
                    }

                    qh.setTax(ra.getPa036().charAt(0)); // 税别
                    qh.setTaxrate(ra.getPa028());
                    qh.setCoin(ra.getPa010());
                    qh.setRatio(ra.getPa018());
                    qh.setSndcode(cs.getSndcode()); // 交货条件
                    qh.setPaycode(ra.getPa012()); // 付款条件
                    qh.setTermcode(cs.getTermcode()); // 交易条件
                    if (qh.getDecode().equals('1')) {
                        Miscode mis1 = miscodeBean.findByPK("GD", qh.getSndcode());
                        if (mis1 != null) {
                            qh.setSndcodedsc(mis1.getCdesc()); // 交货条件叙述
                        }
                        Miscode mis2 = miscodeBean.findByPK("GH", qh.getTermcode());
                        if (mis2 != null) {
                            qh.setTermcodedsc(mis2.getCdesc()); // 交易条件叙述
                        }

                    } else {
                        Cdrpaydsc cdrpaydsc = cdrpaydscBean.findByPK('3', qh.getSndcode());
                        if (cdrpaydsc != null) {
                            qh.setSndcodedsc(cdrpaydsc.getAllcodedsc());
                        }
                        Cdrpaydsc cdrpaydsc2 = cdrpaydscBean.findByPK('2', qh.getTermcode());
                        if (cdrpaydsc2 != null) {
                            qh.setTermcodedsc(cdrpaydsc2.getAllcodedsc());
                        }
                    }
                    qh.setPaycodedsc(cs.getSkfs()); // 付款条件叙述
                    qh.setPaysepcode(cs.getPaysepcode()); // 付款内容区分
                    qh.setSeldate1(cs.getSeldate1()); // 付款截止日（每月几号）
                    qh.setSeldate2(cs.getSeldate2());
                    qh.setSeldate3(cs.getSeldate3());
                    qh.setSeldate4(cs.getSeldate4());
                    qh.setHandays1(cs.getHandays1()); // 整账所需天数
                    qh.setHandays2(cs.getHandays2());
                    qh.setHandays3(cs.getHandays3());
                    qh.setHandays4(cs.getHandays4());
                    qh.setTickdays(cs.getTickdays());
                    qh.setSacode(cs.getSacode());
                    qh.setAreacode(cs.getAreacode());
                    qh.setCuycode(cs.getCuycode());
                    // 业务员取CRM
                    if (ra.getPa005() != null) {
                        qh.setMancode(ra.getPa005());
                    } else {
                        Cdrcusman cusman = cdrcusmanBean.findByPK(facno, qh.getCusno());
                        if (cusman != null) {
                            qh.setMancode(cusman.getMan());
                        } else {
                            log4j.error("CRM估计单抛转轮询时异常,找不到对应的业务员~!");
                            logreppa.setErrdescription("CRM估计单抛转轮询时异常,找不到对应的业务员~!");
                        }
                    }
                    logreppa.setMancode(qh.getMancode());
                    qh.setTramts(ra.getPa020());
                    qh.setTaxamts(ra.getPa021());
                    qh.setTotamts(ra.getPa019());
                    // qh.setHmark1(""); 表头备注一
                    // qh.setHmark2("");
                    // qh.setHmark3("");
                    // qh.setHmark4(pa001 + pa002);
                    qh.setPrtcnt((short) 0);
                    qh.setPiprtcnt((short) 0);
                    qh.setBcdrno(""); // 抛转订单编号
                    qh.setIndate(com.lightshell.comm.BaseLib.getDate());
                    qh.setUserno(ra.getPa005());
                    logreppa.setCreator(ra.getPa005()); // 记录日志
                    qh.setCfmuserno(ra.getPa025()); // 审核者（设定成业务助理）
                    if (ra.getPa024().equals("")) {
                        qh.setCfmdate(
                                BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate())));
                    } else {
                        String pa024 = ra.getPa024().substring(0, 4) + "/" + ra.getPa024().substring(4, 6) + "/"
                                + ra.getPa024().substring(6);
                        qh.setCfmdate(com.lightshell.comm.BaseLib.getDate("yyyy/MM/dd", pa024));
                    }
                    // qh.setTrnuserno(""); //抛转订单人员
                    // qh.setTrndate(""); //抛转订单日期
                    qh.setPino("N"); // 列印PI否
                    qh.setCopyquono(pa001 + pa002); // 原报价单号（copy前）//记录CRM来源单号
                    qh.setSelpricode('1');
                    qh.setContactman(cs.getContactman());
                    qh.setPricingtype(pricingtype);
                    if (ra.getPa515() == null || "".equals(ra.getPa515())) {
                        throw new NullPointerException("是否特殊报价资料错误！");
                    }
                    // qh.setSpcode();
                    pricelevel = cdrqhadBean.getUserPricelevel(pricingtype, qh.getMancode());
                    li_ulevelp = Integer.parseInt(pricelevel.substring(6)); // "price09"截取数字
                    ls_levelpo = qh.getLevelp();

                    // 表身资料
                    int trseq = 0;
                    List<REPPB> reppbasry = new ArrayList<>(); // 接收赠品
                    for (REPPB rb : reppbList) {
                        // 去除赠品，取赠品数量等于0
                        if (rb.getPb010().compareTo(BigDecimal.ZERO) == 0) {
                            trseq++;
                            String itnbr = rb.getPb004();
                            Cdrqdta qd = new Cdrqdta();
                            CdrqdtaPK qdpk = new CdrqdtaPK();
                            qdpk.setFacno("C");
                            qdpk.setQuono(lsquono);
                            qdpk.setTrseq((short) trseq);
                            qd.setCdrqdtaPK(qdpk);
                            qd.setItnbr(itnbr); // 品号
                            qd.setItnbrcus(""); // 客户品号(零件无)
                            qd.setProno("1"); // 默认第一生产地
                            qd.setShptrseq(qh.getShptrseq()); // 指配代号
                            qd.setQuaqy1(rb.getPb009());
                            qd.setQuaqy2(BigDecimal.ZERO);
                            qd.setArmqy(rb.getPb009()); // 应收数量
                            qd.setUnpris(rb.getPb011());
                            qd.setUnprisrccode('0'); // 单价来源
                            qd.setTramts(rb.getPb013());
                            if (ra.getPa503() == null || "".equals(ra.getPa503())) {
                                logreppa.setErrdescription("预计交期未填写！");
                            } else {
                                String pa503 = ra.getPa503().substring(0, 4) + "/" + ra.getPa503().substring(4, 6) + "/"
                                        + ra.getPa503().substring(6);
                                qd.setCdrdate(com.lightshell.comm.BaseLib.getDate("yyyy/MM/dd", pa503)); // 预计交期
                            }
                            qd.setDmark1(rb.getPb517()); // 表身备注1(冷媒机型)
                            qd.setDmark2(""); // 表身备注2（齿数比）
                            qd.setDmark3("");
                            qd.setDmark4("");
                            // qd.setTrnstatus();
                            if (rb.getPb011() == null || rb.getPb011().equals("")) {
                                qd.setListunpri(BigDecimal.ZERO);
                            } else {
                                qd.setListunpri(rb.getPb011()); // 定价
                            }
                            qd.setDiscnt((rb.getPb012().multiply(BigDecimal.valueOf(100))).shortValue()); // 折扣数
                            // qd.setDiscnt(Short.valueOf(rb.getPb012().toString()));
                            qd.setDispri0(BigDecimal.ZERO);
                            qd.setDisqy1(BigDecimal.ZERO);
                            qd.setDispri1(BigDecimal.ZERO);
                            qd.setDisqy2(BigDecimal.ZERO);
                            qd.setDispri2(BigDecimal.ZERO);
                            qd.setDisqy3(BigDecimal.ZERO);
                            qd.setDispri3(BigDecimal.ZERO);
                            qd.setDisqy4(BigDecimal.ZERO);
                            qd.setDispri4(BigDecimal.ZERO);
                            qd.setDisqy5(BigDecimal.ZERO);
                            qd.setDispri5(BigDecimal.ZERO);
                            if (rb.getPb505() == null || rb.getPb505().equals("")) {
                                qd.setOldpri(BigDecimal.ZERO);
                            } else {
                                qd.setOldpri(BigDecimal.valueOf(Double.parseDouble(rb.getPb505()))); // 旧价
                            }
                            qd.setMorderqy(BigDecimal.ZERO); // 最小包装数量, 最小订购量
                            cdrqbomsubBean.setCompany(facno);
                            Cdrqbomsub cbomsub
                                    = cdrqbomsubBean.findByItnbrfAndCdrno(facno, qd.getItnbr(), qdpk.getQuono());
                            if (cbomsub == null) {
                                qd.setSpcode('N');
                                li_cdrbomsubitem = "0";
                            } else {
                                qd.setSpcode('Y');
                                li_cdrbomsubitem = "1";
                            }
                            BigDecimal ldc_unpris = qd.getUnpris();
                            ldc_salesprice = ldc_unpris;
                            String itemno = qd.getDmark1();
                            if (ls_levelpo == null || ls_levelpo.equals("")) {
                                ls_levelpo = "A" + li_ulevelp;
                            }
                            if ("".equals(itemno)) {
                                prpl = cdrqhadBean.getByPricingPolicy(qd.getItnbr(), pricingtype, qh.getQuodate(),
                                        qh.getCoin());
                            } else {
                                prpl = cdrqhadBean.getByPricingPolicy(qd.getItnbr(), pricingtype, qh.getQuodate(),
                                        qh.getCoin(), itemno);
                            }
                            if (prpl == null) {
                                prpl
                                        = cdrqhadBean.getByPricingPolicy(qd.getItnbr(), pricingtype, qh.getQuodate(), "RMB");
                                ldc_salesprice = ldc_unpris.multiply(qh.getRatio());
                            }
                            if (prpl == null) {
                                log4j.error(itnbr + " '未维护价格类别'" + pricingtype + "'对应的标准定价,请先维护CDR1P2!");
                                logreppa.setErrdescription(itnbr + " '未维护价格类别'" + pricingtype + "'对应的标准定价,请先维护CDR1P2!");
                                // 如果是随整机销售零件 return 3
                                if ("RC".equals(pricingtype)) {
                                    pricingtype = "RCS";
                                    pricelevel = "price03";
                                } else {
                                    qh.setIsspecial("Y");
                                }
                                // dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10 如果没有查找到价格,则记录
                                qd.setDqxjkind('D');

                            } else {
                                // 判断A9牌价
                                BigDecimal ldc_a9unpri
                                        = BigDecimal.valueOf(Double.valueOf(prpl[10 + li_ulevelp].toString()));
                                if (ldc_a9unpri == null || ldc_a9unpri.compareTo(BigDecimal.ZERO) == 0) {
                                    log4j.info("此件号" + itnbr + "还未维护A9牌价");
                                    logreppa.setErrdescription("此件号" + itnbr + "还未维护A9牌价");
                                }
                                li_ulevelp = Integer.parseInt(pricelevel.substring(6)); // "price0X"截取数字
                                ldc_stdprice = BigDecimal.valueOf(Double.valueOf(prpl[10 + li_ulevelp].toString())); // prpl标准定价数组的顺序（数量）不能修改
                                if (ldc_stdprice == null || ldc_stdprice.compareTo(BigDecimal.ZERO) < 1) {
                                    log4j.error("错误'" + itnbr + "'的 '" + itemno + "'机型未维护价格类别'" + pricingtype
                                            + "'对应的标准定价,请先维护!");
                                    // dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10 如果没有查找到价格,则记录
                                    logreppa.setErrdescription("错误'" + itnbr + "'的 '" + itemno + "'机型未维护价格类别'"
                                            + pricingtype + "'对应的标准定价,请先维护!");
                                    qh.setIsspecial("Y");
                                    qd.setDqxjkind('D');
                                }
                                ls_itnbr = prpl[0].toString();
                                ls_itemdesc = prpl[2].toString();
                                if (ls_itemdesc == null || "".equals(ls_itemdesc)) {
                                    invmasBean.setCompany(facno);
                                    Invmas m = invmasBean.findByItnbr(ls_itnbr);
                                    // ls_itemdesc = m.getItdsc();
                                }
                                if (ldc_stdprice.compareTo(ldc_salesprice) > 0) {
                                    lb_checpoa = true;
                                    if (li_ulevelp > 1) {
                                        for (int i = li_ulevelp; i >= 1; i--) {
                                            if (prpl[10 + i] == null) { // 无A价（权限价如A5）
                                                continue;
                                            } else {
                                                ldc_levelpri
                                                        = BigDecimal.valueOf(Double.valueOf(prpl[10 + i].toString())); // prpl标准定价数组的顺序（数量）不能修改
                                            }
                                            if (ldc_levelpri == null || ldc_levelpri.compareTo(BigDecimal.ZERO) < 1) {
                                                log4j.error(
                                                        "出错，第" + i + "笔件号'" + itnbr + "'当前售价不符合价格权限表管控范围,请走特殊报价或联系mis'");
                                                // dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10
                                                // 如果没有查找到价格,则记录
                                                logreppa.setErrdescription(
                                                        "出错，第" + i + "笔件号'" + itnbr + "'当前售价不符合价格权限表管控范围,请走特殊报价或联系mis'");
                                                qh.setIsspecial("Y");
                                                continue;
                                            }
                                            if (ldc_levelpri.compareTo(ldc_salesprice) < 1) {
                                                if (li_ulevelp > i) {
                                                    ls_levelpo = "A" + i;
                                                    qh.setLevelp(ls_levelpo);
                                                    qd.setLevelp(ls_levelpo);
                                                    break;
                                                }

                                            }

                                        }
                                    }

                                }
                            }
                            // 单价为零且不算赠品配件（如油品）
                            if (rb.getPb010().compareTo(BigDecimal.ZERO) == 0
                                    && rb.getPb011().compareTo(BigDecimal.ZERO) == 0) {
                                qd.setLevelp("A2");
                                qh.setLevelp("A2");
                            }
                            // qd.setContunpri(BigDecimal.ZERO);
                            // qd.setNorm("");
                            // qd.setIslableprt(Character.MIN_VALUE);
                            // qd.setHisorders("");
                            // qd.setContractno("");
                            qd.setNcodeDA(rb.getPb513()); // 事业部
                            qd.setNcodeCD(rb.getPb515()); // 区域别
                            qd.setNcodeDC(rb.getPb514()); // 产品别
                            qd.setNcodeDD(rb.getPb516()); // 整机或者零件
                            // qd.setCuslable("");
                            // CDR225确认--关于订单规格表判定

                            ls_cdrbomsubyn = 'N';
                            ls_cdrothsfk = 'N';
                            if ("J".equals(facno) || "N".equals(facno) || "G".equals(facno) || "C4".equals(facno)
                                    || "K".equals(facno)) {
                                facno = "C";
                            }
                            Invmas invmas = invmasBean.findByItnbr(itnbr);
                            ls_cdrbomsubyn = invmas.getInvcls().getCdrbomsubyn();
                            if (ls_cdrbomsubyn == null) {
                                ls_cdrbomsubyn = 'N';
                            }
                            // ==> C0583 2014.9.11 订单规格不管控，但仍需维护身份卡之品号大类
                            if (ls_cdrbomsubyn.equals('N')) {
                                if (cdrqhadBean.findByItcls(facno, invmas.getItcls()) != null) {
                                    ls_cdrothsfk = 'Y';
                                }
                            }
                            // 维护身份卡信息 cb_sfkn 可见 ==< DDGA
                            DDGA ddga = ddgaBean.findByREPPB(pa001, pa002, rb.getREPPBPK().getPb003());
                            if (ddga != null) {
                                if (ls_cdrbomsubyn.equals('Y') || ls_cdrothsfk.equals('Y')) {
                                    cdrhpopsfkBean.setCompany(facno);
                                    Cdrhpopsfk sfkh = new Cdrhpopsfk();
                                    CdrhpopsfkPK sfkhPK = new CdrhpopsfkPK();
                                    if (ddga.getGa007() == null || "".equals(ddga.getGa007())) {
                                        sfkhPK.setFacno(facno);
                                    } else {
                                        sfkhPK.setFacno(ddga.getGa007());
                                    }
                                    String lsno = cdrhpopsfkBean.gettrno(facno, quodate, "CDR220", false);
                                    sfkhPK.setSfktrno(lsno);
                                    sfkh.setCdrhpopsfkPK(sfkhPK);
                                    sfkh.setCusno(ddga.getGa009());
                                    sfkh.setItnbr(itnbr);
                                    sfkh.setItnbrcus(ddga.getGa005());
                                    sfkh.setSpcode(ddga.getGa008().charAt(0));
                                    sfkh.setVersion(ddga.getGa011());
                                    sfkh.setQuono(lsquono);
                                    sfkh.setQtrseq(qdpk.getTrseq());
                                    sfkh.setCdrno("");
                                    // sfkh.setManno("");
                                    sfkh.setCdrno("");
                                    sfkh.setSpdesc(ddga.getGa010());
                                    sfkh.setCrtprg("CDR220");
                                    sfkh.setKeyindate(quodate);
                                    sfkh.setVarnr("");
                                    sfkh.setMatcode("");
                                    // 身份卡表身
                                    List<DDGB> ddgbList = ddgaBean.getDetailList(ddga.getDDGAPK().getGa004());
                                    if (ddgbList.size() > 0) {
                                        for (DDGB ddgb : ddgbList) {
                                            Cdrdpopsfk sfkd = new Cdrdpopsfk();
                                            CdrdpopsfkPK sfkdpk = new CdrdpopsfkPK();
                                            sfkdpk.setFacno(sfkh.getCdrhpopsfkPK().getFacno());
                                            sfkdpk.setParts(ddgb.getGb003());
                                            sfkdpk.setSfktrno(sfkhPK.getSfktrno());
                                            sfkdpk.setSorts(ddgb.getGb004());
                                            sfkd.setCdrdpopsfkPK(sfkdpk);
                                            cdrsfkpartBean.setCompany("C");
                                            Cdrsfkpart sfkpart = cdrsfkpartBean.findByPK(facno, ddgb.getGb003());
                                            if (sfkpart != null) {
                                                sfkd.setPartdesc(sfkpart.getPartsdesc());
                                                sfkd.setPapx(sfkpart.getPx());
                                            }
                                            Cdrsfksorts sfksort
                                                    = cdrsfksortsBean.findByPK(facno, ddgb.getGb003(), ddgb.getGb004());
                                            if (sfksort != null) {
                                                sfkd.setSortsdesc(sfksort.getSortsdesc());
                                            }
                                            sfkd.setSpecifit(ddgb.getGb005());
                                            Cdrsfkspec sfkspec = cdrsfkspecBean.findByPK(facno, ddgb.getGb003(),
                                                    ddgb.getGb004(), ddgb.getGb005());
                                            if (sfkspec != null) {
                                                sfkd.setSpecifitesc(sfkspec.getSpecifitesc());
                                            }
                                            sfkdadd.add(sfkd);
                                        }
                                    }
                                    sfkhadd.add(sfkh);
                                    // cdrhpopsfkBean.persist(sfkh);
                                    // cdrhpopsfkBean.persistDetailList(facno, sfkdList);
                                }
                            }
                            // 订单规格表维护
                            if (wi_s_cdrbomsubyn.equals('Y')) {
                                if (ls_cdrbomsubyn.equals('Y') && "0".equals(li_cdrbomsubitem)) {
                                    DDGC ddgc = ddgcBean.findByREPPB(pa001, pa002, rb.getREPPBPK().getPb003());
                                    BigDecimal ldc_price = BigDecimal.ZERO;
                                    // String ls_contractno = qd.getContractno();
                                    // short li_contseq = qd.getContrseq();
                                    if (ddgc != null) {
                                        cdrqbomsubBean.setCompany(facno);
                                        Cdrqbomsub cqbomsub = new Cdrqbomsub();
                                        CdrqbomsubPK cqbomsubpk = new CdrqbomsubPK();
                                        cqbomsubpk.setFacno(facno);
                                        cqbomsubpk.setCdrno(lsquono);
                                        cqbomsubpk.setTrseq(qdpk.getTrseq());
                                        cqbomsub.setCdrqbomsubPK(cqbomsubpk);
                                        cqbomsub.setItnbrf(ddgc.getGc006());
                                        cqbomsub.setSpcode(ddgc.getGc008().charAt(0));
                                        cqbomsub.setSpdesc(ddgc.getGc009());
                                        // cqbomsub.setSpdesc2(""); //规格说明2
                                        // 规格明细
                                        List<DDGD> ddgdList = ddgcBean.getDetailList(ddgc.getDDGCPK().getGc004());
                                        if (ddgdList.size() > 0) {
                                            for (int i = 0; i < ddgdList.size(); i++) {
                                                String ls_defsubitnbrs = "";
                                                Method setMethod1 = cqbomsub.getClass()
                                                        .getDeclaredMethod("set" + "Itdesc" + (i + 1), String.class);
                                                setMethod1.invoke(cqbomsub, ddgdList.get(i).getGd003());
                                                Method setMethod2 = cqbomsub.getClass()
                                                        .getDeclaredMethod("set" + "Itnbr" + (i + 1), String.class);
                                                setMethod2.invoke(cqbomsub, ddgdList.get(i).getGd007());
                                                Method setMethod3 = cqbomsub.getClass()
                                                        .getDeclaredMethod("set" + "Itscode" + (i + 1), String.class);
                                                String itscode = "";
                                                if (ddgdList.get(i).getGd003().equals(ddgdList.get(i).getGd005())) {
                                                    itscode = "00"; // 标准
                                                } else {
                                                    Bomsub bomsub = bomsubBean.findByPKItnbrs(ddgc.getGc006(),
                                                            ddgdList.get(i).getGd007(), ddgdList.get(i).getGd005());
                                                    if (null != bomsub) {
                                                        if (bomsub.getSeqnr() < 10) {
                                                            itscode = "0" + bomsub.getSeqnr();
                                                        } else {
                                                            itscode = String.valueOf(bomsub.getSeqnr());
                                                        }
                                                    } else {
                                                        log4j.error("订单规格表查询异常!");
                                                        logreppa.setErrdescription("订单规格表-itscode 查询异常!");
                                                    }
                                                }
                                                setMethod3.invoke(cqbomsub, itscode);
                                                // setMethod3.invoke(cqbomsub, ddgdList.get(i).getGd004());
                                                Method setMethod4 = cqbomsub.getClass()
                                                        .getDeclaredMethod("set" + "Itsdesc" + (i + 1), String.class);
                                                setMethod4.invoke(cqbomsub, ddgdList.get(i).getGd004());
                                                Method setMethod5 = cqbomsub.getClass()
                                                        .getDeclaredMethod("set" + "Itnbrs" + (i + 1), String.class);
                                                setMethod4.invoke(cqbomsub, ddgdList.get(i).getGd005());
                                                // 获得规格表的标准定价（确认）
                                                BigDecimal ldc_stdqty2 = BigDecimal.ZERO;
                                                BigDecimal ldc_stdqty = BigDecimal.ZERO;
                                                BigDecimal ldc_price02 = BigDecimal.ZERO;
                                                BigDecimal ldc_price01 = BigDecimal.ZERO;
                                                CdrbomsubDefault cbdefault
                                                        = cdrbomsubDefaultBean.findByPK(facno, qd.getItnbr(), qd.getDmark1());
                                                if (null != cbdefault) {
                                                    for (int ll_defrow = 1; ll_defrow <= 25; ll_defrow++) {
                                                        Field f
                                                                = cbdefault.getClass().getDeclaredField("itnbr" + ll_defrow);
                                                        f.setAccessible(true);
                                                        if (null == f.get(cbdefault) || "".equals(f.get(cbdefault))) {
                                                            log4j.error(
                                                                    "规格主料" + ddgdList.get(i).getGd007() + "在CDR1A6中未找到!");
                                                            logreppa.setErrdescription(
                                                                    "规格主料" + ddgdList.get(i).getGd007() + "在CDR1A6中未找到!");
                                                            break;
                                                        }
                                                        String ls_defsubitnbr = f.get(cbdefault).toString();
                                                        if (ls_defsubitnbr.equals(ddgdList.get(i).getGd007())) {
                                                            Field f1 = cbdefault.getClass()
                                                                    .getDeclaredField("itnbrs" + ll_defrow);
                                                            f1.setAccessible(true);
                                                            ls_defsubitnbrs = f1.get(cbdefault).toString();
                                                            break;
                                                        }

                                                    }
                                                    Bomsub bs = bomsubBean.findByPKItnbrs(ddgc.getGc006(),
                                                            ddgdList.get(i).getGd007(), ddgdList.get(i).getGd005());
                                                    if (null != bs) {
                                                        ldc_stdqty = bs.getStdqty();
                                                    }
                                                    // ls_pricingtype='01' //C0583 订单规格差别取固定定价类别'00'，且价格级别为A1价
                                                    Object[] bompri = cdrqhadBean.getByPricingPolicy(
                                                            ddgdList.get(i).getGd005(), "01", quodate, "RMB");
                                                    // 取price02 价格
                                                    ldc_price02
                                                            = BigDecimal.valueOf(Double.valueOf(bompri[12].toString()));
                                                    ldc_price = ldc_price.add(ldc_stdqty.multiply(ldc_price02));

                                                    Bomsub bs2 = bomsubBean.findByPKItnbrs(ddgc.getGc006(),
                                                            ddgdList.get(i).getGd007(), ls_defsubitnbrs);
                                                    if (null != bs2) {
                                                        ldc_stdqty2 = bs2.getStdqty();
                                                    }
                                                    Object[] bompri2 = cdrqhadBean.getByPricingPolicy(ls_defsubitnbrs,
                                                            "01", quodate, "RMB");
                                                    // 取price01价格
                                                    ldc_price01
                                                            = BigDecimal.valueOf(Double.valueOf(bompri2[11].toString()));
                                                    ldc_subdiffprice
                                                            = ldc_price.subtract(ldc_stdqty2.multiply(ldc_price01));
                                                    // wf_get_standpricing1
                                                    String ls_difpriclev = cdrqhadBean.getDeflevel(pricingtype);
                                                    int priclev = Integer.parseInt(ls_difpriclev.substring(6));
                                                    BigDecimal ldc_deflevpricen = BigDecimal
                                                            .valueOf(Double.valueOf(prpl[10 + priclev].toString()));
                                                    qd.setDeflevprice(ldc_deflevpricen);
                                                    double ldc_qxb = (qd.getUnpris().subtract(ldc_deflevpricen)
                                                            .subtract(ldc_subdiffprice)).doubleValue() * 100
                                                            / (ldc_deflevpricen).doubleValue();
                                                    String ls_qxb = BigDecimal.valueOf(ldc_qxb).setScale(2,
                                                            BigDecimal.ROUND_HALF_UP) + "%";
                                                    qd.setQxb(ls_qxb);
                                                    // 扣减规格差异价格
                                                    // ldc_unpris = ldc_unpris.subtract(ldc_subdiffprice);
                                                }

                                            }

                                        }
                                        // cdrqbomsubBean.persist(cqbomsub);
                                        cqbomsubadd.add(cqbomsub);
                                        // throw new RuntimeException("第" + qdpk.getTrseq() +
                                        // 笔订单规格表尚未维护不可确认!");
                                    }
                                }
                            }
                            // BigDecimal ldc_contunpri = qd.getContunpri();
                            // if (ldc_contunpri.compareTo(BigDecimal.ZERO) > 0) {
                            // if (ldc_unpris.compareTo(ldc_contunpri.add(ldc_subdiffprice)) >= 0) {
                            // continue;
                            // }
                            // }

                            addedDetail.add(qd);
                        } else if (rb.getPb010().compareTo(BigDecimal.ZERO) > 0) {
                            reppbasry.add(rb);
                        }
                    }
                    // 维护订单配件
                    List<Cdrqasry> cqasryadd = new ArrayList();
                    if (wi_s_acesoryyn == 'Y') {
                        // 获取CRM表身明细中的赠品配件，根据品号分组
                        if (reppbasry.size() > 0) {
                            for (Cdrqdta qdadd : addedDetail) {
                                int k = 0;
                                for (int j = 0; j < reppbasry.size(); j++) {
                                    if (reppbasry.get(j).getPb519().equals(qdadd.getItnbr())) {
                                        k++;
                                        Cdrqasry cqasry = new Cdrqasry();
                                        CdrqasryPK cqasrypk = new CdrqasryPK();
                                        cqasrypk.setFacno(facno);
                                        cqasrypk.setQuono(lsquono);
                                        cqasrypk.setTrseq(qdadd.getCdrqdtaPK().getTrseq()); // 报价单身序号
                                        cqasrypk.setSeq((short) k); // 配件表身序号
                                        String ls_dmark = "";
                                        if (qdadd.getDmark1() == null || "".equals(qdadd.getDmark1())) {
                                            if (qdadd.getDmark2() == null || "".equals(qdadd.getDmark2())) {
                                            } else {
                                                ls_dmark = qdadd.getDmark2();
                                            }
                                        } else {
                                            ls_dmark = qdadd.getDmark1();
                                        }
                                        if (bomasryBean.findByItnbrfAndCmccode(qdadd.getItnbr(), ls_dmark) == null) {
                                            ls_dmark = "9";
                                        }
                                        cqasrypk.setCmccode(ls_dmark);
                                        cqasry.setCdrqasryPK(cqasrypk);
                                        cqasry.setItnbr(reppbasry.get(j).getPb004());
                                        cqasry.setItnbrf(qdadd.getItnbr());
                                        cqasry.setProsscode("");
                                        cqasry.setStdqty(reppbasry.get(j).getPb010());
                                        cqasry.setStdpar((short) 1);
                                        cqasry.setBadrat(BigDecimal.ZERO);
                                        cqasryadd.add(cqasry);
                                        // cdrqasryBean.persist(cqasry);
                                        // 维修品号，重算levelp
                                        if (invmasBean.findByItnbr(qdadd.getItnbr()).getItdsc().contains("维修品号")) {
                                            String temlp = cdrqhadBean.getPricingLevel(reppbasry.get(j).getPb013(),
                                                    reppbasry.get(j).getPb004(), pricingtype, quodate, qh.getCoin());
                                            if (!"".equals(temlp)) {
                                                if (null == qh.getLevelp() || "".equals(qh.getLevelp())) {
                                                    qh.setLevelp(temlp);
                                                } else {
                                                    int Ap = Integer.parseInt(temlp.substring(1));
                                                    int hp = Integer.parseInt(qh.getLevelp().substring(1));
                                                    if (Ap < hp) {
                                                        qh.setLevelp(temlp);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    // qh.setOacfuser("");
                    // qh.setCuspono();
                    qh.setApprresno(ra.getPa520()); // 审批原因
                    // qh.setWarranty(Short.MAX_VALUE);
                    // qh.setNewcusna(facno);

                    String quono = cdrqsysBean.getSerialno(facno, quodate, decode, true, "CDR225");
                    if (!quono.equals(lsquono)) {
                        throw new RuntimeException("报价单号产生错误，请确认");
                    }
                    qhpk.setQuono(quono); // 报价单号
                    qh.setCdrqhadPK(qhpk);
                    if ("A1".equals(qh.getLevelp())) {
                        qh.setIsspecial("Y");
                    }
                    if ("Y".equals(wi_s_isquouse)) {
                        if ("Y".equals(qh.getIsspecial()) || lb_checpoa == true) {
                            qh.setHquosta('R');// 抛转OA
                        }
                    }
                    try {
                        cdrqhadBean.setCompany(facno);
                        cdrqhadBean.persist(qh);
                        cdrqhadBean.persistDetailList(facno, addedDetail);
                        cdrqhadBean.getEntityManager().flush();
                        if (cqasryadd.size() > 0) {
                            cqasryadd.forEach((cqasry) -> {
                                cdrqasryBean.persist(cqasry);
                            });
                        }
                        if (sfkhadd.size() > 0 && sfkdadd.size() > 0) {
                            cdrhpopsfkBean.setCompany(facno);
                            cdrhpopsfkBean.gettrno(facno, quodate, "CDR220", true);
                            sfkhadd.forEach((cdrhpopsfk) -> {
                                cdrhpopsfkBean.persist(cdrhpopsfk);
                            });
                            cdrhpopsfkBean.persistDetailList(facno, sfkdadd);
                        }
                        if (cqbomsubadd.size() > 0) {
                            cqbomsubadd.forEach((cdrqbomsub) -> {
                                cdrqbomsubBean.persist(cdrqbomsub);
                            });
                        }
                    } catch (Exception e) {
                        logreppa.setErrdescription("数据库存储报错！！" + e);
                        throw new RuntimeException("数据库存储报错！！" + e);
                    }
                    ra.setPa027("Y");
                    ra.setPa519(quono);
                    reppaBean.update(ra);
                    logreppa.setQuono(quono);
                    crmreppalogBean.setCompany("C");
                    crmreppalogBean.persist(logreppa);
                    crmreppalogBean.getEntityManager().flush();
                    try {
                        mailBean.getTo().clear();
                        mailBean.getTo().add("C1491@hanbell.com.cn");
                        mailBean.getTo().add("C1497@hanbell.com.cn");
                        mailBean.setMailSubject("CRM估价单抛转成功");
                        mailBean.setMailContent(
                                "报价单号：" + logreppa.getPa001() + logreppa.getPa002() + "抛转成功，生成ERP单号：" + quono);
                        mailBean.notify(new MailNotify());
                        log4j.info("Info", "报表邮件发送成功");
                    } catch (Exception ex) {
                        log4j.info("Error", ex.toString());
                    }
                    return "200--- 抛转成功，单号：" + lsquono;
                }

            }
            log4j.info("CRM估计单抛转");
            return "404--读取资料错误";

        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException
                | InvocationTargetException | ParseException ex) {
            logreppa.setErrdescription(ex.toString());
            crmreppalogBean.setCompany("C");
            crmreppalogBean.persist(logreppa);
            crmreppalogBean.getEntityManager().flush();
            log4j.error("CRM估计单抛转轮询时异常", ex);
            mailBean.getTo().clear();
            mailBean.getTo().add("C1491@hanbell.com.cn");
            mailBean.getTo().add("C1497@hanbell.com.cn");
            mailBean.setMailSubject("CRM估价单抛转失败");
            mailBean.setMailContent(
                    "报价单号：" + logreppa.getPa001() + logreppa.getPa002() + "抛转失败,异常：" + logreppa.getErrdescription());
            mailBean.notify(new MailNotify());
            log4j.info("Info", "报表邮件发送失败");
            return String.format("执行%s:参数%s时异常%s:", "createERPQuoteByCRMREPPA", pa001 + pa002,
                    "*****" + logreppa.getErrdescription());
        }

    }

    @WebMethod(operationName = "createERPINV150ByOASHBERPINV150")
    public String createERPINV150ByOASHBERPINV150(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invwhBean.initByOASHBERPINV150(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createERPINV150ByOASHBERPINV150", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createERPINV310ByOAHKGC003")
    public String createERPINV310ByOAHKGC003(@WebParam(name = "psn") String psn) {
        String ret = null;
        try {
            ret = invhadBean.initByOAHKGC003(psn);
        } catch (Exception ex) {
            log4j.error("createERPINV310ByOAHKGC003", ex);
            throw new RuntimeException(ex);
        }
        if (ret != null && !"".equals(ret)) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createERPINV310ByOASHBERPINV310")
    public String createERPINV310ByOASHBERPINV310(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invhadBean.initByOASHBERPINV310(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createERPINV310ByOASHBERPINV310", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            //加入邮件通知
            mailBean.clearReceivers();
            mailBean.getTo().add("C1491@hanbell.com.cn");
            mailBean.getTo().add("C1900@hanbell.com.cn");
            mailBean.setMailSubject("OA新增手工领料单失败");
            mailBean.setMailContent("OA新增手工领料单抛转ERP 失败，流程序号：" + psn);
            mailBean.notify(new MailNotify());
            return "404";
        }
    }

    @WebMethod(operationName = "createERPINV325ByOAHKGC001")
    public String createERPINV325ByOAHKGC001(@WebParam(name = "psn") String psn) {
        String ret = null;
        try {
            ret = invhadBean.initByOAHKGC001(psn);
            log4j.info(String.format("成功执行%s:参数%s", "createERPINV325ByOAHKGC001", psn), ret);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createERPINV325ByOAHKGC001", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret != null && !"".equals(ret)) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createERPMIS226ByOAMIS226")
    public String createERPMIS226ByOAMIS226(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = secgprgBean.initBySHBERPMIS226(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createERPMIS226ByOAMIS226", psn), ex);
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createERPMIS226ByOAHKGL066")
    public String createERPMIS226ByOAHKGL066(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = secgprgBean.initByOAHKGL066(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createERPMIS226ByOAHKGL066", psn), ex);
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createOAHKCG007ByOAHKCW002")
    public String createOAHKCG007ByOAHKCW002(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkcg007Bean.initByHKCW002(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createOAHKCG007ByOAHKCW002", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    /**
     * Web 服务操作
     *
     * @param psn
     * @return
     */
    @WebMethod(operationName = "createOAHKGC002ByOAHKGC001")
    public String createOAHKGC002ByOAHKGC001(@WebParam(name = "psn") String psn) {
        String ret = null;
        try {
            ret = hkgc002Bean.initByHKGC001(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createOAHKGC002ByOAHKGC001", psn), ex);
            throw ex;
        }
        if (ret != null && !"".equals(ret)) {
            return "200";
        } else {
            return "404";
        }
    }

    /**
     * 返台申请单结案自动申请派公务车
     *
     * @param psn
     * @return
     */
    @WebMethod(operationName = "createOAHKGL037ByOAHKGL055")
    public String createOAHKGL037ByOAHKGL055(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkgl037Bean.initByHKGL055(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createOAHKGL037ByOAHKGL055", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    /**
     * 出差单结案自动申请派车
     *
     * @param psn
     * @return
     */
    @WebMethod(operationName = "createOAHKGL037ByOAHZGL004")
    public String createOAHKGL037ByOAHZGL004(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkgl037Bean.initByHZGL004(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createOAHKGL037ByOAHKGL055", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createPLMProjectByOAPLMProject")
    public String createPLMProjectByOAPLMProject(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        String projno, projnoForamt;
        cn.hanbell.oa.entity.PLMProject ep;
        List<cn.hanbell.oa.entity.PLMProjectDetail> detailList;

        cn.hanbell.plm.entity.PLMProject pp;
        cn.hanbell.plm.entity.PLMTeam pt;
        List<cn.hanbell.plm.entity.PLMTeam> teamList = new ArrayList<>();
        HashMap<SuperEJB, List<?>> detailAdded = new HashMap<>();
        detailAdded.put(plmPLMTeamBean, teamList);
        try {
            ep = efgpPLMProjectBean.findByPSN(psn);
            if (ep == null) {
                throw new NullPointerException(psn + "不存在");
            } else if (ep.getProjno() != null && !"".equals(ep.getProjno())) {
                pp = plmPLMProjectBean.findByProjno(ep.getProjno());
                if (pp != null) {
                    return "200";
                }
            }
            efgpPLMProjectBean.setDetail(ep.getFormSerialNumber());
            detailList = efgpPLMProjectBean.getDetailList();
            if (detailList == null || detailList.isEmpty()) {
                throw new NullPointerException(psn + "没有明细资料");
            }
            projnoForamt = "P" + ep.getFacno() + ep.getUseNature() + ep.getProduction();
            projno = plmPLMProjectBean.getFormId(ep.getStartDate(), projnoForamt, "yy", 2);
            if (projno == null || "".equals(projno)) {
                throw new RuntimeException(psn + "无法获取项目编号");
            }

            ep.setProjno(projno);
            for (cn.hanbell.oa.entity.PLMProjectDetail epd : detailList) {
                pt = new cn.hanbell.plm.entity.PLMTeam(ep.getProjno(), epd.getProjrole(), epd.getUserId());
                pt.setTeamrole(epd.getTeamrole());
                pt.setExestatus("N");
                pt.setIndate(BaseLib.getDate());
                teamList.add(pt);
            }
            // 需要重设项目编号
            pp = new cn.hanbell.plm.entity.PLMProject(ep.getProjno(), ep.getProjname());
            pp.setProjman(ep.getProjman());
            pp.setSeries(ep.getProduction());
            pp.setProno(ep.getFacno());
            pp.setProjexample(ep.getProjexample());
            pp.setProjdsc(ep.getDescription());
            pp.setProjfromdate(ep.getStartDate());
            pp.setProjtype(ep.getProjtype());
            pp.setExestatus("N");
            pp.setIndate(BaseLib.getDate());
            // 保存数据
            plmPLMProjectBean.persist(pp, detailAdded, null, null);
            efgpPLMProjectBean.update(ep);
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "createPLMProjectByOAPLMProject", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackCRMPORMYByOABXD")
    public String rollbackCRMPORMYByOABXD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hzcw028Bean.rollbackCRMPORMY(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackCRMPORMYByOABXD", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackCRMPORMYByOAJZGHD")
    public String rollbackCRMPORMYByOAJZGHD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hzcw033Bean.rollbackCRMPORMY(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackCRMPORMYByOAJZGHD", psn), ex);
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
            ret = hkfw004DetailBean.rollbackReptdByOAHKFW004(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackCRMREPTDByOAHKFW004", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackCRMWARTAByOAWARMI05")
    public String rollbackCRMWARTAByOAWARMI05(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = warmi05Bean.rollbackWARTA(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackCRMWARTBByOAWARMI05", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackEAMAssetCardByOAHZCW034")
    public String rollbackEAMAssetCardByOAHZCW034(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HZCW034 e;
        List<HZCW034Detail> detailList;
        try {
            e = hzcw034Bean.findByPSN(psn);
            if (e == null) {
                throw new NullPointerException(psn + "不存在");
            } else if (e.getSourceno() != null && !"".equals(e.getSourceno())) {
                return "200";
            }
            hzcw034Bean.setDetail(e.getFormSerialNumber());
            detailList = hzcw034Bean.getDetailList();
            if (detailList == null || detailList.isEmpty()) {
                throw new NullPointerException(psn + "没有明细资料");
            }
            AssetCard ac;
            AssetItem ai;
            List<AssetCard> editedAssetCard = new ArrayList<>();
            int i = 0;
            for (HZCW034Detail d : detailList) {
                ac = assetCardBean.findByAssetno(d.getAssetno());
                ai = assetItemBean.findByItemno(d.getItnbr());
                if (ac == null) {
                    throw new RuntimeException(d.getAssetno() + "EAM中不存在");
                } else if (ac.getScrap()) {
                    throw new RuntimeException(d.getAssetno() + "EAM中已报废");
                }
                if (ai == null) {
                    throw new RuntimeException(d.getItnbr() + "EAM中不存在");
                }
                ac.setPause(false);
                editedAssetCard.add(ac);
            }
            assetCardBean.update(editedAssetCard);
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackEAMAssetCardByOAHZCW034", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackEAMAssetDisposeByOAHZCW034")
    public String rollbackEAMAssetDisposeByOAHZCW034(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HZCW034 e;
        try {
            e = hzcw034Bean.findByPSN(psn);
            if (e == null) {
                throw new NullPointerException(psn + "不存在");
            } else if (e.getDisposeno() == null || "".equals(e.getDisposeno())) {
                return "200";
            }
            AssetDispose ad = assetDisposeBean.findByFormId(e.getDisposeno());
            if (ad == null) {
                throw new NullPointerException(e.getDisposeno() + "不存在");
            }
            assetDisposeBean.unverify(ad);
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackEAMAssetDisposeByOAHZCW034", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }

    }

    @WebMethod(operationName = "rollbackApmaphByOAAPM811")
    public String rollbackApmaphByOAAPM811(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmaphBean.rollApmtbil(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackApmaphByOAAPM811", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackApmaphByOAAPM828")
    public String rollbackApmaphByOAAPM828(@WebParam(name = "psn") String psn) {
        try {
            SHBERPAPM828 master = shberpapm828Bean.findByPSN(psn);
            if (master == null) {
                throw new NullPointerException(psn);
            }
            String facno = master.getFacno();
            String apno = master.getApno();
            String aptyp = master.getAptyp();
            apmaphBean.setCompany(facno);
            Apmaph entity = apmaphBean.findByPK(facno, apno, aptyp);
            if (entity.getApsta().equals("25")) {
                entity.setOano("");
                entity.setApsta("20");
                entity.setPzsta(' ');
                apmaphBean.update(entity);
            }
            return "200";
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackApmaphByOAAPM828", psn), ex);
        }
        return "404";
    }

    @WebMethod(operationName = "rollbackERPCDR220ByOAHKYX009")
    public String rollbackERPCDR220ByOAHKYX009(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = cdrqhadBean.rollbackByOAHKYX009(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateERPCDR220ByOAHKYX009", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "rollbackERPCdrqhadByCRMREPPA")
    public String rollbackERPCdrqhadByCRMREPPA(@WebParam(name = "facno") String facno,
            @WebParam(name = "pa001") String pa001, @WebParam(name = "pa002") String pa002) {
        String ret = "404";
        try {
            ret = cdrqhadBean.rollbackFromCRMREPPA(facno, pa001, pa002);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackERPCdrqhadByCRMREPPA", pa001 + pa002), ex);
            return String.format("执行%s:参数%s时异常%s:", "rollbackERPCdrqhadByCRMREPPA", pa001 + pa002, "******" + ex);
        }
        return ret;
    }

    @WebMethod(operationName = "rollbackMESHKFW006ByOAHKFW006")
    public String rollbackMESHKFW006ByOAHKFW006(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkfw006Bean.rollbackCRMHKFW006ByOAFW006(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPMIByOAHKFW006", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    /**
     * Web service operation
     *
     * @param psn
     * @return
     */
    @WebMethod(operationName = "rollbackOAHKGC001ByOAHKGC003")
    public String rollbackOAHKGC001ByOAHKGC003(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkgc003Bean.rollbackHKGC001(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "rollbackOAHKGC001ByOAHKGC003", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    /**
     * 发送企业微信消息
     *
     * @param psn 流程序号
     * @param step 流程步骤
     * @return
     */
    @WebMethod(operationName = "sendWeComMessageByOAHSPB015")
    public String sendWeComMessageByOAHSPB015(@WebParam(name = "psn") String psn,
            @WebParam(name = "step") String step) {
        Boolean ret = false;
        try {
            ProcessInstance pi = processInstanceBean.findBySerialNumber(psn);
            HSPB015 entity = hspb015Bean.findByPSN(psn);
            if (pi == null || entity == null) {
                return "404";
            }
            ParticipantActivityInstance pai;
            Users user;
            agent1000002Bean.initConfiguration();
            String resmsg = "";
            switch (step) {
                case "ACT10":
                    Functions function = processInstanceBean.findFunctionsByUserOIDAndOrgUnitOID(pi.getRequesterOID(),
                            pi.getInvokeOrganizationUnitOID());
                    user = usersBean.findByOID(function.getSpecifiedManagerOID());
                    pai = participantActivityInstanceBean.findByContextOIDAndDefinitionId(pi.getContextOID(), step);
                    if (pai != null) {
                        String workItemOID = workItemBean.getWorkItemOID(pai.getOID(), pi.getContextOID());
                        if (workItemOID != null && !workItemOID.isEmpty()) {
                            StringBuilder taskcard = new StringBuilder();
                            taskcard.append("{");
                            taskcard.append("'title':'[").append(hspb015Bean.getCompanyName(entity.getFacno()))
                                    .append("]设备报修',");
                            taskcard.append("'description':'").append(entity.getMachineCode()).append("设备<br/>发生")
                                    .append(entity.getFaultContent()).append("故障<br/>需要报修处理',");
                            taskcard.append("'task_id':'").append(psn).append("@").append(workItemOID).append("',");
                            taskcard.append("'btn':[");
                            taskcard.append("{'key':'reject','name':'拒绝'},");
                            taskcard.append("{'key':'approve','name':'批准','color':'red','is_bold':true}]");
                            taskcard.append("}");
                            resmsg = agent1000002Bean.sendMsgToUser(user.getId(), null, null, "taskcard",
                                    taskcard.toString());
                            ret = true;
                        }
                    }
                    break;
                case "ACT13":
                case "ACT15":
                    pai = participantActivityInstanceBean.findByContextOIDAndDefinitionId(pi.getContextOID(), step);
                    if (pai != null) {
                        String userOID = workItemBean.getAssigneeOID(pai.getOID(), pi.getContextOID());
                        user = usersBean.findByOID(userOID);
                        if (user != null) {
                            StringBuilder content = new StringBuilder();
                            content.append("{");
                            content.append("'content':'")
                                    .append(String.format("[%s]设备报修<br/>%s设备<br/>发生%s故障<br/>请速派员处理",
                                            hspb015Bean.getCompanyName(entity.getFacno()), entity.getMachineCode(),
                                            entity.getFaultContent()))
                                    .append("'");
                            content.append("}");
                            resmsg
                                    = agent1000002Bean.sendMsgToUser(user.getId(), null, null, "text", content.toString());
                            ret = true;
                        }
                    }
                    break;
                case "ACT11":
                    resmsg = agent1000002Bean.sendMsgToUser(entity.getMaintenanceUser(), "text",
                            String.format("[%s]设备报修<br/>%s设备<br/>发生%s故障<br/>请速前往处理",
                                    hspb015Bean.getCompanyName(entity.getFacno()), entity.getMachineCode(),
                                    entity.getFaultContent()));
                    ret = true;
                    break;
                default:
            }
            log4j.info(resmsg);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "sendWeComMessageByOAHSPB015", psn), ex);
            ret = false;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMPORMYByOABXD")
    public String updateCRMPORMYByOABXD(@WebParam(name = "psn") String psn, @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            ret = hzcw028Bean.updateCRMPORMY(psn, status);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMPORMYByOABXD", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMPORMYByOAJZGHD")
    public String updateCRMPORMYByOAJZGHD(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hzcw033Bean.updateCRMPORMY(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMPORMYByOAJZGHD", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAHKYX011ByOAHKYX011")
    public String updateOAHKYX011ByOAHKYX011(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkyx011Bean.updateHKYX011(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKYX011ByOAHKYX011", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAHKYX014ByOAHKYX014")
    public String updateOAHKYX014ByOAHKYX014(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkyx014Bean.updateHKYX014(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKYX014ByOAHKYX014", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAHKGL031ByOAHKGL031")
    public String updateOAHKGL031ByOAHKGL031(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkgl031Bean.updateHKGL031(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKGL031ByOAHKGL031", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAHKJH005ByOAHKJH005")
    public String updateOAHKJH005ByOAHKJH005(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkjh005Bean.updateHKJH005(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKGL031ByOAHKGL031", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMPORMYByOAHZCW033")
    public String updateCRMPORMYByOAHZCW033(@WebParam(name = "psn") String psn,
            @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            ret = hzcw033Bean.updateCRMPORMY(psn, status);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMPORMYByOAHZCW033", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMREPMIByOAHKFW006")
    public String updateCRMREPMIByOAHKFW006(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkfw006Bean.updateREPMIByOAHKFW006(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPMIByOAHKFW006", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMREPTCByOASHBCRMREPI13")
    public String updateCRMREPTCByOASHBCRMREPI13(@WebParam(name = "psn") String psn) {
        String ret = "200";
        try {
            SHBCRMREPI13 h = shbcrmrepi13Bean.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException("未找到对应的OA实体");
            }
            String tc001 = h.getTc001();
            String tc002 = h.getTc002();
            REPTC tc = reptcBean.findByPK(tc001, tc002);
            if (tc != null) {
                tc.setTc082("".equals(h.getTc082()) ? "0" : h.getTc082());
                tc.setTc086("".equals(h.getTc086()) ? "0" : h.getTc086());
                int s = Integer.parseInt(h.getTc082()) + Integer.parseInt(h.getTc086());
                tc.setTc087(BigDecimal.valueOf(s));
                tc.setTc088(h.getTc088());
                reptcBean.update(tc);
            } else {
                throw new NullPointerException("未找到对应的CRM维修单");
            }

        } catch (Exception e) {
            return String.format("执行%s:参数%s时异常%s:", "updateCRMREPTCByOASHBCRMREPI13", psn, "******" + e.toString());
        }
        return ret;
    }

    @WebMethod(operationName = "updateCRMREPTCByOAHKFW005")
    public String updateCRMREPTCByOAHKFW005(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkfw005Bean.updateReptdByOAHKFW005(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPTCByOAHKFW005", psn), ex);
            return String.format("执行%s:参数%s时异常%s:", "updateCRMREPTCByOAHKFW005", psn, "******" + ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMREPTDByOAHKFW004Detail")
    public String updateCRMREPTDByOAHKFW004Detail(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkfw004DetailBean.updateReptdByOAHKFW004(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPTDByOAHKFW004Detail", psn), ex);
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

    @WebMethod(operationName = "updateCRMREPTDFromOAHKFW006")
    public String updateCRMREPTDFromOAHKFW006(@WebParam(name = "psn") String psn,
            @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            ret = hkfw006Bean.updateReptdByOAHKFW006(psn, status);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPTDByOAHKFW006", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMSERBQByOASERI12")
    public String updateCRMSERBQByOASERI12(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = seri12Bean.updateSerbq(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMSERBQByOASERI12", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMSERBQFromOASERI12")
    public String updateCRMSERBQFromOASERI12(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = seri12Bean.updateSERBQ(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMSERBQFromOASERI12", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateCRMWARTBByOAWARMI05")
    public String updateCRMWARTBByOAWARMI05(@WebParam(name = "psn") String psn, @WebParam(name = "step") String step) {
        Boolean ret = false;
        try {
            ret = warmi05Bean.updateWARTB(psn, step);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMWARTBByOAWARMI05", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateEAMAssetCardByOAHZCW034")
    public String updateEAMAssetCardByOAHZCW034(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HZCW034 e;
        List<HZCW034Detail> detailList;
        try {
            e = hzcw034Bean.findByPSN(psn);
            if (e == null) {
                throw new NullPointerException(psn + "不存在");
            } else if (e.getSourceno() != null && !"".equals(e.getSourceno())) {
                return "200";
            }
            hzcw034Bean.setDetail(e.getFormSerialNumber());
            detailList = hzcw034Bean.getDetailList();
            if (detailList == null || detailList.isEmpty()) {
                throw new NullPointerException(psn + "没有明细资料");
            }
            AssetCard ac;
            AssetItem ai;
            List<AssetCard> editedAssetCard = new ArrayList<>();
            int i = 0;
            for (HZCW034Detail d : detailList) {
                ac = assetCardBean.findByAssetno(d.getAssetno());
                ai = assetItemBean.findByItemno(d.getItnbr());
                if (ac == null) {
                    throw new RuntimeException(d.getAssetno() + "EAM中不存在");
                } else if (ac.getScrap()) {
                    throw new RuntimeException(d.getAssetno() + "EAM中已报废");
                }
                if (ai == null) {
                    throw new RuntimeException(d.getItnbr() + "EAM中不存在");
                }
                ac.setPause(true);
                editedAssetCard.add(ac);
            }
            assetCardBean.update(editedAssetCard);
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateEAMAssetCardByOAHZCW034", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateEAPDemandsByOAHKXQB001")
    public String updateEAPDemandsByOAHKXQB001(@WebParam(name = "psn") String psn,
            @WebParam(name = "status") String status) {
        Boolean ret = false;
        HKXQB001 b = hkxqb001Bean.findByPSN(psn);
        if (b == null) {
            throw new NullPointerException();
        }
        try {
            String SerialNumber = b.getSerialNumber();// OA表单单号
            /*找到Demands中的这条数据*/
            Demands d = demandsBean.findByOID(SerialNumber);
            if (d == null) {
                throw new NullPointerException();
            }
            if ("Y".equals(status)) {
                /*如果是已完成状态 就不需要再更新数据*/
                if (!"Y".equals(d.getStatus())) {
                    String user2 = b.getUser2().trim();// 负责人
                    Date time2 = b.getTime2();// 计划开始
                    Date time3 = b.getTime3();// 计划完成
                    Date time4 = b.getTime4();// 实际开始
                    Date time5 = b.getTime5();// 实际完成
                    SystemUser s;
                    if (user2 != null && !"".equals(user2)) {
                        /*负责人*/
                        s = systemUserBean.findByUserId(user2);
                        if (s != null) {
                            d.setDirectorID(user2);
                            d.setDirectorName(s.getUsername());
                        }
                    }
                    if (time2 != null) {
                        d.setPlanStartDate(time2);
                    }
                    if (time2 != null) {
                        d.setPlanOverDate(time3);
                    }
                    if (time2 != null) {
                        d.setRealStartDate(time4);
                    }
                    if (time2 != null) {
                        d.setRealOverDate(time5);
                    }
                    d.setStatus("Y");
                    demandsBean.update(d);
                } else {
                    d.setStatus(status);
                    demandsBean.update(d);
                }
            } else {
                d.setStatus(status);
                demandsBean.update(d);
            }
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateEAPDemandsByOAHKXQB001", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPCDR220ByOAHKYX009")
    public String updateERPCDR220ByOAHKYX009(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = cdrqhadBean.updateByOAHKYX009(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateERPCDR220ByOAHKYX009", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPCDRN20ByOAHKJH005")
    public String updateERPCDRN20ByOAHKJH005(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = cdrlndtaBean.updateByOAHKJH005(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateERPCDRN20ByOAHKJH005", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPCDR1P3ByOASHBERPCDR1P3")
    public String updateERPCDR1P3ByOASHBERPCDR1P3(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = pricingGroupBean.updateByOASHBERPCDR1P3(psn);
        } catch (Exception ex) {
            log4j.error("createPUR210ByOAQGD时异常", ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPINV140ByOAHKCW003")
    public String updateERPINV140ByOAHKCW003(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = invmasBean.updateByOAHKCW003(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateERPINV140ByOAHKCW003", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPPUR120ByOAHKCG006") // by C1749 2018/3/28
    public String updateERPPUR120ByOAHKCG006(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = purvdrBean.refuseByOAHKCG006(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateERPPUR120ByOAHKCG006", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPCDRByOAHKYX013") // by C1749 2020/7/23
    public String updateERPCDRByOAHKYX013(@WebParam(name = "psn") String psn) {
        Boolean ret1 = false;
        Boolean ret2 = false;
        Boolean ret3 = false;
        try {
            ret1 = cdrhadBean.updateByOAHKYX013(psn);
            ret2 = cdrhmasBean.updateByOAHKYX013(psn);
            ret3 = cdrbhadBean.updateByOAHKYX013(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateByOAHKYX013", psn), ex);
        }
        if (ret1 && ret2 && ret3) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateMESHKFW006ByOAHKFW006")
    public String updateMESHKFW006ByOAHKFW006(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkfw006Bean.updateCRMHKFW006ByOAFW006(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateCRMREPMIByOAHKFW006", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAHKGC001ByOAHKGC003")
    public String updateOAHKGC001ByOAHKGC003(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkgc003Bean.updateHKGC001(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKGC001ByOAHKGC003", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAHKGL037ByOAHKGL038")
    public String updateOAHKGL037ByOAHKGL038(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkgl038Bean.updateHKGL037(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKGL037ByOAHKGL038", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAHKJH001ByOAHKJH001")
    public String updateOAHKJH001ByOAHKJH001(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkjh001Bean.updateHKJH001(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKJH001ByOAHKJH001", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAHKJH006ByOAHKJH006")
    public String updateOAHKJH006ByOAHKJH006(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = hkjh006Bean.updateHKJH006(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAHKJH006ByOAHKJH006", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAProcessInstanceByOAWARMI05")
    public String updateOAProcessInstanceByOAWARMI05(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = warmi05Bean.updateSubject(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAProcessInstanceByOAWARMI05", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateOAVHTV001ByOAVHTV002")
    public String updateOAVHTV001ByOAVHTV002(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = vhtv002Bean.updatevhtv002(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateOAVHTV001ByOAVHTV002", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateRootCloudDeviceAlarmStatus")
    public String updateRootCloudDeviceAlarmStatus(@WebParam(name = "psn") String psn,
            @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            SERI12 e = seri12Bean.findByPSN(psn);
            if (e == null) {
                throw new NullPointerException("updateRootCloudDeviceAlarmStatus找不到流程序号:" + psn);
            }
            List<SERI12grid2SERI12> devices = seri12Bean.getDeviceList(e.getFormSerialNumber());
            if (devices == null || devices.isEmpty()) {
                throw new NullPointerException("updateRootCloudDeviceAlarmStatus找不到设备信息:" + psn);
            }
            SERI12grid2SERI12 d = devices.get(0);// 云端产生的客诉只有一台设备
            String response = "";// rootCloudBean.updateAlarmStatus(d.getCa009(), e.getBq508(), status);
            if (response == null || "".equals(response)) {
                ret = false;
            } else {
                ret = true;
            }
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateRootCloudDeviceAlarmStatus", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    /**
     * 根据OA办公用品申请表审核EAM对应领用单
     *
     * @param psn
     * @return
     */
    @WebMethod(operationName = "verifyEAMOS310ByOAHKGL060")
    public String verifyEAMOS310ByOAHKGL060(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        HKGL060 e;
        AssetDistribute ad;
        try {
            e = hkgl060Bean.findByPSN(psn);
            if (e == null || e.getRelformid() == null || "".equals(e.getRelformid())) {
                throw new NullPointerException(psn + "不存在");
            }
            ad = stationeryDistributeBean.findByFormId(e.getRelformid());
            if (ad == null) {
                throw new NullPointerException(e.getRelformid() + "不存在");
            }
            ad.setStatus("T");
            ad.setCfmuserToSystem();
            ad.setCfmdateToNow();
            stationeryDistributeBean.verify(ad);
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "verifyEAMStationeryDistributeByOAHKGL060", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateEVendorEvaluateByOAHKCG011")
    public String updateEVendorEvaluateByOAHKCG011(@WebParam(name = "psn") String psn,
            @WebParam(name = "URL") String url) {
        Boolean ret = false;
        try {
            HKCG011 p = hkcg011Bean.findByPSN(psn);
            if (p == null) {
                throw new NullPointerException("updateEVendorEvaluateByOAHKCG011找不到流程序号:" + psn);
            }
            // status: 1代表撤销/终止 ，3代表完成
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Code", "200");
            jsonObject.put("Message", "OA审核完成");
            jsonObject.put("Data", psn);
            String response = ecpurvdrBean.ECPostBack(url, jsonObject);
            ret = !(response == null || "".equals(response));
        } catch (NullPointerException | JSONException ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateEVendorEvaluateByOAHKCG011", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateECNGByOAHKCG019")
    public String updateECNGByOAHKCG019(@WebParam(name = "psn") String psn, @WebParam(name = "status") String status) {
        // 加入请求日志起
        log4j.info(String.format("拟购申请单发起webservice,状态:%s,psn:%s", status, psn));
        Boolean ret = false;
        try {
            HKCG019 p = hkcg019Bean.findByPSN(psn);
            if (p == null) {
                throw new NullPointerException("updateECNGByOAHKCG019找不到流程序号:" + psn);
            }
            // status: 1代表撤销/终止 ，3代表完成
            // String url = "http://172.16.80.104:8090/api/EFBK/EFSup";
            String url = p.getBackUrl();
            String tag = p.getTag();
            JSONObject jsonObject = new JSONObject();
            if ("1".equals(status)) {
                // 加入撤销或终止人员、意见 ,"|"
                String execComment = "";
                List<WorkItem> wiList = processInstanceBean.getWorkItemListBySerialNumber(psn);
                if (!wiList.isEmpty()) {
                    for (WorkItem wi : wiList) {
                        if (5 == wi.getCurrentState() || 4 == wi.getCurrentState()) {
                            Users u;
                            if (null == wi.getPerformerOID()) {
                                // 修正取回重办后撤销，人员取流程发起人
                                u = usersBean.findByOID(processInstanceBean.findBySerialNumber(psn).getRequesterOID());
                            } else {
                                u = usersBean.findByOID(wi.getPerformerOID());
                            }
                            execComment = execComment + u.getId() + "|" + wi.getExecutiveComment();
                        }
                    }
                }
                jsonObject.put("Code", "101");
                jsonObject.put("Message", execComment);
                jsonObject.put("Tag", tag);
            } else if ("3".equals(status)) {
                jsonObject.put("Code", "200");
                jsonObject.put("Message", "success");
                jsonObject.put("Tag", tag);
            }
            jsonObject.put("Data", psn);
            log4j.info(String.format("拟购申请单发起请求电采接口,状态:%s,jsonObject:%s", status, jsonObject));
            String response = ecpurvdrBean.ECPostBack(url, jsonObject);
            ret = !(response == null || "".equals(response));
        } catch (NullPointerException | JSONException ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateECNGByOAHKCG019", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateEProcurementByOAHKCG016")
    public String updateEProcurementByOAHKCG016(@WebParam(name = "psn") String psn,
            @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            HKCG016 p = hkcg016Bean.findByPSN(psn);
            if (p == null) {
                throw new NullPointerException("updateEProcurementByOAHKCG016找不到流程序号:" + psn);
            }
            // status: 1代表撤销/终止 ，3代表完成
            // String url = "http://172.16.80.104:8090/api/EFBK/EFSup";
            String url = p.getBackUrl();
            String tag = p.getTag();
            JSONObject jsonObject = new JSONObject();
            if ("1".equals(status)) {
                jsonObject.put("Code", "101");
                jsonObject.put("Message", "OA审核不通过");
                jsonObject.put("Tag", tag);
                jsonObject.put("Data", "NULL");
            } else if ("3".equals(status)) {
                jsonObject.put("Code", "200");
                jsonObject.put("Message", "ERP同步完成");
                jsonObject.put("Tag", tag);
                JSONArray jsonarr = new JSONArray();
                JSONObject data1 = new JSONObject();
                data1.put("Facno", p.getFacno());
                data1.put("Vdrno", p.getVdrno());
                jsonarr.put(0, data1);
                if ("G".equals(p.getFacno()) || "N".equals(p.getFacno()) || "J".equals(p.getFacno())
                        || "C4".equals(p.getFacno())) {
                    JSONObject data2 = new JSONObject();
                    data2.put("Facno", "C");
                    data2.put("Vdrno", p.getVdrno());
                    jsonarr.put(1, data2);
                }
                jsonObject.put("Data", jsonarr);
            }
            String response = ecpurvdrBean.ECPostBack(url, jsonObject);
            ret = !(response == null || "".equals(response));
        } catch (NullPointerException | JSONException ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateEProcurementByOAHKCG016", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateEProcurementByOAHKCG020")
    public String updateEProcurementByOAHKCG020(@WebParam(name = "psn") String psn,
            @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            HKCG020 p = hkcg020Bean.findByPSN(psn);
            if (p == null) {
                throw new NullPointerException("updateEProcurementByOAHKCG020找不到流程序号:" + psn);
            }
            // status: 1代表撤销/终止 ，3代表完成
            String url = p.getExt01();
            String tag = p.getExt02();
            JSONObject jsonObject = new JSONObject();
            if ("1".equals(status)) {
                jsonObject.put("Code", "101");
                jsonObject.put("Message", "OA审核不通过");
                jsonObject.put("Tag", tag);
                jsonObject.put("Data", "NULL");
            } else if ("3".equals(status)) {
                jsonObject.put("Code", "200");
                jsonObject.put("Message", "OA审核完成");
                jsonObject.put("Tag", tag);
                JSONArray jsonarr = new JSONArray();
                JSONObject data1 = new JSONObject();
                data1.put("Facno", p.getFacno());
                data1.put("Vdrno", p.getVdrno());
                jsonarr.put(0, data1);
                if ("G".equals(p.getFacno()) || "N".equals(p.getFacno()) || "J".equals(p.getFacno())
                        || "C4".equals(p.getFacno())) {
                    JSONObject data2 = new JSONObject();
                    data2.put("Facno", "C");
                    data2.put("Vdrno", p.getVdrno());
                    jsonarr.put(1, data2);
                }
                jsonObject.put("Data", jsonarr);
            }
            String response = ecpurvdrBean.ECPostBack(url, jsonObject);
            ret = !(response == null || "".equals(response));
        } catch (NullPointerException | JSONException ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateEProcurementByOAHKCG020", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPAPM585ByOAHKCW015")
    public String updateERPAPM585ByOAHKCW015(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            HKCW015 h = hkcw015Bean.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException("updateERPAPM585ByOAHKCW015找不到流程序号:" + psn);
            }
            String facno = h.getFacno();
            String fsn = h.getFormSerialNumber();
            if (null == facno || "".equals(facno)) {
                throw new NullPointerException("updateERPAPM585ByOAHKCW015付款凭单未设置正确的公司别" + facno);
            }
            apmanp585hBean.setCompany(facno);
            Apmanp585h apm = apmanp585hBean.findByOAPSN(fsn);
            if (apm == null) {
                throw new NullPointerException("updateERPAPM585ByOAHKCW015找不到ERP单据");
            }
            apm.setExtcnt((short) 2);
            apmanp585hBean.update(apm);
            ret = true;
        } catch (NullPointerException | JSONException ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateERPAPM585ByOAHKCW015", psn), ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "updateERPAPM540ByOAHKCW018")
    public String updateERPAPM540ByOAHKCW018(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        try {
            ret = apmchpBean.updateByOAHKCW018(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "updateByOAHKCW018", psn), ex);
            throw ex;
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "createCustomerComplaintByEAP")
    public String createCustomerComplaintByEAP(@WebParam(name = "psn") String psn) {
        Boolean ret = false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal travel = BigDecimal.ZERO;
        BigDecimal tansport = BigDecimal.ZERO;
        BigDecimal material = BigDecimal.ZERO;
        // 差旅
        List<CustomerComplaintExpense> travelList;
        // 运费
        List<CustomerComplaintExpense> tansportList;
        // 材料
        List<CustomerComplaintMaterial> materialList;
        try {
            SERI12 seri12 = seri12Bean.findByPSNAndBQ110(psn);
            if (seri12 != null) {
                if (seri12.getBq001() == null && "".equals(seri12.getBq001())) {
                    throw new NullPointerException("createCustomerComplaintByEAP--seri12.getBq001()为空");
                }
                String badwhy, dutydeptno, remark1;
                String kfno = seri12.getBq001();
                CustomerComplaint cp = new CustomerComplaint();
                String varnr = sercaBean.findCa009ByCa001(kfno);
                cp.setKfno(seri12.getBq001());
                cp.setCusno(seri12.getBq002() == null ? "null" : seri12.getBq002());
                cp.setCusna(seri12.getBq002c() == null ? "null" : seri12.getBq002c());
                cp.setVarnr(varnr == null ? "null" : varnr);
                cp.setNcodeDC(seri12.getBq197() == null ? "null" : seri12.getBq197());
                cp.setNcodeCD(seri12.getBq198() == null ? "null" : seri12.getBq198());
                cp.setNcodeDD(seri12.getBq003() == null ? "null" : seri12.getBq003());
                dutydeptno = seri12.getBq504() == null ? "null" : seri12.getBq504();
                // 因OA版更栏位发生改变
                if (!dutydeptno.equals("null") && !dutydeptno.equals("")) {
                    cp.setDutydeptno(dutydeptno);
                } else {
                    cp.setDutydeptno(seri12.getBq133() == null ? "null" : seri12.getBq133());
                }
                cp.setDutydeptna(seri12.getBq504c() == null ? "null" : seri12.getBq504c());
                // 19年9月10日加入责任判定
                remark1 = seri12.getBq502() == null ? "" : seri12.getBq502();
                if (!remark1.equals("")) {
                    cp.setRemark1(remark1);
                } else {
                    cp.setRemark1(seri12.getBq131() == null ? "null" : seri12.getBq131());
                }
                // 0值改为空白
                cp.setDutyrate(seri12.getPropotion() == null ? ""
                        : seri12.getPropotion().trim().equals("0") ? "" : seri12.getPropotion());
                cp.setCredate(BaseLib.getDate("yyyy/MM/dd", seri12.getBq021()));
                cp.setOverdate(BaseLib.getDate("yyyy/MM/dd", seri12.getBq037()));
                badwhy = seri12.getBq503() == null ? "null" : seri12.getBq503();
                // 因OA版更栏位发生改变
                if (!badwhy.equals("null") && !badwhy.equals("")) {
                    cp.setBadwhy(badwhy);
                } else {
                    cp.setBadwhy(seri12.getBq132() == null ? "null" : seri12.getBq132());
                }
                // 一、运输费
                tansportList = new ArrayList<>();
                CustomerComplaintExpense cce;
                List hkfw005s = hkfw005Bean.getTansportExpense(kfno);
                if (hkfw005s != null && !hkfw005s.isEmpty()) {
                    for (int i = 0; i < hkfw005s.size(); i++) {
                        Object[] row = (Object[]) hkfw005s.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(hkfw005Bean.getYsStyleName(row[10].toString()));
                        cce.setCustom2(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setCustom4(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesno(row[16] == null ? "null" : row[16].toString());
                        tansportList.add(cce);
                    }
                }
                List hkfw006s = hkfw006Bean.getTansportExpense(kfno);
                if (hkfw006s != null && !hkfw006s.isEmpty()) {
                    for (int i = 0; i < hkfw006s.size(); i++) {
                        Object[] row = (Object[]) hkfw006s.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(row[10] == null ? "null" : row[10].toString());
                        cce.setCustom2(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setCustom4(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesno(row[16] == null ? "null" : row[16].toString());
                        tansportList.add(cce);
                    }
                }
                List cdrlnhads = cdrlnhadBean.getCustomerComplaintExpense(kfno);
                if (cdrlnhads != null && !cdrlnhads.isEmpty()) {
                    for (int i = 0; i < cdrlnhads.size(); i++) {
                        Object[] row = (Object[]) cdrlnhads.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(row[10] == null ? "null" : row[10].toString());
                        cce.setCustom2(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setSourcesno(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        tansportList.add(cce);
                    }
                }
                // 二、差旅费
                travelList = new ArrayList<>();
                List repts = reptcBean.getCustomerComplaintExpense(kfno);
                if (repts != null && !repts.isEmpty()) {
                    for (int i = 0; i < repts.size(); i++) {
                        Object[] row = (Object[]) repts.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setSerialno(row[8] == null ? "null" : row[8].toString());
                        cce.setOccurdate(row[9] == null ? "null" : row[9].toString());
                        cce.setExpensetype(row[10] == null ? "null" : row[10].toString());
                        cce.setCustom1(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom2(row[12] == null ? "null" : row[12].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[13].toString())));
                        cce.setRemark1(row[14] == null ? "null" : row[14].toString());
                        cce.setSourcesno(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesdate(row[16] == null ? "null" : row[16].toString());
                        travelList.add(cce);
                    }
                }
                // 三、材料费
                materialList = new ArrayList<>();
                CustomerComplaintMaterial cpd;
                List invhadhs = invhadBean.getCustomerComplaintMaterial(kfno);
                if (invhadhs != null && !invhadhs.isEmpty()) {
                    for (int i = 0; i < invhadhs.size(); i++) {
                        Object[] row = (Object[]) invhadhs.get(i);
                        cpd = new CustomerComplaintMaterial();
                        cpd.setKfno(row[0].toString());
                        cpd.setFwno(row[1] == null ? "null" : row[1].toString());
                        cpd.setTrtype(row[2] == null ? "null" : row[2].toString());
                        cpd.setTypedsc(row[3] == null ? "null" : row[3].toString());
                        cpd.setTrno(row[4] == null ? "null" : row[4].toString());
                        cpd.setTrdate(df.parse(row[5].toString()));
                        cpd.setTrseq(row[6] == null ? 0 : Integer.parseInt(row[6].toString()));
                        cpd.setItnbr(row[7] == null ? "null" : row[7].toString());
                        cpd.setItdsc(row[8] == null ? "null" : row[8].toString());
                        cpd.setTrnqy1(row[9] == null ? BigDecimal.ZERO
                                : BigDecimal.valueOf(Double.parseDouble(row[9].toString())));
                        cpd.setUnmsr1(row[10] == null ? "null" : row[10].toString());
                        cpd.setTramt(row[11] == null ? BigDecimal.ZERO
                                : BigDecimal.valueOf(Double.parseDouble(row[11].toString())));
                        materialList.add(cpd);
                    }
                }
                // 资料更新
                List<CustomerComplaintExpense> expenses = complaintExpenseBean.findKfno(kfno);
                if (expenses != null && !expenses.isEmpty()) {
                    complaintExpenseBean.delete(expenses);
                }
                List<CustomerComplaintMaterial> materials = complaintMaterialBean.findKfno(kfno);
                if (materials != null && !materials.isEmpty()) {
                    complaintMaterialBean.delete(materials);
                }
                if (!travelList.isEmpty()) {
                    for (CustomerComplaintExpense complaintExpense : travelList) {
                        travel = travel.add(complaintExpense.getExpense());
                        complaintExpenseBean.persist(complaintExpense);
                    }
                }
                if (!tansportList.isEmpty()) {
                    for (CustomerComplaintExpense complaintExpense : tansportList) {
                        tansport = tansport.add(complaintExpense.getExpense());
                        complaintExpenseBean.persist(complaintExpense);
                    }
                }
                if (!materialList.isEmpty()) {
                    for (CustomerComplaintMaterial complaintMaterial : materialList) {
                        // IAF为服务领料 领料加项 IAG为服务退料 退料减项
                        if (complaintMaterial.getTrtype().equals("IAF")) {
                            material = material.add(complaintMaterial.getTramt());
                        } else {
                            material = material.subtract(complaintMaterial.getTramt());
                        }
                        complaintMaterialBean.persist(complaintMaterial);
                    }
                }
                CustomerComplaint plaint = customerComplaintBean.findKfno(kfno);
                if (plaint != null) {
                    customerComplaintBean.delete(plaint);
                }
                cp.setMaterialcost(material);
                cp.setTravelexpense(travel);
                cp.setTansportexpense(tansport);
                customerComplaintBean.persist(cp);
                List<String> emailTo
                        = mailSettingBean.findRecipientTo("cn.hanbell.jws.EAPWebService.createCustomerComplaintByEAP");
                List<String> emailCc
                        = mailSettingBean.findRecipientCc("cn.hanbell.jws.EAPWebService.createCustomerComplaintByEAP");
                List<String> emailBcc
                        = mailSettingBean.findRecipientBcc("cn.hanbell.jws.EAPWebService.createCustomerComplaintByEAP");
                mailBean.clearReceivers();
                mailBean.getAttachments().clear();
                if (emailTo != null && !emailTo.isEmpty()) {
                    mailBean.getTo().addAll(emailTo);
                }
                if (emailCc != null && !emailCc.isEmpty()) {
                    mailBean.getCc().addAll(emailCc);
                }
                if (emailBcc != null && !emailBcc.isEmpty()) {
                    mailBean.getBcc().addAll(emailBcc);
                }
                mailBean.setMailSubject("客诉结案抛转详细");
                mailBean.setMailContent(customerComplaintBean.getMail("客诉结案抛转详细", kfno));
                mailBean.notify(new MailNotify());
                ret = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log4j.error(String.format("执行%s:参数%s时异常", "createCustomerComplaintByEAP", psn), ex);
               List<String> emailTo
                        = mailSettingBean.findRecipientTo("cn.hanbell.jws.EAPWebService.createCustomerComplaintByEAP");
                List<String> emailCc
                        = mailSettingBean.findRecipientCc("cn.hanbell.jws.EAPWebService.createCustomerComplaintByEAP");
                List<String> emailBcc
                        = mailSettingBean.findRecipientBcc("cn.hanbell.jws.EAPWebService.createCustomerComplaintByEAP");
                      if (emailTo != null && !emailTo.isEmpty()) {
                    mailBean.getTo().addAll(emailTo);
                }
                if (emailCc != null && !emailCc.isEmpty()) {
                    mailBean.getCc().addAll(emailCc);
                }
                if (emailBcc != null && !emailBcc.isEmpty()) {
                    mailBean.getBcc().addAll(emailBcc);
                }
            mailBean.setMailSubject("客诉结案抛转详细失败");
            mailBean.setMailContent("流程号：" + psn + "————————异常" + ex.toString());
            mailBean.notify(new MailNotify());
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }
    }

    @WebMethod(operationName = "sendOAHKGL034CancelMsgByPSN")
    public String sendOAHKGL034CancelMsgByPSN(@WebParam(name = "psn") String psn) {
        HKGL034 hkgl034 = hkgl034Bean.findByPSN(psn);
        List<HKGL034Detail> details = hkgl034DetailBean.findByFSN(hkgl034.getFormSerialNumber());
        agent1000002Bean.initConfiguration();
        boolean isSuccess = true;
        for (HKGL034Detail detail : details) {
            String errmsg = agent1000002Bean.sendMsgToUser(detail.getEmployee(), "text",
                    "[汉钟精机] 您申请的" + detail.getDate1Txt() + "加班单已完成签核");
            if (!"ok".equals(errmsg)) {
                isSuccess = false;
            }
        }
        if (isSuccess) {
            return "200";
        } else {
            return "400";
        }
    }

    @WebMethod(operationName = "sendOAHKGL004CancelMsgByPSN")
    public String sendOAHKGL004CancelMsgByPSN(@WebParam(name = "psn") String psn) {
        HKGL004 hkgl034 = hkgl004Bean.findByPSN(psn);
        agent1000002Bean.initConfiguration();
        String errmsg = agent1000002Bean.sendMsgToUser(hkgl034.getEmployee(), "text",
                "[汉钟精机] 您申请的" + BaseLib.formatDate("yyyy-MM-dd", hkgl034.getDate1()) + "请假单已完成签核");
        if ("ok".equals(errmsg)) {
            return "200";
        } else {
            return "400";
        }
    }

    @WebMethod(operationName = "sendOAHZGL004CancelMsgByPSN")
    public String sendOAHZGL004CancelMsgByPSN(@WebParam(name = "psn") String psn) {
        HZGL004 hzgl004 = hzgl004Bean.findByPSN(psn);
        List<HZGL004BizDetail> details = hzgl004BizBean.findByFSN(hzgl004.getFormSerialNumber());
        agent1000002Bean.initConfiguration();
        boolean isSuccess = true;
        for (HZGL004BizDetail detail : details) {
            String errmsg = agent1000002Bean.sendMsgToUser(detail.getBizEmployeetxt(), "text",
                    "[汉钟精机] 您申请的" + detail.getBizDatetxt() + "出差单已完成签核");
            if (!"ok".equals(errmsg)) {
                isSuccess = false;
            }
        }
        if (isSuccess) {
            return "200";
        } else {
            return "400";
        }
    }

    @WebMethod(operationName = "updateKPISCORECARDAUDITORByHKGL076")
    public String updateKPISCORECARDAUDITORByHKGL076(@WebParam(name = "psn") String psn, @WebParam(name = "status") String status) {
        Boolean ret = false;
        try {
            HKGL076 hkgl076 = hkgl076Bean.findByPSN(psn);
            if (hkgl076 == null) {
                throw new NullPointerException("updateECNGByOAHKCG019找不到流程序号:" + psn);
            }
            //删除所有审核人员直接返回
            int quarter = Integer.valueOf(hkgl076.getAssessmentQuarter().substring(1));
            List<ScorecardAuditor> deleteList = scorecardAuditorBean.findByPId(Integer.valueOf(hkgl076.getScoreCord()));
            for (ScorecardAuditor entity : deleteList) {
                if (entity.getQuarter() == quarter) {
                    scorecardAuditorBean.delete(entity);
                }
            }
            //流程撤销或终止，删除所有审核人员后直接返回！
            if ("1".equals(status)) {
                Scorecard sc = scorecarBean.findById(Integer.valueOf(hkgl076.getScoreCord()));
                if (quarter == 1) {
                    sc.setOastatus1("V");
                    sc.setOapsn1("");
                } else if (quarter == 2) {
                    sc.setOastatus2("V");
                    sc.setOapsn2("");
                } else if (quarter == 3) {
                    sc.setOastatus3("V");
                    sc.setOapsn3("");
                } else if (quarter == 4) {
                    sc.setOastatus4("V");
                    sc.setOapsn4("");
                }
                scorecarBean.update(sc);
                return "200";
            } else {
                //先更新数据
                switch (quarter) {
                    case 1://第一季度
                        List<HKGL076DetailQ1> q1List = hkgl076Bean.getQ1Detail(hkgl076.getFormSerialNumber());
                        for (HKGL076DetailQ1 q1entity : q1List) {
                            ScorecardDetail sc = scorecardDetailBean.findByPidAndContent(Integer.valueOf(hkgl076.getScoreCord()), q1entity.getContent1());
                            System.out.println(q1entity.getContent1());
                            sc.setAq1(scorecardDetailBean.formatEAPEnt(q1entity.getActualValueQ1()));
                            sc.setPq1(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q1entity.getAchievementRateQ1()))));
                            sc.getDeptScore().setQ1(scorecardDetailBean.formatEAPEnt(q1entity.getExplanation1()));
                            sc.getDeptScore().setSq1(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q1entity.getScoreQ1()))));
                            scorecardDetailBean.update(sc);
                        }
                        break;
                    case 2://第二季度
                        List<HKGL076DetailQ2> q2List = hkgl076Bean.getQ2Detail(hkgl076.getFormSerialNumber());
                        for (HKGL076DetailQ2 q2entity : q2List) {
                            ScorecardDetail sc = scorecardDetailBean.findByPidAndContent(Integer.valueOf(hkgl076.getScoreCord()), q2entity.getContent2());
                            sc.setAq2(scorecardDetailBean.formatEAPEnt(q2entity.getActualValueQ2()));
                            sc.setPq2(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q2entity.getAchievementRateQ2()))));
                            sc.getDeptScore().setQ2(scorecardDetailBean.formatEAPEnt(q2entity.getExplanation2()));
                            sc.getDeptScore().setSq2(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q2entity.getScoreQ2()))));
                            sc.setAh1(scorecardDetailBean.formatEAPEnt(q2entity.getActualValueHalfYear()));
                            sc.setPh1(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q2entity.getAchievementRateHalfYear()))));
                            sc.getDeptScore().setSh1(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q2entity.getScoreHalfYear()))));
                            scorecardDetailBean.update(sc);
                        }
                        break;
                    case 3://第三季度
                        List<HKGL076DetailQ3> q3List = hkgl076Bean.getQ3Detail(hkgl076.getFormSerialNumber());
                        for (HKGL076DetailQ3 q3entity : q3List) {
                            ScorecardDetail sc = scorecardDetailBean.findByPidAndContent(Integer.valueOf(hkgl076.getScoreCord()), q3entity.getContent3());
                            sc.setAq3(scorecardDetailBean.formatEAPEnt(q3entity.getActualValueQ3()));
                            sc.setPq3(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q3entity.getAchievementRateQ3()))));
                            sc.getDeptScore().setQ3(scorecardDetailBean.formatEAPEnt(q3entity.getExplanation3()));
                            sc.getDeptScore().setSq3(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q3entity.getScoreQ3()))));
                            scorecardDetailBean.update(sc);
                        }
                        break;
                    case 4://第四季度
                        List<HKGL076DetailQ4> q4List = hkgl076Bean.getQ4Detail(hkgl076.getFormSerialNumber());
                        for (HKGL076DetailQ4 q4entity : q4List) {
                            ScorecardDetail sc = scorecardDetailBean.findByPidAndContent(Integer.valueOf(hkgl076.getScoreCord()), q4entity.getContent4());
                            sc.setAq4(scorecardDetailBean.formatEAPEnt(q4entity.getActualValueQ4()));
                            sc.setPq4(q4entity.getAchievementRateQ4() == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q4entity.getAchievementRateQ4()))));
                            sc.getDeptScore().setQ4(scorecardDetailBean.formatEAPEnt(q4entity.getExplanation4()));
                            sc.getDeptScore().setSq4(q4entity.getScoreQ4() == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q4entity.getScoreQ4()))));
                            sc.setAfy(scorecardDetailBean.formatEAPEnt(q4entity.getActualValueYear()));
                            sc.setPfy(q4entity.getAchievementRateYear() == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q4entity.getAchievementRateYear()))));
                            sc.getDeptScore().setSfy(BigDecimal.valueOf(Double.valueOf(scorecardDetailBean.formatEAPEnt(q4entity.getScoreYear()))));

                            scorecardDetailBean.update(sc);
                        }
                        break;
                }
                //流程关卡更具时间排序
                List<WorkItem> wiList = processInstanceBean.getWorkItemListBySerialNumber(psn);
                wiList.sort((WorkItem o1, WorkItem o2) -> {
                    if (o1.getCreatedTime().compareTo(o2.getCreatedTime()) < 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                });
                //更新关卡人员
                List<ScorecardAuditor> list = new ArrayList<>();
                for (WorkItem entity : wiList) {
                    if (!"申请人".equals(entity.getWorkItemName())) {
                        Users user = usersBean.findByOID(entity.getPerformerOID());
                        if (user != null) {
                            ScorecardAuditor sc1 = new ScorecardAuditor();
                            sc1.setPid(Integer.valueOf(hkgl076.getScoreCord()));
                            sc1.setAuditorId(user.getId());
                            sc1.setAuditorName(user.getUserName());
                            sc1.setSeq(Integer.valueOf(hkgl076.getAssessmentYear()));
                            sc1.setQuarter(quarter);
                            sc1.setCredate(entity.getCompletedTime());
                            sc1.setCreator(sc1.getAuditorId());
                            scorecardAuditorBean.persist(sc1);
                        }
                    }
                }
                Scorecard sc = scorecarBean.findById(Integer.valueOf(hkgl076.getScoreCord()));
                if (quarter == 1) {
                    sc.setOastatus1("V");
                } else if (quarter == 2) {
                    sc.setOastatus2("V");
                } else if (quarter == 3) {
                    sc.setOastatus3("V");
                } else if (quarter == 4) {
                    sc.setOastatus4("V");
                }
                scorecarBean.update(sc);
                return "200";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "404";
        }
    }
}
