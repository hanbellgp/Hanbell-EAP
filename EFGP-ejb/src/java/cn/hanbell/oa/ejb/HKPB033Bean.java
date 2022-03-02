/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKPB033;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HKPB033Bean extends SuperEJBForEFGP<HKPB033> {

    @EJB
    protected cn.hanbell.oa.ejb.WorkFlowBean workFlowBean;

    public HKPB033Bean() {
        super(HKPB033.class);
    }

}
