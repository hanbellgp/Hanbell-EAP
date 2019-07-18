/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPINV140;
import cn.hanbell.oa.entity.SHBERPINV140Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SHBINV140Bean extends SuperEJBForEFGP<SHBERPINV140> {

    @EJB
    private SHBINV140DetailBean shbinv140DetailBean;
    private List<SHBERPINV140Detail> detailList;

    public SHBINV140Bean() {
        super(SHBERPINV140.class);
    }

    public List<SHBERPINV140Detail> getDetailList(String fsn) {
        return shbinv140DetailBean.findByFSN(fsn);
    }

    public void setDetailList(List<SHBERPINV140Detail> detailList) {
        this.detailList = detailList;
    }

}
