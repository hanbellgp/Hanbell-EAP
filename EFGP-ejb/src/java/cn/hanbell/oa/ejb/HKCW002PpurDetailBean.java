/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW002PpurDetail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1368
 */
@Stateless
@LocalBean
public class HKCW002PpurDetailBean extends  SuperEJBForEFGP<HKCW002PpurDetail>{

    public HKCW002PpurDetailBean(){
       super(HKCW002PpurDetail.class);
   }
}
