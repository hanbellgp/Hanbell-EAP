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
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.Calendar;
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

    public List<Object[]> getInvtrnhByINV555(String facno, Date queryDate, String syscode, String queryno, String querytype, String querywareh, String querydept, String queryuser) {
        StringBuffer sql = new StringBuffer();
        Calendar c = Calendar.getInstance();
        c.setTime(queryDate);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date begindate = c.getTime();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date enddate = c.getTime();
        sql.append(" select  invtrnh.trdate as '交易时间',invtrnh.trtype as '单据别' ,invdou.typedsc as '单据名称',invtrnh.facno as '公司别',invtrnh.prono as '生产地',invtrnh.depno as '对像别' ,");
        sql.append(" case invdou.depdsckind when 'GE' then (select depname from misdept where depno= invtrnh.depno)");
        sql.append("    when 'PJ' then (select vdrna from  purvdr where vdrno=invtrnh.depno)");
        sql.append("    when 'CA' then (select cusna from  cdrcus where cusno=invtrnh.depno)end '对象名称',");
        sql.append(" invtrnh.trno as'交易单号',invtrnh.trseq as'序号', invtrnh.itnbr as '品号', invmas.itdsc as '名称',invcls.itcls as '大类',invcls.clsdsc as '大类名称',");
        sql.append(" case invcls.itclscode when  '1' then  '成品类' when  '2' then  '半成品类' when  '3' then  '原料类' when  '4' then  '物料类'");
        sql.append("    when  '5' then  '在制品类' when  '6' then  '商品'");
        sql.append("    when  '7' then  '费用' when  '8' then  '列管资产' when  'A' then  '包装物' when  'B' then  '低质易耗品' end as '归类',");
        sql.append(" invtrnh.wareh as '仓库',invwh.whdsc as'仓库名称',invtrnh.trnqy1 as'数量', invtrnh.unmsr1 as '单位',invtrnh.tramt as '金额',invtrnh.userno as '录入人员',");
        sql.append(" case invtrnh.iocode when '0' then '期初' when '1' then '入库' when '2' then '出库'");
        sql.append(" when '3' then '调拨' when 'Z' then '期末' end  as '出入库',");
        sql.append(" (select mark1+';;'+mark2+';;'+mark3+';;'+mark4 from invhdsc  where facno='").append(facno).append("' and prono='1' and trno=invtrnh.trno ) as '备注' ,");
        sql.append(" invdou.reskind '原因别',");
        sql.append(" (select cdesc from miscode where ckind=invdou.reskind  and code=invtrnh.rescode)as '原因内容',");
        sql.append(" invtrnh.hmark1 '申报项目编号'  ,");
        sql.append(" case invtrnh.trtype when 'IAA' then (select cdesc from miscode where ckind='91' and code=invtrnh.hmark1 ) when 'IAB' then (select cdesc from miscode where ckind='91' and code=invtrnh.hmark1)  else ''end '申报项目',");
        sql.append(" case invtrnh.trtype when 'ARY' then (  select depname from cdrhadasry left join misdept on cdrhadasry.shpdepno=misdept.depno where cdrhadasry.facno=invtrnh.facno and cdrhadasry.prono=invtrnh.prono and cdrhadasry.facno='").append(facno).append("'and cdrhadasry.prono='1'  and cdrhadasry.trno=invtrnh.trno  ) end 'ARY打单部门',");
        sql.append(" invtrnh.hmark1,invtrnh.hmark2,");
        sql.append("  (select kfno from invhadh where facno= '").append(facno).append("' and prono='1' and invhadh.trno=invtrnh.trno )as '来源单号'");
        sql.append(" ,case  when invtrnh.trtype='IAF' or invtrnh.trtype='IAG' then (select cdesc from cdrcus,miscode where cdrcus.SCCode=miscode.code and ckind='3C' and cdrcus.cusno=invtrnh.depno) end as '客户性质',");
        sql.append(" case  when invtrnh.trtype='IAF' or invtrnh.trtype='IAG' then (select miscode.cusds from cdrcus,miscode where cdrcus.SCCode=miscode.code and ckind='3C' and cdrcus.cusno=invtrnh.depno) end as '客户归类'");
        sql.append(" FROM  invdou,invwh,invtrnh, invmas,   invcls");
        sql.append(" WHERE (invtrnh.facno = invwh.facno) AND (invtrnh.prono = invwh.prono) and (invmas.itnbr = invtrnh.itnbr)  AND (invtrnh.wareh = invwh.wareh) AND (invdou.trtype = invtrnh.trtype) AND (invcls.itcls = invmas.itcls)");
        sql.append(" AND (invtrnh.facno = '").append(facno).append("' AND invtrnh.prono = '1'");
        sql.append(" AND trdate>='").append(BaseLib.formatDate("YYYY-MM-dd", begindate)).append("'");
        sql.append(" AND trdate<='").append(BaseLib.formatDate("YYYY-MM-dd", enddate)).append("')");
        if (!"".equals(syscode) && syscode != null) {
            sql.append(" AND invdou.syscode = '").append(syscode).append("'");
        }
        if (!"".equals(queryno) && queryno != null) {
            sql.append(" and invtrnh.trno in (").append(queryno).append(")");
        }
        if (!"".equals(querytype) && querytype != null) {
            sql.append(" and invtrnh.trtype in (").append(querytype).append(")");
        }
        if (!"".equals(querywareh) && querywareh != null) {
            sql.append(" and invtrnh.wareh in (").append(querywareh).append(")");
        }
        if (!"".equals(querydept) && querydept != null) {
            sql.append(" and invtrnh.depno in (").append(querydept).append(")");
        }
        if (!"".equals(queryuser) && queryuser != null) {
            sql.append(" and invtrnh.userno in (").append(queryuser).append(")");
        }
        if ("10".equals(syscode)) {
            sql.append("AND (invdou.reskind IS NOT NULL AND ltrim(invdou.reskind) <> '')");
        }
        sql.append("AND (invdou.iocode IN ('1', '2') OR invdou.iocode = '3' AND invdou.trtype IN (SELECT trntp FROM cstrul WHERE facno = '").append(facno).append("' AND avgco = 'Y')) AND (invdou.depdsckind IN (SELECT ckind  FROM misckind))");

        try {
            Query query = getEntityManager().createNativeQuery(sql.toString());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCompanyName(String name) {
        WorkFlowBean WorkFlowBean = new WorkFlowBean();
        return WorkFlowBean.getCompanyName(name);
    }

}
