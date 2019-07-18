/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efnet.ejb;

import cn.hanbell.efnet.comm.SuperEJBForEFNET;
import cn.hanbell.efnet.entity.HZFWD;
import cn.hanbell.efnet.entity.HZFWDD05;
import cn.hanbell.oa.ejb.HZCW028tDetailBean;
import cn.hanbell.oa.entity.HZCW028tDetail;
import cn.hanbell.util.BaseLib;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class HZFWDD05Bean extends SuperEJBForEFNET<HZFWDD05> {

    @EJB
    private HZCW028tDetailBean hzcw028tDetailBean;

    @EJB
    private HZFWDBean hzfwdBean;

    public HZFWDD05Bean() {
        super(HZFWDD05.class);
    }

    public HZFWDD05 findByPK(String id, String seq) {
        Query query = this.getEntityManager().createNamedQuery("HZFWDD05.findByPK");
        query.setParameter("id", id);
        query.setParameter("seq", seq);
        try {
            Object o = query.getSingleResult();
            return (HZFWDD05) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean initByEFGPFormSerialNumber(String fsn) {
        List<HZCW028tDetail> traffics = hzcw028tDetailBean.findByFSN(fsn);
        if (traffics != null && !traffics.isEmpty()) {
            HZFWD entity = null;
            HZFWDD05 d = null;
            String serviceid = "";
            Double amts = 0.00;
            try {
                for (HZCW028tDetail t : traffics) {
                    if (Objects.equals(t.getIsFree(), "Y") && t.getServiceno2() != null && !"".equals(t.getServiceno2())) {
                        if (!Objects.equals(t.getServiceno2(), serviceid)) {
                            //遇到不同服务单就把先前的资料更新
                            if (entity != null) {
                                entity.setPaydate(BaseLib.getDate());
                                entity.setHzfwd007(amts.toString());
                                hzfwdBean.update(entity);
                                hzfwdBean.getEntityManager().flush();
                            }
                            serviceid = t.getServiceno2();
                            entity = hzfwdBean.findById(serviceid);
                            amts = 0.00;
                        }
                        if (entity != null) {
                            d = this.findByPK(entity.getHZFWDPK().getHzfwd002(), formatString(t.getNo(), "0000"));
                            if (d == null) {
                                d = new HZFWDD05(entity.getHZFWDPK().getHzfwd001(), entity.getHZFWDPK().getHzfwd002(), formatString(t.getNo(), "0000"));
                            }
                            d.setCompany(entity.getCompany());
                            d.setCreator(entity.getCreator());
                            d.setUsrGroup(entity.getUsrGroup());
                            d.setCreateDate(entity.getCreateDate());
                            d.setModifier(entity.getModifier());
                            d.setModiDate(entity.getModiDate());
                            d.setFlag(entity.getFlag());
                            d.setHzfwdD05004("6617");//差旅明细中没有科目只好固定
                            d.setHzfwdD05005("差旅费");
                            if (t.getTrafficSummary() != null && t.getTrafficSummary().length() > 20) {
                                //因EFNET中栏位长度限制
                                d.setHzfwdD05006(t.getTrafficSummary().substring(0, 20));
                            } else {
                                d.setHzfwdD05006(t.getTrafficSummary());
                            }
                            d.setHzfwdD05007(entity.getSelect1());
                            d.setHzfwdD05008(t.getSubtotal());
                            d.setHzfwdD05009("0");
                            d.setHzfwdD05010(t.getSubtotal());
                            this.persist(d);
                            //累计金额，后续更新到服务单上
                            amts += Double.parseDouble(t.getSubtotal());
                        }
                    }
                }
                //循环结束后更新最后一个服务单的累计金额
                if (entity != null) {
                    entity.setPaydate(BaseLib.getDate());
                    entity.setHzfwd007(amts.toString());
                    hzfwdBean.update(entity);
                    hzfwdBean.getEntityManager().flush();
                }
            } catch (Exception ex) {
                Logger.getLogger(HZFWDD05Bean.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

    public boolean deleteByEFGPFormSerialNumber(String fsn) {
        List<HZCW028tDetail> traffics = hzcw028tDetailBean.findByFSN(fsn);
        if (traffics != null && !traffics.isEmpty()) {
            HZFWD entity = null;
            List<HZFWDD05> details = null;
            String serviceid = "";
            try {
                for (HZCW028tDetail t : traffics) {
                    if (Objects.equals(t.getIsFree(), "Y") && t.getServiceno2() != null && !"".equals(t.getServiceno2())) {
                        if (!Objects.equals(t.getServiceno2(), serviceid)) {
                            serviceid = t.getServiceno2();
                            entity = hzfwdBean.findById(serviceid);
                            if (entity != null) {
                                details = this.findByPId(entity.getHZFWDPK().getHzfwd002());
                                if (details != null && !details.isEmpty()) {
                                    entity.setHzfwd007("0");
                                    hzfwdBean.update(entity);
                                    this.delete(details);
                                }
                            }
                        }
                    }
                }
                return true;
            } catch (Exception ex) {
                Logger.getLogger(HZFWDD05Bean.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

    private String formatString(String value, String format) {
        if (value.length() >= format.length()) {
            return value;
        }
        return format.substring(0, format.length() - value.length()) + value;
    }

}
