/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invtrn;
import cn.hanbell.util.BaseLib;
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

    public List<Object[]> getInvtrnhByINV555(String facno, Date queryDateBegin, Date queryDateEnd, String queryno, String querytype, String querywareh, String querydept, String queryuser) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT invtrn.trtype,invdou.typedsc,invtrn.facno,invtrn.prono,invtrn.depno, invtrn.trno,invtrn.trdate,invtrn.trseq, invtrn.itnbr,");
        sql.append(" invmas.itdsc,invcls.itcls,invcls.clsdsc, invtrn.wareh,invwh.whdsc, invtrn.trnqy1,invtrn.unmsr1,invtrn.tramt,invtrn.userno, invtrn.iocode,invdou.reskind,invtrn.rescode");
        sql.append(" FROM invtrn, invmas, invwh, invdou, invcls");
        sql.append(" WHERE (invmas.itnbr = invtrn.itnbr) AND(invtrn.facno = invwh.facno) AND (invtrn.prono = invwh.prono) AND (invtrn.wareh = invwh.wareh) AND");
        sql.append(" (invdou.trtype = invtrn.trtype) AND (invcls.itcls = invmas.itcls) AND ((invdou.syscode = '10') AND (invdou.reskind IS NOT NULL AND");
        sql.append(" ltrim(invdou.reskind) <> '') AND (invdou.iocode IN ('1', '2') OR invdou.iocode = '3' AND invdou.trtype IN (SELECT trntp FROM cstrul WHERE facno = invtrn.facno AND avgco = 'Y')))");
        sql.append(" AND (invtrn.facno = '").append(facno).append("'").append(" AND invtrn.prono = '1' AND (invdou.depdsckind IN (SELECT ckind  FROM misckind)) AND");
        sql.append(" (invtrn.trdate >= '").append(BaseLib.formatDate("yyyy/MM/dd", queryDateBegin)).append("' and");
        sql.append(" invtrn.trdate <='").append(BaseLib.formatDate("yyyy/MM/dd", queryDateEnd)).append("')");

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
        sql.append(")");
        try {
            Query query = getEntityManager().createNativeQuery(sql.toString());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
