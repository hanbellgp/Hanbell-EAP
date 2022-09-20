/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW013;
import cn.hanbell.oa.entity.HKCW013Detail;
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
public class HKCW013Bean extends SuperEJBForEFGP<HKCW013> {

    @EJB
    private HKCW013DetailBean hkcw013DetailBean;

    public HKCW013Bean() {
        super(HKCW013.class);
    }

    public List<HKCW013Detail> getDetailList(String fsn) {
        return hkcw013DetailBean.findByFSN(fsn);
    }
}
