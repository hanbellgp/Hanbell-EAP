/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW027;
import cn.hanbell.oa.entity.HZCW027Detail;
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
public class HZCW027Bean extends SuperEJBForEFGP<HZCW027> {

    @EJB
    private HZCW027DetailBean hzcw027DetailBean;

    private List<HZCW027Detail> detailList;

    public HZCW027Bean() {
        super(HZCW027.class);
    }

    @Override
    public void setDetail(Object value) {
        this.detailList = hzcw027DetailBean.findByFSN(value);
    }

    /**
     * @return the detailList
     */
    public List<HZCW027Detail> getDetailList() {
        return detailList;
    }

}
