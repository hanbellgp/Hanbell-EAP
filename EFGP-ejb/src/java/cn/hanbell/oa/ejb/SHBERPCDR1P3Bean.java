/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPCDR1P3;
import cn.hanbell.oa.entity.SHBERPCDR1P3Detail;
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
public class SHBERPCDR1P3Bean extends SuperEJBForEFGP<SHBERPCDR1P3> {

    @EJB
    private SHBERPCDR1P3DetailBean shberpcdr1p3DetailBean;

    public SHBERPCDR1P3Bean() {
        super(SHBERPCDR1P3.class);
    }

    public List<SHBERPCDR1P3Detail> getDetails(String fsn) {
        return shberpcdr1p3DetailBean.findByFSN(fsn);
    }

}
