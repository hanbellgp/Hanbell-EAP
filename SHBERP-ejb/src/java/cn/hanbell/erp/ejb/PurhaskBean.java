/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.erp.entity.Purdask;
import cn.hanbell.erp.entity.PurdaskPK;
import cn.hanbell.erp.entity.Purdaskdsc;
import cn.hanbell.erp.entity.PurdaskdscPK;
import cn.hanbell.erp.entity.Purhask;
import cn.hanbell.erp.entity.PurhaskPK;
import cn.hanbell.erp.entity.Purqnam;
import cn.hanbell.erp.entity.PurqnamPK;
import cn.hanbell.erp.entity.Purvdr;
import cn.hanbell.oa.ejb.HKCG007Bean;
import cn.hanbell.oa.ejb.HKCG007purDetailBean;
import cn.hanbell.oa.entity.HKCG007;
import cn.hanbell.oa.entity.HKCG007purDetail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
 * @author C1491
 */
@Stateless
@LocalBean
public class PurhaskBean extends SuperEJBForERP<Purhask> {

    @EJB
    private PursysBean pursysBean;
    @EJB
    private HKCG007Bean hkcg007Bean;
    @EJB
    private HKCG007purDetailBean hkcg007purDetailBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private PurvdrBean purvdrBean;
    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private PurdaskBean purdaskBean;
    @EJB
    private PurqnamBean purqnamBean;
    @EJB
    private PurdaskdscBean purdaskdscBean;

    public PurhaskBean() {
        super(Purhask.class);
    }

    public Purhask findBySrcno(String srcno) {
        Query query = getEntityManager().createNamedQuery("Purhask.findBySrcno");
        query.setParameter("srcno", srcno);
        try {
            return (Purhask) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean initByOAQGD(String psn) {
        Date date;
        String facno;
        String prono;
        List<Purdask> purdasks = new ArrayList<>();
        List<Purqnam> purqnams = new ArrayList<>();
        List<Purdaskdsc> purdaskdscs = new ArrayList<>();
        try {
            HKCG007 q = hkcg007Bean.findByPSN(psn);
            if (q == null) {
                return false;
            }
            //判断ERP中是否已经抛转
            this.setCompany(q.getFacno());
            if (this.findBySrcno(q.getProcessSerialNumber().substring(4)) != null) {
                return false;
            }
            List<HKCG007purDetail> details = hkcg007purDetailBean.findByFSN(q.getFormSerialNumber());
            for (HKCG007purDetail detail : details) {
                if (!"9".equals(detail.getItnbr())) {
                    invmasBean.setCompany(q.getFacno());
                    Invmas m = invmasBean.findByItnbr(detail.getItnbr());
                    if (m == null) {
                        throw new NullPointerException();
                    }
                }
            }
            facno = q.getFacno();
            prono = q.getProno();
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            pursysBean.setCompany(facno);
            String prno = pursysBean.getNewPrno(facno, prono, date, Boolean.TRUE);
            Purhask p = new Purhask();
            PurhaskPK ppk = new PurhaskPK();
            ppk.setFacno(facno);
            ppk.setPrno(prno);
            ppk.setProno(prono);
            p.setPurhaskPK(ppk);
            p.setPrkind(q.getPrkind());
            p.setPrdate(q.getAppDate());
            p.setDepno(q.getDepno());
            String srcString = q.getProcessSerialNumber().substring(4);
            p.setSrcno(srcString);
            p.setBudgetcode(q.getBudgetcode());                                 //获得专案预算代号
            p.setHmark1(q.getHmark1());                                         //材料区分
            p.setHmark2(q.getCenterid());
            p.setHasksta('Y');
            p.setUserno(q.getCreator());
            p.setIndate(date);
            p.setCfmuserno(q.getCfmuserno());                                   //申请部门权责主管
            p.setCfmdate(date);
            p.setPrtcnt((short) 0);
            if (q.getFormid().isEmpty()) {
                p.setApplyno("N");
            } else {
                p.setApplyno("Y");
            }
            //表身明细
            for (int i = 0; i < details.size(); i++) {
                HKCG007purDetail detail = details.get(i);
                Purdask pd = new Purdask();
                PurdaskPK pdk = new PurdaskPK();
                pdk.setFacno(facno);
                pdk.setPrno(prno);
                pdk.setProno(prono);
                pdk.setTrseq((short) (i + 1));
                pd.setPurdaskPK(pdk);
                pd.setItnbr(detail.getItnbr());
                pd.setPrqy1(BigDecimal.valueOf(Double.parseDouble(detail.getPrqy1())));     //设置请购数量
                pd.setPrqy2(BigDecimal.ZERO);
                pd.setApmqy(pd.getPrqy1());
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                pd.setRqtdate(format.parse(detail.getRqtdateTxt()));                          //需求日期
                //如果是补单，更新表身是否紧急栏位
                if ("1".equals(q.getIssup())) {
                    pd.setEmgyn('B');
                } else {
                    pd.setEmgyn(detail.getEmgyn().charAt(0));
                }
                pd.setDmark1(detail.getDmark1());
                pd.setDmark2(detail.getDmark2());
                pd.setDasksta("20");                                                        //请购单身状态码
                if (!"9".equals(detail.getItnbr())) {
                    invmasBean.setCompany(q.getFacno());
                    Invmas m = invmasBean.findByItnbr(detail.getItnbr());
                    pd.setPurtrtype(m.getPurtrtype());                                       //品号验收类别
                    String purjudco = m.getJudco();
                    pd.setJudco(purjudco.substring(2, 3) + purjudco.substring(3, 4));
                } else {
                    pd.setPurtrtype("");
                    pd.setJudco("11");
                }
                pd.setVdrno(detail.getVdrno());
                pd.setBuyer(detail.getBuyer());
                pd.setCoin(q.getCurrency());
                if (!"".equals(detail.getUnpris())) {
                    double d1 = Double.parseDouble(detail.getUnpris());
                    pd.setUnpris(BigDecimal.valueOf(d1));
                }
                pd.setRatio(BigDecimal.valueOf(q.getRate()));
                if (!"".equals(detail.getTax())) {
                    pd.setTax(detail.getTax().charAt(0));
                }
                if (!"".equals(detail.getTaxrate())) {
                    pd.setTaxrate(BigDecimal.valueOf(Double.parseDouble(detail.getTaxrate())));
                }
                pd.setTotamts(BigDecimal.valueOf(Double.parseDouble(detail.getCtotamts())));
                pd.setTramts(BigDecimal.valueOf(Double.parseDouble(detail.getCtramts())));
                pd.setTaxamts(BigDecimal.valueOf(Double.parseDouble(detail.getCtaxamts())));
                if (!"".equals(detail.getAskdateTxt())) {
                    pd.setAskdate(format.parse(detail.getAskdateTxt()));                         //设置预计交期
                }
                purvdrBean.setCompany(facno);
                if (!detail.getVdrna().isEmpty()) {
                    Purvdr pv = purvdrBean.findByVdrno(detail.getVdrno());
                    pd.setTermcode(pv.getTermcode());
                    miscodeBean.setCompany(facno);
                    Miscode m1 = miscodeBean.findByPK("GH", pd.getTermcode());
                    pd.setTermcodedsc(m1.getCdesc());
                    pd.setSndcode(pv.getSndcode());
                    Miscode m2 = miscodeBean.findByPK("GD", pd.getSndcode());
                    pd.setSndcodedsc(m2.getCdesc());
                    pd.setPaycom(pv.getPaycom());
                    pd.setPaycode(pv.getPaycode());
                    String paycodedsc = pv.getPaycode() == '1' ? "现金" : pv.getPaycode() == '2' ? "支票" : pv.getPaycode() == '3' ? "国内T/T或承兑汇票" : pv.getPaycode() == '4' ? "国~外T/T" : pv.getPaycode() == '5' ? "国内L/C" : pv.getPaycode() == '6' ? "国~外L/C" : pv.getPaycode() == '7' ? "D/A" : pv.getPaycode() == '8' ? "D/P" : "";    //付款条件叙述--------------
                    paycodedsc = paycodedsc + " " + pv.getTickdays() + "天";
                    pd.setPaycodedsc(paycodedsc);
                    pd.setPaysepcode(pv.getPaysepcode());
                    pd.setSeldate1(pv.getSeldate1());
                    pd.setSeldate2(pv.getSeldate2());
                    pd.setSeldate3(pv.getSeldate3());
                    pd.setSeldate4(pv.getSeldate4());
                    pd.setHandays1(pv.getHandays1());
                    pd.setHandays2(pv.getHandays2());
                    pd.setHandays3(pv.getHandays3());
                    pd.setHandays4(pv.getHandays4());
                    pd.setTickdays(pv.getTickdays());
                    pd.setDecode(pv.getDecode());
                    pd.setPosrccode(detail.getPosrccode().charAt(0));            //单价来源码
                }
                pd.setPrepayamts(BigDecimal.ZERO);
                if(null == detail.getAddcode() || "".equals(detail.getAddcode())){
                    pd.setAddcode(facno);
                }else{
                    pd.setAddcode(detail.getAddcode());
                }               
                pd.setPoprtcnt((short) 0);
                pd.setRefno(q.getFormid());                                      //请购来源编号
                pd.setModnum((short) 0);
                pd.setTransno("N");
                pd.setBudgetacc(detail.getBudgetacc());
                pd.setPreprice(BigDecimal.ZERO);
                purdasks.add(pd);

                //9件号，更新purqnam 表
                if ("9".equals(detail.getItnbr())) {
                    Purqnam purqnam = new Purqnam();
                    PurqnamPK purqnamPK = new PurqnamPK();
                    purqnamPK.setFacno(facno);
                    purqnamPK.setPrno(prno);
                    purqnamPK.setProno(prono);
                    purqnamPK.setTrseq(pdk.getTrseq());
                    purqnam.setPurqnamPK(purqnamPK);
                    purqnam.setItdsc(detail.getItdsc());
                    purqnam.setSpdsc(detail.getSpdsc());
                    purqnam.setUnmsr1(detail.getAppunit());
                    purqnams.add(purqnam);
                }
                //请购备注/用途
                if (!"".equals(detail.getPurdaskdescs())) {
                    Purdaskdsc purdaskdsc = new Purdaskdsc();
                    PurdaskdscPK purdaskdscPK = new PurdaskdscPK();
                    purdaskdscPK.setFacno(facno);
                    purdaskdscPK.setPrno(prno);
                    purdaskdscPK.setProno(prono);
                    purdaskdscPK.setTrseq(pdk.getTrseq());
                    purdaskdsc.setPurdaskdscPK(purdaskdscPK);
                    purdaskdsc.setMark1(detail.getPurdaskdescs());
                    purdaskdsc.setMark2("");
                    purdaskdsc.setMark3("");
                    purdaskdsc.setMark4("");
                    purdaskdsc.setMark5("");
                    purdaskdsc.setMark6("");
                    purdaskdsc.setMark7("");
                    purdaskdsc.setMark8("");
                    purdaskdsc.setMark9("");
                    purdaskdsc.setMarka("");
                    purdaskdscs.add(purdaskdsc);
                }

            }
            this.persist(p);
            purdaskBean.setCompany(q.getFacno());
            purdasks.forEach((pd) -> {
                purdaskBean.persist(pd);
            });
            purqnamBean.setCompany(facno);
            purqnams.forEach((purqnam) -> {
                purqnamBean.persist(purqnam);
            });
            purdaskdscBean.setCompany(facno);
            purdaskdscs.forEach((purdaskdsc) -> {
                purdaskdscBean.persist(purdaskdsc);
            });
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PurhaskBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
