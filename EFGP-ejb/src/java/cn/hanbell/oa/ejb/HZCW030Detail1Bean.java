/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW030Detail1;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HZCW030Detail1Bean extends SuperEJBForEFGP<HZCW030Detail1> {
     public HZCW030Detail1Bean() {
        super(HZCW030Detail1.class);
    }

}
