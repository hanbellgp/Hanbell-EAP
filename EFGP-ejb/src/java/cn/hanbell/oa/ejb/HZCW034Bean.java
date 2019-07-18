/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW034;
import cn.hanbell.oa.entity.HZCW034Detail;
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
public class HZCW034Bean extends SuperEJBForEFGP<HZCW034> {

    @EJB
    private HZCW034DetailBean hzcw034DetailBean;
    private List<HZCW034Detail> detailList;

    public HZCW034Bean() {
        super(HZCW034.class);
    }

    public void setDetail(String fsn) {
        detailList = hzcw034DetailBean.findByFSN(fsn);
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    public List<HZCW034Detail> getDetailList() {
        return detailList;
    }

    public List<HZCW034Detail> getDetailList(Object value) {
         detailList = hzcw034DetailBean.findByFSN(value);
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
        return detailList;
    }

}
