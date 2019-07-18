/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJH005;
import cn.hanbell.oa.entity.HKJH005Detail;
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
public class HKJH005Bean extends SuperEJBForEFGP<HKJH005> {

    @EJB
    private HKJH005DetailBean hkjh005DetailBean;

    public HKJH005Bean() {
        super(HKJH005.class);
    }

    public List<HKJH005Detail> getDetailList(String fsn) {
        return hkjh005DetailBean.findByFSN(fsn);
    }
}
