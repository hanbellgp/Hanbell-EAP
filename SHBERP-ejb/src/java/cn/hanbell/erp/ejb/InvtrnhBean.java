/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmpyh;
import cn.hanbell.erp.entity.Invclswah;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.erp.entity.Invsys;
import cn.hanbell.erp.entity.Invtrnh;
import cn.hanbell.erp.entity.InvtrnhPK;
import cn.hanbell.erp.entity.Puracd;
import cn.hanbell.erp.entity.Pursys;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
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
public class InvtrnhBean extends SuperEJBForERP<Invtrnh> {

    @EJB
    private ApmpyhBean apmpyhBean;
    @EJB
    private InvsysBean invsysBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private PuracdBean puracdBean;
    @EJB
    private InvclswahBean invclswahBean;
    @EJB
    private InvwhBean invwhBean;
    @EJB
    private PursysBean pursysBean;

    public InvtrnhBean() {
        super(Invtrnh.class);
    }

    public Invtrnh findBySourcenoAndInd2(String facno, String itnbr, Character iocode, String syscode, String trtype, String wareh, Character priyn, String sourceno, String sourceno1) {
        Query query = this.getEntityManager().createNamedQuery("Invtrnh.findBySourcenoAndInd2");
        query.setParameter("facno", facno);
        query.setParameter("itnbr", itnbr);
        query.setParameter("iocode", iocode);
        query.setParameter("syscode", syscode);
        query.setParameter("trtype", trtype);
        query.setParameter("wareh", wareh);
        query.setParameter("priyn", priyn);
        query.setParameter("sourceno", sourceno);
        query.setParameter("sourceno1", sourceno1);
        try {
            Object o = query.getSingleResult();
            if (o == null) {
                return null;
            } else {
                return (Invtrnh) o;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public int invapminsert(String facno, String trtype, String acpno, String sourceno, String userno, String sysno, Date trdate, BigDecimal tramt) {
        apmpyhBean.setCompany(facno);
        invsysBean.setCompany(facno);
        invmasBean.setCompany(facno);
        puracdBean.setCompany(facno);
        invclswahBean.setCompany(facno);
        invwhBean.setCompany(facno);
        pursysBean.setCompany(facno);
        String ls_itnbr;
        Date ldt_trdate;
        String ls_date;
        String ls_cstno = "";
        String ls_iocode;
        String ls_trno;
        String ls_acceptno;
        String ls_wareh = "";
        String ls_fixnr, ls_varnr;
        String ls_asstype;
        String ls_syscode;
        short li_purtrseq;
        int li_trseq;
        BigDecimal ldc_ttassm;
        BigDecimal ldc_ttmatm;
        Apmpyh apmpyh = apmpyhBean.findByPK(facno, acpno);
        try {
            if (null == apmpyh) {
                throw new RuntimeException("所选择之验收单: [" + acpno + "] 资料不全");
            } else {

                ls_itnbr = apmpyh.getItnbr();
                if ("9".equals(ls_itnbr)) {
                    return 0;
                }
                if (!"APM253".equals(sysno)) {
                    ldt_trdate = BaseLib.getDate();
                } else {
                    ldt_trdate = trdate;
                }
                //分别料工费分离or合并
                Invsys invsys = invsysBean.findByFacno(facno);
                if (null == invsys) {
                    throw new RuntimeException("系统档资料错误");
                } else if (invsys.getCstno() == null || invsys.getCstno().equals("")) {
                    ls_cstno = "1";
                }
                ls_date = BaseLib.formatDate("yyyyMMdd", trdate);
                if ("ADD".equals(trtype)) {
                    //短估
                    ls_iocode = "1";
                } else {
                    //溢估trtype ='DIS'
                    ls_iocode = "2";
                }
                ls_trno = trtype + ls_date;
                li_trseq = getMaxTrseqBytrno(facno, "1", trtype, ls_trno);
                Invmas m = invmasBean.findByItnbr(ls_itnbr);
                if (null == m) {
                    throw new RuntimeException("所选择之品号目前不存在品号主档!");
                }
                //传验收单号apmpyh.acpno分解
                ls_acceptno = acpno.split("-")[0];
                li_purtrseq = Short.valueOf(acpno.split("-")[1]);
                Puracd puracd = puracdBean.findByPK(facno, "1", ls_acceptno, li_purtrseq);
                ls_wareh = puracd.getWareh();
                if (null == ls_wareh || "".equals(ls_wareh)) {
                    Invclswah invclswah = invclswahBean.findByInvclswahPK(facno, "1", m.getItcls());
                    ls_wareh = invclswah.getDefwah();
                    if (null == ls_wareh || "".equals(ls_wareh)) {
                        ls_wareh = invwhBean.getMinWareh(facno, "1");
                        if (null == ls_wareh || "".equals(ls_wareh)) {
                            throw new RuntimeException("所选择之验收单目前不存在点验收档案!");
                        }
                    }
                }
                if (null == puracd.getFixnr()) {
                    ls_fixnr = "";
                } else {
                    ls_fixnr = puracd.getFixnr();
                }
                if (null == puracd.getVarnr()) {
                    ls_varnr = "";
                } else {
                    ls_varnr = puracd.getVarnr();
                }
                Pursys pursys = pursysBean.findByPK(facno, apmpyh.getProno());
                if (null == pursys || "".equals(pursys.getAsstype())) {
                    throw new RuntimeException("系统档错误!");
                }
                ls_asstype = pursys.getAsstype();
                ls_syscode = "20";
                if ("1".equals(ls_cstno)) {
                    ldc_ttassm = BigDecimal.ZERO;
                    ldc_ttmatm = BigDecimal.ZERO;
                } else //=> Mega 2008/5/3 syscode 可以一律采20, 但托工还是要写到托工折让, 才不会有原料负帐问题
                if (ls_asstype.equals(puracd.getPurtrtype())) {
                    ldc_ttassm = tramt;
                    ldc_ttmatm = BigDecimal.ZERO;
                } else {
                    ldc_ttassm = BigDecimal.ZERO;
                    ldc_ttmatm = tramt;
                }
                //判断invtrnh 是否有过记录
                Invtrnh ih = findBySourcenoAndInd2(facno, ls_itnbr, ls_iocode.charAt(0), ls_syscode, trtype, ls_wareh, 'Y', sourceno, acpno);
                if (ih != null) {
                    return 1;
                }
                Invtrnh invtrnh = new Invtrnh();
                InvtrnhPK invtrnhPK = new InvtrnhPK();
                invtrnhPK.setFacno(facno);
                invtrnhPK.setProno(apmpyh.getProno());
                invtrnhPK.setTrtype(trtype);
                invtrnhPK.setTrno(ls_trno);
                invtrnhPK.setTrseq(li_trseq);
                invtrnh.setInvtrnhPK(invtrnhPK);
                invtrnh.setItnbr(ls_itnbr);
                invtrnh.setTrdate(trdate);
                invtrnh.setDepno(apmpyh.getVdrno());
                invtrnh.setHmark1(sysno);
                invtrnh.setHmark2("");
                invtrnh.setWareh(ls_wareh);
                invtrnh.setFixnr(ls_fixnr);
                invtrnh.setVarnr(ls_varnr);
                invtrnh.setTrnqy1(BigDecimal.ZERO);
                invtrnh.setTrnqy2(BigDecimal.ZERO);
                invtrnh.setTrnqy3(BigDecimal.ZERO);
                invtrnh.setUnmsr1(m.getUnmsr1());
                invtrnh.setUnmsr2(m.getUnmsr2());
                invtrnh.setUnmsr3(m.getUnmsr3());
                invtrnh.setIocode(ls_iocode.charAt(0));
                invtrnh.setDmark1("");
                invtrnh.setDmark2("");
                invtrnh.setUserno(userno);
                invtrnh.setCfmuserno(userno);
                invtrnh.setRescode("");
                invtrnh.setSyscode(sysno);
                invtrnh.setSyscode(ls_syscode);
                invtrnh.setSourceno(sourceno);
                invtrnh.setItcls(m.getItcls());
                invtrnh.setItclscode(m.getItclscode());
                invtrnh.setIndate(ldt_trdate);
                invtrnh.setCfmdate(ldt_trdate);
                invtrnh.setTramt(tramt);
                invtrnh.setPriyn('Y');
                invtrnh.setSourceno1(acpno);
                invtrnh.setTtmanm(BigDecimal.ZERO);
                invtrnh.setTtexpm(BigDecimal.ZERO);
                invtrnh.setTtassm(ldc_ttassm);
                invtrnh.setTtmatm(ldc_ttmatm);
                persist(invtrnh);

            }
            return 0;
        } catch (RuntimeException ex) {
            Logger.getLogger(InvtrnhBean.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

    }

    public int getMaxTrseqBytrno(String facno, String prono, String trtype, String trno) {
        StringBuilder sb = new StringBuilder();
        int s;
        sb.append("SELECT  max(trseq)  from invtrnh where facno = '").append(facno).append("' AND prono = '").append(prono).append("' AND trtype = '").append(trtype).append("' AND trno = '").append(trno).append("'");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        try {
            if (null == query.getSingleResult()) {
                s = 1;
            } else {
                s = (int) query.getSingleResult();
                s = s + 1;
            }
            return s;
        } catch (Exception ex) {
            throw new RuntimeException("资料库查询最大数发生错误！");
        }
    }

    public List<String[]> getINV555(Date begin, Date end, LinkedHashMap<String, Object> map) {
        List<String[]> strings = new ArrayList<>();
        String facno = map.get("facno") != null ? map.get("facno").toString() : "";
        String trtype = map.get("trtype") != null ? map.get("trtype").toString() : "";
        String depno = map.get("depno") != null ? map.get("depno").toString() : "";
        String userno = map.get("userno") != null ? map.get("userno").toString() : "";
        String wareh = map.get("wareh") != null ? map.get("wareh").toString() : "";

        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT  b.trtype,e.typedsc,b.facno,b.prono,b.depno,  ");
        sb.append(" (select x.cdesc from miscode x where x.ckind=e.depdsckind and x.code=b.depno ) as depdsc, ");
        sb.append(" b.trno,convert(char(8),b.trdate,112) as trdate,b.trseq,a.itnbr, a.itdsc,b.itclscode,a.itcls,d.clsdsc,b.wareh,c.whdsc, ");
        sb.append(" b.trnqy1,b.unmsr1,b.tramt,b.cfmuserno,case b. iocode when '1' then '入库' when '2' then '出库' when '3' then  '调拨' end as iocodedsc, ");
        sb.append(" (b.hmark1 +").append(" ';' +").append(" b.hmark2 +").append(" ';' +").
                append(" f.mark1 +").append(" ';' +").append(" f.mark2 +").append(" ';' +").append(" f.mark3 +").append(" ';' +").append(" f.mark4) as mark,e.reskind, ");
        sb.append(" (select y.cdesc from miscode y where y.ckind=e.reskind and y.code=b.rescode) as resdsc  FROM  invtrnh b ");
        sb.append("  left outer join invwh c on b.facno=c.facno and b.prono=c.prono and b.wareh=c.wareh ");
        sb.append("  left outer join invdou e on e.trtype=b.trtype left outer join invhdsc f on f.facno=b.facno and f.prono=b.prono and f.trno=b.trno ");
        sb.append("   ,invmas  a left outer join invcls d on a.itcls=d.itcls WHERE ( b.itnbr = a.itnbr )   and  b.facno='${facno}' and b.prono='1' ");
        sb.append("  and (b.trdate>='${begin}' AND b.trdate <='${end}') ");
        if (!"".equals(trtype)) {
            sb.append("  and b.trtype = '").append(trtype).append("'");
        }
        if (!"".equals(depno)) {
            sb.append("  and b.depno = '").append(depno).append("'");
        }
        if (!"".equals(userno)) {
            sb.append("  and b.userno = '").append(userno).append("'");
        }
        if (!"".equals(wareh)) {
            sb.append("  and b.wareh = '").append(wareh).append("'");
        }
        sb.append("  order by  b.trtype ASC,b.trdate ASC,b.trno ASC ");
        String sql1 = sb.toString().replace("${begin}", com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", begin)).replace("${end}", com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", end))
                .replace("${facno}", facno);

        sb.setLength(0);
        sb.append(" SELECT  b.trtype,e.typedsc,b.facno,b.prono,b.depno,  ");
        sb.append(" (select x.cdesc from miscode x where x.ckind=e.depdsckind and x.code=b.depno ) as depdsc, ");
        sb.append(" b.trno,convert(char(8),b.trdate,112) as trdate,b.trseq,a.itnbr, a.itdsc,b.itclscode,a.itcls,d.clsdsc,b.wareh,c.whdsc, ");
        sb.append(" b.trnqy1,b.unmsr1,b.tramt,b.cfmuserno,case b. iocode when '1' then '入库' when '2' then '出库' when '3' then  '调拨' end as iocodedsc, ");
        sb.append(" (b.hmark1 +").append(" ';' +").append(" b.hmark2 +").append(" ';' +").
                append(" f.mark1 +").append(" ';' +").append(" f.mark2 +").append(" ';' +").append(" f.mark3 +").append(" ';' +").append(" f.mark4) as mark,e.reskind, ");
        sb.append(" (select y.cdesc from miscode y where y.ckind=e.reskind and y.code=b.rescode) as resdsc  FROM  invtrn b ");
        sb.append("  left outer join invwh c on b.facno=c.facno and b.prono=c.prono and b.wareh=c.wareh ");
        sb.append("  left outer join invdou e on e.trtype=b.trtype left outer join invhdsc f on f.facno=b.facno and f.prono=b.prono and f.trno=b.trno ");
        sb.append("   ,invmas  a left outer join invcls d on a.itcls=d.itcls WHERE ( b.itnbr = a.itnbr )   and  b.facno='${facno}' and b.prono='1' ");
        sb.append("  and (b.trdate>='${begin}' AND b.trdate <='${end}') ");
        if (!"".equals(trtype)) {
            sb.append("  and b.trtype = '").append(trtype).append("'");
        }
        if (!"".equals(depno)) {
            sb.append("  and b.depno = '").append(depno).append("'");
        }
        if (!"".equals(userno)) {
            sb.append("  and b.userno = '").append(userno).append("'");
        }
        if (!"".equals(wareh)) {
            sb.append("  and b.wareh = '").append(wareh).append("'");
        }
        sb.append("  order by  b.trtype ASC,b.trdate ASC,b.trno ASC ");
        String sql2 = sb.toString().replace("${begin}", com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", begin)).replace("${end}", com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", end))
                .replace("${facno}", facno);
        try {
            setCompany(facno);
            Query query1 = getEntityManager().createNativeQuery(sql1);
            Query query2 = getEntityManager().createNativeQuery(sql2);
            List list1 = query1.getResultList();
            List list2 = query2.getResultList();
            if (list1 != null && !list1.isEmpty()) {
                list2.addAll(list1);
            }
            if (list2 != null && !list2.isEmpty()) {
                String[] arr;
                for (int i = 0; i < list2.size(); i++) {
                    Object[] row = (Object[]) list2.get(i);
                    arr = new String[24];
                    for (int j = 0; j < arr.length; j++) {
                        if (j == 11) {
                            arr[11] = getItclscodeName(row[11] == null ? "" : row[11].toString());
                        } else {
                            arr[j] = row[j] == null ? "" : row[j].toString();
                        }
                    }
                    strings.add(arr);
                }
            }
            return strings;
        } catch (Exception e) {
            return null;
        }
    }

    public List<String[]> getINV570(Date begin, Date end, LinkedHashMap<String, Object> map) {
        List<String[]> strings = new ArrayList<>();
        String facno = map.get("facno") != null ? map.get("facno").toString() : "";
        String trtype = map.get("trtype") != null ? map.get("trtype").toString() : "";
        String depno = map.get("depno") != null ? map.get("depno").toString() : "";
        String userno = map.get("userno") != null ? map.get("userno").toString() : "";
        String wareh = map.get("wareh") != null ? map.get("wareh").toString() : "";

        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT b.trtype,e.typedsc,case when e.depdsckind='CA' then (select cuskind from cdrcus where cusno=b.depno)  ");
        sb.append(" else b.facno end as facno,case when  e.depdsckind='CA' then (select areacode from cdrcus where cusno=b.depno) ");
        sb.append(" else b.prono end  as prono, b.depno, (select x.cdesc from miscode x where x.ckind=e.depdsckind and x.code=b.depno ) as depdsc, ");
        sb.append(" b.trno, convert(char(8),b.trdate,112) as trdate , b.trseq, a.itnbr, a.itdsc,a.itclscode,a.itcls, d.clsdsc, ");
        sb.append(" b.wareh, c.whdsc, b.trnqy1,  b.unmsr1,b.tramt,b.userno, ");
        sb.append(" case b. iocode when  '1'  then  '入库'  when '2'  then  '出库'  when '3'  then  '调拨'  end as iocodedsc, ");
        sb.append(" (b.hmark1 +").append(" ';' +").append(" b.hmark2 +").append(" ';' +").
                append(" f.mark1 +").append(" ';' +").append(" f.mark2 +").append(" ';' +").append(" f.mark3 +").append(" ';' +").append(" f.mark4) as mark,e.reskind, ");
        sb.append(" (select y.cdesc from miscode y where y.ckind=e.reskind and y.code=b.rescode) as resdsc ");
        sb.append("  FROM invmas  a  left outer join invcls d on a.itcls=d.itcls,invtrnh b ");
        sb.append("  left outer join invwh c on b.facno=c.facno and b.prono=c.prono and b.wareh=c.wareh left outer join invdou e on e.trtype=b.trtype");
        sb.append("   left outer join invhdsc f on f.facno=b.facno and f.prono=b.prono and f.trno=b.trno WHERE ( b.itnbr = a.itnbr )   and  b.facno='${facno}' and b.prono='1' ");
        sb.append("  and (b.trdate>='${begin}' AND b.trdate <='${end}') ");
        if (!"".equals(trtype)) {
            sb.append("  and b.trtype = '").append(trtype).append("'");
        }
        if (!"".equals(depno)) {
            sb.append("  and b.depno = '").append(depno).append("'");
        }
        if (!"".equals(userno)) {
            sb.append("  and b.userno = '").append(userno).append("'");
        }
        if (!"".equals(wareh)) {
            sb.append("  and b.wareh = '").append(wareh).append("'");
        } 
        sb.append("  order by  b.trtype ASC,b.trdate ASC,b.trno ASC ");
        String sql1 = sb.toString().replace("${begin}", com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", begin)).replace("${end}", com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", end))
                .replace("${facno}", facno);

        sb.setLength(0);
        sb.append(" SELECT b.trtype,e.typedsc,case when e.depdsckind='CA' then (select cuskind from cdrcus where cusno=b.depno)  ");
        sb.append(" else b.facno end as facno,case when  e.depdsckind='CA' then (select areacode from cdrcus where cusno=b.depno) ");
        sb.append(" else b.prono end  as prono, b.depno, (select x.cdesc from miscode x where x.ckind=e.depdsckind and x.code=b.depno ) as depdsc, ");
        sb.append(" b.trno, convert(char(8),b.trdate,112) as trdate , b.trseq, a.itnbr, a.itdsc,a.itclscode,a.itcls, d.clsdsc, ");
        sb.append(" b.wareh, c.whdsc, b.trnqy1,  b.unmsr1,b.tramt,b.userno, ");
        sb.append(" case b. iocode when  '1'  then  '入库'  when '2'  then  '出库'  when '3'  then  '调拨'  end as iocodedsc, ");
        sb.append(" (b.hmark1 +").append(" ';' +").append(" b.hmark2 +").append(" ';' +").
                append(" f.mark1 +").append(" ';' +").append(" f.mark2 +").append(" ';' +").append(" f.mark3 +").append(" ';' +").append(" f.mark4) as mark,e.reskind, ");
        sb.append(" (select y.cdesc from miscode y where y.ckind=e.reskind and y.code=b.rescode) as resdsc ");
        sb.append("  FROM invmas  a  left outer join invcls d on a.itcls=d.itcls,invtrn b ");
        sb.append("  left outer join invwh c on b.facno=c.facno and b.prono=c.prono and b.wareh=c.wareh left outer join invdou e on e.trtype=b.trtype");
        sb.append("   left outer join invhdsc f on f.facno=b.facno and f.prono=b.prono and f.trno=b.trno WHERE ( b.itnbr = a.itnbr )   and  b.facno='${facno}' and b.prono='1' ");
        sb.append("  and (b.trdate>='${begin}' AND b.trdate <='${end}') ");
        if (!"".equals(trtype)) {
            sb.append("  and b.trtype = '").append(trtype).append("'");
        }
        if (!"".equals(depno)) {
            sb.append("  and b.depno = '").append(depno).append("'");
        }
        if (!"".equals(userno)) {
            sb.append("  and b.userno = '").append(userno).append("'");
        }
        if (!"".equals(wareh)) {
            sb.append("  and b.wareh = '").append(wareh).append("'");
        }
        sb.append("  order by  b.trtype ASC,b.trdate ASC,b.trno ASC ");
        String sql2 = sb.toString().replace("${begin}", com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", begin)).replace("${end}", com.lightshell.comm.BaseLib.formatDate("yyyy/MM/dd", end))
                .replace("${facno}", facno);
        try {
            setCompany(facno);
            Query query1 = getEntityManager().createNativeQuery(sql1);
            Query query2 = getEntityManager().createNativeQuery(sql2);
            List list1 = query1.getResultList();
            List list2 = query2.getResultList();
            if (list1 != null && !list1.isEmpty()) {
                list2.addAll(list1);
            }
            if (list2 != null && !list2.isEmpty()) {
                String[] arr;
                for (int i = 0; i < list2.size(); i++) {
                    Object[] row = (Object[]) list2.get(i);
                    arr = new String[24];
                    for (int j = 0; j < arr.length; j++) {
                        if (j == 11) {
                            arr[11] = getItclscodeName(row[11] == null ? "" : row[11].toString());
                        } else {
                            arr[j] = row[j] == null ? "" : row[j].toString();
                        }
                    }
                    strings.add(arr);
                }
            }
            return strings;
        } catch (Exception e) {
            return null;
        }
    }

    public String getItclscodeName(String itclscode) {
        String name = "";
        switch (itclscode) {
            case "1":
                name = "成品";
                break;
            case "2":
                name = "半成品类";
                break;
            case "3":
                name = "原料类";
                break;
            case "4":
                name = "物料类";
                break;
            case "5":
                name = "在制品";
                break;
            case "6":
                name = "商品";
                break;
            case "7":
                name = "费用";
                break;
            case "8":
                name = "列管资产";
                break;
            case "A":
                name = "包装物";
                break;
            case "B":
                name = "低质易耗品";
                break;
            default:
                name = "";
        }
        return name;
    }

}
