/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.app.REPTCApplication;
import cn.hanbell.crm.app.REPTCSatisfaction;
import cn.hanbell.crm.app.REPTDApplication;
import cn.hanbell.crm.ejb.CMSMVBean;
import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.ejb.REPMFBean;
import cn.hanbell.crm.ejb.REPMUBean;
import cn.hanbell.crm.ejb.REPPWBean;
import cn.hanbell.crm.ejb.REPTABean;
import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.ejb.REPTDBean;
import cn.hanbell.crm.ejb.SERCABean;
import cn.hanbell.crm.ejb.SYSNNBean;
import cn.hanbell.crm.ejb.WARMQBean;
import cn.hanbell.crm.ejb.WARTABean;
import cn.hanbell.crm.ejb.WARTBBean;
import cn.hanbell.crm.entity.CMSMV;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.REPMF;
import cn.hanbell.crm.entity.REPPW;
import cn.hanbell.crm.entity.REPTA;
import cn.hanbell.crm.entity.REPTC;
import cn.hanbell.crm.entity.REPTCPK;
import cn.hanbell.crm.entity.REPTD;
import cn.hanbell.crm.entity.REPTDPK;
import cn.hanbell.crm.entity.SYSNN;
import cn.hanbell.crm.entity.WARTA;
import cn.hanbell.crm.entity.WARTAPK;
import cn.hanbell.crm.entity.WARTB;
import cn.hanbell.crm.entity.WARTBPK;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author C2082
 */
@Path("crm/reptc")
@javax.enterprise.context.RequestScoped
public class REPTCFacadeREST extends SuperRESTForCRM<REPTC> {

    @EJB
    protected cn.hanbell.oa.ejb.WorkFlowBean workFlowBean;

    @EJB
    private SYSNNBean sysnnBean;
    @EJB
    private SystemUserBean userBean;
    @EJB
    private CMSMVBean cmsmvBean;
    @EJB
    private REPTCBean reptcBean;
    @EJB
    private REPTABean reptaBean;
    @EJB
    private REPPWBean reppwBean;
    @EJB
    private CRMGGBean crmggBean;
    @EJB
    private SERCABean sercaBean;
    @EJB
    private REPTDBean reptdBean;
    @EJB
    private WARTABean wartaBean;
    @EJB
    private WARTBBean wartbBean;
    @EJB
    private REPMFBean repmfBean;
    @EJB
    private WARMQBean warmqBean;
    @EJB
    private REPMUBean repmuBean;

    public REPTCFacadeREST() {
        super(REPTC.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return reptcBean;
    }

    /**
     * 创建维修单，录入库存异动单反写多人派工及客诉派工状态码
     *
     * @param reptcapplication
     * @param appid
     * @param token
     * @return
     */
    @POST
    @Path("createMaintain")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage createMaintain(REPTCApplication reptcapplication, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            String seal = reptcBean.getTC002ByTC001AndDate(reptcapplication.getMaintainTypeId(), new Date());
            StringBuffer msg = new StringBuffer("【汉钟精机】 维修单:");
            String serializableNumber = wartaBean.getTA002ByTA001AndDate(reptcapplication.getIncentoryform(),
                    new Date());
            List<Object[]> warmqs = warmqBean.findByMQ003(reptcapplication.getIncentoryform());
            msg.append(reptcapplication.getMaintainTypeId()).append("-").append(seal);
            msg.append("。 库存异动单:").append(reptcapplication.getIncentoryform()).append("-").append(serializableNumber).append("。");
            CRMGG crmgg = crmggBean.findByGG001(reptcapplication.getCustomer());
            try {
                Date date;
                date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                REPTC reptc = new REPTC();
                REPTCPK reptcpk = new REPTCPK();
                reptcpk.setTc001(reptcapplication.getMaintainTypeId());// 维修单别
                reptcpk.setTc002(seal);// 维修单号
                reptc.setCompany("CRMDB");
                reptc.setCreator(reptcapplication.getEmployeeId());
                reptc.setUsrGroup(reptcapplication.getDeptId());
                reptc.setCreateDate(simpleDateFormat.format(new Date()));
                reptc.setFlag(new Short("1"));
                reptc.setREPTCPK(reptcpk);
                reptc.setTc003(simpleDateFormat.format(new Date()));
                reptc.setTc005(reptcapplication.getRepairKindId());// 叫修单别
                reptc.setTc006(reptcapplication.getRepairno());// 叫修单号
                reptc.setTc007(reptcapplication.getCustomer());// 客户
                // 叫修单信息
                REPTA repta = reptaBean.findByPK(reptcapplication.getRepairKindId(), reptcapplication.getRepairno());
                reptc.setTc008(repta.getTa005());
                reptc.setTc009(repta.getTa006());
                reptc.setTc010(repta.getTa007());
                reptc.setTc011(repta.getTa009());
                reptc.setTc012(repta.getReceiver().getMv004());// 部门
                reptc.setTc013(repta.getTa010());
                reptc.setTc014(repta.getTa011());
                reptc.setTc015(repta.getTa012());
                reptc.setTc016(reptcapplication.getMaintainer());// 维修人员
                SystemUser user = userBean.findByUserId(reptc.getTc016());
                reptc.setTc017(user.getDeptno());// 维修人员部门/站别
                reptc.setTc018("1");
                reptc.setTc023(repta.getTa017());
                reptc.setTc056(repta.getTa051());// 紧急度
                reptc.setTc058(repta.getTa013());// 产品序号
                reptc.setTc034("N");
                // reptc.setTc035(reptcapplication.getDeptId());
                reptc.setTc035(user.getDeptno());
                // 客户厂商信息
                reptc.setTc036(crmgg.getGg004());
                reptc.setTc037(crmgg.getGg101());
                reptc.setTc038(crmgg.getGg030());
                reptc.setTc039(crmgg.getGg089());
                reptc.setTc040(crmgg.getGg096());
                reptc.setTc041(crmgg.getGg097());
                reptc.setTc042("N");
                reptc.setTc045(BaseLib.formatDate("yyyyMM", new Date()));
                SYSNN sysnn = sysnnBean.findById(repta.getTa068());
                reptc.setTc046(sysnn.getNn003());//营业税率
                reptc.setTc048("N");
                reptc.setTc051(crmgg.getGg098());
                reptc.setTc063(repta.getTa055());
                reptc.setTc064(repta.getTa056());// 保固开始日期
                reptc.setTc065(repta.getTa057());// 保固结束日期
                reptc.setTc066(BigDecimal.TEN);// 维修数量（###）
                reptc.setTc069(repta.getTa062());
                reptc.setTc070(repta.getTa063());
                reptc.setTc074(repta.getTa068());
                reptc.setTc077(repta.getTa071());
                reptc.setTc078("来至微信小程序");
                //从多人派工中带入
                List<REPPW> reppes = reppwBean.findByPw001AndPw002(reptcapplication.getRepairKindId(), reptcapplication.getRepairno());
                for (REPPW r : reppes) {
                    if (r.getPw004().equals(reptcapplication.getMaintainer())) {
                        r.setPw008(reptcapplication.getMaintainTypeId());
                        r.setPw009(seal);
                        reppwBean.update(r);
                        reptc.setTc095(r.getPw026());
                    }
                }
                reppwBean.findByPw001AndPw002(seal, seal);
                reptc.setTc198(repta.getTa198());
                reptc.setTc199(repta.getTa199());
                String serca = sercaBean.findByAC010AndAC011(reptcapplication.getRepairKindId(),
                        reptcapplication.getRepairno());// 获得客诉单号
                reptc.setTc054(serca);
                reptc.setCustomer(reptcapplication.getCustomer());// 客户ID
                reptc.setProduct(repta.getTa197());// 产品
                reptc.setProduct(repta.getTa198());// 区域
                reptc.setTc197(repta.getTa197());// 产品
                REPTD reptd = null;// 维修单明细
                REPTDPK reptdpk;// 维修单名字联合主键
                // 异动库存单，产生维修单明细同时产生异动库存明细
                WARTA warta = new WARTA();
                WARTAPK wartapk = new WARTAPK();
                wartapk.setTa001(reptcapplication.getIncentoryform());

                int count = 0;
                BigDecimal sumMoney = new BigDecimal(0);
                LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
                //
                List<WARTB> detailList = new ArrayList<WARTB>();
                for (REPTDApplication rept : reptcapplication.getReptds()) {
                    reptd = new REPTD();
                    reptdpk = new REPTDPK();
                    reptd.setCompany("CRMDB");
                    reptd.setCreator(reptcapplication.getEmployeeId());
                    reptd.setUsrGroup("0000");
                    reptd.setCreateDate(simpleDateFormat.format(new Date()));
                    reptd.setFlag(new Short("1"));
                    reptdpk.setTd001(reptcapplication.getMaintainTypeId());// 维修单别
                    reptdpk.setTd002(seal);// 维修单号
                    reptd.setREPTDPK(reptdpk);
                    String serl = reptdBean.getTD003ByTD001AndTD002(reptdpk.getTd001(), reptdpk.getTd002());
                    reptdpk.setTd003(serl);// 维修单序号
                    reptd.setTd004(rept.getProductQuality());
                    reptd.setTd005(rept.getProduct_name());
                    reptd.setTd006(rept.getProductStandard());
                    reptd.setTd007(rept.getProductUnit());// 单位
                    reptd.setTd008(rept.getWarehouseId());// 维修人员仓库
                    reptd.setTd009(new BigDecimal(rept.getPlanMaintainCount()));// 维修数量
                    reptd.setTd013("N");
                    reptd.setTd012(reptc.getTc023());// 备注
                    reptd.setTd022(rept.getProductNumberId());// 料件序号，即产品序号
                    reptd.setTd026("1");// 类别 默认料件
                    reptd.setTd027("1");
                    reptd.setTd028("");
                    reptd.setTd031("1");
                    reptd.setTd032(new BigDecimal(rept.getPlanMaintainCount()));
                    reptd.setTd034(rept.getWarrantyStart());// 开始日期
                    reptd.setTd035(rept.getWarrantyEnd());// 到期日期
                    SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
                    Date start = null;
                    Date end = null;
                    if (rept.getWarrantyStart() != null && !"".equals(rept.getWarrantyStart())) {
                        start = sim.parse(rept.getWarrantyStart());
                    }
                    if (rept.getWarrantyEnd() != null && !"".equals(rept.getWarrantyEnd())) {
                        end = sim.parse(rept.getWarrantyEnd());
                    }
                    if (start != null && end != null) {
                        if (start.getTime() <= new Date().getTime() && new Date().getTime() <= end.getTime()) {
                            reptd.setTd033("Y");
                        } else {
                            reptd.setTd033("N");
                        }
                    }
                    reptd.setTd043("N");
                    reptd.setTd046("Y");
                    reptd.setTd047("N");
                    count = count + Integer.parseInt(rept.getPlanMaintainCount());
                    // 异动库存单单身
                    WARTB wartb = new WARTB();
                    WARTBPK wartbpk = new WARTBPK();
                    wartb.setCompany("CRMDB");
                    wartb.setCreator(reptcapplication.getEmployeeId());
                    wartb.setUsrGroup(reptcapplication.getDeptId());
                    wartb.setCreateDate(BaseLib.formatDate("yyyyMMdd", new Date()));
                    wartb.setFlag(new Short("1"));
                    wartbpk.setTb001(wartapk.getTa001());
                    wartbpk.setTb002(serializableNumber);
                    wartbpk.setTb003(wartbBean.getDetailSerlByTA001AndTA002(wartapk.getTa001(), serializableNumber));// 维修单序号，作为库存交易单序号
                    wartb.setWARTBPK(wartbpk);
                    wartb.setTb004(reptd.getTd004());
                    wartb.setTb005(reptd.getTd005());
                    wartb.setTb006(reptd.getTd006());
                    wartb.setTb007(reptd.getTd009());
                    wartb.setTb008(reptd.getTd007());
                    wartb.setTb009(reptd.getTd009());
                    wartb.setTb010(reptd.getTd008());
                    REPMF repmf = repmfBean.findByItnbr(wartb.getTb004());
                    wartb.setTb013("N");
                    wartb.setTb014(BaseLib.formatDate("yyyyMMdd", new Date()));
                    wartb.setTb015(reptdpk.getTd001());
                    wartb.setTb016(reptdpk.getTd002());
                    wartb.setTb017(reptdpk.getTd003());

                    if (repmf == null) {
                        wartb.setTb018(new BigDecimal(0));
                    } else {
                        wartb.setTb018(repmf.getMf003());// 单价
                    }
                    // 总金额
                    sumMoney = sumMoney.add(wartb.getTb018().multiply(wartb.getTb007()));
                    wartb.setTb027("1");
                    wartb.setTb034("0");
                    wartb.setTb042("0");
                    detailList.add(wartb);
                    reptdBean.persist(reptd);
                    wartbBean.persist(wartb);
                }
                reptcBean.persist(reptc);
                // 设置当前员工的维修人员的状态为1
                List<REPPW> list = reppwBean.findByPw001AndPw002AndPW010(repta.getREPTAPK().getTa001(),
                        repta.getREPTAPK().getTa002(), "0");
                for (REPPW r : list) {
                    if (r.getPw004().equals(reptcapplication.getMaintainer())) {
                        r.setPw010("1");
                        reppwBean.update(r);
                    }
                }
                // 当完成最后一个维修人员的维修单时，反写叫修单
                if (list.size() == 1) {
                    repta.setTa031("1");
                    reptaBean.update(repta);
                }
                // 产生库存异动单头
                wartapk.setTa002(serializableNumber);
                warta.setWARTAPK(wartapk);
                warta.setCompany("CRMDB");
                warta.setCreator(reptcapplication.getEmployeeId());
                warta.setUsrGroup(reptcapplication.getDeptId());
                warta.setCreateDate(BaseLib.formatDate("yyyyMMdd", new Date()));
                warta.setFlag(new Short("1"));
                warta.setTa003(BaseLib.formatDate("yyyyMMdd", new Date()));
                warta.setTa004(user.getDeptno());
                warta.setTa005(reptcapplication.getDeliveryremark());
                warta.setTa006("N");// 审核状态
                warta.setTa007("b1");// 一般单据
                warta.setTa008(new BigDecimal(count));// 总数量
                warta.setTa009(BaseLib.formatDate("yyyyMMdd", new Date()));
                warta.setTa012(reptc.getTc016());
                CMSMV cmsmv = cmsmvBean.findById(reptc.getTc016());
                warta.setTa014(user.getDept().getCompany());// 厂别
                warta.setTa018("来至微信小程序");
                warta.setTa020("N");
                warta.setTa023(sumMoney);
                warta.setTa030(reptc.getProduct());
                warta.setTa031(reptc.getTc197());
                warta.setTa032(crmgg.getGg043());
                warta.setTa033(reptc.getTc008());
                warta.setTa034(reptc.getTc009());
                warta.setTa035(reptc.getTc010());
                warta.setTa036(reptc.getTc058());
                warta.setTa037(reptc.getTc013());
                warta.setTa039(reptc.getTc054());
                warta.setTa040(reptc.getTc005());
                warta.setTa041(seal);
                if ("JCDF".equals(reptcapplication.getIncentoryform())
                        || "JCDX".equals(reptcapplication.getIncentoryform())) {
                    warta.setTa043(reptcapplication.getTradingreason());
                } else if ("FWLL".equals(reptcapplication.getIncentoryform())) {
                    warta.setTa042(reptcapplication.getTradingreason());
                }
                warta.setTa519(reptcapplication.getDeliverydeptId());
                wartaBean.persist(warta);
                StringBuffer userid = null;
                userid = new StringBuffer(reptcapplication.getEmployeeId());
                // 同一个人发送一条数据
                if (!reptcapplication.getEmployeeId().equals(reptcapplication.getMaintainer())) {
                    userid.append("|").append(reptcapplication.getMaintainer());
                }
                String errmsg = wartaBean.sendMsgString(userid.toString(), msg.toString(),
                        reptcapplication.getSessionkey(), reptcapplication.getOpenId());
                // 发送失败，抛异常，使事务回滚
                if (!"200".equals(errmsg)) {
                    throw new RuntimeException("发送失败,请联系管理员");
                }
                ResponseMessage responseMessage = new ResponseMessage("200", msg.toString());
                return responseMessage;
            } catch (Exception ex) {
                log4j.info(msg);
                log4j.error(ex.getMessage());
                ResponseMessage responseMessage = new ResponseMessage("500", ex.getMessage());
                return responseMessage;
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("maintainform/{maintainformtype}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<REPTC> findRepair(@PathParam("maintainformtype") String maintainformtype, @QueryParam("searchWord") String maintainform,
            @QueryParam("appid") String appid, @QueryParam("token") String token) throws Exception {
        if (isAuthorized(appid, token)) {
            List<REPTC> list = reptcBean.getReptcByTC001OrTc002(maintainformtype, maintainform);
            if (list == null) {
                throw new WebApplicationException("没有未处理的维修单");
            }
            ResponseData<REPTC> rsd = new ResponseData<>("200", "sucess");
            if (list.size() >= 50) {
                List<REPTC> reptcs = list.subList(0, 49);
                rsd.setCount(reptcs.size());
                rsd.setData(reptcs);
            } else {
                rsd.setCount(list.size());
                rsd.setData(list);
            }
            return rsd;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    /**
     * 客户提交的满意度调查 由于小程序传过来的数据超过微信规定的拼接url上的字符串字节数，此处暂时不做权限规定。
     *
     * @return
     */
    @POST
    @Path("updateSatisfaction")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateSatisfaction(REPTCSatisfaction satisfaction) {
        if (satisfaction.getOpenID() == null || "".equals(satisfaction.getOpenID())) {
              ResponseMessage message = new ResponseMessage("500", "fail");
                return message;
        }
        try {
            REPTC reptc = reptcBean.findByPK(satisfaction.getMaintainType(), satisfaction.getMaintainNumber());
            reptc.setTc082(satisfaction.getService());
            reptc.setTc086(satisfaction.getProduct());
            int sum = Integer.parseInt(satisfaction.getService()) + Integer.parseInt(satisfaction.getProduct());
            reptc.setTc087(new BigDecimal(String.valueOf(sum / 2)));
            StringBuffer remark = new StringBuffer("【");
            remark.append(satisfaction.getOpenID());
            remark.append("--").append(satisfaction.getNickname()).append("】\t").append(satisfaction.getRemark());
            reptc.setTc088(remark.toString());
            reptcBean.update(reptc);
            //如果服务及产品满意度都小于4，则企业微信通知其上级
            if (Integer.valueOf(satisfaction.getProduct()) < 4 && Integer.valueOf(satisfaction.getService()) < 4) {
                StringBuffer msg = new StringBuffer("【上海汉钟】").append(satisfaction.getMaintainerId()).append("-").append(satisfaction.getMaintainer());
                msg.append("的维修单（").append(satisfaction.getMaintainType()).append("-").append(satisfaction.getMaintainNumber()).append(")");
                msg.append("。服务满意度:").append(satisfaction.getService()).append("。产品满意度:").append(satisfaction.getProduct()).append("。请协助回访！");
                SystemUser user = userBean.findByUserId(satisfaction.getMaintainerId());
                wartaBean.sendMsgString(user.getManagerId(), msg.toString(), satisfaction.getSessionKey(), satisfaction.getOpenID());
            }
            ResponseMessage message = new ResponseMessage("200", "success");
            return message;
        } catch (Exception e) {
            ResponseMessage message = new ResponseMessage("500", "fail");
            return message;
        }
    }
}
