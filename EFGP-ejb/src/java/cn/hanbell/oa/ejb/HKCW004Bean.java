/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW004;
import cn.hanbell.oa.entity.HKCW004Detail;
import cn.hanbell.oa.entity.HZCW027Detail;
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
public class HKCW004Bean extends SuperEJBForEFGP<HKCW004> {

    @EJB
    private HKCW004DetailBean hkcw004DetailBean;

    private List<HKCW004Detail> detailList;

    public HKCW004Bean() {
        super(HKCW004.class);
    }

    @Override
    public void setDetail(Object value) {
        this.detailList = hkcw004DetailBean.findByFSN(value);
    }

    public List<HKCW004Detail> getDetailList() {
        return detailList;
    }
}
