
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW005;
import cn.hanbell.oa.entity.HKCW005Detail;
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
public class HKCW005Bean extends SuperEJBForEFGP<HKCW005> {

    @EJB
    private HKCW005DetailBean hkcwDetailBean;

    private List<HKCW005Detail> detailList;

    public HKCW005Bean() {
        super(HKCW005.class);
    }

    @Override
    public void setDetail(Object value) {
        this.detailList = hkcwDetailBean.findByFSN(value);
    }

    /**
     * @return the detailList
     */
    public List<HKCW005Detail> getDetailList() {
        return detailList;
    }
}