/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW027;
import cn.hanbell.oa.entity.HZCW027Detail;
import cn.hanbell.oa.entity.QTCCW027;
import cn.hanbell.oa.entity.QTCCW027Detail;
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
public class QTCCW027Bean extends SuperEJBForEFGP<QTCCW027> {
     @EJB
    private QTCCW027DetailBean qtccw027DetailBean;

    private List<QTCCW027Detail> detailList;

    public QTCCW027Bean() {
        super(QTCCW027.class);
    }

  

    @Override
    public void setDetail(Object value) {
        this.detailList = qtccw027DetailBean.findByFSN(value);
    }

    /**
     * @return the detailList
     */
    public List<QTCCW027Detail> getDetailList() {
        return detailList;
    }

}
