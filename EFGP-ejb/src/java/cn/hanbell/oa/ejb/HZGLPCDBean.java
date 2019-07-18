/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZGLPCD;
import cn.hanbell.oa.entity.HZGLPCDDetail;
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
public class HZGLPCDBean extends SuperEJBForEFGP<HZGLPCD> {

    @EJB
    private HZGLPCDDetailBean hzglpcdDetailBean;

    private List<HZGLPCDDetail> detailList;

    public HZGLPCDBean() {
        super(HZGLPCD.class);
    }

    @Override
    public void setDetail(Object value) {
        this.detailList = hzglpcdDetailBean.findByFSN(value);
    }

    /**
     * @return the detailList
     */
    public List<HZGLPCDDetail> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<HZGLPCDDetail> detailList) {
        this.detailList = detailList;
    }

}
