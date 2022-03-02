/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGC001;
import cn.hanbell.oa.entity.HSYJG002Detail;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HSYJG002DetailBean extends SuperEJBForEFGP<HSYJG002Detail>{
    
    
    public HSYJG002DetailBean() {
        super(HSYJG002Detail.class);
    }

}
