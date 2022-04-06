/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */

package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPAPM828Detail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SHBERPAPM828DetailBean extends SuperEJBForEFGP<SHBERPAPM828Detail> {

    public SHBERPAPM828DetailBean() {
        super(SHBERPAPM828Detail.class);
    }

}
