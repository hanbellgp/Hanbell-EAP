/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHTV005;
import cn.hanbell.oa.entity.VHTV005Detail;
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
public class VHTV005Bean extends SuperEJBForEFGP<VHTV005> {

    @EJB
    private VHTV005DetailBean vhtv005DetailBean;

    public VHTV005Bean() {
        super(VHTV005.class);
    }

    public List<VHTV005Detail> getDetailList(String fsn) {
        return vhtv005DetailBean.findByFSN(fsn);
    }
}
