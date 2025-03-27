/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.crm.ejb.CMSMEBean;
import cn.hanbell.crm.ejb.CMSMVBean;
import cn.hanbell.crm.entity.CMSME;
import cn.hanbell.crm.entity.CMSMV;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.crmsys.ejb.DSCMABean;
import cn.hanbell.crmsys.entity.DSCMA;
import cn.hanbell.eam.ejb.AssetAcceptanceBean;
import cn.hanbell.eam.ejb.AssetItemBean;
import cn.hanbell.eam.entity.AssetAcceptance;
import cn.hanbell.eam.entity.AssetAcceptanceDetail;
import cn.hanbell.eam.entity.AssetItem;
import cn.hanbell.eap.comm.ErrorMailNotify;
import cn.hanbell.eap.comm.MailNotify;
import cn.hanbell.eap.ejb.ErrorMailNotificationBean;
import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ApmaphBean;
import cn.hanbell.erp.ejb.ApmpyhBean;
import cn.hanbell.erp.ejb.ApmsysBean;
import cn.hanbell.erp.ejb.ApmtbilBean;
import cn.hanbell.erp.ejb.BudgetAccBean;
import cn.hanbell.erp.ejb.CdrcitnbrBean;
import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.ejb.CdrcusmanBean;
import cn.hanbell.erp.ejb.CdrcusrelBean;
import cn.hanbell.erp.ejb.CdrdmasBean;
import cn.hanbell.erp.ejb.CdrhmasBean;
import cn.hanbell.erp.ejb.CdrqhadBean;
import cn.hanbell.erp.ejb.CdrsysBean;
import cn.hanbell.erp.ejb.InvmasBean;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.ejb.MisdeptBean;
import cn.hanbell.erp.ejb.MisrateBean;
import cn.hanbell.erp.ejb.PricingUserBean;
import cn.hanbell.erp.ejb.PurachBean;
import cn.hanbell.erp.ejb.PurhaskBean;
import cn.hanbell.erp.ejb.PurvdrBean;
import cn.hanbell.erp.ejb.SecgprgBean;
import cn.hanbell.erp.ejb.SecmembBean;
import cn.hanbell.erp.ejb.SecuserBean;
import cn.hanbell.erp.entity.Apmapd;
import cn.hanbell.erp.entity.Apmaph;
import cn.hanbell.erp.entity.Apmpyh;
import cn.hanbell.erp.entity.Apmtbil;
import cn.hanbell.erp.entity.BudgetAcc;
import cn.hanbell.erp.entity.Cdrcitnbr;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Cdrcusman;
import cn.hanbell.erp.entity.Cdrcusrel;
import cn.hanbell.erp.entity.Cdrdmas;
import cn.hanbell.erp.entity.Cdrhmas;
import cn.hanbell.erp.entity.Cdrqdta;
import cn.hanbell.erp.entity.Cdrqhad;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.erp.entity.Misdept;
import cn.hanbell.erp.entity.Misrate;
import cn.hanbell.erp.entity.PricingUser;
import cn.hanbell.erp.entity.Puracd;
import cn.hanbell.erp.entity.Purach;
import cn.hanbell.erp.entity.Purhask;
import cn.hanbell.erp.entity.Purvdr;
import cn.hanbell.erp.entity.Secmemb;
import cn.hanbell.erp.entity.Secuser;
import cn.hanbell.jrs.KV;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.mes.entity.MuserRole;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKCW002Bean;
import cn.hanbell.oa.ejb.InvmasmarkBean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.HKCW002;
import cn.hanbell.oa.entity.HKCW002Detail;
import cn.hanbell.oa.entity.Invmasmark;
import cn.hanbell.oa.model.HKCW013DetailModel;
import cn.hanbell.oa.model.HKCW013Model;
import cn.hanbell.oa.model.HKYX009DetailModel;
import cn.hanbell.oa.model.HKYX009Model;
import cn.hanbell.oa.model.HZJS034DetailModel;
import cn.hanbell.oa.model.HZJS034Model;
import cn.hanbell.oa.model.SHBERPAPM811DetailModel;
import cn.hanbell.oa.model.SHBERPAPM811Model;
import cn.hanbell.plm.ejb.PLMItnbrDetailTempBean;
import cn.hanbell.plm.ejb.PLMItnbrMasterTempBean;
import cn.hanbell.plm.entity.PLMItnbrDetailTemp;
import cn.hanbell.plm.entity.PLMItnbrMasterTemp;
import cn.hanbell.util.BaseLib;
import com.lightshell.comm.SuperEJB;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import vn.hanbell.erp.entity.Purvdrrel;

/**
 *
 * @author Administrator
 */
@Path("costctrl/test")
@javax.enterprise.context.RequestScoped
public class TestFacadeREST extends SuperRESTForEFGP<KV> {

    @EJB
    private ApmsysBean apmsysBean;
    @EJB
    private ApmaphBean apmaphBean;
    @EJB
    private PurhaskBean purhaskBean;
    @EJB
    private PurachBean purachBean;
    @EJB
    private PurvdrBean purvdrBean;
    @EJB
    private ApmtbilBean apmtbilBean;
    @EJB
    private ApmpyhBean apmpyhBean;
    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private BudgetAccBean budgetaccBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private MisdeptBean misdeptBean;
    @EJB
    private SecuserBean secuserBean;
    @EJB
    private SecmembBean secmembBean;
    @EJB
    private CdrqhadBean cdrqhadBean;
    @EJB
    private CdrcusBean cdrcusBean;
    @EJB
    private PricingUserBean pricingUserBean;
    @EJB
    private SecgprgBean secgprgBean;
    @EJB
    private CdrsysBean cdrsysBean;
    @EJB
    private CdrcitnbrBean cdrcitnbrBean;
    @EJB
    private CdrcusmanBean cdrcusmanBean;
    @EJB
    private CdrcusrelBean cdrcusrelBean;
    @EJB
    private CdrdmasBean cdrdmasBean;
    @EJB
    private CdrhmasBean cdrhmasBean;
    @EJB
    private MisrateBean misrateBean;

    @EJB
    private HKCW002Bean hkcw002Bean;
    @EJB
    private UsersBean usersBean;

    @EJB
    private DSCMABean dscmaBean;
    @EJB
    private CMSMEBean cmsmeBean;
    @EJB
    private CMSMVBean cmsmvBean;

    @EJB
    private AssetItemBean assetItemBean;
    @EJB
    private AssetAcceptanceBean assetAcceptanceBean;
    @EJB
    private PLMItnbrMasterTempBean plmItnbrMasterTempBean;
    @EJB
    private PLMItnbrDetailTempBean plmItnbrDetailTempBean;
    @EJB
    private InvmasmarkBean imBean;
    @EJB
    private MailNotificationBean eapMailBean;
    @EJB
    private cn.hanbell.eap.ejb.SystemUserBean eapSystemUserBean;
    @EJB
    private cn.hanbell.hrm.ejb.DepartmentBean hrmDepartmentBean;
    @EJB
    private cn.hanbell.hrm.ejb.EmployeeBean hrmEmployeeBean;
    @EJB
    private cn.hanbell.eap.ejb.CompanyBean eapCompanyBean;
    @EJB
    private cn.hanbell.eap.ejb.DepartmentBean eapDepartmentBean;
    @EJB
    private cn.hanbell.mes.ejb.MDepartmentBean mesDepartmentBean;
    @EJB
    private cn.hanbell.mes.ejb.MUserBean mesUserBean;
    @EJB
    private cn.hanbell.mes.ejb.MuserRoleBean mesUserRoleBean;

    @EJB
    private vn.hanbell.erp.ejb.PurhadBean VHBpurhadBean;
    @EJB
    private vn.hanbell.erp.ejb.PurvdrrelBean VHBpurvdrrelBean;
    @EJB
    private kr.hanbell.erp.ejb.PurhadBean KRpurhadBean;
    @EJB
    private kr.hanbell.erp.ejb.PurvdrrelBean KRpurvdrrelBean;
    @EJB
    private tw.hanbell.exch.ejb.PurhadBean exchPurhadBean;

//    @Resource
//    private UserTransaction tran;
    public TestFacadeREST() {
        super(KV.class);
    }

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hkcw002Bean;
    }

    @POST
    @Path("checkPayda")
    @Consumes({"application/json"})
    @Produces({MediaType.APPLICATION_JSON})
    public MCResponseData checkPayda(Apmaph e) {
        try {
            String facno = e.getApmaphPK().getFacno();
            String apno = e.getApmaphPK().getApno();
            List<Apmapd> apmapdList;
            apmsysBean.setCompany(facno);
            apmaphBean.setCompany(facno);
            Apmaph aph = apmaphBean.findByPK(facno, apno, "6");

            Date payda1 = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", aph.getPayda()));
            String vdrno = aph.getVdrno();
            Date apdate = aph.getApdate();
            //Date apdate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            //Date payda2 = apmsysBean.getpurdate(facno, vdrno, apdate);
            Date payda2 = apmsysBean.getpurdate2(facno, vdrno, apdate);
            payda2 = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", payda2));
            boolean b = payda1.compareTo(payda2) == 0;
            String ls_mark = aph.getHmark();
            if (ls_mark.startsWith(facno + "AP") && b == true) {
                apmapdList = apmaphBean.findNeedThrowDetail(aph.getApmaphPK().getFacno(), aph.getApmaphPK().getApno(),
                        aph.getApmaphPK().getAptyp());
                if (apmapdList != null && !apmapdList.isEmpty()) {
                    for (Apmapd d : apmapdList) {
                        //(�����е������޶����)
                        if (d.getIvopsfs().compareTo(BigDecimal.ZERO) > 0 || d.getIvomsfs().compareTo(BigDecimal.ZERO) > 0) {
                            return new MCResponseData(MessageEnum.SUCCESS.getCode(), "*****");
                        }
                    }
                    ls_mark = "mark";
                }
            }

            System.out.println(BaseLib.formatDate("yyyy/MM/dd", payda2));

            MCResponseData res = new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            JSONObject js = new JSONObject();
            js.put("apno", apno);
            js.put("payda1", payda1);
            js.put("payda2", payda2);
            js.put("IsOK", b);
            js.put("hmark", ls_mark);
            res.setData(js);
            return res;
        } catch (Exception ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
    }

    @GET
    @Path("pur530/eam")
    @Produces({MediaType.APPLICATION_JSON})
    public MCResponseData check530() {
        System.out.println("aaaaaa");

        // 将ERP资产验收同步到EAM资产入库
        List<HKCW002Detail> hkcw002Details;
        List<HKCW002> hkcw002List = hkcw002Bean.findNotAcceptance();
        System.out.println(hkcw002List.size());
        if (hkcw002List != null && !hkcw002List.isEmpty()) {
            String[] acceptno;
            boolean flag;
            // 用于更新资产明细
            List<HKCW002Detail> editedHKCW002Detail = new ArrayList<>();
            HashMap<SuperEJB, List<?>> hkcw002DetailEdited = new HashMap<>();
            hkcw002DetailEdited.put(hkcw002Bean, editedHKCW002Detail);
            for (HKCW002 e : hkcw002List) {
                if (!e.getFacno().equals("H")) {
                    continue;
                }
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
                                if (d.getFormSerialNumber().equals("HK_CW002202406070001")) {
                                    System.out.println(d.getFormSerialNumber() + prh.getPurhaskPK().getPrno());
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
                                                    qty
                                                            = qty.add(BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
                                                } else {
                                                    qty = qty.add(acd.getOkqy1());
                                                }
                                            }
                                            for (Puracd acd : puracdList) {
                                                ai = assetItemBean.findByItemno(acd.getItnbr());
                                                if (ai == null) {
                                                    log4j.error("执行createEAMAssetAcceptanceByERPPUR530时异常,找不到件号"
                                                            + acd.getItnbr() + ",流程序号" + e.getProcessSerialNumber());
                                                    continue;
                                                }
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
                                                    aad.setAssetItem(ai);
                                                    // aad.setQty(acd.getAccqy1());
                                                    if (acd.getAccqy1().compareTo(
                                                            BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                                        // 多笔请购合并采购验收，验收数量大于申请数量，按申请数量入库
                                                        aad.setQty(
                                                                BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
                                                    } else {
                                                        aad.setQty(acd.getAccqy1());
                                                    }
                                                    aad.setUnit(ai.getUnit());
                                                    aad.setQcpass(false);
                                                    // aad.setQcqty(acd.getOkqy1());
                                                    if (acd.getOkqy1().compareTo(
                                                            BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                                        // 多笔请购合并采购验收，验收数量大于申请数量，按申请数量入库
                                                        aad.setQcqty(
                                                                BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
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
                                            System.out.println("addedDetail:size---" + addedDetail.size());
                                            if (addedDetail.size() > 0) {
                                                AssetAcceptance aa = new AssetAcceptance();
                                                aa.setCompany(purach.getPurachPK().getFacno());
                                                aa.setFormid("");
                                                aa.setFormdate(purach.getAcceptdate());
                                                aa.setVendorno(purach.getVdrno());
                                                aa.setDeptno(purach.getDepno());
                                                aa.setRemark(e.getProcessSerialNumber() + "_"
                                                        + purach.getPurachPK().getAcceptno());
                                                aa.setStatus("N");
                                                // 产生EAM资产入库
//                                                assetAcceptanceBean.initAssetAcceptance(aa, addedDetail);
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
//                                    acceptno = purachBean.findByPrno(prh.getPurhaskPK().getPrno());
//                                    e.setRelformid(Arrays.toString(acceptno));
                                }
//                                hkcw002Bean.update(e, null, hkcw002DetailEdited, null);
                            }
                        }
                    } catch (NumberFormatException ex) {
                        log4j.error("执行createEAMAssetAcceptanceByERPPUR530时异常", ex);
                    }

                }
            }
        }
        log4j.info("createEAMAssetAcceptanceByERPPUR530轮询");
        return null;
    }

    @GET
    @Path("1491/mail")
    @Consumes({"application/json"})
    @Produces({MediaType.APPLICATION_JSON})
    public MCResponseData checkMailSent(@QueryParam("userno") String userno) {
        MailNotificationBean mailBean = new MailNotificationBean();
        mailBean.getTo().clear();
        mailBean.getTo().add("C1491@hanbell.cn");
        mailBean.setMailSubject("测试发送");
        mailBean.setMailContent("测试发送邮件------ 发送：" + userno);
        mailBean.notify(new MailNotify());
        return null;
    }

    @GET
    @Path("apm811/oa")
    @Consumes({"application/json"})
    @Produces({MediaType.APPLICATION_JSON})
    public void createOASHBERPAPM811ByERPAPM811(@QueryParam("company") String company) {
        System.out.println("mail------");

        SHBERPAPM811Model hm;
        SHBERPAPM811DetailModel dm;
        List<SHBERPAPM811DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("Detail", detailList);
        try {
            apmaphBean.setCompany(company);
            purvdrBean.setCompany(company);
            apmtbilBean.setCompany(company);
            List<Apmaph> apmaphList = apmaphBean.findNeedThrow("6");
            List<Apmapd> apmapdList;
            List<String> bilnoList;
            int i;
            double sumqty;
            BigDecimal expamtfs;
            BigDecimal ratio;
            BigDecimal sumapamtfs;
            BigDecimal sumtaxfs;
            BigDecimal sumtax;
            double sumbilnum8fs;
            double sumbilnum8;
            double sumivopsfs;
            double sumivomsfs;
            if (apmaphList != null && !apmaphList.isEmpty()) {
                for (Apmaph h : apmaphList) {
                    apmapdList = apmaphBean.findNeedThrowDetail(h.getApmaphPK().getFacno(), h.getApmaphPK().getApno(),
                            h.getApmaphPK().getAptyp());
                    if (apmapdList != null && !apmapdList.isEmpty()) {
                        detailList.clear();// 清除前面的资料
                        i = 0;
                        sumqty = 0.00;
                        expamtfs = BigDecimal.ZERO;
                        ratio = BigDecimal.ONE;
                        sumapamtfs = BigDecimal.ZERO;
                        sumtaxfs = BigDecimal.ZERO;
                        sumtax = BigDecimal.ZERO;
                        sumbilnum8fs = 0.00;
                        sumbilnum8 = 0.00;
                        sumivopsfs = 0.00;
                        sumivomsfs = 0.00;
                        bilnoList = new ArrayList<>();
                        String isAttachment = "";
                        String ls_mark = "";     //备注栏位记录OA是否免签和
                        String ls_hmark = h.getHmark() == null ? "" : h.getHmark();
                        Date payda1 = cn.hanbell.util.BaseLib.getDate("yyyy/MM/dd", cn.hanbell.util.BaseLib.formatDate("yyyy/MM/dd", h.getPayda()));
                        String vdrno = h.getVdrno();
                        Date apdate = h.getApdate();
                        Date payda2 = apmsysBean.getpurdate2(company, vdrno, apdate);
                        payda2 = cn.hanbell.util.BaseLib.getDate("yyyy/MM/dd", cn.hanbell.util.BaseLib.formatDate("yyyy/MM/dd", payda2));
                        //1.SCM抛转 2.未变更付款日期且无短溢沽，免签
                        if (ls_hmark != null && ls_hmark.startsWith(company + "AP") && payda1.compareTo(payda2) == 0) {
                            ls_mark = "OA免签";
                        }
                        for (Apmapd d : apmapdList) {
                            i++;
                            dm = new SHBERPAPM811DetailModel();
                            dm.setSeq(String.valueOf(i));
                            dm.setTrapyh(d.getTrapyh());
                            dm.setAcpno(d.getAcpno());
                            dm.setSponr(d.getSponr());
                            dm.setItnbr(d.getItnbr());
                            dm.setItdsc(filterString(d.getItdsc()));
                            dm.setPric(d.getPric().toString());
                            dm.setPayqty(d.getPayqty().toString());
                            sumqty += d.getPayqty().doubleValue();
                            sumivopsfs += d.getIvopsfs().doubleValue();
                            sumivomsfs += d.getIvomsfs().doubleValue();
                            dm.setCoin(d.getCoin());
                            dm.setRatio(d.getRatio().toString());
                            ratio = d.getRatio();
                            dm.setOgdkid(d.getOgdkid());
                            dm.setBilno(d.getBilno());
                            dm.setAcpamtfs(d.getAcpamtfs().toString());
                            if (dm.getTrapyh().equals("2")) {
                                expamtfs = expamtfs.add(d.getAcpamtfs());
                            }
                            dm.setIvopsfs(d.getIvopsfs().toString());
                            dm.setIvomsfs(d.getIvomsfs().toString());
                            dm.setPreamtfs(d.getPreamtfs().toString());
                            dm.setTemamtfs(d.getTemamtfs().toString());
                            dm.setLosamtfs(d.getLosamtfs().toString());
                            dm.setComApamtfs((d.getAcpamtfs().subtract(d.getPreamtfs()).subtract(d.getTemamtfs())
                                    .add(d.getIvopsfs()).subtract(d.getIvomsfs()).subtract(d.getLosamtfs())).toString());
                            sumapamtfs
                                    = sumapamtfs.add(d.getAcpamtfs().subtract(d.getPreamtfs()).subtract(d.getTemamtfs())
                                            .add(d.getIvopsfs()).subtract(d.getIvomsfs()).subtract(d.getLosamtfs()));
                            if (d.getDmark() == null || d.getDmark().isEmpty() || d.getDmark().length() == 0
                                    || d.getDmark().equals("null")) {
                                dm.setDmark("");
                            } else {
                                dm.setDmark(d.getDmark());
                            }
                            if (d.getApdsc() == null || d.getApdsc().isEmpty() || d.getApdsc().length() == 0
                                    || d.getApdsc().equals("null")) {
                                dm.setApdsc("");
                            } else {
                                dm.setApdsc(d.getApdsc().replace('&', '/'));
                            }
                            //IsAttachment判断OA是否需要上传附件(短溢沽且非税率差)
                            if (d.getIvopsfs().compareTo(BigDecimal.ZERO) > 0 || d.getIvomsfs().compareTo(BigDecimal.ZERO) > 0) {
                                if (!d.getApdsc().contains("税率差") && !d.getApdsc().contains("税差")) {
                                    isAttachment = "Y";
                                }
                                ls_mark = ls_hmark;
                            }
                            //有加扣款的验收请款单
                            apmpyhBean.setCompany(company);
                            Apmpyh apmpyh = apmpyhBean.findByPK(company, d.getAcpno());
                            if (null == apmpyh || apmpyh.getPsamt().compareTo(apmpyh.getMsamt()) != 0) {
                                ls_mark = ls_hmark;
                            }
                            //9件号或者验收别7NK，51A
                            if ("9".equals(d.getItnbr()) || "51A".equals(d.getOgdkid()) || "7NK".equals(d.getOgdkid())) {
                                ls_mark = ls_hmark;
                            }
                            detailList.add(dm);
                            // 计算海关代徵,税额
                            if (!bilnoList.contains(d.getBilno())) {
                                bilnoList.add(d.getBilno());
                                Apmtbil apmtbil = apmtbilBean.findByPK(company, d.getBilno());
                                if (null != apmtbil) {
                                    sumtaxfs = sumtaxfs.add(apmtbil.getBiltaxfs());
                                    sumtax = sumtax.add(apmtbil.getBiltax());
                                    if ('8' == apmtbil.getBilnum()) {
                                        sumbilnum8 += apmtbil.getBiltax().doubleValue();
                                        sumbilnum8fs += apmtbil.getBiltaxfs().doubleValue();
                                    }
                                }
                            }
                        }
                        workFlowBean.initUserInfo(h.getUserno());
                        hm = new SHBERPAPM811Model();
                        hm.setFacno(h.getApmaphPK().getFacno());
                        hm.setAppdate(h.getApdate());
                        hm.setAppuser(h.getApusrno());
                        hm.setAppdept(h.getDepno());
                        hm.setAptyp(h.getApmaphPK().getAptyp());
                        hm.setVdrno(h.getVdrno());
                        //集团内部厂商免签(STW00007/STW00045/KTW00001/ETW00001) 
                        if ("STW00007".equals(h.getVdrno()) || "STW00045".equals(h.getVdrno()) || "KTW00001".equals(h.getVdrno()) || "ETW00001".equals(h.getVdrno())) {
                            ls_mark = "OA免签";
                        }
                        hm.setVdrna(h.getVdrna());
                        Purvdr purvdr = purvdrBean.findByVdrno(h.getVdrno());
                        if (null != purvdr) {
                            hm.setTickdays(purvdr.getTickdays().toString());
                        } else {
                            hm.setTickdays("0");
                        }

                        hm.setPyhyn(h.getPyhyn());
                        hm.setApno(h.getApmaphPK().getApno());
                        hm.setPaytn(h.getPaytn());
                        hm.setPaydate(BaseLib.formatDate("yyyy/MM/dd", h.getPayda()));
                        // 票据到期日 n_pur_apmlib --> uf_getpurdate
                        hm.setTerdate(BaseLib.formatDate("yyyy/MM/dd", h.getTerda()));
                        hm.setApsta(h.getApsta());
                        hm.setIndate(h.getIndate());
                        hm.setInuser(h.getUserno());
                        hm.setIsretmoney(h.getIsretmoney().toString());
                        // 表单下方合计栏位(取2位小数)
                        hm.setSum_apamtfs(sumapamtfs.setScale(2, BigDecimal.ROUND_HALF_UP));
                        hm.setSum_apamt(sumapamtfs.multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        hm.setSum_bilnum8fs((double) Math.round(sumbilnum8fs * 100) / 100);
                        hm.setSum_bilnum8((double) Math.round(sumbilnum8 * 100) / 100);
                        hm.setSum_taxfs(sumtaxfs.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                        hm.setSum_tax(sumtax.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                        hm.setTotalfs(hm.getSum_apamtfs().add(BigDecimal.valueOf(hm.getSum_taxfs()))
                                .subtract(BigDecimal.valueOf(hm.getSum_bilnum8fs())));
                        hm.setTotalfs(hm.getTotalfs().setScale(2, BigDecimal.ROUND_HALF_UP));
                        hm.setTotal(hm.getTotalfs().multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        hm.setExpamtfs(expamtfs.setScale(2, BigDecimal.ROUND_HALF_UP));
                        hm.setExpamt(expamtfs.multiply(ratio).setScale(2, BigDecimal.ROUND_HALF_UP));
                        hm.setCompute_1(sumqty);
                        hm.setSumivomsfs((double) Math.round(sumivomsfs * 100) / 100);
                        hm.setSumivopsfs((double) Math.round(sumivopsfs * 100) / 100);
                        //请款金额为0的OA免签
                        if (hm.getTotalfs().compareTo(BigDecimal.ZERO) <= 0) {
                            ls_mark = "OA免签";
                        }
                        //设定OA是否需要传附件
                        hm.setIsAttachment(isAttachment);
                        if (null == ls_mark) {
                            hm.setHmark("");
                        } else {
                            hm.setHmark(ls_mark);
                        }
                        // 构建表单实例
                        String formInstance = workFlowBean.buildXmlForEFGP("SHB_ERP_APM811", hm, details);
                        String subject = "进货请款申请单：" +hm.getFacno()+"--"+ hm.getApno() + ",厂商：" + hm.getVdrna() + ",请款天数（"
                                + hm.getTickdays() + ")," + "请款金额：" + hm.getTotal();
                            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT,
                                    "PKG_SHB_ERP_APM811", formInstance, subject);
                            String[] rm = msg.split("\\$");
                            if (rm != null) {
                                log4j.info(Arrays.toString(rm));
                            }
                            if (rm != null && rm.length == 2 && rm[0].equals("200")) {
                                // 更新ERP APM811状态
                                h.setApsta("25");
                                if ("OA免签".equals(ls_mark)) {
                                    h.setHmark(ls_hmark + ls_mark);
                                }
                                apmaphBean.update(h);
                                // apmaphBean.getEntityManager().flush();
                            }
                        }
                    }
                }
        } catch (Exception ex) {
            ex.printStackTrace();
            log4j.error(ex);
            //加入邮件通知
            eapMailBean.getTo().clear();
            eapMailBean.getTo().add("C1491@hanbell.com.cn");
            eapMailBean.setMailSubject("ERP-APM811抛转OA审批失败");
            eapMailBean.setMailContent(
                    company + "公司别 ERP-APM811抛转OA审批申请单" + "抛转失败，异常：" + ex.getCause().getMessage());
            eapMailBean.notify(new MailNotify());
        }
    }

    @GET
    @Path("apm820/oa")
    @Consumes({"application/json"})
    public void createOAHKCW013ByERPAPM820(@QueryParam("company") String company) {
        HKCW013Model hm;
        HKCW013DetailModel dm;
        List<HKCW013DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("Detail", detailList);
        try {
            apmaphBean.setCompany(company);
            purvdrBean.setCompany(company);
            List<Apmaph> apmaphList = apmaphBean.findNeedThrow("0");
            //加入APM826
            List<Apmaph> apmaph826List = apmaphBean.findNeedThrow("5");
            for (Apmaph apmh826 : apmaph826List) {
                apmaphList.add(apmh826);
            }
            List<Apmapd> apmapdList;
            int i;
            BigDecimal sumapamtfs;
            BigDecimal sumapamt;
            BigDecimal sumtaxfs;
            BigDecimal sumtax;
            BigDecimal sumbilnum8fs;
            BigDecimal sumbilnum8;
            if (apmaphList != null && !apmaphList.isEmpty()) {
                for (Apmaph h : apmaphList) {
                    apmapdList = apmaphBean.findNeedThrowDetail(h.getApmaphPK().getFacno(), h.getApmaphPK().getApno(),
                            h.getApmaphPK().getAptyp());
                    if (apmapdList != null && !apmapdList.isEmpty()) {
                        detailList.clear();// 清除前面的资料
                        i = 0;
                        sumapamtfs = BigDecimal.ZERO;
                        sumapamt = BigDecimal.ZERO;
                        sumtaxfs = BigDecimal.ZERO;
                        sumtax = BigDecimal.ZERO;
                        sumbilnum8fs = BigDecimal.ZERO;
                        sumbilnum8 = BigDecimal.ZERO;
                        List<String> bilList = new ArrayList<>();
                        for (Apmapd d : apmapdList) {
                            i++;
                            dm = new HKCW013DetailModel();
                            dm.setSeq(String.valueOf(i));
                            if (d.getApdsc() == null || d.getApdsc().isEmpty() || d.getApdsc().length() == 0
                                    || d.getApdsc().equals("null")) {
                                dm.setApdsc("");
                            } else {
                                dm.setApdsc(d.getApdsc().replace('&', '/'));
                            }
                            dm.setBilno(d.getBilno() != null ? d.getBilno() : "");
                            dm.setCoin(d.getCoin());
                            dm.setRatio(d.getRatio().toString());
                            dm.setAcpamt(d.getAcpamt());
                            dm.setAcpamtfs(d.getAcpamtfs());
                            dm.setTemamt(d.getTemamt());
                            dm.setTemamtfs(d.getTemamtfs());
                            dm.setCom_apamtfs(d.getAcpamtfs().subtract(d.getTemamtfs()));
                            dm.setCom_apamt(d.getAcpamt().subtract(d.getTemamt()));
                            // 请款合计金额
                            sumapamtfs = sumapamtfs.add(d.getApamtfs());
                            sumapamt = sumapamt.add(d.getApamt());
                            if (d.getDmark() == null || d.getDmark().isEmpty() || d.getDmark().length() == 0
                                    || d.getDmark().equals("null")) {
                                dm.setDmark("");
                            } else {
                                dm.setDmark(d.getDmark());
                            }
                            dm.setCenterid(d.getCenterid() != null ? d.getCenterid() : "");
                            miscodeBean.setCompany(company);
                            Miscode miscode = miscodeBean.findByPK("9N", dm.getCenterid());
                            if (miscode == null) {
                                dm.setCmp_centerid("");
                            } else {
                                dm.setCmp_centerid(miscode.getCdesc());
                            }
                            dm.setBudgetacc(d.getBudgetacc() != null ? d.getBudgetacc() : "");
                            budgetaccBean.setCompany(company);
                            BudgetAcc budgetacc = budgetaccBean.findByAccno(dm.getBudgetacc());
                            if (budgetacc == null) {
                                dm.setCmp_budgetacc("");
                            } else {
                                dm.setCmp_budgetacc(budgetacc.getAccname());
                            }
                            dm.setPayqty(d.getPayqty());
                            if (!bilList.contains(d.getBilno())) {
                                // 计算海关代徵,税额
                                apmtbilBean.setCompany(company);
                                Apmtbil apmtbil = apmtbilBean.findByPK(company, d.getBilno());
                                if (null != apmtbil) {
                                    sumtaxfs = sumtaxfs.add(apmtbil.getBiltaxfs());
                                    sumtax = sumtax.add(apmtbil.getBiltax());
                                    if ('8' == apmtbil.getBilnum()) {
                                        sumbilnum8 = sumbilnum8.add(apmtbil.getBiltax());
                                        sumbilnum8fs = sumbilnum8fs.add(apmtbil.getBiltaxfs());
                                    }
                                }
                                bilList.add(d.getBilno());
                            }
                            detailList.add(dm);
                        }
                        workFlowBean.initUserInfo(h.getUserno());
                        hm = new HKCW013Model();
                        hm.setFacno(h.getApmaphPK().getFacno());
                        hm.setApno(h.getApmaphPK().getApno());
                        hm.setAppdate(h.getApdate());
                        hm.setAppuser(h.getApusrno());
                        //hm.setAppdept(h.getDepno());
                        //修正人员部门不对应问题
                        hm.setAppdept(usersBean.checkDeptno(h.getApusrno(), h.getDepno()));
                        hm.setAptyp(h.getApmaphPK().getAptyp());
                        hm.setVdrno(h.getVdrno());
                        hm.setVdrna(h.getVdrna());
                        Purvdr purvdr = purvdrBean.findByVdrno(h.getVdrno());
                        if (null != purvdr) {
                            hm.setTickdays(String.valueOf(purvdr.getTickdays()));
                            hm.setBankName(purvdr.getTtbankna());
                            hm.setBankAccount(purvdr.getTtname());
                            hm.setVdrds(purvdr.getVdrds());
                            hm.setTel1(purvdr.getTel1());
                        } else {
                            hm.setTickdays("0");
                        }
                        hm.setPyhyn(h.getPyhyn());
                        hm.setPaytn(h.getPaytn());
                        hm.setPaydate(BaseLib.formatDate("yyyy/MM/dd", h.getPayda()));
                        // 票据到期日 n_pur_apmlib --> uf_getpurdate
                        hm.setTerdate(BaseLib.formatDate("yyyy/MM/dd", h.getTerda()));
                        hm.setApsta(h.getApsta());
                        hm.setIndate(h.getIndate());
                        hm.setInuser(h.getUserno());
                        if (null == h.getHmark()) {
                            hm.setHmark("");
                        } else {
                            hm.setHmark(h.getHmark());
                        }
                        // 设置默认立账参数
                        hm.setPayda(h.getPayda());
                        hm.setRkd("MR01");
                        hm.setConfig(36);
                        hm.setAccno("1123");
                        // 表单下方合计总金额栏位(取2位小数)
                        hm.setCmp_sum_tax(sumtax.setScale(2, BigDecimal.ROUND_HALF_UP));
                        hm.setTotalfs(sumapamtfs.add(sumtaxfs).subtract(sumbilnum8fs).setScale(2, BigDecimal.ROUND_HALF_UP));
                        hm.setTotal(sumapamt.add(sumtax).subtract(sumbilnum8).setScale(2, BigDecimal.ROUND_HALF_UP));
                        //大写金额
                        hm.setAmountInWords(workFlowBean.number2CNMonetaryUnit(hm.getTotal()));
                        // 构建表单实例
                        String formInstance = workFlowBean.buildXmlForEFGP("HK_CW013", hm, details);
                        String subject = "费用类请款申请：" + hm.getApno() + ",厂商：" + hm.getVdrna() + ",请款金额：" + hm.getTotal();
                        String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT,
                                "PKG_HK_CW013", formInstance, subject);
                        String[] rm = msg.split("\\$");
                        if (rm != null) {
                            log4j.info(Arrays.toString(rm));
                        }
                        if (rm != null && rm.length == 2 && rm[0].equals("200")) {
                            // 更新ERP APM820状态
                            h.setApsta("25");
                            h.setOano(rm[1]);
                            apmaphBean.update(h);
                            apmaphBean.getEntityManager().flush();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            log4j.error(ex);
        }
    }

    @GET
    @Path("cdrqhad/oa")
    @Consumes({"application/json"})
    public void createOAHKYX009ByERPCDR220(@QueryParam("company") String company) {
        HKYX009Model hm;
        HKYX009DetailModel dm;
        List<HKYX009DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("Detail", detailList);
        try {
            cdrqhadBean.setCompany(company);
            List<Cdrqhad> cdrqhadList = cdrqhadBean.findNeedThrow();
            List<Cdrqdta> cdrqdtaList;
            String facno;
            String quono;
            String oilspecial = "";
            int i;
            if (cdrqhadList != null && !cdrqhadList.isEmpty()) {
                for (Cdrqhad h : cdrqhadList) {
                    facno = h.getCdrqhadPK().getFacno();
                    quono = h.getCdrqhadPK().getQuono();
                    cdrqdtaList = cdrqhadBean.findNeedThrowDetail(facno, quono);
                    cdrcusBean.setCompany(facno);
                    invmasBean.setCompany(facno);
                    miscodeBean.setCompany(facno);
                    secuserBean.setCompany(facno);
                    if (cdrqdtaList != null && !cdrqdtaList.isEmpty()) {
                        detailList.clear();// 清除前面的资料
                        i = 0;
                        for (Cdrqdta d : cdrqdtaList) {
                            i++;
                            dm = new HKYX009DetailModel();
                            dm.setSeq(String.valueOf(i));
                            dm.setTrseq(String.valueOf(d.getCdrqdtaPK().getTrseq()));
                            dm.setItnbr(d.getItnbr());
                            dm.setItnbrcus(d.getItnbrcus());
                            Invmas invmas = invmasBean.findByItnbr(d.getItnbr());
                            dm.setItdsc(filterString(invmas.getItdsc()));
                            dm.setSpdsc(filterString(invmas.getSpdsc()));
                            dm.setQuaqy1(d.getQuaqy1().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            dm.setUnpris(d.getUnpris().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            if (d.getListunpri() != null) {
                                dm.setLastunpri(d.getListunpri().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            } else {
                                dm.setLastunpri("0");
                            }
                            if (d.getHisorders() != null) {
                                dm.setOrderqty(d.getHisorders().toString());
                            } else {
                                dm.setOrderqty("0");
                            }
                            dm.setTramts(d.getTramts().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            if (d.getCdrdate() != null) {
                                dm.setCdrdate(BaseLib.formatDate("yyyy/MM/dd", d.getCdrdate()));
                            } else {
                                dm.setCdrdate(BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
                            }
                            if (null == d.getQxb()) {
                                dm.setPeratio("");
                            } else {
                                dm.setPeratio(d.getQxb());
                            }
                            dm.setRefmodel("");
                            dm.setRefratio("");
                            if (d.getDiffprice() != null) {
                                dm.setDiffitting(d.getDiffprice().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            } else {
                                dm.setDiffitting("0");
                            }
                            //服务部需求油品特殊流程
                            if (d.getItnbr().startsWith("52001-")) {
                                oilspecial = "Y";
                            }
                            detailList.add(dm);
                        }
                        hm = new HKYX009Model();
                        hm.setFacno(facno);
                        hm.setQuono(quono);
                        hm.setQuodate(h.getQuodate());
                        hm.setCfmdate(h.getCfmdate());
                        hm.setIsspecial(h.getIsspecial());
                        hm.setPricingtype(h.getPricingtype());
                        hm.setQuotype(h.getQuotype().toString());
                        Miscode miscode = miscodeBean.findByPK("1C", h.getPricingtype());
                        hm.setPricingtypedsc(miscode.getCdesc());
                        hm.setCoin(h.getCoin());
                        hm.setRatio(h.getRatio().doubleValue());
                        hm.setLevelp(h.getLevelp());
                        hm.setCusno(h.getCusno());
                        Cdrcus cdrcus = cdrcusBean.findByCusno(h.getCusno());
                        hm.setCusna(cdrcus.getCusna());
                        hm.setMancode(h.getMancode());
                        //服务部需求带出定价群组Pricinguser
                        hm.setPricgroup("");
                        pricingUserBean.setCompany("C");
                        PricingUser pu = pricingUserBean.findByPricingtypeAndUserid(h.getPricingtype(), h.getCusno());
                        if (null != pu) {
                            Miscode mis = miscodeBean.findByPK("1D", pu.getPricingUserPK().getGroupid());
                            hm.setPricgroup(mis.getCdesc());
                        }
                        hm.setOilspecial(oilspecial);
                        Secuser secuser = secuserBean.findByUserno(h.getMancode());
                        hm.setMancodesc(secuser.getUsername());
                        // hm.setDepno(workFlowBean.getCurrentUser().getDeptno());
                        hm.setDepno(h.getDepno()); // 报价部门
                        hm.setCfmuser(h.getCfmuserno());
                        // 设置审批原因
                        hm.setApprresno(miscodeBean.findByPK("1O", h.getApprresno()).getCdesc());
                        // 加入付款条件叙述
                        hm.setPaycodedsc(h.getPaycodedsc());
                        hm.setTotamts(h.getTotamts().doubleValue());
                        workFlowBean.initUserInfo(h.getUserno());
                        // 构建表单实例
                        String formInstance = workFlowBean.buildXmlForEFGP("HK_YX009", hm, details);
                        String subject = "客户:" + hm.getCusna() + "申请原因： " + hm.getApprresno() + ".  业务员:"
                                + hm.getMancode() + hm.getMancodesc();
                        String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT,
                                "PKG_HK_YX009", formInstance, subject);
                        String[] rm = msg.split("\\$");
                        if (rm != null) {
                            log4j.info(h.getCdrqhadPK().getQuono());
                            log4j.info(Arrays.toString(rm));
                        }
                        if (rm != null && rm.length == 2 && rm[0].equals("200")) {
                            // 更新ERP CDR220状态
                            h.setHquosta('O');
                            cdrqhadBean.setCompany(facno);
                            cdrqhadBean.update(h);
                            cdrqhadBean.getEntityManager().flush();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            log4j.error(ex);
        }
    }

    @GET
    @Path("plm/oa")
    @Consumes({"application/json"})
//    @Transactional
    public void createOAHZJS034ByPLM() {
        String formInstance = "";
        try {
            HZJS034Model m;
            HZJS034DetailModel d;
            List<HZJS034DetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("Detail", detailList);

            List<PLMItnbrDetailTemp> plmDetailList;
            List<PLMItnbrMasterTemp> plmMasterList = plmItnbrMasterTempBean.findNeedThrow();
            if (plmMasterList != null && !plmMasterList.isEmpty()) {
                boolean fromTHB;
                int i, j;
                String k;
                //获取件号分类2规则
                List<Invmasmark> genre2Map;
                genre2Map = imBean.findAll();
                for (PLMItnbrMasterTemp pm : plmMasterList) {
                    fromTHB = pm.getCProno().equals("A") || pm.getCProno().equals("B");
                    plmDetailList = plmItnbrMasterTempBean.findNeedThrowDetail(pm.getItemNumber());
                    if (plmDetailList != null && !plmDetailList.isEmpty()) {
                        invmasBean.setCompany(pm.getCProno());
                        List<Invmas> stopList = new ArrayList<>();
                        detailList.clear();// 清除前面的资料
                        i = 0;
                        for (PLMItnbrDetailTemp pd : plmDetailList) {
                            i++;
                            d = new HZJS034DetailModel();
                            d.setSeq(String.valueOf(i));
                            d.setItcls("");
                            d.setClsdsc("");
                            j = pd.getCItnbr().indexOf("-");
                            k = pd.getCItnbr().substring(0, 1);
                            if (j == 4 && (k.equals("1") || k.equals("2") || k.equals("3"))) {
                                // 1,2,3字头前面是4码，加入中间3字码
                                d.setItnbr(pd.getCItnbr().substring(0, 2) + "3" + pd.getCItnbr().substring(2));
                            } else {
                                d.setItnbr(pd.getCItnbr());
                            }
                            d.setItdsc(pd.getCItdsc().replace('&', '/'));
                            d.setSpdsc(pd.getCSpdsc().replace('&', '/'));
                            d.setEitdsc(pd.getCEitdsc().replace('&', '/'));
                            d.setEspdsc(pd.getCEspdsc().replace('&', '/'));
                            d.setKind("1");
                            d.setMorpcode("P");
                            d.setUnmsr1(pd.getC_unmsr());
                            d.setUnmsr1e(pd.getUnmsre());
                            d.setUnmsr2("");
                            d.setIsDUnit("N");
                            d.setYt("");
                            d.setRemark("");
                            d.setGenre2("");
                            d.setGenre3("");
                            //invmasmark 分类2/分类3对应件号规则自动带出20230519
                            for (Invmasmark im : genre2Map) {
                                if (d.getItnbr().contains(im.getGrpcode())) {
                                    d.setGenre2(im.getGenre2());
                                    d.setGenre3(im.getGenre3());
                                    continue;
                                }
                            }
                            d.setModelDsc1("");
                            d.setModelDsc2("");
                            detailList.add(d);

                            //加入工程变更通知单作废变更前件号逻辑
                            String ecitnbr = pd.getEcItnbr();
                            if (null != ecitnbr && !"".equals(ecitnbr) && pd.getCStopyn() == 'N') {
                                Invmas item = invmasBean.findByItnbr(ecitnbr);
                                if (item != null) {
                                    item.setItdsc("#" + item.getItdsc());
                                    item.setStopyn("AAAAAAAAAAAAA");
                                    item.setNStopyn("N");
                                    item.setNEcnnewitnbr(pd.getCItnbr());
                                    item.setNEcnno(pd.getItemNumber());
                                    stopList.add(item);
                                    //刷新中间表表身停用状态
                                    pd.setCStopyn('Y');
                                    plmItnbrDetailTempBean.update(pd);
                                }
                            }
                        }
                        m = new HZJS034Model();
                        if (fromTHB) {
                            //workFlowBean.initUserInfo("C1526");// THB申请的品号转入SHB暂时由唐倩处理
                            //ec_worker ECN指配承办
                            workFlowBean.initUserInfo(pm.getEcWorker());
                            m.setFacno(pm.getEcWorker().substring(0, 1));  //设置承办人发起公司别
                        } else {
                            workFlowBean.initUserInfo(pm.getCApplicant()); //上海厂开单人
                            m.setFacno(pm.getCProno());
                        }
                        m.setEmpl(workFlowBean.getCurrentUser().getId());
                        m.setDept(workFlowBean.getUserFunction().getOrganizationUnit().getId());
                        m.setIndate(com.lightshell.comm.BaseLib.getDate());
                        m.setPLMNO(pm.getItemNumber());
                        formInstance = workFlowBean.buildXmlForEFGP("HZ_JS034", m, details);
                        String subject = "PLM件号申请_" + pm.getItemNumber();
                        if (fromTHB) {
                            subject += "_THB";
                        }
                        String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT,
                                "HZ_JS034", formInstance, subject);
                        String[] rm = msg.split("\\$");
                        if (rm != null) {
                            log4j.info(Arrays.toString(rm));
                        }
                        if (rm != null && rm.length == 2 && rm[0].equals("200")) {
                            // 更新PLM状态
                            pm.setCTriggerYn('Y');
                            plmItnbrMasterTempBean.update(pm);
                            plmItnbrMasterTempBean.getEntityManager().flush();
                        }
                        if (!stopList.isEmpty()) {
                            invmasBean.update(stopList);
                            invmasBean.getEntityManager().flush();
                            if (pm.getCProno().equals("C")) {
                                invmasBean.setCompany("G");
                                invmasBean.update(stopList);
                                invmasBean.getEntityManager().flush();
                                invmasBean.setCompany("J");
                                invmasBean.update(stopList);
                                invmasBean.getEntityManager().flush();
                                invmasBean.setCompany("N");
                                invmasBean.update(stopList);
                                invmasBean.getEntityManager().flush();
                                invmasBean.setCompany("C4");
                                invmasBean.update(stopList);
                                invmasBean.getEntityManager().flush();
                            }
                        }

                    } else {
                        //如果表头有数据，表身无，则刷新表头状态为已抛‘Y’
                        PLMItnbrMasterTemp plmt = plmItnbrMasterTempBean.findByItemNumber(pm.getItemNumber());
                        if (null != plmt) {
                            plmt.setCTriggerYn('Y');
                            plmItnbrMasterTempBean.update(plmt);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log4j.error("PLM件号抛转轮询时异常", ex);
        }
    }

    @GET
    @Path("hrm/eap")
    @Consumes({"application/json"})
//    @Transactional
    public void TestSyncOrganizationByHRM() {
        try {
            // 同步部门
            log4j.info("syncOrganizationByHRM开始");
            List<cn.hanbell.hrm.entity.Department> departmentList = hrmDepartmentBean.findAll();
            if (departmentList != null && !departmentList.isEmpty()) {
                departmentList.forEach((hd) -> {
                    // EAP
                    cn.hanbell.eap.entity.Department ep = null;
                    cn.hanbell.hrm.entity.Department hp = hrmDepartmentBean.findByDepartmentId(hd.getParentId());
                    if (hp != null) {
                        ep = eapDepartmentBean.findByDeptno(hp.getCode());
                    }
                    cn.hanbell.eap.entity.Department ed = eapDepartmentBean.findByDeptno(hd.getCode());
                    if (ed == null) {
                        ed = new cn.hanbell.eap.entity.Department();
                        ed.setCompany(workFlowBean.getCompanyByDeptId(hd.getCode()));
                        ed.setDeptno(hd.getCode());
                        ed.setDept(hd.getName());
                        if (ep != null) {
                            ed.setParentDept(ep);
                        }
                        if (hd.getFlag()) {
                            ed.setStatus("N");
                        } else {
                            ed.setStatus("X");
                        }
                        ed.setCreatorToSystem();
                        ed.setCredateToNow();
//                        eapDepartmentBean.persist(ed);
                    } else {
                        if (!ed.getDept().equals(hd.getName()) || !Objects.equals(ed.getParentDept(), ep)
                                || (ed.getOptdate() != null && ed.getOptdate().before(hd.getLastModifiedDate()))) {
                            ed.setDept(hd.getName());
                            if (ep != null) {
                                ed.setParentDept(ep);
                            }
                            if (!hd.getFlag()) {
                                ed.setStatus("X");
                            } else {
                                ed.setStatus("N");
                            }
                            ed.setOptuserToSystem();
                            ed.setOptdate(hd.getLastModifiedDate());
//                            eapDepartmentBean.update(ed);
                        }
                    }
                    String d = hd.getCode().substring(0, 1);
                    // CRM
                    if (d.equals("1") || d.equals("5")) {
                        CMSME cd = cmsmeBean.findById(hd.getCode());
                        if (cd == null) {
                            cd = new CMSME();
                            cd.setMe001(hd.getCode());
                            cd.setMe002(hd.getName());
                            cd.setFlag((short) 1);
                            cd.setCreator("CRMDS");
                            cd.setUsrGroup("0000");
                            cd.setCreateDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
                            cmsmeBean.persist(cd);
                        } else {
                            if (!cd.getMe002().equals(hd.getName())) {
                                cd.setMe002(hd.getName());
                                cd.setModifier("CRMDS");
                                cd.setModiDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
                                cmsmeBean.update(cd);
                            }
                        }
                    }
                    // MES
                    if (d.equals("1")) {
                        cn.hanbell.mes.entity.MDepartment md = mesDepartmentBean.findByDepartmentid(hd.getCode());
                        if (md == null) {
                            md = new cn.hanbell.mes.entity.MDepartment();
                            md.setSysid(com.lightshell.comm.BaseLib.formatDate("yyyyMMddHHmmss", com.lightshell.comm.BaseLib.getDate()));
                            md.setDepartmentid(hd.getCode());
                            md.setDepartmentname(hd.getName());
                            if (hp != null) {
                                md.setPdepartmentid(hp.getCode());
                            }
                            md.setSequences(hd.getCode());
                            md.setModifyuser("HRM");
                            md.setModifytime(com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", hd.getLastModifiedDate()));
//                            mesDepartmentBean.persist(md);
                        } else {
                            boolean flag = false;
                            if (!md.getDepartmentname().equals(hd.getName())) {
                                md.setDepartmentname(hd.getName());
                                flag = true;
                            }
                            if (hp != null && !hp.getCode().equals(md.getPdepartmentid())) {
                                md.setPdepartmentid(hp.getCode());
                                flag = true;
                            }
                            if (flag) {
                                md.setModifyuser("HRM");
                                md.setModifytime(com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", hd.getLastModifiedDate()));
//                                mesDepartmentBean.update(md);
                            }
                        }
                    }
                });
            }
            log4j.info("syncOrganizationByHRM,同步EAP/CRM/MES部门资料结束");
            // 同步人员
            List<cn.hanbell.hrm.entity.Employee> employeeList = hrmEmployeeBean.findByLastModifiedDate(
                    com.lightshell.comm.BaseLib.getDate("yyyy-MM-dd", com.lightshell.comm.BaseLib.formatDate("yyyy-MM-dd", com.lightshell.comm.BaseLib.getDate())));

            if (employeeList != null && !employeeList.isEmpty()) {
                employeeList.forEach((e) -> {
                    boolean flag = false;
                    cn.hanbell.hrm.entity.Employee manager = hrmEmployeeBean.findByEmployeeId(e.getDirectorId());
                    String company = e.getCode().substring(0, 1);
                    if ("C".equals(company) || "K".equals(company) || "E".equals(company) || "H".equals(company)
                            || "Y".equals(company) || "Q".equals(company) || "V".equals(company) || isTWEmployee(company)) {
                        // EAP
                        cn.hanbell.eap.entity.SystemUser eu = eapSystemUserBean.findByUserId(e.getCode());
                        if (eu == null) {
                            eu = new cn.hanbell.eap.entity.SystemUser();
                            eu.setUserid(e.getCode());
                            eu.setUsername(e.getCnName());
                            if (e.getJob() != null) {
                                eu.setJobCode(e.getJob().getCode());
                                eu.setJob(e.getJob().getName());
                            }
                            if (e.getPosition() != null) {
                                eu.setPositionCode(e.getPosition().getCode());
                                eu.setPosition(e.getPosition().getName());
                            }
                            if (e.getEmployeeType() != null) {
                                eu.setType(e.getEmployeeType().getScName());
                            }
                            eu.setLevelId(e.getLevelId());
                            if (e.getDecisionlevelInfo() != null) {
                                eu.setDecisionLevel(e.getDecisionlevelInfo().getInfoCode());
                            }
                            eu.setDeptno(e.getDepartment().getCode());
                            if (manager != null) {
                                eu.setManagerId(manager.getCode());
                            }
                            if (e.getTelephone() != null) {
                                eu.setTel(e.getTelephone());
                            }
                            eu.setPhone(e.getMobilePhone());
                            eu.setEmail(e.getEmail());
                            eu.setCreatorToSystem();
                            eu.setCredateToNow();
                            eu.setOptdate(eu.getCredate());
                            eu.setBirthdayDate(e.getBirthDate());
                            eu.setWorkingAgeBeginDate(e.getWorkingAgeBeginDate());
                            // HR中已离职
                            if (e.getLastModifiedDate().compareTo(e.getLastWorkDate()) != -1) {
                                eu.setSyncWeChatStatus("X");
                                eu.setSyncWeChatDate(e.getLastModifiedDate());
                                eu.setStatus("X");
                                eu.setTel("");
                                eu.setOptuserToSystem();
                                eu.setOptdate(e.getLastModifiedDate());
                                eu.setBirthdayDate(null);
                                eu.setWorkingAgeBeginDate(null);
                            }
//                            eapSystemUserBean.persist(eu);
                        } else {
                            if (eu.getOptdate() != null && eu.getOptdate().before(e.getLastModifiedDate())) {
                                eu.setUsername(e.getCnName());
                                if (e.getJob() != null) {
                                    eu.setJobCode(e.getJob().getCode());
                                    eu.setJob(e.getJob().getName());
                                }
                                if (e.getPosition() != null) {
                                    eu.setPositionCode(e.getPosition().getCode());
                                    eu.setPosition(e.getPosition().getName());
                                }
                                if (e.getEmployeeType() != null) {
                                    eu.setType(e.getEmployeeType().getScName());
                                }
                                eu.setLevelId(e.getLevelId());
                                if (e.getDecisionlevelInfo() != null) {
                                    eu.setDecisionLevel(e.getDecisionlevelInfo().getInfoCode());
                                }
                                if (e.getTelephone() != null) {
                                    eu.setTel(e.getTelephone());
                                }
                                eu.setDeptno(e.getDepartment().getCode());
                                if (manager != null) {
                                    eu.setManagerId(manager.getCode());
                                }
                                //复职的情况下需要把eap数据库中人员状态从X变成N,为了后续企业微信的更新，设置更新企业微信的状态。
                                if (eu.getStatus().equals("X") && e.getLastModifiedDate().before(e.getLastWorkDate())) {
                                    eu.setStatus("N");
                                    eu.setOptuserToSystem();
                                    eu.setSyncWeChatDate(null);
                                    eu.setSyncWeChatStatus("");
                                }
                                eu.setBirthdayDate(e.getBirthDate());
                                eu.setWorkingAgeBeginDate(e.getWorkingAgeBeginDate());
                                eu.setPhone(e.getMobilePhone());
                                eu.setEmail(e.getEmail());
                                eu.setOptuserToSystem();
                                eu.setOptdate(e.getLastModifiedDate());
                                flag = true;
                            }
                            if (!eu.getStatus().equals("X") && e.getLastModifiedDate().compareTo(e.getLastWorkDate()) != -1) {
                                eu.setStatus("X");
                                eu.setOptuserToSystem();
                                eu.setOptdate(e.getLastModifiedDate());
                                eu.setBirthdayDate(null);
                                eu.setWorkingAgeBeginDate(null);
                                flag = true;
                            }
                            if (flag) {
//                                eapSystemUserBean.update(eu);
                            }
                        }
                        // 台湾人员,越南不更新ERP
                        if (isTWEmployee(company) == false && !company.startsWith("V")) {
                            // ERP
                            miscodeBean.setCompany(company);
                            misdeptBean.setCompany(company);
                            secmembBean.setCompany(company);
                            secuserBean.setCompany(company);
                            Secuser erpuser = secuserBean.findByUserno(e.getCode());
                            Misdept erpdept = misdeptBean.findByDepno(e.getDepartment().getCode());
                            if (erpdept == null) {
                                // 增加部门
                                erpdept = new Misdept(company, e.getDepartment().getCode());
                                erpdept.setDepname(e.getDepartment().getName());
                                erpdept.setUplevel("/");
                                erpdept.setChildren(0);
//                                misdeptBean.persist(erpdept);
                                // 加入miscode类别GE中
//                                miscodeBean.persistIfNotExist("GE", erpdept.getMisdeptPK().getDepno(),
//                                        erpdept.getDepname(), 'N');
                            }
                            if (erpuser != null) {
                                Secmemb secmemb
                                        = secmembBean.findByPK(company, e.getDepartment().getCode(), e.getCode());
                                if (secmemb == null) {
                                    // 人员加入部门
                                    secmemb = new Secmemb(company, e.getDepartment().getCode(), e.getCode());
                                    secmemb.setSupvisor('N');
                                    secmemb.setAuth('N');
                                    secmembBean.persist(secmemb);
                                }
                                erpuser.setPdepno(e.getDepartment().getCode());
//                                secuserBean.update(erpuser);
                            }
                        }
                    }
                    if ("C".equals(company) || "K".equals(company)) {
                        // CRM
                        DSCMA cu = dscmaBean.findById(e.getCode());
                        CMSMV cuDept = cmsmvBean.findById(e.getCode());
                        if (cu == null) {
                            cu = new DSCMA();
                            cu.setMa001(e.getCode());
                            cu.setMa002(e.getCnName());
                            cu.setFlag((short) 1);
                            cu.setCreator("CRMDS");
                            cu.setUsrGroup("0000");
                            cu.setCreateDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
//                            dscmaBean.persist(cu);
                        }
                        if (cuDept == null) {
                            cuDept = new CMSMV();
                            cuDept.setMv001(e.getCode());
                            cuDept.setMv002(e.getCnName());
                            cuDept.setMv004(e.getDepartment().getCode());
                            cuDept.setFlag((short) 1);
                            cuDept.setCreator("CRMDS");
                            cuDept.setUsrGroup("0000");
                            cuDept.setCreateDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
//                            cmsmvBean.persist(cuDept);
                        } else {
                            if (!cuDept.getMv004().equals(e.getDepartment().getCode())) {
                                cuDept.setMv004(e.getDepartment().getCode());
                                cuDept.setModifier("CRMDS");
                                cuDept.setModiDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
//                                cmsmvBean.update(cuDept);
                            }
                        }
                    }
                    if ("C".equals(company) || "K".equals(company)) {
                        // MES
                        cn.hanbell.mes.entity.MUser mu = mesUserBean.findByUserid(e.getCode());
                        if (mu == null) {
                            mu = new cn.hanbell.mes.entity.MUser();
                            mu.setUserid(e.getCode());
                            mu.setUsername(e.getCnName());
                            // 设置默认初始密码为123456
                            mu.setPassword("B37EE351B8753658");
                            mu.setStatus("Y");
                            mu.setDepartmentid(e.getDepartment().getCode());
                            mu.setEmail(e.getEmail());
                            mu.setModifyuser("HRM");
                            mu.setModifytime(com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", e.getLastModifiedDate()));
//                            mesUserBean.persist(mu);
                            // 加入mes初始权限
                            MuserRole mur1 = new MuserRole(mu.getUserid(), "CS", "QCUSER");
                            MuserRole mur2 = new MuserRole(mu.getUserid(), "CS", "QZUSER");
                            MuserRole mur3 = new MuserRole(mu.getUserid(), "BS", "WEBUSER");
                            MuserRole mur4 = new MuserRole(mu.getUserid(), "BS", "UQFUSER");
//                            mesUserRoleBean.persist(mur1);
//                            mesUserRoleBean.persist(mur2);
//                            mesUserRoleBean.persist(mur3);
//                            mesUserRoleBean.persist(mur4);
                        } else {
                            flag = false;
                            if (!mu.getDepartmentid().equals(e.getDepartment().getCode())) {
                                mu.setDepartmentid(e.getDepartment().getCode());
                                mu.setEmail(e.getEmail());
                                mu.setModifyuser("HRM");
                                mu.setModifytime(com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", e.getLastModifiedDate()));
                                flag = true;
                            }
                            if (e.getLastModifiedDate().compareTo(e.getLastWorkDate()) != -1) {
                                mu.setStatus("N");
                                mu.setModifyuser("HRM");
                                mu.setModifytime(com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", e.getLastModifiedDate()));
                                flag = true;
                            }
                            if (flag) {
//                                mesUserBean.update(mu);
                            }
                        }
                    }
                });
                log4j.info("syncOrganizationByHRM,同步EAP/ERP/CRM/MES员工资料结束");
            }
            log4j.info("syncOrganizationByHRM结束");
        } catch (Exception ex) {
            log4j.error("syncOrganizationByHRM出现异常", ex);
        }
    }

    @GET
    @Path("hrm/crm")
    @Consumes({"application/json"})
    //@Transactional
    public void TestSyncCRM() {
        try {
            // 同步部门
            log4j.info("syncCRMByHRM开始");
            List<cn.hanbell.hrm.entity.Department> departmentList = hrmDepartmentBean.findAll();
            if (departmentList != null && !departmentList.isEmpty()) {
                departmentList.forEach((hd) -> {
                    // EAP
                    cn.hanbell.hrm.entity.Department hp = hrmDepartmentBean.findByDepartmentId(hd.getParentId());

                    String d = hd.getCode().substring(0, 1);
                    // CRM
                    if (d.equals("1") || d.equals("5")) {
                        CMSME cd = cmsmeBean.findById(hd.getCode());
                        if (cd == null) {
                            cd = new CMSME();
                            cd.setMe001(hd.getCode());
                            cd.setMe002(hd.getName());
                            cd.setFlag((short) 1);
                            cd.setCreator("CRMDS");
                            cd.setUsrGroup("0000");
                            cd.setCreateDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
                            cmsmeBean.persist(cd);
                        } else {
                            if (!cd.getMe002().equals(hd.getName())) {
                                cd.setMe002(hd.getName());
                                cd.setModifier("CRMDS");
                                cd.setModiDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
                                cmsmeBean.update(cd);
                            }
                        }
                    }
                });
            }
            log4j.info("syncOrganizationByHRM,同步EAP/CRM/MES部门资料结束");
            // 同步人员
            List<cn.hanbell.hrm.entity.Employee> employeeList = hrmEmployeeBean.findByLastModifiedDate(
                    com.lightshell.comm.BaseLib.getDate("yyyy-MM-dd", com.lightshell.comm.BaseLib.formatDate("yyyy-MM-dd", com.lightshell.comm.BaseLib.getDate())));

            if (employeeList != null && !employeeList.isEmpty()) {
                employeeList.forEach((e) -> {
                    boolean flag = false;
                    cn.hanbell.hrm.entity.Employee manager = hrmEmployeeBean.findByEmployeeId(e.getDirectorId());
                    String company = e.getCode().substring(0, 1);
                    if ("C".equals(company) || "K".equals(company)) {
                        // CRM
                        DSCMA cu = dscmaBean.findById(e.getCode());
                        CMSMV cuDept = cmsmvBean.findById(e.getCode());
                        if (cu == null) {
                            cu = new DSCMA();
                            cu.setMa001(e.getCode());
                            cu.setMa002(e.getCnName());
                            cu.setFlag((short) 1);
                            cu.setCreator("CRMDS");
                            cu.setUsrGroup("0000");
                            cu.setCreateDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
//                            dscmaBean.persist(cu);
                        }
                        if (cuDept == null) {
                            cuDept = new CMSMV();
                            cuDept.setMv001(e.getCode());
                            cuDept.setMv002(e.getCnName());
                            cuDept.setMv004(e.getDepartment().getCode());
                            cuDept.setFlag((short) 1);
                            cuDept.setCreator("CRMDS");
                            cuDept.setUsrGroup("0000");
                            cuDept.setCreateDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
//                            cmsmvBean.persist(cuDept);
                        } else {
                            if (!cuDept.getMv004().equals(e.getDepartment().getCode())) {
                                cuDept.setMv004(e.getDepartment().getCode());
                                cuDept.setModifier("CRMDS");
                                cuDept.setModiDate(com.lightshell.comm.BaseLib.formatDate("yyyyMMdd", com.lightshell.comm.BaseLib.getDate()));
//                                cmsmvBean.update(cuDept);
                            }
                        }
                    }
                });
                log4j.info("syncOrganizationByHRM,同步EAP/ERP/CRM/MES员工资料结束");
            }
            log4j.info("syncOrganizationByHRM结束");
        } catch (Exception ex) {
            log4j.error("syncOrganizationByHRM出现异常", ex);
        }
    }

    public boolean isTWEmployee(String employeeid) {
        Pattern pattern = Pattern.compile("^[0-9]$");
        return pattern.matcher(employeeid).matches();
    }

    @GET
    @Path("erp/mis226")
    @Consumes({"application/json"})
    public void CopySecuprg(@QueryParam("facno") String facno, @QueryParam("userno1") String userno1, @QueryParam("userno2") String userno2) {
        secgprgBean.updateSecuprg(facno, userno1, userno2);
    }

    @GET
    @Path("vhbpur415/cdr310")
    @Consumes({"application/json"})
    public void createERPCDR310ByVHBPUR415() {
        String cc = "X";
        String cusno = "SDC00001";
        String pricingtype = "00";
        String pc = "V";
        String vdrno = "HA001";
        String beginDate = "20240901";
        Date d;
        try {
            d = com.lightshell.comm.BaseLib.getDate("yyyyMMdd", beginDate);
        } catch (Exception ex) {
            d = com.lightshell.comm.BaseLib.getDate();
        }
        eapMailBean.clearReceivers();
        VHBpurhadBean.setCompany(pc);
        List<vn.hanbell.erp.entity.Purhad> vhbPurhadList = VHBpurhadBean.findNeedThrowByVdrno(vdrno, d);
        if (vhbPurhadList != null && !vhbPurhadList.isEmpty()) {
            StringBuilder msgBuilder = new StringBuilder();
            StringBuilder errorBuilder = new StringBuilder();
            String temp;
            Date indate;
            Date recdate;
            String cdrno = "";
            msgBuilder.append("<div>各位好</div>");
            try {
                indate = com.lightshell.comm.BaseLib.getDate();
                recdate = com.lightshell.comm.BaseLib.getDate("yyyy-MM-dd", com.lightshell.comm.BaseLib.formatDate("yyyy-MM-dd", indate));
                cdrsysBean.setCompany(cc);
                cdrcitnbrBean.setCompany(cc);
                cdrcusBean.setCompany(cc);
                cdrcusmanBean.setCompany(cc);
                cdrcusrelBean.setCompany(cc);
                cdrhmasBean.setCompany(cc);
                cdrdmasBean.setCompany(cc);
                invmasBean.setCompany(cc);
                miscodeBean.setCompany(cc);
                misrateBean.setCompany(cc);
                secuserBean.setCompany(cc);
                Cdrcus cdrcus = cdrcusBean.findByCusno(cusno);
                if (cdrcus == null) {
                    temp = "createERPCDR310ByVHBERPPUR415遇到错误：" + cc + "公司ERP中" + cusno + "客户不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中" + cusno + "客户不存在");
                }
                Cdrcusman cdrcusman = cdrcusmanBean.findByPK(cc, cusno);
                if (cdrcusman == null) {
                    temp = "createERPCDR310ByVHBERPPUR415遇到错误：" + cc + "公司ERP中客户对应业务员资料不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中客户对应业务员资料不存在");
                }
                Secuser secuser = secuserBean.findByUserno(cdrcusman.getMan());
                if (secuser == null || secuser.getPdepno() == null || "".equals(secuser.getPdepno())) {
                    temp = "createERPCDR310ByVHBERPPUR415遇到错误：" + cc + "公司ERP中业务员对应员工资料不存在或不完整";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中业务员对应员工资料不存在或不完整");
                }
                int i, j;
                String k;
                String pono = "";
                BigDecimal tramts = BigDecimal.ZERO;
                BigDecimal taxamts = BigDecimal.ZERO;
                BigDecimal totamts = BigDecimal.ZERO;
                Cdrhmas ch;
                Cdrdmas cd;
                Cdrcitnbr citnbr;
                Invmas item;
                Secuser contacter = null;
                List<Cdrdmas> addedCdrdmas = new ArrayList<>();
                HashMap<SuperEJBForERP, List<?>> detailAdded = new LinkedHashMap<>();
                detailAdded.put(cdrdmasBean, addedCdrdmas);
                short seq;
                for (vn.hanbell.erp.entity.Purhad ph : vhbPurhadList) {
                    pono = ph.getPurhadPK().getPono();
                    seq = 0;
                    List<vn.hanbell.erp.entity.Purdta> vhbPurdtaList
                            = VHBpurhadBean.getDetailList(ph.getPurhadPK().getPono());
                    if (vhbPurdtaList == null || vhbPurdtaList.isEmpty()) {
                        continue;
                    }
                    addedCdrdmas.clear();
                    for (vn.hanbell.erp.entity.Purdta pd : vhbPurdtaList) {
                        if (pd.getDposta().equals("20") || pd.getDposta().equals("30")) {
                            item = invmasBean.findByItnbr(pd.getItnbr());
                            if (item == null || Objects.equals("N", item.getNStopyn())) {
                                j = pd.getItnbr().indexOf("-");
                                k = pd.getItnbr().substring(0, 1);
                                if (j == 4 && (k.equals("1") || k.equals("2") || k.equals("3"))) {
                                    // 1,2,3字头前面是4码，加入中间3字码
                                    k = pd.getItnbr().substring(0, 2) + "3" + pd.getItnbr().substring(2);
                                    item = invmasBean.findByItnbr(k);
                                    if (item == null) {
                                        errorBuilder.append("<div>createERPCDR310ByExchPUR415遇到错误：").append(cc)
                                                .append("公司ERP中").append(pd.getItnbr()).append("品号不存在").append("</div>");
                                    }
                                }
                            }
                            seq++;
                            cd = new Cdrdmas(cc, "", seq);
                            cd.setItnbr(item == null ? pd.getItnbr() : item.getItnbr());
                            // 处理客户品号
                            citnbr = cdrcitnbrBean.findByPK(cusno, cd.getItnbr(), null);
                            if (citnbr == null) {
                                cd.setItnbrcus("");
                            } else {
                                cd.setItnbrcus(citnbr.getCdrcitnbrPK().getItnbrcus());
                            }
                            cd.setProno("1");
                            cd.setShptrseq(cdrcus.getShptrseq());
                            cd.setIvotrseq(cdrcus.getIvotrseq());
                            cd.setCdrqy1(pd.getPoqy1());// 需要处理单位换算问题
                            cd.setCdrqy2(pd.getPoqy2());
                            cd.setArmqy(pd.getApmqy());
                            cd.setUnpris(pd.getUnpris());
                            cd.setOutdate(pd.getAskdate());
                            cd.setCdrdate(pd.getAskdate());
                            cd.setTramts(pd.getTramts());
                            cd.setDrecsta("10");
                            cd.setUnprisrccode('1');
                            cd.setNcodeCD("WXVN");
                            addedCdrdmas.add(cd);
                            // 计算合计金额
                            tramts = tramts.add(pd.getTramts());
                            totamts = totamts.add(pd.getTramts());
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        if (ph.getContacter() != null && !"".equals(ph.getContacter())) {
                            contacter = secuserBean.findByUserno(ph.getContacter());
                        }
                        // 设置邮件收件人
                        if (contacter != null && contacter.getEmail() != null
                                && !"".equals(contacter.getEmail().trim())) {
                            eapMailBean.addTo(contacter.getEmail());
                        } else {
                            if (secuser.getEmail() != null && !"".equals(secuser.getEmail().trim())) {
                                eapMailBean.addTo(secuser.getEmail());
                            }
                        }
                        List<Cdrcusrel> cusrelList = cdrcusrelBean.findByCusno(cusno);
                        if (cusrelList != null && !cusrelList.isEmpty()) {
                            for (Cdrcusrel r : cusrelList) {
                                if (r.getEmail() != null && !"".equals(r.getEmail().trim())) {
                                    eapMailBean.addTo(r.getEmail());
                                }
                            }
                        }
                        VHBpurvdrrelBean.setCompany(pc);
                        List<vn.hanbell.erp.entity.Purvdrrel> vdrrelList = VHBpurvdrrelBean.findByVdrno(vdrno);
                        if (vdrrelList != null && !vdrrelList.isEmpty()) {
                            for (Purvdrrel r : vdrrelList) {
                                if (r.getEmail() != null && !"".equals(r.getEmail().trim())) {
                                    eapMailBean.addTo(r.getEmail());
                                }
                            }
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        ch = new Cdrhmas(cc, "");
                        ch.setCusno(cusno);
                        ch.setCdrcode('A');
                        ch.setDepno(contacter == null ? secuser.getPdepno() : contacter.getPdepno());
                        ch.setRecdate(recdate);
                        ch.setDecode(ph.getDecode());
                        ch.setShptrseq(cdrcus.getShptrseq());
                        ch.setIvotrseq(cdrcus.getIvotrseq());
                        ch.setPricingtype(pricingtype);
                        ch.setHrecsta('N');
                        ch.setTax(ph.getTax());
                        ch.setTaxrate(ph.getTaxrate());
                        ch.setCoin(ph.getCoin());
                        if (ch.getCoin().equals("USD")) {
                            ch.setRatio(BigDecimal.ONE);
                        } else {
                            Misrate misrate = misrateBean.findByCoin(ch.getCoin());
                            ch.setRatio(misrate.getOrate());// 出口汇率
                        }
                        ch.setSndcode(cdrcus.getSndcode());
                        ch.setPaycode(cdrcus.getPaycode());
                        ch.setTermcode(ph.getTermcode());
                        ch.setSndcodedsc(miscodeBean.findByPK("GD", cdrcus.getSndcode()).getCdesc());
                        ch.setPaycodedsc(ph.getPaycodedsc());
                        ch.setTermcodedsc(ph.getTermcodedsc());
                        // 客户基础资料代值
                        ch.setPaysepcode(cdrcus.getPaysepcode());
                        ch.setSeldate1(cdrcus.getSeldate1());
                        ch.setSeldate2(cdrcus.getSeldate2());
                        ch.setSeldate3(cdrcus.getSeldate3());
                        ch.setSeldate4(cdrcus.getSeldate4());
                        ch.setHandays1(cdrcus.getHandays1());
                        ch.setHandays2(cdrcus.getHandays2());
                        ch.setHandays3(cdrcus.getHandays3());
                        ch.setHandays4(cdrcus.getHandays4());
                        ch.setTickdays(cdrcus.getTickdays());
                        ch.setSacode(cdrcus.getSacode());
                        ch.setAreacode(cdrcus.getAreacode());
                        ch.setCuycode(cdrcus.getCuycode());
                        // 计算表头金额税额
                        switch (ch.getTax()) {
                            case '1':
                                ch.setTramts(tramts);
                                ch.setTaxamts(tramts.multiply(ch.getTaxrate()));
                                ch.setTotamts(ch.getTramts().add(ch.getTaxamts()));
                                break;
                            case '4':
                                ch.setTotamts(totamts);
                                ch.setTramts(
                                        totamts.divide(ch.getTaxrate().add(BigDecimal.ONE), 2, RoundingMode.HALF_UP));
                                ch.setTaxamts(totamts.subtract(ch.getTramts()));
                                break;
                            default:
                                ch.setTramts(tramts);
                                ch.setTaxamts(BigDecimal.ZERO);
                                ch.setTotamts(tramts);
                        }
                        ch.setIndate(indate);
                        ch.setUserno(contacter == null ? cdrcusman.getMan() : contacter.getUserno());
                        // 设置负责业务
                        //ch.setMancode(cdrcusman.getMan());
                        //因同一个客户对应不同的产品及业务员，调整为采购单联系人
                        ch.setMancode(ch.getUserno());
                        ch.setCuspono(ph.getPurhadPK().getPono());
                        // 设置订单编号
                        cdrno = cdrsysBean.getSerialNumber(cc, "", "A", recdate, ch.getDecode(), true, "CDR310");
                        ch.getCdrhmasPK().setCdrno(cdrno);
                        //tran.begin();
                        cdrhmasBean.setCompany(cc);
                        cdrhmasBean.persist(ch);
                        //cdrhmasBean.getEntityManager().flush();
                        //tran.commit();
                        for (Cdrdmas e : addedCdrdmas) {
                            e.getCdrdmasPK().setCdrno(cdrno);
                            cdrdmasBean.persist(e);
                        }
                        ph.setFromcdrno(cdrno);
                        VHBpurhadBean.update(ph);
                        msgBuilder.append(String.format("<div>执行%s成功：%s公司采购单%s抛转成%s公司订单%s",
                                "createERPCDR310ByVHBERPPUR415", pc, pono, cc, cdrno)).append("</div>");
                        msgBuilder.append("<div>来源采购单").append(vhbPurdtaList.size()).append("笔明细").append("产生新订单")
                                .append(seq).append("笔明细").append("</div>");
                    } else {
                        msgBuilder
                                .append(
                                        String.format("<div>执行%s成功：%s公司采购单%s，PASS", "createERPCDR310ByVHBERPPUR415", pc, pono))
                                .append("</div>");
                        ph.setFromcdrno("PASS");
                        VHBpurhadBean.update(ph);
                    }
                }
                log4j.info(msgBuilder.toString());
            } catch (Exception ex) {
                errorBuilder.append(ex.toString());
                log4j.error("createERPCDR310ByVHBERPPUR415遇到错误", ex);
                ex.printStackTrace();
                throw new RuntimeException(errorBuilder.toString());
            } finally {
                if (!eapMailBean.getTo().isEmpty() || !eapMailBean.getCc().isEmpty()) {
                    eapMailBean.setMailSubject("香港ERP系统新订单" + cdrno);
                    msgBuilder.append("<div>").append(errorBuilder.toString()).append("</div>");
                    eapMailBean.setHTMLMailContent(msgBuilder.toString());
                    eapMailBean.notify(new MailNotify());
                }
            }
        }
    }

    @GET
    @Path("krpur415/hkcdr310")
    @Consumes({"application/json"})
    public void createHKERPCDR310ByKRPUR415() {
        String cc = "X";
        String cusno = "KHB01";
        String pricingtype = "00";
        String pc = "R";
        String vdrno = "HK001";
        String beginDate = "20250101";
        Date d;
        try {
            d = com.lightshell.comm.BaseLib.getDate("yyyyMMdd", beginDate);
        } catch (Exception ex) {
            d = com.lightshell.comm.BaseLib.getDate();
        }
        eapMailBean.clearReceivers();
        KRpurhadBean.setCompany(pc);
        List<kr.hanbell.erp.entity.Purhad> krPurhadList = KRpurhadBean.findNeedThrowByVdrno(vdrno, d);
        if (krPurhadList != null && !krPurhadList.isEmpty()) {
            StringBuilder msgBuilder = new StringBuilder();
            StringBuilder errorBuilder = new StringBuilder();
            String temp;
            Date indate;
            Date recdate;
            String cdrno = "";
            msgBuilder.append("<div>各位好</div>");
            try {
                indate = com.lightshell.comm.BaseLib.getDate();
                recdate = com.lightshell.comm.BaseLib.getDate("yyyy-MM-dd", com.lightshell.comm.BaseLib.formatDate("yyyy-MM-dd", indate));
                cdrsysBean.setCompany(cc);
                cdrcitnbrBean.setCompany(cc);
                cdrcusBean.setCompany(cc);
                cdrcusmanBean.setCompany(cc);
                cdrcusrelBean.setCompany(cc);
                cdrhmasBean.setCompany(cc);
                cdrdmasBean.setCompany(cc);
                invmasBean.setCompany(cc);
                miscodeBean.setCompany(cc);
                misrateBean.setCompany(cc);
                secuserBean.setCompany(cc);
                Cdrcus cdrcus = cdrcusBean.findByCusno(cusno);
                if (cdrcus == null) {
                    temp = "createERPCDR310ByKRERPPUR415遇到错误：" + cc + "公司ERP中" + cusno + "客户不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中" + cusno + "客户不存在");
                }
                Cdrcusman cdrcusman = cdrcusmanBean.findByPK(cc, cusno);
                if (cdrcusman == null) {
                    temp = "createERPCDR310ByKRERPPUR415遇到错误：" + cc + "公司ERP中客户对应业务员资料不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中客户对应业务员资料不存在");
                }
                Secuser secuser = secuserBean.findByUserno(cdrcusman.getMan());
                if (secuser == null || secuser.getPdepno() == null || "".equals(secuser.getPdepno())) {
                    temp = "createERPCDR310ByKRERPPUR415遇到错误：" + cc + "公司ERP中业务员对应员工资料不存在或不完整";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中业务员对应员工资料不存在或不完整");
                }
                int i, j;
                String k;
                String pono = "";
                BigDecimal tramts = BigDecimal.ZERO;
                BigDecimal taxamts = BigDecimal.ZERO;
                BigDecimal totamts = BigDecimal.ZERO;
                Cdrhmas ch;
                Cdrdmas cd;
                Cdrcitnbr citnbr;
                Invmas item;
                Secuser contacter = null;
                List<Cdrdmas> addedCdrdmas = new ArrayList<>();
                HashMap<SuperEJBForERP, List<?>> detailAdded = new LinkedHashMap<>();
                detailAdded.put(cdrdmasBean, addedCdrdmas);
                short seq;
                for (kr.hanbell.erp.entity.Purhad ph : krPurhadList) {
                    pono = ph.getPurhadPK().getPono();
                    seq = 0;
                    List<kr.hanbell.erp.entity.Purdta> krPurdtaList
                            = KRpurhadBean.getDetailList(ph.getPurhadPK().getPono());
                    if (krPurdtaList == null || krPurdtaList.isEmpty()) {
                        continue;
                    }
                    addedCdrdmas.clear();
                    for (kr.hanbell.erp.entity.Purdta pd : krPurdtaList) {
                        if (pd.getDposta().equals("20") || pd.getDposta().equals("30")) {
                            item = invmasBean.findByItnbr(pd.getItnbr());
                            if (item == null || Objects.equals("N", item.getNStopyn())) {
                                j = pd.getItnbr().indexOf("-");
                                k = pd.getItnbr().substring(0, 1);
                                if (j == 4 && (k.equals("1") || k.equals("2") || k.equals("3"))) {
                                    // 1,2,3字头前面是4码，加入中间3字码
                                    k = pd.getItnbr().substring(0, 2) + "3" + pd.getItnbr().substring(2);
                                    item = invmasBean.findByItnbr(k);
                                    if (item == null) {
                                        errorBuilder.append("<div>createERPCDR310ByExchPUR415遇到错误：").append(cc)
                                                .append("公司ERP中").append(pd.getItnbr()).append("品号不存在").append("</div>");
                                    }
                                }
                            }
                            seq++;
                            cd = new Cdrdmas(cc, "", seq);
                            cd.setItnbr(item == null ? pd.getItnbr() : item.getItnbr());
                            // 处理客户品号
                            citnbr = cdrcitnbrBean.findByPK(cusno, cd.getItnbr(), null);
                            if (citnbr == null) {
                                cd.setItnbrcus("");
                            } else {
                                cd.setItnbrcus(citnbr.getCdrcitnbrPK().getItnbrcus());
                            }
                            cd.setProno("1");
                            cd.setShptrseq(cdrcus.getShptrseq());
                            cd.setIvotrseq(cdrcus.getIvotrseq());
                            cd.setCdrqy1(pd.getPoqy1());// 需要处理单位换算问题
                            cd.setCdrqy2(pd.getPoqy2());
                            cd.setArmqy(pd.getApmqy());
                            cd.setUnpris(pd.getUnpris());
                            cd.setOutdate(pd.getAskdate());
                            cd.setCdrdate(pd.getAskdate());
                            cd.setTramts(pd.getTramts());
                            cd.setDrecsta("10");
                            cd.setUnprisrccode('1');
                            cd.setNcodeCD("WX");
                            addedCdrdmas.add(cd);
                            // 计算合计金额
                            tramts = tramts.add(pd.getTramts());
                            totamts = totamts.add(pd.getTramts());
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        if (ph.getContacter() != null && !"".equals(ph.getContacter())) {
                            contacter = secuserBean.findByUserno(ph.getContacter());
                        }
                        // 设置邮件收件人
                        if (contacter != null && contacter.getEmail() != null
                                && !"".equals(contacter.getEmail().trim())) {
                            eapMailBean.addTo(contacter.getEmail());
                        } else {
                            if (secuser.getEmail() != null && !"".equals(secuser.getEmail().trim())) {
                                eapMailBean.addTo(secuser.getEmail());
                            }
                        }
                        List<Cdrcusrel> cusrelList = cdrcusrelBean.findByCusno(cusno);
                        if (cusrelList != null && !cusrelList.isEmpty()) {
                            for (Cdrcusrel r : cusrelList) {
                                if (r.getEmail() != null && !"".equals(r.getEmail().trim())) {
                                    eapMailBean.addTo(r.getEmail());
                                }
                            }
                        }
                        KRpurvdrrelBean.setCompany(pc);
                        List<kr.hanbell.erp.entity.Purvdrrel> vdrrelList = KRpurvdrrelBean.findByVdrno(vdrno);
                        if (vdrrelList != null && !vdrrelList.isEmpty()) {
                            for (kr.hanbell.erp.entity.Purvdrrel r : vdrrelList) {
                                if (r.getEmail() != null && !"".equals(r.getEmail().trim())) {
                                    eapMailBean.addTo(r.getEmail());
                                }
                            }
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        ch = new Cdrhmas(cc, "");
                        ch.setCusno(cusno);
                        ch.setCdrcode('A');
                        ch.setDepno(contacter == null ? secuser.getPdepno() : contacter.getPdepno());
                        ch.setRecdate(recdate);
                        ch.setDecode(ph.getDecode());
                        ch.setShptrseq(cdrcus.getShptrseq());
                        ch.setIvotrseq(cdrcus.getIvotrseq());
                        ch.setPricingtype(pricingtype);
                        ch.setHrecsta('N');
                        ch.setTax(ph.getTax());
                        ch.setTaxrate(ph.getTaxrate());
                        ch.setCoin("CNY".equals(ph.getCoin()) ? "RMB" : ph.getCoin());
                        if (ch.getCoin().equals("USD")) {
                            ch.setRatio(BigDecimal.ONE);
                        } else {
                            Misrate misrate = misrateBean.findByCoin(ch.getCoin());
                            if (null == misrate) {
                                errorBuilder.append("createERPCDR310ByKRERPPUR415遇到错误：" + cc + "公司ERP中币别对应汇率不存在");
                                throw new RuntimeException(cc + "公司ERP中币别对应汇率不存在");
                            }
                            ch.setRatio(misrate.getOrate());// 出口汇率
                        }
                        ch.setSndcode(cdrcus.getSndcode());
                        ch.setPaycode(cdrcus.getPaycode());
                        ch.setTermcode(ph.getTermcode());
                        ch.setSndcodedsc(miscodeBean.findByPK("GD", cdrcus.getSndcode()).getCdesc());
                        ch.setPaycodedsc(ph.getPaycodedsc());
                        ch.setTermcodedsc(ph.getTermcodedsc());
                        // 客户基础资料代值
                        ch.setPaysepcode(cdrcus.getPaysepcode());
                        ch.setSeldate1(cdrcus.getSeldate1());
                        ch.setSeldate2(cdrcus.getSeldate2());
                        ch.setSeldate3(cdrcus.getSeldate3());
                        ch.setSeldate4(cdrcus.getSeldate4());
                        ch.setHandays1(cdrcus.getHandays1());
                        ch.setHandays2(cdrcus.getHandays2());
                        ch.setHandays3(cdrcus.getHandays3());
                        ch.setHandays4(cdrcus.getHandays4());
                        ch.setTickdays(cdrcus.getTickdays());
                        ch.setSacode(cdrcus.getSacode());
                        ch.setAreacode(cdrcus.getAreacode());
                        ch.setCuycode(cdrcus.getCuycode());
                        // 计算表头金额税额
                        switch (ch.getTax()) {
                            case '1':
                                ch.setTramts(tramts);
                                ch.setTaxamts(tramts.multiply(ch.getTaxrate()));
                                ch.setTotamts(ch.getTramts().add(ch.getTaxamts()));
                                break;
                            case '4':
                                ch.setTotamts(totamts);
                                ch.setTramts(
                                        totamts.divide(ch.getTaxrate().add(BigDecimal.ONE), 2, RoundingMode.HALF_UP));
                                ch.setTaxamts(totamts.subtract(ch.getTramts()));
                                break;
                            default:
                                ch.setTramts(tramts);
                                ch.setTaxamts(BigDecimal.ZERO);
                                ch.setTotamts(tramts);
                        }
                        ch.setIndate(indate);
                        ch.setUserno(contacter == null ? cdrcusman.getMan() : contacter.getUserno());
                        // 设置负责业务
                        //ch.setMancode(cdrcusman.getMan());
                        //因同一个客户对应不同的产品及业务员，调整为采购单联系人
                        ch.setMancode(ch.getUserno());
                        ch.setCuspono(ph.getPurhadPK().getPono());
                        // 设置订单编号
                        cdrno = cdrsysBean.getSerialNumber(cc, "", "A", recdate, ch.getDecode(), true, "CDR310");
                        ch.getCdrhmasPK().setCdrno(cdrno);
                        //tran.begin();
                        cdrhmasBean.setCompany(cc);
                        cdrhmasBean.persist(ch);
                        //cdrhmasBean.getEntityManager().flush();
                        //tran.commit();
                        for (Cdrdmas e : addedCdrdmas) {
                            e.getCdrdmasPK().setCdrno(cdrno);
                            cdrdmasBean.persist(e);
                        }
                        ph.setFromcdrno(cdrno);
                        KRpurhadBean.update(ph);
                        msgBuilder.append(String.format("<div>执行%s成功：%s公司采购单%s抛转成%s公司订单%s",
                                "createERPCDR310ByKRERPPUR415", pc, pono, cc, cdrno)).append("</div>");
                        msgBuilder.append("<div>来源采购单").append(krPurdtaList.size()).append("笔明细").append("产生新订单")
                                .append(seq).append("笔明细").append("</div>");
                    } else {
                        msgBuilder
                                .append(
                                        String.format("<div>执行%s成功：%s公司采购单%s，PASS", "createERPCDR310ByKRERPPUR415", pc, pono))
                                .append("</div>");
                        ph.setFromcdrno("PASS");
                        KRpurhadBean.update(ph);
                    }
                }
                log4j.info(msgBuilder.toString());
            } catch (Exception ex) {
                errorBuilder.append(ex.toString());
                log4j.error("createERPCDR310ByKRERPPUR415遇到错误", ex);
                ex.printStackTrace();
                throw new RuntimeException(errorBuilder.toString());
            } finally {
                if (!eapMailBean.getTo().isEmpty() || !eapMailBean.getCc().isEmpty()) {
                    eapMailBean.setMailSubject("香港ERP系统新订单" + cdrno);
                    msgBuilder.append("<div>").append(errorBuilder.toString()).append("</div>");
                    eapMailBean.setHTMLMailContent(msgBuilder.toString());
                    eapMailBean.notify(new MailNotify());
                }
            }
        }
    }

    @GET
    @Path("thbpur415/cdr310")
    @Consumes({"application/json"})
    public void createERPCDR310ByExchPUR415(@QueryParam("cc") String cc, @QueryParam("cusno") String cusno, @QueryParam("vdrno") String vdrno) {
//        String cc = "C";
//        String cusno = "STW00003";
//        String pricingtype = "00";
//        String pc = "A";
//        String vdrno = "86005";
//        String beginDate = "20200408";
//        String cc = "H";
//        String cusno = "HTW00001";
//        String pricingtype = "00";
//        String pc = "A";
//        String vdrno = "1139";
//        String beginDate = "20200408";
//        String cc = "K";
//        String cusno = "KTW00004";
        String pricingtype = "00";
        String pc = "A";
//        String vdrno = "86010";
        String beginDate = "20200408";
        Date d;
        try {
            d = BaseLib.getDate("yyyyMMdd", beginDate);
        } catch (Exception ex) {
            d = BaseLib.getDate();
        }
        List<tw.hanbell.exch.entity.Purhad> exchPurhadList = exchPurhadBean.findNeedThrowByVdrno(vdrno, d);
        if (exchPurhadList != null && !exchPurhadList.isEmpty()) {
            StringBuilder msgBuilder = new StringBuilder();
            StringBuilder errorBuilder = new StringBuilder();
            String temp;
            Date indate;
            Date recdate;
            String cdrno = "";
            msgBuilder.append("<div>各位好</div>");
            try {
                indate = BaseLib.getDate();
                recdate = BaseLib.getDate("yyyy-MM-dd", BaseLib.formatDate("yyyy-MM-dd", indate));
                cdrsysBean.setCompany(cc);
                cdrcitnbrBean.setCompany(cc);
                cdrcusBean.setCompany(cc);
                cdrcusmanBean.setCompany(cc);
                cdrcusrelBean.setCompany(cc);
                cdrhmasBean.setCompany(cc);
                cdrdmasBean.setCompany(cc);
                invmasBean.setCompany(cc);
                miscodeBean.setCompany(cc);
                misrateBean.setCompany(cc);
                secuserBean.setCompany(cc);
                Cdrcus cdrcus = cdrcusBean.findByCusno(cusno);
                if (cdrcus == null) {
                    temp = "createERPCDR310ByExchPUR415遇到错误：" + cc + "公司ERP中" + cusno + "客户不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中" + cusno + "客户不存在");
                }
                Cdrcusman cdrcusman = cdrcusmanBean.findByPK(cc, cusno);
                if (cdrcusman == null) {
                    temp = "createERPCDR310ByExchPUR415遇到错误：" + cc + "公司ERP中客户对应业务员资料不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中客户对应业务员资料不存在");
                }
                Secuser secuser = secuserBean.findByUserno(cdrcusman.getMan());
                if (secuser == null || secuser.getPdepno() == null || "".equals(secuser.getPdepno())) {
                    temp = "createERPCDR310ByExchPUR415遇到错误：" + cc + "公司ERP中业务员对应员工资料不存在或不完整";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中业务员对应员工资料不存在或不完整");
                }
                int i, j;
                String k;
                String pono = "";
                BigDecimal tramts = BigDecimal.ZERO;
                BigDecimal taxamts = BigDecimal.ZERO;
                BigDecimal totamts = BigDecimal.ZERO;
                Cdrhmas ch;
                Cdrdmas cd;
                Cdrcitnbr citnbr;
                Invmas item;
                Secuser contacter = null;
                List<Cdrdmas> addedCdrdmas = new ArrayList<>();
                HashMap<SuperEJBForERP, List<?>> detailAdded = new LinkedHashMap<>();
                detailAdded.put(cdrdmasBean, addedCdrdmas);
                short seq;
                for (tw.hanbell.exch.entity.Purhad ph : exchPurhadList) {
                    pono = ph.getPurhadPK().getPono();
                    seq = 0;
                    List<tw.hanbell.exch.entity.Purdta> exchPurdtaList
                            = exchPurhadBean.getDetailList(ph.getPurhadPK().getPono());
                    if (exchPurdtaList == null || exchPurdtaList.isEmpty()) {
                        continue;
                    }
                    addedCdrdmas.clear();
                    for (tw.hanbell.exch.entity.Purdta pd : exchPurdtaList) {
                        if (pd.getDposta().equals("20") || pd.getDposta().equals("30")) {
                            item = invmasBean.findByItnbr(pd.getItnbr());
                            if (item == null || Objects.equals("N", item.getNStopyn())) {
                                j = pd.getItnbr().indexOf("-");
                                k = pd.getItnbr().substring(0, 1);
                                if (j == 4 && (k.equals("1") || k.equals("2") || k.equals("3"))) {
                                    // 1,2,3字头前面是4码，加入中间3字码
                                    k = pd.getItnbr().substring(0, 2) + "3" + pd.getItnbr().substring(2);
                                    item = invmasBean.findByItnbr(k);
                                    if (item == null) {
                                        errorBuilder.append("<div>createERPCDR310ByExchPUR415遇到错误：").append(cc)
                                                .append("公司ERP中").append(pd.getItnbr()).append("品号不存在").append("</div>");
                                    }
                                }
                            }
                            seq++;
                            cd = new Cdrdmas(cc, "", seq);
                            cd.setItnbr(item == null ? pd.getItnbr() : item.getItnbr());
                            // 处理客户品号
                            citnbr = cdrcitnbrBean.findByPK(cusno, cd.getItnbr(), null);
                            if (citnbr == null) {
                                cd.setItnbrcus("");
                            } else {
                                cd.setItnbrcus(citnbr.getCdrcitnbrPK().getItnbrcus());
                            }
                            cd.setProno("1");
                            cd.setShptrseq(cdrcus.getShptrseq());
                            cd.setIvotrseq(cdrcus.getIvotrseq());
                            cd.setCdrqy1(pd.getPoqy1());// 需要处理单位换算问题
                            cd.setCdrqy2(pd.getPoqy2());
                            cd.setArmqy(pd.getApmqy());
                            cd.setUnpris(pd.getUnpris());
                            cd.setOutdate(pd.getAskdate());
                            cd.setCdrdate(pd.getAskdate());
                            cd.setTramts(pd.getTramts());
                            cd.setDrecsta("10");
                            cd.setUnprisrccode('1');
                            addedCdrdmas.add(cd);
                            // 计算合计金额
                            tramts = tramts.add(pd.getTramts());
                            totamts = totamts.add(pd.getTramts());
                        }
                    }
                    eapMailBean.clearReceivers();
                    if (!addedCdrdmas.isEmpty()) {
                        if (ph.getNContacter() != null && !"".equals(ph.getNContacter())) {
                            contacter = secuserBean.findByUserno(ph.getNContacter());
                        }
                        // 设置邮件收件人
                        if (contacter != null && contacter.getEmail() != null
                                && !"".equals(contacter.getEmail().trim())) {
                            eapMailBean.addTo(contacter.getEmail());
                        } else {
                            if (secuser.getEmail() != null && !"".equals(secuser.getEmail().trim())) {
                                eapMailBean.addTo(secuser.getEmail());
                            }
                        }
                        List<Cdrcusrel> cusrelList = cdrcusrelBean.findByCusno(cusno);
                        if (cusrelList != null && !cusrelList.isEmpty()) {
                            for (Cdrcusrel r : cusrelList) {
                                if (r.getEmail() != null && !"".equals(r.getEmail().trim())) {
                                    eapMailBean.addTo(r.getEmail());
                                }
                            }
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        ch = new Cdrhmas(cc, "");
                        ch.setCusno(cusno);
                        ch.setCdrcode('A');
                        ch.setDepno(contacter == null ? secuser.getPdepno() : contacter.getPdepno());
                        ch.setRecdate(recdate);
                        ch.setDecode(ph.getDecode().charAt(0));
                        ch.setShptrseq(cdrcus.getShptrseq());
                        ch.setIvotrseq(cdrcus.getIvotrseq());
                        ch.setPricingtype(pricingtype);
                        ch.setHrecsta('N');
                        ch.setTax(ph.getTax().charAt(0));
                        ch.setTaxrate(ph.getTaxrate());
                        ch.setCoin((ph.getCoin() == null || "".equals(ph.getCoin())) ? "RMB" : ph.getCoin());
                        if (ch.getCoin().equals("RMB") || ch.getCoin().equals("CNY")) {
                            ch.setRatio(BigDecimal.ONE);
                        } else {
                            Misrate misrate = misrateBean.findByCoin(ch.getCoin());
                            ch.setRatio(misrate.getOrate());// 出口汇率
                        }
                        ch.setSndcode(cdrcus.getSndcode());
                        ch.setPaycode(cdrcus.getPaycode());
                        ch.setTermcode(ph.getTermcode());
                        ch.setSndcodedsc(miscodeBean.findByPK("GD", cdrcus.getSndcode()).getCdesc());
                        ch.setPaycodedsc(ph.getPaycodedsc());
                        ch.setTermcodedsc(ph.getTermcodedsc());
                        // 客户基础资料代值
                        ch.setPaysepcode(cdrcus.getPaysepcode());
                        ch.setSeldate1(cdrcus.getSeldate1());
                        ch.setSeldate2(cdrcus.getSeldate2());
                        ch.setSeldate3(cdrcus.getSeldate3());
                        ch.setSeldate4(cdrcus.getSeldate4());
                        ch.setHandays1(cdrcus.getHandays1());
                        ch.setHandays2(cdrcus.getHandays2());
                        ch.setHandays3(cdrcus.getHandays3());
                        ch.setHandays4(cdrcus.getHandays4());
                        ch.setTickdays(cdrcus.getTickdays());
                        ch.setSacode(cdrcus.getSacode());
                        ch.setAreacode(cdrcus.getAreacode());
                        ch.setCuycode(cdrcus.getCuycode());
                        // 计算表头金额税额
                        switch (ch.getTax()) {
                            case '1':
                                ch.setTramts(tramts);
                                ch.setTaxamts(tramts.multiply(ch.getTaxrate()));
                                ch.setTotamts(ch.getTramts().add(ch.getTaxamts()));
                                break;
                            case '4':
                                ch.setTotamts(totamts);
                                ch.setTramts(
                                        totamts.divide(ch.getTaxrate().add(BigDecimal.ONE), 2, RoundingMode.HALF_UP));
                                ch.setTaxamts(totamts.subtract(ch.getTramts()));
                                break;
                            default:
                                ch.setTramts(tramts);
                                ch.setTaxamts(BigDecimal.ZERO);
                                ch.setTotamts(tramts);
                        }
                        ch.setIndate(indate);
                        ch.setUserno(contacter == null ? cdrcusman.getMan() : contacter.getUserno());
                        // 设置负责业务
                        //ch.setMancode(cdrcusman.getMan());
                        //因同一个客户对应不同的产品及业务员，调整为采购单联系人
                        ch.setMancode(ch.getUserno());
                        ch.setCuspono(ph.getPurhadPK().getPono());
                        // 设置订单编号
                        cdrno = cdrsysBean.getSerialNumber(cc, "", "A", recdate, ch.getDecode(), true, "CDR310");
                        ch.getCdrhmasPK().setCdrno(cdrno);
                        cdrhmasBean.persist(ch);
                        //cdrhmasBean.getEntityManager().flush();
                        for (Cdrdmas e : addedCdrdmas) {
                            e.getCdrdmasPK().setCdrno(cdrno);
                            cdrdmasBean.persist(e);
                        }
                        ph.setFromcdrno(cdrno);
                        exchPurhadBean.update(ph);
                        msgBuilder.append(String.format("<div>执行%s成功：%s公司采购单%s抛转成%s公司订单%s",
                                "createERPCDR310ByExchPUR415", pc, pono, cc, cdrno)).append("</div>");
                        msgBuilder.append("<div>来源采购单").append(exchPurdtaList.size()).append("笔明细").append("产生新订单")
                                .append(seq).append("笔明细").append("</div>");
                    } else {
                        msgBuilder
                                .append(
                                        String.format("<div>执行%s成功：%s公司采购单%s，PASS", "createERPCDR310ByExchPUR415", pc, pono))
                                .append("</div>");
                        ph.setFromcdrno("PASS");
                        exchPurhadBean.update(ph);
                    }
                }
                log4j.info(msgBuilder.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                errorBuilder.append(ex.toString());
                throw new RuntimeException(errorBuilder.toString());
            } finally {
                if (!eapMailBean.getTo().isEmpty() || !eapMailBean.getCc().isEmpty()) {
                    eapMailBean.setMailSubject("ERP系统新订单" + cdrno);
                    msgBuilder.append("<div>").append(errorBuilder.toString()).append("</div>");
                    eapMailBean.setHTMLMailContent(msgBuilder.toString());
                    //eapMailBean.notify(new cn.hanbell.eap.comm.MailNotify());
                }
            }
        }
    }
}
