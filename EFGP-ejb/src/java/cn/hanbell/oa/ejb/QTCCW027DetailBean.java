/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW027Detail;
import cn.hanbell.oa.entity.QTCCW027Detail;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class QTCCW027DetailBean extends SuperEJBForEFGP<QTCCW027Detail>{
 
    public QTCCW027DetailBean() {
        super(QTCCW027Detail.class);
    }
 
}
