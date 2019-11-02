/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.PricingGroup;
import cn.hanbell.erp.entity.PricingUser;
import cn.hanbell.erp.entity.PricingUserPK;
import cn.hanbell.oa.ejb.SHBERPCDR1P3Bean;
import cn.hanbell.oa.entity.SHBERPCDR1P3;
import cn.hanbell.oa.entity.SHBERPCDR1P3Detail;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class PricingGroupBean extends SuperEJBForERP<PricingGroup> {

    @EJB
    private SHBERPCDR1P3Bean shberpcdr1p3Bean;
    @EJB
    private PricingUserBean pricingUserBean;

    public PricingGroupBean() {
        super(PricingGroup.class);
    }

    public List<PricingGroup> findByUserno(String userno) {
        StringBuilder sb = new StringBuilder();
        //不包含集团内部交易价格
        sb.append("SELECT pricinggroup.groupid,pricinggroup.groupname,price09,price08,price07,price06,price05,price04,price03,price02,price01,pricinggroup.pricingtype FROM pricinggroup,pricinguser ");
        sb.append(" WHERE pricinggroup.groupid = pricinguser.groupid AND pricinggroup.pricingtype = pricinguser.pricingtype AND pricinggroup.pricingtype<>'00' ");
        sb.append(" AND pricinguser.userid = '");
        sb.append(userno);
        sb.append("'");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        List result = query.getResultList();
        List<PricingGroup> dataList = new ArrayList<>();
        PricingGroup newEntity;
        if (result != null && !result.isEmpty()) {
            String groupid = "", groupname = "", pricingtype = "";
            boolean price09 = false, price08 = false, price07 = false, price06 = false, price05 = false, price04 = false, price03 = false, price02 = false, price01 = false;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                groupid = row[0].toString();
                groupname = row[1].toString();
                price01 = Boolean.parseBoolean(row[10].toString());
                price02 = price01 || Boolean.parseBoolean(row[9].toString());
                price03 = price02 || Boolean.parseBoolean(row[8].toString());
                price04 = price03 || Boolean.parseBoolean(row[7].toString());
                price05 = price04 || Boolean.parseBoolean(row[6].toString());
                price06 = price05 || Boolean.parseBoolean(row[5].toString());
                price07 = price06 || Boolean.parseBoolean(row[4].toString());
                price08 = price07 || Boolean.parseBoolean(row[3].toString());
                price09 = price08 || Boolean.parseBoolean(row[2].toString());
                pricingtype = row[11].toString();
                newEntity = new PricingGroup(groupid, groupname, price09, price08, price07, price06, price05, price04, price03, price02, price01, pricingtype);
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

    public PricingGroup findByUsernoAndGroupId(String userno, String id) {
        StringBuilder sb = new StringBuilder();
        //不包含集团内部交易价格
        sb.append("SELECT pricinggroup.groupid,pricinggroup.groupname,price09,price08,price07,price06,price05,price04,price03,price02,price01,pricinggroup.pricingtype FROM pricinggroup,pricinguser ");
        sb.append(" WHERE pricinggroup.groupid = pricinguser.groupid AND pricinggroup.pricingtype = pricinguser.pricingtype AND pricinggroup.pricingtype<>'00' ");
        sb.append(" AND pricinguser.userid = '");
        sb.append(userno);
        sb.append("' ");
        sb.append(" AND pricinggroup.groupid='");
        sb.append(id);
        sb.append("' ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        Object[] row = (Object[]) query.getSingleResult();
        PricingGroup newEntity;
        if (row != null) {
            String groupid = "", groupname = "", pricingtype = "";
            boolean price09 = false, price08 = false, price07 = false, price06 = false, price05 = false, price04 = false, price03 = false, price02 = false, price01 = false;

            groupid = row[0].toString();
            groupname = row[1].toString();
            price01 = Boolean.parseBoolean(row[10].toString());
            price02 = price01 || Boolean.parseBoolean(row[9].toString());
            price03 = price02 || Boolean.parseBoolean(row[8].toString());
            price04 = price03 || Boolean.parseBoolean(row[7].toString());
            price05 = price04 || Boolean.parseBoolean(row[6].toString());
            price06 = price05 || Boolean.parseBoolean(row[5].toString());
            price07 = price06 || Boolean.parseBoolean(row[4].toString());
            price08 = price07 || Boolean.parseBoolean(row[3].toString());
            price09 = price08 || Boolean.parseBoolean(row[2].toString());
            pricingtype = row[11].toString();
            newEntity = new PricingGroup(groupid, groupname, price09, price08, price07, price06, price05, price04, price03, price02, price01, pricingtype);
            return newEntity;
        }
        return null;
    }
    
     public PricingGroup findByGroupId(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT pricinggroup.groupid,pricinggroup.groupname,price09,price08,price07,price06,price05,price04,price03,price02,price01,pricinggroup.pricingtype FROM pricinggroup ");
        sb.append(" WHERE pricinggroup.groupid = '");
        sb.append(id);
        sb.append("' ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        Object[] row = (Object[]) query.getSingleResult();
        PricingGroup newEntity;
        if (row != null) {
            String groupid = "", groupname = "", pricingtype = "";
            boolean price09 = false, price08 = false, price07 = false, price06 = false, price05 = false, price04 = false, price03 = false, price02 = false, price01 = false;
            groupid = row[0].toString();
            groupname = row[1].toString();
            price01 = Boolean.parseBoolean(row[10].toString());
            price02 = price01 || Boolean.parseBoolean(row[9].toString());
            price03 = price02 || Boolean.parseBoolean(row[8].toString());
            price04 = price03 || Boolean.parseBoolean(row[7].toString());
            price05 = price04 || Boolean.parseBoolean(row[6].toString());
            price06 = price05 || Boolean.parseBoolean(row[5].toString());
            price07 = price06 || Boolean.parseBoolean(row[4].toString());
            price08 = price07 || Boolean.parseBoolean(row[3].toString());
            price09 = price08 || Boolean.parseBoolean(row[2].toString());
            pricingtype = row[11].toString();
            newEntity = new PricingGroup(groupid, groupname, price09, price08, price07, price06, price05, price04, price03, price02, price01, pricingtype);
            return newEntity;
        }
        return null;
    }

    public Boolean updateByOASHBERPCDR1P3(String psn) {
        String facno;
        List<PricingUser> pricingUsers = new ArrayList<>();
        try {
            SHBERPCDR1P3 p = shberpcdr1p3Bean.findByPSN(psn);
            if (p == null) {
                return false;
            }
            List<SHBERPCDR1P3Detail> details = shberpcdr1p3Bean.getDetails(p.getFormSerialNumber());
            facno = p.getFacno();

            //表身明细
            for (SHBERPCDR1P3Detail d : details) {
                if (null == d.getCuslevel2() || "".equals(d.getCuslevel2())) {
                    continue;
                }
                PricingGroup pg = this.findByGroupId(d.getCuslevel2());
                if(pg == null){
                     continue;
                }
                if (null != d.getCuslevel1() || !"".equals(d.getCuslevel1())) {
                    pricingUserBean.setCompany(facno);
                    PricingUser pricingUser = pricingUserBean.findByGroupidAndUserid(d.getCuslevel1(),d.getCusno());
                    if (pricingUser != null) {
                        pricingUserBean.delete(pricingUser);
                    }
                }

                PricingUser pu = new PricingUser();
                PricingUserPK pupk = new PricingUserPK();
                pupk.setGroupid(d.getCuslevel2());
                pupk.setPricingtype(pg.getPricingGroupPK().getPricingtype());
                pupk.setUserid(d.getCusno());
                pu.setPricingUserPK(pupk);
                pu.setFacno(facno);
                pricingUsers.add(pu);

            }
            pricingUsers.forEach((pu) -> {
                pricingUserBean.persist(pu);
            });

            return true;
        } catch (Exception ex) {
            Logger.getLogger(PricingUserBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

}
