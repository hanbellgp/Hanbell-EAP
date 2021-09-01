/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class NianjiaBean extends SuperEJBForERP<SuperEJB> {

    public NianjiaBean() {
        super(SuperEJB.class);
    }

    /**
     * 获取员工剩余年休假天数
     *
     * @param employeeid 工号
     * @return
     * @throws java.lang.Exception
     */
    public BigDecimal getLeftYearDays(String employeeid)throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("select leftyeardays from nianjia where employeeid='").append(employeeid).append("'");
        Query query = getEntityManager().createNativeQuery(sql.toString());
        return (BigDecimal) query.getSingleResult();
    }

}
