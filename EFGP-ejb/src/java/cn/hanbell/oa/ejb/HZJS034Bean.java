/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZJS034;
import cn.hanbell.oa.entity.HZJS034Detail;
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
public class HZJS034Bean extends SuperEJBForEFGP<HZJS034> {

    @EJB
    private HZJS034DetailBean hzjs034DetailBean;
    private List<HZJS034Detail> detailList;

    public HZJS034Bean() {
        super(HZJS034.class);
    }

    public void setDetail(String fsn) {
        detailList = hzjs034DetailBean.findByFSN(fsn);
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    public List<HZJS034Detail> getDetailList() {
        return detailList;
    }

}
