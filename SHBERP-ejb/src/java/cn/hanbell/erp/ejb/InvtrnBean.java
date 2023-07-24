/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invtrn;
import cn.hanbell.util.BaseLib;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class InvtrnBean extends SuperEJBForERP<Invtrn> {

    public InvtrnBean() {
        super(Invtrn.class);
    }

    public List<Object[]> getInvtrnhByINV555(String facno, Date queryDate, String syscode, String queryno, String querytype, String querywareh, String querydept, String queryuser) {
        StringBuffer sql = new StringBuffer();
        Calendar c = Calendar.getInstance();
        c.setTime(queryDate);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date begindate = c.getTime();
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date enddate = c.getTime();
        sql.append(" select  invtrn.trdate as '交易时间',invtrn.trtype as '单据别' ,invdou.typedsc as '单据名称',invtrn.facno as '公司别',invtrn.prono as '生产地',invtrn.depno as '对像别' ,");
        sql.append(" case invdou.depdsckind when 'GE' then (select depname from misdept where depno= invtrn.depno)");
        sql.append("    when 'PJ' then (select vdrna from  purvdr where vdrno=invtrn.depno)");
        sql.append("    when 'CA' then (select cusna from  cdrcus where cusno=invtrn.depno)end '对象名称',");
        sql.append(" invtrn.trno as'交易单号',invtrn.trseq as'序号', invtrn.itnbr as '品号', invmas.itdsc as '名称',invcls.itcls as '大类',invcls.clsdsc as '大类名称',");
        sql.append(" case invcls.itclscode when  '1' then  '成品类' when  '2' then  '半成品类' when  '3' then  '原料类' when  '4' then  '物料类'");
        sql.append("    when  '5' then  '在制品类' when  '6' then  '商品'");
        sql.append("    when  '7' then  '费用' when  '8' then  '列管资产' when  'A' then  '包装物' when  'B' then  '低质易耗品' end as '归类',");
        sql.append(" invtrn.wareh as '仓库',invwh.whdsc as'仓库名称',invtrn.trnqy1 as'数量', invtrn.unmsr1 as '单位',invtrn.tramt as '金额',invtrn.userno as '录入人员',");
        sql.append(" case invtrn.iocode when '0' then '期初' when '1' then '入库' when '2' then '出库'");
        sql.append(" when '3' then '调拨' when 'Z' then '期末' end  as '出入库',");
        sql.append(" (select mark1+';;'+mark2+';;'+mark3+';;'+mark4 from invhdsc  where facno='").append(facno).append("' and prono='1' and trno=invtrn.trno ) as '备注' ,");
        sql.append(" invdou.reskind '原因别',");
        sql.append(" (select cdesc from miscode where ckind=invdou.reskind  and code=invtrn.rescode)as '原因内容',");
        sql.append(" invtrn.hmark1 '申报项目编号'  ,");
        sql.append(" case invtrn.trtype when 'IAA' then (select cdesc from miscode where ckind='91' and code=invtrn.hmark1 ) when 'IAB' then (select cdesc from miscode where ckind='91' and code=invtrn.hmark1)  else ''end '申报项目',");
        sql.append(" case invtrn.trtype when 'ARY' then (  select depname from cdrhadasry left join misdept on cdrhadasry.shpdepno=misdept.depno where cdrhadasry.facno=invtrn.facno and cdrhadasry.prono=invtrn.prono and cdrhadasry.facno='").append(facno).append("'and cdrhadasry.prono='1'  and cdrhadasry.trno=invtrn.trno  ) end 'ARY打单部门',");
        sql.append(" invtrn.hmark1,invtrn.hmark2,");
        sql.append("  (select kfno from invhadh where facno= '").append(facno).append("' and prono='1' and invhadh.trno=invtrn.trno )as '来源单号'");
        sql.append(" FROM  invdou,invwh,invtrn, invmas,   invcls");
        sql.append(" WHERE (invtrn.facno = invwh.facno) AND (invtrn.prono = invwh.prono) and (invmas.itnbr = invtrn.itnbr)  AND (invtrn.wareh = invwh.wareh) AND (invdou.trtype = invtrn.trtype) AND (invcls.itcls = invmas.itcls)");
        sql.append(" AND (invtrn.facno = '").append(facno).append("' AND invtrn.prono = '1'");
        sql.append(" AND trdate>='").append(BaseLib.formatDate("YYYY-MM-dd", begindate)).append("'");
        sql.append(" AND trdate<='").append(BaseLib.formatDate("YYYY-MM-dd", enddate)).append("')");
        if (!"".equals(syscode) && syscode != null) {
            sql.append(" AND invdou.syscode = '").append(syscode).append("'");
        }
        if (!"".equals(queryno) && queryno != null) {
            sql.append(" and invtrn.trno in (").append(queryno).append(")");
        }
        if (!"".equals(querytype) && querytype != null) {
            sql.append(" and invtrn.trtype in (").append(querytype).append(")");
        }
        if (!"".equals(querywareh) && querywareh != null) {
            sql.append(" and invtrn.wareh in (").append(querywareh).append(")");
        }
        if (!"".equals(querydept) && querydept != null) {
            sql.append(" and invtrn.depno in (").append(querydept).append(")");
        }
        if (!"".equals(queryuser) && queryuser != null) {
            sql.append(" and invtrn.userno in (").append(queryuser).append(")");
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
}
