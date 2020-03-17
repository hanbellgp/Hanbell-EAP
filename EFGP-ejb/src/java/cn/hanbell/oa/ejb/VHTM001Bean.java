/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHTM001;
import cn.hanbell.oa.entity.VHTM001purDetail;
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
public class VHTM001Bean extends SuperEJBForEFGP<VHTM001> {

    @EJB
    private VHTM001purDetailBean vhtm001purDetailBean;

    public VHTM001Bean() {
        super(VHTM001.class);
    }

    public List<VHTM001purDetail> getPurDetails(String fsn) {
        return vhtm001purDetailBean.findByFSN(fsn);
    }

}
