/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKYX013;
import cn.hanbell.oa.entity.HKYX013Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class HKYX013Bean extends SuperEJBForEFGP<HKYX013> {

    @EJB
    HKYX013DetailBean hKYX013DetailBean;

    public HKYX013Bean() {
        super(HKYX013.class);
    }

    public List<HKYX013Detail> getDetailList(String fsn) {
        return hKYX013DetailBean.findByFSN(fsn);
    }

}
