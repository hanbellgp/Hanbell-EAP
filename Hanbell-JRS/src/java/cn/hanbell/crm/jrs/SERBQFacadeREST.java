package cn.hanbell.crm.jrs;

import cn.hanbell.crm.app.SERBQApplication;
import cn.hanbell.crm.ejb.CMSMGBean;
import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.ejb.REPTABean;
import cn.hanbell.crm.ejb.SERBQBean;
import cn.hanbell.crm.ejb.SERCABean;
import cn.hanbell.crm.ejb.SYSNNBean;
import cn.hanbell.crm.entity.CMSMG;
import cn.hanbell.crm.entity.CRMGD;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.REPTA;
import cn.hanbell.crm.entity.REPTAPK;
import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.crm.entity.SERCA;
import cn.hanbell.crm.entity.SERCAPK;
import cn.hanbell.crm.entity.SYSNN;
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
    private REPTABean repiaBean;

    @EJB
    private CRMGGBean crmggBean;

    @EJB
    private REPTABean reptaBean;

    @EJB
    private SERCABean sercaean;

    @EJB
    private SYSNNBean sysnnBean;

    @EJB
    private CMSMGBean cmsmgbean;

    public SERBQFacadeREST() {
        super(SERBQ.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return serbqBean;
    }

    /**
     * 创建客诉单和派工单
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
    public ResponseMessage createSERBQFromWechat(SERBQApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            Date date;
            StringBuffer msg = new StringBuffer("【汉钟精机】 客诉单号:");
            try {
                date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
                String bq001 = serbqBean.getBQ001ByDeptAndDate(entity.getDeptId(), date);
                SERBQ bq = new SERBQ();
                bq.setBq001(bq001 == null ? "" : bq001);
                bq.setBq002(entity.getCustomerCodeId() == null ? "" : entity.getCustomerCodeId());
                bq.setBq003(entity.getProductTypeId() == null ? "" : entity.getProductTypeId());
                bq.setBq005(entity.getEmergencyDrgree() == null ? "" : entity.getEmergencyDrgree());//紧急度
                bq.setBq007(entity.getCallerUnit() == null ? "" : entity.getCallerUnit());
                bq.setBq009(entity.getCallerPhone() == null ? "" : entity.getCallerPhone());//来电者，非来电单位
                String ti = BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", BaseLib.getDate());
                bq.setBq008(ti.substring(11) == null ? "" : ti.substring(11));
                bq.setBq017(entity.getDeptId() == null ? "" : entity.getDeptId());
                bq.setBq018(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
                bq.setBq019(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
                bq.setBq021(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                bq.setBq022("N");
                bq.setBq023(entity.getProblemTypeId() == null ? "" : entity.getProblemTypeId());
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher matcher = p.matcher(entity.getReason());
                String dest = matcher.replaceAll("");
                bq.setBq024(dest);
                bq.setBq027("");
                bq.setBq031("");
                bq.setBq034("");
                bq.setBq035("N");
                bq.setBq036("");
                bq.setBq042(new BigDecimal(0.00));
                bq.setBq043(new BigDecimal(0.00));
                bq.setBq044("N");
                bq.setBq047("2");
                bq.setBq049("");
                bq.setBq052("2");
                bq.setBq055(entity.getPhoneCountry() == null ? "" : entity.getPhoneCountry());//電話過嗎
                bq.setBq056(entity.getPhoneArea() == null ? "" : entity.getPhoneArea());//電話區碼
                bq.setBq058("");
                bq.setBq059("");
                bq.setBq060(entity.getPhoneCountry1() == null ? "" : entity.getPhoneCountry1());//行動電話國碼
                bq.setBq061(entity.getPhoneArea1() == null ? "" : entity.getPhoneArea1());//行動電話號碼
                bq.setBq064("");
                bq.setBq065("");
                bq.setBq068(BigDecimal.ZERO);
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
                bq.setBq199(entity.getDealer() == null ? "" : entity.getDealer());//經銷商 
                bq.setBq500(entity.getComplaintTypeId() == null ? "" : entity.getComplaintTypeId()); //客诉单类型
                bq.setBq506(entity.getIncidentProvinceId() == null ? "" : entity.getIncidentProvinceId()); //事发省
                bq.setBq507(entity.getIncidentCityId() == null ? "" : entity.getIncidentCityId());//事发市
                //客诉类型是否是其他，其他则不是客诉单
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
                //品号资料单身
                SERCA ca = new SERCA();
                SERCAPK capk = new SERCAPK();
                capk.setCa001(bq.getBq001());
                capk.setCa002("0001"); // 手机端发单明细只有1笔资料
                ca.setSERCAPK(capk);
                ca.setCa003(entity.getProductQuality());
                ca.setCa004(entity.getProduct_name());
                ca.setCa005(entity.getProductStandard());
                ca.setCa009(entity.getProductNumberId());//制造号码
                ca.setCa010(entity.getFormId()); // 叫修单单别
                String serl = repiaBean.getTA002ByTA001AndDate(entity.getFormId(), BaseLib.getDate());
                ca.setCa011(serl); // 叫修单单号（派工单号）
                ca.setCa012("");
                ca.setCa013(BigDecimal.ZERO);
                ca.setCa014("");
                ca.setCa015(entity.getProblemTypeName());
                ca.setCa019(entity.getEmergencyDrgree());
                ca.setCa021(entity.getProblemTypeId());
                ca.setCa500(entity.getProductTypeId());
                ca.setFlag((short) 0);
                // 产生叫修单单头
                REPTA ta = new REPTA();
                REPTAPK tapk = new REPTAPK();
                ta.setCompany("SHAHANBELL");
                ta.setCreateDate(bq.getCreateDate());
                ta.setCreator(bq.getCreator());
                ta.setUsrGroup(bq.getUsrGroup());
                tapk.setTa001(entity.getFormId());
                tapk.setTa002(serl);
                ta.setREPTAPK(tapk);
                ta.setTa003(bq.getCreateDate());
                ta.setTa004(entity.getCustomerCodeId()); // 客户代号
                ta.setTa005(entity.getProductQuality()); // 产品品号
                ta.setTa006(entity.getProduct_name()); // 产品品名
                ta.setTa007(entity.getProductStandard()); // 产品规格
                ta.setTa009(entity.getEmployeeId()); // 接单人员
                ta.setTa010(entity.getProblemTypeName());
//            ta.setTa012(entity.getCompanyName());//######数据字段长度不够
                ta.setTa017(entity.getReason());
                ta.setTa022(entity.getInvoiceAdress1());
                ta.setTa023(entity.getInvoiceAdress2());
                ta.setTa024(entity.getInvoiceMail());
                ta.setTa013(entity.getProductNumberId());//产品序号
                ta.setTa031("0");
                ta.setTa036(entity.getUnifyNum());
                ta.setTa049(bq.getBq001());
                ta.setTa051(entity.getEmergencyDrgree());
                SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
                Date start = null;
                Date end = null;
                if (entity.getWarrantyStart() != null && !"".equals(entity.getWarrantyStart())) {
                    start = sim.parse(entity.getWarrantyStart());
                }
                if (entity.getWarrantyEnd() != null && !"".equals(entity.getWarrantyEnd())) {
                    end = sim.parse(entity.getWarrantyEnd());
                }
                if (start != null && end != null) {
                    if (start.getTime() <= new Date().getTime() && new Date().getTime() <= end.getTime()) {
                        ta.setTa055("Y");
                    } else {
                        ta.setTa055("N");
                    }
                }
                ta.setTa056(entity.getWarrantyStart());
                ta.setTa057(entity.getWarrantyEnd());
                ta.setTa058("1");
                ta.setTa071(entity.getProblemTypeId()); // 问题代号
                ta.setTa062(entity.getCurrency());//币别
                ta.setCustomer(entity.getCustomerCodeId());
                ta.setTa199(entity.getDealer());//10
                bq.setBq088(entity.getCurrency());
                List<CMSMG> list = cmsmgbean.findByMG001(entity.getCurrency());
                if (list != null && list.size() != 0) {
                    ta.setTa063(list.get(0).getMg003());//汇率
                    bq.setBq089(list.get(0).getMg003());
                }
                ta.setTa197(entity.getProductId()); //  产品别AA
                ta.setTa198(entity.getAreaId()); // 区域别
                ta.setTa020(entity.getCaller()); // 联络人
                ta.setTa054("3");
                ta.setTa038("N");
                CRMGG gg = crmggBean.findByERPCusno(ta.getTa004());
                if (gg != null) {
                    ta.setTa034(gg.getGg027()); // 传真
                    ta.setTa068(gg.getGg109());
                    ta.setTa037(gg.getGg089());
                    ta.setTa044(gg.getGg098());
//                ##税别码##发票连数##课税别
                    bq.setBq094(gg.getGg109());
                    bq.setBq095(gg.getGg089());
                    bq.setBq096(gg.getGg098());
                    SYSNN sysnn = sysnnBean.findById(gg.getGg109());
                    ta.setTa045(sysnn.getNn003());
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
                ta.setTa500(entity.getMachineTypeId());
                serbqBean.persist(bq);
                sercaean.persist(ca);
                repiaBean.persist(ta);
                ResponseMessage responseMessage = new ResponseMessage("200", "创建成功，单号已发至企业微信，请查收!");
                msg = msg.append(bq001).append("  派工单号:" + serl);
//                String errmsg = serbqBean.sendMsgString(entity.getEmployeeId(), msg.toString(), entity.getSessionkey(), entity.getOpenId());
                String errmsg = serbqBean.sendMsgString("ShenXin|FeiFei", msg.toString(), entity.getSessionkey(), entity.getOpenId());
                if (!"200".equals(errmsg)) {
                    throw new RuntimeException("发送失败,请联系管理员");
                }
                return responseMessage;
            } catch (Exception e) {
//                  log4j.info(msg);
                System.out.println("msg=" + msg);
                ResponseMessage responseMessage = new ResponseMessage("500", "申请失败");
                return responseMessage;
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
