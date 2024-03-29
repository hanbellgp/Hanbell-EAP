/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.crm.ejb.REPPABean;
import cn.hanbell.crm.entity.REPPA;
import cn.hanbell.crm.entity.REPPB;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrcorman;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Cdrpaydsc;
import cn.hanbell.erp.entity.Cdrqasry;
import cn.hanbell.erp.entity.Cdrqdta;
import cn.hanbell.erp.entity.Cdrqhad;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.oa.ejb.HKYX009Bean;
import cn.hanbell.oa.ejb.ProcessCheckBean;
import cn.hanbell.oa.entity.HKYX009;
import cn.hanbell.oa.entity.ProcessCheck;
import cn.hanbell.oa.model.CdrqasryModel;
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
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrqhadBean extends SuperEJBForERP<Cdrqhad> {

    @EJB
    private CdrqdtaBean cdrqdtaBean;
    @EJB
    private CdrqsysBean cdrqsysBean;
    @EJB
    private CdrqasryBean cdrqasryBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private CdrcormanBean cdrcormanBean;
    @EJB
    private CdrpaydscBean cdrpaydscBean;
    @EJB
    private HKYX009Bean hkyx009Bean;
    @EJB
    private ProcessCheckBean processCheckBean;
    @EJB
    private REPPABean reppaBean;
    private List<Cdrqdta> cdrqdtaList;

    public CdrqhadBean() {
        super(Cdrqhad.class);
    }

    public Cdrqhad findByQuono(String quono) {
        Query query = this.getEntityManager().createNamedQuery("Cdrqhad.findByQuono");
        query.setParameter("quono", quono);
        try {
            return (Cdrqhad) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public List<Cdrqhad> findByCRMQuono(String facno, String copyquono) {
        this.setCompany(facno);
        Query query = this.getEntityManager().createNamedQuery("Cdrqhad.findByCopyquono");
        query.setParameter("copyquono", copyquono);
        return query.getResultList();
    }

    public List<Cdrqhad> findNeedThrow() {
        Query query = this.getEntityManager().createNamedQuery("Cdrqhad.findNeedThrow").setFirstResult(0).setMaxResults(1);
        return query.getResultList();
    }

    public List<Cdrqdta> findNeedThrowDetail(String facno, String quono) {
        cdrqdtaBean.setCompany(facno);
        return cdrqdtaBean.findNeedThrowDetail(facno, quono);
    }

    public List<Cdrqdta> getCdrqdtaList() {
        return cdrqdtaList;
    }

    public void setCdrqdtaList(List<Cdrqdta> cdrqdtaList) {
        this.cdrqdtaList = cdrqdtaList;
    }

    public Boolean updateByOAHKYX009(String psn) {
        List<ProcessCheck> processList;
        HKYX009 h = hkyx009Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String facno = h.getFacno();

        try {
            this.setCompany(facno);
            Cdrqhad cdrqhad = this.findByQuono(h.getQuono());
            if (cdrqhad != null) {
                cdrqhad.setHquosta('Y');
                processList = processCheckBean.findByPSN(psn);
                if (processList.size() > 0) {
                    ProcessCheck pc = processList.get(processList.size() - 1);
                    cdrqhad.setOacfuser(pc.getUserID());
                }
                update(cdrqhad);
            }
            return true;
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(CdrqhadBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Boolean rollbackByOAHKYX009(String psn) {
        HKYX009 h = hkyx009Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String facno = h.getFacno();
        try {
            this.setCompany(facno);
            Cdrqhad cdrqhad = this.findByQuono(h.getQuono());
            if (cdrqhad != null) {
                cdrqhad.setHquosta('N');
                cdrqhad.setOacfuser("");
                update(cdrqhad);
                //如果是CRM抛转单据，反写CRM状态
                if (cdrqhad.getCopyquono() != null) {
                    String bcrmno = cdrqhad.getCopyquono();
                    String pa001 = bcrmno.substring(0, 2);
                    String pa002 = bcrmno.substring(2);
                    REPPA ra = reppaBean.findByPK(pa001, pa002);
                    if (ra != null) {
                        ra.setPa027("N");
                        ra.setPa026("N");
                        ra.setPa519("");
                        ra.setPa521("");
                        ra.setPa518("4");
                        reppaBean.update(ra);
                    }
                }
            }
            return true;
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(CdrqhadBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //CRM 撤销估价单
    public Boolean rollbackByCRMREPPA(String pa001, String pa002) {
        try {
            REPPA ra = reppaBean.findByPK(pa001, pa002);
            if (ra == null) {
                throw new NullPointerException();
            }
            String quono = ra.getPa519();
            String facno = ra.getPa500();
            if ("".equals(facno)) {
                throw new NullPointerException("未找到公司别 或者已取消审核");
            }
            this.setCompany(facno);
            Cdrqhad cdrqhad = this.findByQuono(quono);
            if (cdrqhad != null) {
                if (cdrqhad.getHquosta() == 'Y' || cdrqhad.getHquosta() == 'N') {
                    cdrqhad.setHquosta('W');
                    //cdrqhad.setOacfuser("");
                    update(cdrqhad);
                    //CRM抛转单据，反写CRM状态
                    ra.setPa026("N");
                    ra.setPa519("");
                    ra.setPa518("1");
                    reppaBean.update(ra);
                    reppaBean.getEntityManager().flush();
                } else {
                    throw new NullPointerException("报价单状态不符，或已抛转OA" + ra.getPa521());
                }

            }
            return true;
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(CdrqhadBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    //CRM 估价单撤销更新ERP
    public String rollbackFromCRMREPPA(String facno, String pa001, String pa002) {
        try {
            String ret = "200";
            this.setCompany(facno);
            String copyquono = pa001 + pa002;
            List<Cdrqhad> cdrqhads = this.findByCRMQuono(facno, copyquono);
            if (cdrqhads == null) {
                ret = "未找到对应的报价单信息！";
            } else if (cdrqhads.size() > 0) {
                for (Cdrqhad h : cdrqhads) {
                    if (null == h.getHquosta()) {
                        ret = "404";
                    } else {
                        switch (h.getHquosta()) {
                            case 'R':
                            case 'Y':
                            case 'N':
                                h.setHquosta('W');
                                break;
                            case 'O':
                                HKYX009 oah = hkyx009Bean.findByQuono(h.getCdrqhadPK().getQuono());
                                if (oah != null) {
                                    ret = "报价单已抛转OA，请至OA撤销！ 单号：" + oah.getProcessSerialNumber();
                                }
                                break;
                            default:
                                ret = "404";
                                break;
                        }
                    }
                }
            }
            return ret;
        } catch (Exception ex) {
            Logger.getLogger(CdrqhadBean.class.getName()).log(Level.SEVERE, null, ex);
            return ex.toString();
        }
    }

    public void persistDetailList(String facno, List<Cdrqdta> detaiList) {
        if (detaiList.size() > 0) {
            for (Cdrqdta qd : detaiList) {
                cdrqdtaBean.setCompany(facno);
                cdrqdtaBean.persist(qd);
            }

        }
    }

    //wf_get_standpricing
    public int getStandPricing(Cdrqhad qh, String pricingtype, String itnbr, String itemno, Date quodate, String currency, BigDecimal ratio, BigDecimal unpris, int row) {
        int li_ulevelp;
        BigDecimal ldc_salesprice = unpris;
        BigDecimal ldc_stdprice;
        BigDecimal ldc_levelpri;
        String pricelevel;
        String ls_itnbr;
        String ls_itemdesc;
        String ls_levelpo;
        Object[] prpl;
        try {
            pricelevel = getUserPricelevel(pricingtype, qh.getMancode());
            li_ulevelp = Integer.parseInt(pricelevel.substring(6));          //"price09"截取数字
            ls_levelpo = qh.getLevelp();
            if (ls_levelpo == null && ls_levelpo.equals("")) {
                ls_levelpo = "A" + li_ulevelp;
            }
            prpl = getByPricingPolicy(itnbr, pricingtype, quodate, currency);
            if (prpl == null) {
                prpl = getByPricingPolicy(itnbr, pricingtype, quodate, "RMB");
                ldc_salesprice = unpris.multiply(ratio);
            }
            if (prpl == null) {
                log4j.error(itnbr + " '未维护价格类别'" + pricingtype + "'对应的标准定价,请先维护!");

                //dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10 如果没有查找到价格,则记录
                return -1;
            }
            if ("".equals(itemno)) {
                li_ulevelp = Integer.parseInt(pricelevel.substring(6));          //"price09"截取数字
                ldc_stdprice = BigDecimal.valueOf(Double.valueOf(prpl[10 + li_ulevelp].toString())); //prpl标准定价数组的顺序（数量）不能修改
                if (ldc_stdprice == null || ldc_stdprice.compareTo(BigDecimal.ZERO) < 1) {
                    log4j.error("错误'" + itnbr + "'的 '+ itemno + '机型未维护价格类别'" + pricingtype + "'对应的标准定价,请先维护!");
                    //dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10 如果没有查找到价格,则记录
                    return -1;
                }
                ls_itnbr = prpl[0].toString();
                ls_itemdesc = prpl[2].toString();
                if (ls_itemdesc == null || "".equals(ls_itemdesc)) {
                    invmasBean.setCompany(this.getCompany());
                    Invmas m = invmasBean.findByItnbr(ls_itnbr);
                    ls_itemdesc = m.getItdsc();
                }

                if (ldc_stdprice.compareTo(ldc_salesprice) > 0) {
                    if (li_ulevelp > 1) {
                        for (int i = li_ulevelp; i > 0; i--) {
                            ldc_levelpri = BigDecimal.valueOf(Double.valueOf(prpl[10 + i].toString())); //prpl标准定价数组的顺序（数量）不能修改
                            if (ldc_levelpri == null || ldc_levelpri.compareTo(BigDecimal.ZERO) < 1) {
                                log4j.error("出错，第" + i + "笔件号'" + itnbr + "'当前售价不符合价格权限表管控范围,请走特殊报价或联系mis'");
                                //dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10 如果没有查找到价格,则记录
                                continue;
                            }
                            if (ldc_levelpri.compareTo(ldc_salesprice) < 1) {
                                if (li_ulevelp > i) {
                                    ls_levelpo = "A" + i;
                                }

                            }

                        }
                    }

                }

            }
            return 0;
            //d_ds_cdrpricuser_cdr220
        } catch (Exception e) {
            return -1;
        }

    }

    //价格类别对应的标准定价
    public Object[] getByPricingPolicy(String itnbr, String pricingtype, Date quodate, String currency) {
        StringBuilder sb = new StringBuilder();
        Object[] pricingpl;
        sb.append(" select pricing.itnbr, pricing.itemno, pricing.itemdesc,pricingpolicy.pricingdate,pricingpolicy.pricingtype, pricingpolicy.daybegin,")
                .append("pricingpolicy.dayend,pricingpolicy.deptid,pricingpolicy.status,pricingpolicy.creator, pricing.pricingid,")
                .append("pricing.price01,pricing.price02,pricing.price03,pricing.price04,pricing.price05,pricing.price06,pricing.price07,pricing.price08,pricing.price09")
                .append(" from pricing , pricingpolicy   where ( pricingpolicy.pricingid = pricing.pricingid ) and   (( pricing.itnbr = '")
                .append(itnbr).append("') and ( pricingpolicy.pricingtype = '").append(pricingtype).append("') and ( pricingpolicy.status <> 'W' ) and ( pricingpolicy.daybegin <= '")
                .append(BaseLib.formatDate("yyyyMMdd", quodate)).append("') and ( pricingpolicy.dayend >= '").append(BaseLib.formatDate("yyyyMMdd", quodate))
                .append("') and ( pricingpolicy.currency ='").append(currency).append("'))  ORDER BY pricing.pricingid DESC ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        try {
            if (query.getResultList().size() > 0) {
                pricingpl = (Object[]) query.getResultList().get(0);
            } else {
                return null;
            }
            return pricingpl;
        } catch (Exception e) {
            return null;
        }
    }

    public Object[] getByPricingPolicy(String itnbr, String pricingtype, Date quodate, String currency, String itemno) {
        StringBuilder sb = new StringBuilder();
        Object[] pricingpl;
        sb.append(" select pricing.itnbr, pricing.itemno, pricing.itemdesc,pricingpolicy.pricingdate,pricingpolicy.pricingtype, pricingpolicy.daybegin,")
                .append("pricingpolicy.dayend,pricingpolicy.deptid,pricingpolicy.status,pricingpolicy.creator, pricing.pricingid,")
                .append("pricing.price01,pricing.price02,pricing.price03,pricing.price04,pricing.price05,pricing.price06,pricing.price07,pricing.price08,pricing.price09")
                .append(" from pricing , pricingpolicy   where ( pricingpolicy.pricingid = pricing.pricingid ) and   (( pricing.itnbr = '")
                .append(itnbr).append("') and ( pricingpolicy.pricingtype = '").append(pricingtype).append("') and ( pricingpolicy.status <> 'W' ) and ( pricingpolicy.daybegin <= '")
                .append(BaseLib.formatDate("yyyyMMdd", quodate)).append("') and ( pricingpolicy.dayend >= '").append(BaseLib.formatDate("yyyyMMdd", quodate))
                .append("') and ( pricingpolicy.currency ='").append(currency).append("') and (pricing.itemno = '").append(itemno).append("')) ORDER BY pricing.pricingid DESC ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        try {
            if (query.getResultList().size() > 0) {
                pricingpl = (Object[]) query.getResultList().get(0);
            } else {
                return null;
            }
            return pricingpl;
        } catch (Exception e) {
            return null;
        }
    }

    // 获取用户价格权限
    // 业务员在单一群组中抓取定价权限级别
    // 程式设定，同一业务员在一个类别中只能存在一次
    public String getUserPricelevel(String ls_pricingtype, String user) {
        String pricelevel;
        StringBuilder sb = new StringBuilder();
        sb.append(" select  pricinggroup.price01, pricinggroup.price02, pricinggroup.price03, pricinggroup.price04, pricinggroup.price05, pricinggroup.price06,")
                .append("pricinggroup.price07, pricinggroup.price08, pricinggroup.price09  FROM pricinguser,pricinggroup")
                .append(" WHERE ( pricinggroup.groupid = pricinguser.groupid ) and ( pricinggroup.pricingtype = pricinguser.pricingtype ) and (( pricinguser.pricingtype = '")
                .append(ls_pricingtype).append("') and  ( pricinguser.userid = '").append(user).append("') and (pricinggroup.status = 'V')) ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        try {
            if (query.getResultList().size() > 0) {
                Object[] pricinggr = (Object[]) query.getResultList().get(0);
                for (int i = 0; i < pricinggr.length; i++) {
                    if (Boolean.valueOf(pricinggr[i].toString())) {
                        pricelevel = "price0" + (i + 1);
                        return pricelevel;
                    }
                }
            }
            pricelevel = "price09";

        } catch (Exception e) {
            pricelevel = "price09";
            log4j.error("获取用户价格权限失败!", e);
        }
        return pricelevel;
    }

    public String getDeflevel(String pricingtype) {
        String pricelevel = "";
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT price01,price02,price03,price04,price05,price06,price07,price08,price09 FROM pricinggroup");
        sb.append(" WHERE pricinggroup.isdatum = 'Y' AND pricinggroup.pricingtype = '");
        sb.append(pricingtype);
        sb.append("' ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        Object[] row = (Object[]) query.getSingleResult();
        if (row != null) {
            for (int i = 1; i <= 9; i++) {
                if (Boolean.valueOf(row[i].toString())) {
                    pricelevel = "price0" + i;
                    break;
                }
            }
        }
        return pricelevel;
    }

    //需维护身份卡相关大类
    public Cdrcorman findByItcls(String facno, String itcls) {
        cdrcormanBean.setCompany(facno);
        return cdrcormanBean.findByItcls(itcls);
    }

    public String getPricingLevel(BigDecimal price0, String itnbr, String pricingtype, Date quodate, String currency) {
        String defaultlp = "A8";
        Object[] prarr = getByPricingPolicy(itnbr, pricingtype, quodate, currency);
        if (prarr == null) {
            return "";
        }
        for (int i = 1; i < 9; i++) {
            if (prarr[10 + i] == null) {
                continue;
            }
            BigDecimal pi = BigDecimal.valueOf(Double.valueOf(prarr[10 + i].toString()));
            if (price0.compareTo(pi) < 0) {
                return "A" + i;
            }
        }
        return defaultlp;
    }

    public List<CdrqasryModel> queryCdrqasryModelList(String facno, String quono, short trseq) {
        if (facno == null || quono == null) {
            return null;
        }
        cdrqasryBean.setCompany(facno);
        this.setCompany(facno);
        List<Cdrqasry> list = cdrqasryBean.findByQuonoAndTrseq(facno, quono, trseq);
        if (!list.isEmpty()) {
            List<CdrqasryModel> listCdrqasryModel = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Cdrqasry cqasry = list.get(i);
                CdrqasryModel m = new CdrqasryModel();
                m.setFacno(facno);
                m.setQuono(quono);
                m.setTrseq(trseq);
                m.setSeq((short) (i + 1));
                m.setItnbr(cqasry.getItnbr());
                Invmas invmas = invmasBean.findByItnbr(m.getItnbr());
                if (invmas != null) {
                    m.setItdsc(invmas.getItdsc());
                }
                m.setStdqty(cqasry.getStdqty());
                //配件价格
                Cdrqhad qh = findByQuono(quono);
                String bcrmno = qh.getCopyquono();
                if (bcrmno.length() > 8) {
                    //判断是不是从CRM过来的维修配件
                    String pa001 = bcrmno.substring(0, 2);
                    String pa002 = bcrmno.substring(2);
                    List<REPPB> reppbList = reppaBean.getDetailList(pa001, pa002);
                    for (REPPB reppb : reppbList) {
                        if (reppb.getPb004().equals(m.getItnbr())) {
                            m.setQuoprice(reppb.getPb011());  //CRM配件单价
                            break;
                        }
                    }

                }

                listCdrqasryModel.add(m);
            }
            return listCdrqasryModel;
        } else {
            return null;
        }
    }

    //获得报价付款叙述条件
    public String getPaycodedsc(String facno, Cdrcus c) {
        String paycodedsc = "";
        Character paycode = c.getPaycode();
        int tickdays = c.getTickdays();
        Character decode = c.getDecode();
        cdrpaydscBean.setCompany(facno);
        if (null == c.getSkfs()) {
            if ('1' == paycode) {
                if ('1' == decode) {
                    paycodedsc = " 现金付款";
                } else {
                    Cdrpaydsc cdrpaydsc = cdrpaydscBean.findByPK('1', paycode.toString());
                    if (null != cdrpaydsc) {
                        paycodedsc = (cdrpaydsc.getAllcodedsc() == null) ? "" : cdrpaydsc.getAllcodedsc();
                    }
                }
            } else if ('2' == paycode) {
                if ('1' == decode) {
                    if (tickdays == 0) {
                        paycodedsc = " 即期支票";
                    } else {
                        paycodedsc = "支票" + " " + String.valueOf(tickdays) + "天";
                    }
                } else {
                    Cdrpaydsc cdrpaydsc = cdrpaydscBean.findByPK('1', paycode.toString());
                    if (null != cdrpaydsc) {
                        if (null != cdrpaydsc.getAllcodedsc()) {
                            if (tickdays == 0) {
                            } else {
                                paycodedsc = cdrpaydsc.getAllcodedsc() + " " + String.valueOf(tickdays) + " days";
                            }
                        }
                    }
                }
            } else {
                if (tickdays >= 0) {
                    if (decode == '1') {
                        String ls_text;
                        switch (paycode) {
                            case '1':
                                ls_text = "现金";
                                break;
                            case '2':
                                ls_text = "支票";
                                break;
                            case '3':
                                ls_text = "国内T/T";
                                break;
                            case '4':
                                ls_text = "国~外T/T";
                                break;
                            case '5':
                                ls_text = "国内L/C";
                                break;
                            case '6':
                                ls_text = "国~外L/C";
                                break;
                            case '7':
                                ls_text = "D/A";
                                break;
                            case '8':
                                ls_text = "D/P";
                                break;
                            default:
                                ls_text = "";
                                break;
                        }
                        paycodedsc = ls_text + " " + String.valueOf(tickdays) + "天";
                    } else {
                        Cdrpaydsc cdrpaydsc = cdrpaydscBean.findByPK('1', paycode.toString());
                        if (null != cdrpaydsc) {
                            paycodedsc = cdrpaydsc.getAllcodedsc() + " " + String.valueOf(tickdays) + " days";
                        } else {
                            paycodedsc = String.valueOf(tickdays) + " days";
                        }
                    }
                }
            }
            if (paycode == '3') {
                if (tickdays == 0) {
                    paycodedsc = "T/T IN ADVANCE";
                }
            }
            if (paycode == '4') {
                if (tickdays == 0) {
                    paycodedsc = "T/T IN ADVANCE";
                }
            }
            if (paycode == '5') {
                if (tickdays == 0) {
                    paycodedsc = "L/C AT SIGHT";
                }
            }
            if (paycode == '6') {
                if (tickdays == 0) {
                    paycodedsc = "L/C AT SIGHT";
                }
            }

        } else {
            paycodedsc = c.getSkfs();
        }

        return paycodedsc;
    }

}
