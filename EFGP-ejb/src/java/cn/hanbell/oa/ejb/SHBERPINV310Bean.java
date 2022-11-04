/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPINV310;
import cn.hanbell.oa.entity.SHBERPINV310Detail;
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
public class SHBERPINV310Bean extends SuperEJBForEFGP<SHBERPINV310> {

    @EJB
    private SHBERPINV130DetailBean shberpinv310DetailBean;

    public SHBERPINV310Bean() {
        super(SHBERPINV310.class);
    }

    public List<SHBERPINV310Detail> getDetailByFSN(String fsn) {
        return shberpinv310DetailBean.findByFSN(fsn);
    }

}
