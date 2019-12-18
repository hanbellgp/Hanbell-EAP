/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKPB054;
import cn.hanbell.oa.entity.HKPB054Detail;
import cn.hanbell.oa.entity.HKPB054WLDetail;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class HKPB054Bean extends SuperEJBForEFGP<HKPB054> {

    @EJB
    private HKPB054DetailBean hkpb054DetailBean;
    @EJB
    private HKPB054WLDetailBean hkpb054WLDetailBean;

    private List<HKPB054Detail> hkpb054DetalList;

    private List<HKPB054WLDetail> hkpb054WLDetailList;

    public HKPB054Bean() {
        super(HKPB054.class);
    }

    public List<HKPB054Detail> getHkpb054DetalList() {
        return hkpb054DetalList;
    }

    public void setHkpb054DetalList(Object value) {
        hkpb054DetalList = hkpb054DetailBean.findByFSN(value.toString());
        if (hkpb054DetalList == null) {
            hkpb054DetalList = new ArrayList<>();
        }
    }

    public List<HKPB054WLDetail> getHkpb054WLDetailList() {
        return hkpb054WLDetailList;
    }

    public void setHkpb054WLDetailList(Object value) {
        hkpb054WLDetailList = hkpb054WLDetailBean.findByFSN(value.toString());
        if (hkpb054WLDetailList == null) {
            hkpb054WLDetailList = new ArrayList<>();
        }
    }

}
