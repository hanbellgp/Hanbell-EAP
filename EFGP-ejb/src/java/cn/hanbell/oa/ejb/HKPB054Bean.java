/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKPB054;
import cn.hanbell.oa.entity.HKPB054WLDetail;
import java.util.ArrayList;
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
public class HKPB054Bean extends SuperEJBForEFGP<HKPB054> {

    @EJB
    private HKPB054WLDetailBean hkpb054WLDetailBean;

    private List<HKPB054WLDetail> hkpb054WLDetailList;

    public HKPB054Bean() {
        super(HKPB054.class);
    }

    public List<HKPB054WLDetail> getHKPB054WLDetailList() {
        return hkpb054WLDetailList;
    }

    public void setHKPB054WLDetailList(Object value) {
        hkpb054WLDetailList = hkpb054WLDetailBean.findByFSN(value.toString());
        if (hkpb054WLDetailList == null) {
            hkpb054WLDetailList = new ArrayList<>();
        }
    }
}
