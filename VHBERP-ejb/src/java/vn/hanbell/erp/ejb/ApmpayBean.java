/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import cn.hanbell.oa.ejb.VHTV001Bean;
import cn.hanbell.oa.ejb.VHTV002Bean;
import cn.hanbell.oa.ejb.VHTV003Bean;
import cn.hanbell.oa.entity.VHTV001;
import cn.hanbell.oa.entity.VHTV002;
import cn.hanbell.oa.entity.VHTV002reDetail;
import cn.hanbell.oa.entity.VHTV003;
import cn.hanbell.oa.entity.VHTV003reDetail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Apmpad;
import vn.hanbell.erp.entity.ApmpadPK;
import vn.hanbell.erp.entity.Apmpay;
import vn.hanbell.erp.entity.ApmpayPK;
import vn.hanbell.erp.entity.BudgetDetail;
import vn.hanbell.erp.entity.Miscode;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ApmpayBean extends SuperEJBForERP<Apmpay>{
    @EJB
    private VHTV003Bean vhtv003Bean;
    @EJB
    private VHTV001Bean vhtv001Bean;
    @EJB
    private VHTV002Bean vhtv002Bean;
    @EJB
    private ApmsysBean apmsysBean;
    @EJB
    private AccrnoBean accrnoBean;
    @EJB
    private AccacrBean accacrBean;
    @EJB
    private ApmpadBean apmpadBean;
    @EJB
    private BudgetDetailBean budgetDetailBean;
    public ApmpayBean() {
        super(Apmpay.class);
    }
    
    public Boolean initByOAVHTV003(String psn) {
        String period;
        Date date;
        VHTV003 v = vhtv003Bean.findByPSN(psn);
        String facno = v.getFacno();
        List<BudgetDetail> budgetDetails = new ArrayList<>();

        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate())); //付款日期
            period = BaseLib.formatDate("yyyyMM", date);

            ApmpayPK pk = new ApmpayPK();
            pk.setFacno(facno);
            pk.setPaycode('2');
            pk.setPayno(apmsysBean.getFormId(facno, "APM525", date, Boolean.TRUE));

            Apmpay h = new Apmpay();
            h.setApmpayPK(pk);
            h.setPayda(date);
            h.setVouno(accrnoBean.getFormId(facno, date, Boolean.TRUE));        //设置初稿传票编号

            h.setDepno(v.getAppDept());                                         //取得OA预算部门
            h.setRkd("MR01");
            h.setSumry(v.getSummary());                                         //取得OA报销摘要
            h.setUsrno(v.getCreator());                                         //OA表单输入人员
            //h.setAppuserno(b.getAppUser());                                   //OA请款人
            h.setTaxym(BaseLib.formatDate("yyyyMM", date));                     //取得OA请款日期设置申报年月
            //h.setBilltype("VH_TV003");                                        //取得OA表单名称
            //h.setSrcno(v.getProcessSerialNumber());                           //取得OA表单序列号
            h.setPaystat('0');                                                  //设置付款状态
            h.setSrckind("3");                                                  //设置来源区分码

            List<VHTV003reDetail> details01 = vhtv003Bean.getDetailList(v.getFormSerialNumber());
            List<Apmpad> apmpads = new ArrayList<>();
            for (int i = 0; i < details01.size(); i++) {
                Apmpad apmpad = new Apmpad();
                ApmpadPK apmpadPK = new ApmpadPK();
                apmpadPK.setFacno(facno);
                apmpadPK.setPaycode('2');
                apmpadPK.setPayno(pk.getPayno());
                apmpadPK.setTrse((short) (i + 1));
                apmpad.setApmpadPK(apmpadPK);
                VHTV003reDetail detail0l = details01.get(i);
                apmpad.setAccno(detail0l.getAccno());                           //设置会计科目
                apmpad.setCoin(v.getCoin());                                    //设置币别
                apmpad.setRatio(BigDecimal.valueOf(v.getRatio()));              //设置汇率

                if ("53".equals(apmpad.getAccno().substring(0, 2))) {
                    apmpad.setCuskind("9J");
                    apmpad.setVdrno(detail0l.getResearch());
                    Miscode miscode = miscodeBean.findByPK("9J", apmpad.getVdrno());
                    if (miscode != null) {
                        apmpad.setVdrna(miscode.getCdesc());
                    }
                } else {
                    apmpad.setCuskind("GE");                                    //设置对象代号类别（cuskind）
                    apmpad.setVdrno(detail0l.getBudgetDepttxt());               //设置费用部门（预算部门）
                    apmpad.setVdrna(detail0l.getBudgetDeptlbl());
                }
                apmpad.setTnfamt(BigDecimal.ZERO);                              //本次冲账金额
                apmpad.setTnfamtfs(BigDecimal.ZERO);                            //本次冲账金额
                //apmpad.setRefno("");  //对应相关单号目前为空白
                apmpad.setRefamtfs(BigDecimal.ZERO);                            //对应相关金额
                apmpad.setRefamt(BigDecimal.ZERO);                              //对应相关金额

                if (v.getTotaltaxesVND() > 0) {
                    double d1 = Double.parseDouble(detail0l.getNotaxes());
                    apmpad.setDramtfs(BigDecimal.valueOf(d1));                  //设置dramtfs借方原币

                    double d2 = (d1 * (v.getRatio()));
                    apmpad.setDramt(BigDecimal.valueOf(d2));                    //设置dramt借方越南盾
                } else {
                    double d1 = Double.valueOf(detail0l.getTaxInclusive());
                    apmpad.setDramtfs(BigDecimal.valueOf(d1));                  //设置dramtfs借方原币

                    double d2 = (d1 * (v.getRatio()));
                    apmpad.setDramt(BigDecimal.valueOf(d2));                    //设置dramt借方本币
                }
                apmpad.setCramtfs(BigDecimal.ZERO);
                apmpad.setCramt(BigDecimal.ZERO);
                apmpad.setVouseq((short) (3));                                  //对应相关序号
                apmpad.setTrntype("");  //设置交易种类

                apmpad.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad.getAccno(), 'D')); //设置config参数

                apmpads.add(apmpad);

                //预算金额更新逻辑
                BudgetDetail u;
                u = new BudgetDetail(facno, "", period, detail0l.getCenterid(), detail0l.getAccno(), "R", apmpadPK.getTrse(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(Double.valueOf(detail0l.getTaxInclusive()) * (v.getRatio())), BigDecimal.ZERO);
                u.setPreamts(u.getPreamts().subtract(u.getDecramts()));
                budgetDetails.add(u);

            }

            //如果有税额就增加一笔税金明细
            if (v.getTotaltaxesVND() > 0) {
                Apmpad apmpad = new Apmpad();
                ApmpadPK apmpadPK = new ApmpadPK();
                apmpadPK.setFacno(facno);
                apmpadPK.setPaycode('2');
                apmpadPK.setPayno(pk.getPayno());
                apmpadPK.setTrse((short) (details01.size() + 1));
                apmpad.setApmpadPK(apmpadPK);

                apmpad.setDramt(BigDecimal.ZERO);
                apmpad.setDramtfs(BigDecimal.ZERO);
                apmpad.setCoin(v.getCoin());                                   //设置币别
                apmpad.setRatio(BigDecimal.valueOf(v.getRatio()));             //设置汇率
                apmpad.setDramtfs(BigDecimal.valueOf(v.getTotaltaxesVND()));   //设置dramtfs借方越南盾税金
                apmpad.setDramt(BigDecimal.valueOf(v.getTotaltaxesVND() * v.getRatio()));  //设置dramt借方本币税金

                apmpad.setCramtfs(BigDecimal.ZERO);
                apmpad.setCramt(BigDecimal.ZERO);
                apmpad.setTnfamt(BigDecimal.ZERO);     //本次冲账金额本币
                apmpad.setTnfamtfs(BigDecimal.ZERO);   //本次冲账金额原币
                apmpad.setRefamt(BigDecimal.ZERO);     //对应相关金额本币
                apmpad.setRefamtfs(BigDecimal.ZERO);   //对应相关金额原币

                apmpad.setAccno("2222");
                apmpad.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad.getAccno(), 'D'));  //设置config参数

                apmpads.add(apmpad);

            }

            //生成贷方明细固定了科目2242其他应付款-员工报销
            Apmpad apmpad2 = new Apmpad();
            ApmpadPK apmpadPK2 = new ApmpadPK();
            apmpadPK2.setFacno(facno);
            apmpadPK2.setPaycode('2');
            apmpadPK2.setPayno(pk.getPayno());
            if (v.getTotaltaxesVND()> 0) {
                apmpadPK2.setTrse((short) (details01.size() + 2));
            } else {
                apmpadPK2.setTrse((short) (details01.size() + 1));
            }
            apmpad2.setApmpadPK(apmpadPK2);

            apmpad2.setDramt(BigDecimal.ZERO);
            apmpad2.setDramtfs(BigDecimal.ZERO);
            apmpad2.setCoin(v.getCoin());                                       //设置币别
            apmpad2.setRatio(BigDecimal.valueOf(v.getRatio()));                 //设置汇率
            apmpad2.setCramt(BigDecimal.valueOf(v.getTotaltaxInclusiveVND()));  //设置贷方本币
            apmpad2.setCramtfs(BigDecimal.valueOf(v.getTotaltaxInclusive()));   //设置贷方原币
            apmpad2.setTnfamt(BigDecimal.ZERO);     //本次冲账金额本币
            apmpad2.setTnfamtfs(BigDecimal.ZERO);   //本次冲账金额原币
            apmpad2.setRefamt(BigDecimal.ZERO);     //对应相关金额本币
            apmpad2.setRefamtfs(BigDecimal.ZERO);   //对应相关金额原币

            apmpad2.setAccno("2242");
            apmpad2.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad2.getAccno(), 'C'));  //设置config参数
            apmpad2.setCuskind("9E");
            apmpad2.setVdrno(v.getAppUser());
            Miscode miscode = miscodeBean.findByPK("9E", v.getAppUser());
            if (miscode != null) {
                apmpad2.setVdrna(miscode.getCdesc());
            }
            apmpads.add(apmpad2);

            //因为外键关联,无法直接使用EclipseLink批量更新,先更新表头再逐笔更新明细
            //HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
            //detailAdded.put(apmpadBean, apmpads);
            persist(h);
            getEntityManager().flush();

            for (Apmpad apmpad : apmpads) {
                apmpadBean.persist(apmpad);
            }

            budgetDetailBean.add(budgetDetails);
            budgetDetailBean.getEntityManager().flush();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(ApmpayBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
       public Boolean initByOAVHTV001(String psn) {

        VHTV001 j = vhtv001Bean.findByPSN(psn);
        Date date;
        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate())); //付款日期

            Apmpay h = new Apmpay();
            ApmpayPK pk = new ApmpayPK();
            pk.setFacno("V");
            pk.setPaycode('2');
            pk.setPayno(apmsysBean.getFormId("V", "APM525", date, Boolean.TRUE));

            h.setApmpayPK(pk);
            h.setPayda(date);

            h.setVouno(accrnoBean.getFormId("V", date, Boolean.TRUE));        //设置初稿传票编号

            h.setDepno(j.getLoanDept());                                        //取得OA预算部门
            h.setRkd("MR01");
            //h.setSumry("");                                                   //取得OA报销摘要
            h.setUsrno(j.getCreator());                                         //OA表单输入人员
            //h.setAppuserno(j.getLoanUser());                                  //OA请款人
            h.setTaxym(BaseLib.formatDate("yyyyMM", date));                     //取得OA请款日期设置申报年月
            //h.setBilltype("HZ_CW017");                                        //取得OA表单名称
            //h.setSrcno(j.getProcessSerialNumber());                           //取得OA表单序列号
            h.setPaystat('0');                                                  //设置付款状态
            h.setSrckind("3");                                                  //设置来源区分码

            List<Apmpad> apmpads = new ArrayList<>();
            Apmpad apmpad = new Apmpad();
            ApmpadPK apmpadPK = new ApmpadPK();
            apmpadPK.setFacno("V");
            apmpadPK.setPaycode('2');
            apmpadPK.setPayno(pk.getPayno());
            apmpadPK.setTrse((short) (1));
            apmpad.setApmpadPK(apmpadPK);

            apmpad.setAccno("1221");                                            //设置会计科目
            apmpad.setCoin(j.getCoin());                                        //设置币别
            apmpad.setRatio(BigDecimal.valueOf(j.getRatio()));                  //设置汇率

            apmpad.setCuskind("9E");                                            //设置对象代号类别cuskind
            apmpad.setVdrno(j.getLoanUser());                                   //设置费用部门（预算部门）
            Miscode miscode = miscodeBean.findByPK("9E", j.getLoanUser());
            if (miscode != null) {
                apmpad.setVdrna(miscode.getCdesc());
            }

            apmpad.setTnfamtfs(BigDecimal.ZERO);                                //本次冲账金额原币
            apmpad.setTnfamt(BigDecimal.ZERO);                                  //本次冲账金额本币
            //apmpad.setRefno("");                                              //对应相关单号
            apmpad.setRefamtfs(BigDecimal.ZERO);                                //对应相关金额原币
            apmpad.setRefamt(BigDecimal.ZERO);                                  //对应相关金额本币

            apmpad.setDramtfs(BigDecimal.valueOf(j.getLoanTotal()));            //设置dramtfs借方原币
            apmpad.setDramt(BigDecimal.valueOf(j.getTotalRMB()));               //设置dramt借方本币人民币

            apmpad.setCramtfs(BigDecimal.ZERO);
            apmpad.setCramt(BigDecimal.ZERO);
            apmpad.setVouseq((short) (1));                                      //对应相关序号
            apmpad.setTrntype("");                                              //设置交易种类

            apmpad.setConfig(accacrBean.getConfig("V", "APM", "3", h.getRkd(), apmpad.getAccno(), 'D'));//设置config参数
            apmpads.add(apmpad);

            Apmpad apmpad2 = new Apmpad();
            ApmpadPK apmpadPK2 = new ApmpadPK();
            apmpadPK2.setFacno("V");
            apmpadPK2.setPaycode('2');
            apmpadPK2.setPayno(pk.getPayno());
            apmpadPK2.setTrse((short) (2));
            apmpad2.setApmpadPK(apmpadPK2);

            apmpad2.setAccno("1001");                                           //设置会计科目
            apmpad2.setCoin(j.getCoin());                                       //设置币别
            apmpad2.setRatio(BigDecimal.valueOf(j.getRatio()));                 //设置汇率

            //apmpad2.setCuskind("NB");                                         //设置对象代号类别cuskind
            //apmpad.setVdrno(j.getLoanUser());                                 //设置费用部门（预算部门）
            //apmpad.setVdrna();
            apmpad2.setTnfamt(BigDecimal.ZERO);
            apmpad2.setTnfamtfs(BigDecimal.ZERO);
            //apmpad.setRefno("");
            apmpad2.setRefamtfs(BigDecimal.ZERO);
            apmpad2.setRefamt(BigDecimal.ZERO);

            apmpad2.setDramtfs(BigDecimal.ZERO);
            apmpad2.setDramt(BigDecimal.ZERO);
            apmpad2.setCramtfs(BigDecimal.valueOf(j.getTotalRMB()));
            apmpad2.setCramt(BigDecimal.valueOf(j.getTotalRMB()));
            apmpad2.setVouseq((short) (2));                                     //对应相关序号
            apmpad2.setTrntype("");                                             //设置交易种类

            apmpad2.setConfig(accacrBean.getConfig("V", "APM", "3", h.getRkd(), apmpad2.getAccno(), 'C')); //设置config参数
            apmpads.add(apmpad2);

            persist(h);
            getEntityManager().flush();
            for (Apmpad apm : apmpads) {
                apmpadBean.persist(apm);
            }

            return true;
        } catch (Exception ex) {
            Logger.getLogger(ApmpayBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public Boolean initByOAVHTV002(String psn) {
        List<BudgetDetail> budgetDetails = new ArrayList<>();
        VHTV002 g = vhtv002Bean.findByPSN(psn);

        String facno = g.getFacno();
        Date date;
        String period;
        try {

            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate())); //付款日期
            period = BaseLib.formatDate("yyyyMM", date);
            Apmpay h = new Apmpay();
            ApmpayPK pk = new ApmpayPK();
            pk.setFacno(facno);
            pk.setPaycode('2');
            pk.setPayno(apmsysBean.getFormId(facno, "APM525", date, Boolean.TRUE));
            h.setApmpayPK(pk);
            h.setPayda(date);
            h.setVouno(accrnoBean.getFormId(facno, date, Boolean.TRUE));        //设置初稿传票编号
            h.setDepno(g.getAppDept());                                         //取得OA预算部门
            h.setRkd("MR01");
            //h.setSumry("");                                                   //取得OA报销摘要
            h.setUsrno(g.getCreator());                                         //OA表单输入人员
            //h.setAppuserno(g.getAppUser());                                   //OA请款人
            h.setTaxym(BaseLib.formatDate("yyyyMM", date));                     //取得OA请款日期设置申报年月
            //h.setBilltype("HZ_CW033");                                        //取得OA表单名称
            //h.setSrcno(g.getProcessSerialNumber());                           //取得OA表单序列号
            h.setPaystat('0');                                                  //设置付款状态
            h.setSrckind("3");                                                  //设置来源区分码

            List<VHTV002reDetail> reDetail = vhtv002Bean.getDetailList(g.getFormSerialNumber());
            List<Apmpad> apmpads = new ArrayList<>();
            VHTV001 j = vhtv001Bean.findByPSN(reDetail.get(0).getLoanNo());

            for (int i = 0; i < reDetail.size(); i++) {

                Apmpad apmpad = new Apmpad();
                ApmpadPK apmpadPK = new ApmpadPK();
                apmpadPK.setFacno(facno);
                apmpadPK.setPaycode('2');
                apmpadPK.setPayno(pk.getPayno());
                apmpadPK.setTrse((short) (i + 1));
                apmpad.setApmpadPK(apmpadPK);

               VHTV002reDetail detail0l = reDetail.get(i);

                apmpad.setAccno(detail0l.getAccno());                           //设置会计科目
                apmpad.setCoin(g.getCoin());                                    //设置币别
                apmpad.setRatio(BigDecimal.valueOf(g.getRatio()));              //设置汇率

                if ("53".equals(apmpad.getAccno().substring(0, 2))) {
                    apmpad.setCuskind("9J");
                    apmpad.setVdrno(detail0l.getResearch());
                    Miscode miscode = miscodeBean.findByPK("9J", detail0l.getResearch());
                    if (miscode != null) {
                        apmpad.setVdrna(miscode.getCdesc());
                    }
                } else {
                    apmpad.setCuskind("GE");                                    //设置对象代号类别（cuskind）
                    apmpad.setVdrno(detail0l.getBudgetDepttxt());               //设置费用部门（预算部门）
                    apmpad.setVdrna(detail0l.getBudgetDeptlbl());
                }
                apmpad.setTnfamt(BigDecimal.ZERO);
                apmpad.setTnfamtfs(BigDecimal.ZERO);
                //apmpad.setRefno("");
                apmpad.setRefamtfs(BigDecimal.ZERO);
                apmpad.setRefamt(BigDecimal.ZERO);

                if (g.getTotaltaxesRMB() > 0) {
                    double d1 = Double.parseDouble(detail0l.getNotaxes());
                    apmpad.setDramtfs(BigDecimal.valueOf(d1));                  //设置dramtfs借方原币

                    double d2 = (d1 * (g.getRatio()));
                    apmpad.setDramt(BigDecimal.valueOf(d2));                    //设置dramt借方本币
                } else {
                    double d1 = Double.valueOf(detail0l.getTaxInclusive());
                    apmpad.setDramtfs(BigDecimal.valueOf(d1));                  //设置dramtfs借方原币

                    double d2 = (d1 * (g.getRatio()));
                    apmpad.setDramt(BigDecimal.valueOf(d2));                    //设置dramt借方本币
                }
                apmpad.setCramtfs(BigDecimal.ZERO);
                apmpad.setCramt(BigDecimal.ZERO);
                apmpad.setVouseq((short) (3));                                  //对应相关序号
                apmpad.setTrntype("");                                          //设置交易种类

                apmpad.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad.getAccno(), 'D')); //设置config参数
                apmpads.add(apmpad);

                //预算金额更新逻辑
                BudgetDetail u;
                u = new BudgetDetail(facno, "", period, detail0l.getCenterid(), detail0l.getAccno(), "R", apmpadPK.getTrse(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(Double.valueOf(detail0l.getTaxInclusive()) * (g.getRatio())), BigDecimal.ZERO);
                u.setPreamts(u.getPreamts().subtract(u.getDecramts()));
                budgetDetails.add(u);
            }

            //如果有税额就增加一笔税金明细
            if (g.getTotaltaxesRMB() > 0) {
                Apmpad apmpad2 = new Apmpad();
                ApmpadPK apmpadPK2 = new ApmpadPK();
                apmpadPK2.setFacno(facno);
                apmpadPK2.setPaycode('2');
                apmpadPK2.setPayno(pk.getPayno());
                apmpadPK2.setTrse((short) (apmpads.size() + 1));
                apmpad2.setApmpadPK(apmpadPK2);

                apmpad2.setDramt(BigDecimal.ZERO);
                apmpad2.setDramtfs(BigDecimal.ZERO);
                apmpad2.setCoin(g.getCoin());                                   //设置币别
                apmpad2.setRatio(BigDecimal.valueOf(g.getRatio()));             //设置汇率
                apmpad2.setDramtfs(BigDecimal.valueOf(g.getTotaltaxesRMB() / g.getRatio()));//设置dramtfs借方原币
                apmpad2.setDramt(BigDecimal.valueOf(g.getTotaltaxesRMB()));     //设置dramt借方本币

                apmpad2.setCramtfs(BigDecimal.ZERO);
                apmpad2.setCramt(BigDecimal.ZERO);
                apmpad2.setTnfamt(BigDecimal.ZERO);
                apmpad2.setTnfamtfs(BigDecimal.ZERO);
                apmpad2.setRefamtfs(BigDecimal.ZERO);
                apmpad2.setRefamt(BigDecimal.ZERO);
                apmpad2.setAccno("2222");
                apmpad2.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad2.getAccno(), 'D'));//设置config参数

                apmpads.add(apmpad2);

            }

            //处理退还现金逻辑
            if (g.getTotalRefund() > 0) {
                Apmpad apmpad3 = new Apmpad();
                ApmpadPK apmpadPK3 = new ApmpadPK();
                apmpadPK3.setFacno(facno);
                apmpadPK3.setPaycode('2');
                apmpadPK3.setPayno(pk.getPayno());
                apmpadPK3.setTrse((short) (apmpads.size() + 1));
                apmpad3.setApmpadPK(apmpadPK3);

                apmpad3.setAccno("1001");                                       //设置会计科目
                apmpad3.setCoin(g.getCoin());                                   //设置币别
                apmpad3.setRatio(BigDecimal.valueOf(g.getRatio()));             //设置汇率

                //apmpad.setCuskind("NB");                                      //设置对象代号类别cuskind
                //apmpad.setVdrno(j.getLoanUser());                             //设置费用部门（预算部门）
                //apmpad.setVdrna();
                apmpad3.setTnfamt(BigDecimal.ZERO);
                apmpad3.setTnfamtfs(BigDecimal.ZERO);
//                apmpad.setRefno("");
                apmpad3.setRefamtfs(BigDecimal.ZERO);
                apmpad3.setRefamt(BigDecimal.ZERO);

                apmpad3.setCramtfs(BigDecimal.ZERO);
                apmpad3.setCramt(BigDecimal.ZERO);

                apmpad3.setDramtfs(BigDecimal.valueOf(g.getTotalRefund()));
                apmpad3.setDramt(BigDecimal.valueOf(g.getTotalRefund() * (g.getRatio())));
                //apmpad.setVouseq((short) (2));                                //对应相关序号
                apmpad3.setTrntype("");                                         //设置交易种类

                apmpad3.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad3.getAccno(), 'D')); //设置config参数
                apmpads.add(apmpad3);
            }

            //处理贷方明细
            if (g.getTotalRefund() + g.getTotaltaxInclusive() <= Double.valueOf(reDetail.get(0).getApplyAmount())) {
                Apmpad apmpad4 = new Apmpad();
                ApmpadPK apmpadPK4 = new ApmpadPK();
                apmpadPK4.setFacno(facno);
                apmpadPK4.setPaycode('2');
                apmpadPK4.setPayno(pk.getPayno());
                apmpadPK4.setTrse((short) (apmpads.size() + 1));
                apmpad4.setApmpadPK(apmpadPK4);

                apmpad4.setDramt(BigDecimal.ZERO);
                apmpad4.setDramtfs(BigDecimal.ZERO);
                apmpad4.setCoin(g.getCoin());                                   //设置币别
                apmpad4.setRatio(BigDecimal.valueOf(g.getRatio()));             //设置汇率
                double c2 = g.getTotaltaxInclusive() + g.getTotalRefund();
                apmpad4.setCramtfs(BigDecimal.valueOf(c2));                     //设置cramtfs报销总额原币
                double c1 = g.getRatio() * c2;
                apmpad4.setCramt(BigDecimal.valueOf(c1));                       //设置cramt报销总额本币

                apmpad4.setTnfamt(BigDecimal.ZERO);
                apmpad4.setTnfamtfs(BigDecimal.ZERO);
                apmpad4.setRefamtfs(BigDecimal.ZERO);
                apmpad4.setRefamt(BigDecimal.ZERO);
                apmpad4.setAccno("1221");
                apmpad4.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad4.getAccno(), 'C'));  //设置config参数

                apmpad4.setCuskind("9E");
                apmpad4.setVdrno(g.getAppUser());
                Miscode miscode = miscodeBean.findByPK("9E", g.getAppUser());
                if (miscode != null) {
                    apmpad4.setVdrna(miscode.getCdesc());
                }
                apmpads.add(apmpad4);

                g.setApplyAmount(j.getArrears() - g.getTotalRefund() - g.getTotaltaxInclusive());
                j.setArrears(g.getApplyAmount());

            }
            if (g.getTotalRefund() + g.getTotaltaxInclusive() > Double.valueOf(reDetail.get(0).getApplyAmount()) ) {

                Apmpad apmpad5 = new Apmpad();
                ApmpadPK apmpadPK5 = new ApmpadPK();
                apmpadPK5.setFacno(facno);
                apmpadPK5.setPaycode('2');
                apmpadPK5.setPayno(pk.getPayno());
                apmpadPK5.setTrse((short) (apmpads.size() + 1));
                apmpad5.setApmpadPK(apmpadPK5);

                apmpad5.setDramt(BigDecimal.ZERO);
                apmpad5.setDramtfs(BigDecimal.ZERO);
                apmpad5.setCoin(g.getCoin());                                   //设置币别
                apmpad5.setRatio(BigDecimal.valueOf(g.getRatio()));             //设置汇率
                double c2 = Double.valueOf(reDetail.get(0).getApplyAmount());
                apmpad5.setCramtfs(BigDecimal.valueOf(c2));                     //设置 cramtfs(报销总额原币)
                double c1 = g.getRatio() * c2;
                apmpad5.setCramt(BigDecimal.valueOf(c1));                       //设置 cramt(人民币报销 总额)

                apmpad5.setTnfamt(BigDecimal.ZERO);
                apmpad5.setTnfamtfs(BigDecimal.ZERO);
                apmpad5.setRefamtfs(BigDecimal.ZERO);
                apmpad5.setRefamt(BigDecimal.ZERO);
                apmpad5.setAccno("1221");
                apmpad5.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad5.getAccno(), 'C'));  //设置config参数

                apmpad5.setCuskind("9E");
                apmpad5.setVdrno(g.getAppUser());
                Miscode miscode = miscodeBean.findByPK("9E", g.getAppUser());
                if (miscode != null) {
                    apmpad5.setVdrna(miscode.getCdesc());
                }
                apmpads.add(apmpad5);

                Apmpad apmpad6 = new Apmpad();
                ApmpadPK apmpadPK6 = new ApmpadPK();
                apmpadPK6.setFacno(facno);
                apmpadPK6.setPaycode('2');
                apmpadPK6.setPayno(pk.getPayno());
                apmpadPK6.setTrse((short) (apmpads.size() + 1));
                apmpad6.setDramt(BigDecimal.ZERO);
                apmpad6.setDramtfs(BigDecimal.ZERO);
                apmpad6.setCoin(g.getCoin());                                   //设置币别
                apmpad6.setRatio(BigDecimal.valueOf(g.getRatio()));              //设置汇率
                double c3 = g.getTotalRefund() + g.getTotaltaxInclusive() - Double.valueOf(reDetail.get(0).getApplyAmount());
                apmpad6.setCramtfs(BigDecimal.valueOf(c3));                     //设置cramtfs报销总额原币
                double c4 = c3 * g.getRatio();
                apmpad6.setCramt(BigDecimal.valueOf(c4));                       //设置cramt报销总额本币

                apmpad6.setApmpadPK(apmpadPK6);
                apmpad6.setTnfamt(BigDecimal.ZERO);
                apmpad6.setTnfamtfs(BigDecimal.ZERO);
                apmpad6.setRefamtfs(BigDecimal.ZERO);
                apmpad6.setRefamt(BigDecimal.ZERO);
                apmpad6.setAccno("2242");
                apmpad6.setConfig(accacrBean.getConfig(facno, "APM", "3", h.getRkd(), apmpad6.getAccno(), 'C'));  //设置config参数

                apmpad6.setCuskind("9E");
                apmpad6.setVdrno(g.getAppUser());
                miscode = miscodeBean.findByPK("9E", g.getAppUser());
                if (miscode != null) {
                    apmpad6.setVdrna(miscode.getCdesc());
                }
                apmpads.add(apmpad6);

                //g.setApplyAmount(0.00);
                j.setArrears(0.00);

            }

            ///HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
            //detailAdded.put(apmpadBean, apmpads);
            persist(h);
            getEntityManager().flush();

            for (Apmpad apmpad : apmpads) {
                apmpadBean.persist(apmpad);
            }

            vhtv001Bean.update(j);

            budgetDetailBean.add(budgetDetails);
            budgetDetailBean.getEntityManager().flush();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(ApmpayBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Boolean subtractBudgetPlanByOAVHTV003(String psn) {
        return budgetDetailBean.subtractByOAVHTV003(psn);
    }

    public Boolean subtractBudgetPlanByOAVHTV001(String psn) {
        return budgetDetailBean.subtractByOAVHTV001(psn);
    }

    public Boolean subtractBudgetPlanByOAVHTV002(String psn) {
        return budgetDetailBean.subtractByOAVHTV002(psn);
    }

}
