/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmrno;
import cn.hanbell.erp.entity.Apmsys;
import cn.hanbell.erp.entity.Purvdr;
import cn.hanbell.util.BaseLib;
import java.text.ParseException;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ApmsysBean extends SuperEJBForERP<Apmsys> {

    @EJB
    private ApmrnoBean apmrnoBean;
    @EJB
    private PurvdrBean purvdrBean;

    public ApmsysBean() {
        super(Apmsys.class);
    }

    public String getFormId(String facno, String prgno, Date date, Boolean flag) throws Exception {
        String maxid, newid;
        String prg, code, format, header;
        Integer seqlen, id;
        Apmsys e = this.findById(facno);
        if (e == null) {
            throw new NullPointerException();
        }
        switch (prgno) {
            case "APM525":
                prg = "1";
                code = e.getAutnrfnt1();
                format = getFormCode(facno, date, e.getAutnrformat1().substring(0, 1)) + getFormCode(facno, date, e.getAutnrformat1().substring(1, 2))
                        + getFormCode(facno, date, e.getAutnrformat1().substring(2, 3)) + getFormCode(facno, date, e.getAutnrformat1().substring(3, 4))
                        + getFormCode(facno, date, e.getAutnrformat1().substring(4, 5));
                seqlen = Integer.parseInt(e.getAutnrformat1().substring(5));
                break;
            default:
                prg = "";
                code = "";
                format = "";
                seqlen = 0;
        }
        header = code + format;
        apmrnoBean.setCompany(facno);
        Apmrno n = apmrnoBean.findMaxByPK(facno, prg, header + "%");
        if (n != null) {
            maxid = n.getApmrnoPK().getMaxnumber();
            int m = maxid.length();
            id = Integer.parseInt(maxid.substring(m - seqlen, m));
            newid = header + String.format("%0" + seqlen + "d", id + 1);
        } else {
            newid = header + String.format("%0" + seqlen + "d", 1);
        }
        if (flag) {
            apmrnoBean.persist(new Apmrno(facno, prg, newid));
            if (n != null) {
                apmrnoBean.delete(n);
            }
        }
        return newid;

    }

    protected String getFormCode(String facno, Date date, String code) {

        String trno = "", dateString;
        Integer month;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        switch (code) {
            case "0":
                trno = "";
                break;
            case "1":
            case "A":
            case "B":
            case "C":
                trno = facno;
                break;
            case "2":
                dateString = BaseLib.formatDate("yyyy", date);
                trno = dateString.substring(2);
                break;
            case "D":
                trno = BaseLib.formatDate("yyyy", date);
                break;
            case "E":
                dateString = BaseLib.formatDate("yyyy", date);
                trno = dateString.substring(3);
                break;
            case "3":
                month = c.get(Calendar.MONTH) + 1;
                trno = String.format("%02d", month);
                break;
            case "F":
                month = c.get(Calendar.MONTH) + 1;
                switch (month) {
                    case 10:
                        trno = "A";
                        break;
                    case 11:
                        trno = "B";
                        break;
                    case 12:
                        trno = "C";
                        break;
                    default:
                        trno = month.toString();
                }
                break;
            case "4":
                dateString = BaseLib.formatDate("yyyyMMdd", date);
                trno = dateString.substring(6);
                break;
        }
        return trno;
    }

    public Apmsys findByFacno(String facno) {
        Query query = getEntityManager().createNamedQuery("Apmsys.findByFacno");
        query.setParameter("facno", facno);
        try {
            return (Apmsys) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }

    /**
     * C1491 Description: 计算预计付款日
     *
     * @param facno
     * @param vdrno
     * @param bildate 申请日期
     * @return 预计付款日
     */
    public Date getpurdate(String facno, String vdrno, Date bildate) {
        int li_seldate1, li_seldate2, li_seldate3, li_seldate4, li_handays1, li_handays2;
        int li_handays3, li_handays4, li_tickdays, li_handays;
        Character ls_paycom, ls_decode, ls_paycode, ls_paysepcode, ls_payterm;
        int li_year, li_month, li_day;
        Date ld_shpdate, ld_predate, ld_payda;
        boolean lb_nextmonth;
        int li_payda1;
        String ls_month, ls_year;
        Date arg_payda = bildate;
        if ("9".equals(vdrno)) {
            return getPayda(facno, bildate, 0);
        }
        ld_shpdate = bildate;
        purvdrBean.setCompany(facno);
        Purvdr pv = purvdrBean.findByVdrno(vdrno);
        ls_paycom = pv.getPaycom();
        li_tickdays = pv.getTickdays() != null ? pv.getTickdays() : 0;
        ls_decode = pv.getDecode();
        ls_paycode = pv.getPaycode();
        ls_paysepcode = pv.getPaysepcode();
        li_handays1 = pv.getHandays1() != null ? pv.getHandays1() : 0;
        li_handays2 = pv.getHandays2() != null ? pv.getHandays2() : 0;
        li_handays3 = pv.getHandays3() != null ? pv.getHandays3() : 0;
        li_handays4 = pv.getHandays4() != null ? pv.getHandays4() : 0;
        li_seldate1 = pv.getSeldate1() != null ? pv.getSeldate1() : 0;
        li_seldate2 = pv.getSeldate2() != null ? pv.getSeldate2() : 0;
        li_seldate3 = pv.getSeldate3() != null ? pv.getSeldate3() : 0;
        li_seldate4 = pv.getSeldate4() != null ? pv.getSeldate4() : 0;
        this.setCompany(facno);
        Apmsys apmsys = findByFacno(facno);
        li_payda1 = apmsys.getPayda1();
        ls_payterm = apmsys.getPayterm();
        switch (ls_paycom) {
            case '1':
                return getPayda(facno, bildate, li_tickdays);
            case '2':
                if ('2' == ls_decode) {
                    if (ls_paycode == '6' || ls_paycode == '7' || ls_paycode == '8') {
                        return ld_shpdate;
                    } else {
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(ld_shpdate);
                        cal.add(Calendar.DATE, li_tickdays);
                        return cal.getTime();
                    }
                }
                //内购资料计算
                try {
                    if ('1' == ls_decode) {
                        if ('5' == ls_paycode) {
                            return ld_shpdate;
                        }
                        switch (ls_paysepcode) {
                            case '1':   //每月月结後,得到下月第一天
                                Calendar ca = Calendar.getInstance();
                                ca.setTime(ld_shpdate);
                                li_year = ca.get(Calendar.YEAR);
                                li_month = ca.get(Calendar.MONTH) + 1 + 1;
                                if (li_month == 13) {
                                    li_month = 1;
                                    li_year += 1;
                                }
                                ld_predate = BaseLib.getDate("yyyy/MM/dd", li_year + "/" + String.format("%02d", li_month) + "/" + "01");
                                if (ls_paycode == '1' || ls_paycode == '2') {    //现金,支票
                                    if (ls_payterm == 'Y') {
                                        ca.setTime(ld_predate);
                                        ca.add(Calendar.DATE, li_handays1 - 1);
                                        arg_payda = ca.getTime();
                                    } else {
                                        ca.setTime(ld_predate);
                                        ca.add(Calendar.DATE, li_handays1);
                                        arg_payda = ca.getTime();
                                    }

                                }
                                if (ls_paycode == '3') {    //国内T/T 		
                                    if (ls_payterm == 'Y') {
                                        ca.setTime(ld_predate);
                                        ca.add(Calendar.DATE, li_handays1 - 1 + li_tickdays);
                                        arg_payda = ca.getTime();
                                    } else {
                                        ca.setTime(ld_predate);
                                        ca.add(Calendar.DATE, li_handays1 + li_tickdays);
                                        arg_payda = ca.getTime();
                                    }
                                }
                                break;
                            case '2':   //每月?日後
                                Calendar ca2 = Calendar.getInstance();
                                ca2.setTime(ld_shpdate);
                                li_day = ca2.get(Calendar.DATE);
                                li_year = ca2.get(Calendar.YEAR);
                                li_month = ca2.get(Calendar.MONTH) + 1;
                                if (li_day < li_seldate1) {   //本月内
                                    ld_predate = BaseLib.getDate("yyyy/MM/dd", li_year + "/" + String.format("%02d", li_month) + "/" + String.format("%02d", li_seldate1));
                                    if (ls_paycode == '1' || ls_paycode == '2') {
                                        if (ls_payterm == 'Y') {
                                            ca2.setTime(ld_shpdate);
                                            ca2.add(Calendar.DATE, li_seldate1 - li_day + li_handays1);
                                            arg_payda = ca2.getTime();
                                        } else {
                                            ca2.setTime(ld_predate);
                                            ca2.add(Calendar.DATE, li_handays1);
                                            arg_payda = ca2.getTime();
                                        }
                                    }
                                    if (ls_paycode == '3') {    //国内T/T 		
                                        if (ls_payterm == 'Y') {
                                            ca2.setTime(ld_shpdate);
                                            ca2.add(Calendar.DATE, li_seldate1 - li_day + li_handays1 + li_tickdays);
                                            arg_payda = ca2.getTime();
                                        } else {
                                            ca2.setTime(ld_predate);
                                            ca2.add(Calendar.DATE, li_handays1 + li_tickdays);
                                            arg_payda = ca2.getTime();
                                        }
                                    }
                                } else {   //下月
                                    ca2.setTime(ld_shpdate);
                                    li_month = ca2.get(Calendar.MONTH) + 1 + 1;
                                    li_year = ca2.get(Calendar.YEAR);
                                    if (li_month == 13) {
                                        li_month = 1;
                                        li_year += 1;
                                    }
                                    ld_predate = BaseLib.getDate("yyyy/MM/dd", li_year + "/" + String.format("%02d", li_month) + "/" + String.format("%02d", li_seldate1));
                                    if (ls_paycode == '1' || ls_paycode == '2') {    //现金,支票
                                        if (ls_payterm == 'Y') {
                                            ca2.setTime(ld_predate);
                                            ca2.add(Calendar.DATE, li_handays1);
                                            arg_payda = ca2.getTime();
                                        } else {
                                            ca2.setTime(ld_predate);
                                            ca2.add(Calendar.DATE, li_handays1);
                                            arg_payda = ca2.getTime();
                                        }
                                    }
                                    if (ls_paycode == '3') {    //国内T/T 		
                                        if (ls_payterm == 'Y') {
                                            ca2.setTime(ld_predate);
                                            ca2.add(Calendar.DATE, li_handays1 + li_tickdays);
                                            arg_payda = ca2.getTime();
                                        } else {
                                            ca2.setTime(ld_predate);
                                            ca2.add(Calendar.DATE, li_handays1 + li_tickdays);
                                            arg_payda = ca2.getTime();
                                        }
                                    }
                                }
                                break;
                            case '3': //每月月结,半月结,旬结,周结
                                Calendar ca3 = Calendar.getInstance();
                                ca3.setTime(ld_shpdate);
                                li_day = ca3.get(Calendar.DATE);
                                li_year = ca3.get(Calendar.YEAR);
                                li_month = ca3.get(Calendar.MONTH) + 1;
                                if (li_day < li_seldate1) {  //在第一个交货截止日当期结算
                                    li_day = li_seldate1;
                                    li_handays = li_handays1;
                                    lb_nextmonth = false;
                                } else {
                                    if (li_seldate2 == 0) {  //月结;第一交货截止日的下个月结
                                        li_day = li_seldate1;
                                        li_handays = li_handays1;
                                        lb_nextmonth = true;
                                    } else {   //半月结
                                        if (li_day < li_seldate2) { //在第二个交货截止日当期结算
                                            li_day = li_seldate2;
                                            li_handays = li_handays2;
                                            lb_nextmonth = false;
                                        } else {
                                            if (li_seldate3 == 0) {
                                                li_day = li_seldate1;
                                                li_handays = li_handays1;
                                                lb_nextmonth = true;
                                            } else {
                                                if (li_day < li_seldate3) {
                                                    li_day = li_seldate3;
                                                    li_handays = li_handays3;
                                                    lb_nextmonth = false;
                                                } else {
                                                    if (li_seldate4 == 0) {
                                                        li_day = li_seldate1;
                                                        li_handays = li_handays1;
                                                        lb_nextmonth = true;
                                                    } else {
                                                        if (li_day < li_seldate4) {
                                                            li_day = li_seldate4;
                                                            li_handays = li_handays4;
                                                            lb_nextmonth = false;
                                                        } else {
                                                            li_day = li_seldate1;
                                                            li_handays = li_handays1;
                                                            lb_nextmonth = true;
                                                        }
                                                    }

                                                }
                                            }

                                        }
                                    }
                                }
                                if (lb_nextmonth) {
                                    li_month = li_month + 1;
                                    if (li_month == 13) {
                                        li_month = 1;
                                        li_year = li_year + 1;
                                    }
                                }
                                ld_predate = BaseLib.getDate("yyyy/MM/dd", li_year + "/" + String.format("%02d", li_month) + "/" + "01");
                                if (ls_paycode == '1' || ls_paycode == '2') {    //现金,支票
                                    if (ls_payterm == 'Y') {
                                        ca3.setTime(ld_predate);
                                        ca3.add(Calendar.DATE, li_handays);
                                        arg_payda = ca3.getTime();
                                    } else {
                                        ca3.setTime(ld_predate);
                                        ca3.add(Calendar.DATE, li_handays1);
                                        arg_payda = ca3.getTime();
                                    }

                                }
                                if (ls_paycode == '3') {    //国内T/T 		
                                    if (ls_payterm == 'Y') {
                                        ca3.setTime(ld_predate);
                                        ca3.add(Calendar.DATE, li_handays + li_tickdays);
                                        arg_payda = ca3.getTime();
                                    } else {
                                        ca3.setTime(ld_predate);
                                        ca3.add(Calendar.DATE, li_handays1 + li_tickdays);
                                        arg_payda = ca3.getTime();
                                    }
                                }
                                break;
                            case '4':  //每月隔月结後,得到下下月第一天
                                Calendar ca4 = Calendar.getInstance();
                                ca4.setTime(ld_shpdate);
                                li_year = ca4.get(Calendar.YEAR);
                                li_month = ca4.get(Calendar.MONTH) + 1 + 2;
                                if (li_month > 12) {
                                    li_month = li_month - 12;
                                    li_year = li_year + 1;
                                }
                                ld_predate = BaseLib.getDate("yyyy/MM/dd", li_year + "/" + String.format("%02d", li_month) + "/" + "01");
                                if (ls_paycode == '1' || ls_paycode == '2') {    //现金,支票
                                    if (ls_payterm == 'Y') {
                                        ca4.setTime(ld_predate);
                                        ca4.add(Calendar.DATE, li_handays1);
                                        arg_payda = ca4.getTime();
                                    } else {
                                        ca4.setTime(ld_predate);
                                        ca4.add(Calendar.DATE, li_handays1);
                                        arg_payda = ca4.getTime();
                                    }
                                }
                                if (ls_paycode == '3') {    //国内T/T 		
                                    if (ls_payterm == 'Y') {
                                        ca4.setTime(ld_predate);
                                        ca4.add(Calendar.DATE, li_handays1 + li_tickdays);
                                        arg_payda = ca4.getTime();
                                    } else {
                                        ca4.setTime(ld_predate);
                                        ca4.add(Calendar.DATE, li_handays1 + li_tickdays);
                                        arg_payda = ca4.getTime();
                                    }
                                }
                                break;
                            case '5':   //货到
                            case '6':   //发票到
                                Calendar ca5 = Calendar.getInstance();
                                ca5.setTime(ld_shpdate);
                                if (ls_paycode == '1' || ls_paycode == '2') {    //现金,支票
                                    if (ls_payterm == 'Y') {
                                        ca5.setTime(ld_shpdate);
                                        ca5.add(Calendar.DATE, li_handays1);
                                        arg_payda = ca5.getTime();
                                    } else {
                                        ca5.setTime(ld_shpdate);
                                        ca5.add(Calendar.DATE, li_handays1);
                                        arg_payda = ca5.getTime();
                                    }
                                }
                                if (ls_paycode == '3') {    //国内T/T 		
                                    if (ls_payterm == 'Y') {
                                        ca5.setTime(ld_shpdate);
                                        ca5.add(Calendar.DATE, li_handays1 + li_tickdays);
                                        arg_payda = ca5.getTime();
                                    } else {
                                        ca5.setTime(ld_shpdate);
                                        ca5.add(Calendar.DATE, li_handays1 + li_tickdays);
                                        arg_payda = ca5.getTime();
                                    }
                                }
                                break;
                            default:
                                arg_payda = bildate;
                                break;
                        }

                    }
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(ApmsysBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
        return arg_payda;
    }

    /**
     * C1491 获得付款日期（APM811）
     *
     * @param facno 事业单位
     * @param vpayda 验收付款日
     * @param daycnt 票据天数
     * @return payda 预计付款日期
     */
    public Date getPayda(String facno, Date vpayda, long daycnt) {
        int li_payda1, li_payda2, li_fdat1, li_tdat1, li_fdat2, li_tdat2, li_delyday, li_cnt, li_chkd;
        int li_ptype, li_mm, li_dd, li_year, li_num, li_recdd, li_daycnt, li_pmm, li_tmm, li_pyear, li_tyear, li_pdd, li_tdd, li_i, li_j;
        String ls_cntcode;
        Date ld_chkd;
        Date payda = vpayda;
        this.setCompany(facno);
        Apmsys apmsys = findByFacno(facno);
        if (null == apmsys) {
            return vpayda;
        } else {
            li_payda1 = apmsys.getPayda1();
            li_fdat1 = apmsys.getFdat1();
            li_tdat1 = apmsys.getTdat1();
            li_fdat2 = apmsys.getFdat2();
            li_tdat2 = apmsys.getTdat2();
            ls_cntcode = apmsys.getCntcode();
            li_payda2 = apmsys.getPayda2();
            if (li_payda1 == 0 && li_fdat1 == 0 && li_tdat1 == 0) {
                return vpayda;
            }
            //计算预计付款日
            Calendar ca = Calendar.getInstance();
            ca.setTime(vpayda);
            li_year = ca.get(Calendar.YEAR);
            li_mm = ca.get(Calendar.MONTH) + 1;
            li_dd = ca.get(Calendar.DATE);
            li_pmm = li_mm;
            li_pdd = li_dd;
            li_pyear = li_year;

            if (li_fdat2 == 0 && li_tdat2 == 0) {
                li_cnt = 1;
                if (li_fdat1 > li_tdat1) {
                    if (li_dd > li_tdat1) {
                        li_pmm += 1;
                    }
                    if (li_tdat1 >= li_payda1) {
                        li_pmm += 1;
                    }
                } else {
                    li_pmm += 1;
                }
                li_pdd = li_payda1;
                //票据起算日　by cntcode="1" -> 整帐区间截止日  /"2" -> 依付款日
                if ("1".equals(ls_cntcode)) {
                    if (li_fdat1 > li_tdat1) {
                        if (li_dd < li_tdat1) {
                            li_num = li_mm;
                        } else {
                            li_num = li_mm + 1;
                        }
                    } else {
                        li_num = li_pmm;
                    }
                    li_tdd = li_tdat1;
                } else {
                    li_tdd = li_payda1;
                }
            } else {
                li_cnt = 2;
                if ((li_fdat1 < li_tdat1 && li_dd >= li_fdat1 && li_dd <= li_tdat1) || (li_fdat1 > li_tdat1 && li_dd >= li_fdat1 && li_dd <= 31) || (li_fdat1 > li_tdat1 && li_dd <= li_tdat1)) {
                    if (li_dd > li_tdat1) {
                        li_pmm += 1;
                    }
                    if (li_tdat1 >= li_payda1) {
                        li_pmm += 1;
                    }
                    li_pdd = li_payda1;
                    //票据起算日参数
                    if ("1".equals(ls_cntcode)) {
                        li_tdd = li_tdat1;
                    } else {
                        li_tdd = li_payda1;
                    }
                } else {
                    if (li_fdat2 > li_tdat2) {
                        if (li_dd > li_tdat2) {
                            li_pmm += 1;
                        }
                        if (li_tdat2 >= li_payda2) {
                            li_pmm += 1;
                        }
                    } else {
                        if (li_tdat2 >= li_payda2) {
                            li_pmm += 1;
                        }
                    }
                    li_pdd = li_payda2;
                    if ("1".equals(ls_cntcode)) {
                        li_tdd = li_tdat2;
                    } else {
                        li_tdd = li_payda2;
                    }
                }
            }
            if (li_pmm > 12) {
                li_pyear += 1;
                li_pmm = li_pmm - 12;
            }
            //月底日期确认(避免月底日期为28,30的错误)
            try {
                if (li_pdd > 28 || li_tdd > 28) {
                    li_j = li_pyear;
                    li_i = li_pmm + 1;
                    if (li_i > 12) {
                        li_j = li_pyear + 1;
                        li_i = li_i - 12;
                    }

                    ld_chkd = BaseLib.getDate("yyyy/MM/dd", li_j + "/" + String.format("%02d", li_i) + "/" + "01");
                    ca.setTime(ld_chkd);
                    ca.add(Calendar.DATE, -1);
                    li_chkd = ca.get(Calendar.DATE);
                    if (li_pdd > 28 && li_pdd > li_chkd) {
                        li_pdd = li_chkd;

                    }
                }
                payda = BaseLib.getDate("yyyy/MM/dd", li_pyear + "/" + String.format("%02d", li_pmm) + "/" + String.format("%02d", li_pdd));
            } catch (ParseException ex) {
                ex.printStackTrace();
                Logger.getLogger(ApmsysBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (payda == null) {
            payda = vpayda;
        }
        return payda;
    }

    /**
     * Description: 计算预计付款日和票据到期日
     *
     * @param facno
     * @param vdrno 厂商
     * @param bildate 申请日期
     * @return 预计付款日
     */
    public Date getpurdate2(String facno, String vdrno, Date bildate) {
        int li_tickdays;
        int li_year, li_month;
        Date payda = bildate;
        try {
            if ("9".equals(vdrno)) {
                return getPayda(facno, bildate, 0);
            }
            purvdrBean.setCompany(facno);
            Purvdr pv = purvdrBean.findByVdrno(vdrno);
            li_tickdays = pv.getTickdays() != null ? pv.getTickdays() : 0;
            Calendar ca = Calendar.getInstance();
            ca.setTime(bildate);
            li_year = ca.get(Calendar.YEAR);
            li_month = ca.get(Calendar.MONTH) + 1;
            if (li_tickdays <= 30) {
                li_month += 1;
                if (li_month == 13) {
                    li_month = 1;
                    li_year += 1;
                }
                payda = BaseLib.getDate("yyyy/MM/dd", li_year + "/" + String.format("%02d", li_month) + "/" + "25");
            } else {
                ca.add(Calendar.DATE, li_tickdays);
                payda = ca.getTime();
                li_month = ca.get(Calendar.MONTH) + 1;
                payda = BaseLib.getDate("yyyy/MM/dd", li_year + "/" + String.format("%02d", li_month) + "/" + "25");
            }
            return payda;
        } catch (ParseException ex) {
            Logger.getLogger(ApmsysBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payda;
    }

}
