/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */

package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPAPM828;
import cn.hanbell.oa.entity.SHBERPAPM828Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SHBERPAPM828Bean extends SuperEJBForEFGP<SHBERPAPM828> {

    @EJB
    private SHBERPAPM828DetailBean shberpapm828DetailBean;

    public SHBERPAPM828Bean() {
        super(SHBERPAPM828.class);
    }

    public List<SHBERPAPM828Detail> getDetailList(String fsn) {
        return shberpapm828DetailBean.findByFSN(fsn);
    }

}
