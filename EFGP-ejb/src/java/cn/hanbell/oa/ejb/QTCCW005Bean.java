/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.QTCCW005;
import cn.hanbell.oa.entity.QTCCW005Detail;
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
public class QTCCW005Bean extends SuperEJBForEFGP<QTCCW005> {

    @EJB
    private QTCCW005DetailBean qtccw005Bean;
    private List<QTCCW005Detail> detailList;

    public QTCCW005Bean() {
        super(QTCCW005.class);
    }

    public List<QTCCW005Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(Object value) {
        this.detailList = qtccw005Bean.findByFSN(value);
    }

}
