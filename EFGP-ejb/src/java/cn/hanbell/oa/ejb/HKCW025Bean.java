/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW025;
import cn.hanbell.oa.entity.HKCW025Detail;
import cn.hanbell.oa.entity.HKGL038Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2079
 */
@Stateless
@LocalBean
public class HKCW025Bean extends SuperEJBForEFGP<HKCW025> {

    @EJB
    private HKCW025DetailBean hkcw025Detail;

    public HKCW025Bean() {
        super(HKCW025.class);
    }
    private List<HKCW025Detail> detailList;

    @Override
    public void setDetail(Object value) {
        this.detailList = hkcw025Detail.findByFSN(value); //To change body of generated methods, choose Tools | Templates.
    }

    public List<HKCW025Detail> getDetailList(Object value) {
        return hkcw025Detail.findByFSN(value);
    }

    //根据fromid查是否有OA单子
    public List<HKCW025> getOaFormid(String formid) {
        Query query = getEntityManager().createNativeQuery("Select * from HK_CW025 where formid='" + formid + "'");

        List<HKCW025> lenList = query.getResultList();

        return lenList;

    }

    //根据fromid查是否有OA单子
    public String getOaPsn(String psn) {
        Query query = getEntityManager().createNativeQuery("Select max(isERP) from HK_CW025 where processSerialNumber='" + psn + "'");
        String maxid = query.getSingleResult().toString();
        return maxid;
    }

}
