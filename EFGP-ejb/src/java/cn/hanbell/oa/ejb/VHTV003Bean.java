/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHTV003;
import cn.hanbell.oa.entity.VHTV003reDetail;
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
public class VHTV003Bean extends SuperEJBForEFGP<VHTV003>{
    @EJB
    private VHTV003reDetailBean vhtv003reDetailBean;
    

    public VHTV003Bean() {
        super(VHTV003.class);
    }
    
    public List<VHTV003reDetail> getDetailList(Object value) {
        return vhtv003reDetailBean.findByFSN(value);
    }

}
