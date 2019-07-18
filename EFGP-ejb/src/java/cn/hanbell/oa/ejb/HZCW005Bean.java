/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW005;
import cn.hanbell.oa.entity.HZCW005Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HZCW005Bean extends SuperEJBForEFGP<HZCW005> {

    @EJB
    private HZCW005DetailBean hzcw005DetailBean ;
    private List<HZCW005Detail> detailList;

    public HZCW005Bean() {
        super(HZCW005.class);
    }

    public List<HZCW005Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(Object value) {
        this.detailList = hzcw005DetailBean.findByFSN(value) ;
    }

}
