/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.entity.REPTC;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKFW013;
import cn.hanbell.oa.entity.HKFW013Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
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
public class HKFW013Bean extends SuperEJBForEFGP<HKFW013> {

    @EJB
    private HKFW013DetailBean hkfw013DetailBean;


    private List<HKFW013Detail> detailList;

    public HKFW013Bean() {
        super(HKFW013.class);
    }
    @Override
    public void setDetail(Object value) {
        this.detailList = hkfw013DetailBean.findByFSN(value); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the detailList
     */
    public List<HKFW013Detail> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<HKFW013Detail> detailList) {
        this.detailList = detailList;
    }

    public List<HKFW013Detail> getDetailList(String fsn) {
        return hkfw013DetailBean.findByFSN(fsn);
    }

    public List<HKFW013> findByHKCW013QueryPage(Date createDateBegin, Date createDateEnd, String fsn,String psn,String cusno,String cusna,String userid) {
        try {
            StringBuffer sql = new StringBuffer("select a.* from HK_FW013 a,ProcessInstance  b,WorkItem c,WorkAssignment d ,Users e");
            sql.append(" where a.processSerialNumber=b.serialNumber and c.contextOID=b.contextOID and c.OID=d.workItemOID and d.assigneeOID=e.OID");
            sql.append(" and b.currentState='1' and c.currentState in ('1','0') and e.id='").append(userid).append("'");
            if (createDateBegin != null) {
                sql.append(" and c.createdTime>='").append(BaseLib.formatDate("yyyy-MM-dd", createDateBegin)).append("'");
            }
            if (createDateEnd != null) {
                sql.append(" and c.createdTime<='").append(BaseLib.formatDate("yyyy-MM-dd", createDateEnd)).append("'");
            }

            if (fsn != null && !"".equals(fsn)) {
                sql.append(" and a.formSerialNumber like N'%").append(fsn).append("%'");
            }
            if (psn != null && !"".equals(psn)) {
                sql.append(" and a.processSerialNumber like N'%").append(psn).append("%'");
            }
            if (cusno != null && !"".equals(cusno)) {
                sql.append(" and a.cusno like N'%").append(cusno).append("%'");
            }
            if (cusna != null && !"".equals(cusna)) {
                sql.append(" and a.cusds like N'%").append(cusna).append("%'");
            }
            sql.append(" order by a.processSerialNumber asc");
            Query query = getEntityManager().createNativeQuery(sql.toString(), HKFW013.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
