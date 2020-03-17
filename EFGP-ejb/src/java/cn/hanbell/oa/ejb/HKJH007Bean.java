/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJH007;
import cn.hanbell.oa.entity.HKJH007Detail;
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
public class HKJH007Bean extends SuperEJBForEFGP<HKJH007> {

    @EJB
    private HKJH007DetailBean hkjh007DetailBean;

    public HKJH007Bean() {
        super(HKJH007.class);
    }

    public List<HKJH007Detail> getDetailList(String fsn) {
        return hkjh007DetailBean.findByFSN(fsn);
    }

}
