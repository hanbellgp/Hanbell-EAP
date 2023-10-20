/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW018;
import cn.hanbell.oa.entity.HKCW018Detail;
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
public class HKCW018Bean extends SuperEJBForEFGP<HKCW018> {

    @EJB
    private HKCW018DetailBean hkcw018DetailBean;

    public HKCW018Bean() {
        super(HKCW018.class);
    }

    public List<HKCW018Detail> getDetailList(String value) {
        return hkcw018DetailBean.findByFSN(value);
    }
}
