/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZGL004;
import cn.hanbell.oa.entity.HZGL004carDetail;
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
public class HZGL004Bean extends SuperEJBForEFGP<HZGL004> {

    @EJB
    private HZGL004carDetailBean carDetailBean;

    public HZGL004Bean() {
        super(HZGL004.class);
    }

    public List<HZGL004carDetail> getCarDetail(String value) {
        return carDetailBean.findByFSN(value);
    }
}
