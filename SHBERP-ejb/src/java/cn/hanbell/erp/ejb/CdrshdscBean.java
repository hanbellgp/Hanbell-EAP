/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrshdsc;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class CdrshdscBean extends SuperEJBForERP<Cdrshdsc> {

    public CdrshdscBean() {
        super(Cdrshdsc.class);
    }

}
