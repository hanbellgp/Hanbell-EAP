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

    public List<Object[]> getInvtrnhByINV555(String facno, Date queryDate, String queryno, String querytype, String querywareh, String querydept, String queryuser) {
        StringBuffer sql = new StringBuffer();
        Calendar c = Calendar.getInstance();
        c.setTime(queryDate);
         sql.append(" SELECT  invtrn.trdate as '交易时间',invtrn.trtype as '单据别' ,invdou.typedsc as '单据名称',invtrn.facno as '公司别',invtrn.prono as '生产地',invtrn.depno as '对像别'");
        sql.append(" ,case invdou.depdsckind when 'GE' then (select depname from misdept where depno= invtrn.depno)");
        sql.append(" when 'PJ' then (select vdrna from  purvdr where vdrno=invtrn.depno)");
        sql.append(" when 'CS' then (select cusna from  cdrcus where cusno=invtrn.depno)end '对象名称',");
        sql.append("  invtrn.trno as'交易单号',invtrn.trseq as'序号', invtrn.itnbr as '品号',");
        sql.append(" invmas.itdsc as '名称',invcls.itcls as '大类',invcls.clsdsc as '大类名称',");
        sql.append(" case invcls.itclscode when  '1' then  '成品类'");
        sql.append(" when  '2' then  '半成品类'");
        sql.append(" when  '3' then  '原料类'");
        sql.append(" when  '4' then  '物料类'");
        sql.append(" when  '5' then  '在制品类'");
        sql.append(" when  '6' then  '商品'");
        sql.append(" when  '7' then  '费用'");
        sql.append(" when  '8' then  '列管资产'");
        sql.append(" when  'A' then  '包装物'");
        sql.append(" when  'B' then  '低质易耗品' end as '归类',");
        sql.append(" invtrn.wareh as '仓库',invwh.whdsc as'仓库名称', invtrn.trnqy1 as'数量',");
        sql.append(" invtrn.unmsr1 as '单位',invtrn.tramt as '金额',invtrn.userno as '录入人员',");
        sql.append(" case invtrn.iocode when '0' then '期初'");
        sql.append(" when '1' then '入库'");
        sql.append(" when '2' then '出库'");
        sql.append(" when '3' then '调拨'");
        sql.append(" when 'Z' then '期末' end  as '出入库',");
        sql.append(" (select mark1+';;'+mark2+';;'+mark3+';;'+mark4");
        sql.append(" from invhdsc  where facno='C' and prono='1' and trno=invtrn.trno ) as '备注' ,invdou.reskind '原因别',");
        sql.append(" (select cdesc from miscode where ckind=invdou.reskind  and code=invtrn.rescode)as '原因内容',invtrn.hmark1 '申报项目编号'");
        sql.append("  ,case invtrn.trtype when 'IAA' then (select cdesc from miscode where ckind='91' and code=invtrn.hmark1 )");
        sql.append(" when 'IAB' then (select cdesc from miscode where ckind='91' and code=invtrn.hmark1)");
        sql.append("  else ''end '申报项目',");
        sql.append(" case invtrn.trtype when 'ARY' then (");
        sql.append("  select depname from cdrhadasry");
        sql.append(" left join misdept on cdrhadasry.shpdepno=misdept.depno");
        sql.append(" where cdrhadasry.facno=invtrn.facno and cdrhadasry.prono=invtrn.prono and cdrhadasry.trno=invtrn.trno");
        sql.append("  ) end 'ARY打单部门'");
        sql.append(" FROM invtrn, invmas, invwh, invdou, invcls");
        sql.append(" WHERE (invmas.itnbr = invtrn.itnbr) AND(invtrn.facno = invwh.facno) AND (invtrn.prono = invwh.prono) AND (invtrn.wareh = invwh.wareh) AND");
        sql.append(" (invdou.trtype = invtrn.trtype) AND (invcls.itcls = invmas.itcls) AND ((invdou.syscode = '10') AND (invdou.reskind IS NOT NULL AND");
        sql.append(" ltrim(invdou.reskind) <> '') AND (invdou.iocode IN ('1', '2') OR invdou.iocode = '3' AND invdou.trtype IN (SELECT trntp FROM cstrul WHERE facno = invtrn.facno AND avgco = 'Y')))");
        sql.append(" AND (invtrn.facno = '").append(facno).append("'").append(" AND invtrn.prono = '1' AND (invdou.depdsckind IN (SELECT ckind  FROM misckind)) AND");
        sql.append(" year(invtrn.trdate )=" + c.get(Calendar.YEAR));
        sql.append(" and month(invtrn.trdate )=" + (c.get(Calendar.MONTH) + 1));
        sql.append(")");
        
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
       
        try {
            Query query = getEntityManager().createNativeQuery(sql.toString());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
