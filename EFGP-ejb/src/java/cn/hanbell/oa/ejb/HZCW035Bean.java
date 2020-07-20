/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW035;
import cn.hanbell.oa.entity.HZCW035Detail;
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
public class HZCW035Bean extends SuperEJBForEFGP<HZCW035>{
    
    @EJB
    private HZCW035DetailBean hzcw035DetailBean;
    
    public HZCW035Bean() {
        super(HZCW035.class);
    }
    
    
     public List<HZCW035Detail> getDetailList(Object value) {
        return hzcw035DetailBean.findByFSN(value);
    }
}
