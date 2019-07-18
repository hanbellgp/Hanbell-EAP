/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL039;
import cn.hanbell.oa.entity.HKGL039Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class HKGL039Bean extends SuperEJBForEFGP<HKGL039> {

    @EJB
    private HKGL039DetailBean hkglDetailBean;
    private List<HKGL039Detail> detailList;

    public HKGL039Bean() {
        super(HKGL039.class);
    }

    public List<HKGL039Detail> getDetailList(Object value) {
        return hkglDetailBean.findByFSN(value);
    }

    public void setDetailList(Object value) {
        this.detailList = hkglDetailBean.findByFSN(value);
    }

}
