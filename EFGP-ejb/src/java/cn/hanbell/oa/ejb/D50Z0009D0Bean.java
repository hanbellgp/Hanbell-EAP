/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.D50Z0009D0;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class D50Z0009D0Bean extends SuperEJBForEFGP<D50Z0009D0> {

    @EJB
    private D50Z0009D0DetailBean d50Z0009D0DetailBean;
    @EJB
    private REPTCBean reptcBean;
    private List<D50Z0009D0> detailList;

    public D50Z0009D0Bean() {
        super(D50Z0009D0.class);
    }

    public List<D50Z0009D0> getDetailList() {
        return this.detailList;
    }
}
