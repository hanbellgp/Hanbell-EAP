/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJH004;
import cn.hanbell.oa.entity.HKJH004Detail;
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
public class HKJH004Bean extends SuperEJBForEFGP<HKJH004> {

    @EJB
    private HKJH004DetailBean khjh004DetailBean;

    private List<HKJH004Detail> detailList;

    public HKJH004Bean() {
        super(HKJH004.class);
    }

    public List<HKJH004Detail> findDetail(String fsn) {;
        detailList = khjh004DetailBean.findByFSN(fsn);
        return detailList;
    }

}
