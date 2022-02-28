/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmapd;
import cn.hanbell.erp.entity.Apmaph;

import cn.hanbell.erp.entity.Apmpad;
import cn.hanbell.erp.entity.ApmpadPK;
import cn.hanbell.erp.entity.Apmpay;
import cn.hanbell.erp.entity.ApmpayPK;
import cn.hanbell.erp.entity.BudgetDetail;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.oa.ejb.HZCW028reDetailBean;
import cn.hanbell.oa.ejb.HZCW028Bean;
import cn.hanbell.oa.ejb.HZCW017Bean;
import cn.hanbell.oa.ejb.HZCW028tDetailBean;
import cn.hanbell.oa.ejb.HZCW033reDetailBean;
import cn.hanbell.oa.ejb.HZCW033Bean;
import cn.hanbell.oa.ejb.SHBERPAPM828Bean;
import cn.hanbell.oa.entity.HZCW028reDetail;
import cn.hanbell.oa.entity.HZCW028;
import cn.hanbell.oa.entity.HZCW017;
import cn.hanbell.oa.entity.HZCW033reDetail;
import cn.hanbell.oa.entity.HZCW033;
import cn.hanbell.oa.entity.SHBERPAPM828;
import cn.hanbell.oa.entity.SHBERPAPM828Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ApmpayBean extends SuperEJBForERP<Apmpay> {

    @EJB
    private AccrnoBean accrnoBean;
    @EJB
    private AccacrBean accacrBean;
    @EJB
    private ApmaphBean apmaphBean;
    @EJB
    private ApmpadBean apmpadBean;

    @EJB
    private ApmsysBean apmsysBean;

    @EJB
    private BudgetDetailBean budgetDetailBean;

    @EJB
    private HZCW028Bean hzcw028Bean;
    @EJB
    private HZCW028reDetailBean hzcw028reDetailBean;
    @EJB
    private HZCW028tDetailBean hzcw028tDetailBean;

    @EJB
    private HZCW017Bean jzdBean;

    @EJB
    private HZCW033Bean jzghdBean;
    @EJB
    private HZCW033reDetailBean jzghdreDetailBean;

    @EJB
    private SHBERPAPM828Bean shberpapm828Bean;

    private Miscode miscode;

    public ApmpayBean() {
        super(Apmpay.class);
    }

    public boolean isExistRefno(String facno, String apno) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT count(*) FROM apmpad,apmpay WHERE apmpay.facno = apmpad.facno ");
        sb.append(" AND apmpay.paycode = apmpad.paycode AND apmpay.payno = apmpad.payno AND apmpay.facno = '")
            .append(facno).append("' AND apmpay.paycode ='2' AND apmpay.paystat <> 'W'");
        sb.append(" AND apmpad.refno ='").append(apno).append("' ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        int cnt;
        try {
            cnt = (int)query.getSingleResult();
            if (cnt > 0) {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    public Boolean initByOAAPM828(String psn) {
        SHBERPAPM828 oah = shberpapm828Bean.findByPSN(psn);
        if (oah == null) {
            throw new NullPointerException(psn);
        }
        String facno = oah.getFacno();
        String apno = oah.getApno();
        String aptyp = oah.getAptyp();
        Date payda = oah.getPayda();
        String rkd = oah.getRkd();
        String accno = oah.getAccno();
        short config = Short.parseShort(oah.getConfig());
        this.setCompany(facno);
        if (this.isExistRefno(facno, apno)) {
            // 已经抛转
            return true;
        }
        apmaphBean.setCompany(facno);
        Apmaph aph = apmaphBean.findByPK(facno, apno, aptyp);
        if (aph == null || !aph.getApsta().equals("25")) {
            throw new NullPointerException(apno);
        }
        List<Apmapd> apdList = apmaphBean.findApmapd(facno, apno);
        if (apdList == null || apdList.isEmpty()) {
            throw new NullPointerException(apno);
        }
        try {
            List<Apmpad> apmpadList = new ArrayList<>();
            short i = 0;
            apmsysBean.setCompany(facno);
            String payno = apmsysBean.getFormId(facno, "APM525", payda, Boolean.TRUE);
            for (Apmapd apd : apdList) {
                // 此处没有处理合并逻辑
                i++;
                Apmpad apmpad = new Apmpad(facno, '2', payno, i);
                apmpad.setAccno(accno);
                apmpad.setConfig(config);
                apmpad.setDramt(apd.getApamt());
                apmpad.setCramt(BigDecimal.ZERO);
                apmpad.setDramtfs(apd.getAcpamtfs());
                apmpad.setCramtfs(BigDecimal.ZERO);
                apmpad.setCoin(apd.getCoin());
                apmpad.setRatio(apd.getRatio());
                apmpad.setCuskind("PJ");
                apmpad.setVdrno(aph.getVdrno());
                apmpad.setVdrna(aph.getVdrna());
                apmpad.setTnfamt(BigDecimal.ZERO);
                apmpad.setTnfamtfs(BigDecimal.ZERO);
                apmpad.setRefno(apno);
                apmpad.setRefamt(BigDecimal.ZERO);
                apmpad.setRefamtfs(BigDecimal.ZERO);
                apmpad.setVouseq(i);
                apmpad.setTrntype("");
                // 加入列表
                apmpadList.add(apmpad);
            }
            ApmpayPK pk = new ApmpayPK(facno, '2', payno);
            Apmpay apmpay = new Apmpay(pk);
            apmpay.setRkd(rkd);
            apmpay.setPayda(payda);
            apmpay.setUsrno(oah.getAppuser());
            apmpay.setDepno(oah.getAppdept());
            apmpay.setPaystat('0');
            apmpay.setSumry(aph.getHmark() != null ? aph.getHmark() : "");
            apmpay.setTaxym("");
            apmpay.setSrckind("H");
            accrnoBean.setCompany(facno);
            apmpay.setVouno(accrnoBean.getFormId(facno, payda, Boolean.TRUE)); // 设置初稿传票编号
            // 保存表头
            persist(apmpay);
            getEntityManager().flush();
            // 保存明细
            apmpadBean.setCompany(facno);
            for (Apmpad apmpad : apmpadList) {
                apmpadBean.persist(apmpad);
            }
            // 更新APM828请款状态
            aph.setOano(oah.getProcessSerialNumber().substring(4));
            aph.setRefno(payno);
            aph.setApsta("30");
            apmaphBean.update(aph);
            return true;
        } catch (Exception ex) {
            log4j.error(ex);
            throw new RuntimeException(ex);
        }
    }

    public Boolean initByOABXD(String psn) {
        String period;
        Date date;
        HZCW028 b = hzcw028Bean.findByPSN(psn);
        String facno = b.getFacno();
        List<BudgetDetail> budgetDetails = new ArrayList<>();
        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate())); // 付款日期
            period = BaseLib.formatDate("yyyyMM", date);
            apmsysBean.setCompany(facno);
            ApmpayPK pk = new ApmpayPK();
            pk.setFacno(facno);
            pk.setPaycode('2');
            pk.setPayno(apmsysBean.getFormId(facno, "APM525", date, Boolean.TRUE));
            setCompany(facno);
            Apmpay h = new Apmpay();
            h.setApmpayPK(pk);
            h.setPayda(date);
            accrnoBean.setCompany(facno);
            h.setVouno(accrnoBean.getFormId(facno, date, Boolean.TRUE)); // 设置初稿传票编号
            h.setDepno(b.getAppDept()); // 取得OA预算部门
            h.setRkd("MR01");
            h.setSumry(b.getSummary()); // 取得OA报销摘要
            h.setUsrno(b.getCreator()); // OA表单输入人员
            // h.setAppuserno(b.getAppUser()); //OA请款人
            h.setTaxym(BaseLib.formatDate("yyyyMM", date)); // 取得OA请款日期设置申报年月
            h.setBilltype("HZ_CW028"); // 取得OA表单名称
            h.setSrcno(b.getProcessSerialNumber()); // 取得OA表单序列号
            h.setPaystat('0'); // 设置付款状态
            h.setSrckind("3"); // 设置来源区分码
            List<HZCW028reDetail> details01 = hzcw028reDetailBean.findByFSN(b.getFormSerialNumber());
            List<Apmpad> apmpads = new ArrayList<>();
            accacrBean.setCompany(facno);
            for (int i = 0; i < details01.size(); i++) {
                Apmpad apmpad = new Apmpad();
                ApmpadPK apmpadPK = new ApmpadPK();
                apmpadPK.setFacno(facno);
                apmpadPK.setPaycode('2');
                apmpadPK.setPayno(pk.getPayno());
                apmpadPK.setTrse((short)(i + 1));
                apmpad.setApmpadPK(apmpadPK);
                HZCW028reDetail detail0l = details01.get(i);
                apmpad.setAccno(detail0l.getAccno()); // 设置会计科目
                apmpad.setCoin(b.getCoin()); // 设置币别
                apmpad.setRatio(BigDecimal.valueOf(b.getRatio())); // 设置汇率
                if ("53".equals(apmpad.getAccno().substring(0, 2))) {
                    apmpad.setCuskind("9J");
                    apmpad.setVdrno(detail0l.getResearch());
                    miscode = miscodeBean.findByPK("9J", apmpad.getVdrno());
                    if (miscode != null) {
                        apmpad.setVdrna(miscode.getCdesc());
                    }
                } else {
                    apmpad.setCuskind("GE"); // 设置对象代号类别（cuskind）
                    apmpad.setVdrno(detail0l.getBudgetDepttxt()); // 设置费用部门（预算部门）
                    apmpad.setVdrna(detail0l.getBudgetDeptlbl());
                }
                apmpad.setTnfamt(BigDecimal.ZERO); // 本次冲账金额
                apmpad.setTnfamtfs(BigDecimal.ZERO); // 本次冲账金额
                // apmpad.setRefno(""); //对应相关单号目前为空白
                apmpad.setRefamtfs(BigDecimal.ZERO); // 对应相关金额
                apmpad.setRefamt(BigDecimal.ZERO); // 对应相关金额
                if (b.getTotaltaxesRMB() > 0) {
                    double d1 = Double.parseDouble(detail0l.getNotaxes());
                    apmpad.setDramtfs(BigDecimal.valueOf(d1)); // 设置dramtfs借方原币
                    double d2 = (d1 * (b.getRatio()));
                    apmpad.setDramt(BigDecimal.valueOf(d2)); // 设置dramt借方人民币
                } else {
                    double d1 = detail0l.getTaxInclusive();
                    apmpad.setDramtfs(BigDecimal.valueOf(d1)); // 设置dramtfs借方原币
                    double d2 = (d1 * (b.getRatio()));
                    apmpad.setDramt(BigDecimal.valueOf(d2)); // 设置dramt借方人民币
                }
                apmpad.setCramtfs(BigDecimal.ZERO);
                apmpad.setCramt(BigDecimal.ZERO);
                apmpad.setVouseq((short)(3)); // 对应相关序号
                apmpad.setTrntype(""); // 设置交易种类
                apmpad.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad.getAccno(), 'D')); // 设置config参数
                apmpads.add(apmpad);
                // 预算金额更新逻辑
                BudgetDetail u;
                u = new BudgetDetail(facno, "", period, detail0l.getCenterid(), detail0l.getAccno(), "R",
                    apmpadPK.getTrse(), BigDecimal.ZERO, BigDecimal.ZERO,
                    BigDecimal.valueOf(detail0l.getTaxInclusive() * (b.getRatio())), BigDecimal.ZERO);
                u.setPreamts(u.getPreamts().subtract(u.getDecramts()));
                budgetDetails.add(u);
            }
            // 如果有税额就增加一笔税金明细
            if (b.getTotaltaxesRMB() > 0) {
                Apmpad apmpad = new Apmpad();
                ApmpadPK apmpadPK = new ApmpadPK();
                apmpadPK.setFacno(facno);
                apmpadPK.setPaycode('2');
                apmpadPK.setPayno(pk.getPayno());
                apmpadPK.setTrse((short)(details01.size() + 1));
                apmpad.setApmpadPK(apmpadPK);
                apmpad.setDramt(BigDecimal.ZERO);
                apmpad.setDramtfs(BigDecimal.ZERO);
                apmpad.setCoin(b.getCoin()); // 设置币别
                apmpad.setRatio(BigDecimal.valueOf(b.getRatio())); // 设置汇率
                apmpad.setDramtfs(BigDecimal.valueOf(b.getTotaltaxesRMB())); // 设置dramtfs借方原币税金
                apmpad.setDramt(BigDecimal.valueOf(b.getTotaltaxesRMB() * b.getRatio())); // 设置dramt借方本币税金人民币
                apmpad.setCramtfs(BigDecimal.ZERO);
                apmpad.setCramt(BigDecimal.ZERO);
                apmpad.setTnfamt(BigDecimal.ZERO); // 本次冲账金额本币
                apmpad.setTnfamtfs(BigDecimal.ZERO); // 本次冲账金额原币
                apmpad.setRefamt(BigDecimal.ZERO); // 对应相关金额本币
                apmpad.setRefamtfs(BigDecimal.ZERO); // 对应相关金额原币
                apmpad.setAccno("2222");
                apmpad.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad.getAccno(), 'D')); // 设置config参数
                apmpads.add(apmpad);
            }
            // 生成贷方明细固定了科目2242其他应付款-员工报销
            Apmpad apmpad2 = new Apmpad();
            ApmpadPK apmpadPK2 = new ApmpadPK();
            apmpadPK2.setFacno(facno);
            apmpadPK2.setPaycode('2');
            apmpadPK2.setPayno(pk.getPayno());
            if (b.getTotaltaxesRMB() > 0) {
                apmpadPK2.setTrse((short)(details01.size() + 2));
            } else {
                apmpadPK2.setTrse((short)(details01.size() + 1));
            }
            apmpad2.setApmpadPK(apmpadPK2);
            apmpad2.setDramt(BigDecimal.ZERO);
            apmpad2.setDramtfs(BigDecimal.ZERO);
            apmpad2.setCoin(b.getCoin()); // 设置币别
            apmpad2.setRatio(BigDecimal.valueOf(b.getRatio())); // 设置汇率
            apmpad2.setCramt(BigDecimal.valueOf(b.getTotaltaxInclusiveRMB())); // 设置贷方本币
            apmpad2.setCramtfs(BigDecimal.valueOf(b.getTotaltaxInclusive())); // 设置贷方原币
            apmpad2.setTnfamt(BigDecimal.ZERO); // 本次冲账金额本币
            apmpad2.setTnfamtfs(BigDecimal.ZERO); // 本次冲账金额原币
            apmpad2.setRefamt(BigDecimal.ZERO); // 对应相关金额本币
            apmpad2.setRefamtfs(BigDecimal.ZERO); // 对应相关金额原币
            apmpad2.setAccno("2242");
            apmpad2.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad2.getAccno(), 'C')); // 设置config参数
            apmpad2.setCuskind("9E");
            apmpad2.setVdrno(b.getAppUser());
            miscode = miscodeBean.findByPK("9E", b.getAppUser());
            if (miscode != null) {
                apmpad2.setVdrna(miscode.getCdesc());
            }
            apmpads.add(apmpad2);
            // 因为外键关联,无法直接使用EclipseLink批量更新,先更新表头再逐笔更新明细
            // HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
            // detailAdded.put(apmpadBean, apmpads);
            persist(h);
            getEntityManager().flush();
            apmpadBean.setCompany(facno);
            for (Apmpad apmpad : apmpads) {
                apmpadBean.persist(apmpad);
            }
            budgetDetailBean.setCompany(facno);
            budgetDetailBean.add(budgetDetails);
            budgetDetailBean.getEntityManager().flush();

            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Boolean initByOAJZD(String psn) {

        HZCW017 j = jzdBean.findByPSN(psn);
        String facno = j.getFacno();
        Date date;
        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate())); // 付款日期
            Apmpay h = new Apmpay();
            apmsysBean.setCompany(facno);
            ApmpayPK pk = new ApmpayPK();
            pk.setFacno(facno);
            pk.setPaycode('2');
            pk.setPayno(apmsysBean.getFormId(facno, "APM525", date, Boolean.TRUE));
            setCompany(facno);
            h.setApmpayPK(pk);
            h.setPayda(date);
            accrnoBean.setCompany(facno);
            h.setVouno(accrnoBean.getFormId(facno, date, Boolean.TRUE)); // 设置初稿传票编号
            h.setDepno(j.getLoanDept()); // 取得OA预算部门
            h.setRkd("MR01");
            // h.setSumry(""); //取得OA报销摘要
            h.setUsrno(j.getCreator()); // OA表单输入人员
            // h.setAppuserno(j.getLoanUser()); //OA请款人
            h.setTaxym(BaseLib.formatDate("yyyyMM", date)); // 取得OA请款日期设置申报年月
            h.setBilltype("HZ_CW017"); // 取得OA表单名称
            h.setSrcno(j.getProcessSerialNumber()); // 取得OA表单序列号
            h.setPaystat('0'); // 设置付款状态
            h.setSrckind("3"); // 设置来源区分码
            List<Apmpad> apmpads = new ArrayList<>();
            Apmpad apmpad = new Apmpad();
            ApmpadPK apmpadPK = new ApmpadPK();
            apmpadPK.setFacno(facno);
            apmpadPK.setPaycode('2');
            apmpadPK.setPayno(pk.getPayno());
            apmpadPK.setTrse((short)(1));
            apmpad.setApmpadPK(apmpadPK);
            apmpad.setAccno("1221"); // 设置会计科目
            apmpad.setCoin(j.getCoin()); // 设置币别
            apmpad.setRatio(BigDecimal.valueOf(j.getRatio())); // 设置汇率
            apmpad.setCuskind("9E"); // 设置对象代号类别cuskind
            apmpad.setVdrno(j.getLoanUser()); // 设置费用部门（预算部门）
            miscode = miscodeBean.findByPK("9E", j.getLoanUser());
            if (miscode != null) {
                apmpad.setVdrna(miscode.getCdesc());
            }
            apmpad.setTnfamtfs(BigDecimal.ZERO); // 本次冲账金额原币
            apmpad.setTnfamt(BigDecimal.ZERO); // 本次冲账金额本币
            // apmpad.setRefno(""); //对应相关单号
            apmpad.setRefamtfs(BigDecimal.ZERO); // 对应相关金额原币
            apmpad.setRefamt(BigDecimal.ZERO); // 对应相关金额本币
            apmpad.setDramtfs(BigDecimal.valueOf(j.getLoanTotal())); // 设置dramtfs借方原币
            apmpad.setDramt(BigDecimal.valueOf(j.getTotalRMB())); // 设置dramt借方本币人民币
            apmpad.setCramtfs(BigDecimal.ZERO);
            apmpad.setCramt(BigDecimal.ZERO);
            apmpad.setVouseq((short)(1)); // 对应相关序号
            apmpad.setTrntype(""); // 设置交易种类
            accacrBean.setCompany(facno);
            apmpad.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad.getAccno(), 'D'));// 设置config参数
            apmpads.add(apmpad);
            Apmpad apmpad2 = new Apmpad();
            ApmpadPK apmpadPK2 = new ApmpadPK();
            apmpadPK2.setFacno(facno);
            apmpadPK2.setPaycode('2');
            apmpadPK2.setPayno(pk.getPayno());
            apmpadPK2.setTrse((short)(2));
            apmpad2.setApmpadPK(apmpadPK2);
            apmpad2.setAccno("1001"); // 设置会计科目
            apmpad2.setCoin(j.getCoin()); // 设置币别
            apmpad2.setRatio(BigDecimal.valueOf(j.getRatio())); // 设置汇率
            // apmpad2.setCuskind("NB"); //设置对象代号类别cuskind
            // apmpad.setVdrno(j.getLoanUser()); //设置费用部门（预算部门）
            // apmpad.setVdrna();
            apmpad2.setTnfamt(BigDecimal.ZERO);
            apmpad2.setTnfamtfs(BigDecimal.ZERO);
            // apmpad.setRefno("");
            apmpad2.setRefamtfs(BigDecimal.ZERO);
            apmpad2.setRefamt(BigDecimal.ZERO);
            apmpad2.setDramtfs(BigDecimal.ZERO);
            apmpad2.setDramt(BigDecimal.ZERO);
            apmpad2.setCramtfs(BigDecimal.valueOf(j.getTotalRMB()));
            apmpad2.setCramt(BigDecimal.valueOf(j.getTotalRMB()));
            apmpad2.setVouseq((short)(2)); // 对应相关序号
            apmpad2.setTrntype(""); // 设置交易种类
            apmpad2.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad2.getAccno(), 'C')); // 设置config参数
            apmpads.add(apmpad2);
            persist(h);
            getEntityManager().flush();
            apmpadBean.setCompany(facno);
            for (Apmpad apm : apmpads) {
                apmpadBean.persist(apm);
            }
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public Boolean initByOAJZGHD(String psn) {
        List<BudgetDetail> budgetDetails = new ArrayList<>();
        HZCW033 g = jzghdBean.findByPSN(psn);
        String facno = g.getFacno();
        Date date;
        String period;
        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate())); // 付款日期
            period = BaseLib.formatDate("yyyyMM", date);
            Apmpay h = new Apmpay();
            apmsysBean.setCompany(facno);
            ApmpayPK pk = new ApmpayPK();
            pk.setFacno(facno);
            pk.setPaycode('2');
            pk.setPayno(apmsysBean.getFormId(facno, "APM525", date, Boolean.TRUE));
            setCompany(facno);
            h.setApmpayPK(pk);
            h.setPayda(date);
            accrnoBean.setCompany(facno);
            h.setVouno(accrnoBean.getFormId(facno, date, Boolean.TRUE)); // 设置初稿传票编号
            h.setDepno(g.getAppDept()); // 取得OA预算部门
            h.setRkd("MR01");
            // h.setSumry(""); //取得OA报销摘要
            h.setUsrno(g.getCreator()); // OA表单输入人员
            // h.setAppuserno(g.getAppUser()); //OA请款人
            h.setTaxym(BaseLib.formatDate("yyyyMM", date)); // 取得OA请款日期设置申报年月
            h.setBilltype("HZ_CW033"); // 取得OA表单名称
            h.setSrcno(g.getProcessSerialNumber()); // 取得OA表单序列号
            h.setPaystat('0'); // 设置付款状态
            h.setSrckind("3"); // 设置来源区分码
            List<HZCW033reDetail> reDetail = jzghdreDetailBean.findByFSN(g.getFormSerialNumber());
            List<Apmpad> apmpads = new ArrayList<>();
            HZCW017 j = jzdBean.findByPSN(reDetail.get(0).getLoanNo());
            accacrBean.setCompany(facno);
            for (int i = 0; i < reDetail.size(); i++) {
                Apmpad apmpad = new Apmpad();
                ApmpadPK apmpadPK = new ApmpadPK();
                apmpadPK.setFacno(facno);
                apmpadPK.setPaycode('2');
                apmpadPK.setPayno(pk.getPayno());
                apmpadPK.setTrse((short)(i + 1));
                apmpad.setApmpadPK(apmpadPK);
                HZCW033reDetail detail0l = reDetail.get(i);
                apmpad.setAccno(detail0l.getAccno()); // 设置会计科目
                apmpad.setCoin(g.getCoin()); // 设置币别
                apmpad.setRatio(BigDecimal.valueOf(g.getRatio())); // 设置汇率
                if ("53".equals(apmpad.getAccno().substring(0, 2))) {
                    apmpad.setCuskind("9J");
                    apmpad.setVdrno(detail0l.getResearch());
                    miscode = miscodeBean.findByPK("9J", detail0l.getResearch());
                    if (miscode != null) {
                        apmpad.setVdrna(miscode.getCdesc());
                    }
                } else {
                    apmpad.setCuskind("GE"); // 设置对象代号类别（cuskind）
                    apmpad.setVdrno(detail0l.getBudgetDepttxt()); // 设置费用部门（预算部门）
                    apmpad.setVdrna(detail0l.getBudgetDeptlbl());
                }
                apmpad.setTnfamt(BigDecimal.ZERO);
                apmpad.setTnfamtfs(BigDecimal.ZERO);
                // apmpad.setRefno("");
                apmpad.setRefamtfs(BigDecimal.ZERO);
                apmpad.setRefamt(BigDecimal.ZERO);

                if (g.getTotaltaxesRMB() > 0) {
                    double d1 = Double.parseDouble(detail0l.getNotaxes());
                    apmpad.setDramtfs(BigDecimal.valueOf(d1)); // 设置dramtfs借方原币

                    double d2 = (d1 * (g.getRatio()));
                    apmpad.setDramt(BigDecimal.valueOf(d2)); // 设置dramt借方本币
                } else {
                    double d1 = detail0l.getTaxInclusive();
                    apmpad.setDramtfs(BigDecimal.valueOf(d1)); // 设置dramtfs借方原币
                    double d2 = (d1 * (g.getRatio()));
                    apmpad.setDramt(BigDecimal.valueOf(d2)); // 设置dramt借方本币
                }
                apmpad.setCramtfs(BigDecimal.ZERO);
                apmpad.setCramt(BigDecimal.ZERO);
                apmpad.setVouseq((short)(3)); // 对应相关序号
                apmpad.setTrntype(""); // 设置交易种类
                apmpad.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad.getAccno(), 'D')); // 设置config参数
                apmpads.add(apmpad);
                // 预算金额更新逻辑
                BudgetDetail u;
                u = new BudgetDetail(facno, "", period, detail0l.getCenterid(), detail0l.getAccno(), "R",
                    apmpadPK.getTrse(), BigDecimal.ZERO, BigDecimal.ZERO,
                    BigDecimal.valueOf(detail0l.getTaxInclusive() * (g.getRatio())), BigDecimal.ZERO);
                u.setPreamts(u.getPreamts().subtract(u.getDecramts()));
                budgetDetails.add(u);
            }
            // 如果有税额就增加一笔税金明细
            if (g.getTotaltaxesRMB() > 0) {
                Apmpad apmpad2 = new Apmpad();
                ApmpadPK apmpadPK2 = new ApmpadPK();
                apmpadPK2.setFacno(facno);
                apmpadPK2.setPaycode('2');
                apmpadPK2.setPayno(pk.getPayno());
                apmpadPK2.setTrse((short)(apmpads.size() + 1));
                apmpad2.setApmpadPK(apmpadPK2);
                apmpad2.setDramt(BigDecimal.ZERO);
                apmpad2.setDramtfs(BigDecimal.ZERO);
                apmpad2.setCoin(g.getCoin()); // 设置币别
                apmpad2.setRatio(BigDecimal.valueOf(g.getRatio())); // 设置汇率
                apmpad2.setDramtfs(BigDecimal.valueOf(g.getTotaltaxesRMB() / g.getRatio()));// 设置dramtfs借方原币
                apmpad2.setDramt(BigDecimal.valueOf(g.getTotaltaxesRMB())); // 设置dramt借方本币
                apmpad2.setCramtfs(BigDecimal.ZERO);
                apmpad2.setCramt(BigDecimal.ZERO);
                apmpad2.setTnfamt(BigDecimal.ZERO);
                apmpad2.setTnfamtfs(BigDecimal.ZERO);
                apmpad2.setRefamtfs(BigDecimal.ZERO);
                apmpad2.setRefamt(BigDecimal.ZERO);
                apmpad2.setAccno("2222");
                apmpad2.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad2.getAccno(), 'D'));// 设置config参数
                apmpads.add(apmpad2);
            }
            // 处理退还现金逻辑
            if (g.getTotalRefund() > 0) {
                Apmpad apmpad3 = new Apmpad();
                ApmpadPK apmpadPK3 = new ApmpadPK();
                apmpadPK3.setFacno(facno);
                apmpadPK3.setPaycode('2');
                apmpadPK3.setPayno(pk.getPayno());
                apmpadPK3.setTrse((short)(apmpads.size() + 1));
                apmpad3.setApmpadPK(apmpadPK3);
                apmpad3.setAccno("1001"); // 设置会计科目
                apmpad3.setCoin(g.getCoin()); // 设置币别
                apmpad3.setRatio(BigDecimal.valueOf(g.getRatio())); // 设置汇率
                // apmpad.setCuskind("NB"); //设置对象代号类别cuskind
                // apmpad.setVdrno(j.getLoanUser()); //设置费用部门（预算部门）
                // apmpad.setVdrna();
                apmpad3.setTnfamt(BigDecimal.ZERO);
                apmpad3.setTnfamtfs(BigDecimal.ZERO);
                // apmpad.setRefno("");
                apmpad3.setRefamtfs(BigDecimal.ZERO);
                apmpad3.setRefamt(BigDecimal.ZERO);

                apmpad3.setCramtfs(BigDecimal.ZERO);
                apmpad3.setCramt(BigDecimal.ZERO);
                apmpad3.setDramtfs(BigDecimal.valueOf(g.getTotalRefund()));
                apmpad3.setDramt(BigDecimal.valueOf(g.getTotalRefund() * (g.getRatio())));
                // apmpad.setVouseq((short) (2)); //对应相关序号
                apmpad3.setTrntype(""); // 设置交易种类
                apmpad3.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad3.getAccno(), 'D')); // 设置config参数
                apmpads.add(apmpad3);
            }
            // 处理贷方明细
            if (g.getTotalRefund() + g.getTotaltaxInclusive() <= reDetail.get(0).getApplyAmount()) {
                Apmpad apmpad4 = new Apmpad();
                ApmpadPK apmpadPK4 = new ApmpadPK();
                apmpadPK4.setFacno(facno);
                apmpadPK4.setPaycode('2');
                apmpadPK4.setPayno(pk.getPayno());
                apmpadPK4.setTrse((short)(apmpads.size() + 1));
                apmpad4.setApmpadPK(apmpadPK4);
                apmpad4.setDramt(BigDecimal.ZERO);
                apmpad4.setDramtfs(BigDecimal.ZERO);
                apmpad4.setCoin(g.getCoin()); // 设置币别
                apmpad4.setRatio(BigDecimal.valueOf(g.getRatio())); // 设置汇率
                double c2 = g.getTotaltaxInclusive() + g.getTotalRefund();
                apmpad4.setCramtfs(BigDecimal.valueOf(c2)); // 设置cramtfs报销总额原币
                double c1 = g.getRatio() * c2;
                apmpad4.setCramt(BigDecimal.valueOf(c1)); // 设置cramt报销总额本币
                apmpad4.setTnfamt(BigDecimal.ZERO);
                apmpad4.setTnfamtfs(BigDecimal.ZERO);
                apmpad4.setRefamtfs(BigDecimal.ZERO);
                apmpad4.setRefamt(BigDecimal.ZERO);
                apmpad4.setAccno("1221");
                apmpad4.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad4.getAccno(), 'C')); // 设置config参数
                apmpad4.setCuskind("9E");
                apmpad4.setVdrno(g.getAppUser());
                miscode = miscodeBean.findByPK("9E", g.getAppUser());
                if (miscode != null) {
                    apmpad4.setVdrna(miscode.getCdesc());
                }
                apmpads.add(apmpad4);
                g.setApplyAmount(j.getArrears() - g.getTotalRefund() - g.getTotaltaxInclusive());
                j.setArrears(g.getApplyAmount());

            }
            if (g.getTotalRefund() + g.getTotaltaxInclusive() > reDetail.get(0).getApplyAmount()) {
                Apmpad apmpad5 = new Apmpad();
                ApmpadPK apmpadPK5 = new ApmpadPK();
                apmpadPK5.setFacno(facno);
                apmpadPK5.setPaycode('2');
                apmpadPK5.setPayno(pk.getPayno());
                apmpadPK5.setTrse((short)(apmpads.size() + 1));
                apmpad5.setApmpadPK(apmpadPK5);
                apmpad5.setDramt(BigDecimal.ZERO);
                apmpad5.setDramtfs(BigDecimal.ZERO);
                apmpad5.setCoin(g.getCoin()); // 设置币别
                apmpad5.setRatio(BigDecimal.valueOf(g.getRatio())); // 设置汇率
                double c2 = reDetail.get(0).getApplyAmount();
                apmpad5.setCramtfs(BigDecimal.valueOf(c2)); // 设置 cramtfs(报销总额原币)
                double c1 = g.getRatio() * c2;
                apmpad5.setCramt(BigDecimal.valueOf(c1)); // 设置 cramt(人民币报销 总额)
                apmpad5.setTnfamt(BigDecimal.ZERO);
                apmpad5.setTnfamtfs(BigDecimal.ZERO);
                apmpad5.setRefamtfs(BigDecimal.ZERO);
                apmpad5.setRefamt(BigDecimal.ZERO);
                apmpad5.setAccno("1221");
                apmpad5.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad5.getAccno(), 'C')); // 设置config参数
                apmpad5.setCuskind("9E");
                apmpad5.setVdrno(g.getAppUser());
                miscode = miscodeBean.findByPK("9E", g.getAppUser());
                if (miscode != null) {
                    apmpad5.setVdrna(miscode.getCdesc());
                }
                apmpads.add(apmpad5);
                Apmpad apmpad6 = new Apmpad();
                ApmpadPK apmpadPK6 = new ApmpadPK();
                apmpadPK6.setFacno(facno);
                apmpadPK6.setPaycode('2');
                apmpadPK6.setPayno(pk.getPayno());
                apmpadPK6.setTrse((short)(apmpads.size() + 1));
                apmpad6.setDramt(BigDecimal.ZERO);
                apmpad6.setDramtfs(BigDecimal.ZERO);
                apmpad6.setCoin(g.getCoin()); // 设置币别
                apmpad6.setRatio(BigDecimal.valueOf(g.getRatio())); // 设置汇率
                double c3 = g.getTotalRefund() + g.getTotaltaxInclusive() - reDetail.get(0).getApplyAmount();
                apmpad6.setCramtfs(BigDecimal.valueOf(c3)); // 设置cramtfs报销总额原币
                double c4 = c3 * g.getRatio();
                apmpad6.setCramt(BigDecimal.valueOf(c4)); // 设置cramt报销总额本币
                apmpad6.setApmpadPK(apmpadPK6);
                apmpad6.setTnfamt(BigDecimal.ZERO);
                apmpad6.setTnfamtfs(BigDecimal.ZERO);
                apmpad6.setRefamtfs(BigDecimal.ZERO);
                apmpad6.setRefamt(BigDecimal.ZERO);
                apmpad6.setAccno("2242");
                apmpad6.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad6.getAccno(), 'C')); // 设置config参数
                apmpad6.setCuskind("9E");
                apmpad6.setVdrno(g.getAppUser());
                miscode = miscodeBean.findByPK("9E", g.getAppUser());
                if (miscode != null) {
                    apmpad6.setVdrna(miscode.getCdesc());
                }
                apmpads.add(apmpad6);
                // g.setApplyAmount(0.00);
                j.setArrears(0.00);

            }
            /// HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
            // detailAdded.put(apmpadBean, apmpads);
            persist(h);
            getEntityManager().flush();
            apmpadBean.setCompany(facno);
            for (Apmpad apmpad : apmpads) {
                apmpadBean.persist(apmpad);
            }
            jzdBean.update(j);
            budgetDetailBean.setCompany(facno);
            budgetDetailBean.add(budgetDetails);
            budgetDetailBean.getEntityManager().flush();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Boolean subtractBudgetPlanByOABXD(String psn) {
        return budgetDetailBean.subtractByOABXD(psn);
    }

    public Boolean subtractBudgetPlanByOAJZD(String psn) {
        return budgetDetailBean.subtractByOAJZD(psn);
    }

    public Boolean subtractBudgetPlanByOAJZGHD(String psn) {
        return budgetDetailBean.subtractByOAJZGHD(psn);
    }

}
