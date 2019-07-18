/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPINV325;
import cn.hanbell.oa.entity.SHBERPINV325Detail;
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
public class SHBERPINV325Bean extends SuperEJBForEFGP<SHBERPINV325> {

    @EJB
    private SHBERPINV325DetailBean shberpinv325DetailBean;

    private List<SHBERPINV325Detail> detailList;

    public SHBERPINV325Bean() {
        super(SHBERPINV325.class);
    }

    @Override
    public void setDetail(Object value) {
        detailList = shberpinv325DetailBean.findByFSN(value);
    }

    /**
     * @return the detailList
     */
    public List<SHBERPINV325Detail> getDetailList() {
        return detailList;
    }

}
