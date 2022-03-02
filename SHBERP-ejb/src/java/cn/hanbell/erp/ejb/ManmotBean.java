/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Manmot;
import cn.hanbell.oa.ejb.HZPB131Bean;
import cn.hanbell.oa.ejb.HZPB131purDetailBean;
import cn.hanbell.oa.entity.HZPB131;
import cn.hanbell.oa.entity.HZPB131purDetail;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class ManmotBean extends SuperEJBForERP<Manmot> {
    
    @EJB
    private HZPB131Bean hzpb131Bean;
    @EJB
    private HZPB131purDetailBean hzpb131purDetailBean;
    
    public ManmotBean() {
        super(Manmot.class);
    }
    
    public Manmot findByManno(String manno) {
        try {
            Query query = getEntityManager().createNamedQuery("Manmot.findByManno");
            query.setParameter("manno", manno);
            return (Manmot) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public List<Manmot> findByManstatusandAddcodeAndOastatus(String manStatus, String addCode, String oaStatus, Date oaDate, String oaUserno, String manno) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select * from manmot where 1=1");
        if (manStatus != null && !"".equals(manStatus)) {
            sql.append(" and manstatus ='").append(manStatus).append("'");
        }
        if (addCode != null && !"".equals(addCode)) {
            sql.append(" and addcode ='").append(addCode).append("'");
        }
        if (oaStatus != null && !"".equals(oaStatus)) {
            sql.append(" and oastatus ='").append(oaStatus).append("'");
        }
        if (oaUserno != null && !"".equals(oaUserno)) {
            sql.append(" and oauserno ='").append(oaUserno).append("'");
        }
        if (manno != null && !"".equals(manno)) {
            sql.append(" and mrpnr ='").append(manno).append("'");
        }
        if (oaDate != null && !"".equals(oaDate)) {
            sql.append(" and oadate ='").append(BaseLib.formatDate("yyyy-MM-dd HH:mm:ss", oaDate)).append("'");
        } else {
            sql.append(" and oadate =''");
        }
        
        try {
            Query q = getEntityManager().createNativeQuery(sql.toString(), Manmot.class);
            List<Manmot> list = q.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Object[]> findCreateHKFW005OAUsers() {
        String sql = " select oauserno,mrpnr from manmot where manstatus='B' and addcode='A' and oastatus='N' and (oadate is null or oadate='') group by oauserno,mrpnr";
        Query q = getEntityManager().createNativeQuery(sql);
        List<Object[]> list = q.getResultList();
        return list;
    }
    
    public Boolean updateByOAPSN(String psn, String status) {
        HZPB131 head = hzpb131Bean.findByPSN(psn);
        List<HZPB131purDetail> list = hzpb131purDetailBean.findByFSN(head.getFormSerialNumber());
        for (HZPB131purDetail detail : list) {
            Manmot m = findByManno(detail.getManNo());
            //流程结束
            if (m != null && "V".equals(status)) {
                if ("C".equals(detail.getHdnManStatus())) {
                    m.setOastatus("V");
                    m.setManstatus('C');
                } else if ("B".equals(detail.getHdnManStatus())) {
                    m.setOastatus("X");
                    m.setManstatus('B');
                }
                m.setCfmdate(new Date());
                m.setCfmuserno(m.getOauserno());
                m.setMandateo(m.getMandate());
                update(m);
            } else if (m != null && "X".equals(status)) {
                //流程终止或撤销
                m.setOastatus("X");
                m.setManstatus('B');
                m.setCfmdate(new Date());
                m.setCfmuserno(m.getOauserno());
                m.setMandateo(m.getMandate());
                update(m);
            }
        }
        return false;
    }
    
}
