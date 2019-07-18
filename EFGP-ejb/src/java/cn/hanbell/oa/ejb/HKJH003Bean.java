/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJH003Detail;
import cn.hanbell.oa.entity.HKJH003;
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
public class HKJH003Bean extends SuperEJBForEFGP<HKJH003> {

    @EJB
    private HKJH003DetailBean hkjh003DetailBean;
    private List<HKJH003Detail> detailList;

    public HKJH003Bean() {
        super(HKJH003.class);
    }

    public List<HKJH003Detail> findDetail(String fsn) {
        detailList = hkjh003DetailBean.findByFSN(fsn);
        return detailList;
    }

}
