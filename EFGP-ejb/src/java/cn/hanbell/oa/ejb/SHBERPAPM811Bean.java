/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPAPM811;
import cn.hanbell.oa.entity.SHBERPAPM811Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SHBERPAPM811Bean extends SuperEJBForEFGP<SHBERPAPM811> {

    @EJB
    private SHBERPAPM811DetailBean shberpapm811DetailBean;
    private List<SHBERPAPM811Detail> detailList;

    public SHBERPAPM811Bean() {
        super(SHBERPAPM811.class);
    }

    public List<SHBERPAPM811Detail> getDetailList(String fsn) {
        detailList = shberpapm811DetailBean.findByFSN(fsn);
        return detailList;
    }

    public void setDetailList(List<SHBERPAPM811Detail> detailList) {
        this.detailList = detailList;
    }

}
