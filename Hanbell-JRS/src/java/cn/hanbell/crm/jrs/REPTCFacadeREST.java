/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.app.REPTCApplication;
import cn.hanbell.crm.app.REPTDApplication;
import cn.hanbell.crm.ejb.CMSMVBean;
import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.ejb.REPMFBean;
import cn.hanbell.crm.ejb.REPPWBean;
import cn.hanbell.crm.ejb.REPTABean;
import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.ejb.REPTDBean;
import cn.hanbell.crm.ejb.SENDMSGBean;
import cn.hanbell.crm.ejb.SERCABean;
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
import cn.hanbell.crm.entity.WARTA;
import cn.hanbell.crm.entity.WARTAPK;
import cn.hanbell.crm.entity.WARTB;
import cn.hanbell.crm.entity.WARTBPK;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author C2082
 */
@Path("crm/reptc")
@javax.enterprise.context.RequestScoped
public class REPTCFacadeREST extends SuperRESTForCRM<REPTC> {

    private final org.apache.logging.log4j.Logger log4j = LogManager.getLogger();
    @EJB
    protected cn.hanbell.oa.ejb.WorkFlowBean workFlowBean;
    @EJB
    private SENDMSGBean sendmsgbean;

    @EJB
    private SystemUserBean userbean;
    @EJB
    private CMSMVBean cmsmvbean;
    @EJB
    private REPTCBean reptcbean;

    @EJB
    private REPTABean reptabean;
    @EJB
    private REPPWBean reppwbean;

    @EJB
    private CRMGGBean crmggbean;

    @EJB
    private SERCABean sercabean;

    @EJB
    private REPTDBean reptdbean;

    @EJB
    private WARTABean wartabean;

    @EJB
    private WARTBBean wartbbean;
    @EJB
    private REPMFBean repmfbean;

    public REPTCFacadeREST() {
        super(REPTC.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    @Path("wechat/createMaintain")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage createMaintain(REPTCApplication reptcapplication, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            String seal = reptcbean.getTC002ByTC001AndDate(reptcapplication.getMaintainTypeId(), new Date());
            StringBuffer msg = new StringBuffer("【汉钟精机】 维修单号:");
            String serializableNumber = wartabean.getTA002ByTA001AndDate(reptcapplication.getIncentoryform(), new Date());
            msg = msg.append(seal).append("库存异动单号:" + serializableNumber);
            try {
                Date date;
                date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                REPTC reptc = new REPTC();
                REPTCPK reptcpk = new REPTCPK();
                reptcpk.setTc001(reptcapplication.getMaintainTypeId());//维修单别
                reptcpk.setTc002(seal);//维修单号
                reptc.setCompany("CRMDB");
                reptc.setCreator(reptcapplication.getEmployeeId());
                reptc.setUsrGroup(reptcapplication.getDeptId());
                reptc.setCreateDate(simpleDateFormat.format(new Date()));
                reptc.setFlag(new Short("1"));
                reptc.setREPTCPK(reptcpk);
                reptc.setTc003(simpleDateFormat.format(new Date()));
                reptc.setTc005(reptcapplication.getRepairKindId());//叫修单别
                reptc.setTc006(reptcapplication.getRepairno());//叫修单号
                reptc.setTc007(reptcapplication.getCustomer());//客户   
                //叫修单信息
                REPTA repta = reptabean.findByPK(reptcapplication.getRepairKindId(), reptcapplication.getRepairno());
                reptc.setTc008(repta.getTa005());
                reptc.setTc009(repta.getTa006());
                reptc.setTc010(repta.getTa007());
                reptc.setTc011(repta.getTa009());
                reptc.setTc012(repta.getReceiver().getMv004());//部门
                reptc.setTc013(repta.getTa010());
                reptc.setTc014(repta.getTa011());
                reptc.setTc015(repta.getTa012());
                reptc.setTc016(reptcapplication.getMaintainer());//维修人员
                SystemUser user = userbean.findByUserId(reptc.getTc016());
                reptc.setTc017(user.getDeptno());//维修人员部门/站别
                reptc.setTc018("1");
                reptc.setTc023(repta.getTa017());
                reptc.setTc056(repta.getTa051());//紧急度
                reptc.setTc058(repta.getTa013());//产品序号
                reptc.setTc034("N");
//            reptc.setTc035(reptcapplication.getDeptId());
                reptc.setTc035(user.getDeptno());
                //客户厂商信息
                CRMGG crmgg = crmggbean.findByERPCusno(reptcapplication.getCustomer());
                reptc.setTc036(crmgg.getGg004());
                reptc.setTc037(crmgg.getGg101());
                reptc.setTc038(crmgg.getGg030());
                reptc.setTc039(crmgg.getGg089());
                reptc.setTc040(crmgg.getGg096());
                reptc.setTc041(crmgg.getGg097());
                reptc.setTc042("N");
                reptc.setTc045(BaseLib.formatDate("yyyyMM", new Date()));
                reptc.setTc048("N");
                reptc.setTc051(crmgg.getGg098());
                reptc.setTc063(repta.getTa055());
                reptc.setTc064(repta.getTa056());//保固开始日期
                reptc.setTc065(repta.getTa057());//保固结束日期
                reptc.setTc066(BigDecimal.TEN);//维修数量（###）
                reptc.setTc069(repta.getTa062());
                reptc.setTc070(repta.getTa063());
                reptc.setTc074(repta.getTa068());
                reptc.setTc077(repta.getTa071());
                reptc.setTc198(repta.getTa198());
                reptc.setTc199(repta.getTa199());
                String serca = sercabean.findByAC010AndAC011(reptcapplication.getRepairKindId(), reptcapplication.getRepairno());//获得客诉单号
                reptc.setTc054(serca);
                reptc.setCustomer(reptcapplication.getCustomer());//客户ID
                reptc.setProduct(repta.getTa197());//产品
                reptc.setProduct(repta.getTa198());//区域
                reptc.setTc197(repta.getTa197());//产品
                REPTD reptd = null;//维修单明细
                REPTDPK reptdpk;//维修单名字联合主键
                //异动库存单，产生维修单明细同时产生异动库存明细
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
                    reptdpk.setTd001(reptcapplication.getMaintainTypeId());//维修单别
                    reptdpk.setTd002(seal);//维修单号
                    reptd.setREPTDPK(reptdpk);
                    String serl = reptdbean.getTD003ByTD001AndTD002(reptdpk.getTd001(), reptdpk.getTd002());
                    reptdpk.setTd003(serl);//维修单序号
                    reptd.setTd004(rept.getProductQuality());
                    reptd.setTd005(rept.getProduct_name());
                    reptd.setTd006(rept.getProductStandard());
                    reptd.setTd007(rept.getProductUnit());//单位
                    reptd.setTd008(rept.getWarehouseId());//维修人员仓库
                    reptd.setTd009(new BigDecimal(rept.getPlanMaintainCount()));//维修数量
                    reptd.setTd013("N");
                    reptd.setTd012(reptc.getTc023());//备注
                    reptd.setTd022(rept.getProductNumberId());//料件序号，即产品序号
                    reptd.setTd026("1");//类别 默认料件
                    reptd.setTd027("1");
                    reptd.setTd028("");
                    reptd.setTd031("1");
                    reptd.setTd032(new BigDecimal(rept.getPlanMaintainCount()));
                    reptd.setTd034(rept.getWarrantyStart());//开始日期
                    reptd.setTd035(rept.getWarrantyEnd());//到期日期
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
                    //异动库存单单身
                    WARTB wartb = new WARTB();
                    WARTBPK wartbpk = new WARTBPK();
                    wartb.setCompany("CRMDB");
                    wartb.setCreator(reptcapplication.getEmployeeId());
                    wartb.setUsrGroup(reptcapplication.getDeptId());
                    wartb.setCreateDate(BaseLib.formatDate("yyyyMMdd", new Date()));
                    wartb.setFlag(new Short("1"));
                    wartbpk.setTb001(wartapk.getTa001());
                    wartbpk.setTb002(serializableNumber);
                    wartbpk.setTb003(wartbbean.getDetailSerlByTA001AndTA002(wartapk.getTa001(), serializableNumber));//维修单序号，作为库存交易单序号
                    wartb.setWARTBPK(wartbpk);
                    wartb.setTb004(reptd.getTd004());
                    wartb.setTb005(reptd.getTd005());
                    wartb.setTb006(reptd.getTd006());
                    wartb.setTb007(reptd.getTd009());
                    wartb.setTb008(reptd.getTd007());
                    wartb.setTb009(reptd.getTd009());
                    wartb.setTb010(reptd.getTd008());
                    REPMF repmf = repmfbean.findByItnbr(wartb.getTb004());
                    wartb.setTb013("N");
                    wartb.setTb014(BaseLib.formatDate("yyyyMMdd", new Date()));
                    wartb.setTb015(reptdpk.getTd001());
                    wartb.setTb016(reptdpk.getTd002());
                    wartb.setTb017(reptdpk.getTd003());

                    if (repmf == null) {
                        wartb.setTb018(new BigDecimal(0));
                    } else {
                        wartb.setTb018(repmf.getMf003());//单价
                    }
                    //总金额
                    sumMoney = sumMoney.add(wartb.getTb018().multiply(wartb.getTb007()));
                    wartb.setTb027("1");
                    wartb.setTb034("0");
                    wartb.setTb042("0");
                    detailList.add(wartb);
                    reptdbean.persist(reptd);
                    wartbbean.persist(wartb);
                }
                reptcbean.persist(reptc);
                //设置当前员工的维修人员的状态为1
                List<REPPW> list = reppwbean.findByPw001AndPw002AndPW010(repta.getREPTAPK().getTa001(), repta.getREPTAPK().getTa002(), "0");
                for (REPPW r : list) {
                    if (r.getPw004().equals(reptcapplication.getMaintainer())) {
                        r.setPw010("1");
                        reppwbean.update(r);
                    }
                }
                //当完成最后一个维修人员的维修单时，反写叫修单
                if (list.size() == 1) {
                    repta.setTa031("1");
                    reptabean.update(repta);
                }

                //产生库存异动单头
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
                warta.setTa006("N");//审核状态
                warta.setTa007("b1");//一般单据
                warta.setTa008(new BigDecimal(count));//总数量
                warta.setTa009(BaseLib.formatDate("yyyyMMdd", new Date()));
                warta.setTa012(reptc.getTc016());
                CMSMV cmsmv = cmsmvbean.findById(reptc.getTc016());
                warta.setTa014(user.getDept().getCompany());//厂别
                warta.setTa020("N");
                warta.setTa023(sumMoney);
                warta.setTa030(reptc.getProduct());
                warta.setTa031(reptc.getTc197());
                warta.setTa032(reptc.getCustomer());
                warta.setTa033(reptc.getTc008());
                warta.setTa034(reptc.getTc009());
                warta.setTa035(reptc.getTc010());
                warta.setTa036(reptc.getTc058());
                warta.setTa037(reptc.getTc013());
                warta.setTa039(reptc.getTc054());
                warta.setTa040(reptc.getTc005());
                warta.setTa043(reptcapplication.getTradingreason());
                warta.setTa041(seal);
                warta.setTa519(reptcapplication.getDeliverydeptId());
                wartabean.persist(warta);
                StringBuffer userid=null;
                 userid=new StringBuffer(reptcapplication.getEmployeeId());
                //同一个人发送一条数据
                 if(!reptcapplication.getEmployeeId().equals(reptcapplication.getMaintainer())){
                     userid.append("|").append(reptcapplication.getMaintainer());
                }
                String errormsg = sendmsgbean.sendMsgString(userid.toString(), msg.toString(), reptcapplication.getSessionkey(), reptcapplication.getOpenId());
                //发送失败，抛异常，使事务回滚
                if (!"success".equals(errormsg)) {
                    throw new RuntimeException("发送失败,请联系管理员");
                }
               
                ResponseMessage responseMessage = new ResponseMessage("200", "创建成功，单号已发至企业微信，请查收!");
                System.out.println("创建成功");
                return responseMessage;
            } catch (ParseException ex) {
                ex.printStackTrace();
                log4j.info(msg);
                ResponseMessage responseMessage = new ResponseMessage("500", ex.getMessage());
                return responseMessage;
            } catch (RuntimeException ex) {
                ex.printStackTrace();
                log4j.info(msg);
                ResponseMessage responseMessage = new ResponseMessage("500", ex.getMessage());
                return responseMessage;
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
