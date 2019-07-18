/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL060;
import cn.hanbell.oa.entity.HKGL060Detail;
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
public class HKGL060Bean extends SuperEJBForEFGP<HKGL060> {

    @EJB
    private HKGL060DetailBean hkgl060DetailBean;

    private List<HKGL060Detail> detailList;

    public HKGL060Bean() {
        super(HKGL060.class);
    }

    public void setDetail(String fsn) {
        detailList = hkgl060DetailBean.findByFSN(fsn);
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    public List<HKGL060Detail> getDetailList() {
        return detailList;
    }

    public List<HKGL060Detail> getDetailList(Object value) {
        return hkgl060DetailBean.findByFSN(value);
    }

}
