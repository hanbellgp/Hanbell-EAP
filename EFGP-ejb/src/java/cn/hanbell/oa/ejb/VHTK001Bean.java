/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHTK001;
import cn.hanbell.oa.entity.VHTK001Detail;
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
public class VHTK001Bean extends SuperEJBForEFGP<VHTK001>{
  @EJB
  private VHTK001DetailBean vhtk001DetailBean ;
  private List<VHTK001Detail> detailList ;
    
    public VHTK001Bean() {
        super(VHTK001.class);
    }

    public List<VHTK001Detail> getDetailList(String fsn) {
        detailList = vhtk001DetailBean.findByFSN(fsn);
        return  detailList;
    }

    public void setDetailList(List<VHTK001Detail> detailList) {
        this.detailList = detailList;
    }
  

}
