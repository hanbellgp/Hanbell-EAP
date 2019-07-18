/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGC001;
import cn.hanbell.oa.entity.HKGC001Detail;
import java.util.ArrayList;
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
public class HKGC001Bean extends SuperEJBForEFGP<HKGC001> {

    @EJB
    private HKGC001DetailBean hkgc001DetailBean;

    private List<HKGC001Detail> detailList;

    public HKGC001Bean() {
        super(HKGC001.class);
    }

    /**
     * @return the detailList
     */
    public List<HKGC001Detail> getDetailList() {
        return detailList;
    }

    @Override
    public void setDetail(Object value) {
        detailList = hkgc001DetailBean.findByFSN(value.toString());
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    public void setDetail(String fsn, String purflag) {
        detailList = hkgc001DetailBean.findByFSNAndPurchase(fsn, purflag);
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

}
