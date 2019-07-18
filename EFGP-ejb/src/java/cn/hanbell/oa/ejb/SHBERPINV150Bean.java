/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPINV150;
import cn.hanbell.oa.entity.SHBERPINV150Detail;
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
public class SHBERPINV150Bean extends SuperEJBForEFGP<SHBERPINV150>{
    @EJB
    private SHBERPINV150DetailBean shberpinv150DetailBean;
    private List<SHBERPINV150Detail> detailList ;
    
    public SHBERPINV150Bean() {
        super(SHBERPINV150.class);
    }

    public List<SHBERPINV150Detail> getDetailList(String fsn) {
        return shberpinv150DetailBean.findByFSN(fsn);
    }

    public void setDetailList(List<SHBERPINV150Detail> detailList) {
        this.detailList = detailList;
    }
     
    
}
