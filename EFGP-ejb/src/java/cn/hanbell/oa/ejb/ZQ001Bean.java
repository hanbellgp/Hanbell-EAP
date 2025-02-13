/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW004;
import cn.hanbell.oa.entity.HKCW004Detail;
import cn.hanbell.oa.entity.ZQ001;
import cn.hanbell.oa.entity.ZQ001Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class ZQ001Bean  extends SuperEJBForEFGP<ZQ001>{
    
    @EJB
    private ZQ001DetailBean zq001DetailBean;
    List<ZQ001Detail> detailList;
    public ZQ001Bean() {
        super(ZQ001.class);
    }
    
    @Override
    public void setDetail(Object value) {
        this.detailList = zq001DetailBean.findByFSN(value);
    }

    public List<ZQ001Detail> getDetailList() {
        return detailList;
    }
    
}
