/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW025;
import cn.hanbell.oa.entity.HKCW025Detail;
import cn.hanbell.oa.entity.HKGL038Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2079
 */
@Stateless
@LocalBean
public class HKCW025DetailBean extends SuperEJBForEFGP<HKCW025Detail> {

    public HKCW025DetailBean() {
        super(HKCW025Detail.class);
    }

}
