/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.crm.ejb.REPMIBean;
import cn.hanbell.crm.ejb.REPTDBean;
import cn.hanbell.crm.entity.REPMI;
import cn.hanbell.crm.entity.REPMIPK;
import cn.hanbell.crm.entity.REPTD;
import cn.hanbell.mes.ejb.CRMHKFW006Bean;
import cn.hanbell.mes.entity.CRMHKFW006;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKFW006;
import cn.hanbell.oa.entity.HKFW006Cdrn30;
import cn.hanbell.oa.entity.HKFW006Cdrn30Detail;
import cn.hanbell.oa.entity.HKFW006Detail;
import cn.hanbell.oa.entity.HKFW006Inv310;
import cn.hanbell.oa.entity.HKFW006Inv310Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
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
public class HKFW006Bean extends SuperEJBForEFGP<HKFW006> {

    @EJB
    private HKFW006Bean hkfw006Bean;
    @EJB
    private HKFW006DetailBean hkfw006DetailBean;
    @EJB
    private REPTDBean reptdBean;
    @EJB
    private REPMIBean repmiBean;
    @EJB
    private HKFW006Cdrn30Bean hkfw006CDRN30Bean;
    @EJB
    private HKFW006Inv310Bean hKFW006Inv310Bean;
    @EJB
    private CRMHKFW006Bean crmhkfw006Bean;

    private List<HKFW006Detail> detailList;

    public HKFW006Bean() {
        super(HKFW006.class);
    }

    public Boolean updateReptdByOAHKFW006(String psn) {
        return updateReptdByOAHKFW006(psn, "1");
    }

    public Boolean updateReptdByOAHKFW006(String psn, String status) {
        try {
            HKFW006 h = hkfw006Bean.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException();
            }
            if ("2".equals(h.getRettype()) && !"".equals(h.getLitnbr().trim())) {
                String td001 = h.getHdTC001();
                String td002 = h.getFwno().split(td001)[1];
                String td003 = "0001";
                if (null == h.getHdTD003A() || "".equals(h.getHdTD003A())) {
                    if (h.getHdTD003() != null && !"".equals(h.getHdTD003())) {
                        td003 = h.getHdTD003();
                    }
                } else {
                    td003 = h.getHdTD003A();
                }
                REPTD td = reptdBean.findByPK(td001, td002, td003);
                if ("1".equals(status)) {
                    //判断回退数量 by C1491 2019/06/20
                    td.setTd500(BigDecimal.ONE);                                //整机退货一台
                    td.setTd502(h.getFormSerialNumber());                       //退货OA单号
                    td.setTd047("Y");
                } else if ("3".equals(status)) {
                    td.setTd501(h.getPzno());
                } else if ("4".equals(status)) {
                    //加入OA发起主管审核后撤销，刷回CRM状态
                    td.setTd500(BigDecimal.ZERO);
                    td.setTd501("");
                    td.setTd502("");
                    td.setTd047("N");
                }
                reptdBean.update(td);
            }
            List<HKFW006Detail> details = hkfw006DetailBean.findByFSN(h.getFormSerialNumber());
            if (details.size() > 0) {
                for (int i = 0; i < details.size(); i++) {
                    HKFW006Detail detail = details.get(i);
                    String td001 = h.getHdTC001();
                    String td002 = h.getFwno().split(td001)[1];
                    String td003 = detail.getHdTD003();
                    REPTD td = reptdBean.findByPK(td001, td002, td003);
                    if ("1".equals(status)) {
                        //判断回退数量 by C1491 2019/06/20
                        if (td.getTd500() == null) {
                            td.setTd500(BigDecimal.valueOf(Double.valueOf(detail.getRetqty())));    //退货数量
                            td.setTd502(h.getFormSerialNumber());                                   //退货OA单号
                        } else {
                            if (td.getTd502() != null) {
                                if (td.getTd502().contains(h.getFormSerialNumber())) {
                                    //防止重复
                                    continue;
                                }
                            }
                            td.setTd500(td.getTd500().add(BigDecimal.valueOf(Double.valueOf(detail.getRetqty()))));   //退货数量
                            td.setTd502(h.getFormSerialNumber() + ";" + td.getTd502());     //退货OA单号
                        }
                        //判断退货数量VS实领数量
                        if (td.getTd500().compareTo(td.getTd020()) > -1) {
                            td.setTd047("Y");
                        }
                    } else if ("3".equals(status)) {
                        //OA流程结案抛转ERP后，写入CRM中ERP单号
                        td.setTd501(h.getPzno() + ";" + td.getTd501());
                    } else if ("4".equals(status)) {
                        //加入OA发起主管审核后撤销，刷回CRM状态
                        if (td.getTd502() != null) {
                            if (td.getTd502().contains(h.getFormSerialNumber())) {
                                td.setTd500(td.getTd500().subtract(BigDecimal.valueOf(Double.valueOf(detail.getRetqty()))));
                                td.setTd502(td.getTd502().replace(h.getFormSerialNumber(), ""));
                                if (td.getTd500().compareTo(td.getTd020()) < 0) {
                                    td.setTd047("N");
                                }
                            }
                        }
                    }
                    reptdBean.update(td);
                }
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(HKFW006Bean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //更新CRM REPMI
    public Boolean updateREPMIByOAHKFW006(String psn) {
        HKFW006 hkfw006 = this.findByPSN(psn);
        if (hkfw006 == null) {
            throw new NullPointerException();
        }
        try {
            HKFW006Cdrn30 h = hkfw006CDRN30Bean.findByPSN(psn);
            if (h != null) {
                if (h.getPzcdrn30().equals("1")) {
                    List<HKFW006Cdrn30Detail> details = hkfw006CDRN30Bean.getDetailList(h.getFormSerialNumber());
                    if (details != null && details.size() > 0) {
                        for (int i = 0; i < details.size(); i++) {
                            HKFW006Cdrn30Detail detail = details.get(i);
                            if (!detail.getVarnr().equals(detail.getDmark2())) {
                                String mi002 = detail.getDmark2();
                                REPMI repmi = repmiBean.findByMI002(mi002);
                                if (repmi == null) {
                                } else if (!repmi.getREPMIPK().getMi001().equals(detail.getItnbr())) {
                                    String company = repmi.getCompany();
                                    String creator = repmi.getCreator();
                                    String createDate = repmi.getCreateDate();
                                    String usrGroup = repmi.getUsrGroup();
                                    String modifier = repmi.getModifier();
                                    String modiDate = repmi.getModiDate();
                                    Short flag = repmi.getFlag();
                                    String mi004 = repmi.getMi004();
                                    String mi005 = repmi.getMi005();
                                    String mi006 = repmi.getMi006();
                                    String mi007 = repmi.getMi007();
                                    String mi008 = repmi.getMi008();
                                    String mi009 = repmi.getMi009();
                                    String mi010 = repmi.getMi010();
                                    String mi011 = repmi.getMi011();
                                    String mi012 = repmi.getMi012();
                                    String mi013 = repmi.getMi013();
                                    String customer = repmi.getCustomer();
                                    String product = repmi.getProduct();
                                    String region = repmi.getRegion();
                                    String dealer = repmi.getDealer();
                                    String repmi01 = repmi.getRepmi01();
                                    String repmi02 = repmi.getRepmi02();
                                    String repmi03 = repmi.getRepmi03();
                                    String repmi04 = repmi.getRepmi04();
                                    String repmi05 = repmi.getRepmi05();
                                    String repmi06 = repmi.getRepmi06();
                                    String repmi07 = repmi.getRepmi07();
                                    String repmi08 = repmi.getRepmi08();
                                    String repmi09 = repmi.getRepmi09();
                                    String repmi10 = repmi.getRepmi10();
                                    String repmi11 = repmi.getRepmi11();
                                    String repmi12 = repmi.getRepmi12();
                                    String repmi13 = repmi.getRepmi13();
                                    String repmi14 = repmi.getRepmi14();
                                    String repmi15 = repmi.getRepmi15();
                                    String repmi16 = repmi.getRepmi16();
                                    String repmi17 = repmi.getRepmi17();
                                    String repmi18 = repmi.getRepmi18();
                                    String repmi19 = repmi.getRepmi19();
                                    String repmi20 = repmi.getRepmi20();
                                    String mi502 = repmi.getMi502();
                                    repmiBean.delete(repmi);
                                    REPMI r = new REPMI();
                                    REPMIPK repmipk = new REPMIPK();
                                    repmipk.setMi001(detail.getItnbr());
                                    repmipk.setMi002(mi002);
                                    r.setREPMIPK(repmipk);
                                    String mi003 = "OA反写 " + BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate());
                                    r.setMi003(mi003);
                                    r.setMi004(mi004);
                                    r.setMi005(mi005);
                                    r.setMi006(mi006);
                                    r.setMi007(mi007);
                                    r.setMi008(mi008);
                                    r.setMi009(mi009);
                                    r.setMi010(mi010);
                                    r.setMi011(mi011);
                                    r.setMi012(mi012);
                                    r.setMi013(mi013);
                                    r.setMi500(h.getCusno());
                                    r.setMi501(h.getCusname());
                                    r.setMi502(mi502);
                                    r.setCompany(company);
                                    r.setCreateDate(createDate);
                                    r.setCreator(creator);
                                    r.setUsrGroup(usrGroup);
                                    r.setModiDate(modiDate);
                                    r.setModifier(modifier);
                                    r.setFlag(flag);
                                    r.setCustomer(customer);
                                    r.setProduct(product);
                                    r.setRegion(region);
                                    r.setDealer(dealer);
                                    r.setRepmi01(repmi01);
                                    r.setRepmi02(repmi02);
                                    r.setRepmi03(repmi03);
                                    r.setRepmi04(repmi04);
                                    r.setRepmi05(repmi05);
                                    r.setRepmi06(repmi06);
                                    r.setRepmi07(repmi07);
                                    r.setRepmi08(repmi08);
                                    r.setRepmi09(repmi09);
                                    r.setRepmi10(repmi10);
                                    r.setRepmi11(repmi11);
                                    r.setRepmi12(repmi12);
                                    r.setRepmi13(repmi13);
                                    r.setRepmi14(repmi14);
                                    r.setRepmi15(repmi15);
                                    r.setRepmi16(repmi16);
                                    r.setRepmi17(repmi17);
                                    r.setRepmi18(repmi18);
                                    r.setRepmi19(repmi19);
                                    r.setRepmi20(repmi20);
                                    repmiBean.persist(r);

                                }
                            }

                        }
                    }
                }
            }

            HKFW006Inv310 hinv310 = hKFW006Inv310Bean.findByPSN(psn);
            if (hinv310 != null) {
                if (hinv310.getPzinv310().equals("1") && hkfw006.getRettype().equals("2")) {
                    List<HKFW006Inv310Detail> detailsinv310 = hKFW006Inv310Bean.getDetailList(hinv310.getFormSerialNumber());
                    if (detailsinv310 != null && detailsinv310.size() > 0) {
                        for (int i = 0; i < detailsinv310.size(); i++) {
                            HKFW006Inv310Detail detail = detailsinv310.get(i);
                            if (!detail.getVarnr().equals("%") && !detail.getVarnr().equals("")) {
                                String mi002 = detail.getVarnr();
                                REPMI repmi = repmiBean.findByMI002(mi002);
                                if (repmi == null) {
                                } else if (!repmi.getREPMIPK().getMi001().equals(detail.getItnbr())) {
                                    String company = repmi.getCompany();
                                    String creator = repmi.getCreator();
                                    String createDate = repmi.getCreateDate();
                                    String usrGroup = repmi.getUsrGroup();
                                    String modifier = repmi.getModifier();
                                    String modiDate = repmi.getModiDate();
                                    Short flag = repmi.getFlag();
                                    String mi004 = repmi.getMi004();
                                    String mi005 = repmi.getMi005();
                                    String mi006 = repmi.getMi006();
                                    String mi007 = repmi.getMi007();
                                    String mi008 = repmi.getMi008();
                                    String mi009 = repmi.getMi009();
                                    String mi010 = repmi.getMi010();
                                    String mi011 = repmi.getMi011();
                                    String mi012 = repmi.getMi012();
                                    String mi013 = repmi.getMi013();
                                    String customer = repmi.getCustomer();
                                    String product = repmi.getProduct();
                                    String region = repmi.getRegion();
                                    String dealer = repmi.getDealer();
                                    String repmi01 = repmi.getRepmi01();
                                    String repmi02 = repmi.getRepmi02();
                                    String repmi03 = repmi.getRepmi03();
                                    String repmi04 = repmi.getRepmi04();
                                    String repmi05 = repmi.getRepmi05();
                                    String repmi06 = repmi.getRepmi06();
                                    String repmi07 = repmi.getRepmi07();
                                    String repmi08 = repmi.getRepmi08();
                                    String repmi09 = repmi.getRepmi09();
                                    String repmi10 = repmi.getRepmi10();
                                    String repmi11 = repmi.getRepmi11();
                                    String repmi12 = repmi.getRepmi12();
                                    String repmi13 = repmi.getRepmi13();
                                    String repmi14 = repmi.getRepmi14();
                                    String repmi15 = repmi.getRepmi15();
                                    String repmi16 = repmi.getRepmi16();
                                    String repmi17 = repmi.getRepmi17();
                                    String repmi18 = repmi.getRepmi18();
                                    String repmi19 = repmi.getRepmi19();
                                    String repmi20 = repmi.getRepmi20();
                                    String mi502 = repmi.getMi502();
                                    repmiBean.delete(repmi);
                                    REPMI r = new REPMI();
                                    REPMIPK repmipk = new REPMIPK();
                                    repmipk.setMi001(detail.getItnbr());
                                    repmipk.setMi002(mi002);
                                    r.setREPMIPK(repmipk);
                                    String mi003 = "OA反写 " + BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate());
                                    r.setMi003(mi003);
                                    r.setMi004(mi004);
                                    r.setMi005(mi005);
                                    r.setMi006(mi006);
                                    r.setMi007(mi007);
                                    r.setMi008(mi008);
                                    r.setMi009(mi009);
                                    r.setMi010(mi010);
                                    r.setMi011(mi011);
                                    r.setMi012(mi012);
                                    r.setMi013(mi013);
                                    r.setMi500(hinv310.getDepno());
                                    r.setMi501(hinv310.getDepname());
                                    r.setMi502(mi502);
                                    r.setCompany(company);
                                    r.setCreateDate(createDate);
                                    r.setCreator(creator);
                                    r.setUsrGroup(usrGroup);
                                    r.setModiDate(modiDate);
                                    r.setModifier(modifier);
                                    r.setFlag(flag);
                                    r.setCustomer(customer);
                                    r.setProduct(product);
                                    r.setRegion(region);
                                    r.setDealer(dealer);
                                    r.setRepmi01(repmi01);
                                    r.setRepmi02(repmi02);
                                    r.setRepmi03(repmi03);
                                    r.setRepmi04(repmi04);
                                    r.setRepmi05(repmi05);
                                    r.setRepmi06(repmi06);
                                    r.setRepmi07(repmi07);
                                    r.setRepmi08(repmi08);
                                    r.setRepmi09(repmi09);
                                    r.setRepmi10(repmi10);
                                    r.setRepmi11(repmi11);
                                    r.setRepmi12(repmi12);
                                    r.setRepmi13(repmi13);
                                    r.setRepmi14(repmi14);
                                    r.setRepmi15(repmi15);
                                    r.setRepmi16(repmi16);
                                    r.setRepmi17(repmi17);
                                    r.setRepmi18(repmi18);
                                    r.setRepmi19(repmi19);
                                    r.setRepmi20(repmi20);
                                    repmiBean.persist(r);

                                }
                            }

                        }
                    }
                }
            }

            return true;

        } catch (Exception ex) {

            Logger.getLogger(HKFW006Bean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //更新MES CRM_HK_FW006
    public Boolean updateCRMHKFW006ByOAFW006(String psn) {
        try {
            HKFW006 f = this.findByPSN(psn);
            if (f == null) {
                throw new NullPointerException();
            }
            CRMHKFW006 mf = crmhkfw006Bean.findByPSN(psn);
            if (null != mf) {
                mf.setGzreason(f.getGzreason());
                mf.setYyjb(f.getYyjb());
                mf.setTitdsc(f.getTitdsc());
                mf.setTklx(f.getTklx());
                mf.setCreatedate(f.getCreatedate());
                mf.setCdrno(f.getCdrno());
                mf.setLitdsc(f.getLitdsc());
                mf.setMachineoil(f.getMachineoil());
                mf.setFwno(f.getFwno());
                mf.setCusno(f.getCusno());
                mf.setDhno(f.getDhno());
                mf.setPzno(f.getPzno());
                mf.setZbpzno(f.getZbpzno());
                mf.setHdTD003(f.getHdTD003());
                mf.setHdreturntype(f.getHdreturntype());
                mf.setRecitdsc(f.getRecitdsc());
                mf.setRettype(f.getRettype());
                mf.setQty(f.getQty());
                mf.setMark(f.getMark());
                mf.setShpno(f.getShpno());
                mf.setKfno(f.getFwno());
                mf.setMachineoilhalf(f.getMachineoilhalf());
                mf.setCptype(f.getCptype());
                mf.setSfzb(f.getSfzb());
                mf.setYymark(f.getYymark());
                mf.setPstyle(f.getPstyle());
                mf.setRecitnbr(f.getRecitnbr());
                mf.setHdTC001(f.getHdTC001());
                mf.setZjshpno(f.getZjshpno());
                mf.setTitnbr(f.getTitnbr());
                mf.setLcreateno(f.getLcreateno());
                mf.setRetqty(f.getRetqty());
                mf.setApplydept(f.getApplydept());
                mf.setFacno(f.getFacno());
                mf.setRetitdsc(f.getRetitdsc());
                mf.setFgspzno(f.getFgspzno());
                mf.setTcreateno(f.getTcreateno());
                mf.setApplyuser(f.getApplyuser());
                mf.setRstyle(f.getRstyle());
                mf.setRetitnbr(f.getRetitnbr());
                mf.setYf(f.getYf());
                mf.setCusna(f.getCusna());
                mf.setBhmk(f.getBhmk());
                mf.setSupportdept(f.getSupportdept());
                mf.setDzf(f.getDzf());
                mf.setReturntype(f.getReturntype());
                mf.setRecqty(f.getRecqty());
                mf.setUnit(f.getUnit());
                mf.setKssjt(f.getKssjt());
                mf.setAstyle(f.getAstyle());
                mf.setSupportuser(f.getSupportuser());
                mf.setFrozenoil(f.getFrozenoil());
                mf.setReturndate(f.getReturndate());
                mf.setCctype(f.getCctype());
                mf.setLitnbr(f.getLitnbr());
                mf.setFormSerialNumber(f.getFormSerialNumber());
                crmhkfw006Bean.update(mf);
            } else {
                throw new NullPointerException();
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    //OA 撤销或者终止流程后更新MES
    public Boolean rollbackCRMHKFW006ByOAFW006(String psn) {
        try {
            HKFW006 f = this.findByPSN(psn);
            if (f == null) {
                throw new NullPointerException();
            }
            CRMHKFW006 mf = crmhkfw006Bean.findByPSN(psn);
            if (null != mf) {
                mf.setIsdelete("Y");
                crmhkfw006Bean.update(mf);
            } else {
                throw new NullPointerException();
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     *
     * @param kfno
     * @return 退货通知单吊装费和运费
     */
    public List getTansportExpense(String kfno) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT 'tansportexpense' as type ,N'OA退货通知单' as  sources,kfno,fwno,applyuser as userno,userName as userna  ");
        sb.append("  ,applydept as deptno,organizationUnitName as deptna,CONVERT(varchar(100), returndate, 112) as occurdate, ");
        sb.append(" (CASE rettype WHEN '1' THEN N'零件退货' WHEN '2' THEN N'整机退货' ELSE '' END ) as expensetype ");
        sb.append("  ,cptype as custom1,cusno as custom2,cusna as custom3,CRMNO as custom4, (isnull(yf,0)+isnull(dzf,0)) as 'expense' , ");
        sb.append("  (CASE WHEN mark!='' THEN (mark+'; '+yymark)ELSE yymark END ) as remark1,SerialNumber as sourcesno FROM HK_FW006 fw LEFT OUTER JOIN Users s on s.id=applyuser ");
        sb.append("  LEFT OUTER JOIN OrganizationUnit o on o.id=applydept WHERE kfno = '${kfno}' ");
        try {
            String sql = sb.toString().replace("${kfno}", kfno);
            Query query = getEntityManager().createNativeQuery(sql);
            List list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void setDetail(Object value) {
        this.detailList = hkfw006DetailBean.findByFSN(value); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the detailList
     */
    public List<HKFW006Detail> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<HKFW006Detail> detailList) {
        this.detailList = detailList;
    }
}
