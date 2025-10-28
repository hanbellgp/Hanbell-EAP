package cn.hanbell.crm.jrs;

import cn.hanbell.crm.app.SERBQApplication;
import cn.hanbell.crm.app.SERBQDETAILLApplication;
import cn.hanbell.crm.ejb.CMSMGBean;
import cn.hanbell.crm.ejb.CRMGDBean;
import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.ejb.REPMQBean;
import cn.hanbell.crm.ejb.REPTABean;
import cn.hanbell.crm.ejb.SERBFBean;
import cn.hanbell.crm.ejb.SERBQBean;
import cn.hanbell.crm.ejb.SERCABean;
import cn.hanbell.crm.ejb.SYSNNBean;
import cn.hanbell.crm.entity.CMSMG;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.REPTA;
import cn.hanbell.crm.entity.REPTAPK;
import cn.hanbell.crm.entity.SERBF;
import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.crm.entity.SERCA;
import cn.hanbell.crm.entity.SERCAPK;
import cn.hanbell.crm.entity.SYSNN;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author C2082
 */
@Path("crm/serbq")
@javax.enterprise.context.RequestScoped
public class SERBQFacadeREST extends SuperRESTForCRM<SERBQ> {

    @EJB
    private SERBQBean serbqBean;
    @EJB
    private SERBFBean serbfBean;
    @EJB
    private REPTABean reptaBean;

    @EJB
    private CRMGGBean crmggBean;
    @EJB
    private CRMGDBean crmgdBean;
    @EJB
    private SERCABean sercaBean;
     @EJB
    private SystemUserBean systemuserBean;
    @EJB
    private SYSNNBean sysnnBean;

    @EJB
    private CMSMGBean cmsmgBean;

    @EJB
    private REPMQBean repmqBean;

    public SERBQFacadeREST() {
        super(SERBQ.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return serbqBean;
    }

    /**
     * 创建客诉单和叫修单
     *
     * @param entity
     * @param appid
     * @param token
     * @return
     */
    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage createSERBQFromWeChat(SERBQApplication entity, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            Date date;
            StringBuffer msg = new StringBuffer("【汉钟精机】 客诉单:");
             StringBuffer leaderMsg = new StringBuffer("【汉钟精机】"); 
             SystemUser user=systemuserBean.findByUserId(entity.getEmployeeId());
             leaderMsg.append(user.getUsername()).append("创建的");
            try {
                date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
                CRMGG gg = crmggBean.findByGG001(entity.getCustomerCodeId());
                SYSNN sysnn = sysnnBean.findById(gg.getGg109());
                String bq001 = serbqBean.getBQ001ByDeptAndDate(entity.getDeptId(), date);
                SERBQ bq = new SERBQ();
                bq.setBq001(bq001 == null ? "" : bq001);
                msg.append(bq001);
                bq.setBq002(entity.getCustomerCodeId() == null ? "" : entity.getCustomerCodeId());
                bq.setBq003(entity.getProductTypeId() == null ? "" : entity.getProductTypeId());
                bq.setBq005(entity.getEmergencyDrgreeId() == null ? "" : entity.getEmergencyDrgreeId());// 紧急度
                bq.setBq027(entity.getResponsibilitiesId() == null ? "" : entity.getResponsibilitiesId());// 权责
                List<Object[]> callers = crmggBean.findCaller(entity.getCustomerCodeId());
                String caller;
                String callerphone;
                if (callers.size() >= 2) {
                    caller = callers.get(1)[1] == null ? "" : (String) callers.get(1)[1];
                    callerphone = callers.get(1)[4] == null ? "" : (String) callers.get(1)[4];

                } else {
                    caller = callers.get(0)[1] == null ? "" : (String) callers.get(0)[1];
                    callerphone = callers.get(0)[4] == null ? "" : (String) callers.get(0)[4];
                }
                bq.setBq007(caller);
                bq.setBq009(callerphone);
                String ti = BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", BaseLib.getDate());
                bq.setBq008(ti.substring(11) == null ? "" : ti.substring(11));
                bq.setBq016(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
                bq.setBq017(entity.getDeptId() == null ? "" : entity.getDeptId());
                bq.setBq018(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
                bq.setBq019(entity.getDeptId() == null ? "" : entity.getDeptId());
                bq.setBq021(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                bq.setBq022("N");
                bq.setBq023(entity.getProblemTypeId() == null ? "" : entity.getProblemTypeId());
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher matcher = p.matcher(entity.getReason());
                String dest = matcher.replaceAll("");
                bq.setBq024(dest);
              //  List<SERBF> serbfs = serbfBean.findByBF002(entity.getEmployeeId());
              //  if (serbfs != null && !serbfs.isEmpty()) {
             //       bq.setBq027(serbfs.get(0).getSERBFPK().getBf001());
              //  } else {
              //      bq.setBq027("");
             //   }
                bq.setBq031("");
                bq.setBq034("");
                bq.setBq035("N");
                bq.setBq036("");
                bq.setBq042(BigDecimal.ZERO);
                bq.setBq043(BigDecimal.ZERO);
                bq.setBq044("N");
                bq.setBq047("2");
                bq.setBq049("");
                bq.setBq052("2");
                bq.setBq058("");
                bq.setBq059("");
                bq.setBq060(entity.getPhoneCountry1() == null ? "" : entity.getPhoneCountry1());// 行動電話國碼
                bq.setBq061(entity.getPhoneArea1() == null ? "" : entity.getPhoneArea1());// 行動電話號碼
                bq.setBq064("");
                bq.setBq065("");
                bq.setBq068(BigDecimal.ZERO);
                List<CMSMG> list = cmsmgBean.findByMG001(entity.getCurrency());
                if (list != null && list.size() != 0) {
                    bq.setBq089(list.get(0).getMg003());
                }
                bq.setBq088(entity.getCurrency());
                bq.setBq094(gg.getGg109());
                bq.setBq095(gg.getGg089());
                bq.setBq096(gg.getGg098());
                bq.setBq097(sysnn.getNn003());
                bq.setBq090("N");
                bq.setBq092(BigDecimal.ZERO);
                bq.setBq093("N");
                bq.setBq107("N");
                bq.setBq116("N");
                bq.setBq121("N");
                bq.setBq122(BigDecimal.ZERO);
                bq.setBq123(BigDecimal.ZERO);
                bq.setBq124(BigDecimal.ZERO);
                bq.setBq125(BigDecimal.ZERO);
                bq.setBq126(BigDecimal.ZERO);
                bq.setBq127(BigDecimal.ZERO);
                bq.setBq128(BigDecimal.ZERO);
                bq.setBq197(entity.getProductId() == null ? "" : entity.getProductId());
                bq.setBq198(entity.getAreaId() == null ? "" : entity.getAreaId());
                // bq.setBq199(entity.getDealer() == null ? "" : entity.getDealer());//經銷商
                bq.setBq500(entity.getComplaintTypeId() == null ? "" : entity.getComplaintTypeId()); // 客诉单类型
                bq.setBq506(entity.getIncidentProvinceId() == null ? "" : entity.getIncidentProvinceId()); // 事发省
                bq.setBq507(entity.getIncidentCityId() == null ? "" : entity.getIncidentCityId());// 事发市
                // 客诉类型是否是其他，其他则不是客诉单
                if ("1".equals(bq.getBq500())) {
                    bq.setBq110("Y");
                } else {
                    bq.setBq110("N");
                }
                bq.setCompany("SHAHANBELL");
                bq.setCreator(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
                bq.setUsrGroup(entity.getDeptId() == null ? "" : entity.getDeptId());
                bq.setFlag((short) 1);
                bq.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                serbqBean.persist(bq);
                 int m = 1;
                for (SERBQDETAILLApplication detail : entity.getSercadetails()) {
                    // 品号资料单身
                    SERCA ca = new SERCA();
                    SERCAPK capk = new SERCAPK();
                    capk.setCa001(bq.getBq001());
                    StringBuffer serial = new StringBuffer("000");
                    capk.setCa002(serial.append(m).toString());
                    m++;
                    ca.setSERCAPK(capk);
                    ca.setCa003(detail.getProductQuality());
                    ca.setCa004(detail.getProduct_name());
                    ca.setCa005(detail.getProductStandard());
                    ca.setCa009(detail.getProductNumberId());// 制造号码
                    ca.setCa010(detail.getFormId()); // 叫修单单别
                    String serl = reptaBean.getTA002ByTA001AndDate(detail.getFormId(), BaseLib.getDate());
                    ca.setCa011(serl); // 叫修单单号（派工单号）
                    ca.setCa012("");
                    ca.setCa013(BigDecimal.ZERO);
                    ca.setCa014("");
                    ca.setCa015(entity.getProblemTypeName());
                    ca.setCa019(entity.getEmergencyDrgreeId());
                    ca.setCa021(entity.getProblemTypeId());
                    ca.setCa500(detail.getMachineTypeId());
                    ca.setFlag((short) 0);
                    // 产生叫修单单头
                    REPTA ta = new REPTA();
                    REPTAPK tapk = new REPTAPK();
                    ta.setCompany("SHAHANBELL");
                    ta.setCreateDate(bq.getCreateDate());
                    ta.setCreator(bq.getCreator());
                    ta.setUsrGroup(bq.getUsrGroup());
                    tapk.setTa001(detail.getFormId());
                    tapk.setTa002(serl);
                    ta.setREPTAPK(tapk);
                    ta.setTa003(bq.getCreateDate());
                    ta.setTa004(entity.getCustomerCodeId()); // 客户代号
                    ta.setTa005(detail.getProductQuality()); // 产品品号
                    ta.setTa006(detail.getProduct_name()); // 产品品名
                    ta.setTa007(detail.getProductStandard()); // 产品规格
                    ta.setTa009(entity.getEmployeeId()); // 接单人员
                    ta.setTa010(entity.getProblemTypeName());
                    ta.setTa014("N");
                    ta.setTa017(entity.getReason());
                    ta.setTa020(caller);
                    ta.setTa021(gg.getGg004()); // 公司全名
                    ta.setTa026(gg.getGg036()); // 交货地址
                    ta.setTa025(callerphone); // 电话
                    ta.setTa022(entity.getInvoiceAdress1());
                    ta.setTa023(entity.getInvoiceAdress2());
                    ta.setTa024(entity.getInvoiceMail());
                    ta.setTa013(detail.getProductNumberId());// 产品序号
                     ta.setTa030("N");
                    ta.setTa031("0");
                     ta.setTa035("0");
                    ta.setTa036(entity.getUnifyNum());
                    ta.setTa049(bq.getBq001());
                    ta.setTa051(entity.getEmergencyDrgreeId());
                    SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
                    Date start = null;
                    Date end = null;
                    if (detail.getWarrantyStart() != null && !"".equals(detail.getWarrantyStart())) {
                        start = sim.parse(detail.getWarrantyStart());
                    }
                    if (detail.getWarrantyEnd() != null && !"".equals(detail.getWarrantyEnd())) {
                        end = sim.parse(detail.getWarrantyEnd());
                    }
                    if (start != null && end != null) {
                        if (start.getTime() <= new Date().getTime() && new Date().getTime() <= end.getTime()) {
                            ta.setTa055("Y");
                        } else {
                            ta.setTa055("N");
                        }
                    }
                    ta.setTa056(detail.getWarrantyStart());
                    ta.setTa057(detail.getWarrantyEnd());
                    ta.setTa058("1");
                    ta.setTa071(entity.getProblemTypeId()); // 问题代号
                    ta.setTa062(entity.getCurrency());// 币别
                    ta.setCustomer(entity.getCustomerCodeId());
                    // ta.setTa199(entity.getDealer());//10
                    bq.setBq088(entity.getCurrency());
                    if (list != null && list.size() != 0) {
                        ta.setTa063(list.get(0).getMg003());// 汇率
                    }
                    ta.setTa197(entity.getProductId()); // 产品别AA
                    ta.setTa198(entity.getAreaId()); // 区域别
                    ta.setTa054("3");
                    ta.setTa038("0");
                    if (gg != null) {
                        ta.setTa034(gg.getGg027()); // 传真
                        ta.setTa068(gg.getGg109());
                        ta.setTa037(gg.getGg089());
                        ta.setTa044(gg.getGg098());
                        ta.setTa045(sysnn.getNn003());
                    }
                    ta.setTa500(detail.getMachineTypeId());
                    sercaBean.persist(ca);
                    reptaBean.persist(ta);
                    msg.append(" 叫修单").append(m - 1).append(":").append(ta.getREPTAPK().getTa001());
                    msg.append("-").append(serl).append("。");
                    
                    leaderMsg.append(" 叫修单").append(m - 1).append(":").append(ta.getREPTAPK().getTa001());
                    leaderMsg.append("-").append(serl).append("。");
                }
                ResponseMessage responseMessage = new ResponseMessage("200", msg.toString());
                String errmsg = serbqBean.sendMsgString(entity.getEmployeeId(), msg.toString(), entity.getSessionkey(),
                        entity.getOpenId());
                leaderMsg.append(" 请尽快派工。");
                String leadererrmsg = serbqBean.sendMsgString(user.getManagerId(), leaderMsg.toString(), entity.getSessionkey(),
                        entity.getOpenId());
                if (!"200".equals(errmsg)||!"200".equals(leadererrmsg)) {
                    throw new RuntimeException("发送失败,请联系管理员");
                }
                return responseMessage;
            } catch (Exception e) {
                ResponseMessage responseMessage = new ResponseMessage("500", "申请失败");
                return responseMessage;
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
